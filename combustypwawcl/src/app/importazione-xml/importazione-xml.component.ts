import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from '../services/authentication.service';
import { BackService } from '../services/back.service';
import { TitleService } from '../services/title.service';
import { Router } from '@angular/router';
import { SpinnerService } from '../services/spinner.service';
import { MatSnackBar } from '@angular/material/snack-bar';
import { MatDialog } from '@angular/material/dialog';
import { FormGroup } from '@angular/forms';
import { DatiDistributoreService } from '../services/dati-distributore.service';
import { docXML } from '../models/doc-xml';
import { WARNING_TYPE } from '../common/components/message-box/message-box.component';
import { MessageService } from '../services/message.service';
import { ResultService } from '../services/result.service';
import { Esito } from '../models/esito';

@Component({
  selector: 'app-importazione-xml',
  templateUrl: './importazione-xml.component.html',
  styleUrls: ['./importazione-xml.component.scss']
})

export class ImportazioneXmlComponent implements OnInit {
  titoloErrore = "";
  descrizioneErrore = "";
  errorType: number = WARNING_TYPE;
  backTitle: string = "";
  route: string = "ruoli";
  utente: any;
  ruolo: any;
  isMobile: boolean;
  loading: boolean = false;

  public files: any[] = [];
  searchForm: FormGroup;
  descrizioneFile: string = "";

  constructor(
      readonly spinnerService: SpinnerService, 
      private router: Router,
      readonly titoloService: TitleService,
      readonly backService: BackService,
      readonly authService: AuthenticationService,
      private _snackBar: MatSnackBar, 
      public dialog: MatDialog,
      readonly messageService: MessageService,
      private readonly result: ResultService,
      readonly datiDistributoreService: DatiDistributoreService) { }

  ngOnInit(): void {
    this.isMobile = (window.innerWidth < 768) ? true : false;

    this.utente = this.authService.getCurrentUserFromSession();
    this.ruolo = this.authService.getCurrentUserFromSession().ruoloLoggato;
    this.titoloService.setTitle("Elenco Dati Inviati");
    this.route = "elenco-dati-inviati";
    this.backTitle = "Torna indietro"
    this.backService.setBackTitle(this.backTitle);
    this.backService.setRoute("elenco-dati-inviati");
  }

  onInputFileChange(event: Event): void {
    const input = event.target as HTMLInputElement;

    if (input.files && input.files.length > 0) {
      const validFiles: File[] = [];

      Array.from(input.files).forEach(file => {
        if (file.name.toLowerCase().endsWith('.xml')) {
          validFiles.push(file);
        }
      });

      if (validFiles.length === 0) {
        //this._snackBar.open("Solo file XML sono consentiti.", 'Chiudi', { duration: 3000 });
        this.titoloErrore = "Attenzione";
        this.descrizioneErrore = "Il file caricato non ha il formato richiesto (.xml).";
        this.errorType = 1;
        this.messageService.showMessaggioM();
        return;
      }

      this.files = validFiles;
      //this._snackBar.open(`${validFiles.length} file selezionato correttamente!`, 'Chiudi', { duration: 2000 });
    }
  }

  
  onFileArrayChange(fileList: File[]): void {
    const validFiles = fileList.filter(f => f.name.toLowerCase().endsWith('.xml'));
    if (validFiles.length === 0) {
      //this._snackBar.open("Solo file XML sono consentiti.", 'Chiudi', { duration: 3000 });
      this.titoloErrore = "Attenzione";
      this.descrizioneErrore = "Il file caricato non ha il formato richiesto (.xml).";
      this.errorType = 1;
      this.messageService.showMessaggioM();
      return;
    }
    this.files = validFiles;
    //this._snackBar.open(`${validFiles.length} file selezionato correttamente!`, 'Chiudi', { duration: 2000 });
  }

  deleteFromArray(index) {
    console.log(this.files);
    this.files.splice(index, 1);
  }

  caricaFile(): void {
    this.loading = true;
    
    if (!this.files.length) {
      this.loading = false;
      return;
    }

    const file = this.files[0];

    const MAX_FILE_SIZE = 1073741824;
    if (file.size > MAX_FILE_SIZE) {
      this.loading = false;
      this.titoloErrore = "Attenzione";
      this.descrizioneErrore = "Il file selezionato supera le dimensioni massime consentite (1GB).";
      this.errorType = 1;
      this.messageService.showMessaggioM();
      return;
    }

    const reader = new FileReader();

    reader.onload = () => {
    // Crea FormData
    const formData = new FormData();
    formData.append("file", file); 
    formData.append("nomeFile", file.name || "");
    formData.append("descrizione", this.descrizioneFile || "");
    formData.append("dataUpload", this.getDataCorrenteFormattata() || "");
    
    this.datiDistributoreService.uploadXMLDistributoreJWT(
      this.utente?.ruoloLoggato?.idPersonaGiuridica,
      false,
      formData
    ).subscribe(
      (element: Esito) => {
        this.loading = false;
        this.files.splice(0, 1); // Rimuove il file appena caricato

        if (element.descrizioneEsito == null || element.descrizioneEsito.trim() === "") {
          this.titoloErrore = "Successo";
          this.descrizioneErrore = file.name + 
            " il file verra' elaborato nella notte.\n" +
            "E' stato caricato con successo 1 file.\n" +
            "Per i distributori schedulati nella notte, le notifiche verranno inviate alla mail del distributore.";
          this.errorType = 4;
          this.messageService.showMessaggioM();
          setTimeout(() => {
            this.router.navigate(["elenco-dati-inviati"]);
          }, 7000);
        } else {
          this.titoloErrore = "Errore";
          this.descrizioneErrore = element.descrizioneEsito ?? "Errore durante il caricamento del file.";
          this.errorType = 2;
          this.messageService.showMessaggioM();
        }
      },
      error => {
        this.loading = false;

        const errore = error.error as Esito;

        this.titoloErrore = "Errore";
        this.descrizioneErrore = errore?.descrizioneEsito ?? "Errore durante il caricamento del file.";
        this.errorType = 2;
        this.messageService.showMessaggioM();
      }
    );
    };

    reader.onerror = (err) => {
      this.loading = false;
      console.error("Errore lettura file:", err);
      this._snackBar.open("Errore nella lettura del file", 'Chiudi', { duration: 3000 });
    };

    reader.readAsArrayBuffer(file);
  }

  getDataCorrenteFormattata(): string {
    const now = new Date();
    const pad = (n: number) => n.toString().padStart(2, '0');

    return `${now.getFullYear()}-${pad(now.getMonth() + 1)}-${pad(now.getDate())} ${pad(now.getHours())}:${pad(now.getMinutes())}:${pad(now.getSeconds())}`;
  }

  clearErrore() {
    this.titoloErrore = '';
    this.descrizioneErrore = '';
  }
}
