import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { combineLatest } from 'rxjs';
import { AlertService } from 'src/app/services/alert.service';
import { AuthenticationService } from 'src/app/services/authentication.service';
import { PROVINCE_PIEMONTESI, RUOLI, RUOLO_PA_ISPETTORE_ID } from 'src/app/utils/constants';
import { Assegnatario } from 'src/app/verifica/models/assegnatario.model';
import { VerificaService } from 'src/app/verifica/services/verifica.service';
import { ComuneEsteso } from '../../models/comune-esteso.model';
import { StatoIspezione } from '../../models/stato-ispezione.model';
import { IspezioneService } from '../../services/ispezione.service';

@Component({
  selector: 'app-ispezione-search',
  templateUrl: './ispezione-search.component.html',
  styleUrls: ['./ispezione-search.component.scss'],
})
export class IspezioneSearchComponent implements OnInit {
  loading = true;

  assegnatarioList: Assegnatario[];
  statoIspezioneList: StatoIspezione[];
  provinciaList: ComuneEsteso[];
  comuneEstesoList: ComuneEsteso[];

  searchForm: FormGroup;

  constructor(
    private verificaService: VerificaService,
    private ispezioneService: IspezioneService,
    private fb: FormBuilder,
    private router: Router,
    private alert: AlertService,
    private authenticationService: AuthenticationService
  ) {}

  ngOnInit() {
    combineLatest([
      this.verificaService.getAssegnatarioList(),
      this.ispezioneService.getStatoIspezioneList(),
      this.ispezioneService.getComuneEstesoList()
    ]).subscribe(([assegnatarioList, statoIspezioneList, comuneEstesoList]) => {
      const user = this.authenticationService.getCurrentUserFromSession();
      const assegnatari = assegnatarioList
        .filter(a => a.idRuoloPa === RUOLO_PA_ISPETTORE_ID)
        .reduce<Assegnatario[]>((a, c) => a.some(x => x.codicefiscale === c.codicefiscale) ? a : [...a, c], []);
      const comuniPiemontesi = comuneEstesoList.filter(c => PROVINCE_PIEMONTESI.includes(c.siglaProvincia));

      this.assegnatarioList = assegnatari.sort((a, b) => `${a.cognome} ${a.nome}`.localeCompare(`${b.cognome} ${b.nome}`));
      this.statoIspezioneList = statoIspezioneList;
      this.provinciaList = comuniPiemontesi
        .reduce<ComuneEsteso[]>((a, c) => a.some(x => x.idProvincia === c.idProvincia) ? a : [...a, c], [])
        .sort((a, b) => a.provincia.localeCompare(b.provincia));
      this.comuneEstesoList = comuniPiemontesi;

      const cfUtenteAssegn = assegnatari.find(a => a.codicefiscale === user.pfLoggato.codiceFiscalePF)?.codicefiscale;
      const isIstatProvCompetenzaDisabled = [RUOLI.RUOLO_CONSULTATORE, RUOLI.RUOLO_VALIDATORE, RUOLI.RUOLO_ISPETTORE].includes(user.ruoloLoggato.ruolo) && [5, 8].includes(user.ruoloLoggato.istatAbilitazione?.length);
      const istatProvCompetenza = isIstatProvCompetenzaDisabled ? user.ruoloLoggato.istatAbilitazione.substring(2, 5) : null;
      const isIstatComuneCompetenzaDisabled = [RUOLI.RUOLO_CONSULTATORE, RUOLI.RUOLO_VALIDATORE, RUOLI.RUOLO_ISPETTORE].includes(user.ruoloLoggato.ruolo) && user.ruoloLoggato.istatAbilitazione?.length === 8;
      const istatComuneCompetenza = isIstatComuneCompetenzaDisabled ? user.ruoloLoggato.istatAbilitazione.substring(2) : null;

      this.searchForm = this.fb.group({
        idIspezione2018: [null],
        cfUtenteAssegn: [cfUtenteAssegn],
        dtCreazioneDa: [null],
        dtCreazioneA: [null],
        dtConclusioneDa: [null],
        dtConclusioneA: [null],
        fkStatoIspezione: [null],
        flgEsito: [null],
        codiceImpianto: [null],
        nonAssegnato: [null],
        istatProvCompetenza: [{ value: istatProvCompetenza, disabled: isIstatProvCompetenzaDisabled }],
        istatComuneCompetenza: [{ value: istatComuneCompetenza, disabled: isIstatComuneCompetenzaDisabled }],
        flgIspPagamento: [null],
      });

      this.loading = false;
    });
  }

  getComuneEstesoListByProvincia(): ComuneEsteso[] {
    const istatProvCompetenza = this.searchForm.get('istatProvCompetenza').value;
    return this.comuneEstesoList.filter(c => c.codiceIstat.startsWith(istatProvCompetenza));
  }

  submit() {
    const value = this.searchForm.getRawValue();

    if (Object.values(value).every(v => v === null || v === undefined || v === false)) {
      this.alert.warn({ message: 'Impostare almeno un criterio di ricerca' });
      return;
    }

    const filters = {
      ...value,
      dtCreazioneDa: value.dtCreazioneDa?.valueOf(),
      dtCreazioneA: value.dtCreazioneA?.valueOf(),
      dtConclusioneDa: value.dtConclusioneDa?.valueOf(),
      dtConclusioneA: value.dtConclusioneA?.valueOf(),
      flgIspPagamento: value.flgIspPagamento ? 1 : null
    };
    this.router.navigate(['/', 'lista-ispezioni'], {
      fragment: 'fresh',
      state: { filters },
    });
  }
}
