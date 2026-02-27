import { Component, EventEmitter, HostListener, Input, OnInit, Output } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { debounceTime, distinctUntilChanged, filter, map } from 'rxjs/operators';
import { validateCFPIVA } from '../../../common/validators/custom.validator';
import { ComuneEsteso } from '../../../models/common/comune-esteso.model';
import { LoccsiFeature } from '../../../models/common/loccsi-feature';
import { Provincia } from '../../../models/common/provincia.model';
import { DatiImpresa } from '../../../models/dati-impresa';
import { UtenteLoggato } from '../../../models/utente-loggato';
import { AccreditamentoService } from '../../../services/accreditamento.service';
import { ImpiantoService } from '../../../services/impianto.service';
import { SharedService } from '../../../services/shared.service';
import { SvistaService } from '../../../services/svista.service';
import { ICONSURL } from '../../../utils/constants';
@Component({
    selector: 'commonwcl-accreditamento-impresa',
    templateUrl: './accreditamento-impresa.component.html',
    styleUrls: ['./accreditamento-impresa.component.scss']
})
export class AccreditamentoImpresaComponent implements OnInit {

    pgRed: string = ICONSURL + "impresa_red.svg";


    @Input() codiceFiscalePF: string;
    @Input() impresa: DatiImpresa;
    @Input() onlyView: boolean = false;
    @Input() apiUrl: string;

    @Output() onMessage = new EventEmitter<any>();

    //GESTIONE COMUNI-STRADE
    currentAddressProp: LoccsiFeature;
    filteredOptionsProp: Observable<LoccsiFeature[]>;
    indirizziProp: LoccsiFeature[] = [];
    tempAddressProp: LoccsiFeature[] = [];
    loccsiClickedProp = false;

    loccsiClickedPropComuni = false;
    currentAddressPropComuni: LoccsiFeature;
    //filteredOptionsPropComuni: Observable<LoccsiFeature[]>;
    comuniProp: LoccsiFeature[] = [];
    currentAddressPropComuniEsteso: ComuneEsteso;
    filteredOptionsPropComuni: Observable<ComuneEsteso[]> = null;
    comuniEstesoProp: ComuneEsteso[] = [];
    //END COMUNI-STRADE

    sigleRea = [];

    update: boolean = false;

    minDate: Date = new Date();

    // atLeastOneCheckboxSelected: ValidatorFn = (control: AbstractControl) => {
    //     if (this.formImpresaGroup) {
    //         const checkbox1 = this.formImpresaGroup.get('flg_amministratore');
    //         const checkbox2 = this.formImpresaGroup.get('flg_sogg_incaricato');
    //         return (checkbox1.value || checkbox2.value) ? null : { required: true };
    //     } else {
    //         return null;
    //     }
    // };

    getCheckboxRequired(id: string) {
        if (id === "flg_amministratore" || id === "flg_sogg_incaricato") {
            if (this.formImpresaGroup.get('flg_amministratore').value || this.formImpresaGroup.get('flg_sogg_incaricato').value) {
                return false;
            } else {
                return true;
            }
        }
        return false;
    }

    colBreakpoint1: number;
    colBreakpoint2: number;
    colBreakpoint3: number;
    colBreakpoint4: number;
    colBreakpoint5: number;
    colBreakpoint6: number;
    rowSpanHigh: number = window.innerWidth < 768 ? 4 : 2;

    formImpresaGroup: FormGroup;
    isModificaEnabled: boolean = false;
    isNewImpresa: boolean = false;
    isFlgSoggIncaricatoHidden: boolean = true;

    isInit: boolean = true;

    countDichiarazioniPerCheckRea = 0; //Mi serve un contatore per avere il numero di dichiarazioni compilate

