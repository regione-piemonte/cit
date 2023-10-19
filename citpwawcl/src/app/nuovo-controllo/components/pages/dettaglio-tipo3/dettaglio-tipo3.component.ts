import { DatePipe } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormArray, FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { tipiDocDesc, TipoDoc } from 'src/app/enums/tipo-doc-enum';
import { CodiceDescrizione } from 'src/app/models/codice-descrizione';
import { ControlloDisponibileModel } from 'src/app/models/controllo-disponibile';
import { ControlloModel } from 'src/app/models/controllo-model';
import { DatiControlloModel } from 'src/app/models/dati-controllo-model';
import { DatiSCModel } from 'src/app/models/dati-sc-model';
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
import { checkboxCheck2, validateTrattamentoAcqua } from 'src/app/nuovo-controllo/directives/validator-directive.directive';
import { AuthenticationService } from 'src/app/services/authentication.service';
import { BackService } from 'src/app/services/back.service';
import { ComponenteService } from 'src/app/services/componente.service';
import { ControlloService } from 'src/app/services/controllo.service';
import { LocalStorageServiceService } from 'src/app/services/local-storage-service.service';
import { MessageService } from 'src/app/services/message.service';
import { ResultService } from 'src/app/services/result.service';
import { TitleService } from 'src/app/services/title.service';
import { DISPLAY_FORMAT, ESITO_OPERAZIONI, FORMAT, OPERAZIONI, STATO_RAPP, TRATT_ACQUA } from 'src/app/utils/constants';
import { formatoDecimale } from 'src/app/validators/custom.validator';
import { v4 as uuidv4 } from 'uuid';


