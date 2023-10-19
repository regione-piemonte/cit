import { DatePipe } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { OperazioneControlloModel } from 'src/app/models/operazione-controllo-model';
import { UtenteLoggato } from 'src/app/models/utente-loggato';
import { AuthenticationService } from 'src/app/services/authentication.service';
import { LocalStorageServiceService } from 'src/app/services/local-storage-service.service';
import { DISPLAY_FORMAT, ESITO_OPERAZIONI, ICONSURL, STATO_RAPP } from 'src/app/utils/constants';
import { environment } from 'src/environments/environment';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit {

  logo: string = ICONSURL + "logoMenu.png";
  logoblu: string = ICONSURL + "logo-blu.png";
  menu: string = ICONSURL + "menu.png";
  help: string = ICONSURL + "help.png";
  faq: string = ICONSURL + "info.png";
  ricerca: string = ICONSURL + "search.png";
  ruolo: string = ICONSURL + "user.png";
  mail: string = ICONSURL + "mail-fill.png";
  inizialiProfilo: string = "";
  ricercaImpiantiActive: boolean;
  ruoloActive: boolean;
  utente: UtenteLoggato;
  operazioni: OperazioneControlloModel[] = [];
  esitoOperazioni = ESITO_OPERAZIONI;


  constructor(private router: Router, private authService: AuthenticationService, private readonly localStorageService: LocalStorageServiceService, private datepipe: DatePipe) {
    this.ricercaImpiantiActive = false;
    this.ruoloActive = false;
  }

  ngOnInit(): void {
    this.operazioni = [];
    this.utente = this.authService.getCurrentUserFromSession();
    this.inizialiProfilo = this.utente.pfLoggato.cognomePF.charAt(0) + this.utente.pfLoggato.nomePF.charAt(0);
    this.operazioni = this.localStorageService.getOperazioni();
    this.localStorageService.subjectOperazioni.subscribe((elem: OperazioneControlloModel[]) => {
      if (elem)
        this.operazioni = elem;
    });
  }

  navigateRicercaImpianti() {
    this.router.navigate(["/impianto/ricerca-impianti"]);
  }


  logout() {
    this.authService.localLogout().subscribe(() => {
      this.authService.ssoLogout();
    });
  }

  removeItem(operazione: OperazioneControlloModel) {
    const index = this.operazioni.indexOf(operazione, 0);
    let idAllegatoOperazione = this.operazioni[index].idOperazione;
    if (index > -1) {
      this.operazioni.splice(index, 1);
    }
    this.localStorageService.setOperazioni(this.operazioni);
    if (operazione.esito == ESITO_OPERAZIONI.PENDING) {
      let controllo = this.localStorageService.getBozzaLocaleByTempId(idAllegatoOperazione, operazione.codiceImpianto);
      controllo.controlloModel.fkStatoRapp = controllo.fkStatoPrec;
      if (controllo.fkStatoPrec === STATO_RAPP.BOZZA_LOCALE) {
        this.localStorageService.updateBozzaLocale(controllo, controllo.tempIdControllo, operazione.codiceImpianto);
      } else {
        this.localStorageService.delBozzaLocale(controllo.tempIdControllo, operazione.codiceImpianto);
      }
      this.localStorageService.subjectControllo.next(this.localStorageService.getControllo());
    }
  }

  openAssistenza() {
    window.open("https://www.servizi.piemonte.it/assistenza/spcatserv/?codice_applicativo=CFI3992", "_blank");
  }

  openManuale() {
    window.open("https://servizi.regione.piemonte.it/media/2015/download", "_blank");
  }

  openFaq() {
    window.open("https://servizi.regione.piemonte.it/catalogo/catasto-impianti-termici", "_blank");
  }

  openNotifiche() {
    window.open(environment.urlNotifiche, "_blank");
  }

  getDate(data: string) {
    if (data)
      return this.datepipe.transform(data, DISPLAY_FORMAT);
    else
      return "-";
  }
}
