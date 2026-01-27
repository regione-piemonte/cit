import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import moment from 'moment';
import { combineLatest } from 'rxjs';
import { datiPrecompilatiToInfoBox, ImpiantoInfoBox } from 'src/app/common/components/impianto-info-box/impianto-info-box.component';
import { GroupChip } from '../../models/group-chip.model';
import { RapprovaService } from '../../services/rapprova.service';
import { forceArray } from '../../utils/rapprova-utils';
import { AlertService } from 'src/app/services/alert.service';

export function filterGf(gfList: any, filters: any): any[] {
  return forceArray(gfList).filter(row => !row.L4_4dataDismiss);
}

export function filterGt(gtList: any, filters: any): any[] {
  return forceArray(gtList)
    .filter(row =>
      (!filters.tipoCombustibile || row.L4_1combustibile === filters.tipoCombustibile) &&
      !row.L4_1dataDismiss
    );
}

export function gfToChip(gf: any, fabbricanteList: any[]): GroupChip {
  return {
    fabbricante: fabbricanteList.find(f => f.codice === gf.L4_4fabbricante)?.descrizione,
    modello: gf.L4_4modello,
    tipologia: 'frigo',
    num: gf.L4_4numGF,
    dataInstall: moment(gf.L4_4dataInstallaz).valueOf()
  };
}

export function gtToChip(gt: any, fabbricanteList: any[], combustibileList: any[]): GroupChip {
  return {
    fabbricante: fabbricanteList.find(f => f.codice === gt.L4_1fabbricante)?.descrizione,
    modello: gt.L4_1modello,
    tipologia: 'termici',
    num: gt.L4_1numGT,
    dataInstall: moment(gt.L4_1dataInstallaz).valueOf(),
    combustibile: combustibileList.find(c => c.codice === gt.L4_1combustibile)?.descrizione
  };
}

@Component({
  selector: 'app-rapprova-add-step2',
  templateUrl: './rapprova-add-step2.component.html',
  styleUrls: ['./rapprova-add-step2.component.scss']
})
export class RapprovaAddStep2Component implements OnInit {
  state = history.state;
  loading = true;
  idIspezione2018: number;
  impiantoInfoBox: ImpiantoInfoBox;
  chips: GroupChip[];
  selectedChip: GroupChip;

  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private rapprovaService: RapprovaService,
    private alert: AlertService,
  ) {}

  ngOnInit(): void {
    this.route.paramMap.subscribe(paramMap => {
      this.idIspezione2018 = Number(paramMap.get('id'));
  
      if (!this.state.filters || !this.state.codiceImpianto) {
        this.router.navigate(['/', 'dettaglio-ispezione', this.idIspezione2018, 'nuovo-rapprova', 'step-1']);
        return;
      }
  
      combineLatest([
        this.rapprovaService.getLibretto(this.state.codiceImpianto),
      ])
      .subscribe(([libretto]) => {
        const richiesta = libretto.MOD.Richiesta;
        const datiPrecompilati = richiesta.datiPrecompilati;
        const fabbricanteList = forceArray(datiPrecompilati.elencoFabbricante.fabbricante);
        const combustibileList = forceArray(datiPrecompilati.elencoCombustibile.combustibile);
  
        const tipoRapporto = this.state.filters.tipoRapportoDiProva;
  
        if (tipoRapporto === 8) {
          const sezGT = richiesta.datiSchedaGT?.sezGruppiTermici;
          if (!sezGT) {
            this.loading = false;
            this.impiantoInfoBox = datiPrecompilatiToInfoBox(datiPrecompilati);
            return;
          }
          this.chips = filterGt(sezGT.rowGT, this.state.filters).map(gt => gtToChip(gt, fabbricanteList, combustibileList));
        } else {
          const sezGF = richiesta.datiSchedaGF?.sezGF;
          if (!sezGF) {
            this.loading = false;
            this.impiantoInfoBox = datiPrecompilatiToInfoBox(datiPrecompilati);
            return;
          }
          this.chips = filterGf(sezGF.rowGF, this.state.filters).map(gf => gfToChip(gf, fabbricanteList));
        }
  
        this.impiantoInfoBox = datiPrecompilatiToInfoBox(datiPrecompilati);
        this.loading = false;
      });
    });
  }

  groupChipClick(chip: GroupChip): void{
    this.selectedChip = chip;
  }

  uploadScansione(): void {
    this.router.navigate(
      ['/', 'dettaglio-ispezione', this.idIspezione2018, 'nuovo-rapprova', 'step-3-upload'],
      { state: { ...this.state, selectedChip: this.selectedChip } }
    );
  }

  rapprovaWeb(): void {
    const step3 = this.state.filters.tipoRapportoDiProva === 8 ? 'step-3-gt' : 'step-3-gf';
    this.router.navigate(
      ['/', 'dettaglio-ispezione', this.idIspezione2018, 'nuovo-rapprova', step3],
      { state: { ...this.state, selectedChipNum: this.selectedChip.num } }
    );
  }
}
