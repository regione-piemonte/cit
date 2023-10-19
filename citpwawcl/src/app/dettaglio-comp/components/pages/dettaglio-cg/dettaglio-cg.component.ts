import { DatePipe } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatDialog } from '@angular/material/dialog';
import { ActivatedRoute, Router } from '@angular/router';
import { CodiceDescrizione } from 'src/app/models/codice-descrizione';
import { DatiCGModel } from 'src/app/models/dati-cg-model';
import { Esito } from 'src/app/models/esito';
import { UtenteLoggato } from 'src/app/models/utente-loggato';
import { AuthenticationService } from 'src/app/services/authentication.service';
import { BackService } from 'src/app/services/back.service';
import { ComponenteService } from 'src/app/services/componente.service';
import { MessageService } from 'src/app/services/message.service';
import { TitleService } from 'src/app/services/title.service';
import { DISPLAY_FORMAT, FORMAT, KO_PG, OPERAZIONE_COMP, RUOLI, TIPI_COMP } from 'src/app/utils/constants';
import { validateDateIstall } from 'src/app/validators/custom.validator';
import { RicercaPgDialogComponent } from '../../ricerca-pg-dialog/ricerca-pg-dialog.component';


@Component({
  selector: 'app-dettaglio-cg',
  templateUrl: './dettaglio-cg.component.html',
  styleUrls: ['./dettaglio-cg.component.scss']
})
export class DettaglioCgComponent implements OnInit {
  success = false;
  codiceImpianto: string = "";
  progr: string = "";

  fabbricanti: CodiceDescrizione[] = [];
  combustibili: CodiceDescrizione[] = [];
  fonte: CodiceDescrizione[] = [];

  dettForm: FormGroup;

  datiCG: DatiCGModel[] = [];
  currentDato: DatiCGModel;
  cgDismessi: DatiCGModel[] = [];

  utente: UtenteLoggato;

  operazione: number;

  constructor(
    public dialog: MatDialog,
    private route: ActivatedRoute,
    private fb: FormBuilder,
    private componenteService: ComponenteService,
    public datepipe: DatePipe,
    authService: AuthenticationService,
    private readonly backService: BackService,
    private readonly messageService: MessageService,
    private readonly titleService: TitleService,
    private router: Router) {
    this.utente = authService.getCurrentUserFromSession();
    this.codiceImpianto = this.route.snapshot.parent.paramMap.get('id_impianto');
    this.progr = this.route.snapshot.paramMap.get('progr');
    this.dettForm = this.fb.group({
      dtInstall: ["", [Validators.required]],
      dtDismiss: [""],
      fabbricante: ["", [Validators.required]],
      modello: ["", [Validators.required]],
      matricola: ["", [Validators.required]],
      combustibile: ["", [Validators.required]],
      tipologia: ["", [Validators.required]],
      potenzaTermica: ["", [Validators.required]],
      potenzaElettrica: ["", [Validators.required]],
      tempH2oOutMin: [],
      tempH2oOutMax: [],
      tempH2oInMin: [],
      tempH2oInMax: [],
      tempH2oMotoreMin: [],
      tempH2oMotoreMax: [],
      tempFumiValleMin: [],
      tempFumiValleMax: [],
      tempFumiMonteMin: [],
      tempFumiMonteMax: [],
      coMin: [],
      coMax: [],
      nMantenimenti: [, [Validators.required, Validators.pattern(/^[1-9][0-9]*$/)]],
      note: [""]
    });
  }

