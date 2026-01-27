import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { RouterModule } from '@angular/router';
import { BehaviorSubject } from 'rxjs';
import { environment } from 'src/environments/environment';
import { ManutFormModel } from '../models/manut-form-model';
import { OperazioneControlloModel } from '../models/operazione-controllo-model';
import { SyncServiceService } from './sync-service.service';

@Injectable({
  providedIn: 'root'
})
export class ControlloService {
  private apiUrl: string;
  constructor(private http: HttpClient,
    private router: RouterModule,
    private readonly syncService: SyncServiceService) { this.apiUrl = environment.apiUrl + 'controllo'; }

  getControlliOrdinati(codice, ordinamento) {
    let parameters: HttpParams = new HttpParams();
    const url: string = this.apiUrl + "/all";
    parameters = parameters.append("codice-impianto", codice);
    parameters = parameters.append("ordinamento", ordinamento);
    return this.syncService.tryGet(url, parameters);
  }

  getRicevuta(idAllegato) {
    let parameters: HttpParams = new HttpParams();
    const url: string = this.apiUrl + "/ricevuta";
    parameters = parameters.append("id-allegato", idAllegato);
    return this.http.get(url, { params: parameters, responseType: 'blob' });
  }

  getPdfControllo(idAllegato, codiceImpianto, firmato) {
    let parameters: HttpParams = new HttpParams();
    const url: string = this.apiUrl + "/pdf";
    parameters = parameters.append("id-allegato", idAllegato);
    parameters = parameters.append("codice-impianto", codiceImpianto);
    parameters = parameters.append("firmato", firmato);
    return this.http.get(url, { params: parameters});
  }

  getControlliDisponibili(codiceImpianto, tipoComponente, tipoControllo, dataControllo) {
    let parameters: HttpParams = new HttpParams();
    const url: string = this.apiUrl + "/controlli-disponibili";
    parameters = parameters.append("tipo-componente", tipoComponente);
    parameters = parameters.append("codice-impianto", codiceImpianto);
    parameters = parameters.append("tipo-controllo", tipoControllo);
    parameters = parameters.append("data-controllo", dataControllo);
    return this.syncService.tryGet(url, parameters);
  }

  modificaREE(idAllegato, codice, tipoControllo, inviaBool, xml, operazione) {
    let parameters: HttpParams = new HttpParams();
    const url: string = this.apiUrl + "/ree";
    parameters = parameters.append("codice-impianto", codice);
    parameters = parameters.append("tipo-controllo", tipoControllo);
    parameters = parameters.append("invia", inviaBool);
    if (idAllegato) {
      parameters = parameters.append("id-allegato", idAllegato);
      return this.syncService.tryPutPayload(url, xml, parameters, operazione);
    } else {
      return this.syncService.tryPostPayload(url, xml, parameters, operazione);
    }
  }

  inviaREE(idAllegato, operazione) {
    let parameters: HttpParams = new HttpParams();
    const url: string = this.apiUrl + "/ree/invia";
    parameters = parameters.append("id-allegato", idAllegato);
    return this.syncService.tryPostPayload(url, null, parameters, operazione);
  }

  uploadReeFirmato(idAllegato, ree: File) {
    let parameters: HttpParams = new HttpParams();
    const url: string = this.apiUrl + "/ree-firmato";
    parameters = parameters.append("id-allegato", idAllegato);
    parameters = parameters.append("nome", ree.name);
    parameters = parameters.append("tipo", ree.type);

    return this.http.post(url, ree, { params: parameters });
  }

  getOnlineSubject(): BehaviorSubject<boolean> {
    return this.syncService.getOnlineSubject();
  }


  inviaManutenzione(codice, tipoControllo, manutenzione: ManutFormModel, operazione: OperazioneControlloModel) {
    let parameters: HttpParams = new HttpParams();
    const url: string = this.apiUrl + "/manutenzione";
    parameters = parameters.append("codice-impianto", codice);
    parameters = parameters.append("tipo-controllo", tipoControllo);
    return this.syncService.tryPostPayload(url, manutenzione, parameters, operazione);
  }

  deleteControllo(idAllegato, statoRapp, operazione: OperazioneControlloModel) {
    let parameters: HttpParams = new HttpParams();
    const url: string = this.apiUrl;
    parameters = parameters.append("id-allegato", idAllegato);
    parameters = parameters.append("stato-rapp", statoRapp);
    return this.syncService.tryDelete(url, parameters, operazione);
  }
}
