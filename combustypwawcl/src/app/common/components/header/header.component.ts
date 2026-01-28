import { Component, HostListener, OnInit, ViewChild } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { MatSidenav } from '@angular/material/sidenav';
import { NavigationEnd, Router } from '@angular/router';
import { NgxPermissionsService } from 'ngx-permissions';
import { filter } from 'rxjs/operators';
import { UtenteLoggato } from 'src/app/models/utente-loggato';
import { AuthenticationService } from 'src/app/services/authentication.service';
import { ICONSURL } from 'src/app/utils/constants';


@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit {

  logo_blu: string = ICONSURL + "logo_blu.png";
  elenco_dati_inviati: string = ICONSURL + "elenco_dati_inviati.png";
  cerca_imprese: string = ICONSURL + "cerca_imprese.svg";
  caricamento_manuale_semplificato: string = ICONSURL + "caricamento_manuale_semplificato.svg";
  importazione_file_XML: string = ICONSURL + "importazione_file_XML.svg";
  logo_menu: string = ICONSURL +  "logo_menu.png";
  ruolo_blu: string = ICONSURL + "ruolo_blu.svg";
  ruolo_bianco: string = ICONSURL + "ruolo_blu.svg";

  currentUrl: string = "";
  utente: UtenteLoggato;
  inizialiProfilo: string = "";
  isDisponibilitaServizio: boolean;

  constructor(private router: Router, private authService: AuthenticationService,private dialog: MatDialog, private permissions: NgxPermissionsService) { }

  ngOnInit(): void {
    this.isDisponibilitaServizio = true;
    
    this.router.events.pipe(
      filter(event => event instanceof NavigationEnd)
    ).subscribe((event: NavigationEnd) => {
      this.currentUrl = event.urlAfterRedirects;
    });

    this.currentUrl = this.router.url;
    this.utente = this.authService.getCurrentUserFromSession();
    this.inizialiProfilo = this.utente.pfLoggato.cognomePF.charAt(0) + this.utente.pfLoggato.nomePF.charAt(0);
  }

  isPaginaImpresa(): boolean {
    return this.currentUrl?.includes('ricerca-impresa') || this.currentUrl?.includes('risultato-ricerca-impresa');
  }

  navigateElencoDatiInviati(sidenav : any) {
    this.router.navigate(["/elenco-dati-inviati"]).then(() => sidenav.close());

  }

  navigateImportazioneFileXML(sidenav : any) {
    this.router.navigate(["/importazione-xml"]).then(() => sidenav.close());
  }
  
  navigateCaricamentoManuale(sidenav : any) {
    this.router.navigate(["/cerca-dati-fornitura"]).then(() => sidenav.close());
  }
    
  navigateCercaImprese(sidenav : any) {
    this.router.navigate(["/ricerca-impresa"]).then(() => sidenav.close());
  }

  openAssistenza() {
    window.open("https://servizi.piemonte.it/assistenza/spcatserv/?codice_applicativo=CFI1669", "_blank");
  }

  openManuale() {
    window.open("https://servizi.regione.piemonte.it/media/3090/download", "_blank");
  }

  openFaq() {
    window.open("https://servizi.regione.piemonte.it/catalogo/catasto-impianti-termici", "_blank");
  }

  logout() {
    //this.authService.localLogout().subscribe(() => {
        this.authService.ssoLogout();
    //});
  }

  isDisponibilitaServizioPage(): boolean {
    return this.router.url.includes('disponibilita-servizio');
  }
}
