import {
  HttpContextToken,
  HttpErrorResponse,
  HttpEvent,
  HttpHandler,
  HttpInterceptor,
  HttpRequest,
} from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { tap } from 'rxjs/operators';
import { AlertService } from '../services/alert.service';
import { Message2Service } from '../services/message2.service';

export const ERROR_HANDLING_MODE = new HttpContextToken<
  'page' | 'snackbar' | 'alert' | 'off'
>(() => 'off');

function getErrorMessage(error: any): string {
  if (error instanceof HttpErrorResponse) {
    let response: any;

    if (typeof error.error === 'string') {
      try {
        response = JSON.parse(error.error);
      } catch (_) {}
    } else {
      response = error.error;
    }

    return response?.descrizioneEsito ?? error.message;
  }

  return error.message ?? 'Errore generico';
}

function getErrorType(error: any): string {
  if (error instanceof HttpErrorResponse) {
    let response: any;

    if (typeof error.error === 'string') {
      try {
        response = JSON.parse(error.error);
      } catch (_) {}
    } else {
      response = error.error;
    }

    return response?.esito ?? 'KO';
  }

  return 'KO';
}

@Injectable()
export class ErrorHandlingInterceptor implements HttpInterceptor {
  constructor(
    private router: Router,
    private message: Message2Service,
    private alert: AlertService
  ) {}

  intercept(
    request: HttpRequest<unknown>,
    next: HttpHandler
  ): Observable<HttpEvent<unknown>> {
    const mode = request.context.get(ERROR_HANDLING_MODE);

    if (mode !== 'off') {
      return next.handle(request).pipe(
        tap({
          error: (error) => {
            const message = getErrorMessage(error);

            if (mode === 'snackbar') {
              this.message.error(message);
            } else if (mode === 'alert') {
              const type = getErrorType(error);

              switch (type) {
                case 'OK':
                  this.alert.success({ message });
                  break;
                case 'INFO':
                  this.alert.info({ message });
                  break;
                case 'WARN':
                  this.alert.warn({ message });
                  break;
                default:
                  this.alert.error({ message });
              }
            } else {
              const state = { message, dump: JSON.stringify(error) };
              this.router.navigate(['/', 'error'], { state });
            }
          },
        })
      );
    }

    return next.handle(request);
  }
}
