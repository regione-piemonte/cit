import { DatePipe } from '@angular/common';
import { HttpClient, HttpErrorResponse, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject, from, Observable, of, throwError, TimeoutError } from 'rxjs';
import { catchError, concatMap, share, timeout } from 'rxjs/operators';
import { Esito } from '../models/esito';
import { OnlineCheckModel } from '../models/online-check-model';
import { OperazioneControlloModel } from '../models/operazione-controllo-model';
import { SyncTask } from '../models/sync-task';
import { ESITO_OPERAZIONI, FORMAT, STATO_RAPP } from '../utils/constants';
import { LocalStorageServiceService } from './local-storage-service.service';


@Injectable({
  providedIn: 'root'
})
export class SyncServiceService {

  HTTP_TIMEOUT_IN_MS = 30000;
  subject = new BehaviorSubject<boolean>(true);
  syncSubject = new BehaviorSubject<boolean>(false);


  constructor(private http: HttpClient, private readonly localStorageService: LocalStorageServiceService, private datepipe: DatePipe) { }

  getOnlineSubject(): BehaviorSubject<boolean> {
    return this.subject;
  }

  setOnlineSubject(val) {
    this.subject.next(val);
  }


  tryPostPayload(url: string, payload: any, parameters: HttpParams, operazione: OperazioneControlloModel): Observable<any> {
    this.subject.next(true);
    return this.http.post(url, payload, { params: parameters }).pipe(
      timeout(this.HTTP_TIMEOUT_IN_MS),
      catchError((err: HttpErrorResponse) => this.handleError(err, url, "POST", payload, parameters, operazione)),
      share()
    );
  }

  tryPutPayload(url: string, payload: any, parameters: HttpParams, operazione: OperazioneControlloModel): Observable<any> {
    this.subject.next(true);
    return this.http.put(url, payload, { params: parameters }).pipe(
      timeout(this.HTTP_TIMEOUT_IN_MS),
      catchError((err: HttpErrorResponse) => this.handleError(err, url, "PUT", payload, parameters, operazione)),
      share()
    );
  }

  tryDelete(url: string, parameters: HttpParams, operazione: OperazioneControlloModel): Observable<any> {
    this.subject.next(true);
    return this.http.delete(url, { params: parameters }).pipe(
      timeout(this.HTTP_TIMEOUT_IN_MS),
      catchError((err: HttpErrorResponse) => this.handleErrorDelete(err, url, parameters, operazione)),
      share()
    );
  }

  tryGet(url: string, parameters: HttpParams): Observable<any> {
    this.subject.next(true);
    return this.http.get<any>(url, { params: parameters }).pipe(
      timeout(this.HTTP_TIMEOUT_IN_MS),
      catchError((err: HttpErrorResponse) => this.handleGetError(err, url, parameters)),
      share()
    );
  }

  private handleError(err: HttpErrorResponse, url: string, method: string,
    payload: any,
    params: HttpParams, operazione: OperazioneControlloModel): Observable<any> {
    if (this.offlineOrBadConnection(err)) {
      this.subject.next(false);
      this.addOrUpdateSyncTask<any>(url, method, payload, params, operazione);
      let onlineObj = new OnlineCheckModel;
      onlineObj.isOnline = false;
      return throwError(onlineObj);
    } else {
      return throwError(err);
    }
  }

  private handleErrorDelete(err: HttpErrorResponse, url: string,
    params: HttpParams, operazione: OperazioneControlloModel): Observable<any> {
    if (this.offlineOrBadConnection(err)) {
      this.subject.next(false);
      this.addOrUpdateSyncTask<any>(url, "DELETE", "", params, operazione);
      let onlineObj = new OnlineCheckModel;
      onlineObj.isOnline = false;
      return throwError(onlineObj);
    } else {
      return throwError(err);
    }
  }

  private handleGetError(err: HttpErrorResponse, url: string,
    params: HttpParams): Observable<any> {
    if (this.offlineOrBadConnection(err)) {
      this.subject.next(false);
      let onlineObj = new OnlineCheckModel;
      onlineObj.isOnline = false;
      return throwError(onlineObj);
    } else {
      return throwError(err);
    }
  }

  private offlineOrBadConnection(err: HttpErrorResponse): boolean {
    return (
      err instanceof TimeoutError ||
      err.error instanceof ErrorEvent ||
      !window.navigator.onLine ||
      err.status === 418 ||
      err.status === 504
    );
  }

  private addOrUpdateSyncTask<T>(url: string, method: string, payload: T, params: HttpParams, operazione: OperazioneControlloModel): void {
    const tasks = this.getExistingSyncTasks();
    const syncTask = new SyncTask(url, method, payload, params.toString());
    operazione.task = syncTask;
    tasks.push(operazione);
    this.localStorageService.setOperazioni(tasks);
  }

  private getExistingSyncTasks(): OperazioneControlloModel[] {
    return this.localStorageService.getOperazioni();
  }

  sync() {
    this.syncSubject.next(false);
    const syncTasks = this.getExistingSyncTasks();
    const requestsArray = [];
    const unhandledTaskIndex = [];
    syncTasks.forEach((task: OperazioneControlloModel, indexTask: number) => {
      if (!task.dataInvioOnline && task.esito == ESITO_OPERAZIONI.PENDING) {
        const options = { body: task.task.body, params: new HttpParams({ fromString: task.task.params }) };
        requestsArray.push(this.http.request(task.task.method, task.task.url, options));
        unhandledTaskIndex.push(indexTask);
      }
    });

    let index = 0;
    from(requestsArray).pipe(
      concatMap((request) => request.pipe(catchError(err => { return of({ result: { errore: err.error } }) })))
    ).subscribe((res: any) => {
      console.log(res);
      let indexTask = unhandledTaskIndex[index];
      if (res && res.result && res.result.errore) {
        let errore = res.result.errore as Esito;
        if (syncTasks[indexTask]) {
          syncTasks[indexTask].esito = ESITO_OPERAZIONI.FALLITO;
          if (errore && errore.descrizioneEsito) {
            let desc = errore.descrizioneEsito.replace(/<\/?[^>]+(>|$)/g, "\n");
            syncTasks[indexTask].descEsito = desc;
          }
          let controllo = this.localStorageService.getBozzaLocaleByTempId(syncTasks[indexTask].idOperazione, syncTasks[indexTask].codiceImpianto);
          if (controllo) {
            controllo.controlloModel.fkStatoRapp = controllo.fkStatoPrec;
            if (controllo.fkStatoPrec === STATO_RAPP.BOZZA_LOCALE && (!errore.idAllegatoNew)) {
              this.localStorageService.updateBozzaLocale(controllo, controllo.tempIdControllo, syncTasks[indexTask].codiceImpianto);
            } else {
              this.localStorageService.delBozzaLocale(controllo.tempIdControllo, syncTasks[indexTask].codiceImpianto);
            }
          }
        }
        this.localStorageService.setOperazioni(syncTasks);
        if ((index + 1) == requestsArray.length) {
          this.syncSubject.next(true);
        }
        index++;
      } else {
        if (syncTasks[indexTask]) {
          syncTasks[indexTask].dataInvioOnline = this.datepipe.transform(new Date(), FORMAT);
          syncTasks[indexTask].esito = ESITO_OPERAZIONI.SUCCESSO;
          this.localStorageService.setOperazioni(syncTasks);
          this.localStorageService.delBozzaLocale(syncTasks[indexTask].idOperazione, syncTasks[indexTask].codiceImpianto);
        }
        if ((index + 1) == requestsArray.length) {
          this.syncSubject.next(true);
        }
        index++;
      }
    });
  }
}
