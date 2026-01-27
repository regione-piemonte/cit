import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import moment from 'moment';
import { combineLatest } from 'rxjs';
import { datiPrecompilatiToInfoBox, ImpiantoInfoBox } from 'src/app/common/components/impianto-info-box/impianto-info-box.component';
import { IspezioneDetail } from 'src/app/ispezione/models/ispezione-detail.model';
import { IspezioneService } from 'src/app/ispezione/services/ispezione.service';
import { AlertService } from 'src/app/services/alert.service';
import { LoadingService } from 'src/app/services/loading.service';
import { GroupChip } from '../../models/group-chip.model';
import { SaveRapprovaUpload } from '../../models/save-rapprova-upload.model';
import { RapprovaService } from '../../services/rapprova.service';
import { IMPIANTO_NON_CONFORME_DLGS_102_2014_MESSAGE, IMPIANTO_NON_CONFORME_DLGS_102_2014_TITLE } from '../../utils/rapprova-utils';

@Component({
  selector: 'app-rapprova-add-step3-upload',
  templateUrl: './rapprova-add-step3-upload.component.html',
  styleUrls: ['./rapprova-add-step3-upload.component.scss']
})
export class RapprovaAddStep3UploadComponent implements OnInit {
  state = history.state;
  loading = true;
  idIspezione2018: number;
  ispezione: IspezioneDetail;
  impiantoInfoBox: ImpiantoInfoBox;
  rapprovaForm: FormGroup;
  chip: GroupChip;

  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private rapprovaService: RapprovaService,
    private fb: FormBuilder,
    private loadingService: LoadingService,
    private alert: AlertService,
    private ispezioneService: IspezioneService
  ) {}

  ngOnInit(): void {
    this.route.paramMap.subscribe(paramMap => {
      this.idIspezione2018 = Number(paramMap.get('id'));

      if (!this.state.selectedChip){
        this.router.navigate(['/', 'dettaglio-ispezione', this.idIspezione2018, 'nuovo-rapprova', 'step-1']);
        return;
      }

      combineLatest([
        this.rapprovaService.getLibretto(this.state.codiceImpianto),
        this.ispezioneService.getIspezioneDetail(this.idIspezione2018)
      ]).subscribe(([libretto, ispezione]) => {
        const richiesta = libretto.MOD.Richiesta;

        this.impiantoInfoBox = datiPrecompilatiToInfoBox(richiesta.datiPrecompilati);
        this.chip = this.state.selectedChip;
        this.ispezione = ispezione;

        this.rapprovaForm = this.fb.group({
          dataRapprova: [{ value: moment(this.state.filters.dataRapProva), disabled: true }],
          su: [{ value: this.state.selectedChip, disabled: true }],
          nomeDocOriginale: [null],
          docBase64: [null],
          docContentType: [null],
        })

        this.loading = false
      });
    });
  }

  openDocument($event: Event) {
    const file = ($event.target as HTMLInputElement).files[0];

    const reader = new FileReader();
    reader.onload = () => {
      const base64 = (reader.result as string).split(',')[1];
      this.rapprovaForm.patchValue({
        nomeDocOriginale: file.name,
        docBase64: base64,
        docContentType: file.type,
      });
    };

    reader.readAsDataURL(file);
  }

  clearDocument() {
    this.rapprovaForm.patchValue({
      nomeDocOriginale: null,
      docBase64: null,
      docContentType: null,
    });
  }

  private buildSaveRapprovaUpload(): SaveRapprovaUpload {
    const value = this.rapprovaForm.value;

    const elencoApparecchiature = `${this.chip.tipologia === 'termici' ? 'GT' : 'GF'}-${this.chip.num} (${this.chip.fabbricante} - ${this.chip.modello})`;
    const datiRapProvaWeb = {
      progressivo: this.chip.num,
      dataInstall: this.chip.dataInstall
    };

    return {
      datiRapProva: {
        dataControllo: this.state.filters.dataRapProva,
        codiceImpianto: this.state.codiceImpianto,
        fkTipoDocumento: this.state.filters.tipoRapportoDiProva,
        fOraArrivo: this.state.filters.oraRapProva,
        elencoApparecchiature,
        elencoCombustibili: this.chip.combustibile,
        fkIspezIspet: this.ispezione.idIspezIspet
      },
      datiRapProvaWebGt: this.chip.tipologia === 'termici' ? datiRapProvaWeb : undefined,
      datiRapProvaWebGf: this.chip.tipologia !== 'termici' ? datiRapProvaWeb : undefined,
      docBase64: value.docBase64,
      docName: value.nomeDocOriginale
    };
  }

  caricaDocumento(): void {
    this.loadingService.on();

    const request = this.buildSaveRapprovaUpload();
    this.rapprovaService.saveRapprovaUpload(request).subscribe({
      next: (esito) => {
        this.loadingService.off();

        this.alert.success({ message: 'Rapporto di prova aggiunto con successo!', title: 'Rapporto di prova aggiunto' });

        if (esito.impiantoNonConformeDlgs1022014) {
          this.alert.warn({ message: IMPIANTO_NON_CONFORME_DLGS_102_2014_MESSAGE, title: IMPIANTO_NON_CONFORME_DLGS_102_2014_TITLE });
        }

        this.router.navigate(['/', 'dettaglio-ispezione', this.idIspezione2018]);
      },
      error: () => this.loadingService.off(),
    });
  }
}