    formImpresa: any = [{
        id: "denominazione",
        label: "Denominazione",
        // value: this.impresa["denominazione"],
        type: "text",
        validators: [
            Validators.required
        ]
    },
    {
        id: "sigla_rea",
        label: "Sigla REA",
        type: "siglaRea",
        // validators: [Validators.required, Validators.maxLength(2), Validators.minLength(2), Validators.pattern("^[a-zA-Z]*$")],
        hidden: this.isNewImpresaFun
    },
    {
        id: "numero_rea",
        label: "Numero REA",
        // value: this.impresa.numeroRea,
        type: "text",
        validators: [
            // Validators.required, Validators.maxLength(10)
        ],
        hidden: this.isNewImpresaFun
    },
    {
        id: "codice_rea",
        label: "Codice REA",
        type: "text",
        validators: [
        ],
        hidden: this.isNotNewImpresa
    },
    {
        id: "codice_fiscale",
        label: "Codice Fiscale",
        // value: this.impresa.codiceFiscale,
        type: "text",
        validators: [
            Validators.required, validateCFPIVA()
        ]
    },
    {
        id: "desStato",
        label: "Stato Impresa",
        // value: this.impresa.codiceFiscale,
        type: "text",
        validators: [
        ],
        hidden: this.isNotNewImpresa
    },
    {
        id: "data_inizio_attivita",
        label: "Data inizio attività",
        // value: this.impresa.dataInizioAttivita,
        type: "date",
        maxDate: new Date(),
        validators: [
            Validators.required
        ]
    },
    {
        id: "data_cessazione",
        label: "Data cessazione",
        // value: this.impresa.dataInizioAttivita,
        type: "date",
        minDateFn: () => { return this.impresa.data_inizio_attivita },
        maxDate: new Date(),
        validators: [
        ],
        hidden: this.isNotNewImpresa
    },
    {
        id: "flg_indirizzo_estero",
        label: "Indirizzo Estero",
        // value: this.impresa.flgIndirizzoEstero,
        click: this.residenzaEsteraClick,
        type: "checkbox",
        required: false,
        hidden: this.isFlgIndirizzoNonTrovatoChecked
    },
    {
        id: "stato_estero",
        label: "Stato Estero",
        // value: this.impresa.statoEstero,
        type: "text",
        validators: [],
        hidden: this.isFlgIndirizzoEsteroChecked
    },
    {
        id: "citta_estero",
        label: "Città Estero",
        // value: this.impresa.cittaEstero,
        type: "text",
        validators: [],
        hidden: this.isFlgIndirizzoEsteroChecked
    },
    {
        id: "indirizzo_estero",
        label: "Indirizzo Estero",
        // value: this.impresa.indirizzoEstero,
        type: "text",
        validators: [],
        hidden: this.isFlgIndirizzoEsteroChecked
    },
    {
        id: "cap_estero",
        label: "CAP Estero",
        // value: this.impresa.capEstero,
        type: "text",
        validators: [],
        hidden: this.isFlgIndirizzoEsteroChecked
    },
    {
        id: "indirizzo_sitad",
        label: "Indirizzo",
        // value: this.impresa.indirizzoSitad,
        type: "indirizzo_sitad",
        validators: [
            Validators.required
        ],
        hidden: this.isNotEsteroAndNotIndirizzoNonTrovato
    },
    {
        id: "civico",
        label: "Civico",
        // value: this.impresa.civico,
        type: "text",
        validators: [
            Validators.required
        ],
        hidden: this.isNotEsteroAndNotIndirizzoNonTrovato
    },
    {
        id: "stradario", //?
        label: "Non trovato nello stradario",
        // value: this.impresa.indirizzoNonTrovato,
        type: "checkbox",
        click: this.stradarioClick,
        required: false,
        hidden: this.isNotFlgIndirizzoEsteroChecked
    },
    {
        id: "indirizzo_non_trovato",
        label: "Indirizzo",
        // value: this.impresa.indirizzoSitad,
        type: "text",
        validators: [
        ],
        hidden: this.isNotFlgIndirizzoNonTrovatoChecked
    },
    {
        id: "civico",
        label: "Civico",
        // value: this.impresa.civico,
        type: "text",
        validators: [
            Validators.required
        ],
        hidden: this.isNotFlgIndirizzoNonTrovatoChecked
    },
    // {
    //     id: "comune",
    //     label: "Comune",
    //     // value: this.impresa.comune,
    //     type: "text",
    //     validators: [
    //         Validators.required
    //     ],
    //     hidden: this.isNotFlgIndirizzoNonTrovatoChecked
    // },
    {
        id: "comune",
        label: "Comune",
        type: "comune",
        displayFn: this.displayFnComune,
        options: this.filteredOptionsPropComuni,
        hidden: this.isNotFlgIndirizzoNonTrovatoChecked
    },
    {
        id: "provincia",
        label: "Provincia",
        // value: this.impresa.provincia,
        type: "text",
        validators: [
            Validators.required
        ],
        hidden: this.isNotFlgIndirizzoNonTrovatoChecked
    },
    // {
    //     id: "cap",
    //     label: "CAP",
    //     // value: this.impresa.cap,
    //     type: "text",
    //     validators: [
    //         Validators.required
    //     ]
    // },
    {
        id: "email",
        label: "Email",
        // value: this.impresa.email,
        type: "email",
        validators: [
            Validators.required,
            Validators.email
        ]
    },
    {
        id: "pec",
        label: "PEC",
        // value: this.impresa.pec,
        type: "email",
        validators: [
            Validators.email
        ]
    },
    {
        id: "telefono",
        label: "Telefono",
        // value: this.impresa.telefono,
        type: "text",
        validators: [
        ]
    }];
    formDichiarazioni: any = [
        {
            label: "Si dichiara che l'impresa è abilitata ad adoperare sugli impianti di climatizzazione invernale/estiva ed è abilitata ai sensi del DM 37/08, art.1 alle seguenti lettere:",
            rowSpan: this.rowSpanHigh,
            options: [
                {
                    id: "flg_dm37_letterac",
                    label: "C) Impianti di riscaldamento",
                    type: "checkbox",
                    // value: this.impresa.flgDm37Letterac,
                },
                {
                    id: "flg_dm37_letterad",
                    label: "D) Impianti idrico sanitari",
                    type: "checkbox",
                    // value: this.impresa.flgDm37Letterad,
                },
                {
                    id: "flg_dm37_letterae",
                    label: "E) impianti per la distribuzione e l'utilizzazione di gas",
                    type: "checkbox",
                    // value: this.impresa.flgDm37Letterae,
                }
            ]
        },
        {
            label: "Si dichiara inoltre che:",
            options: [
                {
                    id: "flg_fgas",
                    label: "È iscritta al Registro di cui al DPR 146/2018 (F-GAS)",
                    type: "checkbox",
                    // value: this.impresa.flgFgas
                },
                {
                    id: "flg_conduttore",
                    label: "È abilitata alla conduzione di impianti con P > 232 Kw ",
                    type: "checkbox",
                    // value: this.impresa.flgConduttore,
                },
                {
                    id: "flg_terzo_responsabile",
                    label: "Opera in qualità di Terzo Responsabile",
                    type: "checkbox",
                    // value: this.impresa.flgTerzoResponsabile
                },
                {
                    id: "flg_cat",
                    label: "È un soggetto delegato",
                    type: "checkbox",
                    disabled: true
                    // value: this.impresa.flgCat
                }
                ,
                {
                    id: "flg_distributore",
                    label: "E' un distributore, fornitore o venditore di combustibile/energia",
                    type: "checkbox",
                    // value: this.impresa.flgDistributore
                }
            ]
        },
        {
            label: "La presente dichiarazione è redatta in qualità di*:",
            options: [
                {
                    id: "flg_amministratore",
                    label: "Amministratore o legale rappresentante",
                    type: "checkbox",
                    validators: [],
                    // value: this.impresa.flgAmministratore,
                },
                {
                    id: "flg_sogg_incaricato",
                    label: "Soggetto incaricato (es. enti pubblici) con atto/delega",
                    type: "checkbox",
                    validators: [],
                    // value: this.impresa.flgSoggIncaricato
                },
                {
                    id: "delega_sogg_incaricato",
                    label: "Sogg. incaricato",
                    type: "text",
                    // value: this.impresa.delegaSoggIncaricato,
                    hidden: this.isFlgSoggIncaricatoHiddenFun
                }
            ]
        }
    ];

