import { HttpClient, HttpContext } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { IS_CACHING_ENABLED } from 'src/app/interceptors/caching.interceptor';
import { ERROR_HANDLING_MODE } from 'src/app/interceptors/error-handling.interceptor';
import { Esito } from 'src/app/models/esito';
import { AssegnaImpiantoIspezione } from '../models/assegna-impianto-ispezione.model';
import { AssegnaIspezione } from '../models/assegna-ispezione.model';
import { AzioneIspezione } from '../models/azione-ispezione.model';
import { ComuneEsteso } from '../models/comune-esteso.model';
import { ConcludiIspezione } from '../models/concludi-ispezione.model';
import { InsertAzioneIspezione } from '../models/insert-azione-ispezione.model';
import { Ispettore } from '../models/ispettore.model';
import { IspezioneDetail } from '../models/ispezione-detail.model';
import { Ispezione } from '../models/ispezione.model';
import { SaveIspezione } from '../models/save-ispezione.model';
import { SearchIspezione } from '../models/search-ispezione.model';
import { StatoIspezione } from '../models/stato-ispezione.model';

@Injectable({
  providedIn: 'root',
})
export class IspezioneService {
  constructor(private http: HttpClient) {}

  getIspettoreList(): Observable<Ispettore[]> {
    return this.http.get<Ispettore[]>('~/ispezione/getIspettore', { context: new HttpContext().set(ERROR_HANDLING_MODE, 'page').set(IS_CACHING_ENABLED, true) });
  }

  getStatoIspezioneList(): Observable<StatoIspezione[]> {
    return this.http.get<StatoIspezione[]>('~/ispezione/getStatoIspezione', {
      context: new HttpContext()
        .set(ERROR_HANDLING_MODE, 'page')
        .set(IS_CACHING_ENABLED, true),
    });
  }

  getComuneEstesoList(): Observable<ComuneEsteso[]> {
    return this.http.get<ComuneEsteso[]>('~/impianto/ce', {
      context: new HttpContext()
        .set(ERROR_HANDLING_MODE, 'page')
        .set(IS_CACHING_ENABLED, true),
    });
  }

  getIspezioneList(request: SearchIspezione): Observable<Ispezione[]> {
    return this.http.post<Ispezione[]>('~/ispezione/getIspezioni', request, {
      context: new HttpContext().set(ERROR_HANDLING_MODE, 'alert'),
    });
  }

  getIspezioneDetail(id: number): Observable<IspezioneDetail> {
    return this.http.get<IspezioneDetail>('~/ispezione/getIspezione', {
      params: { id },
      context: new HttpContext().set(ERROR_HANDLING_MODE, 'page'),
    });
  }

  saveIspezione(request: SaveIspezione): Observable<Esito> {
    return this.http.post<Esito>('~/ispezione/setIspezione', request, { context: new HttpContext().set(ERROR_HANDLING_MODE, 'snackbar') });
  }

  assegnaIspezione(request: AssegnaIspezione): Observable<Esito> {
    return this.http.post<Esito>('~/ispezione/assegna', request, { context: new HttpContext().set(ERROR_HANDLING_MODE, 'alert') });
  }

  assegnaImpiantoIspezione(request: AssegnaImpiantoIspezione): Observable<Esito> {
    return this.http.post<Esito>('~/ispezione/assegnaImpianto', request, { context: new HttpContext().set(ERROR_HANDLING_MODE, 'alert') });
  }

  concludiIspezione(request: ConcludiIspezione): Observable<Esito> {
    return this.http.post<Esito>('~/ispezione/concludi', request, { context: new HttpContext().set(ERROR_HANDLING_MODE, 'alert') });
  }

  annullaIspezione(id: number): Observable<Esito> {
    return this.http.post<Esito>('~/ispezione/annulla', null, { params: { id }, context: new HttpContext().set(ERROR_HANDLING_MODE, 'alert') });
  }

  downloadCopertinaIspezione(idIspezione2018: number): Observable<any> {
    return this.http.get<any>('~/ispezione/copertinaIspezione', { params: { idIspezione2018 }, context: new HttpContext().set(ERROR_HANDLING_MODE, 'snackbar') });
  }

  downloadLetteraAvviso(idIspezione2018: number): Observable<any> {
    return this.http.get<any>('~/ispezione/letteraAvviso', { params: { idIspezione2018 }, context: new HttpContext().set(ERROR_HANDLING_MODE, 'snackbar') });
  }

  downloadLetteraAvviso180Gg(idIspezione2018: number): Observable<any> {
    return this.http.get<any>('~/ispezione/letteraAvviso180Gg', { params: { idIspezione2018 }, context: new HttpContext().set(ERROR_HANDLING_MODE, 'snackbar') });
  }

  downloadFileExcel(ids: number[]): Observable<any> {
    return this.http.post<any>('~/ispezione/fileExcel', { ids }, { context: new HttpContext().set(ERROR_HANDLING_MODE, 'snackbar') });
  }

  getAzioneListByIdIspezione2018(idIspezione2018: number): Observable<AzioneIspezione[]> {
    return this.http.get<AzioneIspezione[]>('~/ispezione/getAzione', { params: { id: idIspezione2018 }, context: new HttpContext().set(ERROR_HANDLING_MODE, 'page') });
  }

  insertAzione(request: InsertAzioneIspezione): Observable<Esito> {
    return this.http.post<Esito>('~/ispezione/setAzione', request, { context: new HttpContext().set(ERROR_HANDLING_MODE, 'snackbar') });
  }
}
