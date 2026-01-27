import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import moment from 'moment';
import { combineLatest } from 'rxjs';
import { map, switchMap } from 'rxjs/operators';
import { zeroToNull } from 'src/app/pipe/zero-to-null.pipe';
import { AlertService } from 'src/app/services/alert.service';
import { AuthenticationService } from 'src/app/services/authentication.service';
import { DialogService } from 'src/app/services/dialog.service';
import { LoadingService } from 'src/app/services/loading.service';
import { PROVINCE_PIEMONTESI, STATO_ISPEZIONE_BOZZA_ID } from 'src/app/utils/constants';
import { VerificaDetail } from 'src/app/verifica/models/verifica-detail.model';
import { VerificaService } from 'src/app/verifica/services/verifica.service';
import { getIndirizzo } from 'src/app/verifica/utils/verifica-utils';
import { ComuneEsteso } from '../../models/comune-esteso.model';
import { Ispettore } from '../../models/ispettore.model';
import { StatoIspezione } from '../../models/stato-ispezione.model';
import { IspezioneService } from '../../services/ispezione.service';

@Component({
  selector: 'app-ispezione-add',
  templateUrl: './ispezione-add.component.html',
  styleUrls: ['./ispezione-add.component.scss']
})
export class IspezioneAddComponent implements OnInit {
  loading = true;

  ispettoreList: Ispettore[];
  statoIspezioneList: StatoIspezione[];
  provinciaList: ComuneEsteso[];
  comuneEstesoList: ComuneEsteso[];
  verifica: VerificaDetail;

  ispezioneForm: FormGroup;

  constructor(
    private verificaService: VerificaService,
    private ispezioneService: IspezioneService,
    private fb: FormBuilder,
    private route: ActivatedRoute,
    private loadingService: LoadingService,
    private router: Router,
    private dialog: DialogService,
    private alert: AlertService,
    private authenticationService: AuthenticationService
  ) {}

  ngOnInit() {
    combineLatest([
      this.ispezioneService.getIspettoreList(),
      this.ispezioneService.getStatoIspezioneList(),
      this.ispezioneService.getComuneEstesoList(),
      this.route.paramMap.pipe(
        map((paramMap) => Number(paramMap.get('id'))),
        switchMap((id) => this.verificaService.getVerificaDetail(id))
      ),
    ]).subscribe(
      ([
        ispettoreList,
        statoIspezioneList,
        comuneEstesoList,
        verifica,
      ]) => {
        const comuniPiemontesi = comuneEstesoList.filter(c => PROVINCE_PIEMONTESI.includes(c.siglaProvincia));
        const user = this.authenticationService.getCurrentUserFromSession();

        this.ispettoreList = ispettoreList
          .filter(i => !i.dataFine || i.dataFine > Date.now())
          .reduce<Ispettore[]>((a, c) => a.some(x => x.codicefiscale === c.codicefiscale) ? a : [...a, c], [])
          .sort((a, b) => `${a.cognome} ${a.nome}`.localeCompare(`${b.cognome} ${b.nome}`));
        this.statoIspezioneList = statoIspezioneList;
        this.provinciaList = comuniPiemontesi
          .reduce<ComuneEsteso[]>((a, c) => a.some(x => x.idProvincia === c.idProvincia) ? a : [...a, c], [])
          .sort((a, b) => a.provincia.localeCompare(b.provincia));
        this.comuneEstesoList = comuniPiemontesi;
        this.verifica = verifica;

        const istatProvCompetenzaValue = verifica.codiceImpianto ? verifica.istatComune.substring(0, 3) : user.ruoloLoggato.istatAbilitazione?.substring(2, 5);
        const istatComuneCompetenzaValue = verifica.codiceImpianto ? verifica.istatComune : user.ruoloLoggato.istatAbilitazione?.substring(2, 8);
        const isIstatProvCompetenzaDisabled = verifica.codiceImpianto || user.ruoloLoggato.istatAbilitazione?.length >= 5;
        const isIstatComuneCompetenzaDisabled = verifica.codiceImpianto || user.ruoloLoggato.istatAbilitazione?.length === 8;

        this.ispezioneForm = this.fb.group({
          idIspezione2018: [{ value: null, disabled: true }],
          dtCreazione: [
            {
              value: moment(),
              disabled: true,
            },
          ],
          cfUtenteAssegn: [{ value: null, disabled: true }],
          fkStatoIspezione: [
            { value: STATO_ISPEZIONE_BOZZA_ID, disabled: true },
          ],
          codiceImpianto: [
            { value: zeroToNull(verifica.codiceImpianto), disabled: true },
          ],
          indirizzo: [{ value: getIndirizzo(verifica), disabled: true }],
          istatProvCompetenza: [{ value: istatProvCompetenzaValue, disabled: isIstatProvCompetenzaDisabled }, Validators.required],
          istatComuneCompetenza: [{ value: istatComuneCompetenzaValue, disabled: isIstatComuneCompetenzaDisabled }, Validators.required],
          flgIspPagamento: [null],
          note: [null],
        });

        this.loading = false;
      }
    );
  }

  getComuneEstesoListByProvincia(): ComuneEsteso[] {
    const istatProvCompetenza = this.ispezioneForm.get('istatProvCompetenza').value;
    return this.comuneEstesoList.filter(c => c.codiceIstat.startsWith(istatProvCompetenza));
  }

  submit() {
    if (this.ispezioneForm.invalid) {
      return;
    }

    this.dialog
      .confirm(
        'Nuova ispezione',
        "Confermi di voler salvare l'ispezione?"
      )
      .subscribe((result) => {
        if (result) {
          this.loadingService.on();

          const value = this.ispezioneForm.getRawValue();
          const request = {
            ...value,
            dtCreazione: value.dtCreazione?.valueOf(),
            fkVerifica: this.verifica.idVerifica,
            flgIspPagamento: Number(value.flgIspPagamento)
          };
          this.ispezioneService.saveIspezione(request).subscribe({
            next: (esito) => {
              this.loadingService.off();

              this.alert.success({ message: 'Ispezione aggiunta con successo!', title: 'Ispezione aggiunta' });
              this.router.navigate(['/', 'dettaglio-ispezione', esito.idIspezione2018]);
            },
            error: () => this.loadingService.off(),
          });
        }
      });
  }
}
