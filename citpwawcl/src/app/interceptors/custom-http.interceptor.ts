import {
    HttpEvent, HttpHandler, HttpInterceptor, HttpRequest
} from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { finalize } from 'rxjs/operators';
import { SpinnerService } from '../services/spinner.service';

@Injectable()
export class CustomHttpInterceptor implements HttpInterceptor {

  private totalRequests = 0;

  constructor(private spinnerService: SpinnerService) { }

  intercept(request: HttpRequest<unknown>, next: HttpHandler): Observable<HttpEvent<unknown>> {

    if (!request.url.includes("/keep-alive")) {
      this.totalRequests++;
      this.spinnerService.show();
      return next.handle(request)
        .pipe(finalize(() => {
          this.totalRequests--;
          if (this.totalRequests === 0) {
            this.spinnerService.hide();
          }
        }));
    } else {
      return next.handle(request);
    }
  }
}
