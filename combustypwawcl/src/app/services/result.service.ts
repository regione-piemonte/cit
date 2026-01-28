import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { ControlloDisponibileModel } from '../models/controllo-disponibile';
import { DatoControlloModel } from '../models/dato-controllo-model';
import { Persona } from '../models/persona';
import { Impianto } from '../models/impianto';
import { RicercaDatiFornituraResult } from '../models/ricerca-dati-fornitura-result';

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
  resultRicercaDatiFornitura: RicercaDatiFornituraResult;
  privacy: boolean = false;
  boolValue: boolean = false;
  
  isRicercaCompletaCheckedSource = new BehaviorSubject<boolean>(false);
  isRicercaCompletaChecked$ = this.isRicercaCompletaCheckedSource.asObservable();

  isVisualizzazioneDettaglio: boolean;
  isTypeImpianto: boolean;
  isTypePersona: boolean;

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

  setRicercaDatiFornitura(persone: Persona[], impianti: Impianto[]) {
    if (!this.resultRicercaDatiFornitura) {
        this.resultRicercaDatiFornitura = { persone: [], impianti: [] }; // inizializza come oggetto vuoto
      }

    this.resultRicercaDatiFornitura.persone = persone || [];
    this.resultRicercaDatiFornitura.impianti = impianti || [];
  }

  getRicercaDatiFornitura(): RicercaDatiFornituraResult {
    return this.resultRicercaDatiFornitura;
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

  setResultBool(elem: boolean){
    this.boolValue = elem;
  }

  getResultBool(){
    return this.boolValue;
  }

  setIsVisualizzazioneDettaglio(elem: boolean){
    this.isVisualizzazioneDettaglio = elem;
  }

  getResultIsVisualizzazioneDettaglio(){
    return this.isVisualizzazioneDettaglio;
  }

  setIsImpianto(elem: boolean){
    this.isTypeImpianto = elem;
  }

  getResultIsImpianto(){
    return this.isTypeImpianto;
  }

  setIsPersona(elem: boolean){
    this.isTypePersona = elem;
  }

  getResultIsPersona(){
    return this.isTypePersona;
  }
}
