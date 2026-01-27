import { Component, HostListener, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Esito } from 'src/app/models/esito';
import { AuthenticationService } from 'src/app/services/authentication.service';
import { BackService } from 'src/app/services/back.service';
import { LibrettoService } from 'src/app/services/libretto.service';
import { MessageService } from 'src/app/services/message.service';
import { SharedService } from 'src/app/services/shared.service';
import { SpinnerService } from 'src/app/services/spinner.service';
import { TitleService } from 'src/app/services/title.service';
import { RUOLI } from 'src/app/utils/constants';
import { doDownloadFile } from 'src/app/utils/utils';

const SCHEDE_WIDTH_REM = 222;

@Component({
  selector: 'app-lista-scheda-libretto',
  templateUrl: './lista-scheda-libretto.component.html',
  styleUrls: ['./lista-scheda-libretto.component.scss']
})
export class ListaSchedaLibrettoComponent implements OnInit {

  cardWidth: number = 95;

  schede: any[] = [];
  pathPdf: string = 'assets/misc/acrobat.svg';
  heightBreakpoint: number;
  witdhBreakpoint: number;
  consolidaLibrettoEnabled: boolean = true;

  constructor(
    private titleService: TitleService,
    private messageService: MessageService,
    private backService: BackService,
    private router: Router,
    private route: ActivatedRoute,
    private sharedService: SharedService,
    private librettoService: LibrettoService,
    private spinnerService: SpinnerService,
    private authService: AuthenticationService
  ) {
    let utenteLoggato = this.authService.getCurrentUserFromSession();
    if (utenteLoggato.ruoloLoggato.ruolo === RUOLI.RUOLO_CONSULTATORE ||
      utenteLoggato.ruoloLoggato.ruolo === RUOLI.RUOLO_PROPRIETARIO ||
      utenteLoggato.ruoloLoggato.ruolo === RUOLI.RUOLO_PROPRIETARIO_IMPRESA ||
      utenteLoggato.ruoloLoggato.ruolo === RUOLI.RUOLO_RESPONSABILE ||
      utenteLoggato.ruoloLoggato.ruolo === RUOLI.RUOLO_RESPONSABILE_IMPRESA
    ) {
      this.consolidaLibrettoEnabled = false;
    }

  }

  ngOnInit(): void {
    this.changeStyle(window.innerWidth);
    this.titleService.setTitle("Dettaglio impianti termici");
    this.backService.setBackTitle("Torna al dettaglio dell'impianto");
    const urlOriginal = this.router.url;
    const redirectUrl = urlOriginal.substring(0, urlOriginal.lastIndexOf('/'));
    this.backService.setRoute(redirectUrl);
    this.sharedService.forceChangeContent.next();
    //TODO Ripristinare la condizione a i < 15
    for (let i = 0; i < 1; i++) {
      this.schede.push({ text: "Scheda " + (i + 1), isOpen: false, sub: this.createElementSubScheda(i) });
    }
    this.schede.push({ text: "Scheda 2", isOpen: false, sub: this.createElementSubScheda(1) });

    //aggiungo scheda libretto 3 fuori perche manca la 2
    this.schede.push({ text: "Scheda 3", isOpen: false, sub: this.createElementSubScheda(2) });
    //workaround per il problema di scroll verticale
    window.scrollTo(0, 0);
  }

  @HostListener('window:resize', ['$event'])
  onResize(event?) {
    this.changeStyle(event.target.innerWidth);
  }

  changeStyle(width) {
    this.heightBreakpoint = (width < 768) ? 800 : 460;
    this.witdhBreakpoint = (width < 768) ? 95 : 84;
    // this.cardWidth = (width < 768) ? 92: 92;
  }

