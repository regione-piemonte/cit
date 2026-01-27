import { NumberInput } from '@angular/cdk/coercion';
import { DatePipe } from '@angular/common';
import { Component, HostListener, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatDialog } from '@angular/material/dialog';
import { ActivatedRoute, Router } from '@angular/router';
import { CodiceDescrizione } from 'src/app/models/codice-descrizione';
import { DatiGTModel } from 'src/app/models/dati-gt-model';
import { Esito } from 'src/app/models/esito';
import { UtenteLoggato } from 'src/app/models/utente-loggato';
import { rendimentoPercValidator } from 'src/app/nuovo-controllo/directives/validator-directive.directive';
import { AuthenticationService } from 'src/app/services/authentication.service';
import { BackService } from 'src/app/services/back.service';
import { ComponenteService } from 'src/app/services/componente.service';
import { MessageService } from 'src/app/services/message.service';
import { TitleService } from 'src/app/services/title.service';
import { DISPLAY_FORMAT, FORMAT, KO_PG, OPERAZIONE_COMP, RUOLI, TIPI_COMP } from 'src/app/utils/constants';
import { validateDateIstall } from 'src/app/validators/custom.validator';
import { RicercaPgDialogComponent } from '../../ricerca-pg-dialog/ricerca-pg-dialog.component';

@Component({
  selector: 'app-dettaglio-gt',
  templateUrl: './dettaglio-gt.component.html',
  styleUrls: ['./dettaglio-gt.component.scss']
})
export class DettaglioGtComponent implements OnInit {

  success = false;
  codiceImpianto: string = "";
  progr: string = "";

  fabbricanti: CodiceDescrizione[] = [];
  combustibili: CodiceDescrizione[] = [];
  fluidi: CodiceDescrizione[] = [];
  tipologie: CodiceDescrizione[] = [];
  canne: CodiceDescrizione[] = [];

  dettForm: FormGroup;

  datiGT: DatiGTModel[] = [];
  currentDato: DatiGTModel;
  gtDismessi: DatiGTModel[] = [];

  utente: UtenteLoggato;
  operazione: number;