    displayFn(indirizzo: LoccsiFeature | string): string {
        // if (typeof indirizzo === 'string') {
        //     if (indirizzo && indirizzo != "") {
        //         return indirizzo + ", " + this.formImpresaGroup.controls['comune'].value;
        //     } else {
        //         return "";
        //     }
        // }

        // return indirizzo && indirizzo.properties && indirizzo.properties.loccsiLabel ? indirizzo.properties.loccsiLabel : '';
        if (typeof indirizzo === 'string') {
            if (indirizzo) {
                return indirizzo + ", " + this.formImpresaGroup.controls['comune'].value;
            } else {
                return "";
            }
        }
        return indirizzo && indirizzo.properties && indirizzo.properties.loccsiLabel ? (indirizzo.properties.loccsiLabel) : '';
    }

    displayFnComune(indirizzo: ComuneEsteso | string): string {
        if (typeof indirizzo === 'string') {
            return indirizzo;
        }
        return indirizzo && indirizzo.comune ? indirizzo.comune : '';
    }

    constructor(
        private router: Router,
        private fb: FormBuilder,
        private svistaService: SvistaService,
        private impiantoService: ImpiantoService,
        private sharedService: SharedService,
        private accreditamentoService: AccreditamentoService,
    ) {
        // this.accreditamentoService.init(this.apiUrl);
        // this.impiantoService.init(this.apiUrl);
        // this.svistaService.init(this.apiUrl);
        this.prepareView();
    }