  ngOnInit(): void {
    this.titleService.setTitle("Dettaglio CG");
    this.backService.setBackTitle("Torna al dettaglio");
    this.backService.setRoute('impianto/dettaglio-impianto/' + this.codiceImpianto);

    this.componenteService.getCombustibile().subscribe((elem: CodiceDescrizione[]) => {
      this.combustibili = elem;
    }, (error: Esito) => {
      this.messageService.setTitolo("Errore recupero dati");
      this.messageService.setDescrizione(error.descrizioneEsito);
      this.messageService.showMessaggioM();
      this.messageService.setType(2);
    });

    this.componenteService.getMarca().subscribe((elem: CodiceDescrizione[]) => {
      this.fabbricanti = elem;
    }, (error: Esito) => {
      this.messageService.setTitolo("Errore recupero dati");
      this.messageService.setDescrizione(error.descrizioneEsito);
      this.messageService.showMessaggioM();
      this.messageService.setType(2);
    });


    this.componenteService.getFonte().subscribe((elem: CodiceDescrizione[]) => {
      this.fonte = elem;
    }, (error: Esito) => {
      this.messageService.setTitolo("Errore recupero dati");
      this.messageService.setDescrizione(error.descrizioneEsito);
      this.messageService.showMessaggioM();
      this.messageService.setType(2);
    });

    if (this.progr) {
      this.getData();
    } else {
      this.operazione = OPERAZIONE_COMP.INSERISCI;
    }
  }

  getData() {
    this.componenteService.getCG(this.codiceImpianto, this.progr).subscribe((elem: DatiCGModel[]) => {
      this.datiCG = elem;
      this.preparaDati();
    }, (error: Esito) => {
      this.messageService.setTitolo("Errore recupero dati");
      this.messageService.setDescrizione(error.descrizioneEsito);
      this.messageService.showMessaggioM();
      this.messageService.setType(2);
    });
  }

  preparaDati() {
    this.cgDismessi = [];
    this.currentDato = undefined;
    this.datiCG.forEach(element => {
      if (!element.dataDismiss) {
        this.currentDato = element;
      }
    });

    if (!this.currentDato) {
      this.currentDato = this.datiCG[0];
    }

    this.cgDismessi = this.datiCG;
    const index = this.cgDismessi.indexOf(this.currentDato, 0);
    this.cgDismessi.splice(index, 1);

    this.compilaForm(this.currentDato);
    this.dettForm.disable();
  }

  compilaForm(dato: DatiCGModel) {
    this.dettForm.patchValue({
      dtInstall: dato.dataInstall ? new Date(dato.dataInstall) : '',
      dtDismiss: dato.dataDismiss ? new Date(dato.dataDismiss) : '',
      fabbricante: dato.fkMarca ? dato.fkMarca.toString() : dato.fkMarca,
      modello: dato.modello,
      matricola: dato.matricola,
      combustibile: dato.fkCombustibile ? dato.fkCombustibile.toString() : dato.fkCombustibile,
      tipologia: dato.tipologia,
      potenzaTermica: dato.potenzaTermicaKw,
      potenzaElettrica: dato.potenzaElettricaKw,
      tempH2oOutMin: dato.tempH2oOutMin,
      tempH2oOutMax: dato.tempH2oOutMax,
      tempH2oInMin: dato.tempH2oInMin,
      tempH2oInMax: dato.tempH2oInMax,
      tempH2oMotoreMin: dato.tempH2oMotoreMin,
      tempH2oMotoreMax: dato.tempH2oMotoreMax,
      tempFumiValleMin: dato.tempFumiValleMin,
      tempFumiValleMax: dato.tempFumiValleMax,
      tempFumiMonteMin: dato.tempFumiMonteMin,
      tempFumiMonteMax: dato.tempFumiMonteMax,
      coMin: dato.coMin,
      coMax: dato.coMax,
      nMantenimenti: dato.tempoManutAnni,
      note: dato.note
    });
    this.dettForm.get("dtInstall").setValidators([Validators.required, validateDateIstall(this.getLastDate())]);
    this.dettForm.get("dtInstall").updateValueAndValidity();
  }


