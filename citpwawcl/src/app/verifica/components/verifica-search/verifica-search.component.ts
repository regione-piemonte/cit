import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { combineLatest } from 'rxjs';
import { AlertService } from 'src/app/services/alert.service';
import { AuthenticationService } from 'src/app/services/authentication.service';
import { RUOLI, RUOLO_PA_CONSULTATORE_ID, RUOLO_PA_ISPETTORE_ID, RUOLO_PA_VALIDATORE_ID } from 'src/app/utils/constants';
import { Assegnatario } from '../../models/assegnatario.model';
import { TipoVerifica } from '../../models/tipo-verifica.model';
import { VerificaService } from '../../services/verifica.service';
import { siglaReeCompareFn } from '../../utils/verifica-utils';

@Component({
  selector: 'app-verifica-search',
  templateUrl: './verifica-search.component.html',
  styleUrls: ['./verifica-search.component.scss'],
})
export class VerificaSearchComponent implements OnInit {
  loading = true;

  assegnatarioList: Assegnatario[];
  tipoVerificaList: TipoVerifica[];
  siglaReeList: string[];

  searchForm: FormGroup;

  constructor(
    private verificaService: VerificaService,
    private fb: FormBuilder,
    private router: Router,
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
      const assegnatari = assegnatarioList
        .filter(a => [RUOLO_PA_CONSULTATORE_ID, RUOLO_PA_ISPETTORE_ID, RUOLO_PA_VALIDATORE_ID].includes(a.idRuoloPa))
        .reduce<Assegnatario[]>((a, c) => a.some(x => x.codicefiscale === c.codicefiscale) ? a : [...a, c], []);

      this.assegnatarioList = assegnatari.sort((a, b) => `${a.cognome} ${a.nome}`.localeCompare(`${b.cognome} ${b.nome}`));
      this.tipoVerificaList = tipoVerificaList;
      this.siglaReeList = siglaReeList.sort(siglaReeCompareFn);

      const cfUtenteCaricamento = assegnatari.find(a => a.codicefiscale === user.pfLoggato.codiceFiscalePF)?.codicefiscale;
      const isCfUtenteCaricamentoDisabled = [RUOLI.RUOLO_CONSULTATORE, RUOLI.RUOLO_VALIDATORE, RUOLI.RUOLO_ISPETTORE].includes(user.ruoloLoggato.ruolo) && [5, 8].includes(user.ruoloLoggato.istatAbilitazione?.length);

      this.searchForm = this.fb.group({
        idVerifica: [null],
        cfUtenteCaricamento: [{ value: cfUtenteCaricamento, disabled: isCfUtenteCaricamentoDisabled }],
        dtCaricamentoDa: [null],
        dtCaricamentoA: [null],
        fkTipoVerifica: [null],
        codiceImpianto: [null],
        siglaRee: [null],
        numeroRee: [null],
        fkDatoDistrib: [null],
      });

      this.loading = false;
    });
  }

  submit() {
    const value = this.searchForm.getRawValue();

    if (Object.values(value).every(v => v === null || v === undefined || v === false)) {
      this.alert.warn({ message: 'Impostare almeno un criterio di ricerca' });
      return;
    }

    if (value.siglaRee && !value.numeroRee || value.numeroRee && !value.siglaRee) {
      this.alert.warn({ message: 'Indicare sia la sigla bollino sia il numero bollino' });
      return;
    }

    const filters = {
      ...value,
      dtCaricamentoDa: value.dtCaricamentoDa?.valueOf(),
      dtCaricamentoA: value.dtCaricamentoA?.valueOf(),
    };
    this.router.navigate(['/', 'lista-verifiche'], {
      fragment: 'fresh',
      state: { filters },
    });
  }
}
