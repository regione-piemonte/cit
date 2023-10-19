import { DatePipe } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatDialog } from '@angular/material/dialog';
import { ActivatedRoute, Router } from '@angular/router';
import { CodiceDescrizione } from 'src/app/models/codice-descrizione';
import { DatiGFModel } from 'src/app/models/dati-gf.-model';
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
  selector: 'app-dettaglio-gf',
  templateUrl: './dettaglio-gf.component.html',
  styleUrls: ['./dettaglio-gf.component.scss']
})
export class DettaglioGfComponent implements OnInit {
  success = false;
  codiceImpianto: string = "";
  progr: string = "";

  fabbricanti: CodiceDescrizione[] = [];
  combustibili: CodiceDescrizione[] = [];
  fonte: CodiceDescrizione[] = [];
  tipologiaGF: CodiceDescrizione[] = [];

  dettForm: FormGroup;

  datiGF: DatiGFModel[] = [];
  currentDato: DatiGFModel;
  gfDismessi: DatiGFModel[] = [];

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
      dtDismiss: [],
      fabbricante: ["", [Validators.required]],
      modello: ["", [Validators.required]],
      matricola: ["", [Validators.required]],
      combustibile: [],
      potenza: ["", [Validators.required]],
      flgSorgente: [, [Validators.required]],
      flgFluido: [, [Validators.required]],
      fluidoFrigorigeno: ["", [Validators.required]],
      nCircuiti: ["", [Validators.required, Validators.pattern(/^[1-9][0-9]*$/)]],
      raffrescamentoEE: [],
      raffPotKw: ["", [Validators.required]],
      raffPotAss: [],
      riscCop: [],
      riscPotKw: [],
      riscPotAss: [],
      fonteEn: [, [Validators.required]],
      nMantenimenti: [, [Validators.required, Validators.pattern(/^[1-9][0-9]*$/)]],
      note: [],
      tipologia: ["", Validators.required],
    });
  }

  ngOnInit(): void {
    this.titleService.setTitle("Dettaglio GF");
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

    this.componenteService.getTipologiaGF().subscribe((elem: CodiceDescrizione[]) => {
      this.tipologiaGF = elem;
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
    this.componenteService.getGF(this.codiceImpianto, this.progr).subscribe((elem: DatiGFModel[]) => {
      this.datiGF = elem;
      this.preparaDati();
    }, (error: Esito) => {
      this.messageService.setTitolo("Errore recupero dati");
      this.messageService.setDescrizione(error.descrizioneEsito);
      this.messageService.showMessaggioM();
      this.messageService.setType(2);
    });
  }

  preparaDati() {
    this.gfDismessi = [];
    this.currentDato = undefined;
    this.datiGF.forEach(element => {
      if (!element.dataDismiss) {
        this.currentDato = element;
      }
    });

    if (!this.currentDato) {
      this.currentDato = this.datiGF[0];
    }

    this.gfDismessi = this.datiGF;
    const index = this.gfDismessi.indexOf(this.currentDato, 0);
    this.gfDismessi.splice(index, 1);

    this.compilaForm(this.currentDato);
    this.dettForm.disable();
  }

  compilaForm(dato: DatiGFModel) {
    this.dettForm.patchValue({
      dtInstall: dato.dataInstall ? new Date(dato.dataInstall) : '',
      dtDismiss: dato.dataDismiss ? new Date(dato.dataDismiss) : '',
      fabbricante: dato.fkMarca ? dato.fkMarca.toString() : dato.fkMarca,
      modello: dato.modello,
      matricola: dato.matricola,
      combustibile: dato.fkCombustibile ? dato.fkCombustibile.toString() : dato.fkCombustibile,
      fluido: dato.flgFluidoUtenze,
      potenza: dato.potenzaTermicaKw,
      flgSorgente: dato.flgSorgenteExt,
      flgFluido: dato.flgFluidoUtenze,
      fluidoFrigorigeno: dato.fluidoFrigorigenodi,
      nCircuiti: dato.nCircuiti,
      raffrescamentoEE: dato.raffrescamentoEer,
      raffPotKw: dato.raffPotenzaKw,
      raffPotAss: dato.raffPotenzaAss,
      riscCop: dato.riscaldamentoCop,
      riscPotKw: dato.riscPotenzaKw,
      riscPotAss: dato.riscPotenzaAssKw,
      fonteEn: dato.idFonteEnSfruttata ? dato.idFonteEnSfruttata.toString() : dato.idFonteEnSfruttata,
      nMantenimenti: dato.tempoManutAnni,
      tipologia: dato.fkDettaglioGf ? dato.fkDettaglioGf.toString() : "",
      note: dato.note
    });
    if (dato.fkDettaglioGf && dato.fkDettaglioGf.toString() === '2') {
      this.dettForm.controls.combustibile.setValidators(Validators.required);
      this.dettForm.controls.combustibile.updateValueAndValidity();
    }
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
          this.currentDato = this.compilaDatiGF();
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

  ripristina(gf) {
    if (this.currentDato) {
      this.currentDato.dataDismiss = this.datepipe.transform(new Date(), FORMAT);
      this.componenteService.checkSostituisciDismetti(this.currentDato.dataMinimaControllo, this.currentDato.dataMassimaControllo, this.currentDato.dataDismiss).subscribe(elem => {
        const index = this.gfDismessi.indexOf(gf, 0);
        this.gfDismessi.splice(index, 1);
        this.currentDato = gf;
        this.currentDato.dataDismiss = "";
        this.compilaForm(gf);
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
      const index = this.gfDismessi.indexOf(gf, 0);
      this.gfDismessi.splice(index, 1);
      this.currentDato = gf;
      this.compilaForm(gf);
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
        this.gfDismessi.push(this.currentDato);
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
      let datiGF: DatiGFModel = this.compilaDatiGF();
      let newArray: DatiGFModel[] = [datiGF];
      newArray = newArray.concat(this.gfDismessi);
      this.componenteService.updateGF(this.codiceImpianto, newArray).subscribe((elem: Esito) => {
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
            data: { codiceImpianto: this.codiceImpianto, array: newArray, tipo: TIPI_COMP.GF }
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

  compilaDatiGF() {
    let dato = new DatiGFModel();
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
    dato.potenzaTermicaKw = this.dettForm.controls["potenza"].value;
    dato.nCircuiti = this.dettForm.controls["nCircuiti"].value;
    dato.tempoManutAnni = this.dettForm.controls["nMantenimenti"].value;
    dato.note = this.dettForm.controls["note"].value;
    dato.idTipoComponente = 'GF';
    dato.progressivo = parseInt(this.progr);
    dato.flgSorgenteExt = this.dettForm.controls["flgSorgente"].value;
    dato.flgFluidoUtenze = this.dettForm.controls["flgFluido"].value;
    dato.fluidoFrigorigenodi = this.dettForm.controls["fluidoFrigorigeno"].value;
    dato.nCircuiti = this.dettForm.controls["nCircuiti"].value;
    dato.raffPotenzaKw = this.dettForm.controls["raffPotKw"].value;
    dato.raffPotenzaAss = this.dettForm.controls["raffPotAss"].value;
    dato.riscaldamentoCop = this.dettForm.controls["riscCop"].value;
    dato.riscPotenzaKw = this.dettForm.controls["riscPotKw"].value;
    dato.riscPotenzaAssKw = this.dettForm.controls["riscPotAss"].value;
    dato.idFonteEnSfruttata = this.dettForm.controls["fonteEn"].value;
    dato.raffrescamentoEer = this.dettForm.controls["raffrescamentoEE"].value;
    dato.fkDettaglioGf = this.dettForm.controls["tipologia"].value;
    return dato;
  }

  getDate(data: string) {
    if (data)
      return this.datepipe.transform(data, DISPLAY_FORMAT);
    else
      return "-";
  }

  selectTipologia($event) {
    console.log($event.value === "2");
    if ($event.value === "2") {
      this.dettForm.controls.combustibile.setValidators(Validators.required);
    } else {
      this.dettForm.controls.combustibile.clearValidators();
    }
    this.dettForm.controls.combustibile.updateValueAndValidity();
  }

  myFilter = (d: Date | null): boolean => {
    if (this.operazione != OPERAZIONE_COMP.SOSTITUISCI)
      return this.operazione != OPERAZIONE_COMP.SOSTITUISCI && d < new Date();
    else
      return d > this.getLastDate();
  };

  isLastDate(date) {
    let result = true;
    this.gfDismessi.forEach((element: DatiGFModel) => {
      if (new Date(element.dataDismiss) > new Date(date)) {
        result = false;
      }
    });
    return result;
  }

  getLastDate() {
    let result = this.gfDismessi[0] ? new Date(this.gfDismessi[0].dataDismiss) : undefined;
    this.gfDismessi.forEach((element: DatiGFModel) => {
      if (new Date(element.dataDismiss) > result) {
        result = new Date(element.dataDismiss);
      }
    });
    return result;
  }
}
