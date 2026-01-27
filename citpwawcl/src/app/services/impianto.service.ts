import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { tap } from 'rxjs/operators';
import { environment } from 'src/environments/environment';
import { CodiceDescrizione } from '../models/codice-descrizione';
import { DatiImpianto } from '../models/dati-impianto';
import { Esito } from '../models/esito';
import { Impianto } from '../models/impianto';
import { LoccsiFeature } from '../models/loccsi-feature';
import { Persona } from '../models/persona';
import { SubentroComponenti } from '../models/subentro-componenti';
import { SharedService } from './shared.service';

@Injectable({
  providedIn: 'root'
})
export class ImpiantoService {

  private apiUrl: string;
  constructor(
    private http: HttpClient,
    private router: Router,
    private sharedService: SharedService
  ) { this.apiUrl = environment.apiUrl + 'impianto'; }

  getImpiantoByFilter(codiceImpianto?: string,
    statoImpianto?: string,
    cfResp?: string,
    cfProp?: string,
    cf3resp?: string,
    pod?: string,
    pdr?: string,
    indirizzo?: string,
    civico?: string,
    x?: number,
    y?: number,
    distanza?: number,
    descComune?: string) {
    const url: string = this.apiUrl + "/list";

    let parameters: HttpParams = new HttpParams();


    if (cf3resp) {
      parameters = parameters.append("cf3-resp", cf3resp);
    }

    if (cfProp) {
      parameters = parameters.append("cf-proprietario", cfProp);
    }


    if (cfResp) {
      parameters = parameters.append("cf-responsabile", cfResp);
    }

    if (codiceImpianto) {
      parameters = parameters.append("codice-impianto", codiceImpianto);
    }

    if (statoImpianto) {
      parameters = parameters.append("fk-stato", statoImpianto);
    }

    if (pod) {
      parameters = parameters.append("pod", pod);
    }

    if (pdr) {
      parameters = parameters.append("pdr", pdr);
    }
    if (indirizzo) {
      parameters = parameters.append("indirizzo", indirizzo);
    }
    if (civico) {
      parameters = parameters.append("civico", civico);
    }
    if (x) {
      parameters = parameters.append("x", x);
    }

    if (y) {
      parameters = parameters.append("y", y);
    }

    if (distanza) {
      parameters = parameters.append("distanza", distanza);
    }

    if (descComune) {
      parameters = parameters.append("desc-comune", descComune);
    }

    return this.http.get<Impianto[]>(url, { params: parameters });
  }

  getGeoJsonByFilter(ricercaCompleta: boolean,
    codiceImpianto?: string,
    statoImpianto?: string,
    cfResp?: string,
    cfProp?: string,
    cf3resp?: string,
    pod?: string,
    pdr?: string,
    indirizzo?: string,
    civico?: string,
    x?: number,
    y?: number,
    distanza?: number,
    descComune?: string) {
    const url: string = this.apiUrl + "/geojson";

    let parameters: HttpParams = new HttpParams();


    if (cf3resp) {
      parameters = parameters.append("cf3-resp", cf3resp);
    }

    if (cfProp) {
      parameters = parameters.append("cf-proprietario", cfProp);
    }


    if (cfResp) {
      parameters = parameters.append("cf-responsabile", cfResp);
    }

    if (codiceImpianto) {
      parameters = parameters.append("codice-impianto", codiceImpianto);
    }

    if (statoImpianto) {
      parameters = parameters.append("fk-stato", statoImpianto);
    }

    if (pod) {
      parameters = parameters.append("pod", pod);
    }

    if (pdr) {
      parameters = parameters.append("pdr", pdr);
    }
    if (indirizzo) {
      parameters = parameters.append("indirizzo", indirizzo);
    }
    if (civico) {
      parameters = parameters.append("civico", civico);
    }
    if (x) {
      parameters = parameters.append("x", x);
    }

    if (y) {
      parameters = parameters.append("y", y);
    }

    if (distanza) {
      parameters = parameters.append("distanza", distanza);
    }

    if (descComune) {
      parameters = parameters.append("desc-comune", descComune);
    }

    if (ricercaCompleta != null) {
      parameters = parameters.append("ricercaCompleta", ricercaCompleta);
    }

    return this.http.get<String>(url, { params: parameters });
  }

