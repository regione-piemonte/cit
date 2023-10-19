import { Component, Inject, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { RicercaIndirizzoDialogComponent } from 'src/app/impianto/components/ricerca-indirizzo-dialog/ricerca-indirizzo-dialog.component';
import { Esito } from 'src/app/models/esito';
import { ControlloService } from 'src/app/services/controllo.service';
import { SpinnerService } from 'src/app/services/spinner.service';
import { ICONSURL } from 'src/app/utils/constants';

@Component({
  selector: 'app-upload-file-dialog',
  templateUrl: './upload-file-dialog.component.html',
  styleUrls: ['./upload-file-dialog.component.scss']
})
export class UploadFileDialogComponent implements OnInit {

  fileSelected: boolean = false;
  closeGrigio: string = ICONSURL + "close-grigio.png";
  selectedFile: File;
  idAllegato: string;
  titolo: string = "";
  descrizione: string;

  constructor(public dialogRef: MatDialogRef<RicercaIndirizzoDialogComponent>,
    @Inject(MAT_DIALOG_DATA) public data: string,
    private readonly controlliService: ControlloService,
    readonly spinnerService: SpinnerService) { this.idAllegato = data }

  ngOnInit(): void {

  }

  reset() {
    this.fileSelected = false;
  }

  fileChangeEvent(e: any) {
    this.titolo = "";
    this.selectedFile = e.target.files[0];
    this.fileSelected = true;
  }

  closeDialog() {
    this.dialogRef.close({ data: undefined });
  }

  caricaRee() {
    this.controlliService.uploadReeFirmato(this.idAllegato, this.selectedFile).subscribe(elem => {
      this.dialogRef.close({ data: true });
    }, error => {
      let esito = error.error as Esito;
      this.titolo = "Errore upload ree firmato";
      this.descrizione = esito.descrizioneEsito;
    });
  }
}
