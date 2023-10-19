import { DatePipe } from '@angular/common';
import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { FormArray, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { tipiDocDesc, TipoDoc } from 'src/app/enums/tipo-doc-enum';
import { ControlloDisponibileModel } from 'src/app/models/controllo-disponibile';
import { ControlloModel } from 'src/app/models/controllo-model';
import { DatiControlloModel } from 'src/app/models/dati-controllo-model';
import { DatiGTModel } from 'src/app/models/dati-gt-model';
import { DatoControlloModel } from 'src/app/models/dato-controllo-model';
import { Esito } from 'src/app/models/esito';
import { Allegato, CheckList, ControlloImpianto, ControlloVerificaEnergetica, datiAllegato, DatiIdentificativi, DatiIntestazione, DatiManutentore, DatiTecnico, DocumentazioneTecnica, Mod, Richiesta, RowAcquaReintegro, RowAllegato, RowCombustibile, RowFumi, TabAcquaReintegro, TabCombustibile, TabFumi, TrattamentoAcqua } from 'src/app/models/mod';
import { OnlineCheckModel } from 'src/app/models/online-check-model';
import { OperazioneControlloModel } from 'src/app/models/operazione-controllo-model';
import { UtenteLoggato } from 'src/app/models/utente-loggato';
import { checkboxCheck1B, validateTrattamentoAcqua } from 'src/app/nuovo-controllo/directives/validator-directive.directive';
import { AuthenticationService } from 'src/app/services/authentication.service';
import { BackService } from 'src/app/services/back.service';
import { ControlloService } from 'src/app/services/controllo.service';
import { LocalStorageServiceService } from 'src/app/services/local-storage-service.service';
import { MessageService } from 'src/app/services/message.service';
import { ResultService } from 'src/app/services/result.service';
import { TitleService } from 'src/app/services/title.service';
import { DISPLAY_FORMAT, ESITO_OPERAZIONI, FORMAT, OPERAZIONI, STATO_RAPP, TRATT_ACQUA, UM } from 'src/app/utils/constants';
import { formatoDecimale } from 'src/app/validators/custom.validator';
import { v4 as uuidv4 } from 'uuid';

@Component({
  selector: 'app-dettaglio-tipo1-b',
  templateUrl: './dettaglio-tipo1-b.component.html',
  styleUrls: ['./dettaglio-tipo1-b.component.scss']
})
export class DettaglioTipo1BComponent implements OnInit {

  success = false;
  offline = false;

  insertForm = this.fb.group({
    dataControllo: [{ value: '', disabled: true }],
    tipoControllo: [{ value: '', disabled: true }],
    ree: [{ value: '', disabled: true }],
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
      instInterna: [, Validators.required],
      instEsterna: [, Validators.required],
      aperture: [, Validators.required],
      adeguateDim: [, Validators.required],
      canaleFumo: [, Validators.required],
      tempAmbiente: [, Validators.required],
      idoneaTenuta: [, Validators.required],
      puliziaCamino: [, Validators.required]
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
    public datePipe: DatePipe,
    private changeDetect: ChangeDetectorRef) {
    this.codiceImpianto = this.route.snapshot.parent.paramMap.get('id_impianto');
    this.idAllegato = this.route.snapshot.paramMap.get('id_allegato');
    this.utente = this.authenticationService.getCurrentUserFromSession();
  }

  ngOnInit(): void {
    this.xmlImpianto = this.localStorageService.getXmlImpianto();
    this.titleService.setTitle("REE TIPO 1B (Biomassa)");
    this.titleService.setSubtitle("Gruppi Termici a biomassa");
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

    this.controlloService.getOnlineSubject().subscribe((elem) => {
      this.offline = !elem;
    });
  }

  compilaDatiIniziali() {
    let arr = this.getControlloEner();
    let datacontrollo = this.datePipe.transform(this.controlloDisponibile.dataControllo, DISPLAY_FORMAT);
    this.insertForm.controls.dataControllo.setValue(datacontrollo);
    this.insertForm.controls.ree.setValue(tipiDocDesc.get(TipoDoc.REE_1B));
    let dataInstall = this.datePipe.transform(this.controlloDisponibile.dataInstall, DISPLAY_FORMAT);
    const enerForm = this.fb.group({
      comp: [{ value: "GT-" + this.controlloDisponibile.progressivo, disabled: true }],
      dataInstall: [{ value: dataInstall, disabled: true }],
      fabbricante: [{ value: this.controlloDisponibile.descMarca, disabled: true }],
      modello: [{ value: this.controlloDisponibile.modello, disabled: true }],
      matricola: [{ value: this.controlloDisponibile.matricola, disabled: true }],
      tipo: [{ value: this.controlloDisponibile.descDettaglio, disabled: true }],
      potTermicaKw: [{ value: this.controlloDisponibile.potTermica, disabled: true }],
      tipologia: [""],
      condEvaquazioneFumi: [""],
      stelle: ["", Validators.required],
      apparecchiature: ["", Validators.required],
      climaInvernale: [false],
      prodAcs: [false],
      cucina: [false],
      depressCanaleFumo: ["", formatoDecimale(/^[0-9]{0,5}(?:\.[0-9]{0,2})?$/, 5, 2)],
      marcaturaCE: [""],
      placcaCamino: [""],
      evaquazioneFumi: ["", Validators.required],
      ariaComburente: ["", Validators.required],
      controlloAria: ["", Validators.required],
      cercaCombu: ["", [Validators.required]],
      combustibile: [{ value: this.controlloDisponibile.descCombustibile, disabled: true }],
      dispComando: ["", Validators.required],
      dispSicurezza: ["", Validators.required],
      valvSicurezza: ["", Validators.required],
      scambiatore: ["", Validators.required],
      riflusso: ["", Validators.required],
      risultati: ["", Validators.required],
      consumoCombustibile: this.fb.array([]),
      elencoModuli: this.fb.array([])
    });
    enerForm.setValidators([checkboxCheck1B]);
    enerForm.updateValueAndValidity();
    arr.push(enerForm);
    let arr2 = enerForm.controls.elencoModuli as FormArray;
    for (let i = 0; i < this.controlloDisponibile.nModuli; i++) {
      const moduloForm = this.fb.group({
        temperaturaFumi: ["", [Validators.required, formatoDecimale(/^-?[0-9]{0,4}(?:\.[0-9]{0,2})?$/, 4, 2)]],
        temperaturaAria: ["", [Validators.required, formatoDecimale(/^-?[0-9]{0,4}(?:\.[0-9]{0,2})?$/, 4, 2)]],
        o2: ["", [Validators.required, formatoDecimale(/^[0-9]{0,3}(?:\.[0-9]{0,2})?$/, 3, 2)]],
        co2: ["", [Validators.required, formatoDecimale(/^[0-9]{0,3}(?:\.[0-9]{0,2})?$/, 3, 2)]],
        particolato: ["", [Validators.required, formatoDecimale(/^[0-9]{0,4}(?:\.[0-9]{0,2})?$/, 4, 2)]],
        coCorretto: ["", [Validators.required, formatoDecimale(/^[0-9]{0,7}(?:\.[0-9]{0,2})?$/, 7, 2)]],
        rendimentoCombustione: ["", [Validators.required, formatoDecimale(/^[0-9]{0,3}(?:\.[0-9]{0,2})?$/, 3, 2)]],
        rendimentoMinimoLegge: ["", [Validators.required, formatoDecimale(/^[0-9]{0,3}(?:\.[0-9]{0,2})?$/, 3, 2)]],
        noxKw: ["", [Validators.required, formatoDecimale(/^[0-9]{0,7}(?:\.[0-9]{0,2})?$/, 7, 2)]],
        noxNm3: ["", [Validators.required, formatoDecimale(/^[0-9]{0,7}(?:\.[0-9]{0,2})?$/, 7, 2)]],
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
      acquaDiReintegro: this.fb.array([])
    });
  }

  compilaDatiDettaglio() {
    if (this.datiControllo && this.dettaglioControllo) {
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
          acquaDiReintegro: this.fb.array([]),
        });
        if (trattamentoAcqua.tabAcquaReintegro) {
          trattamentoAcqua.tabAcquaReintegro.rowAcquaReintegro.forEach((row: RowAcquaReintegro) => {
            let rowAcqua = this.getAcquaDiReintegro();
            const rowAcquaForm = this.fb.group({
              esercizio: [row.esercizio, [Validators.required, Validators.pattern(/^(19|20)[0-9][0-9]$/)]],
              letturaIniziale: [row.letturaIniziale, [Validators.required, Validators.pattern(/^[0-9]*$/)]],
              letturaFinale: [row.letturaFinale, [Validators.required, Validators.pattern(/^[0-9]*$/)]],
              consumoTotale: [row.consumoTotale, [Validators.required, formatoDecimale(/^[0-9]{0,4}(?:\.[0-9]{0,2})?$/, 4, 2)]],
            });
            rowAcqua.push(rowAcquaForm);
          });
        }
      }

      if (controlloImpianto) {
        this.insertForm.controls["controlloImpianto"].patchValue({
          instInterna: controlloImpianto.flagInterno,
          instEsterna: controlloImpianto.flagEsterno,
          aperture: controlloImpianto.flagAperture,
          adeguateDim: controlloImpianto.flagDimensioni,
          canaleFumo: controlloImpianto.flagCanaleFumo,
          tempAmbiente: controlloImpianto.flagSistRegolaz,
          idoneaTenuta: controlloImpianto.flagTenuta,
          puliziaCamino: controlloImpianto.flagPuliziaCamino
        });
      }

      /* this.compilaDettaglioomponente(); */
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
    let contEnerArr = this.getControlloEner();
    let tipologia = undefined;
    let evacFumi = undefined;

    if (controlloEnergetico.flagCaldaia) {
      tipologia = 0;
    } else if (controlloEnergetico.flagStufa) {
      tipologia = 1;
    } else if (controlloEnergetico.flagStufaAccumulo) {
      tipologia = 2;
    } else if (controlloEnergetico.flagTermocucina) {
      tipologia = 3;
    }

    if (controlloEnergetico.flagCaminoAperto) {
      evacFumi = 0;
    } else if (controlloEnergetico.flagCaminoChiuso) {
      evacFumi = 1;
    } else if (controlloEnergetico.flagInsertoCamino) {
      evacFumi = 2;
    }

    let dataInstall = this.datePipe.transform(gt.dataInstall, DISPLAY_FORMAT);
    const enerForm = this.fb.group({
      comp: [{ value: "GT-" + gt.progressivo, disabled: true }],
      dataInstall: [{ value: dataInstall, disabled: true }],
      fabbricante: [{ value: gt.descMarca, disabled: true }],
      modello: [{ value: gt.modello, disabled: true }],
      matricola: [{ value: gt.matricola, disabled: true }],
      tipo: [{ value: gt.descDettaglioGt, disabled: true }],
      potTermicaKw: [{ value: gt.potenzaTermicaKw, disabled: true }],
      tipologia: [tipologia],
      condEvaquazioneFumi: [evacFumi],
      stelle: [controlloEnergetico.stelle ? controlloEnergetico.stelle.toString() : undefined, Validators.required],
      apparecchiature: [controlloEnergetico.apparecchiatura ? controlloEnergetico.apparecchiatura.toString() : '', Validators.required],
      climaInvernale: [controlloEnergetico.flagClimatizInv],
      prodAcs: [controlloEnergetico.flagProduzACS],
      cucina: [controlloEnergetico.flagCucina],
      depressCanaleFumo: [controlloEnergetico.depressCanaleFumo, [controlloEnergetico.flagEvacFumi === "N" ? Validators.required : Validators.nullValidator, formatoDecimale(/^[0-9]{0,5}(?:\.[0-9]{0,2})?$/, 5, 2)]],
      marcaturaCE: [controlloEnergetico.flagMarcaturaCEE],
      placcaCamino: [controlloEnergetico.flagPlaccaCamino],
      evaquazioneFumi: [controlloEnergetico.flagEvacFumi, Validators.required],
      ariaComburente: [controlloEnergetico.ariaComburente ? controlloEnergetico.ariaComburente.toString() : '', Validators.required],
      controlloAria: [controlloEnergetico.controlloAria ? controlloEnergetico.controlloAria.toString() : '', Validators.required],
      cercaCombu: [controlloEnergetico.carcaCombu, [Validators.required]],
      combustibile: [{ value: gt.descCombustibile, disabled: true }],
      dispComando: [controlloEnergetico.flagDispComando, Validators.required],
      dispSicurezza: [controlloEnergetico.flagDispSicu, Validators.required],
      valvSicurezza: [controlloEnergetico.flagValvSicu, Validators.required],
      scambiatore: [controlloEnergetico.flagScambiatore, Validators.required],
      riflusso: [controlloEnergetico.flagRiflusso, Validators.required],
      risultati: [controlloEnergetico.flagRisultati, Validators.required],
      consumoCombustibile: this.fb.array([]),
      elencoModuli: this.fb.array([])
    });
    enerForm.setValidators([checkboxCheck1B]);
    enerForm.updateValueAndValidity();
    contEnerArr.push(enerForm);
    elem.tabFumi.rowFumi.forEach((row: RowFumi) => {
      let rowFumiArr = enerForm.controls.elencoModuli as FormArray;
      const rowFumiForm = this.fb.group({
        temperaturaFumi: [row.tempFumi, [Validators.required, formatoDecimale(/^-?[0-9]{0,4}(?:\.[0-9]{0,2})?$/, 4, 2)]],
        temperaturaAria: [row.tempAria, [Validators.required, formatoDecimale(/^-?[0-9]{0,4}(?:\.[0-9]{0,2})?$/, 4, 2)]],
        o2: [row.o2, [Validators.required, formatoDecimale(/^[0-9]{0,3}(?:\.[0-9]{0,2})?$/, 3, 2)]],
        co2: [row.co2, [Validators.required, formatoDecimale(/^[0-9]{0,3}(?:\.[0-9]{0,2})?$/, 3, 2)]],
        particolato: [row.particolato, [Validators.required, formatoDecimale(/^[0-9]{0,4}(?:\.[0-9]{0,2})?$/, 4, 2)]],
        coCorretto: [row.cOcorretto, [Validators.required, formatoDecimale(/^[0-9]{0,7}(?:\.[0-9]{0,2})?$/, 7, 2)]],
        rendimentoCombustione: [row.rendimCombu, [Validators.required, formatoDecimale(/^[0-9]{0,3}(?:\.[0-9]{0,2})?$/, 3, 2)]],
        rendimentoMinimoLegge: [row.rendimentoLegge, [Validators.required, formatoDecimale(/^[0-9]{0,3}(?:\.[0-9]{0,2})?$/, 3, 2)]],
        noxKw: [{ value: row.noxUM === UM.MG_K_WH ? row.nox : "", disabled: row.noxUM === UM.MG_NM_3 }, [row.noxUM === UM.MG_K_WH ? Validators.required : Validators.nullValidator, formatoDecimale(/^[0-9]{0,7}(?:\.[0-9]{0,2})?$/, 7, 2)]],
        noxNm3: [{ value: row.noxUM === UM.MG_NM_3 ? row.nox : "", disabled: row.noxUM === UM.MG_K_WH }, [row.noxUM === UM.MG_NM_3 ? Validators.required : Validators.nullValidator, formatoDecimale(/^[0-9]{0,7}(?:\.[0-9]{0,2})?$/, 7, 2)]],
      });
      rowFumiArr.push(rowFumiForm);
    });
    if (elem.tabCombustibile) {
      elem.tabCombustibile.rowCombustibile.forEach((row: RowCombustibile) => {
        let rowCombuArr = enerForm.controls.consumoCombustibile as FormArray;
        const combuForm = this.fb.group({
          unitaMisura: [row.unitaMisura ? row.unitaMisura.toString() : "", Validators.required],
          esercizio: [row.esercizio, [Validators.required, Validators.pattern(/^(19|20)[0-9][0-9]$/)]],
          consumoFinale: [row.consumoAnnuo, [Validators.required, formatoDecimale(/^[0-9]{0,4}(?:\.[0-9]{0,2})?$/, 4, 2)]],
        });
        rowCombuArr.push(combuForm);
      });
    }
  }

  addConsumoCombustibileEmpty(enerForm) {
    let rowCombuArr = enerForm.controls.consumoCombustibile as FormArray;
    const combuForm = this.fb.group({
      unitaMisura: ['', Validators.required],
      esercizio: ['', [Validators.required, Validators.pattern(/^(19|20)[0-9][0-9]$/)]],
      consumoFinale: ['', [Validators.required, formatoDecimale(/^[0-9]{0,4}(?:\.[0-9]{0,2})?$/, 4, 2)]],
    });
    rowCombuArr.push(combuForm);
  }

  getAcquaDiReintegro() {
    return this.insertForm.get("trattamentoAcqua.acquaDiReintegro") as FormArray;
  }

  deleteAcquaDiReintegro(lessonIndex: number) {
    let acqua = this.getAcquaDiReintegro();
    acqua.removeAt(lessonIndex);
  }

  deleteConsumoCombustibile(lessonIndex: number, enerForm) {
    let rowCombuArr = enerForm.controls.consumoCombustibile as FormArray;
    rowCombuArr.removeAt(lessonIndex);
  }

  addAcquaDiReintegroEmpty() {
    let acqua = this.getAcquaDiReintegro();
    const acquaForm = this.fb.group({
      esercizio: ['', [Validators.required, Validators.pattern(/^(19|20)[0-9][0-9]$/)]],
      letturaIniziale: ['', [Validators.required, Validators.pattern(/^[0-9]*$/)]],
      letturaFinale: ['', [Validators.required, Validators.pattern(/^[0-9]*$/)]],
      consumoTotale: ['', [Validators.required, formatoDecimale(/^[0-9]{0,4}(?:\.[0-9]{0,2})?$/, 4, 2)]],
    });
    acqua.push(acquaForm);
  }

  step = 0;
  setStep(index: number) {
    this.step = index;
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
      datoCont.controlloModel.desTipoDocumento = tipiDocDesc.get(TipoDoc.REE_1B);
      datoCont.controlloModel.fkTipoDocumento = Number(TipoDoc.REE_1B);
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
      Object.keys(this.insertForm.controls).forEach(key => {
        if (this.insertForm.controls[key].invalid) {
          console.log(key);
        }
      });
    }
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
    xml.richiesta.datiAllegato.controlloImpianto.flagPuliziaCamino = controlloImpianto.puliziaCamino;
    xml.richiesta.datiAllegato.controlloImpianto.flagTenuta = controlloImpianto.idoneaTenuta;
    xml.richiesta.datiAllegato.checkList.flagValvole = checkList.adozioneValvole;
    xml.richiesta.datiAllegato.checkList.flagIsolamento = checkList.isolamentoRete;
    xml.richiesta.datiAllegato.checkList.flagSistTrattACS = checkList.introduzioneSistemaTrattamento;
    xml.richiesta.datiAllegato.checkList.flagSistRegolaz = checkList.sostituzioneSistemaRegolazione;
    xml.richiesta.datiAllegato.checkList.osservazioni = checkList.osservazioni;
    xml.richiesta.datiAllegato.checkList.raccomandazioni = checkList.raccomandazioni;
    xml.richiesta.datiAllegato.checkList.prescrizioni = checkList.prescrizioni;
    xml.richiesta.datiAllegato.datiTecnico.flagFunzImp = checkList.impiantoPuoFunzionare;
    xml.richiesta.datiAllegato.datiTecnico.dataIntervento = this.datePipe.transform(checkList.interventoEntro, FORMAT);
    let nomeCognome: string = tecnico.nomeCognome;
    let nome: string = nomeCognome && nomeCognome.split(" ")[0] ? nomeCognome.split(" ")[0] : "";
    let cognome: string = nomeCognome && nomeCognome.split(" ")[1] ? nomeCognome.split(" ")[1] : "";
    xml.richiesta.datiAllegato.datiTecnico.nomeTecnico = nome;
    xml.richiesta.datiAllegato.datiTecnico.cognomeTecnico = cognome;
    xml.richiesta.datiAllegato.datiTecnico.orarioArrivo = tecnico.orarioArrivo;
    xml.richiesta.datiAllegato.datiTecnico.orarioPartenza = tecnico.orarioPartenza;
    xml.richiesta.datiAllegato.trattamentoAcqua.tabAcquaReintegro.rowAcquaReintegro = [];
    let acquaRe = this.insertForm.get("trattamentoAcqua.acquaDiReintegro").value;
    acquaRe.forEach(element => {
      let row = new RowAcquaReintegro();
      row.consumoTotale = element.consumoTotale;
      row.esercizio = element.esercizio;
      row.letturaFinale = element.letturaFinale;
      row.letturaIniziale = element.letturaIniziale;
      row.unitaMisura = 1;
      xml.richiesta.datiAllegato.trattamentoAcqua.tabAcquaReintegro.rowAcquaReintegro.push(row);
    });
    if (xml.richiesta.datiAllegato.allegato.rowAllegato) {
      xml.richiesta.datiAllegato.allegato.rowAllegato.forEach((row, index) => {
        row.tabCombustibile.rowCombustibile = [];
        switch (controlloEnergetico[index].tipologia) {
          case 0:
            row.controlloVerificaEnergetica.flagCaldaia = true;
            break;
          case 1:
            row.controlloVerificaEnergetica.flagStufa = true;
            break;
          case 2:
            row.controlloVerificaEnergetica.flagStufaAccumulo = true;
            break;
          case 3:
            row.controlloVerificaEnergetica.flagTermocucina = true;
            break;
        }

        switch (controlloEnergetico[index].condEvaquazioneFumi) {
          case 0:
            row.controlloVerificaEnergetica.flagCaminoAperto = true;
            break;
          case 1:
            row.controlloVerificaEnergetica.flagCaminoChiuso = true;
            break;
          case 2:
            row.controlloVerificaEnergetica.flagInsertoCamino = true;
            break;
        }

        row.controlloVerificaEnergetica.stelle = controlloEnergetico[index].stelle;
        row.controlloVerificaEnergetica.apparecchiatura = controlloEnergetico[index].apparecchiature;
        row.controlloVerificaEnergetica.flagClimatizInv = controlloEnergetico[index].climaInvernale;
        row.controlloVerificaEnergetica.flagProduzACS = controlloEnergetico[index].prodAcs;
        row.controlloVerificaEnergetica.flagCucina = controlloEnergetico[index].cucina;
        row.controlloVerificaEnergetica.depressCanaleFumo = controlloEnergetico[index].depressCanaleFumo;
        row.controlloVerificaEnergetica.flagMarcaturaCEE = controlloEnergetico[index].marcaturaCE;
        row.controlloVerificaEnergetica.flagPlaccaCamino = controlloEnergetico[index].placcaCamino;
        row.controlloVerificaEnergetica.flagEvacFumi = controlloEnergetico[index].evaquazioneFumi;
        row.controlloVerificaEnergetica.ariaComburente = controlloEnergetico[index].ariaComburente;
        row.controlloVerificaEnergetica.controlloAria = controlloEnergetico[index].controlloAria;
        row.controlloVerificaEnergetica.carcaCombu = controlloEnergetico[index].cercaCombu;
        row.controlloVerificaEnergetica.combustibile = controlloEnergetico[index].combustibile;
        row.controlloVerificaEnergetica.flagDispComando = controlloEnergetico[index].dispComando;
        row.controlloVerificaEnergetica.flagDispSicu = controlloEnergetico[index].dispSicurezza;
        row.controlloVerificaEnergetica.flagValvSicu = controlloEnergetico[index].valvSicurezza;
        row.controlloVerificaEnergetica.flagScambiatore = controlloEnergetico[index].scambiatore;
        row.controlloVerificaEnergetica.flagRiflusso = controlloEnergetico[index].riflusso;
        row.controlloVerificaEnergetica.flagRisultati = controlloEnergetico[index].risultati;

        controlloEnergetico[index].consumoCombustibile.forEach(element => {
          let combu = new RowCombustibile();
          combu.consumoAnnuo = element.consumoFinale;
          combu.esercizio = element.esercizio;
          combu.unitaMisura = element.unitaMisura;
          row.tabCombustibile.rowCombustibile.push(combu);
        });

        if (row && row.tabFumi && row.tabFumi.rowFumi) {
          row.tabFumi.rowFumi.forEach((fumi, index2) => {
            fumi.tempFumi = controlloEnergetico[index].elencoModuli[index2].temperaturaFumi;
            fumi.tempAria = controlloEnergetico[index].elencoModuli[index2].temperaturaAria;
            fumi.o2 = controlloEnergetico[index].elencoModuli[index2].o2;
            fumi.co2 = controlloEnergetico[index].elencoModuli[index2].co2;
            fumi.particolato = controlloEnergetico[index].elencoModuli[index2].particolato;
            fumi.cOcorretto = controlloEnergetico[index].elencoModuli[index2].coCorretto;
            fumi.rendimCombu = controlloEnergetico[index].elencoModuli[index2].rendimentoCombustione;
            fumi.rendimentoLegge = controlloEnergetico[index].elencoModuli[index2].rendimentoMinimoLegge;
            if (controlloEnergetico[index].elencoModuli[index2].noxKw) {
              fumi.nox = controlloEnergetico[index].elencoModuli[index2].noxKw;
              fumi.noxUM = UM.MG_K_WH;
            } else {
              fumi.nox = controlloEnergetico[index].elencoModuli[index2].noxNm3;
              fumi.noxUM = UM.MG_NM_3;
            }
            fumi.moduloTermico = index2 + 1;
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
    mod.richiesta.datiAllegato.controlloImpianto.flagPuliziaCamino = controlloImpianto.puliziaCamino;
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
    let acquaRe = this.insertForm.get("trattamentoAcqua.acquaDiReintegro").value;
    mod.richiesta.datiAllegato.trattamentoAcqua.tabAcquaReintegro = new TabAcquaReintegro();
    mod.richiesta.datiAllegato.trattamentoAcqua.tabAcquaReintegro.rowAcquaReintegro = [];
    acquaRe.forEach(element => {
      let row = new RowAcquaReintegro();
      row.consumoTotale = element.consumoTotale;
      row.esercizio = element.esercizio;
      row.letturaFinale = element.letturaFinale;
      row.letturaIniziale = element.letturaIniziale;
      row.unitaMisura = 1;
      mod.richiesta.datiAllegato.trattamentoAcqua.tabAcquaReintegro.rowAcquaReintegro.push(row);
    });
    controlloEnergetico.forEach(elem => {
      let row = new RowAllegato();
      row.tabCombustibile = new TabCombustibile();
      row.tabCombustibile.rowCombustibile = [];
      row.controlloVerificaEnergetica = new ControlloVerificaEnergetica();
      switch (elem.tipologia) {
        case 0:
          row.controlloVerificaEnergetica.flagCaldaia = true;
          break;
        case 1:
          row.controlloVerificaEnergetica.flagStufa = true;
          break;
        case 2:
          row.controlloVerificaEnergetica.flagStufaAccumulo = true;
          break;
        case 3:
          row.controlloVerificaEnergetica.flagTermocucina = true;
          break;
      }

      switch (elem.condEvaquazioneFumi) {
        case 0:
          row.controlloVerificaEnergetica.flagCaminoAperto = true;
          break;
        case 1:
          row.controlloVerificaEnergetica.flagCaminoChiuso = true;
          break;
        case 2:
          row.controlloVerificaEnergetica.flagInsertoCamino = true;
          break;
      }
      row.num = this.controlloDisponibile.progressivo;
      row.controlloVerificaEnergetica.stelle = elem.stelle;
      row.controlloVerificaEnergetica.apparecchiatura = elem.apparecchiature;
      row.controlloVerificaEnergetica.flagClimatizInv = elem.climaInvernale;
      row.controlloVerificaEnergetica.flagProduzACS = elem.prodAcs;
      row.controlloVerificaEnergetica.flagCucina = elem.cucina;
      row.controlloVerificaEnergetica.depressCanaleFumo = elem.depressCanaleFumo;
      row.controlloVerificaEnergetica.flagMarcaturaCEE = elem.marcaturaCE;
      row.controlloVerificaEnergetica.flagPlaccaCamino = elem.placcaCamino;
      row.controlloVerificaEnergetica.flagEvacFumi = elem.evaquazioneFumi;
      row.controlloVerificaEnergetica.ariaComburente = elem.ariaComburente;
      row.controlloVerificaEnergetica.controlloAria = elem.controlloAria;
      row.controlloVerificaEnergetica.carcaCombu = elem.cercaCombu;
      row.controlloVerificaEnergetica.combustibile = elem.combustibile;
      row.controlloVerificaEnergetica.flagDispComando = elem.dispComando;
      row.controlloVerificaEnergetica.flagDispSicu = elem.dispSicurezza;
      row.controlloVerificaEnergetica.flagValvSicu = elem.valvSicurezza;
      row.controlloVerificaEnergetica.flagScambiatore = elem.scambiatore;
      row.controlloVerificaEnergetica.flagRiflusso = elem.riflusso;
      row.controlloVerificaEnergetica.flagRisultati = elem.risultati;
      row.controlloVerificaEnergetica.altroRifNormativo = "";
      elem.consumoCombustibile.forEach(element => {
        let combu = new RowCombustibile();
        combu.consumoAnnuo = element.consumoFinale;
        combu.esercizio = element.esercizio;
        combu.unitaMisura = element.unitaMisura;
        row.tabCombustibile.rowCombustibile.push(combu);
      });
      row.tabFumi = new TabFumi();
      row.tabFumi.rowFumi = [];
      elem.elencoModuli.forEach((elem2, index2) => {
        let fumi = new RowFumi();
        fumi.tempFumi = elem2.temperaturaFumi;
        fumi.tempAria = elem2.temperaturaAria;
        fumi.o2 = elem2.o2;
        fumi.co2 = elem2.co2;
        fumi.particolato = elem2.particolato;
        fumi.cOcorretto = elem2.coCorretto;
        fumi.rendimCombu = elem2.rendimentoCombustione;
        fumi.rendimentoLegge = elem2.rendimentoMinimoLegge;
        if (elem2.noxKw) {
          fumi.nox = elem2.noxKw;
          fumi.noxUM = UM.MG_K_WH;
        } else {
          fumi.nox = elem2.noxNm3;
          fumi.noxUM = UM.MG_NM_3;
        }
        fumi.moduloTermico = index2 + 1;
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
    datoCont.controlloModel.desTipoDocumento = tipiDocDesc.get(TipoDoc.REE_1B);
    datoCont.controlloModel.fkTipoDocumento = Number(TipoDoc.REE_1B);
    return datoCont;
  }

  changeNox(modulo, dataInstall) {
    modulo.controls["noxKw"].setValidators([Validators.required, formatoDecimale(/^[0-9]{0,7}(?:\.[0-9]{0,2})?$/, 7, 2)]);
    modulo.controls["noxNm3"].setValidators([Validators.required, formatoDecimale(/^[0-9]{0,7}(?:\.[0-9]{0,2})?$/, 7, 2)]);
    if (modulo.controls["noxKw"].value) {
      modulo.controls["noxNm3"].setValue("");
      modulo.controls["noxNm3"].disable();
      modulo.controls["noxNm3"].clearValidators();
    } else {
      modulo.controls["noxNm3"].enable();
    }

    if (modulo.controls["noxNm3"].value) {
      modulo.controls["noxKw"].setValue("");
      modulo.controls["noxKw"].disable();
      modulo.controls["noxKw"].clearValidators();
    } else {
      modulo.controls["noxKw"].enable("");
    }

    modulo.updateValueAndValidity();
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
