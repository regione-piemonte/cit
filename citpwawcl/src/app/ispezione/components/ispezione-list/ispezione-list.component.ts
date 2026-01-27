import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { combineLatest } from 'rxjs';
import { LoadingService } from 'src/app/services/loading.service';
import { EXCEL_MIME_TYPE, WORD_MIME_TYPE } from 'src/app/utils/constants';
import { doDownloadFile } from 'src/app/utils/utils';
import { ComuneEsteso } from '../../models/comune-esteso.model';
import { Ispezione } from '../../models/ispezione.model';
import { StatoIspezione } from '../../models/stato-ispezione.model';
import { IspezioneService } from '../../services/ispezione.service';

@Component({
  selector: 'app-ispezione-list',
  templateUrl: './ispezione-list.component.html',
  styleUrls: ['./ispezione-list.component.scss']
})
export class IspezioneListComponent implements OnInit {
  loading = true;

  ispezioneList: Ispezione[];
  statoIspezioneList: StatoIspezione[];
  comuneEstesoList: ComuneEsteso[];

  constructor(
    private ispezioneService: IspezioneService,
    private loadingService: LoadingService,
    private router: Router
  ) {}

  ngOnInit() {
    if (!history.state.filters) {
      this.router.navigate(['/', 'cerca-ispezioni']);
      return;
    }

    combineLatest([
      this.ispezioneService.getIspezioneList(history.state.filters),
      this.ispezioneService.getStatoIspezioneList(),
      this.ispezioneService.getComuneEstesoList(),
    ]).subscribe({
      next: ([ispezioneList, statoIspezioneList, comuneEstesoList]) => {
        this.ispezioneList = ispezioneList;
        this.statoIspezioneList = statoIspezioneList;
        this.comuneEstesoList = comuneEstesoList;

        this.loading = false;
      },
      error: () => this.router.navigate(['/', 'cerca-ispezioni']),
    });
  }

  getStatoIspezione(ispezione: Ispezione): StatoIspezione {
    return this.statoIspezioneList.find(
      (si) => si.idStatoIspezione === ispezione.fkStatoIspezione
    );
  }

  getProvincia(ispezione: Ispezione): ComuneEsteso {
    return this.comuneEstesoList.find(ce => ce.codiceIstat.startsWith(ispezione.istatProvCompetenza));
  }

  getEsitoLabel(ispezione: Ispezione): string {
    switch (ispezione.flgEsito) {
      case 1:
        return 'POSITIVO';
      case 0:
        return 'NEGATIVO';
      default:
        return undefined;
    }
  }

  downloadCopertinaIspezione(ispezione: Ispezione) {
    this.loadingService.on();

    this.ispezioneService
      .downloadCopertinaIspezione(ispezione.idIspezione2018)
      .subscribe({
        next: (documento) => {
          doDownloadFile(
            documento.doc,
            `copertina-ispezione-${ispezione.idIspezione2018}.docx`,
            WORD_MIME_TYPE
          );

          this.loadingService.off();
        },
        error: () => this.loadingService.off(),
      });
  }

  downloadLetteraAvviso(ispezione: Ispezione) {
    this.loadingService.on();

    this.ispezioneService
      .downloadLetteraAvviso(ispezione.idIspezione2018)
      .subscribe({
        next: (documento) => {
          doDownloadFile(
            documento.doc,
            `lettera-avviso-${ispezione.idIspezione2018}.docx`,
            WORD_MIME_TYPE
          );

          this.loadingService.off();
        },
        error: () => this.loadingService.off(),
      });
  }

  downloadLetteraAvviso180Gg(ispezione: Ispezione) {
    this.loadingService.on();

    this.ispezioneService
      .downloadLetteraAvviso180Gg(ispezione.idIspezione2018)
      .subscribe({
        next: (documento) => {
          doDownloadFile(
            documento.doc,
            `lettera-avviso-180-gg-${ispezione.idIspezione2018}.docx`,
            WORD_MIME_TYPE
          );

          this.loadingService.off();
        },
        error: () => this.loadingService.off(),
      });
  }

  downloadFileExcel() {
    this.loadingService.on();

    const ids = this.ispezioneList.map(i => i.idIspezione2018);
    this.ispezioneService
      .downloadFileExcel(ids)
      .subscribe({
        next: (documento) => {
          doDownloadFile(
            documento.doc,
            'elencoIspezioni.xls',
            EXCEL_MIME_TYPE
          );

          this.loadingService.off();
        },
        error: () => this.loadingService.off(),
      });
  }

  /* downloadExcel() {
    const aoa = [
      [
        'idIspezione2018',
        'fkStatoIspezione',
        'desStatoIspezione',
        'fkAccertamento',
        'fkVerifica',
        'codiceImpianto',
        'cfUtenteAssegn',
        'denomUtenteAssegn',
        'cfIspettoreSecondario',
        'enteCompetente',
        'flgEsito',
        'dtSveglia',
        'noteSveglia',
        'note',
        'istatProvCompetenza',
        'flgAccSostitutivo',
        'dtCreazione',
        'dtConclusione',
        'flgIspPagamento',
        'istatComuneCompetenza',
        'empty'
      ],
      ...this.ispezioneList.map(i => [
        i.idIspezione2018,
        i.fkStatoIspezione,
        i.desStatoIspezione,
        i.fkAccertamento,
        i.fkVerifica,
        i.codiceImpianto,
        i.cfUtenteAssegn,
        i.denomUtenteAssegn,
        i.cfIspettoreSecondario,
        i.enteCompetente,
        i.flgEsito,
        i.dtSveglia,
        i.noteSveglia,
        i.note,
        i.istatProvCompetenza,
        i.flgAccSostitutivo,
        i.dtCreazione,
        i.dtConclusione,
        i.flgIspPagamento,
        i.istatComuneCompetenza,
        i.empty
      ])
    ];

    const ws = XLSX.utils.aoa_to_sheet(aoa);

    const wb = XLSX.utils.book_new();
    XLSX.utils.book_append_sheet(wb, ws);

    XLSX.writeFile(wb, `ispezioni-${Date.now()}.xlsx`);
  } */
}
