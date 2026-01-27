import { Component, HostListener, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { MatDialog } from '@angular/material/dialog';
import { ActivatedRoute, Router } from '@angular/router';
import moment from 'moment';
import { combineLatest } from 'rxjs';
import { map, switchMap } from 'rxjs/operators';
import { zeroToNull } from 'src/app/pipe/zero-to-null.pipe';
import { RapprovaUploadFirmatoDialogComponent } from 'src/app/rapprova/components/rapprova-upload-firmato-dialog/rapprova-upload-firmato-dialog.component';
import { RapprovaLocale } from 'src/app/rapprova/models/rapprova-locale.model';
import { Rapprova } from 'src/app/rapprova/models/rapprova.model';
import { RapprovaLocaleService } from 'src/app/rapprova/services/rapprova-locale.service';
import { RapprovaPendingOpService } from 'src/app/rapprova/services/rapprova-pending-op.service';
import { RapprovaService } from 'src/app/rapprova/services/rapprova.service';
import { AlertService } from 'src/app/services/alert.service';
import { DialogService } from 'src/app/services/dialog.service';
import { DocumentiImpiantoService } from 'src/app/services/documenti-impianto.service';
import { LoadingService } from 'src/app/services/loading.service';
import { SharedService } from 'src/app/services/shared.service';
import { PROVINCE_PIEMONTESI, STATO_ISPEZIONE_ANNULLATO_ID, STATO_ISPEZIONE_BOZZA_ID } from 'src/app/utils/constants';
import { doDownloadFile, download } from 'src/app/utils/utils';
import { AzioneIspezione } from '../../models/azione-ispezione.model';
import { ComuneEsteso } from '../../models/comune-esteso.model';
import { Ispettore } from '../../models/ispettore.model';
import { IspezioneDetail } from '../../models/ispezione-detail.model';
import { StatoIspezione } from '../../models/stato-ispezione.model';
import { IspezioneService } from '../../services/ispezione.service';
import { getIndirizzo } from '../../utils/ispezione-utils';
import { LibrettoService } from 'src/app/services/libretto.service';

@Component({
  selector: 'app-ispezione-detail',
  templateUrl: './ispezione-detail.component.html',
  styleUrls: ['./ispezione-detail.component.scss'],
})
export class IspezioneDetailComponent implements OnInit {

  loading = true;

  ispettoreList: Ispettore[];
  statoIspezioneList: StatoIspezione[];
  provinciaList: ComuneEsteso[];
  comuneEstesoList: ComuneEsteso[];
  ispezione: IspezioneDetail;
  rapprovaLocaleList: RapprovaLocale[];
  rapprovaList: Rapprova[];
  azioneList: AzioneIspezione[];
  editMode: boolean;

  ispezioneForm: FormGroup;

  constructor(
    readonly sharedService: SharedService,
    private ispezioneService: IspezioneService,
    private documentiImpiantoService: DocumentiImpiantoService,
    private fb: FormBuilder,
    private route: ActivatedRoute,
    private loadingService: LoadingService,
    private router: Router,
    private dialog: DialogService,
    private matDialog: MatDialog,
    private alert: AlertService,
    private rapprovaService: RapprovaService,
    private rapprovaLocaleService: RapprovaLocaleService,
    private rapprovaPendingOpService: RapprovaPendingOpService,
    private librettoService: LibrettoService,
  ) {}

  private popolateForm(ispezione: IspezioneDetail) {
    this.ispezioneForm = this.fb.group({
      idIspezione2018: [
        { value: ispezione.idIspezione2018, disabled: true },
      ],
      dtCreazione: [
        {
          value: ispezione.dtCreazione
            ? moment(ispezione.dtCreazione)
            : null,
          disabled: true,
        },
      ],
      cfUtenteAssegn: [{ value: ispezione.cfUtenteAssegn, disabled: true }],
      cfIspettoreSecondario: [
        {
          value: ispezione.cfIspettoreSecondario,
          disabled: !this.editMode || !this.isBozza(),
        },
      ],
      fkStatoIspezione: [
        { value: ispezione.fkStatoIspezione, disabled: true },
      ],
      codiceImpianto: [
        { value: zeroToNull(ispezione.codiceImpianto), disabled: true },
      ],
      indirizzo: [{ value: getIndirizzo(ispezione), disabled: true }],
      istatProvCompetenza: [{ value: ispezione.istatProvCompetenza, disabled: true }],
      istatComuneCompetenza: [{ value: ispezione.istatComuneCompetenza, disabled: true }],
      flgIspPagamento: [{ value: ispezione.flgIspPagamento, disabled: !this.editMode || !this.isBozza() }],
      dtConclusione: [
        {
          value: ispezione.dtConclusione
            ? moment(ispezione.dtConclusione)
            : null,
          disabled: true,
        },
      ],
      flgEsito: [{ value: ispezione.flgEsito, disabled: true }],
      enteCompetente: [{ value: ispezione.enteCompetente, disabled: true }],
      dtSveglia: [
        {
          value: ispezione.dtSveglia ? moment(ispezione.dtSveglia) : null,
          disabled: !this.editMode,
        },
      ],
      noteSveglia: [
        { value: ispezione.noteSveglia, disabled: !this.editMode },
      ],
      note: [{ value: ispezione.note, disabled: !this.editMode }],
    });
  }

  ngOnInit() {
    combineLatest([
      this.ispezioneService.getIspettoreList(),
      this.ispezioneService.getStatoIspezioneList(),
      this.ispezioneService.getComuneEstesoList(),
      this.route.paramMap.pipe(
        map((paramMap) => Number(paramMap.get('id'))),
        switchMap((id) =>
          combineLatest([
            this.ispezioneService.getIspezioneDetail(id),
            this.rapprovaService.getRapprovaList({ idIspezione2018: id }),
            this.ispezioneService.getAzioneListByIdIspezione2018(id)
          ])
        )
      ),
      this.route.paramMap,
    ]).subscribe(
      ([
        ispettoreList,
        statoIspezioneList,
        comuneEstesoList,
        [ispezione, rapprovaList, azioneList],
        paramMap,
      ]) => {
        const comuniPiemontesi = comuneEstesoList.filter(c => PROVINCE_PIEMONTESI.includes(c.siglaProvincia));

        this.ispettoreList = ispettoreList
          .filter(i => !i.dataFine || i.dataFine > Date.now())
          .reduce<Ispettore[]>((a, c) => a.some(x => x.codicefiscale === c.codicefiscale) ? a : [...a, c], [])
          .sort((a, b) => `${a.cognome} ${a.nome}`.localeCompare(`${b.cognome} ${b.nome}`));
        this.statoIspezioneList = statoIspezioneList;
        this.provinciaList = comuniPiemontesi
          .reduce<ComuneEsteso[]>((a, c) => a.some(x => x.idProvincia === c.idProvincia) ? a : [...a, c], [])
          .sort((a, b) => a.provincia.localeCompare(b.provincia));
        this.comuneEstesoList = comuniPiemontesi;
        this.ispezione = ispezione;
        this.rapprovaLocaleList = this.rapprovaLocaleService.getRapprovaLocaleListByIdIspezione2018OrderByDataControllo(ispezione.idIspezione2018);
        this.rapprovaList = rapprovaList;
        this.azioneList = azioneList.sort((a, b) => b.dtAzione - a.dtAzione === 0 ? b.idAzione - a.idAzione : b.dtAzione - a.dtAzione);
        this.editMode = paramMap.get('edit') === 'edit';

        this.popolateForm(ispezione);

        this.loading = false;
      }
    );
  }

  clearSveglia() {
    this.ispezioneForm.get('dtSveglia').reset();
    this.ispezioneForm.get('noteSveglia').reset();
  }

  submit() {
    this.dialog
      .confirm(
        'Modifica ispezione',
        `Confermi di voler salvare le modifiche sull'ispezione numero ${this.ispezione.idIspezione2018}?`
      )
      .subscribe((result) => {
        if (result) {
          this.loadingService.on();

          const value = this.ispezioneForm.value;
          const request = {
            ...value,
            idIspezione2018: this.ispezione.idIspezione2018,
            flgIspPagamento: Number(value.flgIspPagamento),
            dtSveglia: value.dtSveglia?.valueOf(),
          };
          this.ispezioneService.saveIspezione(request).subscribe({
            next: (esito) => {
              this.loadingService.off();

              this.alert.success({ message: 'Ispezione modificata con successo!', title: 'Ispezione modificata' });
              this.router.navigate(['/', 'dettaglio-ispezione', esito.idIspezione2018]);
            },
            error: () => this.loadingService.off(),
          });
        }
      });
  }

  downloadRapprova(rapprova: Rapprova): void {
    this.loadingService.on();

    this.rapprovaService
      .downloadRapprova(rapprova.idAllegato)
      .subscribe({
        next: (documento) => {
          download(documento.base64, documento.name);

          this.loadingService.off();
        },
        error: () => this.loadingService.off(),
      });
  }

  downloadRapprovaFirmato(rapprova: Rapprova): void {
    this.loadingService.on();

    this.rapprovaService
      .downloadRapprovaFirmato(rapprova.idAllegato)
      .subscribe({
        next: (documento) => {
          download(documento.base64, documento.name);

          this.loadingService.off();
        },
        error: () => {
          this.loadingService.off();

          this.alert.warn({ message: 'Nessun documento firmato presente a sistema per questo rapporto di prova', title: 'Attenzione' });
        },
      });
  }

  getRapprovaCardClass(rapprova: Rapprova | RapprovaLocale): string {
    const idAllegato = (rapprova as Rapprova).idAllegato ?? (rapprova as RapprovaLocale).localId;
    const pendingOp = this.rapprovaPendingOpService.getByIdAllegato(idAllegato);

    if (pendingOp) {
      return 'rapprova-in-attesa-card';
    }

    return (rapprova as Rapprova).idAllegato ? `rapprova-${(rapprova as Rapprova).fkStatoRapp}-card` : 'rapprova-locale-card';
  }

  getRapprovaState(rapprova: Rapprova | RapprovaLocale): string {
    const idAllegato = (rapprova as Rapprova).idAllegato ?? (rapprova as RapprovaLocale).localId;
    const pendingOp = this.rapprovaPendingOpService.getByIdAllegato(idAllegato);

    if (pendingOp) {
      switch (pendingOp.op) {
        case 'INVIA':
          return 'IN ATTESA DI INVIO';
        case 'SALVA_INVIA':
          return 'IN ATTESA DI SALVATAGGIO E INVIO';
        case 'ELIMINA':
          return 'IN ATTESA DI ELIMINAZIONE';
      }
    }

    return (rapprova as Rapprova).idAllegato ? (rapprova as Rapprova).desStatoRapp.toUpperCase() : 'BOZZA LOCALE';
  }

  hasRapprovaPendingOp(rapprova: Rapprova | RapprovaLocale): boolean {
    const idAllegato = (rapprova as Rapprova).idAllegato ?? (rapprova as RapprovaLocale).localId;
    return !!this.rapprovaPendingOpService.getByIdAllegato(idAllegato);
  }

  cancelRapprovaPendingOp(rapprova: Rapprova | RapprovaLocale): void {
    const idAllegato = (rapprova as Rapprova).idAllegato ?? (rapprova as RapprovaLocale).localId;
    this.rapprovaPendingOpService.cancelByIdAllegato(idAllegato);
    // Valutare se occorre refresh o locale o online / prob non serve, basta riassegnare le liste o markForCheck
  }

  private refreshRapprovaList(): void {
    this.loadingService.on();

    this.rapprovaService.getRapprovaList({ idIspezione2018: this.ispezione.idIspezione2018 }).subscribe({
      next: rapprovaList => {
        this.rapprovaList = rapprovaList;

        this.loadingService.off();
      },
      error: () => this.loadingService.off()
    });
  }

  private refreshRapprovaLocaleList(): void {
    this.rapprovaLocaleList = this.rapprovaLocaleService.getRapprovaLocaleListByIdIspezione2018OrderByDataControllo(this.ispezione.idIspezione2018);
  }

  @HostListener('document:rapprovaPendingOpListChanged')
  onRapprovaPendingOpListChanged(): void {
    if (navigator.onLine) {
      this.refreshRapprovaList();
    }
  }

  private deleteRapprova(rapprova: Rapprova | RapprovaLocale): void {
    if ((rapprova as Rapprova).idAllegato) {
      if (navigator.onLine) {
        this.loadingService.on();

        this.rapprovaService.deleteRapprova((rapprova as Rapprova).idAllegato, this.ispezione.idIspezione2018).subscribe({
          next: () => {
            this.loadingService.off();

            this.alert.success({ title: 'Rapporto di prova cancellato', message: 'Operazione effettuata con successo!' });

            this.refreshRapprovaList();
          },
          error: () => this.loadingService.off(),
        });
      } else {
        this.rapprovaPendingOpService.add({
          op: 'ELIMINA',
          idAllegato: (rapprova as Rapprova).idAllegato,
          idIspezione2018: this.ispezione.idIspezione2018,
          dataRapportoDiProva: (rapprova as Rapprova).dataControllo
        });
      }
    } else {
      this.rapprovaLocaleService.deleteRapprovaLocale((rapprova as RapprovaLocale).localId);
      this.refreshRapprovaLocaleList();
    }
  }

  deleteRapprovaConfirm(rapprova: Rapprova | RapprovaLocale): void {
    this.dialog
      .confirm('Cancella rapporto di prova', 'Confermi di voler procedere?')
      .subscribe((result) => {
        if (result) {
          this.deleteRapprova(rapprova);
        }
      });
  }

  inviaRapprovaAlert(): void {
    this.alert.error({ title: 'Errore invio rapporto di prova', message: 'Bisogna salvare il dettaglio del rapporto di prova prima di inviarlo.' });
  }

  modificaRapprova(rapprova: Rapprova | RapprovaLocale): void {
    const isGt = (rapprova as Rapprova).idAllegato ? (rapprova as Rapprova).fkTipoDocumento === 8 : !!(rapprova as RapprovaLocale).datiRapProvaWebGt;
    const idAllegato = (rapprova as Rapprova).idAllegato ?? `L${(rapprova as RapprovaLocale).localId}`;

    this.router.navigate(['/', 'dettaglio-ispezione', this.ispezione.idIspezione2018, isGt ? 'rapprova-gt' : 'rapprova-gf', idAllegato, 'edit']);
  }

  uploadRapprovaFirmato(rapprova: Rapprova): void {
    this.matDialog
      .open(RapprovaUploadFirmatoDialogComponent, {
        data: {
          idAllegato: rapprova.idAllegato,
          codiceImpianto: this.ispezione.codiceImpianto
        }
      })
      .afterClosed()
      .subscribe();
  }

  getDocumentoAzioneExt(azione: AzioneIspezione): string {
    return azione.nomeDocOriginale.split('.').pop().toLowerCase();
  }

  getDocumentoAzioneColor(azione: AzioneIspezione): string {
    return this.getDocumentoAzioneExt(azione) === 'pdf' ? 'accent' : 'primary';
  }

  getDocumentoAzioneIcon(azione: AzioneIspezione): string {
    const ext = this.getDocumentoAzioneExt(azione);
    return ['jpg', 'jpeg', 'png'].includes(ext) ? 'image' : 'description';
  }

  getDocumentoAzioneLabel(azione: AzioneIspezione): string {
    const ext = this.getDocumentoAzioneExt(azione);
    const prefix = ['jpg', 'jpeg', 'png'].includes(ext) ? 'Immagine' : 'Documento';
    const suffix = ext.toUpperCase();
    return `${prefix} ${suffix}`;
  }

  downloadDocumentoAzione(azione: AzioneIspezione) {
    this.loadingService.on();

    this.documentiImpiantoService.getDocumentoByUid(azione.uidIndex).subscribe({
      next: (documento) => {
        doDownloadFile(documento.doc, documento.nome, documento.mimeType);

        this.loadingService.off();
      },
      error: () => this.loadingService.off(),
    });
  }

  isBozza(): boolean {
    return this.ispezione.fkStatoIspezione === STATO_ISPEZIONE_BOZZA_ID;
  }

  isAnnullato(): boolean {
    return this.ispezione.fkStatoIspezione === STATO_ISPEZIONE_ANNULLATO_ID;
  }

  private refresh() {
    this.loading = true;

    combineLatest([
      this.ispezioneService.getIspezioneDetail(this.ispezione.idIspezione2018),
      this.rapprovaService.getRapprovaList({ idIspezione2018: this.ispezione.idIspezione2018 }),
      this.ispezioneService.getAzioneListByIdIspezione2018(this.ispezione.idIspezione2018)
    ]).subscribe(([ispezione, rapprovaList, azioneList]) => {
      this.ispezione = ispezione;
      this.rapprovaList = rapprovaList;
      this.azioneList = azioneList.sort((a, b) => b.dtAzione - a.dtAzione);

      this.popolateForm(ispezione);

      this.loading = false;
    });
  }

  annullaIspezioneConfirm() {
    this.dialog.confirm(
      'Annullamento ispezione',
      `Si conferma l'annullamento dell'ispezione ${this.ispezione.idIspezione2018}? Eventuali Rapporti Di Prova in stato BOZZA verranno eliminati. Eventuali Rapporti Di Prova in stato INVIATO verranno respinti.`
    ).subscribe(result => {
      if (result) {
        this.loadingService.on();

        this.ispezioneService.annullaIspezione(this.ispezione.idIspezione2018).subscribe({
          next: () => {
            this.loadingService.off();

            this.alert.success({ title: 'Ispezione annullata', message: 'Operazione effettuata con successo!' });

            this.refresh();
          },
          error: () => this.loadingService.off(),
        });
      }
    });
  }

  comingSoon() {
    this.dialog.alert('Coming soon', 'Funzionalità non ancora disponibile');
  }

  async onAggiungiRapProvaClick() {
    let obsExt = this.librettoService.getLibrettoDtoByCodice(this.ispezione.codiceImpianto.toString());
    let libretto;

    try{
      libretto = await obsExt.toPromise();
    }
    catch(e)
    {
       this.alert.error({ message: 'Per compilare Rapporti di Efficienza Energetica o di altro tipo è necessario eseguire un consolidamento del libretto', title: 'Errore' });
       return;
    }

    this.router.navigate(['/', 'dettaglio-ispezione', this.ispezione.idIspezione2018, 'nuovo-rapprova', 'step-1']); 
  }
}
