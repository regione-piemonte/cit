import { NumberInput } from '@angular/cdk/coercion';
import { DatePipe } from '@angular/common';
import { Component, HostListener, OnInit } from '@angular/core';
import { FormArray, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { tipiDocDesc, TipoDoc } from 'src/app/enums/tipo-doc-enum';
import { ControlloDisponibileModel } from 'src/app/models/controllo-disponibile';
import { ControlloModel } from 'src/app/models/controllo-model';
import { DatiControlloModel } from 'src/app/models/dati-controllo-model';
import { DatiGTModel } from 'src/app/models/dati-gt-model';
import { DatoControlloModel } from 'src/app/models/dato-controllo-model';
import { Esito } from 'src/app/models/esito';
import { Allegato, CheckList, ControlloImpianto, ControlloVerificaEnergetica, datiAllegato, DatiIdentificativi, DatiIntestazione, DatiManutentore, DatiTecnico, DocumentazioneTecnica, Mod, Richiesta, RowAllegato, RowFumi, TabFumi, TrattamentoAcqua } from 'src/app/models/mod';
import { OnlineCheckModel } from 'src/app/models/online-check-model';
import { OperazioneControlloModel } from 'src/app/models/operazione-controllo-model';
import { UtenteLoggato } from 'src/app/models/utente-loggato';
import { checkboxCheck, validateTrattamentoAcqua } from 'src/app/nuovo-controllo/directives/validator-directive.directive';
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
  selector: 'app-dettaglio-tipo1',
  templateUrl: './dettaglio-tipo1.component.html',
  styleUrls: ['./dettaglio-tipo1.component.scss']
})
export class DettaglioTipo1Component implements OnInit {

  success = false;
  offline = false;

