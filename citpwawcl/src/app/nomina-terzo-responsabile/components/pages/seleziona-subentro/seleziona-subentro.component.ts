import { Component, HostListener, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { DatiImpresa } from 'src/app/models/dati-impresa';
import { SubentroComponenti } from 'src/app/models/subentro-componenti';
import { AuthenticationService } from 'src/app/services/authentication.service';
import { BackService } from 'src/app/services/back.service';
import { DialogService } from 'src/app/services/dialog.service';
import { ImpiantoService } from 'src/app/services/impianto.service';
import { LibrettoService } from 'src/app/services/libretto.service';
import { MessageService } from 'src/app/services/message.service';
import { SpinnerService } from 'src/app/services/spinner.service';
import { TitleService } from 'src/app/services/title.service';
import { ICONSURL, RUOLI } from 'src/app/utils/constants';
// import * as xmlJs from 'xml-js';

import { Location } from '@angular/common';
import * as xml2js from 'xml2js';
import { NominaTerzoResponsabileService } from '../../../../services/nomina.service';

@Component({
    selector: 'app-seleziona-subentro',
    templateUrl: './seleziona-subentro.component.html',
    styleUrls: ['./seleziona-subentro.component.scss']
})
export class SelezionaSubentroComponent implements OnInit {

    parser = new xml2js.Parser({
        tagNameProcessors: [
            // Questa funzione rimuove tutti i prefissi dei namespace
            (name) => name.replace(/^.+:/, '')
        ],
        explicitArray: false
    });

    Object = Object;
    subentro: string = ICONSURL + "subentro.svg";
    step: number = 0;
    selezionaSubentro = false;

    effettuaSubentroTitle = "Effettua subentro";
    selezionaTipoSubentroTitle = "Seleziona tipo subentro";
    subentroOccasionaleTitle = "Subentro tipo delega manutentore";
    subentroOccasionaleComponentiSubtitle = "Seleziona le componenti per la delega"

    title: string = "";
    subtitle: string = "";
    backTitile: string = "Torna a ricerca indirizzo e impianto";
    route: string = "" //"/nomina/ricerca-indirizzo";
    titoloMessaggio: string = "";
    descrzioneMessaggio: string = "";
    tipomessaggio: number = 0;
    showMessaggio: boolean = false;
    ruolo: any;
    datiImpianto: any;
    affidamentoOccasionale = false;

    colBreakpoint1: number;
    colBreakpoint2: number;
    colBreakpoint3: number;

    xmlLibretto: any;

    lastTitle;
    lastBackTitle;

    datiSchedaManutentore = {
        datiSchedaGT: { visible: false, title: "SUBENTRO SU COMPONENTI GT" },
        datiSchedaGF: { visible: false, title: "SUBENTRO SU COMPONENTI GF" },
        datiSchedaSC: { visible: false, title: "SUBENTRO SU COMPONENTI SC" },
        datiSchedaCG: { visible: false, title: "SUBENTRO SU COMPONENTI CG" },
        datiSchedaSP: { visible: false, title: "SUBENTRO SU COMPONENTI SP" }
    };
    manutentore: boolean = false;
    amministratoreCondominio: boolean = false;
    proprietario: boolean = false;
    occupante: boolean = false;

    componenti: any[];
    richiesta: any;
    impresa: DatiImpresa;
    codiceImpianto;
    idPersonaGiuridica;

    noImpianto: boolean = false;

    constructor(private authService: AuthenticationService,
        private router: Router,
        private activatedRouter: ActivatedRoute,
        private titoloService: TitleService,
        private backService: BackService,
        readonly messageService: MessageService,
        readonly spinnerService: SpinnerService,
        private impiantoService: ImpiantoService,
        private nominaService: NominaTerzoResponsabileService,
        private librettoService: LibrettoService,
        private dialogService: DialogService,
        private location: Location
    ) {
        this.backTitile = "Torna a ricerca indirizzo e impianto"
        this.backService.setBackTitle(this.backTitile);
        this.backService.setRoute(null);

        this.router?.url?.includes('effettua-subentro') ? this.selezionaSubentro = false : this.selezionaSubentro = true;
        this.activatedRouter.queryParams.subscribe((params) => {
            this.affidamentoOccasionale = params['affidamentoOccasionale'];
            this.codiceImpianto = params['codiceImpianto'];
            if (this.affidamentoOccasionale) {
                this.backService.setBackTitle("Torna indietro");
            }

            this.noImpianto = params['noImpianto'] ? params['noImpianto'] : false;
            this.idPersonaGiuridica = params['id_persona_giuridica'];
            if (this.affidamentoOccasionale) {
                this.route = params['returnUrl'];

            }
            if (!this.noImpianto) {
                this.loadLibretto(this.codiceImpianto);
            }
        });
        let state = this.router.getCurrentNavigation()?.extras?.state;
        if (state?.impresa) {
            this.impresa = state.impresa;
            this.idPersonaGiuridica = this.impresa.id_persona_giuridica;
        }
    }

    loadLibretto(codiceImpianto) {
        this.librettoService.getXmlLibrettoNowByCodice(codiceImpianto).subscribe((data) => {
            let decoded = atob(new TextDecoder().decode(data))
            console.log(decoded);
            this.parser.parseString(decoded, (err, result) => {
                if (err) {
                    console.error(err);
                    return;
                }
                this.richiesta = result?.MOD;
                this.initImpianto(this.richiesta);
            });
        }, (error) => {
            this.messageService.setTitolo("Errore");
            this.messageService.setDescrizione("Errore nel recupero dei dati");
            this.messageService.setType(2);
            this.messageService.showMessaggioM();
        });
    }

    initImpianto(data) {
        let utente = this.authService.getCurrentUserFromSession();
        this.datiImpianto = data?.Richiesta?.datiPrecompilati;
        this.xmlLibretto = data;
        localStorage.setItem('xmlNow', JSON.stringify(data));
        if (utente.ruoloLoggato.ruolo === RUOLI.RUOLO_SUPER ||
            utente.ruoloLoggato.ruolo === RUOLI.RUOLO_VALIDATORE ||
            utente.ruoloLoggato.ruolo === RUOLI.RUOLO_IMPRESA || this.affidamentoOccasionale
            // utente.ruoloLoggato.ruolo === RUOLI.RUOLO_SPAZZACAMINO ||
        ) {
            data.Richiesta.datiSchedaGT ? this.datiSchedaManutentore.datiSchedaGT.visible = true : this.datiSchedaManutentore.datiSchedaGT.visible = false;
            data.Richiesta.datiSchedaGF ? this.datiSchedaManutentore.datiSchedaGF.visible = true : this.datiSchedaManutentore.datiSchedaGF.visible = false;
            data.Richiesta.datiSchedaSC ? this.datiSchedaManutentore.datiSchedaSC.visible = true : this.datiSchedaManutentore.datiSchedaSC.visible = false;
            data.Richiesta.datiSchedaCG ? this.datiSchedaManutentore.datiSchedaCG.visible = true : this.datiSchedaManutentore.datiSchedaCG.visible = false;
            data.Richiesta.datiSchedaSP ? this.datiSchedaManutentore.datiSchedaSP.visible = true : this.datiSchedaManutentore.datiSchedaSP.visible = false;
            this.manutentore = true;
            console.log(data);
        } else if (
            utente.ruoloLoggato.ruolo === RUOLI.RUOLO_RESPONSABILE ||
            utente.ruoloLoggato.ruolo === RUOLI.RUOLO_RESPONSABILE_IMPRESA ||
            utente.ruoloLoggato.ruolo === RUOLI.RUOLO_PROPRIETARIO ||
            utente.ruoloLoggato.ruolo === RUOLI.RUOLO_PROPRIETARIO_IMPRESA ||
            utente.ruoloLoggato.ruolo === RUOLI.RUOLO_RESPONSABILE_IMPRESA
        ) {
            this.amministratoreCondominio = true;
            this.proprietario = true;
            this.occupante = true;
        }
    }

    arrayBufferToStringFileReader(buffer: ArrayBuffer): Promise<string> {
        return new Promise((resolve, reject) => {
            const blob = new Blob([buffer], { type: 'text/xml' }); // Create a Blob object from the buffer
            const reader = new FileReader();
            reader.readAsText(blob); // Read the Blob as text
            reader.onload = () => resolve(reader.result as string); // Resolve the Promise with the decoded string
            reader.onerror = reject; // Reject the Promise on error
        });
    }

    ngOnInit(): void {
        // Initialization code goes here
        this.ruolo = this.authService.getCurrentUserFromSession()?.ruoloLoggato?.ruolo;
        if (this.selezionaSubentro) {
            if (this.affidamentoOccasionale) {
                this.titoloService.setTitle(this.subentroOccasionaleTitle);
            } else {
                this.titoloService.setTitle(this.selezionaTipoSubentroTitle);
            }
        } else {
            if (this.affidamentoOccasionale) {
                this.titoloService.setTitle(this.subentroOccasionaleTitle);
            } else {
                this.titoloService.setTitle(this.effettuaSubentroTitle);
            }
        }
        this.colBreakpoint1 = (window.innerWidth < 768) ? 12 : 6;
        this.colBreakpoint2 = (window.innerWidth < 768) ? 0 : 6;
        this.colBreakpoint3 = (window.innerWidth < 768) ? 12 : 3;

    }

    ngAfterContentChecked() {
        this.doChange();
    }

    doChange() {
        this.title = this.titoloService.getTitle();
        this.subtitle = this.titoloService.getsubtitle();
        this.backTitile = this.backService.getBack();
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
        this.colBreakpoint3 = (event.target.innerWidth < 768) ? 12 : 3;
    }


    getFabbricante(codice: string): any | undefined {
      return this.xmlLibretto.Richiesta.datiPrecompilati.elencoFabbricante.fabbricante.find(f => f.codice === codice);
    }

    addManutentori(key: string) {
        let utenteLoggato = this.authService.getCurrentUserFromSession();
        let componenti = [];
        switch (key) {
            case "datiSchedaGT":
                // Richiesta.datiSchedaGT.sezGruppiTermici.rowGT[2].sezGTimpresa.impresaGT.L4_1codiceFiscale
                this.normalizeArray(this.xmlLibretto['Richiesta']['datiSchedaGT'].sezGruppiTermici.rowGT).forEach((element, index) => {
                    if (this.getSezione(element.sezGTimpresa).impresaGT.L4_1codiceFiscale === utenteLoggato.ruoloLoggato.piva ||
                        (this.impresa && this.getSezione(element.sezGTimpresa).impresaGT.L4_1codiceFiscale === this.impresa?.codice_fiscale)
                        || !(element.L4_1dataDismiss?.$ && element.L4_1dataDismiss?.$['xsi:nil'])) {
                        //dovrebbe essere codiceFiscaleImpresa , da dove lo prendo ?
                        return;
                    }
                    componenti.push({
                        sigla: "GT",
                        progressivo: element.L4_1numGT,
                        dataInstall: element.L4_1dataInstallaz,
                        modello: element.L4_1modello,
                        component: this.xmlLibretto['Richiesta']['datiSchedaGT'].sezGruppiTermici.rowGT[index],
                        fabbricante: element.L4_1fabbricante,
                        matricola: element.L4_1matricola,
                        potenza: element.L4_1potTermUtileMax
                    });
                });
                break;
            case "datiSchedaGF":
                this.normalizeArray(this.xmlLibretto['Richiesta']['datiSchedaGF'].sezGF.rowGF).forEach((element, index) => {
                    if (this.getSezione(element.sezGFimpresa).impresaGF.L4_4codiceFiscale === utenteLoggato.ruoloLoggato.piva ||
                        this.getSezione(element.sezGFimpresa).impresaGF.L4_4codiceFiscale === this.impresa?.codice_fiscale ||
                        !(element.L4_4dataDismiss?.$ && element.L4_4dataDismiss?.$['xsi:nil'])) {
                        //dovrebbe essere codiceFiscaleImpresa , da dove lo prendo ?
                        return;
                    }
                    componenti.push({
                        sigla: "GF",
                        progressivo: element.L4_4numGF,
                        dataInstall: element.L4_4dataInstallaz,
                        modello: element.L4_4modello,
                        component: this.xmlLibretto['Richiesta']['datiSchedaGF'].sezGF.rowGF[index],
                        fabbricante: element.L4_4fabbricante,
                        matricola: element.L4_4matricola,
                        potenza: element.L4_4potTermUtileMax
                    });
                });
                break;
            case "datiSchedaSC":
                this.normalizeArray(this.xmlLibretto['Richiesta']['datiSchedaSC'].sezSC.rowSC).forEach((element, index) => {
                    if (this.getSezione(element.sezSCimpresa).impresaSC.L4_5codiceFiscale === utenteLoggato.ruoloLoggato.piva ||
                        this.getSezione(element.sezSCimpresa).impresaSC.L4_5codiceFiscale === this.impresa?.codice_fiscale
                        || !(element.L4_5dataDismiss?.$ && element.L4_5dataDismiss?.$['xsi:nil'])) {
                        //dovrebbe essere codiceFiscaleImpresa , da dove lo prendo ?
                        return;
                    }
                    componenti.push(
                        {
                            sigla: "SC",
                            progressivo: element.L4_5numSC,
                            dataInstall: element.L4_5dataInstallaz,
                            modello: element.L4_5modello,
                            component: this.xmlLibretto['Richiesta']['datiSchedaSC'].sezSC.rowSC[index],
                            fabbricante: element.L4_5fabbricante,
                            matricola: element.L4_5matricola,
                            potenza: element.L4_5potTermUtileMax
                        });
                });
                break;
            case "datiSchedaCG":
                this.normalizeArray(this.xmlLibretto['Richiesta']['datiSchedaCG'].sezCG.rowCG).forEach((element, index) => {
                    if (this.getSezione(element.sezCGimpresa).impresaCG.L4_6codiceFiscale === utenteLoggato.ruoloLoggato.piva ||
                        this.getSezione(element.sezCGimpresa).impresaCG.L4_6codiceFiscale === this.impresa?.codice_fiscale
                        || !(element.L4_6dataDismiss?.$ && element.L4_6dataDismiss?.$['xsi:nil'])) {
                        //dovrebbe essere codiceFiscaleImpresa , da dove lo prendo ?
                        return;
                    }
                    componenti.push(
                        {
                            sigla: "CG",
                            progressivo: element.L4_6numCG,
                            dataInstall: element.L4_6dataInstallaz,
                            modello: element.L4_6modello,
                            component: this.xmlLibretto['Richiesta']['datiSchedaCG'].sezCG.rowCG[index],
                            fabbricante: element.L4_6fabbricante,
                            matricola: element.L4_6matricola,
                            potenza: element.L4_6potTermUtileMax
                        });
                });
                break;
            case "datiSchedaSP":
                this.normalizeArray(this.xmlLibretto['Richiesta']['datiSchedaSP'].sezSP.rowSP).forEach((element, index) => {
                    if (this.getSezione(element.sezSPimpresa).impresaSP.L4_6codiceFiscale === utenteLoggato.ruoloLoggato.piva ||
                        this.getSezione(element.sezSPimpresa).impresaSP.L4_6codiceFiscale === this.impresa?.codice_fiscale
                        || !(element.L4_6dataDismiss?.$ && element.L4_6dataDismiss?.$['xsi:nil'])) {
                        //dovrebbe essere codiceFiscaleImpresa , da dove lo prendo ?
                        return;
                    }
                    componenti.push(
                        { sigla: "SP", component: this.xmlLibretto['Richiesta']['datiSchedaSP'].sezSP.rowSP[index] });
                });
                break;
        }
        this.componenti = componenti;
        this.goStepOne();
    }

    normalizeArray(row: any) {
        return Array.isArray(row) ? row : [row]
    }


    getSezione(sez) {
        if (sez instanceof Array) {
            return sez[0]
        }
        return sez;
    }
    goStepOne() {
        this.lastTitle = this.title;
        this.lastBackTitle = this.backTitile;
        this.step = 1;
        if (this.affidamentoOccasionale) {
            this.titoloService.setTitle(this.subentroOccasionaleComponentiSubtitle);
        } else {
            this.titoloService.setTitle("Seleziona componenti subentro");
        }
        this.backTitile = "Torna a selezione tipo subentro";
        this.backService.setBackTitle(this.backTitile);
    }


    modificaTemponeaneaLibretto() {
        let idImpresagiuridica;
        if (this.idPersonaGiuridica) {
            idImpresagiuridica = this.idPersonaGiuridica;
        } else {
            idImpresagiuridica = this.authService.getCurrentUserFromSession().ruoloLoggato.idPersonaGiuridica;
        }
        //Richiama Algoritmo A019_5b
        let confirmMsg = "Confermi di voler effettuare il subentro?";
        this.dialogService.confirm("Subentro", confirmMsg).subscribe((response) => {
            if (response) {
                console.log("*****ATTENZIONE - DESCRIZIONE RUOLO MOCKED*****");
                this.nominaService.setSubentrosuImpianto(
                    this.authService.getCurrentUserFromSession().pfLoggato.codiceFiscalePF,
                    idImpresagiuridica,
                    this.codiceImpianto,
                    "Caricatore",
                    this.authService.getCurrentUserFromSession()
                ).subscribe((data) => {
                    if (data == 'OK') {
                        console.log("Mocked, please implement");
                        this.messageService.setTitolo("Successo");
                        this.messageService.setDescrizione("Subentro effettuato con successo");
                        this.messageService.setType(4);
                        this.messageService.showMessaggioM();
                    } else if (data == 'S075') {
                        this.messageService.setTitolo("Errore");
                        this.messageService.setDescrizione("Non è possibile subentrare a se stessi");
                        this.messageService.setType(2);
                        this.messageService.showMessaggioM();
                    }
                }, (error) => {
                    console.log("Mocked, please implement");
                    this.messageService.setTitolo("Errore");
                    this.messageService.setDescrizione("Impossibile effettuare l'operazione");
                    this.messageService.setType(2);
                    this.messageService.showMessaggioM();
                });

            }
        });
    }

    selectAll(value) {
        this.componenti.forEach(element => {
            element.checked = value.checked;
            element.disabled = value.checked;
        });
    }

    anyoneSelected() {
        if (this.componenti) {
            return this.componenti.filter(element => element.checked).length > 0;
        }
        return false;
    }

    salva() {
        console.log(this.componenti);
        let confirmMsg = "";
        if (this.componenti.filter(element => element.checked).length === this.componenti.length) {
            confirmMsg = "Confermi di voler effettuare il subentro per tutte le componenti dell'impianto con codice " + this.datiImpianto.codice_impianto + " ?";
        } else {
            confirmMsg = "Confermi di voler effettuare il subentro per le componenti \n " + this.componenti.filter(element => element.checked).map(element => element.sigla + "-" + element.progressivo).join(", ") + " ?";
        }
        this.dialogService.confirm("Subentro", confirmMsg).subscribe((response) => {
            if (response) {
                let subentro: SubentroComponenti = this.buildSubentro();
                let idImpresagiuridica;
                if (this.idPersonaGiuridica) {
                    idImpresagiuridica = this.idPersonaGiuridica;
                } else {
                    idImpresagiuridica = this.authService.getCurrentUserFromSession().ruoloLoggato.idPersonaGiuridica;
                }
                this.impiantoService.setSubentrosuComponenti(this.codiceImpianto, idImpresagiuridica, true, subentro).subscribe((data) => {
                    this.back();
                    this.messageService.setTitolo("Successo");
                    this.messageService.setDescrizione("Subentro effettuato con successo");
                    this.messageService.setType(4);
                    this.messageService.showMessaggioM();
                    this.loadLibretto(this.codiceImpianto);
                }, err => {
                    this.messageService.setTitolo("Error");
                    this.messageService.setDescrizione("Impossibile effettuare il subentro.");
                    this.messageService.setType(1);
                    this.messageService.showMessaggioM();
                });
            }
        });
        console.log(confirmMsg);
    }


    effettuaSubentro(ruolo: string) {
        let idImpresagiuridica;
        if (this.idPersonaGiuridica) {
            idImpresagiuridica = this.idPersonaGiuridica;
        } else {
            idImpresagiuridica = this.authService.getCurrentUserFromSession().ruoloLoggato.idPersonaGiuridica;
        }
        let confirmMsg = "Confermi di voler effettuare il subentro sull'impianto con codice " + this.codiceImpianto + "?";
        this.dialogService.confirm("Subentro", confirmMsg).subscribe((response) => {
            // codice_fiscale: string, id_persona: number, codice_impianto: number, des_ruolo: string
            if (response) {
                this.nominaService.setSubentrosuImpianto(
                    this.authService.getCurrentUserFromSession().pfLoggato.codiceFiscalePF,
                    idImpresagiuridica,
                    this.codiceImpianto,
                    ruolo,
                    this.authService.getCurrentUserFromSession()
                ).subscribe((data) => {
                    if (data == 'OK') {
                        this.messageService.setTitolo("Successo");
                        this.messageService.setDescrizione("Subentro effettuato con successo");
                        this.messageService.setType(4);
                        this.messageService.showMessaggioM();
                        // if(this.affidamentoOccasionale){
                        //this.location.back();
                        this.router.navigate(["/impianto/ricerca-impianti"]);

                    } else if (data == 'S075') {
                        this.messageService.setTitolo("Errore");
                        this.messageService.setDescrizione("Non e' possibile effettuare il subentro verso se' stessi.");
                        this.messageService.setType(2);
                        this.messageService.showMessaggioM();
                    } else if (data == 'Occorre prima verificare il libretto') {
                        this.messageService.setTitolo("Errore");
                        this.messageService.setDescrizione("Occorre prima verificare il libretto");
                        this.messageService.setType(2);
                        this.messageService.showMessaggioM();
                    }
                }, (error) => {
                    this.messageService.setTitolo("Errore");
                    this.messageService.setDescrizione("Impossibile effettuare l'operazione");
                    this.messageService.setType(2);
                    this.messageService.showMessaggioM();
                });
            }
        });
    }

    buildSubentro(): SubentroComponenti {
        const subentro = new SubentroComponenti();
        subentro.utenteLoggato = this.authService.getCurrentUserFromSession();
        subentro.componenti = this.componenti
          .filter((c) => c.checked)
          .map((c) => ({
            idTipoComponente: c.sigla,
            progressivo: c.progressivo,
            dataInstall: new Date(c.dataInstall),
            codiceImpianto: this.codiceImpianto,
            marca: c?.marca,
            modello: c.modello
          }));
        return subentro;
    }


    isProprietario() {
        let ruolo = this.authService.getCurrentUserFromSession().ruoloLoggato.ruolo;
        if (ruolo === RUOLI.RUOLO_PROPRIETARIO || ruolo === RUOLI.RUOLO_PROPRIETARIO_IMPRESA) {
            return true;
        }
        return false;
    }


    goToNuovoImpianto() {
        this.router.navigate(["/impianto/nuovo-impianto"]);
    }


    checkValueManutentore(value) {
        let result = false;
        switch (value) {
            case "datiSchedaGT":
                // Richiesta.datiSchedaGT.sezGruppiTermici.rowGT[2].sezGTimpresa.impresaGT.L4_1codiceFiscale
                result = this.xmlLibretto['Richiesta']['datiSchedaGT'].sezGruppiTermici.rowGT ? true : false;
                break;
            case "datiSchedaGF":
                result = this.xmlLibretto['Richiesta']['datiSchedaGF'].sezGF.rowGF ? true : false;
                break;
            case "datiSchedaSC":
                result = this.xmlLibretto['Richiesta']['datiSchedaSC'].sezSC.rowSC ? true : false;
                break;
            case "datiSchedaCG":
                result = this.xmlLibretto['Richiesta']['datiSchedaCG'].sezCG.rowCG ? true : false;
                break;
            case "datiSchedaSP":
                result = this.xmlLibretto['Richiesta']['datiSchedaSP'].sezSP.rowSP ? true : false;
                break;
            default:
                break;
        }
        return result;
    }

    lastBack = new Date();

    back() {
        if ((Date.now() - this.lastBack.getTime()) > 500) {
            if (this.step > 0) {
                this.step = 0;
                this.titoloService.setTitle(this.lastTitle);
                this.lastTitle = "";
                this.backTitile = this.lastBackTitle;
                this.lastBackTitle = "";
                this.backService.setBackTitle(this.backTitile);
            } else {
                if (!this.affidamentoOccasionale) {
                    let state = {

                    }
                    if(this.impresa){
                        state['impresa'] = this.impresa;
                    }
                    this.router.navigate(['../ricerca-indirizzo'], {
                        relativeTo: this.activatedRouter,
                        state: state
                    });
                } else {
                    this.location.back();
                }
            }
        }
        this.lastBack = new Date();
    }
}
