import { Component, Inject, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { SpinnerService } from 'src/app/services/spinner.service';
import { ICONSURL } from 'src/app/utils/constants';
import { NuovoResponsabileProprietarioComponent } from '../nuovo-responsabile-proprietario/nuovo-responsabile-proprietario.component';

@Component({
  selector: 'app-aggiungi-componente-dialog',
  templateUrl: './aggiungi-componente-dialog.component.html',
  styleUrls: ['./aggiungi-componente-dialog.component.scss']
})
export class AggiungiComponenteDialogComponent implements OnInit {

  closeGrigio: string = ICONSURL + "close-grigio.png";
  titoloErrore = "";
  descrizioneErrore = "";

  constructor(public dialogRef: MatDialogRef<NuovoResponsabileProprietarioComponent>,
    @Inject(MAT_DIALOG_DATA) public data, readonly spinnerService: SpinnerService, private router: Router) { }

  ngOnInit(): void {
  }

  closeDialog() {
    this.dialogRef.close();
  }

  aggiungiComponente(type: number) {
    switch (type) {
      case 0:
        this.dialogRef.close();
        this.router.navigate(["/impianto/dettaglio/" + this.data.codiceImpianto + "/dettaglio-gt"]);
        break;
      case 1:
        this.dialogRef.close();
        this.router.navigate(["/impianto/dettaglio/" + this.data.codiceImpianto + "/dettaglio-gf"]);
        break;
      case 2:
        this.dialogRef.close();
        this.router.navigate(["/impianto/dettaglio/" + this.data.codiceImpianto + "/dettaglio-sc"]);
        break;
      case 3:
        this.dialogRef.close();
        this.router.navigate(["/impianto/dettaglio/" + this.data.codiceImpianto + "/dettaglio-cg"]);
        break;
    }
  }
}
