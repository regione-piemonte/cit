import { Component, HostListener, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { NgxPermissionsService } from 'ngx-permissions';
import { PFLoggato } from 'src/app/models/pf-loggato';
import { Ruoli } from 'src/app/models/ruoli';
import { RuoloLoggato } from 'src/app/models/ruolo-loggato';
import { RuoloPA } from 'src/app/models/ruolo-pa';
import { RuoloPG } from 'src/app/models/ruolo-pg';
import { UtenteLoggato } from 'src/app/models/utente-loggato';
import { PERMS } from 'src/app/perms';
import { AuthenticationService } from 'src/app/services/authentication.service';
import { ResultService } from 'src/app/services/result.service';
import { ICONSURL } from 'src/app/utils/constants';
import { PrivacyDialogComponent } from '../../privacy-dialog/privacy-dialog.component';
import { Errore } from 'src/app/models/errore';
import { SvistaService } from 'src/app/services/svista.service';
import { DatiDistributoreService } from 'src/app/services/dati-distributore.service';

@Component({
  selector: 'app-roles',
  templateUrl: './roles.component.html',
  styleUrls: ['./roles.component.scss']
})
export class RolesComponent implements OnInit {

  imprese: string = ICONSURL + "imprese.svg";
  pa: string = ICONSURL + "pa.svg";
  chat: string = ICONSURL + "icon_chat.png";
  titlePng: string = ICONSURL + "titolo.png";
  paRed: string = ICONSURL + "pa_red.svg";
  pgRed: string = ICONSURL + "impresa_red.svg";

  titoloErrore: string = "";
  descrizioneErrore: string = "";

  impreseclicked: boolean = false;
  paclicked: boolean = false;
  hasAnyRuoliPA: boolean = false;
  hasAnyRuoliPG: boolean = false;
  isMobile: boolean;
  ruoli?: Ruoli = new Ruoli(
  new PFLoggato('', '', ''),
  [], // ruoliPF
  [], // ruoliPG
  []  // ruoliPA
  );

  utente?: UtenteLoggato;

  constructor(
    private readonly authenticationService: AuthenticationService, 
    private router: Router, 
    public dialog: MatDialog, 
    private resultService: ResultService, 
    private permissions: NgxPermissionsService,
    private datiDistributoreService: DatiDistributoreService,
  readonly svistaService: SvistaService) { }

  ngOnInit(): void {
    this.isMobile = (window.innerWidth < 768) ? true : false;
    this.datiDistributoreService.clearFiltri();

    this.svistaService.saveComuniEstesiToLocalStorage();
    this.utente = new UtenteLoggato(new PFLoggato(
    this.authenticationService.getCurrentUserFromSession().pfLoggato.codiceFiscalePF, 
    this.authenticationService.getCurrentUserFromSession().pfLoggato.nomePF, 
    this.authenticationService.getCurrentUserFromSession().pfLoggato.cognomePF),
    new RuoloLoggato(null, null, null, null, null, null, null, null, null, null, null));

    this.permissions.loadPermissions(PERMS[this.utente.ruoloLoggato.ruolo] ?? []);
    
    this.authenticationService.getDisponibilitaServizio(this.utente).toPromise()
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
          this.authenticationService.getRuoliUtenteDistributore(this.utente).subscribe((ruoliResponse: Ruoli) => {
            this.clearErrors();
            this.ruoli = ruoliResponse;
            this.hasAnyRuoliPG = this.ruoli.ruoliPG?.length > 0;
            this.hasAnyRuoliPA = this.ruoli.ruoliPA?.length > 0;
            //this.updateRuoliPresence();
          }, (error: Errore) => {
            this.titoloErrore = "Errore";
            this.descrizioneErrore = error.title;
          });
        }
      });
    } else {
      this.authenticationService.getRuoliUtenteDistributore(this.utente).subscribe((ruoliResponse: Ruoli) => {
        this.clearErrors();
        this.ruoli = ruoliResponse;
        this.hasAnyRuoliPG = this.ruoli.ruoliPG?.length > 0;
        this.hasAnyRuoliPA = this.ruoli.ruoliPA?.length > 0;
        //this.updateRuoliPresence();
      }, (error: Errore) => {
        this.titoloErrore = "Errore";
        this.descrizioneErrore = error.title;
      });
    }
    //this.updateRuoliPresence();

  }

  @HostListener('window:resize', ['$event'])
  onResize(event?) {
    this.isMobile = (event.target.innerWidth < 768) ? true : false;
  }

  updateRuoliPresence() {
    if (this.ruoli.ruoliPG.length == 1 && this.ruoli.ruoliPA.length == 0){
      this.utente = new UtenteLoggato(
                  new PFLoggato(this.ruoli.pfLoggato.codiceFiscalePF, 
                                this.ruoli.pfLoggato.cognomePF, 
                                this.ruoli.pfLoggato.nomePF),
                  new RuoloLoggato(this.ruoli.ruoliPG[0].ruoloPG, 
                                  this.ruoli.ruoliPG[0].piva, 
                                  this.ruoli.ruoliPG[0].siglaREA, 
                                  this.ruoli.ruoliPG[0].numeroREA, 
                                  this.ruoli.ruoliPG[0].denominazione, 
                                  this.ruoli.ruoliPG[0].dataCessazione,
                                  this.ruoli.ruoliPG[0].idStato, 
                                  this.ruoli.ruoliPG[0].descStato, 
                                  null, 
                                  null, 
                                  this.ruoli.ruoliPG[0].idPersonaGiuridica));
      this.authenticationService.setAccesso(this.utente).subscribe(elem => {
        sessionStorage.setItem('currentUser', JSON.stringify(elem));
        this.permissions.loadPermissions(PERMS[elem.ruoloLoggato.ruolo] ?? []);
        this.router.navigate(["/elenco-dati-inviati"]);
      }, error => {
        this.titoloErrore = "Errore";
        this.descrizioneErrore = error.title;
      });
      this.router.navigate(["/elenco-dati-inviati"]); 
    }

    this.hasAnyRuoliPG = this.ruoli.ruoliPG.length > 0;
    this.hasAnyRuoliPA = this.ruoli.ruoliPA.length > 0;
  }

  showPA(): void {
    this.paclicked = true;
    this.impreseclicked = false;
  }

  showImprese(): void {
    this.paclicked = false;
    this.impreseclicked = true;
  }

  selezionaRuoloPG(role: RuoloPG) {
    console.log('role.idStato:', role.idStato);

    if (role.idStato == 3 || role.idStato == 4) {
        this.titoloErrore = "Errore";
        this.descrizioneErrore = "La ditta selezionata non può operare sul CIT Combusty in quanto in stato RADIATO o SOSPESO, contattare l’assistenza";
        return;
    }

    if (this.ruoli) {
      this.utente = new UtenteLoggato(new PFLoggato(this.ruoli.pfLoggato.codiceFiscalePF, this.ruoli.pfLoggato.cognomePF, this.ruoli.pfLoggato.nomePF),
        new RuoloLoggato(
          role.ruoloPG, 
          role.piva, 
          role.siglaREA, 
          role.numeroREA, 
          role.denominazione, 
          role.dataCessazione, 
          role.idStato, 
          role.descStato, 
          null, 
          null, 
          role.idPersonaGiuridica));
      this.authenticationService.setAccesso(this.utente).subscribe(elem => {
        sessionStorage.setItem('currentUser', JSON.stringify(elem));
        this.permissions.loadPermissions(PERMS[elem.ruoloLoggato.ruolo] ?? []);
        this.router.navigate(["/elenco-dati-inviati"]);
      }, error => {
        this.titoloErrore = "Errore";
        this.descrizioneErrore = error.title;
      });
    }
  }

  selezionaRuoloPA(role: RuoloPA) {
    if (this.ruoli) {
      this.utente = new UtenteLoggato(new PFLoggato(this.ruoli.pfLoggato.codiceFiscalePF, this.ruoli.pfLoggato.cognomePF, this.ruoli.pfLoggato.nomePF),
        new RuoloLoggato(role.ruoloPA, null, null, null, null, null, null, null, role.istatAbilitazione, role.descrAbilitazione, null));
      this.authenticationService.setAccesso(this.utente).subscribe(elem => {
        sessionStorage.setItem('currentUser', JSON.stringify(elem));
        //this.permissions.loadPermissions(PERMS[elem.ruoloLoggato.ruolo] ?? []);
        this.router.navigate(["/ricerca-impresa"]);
      }, error => {
        this.titoloErrore = "Errore";
        this.descrizioneErrore = error.title;
      });
    }
  }

  clearErrors() {
    this.titoloErrore = "";
    this.descrizioneErrore = "";
  }
}
