import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { Errore } from 'src/app/models/errore';
import { PFLoggato } from 'src/app/models/pf-loggato';
import { Ruoli } from 'src/app/models/ruoli';
import { RuoloLoggato } from 'src/app/models/ruolo-loggato';
import { RuoloPA } from 'src/app/models/ruolo-pa';
import { RuoloPF } from 'src/app/models/ruolo-pf';
import { RuoloPG } from 'src/app/models/ruolo-pg';
import { UtenteLoggato } from 'src/app/models/utente-loggato';
import { PrivacyDialogComponent } from 'src/app/ruolo/components/privacy-dialog/privacy-dialog.component';
import { AuthenticationService } from 'src/app/services/authentication.service';
import { ResultService } from 'src/app/services/result.service';
import { ICONSURL } from 'src/app/utils/constants';

@Component({
  selector: 'app-roles',
  templateUrl: './roles.component.html',
  styleUrls: ['./roles.component.scss']
})
export class RolesComponent implements OnInit {


  cittadini: string = ICONSURL + "cittadini.png";
  imprese: string = ICONSURL + "imprese.png";
  pa: string = ICONSURL + "pa.png";
  cittadiniScuro: string = ICONSURL + "cittadini_scuro.png";
  impreseScuro: string = ICONSURL + "imprese_scuro.png";
  paScuro: string = ICONSURL + "pa_scuro.png";
  paRed: string = ICONSURL + "pa_red.svg";
  pgRed: string = ICONSURL + "impresa_red.svg";
  pfRed: string = ICONSURL + "cittadino_red.svg";
  titoloErrore: string = "";
  descrizioneErrore: string = "";

  cittadiniclicked: boolean = true;
  impreseclicked: boolean = false;
  paclicked: boolean = false;
  ruoli?: Ruoli;
  citbot: string = ICONSURL + "citbot.png";

  constructor(private readonly authenticationService: AuthenticationService, private router: Router, public dialog: MatDialog, private resultService: ResultService) {
  }

  ngOnInit(): void {
    if (!this.resultService.getPrivacy()) {
      const dialogRef = this.dialog.open(PrivacyDialogComponent, { disableClose: true });
      dialogRef.afterClosed().subscribe(result => {
        if (result) {
          this.resultService.setPrivacy(true);
          this.authenticationService.getRuoliUtente().subscribe((ruoliResponse: Ruoli) => {
            this.clearErrors();
            this.ruoli = ruoliResponse;
          }, (error: Errore) => {
            this.titoloErrore = "Errore";
            this.descrizioneErrore = error.title;
          });
        }
      });
    } else {
      this.authenticationService.getRuoliUtente().subscribe((ruoliResponse: Ruoli) => {
        this.clearErrors();
        this.ruoli = ruoliResponse;
      }, (error: Errore) => {
        this.titoloErrore = "Errore";
        this.descrizioneErrore = error.title;
      });
    }
  }

  clearErrors() {
    this.titoloErrore = "";
    this.descrizioneErrore = "";
  }

  showPa(): void {
    this.paclicked = true;
    this.impreseclicked = false;
    this.cittadiniclicked = false;
  }


  showCittadini(): void {
    this.paclicked = false;
    this.impreseclicked = false;
    this.cittadiniclicked = true;
  }
  showImprese(): void {
    this.paclicked = false;
    this.impreseclicked = true;
    this.cittadiniclicked = false;
  }

  selezionaRuoloPF(role: RuoloPF) {
    if (this.ruoli) {
      let utente = new UtenteLoggato(new PFLoggato(this.ruoli.pfLoggato.codiceFiscalePF, this.ruoli.pfLoggato.cognomePF, this.ruoli.pfLoggato.nomePF),
        new RuoloLoggato(role.ruoloPF, null, null, null, null, null, null, null, null, null, null));
      this.authenticationService.setAccesso(utente).subscribe(elem => {
        sessionStorage.setItem('currentUser', JSON.stringify(elem));
        this.router.navigate(["/impianto/ricerca-impianti"]);
      }, error => {
        this.titoloErrore = "Errore";
        this.descrizioneErrore = error.title;
      });
    }
  }

  selezionaRuoloPA(role: RuoloPA) {
    if (this.ruoli) {
      let utente = new UtenteLoggato(new PFLoggato(this.ruoli.pfLoggato.codiceFiscalePF, this.ruoli.pfLoggato.cognomePF, this.ruoli.pfLoggato.nomePF),
        new RuoloLoggato(role.ruoloPA, null, null, null, null, null, null, null, role.istatAbilitazione, role.descrAbilitazione, null));
      this.authenticationService.setAccesso(utente).subscribe(elem => {
        sessionStorage.setItem('currentUser', JSON.stringify(elem));
        this.router.navigate(["/impianto/ricerca-impianti"]);
      }, error => {
        this.titoloErrore = "Errore";
        this.descrizioneErrore = error.title;
      });
    }
  }

  selezionaRuoloPG(role: RuoloPG) {
    if (this.ruoli) {
      let utente = new UtenteLoggato(new PFLoggato(this.ruoli.pfLoggato.codiceFiscalePF, this.ruoli.pfLoggato.cognomePF, this.ruoli.pfLoggato.nomePF),
        new RuoloLoggato(role.ruoloPG, role.piva, role.siglaREA, role.numeroREA, role.denominazione, role.dataCessazione, role.idStato, role.descStato, null, null, role.idPersonaGiuridica));
      this.authenticationService.setAccesso(utente).subscribe(elem => {
        sessionStorage.setItem('currentUser', JSON.stringify(elem));
        this.router.navigate(["/impianto/ricerca-impianti"]);
      }, error => {
        this.titoloErrore = "Errore";
        this.descrizioneErrore = error.title;
      });
    }
  }
}
