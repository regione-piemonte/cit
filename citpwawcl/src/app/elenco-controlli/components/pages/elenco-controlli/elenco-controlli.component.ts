import { DatePipe } from '@angular/common';
import { Component, OnDestroy, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { MatDialog } from '@angular/material/dialog';
import { ActivatedRoute, Router } from '@angular/router';
import { DeleteDialogComponent } from 'src/app/common/components/delete-dialog/delete-dialog.component';
import { TipoDoc } from 'src/app/enums/tipo-doc-enum';
import { ControlloModel } from 'src/app/models/controllo-model';
import { DatiControlloModel } from 'src/app/models/dati-controllo-model';
import { DatoControlloModel } from 'src/app/models/dato-controllo-model';
import { Esito } from 'src/app/models/esito';
import { OnlineCheckModel } from 'src/app/models/online-check-model';
import { OperazioneControlloModel } from 'src/app/models/operazione-controllo-model';
import { PdfControllo } from 'src/app/models/pdf-controllo';
import { UtenteLoggato } from 'src/app/models/utente-loggato';
import { AuthenticationService } from 'src/app/services/authentication.service';
import { BackService } from 'src/app/services/back.service';
import { ControlloService } from 'src/app/services/controllo.service';
import { LocalStorageServiceService } from 'src/app/services/local-storage-service.service';
import { MessageService } from 'src/app/services/message.service';
import { ResultService } from 'src/app/services/result.service';
import { SyncServiceService } from 'src/app/services/sync-service.service';
import { TitleService } from 'src/app/services/title.service';
import { DISPLAY_FORMAT, ESITO_OPERAZIONI, FORMAT, OPERAZIONI, ORDINAMENTO, RUOLI, STATO_RAPP } from 'src/app/utils/constants';
import { doDownloadFile } from 'src/app/utils/utils';
import { v4 as uuidv4 } from 'uuid';
import { UploadFileDialogComponent } from '../../upload-file-dialog/upload-file-dialog.component';

@Component({
  selector: 'app-elenco-controlli',
  templateUrl: './elenco-controlli.component.html',
  styleUrls: ['./elenco-controlli.component.scss']
})
export class ElencoControlliComponent implements OnInit, OnDestroy {
  success = false;
  offline = false;
  filterForm: FormGroup;

  codiceImpianto: string = "";

  controlli: DatoControlloModel[];

  ordinamento = ORDINAMENTO;
  statoRapp = STATO_RAPP;
  tipiDoc = TipoDoc;
  pdf: string = 'assets/misc/acrobat.svg';

  utente: UtenteLoggato;

  constructor(
    private route: ActivatedRoute,
    private fb: FormBuilder,
    private readonly controlloService: ControlloService,
    private authenticationService: AuthenticationService,
    private router: Router,
    private readonly backService: BackService,
    private readonly messageService: MessageService,
    private readonly titleService: TitleService,
    public datepipe: DatePipe,
    private readonly localStorageService: LocalStorageServiceService,
    private readonly resultService: ResultService,
    private readonly syncService: SyncServiceService,
    public dialog: MatDialog) {
    this.codiceImpianto = this.route.snapshot.parent.paramMap.get('id_impianto');
    this.utente = authenticationService.getCurrentUserFromSession();
    this.filterForm = this.fb.group({
      filtro: ["", [
      ]]
    });
  }

  ngOnInit(): void {
    this.controlloService.getOnlineSubject().subscribe((elem) => {
      this.offline = !elem;
    });

    this.localStorageService.subjectControllo.subscribe((elem: DatiControlloModel) => {
      if (elem)
        this.sortControlli();
    });

    this.syncService.syncSubject.subscribe((elem) => {
      if (elem)
        this.sortControlli();
    });

    this.titleService.setTitle("Elenco controlli");
    this.backService.setBackTitle("Torna al dettaglio");
    this.backService.setRoute('impianto/dettaglio-impianto/' + this.codiceImpianto);
    this.messageService.showMessaggioM();

    this.filterForm.controls["filtro"].setValue(ORDINAMENTO.STATO_DEL_CONTROLLO);

    this.sortControlli();

    this.success = !!this.route.snapshot.paramMap.get('success');
    if (this.success) {
      this.messageService.setTitolo("Successo");
      this.messageService.setDescrizione("Operazione avvenuta con successo");
      this.messageService.showMessaggioM();
      this.messageService.setType(4);
      this.success = false;
    }
  }

  ngOnDestroy(): void {
    //Not Implemented
  }

  sortControlli() {
    this.controlli = [];
    this.controlloService.getControlliOrdinati(this.codiceImpianto, ORDINAMENTO.DATA_CONTROLLO_PIU_RECENTE).subscribe((elem: DatiControlloModel) => {
      this.localStorageService.setDatiControllo(elem);
      this.controlli = elem.controlli ? elem.controlli : [];
      this.controlli.forEach((dato: DatoControlloModel, index: number) => {
        let bozza = this.localStorageService.getBozzaLocaleByIdAllegato(dato.controlloModel.idAllegato, this.codiceImpianto);
        if (bozza) {
          this.controlli[index] = bozza;
        }
      });
      let bozzeNew = this.localStorageService.getNewBozzeLocali(this.codiceImpianto);
      if (!elem.controlli) {
        elem.controlli = [];
      }
      this.controlli = elem.controlli.concat(bozzeNew);
      this.sortOffline();
    }, (error) => {
      if (error instanceof OnlineCheckModel) {
        let elem = this.localStorageService.getControllo();
        if (elem && elem.controlli) {
          elem.controlli.forEach((dato: DatoControlloModel, index: number) => {
            let bozza = this.localStorageService.getBozzaLocaleByIdAllegato(dato.controlloModel.idAllegato, this.codiceImpianto);
            if (bozza) {
              elem.controlli[index] = bozza;
            }
          });
        }
        let bozzeNew = this.localStorageService.getNewBozzeLocali(this.codiceImpianto);
        if (!elem.controlli) {
          elem.controlli = [];
        }
        elem.controlli = elem.controlli.concat(bozzeNew);
        this.controlli = elem.controlli;
        this.sortOffline();
      } else {
        this.messageService.setTitolo("Errore recupero dati dal server");
        this.messageService.setDescrizione("Impossibile recuperare i controlli disponibili");
        this.messageService.showMessaggioM();
        this.messageService.setType(2);
      }
    });
  }

  sortOffline() {
    switch (this.filterForm.controls["filtro"].value) {
      case ORDINAMENTO.STATO_DEL_CONTROLLO:
        this.controlli.sort((a, b) => a.controlloModel.fkStatoRapp < b.controlloModel.fkStatoRapp ? -1 : 1);
        break;
      case ORDINAMENTO.DATA_CONTROLLO_MENO_RECENTE:
        this.controlli.sort((a, b) => a.controlloModel.dataControllo < b.controlloModel.dataControllo ? -1 : 1);
        break;
      case ORDINAMENTO.DATA_CONTROLLO_PIU_RECENTE:
        this.controlli.sort((a, b) => a.controlloModel.dataControllo < b.controlloModel.dataControllo ? 1 : -1);
        break;
      case ORDINAMENTO.TIPOLOGIA_DI_CONTROLLO:
        this.controlli.sort((a, b) => a.controlloModel.fkTipoDocumento < b.controlloModel.fkTipoDocumento ? -1 : 1);
        break;
    }
  }

  isCaricaReeVisibile(elem: ControlloModel) {
    let result = true;
    result = result && (elem.fkStatoRapp == STATO_RAPP.INVIATO);
    if (this.utente.ruoloLoggato.ruolo === RUOLI.RUOLO_IMPRESA) {
      result = result && (elem.idPersonaGiuridica === this.utente.ruoloLoggato.idPersonaGiuridica);
    } else {
      result = result &&
        (this.utente.ruoloLoggato.ruolo === RUOLI.RUOLO_PROPRIETARIO
          || this.utente.ruoloLoggato.ruolo === RUOLI.RUOLO_SUPER
          || this.utente.ruoloLoggato.ruolo === RUOLI.RUOLO_ISPETTORE
          || this.utente.ruoloLoggato.ruolo === RUOLI.RUOLO_CONSULTATORE
          || this.utente.ruoloLoggato.ruolo === RUOLI.RUOLO_VALIDATORE);
    }
    result = result && !(elem.fkTipoDocumento.toLocaleString() === TipoDoc.MANUT_CG
      || elem.fkTipoDocumento.toLocaleString() === TipoDoc.MANUT_GT
      || elem.fkTipoDocumento.toLocaleString() === TipoDoc.MANUT_GF
      || elem.fkTipoDocumento.toLocaleString() === TipoDoc.MANUT_SC);
    return result;
  }

  isRiepilogFirmatoVisibile(elem: ControlloModel) {
    let result = true;
    result = result && (elem.fkStatoRapp == STATO_RAPP.INVIATO);
    if (this.utente.ruoloLoggato.ruolo === RUOLI.RUOLO_IMPRESA) {
      result = result && (elem.idPersonaGiuridica === this.utente.ruoloLoggato.idPersonaGiuridica);
    } else {
      result = result &&
        (this.utente.ruoloLoggato.ruolo === RUOLI.RUOLO_PROPRIETARIO
          || this.utente.ruoloLoggato.ruolo === RUOLI.RUOLO_SUPER
          || this.utente.ruoloLoggato.ruolo === RUOLI.RUOLO_ISPETTORE
          || this.utente.ruoloLoggato.ruolo === RUOLI.RUOLO_CONSULTATORE
          || this.utente.ruoloLoggato.ruolo === RUOLI.RUOLO_VALIDATORE);
    }
    result = result && !(elem.fkTipoDocumento.toLocaleString() === TipoDoc.MANUT_CG
      || elem.fkTipoDocumento.toLocaleString() === TipoDoc.MANUT_GT
      || elem.fkTipoDocumento.toLocaleString() === TipoDoc.MANUT_GF
      || elem.fkTipoDocumento.toLocaleString() === TipoDoc.MANUT_SC);
    return result;
  }

  isRepilogoVisibile(elem: ControlloModel) {
    let result = true;
    result = result && (elem.fkStatoRapp == STATO_RAPP.INVIATO);
    if (this.utente.ruoloLoggato.ruolo === RUOLI.RUOLO_IMPRESA) {
      result = result && (elem.idPersonaGiuridica === this.utente.ruoloLoggato.idPersonaGiuridica);
    } else {
      result = result &&
        (this.utente.ruoloLoggato.ruolo === RUOLI.RUOLO_PROPRIETARIO
          || this.utente.ruoloLoggato.ruolo === RUOLI.RUOLO_SUPER
          || this.utente.ruoloLoggato.ruolo === RUOLI.RUOLO_ISPETTORE
          || this.utente.ruoloLoggato.ruolo === RUOLI.RUOLO_CONSULTATORE
          || this.utente.ruoloLoggato.ruolo === RUOLI.RUOLO_VALIDATORE);
    }
    result = result && !(elem.fkTipoDocumento.toLocaleString() === TipoDoc.MANUT_CG
      || elem.fkTipoDocumento.toLocaleString() === TipoDoc.MANUT_GT
      || elem.fkTipoDocumento.toLocaleString() === TipoDoc.MANUT_GF
      || elem.fkTipoDocumento.toLocaleString() === TipoDoc.MANUT_SC);
    return result;
  }

  isRicevutaVisibile(elem: ControlloModel) {
    let result = true;
    result = result && (elem.fkStatoRapp == STATO_RAPP.INVIATO || elem.fkStatoRapp == STATO_RAPP.RESPINTO);
    if (this.utente.ruoloLoggato.ruolo === RUOLI.RUOLO_IMPRESA) {
      result = result && (elem.idPersonaGiuridica === this.utente.ruoloLoggato.idPersonaGiuridica);
    } else {
      result = result &&
        (this.utente.ruoloLoggato.ruolo === RUOLI.RUOLO_PROPRIETARIO
          || this.utente.ruoloLoggato.ruolo === RUOLI.RUOLO_SUPER
          || this.utente.ruoloLoggato.ruolo === RUOLI.RUOLO_ISPETTORE
          || this.utente.ruoloLoggato.ruolo === RUOLI.RUOLO_CONSULTATORE
          || this.utente.ruoloLoggato.ruolo === RUOLI.RUOLO_VALIDATORE);
    }
    return result;
  }

  aggiungiControllo() {
    this.router.navigate(["impianto/dettaglio/" + this.codiceImpianto + "/elenco-controlli/cerca-controlli"]);
  }

  isAggiungiControlloVisible() {
    return !(this.utente.ruoloLoggato.ruolo === RUOLI.RUOLO_CONSULTATORE
      && this.utente.ruoloLoggato.ruolo === RUOLI.RUOLO_ISPETTORE);
  }

  caricaReeFirmato(controllo: DatoControlloModel) {
    if (!this.offline) {
      this.dialog.open(UploadFileDialogComponent, {
        width: "100%",
        data: controllo.controlloModel.idAllegato,
        maxWidth: "900px",
      }).afterClosed().subscribe(response => {
        if (response.data) {
          this.messageService.setTitolo("Successo");
          this.messageService.setDescrizione("REE firmato caricato correttamente");
          this.messageService.showMessaggioM();
          this.messageService.setType(4);
        }
        this.sortControlli();
      });
    } else {
      this.messageService.setTitolo("Errore Inserimento REE firmato");
      this.messageService.setDescrizione("Impossibile caricare il REE firmato se il dispositivo è offline");
      this.messageService.showMessaggioM();
      this.messageService.setType(2);
    }
  }

  downloadRicevuta(elem: ControlloModel) {

    if (!this.offline) {
      this.controlloService.getRicevuta(elem.idAllegato).subscribe((doc) => {
        this.downLoadFile(doc, elem.idAllegato, "ricevuta");
      }, (error: Esito) => {
        this.messageService.setTitolo("Errore download ricevuta");
        this.messageService.setDescrizione(error.descrizioneEsito);
        this.messageService.showMessaggioM();
        this.messageService.setType(2);
      });
    } else {
      this.messageService.setDescrizione("Impossibile scaricare la ricevuta se il dispositivo è offline");
      this.messageService.setTitolo("Errore download ricevuta");
      this.messageService.showMessaggioM();
      this.messageService.setType(2);
    }
  }

  downloadReeFirmato(elem: ControlloModel) {
    if (elem.uidIndexFirmato) {
      if (!this.offline) {
        this.controlloService.getPdfControllo(elem.idAllegato, elem.codiceImpianto, true).subscribe((doc: any) => {
          const byteArray = new Uint8Array(
            atob(doc.file)
              .split('')
              .map((char) => char.charCodeAt(0))
          );
          doDownloadFile(byteArray, doc.name, doc.mimeType);
        }, (error: Esito) => {
          this.messageService.setTitolo("Errore download Riepilogo firmato");
          this.messageService.setDescrizione(error.descrizioneEsito);
          this.messageService.showMessaggioM();
          this.messageService.setType(2);
        });
      } else {
        this.messageService.setTitolo("Errore download Riepilogo firmato");
        this.messageService.setDescrizione("Impossibile scaricare il riepilogo firmato se il dispositivo è offline");
        this.messageService.showMessaggioM();
        this.messageService.setType(2);
      }
    } else {
      this.messageService.setTitolo("Attenzione");
      this.messageService.setDescrizione("Nessun documento firmato presente a sistema per questo controllo");
      this.messageService.showMessaggioM();
      this.messageService.setType(1);
    }
  }

  downloadRee(elem: ControlloModel) {
    if (elem.uidIndex) {
      if (!this.offline) {
        this.controlloService.getPdfControllo(elem.idAllegato, elem.codiceImpianto, false).subscribe((doc: PdfControllo) => {
          const byteArray = new Uint8Array(
            atob(doc.file)
              .split('')
              .map((char) => char.charCodeAt(0))
          );
          doDownloadFile(byteArray, doc.name, doc.mimeType);
        }, (error: Esito) => {
          this.messageService.setTitolo("Errore download Riepilogo");
          this.messageService.setDescrizione(error.descrizioneEsito);
          this.messageService.showMessaggioM();
          this.messageService.setType(2);
        });
      } else {
        this.messageService.setTitolo("Errore download Riepilogo");
        this.messageService.setDescrizione("Impossibile scaricare il riepilogo se il dispositivo è offline");
        this.messageService.showMessaggioM();
        this.messageService.setType(2);
      }
    } else {
      this.messageService.setTitolo("Attenzione");
      this.messageService.setDescrizione("Nessun documento presente a sistema per questo controllo");
      this.messageService.showMessaggioM();
      this.messageService.setType(1);
    }
  }

  downLoadFile(data: any, idAllegato: number, tipo: string) {
    doDownloadFile(data, tipo + "_" + idAllegato + ".pdf");
  }

  inviaControllo(controllo: DatoControlloModel) {
    if (controllo.controlloModel.idAllegato) {
      if (controllo.controlloModel.fkStatoRapp !== STATO_RAPP.BOZZA_LOCALE) {
        controllo.tempIdControllo = uuidv4();
        controllo.fkStatoPrec = controllo.controlloModel.fkStatoRapp;
        this.localStorageService.addBozzeLocali(controllo, this.codiceImpianto);
      }
      let operazione = this.createOperazioneOffline(controllo, OPERAZIONI.INVIO);
      this.controlloService.inviaREE(controllo.controlloModel.idAllegato, operazione).subscribe((esito: Esito) => {
        this.localStorageService.delBozzaLocale(controllo.tempIdControllo, this.codiceImpianto);
        this.success = true;
        this.messageService.setTitolo("Successo");
        this.messageService.setDescrizione(esito.descrizioneEsito);
        this.messageService.showMessaggioM();
        this.messageService.setType(4);
        this.sortControlli();
      }, error => {
        if (error instanceof OnlineCheckModel) {
          controllo.fkStatoPrec = controllo.controlloModel.fkStatoRapp;
          controllo.controlloModel.fkStatoRapp = STATO_RAPP.IN_ATTESA_DI_INVIO;
          this.localStorageService.updateBozzaLocale(controllo, controllo.tempIdControllo, this.codiceImpianto);
          this.sortControlli();
        } else {
          let errore: Esito = error.error;
          this.messageService.setType(2);
          this.messageService.setTitolo("Errore invio controllo");
          this.messageService.setDescrizione(errore.descrizioneEsito);
          this.messageService.showMessaggioM();
        }
      });
    } else {
      this.messageService.setType(2);
      this.messageService.setTitolo("Errore invio controllo");
      this.messageService.setDescrizione("Bisogna salvare il dettaglio del controllo prima di inviarlo.");
      this.messageService.showMessaggioM();
    }
  }

  modificaControllo(controllo: DatoControlloModel) {
    this.resultService.setResultControllo(controllo);
    switch (controllo.controlloModel.fkTipoDocumento.toLocaleString()) {
      case TipoDoc.REE_1:
        this.router.navigate(["/impianto/dettaglio/" + this.codiceImpianto + "/elenco-controlli/" + (controllo.controlloModel.idAllegato ? "ree-tipo1/" + controllo.controlloModel.idAllegato : "aggiungi-ree-tipo1")]);
        break;
      case TipoDoc.REE_1B:
        this.router.navigate(["/impianto/dettaglio/" + this.codiceImpianto + "/elenco-controlli/" + (controllo.controlloModel.idAllegato ? "ree-tipo1B/" + controllo.controlloModel.idAllegato : "aggiungi-ree-tipo1B")]);
        break;

      case TipoDoc.REE_2:
        this.router.navigate(["/impianto/dettaglio/" + this.codiceImpianto + "/elenco-controlli/" + (controllo.controlloModel.idAllegato ? "ree-tipo2/" + controllo.controlloModel.idAllegato : "aggiungi-ree-tipo2")]);
        break;

      case TipoDoc.REE_3:
        this.router.navigate(["/impianto/dettaglio/" + this.codiceImpianto + "/elenco-controlli/" + (controllo.controlloModel.idAllegato ? "ree-tipo3/" + controllo.controlloModel.idAllegato : "aggiungi-ree-tipo3")]);
        break;

      case TipoDoc.REE_4:
        this.router.navigate(["/impianto/dettaglio/" + this.codiceImpianto + "/elenco-controlli/" + (controllo.controlloModel.idAllegato ? "ree-tipo4/" + controllo.controlloModel.idAllegato : "aggiungi-ree-tipo4")]);
        break;
    }
  }

  createOperazioneOffline(controllo: DatoControlloModel, descOperazione: string) {
    let operazione = new OperazioneControlloModel();
    operazione.codiceImpianto = this.codiceImpianto;
    operazione.idOperazione = controllo.tempIdControllo;
    operazione.dataControllo = controllo.controlloModel.dataControllo;
    operazione.dataInserimento = this.datepipe.transform(new Date(), FORMAT);
    operazione.dataInvioOnline = undefined;
    operazione.descrizioneOperazione = descOperazione;
    operazione.utente = this.utente;
    operazione.esito = ESITO_OPERAZIONI.PENDING;
    return operazione;
  }

  annullaOperazione(controllo: DatoControlloModel) {
    controllo.controlloModel.fkStatoRapp = controllo.fkStatoPrec;
    if (controllo.fkStatoPrec === STATO_RAPP.BOZZA_LOCALE) {
      this.localStorageService.updateBozzaLocale(controllo, controllo.tempIdControllo, this.codiceImpianto);
    } else {
      this.localStorageService.delBozzaLocale(controllo.tempIdControllo, this.codiceImpianto);
    }
    this.localStorageService.delOperazioniByTempId(controllo.tempIdControllo);
    this.sortControlli();
  }

  deleteControllo(controllo: DatoControlloModel) {
    if (controllo.controlloModel.fkStatoRapp === STATO_RAPP.BOZZA_LOCALE) {
      this.dialog.open(DeleteDialogComponent, {
        data: { titolo: "Eliminare bozza?", descrizione: "Confermi di voler eliminare la bozza del controllo " + controllo.controlloModel.desTipoDocumento + "? Se esistenti i dati precedenti alla bozza verranno mantenuti" }
      }).afterClosed().subscribe(response => {
        if (response) {
          this.localStorageService.delBozzaLocale(controllo.tempIdControllo, this.codiceImpianto);
          this.sortControlli();
        }
      });
    } else {
      this.dialog.open(DeleteDialogComponent, {
        data: { titolo: "Eliminare il controllo?", descrizione: "Confermi di voler eliminare il controllo " + controllo.controlloModel.desTipoDocumento + "?" }
      }).afterClosed().subscribe(response => {
        if (response) {
          if (controllo.controlloModel.idAllegato) {
            controllo.fkStatoPrec = controllo.controlloModel.fkStatoRapp;
            controllo.tempIdControllo = uuidv4();
            this.localStorageService.addBozzeLocali(controllo, this.codiceImpianto);
            let operazione = this.createOperazioneOffline(controllo, OPERAZIONI.CANCELLAZIONE);
            this.controlloService.deleteControllo(controllo.controlloModel.idAllegato, controllo.controlloModel.fkStatoRapp, operazione).subscribe(elem => {
              this.localStorageService.delBozzaLocale(controllo.tempIdControllo, this.codiceImpianto);
              this.success = true;
              this.messageService.setTitolo("Successo");
              this.messageService.setDescrizione("Cancellazione avvenuta con successo");
              this.messageService.showMessaggioM();
              this.messageService.setType(4);
              this.sortControlli();
            }, error => {
              if (error instanceof OnlineCheckModel) {
                controllo.controlloModel.fkStatoRapp = STATO_RAPP.IN_ATTESA_DI_ELIMINAZIONE;
                this.localStorageService.updateBozzaLocale(controllo, controllo.tempIdControllo, this.codiceImpianto);
                this.sortControlli();
              } else {
                let errore: Esito = error.error;
                this.messageService.setType(2);
                this.messageService.setTitolo("Errore cancellazione controllo");
                this.messageService.setDescrizione(errore ? errore.descrizioneEsito : "Errore non gestito");
                this.messageService.showMessaggioM();
              }
            });
          }
        }
      });
    }
  }

  inviaManutenzione(controllo: DatoControlloModel) {
    let operazione = this.createOperazioneOffline(controllo, OPERAZIONI.INVIO);
    this.controlloService.inviaManutenzione(this.codiceImpianto, controllo.manut.tipoControllo, controllo.manut, operazione).subscribe(elem => {
      this.localStorageService.delBozzaLocale(controllo.tempIdControllo, this.codiceImpianto);
      this.success = true;
      this.messageService.setTitolo("Successo");
      this.messageService.setDescrizione("Manutenzione inviata con successo");
      this.messageService.showMessaggioM();
      this.messageService.setType(4);
      this.sortControlli();
    }, error => {
      if (error instanceof OnlineCheckModel) {
        controllo.tempIdControllo = operazione.idOperazione;
        controllo.fkStatoPrec = STATO_RAPP.BOZZA_LOCALE;
        controllo.controlloModel.fkStatoRapp = STATO_RAPP.IN_ATTESA_DI_INVIO;
        this.localStorageService.updateBozzaLocale(controllo, controllo.tempIdControllo, this.codiceImpianto);
        this.localStorageService.subjectControllo.next(this.localStorageService.getControllo());
      } else {
        this.messageService.setType(2);
        this.messageService.setTitolo("Errore invio controllo");
        let errore: Esito = error.error as Esito;
        this.messageService.setDescrizione(errore.descrizioneEsito);
        this.messageService.showMessaggioM();
      }
    });
  }

  getDate(data: string) {
    if (data)
      return this.datepipe.transform(data, DISPLAY_FORMAT);
    else
      return "-";
  }
}
