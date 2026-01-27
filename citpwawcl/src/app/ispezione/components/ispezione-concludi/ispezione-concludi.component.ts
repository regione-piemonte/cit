import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { combineLatest } from 'rxjs';
import { map, switchMap } from 'rxjs/operators';
import { AlertService } from 'src/app/services/alert.service';
import { DialogService } from 'src/app/services/dialog.service';
import { LoadingService } from 'src/app/services/loading.service';
import { IspezioneDetail } from '../../models/ispezione-detail.model';
import { IspezioneService } from '../../services/ispezione.service';

@Component({
  selector: 'app-ispezione-concludi',
  templateUrl: './ispezione-concludi.component.html',
  styleUrls: ['./ispezione-concludi.component.scss']
})
export class IspezioneConcludiComponent implements OnInit {
  loading = true;

  ispezione: IspezioneDetail;

  ispezioneForm: FormGroup;

  constructor(
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
          enteCompetente: [ispezione.enteCompetente, Validators.required],
          flgEsito: [ispezione.flgEsito, Validators.required],
          note: [ispezione.note],
        });

        this.loading = false;
      }
    );
  }

  submit() {
    if (this.ispezioneForm.invalid) {
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
          this.ispezioneService.concludiIspezione(request).subscribe({
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
