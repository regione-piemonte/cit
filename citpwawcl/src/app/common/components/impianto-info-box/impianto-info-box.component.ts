import { Component, EventEmitter, Input, Output } from '@angular/core';

export interface ImpiantoInfoBox{
  indirizzo: string,
  responsabile: string,
  terzoResponsabile: string,
  codiceImpianto: number
}


export function datiPrecompilatiToInfoBox(datiPrecompilati: any): ImpiantoInfoBox{
let indirizzo;
let responsabile;
let terzoResponsabile;
let codiceImpianto;
let validitaAlTerzoResp;
let validitaDalTerzoResp;
  if (datiPrecompilati.sezNomine && datiPrecompilati.sezNomine.rowNomine) {
    validitaAlTerzoResp = datiPrecompilati.sezNomine.rowNomine[0]?.L3dataValiditaContrattoAl;
    validitaDalTerzoResp = datiPrecompilati.sezNomine.rowNomine[0]?.L3dataValiditaContrattoDal;
  }
  codiceImpianto = datiPrecompilati.codice_impianto;
  if (datiPrecompilati.L1_2indirizzo) {
    indirizzo = datiPrecompilati.L1_2indirizzo;
    indirizzo += datiPrecompilati.L1_2civico ? " " + datiPrecompilati.L1_2civico : "";
    indirizzo += datiPrecompilati.L1_2comune ? ", " + datiPrecompilati.L1_2comune : "";
  }

  if (datiPrecompilati.L1_6cf) {
    responsabile = datiPrecompilati.L1_6nome ? datiPrecompilati.L1_6nome : "";
    responsabile += datiPrecompilati.L1_6cognome ? " " + datiPrecompilati.L1_6cognome : "";
  } else {
    responsabile = datiPrecompilati.L1_6ragSociale ? datiPrecompilati.L1_6ragSociale : "";
  }
  if (datiPrecompilati.sezNomine && datiPrecompilati.sezNomine.rowNomine && validitaDalTerzoResp) {
    if ((validitaAlTerzoResp && validitaAlTerzoResp > new Date() && validitaDalTerzoResp < new Date()) || (!validitaAlTerzoResp)) {
      terzoResponsabile = datiPrecompilati.sezNomine.rowNomine[0].L3ragSocialeDitta;
    }
  }
  return {indirizzo, responsabile, terzoResponsabile, codiceImpianto}
}
@Component({
  selector: 'app-impianto-info-box',
  templateUrl: './impianto-info-box.component.html',
  styleUrls: ['./impianto-info-box.component.scss'],
})
export class ImpiantoInfoBoxComponent {
  @Input() impianto: ImpiantoInfoBox;
  @Output() onPanelToggle = new EventEmitter<boolean>();

  isOpened: boolean;

  togglePanel() {
    this.isOpened = !this.isOpened;
    this.onPanelToggle.emit(this.isOpened);
  }

}
