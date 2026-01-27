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
import { ICONSURL } from 'src/app/utils/constants';
// import * as xmlJs from 'xml-js';

import { Location } from '@angular/common';
import * as xml2js from 'xml2js';
import { NominaTerzoResponsabileService } from '../../../../services/nomina.service';

@Component({
    selector: 'app-affidamento-occasionale',
    templateUrl: './affidamento-occasionale.component.html',
    styleUrls: ['./affidamento-occasionale.component.scss']
})
export class AffidamentoOccasionaleComponent implements OnInit {

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

    subentroOccasionaleTitle = "Seleziona tipo delega manutentore";
    subentroOccasionaleComponentiSubtitle = "Seleziona componenti delega manutentore"

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

    colBreakpoint1: number;
    colBreakpoint2: number;
    colBreakpoint3: number;

    xmlLibretto: any;

    lastTitle;
    lastBackTitle;

    datiSchedaManutentore = {
        datiSchedaGT: { visible: false, title: "DELEGA SU COMPONENTI GT" },
        datiSchedaGF: { visible: false, title: "DELEGA SU COMPONENTI GF" },
        datiSchedaSC: { visible: false, title: "DELEGA SU COMPONENTI SC" },
        datiSchedaCG: { visible: false, title: "DELEGA SU COMPONENTI CG" },
        datiSchedaSP: { visible: false, title: "DELEGA SU COMPONENTI SP" }
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

    cf: string;

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
            this.codiceImpianto = params['codiceImpianto'];
            this.backService.setBackTitle("Torna indietro");

            this.noImpianto = params['noImpianto'] ? params['noImpianto'] : false;
            this.idPersonaGiuridica = params['id_persona_giuridica'];
            this.route = params['returnUrl'];
            if (!this.noImpianto) {
                this.loadLibretto(this.codiceImpianto);
            }
            this.cf = params['cf'];
        });
        let state = this.router.getCurrentNavigation()?.extras?.state;
        if (state?.impresa) {
            this.impresa = state.impresa;
            this.idPersonaGiuridica = this.impresa.id_persona_giuridica;
        } else {
          this.router.navigate(['/']);
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
        this.datiImpianto = data?.Richiesta?.datiPrecompilati;
        this.xmlLibretto = data;
        localStorage.setItem('xmlNow', JSON.stringify(data));
        data.Richiesta.datiSchedaGT ? this.datiSchedaManutentore.datiSchedaGT.visible = true : this.datiSchedaManutentore.datiSchedaGT.visible = false;
        data.Richiesta.datiSchedaGF ? this.datiSchedaManutentore.datiSchedaGF.visible = true : this.datiSchedaManutentore.datiSchedaGF.visible = false;
        data.Richiesta.datiSchedaSC ? this.datiSchedaManutentore.datiSchedaSC.visible = true : this.datiSchedaManutentore.datiSchedaSC.visible = false;
        data.Richiesta.datiSchedaCG ? this.datiSchedaManutentore.datiSchedaCG.visible = true : this.datiSchedaManutentore.datiSchedaCG.visible = false;
        data.Richiesta.datiSchedaSP ? this.datiSchedaManutentore.datiSchedaSP.visible = true : this.datiSchedaManutentore.datiSchedaSP.visible = false;
        this.manutentore = true;
        console.log(data);
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
        this.titoloService.setTitle(this.subentroOccasionaleTitle);
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
                const toAdd1 = this.normalizeArray(this.xmlLibretto['Richiesta']['datiSchedaGT'].sezGruppiTermici.rowGT)
                  .filter(e => this.getSezione(e.sezGTimpresa).impresaGT.L4_1codiceFiscale === this.cf)
                  .filter(e => !e.L4_1dataDismiss?.$ || e.L4_1dataDismiss?.$['xsi:nil'])
                  .map((e, i) => ({
                    sigla: "GT",
                    progressivo: e.L4_1numGT,
                    dataInstall: e.L4_1dataInstallaz,
                    modello: e.L4_1modello,
                    component: this.xmlLibretto['Richiesta']['datiSchedaGT'].sezGruppiTermici.rowGT[i],
                    fabbricante: e.L4_1fabbricante,
                    matricola: e.L4_1matricola,
                    potenza: e.L4_1potTermUtileMax
                  }));

                componenti.push(...toAdd1);
                break;
            case "datiSchedaGF":
                const toAdd2 = this.normalizeArray(this.xmlLibretto['Richiesta']['datiSchedaGF'].sezGF.rowGF)
                  .filter(e => this.getSezione(e.sezGFimpresa).impresaGF.L4_4codiceFiscale === this.cf)
                  .filter(e => !e.L4_4dataDismiss?.$ || e.L4_4dataDismiss?.$['xsi:nil'])
                  .map((e, i) => ({
                    sigla: "GF",
                    progressivo: e.L4_4numGF,
                    dataInstall: e.L4_4dataInstallaz,
                    modello: e.L4_4modello,
                    component: this.xmlLibretto['Richiesta']['datiSchedaGF'].sezGF.rowGF[i],
                    fabbricante: e.L4_4fabbricante,
                    matricola: e.L4_4matricola,
                    potenza: e.L4_4potTermUtileMax
                  }));

                componenti.push(...toAdd2);
                break;
            case "datiSchedaSC":
                const toAdd3 = this.normalizeArray(this.xmlLibretto['Richiesta']['datiSchedaSC'].sezSC.rowSC)
                  .filter(e => this.getSezione(e.sezSCimpresa).impresaSC.L4_5codiceFiscale === this.cf)
                  .filter(e => !e.L4_5dataDismiss?.$ || e.L4_5dataDismiss?.$['xsi:nil'])
                  .map((e, i) => ({
                    sigla: "SC",
                    progressivo: e.L4_5numSC,
                    dataInstall: e.L4_5dataInstallaz,
                    modello: e.L4_5modello,
                    component: this.xmlLibretto['Richiesta']['datiSchedaSC'].sezSC.rowSC[i],
                    fabbricante: e.L4_5fabbricante,
                    matricola: e.L4_5matricola,
                    potenza: e.L4_5potTermUtileMax
                  }));

                componenti.push(...toAdd3);
                break;
            case "datiSchedaCG":
                const toAdd4 = this.normalizeArray(this.xmlLibretto['Richiesta']['datiSchedaCG'].sezCG.rowCG)
                  .filter(e => this.getSezione(e.sezCGimpresa).impresaCG.L4_6codiceFiscale === this.cf)
                  .filter(e => !e.L4_6dataDismiss?.$ || e.L4_6dataDismiss?.$['xsi:nil'])
                  .map((e, i) => ({
                    sigla: "CG",
                    progressivo: e.L4_6numCG,
                    dataInstall: e.L4_6dataInstallaz,
                    modello: e.L4_6modello,
                    component: this.xmlLibretto['Richiesta']['datiSchedaCG'].sezCG.rowCG[i],
                    fabbricante: e.L4_6fabbricante,
                    matricola: e.L4_6matricola,
                    potenza: e.L4_6potTermUtileMax
                  }));

                componenti.push(...toAdd4);
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
        this.titoloService.setTitle(this.subentroOccasionaleComponentiSubtitle);
        this.backTitile = "Torna a selezione tipo delega";
        this.backService.setBackTitle(this.backTitile);
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
            confirmMsg = "Confermi di voler effettuare la delega del manutentore per tutte le componenti dell'impianto con codice " + this.datiImpianto.codice_impianto + " ?";
        } else {
            confirmMsg = "Confermi di voler effettuare la delega del manutentore per le componenti \n " + this.componenti.filter(element => element.checked).map(element => element.sigla + "-" + element.progressivo).join(", ") + " ?";
        }
        this.dialogService.confirm("Delega manutentore", confirmMsg).subscribe((response) => {
            if (response) {
                let subentro: SubentroComponenti = this.buildSubentro();
                let idImpresagiuridica = this.idPersonaGiuridica;
                this.impiantoService.setSubentrosuComponenti(this.codiceImpianto, idImpresagiuridica, false, subentro).subscribe((data) => {
                    this.messageService.setTitolo("Successo");
                    this.messageService.setDescrizione("Delega manutentore effettuata con successo");
                    this.messageService.setType(4);
                    this.messageService.showMessaggioM();
                    this.loadLibretto(this.codiceImpianto);
                    this.router.navigate(['/', 'impianto', 'dettaglio-impianto', this.codiceImpianto]);
                }, () => {
                    this.messageService.setTitolo("Error");
                    this.messageService.setDescrizione("Impossibile effettuare la delega.");
                    this.messageService.setType(1);
                    this.messageService.showMessaggioM();
                });
            }
        });
        console.log(confirmMsg);
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
              this.location.back();
            }
        }
        this.lastBack = new Date();
    }
}
