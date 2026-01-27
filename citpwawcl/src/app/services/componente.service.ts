import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { environment } from 'src/environments/environment';
import { CodiceDescrizione } from '../models/codice-descrizione';
import { Esito } from '../models/esito';

@Injectable({
  providedIn: 'root'
})
export class ComponenteService {
  private apiUrl: string;
  constructor(private http: HttpClient, private router: Router) { this.apiUrl = environment.apiUrl + 'componente'; }

  getGT(codice, progr) {
    let parameters: HttpParams = new HttpParams();
    const url: string = this.apiUrl + "/gt";
    parameters = parameters.append("codice-impianto", codice);
    parameters = parameters.append("progressivo", progr);
    return this.http.get(url, { params: parameters });
  }

  getSC(codice, progr) {
    let parameters: HttpParams = new HttpParams();
    const url: string = this.apiUrl + "/sc";
    parameters = parameters.append("codice-impianto", codice);
    parameters = parameters.append("progressivo", progr);
    return this.http.get(url, { params: parameters });
  }

  getGF(codice, progr) {
    let parameters: HttpParams = new HttpParams();
    const url: string = this.apiUrl + "/gf";
    parameters = parameters.append("codice-impianto", codice);
    parameters = parameters.append("progressivo", progr);
    return this.http.get(url, { params: parameters });
  }

  getCG(codice, progr) {
    let parameters: HttpParams = new HttpParams();
    const url: string = this.apiUrl + "/cg";
    parameters = parameters.append("codice-impianto", codice);
    parameters = parameters.append("progressivo", progr);
    return this.http.get(url, { params: parameters });
  }

  updateGT(codice, datiGT, idimpresa?) {
    let parameters: HttpParams = new HttpParams();
    const url: string = this.apiUrl + "/gt";
    parameters = parameters.append("codice-impianto", codice);
    if (idimpresa)
      parameters = parameters.append("id-impresa", idimpresa);
    return this.http.put(url, datiGT, { params: parameters });
  }

  updateGF(codice, datiGF, idimpresa?) {
    let parameters: HttpParams = new HttpParams();
    const url: string = this.apiUrl + "/gf";
    parameters = parameters.append("codice-impianto", codice);
    if (idimpresa)
      parameters = parameters.append("id-impresa", idimpresa);
    return this.http.put(url, datiGF, { params: parameters });
  }

  updateSC(codice, datiSC, idimpresa?) {
    let parameters: HttpParams = new HttpParams();
    const url: string = this.apiUrl + "/sc";
    parameters = parameters.append("codice-impianto", codice);
    if (idimpresa)
      parameters = parameters.append("id-impresa", idimpresa);
    return this.http.put(url, datiSC, { params: parameters });
  }

  updateCG(codice, datiCG, idimpresa?) {
    let parameters: HttpParams = new HttpParams();
    const url: string = this.apiUrl + "/cg";
    parameters = parameters.append("codice-impianto", codice);
    if (idimpresa)
      parameters = parameters.append("id-impresa", idimpresa);
    return this.http.put(url, datiCG, { params: parameters });
  }

  getMarca() {
    const url: string = this.apiUrl + "/marca";
    return this.http.get<CodiceDescrizione[]>(url);
  }

  getFonte() {
    const url: string = this.apiUrl + "/fonte";
    return this.http.get<CodiceDescrizione[]>(url);
  }

  getFluido() {
    const url: string = this.apiUrl + "/fluido";
    return this.http.get<CodiceDescrizione[]>(url);
  }

  getCombustibile() {
    const url: string = this.apiUrl + "/combustibile";
    return this.http.get<CodiceDescrizione[]>(url);
  }

  getTipologiaGT() {
    const url: string = this.apiUrl + "/tipologiaGT";
    return this.http.get<CodiceDescrizione[]>(url);
  }

  getTipologiaGF() {
    const url: string = this.apiUrl + "/tipologiaGF";
    return this.http.get<CodiceDescrizione[]>(url);
  }

  getTipoCannaFumaria() {
    const url: string = this.apiUrl + "/canna-fumaria";
    return this.http.get<CodiceDescrizione[]>(url);
  }

  checkSostituisciDismetti(dataMinima, dataMassima, dataDismiss) {
    const url: string = this.apiUrl + "/dismetti";
    let parameters: HttpParams = new HttpParams;
    parameters = parameters.append("data-minima", dataMinima);
    parameters = parameters.append("data-massima", dataMassima);
    parameters = parameters.append("data-dismiss", dataDismiss);
    return this.http.post<Esito>(url, { params: parameters });
  }

  delComponente(codiceImpianto, tipo, progressivo) {
    let parameters: HttpParams = new HttpParams();
    const url: string = this.apiUrl;
    parameters = parameters.append("codice-impianto", codiceImpianto);
    parameters = parameters.append("tipo", tipo);
    parameters = parameters.append("progressivo", progressivo);
    return this.http.delete(url, { params: parameters });
  }
}
