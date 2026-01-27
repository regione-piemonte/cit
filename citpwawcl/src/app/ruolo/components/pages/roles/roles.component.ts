import { NumberInput } from '@angular/cdk/coercion';
import { Component, HostListener, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { NgxPermissionsService } from 'ngx-permissions';
import { Errore } from 'src/app/models/errore';
import { PFLoggato } from 'src/app/models/pf-loggato';
import { Ruoli } from 'src/app/models/ruoli';
import { RuoloLoggato } from 'src/app/models/ruolo-loggato';
import { RuoloPA } from 'src/app/models/ruolo-pa';
import { RuoloPF } from 'src/app/models/ruolo-pf';
import { RuoloPG } from 'src/app/models/ruolo-pg';
import { UtenteLoggato } from 'src/app/models/utente-loggato';
import { PERMS } from 'src/app/perms';
import { PrivacyDialogComponent } from 'src/app/ruolo/components/privacy-dialog/privacy-dialog.component';
import { AuthenticationService } from 'src/app/services/authentication.service';
import { LocalStorageServiceService } from 'src/app/services/local-storage-service.service';
import { ResultService } from 'src/app/services/result.service';
import { ICONSURL } from 'src/app/utils/constants';

@Component({
  selector: 'app-roles',
  templateUrl: './roles.component.html',
  styleUrls: ['./roles.component.scss']
})
export class RolesComponent implements OnInit {

  cittadini: string = ICONSURL + "IconCittadini.png";
  imprese: string = ICONSURL + "IconImprese.png";
  pa: string = ICONSURL + "IconPA.png";
  chat: string = ICONSURL + "IconChat.png";
  titlePng: string = ICONSURL + "titolo.png";
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

  colBreakpoint1: NumberInput;
  colBreakpoint2: NumberInput;
  isMobile: boolean;

  constructor(private readonly authenticationService: AuthenticationService, private router: Router, public dialog: MatDialog, private resultService: ResultService, private permissions: NgxPermissionsService, private localStorageService: LocalStorageServiceService) {
  }

  ngOnInit(): void {
    this.localStorageService.clearDatiImpiantoDuplicato();
    this.isMobile = (window.innerWidth < 768) ? true : false;
    this.colBreakpoint1 = (window.innerWidth < 768) ? 0 : 1;
    this.colBreakpoint2 = (window.innerWidth < 768) ? 12 : 10;

    let utente = new UtenteLoggato(new PFLoggato(
      this.authenticationService.getCurrentUserFromSession().pfLoggato.codiceFiscalePF, null, null),
      new RuoloLoggato(null, null, null, null, null, null, null, null, null, null, null));

    this.authenticationService.getDisponibilitaServizio(utente).toPromise()
      .then((response: any) => {
        // This is intentional
      })
      .catch((error) => {
        var parsed = JSON.parse(JSON.stringify(error));

        if ((parsed.status.toString() === "500") && (parsed.statusText.toString() === "Internal Server Error"))
        {
          this.router.navigate(['/disponibilita-servizio']);
        }
      });

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

  @HostListener('window:resize', ['$event'])
  onResize(event?) {
    this.isMobile = (event.target.innerWidth < 768) ? true : false;
    this.colBreakpoint1 = (event.target.innerWidth < 768) ? 0 : 1;
    this.colBreakpoint2 = (event.target.innerWidth < 768) ? 12 : 10;
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
        this.permissions.loadPermissions(PERMS[elem.ruoloLoggato.ruolo] ?? []);
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
        this.permissions.loadPermissions(PERMS[elem.ruoloLoggato.ruolo] ?? []);
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
        this.permissions.loadPermissions(PERMS[elem.ruoloLoggato.ruolo] ?? []);
        this.router.navigate(["/impianto/ricerca-impianti"]);
      }, error => {
        this.titoloErrore = "Errore";
        this.descrizioneErrore = error.title;
      });
    }
  }

  isRuoloResponsabile(ruolo: string): boolean {
    if(ruolo == "RESPONSABILE"){
      return true;
    }else{
      return false;
    }
  }
}
