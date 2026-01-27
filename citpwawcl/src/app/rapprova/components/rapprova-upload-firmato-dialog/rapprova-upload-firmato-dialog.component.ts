import { Component, Inject } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import { AlertService } from 'src/app/services/alert.service';
import { LoadingService } from 'src/app/services/loading.service';
import { UploadRapprovaFirmato } from '../../models/upload-rapprova-firmato.model';
import { RapprovaService } from '../../services/rapprova.service';

interface RapprovaUploadFirmatoDialogData {
  idAllegato: number;
  codiceImpianto: number;
}

@Component({
  selector: 'app-rapprova-upload-firmato-dialog',
  templateUrl: './rapprova-upload-firmato-dialog.component.html',
  styleUrls: ['./rapprova-upload-firmato-dialog.component.scss'],
})
export class RapprovaUploadFirmatoDialogComponent {
  uploadForm = this.fb.group({
    nomeDocOriginale: [null, Validators.required],
    docBase64: [null],
    docContentType: [null],
  });

  constructor(
    @Inject(MAT_DIALOG_DATA) private data: RapprovaUploadFirmatoDialogData,
    private fb: FormBuilder,
    private rapprovaService: RapprovaService,
    private loading: LoadingService,
    private alert: AlertService,
    private dialogRef: MatDialogRef<RapprovaUploadFirmatoDialogComponent>
  ) {}

  openDocument($event: Event) {
    const file = ($event.target as HTMLInputElement).files[0];

    const reader = new FileReader();
    reader.onload = () => {
      const base64 = (reader.result as string).split(',')[1];
      this.uploadForm.patchValue({
        nomeDocOriginale: file.name,
        docBase64: base64,
        docContentType: file.type,
      });
    };

    reader.readAsDataURL(file);
  }

  clearDocument() {
    this.uploadForm.patchValue({
      nomeDocOriginale: null,
      docBase64: null,
      docContentType: null,
    });
  }

  submit() {
    this.loading.on();

    const value = this.uploadForm.value;
    const request: UploadRapprovaFirmato = {
      datiRapProva: this.data,
      docBase64: value.docBase64,
      docName: value.nomeDocOriginale
    };
    this.rapprovaService
      .uploadRapprovaFirmato(request)
      .subscribe({
        next: () => {
          this.alert.success({ title: 'Upload effettuato', message: 'Rapporto di Prova firmato caricato correttamente' });
          this.loading.off();
          this.dialogRef.close();
        },
        error: () => this.loading.off()
      });
  }
}
