import { Component, OnInit } from '@angular/core';
import { ImpiantoService } from 'src/app/services/impianto.service';
import { ResultService } from 'src/app/services/result.service';

@Component({
  selector: 'app-impianto-header',
  templateUrl: './impianto-header.component.html',
  styleUrls: ['./impianto-header.component.scss']
})
export class ImpiantoHeaderComponent implements OnInit {

  datiPrecompilati: any;
  indirizzo: string = "";
  responsabile: string = "";
  codiceImpianto: string;
  terzoResponsabile: string = "";
  terzoResponsabileLabel: string = "3 Responsabile: ";
  validitaDalTerzoResp: Date;
  validitaAlTerzoResp: Date;


  constructor(private readonly resultService: ResultService, private readonly impiantoService: ImpiantoService) { }

  ngOnInit(): void {
    this.datiPrecompilati = this.resultService.getResult();
    if (this.datiPrecompilati.sezNomine && this.datiPrecompilati.sezNomine.rowNomine) {
      this.validitaAlTerzoResp = this.datiPrecompilati.sezNomine.rowNomine[0].L3dataValiditaContrattoAl;
      this.validitaDalTerzoResp = this.datiPrecompilati.sezNomine.rowNomine[0].L3dataValiditaContrattoDal;
    }
    if (this.datiPrecompilati) {
      this.codiceImpianto = this.datiPrecompilati.codice_impianto;
      if (this.datiPrecompilati.L1_2indirizzo) {
        this.indirizzo = this.datiPrecompilati.L1_2indirizzo;
        this.indirizzo += this.datiPrecompilati.L1_2civico ? " " + this.datiPrecompilati.L1_2civico : "";
        this.indirizzo += this.datiPrecompilati.L1_2comune ? ", " + this.datiPrecompilati.L1_2comune : "";
      }

      if (this.datiPrecompilati.L1_6cf) {
        this.responsabile = this.datiPrecompilati.L1_6nome ? this.datiPrecompilati.L1_6nome : "";
        this.responsabile += this.datiPrecompilati.L1_6cognome ? " " + this.datiPrecompilati.L1_6cognome : "";
      } else {
        this.responsabile = this.datiPrecompilati.L1_6ragSociale ? this.datiPrecompilati.L1_6ragSociale : "";
      }
      if (this.datiPrecompilati.sezNomine && this.datiPrecompilati.sezNomine.rowNomine && this.validitaDalTerzoResp) {
        if (this.validitaAlTerzoResp && this.validitaAlTerzoResp > new Date() && this.validitaDalTerzoResp < new Date()) {
          this.terzoResponsabile = this.terzoResponsabileLabel + this.datiPrecompilati.sezNomine.rowNomine[0].L3ragSocialeDitta;
        } else if (!this.validitaAlTerzoResp) {
          this.terzoResponsabile = this.terzoResponsabileLabel + this.datiPrecompilati.sezNomine.rowNomine[0].L3ragSocialeDitta;
        }
      }
    }
  }
}
