import { Component, HostListener, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CONFIRM_TYPE, ERROR_TYPE, getDefaultTitleByType, WARNING_TYPE } from 'src/app/common/components/message-box/message-box.component';
import { AuthenticationService } from 'src/app/services/authentication.service';
import { BackService } from 'src/app/services/back.service';
import { DocumentiImpiantoService } from 'src/app/services/documenti-impianto.service';
import { SharedService } from 'src/app/services/shared.service';
import { TitleService } from 'src/app/services/title.service';
import { ANIMATION_DO_FADE, ICONSURL, KO, RUOLI, STATO_DATI_DOCUMENTO_IMPIANTO } from 'src/app/utils/constants';
import { doDownloadFile } from 'src/app/utils/utils';



@Component({
  selector: 'app-documenti-impianto',
  templateUrl: './documenti-impianto.component.html',
  styleUrls: ['./documenti-impianto.component.scss'],
  styles: [ANIMATION_DO_FADE]
})
export class DocumentiImpiantoComponent implements OnInit {

  readonly maxDocumentoLengthForPipe = 20;

  statoDoc = STATO_DATI_DOCUMENTO_IMPIANTO;

  readonly PDF_SVG = 'assets/misc/acrobat.svg';
  readonly IMG_SVG = ICONSURL + 'image.svg';

  readonly WARNING_TYPE = WARNING_TYPE;

  sezioni: { title: string, showAddButton: boolean, documenti: DocumentoGeneral[], showDeleteButton: boolean }[] = [];

  isSuccess: boolean = false;
  doFade: boolean = false;
  indexBox: number = -1;
  titleBox: string = 'title';
  messageBox: string = 'message';
  typeBox: number = 4;

  formColBreakpoint: number;

  showAddButton = true;
  showDeleteButton = true;
  utenteLoggato;

  constructor(
    private titleService: TitleService,
    private backService: BackService,
    private sharedService: SharedService,
    private router: Router,
    private documentiImpiantoService: DocumentiImpiantoService,
    private authService: AuthenticationService
  ) {
    this.utenteLoggato = this.authService.getCurrentUserFromSession();
    let gruppoA = [RUOLI.RUOLO_CONSULTATORE, RUOLI.RUOLO_PROPRIETARIO, RUOLI.RUOLO_PROPRIETARIO_IMPRESA];
    if(gruppoA.indexOf(this.utenteLoggato.ruoloLoggato.ruolo) > -1){
      this.showAddButton = false;
      this.showDeleteButton = false;
    }
  }
  ngOnInit(): void {
    this.changeStyle(window.innerWidth);
    this.titleService.setTitle("Elenco documenti");
    this.backService.setBackTitle("Torna al dettaglio dell'impianto");
    const urlOriginal = this.router.url;
    const redirectUrl = urlOriginal.substring(0, urlOriginal.lastIndexOf('/'));
    this.backService.setRoute(redirectUrl);
    this.sharedService.forceChangeContent.next();
    this.documentiImpiantoService.getElencoDocumenti().subscribe((res: any) => {
      const { documentiAssociatiContratto, documentiAggiuntiviImpianto, documentiAzioni, documentiAllegatiImpianto } = res;
      this.setSection(documentiAggiuntiviImpianto, 'Documenti Aggiuntivi associati all\'impianto', this.showAddButton, this.showDeleteButton);
      this.setSection(documentiAssociatiContratto, 'Documenti associati al Contratto di Terza Responsabilità');
      // this.setSection(documentiAzioni, 'DA FINIRE IN FUTURO');
      this.setSection(documentiAllegatiImpianto, 'Documenti associati a Rapporti di Efficienza Energetica e Manutenzioni');
      console.log(`CHECK: ${this.sezioni.length == 1}, Sezioni:`, this.sezioni);
    }, error => {
      if (error.error?.esito == KO.toUpperCase()) {
        this.setSection([], '', true);
      }
    });
    window.scrollTo(0, 0);
  }

