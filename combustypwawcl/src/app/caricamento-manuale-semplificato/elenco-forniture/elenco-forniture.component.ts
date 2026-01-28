import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Impianto } from 'src/app/models/impianto';
import { Persona } from 'src/app/models/persona';
import { AuthenticationService } from 'src/app/services/authentication.service';
import { BackService } from 'src/app/services/back.service';
import { ImpiantoService } from 'src/app/services/impianto.service';
import { MessageService } from 'src/app/services/message.service';
import { ResultService } from 'src/app/services/result.service';
import { SpinnerService } from 'src/app/services/spinner.service';
import { TitleService } from 'src/app/services/title.service';
import { DatiDistributoreService } from 'src/app/services/dati-distributore.service';
import { ImportDatiDistributore } from 'src/app/models/importazione-dati-distributore';
import { DatiFornitura } from 'src/app/models/dati-fornitura';

@Component({
  selector: 'app-elenco-forniture',
  templateUrl: './elenco-forniture.component.html',
  styleUrls: ['./elenco-forniture.component.scss']
})
export class ElencoFornitureComponent implements OnInit {
  impianti: Impianto[];
  hasResult: boolean;
  titoloErrore = "";
  descrizioneErrore = "";
  persone: Persona[] = undefined;
  backTitile: string = "";
  route: string = "ruoli";
  ruolo: any;
  idPersonaGiuridica: string;

  constructor( 
      readonly spinnerService: SpinnerService, 
      private router: Router,
      readonly titoloService: TitleService,
      readonly backService: BackService,
      readonly authService: AuthenticationService,
      readonly impiantoService: ImpiantoService,
      readonly messageService: MessageService,
      readonly datiDistributoreService: DatiDistributoreService,
      private readonly result: ResultService) { }

  ngOnInit(): void {
    
    this.titoloService.setTitle("Caricamento manuale semplificato");
    this.route = "cerca-dati-fornitura";
    this.backTitile = "Torna indietro"
    this.backService.setBackTitle(this.backTitile);
    this.backService.setRoute("/");
    
    this.ruolo = this.authService.getCurrentUserFromSession().ruoloLoggato;
    this.impianti = this.result.getRicercaDatiFornitura().impianti; 
    console.log(this.impianti);
    this.persone = this.result.getRicercaDatiFornitura().persone; 

    if(this.impianti.length == 0 && this.persone.length == 0){
      this.messageService.setTitolo("Attenzione");
      this.messageService.setDescrizione("Nessun risultato presente per la ricerca effettuata");
      this.messageService.showMessaggioM();
      this.messageService.setType(1);
    }
  }

  getProvinciaBySiglaProvincia(arg0: string) {
    return arg0;
    throw new Error('Method not implemented.');
  }

  selezionaDettaglioImpianto(impianto: Impianto) {
    this.result.setResult(impianto);
    this.result.setIsImpianto(true);
    this.result.setIsPersona(false);
    this.result.setIsVisualizzazioneDettaglio(false);
    this.router.navigate(["/caricamento-semplificato"]);
  }

  selezionaDettaglioPersona(persona: Persona){
    this.result.setResult(persona);
    this.result.setIsImpianto(false);
    this.result.setIsPersona(true);
    this.result.setIsVisualizzazioneDettaglio(false);
    this.router.navigate(["/caricamento-semplificato"]);
  }
}
