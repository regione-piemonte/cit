import { HttpClient } from '@angular/common/http';
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";

@Injectable({
    providedIn: 'root'
  })
export class ReadFileService {
    constructor(private http: HttpClient) { }

    public getFermate(): Observable<any> {
        return this.http.get('../assets/geojson_fermate.geojson');
        // return this.http.get('../assets/geojson_punti1.geojson');
    }

    public getNodiGomma(): Observable<any> {
        return this.http.get('../assets/geojson_nodi_gomma.geojson');
        // return this.http.get('../assets/geojson_punti2.geojson');
    }

    public getPaline(): Observable<any> {
        return this.http.get('../assets/geojson_paline.geojson');
        // return this.http.get('../assets/geojson_punti3.geojson');
    }

    public getData(): Observable<any> {
        // return this.http.get('../assets/geojson_paline.geojson');
        return this.http.get('../assets/CIT-GeoJson.json');
    }

    public getBaseLayer(): Observable<any> {
        return this.http.get('../assets/baselayers.json');
    }

    public getCapabilities(): Observable<any> {
        return this.http.get('https://geomap.reteunitaria.piemonte.it/ws/vtdifsuolo/rp-01/fascpaiwms/wms_vtdifsuolo_fasce_fluviali'+ '?SERVICE=WMS&REQUEST=GetCapabilities', {responseType: 'text'});
    }
}
