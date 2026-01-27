import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import moment from 'moment';
import { combineLatest } from 'rxjs';
import { map, switchMap } from 'rxjs/operators';
import { datiPrecompilatiToInfoBox, ImpiantoInfoBox } from 'src/app/common/components/impianto-info-box/impianto-info-box.component';
import { Ispezione } from 'src/app/ispezione/models/ispezione.model';
import { IspezioneService } from 'src/app/ispezione/services/ispezione.service';
import { RapprovaService } from '../../services/rapprova.service';
import { forceArray } from '../../utils/rapprova-utils';

@Component({
  selector: 'app-rapprova-add',
  templateUrl: './rapprova-add.component.html',
})
export class RapprovaAddComponent implements OnInit {
  loading = true;

  idIspezione2018: number;

  ispezione: Ispezione;

  searchForm: FormGroup;

  datiImpianto: ImpiantoInfoBox;

  tipoCombustibile: any[];
  tipoRapportoDiProva = [
    { codice: 8, descrizione: 'Rapporto Prova GT' },
    { codice: 9, descrizione: 'Rapporto Prova GF' },
  ];

  dataRapProvaMax = moment();

  constructor(
    private ispezioneService: IspezioneService,
    private rapprovaService: RapprovaService,
    private fb: FormBuilder,
    private router: Router,
    private route: ActivatedRoute
  ) {}

  ngOnInit(): void  {
    this.route.paramMap.subscribe(paramMap => {
      this.idIspezione2018 = Number(paramMap.get('id'));

      combineLatest([
        this.ispezioneService
          .getIspezioneDetail(this.idIspezione2018)
          .pipe(
            switchMap((ispezione) =>
              this.rapprovaService
                .getLibretto(ispezione.codiceImpianto)
                .pipe(map((libretto) => [ispezione, libretto]))
            )
          )
      ]).subscribe(([[ispezione, libretto]]) => {
        const datiPrecompilati = libretto.MOD.Richiesta.datiPrecompilati;

        this.tipoCombustibile = forceArray(datiPrecompilati.elencoCombustibile.combustibile);
        this.ispezione = ispezione;
        this.datiImpianto = datiPrecompilatiToInfoBox(datiPrecompilati);

        this.searchForm = this.fb.group({
          dataRapProva: [null, Validators.required],
          oraRapProva: [null, Validators.required],
          tipoRapportoDiProva: [null, Validators.required],
          tipoCombustibile: [null]
        });

        this.loading = false;
      });
    });
  }

  cercaRapProva() {
    const value = this.searchForm.value;
    const filters = {
      ...value,
      dataRapProva: value.dataRapProva.valueOf(),
    };
    this.router.navigate(
      ['/', 'dettaglio-ispezione', this.ispezione?.idIspezione2018, 'nuovo-rapprova', 'step-2'],
      { state: { codiceImpianto: this.ispezione.codiceImpianto, filters } }
    );
  }
}
