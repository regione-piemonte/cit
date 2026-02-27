import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { ConfirmDialog } from '../../../common/components/confirm-dialog/confirm-dialog.component';
import { DatiDelega } from '../../../models/dati-delega';
import { DatiImpresa } from '../../../models/dati-impresa';
import { DatiIncarico } from '../../../models/dati-incarico';
import { UtenteLoggato } from '../../../models/utente-loggato';
import { AccreditamentoService } from '../../../services/accreditamento.service';
import { SharedService } from '../../../services/shared.service';
import { ICONSURL, RUOLI } from '../../../utils/constants';

@Component({
    selector: 'commonwcl-card-impresa',
    templateUrl: './card-impresa.component.html',
    styleUrls: ['./card-impresa.component.scss']
})
export class CardImpresaComponent implements OnInit {

    pgRed: string = ICONSURL + "impresa_red.svg";
    isCitpwa: boolean;
    
    @Input() impresa: DatiImpresa;
    @Input() deleghe: DatiDelega[] = [];
    @Input() apiUrl: string;
    @Input() incarichi: DatiIncarico[] = [];
    @Input() onlyView: boolean = false;
    @Input() onMessage = new EventEmitter<any>();
    @Input() codiceFiscalePF;
    @Output() delegheChange = new EventEmitter<any>();
    @Output() incarichiChange = new EventEmitter<any>();
    
    constructor(private accreditamentoService: AccreditamentoService,
        private dialog: MatDialog,
        private sharedService: SharedService,
        private router: Router) { }

    ngOnInit(): void {
        // Inizializza il componente
        this.isCitpwa = this.apiUrl?.includes('citpwa');
    }

    dettaglioImpresa(onlyView: boolean = true) {
        this.accreditamentoService.getDatiImpresa(this.impresa.codice_fiscale, this.impresa.sigla_rea, this.impresa.numero_rea).subscribe((data) => {
            this.router.navigate(['accreditamento/dettaglio-impresa'], { state: { impresa: data[0], onlyView: onlyView, codiceFiscalePF: this.codiceFiscalePF } });
        });

    }

    isTokenRole(): boolean {
        let utenteLoggato = this.sharedService.getUtenteLoggato();

        if (utenteLoggato.ruoloLoggato.ruolo == RUOLI.RUOLO_SUPER || 
            utenteLoggato.ruoloLoggato.ruolo == RUOLI.RUOLO_IMPRESA ||
            utenteLoggato.ruoloLoggato.ruolo == RUOLI.RUOLO_DISTRIBUTORE) {
            return true;
        }
        return false;
    }

    isVisualizzaImpiantiRole(): boolean {
        let utenteLoggato = this.sharedService.getUtenteLoggato();
        if (utenteLoggato.ruoloLoggato.ruolo == RUOLI.RUOLO_SUPER || 
            utenteLoggato.ruoloLoggato.ruolo == RUOLI.RUOLO_CONSULTATORE ||
            utenteLoggato.ruoloLoggato.ruolo == RUOLI.RUOLO_ISPETTORE || 
            utenteLoggato.ruoloLoggato.ruolo == RUOLI.RUOLO_VALIDATORE) {
            return true;
        }
        return false;
    }

    generaToken(impresa: DatiImpresa) {
        this.router.navigate(['accreditamento/genera-token'], { state: { impresa: this.impresa } });
    }

    visualizzaImpiantiAssociati(impresa: DatiImpresa)
    {    
        if (this.isCitpwa) 
        {
            this.router.navigate(['/impianto/ricerca-impianti'], { state: { impresa } });
        }
    }

    nuovoDelegato() {
        this.router.navigate(['accreditamento/nuova-delega'], { state: { impresa: this.impresa, } });
    }

