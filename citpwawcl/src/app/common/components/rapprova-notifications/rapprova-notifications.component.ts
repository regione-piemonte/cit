import { Component, HostListener, OnInit } from '@angular/core';
import { RapprovaPendingOp, RapprovaPendingOpService } from 'src/app/rapprova/services/rapprova-pending-op.service';

@Component({
  selector: 'app-rapprova-notifications',
  templateUrl: './rapprova-notifications.component.html',
  styleUrls: ['./rapprova-notifications.component.scss']
})
export class RapprovaNotificationsComponent implements OnInit {
  pendingOps: RapprovaPendingOp[] = [];

  constructor(private rapprovaPendingOpService: RapprovaPendingOpService) {}

  ngOnInit(): void {
    this.pendingOps = this.rapprovaPendingOpService.getList();
  }

  @HostListener('document:rapprovaPendingOpListChanged')
  onRapprovaPendingOpListChanged(): void {
    this.pendingOps = this.rapprovaPendingOpService.getList();
  }

  pendingOpTrackByFn(_index: number, pendingOp: RapprovaPendingOp): number | string {
    return pendingOp.idAllegato;
  }

  getAttivita(pendingOp: RapprovaPendingOp): string {
    switch (pendingOp.op) {
      case 'INVIA':
        return 'INVIO';
      case 'SALVA_INVIA':
        return 'SALVATAGGIO E INVIO';
      case 'ELIMINA':
        return 'ELIMINA';
    }
  }

  cancelRapprovaPendingOp(pendingOp: RapprovaPendingOp): void {
    this.rapprovaPendingOpService.cancelByIdAllegato(pendingOp.idAllegato);
  }
}
