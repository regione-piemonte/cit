import { Component, EventEmitter, Input, Output } from '@angular/core';
import { ICONSURL, STATO_DATI_DOCUMENTO_IMPIANTO } from 'src/app/utils/constants';
import { doDownloadFile } from 'src/app/utils/utils';
import { DocumentiImpiantoService } from '../../../services/documenti-impianto.service';
import { WARNING_TYPE } from '../message-box/message-box.component';

@Component({
    selector: 'app-card-documento',
    templateUrl: './card-documento.component.html',
    styleUrls: ['./card-documento.component.scss']
})
export class CardDocumentoComponent {

    @Input() documento: any;
    @Input() showDeleteButton: boolean = true;

    @Output() onDelete = new EventEmitter<any>();
    @Output() onDownload = new EventEmitter<any>();

    readonly maxDocumentoLengthForPipe = 20;
    statoDoc = STATO_DATI_DOCUMENTO_IMPIANTO;

    readonly PDF_SVG = 'assets/misc/acrobat.svg';
    readonly IMG_SVG = ICONSURL + 'image.svg';

    readonly WARNING_TYPE = WARNING_TYPE;

    constructor(private documentiImpiantoService: DocumentiImpiantoService) { }

    download(uidIndex: string, stato: string, nomeDoc: string) {
        if (stato == this.statoDoc.CANCELLATO /*&& this.utenteLoggato.ruoloLoggato.ruolo !== RUOLI.RUOLO_SUPER*/) {
            let messageBox = 'Il documento risulta cancellato!';
            this.onDownload.emit({ error: true, message: messageBox });
            return;
        }
        this.documentiImpiantoService.getDocumentoByUid(uidIndex).subscribe((documento) => {
            doDownloadFile(documento.doc, nomeDoc, documento.mimeType);
        });
    }

    delete(uidIndex: string) {

        if (this.documento.stato == this.statoDoc.CANCELLATO) {
            const message = !this.showDeleteButton ?
                'In questa sezione non è consentita la cancellazione'
                : 'Il documento è già stato cancellato!';
            this.onDelete.emit({ error: true, message });
            return;
        }
        this.documentiImpiantoService.deleteDocumento(uidIndex)
            .subscribe(() => {
                this.onDelete.emit({ error: false, message: 'Eliminazione avvenuta con successo' });
                this.documento.stato = this.statoDoc.CANCELLATO;
            }, (error) => {
                this.onDelete.emit({ error: true, message: 'Errore durante l\'eliminazione del documento' });
            });
    }

}
