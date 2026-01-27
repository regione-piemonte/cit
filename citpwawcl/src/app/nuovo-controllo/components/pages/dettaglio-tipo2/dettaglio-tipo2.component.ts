import { NumberInput } from '@angular/cdk/coercion';
import { DatePipe } from '@angular/common';
import { Component, HostListener, OnInit } from '@angular/core';
import { FormArray, FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { tipiDocDesc, TipoDoc } from 'src/app/enums/tipo-doc-enum';
import { ControlloDisponibileModel } from 'src/app/models/controllo-disponibile';
import { ControlloModel } from 'src/app/models/controllo-model';
import { DatiGFModel } from 'src/app/models/dati-gf.-model';
import { DatoControlloModel } from 'src/app/models/dato-controllo-model';
import { Esito } from 'src/app/models/esito';
import {
    Allegato, CheckList, ControlloImpianto, ControlloVerificaEnergetica,
    datiAllegato, DatiIdentificativi, DatiIntestazione, DatiManutentore, DatiTecnico, DocumentazioneTecnica, Mod,
    Richiesta, RowAllegato, RowFumi, TabFumi, TrattamentoAcqua
} from 'src/app/models/mod';
import { OnlineCheckModel } from 'src/app/models/online-check-model';
import { OperazioneControlloModel } from 'src/app/models/operazione-controllo-model';
import { UtenteLoggato } from 'src/app/models/utente-loggato';
import { validateTrattamentoAcqua } from 'src/app/nuovo-controllo/directives/validator-directive.directive';
import { AuthenticationService } from 'src/app/services/authentication.service';
import { BackService } from 'src/app/services/back.service';
import { ControlloService } from 'src/app/services/controllo.service';
import { LocalStorageServiceService } from 'src/app/services/local-storage-service.service';
import { MessageService } from 'src/app/services/message.service';
import { ResultService } from 'src/app/services/result.service';
import { TitleService } from 'src/app/services/title.service';
import { DISPLAY_FORMAT, ESITO_OPERAZIONI, FORMAT, OPERAZIONI, STATO_RAPP, TRATT_ACQUA } from 'src/app/utils/constants';
import { formatoDecimale } from 'src/app/validators/custom.validator';
import { v4 as uuidv4 } from 'uuid';

@Component({
  selector: 'app-dettaglio-tipo2',
  templateUrl: './dettaglio-tipo2.component.html',
  styleUrls: ['./dettaglio-tipo2.component.scss']
})
export class DettaglioTipo2Component implements OnInit {


  success = false;
  offline = false;

  insertForm = this.fb.group({
    dataControllo: [{ value: '', disabled: true }],
    tipoControllo: [{ value: '', disabled: true }],
    ree: [{ value: '', disabled: true, }],
    datiIdentificativi: this.fb.group({
      potenzaTermica: ['', [Validators.required, formatoDecimale(/^[0-9]{0,6}(?:\.[0-9]{0,2})?$/, 6, 2)]]
    }),
    docTecnica: this.fb.group({
      dichiarazioneDiConformita: [false, Validators.required],
      librettoPresente: [false, Validators.required],
      librettoUso: [false, Validators.required],
      librettoCompilato: [false, Validators.required],
    }),
    trattamentoAcqua: this.fb.group({}),
    controlloImpianto: this.fb.group({
      localeIdoneo: ["", Validators.required],
      dimensioni: ["", Validators.required],
      aperture: ["", Validators.required],
      lineeIdonee: ["", Validators.required],
      coiben: ["", Validators.required],
    }),
    controlloEnergetico: this.fb.array([]),
    checkList: this.fb.group({
      sostGen1: [false],
      sostGen2: [false],
      isolamentoRete: [false],
      isolamentoCanali: [false],
      osservazioni: ['', Validators.maxLength(1000)],
      raccomandazioni: ['', Validators.maxLength(1000)],
      prescrizioni: ['', Validators.maxLength(1000)],
      funzImp: [true, Validators.required],
      dtIntervento: ['', Validators.required]
    }),
    tecnico: this.fb.group({
      nomeCognome: ['', Validators.required],
      orarioArrivo: [''],
      orarioPartenza: ['']
    })
  });

  controlloDisponibile: ControlloDisponibileModel;
  dettaglioControllo: DatoControlloModel;
  xmlImpianto: any;
  codiceImpianto: string;
  idAllegato: string;
  idAllegatoNew: string;
  utente: UtenteLoggato;

  colBreakpoint1: NumberInput;
  colBreakpoint2: NumberInput;
  colBreakpoint3: NumberInput;
  colBreakpoint4: NumberInput;

  constructor(private route: ActivatedRoute,
    private fb: FormBuilder,
    private readonly controlloService: ControlloService,
    private authenticationService: AuthenticationService,
    private router: Router,
    private readonly titleService: TitleService,
    private readonly backService: BackService,
    private readonly messageService: MessageService,
    private resultService: ResultService,
    private localStorageService: LocalStorageServiceService,
    public datePipe: DatePipe) {
    this.codiceImpianto = this.route.snapshot.parent.paramMap.get('id_impianto');
    this.idAllegato = this.route.snapshot.paramMap.get('id_allegato');
    this.utente = this.authenticationService.getCurrentUserFromSession();
  }

  ngOnInit(): void {
    this.colBreakpoint1 = (window.innerWidth < 768) ? 12 : 6;
    this.colBreakpoint2 = (window.innerWidth < 768) ? 0 : 6;
    this.colBreakpoint3 = (window.innerWidth < 768) ? 10 : 5;
    this.colBreakpoint4 = (window.innerWidth < 768) ? 1 : 0;

    this.xmlImpianto = this.localStorageService.getXmlImpianto();
    this.titleService.setTitle("REE TIPO 2");
    this.titleService.setSubtitle("Gruppi frigo");
    this.insertForm.controls.tipoControllo.setValue("REE");
    if (this.resultService.getResultControllo()) {
      this.dettaglioControllo = this.resultService.getResultControllo();
    } else {
      this.controlloDisponibile = this.resultService.getResultControlloDisponibile();
    }
    if ((!this.controlloDisponibile) && (!this.dettaglioControllo)) {
      this.router.navigate(["/impianto/dettaglio/" + this.codiceImpianto + "/elenco-controlli"]);
    }

    if (this.idAllegato || (this.dettaglioControllo && this.dettaglioControllo.tempIdControllo)) {
      this.backService.setBackTitle("Torna ai controlli");
      this.backService.setRoute("/impianto/dettaglio/" + this.codiceImpianto + "/elenco-controlli");
      this.compilaDatiDettaglio();
    } else {
      this.backService.setBackTitle("Torna ai risultati");
      this.backService.setRoute("/impianto/dettaglio/" + this.codiceImpianto + "/elenco-controlli/cerca-controlli");
      this.compilaDatiIniziali();
    }

    this.controlloService.getOnlineSubject().subscribe((elem) => {
      this.offline = !elem;
    });
  }

  @HostListener('window:resize', ['$event'])
  onResize(event?) {
    this.colBreakpoint1 = (event.target.innerWidth < 768) ? 12 : 6;
    this.colBreakpoint2 = (event.target.innerWidth < 768) ? 0 : 6;
    this.colBreakpoint3 = (event.target.innerWidth < 768) ? 10 : 5;
    this.colBreakpoint4 = (event.target.innerWidth < 768) ? 1 : 0;
  }

  compilaDatiIniziali() {
    let arr = this.getControlloEner();
    let datacontrollo = this.datePipe.transform(this.controlloDisponibile.dataControllo, DISPLAY_FORMAT);
    this.insertForm.controls.dataControllo.setValue(datacontrollo);
    this.insertForm.controls.ree.setValue(tipiDocDesc.get(TipoDoc.REE_2));
    let dataInstall = this.datePipe.transform(this.controlloDisponibile.dataInstall, DISPLAY_FORMAT);
    const enerForm = this.fb.group({
      comp: [{ value: "GF-" + this.controlloDisponibile.progressivo, disabled: true }],
      dataInstall: [{ value: dataInstall, disabled: true }],
      fabbricante: [{ value: this.controlloDisponibile.descMarca, disabled: true }],
      modello: [{ value: this.controlloDisponibile.modello, disabled: true }],
      matricola: [{ value: this.controlloDisponibile.matricola, disabled: true }],
      tipo: [{ value: this.controlloDisponibile.descDettaglio, disabled: true }],
      potTermicaKw: [{ value: this.controlloDisponibile.potTermica, disabled: true }],
      raffPotKw: [{ value: this.controlloDisponibile.potTermicaRaff, disabled: true }],
      riscPotKw: [{ value: this.controlloDisponibile.potTermicaRisc, disabled: true }],
      modalita: ["", [Validators.required]],
      perdite: ["", [Validators.required]],
      fugheDiretta: ["", [Validators.required]],
      fugheIndiretta: ["", [Validators.required]],
      scambPuliti: ["", [Validators.required]],
      elencoCircuiti: this.fb.array([])
    });
    arr.push(enerForm);
    let arr2 = enerForm.controls.elencoCircuiti as FormArray;
    for (let i = 0; i < this.controlloDisponibile.nModuli; i++) {
      const moduloForm = this.fb.group({
        surrisc: ["", [Validators.required, formatoDecimale(/^-?[0-9]{0,5}(?:\.[0-9]{0,2})?$/, 5, 2)]],
        sottoRaffr: ["", [Validators.required, formatoDecimale(/^-?[0-9]{0,5}(?:\.[0-9]{0,2})?$/, 5, 2)]],
        condens: ["", [Validators.required, formatoDecimale(/^-?[0-9]{0,5}(?:\.[0-9]{0,2})?$/, 5, 2)]],
        evaporaz: ["", [Validators.required, formatoDecimale(/^-?[0-9]{0,5}(?:\.[0-9]{0,2})?$/, 5, 2)]],
        ingLatoEst: ["", [Validators.required, formatoDecimale(/^-?[0-9]{0,5}(?:\.[0-9]{0,2})?$/, 5, 2)]],
        uscLatoEst: ["", [Validators.required, formatoDecimale(/^-?[0-9]{0,5}(?:\.[0-9]{0,2})?$/, 5, 2)]],
        ingLatoUtenze: ["", [Validators.required, formatoDecimale(/^-?[0-9]{0,5}(?:\.[0-9]{0,2})?$/, 5, 2)]],
        uscLatoUtenze: ["", [Validators.required, formatoDecimale(/^-?[0-9]{0,5}(?:\.[0-9]{0,2})?$/, 5, 2)]],
        tuscFluido: ["", [Validators.required, formatoDecimale(/^-?[0-9]{0,5}(?:\.[0-9]{0,2})?$/, 5, 2)]],
        bulboUmido: ["", [Validators.required, formatoDecimale(/^-?[0-9]{0,5}(?:\.[0-9]{0,2})?$/, 5, 2)]],
        ingFluidoSorg: ["", [Validators.required, formatoDecimale(/^-?[0-9]{0,5}(?:\.[0-9]{0,2})?$/, 5, 2)]],
        uscFluidoSorg: ["", [Validators.required, formatoDecimale(/^-?[0-9]{0,5}(?:\.[0-9]{0,2})?$/, 5, 2)]],
        ingFluidoMac: ["", [Validators.required, formatoDecimale(/^-?[0-9]{0,5}(?:\.[0-9]{0,2})?$/, 5, 2)]],
        uscFluidoMac: ["", [Validators.required, formatoDecimale(/^-?[0-9]{0,5}(?:\.[0-9]{0,2})?$/, 5, 2)]],
        potAss: ["", [Validators.required, formatoDecimale(/^[0-9]{0,5}(?:\.[0-9]{0,2})?$/, 5, 2)]],
        filtriPuliti: [false, Validators.required],
        verifica: [false, Validators.required],
        dataRipristino: [""],
      });
      arr2.push(moduloForm);
    }
    let trattH2o = this.xmlImpianto.Richiesta.datiSchedaTrattH2O;
    let trattRsc = "";
    if (trattH2o) {
      if (trattH2o.L2_3flagAssenteH2Oclima) {
        trattRsc = TRATT_ACQUA.DESC_ASSENTE;
      } else if (trattH2o.L2_3flagFiltrazione) {
        trattRsc = TRATT_ACQUA.DESC_FILTRAZIONE;
      } else if (trattH2o.L2_3flagAddolcimento) {
        trattRsc = TRATT_ACQUA.DESC_ADDOLCIMENTO;
      } else if (trattH2o.L2_3flagCondizChimico) {
        trattRsc = TRATT_ACQUA.DESC_CONDIZ_CHIMICO;
      }
    }

    this.insertForm.controls["trattamentoAcqua"] = this.fb.group({
      richiestoRiscaldamento: [false, [validateTrattamentoAcqua(trattRsc)]],
      durezza: { value: (trattH2o ? trattH2o.L2_2durezzaTotaleH2O : ""), disabled: true },
      trattamentoRiscaldamento: { value: trattRsc, disabled: true },
    });
  }

  compilaDatiDettaglio() {
    if (this.dettaglioControllo) {
      let xml: Mod = this.dettaglioControllo.xmlControllo;
      let datiIdentificativi: DatiIdentificativi = xml.richiesta.datiAllegato.datiIdentificativi;
      let docTecnica: DocumentazioneTecnica = xml.richiesta.datiAllegato.documentazioneTecnica;
      let trattamentoAcqua: TrattamentoAcqua = xml.richiesta.datiAllegato.trattamentoAcqua;
      let trattH2o = this.xmlImpianto.Richiesta.datiSchedaTrattH2O;
      let controlloImpianto: ControlloImpianto = xml.richiesta.datiAllegato.controlloImpianto;
      let rowAllegato: RowAllegato[] = xml.richiesta.datiAllegato.allegato.rowAllegato;
      let checklist: CheckList = xml.richiesta.datiAllegato.checkList;
      let datiTecnico: DatiTecnico = xml.richiesta.datiAllegato.datiTecnico;
      let datacontrollo = this.datePipe.transform(this.dettaglioControllo.controlloModel.dataControllo, DISPLAY_FORMAT);
      this.insertForm.controls.dataControllo.setValue(datacontrollo);
      this.insertForm.controls.ree.setValue(this.dettaglioControllo.controlloModel.desTipoDocumento);
      if (datiIdentificativi) {
        this.insertForm.controls["datiIdentificativi"].patchValue({
          potenzaTermica: datiIdentificativi.potenzaTermicaNomTotMax
        });
      }

      if (docTecnica) {
        this.insertForm.controls["docTecnica"].patchValue({
          dichiarazioneDiConformita: docTecnica.flagDichiarazConf,
          librettoPresente: docTecnica.flagLibrettoImp,
          librettoUso: docTecnica.flagManutGen,
          librettoCompilato: docTecnica.flagLibrettoComp
        });
      }

      if (trattamentoAcqua) {
        let trattRsc = "";
        if (trattH2o) {
          if (trattH2o.L2_3flagAssenteH2Oclima) {
            trattRsc = TRATT_ACQUA.DESC_ASSENTE;
          } else if (trattH2o.L2_3flagFiltrazione) {
            trattRsc = TRATT_ACQUA.DESC_FILTRAZIONE;
          } else if (trattH2o.L2_3flagAddolcimento) {
            trattRsc = TRATT_ACQUA.DESC_ADDOLCIMENTO;
          } else if (trattH2o.L2_3flagCondizChimico) {
            trattRsc = TRATT_ACQUA.DESC_CONDIZ_CHIMICO;
          }
        }
        this.insertForm.controls["trattamentoAcqua"] = this.fb.group({
          richiestoRiscaldamento: [trattamentoAcqua.flagTrattH2ONR, [validateTrattamentoAcqua(trattRsc)]],
          durezza: { value: trattH2o ? trattH2o.L2_2durezzaTotaleH2O : "", disabled: true },
          trattamentoRiscaldamento: { value: trattRsc, disabled: true },
        });
      }

      if (controlloImpianto) {
        this.insertForm.controls["controlloImpianto"].patchValue({
          localeIdoneo: controlloImpianto.flagLocaleIdoneo,
          dimensioni: controlloImpianto.flagDimensioni,
          aperture: controlloImpianto.flagAperture,
          lineeIdonee: controlloImpianto.flagLineeIdonee,
          coiben: controlloImpianto.flagCoibenIdonee
        });
      }

      rowAllegato.forEach((row: RowAllegato) => {
        this.dettaglioControllo.datiCompModelList.forEach((gf: DatiGFModel) => {
          if (row.num == gf.progressivo && !gf.dataDismiss) {
            this.addControlloEner(row, gf);
          }
        });
      });

      if (checklist) {
        this.insertForm.controls["checkList"].patchValue({
          sostGen1: checklist.flagSostGen1,
          sostGen2: checklist.flagSostGen2,
          isolamentoRete: checklist.flagIsolamentoRete,
          isolamentoCanali: checklist.flagIsolamentoCanali,
          osservazioni: checklist.osservazioni,
          raccomandazioni: checklist.raccomandazioni,
          prescrizioni: checklist.prescrizioni,
          funzImp: datiTecnico ? datiTecnico.flagFunzImp : "",
          dtIntervento: datiTecnico && datiTecnico.dataIntervento ? new Date(datiTecnico.dataIntervento) : ""
        });
      }

      if (datiTecnico) {
        let nome = datiTecnico.nomeTecnico ? datiTecnico.nomeTecnico + " " : '';
        nome += datiTecnico.cognomeTecnico ? datiTecnico.cognomeTecnico : '';
        this.insertForm.controls["tecnico"].patchValue({
          nomeCognome: nome,
          orarioArrivo: datiTecnico.orarioArrivo,
          orarioPartenza: datiTecnico.orarioPartenza
        });
      }
    }
  }

  getControlloEner() {
    return this.insertForm.get("controlloEnergetico") as FormArray;
  }

  addControlloEner(elem: RowAllegato, gf: DatiGFModel) {
    let controlloEnergetico = elem.controlloVerificaEnergetica
    let contEnerArr = this.getControlloEner();
    let dataInstall = this.datePipe.transform(gf.dataInstall, DISPLAY_FORMAT);
    const enerForm = this.fb.group({
      comp: [{ value: "GF-" + gf.progressivo, disabled: true }],
      dataInstall: [{ value: dataInstall, disabled: true }],
      fabbricante: [{ value: gf.desMarca, disabled: true }],
      modello: [{ value: gf.modello, disabled: true }],
      matricola: [{ value: gf.matricola, disabled: true }],
      tipo: [{ value: gf.desDettaglioGf, disabled: true }],
      potTermicaKw: [{ value: gf.potenzaTermicaKw, disabled: true }],
      raffPotKw: [{ value: gf.raffPotenzaKw, disabled: true }],
      riscPotKw: [{ value: gf.riscPotenzaKw, disabled: true }],
      modalita: [controlloEnergetico.flagModalita, [Validators.required]],
      perdite: [controlloEnergetico.flagPerdite, [Validators.required]],
      fugheDiretta: [controlloEnergetico.flagRilevFugheDiretta, [Validators.required]],
      fugheIndiretta: [controlloEnergetico.flagRilevFugheInDiretta, [Validators.required]],
      scambPuliti: [controlloEnergetico.flagScambPuliti, [Validators.required]],
      elencoCircuiti: this.fb.array([])
    });
    contEnerArr.push(enerForm);
    elem.tabFumi.rowFumi.forEach((row: RowFumi) => {
      let rowFumiArr = enerForm.controls.elencoCircuiti as FormArray;
      const rowFumiForm = this.fb.group({
        surrisc: [row.surrisc, [Validators.required, formatoDecimale(/^-?[0-9]{0,5}(?:\.[0-9]{0,2})?$/, 5, 2)]],
        sottoRaffr: [row.sottoRaffr, [Validators.required, formatoDecimale(/^-?[0-9]{0,5}(?:\.[0-9]{0,2})?$/, 5, 2)]],
        condens: [row.condens, [Validators.required, formatoDecimale(/^-?[0-9]{0,5}(?:\.[0-9]{0,2})?$/, 5, 2)]],
        evaporaz: [row.evaporaz, [Validators.required, formatoDecimale(/^-?[0-9]{0,5}(?:\.[0-9]{0,2})?$/, 5, 2)]],
        ingLatoEst: [row.ingLatoEst, [Validators.required, formatoDecimale(/^-?[0-9]{0,5}(?:\.[0-9]{0,2})?$/, 5, 2)]],
        uscLatoEst: [row.uscLatoEst, [Validators.required, formatoDecimale(/^-?[0-9]{0,5}(?:\.[0-9]{0,2})?$/, 5, 2)]],
        ingLatoUtenze: [row.ingLatoUtenze, [Validators.required, formatoDecimale(/^-?[0-9]{0,5}(?:\.[0-9]{0,2})?$/, 5, 2)]],
        uscLatoUtenze: [row.uscLatoUtenze, [Validators.required, formatoDecimale(/^-?[0-9]{0,5}(?:\.[0-9]{0,2})?$/, 5, 2)]],
        tuscFluido: [row.tuscFluido, [Validators.required, formatoDecimale(/^-?[0-9]{0,5}(?:\.[0-9]{0,2})?$/, 5, 2)]],
        bulboUmido: [row.tbulboUmido, [Validators.required, formatoDecimale(/^-?[0-9]{0,5}(?:\.[0-9]{0,2})?$/, 5, 2)]],
        ingFluidoSorg: [row.tingFluidoSorg, [Validators.required, formatoDecimale(/^-?[0-9]{0,5}(?:\.[0-9]{0,2})?$/, 5, 2)]],
        uscFluidoSorg: [row.tuscFluidoSorg, [Validators.required, formatoDecimale(/^-?[0-9]{0,5}(?:\.[0-9]{0,2})?$/, 5, 2)]],
        ingFluidoMac: [row.tingFluidoMacc, [Validators.required, formatoDecimale(/^-?[0-9]{0,5}(?:\.[0-9]{0,2})?$/, 5, 2)]],
        uscFluidoMac: [row.tuscFluidoMacc, [Validators.required, formatoDecimale(/^-?[0-9]{0,5}(?:\.[0-9]{0,2})?$/, 5, 2)]],
        potAss: [row.potenzaAss, [Validators.required, formatoDecimale(/^[0-9]{0,5}(?:\.[0-9]{0,2})?$/, 5, 2)]],
        filtriPuliti: [row.filtriPuliti, Validators.required],
        verifica: [row.verifica, Validators.required],
        dataRipristino: [row.dataRipristino ? new Date(row.dataRipristino) : ""],
      });
      rowFumiArr.push(rowFumiForm);
    });
  }

  onSubmit() {
    let operation = undefined;
    if (this.insertForm.valid) {
      let nuovoControllo: DatoControlloModel = this.creaBozza();
      this.localStorageService.addBozzeLocali(nuovoControllo, this.codiceImpianto);
      operation = this.createOperazioneOffline(nuovoControllo, OPERAZIONI.INVIO);
      this.controlloService.modificaREE(this.idAllegato ? this.idAllegato : this.idAllegatoNew, this.codiceImpianto, nuovoControllo.controlloModel.fkTipoDocumento, true, nuovoControllo.xmlControllo, operation).subscribe(elem => {
        this.localStorageService.delBozzaLocale(nuovoControllo.tempIdControllo, this.codiceImpianto);
        this.router.navigate(["/impianto/dettaglio/" + this.codiceImpianto + "/elenco-controlli", { success: true }]);
      }, error => {
        if (error instanceof OnlineCheckModel) {
          let bozza = this.localStorageService.getBozzaLocaleByTempId(nuovoControllo.tempIdControllo, this.codiceImpianto);
          bozza.fkStatoPrec = STATO_RAPP.BOZZA_LOCALE;
          bozza.controlloModel.fkStatoRapp = STATO_RAPP.IN_ATTESA_DI_INVIO;
          this.localStorageService.updateBozzaLocale(bozza, nuovoControllo.tempIdControllo, this.codiceImpianto);
          this.router.navigate(["/impianto/dettaglio/" + this.codiceImpianto + "/elenco-controlli", { success: true }]);
        } else {
          let errore = error.error as Esito;
          if (errore.idAllegatoNew) {
            this.idAllegatoNew = errore.idAllegatoNew.toString();
          }
          this.messageService.setType(2);
          this.messageService.setTitolo("Errore invio controllo");
          this.messageService.setDescrizione(errore.descrizioneEsito);
          this.messageService.showMessaggioM();
          this.localStorageService.delBozzaLocale(nuovoControllo.tempIdControllo, this.codiceImpianto);
        }
      });
    } else {
      this.insertForm.markAllAsTouched();
      this.messageService.setType(2);
      this.messageService.setTitolo("Dati controllo mancanti");
      this.messageService.setDescrizione("Compilare tutti i campi e riprovare");
      this.messageService.showMessaggioM();
    }
  }

  creaBozza() {
    let uuid = uuidv4();
    if (this.idAllegato || (this.dettaglioControllo && this.dettaglioControllo.tempIdControllo)) {
      this.localStorageService.delBozzaLocale(this.dettaglioControllo.tempIdControllo, this.codiceImpianto);
      let mod = this.compilaControllo();
      this.dettaglioControllo.xmlControllo = mod;
      this.dettaglioControllo.controlloModel.fkStatoRapp = STATO_RAPP.BOZZA_LOCALE;
      this.dettaglioControllo.tempIdControllo = uuid;
      let checkList = this.insertForm.controls["checkList"].value;
      this.dettaglioControllo.controlloModel.fInterventoEntro = checkList.interventoEntro ? this.datePipe.transform(checkList.interventoEntro, FORMAT) : "";
      if (this.idAllegato) {
        this.dettaglioControllo.fkStatoPrec = STATO_RAPP.BOZZA;
      }
      return this.dettaglioControllo;
    } else {
      let mod = this.creaControllo();
      let datoCont: DatoControlloModel = new DatoControlloModel();
      datoCont.tempIdControllo = uuid;
      datoCont.xmlControllo = mod;
      datoCont.controlloModel = new ControlloModel();
      datoCont.controlloModel.fkStatoRapp = STATO_RAPP.BOZZA_LOCALE;
      datoCont.controlloModel.dataControllo = this.controlloDisponibile.dataControllo;
      datoCont.controlloModel.desTipoDocumento = tipiDocDesc.get(TipoDoc.REE_2);
      datoCont.controlloModel.fkTipoDocumento = Number(TipoDoc.REE_2);
      datoCont.controlloModel.elencoApparecchiatura = this.controlloDisponibile.tipoComponente + "-" + this.controlloDisponibile.progressivo;
      let checkList = this.insertForm.controls["checkList"].value;
      datoCont.controlloModel.fInterventoEntro = checkList.interventoEntro ? this.datePipe.transform(checkList.interventoEntro, FORMAT) : "";
      datoCont.datiCompModelList = [];
      let datoGF: DatiGFModel = new DatiGFModel();
      datoGF.progressivo = this.controlloDisponibile.progressivo;
      datoGF.dataInstall = this.controlloDisponibile.dataInstall;
      datoGF.desMarca = this.controlloDisponibile.descMarca;
      datoGF.modello = this.controlloDisponibile.modello;
      datoGF.matricola = this.controlloDisponibile.matricola;
      datoGF.desDettaglioGf = this.controlloDisponibile.descDettaglio;
      datoGF.potenzaTermicaKw = this.controlloDisponibile.potTermica ? Number(this.controlloDisponibile.potTermica) : 0;
      datoGF.desCombustibile = this.controlloDisponibile.descCombustibile;
      datoGF.cf = this.controlloDisponibile.cfPIvaImpresa;
      datoGF.siglaRea = this.controlloDisponibile.siglaReaImpresa;
      datoGF.numeroRea = this.controlloDisponibile.numeroReaImpresa;
      datoGF.nCircuiti = this.controlloDisponibile.nModuli;
      datoGF.raffPotenzaKw = this.controlloDisponibile.potTermicaRaff;
      datoGF.riscPotenzaKw = this.controlloDisponibile.potTermicaRisc;
      datoCont.datiCompModelList.push(datoGF);
      return datoCont;
    }
  }

  salvaBozza() {
    let controllo: DatoControlloModel = this.creaBozza();
    this.localStorageService.addBozzeLocali(controllo, this.codiceImpianto);
    this.router.navigate(["/impianto/dettaglio/" + this.codiceImpianto + "/elenco-controlli", { success: true }]);
  }

  step = 0;
  setStep(index: number) {
    this.step = index;
  }

  createOperazioneOffline(controllo: DatoControlloModel, descOperazione: string) {
    let operazione = new OperazioneControlloModel();
    operazione.codiceImpianto = this.codiceImpianto;
    operazione.idOperazione = controllo.tempIdControllo;
    operazione.dataControllo = controllo.controlloModel.dataControllo;
    operazione.dataInserimento = this.datePipe.transform(new Date(), FORMAT);
    operazione.dataInvioOnline = undefined;
    operazione.descrizioneOperazione = descOperazione;
    operazione.utente = this.utente;
    operazione.esito = ESITO_OPERAZIONI.PENDING;
    return operazione;
  }


  compilaControllo(): Mod {
    let xml: Mod = this.dettaglioControllo.xmlControllo as Mod;
    let datiIdentificativi = this.insertForm.controls["datiIdentificativi"].value;
    let docTecnica = this.insertForm.controls["docTecnica"].value;
    let trattamentoAcqua = this.insertForm.controls["trattamentoAcqua"].value;
    let controlloImpianto = this.insertForm.controls["controlloImpianto"].value;
    let controlloEnergetico = this.insertForm.controls["controlloEnergetico"].value;
    let tecnico = this.insertForm.controls["tecnico"].value;
    let checkList = this.insertForm.controls["checkList"].value;
    xml.richiesta.datiAllegato.datiIdentificativi.potenzaTermicaNomTotMax = datiIdentificativi.potenzaTermica;
    xml.richiesta.datiAllegato.documentazioneTecnica.flagDichiarazConf = docTecnica.dichiarazioneDiConformita;
    xml.richiesta.datiAllegato.documentazioneTecnica.flagLibrettoImp = docTecnica.librettoPresente;
    xml.richiesta.datiAllegato.documentazioneTecnica.flagManutGen = docTecnica.librettoUso;
    xml.richiesta.datiAllegato.documentazioneTecnica.flagLibrettoComp = docTecnica.librettoCompilato;
    xml.richiesta.datiAllegato.trattamentoAcqua.flagTrattH2ONR = trattamentoAcqua.richiestoRiscaldamento;
    xml.richiesta.datiAllegato.controlloImpianto.flagLocaleIdoneo = controlloImpianto.localeIdoneo;
    xml.richiesta.datiAllegato.controlloImpianto.flagLineeIdonee = controlloImpianto.lineeIdonee;
    xml.richiesta.datiAllegato.controlloImpianto.flagAperture = controlloImpianto.aperture;
    xml.richiesta.datiAllegato.controlloImpianto.flagDimensioni = controlloImpianto.dimensioni;
    xml.richiesta.datiAllegato.controlloImpianto.flagCoibenIdonee = controlloImpianto.coiben;
    xml.richiesta.datiAllegato.checkList.flagSostGen1 = checkList.sostGen1;
    xml.richiesta.datiAllegato.checkList.flagSostGen2 = checkList.sostGen2;
    xml.richiesta.datiAllegato.checkList.flagIsolamentoRete = checkList.isolamentoRete;
    xml.richiesta.datiAllegato.checkList.flagIsolamentoCanali = checkList.isolamentoCanali;
    xml.richiesta.datiAllegato.checkList.osservazioni = checkList.osservazioni;
    xml.richiesta.datiAllegato.checkList.raccomandazioni = checkList.raccomandazioni;
    xml.richiesta.datiAllegato.checkList.prescrizioni = checkList.prescrizioni;
    xml.richiesta.datiAllegato.datiTecnico.flagFunzImp = checkList.funzImp;
    xml.richiesta.datiAllegato.datiTecnico.dataIntervento = this.datePipe.transform(checkList.dtIntervento, FORMAT);
    let nomeCognome: string = tecnico.nomeCognome;
    let nome: string = nomeCognome && nomeCognome.split(" ")[0] ? nomeCognome.split(" ")[0] : "";
    let cognome: string = nomeCognome && nomeCognome.split(" ")[1] ? nomeCognome.split(" ")[1] : "";
    xml.richiesta.datiAllegato.datiTecnico.nomeTecnico = nome;
    xml.richiesta.datiAllegato.datiTecnico.cognomeTecnico = cognome;
    xml.richiesta.datiAllegato.datiTecnico.orarioArrivo = tecnico.orarioArrivo;
    xml.richiesta.datiAllegato.datiTecnico.orarioPartenza = tecnico.orarioPartenza;
    xml.richiesta.datiAllegato.allegato.rowAllegato.forEach((row: RowAllegato, index) => {
      row.controlloVerificaEnergetica.flagModalita = controlloEnergetico[index].modalita;
      row.controlloVerificaEnergetica.flagPerdite = controlloEnergetico[index].perdite;
      row.controlloVerificaEnergetica.flagRilevFugheDiretta = controlloEnergetico[index].fugheDiretta;
      row.controlloVerificaEnergetica.flagRilevFugheInDiretta = controlloEnergetico[index].fugheIndiretta;
      row.controlloVerificaEnergetica.flagScambPuliti = controlloEnergetico[index].scambPuliti;

      row.tabFumi.rowFumi.forEach((fumi: RowFumi, index2) => {
        fumi.surrisc = controlloEnergetico[index].elencoCircuiti[index2].surrisc;
        fumi.sottoRaffr = controlloEnergetico[index].elencoCircuiti[index2].sottoRaffr;
        fumi.condens = controlloEnergetico[index].elencoCircuiti[index2].condens;
        fumi.evaporaz = controlloEnergetico[index].elencoCircuiti[index2].evaporaz;
        fumi.ingLatoEst = controlloEnergetico[index].elencoCircuiti[index2].ingLatoEst;
        fumi.uscLatoEst = controlloEnergetico[index].elencoCircuiti[index2].uscLatoEst;
        fumi.ingLatoUtenze = controlloEnergetico[index].elencoCircuiti[index2].ingLatoUtenze;
        fumi.uscLatoUtenze = controlloEnergetico[index].elencoCircuiti[index2].uscLatoUtenze;
        fumi.tuscFluido = controlloEnergetico[index].elencoCircuiti[index2].tuscFluido;
        fumi.tbulboUmido = controlloEnergetico[index].elencoCircuiti[index2].bulboUmido;
        fumi.tingFluidoSorg = controlloEnergetico[index].elencoCircuiti[index2].ingFluidoSorg;
        fumi.tuscFluidoSorg = controlloEnergetico[index].elencoCircuiti[index2].uscFluidoSorg;
        fumi.tingFluidoMacc = controlloEnergetico[index].elencoCircuiti[index2].ingFluidoMac;
        fumi.tuscFluidoMacc = controlloEnergetico[index].elencoCircuiti[index2].uscFluidoMac;
        fumi.potenzaAss = controlloEnergetico[index].elencoCircuiti[index2].potAss;
        fumi.filtriPuliti = controlloEnergetico[index].elencoCircuiti[index2].filtriPuliti;
        fumi.verifica = controlloEnergetico[index].elencoCircuiti[index2].verifica;
        fumi.dataRipristino = controlloEnergetico[index].elencoCircuiti[index2].dataRipristino ?
          this.datePipe.transform(controlloEnergetico[index].elencoCircuiti[index2].dataRipristino, FORMAT) : "";
        fumi.numCircuito = index2 + 1;
      });
    });
    return xml;
  }

  creaControllo(): Mod {
    let mod: Mod = new Mod();
    let datiIdentificativi = this.insertForm.controls["datiIdentificativi"].value;
    let docTecnica = this.insertForm.controls["docTecnica"].value;
    let trattamentoAcqua = this.insertForm.controls["trattamentoAcqua"].value;
    let controlloImpianto = this.insertForm.controls["controlloImpianto"].value;
    let controlloEnergetico = this.insertForm.controls["controlloEnergetico"].value;
    let tecnico = this.insertForm.controls["tecnico"].value;
    let checkList = this.insertForm.controls["checkList"].value;
    mod.richiesta = new Richiesta();
    mod.richiesta.datiAllegato = new datiAllegato();
    mod.richiesta.datiAllegato.datiIdentificativi = new DatiIdentificativi();
    mod.richiesta.datiManutentore = new DatiManutentore();
    mod.richiesta.datiIntestazione = new DatiIntestazione();
    mod.richiesta.datiIntestazione.codiceCatasto = this.codiceImpianto;
    mod.richiesta.datiIntestazione.dataControllo = this.controlloDisponibile.dataControllo;
    mod.richiesta.datiManutentore.codiceFiscale = this.controlloDisponibile.cfPIvaImpresa;
    mod.richiesta.datiManutentore.siglaREA = this.controlloDisponibile.siglaReaImpresa;
    mod.richiesta.datiManutentore.numeroREA = this.controlloDisponibile.numeroReaImpresa;

    mod.richiesta.datiAllegato.datiIdentificativi.potenzaTermicaNomTotMax = datiIdentificativi.potenzaTermica;
    mod.richiesta.datiAllegato.documentazioneTecnica = new DocumentazioneTecnica();
    mod.richiesta.datiAllegato.documentazioneTecnica.flagDichiarazConf = docTecnica.dichiarazioneDiConformita;
    mod.richiesta.datiAllegato.documentazioneTecnica.flagLibrettoImp = docTecnica.librettoPresente;
    mod.richiesta.datiAllegato.documentazioneTecnica.flagManutGen = docTecnica.librettoUso;
    mod.richiesta.datiAllegato.documentazioneTecnica.flagLibrettoComp = docTecnica.librettoCompilato;
    mod.richiesta.datiAllegato.trattamentoAcqua = new TrattamentoAcqua();
    mod.richiesta.datiAllegato.trattamentoAcqua.flagTrattH2ONR = trattamentoAcqua.richiestoRiscaldamento;
    mod.richiesta.datiAllegato.controlloImpianto = new ControlloImpianto();
    mod.richiesta.datiAllegato.controlloImpianto.flagLocaleIdoneo = controlloImpianto.localeIdoneo;
    mod.richiesta.datiAllegato.controlloImpianto.flagLineeIdonee = controlloImpianto.lineeIdonee;
    mod.richiesta.datiAllegato.controlloImpianto.flagAperture = controlloImpianto.aperture;
    mod.richiesta.datiAllegato.controlloImpianto.flagDimensioni = controlloImpianto.dimensioni;
    mod.richiesta.datiAllegato.controlloImpianto.flagCoibenIdonee = controlloImpianto.coiben;
    mod.richiesta.datiAllegato.checkList = new CheckList();
    mod.richiesta.datiAllegato.checkList.flagSostGen1 = checkList.sostGen1;
    mod.richiesta.datiAllegato.checkList.flagSostGen2 = checkList.sostGen2;
    mod.richiesta.datiAllegato.checkList.flagIsolamentoRete = checkList.isolamentoRete;
    mod.richiesta.datiAllegato.checkList.flagIsolamentoCanali = checkList.isolamentoCanali;
    mod.richiesta.datiAllegato.checkList.osservazioni = checkList.osservazioni;
    mod.richiesta.datiAllegato.checkList.raccomandazioni = checkList.raccomandazioni;
    mod.richiesta.datiAllegato.checkList.prescrizioni = checkList.prescrizioni;
    mod.richiesta.datiAllegato.datiTecnico = new DatiTecnico();
    mod.richiesta.datiAllegato.datiTecnico.flagFunzImp = checkList.funzImp;
    mod.richiesta.datiAllegato.datiTecnico.dataIntervento = this.datePipe.transform(checkList.dtIntervento, FORMAT);
    let nomeCognome: string = tecnico.nomeCognome;
    let nome: string = nomeCognome && nomeCognome.split(" ")[0] ? nomeCognome.split(" ")[0] : "";
    let cognome: string = nomeCognome && nomeCognome.split(" ")[1] ? nomeCognome.split(" ")[1] : "";
    mod.richiesta.datiAllegato.datiTecnico.nomeTecnico = nome;
    mod.richiesta.datiAllegato.datiTecnico.cognomeTecnico = cognome;
    mod.richiesta.datiAllegato.datiTecnico.orarioArrivo = tecnico.orarioArrivo;
    mod.richiesta.datiAllegato.datiTecnico.orarioPartenza = tecnico.orarioPartenza;
    mod.richiesta.datiAllegato.datiTecnico.firmaTecnico = "";
    mod.richiesta.datiAllegato.datiTecnico.firmaResp = "";
    mod.richiesta.datiAllegato.allegato = new Allegato();
    mod.richiesta.datiAllegato.allegato.rowAllegato = [];
    controlloEnergetico.forEach(elem => {
      let row = new RowAllegato();
      row.num = this.controlloDisponibile.progressivo;
      row.controlloVerificaEnergetica = new ControlloVerificaEnergetica();
      row.controlloVerificaEnergetica.flagModalita = elem.modalita;
      row.controlloVerificaEnergetica.flagPerdite = elem.perdite;
      row.controlloVerificaEnergetica.flagRilevFugheDiretta = elem.fugheDiretta;
      row.controlloVerificaEnergetica.flagRilevFugheInDiretta = elem.fugheIndiretta;
      row.controlloVerificaEnergetica.flagScambPuliti = elem.scambPuliti;
      row.tabFumi = new TabFumi();
      row.tabFumi.rowFumi = [];
      elem.elencoCircuiti.forEach((elem2, index2) => {
        let fumi = new RowFumi();
        fumi.surrisc = elem2.surrisc;
        fumi.sottoRaffr = elem2.sottoRaffr;
        fumi.condens = elem2.condens;
        fumi.evaporaz = elem2.evaporaz;
        fumi.ingLatoEst = elem2.ingLatoEst;
        fumi.uscLatoEst = elem2.uscLatoEst;
        fumi.ingLatoUtenze = elem2.ingLatoUtenze;
        fumi.uscLatoUtenze = elem2.uscLatoUtenze;
        fumi.tuscFluido = elem2.tuscFluido;
        fumi.tbulboUmido = elem2.bulboUmido;
        fumi.tingFluidoSorg = elem2.ingFluidoSorg;
        fumi.tuscFluidoSorg = elem2.uscFluidoSorg;
        fumi.tingFluidoMacc = elem2.ingFluidoMac;
        fumi.tuscFluidoMacc = elem2.uscFluidoMac;
        fumi.potenzaAss = elem2.potAss;
        fumi.filtriPuliti = elem2.filtriPuliti;
        fumi.verifica = elem2.verifica;
        fumi.dataRipristino = elem2.dataRipristino ?
          this.datePipe.transform(elem2.dataRipristino, FORMAT) : "";
        fumi.numCircuito = index2 + 1;
        row.tabFumi.rowFumi.push(fumi);
      });
      mod.richiesta.datiAllegato.allegato.rowAllegato.push(row);
    });
    return mod;
  }

  mapControlloDisponibileToNuovoControllo(): DatoControlloModel {
    let datoCont = new DatoControlloModel();
    datoCont.controlloModel = new ControlloModel();
    datoCont.controlloModel.fkStatoRapp = STATO_RAPP.IN_ATTESA_DI_MODIFICA;
    datoCont.controlloModel.dataControllo = this.datePipe.transform(new Date(), FORMAT);
    datoCont.controlloModel.desTipoDocumento = tipiDocDesc.get(TipoDoc.REE_2);
    datoCont.controlloModel.fkTipoDocumento = Number(TipoDoc.REE_2);
    return datoCont;
  }

  myFilter = (d: Date | null): boolean => {
    if (this.controlloDisponibile && this.controlloDisponibile.dataControllo)
      return d > new Date(this.controlloDisponibile.dataControllo);
    else if (this.dettaglioControllo && this.dettaglioControllo.controlloModel.dataControllo) {
      return d > new Date(this.dettaglioControllo.controlloModel.dataControllo);
    } else
      return true;
  }
}