    initService() {
        this.accreditamentoService.init(this.apiUrl);
        this.impiantoService.init(this.apiUrl);
        this.svistaService.init(this.apiUrl);
        let province: Provincia[] = this.svistaService.loadProvinceFromLocalStorage();
        this.sigleRea = province.map((provincia) => provincia.siglaProvincia);
    }

    ngOnInit(): void {
        console.log(this.codiceFiscalePF);
        // Initialization code goes here
        this.initService();
        this.prepareView();
        let validators: any = {};
        this.formImpresa.forEach((field) => {
            validators[field["id"]] = ["", field["validators"] || []];
        });
        this.formDichiarazioni.forEach((field) => {
            field.options.forEach((subField) => {
                validators[subField["id"]] = ["", subField["validators"] || []];
            });
        });
        this.formImpresaGroup = this.fb.group({
            ...validators
        });

        if (this.impresa?.codice_fiscale) {
            this.update = true;
        }
        // this.formImpresaGroup.addControl('checkbox_required', new FormGroup);
        // });

        // this.formImpresaGroup.addControl('checkbox_required', new FormGroup({
        //     checkbox1: this.formImpresaGroup.get('flg_amministratore'),
        //     checkbox2: this.formImpresaGroup.get('flg_sogg_incaricato')
        // }, { validators: this.atLeastOneCheckboxSelected }));

        // this.formImpresaGroup.disable();
        this.formImpresaGroup.controls['flg_sogg_incaricato'].valueChanges.subscribe((value) => {
            console.log(value);
            this.isFlgSoggIncaricatoHidden = !value;
            if (value) {
                this.formImpresaGroup.controls['delega_sogg_incaricato'].setValidators([Validators.required]);
            } else {
                this.formImpresaGroup.controls['delega_sogg_incaricato'].setValidators([]);
            }
            this.formImpresaGroup.controls['delega_sogg_incaricato'].updateValueAndValidity();
            this.formImpresaGroup.controls['flg_amministratore'].markAsTouched();
            this.formImpresaGroup.updateValueAndValidity();
        });
        this.formImpresaGroup.controls['flg_amministratore'].valueChanges.subscribe((value) => {
            this.formImpresaGroup.controls['flg_sogg_incaricato'].markAsTouched();
        });

        this.formImpresaGroup.controls['flg_indirizzo_estero'].valueChanges.subscribe((value) => {
            // if (!this.isInit) {
            if (value !== null && (value === 1 || value === true)) {
                this.clearValidators(this.formImpresaGroup.controls['indirizzo_sitad']);
                this.clearValidators(this.formImpresaGroup.controls['civico']);
                this.clearValidators(this.formImpresaGroup.controls['comune']);
                this.clearValidators(this.formImpresaGroup.controls['provincia']);
                this.formImpresaGroup.controls['indirizzo_estero'].setValidators([Validators.required]);
                this.formImpresaGroup.controls['citta_estero'].setValidators([Validators.required]);
                this.formImpresaGroup.controls['stato_estero'].setValidators([Validators.required]);
                this.formImpresaGroup.controls['cap_estero'].setValidators([Validators.required]);
            } else if (value !== null && (value === 0 || value === false)) {
                this.clearValidators(this.formImpresaGroup.controls['indirizzo_estero']);
                this.clearValidators(this.formImpresaGroup.controls['citta_estero']);
                this.clearValidators(this.formImpresaGroup.controls['stato_estero']);
                this.clearValidators(this.formImpresaGroup.controls['cap_estero']);
                this.formImpresaGroup.controls['indirizzo_sitad'].setValidators([Validators.required]);
                this.formImpresaGroup.controls['civico'].setValidators([Validators.required]);
            }
            this.formImpresaGroup.updateValueAndValidity();
            // }
        });
        this.formImpresaGroup.controls['stradario'].valueChanges.subscribe((value) => {
            // if (!this.isInit) {
            if (value !== null && (value === 1 || value === true)) {
                this.formImpresaGroup.controls['indirizzo_non_trovato'].setValidators([Validators.required]);
                this.formImpresaGroup.controls['civico'].setValidators([Validators.required]);
                this.formImpresaGroup.controls['comune'].setValidators([Validators.required]);
                this.formImpresaGroup.controls['provincia'].setValidators([Validators.required]);
                this.formImpresaGroup.controls['indirizzo_sitad'].clearValidators();
                this.formImpresaGroup.controls['indirizzo_estero'].clearValidators();
                this.formImpresaGroup.controls['citta_estero'].clearValidators();
                this.formImpresaGroup.controls['stato_estero'].clearValidators();
                this.formImpresaGroup.controls['cap_estero'].clearValidators();
                this.formImpresaGroup.controls['indirizzo_non_trovato'].updateValueAndValidity();
            } else if (value !== null && (value === 0 || value === false) && !this.formImpresaGroup.controls['flg_indirizzo_estero'].value) {
                this.formImpresaGroup.controls['indirizzo_sitad'].setValidators([Validators.required]);
                this.formImpresaGroup.controls['indirizzo_non_trovato'].clearValidators();
                this.formImpresaGroup.controls['indirizzo_non_trovato'].updateValueAndValidity();
            }
            // this.updateValueAndValidity();
            this.formImpresaGroup.controls['indirizzo_sitad'].updateValueAndValidity();
            this.formImpresaGroup.updateValueAndValidity();
            // }
            // this.updateValueAndValidity();
        });

        this.formImpresaGroup.controls['indirizzo_sitad'].valueChanges
            .pipe(debounceTime(500), distinctUntilChanged(), filter(data => data ? data.length >= 3 : false)).subscribe(elem => {
                if (typeof elem === "string" && elem !== this.impresa.indirizzo_sitad) {
                    this.loccsiClickedProp = false;
                    // this.currentAddressProp = undefined;
                    const elem2 = elem;
                    this.formImpresaGroup.controls['civico'].enable();
                    this.filteredOptionsProp = this.impiantoService.getIndirizzoStradario(elem2)
                        .pipe(
                            map(name => name ? name : this.indirizziProp.slice()));
                }
            });

        this.formImpresaGroup.controls['comune'].valueChanges
            .pipe(debounceTime(500), distinctUntilChanged(), filter(data => data ? data.length >= 2 : false)).subscribe(elem => {
                if (typeof elem === "string") {
                    this.loccsiClickedPropComuni = false;
                    // this.currentAddressPropComuni = undefined;
                    const elem2 = elem;
                    this.filteredOptionsPropComuni = this.svistaService.loadDataFromLocalStorage(elem2)
                        .pipe(
                            map(name => name ? name : this.comuniEstesoProp.slice()));

                }
            });

        //01/01/2024 Aggiunta per codice rea e numero rea obbligatori in caso di checkbox selezionata
        this.formDichiarazioni.slice(0, 2).forEach((field) => {
            field.options.forEach((subField) => {
                this.formImpresaGroup.controls[subField["id"]].valueChanges.subscribe((value) => {
                    if (value) {
                        this.countDichiarazioniPerCheckRea++;
                    } else {
                        this.countDichiarazioniPerCheckRea--;
                    }
                    if (this.countDichiarazioniPerCheckRea > 0) {
                        this.formImpresaGroup.controls['sigla_rea'].setValidators([Validators.required, Validators.maxLength(2), Validators.minLength(2), Validators.pattern("^[a-zA-Z]*$")]);
                        this.formImpresaGroup.controls['numero_rea'].setValidators([Validators.required, Validators.maxLength(10)]);
                        this.formImpresaGroup.controls['sigla_rea'].updateValueAndValidity();
                        this.formImpresaGroup.controls['numero_rea'].updateValueAndValidity();
                    } else {
                        this.formImpresaGroup.controls['sigla_rea'].clearValidators();
                        this.formImpresaGroup.controls['numero_rea'].clearValidators();
                        this.formImpresaGroup.controls['sigla_rea'].updateValueAndValidity();
                        this.formImpresaGroup.controls['numero_rea'].updateValueAndValidity();
                    }

                });
            });
        });
        //End 01/01/2024 Aggiunta per codice rea e numero rea obbligatori in caso di checkbox selezionata
        this.init();

    }



