import { HttpClient, HttpContext, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { SharedService } from './shared.service';
import { IS_CACHING_ENABLED } from '../interceptors/caching.interceptor';
import { ERROR_HANDLING_MODE } from '../interceptors/error-handling.interceptor';

@Injectable({
  providedIn: 'root'
})
export class LibrettoService {

  private apiUrl: string;
  constructor(private http: HttpClient, private sharedService: SharedService) { this.apiUrl = environment.apiUrl + 'libretto'; }

  getLibrettoByCodice(codiceImpianto?: string) {
    const url: string = this.apiUrl + "/uid";
    let params = this.getParamsCoodiceImpianto(codiceImpianto);
    return this.http.get(url, { params, responseType: 'text'});
  }

  getLibrettoDtoByCodice(codiceImpianto?: string) {
    const url: string = this.apiUrl + "/dto/uid";
    let params = this.getParamsCoodiceImpianto(codiceImpianto);
    return this.http.get(url, { params });
  }

  consolidaLibretto(codiceImpianto?: string) {
    const url: string = this.apiUrl + "/consolida";
    let params = this.getParamsCoodiceImpianto(codiceImpianto)
    return this.http.post(url, null, { params });
  }

  getLibrettoNowJWT(codiceImpianto?) {
    const params = this.getParamsCoodiceImpianto(codiceImpianto, true);
    const url: string = this.apiUrl + "/now";
    return this.http.get(url, { params, responseType: 'arraybuffer' });
  }

  getXmlLibrettoNowByCodice(codiceImpianto?, withCache = false) {    
    const params = this.getParamsCoodiceImpianto(codiceImpianto, true);
    const url: string = this.apiUrl + "/xml/now";
    return this.http.get(url, { params, responseType: 'arraybuffer', context: withCache?new HttpContext().set(ERROR_HANDLING_MODE, 'page').set(IS_CACHING_ENABLED, true) : undefined})
  }

  getXMLLibrettoConsolidatoJWT(codiceImpianto?) {
    const params = this.getParamsCoodiceImpianto(codiceImpianto);
    const url: string = this.apiUrl + "/xml/consolidato";
    return this.http.get(url, { params, responseType: 'arraybuffer' });
  }

  getSchedaLibrettoJWT(codiceImpianto?) {
    const params = this.getParamsCoodiceImpianto(codiceImpianto, true);
    const url: string = this.apiUrl + "/scheda-libretto";
    return this.http.get<any>(url, { params });
  }

  setLibSch1IdImpianto(scheda1, codiceImpianto?) {
    const url: string = this.apiUrl + "/setLibSch1IdImpianto";
    const params = this.getParamsCoodiceImpianto(codiceImpianto)
    return this.http.post(url, scheda1, { params });
  }

  setLibSch2IdImpianto(scheda2, codiceImpianto?) {
    const url: string = this.apiUrl + "/setLibSch2IdImpianto";
    const params = this.getParamsCoodiceImpianto(codiceImpianto)
    return this.http.post(url, scheda2, { params , responseType: 'text'});
  }

  getCategorie() {
    const url: string = this.apiUrl + "/categorie";
    return this.http.get<{idCategoria: string, desCategoria: string}[]>(url);
  }

  getTipoIntervento() {
    const url: string = this.apiUrl + "/tipoIntervento";
    return this.http.get<{codice: number, descrizione: string}[]>(url);
  }

  getParamsCoodiceImpianto(codiceImpianto, withConsolidato?: boolean) {
    if(!codiceImpianto) {
      codiceImpianto = this.sharedService.getCodiceImpiantoFromDatiPrecompilati();
    }
    const result = new HttpParams()
      .set('codice-impianto', codiceImpianto);
    if(withConsolidato) {
      result.append('consolidato', true);
    }
    return result;
  }

}
