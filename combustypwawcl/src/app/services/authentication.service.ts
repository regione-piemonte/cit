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

  constructor(private http: HttpClient, private router: Router, private readonly syncService: SyncServiceService) { 
    this.apiUrl = environment.apiUrl + 'user';
  }

  getCurrentUser(): Observable<UtenteLoggato> {
    const url: string = this.apiUrl + "/currentUser";
    return this.http.get<UtenteLoggato>(url);
  }

  getCurrentUserFromSession(): UtenteLoggato | null {
    let item = sessionStorage.getItem('currentUser');
    if (item != null)
      return JSON.parse(item) as UtenteLoggato;
    else
      return null;
  }

  getRuoliUtenteDistributore(utente: UtenteLoggato): Observable<Ruoli> {
    const url: string = environment.apiUrl + "/distributore/ruoli";

    let params = new HttpParams()
    .set('cf', utente.pfLoggato.codiceFiscalePF)
    .set('cognome', utente.pfLoggato.nomePF)
    .set('nome', utente.pfLoggato.cognomePF);

    return this.http.get<Ruoli>(url, { params });
  }

  setAccesso(utente: UtenteLoggato) {
    const url: string = this.apiUrl + "/accesso";
    return this.http.post<any>(url, utente);
  }

  getDisponibilitaServizio(utente: UtenteLoggato) {
    const url: string = this.apiUrl + "/disponibilitaservizio";
    return this.http.post<Ruoli>(url, utente);
  }

  keepAlive() {
    const url: string = this.apiUrl + "/keep-alive";
    const params: HttpParams = new HttpParams();
    return this.syncService.tryGet(url, params);
  }

  ssoLogout() {
    this.localLogout();
    this.router.navigate(['/']).then(result => { window.location.href = environment.shibbolethSSOLogoutURL; });
  }

  localLogout() {
    sessionStorage.removeItem('currentUser');
  }
}