    init() {
        this.normalizeData(this.impresa);
        this.formImpresaGroup.patchValue(this.impresa);
        if (this.onlyView) {
            this.formImpresaGroup.disable();
            //costruisco il codice_rea
            if (this.impresa['sigla_rea'] && this.impresa['numero_rea']) {
                this.formImpresaGroup.controls['codice_rea'].setValue(this.impresa['sigla_rea'] + "-" + this.impresa['numero_rea']);
            } else {
                this.formImpresaGroup.controls['codice_rea'].setValue("-");
            }
            this.disableFieldInEdit();
        }
        if (this.impresa['codice_fiscale']) {
            this.isModificaEnabled = true;
            //costruisco il codice_rea
            if (this.impresa['sigla_rea'] && this.impresa['numero_rea']) {
                this.formImpresaGroup.controls['codice_rea'].setValue(this.impresa['sigla_rea'] + "-" + this.impresa['numero_rea']);
            } else {
                this.formImpresaGroup.controls['codice_rea'].setValue("-");
            }
            this.disableFieldInEdit();
        } else {
            this.isModificaEnabled = true;
            this.isNewImpresa = true;
        }
        if (this.impresa.data_cessazione) {
            this.formImpresaGroup.controls['data_cessazione'].disable();
        }
        this.formImpresaGroup.controls['provincia'].disable();
        this.isInit = false;
    }


