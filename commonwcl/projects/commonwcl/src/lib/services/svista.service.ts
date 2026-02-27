import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { ComuneEsteso } from '../models/common/comune-esteso.model';
import { Provincia } from '../models/common/provincia.model';

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
  }

  init(apiUrl: string) {
    this.apiUrl = apiUrl + 'impianto';
  }

  getComuneEsteso(selectedComune: string) {
    this.allComuneEsteso = JSON.parse(localStorage.getItem(this.key));
    this.filteredComuneEsteso = this.allComuneEsteso.filter(item => item.comune === selectedComune);
    this.observableComuneEsteso = new Observable<ComuneEsteso[]>(observer =>
      observer.next(this.filteredComuneEsteso));
    return this.observableComuneEsteso;
  }

  saveComuniEstesiToLocalStorage() {
    if (localStorage.getItem('ComuniEstesi') == null || localStorage.getItem('Province') == null){
      this.callComuniEstesi().subscribe((data: ComuneEsteso[]) => {
        this.saveDataToLocalStorage(data);
        this.saveProvinceFromComuniEstesi(data);
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

  saveProvinceFromComuniEstesi(data: ComuneEsteso[]) {
    //Converto ed elaboro comune esteso
    const distinctData = Array.from(
      new Set(data.map((obj) => ({
        siglaProvincia: obj.siglaProvincia,
        provincia: obj.provincia,
        codiceRegione: obj.codiceIstat.substring(0, 4)
      })))
    );
    const result = distinctData.filter((obj1, i, arr) =>
      arr.findIndex(obj2 =>
        JSON.stringify(obj2) === JSON.stringify(obj1)
      ) === i
    );
    //Applico un ordinamento per cui vengono prima tutte le province del piemonte e poi il resto in ordine alfabetico
    let piemonte = result.filter((obj) => obj.siglaProvincia == 'AL' || obj.siglaProvincia == 'AT' || obj.siglaProvincia == 'BI' || obj.siglaProvincia == 'CN' || obj.siglaProvincia == 'NO' || obj.siglaProvincia == 'TO' || obj.siglaProvincia == 'VC' || obj.siglaProvincia == 'VB');
    let resto = result.filter((obj) => obj.siglaProvincia !== 'AL' && obj.siglaProvincia !== 'AT' && obj.siglaProvincia !== 'BI' &&  obj.siglaProvincia !== 'CN' && obj.siglaProvincia !== 'NO' && obj.siglaProvincia !== 'TO' && obj.siglaProvincia !== 'VC' && obj.siglaProvincia !== 'VB' && obj.siglaProvincia);
    piemonte = piemonte.sort((a, b) => a.siglaProvincia.localeCompare(b.siglaProvincia));
    resto = resto.sort((a, b) => a.siglaProvincia.localeCompare(b.siglaProvincia));
    localStorage.setItem('Province', JSON.stringify(piemonte.concat(resto)));
  }

  loadProvinceFromLocalStorage(): Provincia[] {
    const jsonData = localStorage.getItem('Province');
    const data = jsonData ? JSON.parse(jsonData) : [];
    return data;
  }

}
