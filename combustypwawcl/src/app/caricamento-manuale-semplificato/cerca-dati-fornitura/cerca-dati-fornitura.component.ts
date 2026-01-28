import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatCheckboxChange } from '@angular/material/checkbox';

import { Router } from '@angular/router';
import { Errore } from 'src/app/models/errore';
import { Impianto } from 'src/app/models/impianto';
import { Persona } from 'src/app/models/persona';
import { AuthenticationService } from 'src/app/services/authentication.service';
import { BackService } from 'src/app/services/back.service';
import { ImpiantoService } from 'src/app/services/impianto.service';
import { MessageService } from 'src/app/services/message.service';
import { ResultService } from 'src/app/services/result.service';
import { SpinnerService } from 'src/app/services/spinner.service';
import { TitleService } from 'src/app/services/title.service';
import { ICONSURL } from 'src/app/utils/constants';
import { validateAlphanumeric, validateCFPIVA, validateNumbers } from 'src/app/validators/custom.validator';
import { BarcodeFormat } from '@zxing/library';
import { WARNING_TYPE } from 'src/app/common/components/message-box/message-box.component';

@Component({
  selector: 'app-cerca-dati-fornitura',
  templateUrl: './cerca-dati-fornitura.component.html',
  styleUrls: ['./cerca-dati-fornitura.component.scss']
})

export class CercaDatiFornituraComponent implements OnInit {

  hasResult: boolean;
  searchForm: FormGroup;
  errorType: number = WARNING_TYPE;
  titoloErrore = "";
  descrizioneErrore = "";
  persone: Persona[] = undefined;
  backTitile: string = "";
  route: string = "ruoli";
  ruolo: any;
  utenteLoggato: any;
  codiceFiscalePF;
  iconBarcode: string = ICONSURL + "ios-barcode.png";
  impianti: Impianto[];

  showScanner = false;
  torchEnabled = false;

  public allowedFormats = [
    BarcodeFormat.CODE_128,
    BarcodeFormat.CODE_39,
    BarcodeFormat.EAN_13,
    BarcodeFormat.QR_CODE
  ];  

  constructor(
    private fb: FormBuilder, 
    readonly spinnerService: SpinnerService, 
    private router: Router,
    readonly titoloService: TitleService,
    readonly backService: BackService,
    readonly authService: AuthenticationService,
    readonly impiantoService: ImpiantoService,
    readonly messageService: MessageService,
    private readonly result: ResultService) { 
    this.searchForm = this.fb.group({
        checkEnteImpresa: [false],
        cf: ["", validateCFPIVA],
        codImpianto: ["", validateNumbers()]
      });
    }
    
    ngOnInit(): void {
      this.ruolo = this.authService.getCurrentUserFromSession().ruoloLoggato;
      this.utenteLoggato = this.authService.getCurrentUserFromSession().pfLoggato;
      this.titoloService.setTitle("Caricamento manuale semplificato");
      this.route = "elenco-dati-inviati";
      this.backTitile = "Torna indietro"
      this.backService.setBackTitle(this.backTitile);
      this.backService.setRoute("/");

    }

     onCodeResult(resultString: string): void {
      console.log('Barcode rilevato:', resultString);
      this.searchForm.controls['cf'].setValue(resultString);
      this.showScanner = false;
      this.cercaPerCF();
    }

    onScanError(error: any): void {
      console.error('Errore scanner:', error);
      this.titoloErrore = "Errore";
      this.descrizioneErrore = "Impossibile leggere il codice a barre.";
      this.errorType = 2;
      this.messageService.showMessaggioM();
    }

    toggleEnteImpresa(event: MatCheckboxChange): void {
      const checked = event.checked;
      console.log('Valore checkbox Ente/Impresa:', checked);
      this.searchForm.get('checkEnteImpresa')?.setValue(checked);
    }
    
    navigateToCaricamentoManuale() {
      this.result.setResult(null);
      this.router.navigate(["/caricamento-semplificato"]);
    }