  insertForm = this.fb.group({
    dataControllo: [{ value: '', disabled: true }],
    tipoControllo: [{ value: '', disabled: true }],
    ree: [{ value: '', disabled: true }, Validators.required],
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
      instInterna: ["", Validators.required],
      instEsterna: ["", Validators.required],
      aperture: ["", Validators.required],
      adeguateDim: ["", Validators.required],
      canaleFumo: ["", Validators.required],
      tempAmbiente: ["", Validators.required],
      assenzePerdite: ["", Validators.required],
      idoneaTenuta: ["", Validators.required]
    }),
    controlloEnergetico: this.fb.array([]),
    checkList: this.fb.group({
      adozioneValvole: [false],
      isolamentoRete: [false],
      introduzioneSistemaTrattamento: [false],
      sostituzioneSistemaRegolazione: [false],
      osservazioni: ['', [Validators.maxLength(1000)]],
      raccomandazioni: ['', [Validators.maxLength(1000)]],
      prescrizioni: ['', [Validators.maxLength(1000)]],
      impiantoPuoFunzionare: [true, Validators.required],
      interventoEntro: ['', Validators.required]
    }),
    tecnico: this.fb.group({
      nomeCognome: ['', Validators.required],
      orarioArrivo: [''],
      orarioPartenza: ['']
    })
  });


  controlloDisponibile: ControlloDisponibileModel;
  datiControllo: DatiControlloModel;
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
    this.titleService.setTitle("REE TIPO 1");
    this.titleService.setSubtitle("Gruppi termici");
    this.insertForm.controls.tipoControllo.setValue("REE");
    this.datiControllo = this.localStorageService.getControllo();
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
    if (this.controlloDisponibile) {
      // Not Implemented
    } else if (!(this.dettaglioControllo && this.datiControllo)) {
      this.router.navigate(["/impianto/dettaglio/" + this.codiceImpianto + "/elenco-controlli"]);
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
    this.insertForm.controls.ree.setValue(tipiDocDesc.get(TipoDoc.REE_1));
    let dataInstall = this.datePipe.transform(this.controlloDisponibile.dataInstall, DISPLAY_FORMAT);
    const enerForm = this.fb.group({
      comp: [{ value: "GT-" + this.controlloDisponibile.progressivo, disabled: true }],
      dataInstall: [{ value: dataInstall, disabled: true }],
      fabbricante: [{ value: this.controlloDisponibile.descMarca, disabled: true }],
      modello: [{ value: this.controlloDisponibile.modello, disabled: true }],
      matricola: [{ value: this.controlloDisponibile.matricola, disabled: true }],
      tipo: [{ value: this.controlloDisponibile.descDettaglio, disabled: true }],
      potTermicaKw: [{ value: this.controlloDisponibile.potTermica, disabled: true }],
      potTermica: ["", [Validators.required, formatoDecimale(/^[0-9]{0,6}(?:\.[0-9]{0,2})?$/, 6, 2)]],
      modEvaquazioneFumi: ["", Validators.required],
      climaInvernale: [false, Validators.required],
      prodAcs: [false, Validators.required],
      depressCanaleFumo: ["", formatoDecimale(/^[0-9]{0,5}(?:\.[0-9]{0,2})?$/, 5, 2)],
      combustibile: [{ value: this.controlloDisponibile.descCombustibile, disabled: true }],
      dispComando: ["", Validators.required],
      dispSicurezza: ["", Validators.required],
      valvSicurezza: ["", Validators.required],
      controllatoEPulito: ["", Validators.required],
      presenzaRiflusso: ["", Validators.required],
      risControllo: ["", Validators.required],
      altroRif: ["", Validators.maxLength(500)],
      elencoModuli: this.fb.array([]),
    });
    enerForm.setValidators([checkboxCheck]);
    enerForm.updateValueAndValidity();
    arr.push(enerForm);
    let arr2 = enerForm.controls.elencoModuli as FormArray;
    for (let i = 0; i < this.controlloDisponibile.nModuli; i++) {
      const moduloForm = this.fb.group({
        temperaturaFumi: ["", [Validators.required, formatoDecimale(/^-?[0-9]{0,4}(?:\.[0-9]{0,2})?$/, 4, 2)]],
        temperaturaAria: ["", [Validators.required, formatoDecimale(/^-?[0-9]{0,4}(?:\.[0-9]{0,2})?$/, 4, 2)]],
        o2: ["", [Validators.required, formatoDecimale(/^[0-9]{0,3}(?:\.[0-9]{0,2})?$/, 3, 2)]],
        co2: ["", [Validators.required, formatoDecimale(/^[0-9]{0,3}(?:\.[0-9]{0,2})?$/, 3, 2)]],
        bacharach1: ["", [formatoDecimale(/^[0-9]{0,4}(?:\.[0-9]{0,2})?$/, 4, 2)]],
        bacharach2: ["", [formatoDecimale(/^[0-9]{0,4}(?:\.[0-9]{0,2})?$/, 4, 2)]],
        bacharach3: ["", [formatoDecimale(/^[0-9]{0,4}(?:\.[0-9]{0,2})?$/, 4, 2)]],
        coCorretto: ["", [Validators.required, formatoDecimale(/^[0-9]{0,7}(?:\.[0-9]{0,2})?$/, 7, 2)]],
        rendimentoCombustione: ["", [Validators.required, formatoDecimale(/^[0-9]{0,3}(?:\.[0-9]{0,2})?$/, 3, 2)]],
        rendimentoMinimoLegge: ["", [Validators.required, formatoDecimale(/^[0-9]{0,3}(?:\.[0-9]{0,2})?$/, 3, 2)]],
        noxKw: ["", [Validators.required, formatoDecimale(/^[0-9]{0,7}(?:\.[0-9]{0,2})?$/, 7, 2)]],
        portataCombu: ["", Validators.required],
        valorePortata: ["", [formatoDecimale(/^[0-9]{0,4}(?:\.[0-9]{0,2})?$/, 4, 2)]],
        fumiSecchi: ["", [formatoDecimale(/^[0-9]{0,4}(?:\.[0-9]{0,2})?$/, 4, 2)]],
        rispettoIndBacharach: ["", Validators.required],
        minimo: ["", Validators.required]
      });
      arr2.push(moduloForm);
    }

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
    if (this.datiControllo && this.dettaglioControllo) {
      let xml: Mod = this.dettaglioControllo.xmlControllo as Mod;
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

        console.log(trattamentoAcqua);
        this.insertForm.controls["trattamentoAcqua"] = this.fb.group({
          richiestoRiscaldamento: [trattamentoAcqua.flagTrattH2ONR === undefined ? false : trattamentoAcqua.flagTrattH2ONR, [validateTrattamentoAcqua(trattRsc)]],
          richiestoAcs: [trattamentoAcqua.flagTrattAcsNR === undefined ? false : trattamentoAcqua.flagTrattAcsNR, [validateTrattamentoAcqua(acs)]],
          durezza: { value: trattH2o ? trattH2o.L2_2durezzaTotaleH2O : "", disabled: true },
          trattamentoRiscaldamento: { value: trattRsc, disabled: true },
          acs: { value: acs, disabled: true }
        });
      }

      if (controlloImpianto) {
        this.insertForm.controls["controlloImpianto"].patchValue({
          instInterna: controlloImpianto.flagInterno,
          instEsterna: controlloImpianto.flagEsterno,
          aperture: controlloImpianto.flagAperture,
          adeguateDim: controlloImpianto.flagDimensioni,
          canaleFumo: controlloImpianto.flagCanaleFumo,
          tempAmbiente: controlloImpianto.flagSistRegolaz,
          assenzePerdite: controlloImpianto.flagPerdite,
          idoneaTenuta: controlloImpianto.flagTenuta
        });
      }
      if (rowAllegato) {
        rowAllegato.forEach((row: RowAllegato) => {
          this.dettaglioControllo.datiCompModelList.forEach((gt: DatiGTModel) => {
            if (row.num == gt.progressivo && !gt.dataDismiss) {
              this.addControlloEner(row, gt);
            }
          });
        });
      }

      if (checklist) {
        this.insertForm.controls["checkList"].patchValue({
          adozioneValvole: checklist.flagValvole,
          isolamentoRete: checklist.flagIsolamento,
          introduzioneSistemaTrattamento: checklist.flagSistTrattACS,
          sostituzioneSistemaRegolazione: checklist.flagSistRegolaz,
          osservazioni: checklist.osservazioni,
          raccomandazioni: checklist.raccomandazioni,
          prescrizioni: checklist.prescrizioni,
          impiantoPuoFunzionare: datiTecnico ? datiTecnico.flagFunzImp : '',
          interventoEntro: datiTecnico && datiTecnico.dataIntervento ? new Date(datiTecnico.dataIntervento) : ''
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

  addControlloEner(elem: RowAllegato, gt: DatiGTModel) {
    let controlloEnergetico = elem.controlloVerificaEnergetica
    let arr = this.getControlloEner();
    let dataInstall = this.datePipe.transform(gt.dataInstall, DISPLAY_FORMAT);
    const enerForm = this.fb.group({
      comp: [{ value: "GT-" + gt.progressivo, disabled: true }],
      dataInstall: [{ value: dataInstall, disabled: true }],
      fabbricante: [{ value: gt.descMarca, disabled: true }],
      modello: [{ value: gt.modello, disabled: true }],
      matricola: [{ value: gt.matricola, disabled: true }],
      tipo: [{ value: gt.descDettaglioGt, disabled: true }],
      potTermicaKw: [{ value: gt.potenzaTermicaKw, disabled: true }],
      potTermica: [controlloEnergetico.potenzaFocolare, [Validators.required, formatoDecimale(/^[0-9]{0,6}(?:\.[0-9]{0,2})?$/, 6, 2)]],
      modEvaquazioneFumi: [controlloEnergetico.flagEvacFumi, Validators.required],
      climaInvernale: [controlloEnergetico.flagClimatizInv, Validators.required],
      prodAcs: [controlloEnergetico.flagProduzACS, Validators.required],
      depressCanaleFumo: [controlloEnergetico.depressCanaleFumo, [controlloEnergetico.flagEvacFumi === "N" ? Validators.required : Validators.nullValidator, formatoDecimale(/^[0-9]{0,5}(?:\.[0-9]{0,2})?$/, 5, 2)]],
      combustibile: [{ value: gt.descCombustibile, disabled: true }],
      dispComando: [controlloEnergetico.flagDispComando, Validators.required],
      dispSicurezza: [controlloEnergetico.flagDispSicu, Validators.required],
      valvSicurezza: [controlloEnergetico.flagValvSicu, Validators.required],
      controllatoEPulito: [controlloEnergetico.flagScambiatore, Validators.required],
      presenzaRiflusso: [controlloEnergetico.flagRiflusso, Validators.required],
      risControllo: [controlloEnergetico.flagRisultati, Validators.required],
      altroRif: [controlloEnergetico.altroRifNormativo, Validators.maxLength(500)],
      elencoModuli: this.fb.array([]),
    });
    enerForm.setValidators([checkboxCheck]);
    enerForm.updateValueAndValidity();
    arr.push(enerForm);
    elem.tabFumi.rowFumi.forEach((row: RowFumi) => {
      let arr2 = enerForm.controls.elencoModuli as FormArray;
      const moduloForm = this.fb.group({
        temperaturaFumi: [row.tempFumi, [Validators.required, formatoDecimale(/^-?[0-9]{0,4}(?:\.[0-9]{0,2})?$/, 4, 2)]],
        temperaturaAria: [row.tempAria, [Validators.required, formatoDecimale(/^-?[0-9]{0,4}(?:\.[0-9]{0,2})?$/, 4, 2)]],
        o2: [row.o2, [Validators.required, formatoDecimale(/^[0-9]{0,3}(?:\.[0-9]{0,2})?$/, 3, 2)]],
        co2: [row.co2, [Validators.required, formatoDecimale(/^[0-9]{0,3}(?:\.[0-9]{0,2})?$/, 3, 2)]],
        bacharach1: [row.bacharach1, formatoDecimale(/^[0-9]{0,4}(?:\.[0-9]{0,2})?$/, 4, 2)],
        bacharach2: [row.bacharach2, formatoDecimale(/^[0-9]{0,4}(?:\.[0-9]{0,2})?$/, 4, 2)],
        bacharach3: [row.bacharach3, formatoDecimale(/^[0-9]{0,4}(?:\.[0-9]{0,2})?$/, 4, 2)],
        coCorretto: [row.cOcorretto, [Validators.required, formatoDecimale(/^[0-9]{0,7}(?:\.[0-9]{0,2})?$/, 7, 2)]],
        rendimentoCombustione: [row.rendimCombu, [Validators.required, formatoDecimale(/^[0-9]{0,3}(?:\.[0-9]{0,2})?$/, 3, 2)]],
        rendimentoMinimoLegge: [row.rendimentoLegge, [Validators.required, formatoDecimale(/^[0-9]{0,3}(?:\.[0-9]{0,2})?$/, 3, 2)]],
        noxKw: [row.nox, [Validators.required, formatoDecimale(/^[0-9]{0,7}(?:\.[0-9]{0,2})?$/, 7, 2)]],
        portataCombu: [row.portataCombu, [Validators.required]],
        valorePortata: [row.valorePortata, formatoDecimale(/^[0-9]{0,4}(?:\.[0-9]{0,2})?$/, 4, 2)],
        fumiSecchi: [row.coFumiSecchi, formatoDecimale(/^[0-9]{0,4}(?:\.[0-9]{0,2})?$/, 4, 2)],
        rispettoIndBacharach: [row.rispettoIndBacharach, Validators.required],
        minimo: [row.minimo, Validators.required]
      });
      arr2.push(moduloForm);
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
      datoCont.controlloModel.desTipoDocumento = tipiDocDesc.get(TipoDoc.REE_1);
      datoCont.controlloModel.fkTipoDocumento = Number(TipoDoc.REE_1);
      datoCont.controlloModel.elencoApparecchiatura = this.controlloDisponibile.tipoComponente + "-" + this.controlloDisponibile.progressivo;
      let checkList = this.insertForm.controls["checkList"].value;
      datoCont.controlloModel.fInterventoEntro = checkList.interventoEntro ? this.datePipe.transform(checkList.interventoEntro, FORMAT) : "";
      datoCont.datiCompModelList = [];
      let datoGT: DatiGTModel = new DatiGTModel();
      datoGT.progressivo = this.controlloDisponibile.progressivo;
      datoGT.dataInstall = this.controlloDisponibile.dataInstall;
      datoGT.descMarca = this.controlloDisponibile.descMarca;
      datoGT.modello = this.controlloDisponibile.modello;
      datoGT.matricola = this.controlloDisponibile.matricola;
      datoGT.descDettaglioGt = this.controlloDisponibile.descDettaglio;
      datoGT.potenzaTermicaKw = this.controlloDisponibile.potTermica ? Number(this.controlloDisponibile.potTermica) : 0;
      datoGT.descCombustibile = this.controlloDisponibile.descCombustibile;
      datoGT.cf = this.controlloDisponibile.cfPIvaImpresa;
      datoGT.siglaRea = this.controlloDisponibile.siglaReaImpresa;
      datoGT.numeroRea = this.controlloDisponibile.numeroReaImpresa;
      datoGT.nModuli = this.controlloDisponibile.nModuli;
      datoCont.datiCompModelList.push(datoGT);
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
    xml.richiesta.datiAllegato.controlloImpianto.flagInterno = controlloImpianto.instInterna;
    xml.richiesta.datiAllegato.controlloImpianto.flagEsterno = controlloImpianto.instEsterna;
    xml.richiesta.datiAllegato.controlloImpianto.flagAperture = controlloImpianto.aperture;
    xml.richiesta.datiAllegato.controlloImpianto.flagDimensioni = controlloImpianto.adeguateDim;
    xml.richiesta.datiAllegato.controlloImpianto.flagCanaleFumo = controlloImpianto.canaleFumo;
    xml.richiesta.datiAllegato.controlloImpianto.flagSistRegolaz = controlloImpianto.tempAmbiente;
    xml.richiesta.datiAllegato.controlloImpianto.flagPerdite = controlloImpianto.assenzePerdite;
    xml.richiesta.datiAllegato.controlloImpianto.flagTenuta = controlloImpianto.idoneaTenuta;
    xml.richiesta.datiAllegato.checkList.flagValvole = checkList.adozioneValvole;
    xml.richiesta.datiAllegato.checkList.flagIsolamento = checkList.isolamentoRete;
    xml.richiesta.datiAllegato.checkList.flagSistTrattACS = checkList.introduzioneSistemaTrattamento;
    xml.richiesta.datiAllegato.checkList.flagSistRegolaz = checkList.sostituzioneSistemaRegolazione;
    xml.richiesta.datiAllegato.checkList.osservazioni = checkList.osservazioni;
    xml.richiesta.datiAllegato.checkList.raccomandazioni = checkList.raccomandazioni;
    xml.richiesta.datiAllegato.checkList.prescrizioni = checkList.prescrizioni;
    xml.richiesta.datiAllegato.datiTecnico.flagFunzImp = checkList.impiantoPuoFunzionare;
    xml.richiesta.datiAllegato.datiTecnico.dataIntervento = checkList.interventoEntro ? this.datePipe.transform(checkList.interventoEntro, FORMAT) : "";
    let nomeCognome: string = tecnico.nomeCognome;
    let nome: string = nomeCognome && nomeCognome.split(" ")[0] ? nomeCognome.split(" ")[0] : "";
    let cognome: string = nomeCognome && nomeCognome.split(" ")[1] ? nomeCognome.split(" ")[1] : "";
    xml.richiesta.datiAllegato.datiTecnico.nomeTecnico = nome;
    xml.richiesta.datiAllegato.datiTecnico.cognomeTecnico = cognome;
    xml.richiesta.datiAllegato.datiTecnico.orarioArrivo = tecnico.orarioArrivo;
    xml.richiesta.datiAllegato.datiTecnico.orarioPartenza = tecnico.orarioPartenza;
    if (xml.richiesta.datiAllegato.allegato.rowAllegato) {
      xml.richiesta.datiAllegato.allegato.rowAllegato.forEach((row, index) => {
        row.controlloVerificaEnergetica.potenzaFocolare = controlloEnergetico[index].potTermica;
        row.controlloVerificaEnergetica.flagEvacFumi = controlloEnergetico[index].modEvaquazioneFumi;
        row.controlloVerificaEnergetica.flagClimatizInv = controlloEnergetico[index].climaInvernale;
        row.controlloVerificaEnergetica.flagProduzACS = controlloEnergetico[index].prodAcs;
        row.controlloVerificaEnergetica.depressCanaleFumo = controlloEnergetico[index].depressCanaleFumo;
        row.controlloVerificaEnergetica.flagDispComando = controlloEnergetico[index].dispComando;
        row.controlloVerificaEnergetica.flagDispSicu = controlloEnergetico[index].dispSicurezza;
        row.controlloVerificaEnergetica.flagValvSicu = controlloEnergetico[index].valvSicurezza;
        row.controlloVerificaEnergetica.flagScambiatore = controlloEnergetico[index].controllatoEPulito;
        row.controlloVerificaEnergetica.flagRiflusso = controlloEnergetico[index].presenzaRiflusso;
        row.controlloVerificaEnergetica.flagRisultati = controlloEnergetico[index].risControllo;
        row.controlloVerificaEnergetica.altroRifNormativo = controlloEnergetico[index].altroRif;
        if (row && row.tabFumi && row.tabFumi.rowFumi) {
          row.tabFumi.rowFumi.forEach((fumi, index2) => {
            fumi.tempFumi = controlloEnergetico[index].elencoModuli[index2].temperaturaFumi;
            fumi.tempAria = controlloEnergetico[index].elencoModuli[index2].temperaturaAria;
            fumi.o2 = controlloEnergetico[index].elencoModuli[index2].o2;
            fumi.co2 = controlloEnergetico[index].elencoModuli[index2].co2;
            fumi.bacharach1 = controlloEnergetico[index].elencoModuli[index2].bacharach1;
            fumi.bacharach2 = controlloEnergetico[index].elencoModuli[index2].bacharach2;
            fumi.bacharach3 = controlloEnergetico[index].elencoModuli[index2].bacharach3;
            fumi.cOcorretto = controlloEnergetico[index].elencoModuli[index2].coCorretto;
            fumi.rendimCombu = controlloEnergetico[index].elencoModuli[index2].rendimentoCombustione;
            fumi.rendimentoLegge = controlloEnergetico[index].elencoModuli[index2].rendimentoMinimoLegge;
            fumi.moduloTermico = index2 + 1;
            fumi.nox = controlloEnergetico[index].elencoModuli[index2].noxKw;
            fumi.portataCombu = controlloEnergetico[index].elencoModuli[index2].portataCombu;
            fumi.valorePortata = controlloEnergetico[index].elencoModuli[index2].valorePortata;
            fumi.coFumiSecchi = controlloEnergetico[index].elencoModuli[index2].fumiSecchi;
            fumi.rispettoIndBacharach = controlloEnergetico[index].elencoModuli[index2].rispettoIndBacharach;
            fumi.minimo = controlloEnergetico[index].elencoModuli[index2].minimo;
          });
        }
      });
    }
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
    mod.richiesta.datiAllegato.controlloImpianto.flagInterno = controlloImpianto.instInterna;
    mod.richiesta.datiAllegato.controlloImpianto.flagEsterno = controlloImpianto.instEsterna;
    mod.richiesta.datiAllegato.controlloImpianto.flagAperture = controlloImpianto.aperture;
    mod.richiesta.datiAllegato.controlloImpianto.flagDimensioni = controlloImpianto.adeguateDim;
    mod.richiesta.datiAllegato.controlloImpianto.flagCanaleFumo = controlloImpianto.canaleFumo;
    mod.richiesta.datiAllegato.controlloImpianto.flagSistRegolaz = controlloImpianto.tempAmbiente;
    mod.richiesta.datiAllegato.controlloImpianto.flagPerdite = controlloImpianto.assenzePerdite;
    mod.richiesta.datiAllegato.controlloImpianto.flagTenuta = controlloImpianto.idoneaTenuta;
    mod.richiesta.datiAllegato.checkList = new CheckList();
    mod.richiesta.datiAllegato.checkList.flagValvole = checkList.adozioneValvole;
    mod.richiesta.datiAllegato.checkList.flagIsolamento = checkList.isolamentoRete;
    mod.richiesta.datiAllegato.checkList.flagSistTrattACS = checkList.introduzioneSistemaTrattamento;
    mod.richiesta.datiAllegato.checkList.flagSistRegolaz = checkList.sostituzioneSistemaRegolazione;
    mod.richiesta.datiAllegato.checkList.osservazioni = checkList.osservazioni;
    mod.richiesta.datiAllegato.checkList.raccomandazioni = checkList.raccomandazioni;
    mod.richiesta.datiAllegato.checkList.prescrizioni = checkList.prescrizioni;
    mod.richiesta.datiAllegato.datiTecnico = new DatiTecnico();
    mod.richiesta.datiAllegato.datiTecnico.flagFunzImp = checkList.impiantoPuoFunzionare;
    mod.richiesta.datiAllegato.datiTecnico.dataIntervento = this.datePipe.transform(checkList.interventoEntro, FORMAT);
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
      row.controlloVerificaEnergetica.potenzaFocolare = elem.potTermica;
      row.controlloVerificaEnergetica.flagEvacFumi = elem.modEvaquazioneFumi;
      row.controlloVerificaEnergetica.flagClimatizInv = elem.climaInvernale;
      row.controlloVerificaEnergetica.flagProduzACS = elem.prodAcs;
      row.controlloVerificaEnergetica.depressCanaleFumo = elem.depressCanaleFumo;
      row.controlloVerificaEnergetica.flagDispComando = elem.dispComando;
      row.controlloVerificaEnergetica.flagDispSicu = elem.dispSicurezza;
      row.controlloVerificaEnergetica.flagValvSicu = elem.valvSicurezza;
      row.controlloVerificaEnergetica.flagScambiatore = elem.controllatoEPulito;
      row.controlloVerificaEnergetica.flagRiflusso = elem.presenzaRiflusso;
      row.controlloVerificaEnergetica.flagRisultati = elem.risControllo;
      row.controlloVerificaEnergetica.altroRifNormativo = elem.altroRif;
      row.tabFumi = new TabFumi();
      row.tabFumi.rowFumi = [];
      elem.elencoModuli.forEach((elem2, index2) => {
        let fumi = new RowFumi();
        fumi.tempFumi = elem2.temperaturaFumi;
        fumi.tempAria = elem2.temperaturaAria;
        fumi.o2 = elem2.o2;
        fumi.co2 = elem2.co2;
        fumi.bacharach1 = elem2.bacharach1;
        fumi.bacharach2 = elem2.bacharach2;
        fumi.bacharach3 = elem2.bacharach3;
        fumi.cOcorretto = elem2.coCorretto;
        fumi.rendimCombu = elem2.rendimentoCombustione;
        fumi.rendimentoLegge = elem2.rendimentoMinimoLegge;
        fumi.moduloTermico = index2 + 1;
        fumi.nox = elem2.noxKw;
        fumi.portataCombu = elem2.portataCombu;
        fumi.valorePortata = elem2.valorePortata;
        fumi.coFumiSecchi = elem2.fumiSecchi;
        fumi.rispettoIndBacharach = elem2.rispettoIndBacharach;
        fumi.minimo = elem2.minimo;
        row.tabFumi.rowFumi.push(fumi);
      });
      mod.richiesta.datiAllegato.allegato.rowAllegato.push(row);
    });
    return mod;
  }

  mapControlloDisponibileToNuovoControllo(): DatoControlloModel {
    let datoCont = new DatoControlloModel();
    datoCont.controlloModel = new ControlloModel();
    datoCont.controlloModel.dataControllo = this.datePipe.transform(new Date(), FORMAT);
    datoCont.controlloModel.desTipoDocumento = tipiDocDesc.get(TipoDoc.REE_1);
    datoCont.controlloModel.fkTipoDocumento = Number(TipoDoc.REE_1);
    return datoCont;
  }

  selectEvacFumi($event, ener: FormGroup) {
    if (ener.controls.modEvaquazioneFumi.value === "N") {
      ener.controls.depressCanaleFumo.setValidators([Validators.required, formatoDecimale(/^[0-9]{0,5}(?:\.[0-9]{0,2})?$/, 5, 2)]);
    } else {
      ener.controls.depressCanaleFumo.setValidators(formatoDecimale(/^[0-9]{0,5}(?:\.[0-9]{0,2})?$/, 5, 2));
    }
    ener.controls.depressCanaleFumo.updateValueAndValidity();
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
