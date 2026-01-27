import { Injectable } from '@angular/core';
import { SaveRapprovaWeb } from '../models/save-rapprova-web.model';

export interface RapprovaPendingOp {
  op: 'INVIA' | 'SALVA_INVIA' | 'ELIMINA';
  idAllegato: string | number;
  idIspezione2018: number;
  dataRapportoDiProva: number;
  saveRapprovaWeb?: SaveRapprovaWeb;
  dataInserimento?: number;
  dataInvioOnline?: number;
}

const KEY = 'RAPPROVA_PENDING_OP_LIST';

@Injectable({
  providedIn: 'root',
})
export class RapprovaPendingOpService {
  getList(): RapprovaPendingOp[] {
    const json = localStorage.getItem(KEY);
    return json ? JSON.parse(json) : [];
  }

  getUndoneList(): RapprovaPendingOp[] {
    return this.getList().filter(o => !o.dataInvioOnline);
  }

  private setList(list: RapprovaPendingOp[]): void {
    const json = JSON.stringify(list);
    localStorage.setItem(KEY, json);
    document.dispatchEvent(new Event('rapprovaPendingOpListChanged'));
  }

  cancelByIdAllegato(idAllegato: string | number): void {
    const filteredList = this.getList().filter(o => o.idAllegato !== idAllegato);
    this.setList(filteredList);
  }

  getByIdAllegato(idAllegato: string | number): RapprovaPendingOp {
    return this.getList().find((r) => r.idAllegato === idAllegato);
  }

  add(pendingOp: RapprovaPendingOp): void {
    const newList = [...this.getList(), { ...pendingOp, dataInserimento: Date.now() }];
    this.setList(newList);
  }

  markDoneByIdAllegato(idAllegato: string | number): void {
    const list = this.getList();
    list.find(o => o.idAllegato === idAllegato).dataInvioOnline = Date.now();
    this.setList(list);
  }
}