  colBreakpoint1: NumberInput;
  colBreakpoint2: NumberInput;
  colBreakpoint3: NumberInput;

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
      fluido: ["", [Validators.required]],
      potenza: ["", [Validators.required]],
      rendimento: ["", [Validators.required, rendimentoPercValidator()]],
      tipologia: ["", [Validators.required]],
      nModuli: ["", [Validators.required, Validators.pattern(/^[1-9][0-9]*$/)]],
      canna: ["", [Validators.required]],
      nOre: [Validators.pattern(/^\d*\.?\d*$/)],
      nMantenimenti: ["", [Validators.required, Validators.pattern(/^[1-9][0-9]*$/)]],
      note: [""]
    });

  }

  ngOnInit(): void {
    this.colBreakpoint1 = (window.innerWidth < 768) ? 6 : 2;
    this.colBreakpoint2 = (window.innerWidth < 768) ? 6 : 4;
    this.colBreakpoint3 = 6;

    this.titleService.setTitle("Dettaglio GT");
    this.backService.setBackTitle("Torna al dettaglio");
    this.backService.setRoute('impianto/dettaglio-impianto/' + this.codiceImpianto);

    this.componenteService.getFluido().subscribe((elem: CodiceDescrizione[]) => {
      this.fluidi = elem;
    }, (error: Esito) => {
      this.setErroreRecuperoMessage(error);
    });

    this.componenteService.getCombustibile().subscribe((elem: CodiceDescrizione[]) => {
      this.combustibili = elem;
    }, (error: Esito) => {
      this.setErroreRecuperoMessage(error);
    });

    this.componenteService.getMarca().subscribe((elem: CodiceDescrizione[]) => {
      this.fabbricanti = elem;
    }, (error: Esito) => {
      this.setErroreRecuperoMessage(error);
    });

    this.componenteService.getTipoCannaFumaria().subscribe((elem: CodiceDescrizione[]) => {
      this.canne = elem;
    }, (error: Esito) => {
      this.setErroreRecuperoMessage(error);
    });

    this.componenteService.getTipologiaGT().subscribe((elem: CodiceDescrizione[]) => {
      this.tipologie = elem;
    }, (error: Esito) => {
      this.setErroreRecuperoMessage(error);
    });
    if (this.progr) {
      this.getData();
    } else {
      this.operazione = OPERAZIONE_COMP.INSERISCI;
    }
  }

  setErroreRecuperoMessage(error: Esito)
  {
    this.messageService.setTitolo("Errore recupero dati");
    this.messageService.setDescrizione(error.descrizioneEsito);
    this.messageService.showMessaggioM();
    this.messageService.setType(2);
  }

  @HostListener('window:resize', ['$event'])
  onResize(event?) {
    this.colBreakpoint1 = (event.target.innerWidth < 768) ? 6 : 2;
    this.colBreakpoint2 = (event.target.innerWidth < 768) ? 6 : 4;
  }

  getData() {
    this.componenteService.getGT(this.codiceImpianto, this.progr).subscribe((elem: DatiGTModel[]) => {
      this.datiGT = elem;
      this.preparaDati();
    }, (error: Esito) => {
      this.setErroreRecuperoMessage(error);
    });
  }

  preparaDati() {
    this.gtDismessi = [];
    this.currentDato = undefined;
    this.datiGT.forEach(element => {
      if (!element.dataDismiss) {
        this.currentDato = element;
      }
    });

    if (!this.currentDato) {
      this.currentDato = this.datiGT[0];
    }

    this.gtDismessi = this.datiGT;
    const index = this.gtDismessi.indexOf(this.currentDato, 0);
    this.gtDismessi.splice(index, 1);

    this.compilaForm(this.currentDato);
    this.dettForm.disable();
  }

  checkRuoloConsultazione() {
    let ruolo = this.utente.ruoloLoggato.ruolo;
    return !(ruolo === RUOLI.RUOLO_CONSULTATORE
      || ruolo === RUOLI.RUOLO_RESPONSABILE
      || ruolo === RUOLI.RUOLO_RESPONSABILE_IMPRESA
      || ruolo === RUOLI.RUOLO_3RESPONSABILE
      || ruolo === RUOLI.RUOLO_PROPRIETARIO
      || ruolo === RUOLI.RUOLO_PROPRIETARIO_IMPRESA);
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
          this.currentDato = this.compilaDatiGT();
        } else {
          this.currentDato.dataDismiss = this.datepipe.transform(dataDismiss, FORMAT);
          this.componenteService.checkSostituisciDismetti(this.currentDato.dataMinimaControllo, this.currentDato.dataMassimaControllo, dataDismiss).subscribe(elem => {
            this.compilaForm(this.currentDato);
            this.dettForm.disable();
            this.operazione = OPERAZIONE_COMP.DISMETTI;
          }, (error: Esito) => {
            this.setOperazioneNonValidaMessage(error);
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

  controlloModulo(event) {
    if (event && event.value === '1') {
      this.dettForm.controls.nModuli.setValue('1');
      this.dettForm.controls.nModuli.disable();
    } else {
      this.dettForm.controls.nModuli.enable();
      this.dettForm.controls.nModuli.setValue("");
    }
  }

  ripristina(gt) {
    if (this.currentDato) {
      this.currentDato.dataDismiss = this.datepipe.transform(new Date(), FORMAT);
      this.componenteService.checkSostituisciDismetti(this.currentDato.dataMinimaControllo, this.currentDato.dataMassimaControllo, this.currentDato.dataDismiss).subscribe(elem => {
        const index = this.gtDismessi.indexOf(gt, 0);
        this.gtDismessi.splice(index, 1);
        this.currentDato = gt;
        this.currentDato.dataDismiss = "";
        this.compilaForm(gt);
        this.dettForm.enable();
        this.dettForm.controls["dtInstall"].disable();
        if(this.dettForm.get('tipologia').value && this.dettForm.get('tipologia').value == '1')
        {
          this.dettForm.get('nModuli').disable();
        }
        this.operazione = OPERAZIONE_COMP.RIPRISTINA;
      }, (error: Esito) => {
        this.setOperazioneNonValidaMessage(error);
      });
    } else {
      const index = this.gtDismessi.indexOf(gt, 0);
      this.gtDismessi.splice(index, 1);
      this.currentDato = gt;
      this.compilaForm(gt);
      this.dettForm.enable();
      this.dettForm.controls["dtInstall"].disable();
      this.operazione = OPERAZIONE_COMP.RIPRISTINA;
    }
  }

  setOperazioneNonValidaMessage(error : Esito)
  {
    this.messageService.setTitolo("Operazione non valida");
    this.messageService.setDescrizione(error.descrizioneEsito);
    this.messageService.showMessaggioM();
    this.messageService.setType(2);
  }

  riattiva() {
    this.dettForm.enable();
    this.dettForm.controls["dtInstall"].disable();
    if(this.dettForm.get('tipologia').value && this.dettForm.get('tipologia').value == '1')
    {
      this.dettForm.get('nModuli').disable();
    }
    this.operazione = OPERAZIONE_COMP.MODIFICA;
    this.dettForm.controls.dtDismiss.setValue("");

  }

  modifica() {
    this.dettForm.enable();
    this.dettForm.controls["dtInstall"].disable();
    if(this.dettForm.get('tipologia').value && this.dettForm.get('tipologia').value == '1')
    {
      this.dettForm.get('nModuli').disable();
    }
    this.operazione = OPERAZIONE_COMP.MODIFICA;
  }



  sostituisci() {
    let dataDismiss = this.dettForm.controls.dtDismiss.value;
    if (dataDismiss && dataDismiss > this.dettForm.controls.dtInstall.value) {
      this.currentDato.dataDismiss = this.datepipe.transform(dataDismiss, FORMAT)
      this.componenteService.checkSostituisciDismetti(this.currentDato.dataMinimaControllo, this.currentDato.dataMassimaControllo, dataDismiss).subscribe(elem => {
        this.gtDismessi.push(this.currentDato);
        this.currentDato = undefined;
        this.dettForm.reset();
        this.dettForm.enable();
        this.operazione = OPERAZIONE_COMP.SOSTITUISCI;
        this.dettForm.get("dtInstall").setValidators([Validators.required, validateDateIstall(this.getLastDate())]);
        this.dettForm.get("dtInstall").updateValueAndValidity();
      }, (error: Esito) => {
        this.setOperazioneNonValidaMessage(error);
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
      let datiGT: DatiGTModel = this.compilaDatiGT();
      let newArray: DatiGTModel[] = [datiGT];
      newArray = newArray.concat(this.gtDismessi);
      this.componenteService.updateGT(this.codiceImpianto, newArray).subscribe((elem: Esito) => {
        this.router.navigate(["impianto/dettaglio-impianto/" + this.codiceImpianto, { success: true }]);
        this.dettForm.disable();
        this.messageService.setTitolo("Componente inserito correttamente");
        this.messageService.showMessaggioM();
        this.messageService.setType(4);
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
            data: { codiceImpianto: this.codiceImpianto, array: newArray, tipo: TIPI_COMP.GT }
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

  compilaForm(dato: DatiGTModel) {
    if (dato.dataInstall) {
      this.dettForm.controls["dtInstall"].setValue(new Date(dato.dataInstall));
    }
    if (dato.dataDismiss) {
      this.dettForm.controls["dtDismiss"].setValue(new Date(dato.dataDismiss));
    }
    this.dettForm.controls["fabbricante"].setValue(dato.fkMarca ? dato.fkMarca.toString() : dato.fkMarca);
    this.dettForm.controls["modello"].setValue(dato.modello ? dato.modello.toString() : dato.modello);
    this.dettForm.controls["matricola"].setValue(dato.matricola);
    this.dettForm.controls["combustibile"].setValue(dato.fkCombustibile ? dato.fkCombustibile.toString() : dato.fkCombustibile);
    this.dettForm.controls["fluido"].setValue(dato.fkFluido ? dato.fkFluido.toString() : dato.fkFluido);
    this.dettForm.controls["potenza"].setValue(dato.potenzaTermicaKw);
    this.dettForm.controls["rendimento"].setValue(dato.rendimentoPerc);
    this.dettForm.controls["tipologia"].setValue(dato.fkDettaglioGt ? dato.fkDettaglioGt.toString() : dato.fkDettaglioGt);
    if (dato.fkDettaglioGt && dato.fkDettaglioGt.toString() === '1') {
      this.dettForm.controls.nModuli.setValue('1');
      this.dettForm.controls.nModuli.disable();
    } else {
      this.dettForm.controls.nModuli.enable();
      this.dettForm.controls["nModuli"].setValue(dato.nModuli);
    }
    this.dettForm.controls["canna"].setValue(dato.idTipocannaFumaria ? dato.idTipocannaFumaria.toString() : dato.idTipocannaFumaria);
    this.dettForm.controls["nOre"].setValue(dato.mediImpOreOperative);
    this.dettForm.controls["nMantenimenti"].setValue(dato.tempoManutAnni);
    this.dettForm.controls["note"].setValue(dato.note);
    this.dettForm.get("dtInstall").setValidators([Validators.required, validateDateIstall(this.getLastDate())]);
    this.dettForm.get("dtInstall").updateValueAndValidity();
  }

  compilaDatiGT() {
    let dato = new DatiGTModel();
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
    dato.fkFluido = this.dettForm.controls["fluido"].value;
    dato.potenzaTermicaKw = this.dettForm.controls["potenza"].value;
    dato.rendimentoPerc = this.dettForm.controls["rendimento"].value;
    dato.fkDettaglioGt = this.dettForm.controls["tipologia"].value;
    dato.nModuli = this.dettForm.controls["nModuli"].value;
    dato.idTipocannaFumaria = this.dettForm.controls["canna"].value;
    dato.mediImpOreOperative = this.dettForm.controls["nOre"].value as number;
    dato.tempoManutAnni = this.dettForm.controls["nMantenimenti"].value as number;
    dato.note = this.dettForm.controls["note"].value;
    dato.idTipoComponente = 'GT';
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
    this.gtDismessi.forEach((element: DatiGTModel) => {
      if (new Date(element.dataDismiss) > new Date(date)) {
        result = false;
      }
    });
    return result;
  }


  getLastDate() {
    let result = this.gtDismessi[0] ? new Date(this.gtDismessi[0].dataDismiss) : undefined;
    this.gtDismessi.forEach((element: DatiGTModel) => {
      if (new Date(element.dataDismiss) > result) {
        result = new Date(element.dataDismiss);
      }
    });
    return result;
  }
}