    deleteDelega(impresa: DatiImpresa, delega: DatiDelega, index: number) {
        let idPersona = null;
        if (delega.id_persona_fisica) {
            idPersona = delega.id_persona_fisica;
        } else {
            idPersona = delega.id_persona_giuridic;
        }
        let utenteLoggato = this.sharedService.getUtenteLoggato();
        // if(!utenteLoggato.ruoloLoggato?.ruolo){
        //     this.onMessage.emit({
        //         titolo: "Attenzione",
        //         descrizione: "Selezionare un ruolo per effettuare la cancellazione delle delega.", type: 1
        //     });
        //     return;
        // }
        this.accreditamentoService.deleteDelega(idPersona, utenteLoggato).subscribe((data) => {
            this.dialog.open(ConfirmDialog, {
                data: {
                    titolo: 'Conferma eliminazione',
                    premessa: "Attenzione: ",
                    descrizione: 'Sei sicuro di voler eliminare questa delega?'
                }
            }).afterClosed().subscribe((confirm) => {
                if (confirm) {
                    this.accreditamentoService.deleteDelegaConfirm(utenteLoggato.pfLoggato.codiceFiscalePF, impresa.id_persona_giuridica, delega.id_persona_fisica)
                        .subscribe((deleteData) => {
                            this.onMessage.emit({
                                titolo: "Delega eliminata correttamente",
                                descrizione: "La delega è stata eliminata correttamente.", type: 4
                            });
                            this.deleghe.splice(index, 1);
                            this.delegheChange.emit(this.deleghe);
                        });
                }
            });
        });
    }

    /**
 *
 * @param impresa
 * @returns
 */
    isModificaImpresaVisible(impresa: DatiImpresa) {
        let utenteLoggato = this.sharedService.getUtenteLoggato();
        if (utenteLoggato.ruoloLoggato.ruolo == RUOLI.RUOLO_SUPER || utenteLoggato.ruoloLoggato.ruolo == RUOLI.RUOLO_VALIDATORE) {
            return true;
        }
        if (utenteLoggato.ruoloLoggato.ruolo == RUOLI.RUOLO_ISPETTORE || utenteLoggato.ruoloLoggato.ruolo == RUOLI.RUOLO_CONSULTATORE) {
            return false;
        }
        let cf = utenteLoggato.pfLoggato.codiceFiscalePF;
        for (let delega of this.deleghe) {
            if (delega.id_persona_giuridic == impresa.id_persona_giuridica && delega.codice_fiscale == cf) {
                if (delega.tipo_legame == "Accreditato") {
                    return true;
                }
            }
        }
        return false;
    }

    deleteIncarico(incarico: DatiIncarico, index: number) {
    let utenteLoggato: UtenteLoggato = this.sharedService.getUtenteLoggato();
        this.dialog.open(ConfirmDialog, {
            data: {
                titolo: 'Conferma eliminazione',
                premessa: "Attenzione: ",
                descrizione: 'Sei sicuro di voler eliminare questo incarico?'
            }
        }).afterClosed().subscribe((confirm) => {
            if (confirm) {
                this.accreditamentoService.deleteIncaricoSoggettoDelegato(utenteLoggato.pfLoggato.codiceFiscalePF, incarico.id_persona_giuridica_impresa, incarico.id_persona_giuridica_cat).pipe().subscribe((data) => {
                    this.onMessage.emit({
                        titolo: "Incarico eliminato correttamente",
                        descrizione: "L'incarico è stato eliminato correttamente.", type: 4
                    });
                    this.incarichi.splice(index, 1);
                    this.incarichiChange.emit(this.incarichi);
                }, (error) => {
                    this.onMessage.emit({
                        titolo: "Impossibile eliminare l'incarico",
                        descrizione: "Impossibile eliminare l'incarico, contattare il supporto per maggiori dettagli.", type: 4
                    });
                });
            }
        });
    }

    nuovaImpresa() {
        this.router.navigate(['accreditamento/nuova-impresa'], { state: { codiceFiscalePF: this.codiceFiscalePF } });
    }


    nuovoIncarico() {
        this.router.navigate(['accreditamento/nuovo-incarico'], { state: { impresa: this.impresa, codiceFiscalePF: this.codiceFiscalePF } });
    }






}
