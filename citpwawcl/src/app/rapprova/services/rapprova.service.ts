import { HttpClient, HttpContext } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { map, switchMap } from "rxjs/operators";
import { IS_CACHING_ENABLED } from "src/app/interceptors/caching.interceptor";
import { ERROR_HANDLING_MODE } from "src/app/interceptors/error-handling.interceptor";
import { CodiceDescrizione } from "src/app/models/codice-descrizione";
import { Esito } from "src/app/models/esito";
import { parseStringPromise } from "xml2js";
import { parseBooleans, parseNumbers, stripPrefix } from "xml2js/lib/processors";
import { Categoria } from "../models/categoria.model";
import { FileBase64 } from "../models/file-base64.mode";
import { RapprovaDetail } from "../models/rapprova-detail.model";
import { Rapprova } from "../models/rapprova.model";
import { SaveRapprovaUpload } from "../models/save-rapprova-upload.model";
import { SaveRapprovaWeb } from "../models/save-rapprova-web.model";
import { SearchRapprova } from "../models/search-rapprova.model";
import { UploadRapprovaFirmato } from "../models/upload-rapprova-firmato.model";

function parseNumbersPrudently(value: string): string | number {
  const num = parseNumbers(value);
  return value === num.toString() ? num : value;
}

function nullifier(obj: any) {
  for (let key in obj) {
    const value = obj[key];

    if (value?.$?.nil) {
      obj[key] = null;
    } else if (typeof value === 'object' && value !== null) {
      obj[key] = nullifier(value);
    }
  }

  return obj;
}

@Injectable({
  providedIn: 'root',
})
export class RapprovaService {
  constructor(private http: HttpClient) {}

  getRapprovaList(request: SearchRapprova): Observable<Rapprova[]> {
    return this.http.post<Rapprova[]>('~/rapprova/getRapProva', request, { context: new HttpContext().set(ERROR_HANDLING_MODE, 'page') });
  }

  getRapprovaDetail(idAllegato: number, fkTipoDocumento: number): Observable<RapprovaDetail> {
    return this.http.get<RapprovaDetail>('~/rapprova/getRapProvaWeb', { params: { id_allegato: idAllegato, fk_Tipo_Documento: fkTipoDocumento }, context: new HttpContext().set(ERROR_HANDLING_MODE, 'snackbar') });
  }

  saveRapprovaWeb(request: SaveRapprovaWeb): Observable<Esito> {
    return this.http.post<Esito>('~/rapprova/setRapProvaWeb', request, { context: new HttpContext().set(ERROR_HANDLING_MODE, 'alert') });
  }

  saveRapprovaUpload(request: SaveRapprovaUpload): Observable<Esito> {
    return this.http.post<Esito>('~/rapprova/setScansioneRapProva', request, { context: new HttpContext().set(ERROR_HANDLING_MODE, 'alert') });
  }

  deleteRapprova(idAllegato: number, idIspezione2018: number): Observable<string> {
    return this.http.post('~/rapprova/deleteRapProva', null, { params: { id_allegato: idAllegato, id_ispezione_2018: idIspezione2018 }, responseType: 'text', context: new HttpContext().set(ERROR_HANDLING_MODE, 'alert') });
  }

  downloadRapprova(idAllegato: number): Observable<FileBase64> {
    return this.http.post<FileBase64>('~/rapprova/getPDFRapProva', null, { params: { id_allegato: idAllegato, firmato: false }, context: new HttpContext().set(ERROR_HANDLING_MODE, 'alert') });
  }

  downloadRapprovaFirmato(idAllegato: number): Observable<FileBase64> {
    return this.http.post<FileBase64>('~/rapprova/getPDFRapProva', null, { params: { id_allegato: idAllegato, firmato: true }, context: new HttpContext().set(ERROR_HANDLING_MODE, 'off') });
  }

  uploadRapprovaFirmato(request: UploadRapprovaFirmato): Observable<Esito> {
    return this.http.post<Esito>('~/rapprova/updatePDFFirmatoRapProva', request, { context: new HttpContext().set(ERROR_HANDLING_MODE, 'snackbar') });
  }

  getCombustibileList(): Observable<CodiceDescrizione[]> {
    return this.http.get<CodiceDescrizione[]>('~/componente/combustibile', { context: new HttpContext().set(ERROR_HANDLING_MODE, 'page').set(IS_CACHING_ENABLED, true) });
  }

  getFluidoList(): Observable<CodiceDescrizione[]> {
    return this.http.get<CodiceDescrizione[]>('~/componente/fluido', { context: new HttpContext().set(ERROR_HANDLING_MODE, 'page').set(IS_CACHING_ENABLED, true) });
  }

  getTipoClassificazioneDpr66096List(): Observable<CodiceDescrizione[]> {
    return this.http.get<CodiceDescrizione[]>('~/componente/classDpr66096', { context: new HttpContext().set(ERROR_HANDLING_MODE, 'page').set(IS_CACHING_ENABLED, true) });
  }

  getFrequenzaManutList(): Observable<CodiceDescrizione[]> {
    return this.http.get<CodiceDescrizione[]>('~/componente/frequenzaManut', { context: new HttpContext().set(ERROR_HANDLING_MODE, 'page').set(IS_CACHING_ENABLED, true) });
  }

  getLibretto(codiceImpianto: number): Observable<any> {
    return this.http
      .get('~/libretto/xml/now', { params: { 'codice-impianto': codiceImpianto }, responseType: 'text', context: new HttpContext().set(ERROR_HANDLING_MODE, 'page') })
      .pipe(
        map(base64 => atob(base64)),
        switchMap(xml => parseStringPromise(xml, {
          explicitArray: false,
          tagNameProcessors: [stripPrefix],
          valueProcessors: [parseNumbersPrudently, parseBooleans],
          attrNameProcessors: [stripPrefix],
          attrValueProcessors: [parseNumbersPrudently, parseBooleans]
        })),
        map(obj => nullifier(obj))
      );
  }

  getCategoriaList(): Observable<Categoria[]> {
    return this.http.get<Categoria[]>('~/libretto/categorie', { context: new HttpContext().set(ERROR_HANDLING_MODE, 'page').set(IS_CACHING_ENABLED, true) });
  }
}
