import { NumberInput } from '@angular/cdk/coercion';
import { DatePipe } from '@angular/common';
import { Component, HostListener, OnInit } from '@angular/core';
import { FormArray, FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { tipiDocDesc, TipoDoc } from 'src/app/enums/tipo-doc-enum';
import { CodiceDescrizione } from 'src/app/models/codice-descrizione';
import { ControlloDisponibileModel } from 'src/app/models/controllo-disponibile';
import { ControlloModel } from 'src/app/models/controllo-model';
import { DatiCGModel } from 'src/app/models/dati-cg-model';
import { DatiControlloModel } from 'src/app/models/dati-controllo-model';
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
  selector: 'app-dettaglio-tipo4',
  templateUrl: './dettaglio-tipo4.component.html',
  styleUrls: ['./dettaglio-tipo4.component.scss']
})
export class DettaglioTipo4Component implements OnInit {

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
      dimensioni: ["", Validators.required],
      aperture: ["", Validators.required],
      lineeIdonee: ["", Validators.required],
      canaleFumo: ["", Validators.required],
      capsulaInso: ["", Validators.required],
      tenutaIdraulica: ["", Validators.required],
      tenutaOlio: ["", Validators.required],
      tenutaAlimentaz: ["", Validators.required],
      funzionalita: ["", Validators.required]
    }),
    controlloEnergetico: this.fb.array([]),
    checkList: this.fb.group({
      valvole: [false],
      isolamento: [false],
      sistTrattAcs: [false],
      sistRegolaz: [false],
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

  colBreakpoint1: NumberInput;
  colBreakpoint2: NumberInput;
  colBreakpoint3: NumberInput;
  colBreakpoint4: NumberInput;

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
    this.colBreakpoint1 = (window.innerWidth < 768) ? 12 : 6;
    this.colBreakpoint2 = (window.innerWidth < 768) ? 0 : 6;
    this.colBreakpoint3 = (window.innerWidth < 768) ? 10 : 5;
    this.colBreakpoint4 = (window.innerWidth < 768) ? 1 : 0;

    this.titleService.setTitle("REE TIPO 4");
    this.titleService.setSubtitle("Cogeneratori");
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
    let dataInstall = this.datePipe.transform(this.controlloDisponibile.dataInstall, DISPLAY_FORMAT);
    this.insertForm.controls.ree.setValue(tipiDocDesc.get(TipoDoc.REE_4));
    const enerForm = this.fb.group({
      comp: [{ value: "SC-" + this.controlloDisponibile.progressivo, disabled: true }],
      dataInstall: [{ value: dataInstall, disabled: true }],
      fabbricante: [{ value: this.controlloDisponibile.descMarca, disabled: true }],
      modello: [{ value: this.controlloDisponibile.modello, disabled: true }],
      matricola: [{ value: this.controlloDisponibile.matricola, disabled: true }],
      tipo: [{ value: this.controlloDisponibile.descDettaglio, disabled: true }],
      alimentazione: [{ value: this.controlloDisponibile.alimentazione, disabled: true }],
      fluidoVett: ["", [Validators.required]],
      potAssorbita: [""],
      potTermica: [{ value: this.controlloDisponibile.potTermica, disabled: true }],
      potTermBypass: [""],
      emissioniCO: [{ value: (this.controlloDisponibile.coMin ? this.controlloDisponibile.coMin + "\\" : "\\") + (this.controlloDisponibile.coMax ? this.controlloDisponibile.coMax : ""), disabled: true }],
      elencoCircuiti: this.fb.array([])
    });
    arr.push(enerForm);
    let arr2 = enerForm.controls.elencoCircuiti as FormArray;
    const moduloForm = this.fb.group({
      tempAriaCombur: ["", [Validators.required, formatoDecimale(/^-?[0-9]{0,4}(?:\.[0-9]{0,2})?$/, 4, 2)]],
      tempAcquaUsc: ["", [Validators.required, formatoDecimale(/^-?[0-9]{0,4}(?:\.[0-9]{0,2})?$/, 4, 2)]],
      tempAcquaIng: ["", [Validators.required, formatoDecimale(/^-?[0-9]{0,4}(?:\.[0-9]{0,2})?$/, 4, 2)]],
      potenzaMorsetti: ["", [Validators.required, formatoDecimale(/^[0-9]{0,4}(?:\.[0-9]{0,2})?$/, 4, 2)]],
      tempH2oMotore: ["", [Validators.required, formatoDecimale(/^-?[0-9]{0,4}(?:\.[0-9]{0,2})?$/, 4, 2)]],
      tempFumiAValle: ["", [Validators.required, formatoDecimale(/^-?[0-9]{0,4}(?:\.[0-9]{0,2})?$/, 4, 2)]],
      tempFumiAMonte: ["", [Validators.required, formatoDecimale(/^-?[0-9]{0,4}(?:\.[0-9]{0,2})?$/, 4, 2)]],
      sovraFreqSoglia1: ["", formatoDecimale(/^[0-9]{0,3}(?:\.[0-9]{0,2})?$/, 3, 2)],
      sovraFreqSoglia2: ["", formatoDecimale(/^[0-9]{0,3}(?:\.[0-9]{0,2})?$/, 3, 2)],
      sovraFreqSoglia3: ["", formatoDecimale(/^[0-9]{0,3}(?:\.[0-9]{0,2})?$/, 3, 2)],
      sovraFreqTempo1: ["", formatoDecimale(/^[0-9]{0,3}(?:\.[0-9]{0,2})?$/, 3, 2)],
      sovraFreqTempo2: ["", formatoDecimale(/^[0-9]{0,3}(?:\.[0-9]{0,2})?$/, 3, 2)],
      sovraFreqTempo3: ["", formatoDecimale(/^[0-9]{0,3}(?:\.[0-9]{0,2})?$/, 3, 2)],
      sottoFreqSoglia1: ["", formatoDecimale(/^[0-9]{0,3}(?:\.[0-9]{0,2})?$/, 3, 2)],
      sottoFreqSoglia2: ["", formatoDecimale(/^[0-9]{0,3}(?:\.[0-9]{0,2})?$/, 3, 2)],
      sottoFreqSoglia3: ["", formatoDecimale(/^[0-9]{0,3}(?:\.[0-9]{0,2})?$/, 3, 2)],
      sottoFreqTempo1: ["", formatoDecimale(/^[0-9]{0,3}(?:\.[0-9]{0,2})?$/, 3, 2)],
      sottoFreqTempo2: ["", formatoDecimale(/^[0-9]{0,3}(?:\.[0-9]{0,2})?$/, 3, 2)],
      sottoFreqTempo3: ["", formatoDecimale(/^[0-9]{0,3}(?:\.[0-9]{0,2})?$/, 3, 2)],
      sovraTensSoglia1: ["", formatoDecimale(/^[0-9]{0,3}(?:\.[0-9]{0,2})?$/, 3, 2)],
      sovraTensSoglia2: ["", formatoDecimale(/^[0-9]{0,3}(?:\.[0-9]{0,2})?$/, 3, 2)],
      sovraTensSoglia3: ["", formatoDecimale(/^[0-9]{0,3}(?:\.[0-9]{0,2})?$/, 3, 2)],
      sovraTensTempo1: ["", formatoDecimale(/^[0-9]{0,3}(?:\.[0-9]{0,2})?$/, 3, 2)],
      sovraTensTempo2: ["", formatoDecimale(/^[0-9]{0,3}(?:\.[0-9]{0,2})?$/, 3, 2)],
      sovraTensTempo3: ["", formatoDecimale(/^[0-9]{0,3}(?:\.[0-9]{0,2})?$/, 3, 2)],
      sottoTensSoglia1: ["", formatoDecimale(/^[0-9]{0,3}(?:\.[0-9]{0,2})?$/, 3, 2)],
      sottoTensSoglia2: ["", formatoDecimale(/^[0-9]{0,3}(?:\.[0-9]{0,2})?$/, 3, 2)],
      sottoTensSoglia3: ["", formatoDecimale(/^[0-9]{0,3}(?:\.[0-9]{0,2})?$/, 3, 2)],
      sottoTensTempo1: ["", formatoDecimale(/^[0-9]{0,3}(?:\.[0-9]{0,2})?$/, 3, 2)],
      sottoTensTempo2: ["", formatoDecimale(/^[0-9]{0,3}(?:\.[0-9]{0,2})?$/, 3, 2)],
      sottoTensTempo3: ["", formatoDecimale(/^[0-9]{0,3}(?:\.[0-9]{0,2})?$/, 3, 2)]
    });
    arr2.push(moduloForm);

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
          luogoIdoneo: controlloImpianto.flagLuogoIdoneo,
          dimensioni: controlloImpianto.flagDimensioni,
          aperture: controlloImpianto.flagAperture,
          lineeIdonee: controlloImpianto.flagLineeIdonee,
          canaleFumo: controlloImpianto.flagCanaleFumo,
          capsulaInso: controlloImpianto.flagCapsulaInso,
          tenutaIdraulica: controlloImpianto.flagTenutaIdraulica,
          tenutaOlio: controlloImpianto.flagTenutaOlio,
          tenutaAlimentaz: controlloImpianto.flagTenutaAlimentaz,
          funzionalita: controlloImpianto.flagFunzionalita
        });
      }

      rowAllegato.forEach((row: RowAllegato) => {
        this.dettaglioControllo.datiCompModelList.forEach((cg: DatiCGModel) => {
          if (row.num == cg.progressivo && !cg.dataDismiss) {
            this.addControlloEner(row, cg);
          }
        });
      });

      if (checklist) {
        this.insertForm.controls["checkList"].patchValue({
          valvole: checklist.flagValvole,
          isolamento: checklist.flagIsolamento,
          sistTrattAcs: checklist.flagSistTrattACS,
          sistRegolaz: checklist.flagSistRegolaz,
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

  addControlloEner(elem: RowAllegato, cg: DatiCGModel) {
    let controlloEnergetico = elem.controlloVerificaEnergetica
    let contEnerArr = this.getControlloEner();
    let dataInstall = this.datePipe.transform(cg.dataInstall, DISPLAY_FORMAT);
    const enerForm = this.fb.group({
      comp: [{ value: "CG-" + cg.progressivo, disabled: true }],
      dataInstall: [{ value: dataInstall, disabled: true }],
      fabbricante: [{ value: cg.descMarca, disabled: true }],
      modello: [{ value: cg.modello, disabled: true }],
      matricola: [{ value: cg.matricola, disabled: true }],
      tipo: [{ value: cg.tipologia, disabled: true }],
      alimentazione: [{ value: cg.alimentazione, disabled: true }],
      fluidoVett: [controlloEnergetico.fluidoVett, [Validators.required]],
      potAssorbita: [controlloEnergetico.potenzaAssorbita],
      potTermica: [{ value: cg.potenzaTermicaKw, disabled: true }],
      potTermBypass: [controlloEnergetico.potenzaTermByPass],
      emissioniCO: [{ value: (cg.coMin ? cg.coMin + "\\" : "\\") + (cg.coMax ? cg.coMax : ""), disabled: true }],
      elencoCircuiti: this.fb.array([])
    });
    contEnerArr.push(enerForm);
    elem.tabFumi.rowFumi.forEach((row: RowFumi) => {
      let rowFumiArr = enerForm.controls.elencoCircuiti as FormArray;
      const rowFumiForm = this.fb.group({
        tempAriaCombur: [row.tempAriaCombur, [Validators.required, formatoDecimale(/^-?[0-9]{0,4}(?:\.[0-9]{0,2})?$/, 4, 2)]],
        tempAcquaUsc: [row.tempAcquaUsc, [Validators.required, formatoDecimale(/^-?[0-9]{0,4}(?:\.[0-9]{0,2})?$/, 4, 2)]],
        tempAcquaIng: [row.tempAcquaIng, [Validators.required, formatoDecimale(/^-?[0-9]{0,4}(?:\.[0-9]{0,2})?$/, 4, 2)]],
        potenzaMorsetti: [row.potenzaMorsetti, [Validators.required, formatoDecimale(/^[0-9]{0,4}(?:\.[0-9]{0,2})?$/, 4, 2)]],
        tempH2oMotore: [row.tempH2Omotore, [Validators.required, formatoDecimale(/^-?[0-9]{0,4}(?:\.[0-9]{0,2})?$/, 4, 2)]],
        tempFumiAValle: [row.tempFumiAvalle, [Validators.required, formatoDecimale(/^-?[0-9]{0,4}(?:\.[0-9]{0,2})?$/, 4, 2)]],
        tempFumiAMonte: [row.tempFumiAmonte, [Validators.required, formatoDecimale(/^-?[0-9]{0,4}(?:\.[0-9]{0,2})?$/, 4, 2)]],
        sovraFreqSoglia1: [row.sovraFreqSoglia1, [formatoDecimale(/^[0-9]{0,3}(?:\.[0-9]{0,2})?$/, 3, 2)]],
        sovraFreqSoglia2: [row.sovraFreqSoglia2, [formatoDecimale(/^[0-9]{0,3}(?:\.[0-9]{0,2})?$/, 3, 2)]],
        sovraFreqSoglia3: [row.sovraFreqSoglia3, [formatoDecimale(/^[0-9]{0,3}(?:\.[0-9]{0,2})?$/, 3, 2)]],
        sovraFreqTempo1: [row.sovraFreqTempo1, [formatoDecimale(/^[0-9]{0,3}(?:\.[0-9]{0,2})?$/, 3, 2)]],
        sovraFreqTempo2: [row.sovraFreqTempo2, [formatoDecimale(/^[0-9]{0,3}(?:\.[0-9]{0,2})?$/, 3, 2)]],
        sovraFreqTempo3: [row.sovraFreqTempo3, [formatoDecimale(/^[0-9]{0,3}(?:\.[0-9]{0,2})?$/, 3, 2)]],
        sottoFreqSoglia1: [row.sottoFreqSoglia1, [formatoDecimale(/^[0-9]{0,3}(?:\.[0-9]{0,2})?$/, 3, 2)]],
        sottoFreqSoglia2: [row.sottoFreqSoglia2, [formatoDecimale(/^[0-9]{0,3}(?:\.[0-9]{0,2})?$/, 3, 2)]],
        sottoFreqSoglia3: [row.sottoFreqSoglia3, [formatoDecimale(/^[0-9]{0,3}(?:\.[0-9]{0,2})?$/, 3, 2)]],
        sottoFreqTempo1: [row.sottoFreqTempo1, [formatoDecimale(/^[0-9]{0,3}(?:\.[0-9]{0,2})?$/, 3, 2)]],
        sottoFreqTempo2: [row.sottoFreqTempo2, [formatoDecimale(/^[0-9]{0,3}(?:\.[0-9]{0,2})?$/, 3, 2)]],
        sottoFreqTempo3: [row.sottoFreqTempo3, [formatoDecimale(/^[0-9]{0,3}(?:\.[0-9]{0,2})?$/, 3, 2)]],
        sovraTensSoglia1: [row.sovraTensSoglia1, [formatoDecimale(/^[0-9]{0,3}(?:\.[0-9]{0,2})?$/, 3, 2)]],
        sovraTensSoglia2: [row.sovraTensSoglia2, [formatoDecimale(/^[0-9]{0,3}(?:\.[0-9]{0,2})?$/, 3, 2)]],
        sovraTensSoglia3: [row.sovraTensSoglia3, [formatoDecimale(/^[0-9]{0,3}(?:\.[0-9]{0,2})?$/, 3, 2)]],
        sovraTensTempo1: [row.sovraTensTempo1, [formatoDecimale(/^[0-9]{0,3}(?:\.[0-9]{0,2})?$/, 3, 2)]],
        sovraTensTempo2: [row.sovraTensTempo2, [formatoDecimale(/^[0-9]{0,3}(?:\.[0-9]{0,2})?$/, 3, 2)]],
        sovraTensTempo3: [row.sovraTensTempo3, [formatoDecimale(/^[0-9]{0,3}(?:\.[0-9]{0,2})?$/, 3, 2)]],
        sottoTensSoglia1: [row.sottoTensSoglia1, [formatoDecimale(/^[0-9]{0,3}(?:\.[0-9]{0,2})?$/, 3, 2)]],
        sottoTensSoglia2: [row.sottoFreqSoglia2, [formatoDecimale(/^[0-9]{0,3}(?:\.[0-9]{0,2})?$/, 3, 2)]],
        sottoTensSoglia3: [row.sottoFreqSoglia3, [formatoDecimale(/^[0-9]{0,3}(?:\.[0-9]{0,2})?$/, 3, 2)]],
        sottoTensTempo1: [row.sottoTensTempo1, [formatoDecimale(/^[0-9]{0,3}(?:\.[0-9]{0,2})?$/, 3, 2)]],
        sottoTensTempo2: [row.sottoTensTempo2, [formatoDecimale(/^[0-9]{0,3}(?:\.[0-9]{0,2})?$/, 3, 2)]],
        sottoTensTempo3: [row.sottoTensTempo3, [formatoDecimale(/^[0-9]{0,3}(?:\.[0-9]{0,2})?$/, 3, 2)]]
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
      Object.keys(this.insertForm.controls).forEach(key => {
        if (this.insertForm.controls[key].invalid) {
          console.log(key);

        }
      });
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
      datoCont.controlloModel.desTipoDocumento = tipiDocDesc.get(TipoDoc.REE_4);
      datoCont.controlloModel.fkTipoDocumento = Number(TipoDoc.REE_4);
      datoCont.controlloModel.elencoApparecchiatura = this.controlloDisponibile.tipoComponente + "-" + this.controlloDisponibile.progressivo;
      let checkList = this.insertForm.controls["checkList"].value;
      datoCont.controlloModel.fInterventoEntro = checkList.interventoEntro ? this.datePipe.transform(checkList.interventoEntro, FORMAT) : "";
      datoCont.datiCompModelList = [];
      let datoGT: DatiCGModel = new DatiCGModel();
      datoGT.progressivo = this.controlloDisponibile.progressivo;
      datoGT.dataInstall = this.controlloDisponibile.dataInstall;
      datoGT.descMarca = this.controlloDisponibile.descMarca;
      datoGT.modello = this.controlloDisponibile.modello;
      datoGT.matricola = this.controlloDisponibile.matricola;
      datoGT.tipologia = this.controlloDisponibile.descDettaglio;
      datoGT.potenzaTermicaKw = this.controlloDisponibile.potTermica ? Number(this.controlloDisponibile.potTermica) : 0;
      datoGT.descCombustibile = this.controlloDisponibile.descCombustibile;
      datoGT.cf = this.controlloDisponibile.cfPIvaImpresa;
      datoGT.siglaRea = this.controlloDisponibile.siglaReaImpresa;
      datoGT.numeroRea = this.controlloDisponibile.numeroReaImpresa;
      datoGT.coMin = this.controlloDisponibile.coMin;
      datoGT.coMax = this.controlloDisponibile.coMax;
      datoGT.alimentazione = this.controlloDisponibile.alimentazione;
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
    xml.richiesta.datiAllegato.controlloImpianto.flagLuogoIdoneo = controlloImpianto.luogoIdoneo;
    xml.richiesta.datiAllegato.controlloImpianto.flagDimensioni = controlloImpianto.dimensioni;
    xml.richiesta.datiAllegato.controlloImpianto.flagAperture = controlloImpianto.aperture;
    xml.richiesta.datiAllegato.controlloImpianto.flagLineeIdonee = controlloImpianto.lineeIdonee;
    xml.richiesta.datiAllegato.controlloImpianto.flagCanaleFumo = controlloImpianto.canaleFumo;
    xml.richiesta.datiAllegato.controlloImpianto.flagCapsulaInso = controlloImpianto.capsulaInso;
    xml.richiesta.datiAllegato.controlloImpianto.flagTenutaIdraulica = controlloImpianto.tenutaIdraulica;
    xml.richiesta.datiAllegato.controlloImpianto.flagTenutaOlio = controlloImpianto.tenutaOlio;
    xml.richiesta.datiAllegato.controlloImpianto.flagTenutaAlimentaz = controlloImpianto.tenutaAlimentaz;
    xml.richiesta.datiAllegato.controlloImpianto.flagFunzionalita = controlloImpianto.funzionalita;
    xml.richiesta.datiAllegato.checkList.flagValvole = checkList.valvole;
    xml.richiesta.datiAllegato.checkList.flagIsolamento = checkList.isolamento;
    xml.richiesta.datiAllegato.checkList.flagSistTrattACS = checkList.sistTrattAcs;
    xml.richiesta.datiAllegato.checkList.flagSistRegolaz = checkList.sistRegolaz;
    xml.richiesta.datiAllegato.checkList.osservazioni = checkList.osservazioni;
    xml.richiesta.datiAllegato.checkList.raccomandazioni = checkList.raccomandazioni;
    xml.richiesta.datiAllegato.checkList.prescrizioni = checkList.prescrizioni;
    xml.richiesta.datiAllegato.datiTecnico.flagFunzImp = checkList.funzImp;
    xml.richiesta.datiAllegato.datiTecnico.dataIntervento = checkList.dtIntervento ? this.datePipe.transform(checkList.dtIntervento, FORMAT) : "";
    let nomeCognome: string = tecnico.nomeCognome;
    let nome: string = nomeCognome && nomeCognome.split(" ")[0] ? nomeCognome.split(" ")[0] : "";
    let cognome: string = nomeCognome && nomeCognome.split(" ")[1] ? nomeCognome.split(" ")[1] : "";
    xml.richiesta.datiAllegato.datiTecnico.nomeTecnico = nome;
    xml.richiesta.datiAllegato.datiTecnico.cognomeTecnico = cognome;
    xml.richiesta.datiAllegato.datiTecnico.orarioArrivo = tecnico.orarioArrivo;
    xml.richiesta.datiAllegato.datiTecnico.orarioPartenza = tecnico.orarioPartenza;
    xml.richiesta.datiAllegato.allegato.rowAllegato.forEach((row: RowAllegato, index) => {
      row.controlloVerificaEnergetica.fluidoVett = controlloEnergetico[index].fluidoVett;
      row.controlloVerificaEnergetica.potenzaAssorbita = controlloEnergetico[index].potAssorbita;
      row.controlloVerificaEnergetica.potenzaTermByPass = controlloEnergetico[index].potTermBypass;
      row.tabFumi.rowFumi.forEach((fumi: RowFumi, index2) => {
        fumi.tempAriaCombur = controlloEnergetico[index].elencoCircuiti[index2].tempAriaCombur;
        fumi.tempAcquaUsc = controlloEnergetico[index].elencoCircuiti[index2].tempAcquaUsc;
        fumi.tempAcquaIng = controlloEnergetico[index].elencoCircuiti[index2].tempAcquaIng;
        fumi.potenzaMorsetti = controlloEnergetico[index].elencoCircuiti[index2].potenzaMorsetti;
        fumi.tempH2Omotore = controlloEnergetico[index].elencoCircuiti[index2].tempH2oMotore;
        fumi.tempFumiAvalle = controlloEnergetico[index].elencoCircuiti[index2].tempFumiAValle;
        fumi.tempFumiAmonte = controlloEnergetico[index].elencoCircuiti[index2].tempFumiAMonte;
        fumi.sovraFreqSoglia1 = controlloEnergetico[index].elencoCircuiti[index2].sovraFreqSoglia1;
        fumi.sovraFreqSoglia2 = controlloEnergetico[index].elencoCircuiti[index2].sovraFreqSoglia2;
        fumi.sovraFreqSoglia3 = controlloEnergetico[index].elencoCircuiti[index2].sovraFreqSoglia3;
        fumi.sovraFreqTempo1 = controlloEnergetico[index].elencoCircuiti[index2].sovraFreqTempo1;
        fumi.sovraFreqTempo2 = controlloEnergetico[index].elencoCircuiti[index2].sovraFreqTempo2;
        fumi.sovraFreqTempo3 = controlloEnergetico[index].elencoCircuiti[index2].sovraFreqTempo3;
        fumi.sottoFreqSoglia1 = controlloEnergetico[index].elencoCircuiti[index2].sottoFreqSoglia1;
        fumi.sottoFreqSoglia2 = controlloEnergetico[index].elencoCircuiti[index2].sottoFreqSoglia2;
        fumi.sottoFreqSoglia3 = controlloEnergetico[index].elencoCircuiti[index2].sottoFreqSoglia3;
        fumi.sottoFreqTempo1 = controlloEnergetico[index].elencoCircuiti[index2].sottoFreqTempo1;
        fumi.sottoFreqTempo2 = controlloEnergetico[index].elencoCircuiti[index2].sottoFreqTempo2;
        fumi.sottoFreqTempo3 = controlloEnergetico[index].elencoCircuiti[index2].sottoFreqTempo3;
        fumi.sovraTensSoglia1 = controlloEnergetico[index].elencoCircuiti[index2].sovraTensSoglia1;
        fumi.sovraTensSoglia2 = controlloEnergetico[index].elencoCircuiti[index2].sovraTensSoglia2;
        fumi.sovraTensSoglia3 = controlloEnergetico[index].elencoCircuiti[index2].sovraTensSoglia3;
        fumi.sovraTensTempo1 = controlloEnergetico[index].elencoCircuiti[index2].sovraTensTempo1;
        fumi.sovraTensTempo2 = controlloEnergetico[index].elencoCircuiti[index2].sovraTensTempo2;
        fumi.sovraTensTempo3 = controlloEnergetico[index].elencoCircuiti[index2].sovraTensTempo3;
        fumi.sottoTensSoglia1 = controlloEnergetico[index].elencoCircuiti[index2].sottoTensSoglia1;
        fumi.sottoTensSoglia2 = controlloEnergetico[index].elencoCircuiti[index2].sottoTensSoglia2;
        fumi.sottoTensSoglia3 = controlloEnergetico[index].elencoCircuiti[index2].sottoTensSoglia3;
        fumi.sottoTensTempo1 = controlloEnergetico[index].elencoCircuiti[index2].sottoTensTempo1;
        fumi.sottoTensTempo2 = controlloEnergetico[index].elencoCircuiti[index2].sottoTensTempo2;
        fumi.sottoTensTempo3 = controlloEnergetico[index].elencoCircuiti[index2].sottoTensTempo3;
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
    mod.richiesta.datiAllegato.controlloImpianto.flagLuogoIdoneo = controlloImpianto.luogoIdoneo;
    mod.richiesta.datiAllegato.controlloImpianto.flagDimensioni = controlloImpianto.dimensioni;
    mod.richiesta.datiAllegato.controlloImpianto.flagAperture = controlloImpianto.aperture;
    mod.richiesta.datiAllegato.controlloImpianto.flagLineeIdonee = controlloImpianto.lineeIdonee;
    mod.richiesta.datiAllegato.controlloImpianto.flagCanaleFumo = controlloImpianto.canaleFumo;
    mod.richiesta.datiAllegato.controlloImpianto.flagCapsulaInso = controlloImpianto.capsulaInso;
    mod.richiesta.datiAllegato.controlloImpianto.flagTenutaIdraulica = controlloImpianto.tenutaIdraulica;
    mod.richiesta.datiAllegato.controlloImpianto.flagTenutaOlio = controlloImpianto.tenutaOlio;
    mod.richiesta.datiAllegato.controlloImpianto.flagTenutaAlimentaz = controlloImpianto.tenutaAlimentaz;
    mod.richiesta.datiAllegato.controlloImpianto.flagFunzionalita = controlloImpianto.funzionalita;
    mod.richiesta.datiAllegato.checkList = new CheckList();
    mod.richiesta.datiAllegato.checkList.flagValvole = checkList.valvole;
    mod.richiesta.datiAllegato.checkList.flagIsolamento = checkList.isolamento;
    mod.richiesta.datiAllegato.checkList.flagSistTrattACS = checkList.sistTrattAcs;
    mod.richiesta.datiAllegato.checkList.flagSistRegolaz = checkList.sistRegolaz;
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
      row.controlloVerificaEnergetica.fluidoVett = elem.fluidoVett;
      row.controlloVerificaEnergetica.potenzaAssorbita = elem.potAssorbita;
      row.controlloVerificaEnergetica.potenzaTermByPass = elem.potTermBypass;
      row.tabFumi = new TabFumi();
      row.tabFumi.rowFumi = [];
      elem.elencoCircuiti.forEach((elem2, index2) => {
        let fumi = new RowFumi();
        fumi.tempAriaCombur = elem2.tempAriaCombur;
        fumi.tempAcquaUsc = elem2.tempAcquaUsc;
        fumi.tempAcquaIng = elem2.tempAcquaIng;
        fumi.potenzaMorsetti = elem2.potenzaMorsetti;
        fumi.tempH2Omotore = elem2.tempH2oMotore;
        fumi.tempFumiAvalle = elem2.tempFumiAValle;
        fumi.tempFumiAmonte = elem2.tempFumiAMonte;
        fumi.sovraFreqSoglia1 = elem2.sovraFreqSoglia1;
        fumi.sovraFreqSoglia2 = elem2.sovraFreqSoglia2;
        fumi.sovraFreqSoglia3 = elem2.sovraFreqSoglia3;
        fumi.sovraFreqTempo1 = elem2.sovraFreqTempo1;
        fumi.sovraFreqTempo2 = elem2.sovraFreqTempo2;
        fumi.sovraFreqTempo3 = elem2.sovraFreqTempo3;
        fumi.sottoFreqSoglia1 = elem2.sottoFreqSoglia1;
        fumi.sottoFreqSoglia2 = elem2.sottoFreqSoglia2;
        fumi.sottoFreqSoglia3 = elem2.sottoFreqSoglia3;
        fumi.sottoFreqTempo1 = elem2.sottoFreqTempo1;
        fumi.sottoFreqTempo2 = elem2.sottoFreqTempo2;
        fumi.sottoFreqTempo3 = elem2.sottoFreqTempo3;
        fumi.sovraTensSoglia1 = elem2.sovraTensSoglia1;
        fumi.sovraTensSoglia2 = elem2.sovraTensSoglia2;
        fumi.sovraTensSoglia3 = elem2.sovraTensSoglia3;
        fumi.sovraTensTempo1 = elem2.sovraTensTempo1;
        fumi.sovraTensTempo2 = elem2.sovraTensTempo2;
        fumi.sovraTensTempo3 = elem2.sovraTensTempo3;
        fumi.sottoTensSoglia1 = elem2.sottoTensSoglia1;
        fumi.sottoTensSoglia2 = elem2.sottoTensSoglia2;
        fumi.sottoTensSoglia3 = elem2.sottoTensSoglia3;
        fumi.sottoTensTempo1 = elem2.sottoTensTempo1;
        fumi.sottoTensTempo2 = elem2.sottoTensTempo2;
        fumi.sottoTensTempo3 = elem2.sottoTensTempo3;
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
    datoCont.controlloModel.desTipoDocumento = tipiDocDesc.get(TipoDoc.REE_4);
    datoCont.controlloModel.fkTipoDocumento = Number(TipoDoc.REE_4);
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
