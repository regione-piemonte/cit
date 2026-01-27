import { Location } from '@angular/common';
import { Component, HostListener, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Console, debug, log } from 'console';
import moment from 'moment';
import { RequestTerzoResponsabile } from 'src/app/models/request-terzo-responsabile';
import { AuthenticationService } from 'src/app/services/authentication.service';
import { BackService } from 'src/app/services/back.service';
import { DialogService } from 'src/app/services/dialog.service';
import { ImpiantoService } from 'src/app/services/impianto.service';
import { MessageService } from 'src/app/services/message.service';
import { NominaTerzoResponsabileService } from 'src/app/services/nomina.service';
import { SharedService } from 'src/app/services/shared.service';
import { SpinnerService } from 'src/app/services/spinner.service';
import { SvistaService } from 'src/app/services/svista.service';
import { TitleService } from 'src/app/services/title.service';
import { ICONSURL, RUOLI } from 'src/app/utils/constants';

/**
 * M019_5: Nomina terzo responsabile
 */
@Component({
    selector: 'app-cessazione',
    templateUrl: './cessazione.component.html',
    styleUrls: ['./cessazione.component.scss']
})
export class CessazioneComponent implements OnInit {

    titlePng: string = ICONSURL + "titolo.png";
    title: string = "Cessazione";
    subtitle: string = "";
    backTitile: string = "Torna indietro";
    route: string = "";
    titoloMessaggio: string = "";
    descrzioneMessaggio: string = "";
    tipomessaggio: number = 0;
    showMessaggio: boolean = false;
    ruolo: any;
    datiImpianto: any = {};
    codice_impianto: any;

    colBreakpoint1: number;
    formGroup: FormGroup;

    tipoAutodichiarazione: any[] = [];
    tipoAutodichiarazioneSelected: any;
    checkboxesDichiarazioni: any[] = [];
    id_contratto: any;
    dettaglioImpianto: any;
    nomina: any;
    dataCessazioneMax = new Date().toISOString();

    constructor(
        private authService: AuthenticationService,
        private router: Router,
        private titoloService: TitleService,
        private backService: BackService,
        readonly messageService: MessageService,
        readonly spinnerService: SpinnerService,
        private fb: FormBuilder,
        private impiantoService: ImpiantoService,
        private nominaService: NominaTerzoResponsabileService,
        private sharedService: SharedService,
        private dialogService: DialogService,
        private aRoute: ActivatedRoute,
        private location: Location,
        private svistaService: SvistaService
    ) {
        this.formGroup = this.fb.group({
            dataCessazione: [null, Validators.required],
            tipoCessazione: ['', Validators.required],
            motivoCessazione: ['', Validators.required],
        });
        this.ruolo = this.authService.getCurrentUserFromSession()?.ruoloLoggato?.ruolo;
        this.valueForTipoCessazione();
        this.aRoute.queryParams.subscribe(params => {
            this.id_contratto = params.id_contratto;
            this.codice_impianto = params.codice_impianto;
            this.impiantoService.getDettaglioImpianto(params.codice_impianto).subscribe((data) => {
                this.dettaglioImpianto = data;
                this.datiImpianto = data.datiPrecompilati;
            });
            this.nomina = JSON.parse(params.nomina);
        });
        this.nominaService.getTipoAutodichiarazione().subscribe((data) => {
            this.checkboxesDichiarazioni = data;
            data.forEach(element => {
                this.formGroup.addControl(Object.keys(element)[0], new FormControl(false));
            });
        });
    }

    ngOnInit(): void {
        // Initialization code goes here
        this.titoloService.setTitle(this.title);
        this.backTitile = "Torna a Dettaglio Nomina Terza Responsabilità"
        this.backService.setBackTitle(this.backTitile);
        this.colBreakpoint1 = (window.innerWidth < 768) ? 2 : 1;

    }

    @HostListener('window:resize', ['$event'])
    onResize(event?) {
        this.colBreakpoint1 = (event.target.innerWidth < 768) ? 2 : 1;
    }

    annulla() {
        this.location.back();
    }

    ngAfterContentChecked() {
        this.doChange();
    }

    doChange() {
        this.title = this.titoloService.getTitle();
        this.subtitle = this.titoloService.getsubtitle();
        this.backTitile = this.backService.getBack();
        this.route = this.backService.getRoute();
        this.titoloMessaggio = this.messageService.getTitolo();
        this.descrzioneMessaggio = this.messageService.getDescrizione();
        this.tipomessaggio = this.messageService.getType();
        this.showMessaggio = this.messageService.getShowMessaggio();
    }