  checkRuoloConsultazione(): boolean {
    let ruolo = this.utente.ruoloLoggato.ruolo;
    return !((ruolo === RUOLI.RUOLO_CONSULTATORE
      || ruolo === RUOLI.RUOLO_RESPONSABILE
      || ruolo === RUOLI.RUOLO_RESPONSABILE_IMPRESA
      || ruolo === RUOLI.RUOLO_3RESPONSABILE
      || ruolo === RUOLI.RUOLO_PROPRIETARIO
      || ruolo === RUOLI.RUOLO_PROPRIETARIO_IMPRESA));
  }

  checkModificaButton(): boolean {
    return this.checkRuoloConsultazione() && this.currentDato && (!this.currentDato.dataDismiss) && this.dettForm.disabled && this.progr != undefined;
  }

  checkRiattivaButton(): boolean {
    return this.checkRuoloConsultazione() && this.currentDato && this.currentDato.dataDismiss && this.dettForm.disabled && this.progr != undefined;
  }

  checkDismettiButton(): boolean {
    return this.checkRuoloConsultazione() && this.progr && this.dettForm.enabled;
  }

  checkSostituisciButton(): boolean {
    return this.checkRuoloConsultazione() && this.progr && this.dettForm.enabled;
  }

  checkRipristinaButton(): boolean {
    return this.checkRuoloConsultazione();
  }

  checkAnnullaButton(): boolean {
    return this.checkRuoloConsultazione() && this.dettForm.enabled && this.operazione != undefined;
  }

  checkSalvaButton(): boolean {
    return this.operazione != undefined;
  }

  dismetti() {
    let dataDismiss = this.dettForm.controls["dtDismiss"].value;
    if (dataDismiss && dataDismiss > this.dettForm.controls["dtInstall"].value) {
      if (this.dettForm.valid) {
        if (this.operazione = OPERAZIONE_COMP.SOSTITUISCI) {
          this.dettForm.disable();
          this.operazione = OPERAZIONE_COMP.DISMETTI;
          this.currentDato = this.compilaDatiCG();
        } else {
          this.currentDato.dataDismiss = this.datepipe.transform(dataDismiss, FORMAT);
          this.componenteService.checkSostituisciDismetti(this.currentDato.dataMinimaControllo, this.currentDato.dataMassimaControllo, dataDismiss).subscribe(elem => {
            this.compilaForm(this.currentDato);
            this.dettForm.disable();
            this.operazione = OPERAZIONE_COMP.DISMETTI;
          }, (error: Esito) => {
            this.messageService.setTitolo("Operazione non valida");
            this.messageService.setDescrizione(error.descrizioneEsito);
            this.messageService.showMessaggioM();
            this.messageService.setType(2);
          });
        }
      } else {
        this.dettForm.markAllAsTouched();
        this.messageService.setTitolo("Dati inseriti non validi");
        this.messageService.setDescrizione("Compilare correttamente il form e riprovare");
        this.messageService.showMessaggioM();
        this.messageService.setType(2);
      }
    } else {
      this.messageService.setTitolo("Dati inseriti non validi");
      this.messageService.setDescrizione("Data dismissione non valida");
      this.messageService.showMessaggioM();
      this.messageService.setType(2);
    }
  }

  ripristina(cg) {
    if (this.currentDato) {
      this.currentDato.dataDismiss = this.datepipe.transform(new Date(), FORMAT);
      this.componenteService.checkSostituisciDismetti(this.currentDato.dataMinimaControllo, this.currentDato.dataMassimaControllo, this.currentDato.dataDismiss).subscribe(elem => {
        const index = this.cgDismessi.indexOf(cg, 0);
        this.cgDismessi.splice(index, 1);
        this.currentDato = cg;
        this.currentDato.dataDismiss = "";
        this.compilaForm(cg);
        this.dettForm.enable();
        this.dettForm.controls["dtInstall"].disable();
        this.operazione = OPERAZIONE_COMP.RIPRISTINA;
      }, (error: Esito) => {
        this.messageService.setTitolo("Operazione non valida");
        this.messageService.setDescrizione(error.descrizioneEsito);
        this.messageService.showMessaggioM();
        this.messageService.setType(2);
      });
    } else {
      const index = this.cgDismessi.indexOf(cg, 0);
      this.cgDismessi.splice(index, 1);
      this.currentDato = cg;
      this.compilaForm(cg);
      this.dettForm.enable();
      this.dettForm.controls["dtInstall"].disable();
      this.operazione = OPERAZIONE_COMP.RIPRISTINA;
    }
  }

