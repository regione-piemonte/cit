import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class LibrettoService {

  private apiUrl: string;
  constructor(private http: HttpClient, private router: Router) { this.apiUrl = environment.apiUrl + 'libretto'; }

  getLibrettoByCodice(codiceImpianto: string) {
    const url: string = this.apiUrl + "/uid";
    let parameters: HttpParams = new HttpParams();
    parameters = parameters.append("codice-impianto", codiceImpianto);
    return this.http.get(url, { params: parameters, responseType: 'blob' });
  }

  consolidaLibretto(codiceImpianto: string) {
    const url: string = this.apiUrl + "/consolida";
    let parameters: HttpParams = new HttpParams();
    parameters = parameters.append("codice-impianto", codiceImpianto);
    return this.http.post(url, "", { params: parameters });
  }
}