    /**
     * Disabilito i campi non modificabili
     */
    disableFieldInEdit() {
        //disabilito i campi non modificabili
        // this.formImpresaGroup.controls['denominazione'].disable();
        this.formImpresaGroup.controls['sigla_rea'].disable();
        this.formImpresaGroup.controls['numero_rea'].disable();
        this.formImpresaGroup.controls['codice_fiscale'].disable();
        this.formImpresaGroup.controls['codice_rea'].disable();
        this.formImpresaGroup.controls['desStato'].disable();
    }

    /**
     * Normalizzo le date
     * @param impresa
     */
    normalizeData(impresa: DatiImpresa) {
        impresa.data_inizio_attivita = impresa.data_inizio_attivita ? new Date(impresa.data_inizio_attivita.toString().split("[")[0]) : null;
        impresa.data_fine_legame = impresa.data_fine_legame ? new Date(impresa.data_fine_legame.toString().split("[")[0]) : null;
        impresa.data_cessazione = impresa.data_cessazione ? new Date(impresa.data_cessazione.toString().split("[")[0]) : null;
    }

    prepareView() {
        this.colBreakpoint1 = (window.innerWidth < 768) ? 12 : 6;
        this.colBreakpoint2 = (window.innerWidth < 768) ? 12 : 3;
        this.colBreakpoint3 = (window.innerWidth < 768) ? 0 : 9;
        this.colBreakpoint4 = (window.innerWidth < 768) ? 0 : 6;
        this.colBreakpoint5 = (window.innerWidth < 768) ? 2 : 1;
        this.colBreakpoint6 = (window.innerWidth < 768) ? 12 : 4;
        this.rowSpanHigh = window.innerWidth < 768 ? 4 : 2;
        window.scrollTo(0, 0);
    }



    @HostListener('window:resize', ['$event'])
    onResize(event?) {
        this.prepareView();
    }


    onDatePickerToggleClick(event: MouseEvent, fieldId: string) {
        const datePickerContainer = (event.target as HTMLElement).closest('.mat-datepicker-toggle'); // Find closest datepicker container
        const datePicker = document.getElementById('datePicker_' + fieldId) as any; // Get datepicker by ID
        const datePickerInput = datePickerContainer.querySelectorAll('input')[0]; // Get input element within container

        if (datePicker) {
            datePicker.open();
            datePickerInput.focus(); // Focus the input element (optional)
        } else {
            console.error('Datepicker element not found:', 'datePicker_' + fieldId); // Handle missing element scenario
        }
    }