  riattiva() {
    this.dettForm.enable();
    this.dettForm.controls["dtInstall"].disable();
    this.operazione = OPERAZIONE_COMP.MODIFICA;
    this.dettForm.controls.dtDismiss.setValue("");
  }

  modifica() {
    this.dettForm.enable();
    this.dettForm.controls["dtInstall"].disable();
    this.operazione = OPERAZIONE_COMP.MODIFICA;
  }



  sostituisci() {
    let dataDismiss = this.dettForm.controls.dtDismiss.value;
    if (dataDismiss && dataDismiss > this.dettForm.controls.dtInstall.value) {
      this.currentDato.dataDismiss = this.datepipe.transform(dataDismiss, FORMAT)
      this.componenteService.checkSostituisciDismetti(this.currentDato.dataMinimaControllo, this.currentDato.dataMassimaControllo, dataDismiss).subscribe(elem => {
        this.cgDismessi.push(this.currentDato);
        this.currentDato = undefined;
        this.dettForm.reset();
        this.dettForm.enable();
        this.operazione = OPERAZIONE_COMP.SOSTITUISCI;
        this.dettForm.get("dtInstall").setValidators([Validators.required, validateDateIstall(this.getLastDate())]);
        this.dettForm.get("dtInstall").updateValueAndValidity();
      }, (error: Esito) => {
        this.messageService.setTitolo("Operazione non valida");
        this.messageService.setDescrizione(error.descrizioneEsito);
        this.messageService.showMessaggioM();
        this.messageService.setType(2);
      });
    } else {
      this.messageService.setTitolo("Dati inseriti non validi");
      this.messageService.setDescrizione("Data dismissione non valida");
      this.messageService.showMessaggioM();
      this.messageService.setType(2);
    }
  }

  annulla() {
    if (this.progr) {
      this.operazione = undefined;
      this.getData();
    } else {
      this.router.navigate(["impianto/dettaglio-impianto/" + this.codiceImpianto]);
    }
  }

  salvaDati() {
    if (this.operazione === OPERAZIONE_COMP.DISMETTI) {
      this.dettForm.enable();
    }

    if (this.dettForm.valid || this.operazione === OPERAZIONE_COMP.DISMETTI) {
      let datiCG: DatiCGModel = this.compilaDatiCG();
      let newArray: DatiCGModel[] = [datiCG];
      newArray = newArray.concat(this.cgDismessi);
      this.componenteService.updateCG(this.codiceImpianto, newArray).subscribe((elem: Esito) => {
        this.router.navigate(["impianto/dettaglio-impianto/" + this.codiceImpianto, { success: true }]);
        this.dettForm.disable();
      }, (error) => {
        if (this.operazione === OPERAZIONE_COMP.DISMETTI) {
          this.dettForm.disable();
        }
        let errore = error.error as Esito;
        if (errore.esito === KO_PG) {
          this.dialog.open(RicercaPgDialogComponent, {
            width: "90%",
            height: '90%',
            maxWidth: "500px",
            data: { codiceImpianto: this.codiceImpianto, array: newArray, tipo: TIPI_COMP.CG }
          }).afterClosed().subscribe(response => {
            if (!response) {
              this.messageService.setTitolo("Errore recupero dati");
              this.messageService.setDescrizione(errore.descrizioneEsito);
              this.messageService.showMessaggioM();
              this.messageService.setType(2);
            }
          });
        } else {
          this.messageService.setTitolo("Errore recupero dati");
          this.messageService.setDescrizione(errore.descrizioneEsito);
          this.messageService.showMessaggioM();
          this.messageService.setType(2);
        }
      });
    } else {
      if (this.operazione === OPERAZIONE_COMP.DISMETTI) {
        this.dettForm.disable();
      }
      this.messageService.setTitolo("Dati inseriti non validi");
      this.messageService.setDescrizione("Controllare i dati inseriti e riprovare");
      this.messageService.showMessaggioM();
      this.messageService.setType(2);
      this.dettForm.markAllAsTouched();
    }
  }

