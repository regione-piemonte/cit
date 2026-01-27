import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import moment from 'moment';
import { combineLatest, of } from 'rxjs';
import { map, switchMap } from 'rxjs/operators';
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
import { RapprovaPendingOp, RapprovaPendingOpService } from '../../services/rapprova-pending-op.service';
import { RapprovaService } from '../../services/rapprova.service';
import { datiPrecompilatiToCatasto, datiPrecompilatiToResponsabile, datiRapProvaWebGtToSingoloTipo, datiSchedaIdentificativaImpToCategoriaEdificio, datiSchedaIdentificativaImpToUsoImpianto, datiSchedaTrattH2OToInProduzioneDiAcs, datiSchedaTrattH2OToInRiscaldamento, forceArray, gtToTipologiaGruppoTermico, IMPIANTO_NON_CONFORME_DLGS_102_2014_MESSAGE, IMPIANTO_NON_CONFORME_DLGS_102_2014_TITLE, moduloToPercentualeDi } from '../../utils/rapprova-utils';

@Component({
  selector: 'app-rapprova-edit-gt',
  templateUrl: './rapprova-edit-gt.component.html',
  styleUrls: ['./rapprova-edit-gt.component.scss']
})
export class RapprovaEditGtComponent implements OnInit {
  loading = true;
  idAllegato: string;
  idIspezione2018: number;
  ispezione : IspezioneDetail;
  impiantoInfoBox: ImpiantoInfoBox;
  tipoClassificazioneDpr66096List: CodiceDescrizione[];
  frequenzaManutList: CodiceDescrizione[];
  rapprovaForm: FormGroup;
  gt: any;
  siglaReeList: string[];
  climaNonRichiestoRequired: boolean;
  acsNonRichiestoRequired: boolean;

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
      this.idAllegato = paramMap.get('idAllegato');

