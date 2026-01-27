import { HttpClient, HttpContext } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { IS_CACHING_ENABLED } from 'src/app/interceptors/caching.interceptor';
import { ERROR_HANDLING_MODE } from 'src/app/interceptors/error-handling.interceptor';
import { Esito } from 'src/app/models/esito';
import { Assegnatario } from '../models/assegnatario.model';
import { Azione } from '../models/azione.model';
import { Controllo } from '../models/controllo.model';
import { Distributore } from '../models/distributore.model';
import { InsertAzione } from '../models/insert-azione.model';
import { InsertIspezioneMassiva } from '../models/insert-ispezione-massiva.model';
import { SaveVerifica } from '../models/save-verifica.model';
import { SearchVerifica } from '../models/search-verifica.model';
import { TipoVerifica } from '../models/tipo-verifica.model';
import { VerificaDetail } from '../models/verifica-detail.model';
import { Verifica } from '../models/verifica.model';

@Injectable({
  providedIn: 'root',
})
export class VerificaService {
  constructor(private http: HttpClient) {}

  getAssegnatarioList(): Observable<Assegnatario[]> {
    return this.http.get<Assegnatario[]>('~/verifica/getAssegnatario', { context: new HttpContext().set(ERROR_HANDLING_MODE, 'page').set(IS_CACHING_ENABLED, true) });
  }

  getTipoVerificaList(): Observable<TipoVerifica[]> {
    return this.http.get<TipoVerifica[]>('~/verifica/tipoVerifica', { context: new HttpContext().set(ERROR_HANDLING_MODE, 'page').set(IS_CACHING_ENABLED, true) });
  }

  getSiglaReeList(): Observable<string[]> {
    return this.http.get<string[]>('~/verifica/getSiglaRee', { context: new HttpContext().set(ERROR_HANDLING_MODE, 'page').set(IS_CACHING_ENABLED, true) });
  }

  getDistributore(id: number): Observable<Distributore> {
    return this.http.get<Distributore>('~/verifica/getDistributore', { params: { id_dato_distrib: id }, context: new HttpContext().set(ERROR_HANDLING_MODE, 'alert') });
  }

  getControllo(siglaRee: string, numeroRee: number): Observable<Controllo> {
    return this.http.get<Controllo>('~/verifica/getControllo', { params: { sigla_ree: siglaRee, numero_ree: numeroRee }, context: new HttpContext().set(ERROR_HANDLING_MODE, 'alert') });
  }

  getImpianto(codiceImpianto: number): Observable<any> {
    return this.http
      .get<any>('~/impianto/geojson', { params: { 'codice-impianto': codiceImpianto, ricercaCompleta: false }, context: new HttpContext().set(ERROR_HANDLING_MODE, 'off') })
      .pipe(map(res => res.features?.[0]));
  }

  getVerificaList(request: SearchVerifica): Observable<Verifica[]> {
    return this.http.post<Verifica[]>('~/verifica/getVerifiche', request, { context: new HttpContext().set(ERROR_HANDLING_MODE, 'alert') });
  }

  getVerificaDetail(id: number): Observable<VerificaDetail> {
    return this.http.get<VerificaDetail>('~/verifica/getVerifica', { params: { id }, context: new HttpContext().set(ERROR_HANDLING_MODE, 'page') });
  }

  saveVerifica(request: SaveVerifica): Observable<Esito> {
    return this.http.post<Esito>('~/verifica/setVerifica', request, { context: new HttpContext().set(ERROR_HANDLING_MODE, 'snackbar') });
  }

  deleteVerifica(id: number): Observable<Esito> {
    return this.http.delete<Esito>('~/verifica/delete', { params: { id }, context: new HttpContext().set(ERROR_HANDLING_MODE, 'alert') });
  }

  getAzioneListByIdVerifica(idVerifica: number): Observable<Azione[]> {
    return this.http.get<Azione[]>('~/verifica/getAzione', { params: { id_verifica: idVerifica }, context: new HttpContext().set(ERROR_HANDLING_MODE, 'page') });
  }

  insertAzione(request: InsertAzione): Observable<Esito> {
    return this.http.post<Esito>('~/verifica/setAzione', request, { context: new HttpContext().set(ERROR_HANDLING_MODE, 'snackbar') });
  }

  insertIspezioneMassiva(request: InsertIspezioneMassiva): Observable<Esito> {
    return this.http.post<Esito>('~/verifica/setIspezioneMassiva', request, { context: new HttpContext().set(ERROR_HANDLING_MODE, 'alert') });
  }
}
