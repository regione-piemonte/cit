import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { combineLatest } from 'rxjs';
import { map, switchMap } from 'rxjs/operators';
import { zeroToNull } from 'src/app/pipe/zero-to-null.pipe';
import { AlertService } from 'src/app/services/alert.service';
import { DialogService } from 'src/app/services/dialog.service';
import { LoadingService } from 'src/app/services/loading.service';
import { VerificaService } from 'src/app/verifica/services/verifica.service';
import { getIndirizzo } from 'src/app/verifica/utils/impianto-utils';
import { IspezioneDetail } from '../../models/ispezione-detail.model';
import { IspezioneService } from '../../services/ispezione.service';

@Component({
  selector: 'app-ispezione-assegna-impianto',
  templateUrl: './ispezione-assegna-impianto.component.html',
  styleUrls: ['./ispezione-assegna-impianto.component.scss']
})
export class IspezioneAssegnaImpiantoComponent implements OnInit {
  loading = true;

  ispezione: IspezioneDetail;

  ispezioneForm: FormGroup;
  impianto: any;

  constructor(
    private verificaService: VerificaService,
    private ispezioneService: IspezioneService,
    private fb: FormBuilder,
    private route: ActivatedRoute,
    private loadingService: LoadingService,
    private router: Router,
    private dialog: DialogService,
    private alert: AlertService
  ) {}

  ngOnInit() {
    combineLatest([
      this.route.paramMap.pipe(
        map((paramMap) => Number(paramMap.get('id'))),
        switchMap((id) => this.ispezioneService.getIspezioneDetail(id))
      ),
    ]).subscribe(
      ([
        ispezione,
      ]) => {
        this.ispezione = ispezione;

        this.ispezioneForm = this.fb.group({
          codiceImpianto: [zeroToNull(ispezione.codiceImpianto), Validators.required],
        });

        this.loading = false;
      }
    );
  }

  searchByCodiceImpianto(codiceImpianto: number) {
    this.loadingService.on();

    this.verificaService.getImpianto(codiceImpianto).subscribe({
      next: impianto => {
        this.ispezioneForm.get('codiceImpianto').setValue(codiceImpianto);

        this.impianto = impianto;

        this.loadingService.off();
      },
      error: () => {
        this.loadingService.off();
        this.alert.error({ message: 'Non esiste un impianto con il codice specificato' });
      }
    });
  }

  getLocalizzazione(): string {
    return getIndirizzo(this.impianto);
  }

  submit() {
    if (this.ispezioneForm.invalid) {
      if (this.ispezioneForm.get('codiceImpianto').errors?.required) {
        this.alert.error({ message: 'Selezionare un impianto per continuare' });
      }

      return;
    }

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
          };
          this.ispezioneService.assegnaImpiantoIspezione(request).subscribe({
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
}
