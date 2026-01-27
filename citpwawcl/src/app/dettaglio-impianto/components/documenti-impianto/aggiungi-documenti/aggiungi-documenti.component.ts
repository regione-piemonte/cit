import { animate, state, style, transition, trigger } from '@angular/animations';
import { Platform } from '@angular/cdk/platform';
import { Location } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Documento, TipoDocumento } from 'src/app/models/documento-impianto.model';
import { BackService } from 'src/app/services/back.service';
import { DocumentiImpiantoService } from 'src/app/services/documenti-impianto.service';
import { MessageService } from 'src/app/services/message.service';
import { SharedService } from 'src/app/services/shared.service';
import { TitleService } from 'src/app/services/title.service';


@Component({
  selector: 'app-aggiungi-documenti',
  templateUrl: './aggiungi-documenti.component.html',
  styleUrls: ['./aggiungi-documenti.component.scss'],
  animations: [
    trigger('rotatedState', [
      state('default', style({ transform: 'rotate(0)' })),
      state('rotated', style({ transform: 'rotate(135deg)' })),
      transition('rotated => default', animate('0.2s ease-out')),
      transition('default => rotated', animate('0.2s ease-in'))
    ])
  ]
})
export class AggiungiDocumentiComponent implements OnInit {

  state: 'rotated' | 'default' = 'default';

  isMobile: boolean = false;

  selectedFile: File = null;
  showButtons: boolean = false;
  nuovoDocumentoForm: FormGroup;

  codiceImpianto: string;

  tipoDoc: string; //3 resp, aggiuntivo, ecc

  tipiDocumento: TipoDocumento[] = []

  constructor(
    private titleService: TitleService,
    private backService: BackService,
    private router: Router,
    private route: ActivatedRoute,
    private location: Location,
    private sharedService: SharedService,
    private fb: FormBuilder,
    platform: Platform,
    private documentiImpiantoService: DocumentiImpiantoService,
    private messageService: MessageService
  ) {
    this.isMobile = platform.ANDROID || platform.IOS;
    this.nuovoDocumentoForm = this.fb.group({
      tipoDocumentoControl: ['', Validators.required],
      descrizioneDocumentoControl: ['']
    });

  }

  ngOnInit(): void {
    // this.changeStyle(window.innerWidth);
    this.titleService.setTitle("Aggiungi documento");
    this.backService.setBackTitle("Torna a Elenco documenti");
    const urlOriginal = this.router.url;
    const redirectUrl = urlOriginal.substring(0, urlOriginal.lastIndexOf('/'));
    this.backService.setRoute(redirectUrl);
    this.sharedService.forceChangeContent.next();
    this.codiceImpianto = this.route.snapshot.paramMap.get('id_impianto');
    this.documentiImpiantoService.getTipiDocumento().subscribe((res) => {
      this.tipiDocumento = res;
    }, (error) => {
      console.log("Errore getTipiDocumento", error);
    });
  }

  // FILE SECTION

  doPlusButton() {
    if (this.state == 'rotated' && !!this.selectedFile) {
      this.selectedFile = null;
    } else {
      this.showButtons = !this.showButtons;
    }
    this.state = (this.state === 'default' ? 'rotated' : 'default');
  }

  onDragOver(event: DragEvent) {
    event.preventDefault();
    event.stopPropagation();
    this.addDragOverClass();
  }

  onDragLeave(event: DragEvent) {
    event.preventDefault();
    event.stopPropagation();
    this.removeDragOverClass();
  }

  onDrop(event: DragEvent) {
    console.log("ondrop")
    event.preventDefault();
    event.stopPropagation();
    this.removeDragOverClass();

    const files = event.dataTransfer?.files;
    if (files && files.length > 0) {
      this.handleFiles(files);
    }
  }

  onFileSelected(event: Event) {
    const input = event.target as HTMLInputElement;
    if (input.files && input.files.length > 0) {
      this.handleFiles(input.files);
    }
  }

  handleFiles(files: FileList) {
    if (files.length == 1) {
      this.selectedFile = files[0];
      this.showButtons = false;
    } else {
      alert("PUOI SELEZIONARE SOLO UN FILE");
    }
  }

  addDragOverClass() {
    const container = document.querySelector('.file-upload-container');
    container?.classList.add('dragover');
  }

  removeDragOverClass() {
    const container = document.querySelector('.file-upload-container');
    container?.classList.remove('dragover');
  }

  async uploadDocument() {
    let idAzione = "0"; //No id azione per ora
    console.log("Selected file" + this.selectedFile);
    // File  to base64
    let bb = await this.fileToByteArray(this.selectedFile);
    //bb to byte array

    let documento: Documento = {
      doc: bb,
      nome: this.selectedFile.name,
      mimeType: this.selectedFile.type,
      dimensione: this.selectedFile.size,
      // dimensione: 45,
      dataUpload: new Date(),
      uid: null,
      isPdfStatico: false,
      encoding: null,
      tipoDocumento: this.nuovoDocumentoForm.get('tipoDocumentoControl').value,
      descrizione: this.nuovoDocumentoForm.get('descrizioneDocumentoControl').value
    }
    this.documentiImpiantoService.uploadDocumento(this.codiceImpianto, "aggiuntivo", idAzione, documento).subscribe((res) => {
      this.messageService.setTitolo("Operazione Completata");
      this.messageService.setDescrizione("Documento caricato correttamente");
      this.messageService.showMessaggioM();
      this.messageService.setType(4);
      this.location.back();
    }, (error) => {
      let errorString = "Impossibile caricare il documento";
      try {
        if (JSON.parse(error.error)['descrizioneEsito'] === "Nessun contratto attivo per l'impianto") {
          errorString = errorString +  ", nessun contratto attivo per l'impianto";
        }
      } catch (e) { }
      console.log("Errore upload documento", error);
      this.messageService.setTitolo("Errore");
      this.messageService.setDescrizione(errorString);
      this.messageService.showMessaggioM();
      this.messageService.setType(2);
    });
  }

  async fileToBase64(file): Promise<string> {
    return new Promise((resolve, reject) => {
      const reader = new FileReader();
      reader.onload = () => {
        resolve(reader.result as string);
      };
      reader.onerror = reject;
      reader.readAsDataURL(file);
    });
  }


  async fileToByteArray(file): Promise<string> {
    const response = await fetch(URL.createObjectURL(file));
    const arrayBuffer = await response.arrayBuffer();
    //array buffer as array of numbers
    // const byteArray = Array.from(new Uint8Array(arrayBuffer));
    let binary = '';
    var bytes = new Uint8Array(arrayBuffer);
    var len = bytes.byteLength;
    for (var i = 0; i < len; i++) {
      binary += String.fromCharCode(bytes[i]);
    }
    return window.btoa(binary);
  }


}
