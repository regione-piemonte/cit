import { Injectable } from '@angular/core';
import { Impianto } from '../models/impianto';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Router } from '@angular/router';
import { SharedService } from './shared.service';
import { environment } from 'src/environments/environment';
import { ImportDatiDistributore } from '../models/importazione-dati-distributore';
import { DatiFornitura } from '../models/dati-fornitura';
import { UtenteLoggato } from '../models/utente-loggato';
import { Esito } from '../models/esito';
import { Persona } from '@sigit/common-lib';
import { CodiceDescrizione } from '../models/codice-descrizione';
import { docXML } from '../models/doc-xml';
import { map } from 'rxjs/operators';


@Injectable({
  providedIn: 'root'
})
export class DatiDistributoreService {
 
  private apiUrl: string;
  private filtriSalvati: any = null;
  
  constructor(
      private http: HttpClient,
      private router: Router,
      private sharedService: SharedService
    ) { this.apiUrl = environment.apiUrl + 'distributore'; }

  getDettaglioDatiDistributoreJson(id_persona_giuridica: number, anno: string, mese: string, tipoCaricamento: string, statoFile: string) 
  {
    const url: string = this.apiUrl + "/datiDistributore";

    let params = new HttpParams()
    .set('idPersonaGiuridica', id_persona_giuridica)
    .set('anno', anno)
    .set('mese', mese)
    .set('tipoCaricamento', tipoCaricamento)
    .set('statoFile', statoFile)
    //.set('numRecords', numRecord)

    return this.http.get<ImportDatiDistributore[]>(url, { params });
  }

    getDettaglioDatiImportJson(id_import_distrib: number) 
  {
    const url: string = this.apiUrl + "/datiImport";

    let params = new HttpParams()
    .set('idID', id_import_distrib)

    return this.http.get<DatiFornitura>(url, { params });
  }

  setDatiDistributoreSemplificatoJson( 
    idPG: number | string, 
    piva: string, 
    cf: string, 
    import_dati_fornitura: ImportDatiDistributore) {
    const url: string = this.apiUrl + "/datiDistributore";

    let params = new HttpParams()
      .set('idPersonaGiuridica', idPG.toString())
      .set('piva', piva)
      .set('cf', cf);

    return this.http.post<Esito>(url, import_dati_fornitura, { params });
  }
 
  annullaAcquisizioneDatoDistributore(cf: string, id_import_distrib: number) {
    const url: string = this.apiUrl + "/acquisizione/annulla";

    let params = new HttpParams()
    .set('cf', cf)
    .set('idID', id_import_distrib)

    return this.http.get<Esito>(url, { params });
  }

  uploadXMLDistributoreJWT( 
    idPG: number, 
    sost: boolean, 
    //idID: number, 
    dati: FormData) {
    const url: string = this.apiUrl + "/uploadxml";

    let params = new HttpParams()
      .set('idPG', idPG)
      .set('sostituzione', sost)
      //.set('idID', idID);

    return this.http.post<Esito>(url, dati, { params });
  }

  getTipoCombustibile() {
  const url: string = environment.apiUrl + "/componente/combustibile";
  return this.http.get<CodiceDescrizione[]>(url).pipe(
    map((list: CodiceDescrizione[]) =>
      list.filter(cd => {
        const codiceNum = Number(cd.codice);
        return codiceNum < 80 || codiceNum === 99;
      })
    )
  );
}

  getUnitaDiMisura() {
    const url: string = environment.apiUrl + "/componente/unita-misura";
    return this.http.get<CodiceDescrizione[]>(url);
  }

  salvaFiltri(filtri: any) {
    this.filtriSalvati = { ...filtri };
  }

  getFiltri() {
    return this.filtriSalvati;
  }

  clearFiltri() {
    this.filtriSalvati = null;
  }
}
