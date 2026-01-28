import { HttpRequest, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class RequestCache {
  private cache = new Map<string, HttpResponse<unknown>>();

  get(request: HttpRequest<unknown>): HttpResponse<unknown> {
    return this.cache.get(request.urlWithParams);
  }

  put(request: HttpRequest<unknown>, response: HttpResponse<unknown>) {
    this.cache.set(request.urlWithParams, response);
  }

  delete(request: HttpRequest<unknown>) {
    this.cache.delete(request.urlWithParams);
  }
}
