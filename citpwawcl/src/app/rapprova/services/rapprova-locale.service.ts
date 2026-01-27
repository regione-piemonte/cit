import { Injectable } from '@angular/core';
import { RapprovaLocale } from '../models/rapprova-locale.model';

const KEY = 'RAPPROVA_LOCALE_LIST';

@Injectable({
  providedIn: 'root',
})
export class RapprovaLocaleService {
  private getRapprovaLocaleList(): RapprovaLocale[] {
    const json = localStorage.getItem(KEY);
    return json ? JSON.parse(json) : [];
  }

  getRapprovaLocaleListByIdIspezione2018OrderByDataControllo(idIspezione2018: number): RapprovaLocale[] {
    const list = this.getRapprovaLocaleList();
    return list
      .filter((r) => r.idIspezione2018 === idIspezione2018)
      .sort((a, b) => a.datiRapProva.dataControllo - b.datiRapProva.dataControllo);
  }

  getRapprovaLocale(localId: string): RapprovaLocale {
    const list = this.getRapprovaLocaleList();
    return list.find((r) => r.localId === localId);
  }

  private setRapprovaLocaleList(rapprovaLocaleList: RapprovaLocale[]): void {
    const json = JSON.stringify(rapprovaLocaleList);
    localStorage.setItem(KEY, json);
  }

  private insertRapprovaLocale(rapprovaLocale: RapprovaLocale): RapprovaLocale {
    const withId = { ...rapprovaLocale, localId: (crypto as any).randomUUID() };
    const list = this.getRapprovaLocaleList();
    const newList = [...list, withId];
    this.setRapprovaLocaleList(newList);
    return withId;
  }

  private updateRapprovaLocale(rapprovaLocale: RapprovaLocale): RapprovaLocale {
    const list = this.getRapprovaLocaleList();
    const filteredList = list.filter((r) => r.localId !== rapprovaLocale.localId);
    const newList = [...filteredList, rapprovaLocale];
    this.setRapprovaLocaleList(newList);
    return rapprovaLocale;
  }

  saveRapprovaLocale(rapprovaLocale: RapprovaLocale): RapprovaLocale {
    if (rapprovaLocale.localId) {
      return this.updateRapprovaLocale(rapprovaLocale);
    }

    return this.insertRapprovaLocale(rapprovaLocale);
  }

  deleteRapprovaLocale(localId: string): void {
    const list = this.getRapprovaLocaleList();
    const filteredList = list.filter((r) => r.localId !== localId);
    this.setRapprovaLocaleList(filteredList);
  }
}