    save() {
        this.formImpresaGroup.markAllAsTouched();
        if (!this.formImpresaGroup.valid || !this.isDichiarazioneRedattaChecked()) {
            return;
        }
        let flgObbligatori = ["flg_dm37_letterac", "flg_terzo_responsabile", "flg_sogg_incaricato", "flg_distributore"];
        let formResult = this.formImpresaGroup.getRawValue();
        formResult.flg_indirizzo_estero = this.formImpresaGroup.controls['flg_indirizzo_estero']?.value ? 1 : 0;
        formResult.stradario = this.formImpresaGroup.controls['stradario']?.value ? 1 : 0;
        let result = {};
        let obj = { ...this.impresa, ...formResult };
        result = obj;
        for (const key in formResult) {
            let changed = false;
            if (formResult[key] === null || formResult[key] === undefined || formResult[key] === "") {
                if (flgObbligatori.includes(key) || key.startsWith("flg_")) {
                    result[key] = +formResult[key];
                }
                continue;
            }
            if (formResult[key] == true) {
                changed = true;
                result[key] = +formResult[key];
            }
            if (formResult[key] == false) {
                changed = true;
                result[key] = +formResult[key];
            }
            if (!changed)
                result[key] = formResult[key];
        }
        if (result['stradario'] == 0 && result['flg_indirizzo_estero'] == 0 && this.currentAddressProp) {
            result['indirizzo_sitad'] = this.currentAddressProp.properties.tipoVia + " " + this.currentAddressProp.properties.nomeVia;
            result['istat_comune'] = this.currentAddressProp.properties.codiceIstat;
            result['sigla_prov'] = this.currentAddressProp.properties.siglaProvincia;
        } else if (this.currentAddressPropComuniEsteso) {
            result['istat_comune'] = this.currentAddressPropComuniEsteso.codiceIstat;
            result['sigla_prov'] = this.currentAddressPropComuniEsteso.siglaProvincia;
        }
        if (result['stradario'] == 1) {
            result['indirizzo_sitad'] = "";
            result['indirizzo_estero'] = "";
            result['citta_estero'] = "";
            result['stato_estero'] = "";
            result['cap_estero'] = "";
        } else if (result['flg_indirizzo_estero'] == 1) {
            result['indirizzo_non_trovato'] = "";
            result['indirizzo_sitad'] = "";
            result['civico'] = "";
            result['comune'] = "";
            result['provincia'] = "";
            result['istat_comune'] = "";
            result['sigla_prov'] = "";
            result['cap'] = "";
        } else {
            result['indirizzo_estero'] = "";
            result['citta_estero'] = "";
            result['stato_estero'] = "";
            result['cap_estero'] = "";
            result['indirizzo_non_trovato'] = "";
        }
        if (result['numero_rea'] == "") {
            result['numero_rea'] = null;
        }
        let utenteLoggato: UtenteLoggato = this.sharedService.getUtenteLoggato();
        this.accreditamentoService.setImpresaAssociata(this.update, utenteLoggato.pfLoggato.codiceFiscalePF, obj).subscribe((data: any) => {
            this.onMessage.emit({
                titolo: "Successo",
                descrizione: "Impresa salvata correttamente", type: 4
            });
            this.router.navigate(['/accreditamento']);
        }, (error) => {
            let action = this.isNewImpresa ? "creare" : "modificare"
            if (error?.error && JSON.parse(error?.error).descrizioneEsito) {
                this.onMessage.emit({
                    titolo: "Errore",
                    descrizione: JSON.parse(error?.error).descrizioneEsito, type: 2
                });
            } else {
                this.onMessage.emit({
                    titolo: "Errore",
                    descrizione: "Impossibile " + action + " l'impresa.", type: 2
                });
            }
        });
    }

    isDichiarazioneRedattaChecked() {
        if (this.formImpresaGroup.controls['flg_amministratore'].value == true
            // ||this.formImpresaGroup.controls['flg_dm37_letterac'].value == true
            // ||this.formImpresaGroup.controls['flg_terzo_responsabile'].value == true
            // ||this.formImpresaGroup.controls['flg_distributore'].value == true
            // ||this.formImpresaGroup.controls['flg_cat'].value == true
            || this.formImpresaGroup.controls['flg_sogg_incaricato'].value == true) {
            return true;
        }
        return false;
    }

    test() {
        console.log(this.formImpresaGroup);
    }


    back() {
        this.router.navigate(['/accreditamento']);
    }

    isEnabledModifica() {
        return this.isModificaEnabled;
    }

    isNotEnabledModifica() {
        return !this.isModificaEnabled;
    }

    isNewImpresaFun() {
        return this.isNewImpresa;
    }

    isNotNewImpresa() {
        return !this.isNewImpresa
    }

    isNotOnlyView() {
        return this.onlyView;
    }

    isOnlyView() {
        return !this.onlyView
    }

    isOnlyViewOrModify() {
        return this.onlyView || !this.isModificaEnabled;
    }

    isNotOnlyViewOrModify() {
        return !((this.onlyView || this.isModificaEnabled) && this.isNewImpresa);
    }

    isPropPresent() {
        return true;
    }

    getFilteredOptionsPropComuni() {
        if (this.filteredOptionsPropComuni)
            return this.filteredOptionsPropComuni
        return [];
    }

    changeModifica() {
        this.isModificaEnabled = !this.isModificaEnabled;
        if (this.isModificaEnabled) {
            this.formImpresaGroup.enable();
        } else {
            this.formImpresaGroup.disable();
        }
    }



    isFlgIndirizzoEsteroChecked() {
        return this.formImpresaGroup.controls['flg_indirizzo_estero'].value;
    }

    isNotFlgIndirizzoEsteroChecked() {
        return !this.formImpresaGroup.controls['flg_indirizzo_estero'].value;
    }

