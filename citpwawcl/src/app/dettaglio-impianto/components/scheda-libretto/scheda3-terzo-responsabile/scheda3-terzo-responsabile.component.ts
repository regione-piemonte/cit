import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { AuthenticationService } from 'src/app/services/authentication.service';
import { BackService } from 'src/app/services/back.service';
import { ImpiantoService } from 'src/app/services/impianto.service';
import { LibrettoService } from 'src/app/services/libretto.service';
import { SharedService } from 'src/app/services/shared.service';
import { SpinnerService } from 'src/app/services/spinner.service';
import { TitleService } from 'src/app/services/title.service';
import { RUOLI } from 'src/app/utils/constants';
import * as xml2js from 'xml2js';


@Component({
    selector: 'app-scheda3-terzo-responsabile',
    templateUrl: './scheda3-terzo-responsabile.component.html',
    styleUrls: ['./scheda3-terzo-responsabile.component.scss']
})
export class Scheda3TerzoResponsabileComponent implements OnInit {

    parser = new xml2js.Parser({
        tagNameProcessors: [
            // Questa funzione rimuove tutti i prefissi dei namespace
            (name) => name.replace(/^.+:/, '')
        ],
        explicitArray: false
    });

    nomine: any[] = [];
    dataUltimaNominaDal: any;
    loaded = false;

    constructor(
        private titleService: TitleService,
        private backService: BackService,
        private router: Router,
        private fb: FormBuilder,
        private sharedService: SharedService,
        private librettoService: LibrettoService,
        private impiantoService: ImpiantoService,
        readonly spinnerService: SpinnerService,
        private route: ActivatedRoute,
        private authService: AuthenticationService
    ) {
        this.titleService.setTitle("Elenco storico terza responsabilità");
        // this.backService.setBackTitle("Torna a dettagli impianto termico");
        // this.spinnerService.show();
        // const urlOriginal = this.router.url;
        this.backService.setBackTitle("Torna a scheda libretto");
        const urlOriginal = this.router.url;
        //fix devo togliere anche l'ultimo pezzo "scheda"
        const redirectUrl = urlOriginal.substring(0, urlOriginal.lastIndexOf('/'));
        this.backService.setRoute(redirectUrl.substring(0, redirectUrl.lastIndexOf('/')) + '/lista');
    }

    ngOnInit(): void {
        // Initialization code goes here

        let utenteLoggato = this.authService.getCurrentUserFromSession();
        this.librettoService.getXmlLibrettoNowByCodice(this.sharedService.getCodiceImpiantoFromDatiPrecompilati()).subscribe((data) => {
            let decoded = atob(new TextDecoder().decode(data))
            console.log(decoded);
            this.parser.parseString(decoded, (err, result) => {
                if (err) {
                    console.error(err);
                    return;
                }
                this.sharedService.setLibrettoXmlNow(result);
                this.nomine = Array.isArray(result?.MOD?.Richiesta?.datiPrecompilati?.sezNomine?.rowNomine) ? result?.MOD?.Richiesta?.datiPrecompilati?.sezNomine?.rowNomine : [result?.MOD?.Richiesta?.datiPrecompilati?.sezNomine?.rowNomine];
                this.nomine = this.nomine.sort((a , b) => b.L3dataValiditaContrattoDal.localeCompare(a.L3dataValiditaContrattoDal));
                this.dataUltimaNominaDal=this.nomine[0].L3dataValiditaContrattoDal;
                
                this.loaded = true;
            });
        });
    }

    dettaglioNomina(idContratto, dataValiditaContrattoDal) {
        this.router.navigate(['../../dettaglio-nomina'], {
            queryParams: {
                idContratto: idContratto,
                dataValiditaContrattoDal: dataValiditaContrattoDal,
                dataUltimaNominaDal: this.dataUltimaNominaDal
            }, relativeTo: this.route
        });
    }

    isDettaglioNominaVisible(nomina: any) {
        let utenteLoggato = this.authService.getCurrentUserFromSession();
        if ((utenteLoggato?.ruoloLoggato?.ruolo === RUOLI.RUOLO_3RESPONSABILE && nomina?.L3codiceFiscaleDitta === utenteLoggato.ruoloLoggato.piva) ||
            utenteLoggato?.ruoloLoggato?.ruolo === RUOLI.RUOLO_RESPONSABILE ||
            utenteLoggato?.ruoloLoggato?.ruolo === RUOLI.RUOLO_SUPER ||
            utenteLoggato?.ruoloLoggato?.ruolo === RUOLI.RUOLO_RESPONSABILE_IMPRESA ||
            utenteLoggato?.ruoloLoggato?.ruolo === RUOLI.RUOLO_VALIDATORE) {
            return true;
        }
        return false;

    }


    isDateVisible() {
        let utenteLoggato = this.authService.getCurrentUserFromSession();
        if (utenteLoggato?.ruoloLoggato?.ruolo === RUOLI.RUOLO_SUPER ||
            utenteLoggato?.ruoloLoggato?.ruolo === RUOLI.RUOLO_VALIDATORE ||
            utenteLoggato?.ruoloLoggato?.ruolo === RUOLI.RUOLO_ISPETTORE ||
            utenteLoggato?.ruoloLoggato?.ruolo === RUOLI.RUOLO_CONSULTATORE) {
            return true;
        }
        return false;
    }

    parseDate(date) {
        if (date && date.indexOf("+") > -1)
            date = date.substring(0, date.indexOf("+"));
        return new Date(date);
    }
}
