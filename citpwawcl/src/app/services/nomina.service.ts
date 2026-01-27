import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { DettaglioNomina } from '../models/dettaglio-nomina';
import { RequestTerzoResponsabile } from '../models/request-terzo-responsabile';
import { UtenteLoggato } from '../models/utente-loggato';

@Injectable({
    providedIn: 'root'
})
export class NominaTerzoResponsabileService {
    private apiUrl: string;

    constructor(
        private http: HttpClient
    ) { this.apiUrl = environment.apiUrl + 'nominaterzoresponsabile'; }

    // Add your service methods here


    getDettaglioNomina(idContratto, idImpianto): Observable<DettaglioNomina> {
        const url: string = this.apiUrl + "/dettaglio";
        let parameters: HttpParams = new HttpParams();
        parameters = parameters.append("id_contratto", idContratto).append("codice_impianto", idImpianto);
        return this.http.get<DettaglioNomina>(url, { params: parameters });
    }


    getTipoCessazione(): Observable<any> {
        const url: string = this.apiUrl + "/tipo/cessazione";
        return this.http.get<Map<Number, String>>(url);
    }

    getTipoAutodichiarazione(): Observable<any> {
        const url: string = this.apiUrl + "/tipo/autodichiarazione";
        return this.http.get<Map<Number, String>>(url);
    }

    deleteAffidamento(codiceFiscale: string, idPersonaGiuridica: number, codiceImpianto: string, affidamento) {
        const url: string = this.apiUrl + "/delete/affidamento";
        let params = new HttpParams().append("id_persona_giuridica", idPersonaGiuridica)
            .append("codice_impianto", codiceImpianto).append("codice_fiscale", codiceFiscale);
        return this.http.post(url, affidamento, { params: params, responseType: 'text' });
    }

    setSubentrosuImpianto(codice_fiscale: string, id_persona: number, codice_impianto: number, des_ruolo: string, utenteLoggato: UtenteLoggato) {
        const url: string = this.apiUrl + "/subentro/impianto/set";
        let params = new HttpParams()
            .append("codice_fiscale", codice_fiscale)
            .append("codice_impianto", codice_impianto)
            .append("des_ruolo", des_ruolo);
        if(id_persona){
            params = params.append("id_persona", id_persona)
        }
        return this.http.post(url, utenteLoggato, { params: params, responseType: 'text' });
    }

    verifyContrattoTerzoResponsabile(requestTerzoResponsabile: RequestTerzoResponsabile) {
        const url: string = this.apiUrl + "/verify/contratto";
        return this.http.post(url, requestTerzoResponsabile, { responseType: 'text' });
    }

    setNuovoTerzoResp(codice_impianto: string | number, requestTerzoResponsabile: RequestTerzoResponsabile) {
        const url: string = this.apiUrl + "/nuovo/set";
        let params = new HttpParams().append("codice_impianto", codice_impianto);
        return this.http.post(url, requestTerzoResponsabile, { responseType: 'text', params: params });
    }

    setCessazione(requestTerzoResponsabile: RequestTerzoResponsabile) {
        const url: string = this.apiUrl + "/cessazione/set";
        return this.http.post(url, requestTerzoResponsabile, { responseType: 'text' });
    }

    setProroga(requestTerzoResponsabile: RequestTerzoResponsabile) {
        const url: string = this.apiUrl + "/proroga/set";
        return this.http.post(url, requestTerzoResponsabile, { responseType: 'text' });
    }
}
