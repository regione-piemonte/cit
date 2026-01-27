import { Injectable } from '@angular/core';
import { combineLatest, Observable, of } from 'rxjs';
import { tap } from 'rxjs/operators';
import { LoadingService } from 'src/app/services/loading.service';
import { RapprovaLocaleService } from './rapprova-locale.service';
import { RapprovaPendingOp, RapprovaPendingOpService } from './rapprova-pending-op.service';
import { RapprovaService } from './rapprova.service';

const INITIAL_DELAY_MS = 2000;
const INTERVAL_MS = 2000;

@Injectable({
  providedIn: 'root'
})
export class RapprovaWorkerService {
  constructor(
    private rapprovaPendingOpService: RapprovaPendingOpService,
    private rapprovaService: RapprovaService,
    private rapprovaLocaleService: RapprovaLocaleService,
    private loadingService: LoadingService
  ) {}

  init(): void {
    setTimeout(() => this.work(), INITIAL_DELAY_MS);
  }

  private salvaInvia(pendingOp: RapprovaPendingOp): Observable<any> {
    const request = typeof pendingOp.idAllegato === 'string'
      ? this.rapprovaLocaleService.getRapprovaLocale(pendingOp.idAllegato)
      : pendingOp.saveRapprovaWeb;
    return this.rapprovaService
      .saveRapprovaWeb(request)
      .pipe(
        tap(() => {
          if (typeof pendingOp.idAllegato === 'string') {
            this.rapprovaLocaleService.deleteRapprovaLocale(pendingOp.idAllegato)
          }
        })
      );
  }

  private elimina(pendingOp: RapprovaPendingOp): Observable<any> {
    return typeof pendingOp.idAllegato === 'string'
      ? of(this.rapprovaLocaleService.deleteRapprovaLocale(pendingOp.idAllegato))
      : this.rapprovaService.deleteRapprova(pendingOp.idAllegato, pendingOp.idIspezione2018);
  }

  private hub(pendingOp: RapprovaPendingOp): Observable<any> {
    switch (pendingOp.op) {
      case 'INVIA':
        return of(null);
      case 'SALVA_INVIA':
        return this.salvaInvia(pendingOp);
      case 'ELIMINA':
        return this.elimina(pendingOp);
    }
  }

  private work(): void {
    const pendingOpList = this.rapprovaPendingOpService.getUndoneList();

    if (!pendingOpList.length || !navigator.onLine) {
      setTimeout(() => this.work(), INTERVAL_MS);
      return;
    }

    this.loadingService.on();

    const obs = pendingOpList.map(pendingOp =>
      this.hub(pendingOp).pipe(tap(() => this.rapprovaPendingOpService.markDoneByIdAllegato(pendingOp.idAllegato))));

    combineLatest(obs).subscribe({
      next: () => {
        this.loadingService.off();

        setTimeout(() => this.work(), INTERVAL_MS);
      },
      error: () => {
        this.loadingService.off();

        setTimeout(() => this.work(), INTERVAL_MS);
      }
    });
  }
}
