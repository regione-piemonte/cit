import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Accreditamento } from '../models/accreditamento';
import { IncarichiSoggettiDelegati } from '../models/accreditamento/incarichi-soggetti-delegati';
import { DatiImpresa } from '../models/dati-impresa';
import { DatiIncarico } from '../models/dati-incarico';
import { Persona } from '../models/persona';
import { UtenteLoggato } from '../models/utente-loggato';

@Injectable({
  providedIn: 'root'
})
export class AccreditamentoService {


  private apiUrl: string;

  constructor(
    private http: HttpClient
  ) { }

  init(apiUrl: string) {
    this.apiUrl = apiUrl + 'accreditamento';
  }

  getDatiAccreditamento(codiceFiscalePF: string): Observable<Accreditamento> {
    let url = this.apiUrl + "/dati";
    let params = new HttpParams().set("codice_fiscale", codiceFiscalePF);
    return this.http.get<Accreditamento>(url, { params: params });
  }

  setDatiPersonaliUtente(codiceFiscalePF: string, persona: Persona) {
    let url = this.apiUrl + "/datiPersonaliUtente";
    let params = new HttpParams().set("codice_fiscale", codiceFiscalePF);
    return this.http.post(url, persona, { params: params, responseType: 'text' });
  }

  getIncarichiSoggettiDelegati(): Observable<IncarichiSoggettiDelegati[]> {
    return this.http.get<IncarichiSoggettiDelegati[]>(this.apiUrl + "/delega/soggetti");
  }

  setIncaricoSoggettoDelegato(codiceFiscale: string, personaGiuridica: any, personaGiuridicaCat: any) {
    let params = new HttpParams().set("id_persona_giuridica", personaGiuridica)
      .set("id_persona_giuridica_cat", personaGiuridicaCat)
      .set("codice_fiscale", codiceFiscale);
    return this.http.get(this.apiUrl + "/delega/soggetti/incarico/set", { params: params, responseType: 'text' });
  };


  deleteIncaricoSoggettoDelegato(codiceFiscale: string, personaGiuridica: any, personaGiuridicaCat: any) {
    let params = new HttpParams().set("id_persona_giuridica", personaGiuridica)
      .set("id_persona_giuridica_cat", personaGiuridicaCat)
      .set("codice_fiscale", codiceFiscale);
    return this.http.delete(this.apiUrl + "/delega/soggetti/incarico/delete", { params: params, responseType: 'text' });
  }

  deleteDelega(idPersona: number, utenteLoggato: UtenteLoggato) {
    let params = new HttpParams().set("id_persona", idPersona);
    return this.http.post(this.apiUrl + "/delega/delete", utenteLoggato, { params: params, responseType: 'text' });
  }

  deleteDelegaConfirm(codiceFiscalePF, id_persona_giuridica, idPersona) {
    let params = new HttpParams().set("codice_fiscale", codiceFiscalePF)
      .set("id_persona_giuridica", id_persona_giuridica)
      .set("id_persona", idPersona);
    return this.http.delete(this.apiUrl + "/delega/delete/confirm", { params: params, responseType: 'text' });
  }

  getDatiImpresa(codiceFiscale: string, siglaRea: string, numeroRea: number): Observable<DatiImpresa[]> {
    let params = new HttpParams();
    if (codiceFiscale) {
      params = params.set("codice_fiscale", codiceFiscale);
    }
    if (siglaRea && numeroRea) {
      params = params.set("sigla_REA", siglaRea).set("numero_REA", numeroRea);
    }
    return this.http.get<DatiImpresa[]>(this.apiUrl + "/dati/impresa", { params: params });
  }

  setDelega(codiceFiscalePF: string, id_persona_giuridica: number, idPersona: number) {
    let params = new HttpParams().set("codice_fiscale", codiceFiscalePF)
      .set("id_persona_giuridica", id_persona_giuridica).set("id_persona", idPersona);
    return this.http.get(this.apiUrl + "/delega/set", { params: params, responseType: 'text' });
  }

  sendTestMail(email_address: any) {
    let params = new HttpParams().set("email_address", email_address);
    return this.http.get(this.apiUrl + "/mail/send/prova", { params: params, responseType: 'text' });
  }

  setImpresaAssociata(isUpdate: boolean, codiceFiscalePF: string, datiImpresa: any) {
    let params = new HttpParams().set("codice_fiscale", codiceFiscalePF);
    if(isUpdate){
      params = params.set("operation", "update");
    }else{
      params = params.set("operation", "insert");
    }
    return this.http.post(this.apiUrl + "/impresa/set", datiImpresa, { params: params, responseType: 'text' });
  }

  getElencoIncarichi(id_persona_giuridica: number): Observable<any>{
    let params = new HttpParams().set("id_persona_giuridica", id_persona_giuridica);
    return this.http.get<DatiIncarico[]>(this.apiUrl + "/getElencoIncarichi", { params: params });
  }

  getElencoDeleghe(id_persona_giuridica: number) : Observable<any>{
    let params = new HttpParams().set("id_persona_giuridica", id_persona_giuridica);
    return this.http.get(this.apiUrl + "/getElencoDeleghe", { params: params });
  }

  getDatiTokenImpresa(id_persona_giuridica: number) : Observable<any>{
    let params = new HttpParams().set("id_persona_giuridica", id_persona_giuridica);
    return this.http.get(this.apiUrl + "/token/impresa", { params: params });
  }

  generateTokenImpresa(id_persona_giuridica: number) {
    let params = new HttpParams().set("id_persona_giuridica", id_persona_giuridica);
    return this.http.put(this.apiUrl + "/token/impresa", id_persona_giuridica, { params: params, responseType: 'text' });
  }

}
