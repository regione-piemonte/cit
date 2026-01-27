import { NumberInput } from '@angular/cdk/coercion';
import { Component, HostListener, Inject, OnInit } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
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

  colBreakpoint1: NumberInput;
  colBreakpoint2: NumberInput;
  colBreakpoint3: NumberInput;
  rowBreakpoint1: NumberInput;

  constructor(public dialogRef: MatDialogRef<RicercaIndirizzoDialogComponent>,
    @Inject(MAT_DIALOG_DATA) public data: string,
    private readonly controlliService: ControlloService,
    readonly spinnerService: SpinnerService) { this.idAllegato = data }

  ngOnInit(): void {
    this.colBreakpoint1 = (window.innerWidth < 768) ? 12 : 4;
    this.colBreakpoint2 = (window.innerWidth < 768) ? 0 : 1;
    this.colBreakpoint3 = (window.innerWidth < 768) ? 12 : 6;
    this.rowBreakpoint1 = (window.innerWidth < 768) ? 3 : 2;
  }

  @HostListener('window:resize', ['$event'])
  onResize(event?) {
    this.colBreakpoint1 = (event.target.innerWidth < 768) ?  12 : 4;
    this.colBreakpoint2 = (event.target.innerWidth < 768) ?  0 : 1;
    this.colBreakpoint3 = (window.innerWidth < 768) ? 12 : 6;
    this.rowBreakpoint1 = (event.target.innerWidth < 768) ?  3 : 2;
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
