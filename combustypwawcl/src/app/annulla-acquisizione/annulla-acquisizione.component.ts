import { Component, Inject, OnInit } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import { ImportDatiDistributore } from '../models/importazione-dati-distributore';
import { ICONSURL } from '../utils/constants';
import { DatiDistributoreService } from '../services/dati-distributore.service';
import { AuthenticationService } from '../services/authentication.service';
import { CONFIRM_TYPE, ERROR_TYPE, WARNING_TYPE } from '../common/components/message-box/message-box.component';
import { NgZone } from '@angular/core';

@Component({
  selector: 'app-annulla-acquisizione',
  templateUrl: './annulla-acquisizione.component.html',
  styleUrls: ['./annulla-acquisizione.component.scss']
})
export class AnnullaAcquisizioneComponent implements OnInit {
  titlePng: string = ICONSURL + "titolo.png";
  utente: any;
  loading: boolean = false;

  constructor(
    private dialogRef: MatDialogRef<AnnullaAcquisizioneComponent>,
    @Inject(MAT_DIALOG_DATA) public data: {
    importDatiDistributore: ImportDatiDistributore;
    codiceFiscalePF: string;
    errorType?: number;
    titoloErrore?: string;
    descrizioneErrore?: string;
    },
    private datiDistributoreService: DatiDistributoreService,
     readonly authService: AuthenticationService,
     private zone: NgZone
  ) {}

  ngOnInit(): void {
    this.utente = this.authService.getCurrentUserFromSession();
  }

   close(): void {
    if (!this.loading) {
      this.dialogRef.close();
    }
  }

  confirm(): void {
    this.loading = true;  // attivo loader, blocco pulsanti

    this.datiDistributoreService.annullaAcquisizioneDatoDistributore(
      this.data.codiceFiscalePF,
      this.data.importDatiDistributore.id_import_distrib
    ).subscribe({
      next: (esito) => {
        this.loading = false;

        let titolo: string | null = null;
        let descrizione: string | null = null;
        let tipo: any = null;

        if (esito.esito?.toUpperCase() === "OK") {
          titolo = "Successo";
          descrizione = "Annullamento eseguito con successo.";
          tipo = CONFIRM_TYPE;
        } else if (esito.esito === "Errore gestito") {
          titolo = "Attenzione";
          descrizione = esito.descrizioneEsito;
          tipo = WARNING_TYPE;
        } else {
          titolo = "Errore";
          descrizione = "Si è verificato un errore sconosciuto.";
          tipo = ERROR_TYPE;
        }

        if (titolo && descrizione && tipo != null) {
          this.zone.run(() => {
            this.dialogRef.close({
              titoloErrore: titolo,
              descrizioneErrore: descrizione,
              errorType: tipo
            });
          });
        }
      },
      error: (err) => {
        this.loading = false;
        console.error('Errore:', err);
        this.zone.run(() => {
          this.dialogRef.close({
            titoloErrore: "Errore",
            descrizioneErrore: "Errore nel recupero dei dati del distributore.",
            errorType: ERROR_TYPE
          });
        });
      }
    });
  }
}