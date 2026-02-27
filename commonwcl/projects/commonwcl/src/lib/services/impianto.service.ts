import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { LoccsiFeature } from '../models/common/loccsi-feature';

@Injectable({
    providedIn: 'root'
})
export class ImpiantoService {

    private apiUrl: string;

    constructor(
        private http: HttpClient,
        private router: Router
    ) {

    }

    init(apiUrl: string) {
        this.apiUrl = apiUrl + 'impianto';
    }


    getGeoJsonByFilter(codiceImpianto?: string,
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
        this.checkInit();
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

        return this.http.get<String>(url, { params: parameters });
    }

    checkInit() {
        if(!this.apiUrl)
            throw new Error("ImpiantoService not initialized. Call init() method before using it.");
    }





    getIndirizzoStradario(q: string) {
        this.checkInit();
        const url: string = this.apiUrl + "/indirizzo";
        let parameters: HttpParams = new HttpParams();
        parameters = parameters.append("indirizzo", q);
        return this.http.get<LoccsiFeature[]>(url, { params: parameters });
    }

    getProvinciaByComune(comune: string) {
        this.checkInit();
        const url: string = this.apiUrl + "/pv";
        let parameters: HttpParams = new HttpParams();
        parameters = parameters.append("comune", comune);
        return this.http.get<LoccsiFeature[]>(url, { params: parameters });
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




}
