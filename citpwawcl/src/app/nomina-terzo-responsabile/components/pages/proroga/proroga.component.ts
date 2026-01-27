import { Location } from '@angular/common';
import { Component, HostListener, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { RequestTerzoResponsabile } from 'src/app/models/request-terzo-responsabile';
import { AuthenticationService } from 'src/app/services/authentication.service';
import { BackService } from 'src/app/services/back.service';
import { DialogService } from 'src/app/services/dialog.service';
import { ImpiantoService } from 'src/app/services/impianto.service';
import { MessageService } from 'src/app/services/message.service';
import { NominaTerzoResponsabileService } from 'src/app/services/nomina.service';
import { SharedService } from 'src/app/services/shared.service';
import { SpinnerService } from 'src/app/services/spinner.service';
import { TitleService } from 'src/app/services/title.service';
import { ICONSURL } from 'src/app/utils/constants';

/**
 * M019_5: Nomina terzo responsabile
 */
@Component({
    selector: 'app-proroga',
    templateUrl: './proroga.component.html',
    styleUrls: ['./proroga.component.scss']
})
export class ProrogaComponent implements OnInit {

    titlePng: string = ICONSURL + "titolo.png";
    title: string = "Proroga";
    subtitle: string = "";
    backTitile: string = "Torna indietro";
    route: string = "";
    titoloMessaggio: string = "";
    descrzioneMessaggio: string = "";
    tipomessaggio: number = 0;
    showMessaggio: boolean = false;
    ruolo: any;
    datiImpianto: any = {};
    today = new Date();

    colBreakpoint1: number;
    formGroup: FormGroup;
    id_contratto: any;
    codice_impianto: any;
    dettaglioImpianto: any;
    nomina: any;

    constructor(
        private authService: AuthenticationService,
        private router: Router,
        private activatedRouter: ActivatedRoute,
        private titoloService: TitleService,
        private backService: BackService,
        readonly messageService: MessageService,
        private impiantoService: ImpiantoService,
        private nominaService: NominaTerzoResponsabileService,
        private dialogService: DialogService,
        readonly spinnerService: SpinnerService,
        private sharedService: SharedService,
        private location: Location,
        private fb: FormBuilder,
        private aRoute: ActivatedRoute
    ) {
        this.formGroup = this.fb.group({
            dataFineContratto: [null, Validators.required],
            tacitoRinnovo: [],
        });
        this.ruolo = this.authService.getCurrentUserFromSession()?.ruoloLoggato?.ruolo;
        this.aRoute.queryParams.subscribe(params => {
            this.id_contratto = params.id_contratto;
            this.codice_impianto = params.codice_impianto;
            this.impiantoService.getDettaglioImpianto(params.codice_impianto).subscribe((data) => {
                this.dettaglioImpianto = data;
                this.datiImpianto = data.datiPrecompilati;
            });
            this.nomina = JSON.parse(params.nomina);

        });
    }

    ngOnInit(): void {
        // Initialization code goes here
        this.titoloService.setTitle(this.title);
        this.backTitile = "Torna a Dettaglio Nomina Terza Responsabilità"
        this.backService.setBackTitle(this.backTitile);
        this.backService.setRoute(null);
        this.colBreakpoint1 = (window.innerWidth < 768) ? 2 : 1;
    }

    @HostListener('window:resize', ['$event'])
    onResize(event?) {
        this.colBreakpoint1 = (event.target.innerWidth < 768) ? 2 : 1;
    }

    ngAfterContentChecked() {
        this.doChange();
    }

    doChange() {

        this.titoloMessaggio = this.messageService.getTitolo();
        this.descrzioneMessaggio = this.messageService.getDescrizione();
        this.tipomessaggio = this.messageService.getType();
        this.showMessaggio = this.messageService.getShowMessaggio();
    }

    annulla() {
        this.location.back();
    }

    isSalvaEnabled(){
        if(this.formGroup.get('dataFineContratto').value != null ) 
        {
            return true;
        } 
        else 
        {
            return false;
        }

    }

    salva() {
        let confirmMsg = "Confermi di voler effettuare la proroga della nomina del terzo responsabile?"
        this.dialogService.confirm("Proroga nomina", confirmMsg).subscribe((response) => {
            if (response) {
                let user = this.authService.getCurrentUserFromSession();
                let datiPrecom = this.sharedService.getDatiPrecompilati();
                let request: RequestTerzoResponsabile = {
                    datiImpianto: {
                        codiceImpianto: this.codice_impianto,
                        siglaProv: datiPrecom.L1_2prov,
                        indirizzoSitad: datiPrecom.L1_2indirizzo,
                        indirizzoNonTrovato: datiPrecom.L1P_6indirizzoEstero,
                        tipoImpianto: datiPrecom.tipoImpianto,
                        comune: datiPrecom.L1_2comune,
                        civico: datiPrecom.L1_2civico
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
                        data_fine: this.formGroup.get('dataFineContratto').value,
                        flg_tacito_rinnovo: +this.formGroup.get('tacitoRinnovo').value,
                    },
                    autodichiarazioni: [],
                }
                console.log(request);
                this.nominaService.setProroga(request).subscribe((data) => {
                    if (data == "OK") {
                        //success
                        this.messageService.setTitolo("Proroga effettuata");
                        this.messageService.setDescrizione("La proroga della nomina del terzo responsabile è stata effettuata con successo");
                        this.messageService.setType(4);
                        this.messageService.showMessaggioM();
                        this.location.back();
                    } else {
                        //error msg
                        this.messageService.setTitolo("Attenzione");
                        this.messageService.setDescrizione(data);
                        this.messageService.setType(1);
                        this.messageService.showMessaggioM();
                    }
                }, (error) => {
                    this.messageService.setTitolo("Errore");
                    this.messageService.setDescrizione(error);
                    this.messageService.setType(2);
                    this.messageService.showMessaggioM();
                });
                console.log(this.formGroup.getRawValue())
            }
        });
    }
}
