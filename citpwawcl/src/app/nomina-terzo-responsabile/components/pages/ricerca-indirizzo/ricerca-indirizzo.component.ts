import { Component, HostListener, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { DatiImpresa } from '@sigit/common-lib';
import { Observable } from 'rxjs';
import { debounceTime, distinctUntilChanged, filter, map } from 'rxjs/operators';
import { DatiImpianto } from 'src/app/models/dati-impianto';
import { LoccsiFeature } from 'src/app/models/loccsi-feature';
import { AuthenticationService } from 'src/app/services/authentication.service';
import { ImpiantoService } from 'src/app/services/impianto.service';
import { MessageService } from 'src/app/services/message.service';
import { SharedService } from 'src/app/services/shared.service';
import { TitleService } from 'src/app/services/title.service';
import { RUOLI } from 'src/app/utils/constants';
import { BackService } from '../../../../services/back.service';

@Component({
    selector: 'app-ricerca-indirizzo',
    templateUrl: './ricerca-indirizzo.component.html',
    styleUrls: ['./ricerca-indirizzo.component.scss']
})
export class RicercaIndirizzoComponent implements OnInit {

    title: string = "";
    subtitle: string = "";
    backTitile: string = "";
    route: string = "";
    titoloMessaggio: string = "";
    descrzioneMessaggio: string = "";
    tipomessaggio: number = 0;
    showMessaggio: boolean = false;
    ruolo: any;

    filteredOptions: Observable<LoccsiFeature[]>;
    indirizzi: LoccsiFeature[] = [];
    loccsiClicked: boolean = false;
    currentAddress: LoccsiFeature;

    filteredOptionsComuni: Observable<LoccsiFeature[]>;
    comuni: LoccsiFeature[] = [];
    loccsiClickedComuni: boolean = false;
    currentAddressComuni: LoccsiFeature;

    colBreakpoint1: number;
    colBreakpoint2: number;
    colBreakpoint3: number;
    insertForm: FormGroup;

    datiImpresa: DatiImpresa;

    constructor(private authService: AuthenticationService,
        private router: Router,
        private titoloService: TitleService,
        private backService: BackService,
        private messageService: MessageService,
        private impiantoService: ImpiantoService,
        private sharedService : SharedService,
        private fb: FormBuilder) {
        this.insertForm = this.fb.group({
            codiceImpianto: ["", [Validators.required, Validators.min(0), Validators.pattern("^[0-9]*$"), Validators.maxLength(10)]],
            indirizzoLoccsi: ["", [
                Validators.required
            ]],
            civicoLoccsi: [""],
            stradario: [""],
            indirizzo: [],
            civico: [""],
            comune: [""],
            provincia: [""],
            noPdr: [""],
            propCheck: [""]
        });
        let state = this.router.getCurrentNavigation()?.extras?.state;
        if (state?.impresa) {
            this.datiImpresa = state.impresa;
            console.log(this.datiImpresa);
        }
    }



    ngOnInit(): void {
        this.ruolo = this.authService.getCurrentUserFromSession()?.ruoloLoggato?.ruolo;
        this.titoloService.setTitle("Ricerca indirizzo e impianto");
        this.route = "/";
        this.backTitile = "Torna alla home"
        this.backService.setBackTitle(this.backTitile);
        this.backService.setRoute("/");
        this.colBreakpoint1 = (window.innerWidth < 768) ? 12 : 6;
        this.colBreakpoint2 = (window.innerWidth < 768) ? 0 : 6;
        this.colBreakpoint3 = (window.innerWidth < 768) ? 12 : 3;

        this.insertForm.controls['indirizzoLoccsi'].valueChanges
            .pipe(debounceTime(500), distinctUntilChanged(), filter(data => data.length >= 3)).subscribe(elem => {
                if (typeof elem === "string") {

                    const elem2 = elem;
                    this.insertForm.controls['civicoLoccsi'].enable();
                    this.filteredOptions = this.impiantoService.getIndirizzoStradario(elem2)
                        .pipe(
                            map(name => name ? name : this.indirizzi.slice()));
                }
            });

        this.insertForm.controls['comune'].valueChanges
            .pipe(debounceTime(500), distinctUntilChanged(), filter(data => data.length >= 3)).subscribe(elem => {
                if (typeof elem === "string") {

                    const elem2 = elem;
                    this.insertForm.controls['comune'].enable();
                    this.filteredOptionsComuni = this.impiantoService.getProvinciaByComune(elem2)
                        .pipe(
                            map(name => name ? name : this.comuni.slice()));
                }
            });
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

    @HostListener('window:resize', ['$event'])
    onResize(event?) {
        this.colBreakpoint1 = (event.target.innerWidth < 768) ? 12 : 6;
        this.colBreakpoint2 = (event.target.innerWidth < 768) ? 0 : 6;
        this.colBreakpoint3 = (event.target.innerWidth < 768) ? 12 : 3;
    }

    setLoccsiElem(feature: LoccsiFeature) {
        this.currentAddress = feature;
        if (feature.properties.civicoNum) {
            this.insertForm.controls['civicoLoccsi'].setValue(feature.properties.civicoNum +
                feature.properties.civicoSub);
            this.insertForm.controls['civicoLoccsi'].disable();
        }
        this.loccsiClicked = true;
    }

    setProvinciaComune(feature: LoccsiFeature) {
        this.currentAddressComuni = feature;
        this.insertForm.controls['provincia'].setValue(feature.properties.descProvincia ? feature.properties.descProvincia : feature.properties.pv);
        this.loccsiClickedComuni = true;
    }

    displayFn(indirizzo: LoccsiFeature): string {
        if (typeof indirizzo === 'string') {
            return indirizzo;
        }
        return indirizzo && indirizzo.properties && indirizzo.properties.loccsiLabel ? indirizzo.properties.loccsiLabel : '';
    }

    toggleStradarioImpianto($event) {
        if (this.insertForm.controls["stradario"].value) {
            this.insertForm.controls["indirizzoLoccsi"].clearValidators();
            this.insertForm.controls["indirizzoLoccsi"].updateValueAndValidity();
            this.insertForm.controls["civicoLoccsi"].clearValidators();
            this.insertForm.controls["civicoLoccsi"].updateValueAndValidity();

            this.insertForm.controls["indirizzo"].setValidators([Validators.required]);
            //this.insertForm.controls["civico"].setValidators([Validators.required]);
            this.insertForm.controls["civico"].clearValidators();
            this.insertForm.controls["indirizzo"].updateValueAndValidity();
            this.insertForm.controls["civico"].updateValueAndValidity();
            this.insertForm.controls["comune"].setValidators([Validators.required]);
            this.insertForm.controls["comune"].updateValueAndValidity();
            this.insertForm.controls["provincia"].setValidators([Validators.required]);
            this.insertForm.controls["provincia"].updateValueAndValidity();

        } else {
            this.insertForm.controls["indirizzo"].clearValidators();
            this.insertForm.controls["civico"].clearValidators();
            this.insertForm.controls["indirizzo"].updateValueAndValidity();
            this.insertForm.controls["civico"].updateValueAndValidity();
            this.insertForm.controls["comune"].clearValidators();
            this.insertForm.controls["comune"].updateValueAndValidity();
            this.insertForm.controls["provincia"].clearValidators();
            this.insertForm.controls["provincia"].updateValueAndValidity();

            this.insertForm.controls["indirizzoLoccsi"].setValidators([Validators.required]);
            this.insertForm.controls["indirizzoLoccsi"].updateValueAndValidity();
            this.insertForm.controls["civicoLoccsi"].updateValueAndValidity();
        }
    }
    // Aggiungi qui i metodi e le proprietà del componente

    isVericaImpiantoSubentroVisible() {
        if (this.ruolo == RUOLI.RUOLO_SUPER ||
            this.ruolo == RUOLI.RUOLO_VALIDATORE ||
            this.ruolo == RUOLI.RUOLO_IMPRESA ||
            this.ruolo == RUOLI.RUOLO_RESPONSABILE ||
            this.ruolo == RUOLI.RUOLO_RESPONSABILE_IMPRESA ||
            this.ruolo == RUOLI.RUOLO_PROPRIETARIO ||
            this.ruolo == RUOLI.RUOLO_PROPRIETARIO_IMPRESA) {
            return true;
        }
        return false;
    }

    isVericaImpiantoNominaTerzoResponsabileVisible() {
        if (this.ruolo == RUOLI.RUOLO_SUPER ||
            this.ruolo == RUOLI.RUOLO_VALIDATORE ||
            // this.ruolo == RUOLI.DELEGATO 3 RESPONSABILE ?????
            this.ruolo == RUOLI.RUOLO_3RESPONSABILE) {
            return true;
        }
        return false;
    }

    verificaImpiantoSubentro() {
        let datiImpianto: DatiImpianto = this.buildDatiImpianto();
        datiImpianto.codiceImpianto = this.insertForm.get("codiceImpianto").value;

        const checkContrattoInEssere = [RUOLI.RUOLO_SUPER, RUOLI.RUOLO_VALIDATORE, RUOLI.RUOLO_IMPRESA].includes(this.ruolo);

        this.impiantoService.verifyIndirizzoImpianto(datiImpianto, checkContrattoInEssere).subscribe(() => {
            //TODO chiamare elenco subentri disponibili
            /**
             * Se utente ha ruolo superuser mostra M019_2
             * Altrimenti M019_4
             */
            switch (this.ruolo) {
                case RUOLI.RUOLO_SUPER:
                case RUOLI.RUOLO_VALIDATORE:
                case RUOLI.RUOLO_IMPRESA:                
                    // case RUOLI.DELEGATO_SU_IMPRESA?:
                    //mostra M019_2
                    this.router.navigate(["/nomina/seleziona-subentro"],
                        {
                            queryParams: {
                                codiceImpianto: datiImpianto.codiceImpianto,
                                id_persona_giuridica: this.datiImpresa ? this.datiImpresa?.id_persona_giuridica : undefined
                            },
                            state: { impresa: this.datiImpresa }
                        });
                    break;
                default:
                    this.router.navigate(["/nomina/effettua-subentro"],
                        {
                            queryParams: {
                                codiceImpianto: datiImpianto.codiceImpianto,
                                id_persona_giuridica: this.datiImpresa ? this.datiImpresa?.id_persona_giuridica : undefined
                            },
                            state: { impresa: this.datiImpresa }
                        });
                    //mostra M019_4
                    break;
            }
        }, (err) => {
            if (err?.error && err.error.descrizioneEsito /**check codice di errore */) {
                if (err.error.descrizioneEsito == "NOIMPIANTO") {
                    this.noImpiantoAction();
                } else if (err.error.descrizioneEsito == "S070") {
                    this.messageService.setTitolo("Errore");
                    this.messageService.setDescrizione("Il codice impianto non risulta presente all'indirizzo indicato");
                    this.messageService.setType(2);
                    this.messageService.showMessaggioM();
                } else {
                  this.messageService.setTitolo("Errore");
                  this.messageService.setDescrizione(err.error.descrizioneEsito);
                  this.messageService.setType(2);
                  this.messageService.showMessaggioM();
                }
            }

        });
    }


    verificaTerzoResponsabile() {
        //richiamare a019_7 elenco responsabili impianto e mostrare la m019_5 responsabili e contratto
        let datiImpianto: DatiImpianto = this.buildDatiImpianto();
        let impresaSelected = this.sharedService.getImpresaSelected();
        if(impresaSelected && impresaSelected.flg_terzo_responsabile == 0){
            this.messageService.setTitolo("Errore");
            this.messageService.setDescrizione("Impresa e' presente a sistema ma non e' dichiarata con ruolo terzo responsabile");
            this.messageService.setType(2);
            this.messageService.showMessaggioM();
            return;
        }
        datiImpianto.codiceImpianto = this.insertForm.get("codiceImpianto").value;
        this.impiantoService.verifyIndirizzoImpianto(datiImpianto).subscribe((res) => {
            this.router.navigate(["/nomina/nomina"],
                {
                    queryParams: { codiceImpianto: datiImpianto.codiceImpianto },
                    state: { impresa: this.datiImpresa }
                });

        }, (err) => {
            if (err?.error && err.error.descrizioneEsito /**check codice di errore */) {
                if (err.error.descrizioneEsito == "NOIMPIANTO") {
                    this.noImpiantoAction();
                } else if (err.error.descrizioneEsito == "S070") {
                    this.messageService.setTitolo("Errore");
                    this.messageService.setDescrizione("Il codice impianto non risulta presente all'indirizzo indicato");
                    this.messageService.setType(2);
                    this.messageService.showMessaggioM();
                }
            }
        });
    }

    /**
     * Gestisco il caso che l'impianto non sia presente a sistema e navigo verso la creazione o mostro solo il messaggio
     */
    noImpiantoAction() {
        switch (this.ruolo) {
            case RUOLI.RUOLO_SUPER:
            case RUOLI.RUOLO_VALIDATORE:
            case RUOLI.RUOLO_IMPRESA:
                this.router.navigate(["/nomina/effettua-subentro"],
                    {
                        queryParams: {
                            noImpianto: true
                        }
                    });
                break;
            default:
                this.messageService.setTitolo("Errore");
                this.messageService.setDescrizione("Il codice impianto non risulta presente nel sistema");
                this.messageService.setType(2);
                this.messageService.showMessaggioM();
                break;
        }
    }

    buildDatiImpianto(): DatiImpianto {
        let datiImpianto = {};
        let stradario = this.insertForm.controls["stradario"].value;
        if (stradario) {
            datiImpianto['comune'] = this.currentAddressComuni.properties.comune;
            datiImpianto['siglaProv'] = this.currentAddressComuni.properties.siglaProvincia;
            datiImpianto['istatComune'] = this.currentAddressComuni.properties.codiceIstat;
            datiImpianto['provincia'] = this.insertForm.controls["provincia"].value;
            datiImpianto['indirizzoNonTrovato'] = this.insertForm.controls["indirizzo"].value;
            if(this.insertForm.controls["civico"].value == undefined || this.insertForm.controls["civico"].value == null){
                datiImpianto['civico'] = "" ;
            }else{
                datiImpianto['civico'] = this.insertForm.controls["civico"].value ;
            }
        } else {

            let propStr = this.currentAddress.properties.tipoVia;
            propStr += this.currentAddress.properties.preposizione
                && this.currentAddress.properties.preposizione != "" ? " " + this.currentAddress.properties.preposizione : "";
            propStr += " " + this.currentAddress.properties.nomeVia;
            datiImpianto['indirizzoSitad'] = propStr;
            let civico = this.currentAddress.properties.civicoNum ? this.currentAddress.properties.civicoNum : "";
            civico += this.currentAddress.properties.civicoSub ? this.currentAddress.properties.civicoSub : "";
            datiImpianto['civico'] = civico ? civico : this.insertForm.controls["civicoLoccsi"].value;
             }
        return datiImpianto as DatiImpianto;
    }
}
