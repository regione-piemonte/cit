import { Component, Inject, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import { Observable } from 'rxjs';
import { debounceTime, distinctUntilChanged, filter, map } from 'rxjs/operators';
import { Errore } from 'src/app/models/errore';
import { LoccsiFeature } from 'src/app/models/loccsi-feature';
import { ImpiantoService } from 'src/app/services/impianto.service';
import { ResultService } from 'src/app/services/result.service';
import { SpinnerService } from 'src/app/services/spinner.service';
import { ICONSURL, LOCCSI } from 'src/app/utils/constants';

@Component({
  selector: 'app-ricerca-indirizzo-dialog',
  templateUrl: './ricerca-indirizzo-dialog.component.html',
  styleUrls: ['./ricerca-indirizzo-dialog.component.scss']
})
export class RicercaIndirizzoDialogComponent implements OnInit {

  closeGrigio: string = ICONSURL + "close-grigio.png";
  searchForm: FormGroup;
  isValueSet: boolean = false;
  x: number = 0;
  y: number = 0;
  distanza = 0;
  value = 0;
  filteredOptions: Observable<LoccsiFeature[]>;
  indirizzi: LoccsiFeature[] = [];
  loccsiClicked: boolean = false;
  currentAddress: LoccsiFeature;

  isRicercaCompletaChecked: boolean = false;

  constructor(public dialogRef: MatDialogRef<RicercaIndirizzoDialogComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any,
    private readonly result: ResultService,
    private fb: FormBuilder,
    private readonly impiantoService: ImpiantoService,
    readonly spinnerService: SpinnerService) {
    this.isRicercaCompletaChecked = data.isRicercaCompletaChecked;
    this.searchForm = this.fb.group({
      indirizzo: [""],
      indirizzoLoccsi: [""]
    });
  }

  ngOnInit(): void {
    this.searchForm.controls['indirizzoLoccsi'].valueChanges
      .pipe(debounceTime(500), distinctUntilChanged(), filter(data => data.length >= 3)).subscribe(elem => {
        if (!this.isValueSet) {
          if (typeof elem === "string") {
            this.loccsiClicked = false;
            const elem2 = elem;
            this.filteredOptions = this.impiantoService.getIndirizzoStradario(elem2)
              .pipe(
                map(name => name ? name : this.indirizzi.slice()));
          }
        }
      })
  }

  closeDialog() {
    this.dialogRef.close({ data: undefined });
  }

  ricercaGPS() {
    this.loccsiClicked = false;
    this.getPosition().then(pos => {
      this.searchForm.controls['indirizzo'].setValue("La tua posizione");
      this.searchForm.controls['indirizzo'].disable();
      this.isValueSet = true;
      this.x = pos.lng;
      this.y = pos.lat;
      this.distanza = 100;
      this.value = 100;
    });
  }

  ricercaIndirizzo() {
    this.result.setRicercaCompletaChecked(this.isRicercaCompletaChecked);

    if (this.isValueSet) {
      this.impiantoService.getGeoJsonByFilter(this.isRicercaCompletaChecked, undefined, undefined, undefined, undefined, undefined, undefined,
        undefined, undefined, undefined, this.x, this.y, this.distanza, undefined).subscribe((element: string) => {
          this.dialogRef.close({
            data: element,
            error: undefined,
          });
        },
          error => {
            if (error.status == 404) {
              this.dialogRef.close({
                data: [],
                error: undefined,
              });
            } else {
              this.dialogRef.close({
                data: [],
                error: error.error as Errore,
              });
            }
          });
    } else if (this.loccsiClicked) {
      let indirizzoFormatted = undefined;

      if (this.currentAddress.type == LOCCSI.CIVICI || this.currentAddress.type == LOCCSI.STRADE) {

        indirizzoFormatted = this.currentAddress.properties.tipoVia;

        if (this.currentAddress.properties.preposizione) {
          indirizzoFormatted += " " + this.currentAddress.properties.preposizione;
        }
        indirizzoFormatted += " " + this.currentAddress.properties.nomeVia;
      }
      this.impiantoService.getGeoJsonByFilter(this.isRicercaCompletaChecked, undefined, undefined, undefined, undefined, undefined, undefined, undefined,
        indirizzoFormatted, this.currentAddress.properties.civicoNum ? this.currentAddress.properties.civicoNum : undefined, undefined, undefined, undefined, this.currentAddress.properties.comune).subscribe((element: string) => {
          this.dialogRef.close({
            data: element,
            error: undefined,
          });
        },
          error => {
            if (error.status == 404) {
              this.dialogRef.close({
                data: [],
                error: undefined,
              });
            } else {
              this.dialogRef.close({
                data: [],
                error: error.error,
              });
            }
          });
    }
  }

  getPosition(): Promise<any> {
    return new Promise((resolve, reject) => {

      navigator.geolocation.getCurrentPosition(resp => {
        resolve({ lng: resp.coords.longitude, lat: resp.coords.latitude });
      },
        err => {
          reject(err);
        });
    });

  }

  reset() {
    this.searchForm.controls['indirizzo'].setValue('');
    this.searchForm.controls['indirizzoLoccsi'].setValue('');
    this.currentAddress = null;
    this.isValueSet = false;
  }

  formatLabel(value: number) {
    return value + "m";
  }

  setValue(event: any) {
    this.distanza = event.value;
    this.value = event.value;
  }

  displayFn(indirizzo: LoccsiFeature): string {
    return indirizzo && indirizzo.properties && indirizzo.properties.loccsiLabel ? indirizzo.properties.loccsiLabel : '';
  }

  enabled() {
    return this.loccsiClicked || this.isValueSet;
  }

  setLoccsiElem(feature: LoccsiFeature) {
    this.loccsiClicked = true;
    this.currentAddress = feature;
  }
}
