import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import moment from 'moment';
import { combineLatest, of } from 'rxjs';
import { map, switchMap } from 'rxjs/operators';
import { Ispezione } from 'src/app/ispezione/models/ispezione.model';
import { IspezioneService } from 'src/app/ispezione/services/ispezione.service';
import { zeroToNull } from 'src/app/pipe/zero-to-null.pipe';
import { AlertService } from 'src/app/services/alert.service';
import { DialogService } from 'src/app/services/dialog.service';
import { DocumentiImpiantoService } from 'src/app/services/documenti-impianto.service';
import { LoadingService } from 'src/app/services/loading.service';
import { doDownloadFile } from 'src/app/utils/utils';
import { Assegnatario } from '../../models/assegnatario.model';
import { Azione } from '../../models/azione.model';
import { Distributore } from '../../models/distributore.model';
import { TipoVerifica } from '../../models/tipo-verifica.model';
import { VerificaDetail } from '../../models/verifica-detail.model';
import { VerificaService } from '../../services/verifica.service';
import { getCodiceRee, getIndirizzo } from '../../utils/verifica-utils';

@Component({
  selector: 'app-verifica-detail',
  templateUrl: './verifica-detail.component.html',
  styleUrls: ['./verifica-detail.component.scss'],
})
export class VerificaDetailComponent implements OnInit {
  loading = true;

  assegnatarioList: Assegnatario[];
  tipoVerificaList: TipoVerifica[];
  verifica: VerificaDetail;
  distributore: Distributore;
  azioneList: Azione[];
  ispezioneList: Ispezione[];
  editMode: boolean;

  verificaForm: FormGroup;

  constructor(
    private verificaService: VerificaService,
    private ispezioneService: IspezioneService,
    private documentiImpiantoService: DocumentiImpiantoService,
    private fb: FormBuilder,
    private route: ActivatedRoute,
    private loadingService: LoadingService,
    private router: Router,
    private dialog: DialogService,
    private alert: AlertService
  ) {}

  ngOnInit() {
    combineLatest([
      this.verificaService.getAssegnatarioList(),
      this.verificaService.getTipoVerificaList(),
      this.route.paramMap.pipe(
        map((paramMap) => Number(paramMap.get('id'))),
        switchMap((id) =>
          combineLatest([
            this.verificaService.getVerificaDetail(id).pipe(
              switchMap(verifica =>
                combineLatest([
                  of(verifica),
                  verifica.fkDatoDistrib ? this.verificaService.getDistributore(verifica.fkDatoDistrib) : of(null)
                ])
              )
            ),
            this.verificaService.getAzioneListByIdVerifica(id),
            this.ispezioneService.getIspezioneList({ fkVerifica: id })
          ])
        )
      ),
      this.route.paramMap,
    ]).subscribe(
      ([
        assegnatarioList,
        tipoVerificaList,
        [[verifica, distributore], azioneList, ispezioneList],
        paramMap,
      ]) => {
        this.assegnatarioList = assegnatarioList;
        this.tipoVerificaList = tipoVerificaList;
        this.verifica = verifica;
        this.distributore = distributore;
        this.azioneList = azioneList.sort((a, b) => b.dtAzione - a.dtAzione === 0 ? b.idAzione - a.idAzione : b.dtAzione - a.dtAzione);
        this.ispezioneList = ispezioneList;
        this.editMode = paramMap.get('edit') === 'edit';

        this.verificaForm = this.fb.group({
          idVerifica: [{ value: verifica.idVerifica, disabled: true }],
          cfUtenteCaricamento: [
            { value: verifica.cfUtenteCaricamento, disabled: true },
          ],
          dtCaricamento: [
            {
              value: verifica.dtCaricamento
                ? moment(verifica.dtCaricamento)
                : null,
              disabled: true,
            },
          ],
          fkTipoVerifica: [{ value: verifica.fkTipoVerifica, disabled: true }],
          codiceImpianto: [
            { value: zeroToNull(verifica.codiceImpianto), disabled: true },
          ],
          indirizzo: [{ value: getIndirizzo(verifica), disabled: true }],
          codiceRee: [
            { value: getCodiceRee(verifica), disabled: true },
          ],
          fkDatoDistrib: [
            {
              value: zeroToNull(verifica.fkDatoDistrib),
              disabled: true,
            },
          ],
          dtSveglia: [
            {
              value: verifica.dtSveglia ? moment(verifica.dtSveglia) : null,
              disabled: !this.editMode,
            },
          ],
          noteSveglia: [
            { value: verifica.noteSveglia, disabled: !this.editMode },
          ],
          note: [{ value: verifica.note, disabled: !this.editMode }],
        });

        this.loading = false;
      }
    );
  }

  clearSveglia() {
    this.verificaForm.get('dtSveglia').reset();
    this.verificaForm.get('noteSveglia').reset();
  }

  submit() {
    this.dialog
      .confirm(
        'Modifica verifica',
        `Confermi di voler salvare le modifiche sulla verifica numero ${this.verifica.idVerifica}?`
      )
      .subscribe((result) => {
        if (result) {
          this.loadingService.on();

          const value = this.verificaForm.value;
          const request = {
            ...value,
            idVerifica: this.verifica.idVerifica,
            dtSveglia: value.dtSveglia?.valueOf(),
          };
          this.verificaService.saveVerifica(request).subscribe({
            next: (esito) => {
              this.loadingService.off();

              this.alert.success({ message: 'Verifica modificata con successo!', title: 'Verifica modificata' });
              this.router.navigate(['/', 'dettaglio-verifica', esito.idVerifica]);
            },
            error: () => this.loadingService.off(),
          });
        }
      });
  }

  getDocumentoAzioneExt(azione: Azione): string {
    return azione.nomeDocOriginale.split('.').pop().toLowerCase();
  }

  getDocumentoAzioneColor(azione: Azione): string {
    return this.getDocumentoAzioneExt(azione) === 'pdf' ? 'accent' : 'primary';
  }

  getDocumentoAzioneIcon(azione: Azione): string {
    const ext = this.getDocumentoAzioneExt(azione);
    return ['jpg', 'jpeg', 'png'].includes(ext) ? 'image' : 'description';
  }

  getDocumentoAzioneLabel(azione: Azione): string {
    const ext = this.getDocumentoAzioneExt(azione);
    const prefix = ['jpg', 'jpeg', 'png'].includes(ext) ? 'Immagine' : 'Documento';
    const suffix = ext.toUpperCase();
    return `${prefix} ${suffix}`;
  }

  downloadDocumentoAzione(azione: Azione) {
    this.loadingService.on();

    this.documentiImpiantoService.getDocumentoByUid(azione.uidIndex).subscribe({
      next: (documento) => {
        doDownloadFile(documento.doc, documento.nome, documento.mimeType);

        this.loadingService.off();
      },
      error: () => this.loadingService.off(),
    });
  }

  comingSoon() {
    this.dialog.alert('Coming soon', 'Funzionalità non ancora disponibile');
  }
}
