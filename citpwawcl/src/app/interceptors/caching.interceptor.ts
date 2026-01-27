import {
  HttpContextToken,
  HttpEvent,
  HttpHandler,
  HttpInterceptor,
  HttpRequest,
  HttpResponse,
} from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { tap } from 'rxjs/operators';
import { RequestCache } from '../services/request-cache.service';

export const IS_CACHING_ENABLED = new HttpContextToken<boolean>(() => false);

function sendRequest(
  request: HttpRequest<unknown>,
  next: HttpHandler,
  cache: RequestCache
): Observable<HttpEvent<unknown>> {
  return next.handle(request).pipe(
    tap((event) => {
      if (event instanceof HttpResponse) {
        cache.put(request, event);
      }
    })
  );
}

@Injectable()
export class CachingInterceptor implements HttpInterceptor {
  constructor(private cache: RequestCache) {}

  intercept(
    request: HttpRequest<unknown>,
    next: HttpHandler
  ): Observable<HttpEvent<unknown>> {
    if (!request.context.get(IS_CACHING_ENABLED)) {
      this.cache.delete(request);
      return next.handle(request);
    }

    const cachedResponse = this.cache.get(request);
    return cachedResponse
      ? of(cachedResponse)
      : sendRequest(request, next, this.cache);
  }
}
