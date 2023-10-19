import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { DatiControlloModel } from '../models/dati-controllo-model';
import { DatoControlloModel } from '../models/dato-controllo-model';
import { OperazioneControlloModel } from '../models/operazione-controllo-model';


@Injectable({
  providedIn: 'root'
})
export class LocalStorageServiceService {

  subjectControllo = new BehaviorSubject<DatiControlloModel>(new DatiControlloModel());
  subjectOperazioni = new BehaviorSubject<OperazioneControlloModel[]>(null);

  constructor() {
  }

  getControllo(): DatiControlloModel {
    const serializedTasks = localStorage.getItem("controlli");
    return JSON.parse(serializedTasks) as DatiControlloModel;
  }

  getOperazioni(): OperazioneControlloModel[] {
    const serializedTasks = localStorage.getItem("operazioni");
    return (serializedTasks)
      ? JSON.parse(serializedTasks)
      : [];
  }

  setOperazioni(operazione: OperazioneControlloModel[]) {
    localStorage.setItem("operazioni", JSON.stringify(operazione));
    this.subjectOperazioni.next(operazione);
  }

  setControlli(controlli: DatoControlloModel[]) {
    const serializedTasks = localStorage.getItem("controlli");
    let dati: DatiControlloModel = JSON.parse(serializedTasks) as DatiControlloModel;
    dati.controlli = controlli;
    localStorage.setItem("controlli", JSON.stringify(dati));
  }

  setDatiControllo(datiControllo: DatiControlloModel) {
    localStorage.setItem("controlli", JSON.stringify(datiControllo));
  }

  getXmlImpianto() {
    const serializedTasks = localStorage.getItem("xml");
    return (serializedTasks)
      ? JSON.parse(serializedTasks) : undefined;
  }

  setXmlImpianto(xml: any) {
    localStorage.setItem("xml", JSON.stringify(xml));
  }

  getBozzeLocali(codiceImpianto: string): DatoControlloModel[] {
    const serializedTasks = localStorage.getItem("bozze-locali");
    const map: Map<string, DatoControlloModel[]> = (serializedTasks)
      ? new Map(JSON.parse(serializedTasks)) : new Map<string, DatoControlloModel[]>([]);
    if (map && map.has(codiceImpianto)) {
      return map.get(codiceImpianto);
    } else return [];
  }

  addBozzeLocali(datoControllo: DatoControlloModel, codiceImpianto: string) {
    const serializedTasks = localStorage.getItem("bozze-locali");
    const map: Map<string, DatoControlloModel[]> = (serializedTasks)
      ? new Map(JSON.parse(serializedTasks)) : new Map<string, DatoControlloModel[]>();
    let datiControllo: DatoControlloModel[] = map && map.has(codiceImpianto) ? map.get(codiceImpianto) : [];
    datiControllo.push(datoControllo);
    map.set(codiceImpianto, datiControllo);
    localStorage.setItem("bozze-locali", JSON.stringify(Array.from(map.entries())));
  }

  getBozzaLocaleByIdAllegato(idAllegato: number, codiceImpianto: string): DatoControlloModel {
    const serializedTasks = localStorage.getItem("bozze-locali");
    let result: DatoControlloModel = undefined;
    const map: Map<string, DatoControlloModel[]> = (serializedTasks)
      ? new Map(JSON.parse(serializedTasks)) : new Map<string, DatoControlloModel[]>();
    let datiControllo: DatoControlloModel[] = map && map.has(codiceImpianto) ? map.get(codiceImpianto) : [];
    if (datiControllo) {
      datiControllo.forEach((dato: DatoControlloModel) => {
        if (dato.controlloModel.idAllegato && dato.controlloModel.idAllegato === idAllegato) {
          result = dato;
        }
      });
    }
    return result;
  }

  getBozzaLocaleByTempId(tempId: string, codiceImpianto: string): DatoControlloModel {
    const serializedTasks = localStorage.getItem("bozze-locali");
    let result: DatoControlloModel = undefined;
    const map: Map<string, DatoControlloModel[]> = (serializedTasks)
      ? new Map(JSON.parse(serializedTasks)) : new Map<string, DatoControlloModel[]>();
    let datiControllo: DatoControlloModel[] = map && map.has(codiceImpianto) ? map.get(codiceImpianto) : [];
    if (datiControllo) {
      datiControllo.forEach((dato: DatoControlloModel) => {
        if (dato.tempIdControllo === tempId) {
          result = dato;
        }
      });
    }
    return result;
  }

  updateBozzaLocale(bozza: DatoControlloModel, tempId: string, codiceImpianto: string) {
    this.delBozzaLocale(tempId, codiceImpianto);
    this.addBozzeLocali(bozza, codiceImpianto);
  }

  getNewBozzeLocali(codiceImpianto: string): DatoControlloModel[] {
    let newBozze: DatoControlloModel[] = [];
    const serializedTasks = localStorage.getItem("bozze-locali");
    const map: Map<string, DatoControlloModel[]> = (serializedTasks)
      ? new Map(JSON.parse(serializedTasks)) : new Map<string, DatoControlloModel[]>();
    let datiControllo: DatoControlloModel[] = map && map.has(codiceImpianto) ? map.get(codiceImpianto) : [];
    if (datiControllo) {
      datiControllo.forEach((dato: DatoControlloModel) => {
        if (!dato.controlloModel.idAllegato) {
          newBozze.push(dato);
        }
      });
    }
    return newBozze;
  }

  delBozzaLocale(uuid: string, codiceImpianto: string) {
    if (uuid) {
      const serializedTasks = localStorage.getItem("bozze-locali");
      const map: Map<string, DatoControlloModel[]> = (serializedTasks)
        ? new Map(JSON.parse(serializedTasks)) : new Map<string, DatoControlloModel[]>();
      let datiControllo: DatoControlloModel[] = map && map.has(codiceImpianto) ? map.get(codiceImpianto) : [];
      if (datiControllo) {
        datiControllo.forEach((dato: DatoControlloModel, index: number) => {
          if (dato.tempIdControllo === uuid) {
            datiControllo.splice(index, 1);
          }
        });
        if (datiControllo.length == 0)
          map.delete(codiceImpianto);
        else
          map.set(codiceImpianto, datiControllo);
        localStorage.setItem("bozze-locali", JSON.stringify(Array.from(map.entries())));
      }
    }
  }
  delOperazioniByTempId(tempIdControllo: string) {
    let operazioni = this.getOperazioni();
    operazioni.forEach((elem: OperazioneControlloModel) => {
      if (elem.idOperazione === tempIdControllo) {
        const index = operazioni.indexOf(elem, 0);
        if (index > -1) {
          operazioni.splice(index, 1);
        }
      }
    });
    this.setOperazioni(operazioni);
  }
}
