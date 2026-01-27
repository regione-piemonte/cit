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
import { datiPrecompilatiToCatasto, datiPrecompilatiToResponsabile, datiSchedaIdentificativaImpToCategoriaEdificio, datiSchedaIdentificativaImpToUsoImpianto, datiSchedaTrattH2OToInRiscaldamento, forceArray, gfToFluidoLatoUtenze, gfToSorgenteLatoEsterno, gfToTipoMacchina, IMPIANTO_NON_CONFORME_DLGS_102_2014_MESSAGE, IMPIANTO_NON_CONFORME_DLGS_102_2014_TITLE } from '../../utils/rapprova-utils';

@Component({
  selector: 'app-rapprova-add-step3-gf',
  templateUrl: './rapprova-add-step3-gf.component.html',
  styleUrls: ['./rapprova-add-step3-gf.component.scss']
})
export class RapprovaAddStep3GfComponent implements OnInit {
  state = history.state;
  loading = true;
  idIspezione2018: number;
  ispezione : IspezioneDetail;
  impiantoInfoBox: ImpiantoInfoBox;
  frequenzaManutList: CodiceDescrizione[];
  rapprovaForm: FormGroup;
  gf: any;
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
        this.rapprovaService.getFrequenzaManutList(),
        this.rapprovaService.getLibretto(this.state.codiceImpianto),
        this.ispezioneService.getIspezioneDetail(this.idIspezione2018),
        this.verificaService.getSiglaReeList()
      ])
      .subscribe(([categoriaList, frequenzaManutList, libretto, ispezione, siglaReeList]) => {
        const richiesta = libretto.MOD.Richiesta;
        const gf = forceArray(richiesta.datiSchedaGF.sezGF.rowGF).find(g => g.L4_4numGF === this.state.selectedChipNum);

        const datiPrecompilati = richiesta.datiPrecompilati;
        const catasto = datiPrecompilatiToCatasto(datiPrecompilati);
        const datiSchedaIdentificativaImp = richiesta.datiSchedaIdentificativaImp;
        const datiSchedaTrattH2O = richiesta.datiSchedaTrattH2O ?? {};
        const fabbricante = forceArray(datiPrecompilati.elencoFabbricante.fabbricante).find(c => c.codice === gf.L4_4fabbricante);

        this.impiantoInfoBox = datiPrecompilatiToInfoBox(datiPrecompilati);
        this.frequenzaManutList = frequenzaManutList;
        this.gf = gf;
        this.siglaReeList = siglaReeList.sort(siglaReeCompareFn);
        this.ispezione = ispezione;

        const climaNonRichiestoRequired = !datiSchedaTrattH2O.L2_3flagAssenteH2Oclima && !datiSchedaTrattH2O.L2_3flagFiltrazione && !datiSchedaTrattH2O.L2_3flagAddolcimento && !datiSchedaTrattH2O.L2_3flagCondizChimico;

        const circuitiConfig = Array(gf.L4_4numCircuiti)
          .fill(undefined)
          .map(() => this.fb.group({
            raffrescamento: [null],
            riscaldamento: [null],
            filtriPuliti: [null, Validators.required],
            assenzaPerditeGasRefrigerante: [null, Validators.required],
            marca: [null],
            modello: [null],
            matricola: [null],
            potenzaAssorbita: [null],
            strumentazioneFissa: [null],
            surriscaldamento: [null],
            sottoraffreddamento: [null],
            temperaturaCondensazione: [null],
            temperaturaEvaporazione: [null],
            temperaturaSorgenteIngressoLatoEsterno: [null],
            temperaturaSorgenteUscitaLatoEsterno: [null],
            temperaturaIngressoFluidoUtenze: [null],
            temperaturaUscitaFluidoUtenze: [null],
            verificaSuperata: [null],
            rispettaNormativa: [null],
            nonRispettaNormativaPunto7a: [null],
            nonRispettaNormativaPunto7c: [null],
            nonRispettaNormativaPunto8d: [null],
            nonRispettaNormativaPunto9a: [null],
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
          potenzaTermicaNominaleTotaleMassima: [null, Validators.required],
          delegato: this.fb.group({
            cognomeNome: [null],
            delegaPresente: [null]
          }),
          trattamentoAcqua: this.fb.group({
            inRiscaldamento: [{value: datiSchedaTrattH2OToInRiscaldamento(datiSchedaTrattH2O), disabled: true}],
            climaNonRichiesto: [null, climaNonRichiestoRequired ? Validators.required : null],
          }),
          controlloImpianto: this.fb.group({
            check_3_a: [null, Validators.required],
            check_3_b: [null, Validators.required],
            check_3_c: [null, Validators.required],
            check_3_d: [null, Validators.required],
          }),
          statoDocumentazione: this.fb.group({
            check_4_a: [null, Validators.required],
            check_4_b: [null, Validators.required],
            check_4_c: [null, Validators.required],
            check_4_d: [null, Validators.required],
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
          gruppoFrigoPdc: this.fb.group({
            gruppoFrigoPdc: [{value: `GF-${gf.L4_4numGF}`, disabled: true}],
            circuitiNum: [{value: gf.L4_4numCircuiti, disabled: true}],
            dataInstallazione: [{value: moment(gf.L4_4dataInstallaz), disabled: true}],
            costruttore: [{value: fabbricante?.descrizione, disabled: true}],
            modello: [{value: gf.L4_4modello, disabled: true}],
            matricola: [{value: gf.L4_4matricola, disabled: true}],
            fluidoFrigorigeno: [{value: gf.L4_4fluidoFrigo, disabled: true}],
            macchinaDotataDiInverter: [null],
            sorgenteLatoEsterno: [{value: gfToSorgenteLatoEsterno(gf), disabled: true}],
            fluidoLatoUtenze: [{value: gfToFluidoLatoUtenze(gf), disabled: true}],
            k: this.fb.group({
              cop: [{value: gf.L4_4riscaldam, disabled: true}],
              potenzaTermicaNominale: [{value: gf.L4_4potTermNom, disabled: true}],
              potenzaAssorbitaNominale: [{value: gf.L4_4potTermAssorb, disabled: true}],
            }),
            l: this.fb.group({
              eer: [{value: gf.L4_4raffrescam, disabled: true}],
              potenzaFrigoriferaNominale: [{value: gf.L4_4potFrigoNom, disabled: true}],
              potenzaAssorbitaNominale: [{value: gf.L4_4potFrigoAssorb, disabled: true}],
            }),
            tipoMacchina: [{value: gfToTipoMacchina(gf), disabled: true}],
            diretta: [null],
            indiretta: [null],
          }),
          manutenzioneAnalisi: this.fb.group({
            frequenza: [null, Validators.required],
            frequenzaManutAltro: [null],
            ultimaManutenzione: [null, Validators.required],
            ultimaManutenzioneInData: [null],
            registroApparecchiatura: [null],
            presente: [null, Validators.required],
            presenteInData: [null],
            osservazioni: [null],
            raccomandazioni: [null],
            prescrizioni: [null],
          }),
          circuiti: this.fb.group(circuitiConfig),
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
          this.rapprovaForm.get('rapportoControlloEfficenzaEnergetica.bollinoVerdeSigla').setValidators(value ? Validators.required : null);
          this.rapprovaForm.get('rapportoControlloEfficenzaEnergetica.bollinoVerdeNumero').setValidators(value ? Validators.required : null);
          this.rapprovaForm.get('rapportoControlloEfficenzaEnergetica.dataBollino').setValidators(value ? Validators.required : null);
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

        this.loading = false;
      });
    });
  }

  isRequired(path: string): boolean {
    return this.rapprovaForm.get(path).hasValidator(Validators.required);
  }

  getCircuitiKeys(): string[] {
    return Object.keys((this.rapprovaForm.get('circuiti') as FormGroup).controls);
  }

  private buildSaveRapprovaWeb(): SaveRapprovaWeb {
    const value = this.rapprovaForm.getRawValue();
    return {
      datiRapProva: {
        dataControllo: value.ispezione.data.valueOf(),
        codiceImpianto: value.codiceImpianto,
        fkTipoDocumento: 9,
        fOraArrivo: value.ispezione.ora,
        elencoApparecchiature: `GF-${this.gf.L4_4numGF} (${value.gruppoFrigoPdc.costruttore} - ${this.gf.L4_4modello})`,
        elencoCombustibili: null,
        fkIspezIspet: this.ispezione.idIspezIspet
      },
      datiRapProvaWebGf: {
        s1cFlgReeInviato: value.rapportoControlloEfficenzaEnergetica.inviato,
        s1cDataRee: value.rapportoControlloEfficenzaEnergetica.dataBollino?.valueOf(),
        s1cFlgReeBollino: value.rapportoControlloEfficenzaEnergetica.bollino,
        s1cFlgSiglaBollino: null,
        s1cNumBollino: value.rapportoControlloEfficenzaEnergetica.bollinoVerdeNumero,
        s1cSiglaBollino: value.rapportoControlloEfficenzaEnergetica.bollinoVerdeSigla,
        s1cSiglaBollino2: null,
        s1cSiglaBollino3: null,
        s1eDtPrimaInstallazione: value.dataPrimaInstallazione?.valueOf(),
        s1ePotTermicaMaxKw: value.potenzaTermicaNominaleTotaleMassima,
        s1lDenomDelegato: value.delegato.cognomeNome,
        s1lFlgDelega: value.delegato.delegaPresente,
        s2eFlgTrattH2oNonRich: value.trattamentoAcqua.climaNonRichiesto,
        s3aFlgLocaleIntIdoneo: value.controlloImpianto.check_3_a,
        s3bFlgLineeElettrIdonee: value.controlloImpianto.check_3_b,
        s3cFlgVentilazAdeguate: value.controlloImpianto.check_3_c,
        s3dFlgCoibentazioniIdonee: value.controlloImpianto.check_3_d,
        s4aFlgLibImpPresente: value.statoDocumentazione.check_4_a,
        s4bFlgLibCompilato: value.statoDocumentazione.check_4_b,
        s4cFlgConformitaPresente: value.statoDocumentazione.check_4_c,
        s4dFlgLibUsoPresente: value.statoDocumentazione.check_4_d,
        s5aFlgIsolamCanaliDistrib: Number(value.interventiMiglioramento.check_5_a_4),
        s5aFlgIsolamReteDistrib: Number(value.interventiMiglioramento.check_5_a_3),
        s5aFlgSostituzMacchineReg: Number(value.interventiMiglioramento.check_5_a_1),
        s5aFlgSostituzSistemiReg: Number(value.interventiMiglioramento.check_5_a_2),
        s5bFlgNoIntervConv: Number(value.interventiMiglioramento.check_5_b_1),
        s5bFlgRelazDettaglio: Number(value.interventiMiglioramento.check_5_b_2),
        s5bFlgRelazDettaglioSucc: Number(value.interventiMiglioramento.check_5_b_3),
        s5bFlgValutazNonEseguita: Number(value.interventiMiglioramento.check_5_b_4),
        s5bMotivoRelazNonEseg: value.interventiMiglioramento.motivo_5_b_4,
        s5cFlgDimensCorretto: Number(value.interventiMiglioramento.check_5_c_1),
        s5cFlgDimensNonControll: Number(value.interventiMiglioramento.check_5_c_3),
        s5cFlgDimensNonCorretto: Number(value.interventiMiglioramento.check_5_c_2),
        s5cFlgDimensRelazSucces: Number(value.interventiMiglioramento.check_5_c_4),
        progressivo: this.gf.L4_4numGF,
        dataInstall: moment(this.gf.L4_4dataInstallaz).valueOf(),
        s6hFlgInverter: value.gruppoFrigoPdc.macchinaDotataDiInverter,
        s6nFlgFugaDiretta: value.gruppoFrigoPdc.diretta,
        s6nFlgFugaIndiretta: value.gruppoFrigoPdc.indiretta,
        s7aDataUltimaManut: value.manutenzioneAnalisi.ultimaManutenzioneInData?.valueOf(),
        s7aFkFrequenzaManut: value.manutenzioneAnalisi.frequenza ? Number(value.manutenzioneAnalisi.frequenza) : null,
        s7aFlgManutEffettuata: value.manutenzioneAnalisi.ultimaManutenzione,
        s7aFrequenzaManutaltro: value.manutenzioneAnalisi.frequenzaManutAltro,
        s7bFlgRegistroApparecc:  value.manutenzioneAnalisi.registroApparecchiatura,
        s7cDataRee: value.manutenzioneAnalisi.presenteInData?.valueOf(),
        s7cFlgOsservazioni: Number(value.manutenzioneAnalisi.osservazioni),
        s7cFlgPrescr: Number(value.manutenzioneAnalisi.prescrizioni),
        s7cFlgRaccomand: Number(value.manutenzioneAnalisi.raccomandazioni),
        s7cFlgReePresente: value.manutenzioneAnalisi.presente,
        circuiti: Object.values<any>(value.circuiti).map((circuito, i) => ({
          s8aNCircuito: String(i + 1),
          s8bFlgProveRaffrescamento: Number(circuito.raffrescamento),
          s8bFlgProveRiscaldamento: Number(circuito.riscaldamento),
          s8cFlgFiltriPuliti: circuito.filtriPuliti,
          s8dFlgAssenzaPerditeGas: circuito.assenzaPerditeGasRefrigerante,
          s8eMarcaStrumMisura: circuito.marca?.toUpperCase(),
          s8eModelloStrumMisura: circuito.modello?.toUpperCase(),
          s8eMatricolaStrumMisura: circuito.matricola?.toUpperCase(),
          s8fPotAssorbitaKw: circuito.potenzaAssorbita,
          s8gFlgStrumentazioneFissa: circuito.strumentazioneFissa,
          s8hOperatoreDenominazione: null,
          s8iOperatoreNumIscriz: null,
          s8jSurriscaldamentoK: circuito.surriscaldamento,
          s8jTempSorgIngressoC: circuito.temperaturaSorgenteIngressoLatoEsterno,
          s8jSottoraffreddamentoK: circuito.sottoraffreddamento,
          s8jTempSorgUscitaC: circuito.temperaturaSorgenteUscitaLatoEsterno,
          s8jTempCondensazioneC: circuito.temperaturaCondensazione,
          s8jTempIngressoFluidoC: circuito.temperaturaIngressoFluidoUtenze,
          s8jTempEvaporazioneC: circuito.temperaturaEvaporazione,
          s8jTempUscitaFluidoC: circuito.temperaturaUscitaFluidoUtenze,
          s9aFlgVerificaSuperata: circuito.verificaSuperata,
          s9bFlgRispettoNormativa: Number(circuito.rispettaNormativa),
          s9cFlgNoRispetto7a: Number(circuito.nonRispettaNormativaPunto7a),
          s9cFlgNoRispetto7b: Number(circuito.nonRispettaNormativaPunto7c), // 7c è il nome giusto, ma su BE e DB si chiama 7b
          s9cFlgNoRispetto8d: Number(circuito.nonRispettaNormativaPunto8d),
          s9cFlgNoRispetto9a: Number(circuito.nonRispettaNormativaPunto9a)
        })),
        fOsservazioni: value.osservazioni.osservazioni,
        fPrescrizioni: value.prescrizioni.prescrizioni,
        fRaccomandazioni: value.dichiarazioniResponsabile.raccomandazioni,
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

    if (Object.values<any>(this.rapprovaForm.value.circuiti).some(circuito => !circuito.raffrescamento && !circuito.riscaldamento)) {
      this.alert.error({ title: 'Errore di compilazione', message: 'Spuntare almeno una delle caselle Raffrescamento e Riscaldamento nella sezione 8.b' });
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
