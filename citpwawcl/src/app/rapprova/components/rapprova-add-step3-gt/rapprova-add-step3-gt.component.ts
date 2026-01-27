import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import moment from 'moment';
import { combineLatest } from 'rxjs';
import { datiPrecompilatiToInfoBox, ImpiantoInfoBox } from 'src/app/common/components/impianto-info-box/impianto-info-box.component';
import { IspezioneDetail } from 'src/app/ispezione/models/ispezione-detail.model';
import { IspezioneService } from 'src/app/ispezione/services/ispezione.service';
import { CodiceDescrizione } from 'src/app/models/codice-descrizione';
import { AlertService } from 'src/app/services/alert.service';
import { DialogService } from 'src/app/services/dialog.service';
import { LoadingService } from 'src/app/services/loading.service';
import { VerificaService } from 'src/app/verifica/services/verifica.service';
import { siglaReeCompareFn } from 'src/app/verifica/utils/verifica-utils';
import { RapprovaLocale } from '../../models/rapprova-locale.model';
import { SaveRapprovaWeb } from '../../models/save-rapprova-web.model';
import { RapprovaLocaleService } from '../../services/rapprova-locale.service';
import { RapprovaPendingOpService } from '../../services/rapprova-pending-op.service';
import { RapprovaService } from '../../services/rapprova.service';
import { datiPrecompilatiToCatasto, datiPrecompilatiToResponsabile, datiSchedaIdentificativaImpToCategoriaEdificio, datiSchedaIdentificativaImpToUsoImpianto, datiSchedaTrattH2OToInProduzioneDiAcs, datiSchedaTrattH2OToInRiscaldamento, forceArray, gtToTipologiaGruppoTermico, IMPIANTO_NON_CONFORME_DLGS_102_2014_MESSAGE, IMPIANTO_NON_CONFORME_DLGS_102_2014_TITLE } from '../../utils/rapprova-utils';

