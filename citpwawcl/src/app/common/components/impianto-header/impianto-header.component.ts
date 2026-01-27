import { Component, Input, OnChanges, OnInit, SimpleChanges } from '@angular/core';
import { Router } from '@angular/router';
import { DatiImpianto } from 'src/app/models/dati-impianto';
import { ResultService } from 'src/app/services/result.service';
import { SharedService } from 'src/app/services/shared.service';

@Component({
  selector: 'app-impianto-header',
  templateUrl: './impianto-header.component.html',
  styleUrls: ['./impianto-header.component.scss']
})
export class ImpiantoHeaderComponent implements OnInit, OnChanges {

  datiPrecompilati: any;
  indirizzo: string = "";
  responsabile: string = "";
  codiceImpianto: string;
  terzoResponsabile: string = "";
  terzoResponsabileLabel: string = "3 Responsabile: ";
  validitaDalTerzoResp: Date;
  validitaAlTerzoResp: Date;

  @Input() datiImpianto: DatiImpianto;
  @Input() redirect: boolean = true; // aggiunto per evitare il redirect in caso di datiImpianto non presenti


  constructor(
    private readonly resultService: ResultService,
    private readonly sharedService: SharedService,
    private router: Router,
  ) { }

  ngOnInit(): void {
    this.loadData();
  }

  ngOnChanges(changes: SimpleChanges) {
   this.loadData();
  }


  loadData() {
    if (this.datiImpianto) {
      this.datiPrecompilati = this.datiImpianto;
    } else {
      if (!!this.sharedService.datiPrecompilati) {
        this.datiPrecompilati = this.sharedService.getDatiPrecompilati();
      } else {
        this.datiPrecompilati = this.resultService.getResult();
      }
    }
    if (this.datiPrecompilati) {
      if (this.datiPrecompilati.sezNomine && this.datiPrecompilati.sezNomine.rowNomine) {
        this.validitaAlTerzoResp = this.datiPrecompilati.sezNomine.rowNomine[0]?.L3dataValiditaContrattoAl;
        this.validitaDalTerzoResp = this.datiPrecompilati.sezNomine.rowNomine[0]?.L3dataValiditaContrattoDal;
      }
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
        if ((this.validitaAlTerzoResp && this.validitaAlTerzoResp > new Date() && this.validitaDalTerzoResp < new Date()) || (!this.validitaAlTerzoResp)) {
          this.terzoResponsabile = this.terzoResponsabileLabel + this.datiPrecompilati.sezNomine.rowNomine[0].L3ragSocialeDitta;
        }
      }
    } else {
      if (this.redirect) {
        console.log("VAR VALUE", this.datiPrecompilati);
        this.router.navigate(['/impianto/ricerca-impianti']);
      }
    }
  }
}
