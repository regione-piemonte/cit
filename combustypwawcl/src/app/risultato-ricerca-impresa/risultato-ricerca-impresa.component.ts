import { Component, OnInit } from '@angular/core';
import { SpinnerService } from '../services/spinner.service';
import { Router } from '@angular/router';
import { TitleService } from '../services/title.service';
import { BackService } from '../services/back.service';
import { AuthenticationService } from '../services/authentication.service';
import { Persona } from '../models/persona';
import { ResultService } from '../services/result.service';
import { WARNING_TYPE } from '../common/components/message-box/message-box.component';
import { NgxPermissionsService } from 'ngx-permissions';
import { PERMS } from '../perms';
import { UtenteLoggato } from '../models/utente-loggato';
import { PFLoggato } from '../models/pf-loggato';
import { RuoloLoggato } from '../models/ruolo-loggato';
import { DatiDistributoreService } from '../services/dati-distributore.service';

@Component({
  selector: 'app-risultato-ricerca-impresa',
  templateUrl: './risultato-ricerca-impresa.component.html',
  styleUrls: ['./risultato-ricerca-impresa.component.scss']
})
export class RisultatoRicercaImpresaComponent implements OnInit {

  errorType: number = WARNING_TYPE;
  titoloErrore = "";
  descrizioneErrore = "";

  persone: Persona[] = undefined;
  backTitile: string = "";
  route: string = "ruoli";
  utente: any;
  codiceFiscalePF;
  isMobile: any;
  risultati: any;
  imprese: any;

  constructor(
    readonly spinnerService: SpinnerService, 
    private router: Router,
    readonly titoloService: TitleService,
    readonly backService: BackService,
    readonly authService: AuthenticationService,
    private readonly result: ResultService,
    private readonly authenticationService: AuthenticationService,
    private datiDistributoreService: DatiDistributoreService,
    private permissions: NgxPermissionsService
  ) { }

  ngOnInit(): void {
    this.utente = this.authService.getCurrentUserFromSession();
    this.titoloService.setTitle("Elenco Dati Inviati");
    this.route = "ricerca-impresa";
    this.backTitile = "Torna indietro"
    this.backService.setBackTitle(this.backTitile);
    this.backService.setRoute("/");

    if(this.risultati <= 0){
        this.titoloErrore = "Attenzione";
        this.descrizioneErrore = "Nessun elemento trovato. Nessuna persona giuridica trovata con i parametri indicati";
        this.errorType = WARNING_TYPE;
    }

    if(this.risultati <= 0 && !this.result.getResultBool()) {
        this.titoloErrore = "Attenzione";
        this.descrizioneErrore = "L'impresa è presente a sistema, ma non è dichiarata con ruolo distributore";
        this.errorType = WARNING_TYPE;
        return;
    }

    this.imprese = this.result.getResult();
    this.risultati = this.imprese.length;

  }

  usaDati(impresa: any) {
    this.result.setResult(impresa);

    if (this.utente && this.utente.ruoloLoggato) {
        this.utente = new UtenteLoggato(
          new PFLoggato(
            this.utente.pfLoggato.codiceFiscalePF,
            this.utente.pfLoggato.cognomePF,
            this.utente.pfLoggato.nomePF
          ),
          new RuoloLoggato(
            this.utente.ruoloLoggato.ruolo ?? null,            // ruolo
            impresa.codice_fiscale ?? null ,                   // piva
            null,                                              // siglaRea
            null,                                              // numeroRea
            null,                                              // denominazione
            null,                                              // dataCessazione
            null,                                              // idStato
            null,                                              // descStato
            this.utente.ruoloLoggato.istatAbilitazione ?? null,
            this.utente.ruoloLoggato.descrAbilitazione ?? null,
            impresa.id_persona_giuridica ?? null
          )
        );
        console.log("Utente ricostruito da salvare:\n", JSON.stringify(this.utente, null, 2));

          this.authenticationService.setAccesso(this.utente).subscribe(elem => {
            sessionStorage.setItem('currentUser', JSON.stringify(elem));
            console.log("Risposta dal backend (utente salvato):", elem);
            this.permissions.loadPermissions(PERMS[elem.ruoloLoggato.ruolo] ?? []);
            this.datiDistributoreService.clearFiltri();
            this.router.navigate(["/elenco-dati-inviati"]);
          }, error => {
            this.titoloErrore = "Errore";
            this.descrizioneErrore = error.title;
          });
        }
    }

  clearErrore() {
    this.titoloErrore = '';
    this.descrizioneErrore = '';
  }

  getRowHeight(text: string | undefined): string {
  if (!text) return '3em';  // base default

  return text.length > 60 ? '4em' : '2em';
  }

  getHeight(text: string | undefined): string {
    if (!text) return '3em';

    return text.length > 60 ? '4em' : '2em';
  }

  getLineHeight(text: string | undefined): string {
    if (!text) return '3em';

    return text.length > 60 ? '1.1em' : '3em';
  }
}