  compilaDatiCG() {
    let dato = new DatiCGModel();
    if (this.dettForm.controls["dtInstall"].value) {
      dato.dataInstall = this.datepipe.transform(this.dettForm.controls["dtInstall"].value, FORMAT);
    }
    if (this.dettForm.controls["dtDismiss"].value) {
      dato.dataDismiss = this.datepipe.transform(this.dettForm.controls["dtDismiss"].value, FORMAT);
    }
    dato.fkMarca = this.dettForm.controls["fabbricante"].value;
    dato.modello = this.dettForm.controls["modello"].value;
    dato.matricola = this.dettForm.controls["matricola"].value;
    dato.fkCombustibile = this.dettForm.controls["combustibile"].value;
    dato.tipologia = this.dettForm.controls["tipologia"].value;
    dato.potenzaTermicaKw = this.dettForm.controls["potenzaTermica"].value;
    dato.potenzaElettricaKw = this.dettForm.controls["potenzaElettrica"].value;
    dato.tempH2oOutMin = this.dettForm.controls["tempH2oOutMin"].value;
    dato.tempH2oOutMax = this.dettForm.controls["tempH2oOutMax"].value;
    dato.tempH2oInMin = this.dettForm.controls["tempH2oInMin"].value;
    dato.tempH2oInMax = this.dettForm.controls["tempH2oInMax"].value;
    dato.tempH2oMotoreMin = this.dettForm.controls["tempH2oMotoreMin"].value;
    dato.tempH2oMotoreMax = this.dettForm.controls["tempH2oMotoreMax"].value;
    dato.tempFumiValleMin = this.dettForm.controls["tempFumiValleMin"].value;
    dato.tempFumiValleMax = this.dettForm.controls["tempFumiValleMax"].value;
    dato.tempFumiMonteMin = this.dettForm.controls["tempFumiMonteMin"].value;
    dato.tempFumiMonteMax = this.dettForm.controls["tempFumiMonteMax"].value;
    dato.coMin = this.dettForm.controls["coMin"].value;
    dato.coMax = this.dettForm.controls["coMax"].value;
    dato.tempoManutAnni = this.dettForm.controls["nMantenimenti"].value;
    dato.note = this.dettForm.controls["note"].value;
    dato.idTipoComponente = 'CG';
    dato.progressivo = parseInt(this.progr);
    return dato;
  }

  getDate(data: string) {
    if (data)
      return this.datepipe.transform(data, DISPLAY_FORMAT);
    else
      return "-";
  }

  myFilter = (d: Date | null): boolean => {
    if (this.operazione != OPERAZIONE_COMP.SOSTITUISCI)
      return this.operazione != OPERAZIONE_COMP.SOSTITUISCI && d < new Date();
    else
      return d > this.getLastDate();
  };

  isLastDate(date) {
    let result = true;
    this.cgDismessi.forEach((element: DatiCGModel) => {
      if (new Date(element.dataDismiss) > new Date(date)) {
        result = false;
      }
    });
    return result;
  }

  getLastDate() {
    let result = this.cgDismessi[0] ? new Date(this.cgDismessi[0].dataDismiss) : undefined;
    this.cgDismessi.forEach((element: DatiCGModel) => {
      if (new Date(element.dataDismiss) > result) {
        result = new Date(element.dataDismiss);
      }
    });
    return result;
  }
}