@Component({
  selector: 'app-dettaglio-tipo3',
  templateUrl: './dettaglio-tipo3.component.html',
  styleUrls: ['./dettaglio-tipo3.component.scss']
})
export class DettaglioTipo3Component implements OnInit {



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
      luogoIdoneo: ["", Validators.required],
      perdite: ["", Validators.required],
      lineeIdonee: ["", Validators.required],
      coiben: ["", Validators.required],
    }),
    controlloEnergetico: this.fb.array([]),
    checkList: this.fb.group({
      valvole: [false],
      curvaClim: [false],
      perditaH2o: [false],
      involucro: [false],
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
  fluidi: CodiceDescrizione[];
  datiControllo: DatiControlloModel;


  constructor(private route: ActivatedRoute,
    private fb: FormBuilder,
    private readonly controlloService: ControlloService,
    private readonly compService: ComponenteService,
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
    this.titleService.setTitle("REE TIPO 3");
    this.titleService.setSubtitle("Scambiatori");
    this.datiControllo = this.localStorageService.getControllo();
    this.xmlImpianto = this.localStorageService.getXmlImpianto();
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

    if (this.datiControllo) {
      this.fluidi = this.datiControllo.fluido;
    }
    else {
      this.compService.getFluido().subscribe(elem => {
        this.fluidi = elem;
      });
    }

    this.controlloService.getOnlineSubject().subscribe((elem) => {
      this.offline = !elem;
    });
  }

  compilaDatiIniziali() {
    let arr = this.getControlloEner();
    let datacontrollo = this.datePipe.transform(this.controlloDisponibile.dataControllo, DISPLAY_FORMAT);
    this.insertForm.controls.dataControllo.setValue(datacontrollo);
    let dataInstall = this.datePipe.transform(this.controlloDisponibile.dataInstall, DISPLAY_FORMAT);
    this.insertForm.controls.ree.setValue(tipiDocDesc.get(TipoDoc.REE_3));
    const enerForm = this.fb.group({
      comp: [{ value: "SC-" + this.controlloDisponibile.progressivo, disabled: true }],
      dataInstall: [{ value: dataInstall, disabled: true }],
      fabbricante: [{ value: this.controlloDisponibile.descMarca, disabled: true }],
      modello: [{ value: this.controlloDisponibile.modello, disabled: true }],
      matricola: [{ value: this.controlloDisponibile.matricola, disabled: true }],
      combustibile: ["", [Validators.required]],
      fluidoVett: ["", [Validators.required]],
      climatizInv: [false, [Validators.required]],
      produzACS: [false, [Validators.required]],
      potTermica: [{ value: this.controlloDisponibile.potTermica, disabled: true }],
      potComp: ["", [Validators.required]],
      statoCoiben: ["", [Validators.required]],
      dispReg: ["", [Validators.required]],
      elencoCircuiti: this.fb.array([])
    });
    enerForm.setValidators([checkboxCheck2]);
    enerForm.updateValueAndValidity();
    arr.push(enerForm);
    let arr2 = enerForm.controls.elencoCircuiti as FormArray;
    const moduloForm = this.fb.group({
      tempEst: ["", [Validators.required, formatoDecimale(/^-?[0-9]{0,4}(?:\.[0-9]{0,2})?$/, 4, 2)]],
      tempMandPrim: ["", [Validators.required, formatoDecimale(/^-?[0-9]{0,4}(?:\.[0-9]{0,2})?$/, 4, 2)]],
      tempRitPrim: ["", [Validators.required, formatoDecimale(/^-?[0-9]{0,4}(?:\.[0-9]{0,2})?$/, 4, 2)]],
      potenzaTerm: ["", [Validators.required, formatoDecimale(/^[0-9]{0,4}(?:\.[0-9]{0,2})?$/, 4, 2)]],
      portataFluido: ["", [Validators.required, formatoDecimale(/^[0-9]{0,4}(?:\.[0-9]{0,2})?$/, 4, 2)]],
      tempMandSecond: ["", [Validators.required, formatoDecimale(/^-?[0-9]{0,4}(?:\.[0-9]{0,2})?$/, 4, 2)]],
      tempRitSecond: ["", [Validators.required, formatoDecimale(/^-?[0-9]{0,4}(?:\.[0-9]{0,2})?$/, 4, 2)]]
    });
    arr2.push(moduloForm);

    let trattH2o = this.xmlImpianto.Richiesta.datiSchedaTrattH2O;

    let trattRsc = "";
    let acs = "";

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


      if (trattH2o.L2_4flagAssente) {
        acs = TRATT_ACQUA.DESC_ASSENTE;
      } else if (trattH2o.L2_4flagFiltrazione) {
        acs = TRATT_ACQUA.DESC_FILTRAZIONE;
      } else if (trattH2o.L2_4flagAddolcimento) {
        acs = TRATT_ACQUA.DESC_ADDOLCIMENTO;
      } else if (trattH2o.L2_4flagCondizChimico) {
        acs = TRATT_ACQUA.DESC_CONDIZ_CHIMICO;
      }
    }

    this.insertForm.controls["trattamentoAcqua"] = this.fb.group({
      richiestoRiscaldamento: [false, [validateTrattamentoAcqua(trattRsc)]],
      durezza: { value: (trattH2o ? trattH2o.L2_2durezzaTotaleH2O : ""), disabled: true },
      trattamentoRiscaldamento: { value: trattRsc, disabled: true },
      acs: { value: acs, disabled: true },
      richiestoAcs: [false, [validateTrattamentoAcqua(acs)]],
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
      let dataControllo = this.datePipe.transform(this.dettaglioControllo.controlloModel.dataControllo, DISPLAY_FORMAT);
      this.insertForm.controls.dataControllo.setValue(dataControllo);
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
        let acs = "";
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

          if (trattH2o.L2_4flagAssente) {
            acs = TRATT_ACQUA.DESC_ASSENTE;
          } else if (trattH2o.L2_4flagFiltrazione) {
            acs = TRATT_ACQUA.DESC_FILTRAZIONE;
          } else if (trattH2o.L2_4flagAddolcimento) {
            acs = TRATT_ACQUA.DESC_ADDOLCIMENTO;
          } else if (trattH2o.L2_4flagCondizChimico) {
            acs = TRATT_ACQUA.DESC_CONDIZ_CHIMICO;
          }
        }
        this.insertForm.controls["trattamentoAcqua"] = this.fb.group({
          richiestoRiscaldamento: [trattamentoAcqua.flagTrattH2ONR, [validateTrattamentoAcqua(trattRsc)]],
          richiestoAcs: [trattamentoAcqua.flagTrattAcsNR, [validateTrattamentoAcqua(acs)]],
          durezza: { value: trattH2o ? trattH2o.L2_2durezzaTotaleH2O : "", disabled: true },
          trattamentoRiscaldamento: { value: trattRsc, disabled: true },
          acs: { value: acs, disabled: true },
        });
      }

      if (controlloImpianto) {
        this.insertForm.controls["controlloImpianto"].patchValue({
          luogoIdoneo: controlloImpianto.flagLuogoIdoneo,
          perdite: controlloImpianto.flagPerdite,
          lineeIdonee: controlloImpianto.flagLineeIdonee,
          coiben: controlloImpianto.flagStatoCoiben
        });
      }

      rowAllegato.forEach((row: RowAllegato) => {
        this.dettaglioControllo.datiCompModelList.forEach((gf: DatiSCModel) => {
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

  addControlloEner(elem: RowAllegato, sc: DatiSCModel) {
    let controlloEnergetico = elem.controlloVerificaEnergetica
    let contEnerArr = this.getControlloEner();
    let dataInstall = this.datePipe.transform(sc.dataInstall, DISPLAY_FORMAT);

    const enerForm = this.fb.group({
      comp: [{ value: "SC-" + sc.progressivo, disabled: true }],
      dataInstall: [{ value: dataInstall, disabled: true }],
      fabbricante: [{ value: sc.descMarca, disabled: true }],
      modello: [{ value: sc.modello, disabled: true }],
      matricola: [{ value: sc.matricola, disabled: true }],
      combustibile: [controlloEnergetico.combustibile, [Validators.required]],
      fluidoVett: [controlloEnergetico.fluidoVett, [Validators.required]],
      climatizInv: [controlloEnergetico.flagClimatizInv, [Validators.required]],
      produzACS: [controlloEnergetico.flagProduzACS, [Validators.required]],
      potTermica: [{ value: sc.potenzaTermicaKw, disabled: true }],
      potComp: [controlloEnergetico.flagPotComp, [Validators.required]],
      statoCoiben: [controlloEnergetico.flagStatoCoiben, [Validators.required]],
      dispReg: [controlloEnergetico.flagDispReg, [Validators.required]],
      elencoCircuiti: this.fb.array([])
    });
    enerForm.setValidators([checkboxCheck2]);
    enerForm.updateValueAndValidity();
    contEnerArr.push(enerForm);
    elem.tabFumi.rowFumi.forEach((row: RowFumi) => {
      let rowFumiArr = enerForm.controls.elencoCircuiti as FormArray;
      const rowFumiForm = this.fb.group({
        tempEst: [row.tempEst, [Validators.required, formatoDecimale(/^-?[0-9]{0,4}(?:\.[0-9]{0,2})?$/, 4, 2)]],
        tempMandPrim: [row.tempMandPrim, [Validators.required, formatoDecimale(/^-?[0-9]{0,4}(?:\.[0-9]{0,2})?$/, 4, 2)]],
        tempRitPrim: [row.tempRitPrim, [Validators.required, formatoDecimale(/^-?[0-9]{0,4}(?:\.[0-9]{0,2})?$/, 4, 2)]],
        potenzaTerm: [row.potenzaTerm, [Validators.required, formatoDecimale(/^[0-9]{0,4}(?:\.[0-9]{0,2})?$/, 4, 2)]],
        portataFluido: [row.portataFluido, [Validators.required, formatoDecimale(/^[0-9]{0,4}(?:\.[0-9]{0,2})?$/, 4, 2)]],
        tempMandSecond: [row.tempMandSecond, [Validators.required, formatoDecimale(/^-?[0-9]{0,4}(?:\.[0-9]{0,2})?$/, 4, 2)]],
        tempRitSecond: [row.tempRitSecond, [Validators.required, formatoDecimale(/^-?[0-9]{0,4}(?:\.[0-9]{0,2})?$/, 4, 2)]]
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
      datoCont.controlloModel.desTipoDocumento = tipiDocDesc.get(TipoDoc.REE_3);
      datoCont.controlloModel.fkTipoDocumento = Number(TipoDoc.REE_3);
      datoCont.controlloModel.elencoApparecchiatura = this.controlloDisponibile.tipoComponente + "-" + this.controlloDisponibile.progressivo;
      let checkList = this.insertForm.controls["checkList"].value;
      datoCont.controlloModel.fInterventoEntro = checkList.interventoEntro ? this.datePipe.transform(checkList.interventoEntro, FORMAT) : "";
      datoCont.datiCompModelList = [];
      let datoSC: DatiSCModel = new DatiSCModel();
      datoSC.progressivo = this.controlloDisponibile.progressivo;
      datoSC.dataInstall = this.controlloDisponibile.dataInstall;
      datoSC.descMarca = this.controlloDisponibile.descMarca;
      datoSC.modello = this.controlloDisponibile.modello;
      datoSC.matricola = this.controlloDisponibile.matricola;
      datoSC.potenzaTermicaKw = this.controlloDisponibile.potTermica ? Number(this.controlloDisponibile.potTermica) : 0;
      datoSC.cf = this.controlloDisponibile.cfPIvaImpresa;
      datoSC.siglaRea = this.controlloDisponibile.siglaReaImpresa;
      datoSC.numeroRea = this.controlloDisponibile.numeroReaImpresa;
      datoCont.datiCompModelList.push(datoSC);
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
    xml.richiesta.datiAllegato.trattamentoAcqua.flagTrattAcsNR = trattamentoAcqua.richiestoAcs;
    xml.richiesta.datiAllegato.controlloImpianto.flagLuogoIdoneo = controlloImpianto.luogoIdoneo;
    xml.richiesta.datiAllegato.controlloImpianto.flagLineeIdonee = controlloImpianto.lineeIdonee;
    xml.richiesta.datiAllegato.controlloImpianto.flagPerdite = controlloImpianto.perdite;
    xml.richiesta.datiAllegato.controlloImpianto.flagStatoCoiben = controlloImpianto.coiben;
    xml.richiesta.datiAllegato.checkList.flagValvole = checkList.valvole;
    xml.richiesta.datiAllegato.checkList.flagCurvaClim = checkList.curvaClim;
    xml.richiesta.datiAllegato.checkList.flagPerditaH2O = checkList.perditaH2o;
    xml.richiesta.datiAllegato.checkList.flagInvolucro = checkList.involucro;
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
      row.controlloVerificaEnergetica.combustibile = controlloEnergetico[index].combustibile;
      row.controlloVerificaEnergetica.fluidoVett = controlloEnergetico[index].fluidoVett;
      row.controlloVerificaEnergetica.flagClimatizInv = controlloEnergetico[index].climatizInv;
      row.controlloVerificaEnergetica.flagProduzACS = controlloEnergetico[index].produzACS;
      row.controlloVerificaEnergetica.flagPotComp = controlloEnergetico[index].potComp;
      row.controlloVerificaEnergetica.flagStatoCoiben = controlloEnergetico[index].statoCoiben;
      row.controlloVerificaEnergetica.flagDispReg = controlloEnergetico[index].dispReg;
      row.tabFumi.rowFumi.forEach((fumi: RowFumi, index2) => {
        fumi.tempEst = controlloEnergetico[index].elencoCircuiti[index2].tempEst;
        fumi.tempMandPrim = controlloEnergetico[index].elencoCircuiti[index2].tempMandPrim;
        fumi.tempRitPrim = controlloEnergetico[index].elencoCircuiti[index2].tempRitPrim;
        fumi.potenzaTerm = controlloEnergetico[index].elencoCircuiti[index2].potenzaTerm;
        fumi.portataFluido = controlloEnergetico[index].elencoCircuiti[index2].portataFluido;
        fumi.tempMandSecond = controlloEnergetico[index].elencoCircuiti[index2].tempMandSecond;
        fumi.tempRitSecond = controlloEnergetico[index].elencoCircuiti[index2].tempRitSecond;
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
    mod.richiesta.datiAllegato.trattamentoAcqua.flagTrattAcsNR = trattamentoAcqua.richiestoAcs;
    mod.richiesta.datiAllegato.controlloImpianto = new ControlloImpianto();
    mod.richiesta.datiAllegato.controlloImpianto.flagLuogoIdoneo = controlloImpianto.luogoIdoneo;
    mod.richiesta.datiAllegato.controlloImpianto.flagLineeIdonee = controlloImpianto.lineeIdonee;
    mod.richiesta.datiAllegato.controlloImpianto.flagPerdite = controlloImpianto.perdite;
    mod.richiesta.datiAllegato.controlloImpianto.flagStatoCoiben = controlloImpianto.coiben;
    mod.richiesta.datiAllegato.checkList = new CheckList();
    mod.richiesta.datiAllegato.checkList.flagValvole = checkList.valvole;
    mod.richiesta.datiAllegato.checkList.flagCurvaClim = checkList.curvaClim;
    mod.richiesta.datiAllegato.checkList.flagPerditaH2O = checkList.perditaH2o;
    mod.richiesta.datiAllegato.checkList.flagInvolucro = checkList.involucro;
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
      row.controlloVerificaEnergetica.combustibile = elem.combustibile;
      row.controlloVerificaEnergetica.fluidoVett = elem.fluidoVett;
      row.controlloVerificaEnergetica.flagClimatizInv = elem.climatizInv;
      row.controlloVerificaEnergetica.flagProduzACS = elem.produzACS;
      row.controlloVerificaEnergetica.flagPotComp = elem.potComp;
      row.controlloVerificaEnergetica.flagStatoCoiben = elem.statoCoiben;
      row.controlloVerificaEnergetica.flagDispReg = elem.dispReg;
      row.tabFumi = new TabFumi();
      row.tabFumi.rowFumi = [];
      elem.elencoCircuiti.forEach((elem2, index2) => {
        let fumi = new RowFumi();
        fumi.tempEst = elem2.tempEst;
        fumi.tempMandPrim = elem2.tempMandPrim;
        fumi.tempRitPrim = elem2.tempRitPrim;
        fumi.potenzaTerm = elem2.potenzaTerm;
        fumi.portataFluido = elem2.portataFluido;
        fumi.tempMandSecond = elem2.tempMandSecond;
        fumi.tempRitSecond = elem2.tempRitSecond;
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
    datoCont.controlloModel.desTipoDocumento = tipiDocDesc.get(TipoDoc.REE_3);
    datoCont.controlloModel.fkTipoDocumento = Number(TipoDoc.REE_3);
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
