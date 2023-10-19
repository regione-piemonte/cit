import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Ruoli } from '../models/ruoli';
import { UtenteLoggato } from '../models/utente-loggato';
import { SyncServiceService } from './sync-service.service';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {
  private apiUrl: string;
  constructor(private http: HttpClient, private router: Router, private readonly syncService: SyncServiceService) { this.apiUrl = environment.apiUrl + 'currentUser'; }

  getCurrentUser(): Observable<UtenteLoggato> {
    const url: string = this.apiUrl;
    return this.http.get<UtenteLoggato>(url);
  }

  getCurrentUserFromSession(): UtenteLoggato | null {
    let item = sessionStorage.getItem('currentUser');
    if (item != null)
      return JSON.parse(item) as UtenteLoggato;
    else
      return null;
  }

  getRuoliUtente(): Observable<Ruoli> {
    const url: string = this.apiUrl + "/roles";
    return this.http.get<Ruoli>(url);
  }

  setAccesso(utente: UtenteLoggato) {
    const url: string = this.apiUrl + "/accesso";
    return this.http.post<Ruoli>(url, utente);
  }

  keepAlive() {
    const url: string = this.apiUrl+"/keep-alive";
    const params: HttpParams = new HttpParams();
    return this.syncService.tryGet(url, params);
  }

  ssoLogout() {
    this.router.navigate(['/']).then(result => { window.location.href = environment.shibbolethSSOLogoutURL; });
  }

  localLogout() {
    sessionStorage.removeItem('currentUser');

    const url: string = environment.apiUrl + 'localLogout';
    return this.http.post(url, null);
  }
}
