import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { environment } from 'src/environments/environment';
import { ComuneEsteso } from '../models/comune-esteso.model';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SvistaService {

  private apiUrl: string;
  private key: string = 'ComuniEstesi';
  private allComuneEsteso: ComuneEsteso[] = [];
  private filteredComuneEsteso: ComuneEsteso[] = [];
  private observableComuneEsteso: Observable<ComuneEsteso[]>;

  constructor(private http: HttpClient, private router: Router) {
    this.apiUrl = environment.apiUrl + 'impianto';
  }

  getComuneEsteso(selectedComune: string) {
    this.allComuneEsteso = JSON.parse(localStorage.getItem(this.key));
    this.filteredComuneEsteso = this.allComuneEsteso.filter(item => item.comune === selectedComune);
    this.observableComuneEsteso = new Observable<ComuneEsteso[]>(observer =>
      observer.next(this.filteredComuneEsteso));
    return this.observableComuneEsteso;
  }

  saveComuniEstesiToLocalStorage() {
    if (localStorage.getItem('ComuniEstesi') == null) {
      this.callComuniEstesi().subscribe((data: ComuneEsteso[]) => {
        this.saveDataToLocalStorage(data);
      });
    }
  }

  callComuniEstesi() {
    const url: string = this.apiUrl + "/ce";
    let parameters: HttpParams = new HttpParams();
    parameters = parameters.append("comune", "   ");
    return this.http.get<ComuneEsteso[]>(url, { params: parameters });
  }

  saveDataToLocalStorage(data: ComuneEsteso[]): void {
    const jsonData = JSON.stringify(data);
    localStorage.setItem(this.key, jsonData);
  }

  loadDataFromLocalStorage(filterString: string): Observable<ComuneEsteso[]> {
    const jsonData = localStorage.getItem(this.key);
    const data = jsonData ? JSON.parse(jsonData) : [];

    const filteredData = data.filter((item: ComuneEsteso) =>
      item.comune.startsWith(filterString.toUpperCase()));

    return new Observable<ComuneEsteso[]>((observer) => {
      observer.next(filteredData);
      observer.complete();
    });
  }

}