    salva() {
      
        console.log(this.formGroup.get('dataCessazione').value);
        let datiPrecom = this.sharedService.getDatiPrecompilati();

        let confirmMsg = "Confermi di voler effettuare la cessazione della nomina del terzo responsabile?"
        this.dialogService.confirm("Cessazione nomina", confirmMsg).subscribe((response) => {
            if (response) {
                let comuneEsteso = this.svistaService.getComuneEsteso(datiPrecom.L1_2comune).subscribe((data) => {
                    let user = this.authService.getCurrentUserFromSession();

                    let request: RequestTerzoResponsabile = {
                        datiImpianto: {
                            codiceImpianto: this.codice_impianto,
                            siglaProv: datiPrecom.L1_2prov,
                            indirizzoSitad: datiPrecom.L1_2indirizzo,
                            indirizzoNonTrovato: datiPrecom.L1P_6indirizzoEstero,
                            tipoImpianto: datiPrecom.tipoImpianto,
                            comune: datiPrecom.L1_2comune,
                            civico: datiPrecom.L1_2civico,
                            istatComune: data[0].codiceIstat
                            // istatcomune
                        },
                        datiImpresa: {
                            denominazione: user.ruoloLoggato.denominazione,
                            codice_fiscale: user.ruoloLoggato.piva,
                            sigla_rea: user.ruoloLoggato.siglaRea
                        },
                        utenteLoggato: this.authService.getCurrentUserFromSession(),
                        datiContratto: {
                            id_contratto: this.id_contratto,
                            data_cessazione: this.formGroup.get('dataCessazione').value,
                            fk_tipo_cessazione: this.tipoAutodichiarazioneSelected,
                            flg_tacito_rinnovo: 0,
                            motivo_cessazione: this.formGroup.get('motivoCessazione').value,
                        },
                        autodichiarazioni: [],
                    }
                    this.checkboxesDichiarazioni.forEach(element => {
                        let key: string = Object.keys(element)[0];
                        if (this.formGroup.get(Object.keys(element)[0]).value) {
                            request.autodichiarazioni.push({
                                idContratto: this.id_contratto,
                                idAutodichiarazione: key,
                                desAutodichiarazione: element[key],
                                flgNominaCessa: 'C'
                            });
                        }
                    });
                    this.nominaService.setCessazione(request).subscribe((data) => {
                        if (data == "OK") {
                            //success
                            this.messageService.setTitolo("Cessazione effettuata");
                            this.messageService.setDescrizione("La cessazione della nomina del terzo responsabile è stata effettuata con successo");
                            this.messageService.setType(4);
                            this.messageService.showMessaggioM();
                            this.location.back();
                        } else {
                            //error msg
                            this.messageService.setTitolo("Errore");
                            this.messageService.setDescrizione(data);
                            this.messageService.setType(2);
                            this.messageService.showMessaggioM();
                        }
                    }, (error) => {
                        this.messageService.setTitolo("Errore");
                        this.messageService.setDescrizione(error);
                        this.messageService.setType(1);
                        this.messageService.showMessaggioM();
                    });

                });
            }
        });
    }

    selectTipo($event) {
        this.tipoAutodichiarazioneSelected = $event.value;
    }

    isSalvaEnabled(){
        if(this.formGroup.get('dataCessazione').value != null 
        && this.formGroup.get('tipoCessazione').value != '' 
        && this.formGroup.get('motivoCessazione').value != '') 
        {
            return true;
        } 
        else 
        {
            return false;
        }

    }

    valueForTipoCessazione() {
        const revoca = {
            key: "Revoca",
            value: "Revoca"
        };
        const rinuncia = {
            key: "Rinuncia",
            value: "Rinuncia"
        };
        const decadenza = {
            key: "Decadenza",
            value: "Decadenza"
        };
        if (this.ruolo === RUOLI.RUOLO_RESPONSABILE || this.ruolo === RUOLI.RUOLO_RESPONSABILE_IMPRESA) {
            this.tipoAutodichiarazione.push(revoca);
        } else if (
            this.ruolo === RUOLI.RUOLO_3RESPONSABILE
        ) {
            this.tipoAutodichiarazione.push(rinuncia);
            this.tipoAutodichiarazione.push(decadenza);
        } else {
            switch (this.ruolo) {
                case RUOLI.RUOLO_SUPER:
                case RUOLI.RUOLO_CONSULTATORE:
                case RUOLI.RUOLO_ISPETTORE:
                case RUOLI.RUOLO_VALIDATORE:
                    this.tipoAutodichiarazione.push(revoca);
                    this.tipoAutodichiarazione.push(rinuncia);
                    this.tipoAutodichiarazione.push(decadenza);
                    break;
                default:
                    break;
            }
        }
    }
}
