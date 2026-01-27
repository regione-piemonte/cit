import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import moment from 'moment';
import { combineLatest } from 'rxjs';
import { AlertService } from 'src/app/services/alert.service';
import { AuthenticationService } from 'src/app/services/authentication.service';
import { DialogService } from 'src/app/services/dialog.service';
import { LoadingService } from 'src/app/services/loading.service';
import { TIPO_VERIFICA_DATO_DISTRIBUTORE_ID, TIPO_VERIFICA_IMPIANTO_ID } from 'src/app/utils/constants';
import { Assegnatario } from '../../models/assegnatario.model';
import { TipoVerifica } from '../../models/tipo-verifica.model';
import { VerificaService } from '../../services/verifica.service';

@Component({
  selector: 'app-ispezione-massiva-add',
  templateUrl: './ispezione-massiva-add.component.html',
  styleUrls: ['./ispezione-massiva-add.component.scss']
})
export class IspezioneMassivaAddComponent implements OnInit {
  loading = true;

  assegnatarioList: Assegnatario[];
  tipoVerificaList: TipoVerifica[];

  verificaForm: FormGroup;

  constructor(
    private verificaService: VerificaService,
    private fb: FormBuilder,
    private loadingService: LoadingService,
    private router: Router,
    private dialog: DialogService,
    private alert: AlertService,
    private authenticationService: AuthenticationService
  ) {}

  ngOnInit() {
    combineLatest([
      this.verificaService.getAssegnatarioList(),
      this.verificaService.getTipoVerificaList(),
    ]).subscribe(([assegnatarioList, tipoVerificaList]) => {
      const user = this.authenticationService.getCurrentUserFromSession();

      this.assegnatarioList = assegnatarioList;
      this.tipoVerificaList = tipoVerificaList.filter(t => [TIPO_VERIFICA_IMPIANTO_ID, TIPO_VERIFICA_DATO_DISTRIBUTORE_ID].includes(t.id));

      this.verificaForm = this.fb.group({
        cfUtenteCaricamento: [{ value: user.pfLoggato.codiceFiscalePF, disabled: true }],
        dtCaricamento: [{ value: moment(), disabled: true }],
        fkTipoVerifica: [null, Validators.required],
        codiceImpianto: [null],
        fkDatoDistrib: [null],
        flgIspPagamento: [null]
      });

      this.verificaForm.get('fkTipoVerifica').valueChanges.subscribe(value => {
        this.verificaForm.get('codiceImpianto').clearValidators();
        this.verificaForm.get('fkDatoDistrib').clearValidators();

        switch (value) {
          case TIPO_VERIFICA_IMPIANTO_ID:
            this.verificaForm.get('codiceImpianto').setValidators(Validators.required);
            break;
          case TIPO_VERIFICA_DATO_DISTRIBUTORE_ID:
            this.verificaForm.get('fkDatoDistrib').setValidators(Validators.required);
            break;
        }

        this.verificaForm.patchValue({
          codiceImpianto: null,
          fkDatoDistrib: null,
        })
      });

      this.loading = false;
    });
  }

  isCodiceImpiantoVisible(): boolean {
    return this.verificaForm.get('fkTipoVerifica').value === TIPO_VERIFICA_IMPIANTO_ID;
  }

  isIdentificativoDatoDistributoreVisible(): boolean {
    return this.verificaForm.get('fkTipoVerifica').value === TIPO_VERIFICA_DATO_DISTRIBUTORE_ID;
  }

  submit() {
    if (this.verificaForm.invalid) {
      return;
    }

    this.dialog.confirm('Nuova ispezione massiva', "Confermi di voler salvare l'ispezione massiva?").subscribe(result => {
      if (result) {
        this.loadingService.on();

        const value = this.verificaForm.getRawValue();
        const request = {
          ...value,
          dtCaricamento: value.dtCaricamento?.valueOf(),
          codiceImpianto: value.codiceImpianto?.split(';').map(c => Number(c)),
          fkDatoDistrib: value.fkDatoDistrib?.split(';').map(d => Number(d)),
          flgIspPagamento: Number(value.flgIspPagamento)
        };
        this.verificaService.insertIspezioneMassiva(request).subscribe({
          next: () => {
            this.loadingService.off();

            this.alert.success({ message: 'Ispezione massiva aggiunta con successo!', title: 'Ispezione massiva aggiunta' });
            this.router.navigate(['/', 'cerca-verifiche']);
          },
          error: () => this.loadingService.off(),
        });
      }
    });
  }
}
