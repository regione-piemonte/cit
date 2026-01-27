import { DatePipe, Location } from '@angular/common';
import { Component, HostListener, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { DatiImpresa } from '@sigit/common-lib';
import { Persona } from 'src/app/models/persona';
import { AuthenticationService } from 'src/app/services/authentication.service';
import { BackService } from 'src/app/services/back.service';
import { DialogService } from 'src/app/services/dialog.service';
import { ImpiantoService } from 'src/app/services/impianto.service';
import { MessageService } from 'src/app/services/message.service';
import { SpinnerService } from 'src/app/services/spinner.service';
import { TitleService } from 'src/app/services/title.service';
import { DISPLAY_FORMAT, ICONSURL, RUOLI } from 'src/app/utils/constants';
//import { UtenteLoggato } from '../../../../../../../commonwcl/projects/commonwcl/src/lib/models/utente-loggato';
import { Autodichiarazione } from 'src/app/models/dati-autodichiarazione';
import { DatiContratto } from 'src/app/models/dati-contratto';
import { DatiImpianto } from 'src/app/models/dati-impianto';
import { UtenteLoggato } from 'src/app/models/utente-loggato';
import { NominaTerzoResponsabileService } from 'src/app/services/nomina.service';
import { SharedService } from 'src/app/services/shared.service';
import { RequestTerzoResponsabile } from '../../../../models/request-terzo-responsabile';
import { Errore } from 'src/app/models/errore';

/**
 * M019_5: Nomina terzo responsabile
 */
@Component({
    selector: 'app-subentro',
    templateUrl: './nomina.component.html',
    styleUrls: ['./nomina.component.scss']
})
export class NominaComponent implements OnInit {

    titlePng: string = ICONSURL + "titolo.png";
    title: string = "Nomina terzo responsabile";
    subtitle: string = "";
    backTitile: string = "Torna a ricerca indirizzo e impianto";
    //route: string = "/nomina/ricerca-indirizzo";
    titoloMessaggio: string = "";
    descrzioneMessaggio: string = "";
    showMessaggio: boolean = false;
    tipomessaggio: number = 0;
    ruolo: any;
    datiImpianto: any = {};
    datiImpiantoUbicazione: DatiImpianto = {};

    colBreakpoint1: number;
    colBreakpoint2: number;
    colBreakpoint3: number;
    colBreakpoint4: number;
    responsabileGroup: FormGroup;

    persone: Persona[] = [];
    responsabileAttivo: Persona;
    datiImpresa: DatiImpresa;
    utenteLoggato: UtenteLoggato;

    codiceImpianto: string;
    step: number = 1;

    dichiarazioni: any[] = [];
    dichiarazioniForm: FormGroup;
    tipoAutodichiarazioni: any;
    requestTerzoResponsabile: RequestTerzoResponsabile;
    maxDate = new Date();

    constructor(
        private authService: AuthenticationService,
        private router: Router,
        private activatedRouter: ActivatedRoute,
        private titoloService: TitleService,
        private backService: BackService,
        readonly messageService: MessageService,
        private impiantoService: ImpiantoService,
        private dialogService: DialogService,
        private nominaService: NominaTerzoResponsabileService,
        readonly spinnerService: SpinnerService,
        private sharedService: SharedService,
        private datepipe: DatePipe,
        private fb: FormBuilder,
        private location: Location
    ) {
        this.responsabileGroup = this.fb.group({
            dal: ["", [Validators.required]],
            al: ["", [Validators.required]],
            tacitoRinnovo: [false, []],
            note: [],
        });
        this.ruolo = this.authService.getCurrentUserFromSession()?.ruoloLoggato?.ruolo;
        this.activatedRouter.queryParams.subscribe((params) => {
            this.setCodiceImpianto(params.codiceImpianto);
            this.loadPersone();
        });
        this.datiImpresa = this.sharedService.getImpresaSelected();
        this.utenteLoggato = this.authService.getCurrentUserFromSession();
        this.nominaService.getTipoAutodichiarazione().subscribe((data) => {
            this.tipoAutodichiarazioni = data;
            let controls = {};
            for (let check of data) {
                Object.keys(check).forEach((key) => {
                    this.dichiarazioni.push({ key: key, value: check[key] });
                    controls[key] = this.fb.control({ value: false, disabled: false });
                });
            }
            this.dichiarazioniForm = this.fb.group(controls);
        });
    }

    setCodiceImpianto(codiceImpianto: any): void {
        this.codiceImpianto = codiceImpianto;
        this.impiantoService
          .getDettaglioImpianto(codiceImpianto)
          .subscribe(data => this.datiImpianto = data.datiPrecompilati);
    }

    ngOnInit(): void {

        // Initialization code goes here
        this.titoloService.setTitle(this.title);
        this.backTitile = "Torna a ricerca indirizzo e impianto"
        this.backService.setBackTitle(this.backTitile);
        //this.backService.setRoute(this.route);
        this.colBreakpoint1 = (window.innerWidth < 768) ? 12 : 6;
        this.colBreakpoint2 = (window.innerWidth < 768) ? 0 : 6;
        this.colBreakpoint3 = (window.innerWidth < 768) ? 12 : 3;
        this.colBreakpoint4 = (window.innerWidth < 768) ? 12 : 9;
    }

    ngAfterContentChecked() {
        this.doChange();
    }

    doChange() {
        // this.title = this.titoloService.getTitle();
        // this.subtitle = this.titoloService.getsubtitle();
        // this.backTitile = this.backService.getBack();
        // this.route = this.backService.getRoute();
        this.titoloMessaggio = this.messageService.getTitolo();
        this.descrzioneMessaggio = this.messageService.getDescrizione();
        this.tipomessaggio = this.messageService.getType();
        this.showMessaggio = this.messageService.getShowMessaggio();
    }

    @HostListener('window:resize', ['$event'])
    onResize(event?) {
        this.colBreakpoint1 = (event.target.innerWidth < 768) ? 12 : 6;
        this.colBreakpoint2 = (event.target.innerWidth < 768) ? 0 : 6;
        this.colBreakpoint3 = (window.innerWidth < 768) ? 12 : 3;
        this.colBreakpoint4 = (window.innerWidth < 768) ? 12 : 9;
    }

    back() {
        this.location.back();
    }

    goNextStep() {
        console.log(this.datiImpresa);
        //Richiarare algoritmo A019_8 VerifyContrattoTerzoResponsabile
        //se ok
        if (!this.datiImpianto) {
            this.datiImpianto = {
                codiceImpianto: this.codiceImpianto
            }
        }
        let datiContratto: DatiContratto = this.responsabileGroup.getRawValue();
        datiContratto.flg_tacito_rinnovo = +this.responsabileGroup.get('tacitoRinnovo').value;
        datiContratto.data_inizio = this.responsabileGroup.get('dal').value;
        datiContratto.data_fine = this.responsabileGroup.get('al').value;
        let requestTerzoResponsabile: RequestTerzoResponsabile = {
            datiImpianto: this.datiImpianto,
            utenteLoggato: this.utenteLoggato,
            datiContratto: datiContratto,
            autodichiarazioni: null,
            datiImpresa: this.datiImpresa
        };
        if(!requestTerzoResponsabile.datiImpresa){
            requestTerzoResponsabile.datiImpresa = {
                id_persona_giuridica: this.sharedService.getUtenteLoggato().ruoloLoggato.idPersonaGiuridica
            }
        }
        this.nominaService.verifyContrattoTerzoResponsabile(requestTerzoResponsabile).subscribe((data) => {
            if (data == 'OK') {
                this.title = "Dichiarazione terzo responsabile";
                this.persone.filter((persona) => !persona.dataFineResp).forEach((persona) => {
                    this.responsabileAttivo = persona;
                    console.log(this.responsabileAttivo);
                });
                this.step++
                window.scrollTo(0, 0);
                this.requestTerzoResponsabile = requestTerzoResponsabile;
                this.impiantoService.getDettaglioImpianto(this.codiceImpianto).subscribe((data) => {
                    this.datiImpiantoUbicazione =  this.buildDatiImpianto(data);
                    this.datiImpianto = data.datiPrecompilati;
                });
            } else {
                let msg = "Errore nella verifica del contratto";
                switch (data) {
                    case 'S146':
                        msg = "S146";
                        break;
                    case 'S147':
                        msg = "S147";
                        break;
                    case 'S089':
                        msg = "Alla data di inizio del contratto non esiste un responsabile valido";
                        break;
                    default:
                        msg = data;
                        break;
                }
                this.messageService.setTitolo("Attenzione");
                this.messageService.setDescrizione(msg);
                this.messageService.setType(1);
                this.messageService.showMessaggioM();
            }
        }, (err) => {
            console.log(err);
        });
        // let verify = true;
        // if (verify) {

        // }
    }

    getDate(data: string | any) {
        if (data)
            return this.datepipe.transform(data.split("[")[0], DISPLAY_FORMAT);
        else
            return "-";
    }

    buildDatiImpianto(data){
        let datiImpianto: DatiImpianto = {
            codiceImpianto: data.Richiesta.datiPrecompilati.codice_impianto,
            civico: data.Richiesta.datiPrecompilati.L1_2civico,
            comune: data.Richiesta.datiPrecompilati.L1_2comune,
            indirizzoSitad: data.Richiesta.datiPrecompilati.L1_2indirizzo,
            provincia: data.Richiesta.datiPrecompilati.L1_2prov,
            stradario: data.Richiesta.datiPrecompilati.L1P_6fuoriStradario,
            indirizzoNonTrovato: data.Richiesta.datiPrecompilati.L1_6indirizzoEstero
        };
        return datiImpianto;
    }


    salvaNuovoTerzoResponsabile() {
        this.dialogService.confirm("Nomina terzo responsabile", "Confermi di voler effettuare la nomina del terzo responsabile?").subscribe((response) => {
            if (response) {
                //prima di inviare setto l'id persona giuridica nel ruolo in quanto il BE la prende da la
                if (this.requestTerzoResponsabile.utenteLoggato.ruoloLoggato.ruolo != RUOLI.RUOLO_3RESPONSABILE
                    // ||
                    // this.requestTerzoResponsabile.utenteLoggato.ruoloLoggato.ruolo == RUOLI.DELEGATO_SU_3RESPONSABILE
                ) {
                    this.requestTerzoResponsabile.utenteLoggato.ruoloLoggato.idPersonaGiuridica = this.datiImpresa.id_persona_giuridica;
                }
                let controls = this.dichiarazioniForm.getRawValue();
                let dichiarazioniEffettuate = [];
                for (let key of Object.keys(controls)) {
                    if (controls[key]) {
                        dichiarazioniEffettuate.push(key);
                    }
                }
                let resultes = this.dichiarazioni.filter((dichiarazione) => dichiarazioniEffettuate.includes(dichiarazione.key));
                this.requestTerzoResponsabile.autodichiarazioni =
                    resultes.map((result) => {
                        let aut: Autodichiarazione = {
                            idAutodichiarazione: result.key,
                            desAutodichiarazione: result.value,
                            flgNominaCessa: "N"
                        }
                        return aut
                    });
                this.nominaService.setNuovoTerzoResp(this.codiceImpianto, this.requestTerzoResponsabile).subscribe((data) => {
                    this.messageService.setTitolo("Successo");
                    this.messageService.setDescrizione("Nomina terzo responsabile effettuata con successo.");
                    this.messageService.setType(4);
                    this.messageService.showMessaggioM();
                    this.router.navigate(['/nomina/ricerca-indirizzo'], { relativeTo: this.activatedRouter });
                    this.dichiarazioniForm.reset();
                    this.loadPersone();
                },
                error => {
                            let erroreData = error.error;
                            try {
                                erroreData = typeof error.error === "string" ? JSON.parse(error.error) : error.error;
                            } catch (e) {
                                console.error("Errore nel parsing della risposta:", e);
                                erroreData = {};
                            }
                        
                            let descrizioneEsito = erroreData.descrizioneEsito ? erroreData.descrizioneEsito : "Errore sconosciuto";
                            
                            this.messageService.setTitolo("Errore");
                            this.messageService.setDescrizione(descrizioneEsito);
                            this.messageService.showMessaggioM();
                            this.messageService.setType(2);
                          }
            );
            }
        });
    }


    loadPersone() {
        this.impiantoService.getElencoStoricoResponsabiliImpianto(this.codiceImpianto).subscribe((data) => {
            this.persone = data.sort((a, b) => {
              const aString = (a.dataInizioResp as any).replace('[UTC]', '');
              const bString = (b.dataInizioResp as any).replace('[UTC]', '');

              return new Date(bString).getTime() - new Date(aString).getTime();
            });
        });
    }
}
