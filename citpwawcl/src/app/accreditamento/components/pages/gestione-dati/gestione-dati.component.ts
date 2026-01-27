import { ChangeDetectorRef, Component, OnInit, ViewChild } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Subject } from 'rxjs';
import { AuthenticationService } from 'src/app/services/authentication.service';
import { BackService } from 'src/app/services/back.service';
import { MessageService } from 'src/app/services/message.service';
import { SharedService } from 'src/app/services/shared.service';
import { SpinnerService } from 'src/app/services/spinner.service';
import { SvistaService } from 'src/app/services/svista.service';
import { TitleService } from 'src/app/services/title.service';
import { RUOLI } from 'src/app/utils/constants';
import { environment } from 'src/environments/environment';

@Component({
  selector: 'app-gestione-dati',
  templateUrl: './gestione-dati.component.html',
})
export class GestioneDatiComponent implements OnInit {

  title: string = "";
  subtitle: string = "";
  backTitile: string = "";
  route: string = "";
  titoloMessaggio: string = "";
  descrzioneMessaggio: string = "";
  tipomessaggio: number = 0;
  showMessaggio: boolean = false;
  $destroy = new Subject();
  showImpDrops: boolean = false;
  ruolo: any;

  apiUrl = environment.apiUrl;
  codiceFiscalePF;

  @ViewChild('gestioneDati') private gestioneDati: OnInit;

  constructor(
    readonly titoloService: TitleService,
    readonly backService: BackService,
    readonly messageService: MessageService,
    readonly spinnerService: SpinnerService,
    readonly sharedService: SharedService,
    readonly authService: AuthenticationService,
    private cdref: ChangeDetectorRef,
    private svistaService: SvistaService,
    router: Router,
    private aRoute: ActivatedRoute
  ) {
  }

  ngOnInit(): void {
    if (this.codiceFiscalePF == null || this.codiceFiscalePF == undefined) {
      this.init();
    }
    this.ruolo = this.authService.getCurrentUserFromSession().ruoloLoggato;
    this.titoloService.setTitle("Gestione dati accreditamento");
    this.route = "/";
    this.backTitile = "Torna alla home"
    this.backService.setBackTitle(this.backTitile);
    this.backService.setRoute("/");
    this.svistaService.saveComuniEstesiToLocalStorage();
  }

  init() {
    let utente = this.sharedService.getUtenteLoggato();
    if (utente?.ruoloLoggato.ruolo === RUOLI.RUOLO_IMPRESA) {
      this.codiceFiscalePF = utente?.ruoloLoggato.piva;
    }
    if (utente?.ruoloLoggato.ruolo == RUOLI.RUOLO_RESPONSABILE_IMPRESA) {
      this.codiceFiscalePF = utente?.ruoloLoggato.piva;
    }
    if (utente?.ruoloLoggato.ruolo == RUOLI.RUOLO_RESPONSABILE) {
      this.codiceFiscalePF = utente?.pfLoggato.codiceFiscalePF;
    }
    if (utente?.ruoloLoggato.ruolo == RUOLI.RUOLO_PROPRIETARIO_IMPRESA) {
      this.codiceFiscalePF = utente?.ruoloLoggato.piva
    }
    if (utente?.ruoloLoggato.ruolo == RUOLI.RUOLO_PROPRIETARIO) {
      this.codiceFiscalePF = utente?.pfLoggato.codiceFiscalePF;
    }
    if (utente?.ruoloLoggato.ruolo == RUOLI.RUOLO_3RESPONSABILE) {
      this.codiceFiscalePF = utente?.ruoloLoggato.piva;
    }
    if (!this.codiceFiscalePF) {
      this.codiceFiscalePF = utente?.pfLoggato.codiceFiscalePF;
    }
  }


  ngAfterContentChecked() {
    this.doChange();
  }

  doChange() {
    this.title = this.titoloService.getTitle();
    this.subtitle = this.titoloService.getsubtitle();
    this.backTitile = this.backService.getBack();
    this.route = this.backService.getRoute();
    this.titoloMessaggio = this.messageService.getTitolo();
    this.descrzioneMessaggio = this.messageService.getDescrizione();
    this.tipomessaggio = this.messageService.getType();
    this.showMessaggio = this.messageService.getShowMessaggio();
  }

  ngOnDestroy(): void {
    this.$destroy.next();
    this.sharedService.datiPrecompilati = null;
  }

  onMessage(event: any) {
    this.messageService.setTitolo(event.titolo);
    this.messageService.setDescrizione(event.descrizione);
    this.messageService.showMessaggioM();
    this.messageService.setType(event.type);
    if (event.reload !== false) {
      this.gestioneDati.ngOnInit();
    }
  }

}