  getGeoJsonByFilterPodPdrDuplicati(ricercaCompleta: boolean,
    codiceImpianto?: string,
    statoImpianto?: string,
    cfResp?: string,
    cfProp?: string,
    cf3resp?: string,
    pod?: string,
    pdr?: string,
    indirizzo?: string,
    civico?: string,
    x?: number,
    y?: number,
    distanza?: number,
    descComune?: string) {
    const url: string = this.apiUrl + "/responsabile/geojson/duplicati";

    let parameters: HttpParams = new HttpParams();


    if (cf3resp) {
      parameters = parameters.append("cf3-resp", cf3resp);
    }

    if (cfProp) {
      parameters = parameters.append("cf-proprietario", cfProp);
    }


    if (cfResp) {
      parameters = parameters.append("cf-responsabile", cfResp);
    }

    if (codiceImpianto) {
      parameters = parameters.append("codice-impianto", codiceImpianto);
    }

    if (statoImpianto) {
      parameters = parameters.append("fk-stato", statoImpianto);
    }

    if (pod) {
      parameters = parameters.append("pod", pod);
    }

    if (pdr) {
      parameters = parameters.append("pdr", pdr);
    }
    if (indirizzo) {
      parameters = parameters.append("indirizzo", indirizzo);
    }
    if (civico) {
      parameters = parameters.append("civico", civico);
    }
    if (x) {
      parameters = parameters.append("x", x);
    }

    if (y) {
      parameters = parameters.append("y", y);
    }

    if (distanza) {
      parameters = parameters.append("distanza", distanza);
    }

    if (descComune) {
      parameters = parameters.append("desc-comune", descComune);
    }

    if (ricercaCompleta != null) {
      parameters = parameters.append("ricercaCompleta", ricercaCompleta);
    }

    return this.http.get<String>(url, { params: parameters });
  }


  parseGeoJsonToImpianto(geoJson: any): Impianto[] {
    console.log(geoJson);

    if (geoJson.type !== 'FeatureCollection' || !Array.isArray(geoJson.features) || geoJson.features.length == 0) {
      console.log('Invalid GeoJSON: not a FeatureCollection');
      return [];

      //throw new Error('Invalid GeoJSON: not a FeatureCollection');
    }

    return geoJson.features.map((feature: any) => {
      const properties = feature.properties;

      return {
        cf3Responsabile: '', // Non passato
        cfResponsabile: properties['Responsabile - codice fiscale'] || '',
        civico: properties['Civico'] || '',
        codiceImpianto: properties['Codice impianto'] ? parseInt(properties['Codice impianto'], 10) : 0,
        denom3Responsabile: '', // Non passato
        denomResponsabile: properties['Responsabile - nome'] || '',
        descComune: properties['Comune'] || '',
        dtAssegnazione: '', // Non passato
        dtDismissione: '', // Non passato
        dtUltAggLibretto: '', // Non passato
        indirizzo: properties['Indirizzo'] || '',
        motivoDisimissione: '', // Non passato
        siglaProv: properties['Provincia'] || '',
        stato: properties['Stato'] || '',
        uidIndexLibretto: '' // Non passato
      };
    });
  }

  getGeoJsonImpianto(
    cfImpresa?: string,
    numeroRea?: string,
    siglaRea?: string,
    codiceImpianto?: string,
    cfResp?: string,
    cfProp?: string,
    cf3resp?: string,
    pod?: string,
    pdr?: string,
    indirizzo?: string,
    civico?: string,
    x?: number,
    y?: number,
    distanza?: number,
    descComune?: string) {
    const url: string = this.apiUrl + "/impresa/geojson";

    let parameters: HttpParams = new HttpParams();
    
    if (cfImpresa) {
      parameters = parameters.append("cf-impresa", cfImpresa);
    }

    if (numeroRea) {
      parameters = parameters.append("numero-rea", numeroRea);
    }

    if (siglaRea) {
      parameters = parameters.append("sigla-rea", siglaRea);
    }

    if (cf3resp) {
      parameters = parameters.append("cf3-resp", cf3resp);
    }

    if (cfProp) {
      parameters = parameters.append("cf-proprietario", cfProp);
    }


    if (cfResp) {
      parameters = parameters.append("cf-responsabile", cfResp);
    }

    if (codiceImpianto) {
      parameters = parameters.append("codice-impianto", codiceImpianto);
    }

    if (pod) {
      parameters = parameters.append("pod", pod);
    }

    if (pdr) {
      parameters = parameters.append("pdr", pdr);
    }
    if (indirizzo) {
      parameters = parameters.append("indirizzo", indirizzo);
    }
    if (civico) {
      parameters = parameters.append("civico", civico);
    }
    if (x) {
      parameters = parameters.append("x", x);
    }

    if (y) {
      parameters = parameters.append("y", y);
    }

    if (distanza) {
      parameters = parameters.append("distanza", distanza);
    }

    if (descComune) {
      parameters = parameters.append("desc-comune", descComune);
    }

    return this.http.get<String>(url, { params: parameters });
  }

  getStatoImpianto() {
    const url: string = this.apiUrl + "/stato";
    return this.http.get<CodiceDescrizione[]>(url);
  }

  setImpianto(datiImpianto: DatiImpianto, responsabilita: number) {
    const url: string = this.apiUrl + "/setImpianto";
    let parameters: HttpParams = new HttpParams();
    if (responsabilita) {
      parameters = parameters.append("responsabilita", responsabilita);
    }
    return this.http.post<Esito>(url, datiImpianto, { params: parameters });
  }

