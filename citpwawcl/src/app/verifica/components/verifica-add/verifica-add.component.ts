import { Component, OnInit } from '@angular/core';
import {
  FormBuilder,
  FormGroup,
  Validators,
} from '@angular/forms';
import { Router } from '@angular/router';
import moment from 'moment';
import { combineLatest } from 'rxjs';
import { AlertService } from 'src/app/services/alert.service';
import { AuthenticationService } from 'src/app/services/authentication.service';
import { DialogService } from 'src/app/services/dialog.service';
import { LoadingService } from 'src/app/services/loading.service';
import { TIPO_VERIFICA_ALTRO_ID, TIPO_VERIFICA_DATO_DISTRIBUTORE_ID, TIPO_VERIFICA_DECADENZA_3_RESPONSABILE_ID, TIPO_VERIFICA_IMPIANTO_ID, TIPO_VERIFICA_REE_ID, TIPO_VERIFICA_RELAZIONE_ESIMENTE_ID, TIPO_VERIFICA_SEGNALAZIONE_ID } from 'src/app/utils/constants';
import { Assegnatario } from '../../models/assegnatario.model';
import { Controllo } from '../../models/controllo.model';
import { Distributore } from '../../models/distributore.model';
import { TipoVerifica } from '../../models/tipo-verifica.model';
import { VerificaService } from '../../services/verifica.service';
import { getIndirizzo } from '../../utils/impianto-utils';
import { siglaReeCompareFn } from '../../utils/verifica-utils';

@Component({
  selector: 'app-verifica-add',
  templateUrl: './verifica-add.component.html',
  styleUrls: ['./verifica-add.component.scss'],
})
export class VerificaAddComponent implements OnInit {
  loading = true;

  assegnatarioList: Assegnatario[];
  tipoVerificaList: TipoVerifica[];
  siglaReeList: string[];

