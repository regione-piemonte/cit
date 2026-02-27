import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { Router } from '@angular/router';
import { DatiDelega } from '../../../models/dati-delega';
import { DatiImpresa } from '../../../models/dati-impresa';
import { DatiIncarico } from '../../../models/dati-incarico';
import { SharedService } from '../../../services/shared.service';
import { RUOLI } from '../../../utils/constants';

@Component({
    selector: 'commonwcl-elenco-imprese',
    templateUrl: './elenco-imprese.component.html',
    styleUrls: ['./elenco-imprese.component.scss']
})
export class ElencoImpreseComponent implements OnInit {

    @Input() codiceFiscalePF: string;
    @Input() accreditamento: any;
    @Input() apiUrl: string;
    @Input() impresa: DatiImpresa;
    @Input() deleghe: DatiDelega[] = [];
    @Input() incarichi: DatiIncarico[] = [];
    @Input() onMessage: EventEmitter<any>;
    @Input() ruolo: string;
    @Output() delegheChange = new EventEmitter<number>();
    @Output() incarichiChange = new EventEmitter<number>();

    constructor(private router: Router, private sharedService: SharedService) { }

    ngOnInit(): void {
        console.log(this.codiceFiscalePF);
        // Initialization code goes here
    }

    //region: cerca impresa

    //end region: cerca impresa

    //region: accreditamento

    filterDelega(val: number) {
        if (this.accreditamento?.datiDelegaList) {
            return this.accreditamento?.datiDelegaList?.filter((item) => item.id_persona_giuridic === val);
        }
        return [];
    }

    filterIncarico(val: number) {
        if (this.accreditamento?.datiIncaricoList) {
            return this.accreditamento?.datiIncaricoList?.filter((item) => item.id_persona_giuridica_impresa === val);
        }
        return [];
    }

    nuovaImpresa() {
        this.router.navigate(['accreditamento/nuova-impresa'], { state: { codiceFiscalePF: this.codiceFiscalePF } });
    }

    isConsultatoreValidatore() {
        let utenteLoggato = this.sharedService.getUtenteLoggato();
        if (utenteLoggato.ruoloLoggato.ruolo == RUOLI.RUOLO_CONSULTATORE || utenteLoggato.ruoloLoggato.ruolo == RUOLI.RUOLO_VALIDATORE) {
            return true;
        }
        return false;
    }

    //endregion accreditamento
}