  private createElementSubScheda(index: number) {
    const nScheda = (index + 1);
    const getReturnListSub = (useNumber: boolean, event: string, text: string) => {
      return { event: event + nScheda, text: useNumber ? (nScheda + text) : text };
    }
    /*
      ELENCO TIPI EVENTO:
        - R = Reindirizzamento
    */
    switch (index) {
      case 0: return [getReturnListSub(true, 'R=>../scheda/', ". Scheda Identificativa Impianto")];
      case 1: return [getReturnListSub(true, 'R=>../scheda/', ". Trattamento acqua")];
      case 2: return [getReturnListSub(true, 'R=>../scheda/', ". Nomina terzo responsabile impianto termico")];
      case 3: return [
        getReturnListSub(true, 'M017 ELENCO COMPONENTI', ".1 Gruppi termici o caldaie (GT)"),
        getReturnListSub(true, 'NIENTE', ".2 Bruciatori (BR)"),
        getReturnListSub(true, 'NIENTE', ".3 Recuperatori / Condensatori lato fumi (RC)"),
        getReturnListSub(true, 'M017 ELENCO COMPONENTI', ".4 Macchine frigorifere/ Pompe di calore (GF)"),
        getReturnListSub(true, 'M017 ELENCO COMPONENTI', ".5 Scambiatori di calore (SC)"),
        getReturnListSub(true, 'M017 ELENCO COMPONENTI', ".6 Cogeneratori / Trigeneratori (CG)"),
        getReturnListSub(true, 'NIENTE', ".7 Campi solari termici (CS)"),
        getReturnListSub(true, 'NIENTE', ".8 Altri generatori (AG)")
      ];
      case 4: return [
        getReturnListSub(true, 'NIENTE', ".1 Sistemi di regolazione (SR)"),
        getReturnListSub(true, 'NIENTE', ".1 Valvole di regolazione (VR)"),
        getReturnListSub(true, 'NIENTE', ". Sistemi di regolazione e contabilizzazione")
      ];
      case 5: return [
        getReturnListSub(true, 'NIENTE', ". Sistemi di distribuzione"),
        getReturnListSub(true, 'NIENTE', ".4 Pompe di circolazione (se non incorporate nel generatore) (PO)")
      ];
      case 6: return [getReturnListSub(true, 'NIENTE', ". Sistema di emissione")];
      case 7: return [getReturnListSub(true, 'NIENTE', ".1 Sistema di accumulo (AC)")];
      case 8: return [
        getReturnListSub(true, 'NIENTE', ".1 Torri evaporative (TE)"),
        getReturnListSub(true, 'NIENTE', ".2 Raffreddatori di liquido (RV)"),
        getReturnListSub(true, 'NIENTE', ".3 Scambiatori di calore intermedi (SCX)"),
        getReturnListSub(true, 'NIENTE', ".4 Circuiti interrati a condensazione / espansione diretta (CI)"),
        getReturnListSub(true, 'NIENTE', ".5 Unità di trattamento aria (UT)"),
        getReturnListSub(true, 'NIENTE', ".6 Recuperatori di calore (aria ambiente) (RC)")
      ];
      case 9: return [getReturnListSub(true, 'NIENTE', ".1 Impianto di ventilazione controllata (VM)")];
      default: return null;
    }
  }

  doEvent(event: string) {
    const split = event.split("=>");

    if (split[0] === 'R') {
      this.router.navigate([split[1]], { relativeTo: this.route });
    }
  }

  async scaricaLibretto(type: number) {
    this.spinnerService.show();
    let obs, obsExt = this.librettoService.getLibrettoDtoByCodice();
    let needDetails = true;
    let isPdf = true;
    switch (type) {
      case 1:
        obs = this.librettoService.getLibrettoByCodice();
        break;
      case 2:
        obs = this.librettoService.getXMLLibrettoConsolidatoJWT();
        isPdf = false;
        break;
      case 3:
        obs = this.librettoService.getLibrettoNowJWT();
        needDetails = false;
        break;
    }
    let libretto;
    if (needDetails) {
      try {
        libretto = await obsExt.toPromise();
      } catch (e) {
        this.messageService.setTitolo("Errore recupero libretto");
        this.messageService.setDescrizione("Impossibile procedere perché non esiste un libretto consolidato negli ultimi 5 anni");
        this.messageService.showMessaggioM();
        this.messageService.setType(2);
        return;
      }
    }
    obs.subscribe(res => {
      let nomeFile;
      let mimeType = isPdf ? 'application/pdf' : 'application/xml';
      if (!!libretto) {
        const { fileIndex } = libretto
        nomeFile = isPdf ? fileIndex : fileIndex.replace(".pdf", ".xml");
      } else {
        nomeFile = 'Libretto_IText.pdf';
      }
      doDownloadFile(res, nomeFile, mimeType);
      this.spinnerService.hide();
    });
  }

  verificaLibretto() {
    this.doError("DA FINIRE VERIFICA LIBRETTO");
  }

  consolidaLibretto() {
    this.librettoService.consolidaLibretto().subscribe(res => {
      this.messageService.setTitolo("Successo");
      this.messageService.setDescrizione("Impianto consolidato con successo");
      this.messageService.showMessaggioM();
      this.messageService.setType(4);
    }, error => {
      this.messageService.setTitolo("Errore Consolidamento libretto");
      let esito = error.error as Esito;
      this.messageService.setDescrizione(esito.descrizioneEsito);
      this.messageService.showMessaggioM();
      this.messageService.setType(2);
    });
  }

  doError(message) {
    alert(message);
    throw new Error(message);
  }

}
