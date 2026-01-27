import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { ControlloDisponibileModel } from '../models/controllo-disponibile';
import { DatoControlloModel } from '../models/dato-controllo-model';

@Injectable({
  providedIn: 'root'
})
export class ResultService {

  constructor() {
    //Not Implemented
   }

  result: any;
  resultControllo: DatoControlloModel;
  resultControlloDisponibile: ControlloDisponibileModel;
  privacy: boolean = false;

  isRicercaCompletaCheckedSource = new BehaviorSubject<boolean>(false);
  isRicercaCompletaChecked$ = this.isRicercaCompletaCheckedSource.asObservable();

  setRicercaCompletaChecked(value: boolean) {
    this.isRicercaCompletaCheckedSource.next(value);
  }

  setResult(elem: any) {
    this.result = elem;
  }

  refreshResult() {
    this.result = [];
  }

  getResult() {
    return this.result;
  }

  setResultControllo(elem: DatoControlloModel) {
    this.resultControllo = elem;
    this.resultControlloDisponibile = undefined;
  }

  setResultControlloDisponibile(elem: ControlloDisponibileModel) {
    this.resultControlloDisponibile = elem;
    this.resultControllo = undefined;
  }

  getResultControllo(): DatoControlloModel {
    return this.resultControllo;
  }

  getResultControlloDisponibile(): ControlloDisponibileModel {
    return this.resultControlloDisponibile;
  }

  setPrivacy(elem: boolean) {
    this.privacy = elem;
  }

  getPrivacy() {
    return this.privacy;
  }
}