  updateImpianto(impianto: DatiImpianto, codiceImpianto: string) {
    const url: string = this.apiUrl + "/setImpianto/" + codiceImpianto;
    return this.http.post<Esito>(url, impianto);
  }

  getIndirizzoStradario(q: string) {
    const url: string = this.apiUrl + "/indirizzo";
    let parameters: HttpParams = new HttpParams();
    parameters = parameters.append("indirizzo", q);
    return this.http.get<LoccsiFeature[]>(url, { params: parameters });
  }

  getProvinciaByComune(comune: string) {
    const url: string = this.apiUrl + "/pv";
    let parameters: HttpParams = new HttpParams();
    parameters = parameters.append("comune", comune);
    return this.http.get<LoccsiFeature[]>(url, { params: parameters });
  }

  getDettaglioImpianto(codiceImpianto: string) {
    const url: string = this.apiUrl + "/dati-impianto";
    let parameters: HttpParams = new HttpParams();
    parameters = parameters.append("codice-impianto", codiceImpianto);
    return this.http.get<any>(url, { params: parameters })
      .pipe(tap(res => {
        this.sharedService.datiPrecompilati = res.Richiesta.datiPrecompilati;
        localStorage.setItem("datiPrecompilati", JSON.stringify(this.sharedService.datiPrecompilati));
      }));
  }

  cercaResponsabileProprietario(tipo, cf?, numeroRea?, siglaRea?, checkAbilitazioneInsImpianto = false) {
    const url: string = this.apiUrl + "/resp-prop";
    let parameters: HttpParams = new HttpParams();
    if (tipo)
      parameters = parameters.append("tipo", 1);
    else
      parameters = parameters.append("tipo", 0);
    if (cf) {
      parameters = parameters.append("cf", cf);
    }
    if (numeroRea) {
      parameters = parameters.append("numero-rea", numeroRea);
    }
    if (siglaRea) {
      parameters = parameters.append("sigla-rea", siglaRea);
    }
    parameters = parameters.append("checkAbilitazioneInsImpianto", checkAbilitazioneInsImpianto);
    return this.http.get<any>(url, { params: parameters });
  }

  setResponsabileProprietario(codiceImpianto, persona) {
    const url: string = this.apiUrl + "/resp-prop/" + codiceImpianto;
    return this.http.post<any>(url, persona);
  }

  updateResponsabileProprietario(codiceImpianto, persona) {
    const url: string = this.apiUrl + "/resp-prop/" + codiceImpianto;
    return this.http.put<any>(url, persona);
  }

  checkPodDuplicato(pod: string) {
    const url: string = this.apiUrl + "/pod-duplicato";
    let parameters: HttpParams = new HttpParams();
    parameters = parameters.append("pod", pod);
    return this.http.get<Esito>(url, { params: parameters });
  }

  checkPdrDuplicato(pdr: string) {
    const url: string = this.apiUrl + "/pdr-duplicato";
    let parameters: HttpParams = new HttpParams();
    parameters = parameters.append("pdr", pdr);
    return this.http.get<Esito>(url, { params: parameters });
  }

  checkPodPdrDuplicato(pod: string, pdr: string) {
    const url: string = this.apiUrl + "/podpdr-duplicato";
    let parameters: HttpParams = new HttpParams();
    parameters = parameters.append("pod", pod);
    parameters = parameters.append("pdr", pdr);
    return this.http.get<Esito>(url, { params: parameters });
  }

  getGeoJsonImpiantoMaxResults() {
    const url: string = this.apiUrl + "/geojson/max";
    return this.http.get<number>(url);
  }

  /**
   *  implementation of the verifyIndirizzoImpianto method
   * @param datiImpianto
   * @returns
   */
  verifyIndirizzoImpianto(datiImpianto: DatiImpianto | any, checkContrattoInEssere?: boolean): Observable<any> {
    const url: string = this.apiUrl + "/verify";
    return this.http.post(url, datiImpianto, { params: { checkContrattoInEssere } });
  }

  getElencoStoricoResponsabiliImpianto(codiceImpianto: string): Observable<Persona[]> {
    const url: string = this.apiUrl + "/responsabili/elenco/storico";
    let parameters: HttpParams = new HttpParams();
    parameters = parameters.append("codice_impianto", codiceImpianto);
    return this.http.get<Persona[]>(url, {params: parameters});
  }

  setSubentrosuComponenti(codiceImpianto, idPersonaGiuridica, sendMail: boolean, subentroComponenti: SubentroComponenti){
    const url: string = this.apiUrl + "/subentro/componenti";
    let params: HttpParams = new HttpParams().append("codice_impianto", codiceImpianto).append("id_persona_giuridica", idPersonaGiuridica).append("sendMail", sendMail);
    return this.http.post<Esito>(url, subentroComponenti, {params: params});
  }
}
