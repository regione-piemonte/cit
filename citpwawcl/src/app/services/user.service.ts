import { HttpClient, HttpContext } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { IS_CACHING_ENABLED } from '../interceptors/caching.interceptor';
import { ERROR_HANDLING_MODE } from '../interceptors/error-handling.interceptor';
import { UtenteLoggato } from '../models/utente-loggato';

@Injectable({
  providedIn: 'root',
})
export class UserService {
  constructor(private http: HttpClient) {}

  getUser(): Observable<UtenteLoggato> {
    return this.http.get<UtenteLoggato>('~/currentUser', {
      context: new HttpContext()
        .set(ERROR_HANDLING_MODE, 'page')
        .set(IS_CACHING_ENABLED, true),
    });
  }
}
