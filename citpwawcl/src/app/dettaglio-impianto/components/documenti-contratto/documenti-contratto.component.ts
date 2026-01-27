import { Component, OnInit } from '@angular/core';
import { MatSelectChange } from '@angular/material/select';
import { ActivatedRoute, Router } from '@angular/router';
import { WARNING_TYPE } from 'src/app/common/components/message-box/message-box.component';
import { BackService } from 'src/app/services/back.service';
import { DocumentiImpiantoService } from 'src/app/services/documenti-impianto.service';
import { MessageService } from 'src/app/services/message.service';
import { TitleService } from 'src/app/services/title.service';

@Component({
    selector: 'app-documenti-contratto',
    templateUrl: './documenti-contratto.component.html',
    styleUrls: ['./documenti-contratto.component.scss']
})
export class DocumentiContrattoComponent implements OnInit {

    titleBox: string = 'title';
    messageBox: string = 'message';
    typeBox: number = 4;
    isSuccess: boolean = false;
    documenti: any[] = [];
    WARNING_TYPE = WARNING_TYPE;
    idContratto: any;
    searched = false;
    codiceImpianto: any;

    sortSelected: any;
    sortOptions = [{
        key: 'dataUpload',
        viewValue: 'Documento - dal più recente',
        value: 0
    },
    {
        key: 'dataUpload',
        viewValue: 'Documento - dal meno recente',
        value: 1
    }]

    constructor(
        private router: Router,
        private readonly backService: BackService,
        private readonly messageService: MessageService,
        private readonly titleService: TitleService,
        private documentiService: DocumentiImpiantoService,
        private route: ActivatedRoute
    ) {
        this.route.queryParams.subscribe(params => {
            this.idContratto = params.idContratto;
        });
        this.codiceImpianto = this.route.snapshot.parent.paramMap.get('id_impianto');
        //Riporto a dettaglio nomina
        // let backRoute = `dettaglio-nomina?idContratto=${this.idContratto}`;
        this.backService.setRoute(null);
    }

    ngOnInit(): void {
        // Inizializzazione del componente
        this.titleService.setTitle('Documenti associati al contratto');
        this.backService.setBackTitle('Torna a dettaglio Nomina Terza Responsabilità');
        this.sortSelected = this.sortOptions[0].value;
        this.documentiService.getElencoDocumenti().subscribe((data) => {
            //TODO filtrare per id_contratto
            let docs = data['documentiAssociatiContratto'];
            docs = docs.filter((doc) => doc.fkContratto == this.idContratto);
            for(let el of docs){
                function getDate(date) {
                    if (!!date && typeof date == 'string') {
                        const data = date.substring(0, date.indexOf('T'));
                        date = new Date(data);
                    }
                    return date;
                }
                el.dataControllo = getDate(el.dataControllo);
                el.dataUpload = getDate(el.dataUpload);
                el['isPdf'] = el.nomeDoc.endsWith('pdf');
                el['mimeType'] = el.nomeDoc.substring(el.nomeDoc.lastIndexOf('.') + 1).toUpperCase();
            }
            let keyOrder = 'dataUpload';
            this.documenti = docs.sort((a, b) => {
                if (this.sortSelected == 0) {
                    return b[keyOrder] - a[keyOrder];
                } else {
                    return a[keyOrder] - b[keyOrder];
                }
            });
            // = docs;
            this.searched = true;
        });

    }

    sortDocumenti($event: MatSelectChange) {
        this.documenti.sort((a, b) => {
            if ($event.value == 0) {
                return b[this.sortOptions[$event.value].key] - a[this.sortOptions[$event.value].key];
            } else {
                return a[this.sortOptions[$event.value].key] - b[this.sortOptions[$event.value].key];
            }
        });
    }

    aggiungiDocumento() {
        this.router.navigate(['./nuovo'], {
            queryParams: {
                idContratto: this.idContratto
            }, relativeTo: this.route
        });
    }

    onDownload(e) {
        if (e && e.error) {
            this.setMessageBox(e.message, WARNING_TYPE, 0);
        }
    }

    setMessageBox(msg: string, type: number, index: number) {
        this.messageService.setTitolo("Attenzione!");
        this.messageService.setDescrizione(msg);
        this.messageService.showMessaggioM();
        this.messageService.setType(type);
    }

    onDelete(e){
        if(e && e.error){
            this.setMessageBox(e.message, WARNING_TYPE, 0);
        }else{
            this.messageService.setTitolo("Successo!");
            this.messageService.setDescrizione("Eliminazione avvenuta con successo");
            this.messageService.showMessaggioM();
            this.messageService.setType(4);
        }
    }
}
