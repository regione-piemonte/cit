import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable, of } from "rxjs";
import { catchError, map } from 'rxjs/operators';

@Injectable({
    providedIn: 'root'
  })
export class identifyService {
    constructor(private http: HttpClient) { }

    public getFeatureInfo(url: string): Observable<any> {
      return this.http.get(url).pipe(map(val => val ), catchError(err => {console.error(err); return of(null);}));
    }
}