      combineLatest([
        this.idAllegato.startsWith('L')
          ? of(this.rapprovaLocaleService.getRapprovaLocale(this.idAllegato.substring(1)))
          : this.rapprovaService.getRapprovaDetail(Number(this.idAllegato), 8),
        this.ispezioneService.getIspezioneDetail(this.idIspezione2018).pipe(
          switchMap(ispezione =>
            this.rapprovaService.getLibretto(ispezione.codiceImpianto).pipe(
              map(libretto => ([ispezione, libretto] as any))
            )
          )
        ),
        this.rapprovaService.getCategoriaList(),
        this.rapprovaService.getTipoClassificazioneDpr66096List(),
        this.rapprovaService.getFrequenzaManutList(),
        this.verificaService.getSiglaReeList(),
      ])
      .subscribe(([rapprova, [ispezione, libretto], categoriaList, tipoClassificazioneDpr66096List, frequenzaManutList, siglaReeList]) => {
        const richiesta = libretto.MOD.Richiesta;
        const gt = forceArray(richiesta.datiSchedaGT.sezGruppiTermici.rowGT)
          .find(g => g.L4_1numGT === rapprova.datiRapProvaWebGt.progressivo);
        const brList = richiesta.datiSchedaBR
          ? forceArray(richiesta.datiSchedaBR.sezBR.rowBR).filter(b => b.L4_2numGT === gt.L4_1numGT && (!b.L4_2dataDismiss || b.L4_2dataDismiss > Date.now()))
          : [];

        const datiPrecompilati = richiesta.datiPrecompilati;
        const catasto = datiPrecompilatiToCatasto(datiPrecompilati);
        const datiSchedaIdentificativaImp = richiesta.datiSchedaIdentificativaImp;
        const datiSchedaTrattH2O = richiesta.datiSchedaTrattH2O;
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

        if (datiSchedaTrattH2O == undefined) {
          this.climaNonRichiestoRequired = true;
          this.acsNonRichiestoRequired = true;
        }
        else{
          this.climaNonRichiestoRequired = !datiSchedaTrattH2O.L2_3flagAssenteH2Oclima && !datiSchedaTrattH2O.L2_3flagFiltrazione && !datiSchedaTrattH2O.L2_3flagAddolcimento && !datiSchedaTrattH2O.L2_3flagCondizChimico;
          this.acsNonRichiestoRequired = !datiSchedaTrattH2O.L2_4flagAssente && !datiSchedaTrattH2O.L2_4flagFiltrazione && !datiSchedaTrattH2O.L2_4flagAddolcimento && !datiSchedaTrattH2O.L2_4flagCondizChimico;
        }
        const moduliConfig = rapprova.datiRapProvaWebGt.moduli
          .map((modulo) => this.fb.group({
            primaMisura: [modulo.s8bFumoMis1],
            secondaMisura: [modulo.s8bFumoMis2],
            terzaMisura: [modulo.s8bFumoMis3],
            marca: [modulo.s8cMarcaStrumMisura, Validators.required],
            modello: [modulo.s8cModelloStrumMisura, Validators.required],
            matricola: [modulo.s8cMatricolaStrumMisura, Validators.required],
            temperaturaFluidoMandata: [modulo.s8dTempFluidoMandataC, Validators.required],
            temperaturaAriaComburente: [modulo.s8dTempAriaC, Validators.required],
            temperaturaFumi: [modulo.s8dTempFumiC, Validators.required],
            percentualeDi: [moduloToPercentualeDi(modulo), Validators.required],
            valorePercentuale: [modulo.s8dO2Perc ?? modulo.s8dCo2Perc, Validators.required],
            coFumiSecchi: [modulo.s8dCoFumiSecchiPpm, Validators.required],
            noValoreOssigenoMisurato: [modulo.s8dNoMgKwH, Validators.required],
            indiceAria: [modulo.s8eIndiceAria, Validators.required],
            coFumiSecchiESenzAria: [modulo.s8eFumiSecchiNoAriaPpm, Validators.required],
            potenzaTermicaPersaAlCaminoQs: [modulo.s8eQsPerc, Validators.required],
            recuperoCaloreCondensazioneEt: [modulo.s8eEtPerc, Validators.required],
            rendimentoCombustione: [modulo.s8eRendCombPerc, Validators.required],
            noxAl3PercOssigeno: [modulo.s8eNoxMgKwH, Validators.required],
            monossidoCarbonioFumiSecchiESenzAria: [{ value: modulo.s9aFlgMonossidoCarb, disabled: true }],
            indiceFumosita: [modulo.s9bFlgFumosita, Validators.required],
            rendimentoMinimoRichiesto: [modulo.s9cRendMinCombustPerc, Validators.required],
            senzaNome: [modulo.s9cFlgRendCombustSuff],
            deveEssereMinoreMgKwh: [modulo.s9dOssidiAzotoLimMgKwH, Validators.required],
            senzaNome2: [modulo.s9dFlgOssidiAzoto],
            rispettaNormativa: [Boolean(modulo.s9eFlgRispettoNormativa)],
            nonRispettaNormativaPunto7a: [Boolean(modulo.s9eFlgNoRispetto7a)],
            nonRispettaNormativaPunto7b: [Boolean(modulo.s9eFlgNoRispetto7b)],
            nonRispettaNormativaPunto9a: [Boolean(modulo.s9eFlgNoRispetto9a)],
            nonRispettaNormativaPunto9b: [Boolean(modulo.s9eFlgNoRispetto9b)],
            nonRispettaNormativaPunto9c: [Boolean(modulo.s9eFlgNoRispetto9c)],
            nonRispettaNormativaPunto9d: [Boolean(modulo.s9eFlgNoRispetto9d)],
          }))
          .reduce((a, c, i) => ({ ...a, ['_' + i]: c}), {});

        this.rapprovaForm = this.fb.group({
          codiceImpianto: [{ value: rapprova.datiRapProva.codiceImpianto, disabled: true }],
          ispezione: this.fb.group({
            data: [{ value: moment(rapprova.datiRapProva.dataControllo), disabled: true }],
            ora: [{ value: rapprova.datiRapProva.fOraArrivo, disabled: true }],
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
            inviato: [rapprova.datiRapProvaWebGt.s1cFlgReeInviato, Validators.required],
            bollino: [rapprova.datiRapProvaWebGt.s1cFlgReeBollino, Validators.required],
            bollinoVerdeSigla: [rapprova.datiRapProvaWebGt.s1cSiglaBollino],
            bollinoVerdeNumero: [rapprova.datiRapProvaWebGt.s1cNumBollino],
            dataBollino: [rapprova.datiRapProvaWebGt.s1cDataRee ? moment(rapprova.datiRapProvaWebGt.s1cDataRee) : null]
          }),
          dataPrimaInstallazione: [rapprova.datiRapProvaWebGt.s1eDtPrimaInstallazione ? moment(rapprova.datiRapProvaWebGt.s1eDtPrimaInstallazione) : null],
          potenzaTermicaNominaleTotaleFocolare: [rapprova.datiRapProvaWebGt.s1ePotFocolareKw, Validators.required],
          potenzaTermicaNominaleTotaleUtile: [rapprova.datiRapProvaWebGt.s1ePotUtileKw, Validators.required],
          delegato: this.fb.group({
            cognomeNome: [rapprova.datiRapProvaWebGt.s1lDenomDelegato],
            delegaPresente: [rapprova.datiRapProvaWebGt.s1lFlgDelega]
          }),
          sonoPresentiSistemi: [rapprova.datiRapProvaWebGt.s2b1FlgTermoContab, Validators.required],
          applicataUni10200: [rapprova.datiRapProvaWebGt.s2b2FlgUni10200, Validators.required],
          trattamentoAcqua: this.fb.group({
            inRiscaldamento: [{value: datiSchedaTrattH2OToInRiscaldamento(datiSchedaTrattH2O), disabled: true}],
            climaNonRichiesto: [rapprova.datiRapProvaWebGt.s2fFlgTrattClimaNonRich, this.climaNonRichiestoRequired ? Validators.required : null],
            inProduzioneDiAcs: [{value: datiSchedaTrattH2OToInProduzioneDiAcs(datiSchedaTrattH2O), disabled: true}],
            acsNonRichiesto: [rapprova.datiRapProvaWebGt.s2fFlgTrattAcsNonRich, this.acsNonRichiestoRequired ? Validators.required : null],
          }),
          controlloImpianto: this.fb.group({
            check_3_a: [rapprova.datiRapProvaWebGt.s3aFlgLocaleIntIdoneo, Validators.required],
            check_3_b: [rapprova.datiRapProvaWebGt.s3bFlgGenExtIdoneo, Validators.required],
            check_3_c: [rapprova.datiRapProvaWebGt.s3cFlgVentilazSuff, Validators.required],
            check_3_d: [rapprova.datiRapProvaWebGt.s3dFlgEvacFumiIdoneo, Validators.required],
            check_3_e: [rapprova.datiRapProvaWebGt.s3eFlgCartelliPresenti, Validators.required],
            check_3_f: [rapprova.datiRapProvaWebGt.s3fFlgEstinzPresenti, Validators.required],
            check_3_g: [rapprova.datiRapProvaWebGt.s3gFlgInterrGenPresenti, Validators.required],
            check_3_h: [rapprova.datiRapProvaWebGt.s3hFlgRubinPresente, Validators.required],
            check_3_i: [rapprova.datiRapProvaWebGt.s3iFlgAssenzaPerdComb, Validators.required],
            check_3_j: [rapprova.datiRapProvaWebGt.s3jFlgTempAmbFunz, Validators.required],
            check_3_k: [rapprova.datiRapProvaWebGt.s3kFlgDm1121975, Validators.required],
          }),
          statoDocumentazione: this.fb.group({
            check_4_a: [rapprova.datiRapProvaWebGt.s4aFlgLibImpPresente, Validators.required],
            check_4_b: [rapprova.datiRapProvaWebGt.s4bFlgLibCompilato, Validators.required],
            check_4_c: [rapprova.datiRapProvaWebGt.s4cFlgConformitaPresente, Validators.required],
            check_4_d: [rapprova.datiRapProvaWebGt.s4dFlgLibUsoPresente, Validators.required],
            check_4_e: [rapprova.datiRapProvaWebGt.s4eFlgPraticaVvfPresente, Validators.required],
            check_4_f: [rapprova.datiRapProvaWebGt.s4fFlgPraticaInailPresente, Validators.required],
            check_4_g: [rapprova.datiRapProvaWebGt.s4gFlgDm121975, Validators.required],
            numero_4_g: [rapprova.datiRapProvaWebGt.s4gMatricolaDm1121975, [Validators.min(0), Validators.max(9999999999)]],
          }),
          interventiMiglioramento: this.fb.group({
            check_5_a_1: [Boolean(rapprova.datiRapProvaWebGt.s5aFlgAdozioneValvoleTerm)],
            check_5_a_2: [Boolean(rapprova.datiRapProvaWebGt.s5aFlgIsolamenteRete)],
            check_5_a_3: [Boolean(rapprova.datiRapProvaWebGt.s5aFlgAdozSistTrattamH2o)],
            check_5_a_4: [Boolean(rapprova.datiRapProvaWebGt.s5aFlgSostituzSistRegolaz)],
            check_5_b_1: [Boolean(rapprova.datiRapProvaWebGt.s5bFlgNoIntervConv)],
            check_5_b_2: [Boolean(rapprova.datiRapProvaWebGt.s5bFlgRelazDettaglio)],
            check_5_b_3: [Boolean(rapprova.datiRapProvaWebGt.s5bFlgRelazDettaglioSucc)],
            check_5_b_4: [Boolean(rapprova.datiRapProvaWebGt.s5bFlgValutazNonEseguita)],
            motivo_5_b_4:[rapprova.datiRapProvaWebGt.s5bMotivoRelazNonEseg],
            check_5_c_1: [Boolean(rapprova.datiRapProvaWebGt.s5cFlgDimensCorretto)],
            check_5_c_2: [Boolean(rapprova.datiRapProvaWebGt.s5cFlgDimensNonCorretto)],
            check_5_c_3: [Boolean(rapprova.datiRapProvaWebGt.s5cFlgDimensNonControll)],
            check_5_c_4: [Boolean(rapprova.datiRapProvaWebGt.s5cFlgDimensRelazSucces)],
          }),
          generatore: this.fb.group({
            generatore: [{value: `GT-${gt.L4_1numGT}`, disabled: true}],
            tipoCombustibile: [{value: combustibile?.descrizione, disabled: true}],
            dataInstallazione: [{value: moment(gt.L4_1dataInstallaz), disabled: true}],
            fluido: [{value: fluido?.descrizione, disabled: true}],
            modalitaEvacuazioneFumi: [rapprova.datiRapProvaWebGt.s6dFlgEvacuFumi, Validators.required],
            costruttoreCaldaia: [{value: fabbricante?.descrizione, disabled: true}],
            modelloMatricolaCaldaia: [{value: `${gt.L4_1modello} ${gt.L4_1matricola}`, disabled: true}],
            costruttoreBruciatore: [{value: fabbricanteBr, disabled: true}],
            modelloMatricolaBruciatore: [{value: modelloMatricolaBr, disabled: true}],
            tipologiaGruppoTermico: [{value: gtToTipologiaGruppoTermico(gt), disabled: true}],
            singoloTipo: [datiRapProvaWebGtToSingoloTipo(rapprova.datiRapProvaWebGt), gt.L4_1GTsingolo ? Validators.required : null],
            classificazioneDpr66096: [rapprova.datiRapProvaWebGt.s6jFkClassDpr66096],
            k: this.fb.group({
              potenzaTermicaFocolare: [rapprova.datiRapProvaWebGt.s6kPotTermFocolKw, Validators.required],
              potenzaTermicaUtile: [{value: gt.L4_1potTermUtileMax, disabled: true}],
              da: [rapprova.datiRapProvaWebGt.s6kBruciatoreDaKw],
              a: [rapprova.datiRapProvaWebGt.s6kBruciatoreAKw],
            }),
            l: this.fb.group({
              portataCombustibileM3H: [rapprova.datiRapProvaWebGt.s6lPortataCombM3H],
              portataCombustibileKgH: [rapprova.datiRapProvaWebGt.s6lPortataCombKgH],
              potenzaTermicaFocolare: [rapprova.datiRapProvaWebGt.s6lPotTermFocolKw],
            })
          }),
          manutenzioneAnalisi: this.fb.group({
            frequenza: [rapprova.datiRapProvaWebGt.s7aFkFrequenzaManut?.toString(), Validators.required],
            frequenzaManutAltro: [rapprova.datiRapProvaWebGt.s7aFrequenzaManutAltro],
            ultimaManutenzione: [rapprova.datiRapProvaWebGt.s7aFlgManutEffettuata, Validators.required],
            ultimaManutenzioneInData: [rapprova.datiRapProvaWebGt.s7aDataUltimaManut ? moment(rapprova.datiRapProvaWebGt.s7aDataUltimaManut) : null],
            presente: [rapprova.datiRapProvaWebGt.s7bFlgReePresente, Validators.required],
            presenteInData: [rapprova.datiRapProvaWebGt.s7bDataRee ? moment(rapprova.datiRapProvaWebGt.s7bDataRee) : null],
            osservazioni: [Boolean(rapprova.datiRapProvaWebGt.s7bFlgOsservazioni)],
            raccomandazioni: [Boolean(rapprova.datiRapProvaWebGt.s7bFlgRaccomand)],
            prescrizioni: [Boolean(rapprova.datiRapProvaWebGt.s7bFlgPrescr)],
          }),
          moduli: this.fb.group(moduliConfig),
          osservazioni: this.fb.group({
            osservazioni: [rapprova.datiRapProvaWebGt.fOsservazioni]
          }),
          prescrizioni: this.fb.group({
            prescrizioni: [rapprova.datiRapProvaWebGt.fPrescrizioni]
          }),
          dichiarazioniResponsabile: this.fb.group({
            raccomandazioni: [rapprova.datiRapProvaWebGt.fRaccomandazioni]
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
        idAllegato: !this.idAllegato.startsWith('L') ? Number(this.idAllegato) : undefined,
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
    const rapprovaLocale = {
      ...this.buildSaveRapprovaWeb(),
      idIspezione2018: this.idIspezione2018,
      localId: this.idAllegato.startsWith('L') ? this.idAllegato.substring(1) : undefined
    };
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
                if (this.idAllegato.startsWith('L')) {
                  this.rapprovaLocaleService.deleteRapprovaLocale(this.idAllegato.substring(1));
                }

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
          let pendingOp: RapprovaPendingOp;

          if (this.idAllegato.startsWith('L')) {
            const rapprovaLocale = this.buildAndSaveRapprovaLocale();
            pendingOp = { op: 'SALVA_INVIA', idAllegato: this.idAllegato.substring(1), idIspezione2018: this.idIspezione2018, dataRapportoDiProva: rapprovaLocale.datiRapProva.dataControllo };
          } else {
            const saveRapprovaWeb = this.buildSaveRapprovaWeb();
            pendingOp = { op: 'SALVA_INVIA', idAllegato: Number(this.idAllegato), idIspezione2018: this.idIspezione2018, dataRapportoDiProva: saveRapprovaWeb.datiRapProva.dataControllo, saveRapprovaWeb };
          }

          this.rapprovaPendingOpService.add(pendingOp);
          this.router.navigate(['/']);
        }
      }
    });
  }
}
