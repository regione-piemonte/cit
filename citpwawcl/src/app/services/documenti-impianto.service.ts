import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Documento, TipoDocumento } from '../models/documento-impianto.model';
import { SharedService } from './shared.service';

@Injectable({
  providedIn: 'root'
})
export class DocumentiImpiantoService {

  apiUrl;

  constructor(
    private http: HttpClient,
    private sharedService: SharedService
  ) { this.apiUrl = environment.apiUrl + 'documento'; }

  getElencoDocumenti(id_contratto?: number) {
    let params = new HttpParams()
      .set('codice_impianto', this.sharedService.getCodiceImpiantoFromDatiPrecompilati());
    // .set('id_verifica', idVerifica)
    // .set('id_accertamento', idAccertamento);
    return this.http.get(this.apiUrl + '/elenco', { params });
  }

  getDocumentoByUid(uid: string): Observable<Documento> {
    const params = new HttpParams().set('uidIndex', uid);
    return this.http.get<Documento>(this.apiUrl + '/uid', { params });
  }

  uploadDocumento(codiceImpianto: string, tipoDoc: string, idAzione: string, documento: any) {
    const params = new HttpParams().set('codice_impianto', codiceImpianto).set('tipo_doc', tipoDoc).set("id_azione", idAzione);
    //params to query param
    return this.http.post(this.apiUrl + '/set', documento, { params: params, responseType: 'text' });
  }

  uploadDocumentoContratto(id_contratto: string, codiceImpianto: string, tipoDoc: string, idAzione: string, documento: any) {
    let  params = new HttpParams().set('codice_impianto', codiceImpianto)
    .set('tipo_doc', tipoDoc)
    .set("id_azione", idAzione)
    .set("cfUtenteLoggato", this.sharedService.getUtenteLoggato()?.pfLoggato?.codiceFiscalePF);
    //params to query param
    if(id_contratto){
      params = params.set('idContratto', id_contratto);
    }
    return this.http.post(this.apiUrl + '/set', documento, { params: params, responseType: 'text' });
  }

  getTipiDocumento(): Observable<TipoDocumento[]> {
    return this.http.get<TipoDocumento[]>(this.apiUrl + '/getTipoDocumento');
  }

  deleteDocumento(uid: string) {
    const params = new HttpParams().set('uidIndex', uid);
    return this.http.delete(this.apiUrl + '/uid?uidIndex=' + uid, { responseType: 'text' });
  }

}