    isFlgSoggIncaricatoHiddenFun() {
        return this.isFlgSoggIncaricatoHidden;
    }

    isNotEsteroAndNotIndirizzoNonTrovato() {
        if (!this.formImpresaGroup.controls['flg_indirizzo_estero'].value && !this.formImpresaGroup.controls['stradario'].value) {
            return true;
        }
        return false;
    }


    isFlgIndirizzoNonTrovatoChecked() {
        return !this.formImpresaGroup.controls['stradario'].value;
    }

    isNotFlgIndirizzoNonTrovatoChecked() {
        return this.formImpresaGroup.controls['stradario'].value;
    }

    isNuovaImpresa() {
        return this.isNewImpresa;
    }

    setProvinciaComuneEstesoProp(feature: ComuneEsteso) {
        this.currentAddressPropComuniEsteso = feature;
        this.formImpresaGroup.controls['comune'].setValue(feature.comune ? feature.comune : "");
        this.formImpresaGroup.controls['provincia'].setValue(feature.provincia ? feature.provincia : "");
        // this.formImpresaGroup.controls['istat_comune'].setValue(feature.codiceIstat ? feature.codiceIstat : "");
        // this.formImpresaGroup.controls['sigla_prov'].setValue(feature.siglaProvincia ? feature.siglaProvincia : "");
        this.loccsiClickedPropComuni = true;
    }

    setLoccsiElem(feature: LoccsiFeature, ctx) {
        ctx.currentAddressProp = feature;
        if (feature.properties.civicoNum) {
            ctx.formImpresaGroup.controls['civico'].setValue(feature.properties.civicoNum +
                feature.properties.civicoSub);
            ctx.formImpresaGroup.controls['civico'].disable();
        }
        if (feature.properties.tipoVia) {
            let indirizzo = feature.properties.tipoVia + " " + feature.properties.nomeVia;
            ctx.formImpresaGroup.controls['indirizzo_sitad'].setValue(indirizzo);
        }
        ctx.formImpresaGroup.controls['comune'].setValue(feature.properties.comune);
        ctx.formImpresaGroup.controls['provincia'].setValue(feature.properties.descProvincia);
        // this.formImpresaGroup.controls['istat_comune'].setValue(feature.properties.codiceIstat ? feature.properties.codiceIstat : "");
        // this.formImpresaGroup.controls['sigla_prov'].setValue(feature.properties.siglaProvincia ? feature.properties.siglaProvincia : "");
        ctx.loccsiClickedProp = true;

    }


    get(fun: Function) {
        if (fun !== undefined) {
            return fun.call(this);
        }
        return true;
    }

    updateValueAndValidity() {
        let controls = this.formImpresaGroup.controls;
        for (const key in controls) {
            controls[key].updateValueAndValidity();
        }
    }

    clearValidators(control) {
        control.setValue('');
        control.clearValidators();
        control.updateValueAndValidity();
    }


    residenzaEsteraClick() {
        if (this.formImpresaGroup.controls['residenzaEstera'].value) {
            this.formImpresaGroup.controls['indirizzoSitad'].setValue('');
            this.formImpresaGroup.controls['indirizzoNonTrovato'].setValue('');
            this.formImpresaGroup.controls['civico'].setValue('');
            this.formImpresaGroup.controls['comune'].setValue('');
            this.formImpresaGroup.controls['provincia'].setValue('');
        } else {
            this.formImpresaGroup.controls['indirizzoEstero'].setValue('');
            this.formImpresaGroup.controls['cittaEstero'].setValue('');
            this.formImpresaGroup.controls['statoEstero'].setValue('');
            this.formImpresaGroup.controls['capEstero'].setValue('');
        }
    }

    stradarioClick() {
        if (this.formImpresaGroup.controls['stradario'].value) {
            this.formImpresaGroup.controls['indirizzoEstero'].setValue('');
            this.formImpresaGroup.controls['civico'].setValue('');
            this.formImpresaGroup.controls['cittaEstero'].setValue('');
            this.formImpresaGroup.controls['statoEstero'].setValue('');
            this.formImpresaGroup.controls['capEstero'].setValue('');
            this.formImpresaGroup.controls['indirizzoSitad'].setValue('');
        } else {
            this.formImpresaGroup.controls['indirizzoNonTrovato'].setValue('');
            this.formImpresaGroup.controls['civico'].setValue('');
            this.formImpresaGroup.controls['comune'].setValue('');
            this.formImpresaGroup.controls['provincia'].setValue('');
        }
    }



}