@Component({
  selector: 'app-rapprova-add-step3-gt',
  templateUrl: './rapprova-add-step3-gt.component.html',
  styleUrls: ['./rapprova-add-step3-gt.component.scss']
})
export class RapprovaAddStep3GtComponent implements OnInit {
  state = history.state;
  loading = true;
  idIspezione2018: number;
  ispezione : IspezioneDetail;
  impiantoInfoBox: ImpiantoInfoBox;
  tipoClassificazioneDpr66096List: CodiceDescrizione[];
  frequenzaManutList: CodiceDescrizione[];
  rapprovaForm: FormGroup;
  gt: any;
  siglaReeList: string[];

  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private verificaService: VerificaService,
    private rapprovaService: RapprovaService,
    private ispezioneService: IspezioneService,
    private fb: FormBuilder,
    private loadingService: LoadingService,
    private alert: AlertService,
    private dialog: DialogService,
    private rapprovaLocaleService: RapprovaLocaleService,
    private rapprovaPendingOpService: RapprovaPendingOpService
  ) {}

  ngOnInit(): void {
    this.route.paramMap.subscribe(paramMap => {
      this.idIspezione2018 = Number(paramMap.get('id'));

      if (!this.state.selectedChipNum || !this.state.filters || !this.state.codiceImpianto){
        this.router.navigate(['/', 'dettaglio-ispezione', this.idIspezione2018, 'nuovo-rapprova', 'step-1']);
        return;
      }

      combineLatest([
        this.rapprovaService.getCategoriaList(),
        this.rapprovaService.getTipoClassificazioneDpr66096List(),
        this.rapprovaService.getFrequenzaManutList(),
        this.rapprovaService.getLibretto(this.state.codiceImpianto),
        this.ispezioneService.getIspezioneDetail(this.idIspezione2018),
        this.verificaService.getSiglaReeList(),
      ])
      .subscribe(([categoriaList, tipoClassificazioneDpr66096List, frequenzaManutList, libretto, ispezione, siglaReeList]) => {
        const richiesta = libretto.MOD.Richiesta;
        const gt = forceArray(richiesta.datiSchedaGT.sezGruppiTermici.rowGT)
          .find(g => g.L4_1numGT === this.state.selectedChipNum);
        const numModuli = gt.L4_1numAnalisiFumi ?? 1;
        const brList = richiesta.datiSchedaBR
          ? forceArray(richiesta.datiSchedaBR.sezBR.rowBR).filter(b => b.L4_2numGT === gt.L4_1numGT && (!b.L4_2dataDismiss || b.L4_2dataDismiss > Date.now()))
          : [];

        const datiPrecompilati = richiesta.datiPrecompilati;
        const catasto = datiPrecompilatiToCatasto(datiPrecompilati);
        const datiSchedaIdentificativaImp = richiesta.datiSchedaIdentificativaImp;
        const datiSchedaTrattH2O = richiesta.datiSchedaTrattH2O ?? {};
        const combustibile = forceArray(datiPrecompilati.elencoCombustibile.combustibile).find(c => c.codice === gt.L4_1combustibile);
        const fluido = forceArray(datiPrecompilati.elencoFluidoTermoVett.fluidoTermoVett).find(f => f.codice === gt.L4_1fluidoTermoVett);
        const fabbricante = forceArray(datiPrecompilati.elencoFabbricante.fabbricante).find(f => f.codice === gt.L4_1fabbricante);
        const fabbricanteBr = brList.map(b => forceArray(datiPrecompilati.elencoFabbricante.fabbricante).find(f => f.codice === b.L4_2fabbricante)?.descrizione ?? '-').join(' / ');
        const modelloMatricolaBr = brList.map(b => `${b.L4_2modello} ${b.L4_2matricola}`).join(' / ');

        this.impiantoInfoBox = datiPrecompilatiToInfoBox(datiPrecompilati);
        this.tipoClassificazioneDpr66096List = tipoClassificazioneDpr66096List;
        this.frequenzaManutList = frequenzaManutList;
        this.gt = gt;
        this.siglaReeList = siglaReeList.sort(siglaReeCompareFn);
        this.ispezione = ispezione;

        const climaNonRichiestoRequired = !datiSchedaTrattH2O.L2_3flagAssenteH2Oclima && !datiSchedaTrattH2O.L2_3flagFiltrazione && !datiSchedaTrattH2O.L2_3flagAddolcimento && !datiSchedaTrattH2O.L2_3flagCondizChimico;
        const acsNonRichiestoRequired = !datiSchedaTrattH2O.L2_4flagAssente && !datiSchedaTrattH2O.L2_4flagFiltrazione && !datiSchedaTrattH2O.L2_4flagAddolcimento && !datiSchedaTrattH2O.L2_4flagCondizChimico;

        const moduliConfig = Array(numModuli)
          .fill(undefined)
          .map(() => this.fb.group({
            primaMisura: [null],
            secondaMisura: [null],
            terzaMisura: [null],
            marca: [null, Validators.required],
            modello: [null, Validators.required],
            matricola: [null, Validators.required],
            temperaturaFluidoMandata: [null, Validators.required],
            temperaturaAriaComburente: [null, Validators.required],
            temperaturaFumi: [null, Validators.required],
            percentualeDi: [null, Validators.required],
            valorePercentuale: [null, Validators.required],
            coFumiSecchi: [null, Validators.required],
            noValoreOssigenoMisurato: [null, Validators.required],
            indiceAria: [null, Validators.required],
            coFumiSecchiESenzAria: [null, Validators.required],
            potenzaTermicaPersaAlCaminoQs: [null, Validators.required],
            recuperoCaloreCondensazioneEt: [null, Validators.required],
            rendimentoCombustione: [null, Validators.required],
            noxAl3PercOssigeno: [null, Validators.required],
            monossidoCarbonioFumiSecchiESenzAria: [{ value: null, disabled: true }],
            indiceFumosita: [null, Validators.required],
            rendimentoMinimoRichiesto: [null, Validators.required],
            senzaNome: [null],
            deveEssereMinoreMgKwh: [null, Validators.required],
            senzaNome2: [null],
            rispettaNormativa: [null],
            nonRispettaNormativaPunto7a: [null],
            nonRispettaNormativaPunto7b: [null],
            nonRispettaNormativaPunto9a: [null],
            nonRispettaNormativaPunto9b: [null],
            nonRispettaNormativaPunto9c: [null],
            nonRispettaNormativaPunto9d: [null],
          }))
          .reduce((a, c, i) => ({ ...a, ['_' + i]: c}), {});

        this.rapprovaForm = this.fb.group({
          codiceImpianto: [{ value: this.state.codiceImpianto, disabled: true }],
          ispezione: this.fb.group({
            data: [{ value: moment(this.state.filters.dataRapProva), disabled: true }],
            ora: [{ value: this.state.filters.oraRapProva, disabled: true }],
            numero: [{ value: this.idIspezione2018, disabled: true }],
          }),
          ispettore: this.fb.group({
            cognomeNome: [{ value: `${ispezione.denomUtenteAssegn} (${ispezione.cfUtenteAssegn})`, disabled: true }],
            estremiQualifica: [{ value: null, disabled: true }],
            secondario: [{ value: ispezione.cfIspettoreSecondario, disabled: true }]
          }),
          ubicazione: this.fb.group({
            comune: [{ value: `${datiPrecompilati.L1_2comune} ${datiPrecompilati.L1_2prov}`, disabled: true }],
            indirizzo: [{ value: `${datiPrecompilati.L1_2indirizzo} ${datiPrecompilati.L1_2civico}`, disabled: true }],
          }),
          datiCatastali: this.fb.group({
            sezione: [{ value: catasto.sezione, disabled: true }],
            foglio: [{ value: catasto.foglio, disabled: true }],
            particella: [{ value: catasto.particella, disabled: true }],
            subalterno: [{ value: catasto.sub, disabled: true }],
            pod: [{ value: catasto.pod, disabled: true }],
            pdr: [{ value: catasto.pdr, disabled: true }],
          }),
          responsabile: [{ value: datiPrecompilatiToResponsabile(datiPrecompilati), disabled: true }],
          categoriaEdificio: [{ value: datiSchedaIdentificativaImpToCategoriaEdificio(datiSchedaIdentificativaImp, categoriaList), disabled: true }],
          unitaImmobiliariServite: [{ value: datiSchedaIdentificativaImp.L1_2flagUnitaImmSingle ? 'Unica' : 'Più unità', disabled: true }],
          usoImpianto: [{ value: datiSchedaIdentificativaImpToUsoImpianto(datiSchedaIdentificativaImp), disabled: true }],
          volumeLordoScaldato: [{ value: datiSchedaIdentificativaImp.L1_2volLordoRisc, disabled: true }],
          rapportoControlloEfficenzaEnergetica: this.fb.group({
            inviato: [null, Validators.required],
            bollino: [null, Validators.required],
            bollinoVerdeSigla: [null],
            bollinoVerdeNumero: [null],
            dataBollino: [null]
          }),
          dataPrimaInstallazione: [null],
          potenzaTermicaNominaleTotaleFocolare: [null, Validators.required],
          potenzaTermicaNominaleTotaleUtile: [null, Validators.required],
          delegato: this.fb.group({
            cognomeNome: [null],
            delegaPresente: [null]
          }),
          sonoPresentiSistemi: [null, Validators.required],
          applicataUni10200: [null, Validators.required],
          trattamentoAcqua: this.fb.group({
            inRiscaldamento: [{value: datiSchedaTrattH2OToInRiscaldamento(datiSchedaTrattH2O), disabled: true}],
            climaNonRichiesto: [null, climaNonRichiestoRequired ? Validators.required : null],
            inProduzioneDiAcs: [{value: datiSchedaTrattH2OToInProduzioneDiAcs(datiSchedaTrattH2O), disabled: true}],
            acsNonRichiesto: [null, acsNonRichiestoRequired ? Validators.required : null],
          }),
          controlloImpianto: this.fb.group({
            check_3_a: [null, Validators.required],
            check_3_b: [null, Validators.required],
            check_3_c: [null, Validators.required],
            check_3_d: [null, Validators.required],
            check_3_e: [null, Validators.required],
            check_3_f: [null, Validators.required],
            check_3_g: [null, Validators.required],
            check_3_h: [null, Validators.required],
            check_3_i: [null, Validators.required],
            check_3_j: [null, Validators.required],
            check_3_k: [null, Validators.required],
          }),
          statoDocumentazione: this.fb.group({
            check_4_a: [null, Validators.required],
            check_4_b: [null, Validators.required],
            check_4_c: [null, Validators.required],
            check_4_d: [null, Validators.required],
            check_4_e: [null, Validators.required],
            check_4_f: [null, Validators.required],
            check_4_g: [null, Validators.required],
            numero_4_g: [null, [Validators.min(0), Validators.max(9999999999)]],
          }),
          interventiMiglioramento: this.fb.group({
            check_5_a_1: [null],
            check_5_a_2: [null],
            check_5_a_3: [null],
            check_5_a_4: [null],
            check_5_b_1: [null],
            check_5_b_2: [null],
            check_5_b_3: [null],
            check_5_b_4: [null],
            motivo_5_b_4:[null],
            check_5_c_1: [null],
            check_5_c_2: [null],
            check_5_c_3: [null],
            check_5_c_4: [null],
          }),
          generatore: this.fb.group({
            generatore: [{value: `GT-${gt.L4_1numGT}`, disabled: true}],
            tipoCombustibile: [{value: combustibile?.descrizione, disabled: true}],
            dataInstallazione: [{value: moment(gt.L4_1dataInstallaz), disabled: true}],
            fluido: [{value: fluido?.descrizione, disabled: true}],
            modalitaEvacuazioneFumi: [null, Validators.required],
            costruttoreCaldaia: [{value: fabbricante?.descrizione, disabled: true}],
            modelloMatricolaCaldaia: [{value: `${gt.L4_1modello} ${gt.L4_1matricola}`, disabled: true}],
            costruttoreBruciatore: [{value: fabbricanteBr, disabled: true}],
            modelloMatricolaBruciatore: [{value: modelloMatricolaBr, disabled: true}],
            tipologiaGruppoTermico: [{value: gtToTipologiaGruppoTermico(gt), disabled: true}],
            singoloTipo: [null, gt.L4_1GTsingolo ? Validators.required : null],
            classificazioneDpr66096: [null],
            k: this.fb.group({
              potenzaTermicaFocolare: [null, Validators.required],
              potenzaTermicaUtile: [{value: gt.L4_1potTermUtileMax, disabled: true}],
              da: [null],
              a: [null],
            }),
            l: this.fb.group({
              portataCombustibileM3H: [null],
              portataCombustibileKgH: [null],
              potenzaTermicaFocolare: [null],
            })
          }),
          manutenzioneAnalisi: this.fb.group({
            frequenza: [null, Validators.required],
            frequenzaManutAltro: [null],
            ultimaManutenzione: [null, Validators.required],
            ultimaManutenzioneInData: [null],
            presente: [null, Validators.required],
            presenteInData: [null],
            osservazioni: [null],
            raccomandazioni: [null],
            prescrizioni: [null],
          }),
          moduli: this.fb.group(moduliConfig),
          osservazioni: this.fb.group({
            osservazioni: [null]
          }),
          prescrizioni: this.fb.group({
            prescrizioni: [null]
          }),
          dichiarazioniResponsabile: this.fb.group({
            raccomandazioni: [null]
          })
        });

        this.rapprovaForm.get('rapportoControlloEfficenzaEnergetica.bollino').valueChanges.subscribe(value => {
          [
            this.rapprovaForm.get('rapportoControlloEfficenzaEnergetica.bollinoVerdeSigla'),
            this.rapprovaForm.get('rapportoControlloEfficenzaEnergetica.bollinoVerdeNumero'),
            this.rapprovaForm.get('rapportoControlloEfficenzaEnergetica.dataBollino')
          ].forEach(c => c.setValidators(value ? Validators.required : null));
          this.rapprovaForm.updateValueAndValidity();
        });

        this.rapprovaForm.get('statoDocumentazione.check_4_g').valueChanges.subscribe(value => {
          this.rapprovaForm
            .get('statoDocumentazione.numero_4_g')
            .setValidators(value === 'yes' ? Validators.required : null);
            this.rapprovaForm.updateValueAndValidity();
        });

        this.rapprovaForm.get('manutenzioneAnalisi.frequenza').valueChanges.subscribe(value => {
          this.rapprovaForm
            .get('manutenzioneAnalisi.frequenzaManutAltro')
            .setValidators(value === '4' ? Validators.required : null);
            this.rapprovaForm.updateValueAndValidity();
        });

        this.rapprovaForm.get('manutenzioneAnalisi.ultimaManutenzione').valueChanges.subscribe(value => {
          this.rapprovaForm
            .get('manutenzioneAnalisi.ultimaManutenzioneInData')
            .setValidators(value ? Validators.required : null);
            this.rapprovaForm.updateValueAndValidity();
        });

        this.rapprovaForm.get('manutenzioneAnalisi.presente').valueChanges.subscribe(value => {
          this.rapprovaForm
            .get('manutenzioneAnalisi.presenteInData')
            .setValidators(value ? Validators.required : null);
            this.rapprovaForm.updateValueAndValidity();
        });

        this.getModuliKeys().forEach(key => {
          this.rapprovaForm.get(['moduli', key, 'coFumiSecchiESenzAria']).valueChanges.subscribe(value => {
            const newValue = value > 1000 ? 'I' : 'R';
            this.rapprovaForm.get(['moduli', key, 'monossidoCarbonioFumiSecchiESenzAria']).setValue(newValue);
          });
        });

        this.loading = false;
      });
    });
  }

  isRequired(path: string): boolean {
    return this.rapprovaForm.get(path).hasValidator(Validators.required);
  }

  getModuliKeys(): string[] {
    return Object.keys((this.rapprovaForm.get('moduli') as FormGroup).controls);
  }

  getValoreRilevato1(key: string): string | number {
    const value = this.rapprovaForm.get(['moduli', key, 'rendimentoCombustione']).value;
    return value ? value + 2 : '___';
  }

  getValoreRilevato2(key: string): string | number {
    const value = this.rapprovaForm.get(['moduli', key, 'noxAl3PercOssigeno']).value;
    return value ? value - 20 : '___';
  }

  private buildSaveRapprovaWeb(): SaveRapprovaWeb {
    const value = this.rapprovaForm.getRawValue();
    return {
      datiRapProva: {
        dataControllo: value.ispezione.data.valueOf(),
        codiceImpianto: value.codiceImpianto,
        fkTipoDocumento: 8,
        fOraArrivo: value.ispezione.ora,
        elencoApparecchiature: `GT-${this.gt.L4_1numGT} (${value.generatore.costruttoreCaldaia} - ${this.gt.L4_1modello})`,
        elencoCombustibili: value.generatore.tipoCombustibile,
        fkIspezIspet: this.ispezione.idIspezIspet
      },
      datiRapProvaWebGt: {
        s1cFlgReeInviato: value.rapportoControlloEfficenzaEnergetica.inviato,
        s1cFlgReeBollino: value.rapportoControlloEfficenzaEnergetica.bollino,
        s1cSiglaBollino: value.rapportoControlloEfficenzaEnergetica.bollinoVerdeSigla,
        s1cNumBollino: value.rapportoControlloEfficenzaEnergetica.bollinoVerdeNumero,
        s1eDtPrimaInstallazione: value.dataPrimaInstallazione?.valueOf(),
        s1ePotFocolareKw: value.potenzaTermicaNominaleTotaleFocolare,
        s1ePotUtileKw: value.potenzaTermicaNominaleTotaleUtile,
        s1lDenomDelegato: value.delegato.cognomeNome,
        s1lFlgDelega: value.delegato.delegaPresente,
        s2b1FlgTermoContab: value.sonoPresentiSistemi,
        s2b2FlgUni10200: value.applicataUni10200,
        s2fFlgTrattClimaNonRich: value.trattamentoAcqua.climaNonRichiesto,
        s2fFlgTrattAcsNonRich: value.trattamentoAcqua.acsNonRichiesto,
        s3aFlgLocaleIntIdoneo: value.controlloImpianto.check_3_a,
        s3bFlgGenExtIdoneo: value.controlloImpianto.check_3_b,
        s3cFlgVentilazSuff: value.controlloImpianto.check_3_c,
        s3dFlgEvacFumiIdoneo: value.controlloImpianto.check_3_d,
        s3eFlgCartelliPresenti: value.controlloImpianto.check_3_e,
        s3fFlgEstinzPresenti: value.controlloImpianto.check_3_f,
        s3gFlgInterrGenPresenti: value.controlloImpianto.check_3_g,
        s3hFlgRubinPresente: value.controlloImpianto.check_3_h,
        s3iFlgAssenzaPerdComb: value.controlloImpianto.check_3_i,
        s3jFlgTempAmbFunz: value.controlloImpianto.check_3_j,
        s3kFlgDm1121975: value.controlloImpianto.check_3_k,
        s4aFlgLibImpPresente: value.statoDocumentazione.check_4_a,
        s4bFlgLibCompilato: value.statoDocumentazione.check_4_b,
        s4cFlgConformitaPresente: value.statoDocumentazione.check_4_c,
        s4dFlgLibUsoPresente: value.statoDocumentazione.check_4_d,
        s4eFlgPraticaVvfPresente: value.statoDocumentazione.check_4_e,
        s4fFlgPraticaInailPresente: value.statoDocumentazione.check_4_f,
        s4gFlgDm121975: value.statoDocumentazione.check_4_g,
        s4gMatricolaDm1121975: value.statoDocumentazione.numero_4_g,
        s5aFlgAdozioneValvoleTerm: Number(value.interventiMiglioramento.check_5_a_1),
        s5aFlgIsolamenteRete: Number(value.interventiMiglioramento.check_5_a_2),
        s5aFlgAdozSistTrattamH2o: Number(value.interventiMiglioramento.check_5_a_3),
        s5aFlgSostituzSistRegolaz: Number(value.interventiMiglioramento.check_5_a_4),
        s5bFlgNoIntervConv: Number(value.interventiMiglioramento.check_5_b_1),
        s5bFlgRelazDettaglio: Number(value.interventiMiglioramento.check_5_b_2),
        s5bFlgRelazDettaglioSucc: Number(value.interventiMiglioramento.check_5_b_3),
        s5bFlgValutazNonEseguita: Number(value.interventiMiglioramento.check_5_b_4),
        s5bMotivoRelazNonEseg: value.interventiMiglioramento.motivo_5_b_4,
        s5cFlgDimensCorretto: Number(value.interventiMiglioramento.check_5_c_1),
        s5cFlgDimensNonControll: Number(value.interventiMiglioramento.check_5_c_3),
        s5cFlgDimensRelazSucces: Number(value.interventiMiglioramento.check_5_c_4),
        s1cDataRee: value.rapportoControlloEfficenzaEnergetica.dataBollino?.valueOf(),
        s5cFlgDimensNonCorretto: Number(value.interventiMiglioramento.check_5_c_2),
        progressivo: this.gt.L4_1numGT,
        dataInstall: moment(this.gt.L4_1dataInstallaz).valueOf(),
        s6dFlgEvacuFumi: value.generatore.modalitaEvacuazioneFumi,
        s6iFlgTipoB: Number(value.generatore.singoloTipo === 'B'),
        s6iFlgTipoC: Number(value.generatore.singoloTipo === 'C'),
        s6jFkClassDpr66096: value.generatore.classificazioneDpr66096,
        s6kPotTermFocolKw: value.generatore.k.potenzaTermicaFocolare,
        s6kBruciatoreDaKw: value.generatore.k.da,
        s6kBruciatoreAKw: value.generatore.k.a,
        s6lPortataCombM3H: value.generatore.l.portataCombustibileM3H,
        s6lPortataCombKgH: value.generatore.l.portataCombustibileKgH,
        s6lPotTermFocolKw: value.generatore.l.potenzaTermicaFocolare,
        s7aFlgManutEffettuata: value.manutenzioneAnalisi.ultimaManutenzione,
        s7aDataUltimaManut: value.manutenzioneAnalisi.ultimaManutenzioneInData?.valueOf(),
        s7bFlgReePresente: value.manutenzioneAnalisi.presente,
        s7bDataRee: value.manutenzioneAnalisi.presenteInData?.valueOf(),
        s7bFlgOsservazioni: Number(value.manutenzioneAnalisi.osservazioni),
        s7bFlgRaccomand: Number(value.manutenzioneAnalisi.raccomandazioni),
        s7bFlgPrescr: Number(value.manutenzioneAnalisi.prescrizioni),
        moduli:Object.values<any>(value.moduli).map((modulo, i) => ({
          s8aNModuloTermico: String(i + 1),
          s8bFumoMis1: modulo.primaMisura,
          s8bFumoMis2: modulo.secondaMisura,
          s8bFumoMis3: modulo.terzaMisura,
          s8cMarcaStrumMisura: modulo.marca?.toUpperCase(),
          s8cModelloStrumMisura: modulo.modello?.toUpperCase(),
          s8cMatricolaStrumMisura: modulo.matricola?.toUpperCase(),
          s8dTempFluidoMandataC: modulo.temperaturaFluidoMandata,
          s8dTempAriaC: modulo.temperaturaAriaComburente,
          s8dTempFumiC: modulo.temperaturaFumi,
          s8dO2Perc: modulo.percentualeDi === 'o2' ? modulo.valorePercentuale : undefined,
          s8dCo2Perc: modulo.percentualeDi === 'co2' ? modulo.valorePercentuale : undefined,
          s8dCoFumiSecchiPpm: modulo.coFumiSecchi,
          s8dNoMgKwH: modulo.noValoreOssigenoMisurato,
          s8eIndiceAria: modulo.indiceAria,
          s8eFumiSecchiNoAriaPpm: modulo.coFumiSecchiESenzAria,
          s8eQsPerc: modulo.potenzaTermicaPersaAlCaminoQs,
          s8eEtPerc: modulo.recuperoCaloreCondensazioneEt,
          s8eRendCombPerc: modulo.rendimentoCombustione,
          s8eNoxMgKwH: modulo.noxAl3PercOssigeno,
          s9aFlgMonossidoCarb: modulo.monossidoCarbonioFumiSecchiESenzAria,
          s9bFlgFumosita: modulo.indiceFumosita,
          s9cRendMinCombustPerc: modulo.rendimentoMinimoRichiesto,
          s9cFlgRendCombustSuff: modulo.senzaNome,
          s9dOssidiAzotoLimMgKwH: modulo.deveEssereMinoreMgKwh,
          s9dFlgOssidiAzoto: modulo.senzaNome2,
          s9eFlgRispettoNormativa: Number(modulo.rispettaNormativa),
          s9eFlgNoRispetto7a: Number(modulo.nonRispettaNormativaPunto7a),
          s9eFlgNoRispetto7b: Number(modulo.nonRispettaNormativaPunto7b),
          s9eFlgNoRispetto9a: Number(modulo.nonRispettaNormativaPunto9a),
          s9eFlgNoRispetto9b: Number(modulo.nonRispettaNormativaPunto9b),
          s9eFlgNoRispetto9c: Number(modulo.nonRispettaNormativaPunto9c),
          s9eFlgNoRispetto9d: Number(modulo.nonRispettaNormativaPunto9d)
        })),
        s7aFrequenzaManutAltro: value.manutenzioneAnalisi.frequenzaManutAltro,
        s7aFkFrequenzaManut: value.manutenzioneAnalisi.frequenza ? Number(value.manutenzioneAnalisi.frequenza) : null,
        fOsservazioni: value.osservazioni.osservazioni,
        fRaccomandazioni: value.dichiarazioniResponsabile.raccomandazioni,
        fPrescrizioni: value.prescrizioni.prescrizioni
      }
    };
  }

  private buildAndSaveRapprovaLocale(): RapprovaLocale {
    const rapprovaLocale = { ...this.buildSaveRapprovaWeb(), idIspezione2018: this.idIspezione2018 };
    return this.rapprovaLocaleService.saveRapprovaLocale(rapprovaLocale);
  }

  salvaBozzaLocale(): void {
    this.buildAndSaveRapprovaLocale();
    this.alert.success({ message: 'Rapporto di prova aggiunto localmente con successo!', title: 'Rapporto di prova aggiunto localmente' });
    this.router.navigate(navigator.onLine ? ['/', 'dettaglio-ispezione', this.idIspezione2018] : ['/']);
  }

  save(): void {
    if (!this.rapprovaForm.valid) {
      this.alert.error({ title: 'Dati rapporto di prova mancanti', message: 'Compilare tutti i campi e riprovare' });
      return;
    }

    this.dialog.confirm(
      'Invio Rapporto di Prova',
      'Dopo l\'invio non sarà più possibile apportare modifiche al Rapporto di prova selezionato. Continuare?'
    ).subscribe(result => {
      if (result) {
        if (navigator.onLine) {
          this.loadingService.on();

          const request = this.buildSaveRapprovaWeb();
          this.rapprovaService
            .saveRapprovaWeb(request)
            .subscribe({
              next: (esito) => {
                this.loadingService.off();

                this.alert.success({ message: 'Rapporto di prova aggiunto e inviato con successo!', title: 'Rapporto di prova aggiunto e inviato' });

                if (esito.impiantoNonConformeDlgs1022014) {
                  this.alert.warn({ message: IMPIANTO_NON_CONFORME_DLGS_102_2014_MESSAGE, title: IMPIANTO_NON_CONFORME_DLGS_102_2014_TITLE });
                }

                this.router.navigate(['/', 'dettaglio-ispezione', this.idIspezione2018]);
              },
              error: () => this.loadingService.off(),
            });
        } else {
          const rapprovaLocale = this.buildAndSaveRapprovaLocale();
          this.rapprovaPendingOpService.add({
            op: 'SALVA_INVIA',
            idAllegato: rapprovaLocale.localId,
            idIspezione2018: this.idIspezione2018,
            dataRapportoDiProva: rapprovaLocale.datiRapProva.dataControllo
          });
          this.router.navigate(['/']);
        }
      }
    });
  }
}
