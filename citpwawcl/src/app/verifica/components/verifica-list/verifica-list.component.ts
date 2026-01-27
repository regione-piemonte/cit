import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { combineLatest } from 'rxjs';
import { OnReuse } from 'src/app/custom-reuse-strategy';
import { DialogService } from 'src/app/services/dialog.service';
import { LoadingService } from 'src/app/services/loading.service';
import { Assegnatario } from '../../models/assegnatario.model';
import { SearchVerifica } from '../../models/search-verifica.model';
import { TipoVerifica } from '../../models/tipo-verifica.model';
import { Verifica } from '../../models/verifica.model';
import { VerificaService } from '../../services/verifica.service';

@Component({
  selector: 'app-verifica-list',
  templateUrl: './verifica-list.component.html',
  styleUrls: ['./verifica-list.component.scss'],
})
export class VerificaListComponent implements OnInit, OnReuse {
  loading = true;

  searchVerifica: SearchVerifica;
  assegnatarioList: Assegnatario[];
  tipoVerificaList: TipoVerifica[];
  verificaList: Verifica[];

  constructor(
    private verificaService: VerificaService,
    private loadingService: LoadingService,
    private dialog: DialogService,
    private router: Router
  ) {}

  ngOnInit() {
    if (!history.state.filters) {
      this.router.navigate(['/', 'cerca-verifiche']);
      return;
    }

    this.searchVerifica = history.state.filters;

    combineLatest([
      this.verificaService.getAssegnatarioList(),
      this.verificaService.getTipoVerificaList(),
      this.verificaService.getVerificaList(this.searchVerifica),
    ]).subscribe({
      next: ([assegnatarioList, tipoVerificaList, verificaList]) => {
        this.assegnatarioList = assegnatarioList;
        this.tipoVerificaList = tipoVerificaList;
        this.verificaList = verificaList;

        this.loading = false;
      },
      error: () => this.router.navigate(['/', 'cerca-verifiche']),
    });
  }

  citOnReuse() {
    this.refresh();
  }

  getAssegnatario(verifica: Verifica): Assegnatario {
    return this.assegnatarioList.find(
      (a) => a.codicefiscale === verifica.cfUtenteCaricamento
    );
  }

  getTipoVerifica(verifica: Verifica): TipoVerifica {
    return this.tipoVerificaList.find(
      (tv) => tv.id === verifica.fkTipoVerifica
    );
  }

  private refresh() {
    this.loading = true;

    this.verificaService
      .getVerificaList(this.searchVerifica)
      .subscribe((verificaList) => {
        this.verificaList = verificaList;

        this.loading = false;
      });
  }

  deleteVerificaConfirm(verifica: Verifica) {
    this.dialog
      .confirm('Cancella verifica', 'Confermi di voler procedere?')
      .subscribe((result) => {
        if (result) {
          this.loadingService.on();

          this.verificaService.deleteVerifica(verifica.idVerifica).subscribe({
            next: () => {
              this.loadingService.off();

              this.dialog.alert('Verifica cancellata', 'Operazione effettuata con successo!');

              this.refresh();
            },
            error: () => this.loadingService.off(),
          });
        }
      });
  }
}