  setSection(documenti, title, showAddButton = false, showDeleteButton = false) {

    if (!!documenti) {
      documenti.sort((a: any, b: any) => {
        try {
          const fieldA = new Date(a.dataUpload.substring(0, a.dataUpload.indexOf('[')));
          const fieldB = new Date(b.dataUpload.substring(0, b.dataUpload.indexOf('[')));
          if (fieldA < fieldB) {
            return 1;
          }
          if (fieldA > fieldB) {
            return -1;
          }
        } catch (e) {
        }
        return 0;
      });
      // documenti.sort((a: any, b: any) => {
      //   // Convert field to desired type before comparison
      //   try {
      //     const fieldA = new Date(a.dataUpload.substring(0, a.dataUpload.indexOf('[')));
      //     const fieldB = new Date(b.dataUpload.substring(0, b.dataUpload.indexOf('[')));
      //     if (fieldA < fieldB) {
      //       return -1;
      //     }
      //     if (fieldA > fieldB) {
      //       return 1;
      //     }
      //   } catch (e) {
      //     return 0;
      //   }
      // });
      documenti.forEach(el => {
        function getDate(date) {
          if (!!date && typeof date == 'string') {
            const data = date.substring(0, date.indexOf('T'));
            date = new Date(data);
          }
          return date;
        }
        el.dataControllo = getDate(el.dataControllo);
        el.dataUpload = getDate(el.dataUpload);
        el.dataInizio = getDate(el.dataInizio);
        el.dataFine = getDate(el.dataFine);
        el['isPdf'] = el.nomeDoc.endsWith('pdf');
        el['mimeType'] = el.nomeDoc.substring(el.nomeDoc.lastIndexOf('.') + 1).toUpperCase();
      });
      this.sezioni.push({
        title,
        showAddButton,
        documenti,
        showDeleteButton
      });
    }
  }

  aggiungi(): void {
    this.router.navigate([`${this.router.url}/nuovo`], {
      queryParams: {
        tipoDocumento: 'aggiuntivo', //TODO questo dev'essere in base alla posizione, per ora gestiamo solo aggiuntivo
      }
    });
  }

  @HostListener('window:resize', ['$event'])
  onResize(event?) {
    this.changeStyle(event.target.innerWidth);
  }

  changeStyle(width) {
    this.formColBreakpoint = (width < 768) ? 1 : 2;
  }

  download(uidIndex: string, stato: string, sectionIndex: number, nomeDoc: string) {
    if (stato == this.statoDoc.CANCELLATO && this.utenteLoggato.ruoloLoggato.ruolo !== RUOLI.RUOLO_SUPER) {
      this.indexBox = sectionIndex;
      let messageBox = 'Il documento risulta cancellato!';
      this.setMessageBox(messageBox, 1, sectionIndex);
      return;
    }
    this.documentiImpiantoService.getDocumentoByUid(uidIndex).subscribe((documento) => {
      doDownloadFile(documento.doc, nomeDoc, documento.mimeType);
    });
  }

  delete(uidIndex: string, index: number) {
    this.indexBox = index;
    const element = this.sezioni[index].documenti.find(el => el.uidIndex == uidIndex);
    if (element.stato == this.statoDoc.CANCELLATO || !this.sezioni[index].showDeleteButton) {
      const message = !this.sezioni[index].showDeleteButton ?
        'In questa sezione non è consentita la cancellazione'
        : 'Il documento è già stato cancellato!';
      this.setMessageBox(message, ERROR_TYPE, index);
      return;
    }
    this.documentiImpiantoService.deleteDocumento(uidIndex)
      .subscribe(() => {
        this.setMessageBox('Eliminazione avvenuta con successo', CONFIRM_TYPE, index);
        element.stato = this.statoDoc.CANCELLATO;
      }, () => {
        this.setMessageBox('Errore durante la cancellazione del ' + this.sezioni[index].title, ERROR_TYPE, index);
      });
    //   .subscribe(res => {
    //   });
  }

  setMessageBox(msg: string, type: number, index: number) {
    document.getElementById("section-" + index).scrollIntoView({ behavior: 'smooth' });
    this.titleBox = getDefaultTitleByType(type);
    this.messageBox = msg
    this.typeBox = type;
    this.sharedService.doMessageBoxEvent(this);
  }

}

interface DocumentoGeneral {
  nomeDoc: string;
  tipoDoc: string;
  descrizione: string;
  dataUpload: Date;
  stato: string;
  uidIndex: string;
  idDocAllegato?: number;
  dataControllo?: Date;
  tipoREE?: string;
  statoREE?: number;
  tipoComponente?: string;
  isPdf?: boolean;
  mimeType?: string;

  //aggiunti
  descrizioneStatoRee?: string;
  descrizioneTipoRee?: string;
  tipoDocDes?: string;

  //aggiunti
  codiceFiscale3Resp: string;
  denominazione3Resp: string;
  dataInizio: Date;
  dataFine: Date;

}