    cercaPerCF() {
      let cf = this.searchForm.controls['cf'].value?.trim() || undefined;
      let enteImpresaValue = this.searchForm.get('checkEnteImpresa')?.value ? 1 : 0;

      this.impiantoService.cercaResponsabileProprietario(enteImpresaValue, cf, null, null).subscribe({
        next: (persone: Persona[]) => {
          this.persone = persone;

          this.impiantoService.getGeoJsonByFilter(
            true, undefined, undefined, cf, undefined, undefined, undefined,
            undefined, undefined, undefined, undefined, undefined, undefined,
            undefined, this.ruolo.ruolo, this.ruolo.piva, this.utenteLoggato.codiceFiscalePF
          ).subscribe({
            next: (geoJson: string) => {
              this.impianti = this.impiantoService.parseGeoJsonToImpianto(geoJson);

              if ((this.persone?.length || 0) === 0 && (this.impianti?.length || 0) === 0) {
                this.titoloErrore = "Nessun risultato trovato";
                this.descrizioneErrore = "Nessuna persona o impianto trovati per il codice fiscale inserito.";
                this.errorType = 1;
                this.messageService.showMessaggioM();
                return;
              }

              this.result.setRicercaDatiFornitura(this.persone, this.impianti);
              this.router.navigate(["/elenco-forniture"]);
            },
            error: (error) => {
              if (this.persone?.length != 0) {
                this.result.setRicercaDatiFornitura(this.persone, []);
                this.router.navigate(["/elenco-forniture"]);
              } else {
                this.gestisciErroreCodiceFiscale(error)
              }
            }
          });
        },
        error: (error) => {
          if (error.status === 404) {
            // Nessuna persona trovata, proviamo comunque a cercare impianti
            this.persone = [];

            this.impiantoService.getGeoJsonByFilter(
              true, undefined, undefined, cf, undefined, undefined, undefined,
              undefined, undefined, undefined, undefined, undefined, undefined,
              undefined, this.ruolo.ruolo, this.ruolo.piva, this.utenteLoggato.codiceFiscalePF
            ).subscribe({
              next: (geoJson: string) => {
                this.impianti = this.impiantoService.parseGeoJsonToImpianto(geoJson);

                if (this.impianti.length === 0) {
                  this.titoloErrore = "Nessun risultato trovato";
                  this.descrizioneErrore = "Nessuna persona o impianto trovati per il codice fiscale inserito.";
                  this.errorType = 1;
                  this.messageService.showMessaggioM();
                  return;
                }

                this.result.setRicercaDatiFornitura([], this.impianti);
                this.router.navigate(["/elenco-forniture"]);
              },
              error: (error) => this.gestisciErroreCodiceFiscale(error)
            });

          } else {
            const errore = error.error as Errore;
            this.titoloErrore = "Errore";
            this.descrizioneErrore = errore.title || "Errore imprevisto nel recupero impianti.";
            this.errorType = 2;
            this.messageService.showMessaggioM();
          }
        }
      });
    }

  private gestisciErroreCodiceFiscale(error: any) {
  if (error.status === 404) {
      this.titoloErrore = "Nessun risultato trovato";
      this.descrizioneErrore = "Nessuna persona o impianto trovati per il codice fiscale inserito.";
      this.errorType = 1;
      this.messageService.showMessaggioM();
    } else {
      const errore = error.error as Errore;
      this.titoloErrore = "Errore";
      this.descrizioneErrore = errore.title || "Errore generico";
      this.errorType = 2;
      this.messageService.showMessaggioM();
    }
  }

  cercaPerCodiceImpianto() {
      let codiceImpianto = this.searchForm.controls['codImpianto'].value || undefined;
      let enteImpresaValue = this.searchForm.get('checkEnteImpresa')?.value ? 1 : 0;

      this.impiantoService.getGeoJsonByFilter(
        false, codiceImpianto, undefined, undefined, undefined, undefined, undefined,
        undefined, undefined, undefined, undefined, undefined, undefined, undefined,
        this.ruolo.ruolo, this.ruolo.piva, this.utenteLoggato.codiceFiscalePF
      ).subscribe({
        next: (element: string) => {
          this.impianti = this.impiantoService.parseGeoJsonToImpianto(element);

          if (!this.impianti || this.impianti.length === 0) {
            this.titoloErrore = "Nessun risultato trovato";
            this.descrizioneErrore = "Nessun impianto trovato per il codice impianto inserito.";
            this.errorType = 1;
            this.messageService.showMessaggioM();
            return;
          }

          this.result.setRicercaDatiFornitura([], this.impianti);
          this.router.navigate(["/elenco-forniture"]);
        },
        error: (error) => this.gestisciErroreImpianti(error)
      });
  }

  private gestisciErroreImpianti(error: any) {
    if (error.status === 404) {
      this.titoloErrore = "Nessun risultato trovato";
      this.descrizioneErrore = "Nessun impianto trovato per il codice impianto inserito.";
      this.errorType = 1;
      this.messageService.showMessaggioM();
    } else {
      const errore = error.error as Errore;
      this.titoloErrore = "Nessun risultato trovato";
      this.descrizioneErrore = errore.title || "Nessun impianto trovato per il codice impianto inserito.";
      this.errorType = 1;
      this.messageService.showMessaggioM();
    }
  }

  clearErrore() {
    this.titoloErrore = '';
    this.descrizioneErrore = '';
  }

  onUppercase(controlName: string, event: Event): void {
    const input = event.target as HTMLInputElement;
    const upper = input.value.toUpperCase();
    this.searchForm.get(controlName)?.setValue(upper, { emitEvent: false });
  }
}
