import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import moment from 'moment';
import { combineLatest } from 'rxjs';
import { AlertService } from 'src/app/services/alert.service';
import { AuthenticationService } from 'src/app/services/authentication.service';
import { LoadingService } from 'src/app/services/loading.service';
import { Verifica } from '../../models/verifica.model';
import { VerificaService } from '../../services/verifica.service';

@Component({
  selector: 'app-azione-add',
  templateUrl: './azione-add.component.html',
  styleUrls: ['./azione-add.component.scss'],
})
export class AzioneAddComponent implements OnInit {
  loading = true;

  verificaList: Verifica[];
  idVerifica: number;

  azioneForm: FormGroup;

  constructor(
    private verificaService: VerificaService,
    private fb: FormBuilder,
    private route: ActivatedRoute,
    private loadingService: LoadingService,
    private router: Router,
    private authenticationService: AuthenticationService,
    private alert: AlertService
  ) {}

  ngOnInit() {
    combineLatest([
      this.route.paramMap,
    ]).subscribe(([paramMap]) => {
      const user = this.authenticationService.getCurrentUserFromSession();

      this.verificaList = [{ idVerifica: Number(paramMap.get('id')) } as Verifica];
      this.idVerifica = Number(paramMap.get('id'));

      this.azioneForm = this.fb.group({
        cfUtenteAzione: [user.pfLoggato.codiceFiscalePF],
        descrizioneAzione: [null, Validators.required],
        dtAzione: [
          {
            value: moment(),
            disabled: true,
          },
        ],
        idVerifica: [{ value: this.idVerifica, disabled: true }],
        nomeDocOriginale: [null],
        docBase64: [null],
        docContentType: [null],
      });

      this.loading = false;
    });
  }

  openDocument($event: Event) {
    const file = ($event.target as HTMLInputElement).files[0];

    const reader = new FileReader();
    reader.onload = () => {
      const base64 = (reader.result as string).split(',')[1];
      this.azioneForm.patchValue({
        nomeDocOriginale: file.name,
        docBase64: base64,
        docContentType: file.type,
      });
    };

    reader.readAsDataURL(file);
  }

  clearDocument() {
    this.azioneForm.patchValue({
      nomeDocOriginale: null,
      docBase64: null,
      docContentType: null,
    });
  }

  submit() {
    this.loadingService.on();

    const value = this.azioneForm.getRawValue();
    const request = {
      ...value,
      dtAzione: value.dtAzione?.valueOf(),
    };
    this.verificaService.insertAzione(request).subscribe({
      next: () => {
        this.loadingService.off();

        this.alert.success({ message: 'Azione aggiunta con successo!', title: 'Azione aggiunta' });
        this.router.navigate(['/', 'dettaglio-verifica', this.idVerifica]);
      },
      error: () => this.loadingService.off(),
    });
  }
}