  verificaForm: FormGroup;
  impianto: any;
  controllo: Controllo;
  distributore: Distributore;

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
      this.verificaService.getSiglaReeList()
    ]).subscribe(([assegnatarioList, tipoVerificaList, siglaReeList]) => {
      const user = this.authenticationService.getCurrentUserFromSession();

      this.assegnatarioList = assegnatarioList;
      this.tipoVerificaList = tipoVerificaList;
      this.siglaReeList = siglaReeList.sort(siglaReeCompareFn);

      this.verificaForm = this.fb.group({
        idVerifica: [{ value: null, disabled: true }],
        cfUtenteCaricamento: [{ value: user.pfLoggato.codiceFiscalePF, disabled: true }],
        dtCaricamento: [{ value: moment(), disabled: true }],
        fkTipoVerifica: [null, Validators.required],
        codiceImpianto: [null],
        siglaBollino: [null],
        numeroBollino: [null],
        fkDatoDistrib: [null],
      });

      this.verificaForm.get('fkTipoVerifica').valueChanges.subscribe(value => {
        [
          this.verificaForm.get('codiceImpianto'),
          this.verificaForm.get('fkDatoDistrib'),
          this.verificaForm.get('siglaBollino'),
          this.verificaForm.get('numeroBollino')
        ].forEach((c) => c.clearValidators());

        switch (value) {
          case TIPO_VERIFICA_IMPIANTO_ID:
          case TIPO_VERIFICA_RELAZIONE_ESIMENTE_ID:
          case TIPO_VERIFICA_DECADENZA_3_RESPONSABILE_ID:
            this.verificaForm.get('codiceImpianto').setValidators(Validators.required);
            break;
          case TIPO_VERIFICA_DATO_DISTRIBUTORE_ID:
            this.verificaForm.get('fkDatoDistrib').setValidators(Validators.required);
            break;
          case TIPO_VERIFICA_REE_ID:
            [
              this.verificaForm.get('siglaBollino'),
              this.verificaForm.get('numeroBollino')
            ].forEach((c) => c.setValidators(Validators.required));
            break;
        }

        this.verificaForm.patchValue({
          codiceImpianto: null,
          siglaBollino: null,
          numeroBollino: null,
          fkDatoDistrib: null,
        });

        this.impianto = null;
        this.controllo = null;
        this.distributore = null;
      });

      this.loading = false;
    });
  }

  isCodiceImpiantoVisible(): boolean {
    return [
      TIPO_VERIFICA_IMPIANTO_ID,
      TIPO_VERIFICA_RELAZIONE_ESIMENTE_ID,
      TIPO_VERIFICA_DATO_DISTRIBUTORE_ID,
      TIPO_VERIFICA_SEGNALAZIONE_ID,
      TIPO_VERIFICA_DECADENZA_3_RESPONSABILE_ID,
      TIPO_VERIFICA_ALTRO_ID
    ].includes(this.verificaForm.get('fkTipoVerifica').value);
  }

  isNumeroReeVisible(): boolean {
    return this.verificaForm.get('fkTipoVerifica').value === TIPO_VERIFICA_REE_ID;
  }

  isIdentificativoDatoDistributoreVisible(): boolean {
    return this.verificaForm.get('fkTipoVerifica').value === TIPO_VERIFICA_DATO_DISTRIBUTORE_ID;
  }

  searchByCodiceImpianto(codiceImpianto: number) {
    this.loadingService.on();

    this.verificaService.getImpianto(codiceImpianto).subscribe({
      next: impianto => {
        this.verificaForm.get('codiceImpianto').setValue(codiceImpianto);

        this.impianto = impianto;

        this.loadingService.off();
      },
      error: () => {
        this.loadingService.off();
        this.alert.error({ message: 'Non esiste un impianto con il codice specificato' });
      }
    });
  }

  searchByNumeroRee(siglaRee: string, numeroRee: number) {
    this.loadingService.on();

    this.verificaService.getControllo(siglaRee, numeroRee).subscribe({
      next: controllo => {
        this.verificaForm.patchValue({
          codiceImpianto: controllo.codiceImpianto,
          siglaBollino: siglaRee,
          numeroBollino: numeroRee
        });

        this.controllo = controllo;

        this.loadingService.off();
      },
      error: () => this.loadingService.off(),
    });
  }

  searchByFkDatoDistrib(fkDatoDistrib: number) {
    this.loadingService.on();

    this.verificaService.getDistributore(fkDatoDistrib).subscribe({
      next: distributore => {
        this.verificaForm.get('fkDatoDistrib').setValue(distributore.idDatoDistri);

        this.distributore = distributore;

        this.loadingService.off();
      },
      error: () => this.loadingService.off(),
    });
  }

  getLocalizzazione(): string {
    return getIndirizzo(this.impianto);
  }

  submit() {
    if (this.verificaForm.invalid) {
      if (
        this.verificaForm.get('siglaBollino').errors?.required ||
        this.verificaForm.get('numeroBollino').errors?.required
      ) {
        this.alert.error({ message: 'Selezionare Sigla REE e Numero REE per continuare' });
      }

      if (this.verificaForm.get('codiceImpianto').errors?.required) {
        this.alert.error({ message: 'Selezionare un impianto per continuare' });
      }

      if (this.verificaForm.get('fkDatoDistrib').errors?.required) {
        this.alert.error({ message: 'Selezionare un distributore per continuare' });
      }

      return;
    }

    this.dialog.confirm('Nuova verifica', 'Confermi di voler salvare la verifica?').subscribe(result => {
      if (result) {
        this.loadingService.on();

        const value = this.verificaForm.getRawValue();
        const request = {
          ...value,
          dtCaricamento: value.dtCaricamento?.valueOf()
        };
        this.verificaService.saveVerifica(request).subscribe({
          next: (esito) => {
            this.loadingService.off();

            this.alert.success({ message: 'Verifica aggiunta con successo!', title: 'Verifica aggiunta' });
            this.router.navigate(['/', 'dettaglio-verifica', esito.idVerifica]);
          },
          error: () => this.loadingService.off(),
        });
      }
    });
  }
}
