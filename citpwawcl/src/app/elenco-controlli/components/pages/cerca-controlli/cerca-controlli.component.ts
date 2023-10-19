import { DatePipe } from '@angular/common';
import { Component, OnDestroy, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { TipoDoc } from 'src/app/enums/tipo-doc-enum';
import { CodiceDescrizione } from 'src/app/models/codice-descrizione';
import { ControlloDisponibileModel } from 'src/app/models/controllo-disponibile';
import { DatiCGModel } from 'src/app/models/dati-cg-model';
import { DatiControlloModel } from 'src/app/models/dati-controllo-model';
import { DatiGFModel } from 'src/app/models/dati-gf.-model';
import { DatiGTModel } from 'src/app/models/dati-gt-model';
import { DatiSCModel } from 'src/app/models/dati-sc-model';
import { Esito } from 'src/app/models/esito';
import { OnlineCheckModel } from 'src/app/models/online-check-model';
import { UtenteLoggato } from 'src/app/models/utente-loggato';
import { AuthenticationService } from 'src/app/services/authentication.service';
import { BackService } from 'src/app/services/back.service';
import { ControlloService } from 'src/app/services/controllo.service';
import { LocalStorageServiceService } from 'src/app/services/local-storage-service.service';
import { MessageService } from 'src/app/services/message.service';
import { ResultService } from 'src/app/services/result.service';
import { TitleService } from 'src/app/services/title.service';
import { FORMAT, TIPI_COMP } from 'src/app/utils/constants';

@Component({
  selector: 'app-cerca-controlli',
  templateUrl: './cerca-controlli.component.html',
  styleUrls: ['./cerca-controlli.component.scss']
})
export class CercaControlliComponent implements OnInit, OnDestroy {

  offline = false;
  codiceImpianto: string;
  utente: UtenteLoggato;

  searchForm: FormGroup;
  tipiControllo: CodiceDescrizione[] = [];
  tipiComponente: CodiceDescrizione[] = [];

  risultato: ControlloDisponibileModel[] = undefined;

  isSearchOk = false;

  constructor(
    private route: ActivatedRoute,
    private fb: FormBuilder,
    private readonly controlloService: ControlloService,
    private authenticationService: AuthenticationService,
    private datePipe: DatePipe,
    private readonly backService: BackService,
    private readonly messageService: MessageService,
    private readonly titleService: TitleService,
    private readonly resultService: ResultService,
    private readonly localStorageService: LocalStorageServiceService) {
    this.codiceImpianto = this.route.snapshot.parent.paramMap.get('id_impianto');
    this.utente = authenticationService.getCurrentUserFromSession();
  }

  ngOnInit(): void {
    this.risultato = undefined;

    this.controlloService.getOnlineSubject().subscribe((elem) => {
      this.offline = !elem;
    });
    this.titleService.setTitle("Aggiungi controllo");
    this.backService.setBackTitle("Torna ad elenco controlli");
    this.backService.setRoute('impianto/dettaglio/' + this.codiceImpianto + '/elenco-controlli');
    this.searchForm = this.fb.group({
      dataControllo: ["", [Validators.required]],
      tipoControllo: ["", [Validators.required]],
      tipoComponente: ["", [Validators.required]]
    });

    this.tipiComponente = [new CodiceDescrizione("GT", "Gruppo Termico"),
    new CodiceDescrizione("GF", "Gruppo Frigo"),
    new CodiceDescrizione("SC", "Scambiatore"),
    new CodiceDescrizione("CG", "Cogeneratore")];

    this.tipiControllo = [new CodiceDescrizione("1", "Manutenzione"),
    new CodiceDescrizione("2", "Rapporto di Efficienza Energetica")];
  }


  ngOnDestroy(): void {
  }

  myFilter = (d: Date | null): boolean => {
    return d < new Date();
  };


  cercaControlli() {
    let dataControllo = this.datePipe.transform(this.searchForm.value.dataControllo, FORMAT);
    let tipoComponente = this.searchForm.value.tipoComponente;
    let tipoControllo = this.searchForm.value.tipoControllo;
    this.controlloService.getControlliDisponibili(this.codiceImpianto,
      tipoComponente, tipoControllo, dataControllo).subscribe((elem: ControlloDisponibileModel[]) => {
        this.risultato = elem;
      }, error => {
        if (error instanceof OnlineCheckModel) {
          this.cercaControlliOffline();
        } else {
          let errore = error.error as Esito;
          this.messageService.setTitolo("Errore ricerca controlli disponibili");
          this.messageService.setDescrizione(errore.descrizioneEsito);
          this.messageService.showMessaggioM();
          this.messageService.setType(2);
        }
      });
  }

  closeSearch(result) {
    this.risultato = undefined;
  }

  cercaControlliOffline() {
    let dataControllo = this.datePipe.transform(this.searchForm.value.dataControllo, FORMAT);
    let tipoComponente = this.searchForm.value.tipoComponente;
    let tipoControllo = this.searchForm.value.tipoControllo;
    let controlliDisponibili: ControlloDisponibileModel[] = [];
    let datiControllo: DatiControlloModel = this.localStorageService.getControllo();
    let componenti = undefined;
    switch (tipoComponente) {
      case TIPI_COMP.GT:
        componenti = datiControllo.datiGT;
        if (componenti) {
          componenti.forEach((elem: DatiGTModel) => {
            if (!elem.dataDismiss || new Date(elem.dataDismiss) > new Date(dataControllo)) {
              let controlloDisponibile = new ControlloDisponibileModel();
              controlloDisponibile.dataControllo = dataControllo;
              controlloDisponibile.nomeComponente = elem.idTipoComponente + "-" + elem.progressivo;
              controlloDisponibile.tipoComponente = elem.idTipoComponente;
              controlloDisponibile.progressivo = elem.progressivo;
              controlloDisponibile.nModuli = elem.nModuli ? elem.nModuli : 1;
              controlloDisponibile.dataInstall = elem.dataInstall;
              controlloDisponibile.descMarca = elem.descMarca;
              controlloDisponibile.modello = elem.modello;
              controlloDisponibile.matricola = elem.matricola;
              controlloDisponibile.potTermica = elem.potenzaTermicaKw ? elem.potenzaTermicaKw.toLocaleString() : "";
              controlloDisponibile.descDettaglio = elem.descDettaglioGt;
              controlloDisponibile.descCombustibile = elem.descCombustibile;
              controlloDisponibile.cfPIvaImpresa = elem.cf;
              controlloDisponibile.siglaReaImpresa = elem.siglaRea;
              controlloDisponibile.numeroReaImpresa = elem.numeroRea;

              if (tipoControllo == "1") {
                controlloDisponibile.tipoControllo = TipoDoc.MANUT_GT;
              } else {
                controlloDisponibile.tipoControllo = TipoDoc.REE_1;
                let controlloDisponibileb = new ControlloDisponibileModel();
                controlloDisponibileb.dataControllo = dataControllo;
                controlloDisponibileb.nomeComponente = elem.idTipoComponente + "-" + elem.progressivo;
                controlloDisponibileb.progressivo = elem.progressivo;
                controlloDisponibileb.tipoComponente = elem.idTipoComponente;
                controlloDisponibileb.tipoControllo = TipoDoc.REE_1B;
                controlloDisponibileb.nModuli = elem.nModuli ? elem.nModuli : 1;
                controlloDisponibileb.dataInstall = elem.dataInstall;
                controlloDisponibileb.descMarca = elem.descMarca;
                controlloDisponibileb.modello = elem.modello;
                controlloDisponibileb.matricola = elem.matricola;
                controlloDisponibileb.descDettaglio = elem.descDettaglioGt;
                controlloDisponibileb.descCombustibile = elem.descCombustibile;
                controlloDisponibileb.potTermica = elem.potenzaTermicaKw ? elem.potenzaTermicaKw.toLocaleString() : "";
                controlloDisponibileb.cfPIvaImpresa = elem.cf;
                controlloDisponibileb.siglaReaImpresa = elem.siglaRea;
                controlloDisponibileb.numeroReaImpresa = elem.numeroRea;

                controlliDisponibili.push(controlloDisponibileb);
              }
              controlliDisponibili.push(controlloDisponibile);
            }
          });
        }
        break;
      case TIPI_COMP.GF:
        componenti = datiControllo.datiGF;
        if (componenti) {
          componenti.forEach((elem: DatiGFModel) => {
            if (!elem.dataDismiss || new Date(elem.dataDismiss) > new Date(dataControllo)) {
              let controlloDisponibile = new ControlloDisponibileModel();
              controlloDisponibile.dataControllo = dataControllo;
              controlloDisponibile.nomeComponente = elem.idTipoComponente + "-" + elem.progressivo;
              controlloDisponibile.tipoComponente = elem.idTipoComponente;
              controlloDisponibile.progressivo = elem.progressivo;
              controlloDisponibile.nModuli = elem.nCircuiti ? elem.nCircuiti : 1;

              controlloDisponibile.dataInstall = elem.dataInstall;
              controlloDisponibile.descMarca = elem.desMarca;
              controlloDisponibile.modello = elem.modello;
              controlloDisponibile.matricola = elem.matricola;
              controlloDisponibile.potTermica = elem.potenzaTermicaKw ? elem.potenzaTermicaKw.toLocaleString() : "";

              controlloDisponibile.descDettaglio = elem.desDettaglioGf;
              controlloDisponibile.potTermicaRaff = elem.raffPotenzaKw;
              controlloDisponibile.potTermicaRisc = elem.riscPotenzaKw;
              controlloDisponibile.cfPIvaImpresa = elem.cf;
              controlloDisponibile.siglaReaImpresa = elem.siglaRea;
              controlloDisponibile.numeroReaImpresa = elem.numeroRea;


              if (tipoControllo == "1")
                controlloDisponibile.tipoControllo = TipoDoc.MANUT_GF;
              else
                controlloDisponibile.tipoControllo = TipoDoc.REE_2;
              controlliDisponibili.push(controlloDisponibile);
            }
          });
        }
        break;
      case TIPI_COMP.SC:
        componenti = datiControllo.datiSC;
        if (componenti) {
          componenti.forEach((elem: DatiSCModel) => {
            if (!elem.dataDismiss || new Date(elem.dataDismiss) > new Date(dataControllo)) {
              let controlloDisponibile = new ControlloDisponibileModel();
              controlloDisponibile.dataControllo = dataControllo;
              controlloDisponibile.nomeComponente = elem.idTipoComponente + "-" + elem.progressivo;
              controlloDisponibile.tipoComponente = elem.idTipoComponente;
              controlloDisponibile.progressivo = elem.progressivo;

              controlloDisponibile.dataInstall = elem.dataInstall;
              controlloDisponibile.descMarca = elem.descMarca;
              controlloDisponibile.modello = elem.modello;
              controlloDisponibile.matricola = elem.matricola;
              controlloDisponibile.potTermica = elem.potenzaTermicaKw ? elem.potenzaTermicaKw.toLocaleString() : "";
              controlloDisponibile.cfPIvaImpresa = elem.cf;
              controlloDisponibile.siglaReaImpresa = elem.siglaRea;
              controlloDisponibile.numeroReaImpresa = elem.numeroRea;


              if (tipoControllo == "1")
                controlloDisponibile.tipoControllo = TipoDoc.MANUT_SC;
              else
                controlloDisponibile.tipoControllo = TipoDoc.REE_3;
              controlliDisponibili.push(controlloDisponibile);
            }
          });
        }
        break;
      case TIPI_COMP.CG:
        componenti = datiControllo.datiCG;
        if (componenti) {
          componenti.forEach((elem: DatiCGModel) => {
            if (!elem.dataDismiss || new Date(elem.dataDismiss) > new Date(dataControllo)) {
              let controlloDisponibile = new ControlloDisponibileModel();
              controlloDisponibile.dataControllo = dataControllo;
              controlloDisponibile.nomeComponente = elem.idTipoComponente + "-" + elem.progressivo;
              controlloDisponibile.tipoComponente = elem.idTipoComponente;
              controlloDisponibile.progressivo = elem.progressivo;

              controlloDisponibile.dataInstall = elem.dataInstall;
              controlloDisponibile.descMarca = elem.descMarca;
              controlloDisponibile.modello = elem.modello;
              controlloDisponibile.matricola = elem.matricola;
              controlloDisponibile.potTermica = elem.potenzaTermicaKw ? elem.potenzaTermicaKw.toLocaleString() : "";

              controlloDisponibile.coMin = elem.coMin;
              controlloDisponibile.coMax = elem.coMax;
              controlloDisponibile.alimentazione = elem.alimentazione;
              controlloDisponibile.descDettaglio = elem.tipologia;
              controlloDisponibile.cfPIvaImpresa = elem.cf;
              controlloDisponibile.siglaReaImpresa = elem.siglaRea;
              controlloDisponibile.numeroReaImpresa = elem.numeroRea;


              if (tipoControllo == "1")
                controlloDisponibile.tipoControllo = TipoDoc.MANUT_CG;
              else
                controlloDisponibile.tipoControllo = TipoDoc.REE_4;
              controlliDisponibili.push(controlloDisponibile);
            }
          });
        }
        break;
    }
    this.risultato = controlliDisponibili;
  }

  nuovaRicerca() {
    this.risultato = undefined;
  }

}
