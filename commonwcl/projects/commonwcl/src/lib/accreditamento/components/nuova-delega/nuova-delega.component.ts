import { Location } from '@angular/common';
import { Component, EventEmitter, HostListener, Input, OnInit, Output } from '@angular/core';
import { Router } from '@angular/router';
import { DatiImpresa } from '../../../models/dati-impresa';
import { Persona } from '../../../models/persona';
import { UtenteLoggato } from '../../../models/utente-loggato';
import { AccreditamentoService } from '../../../services/accreditamento.service';
import { ImpiantoService } from '../../../services/impianto.service';
import { SharedService } from '../../../services/shared.service';
import { ICONSURL } from '../../../utils/constants';


@Component({
  selector: 'commonwcl-nuova-delega',
  templateUrl: './nuova-delega.component.html',
  styleUrls: ['./nuova-delega.component.scss']
})
export class NuovaDelegaComponent implements OnInit {

  warnIcon: string = ICONSURL + "alert.svg";


  @Input() apiUrl: any;
  @Input() impresa: DatiImpresa;
  @Input() codiceFiscalePF: string;

  @Output() onMessage = new EventEmitter<any>();

  colBreakpoint1: number;
  colBreakpoint3: number;
  rowSpan: number;
  inner_card_width: number;

  codiceFiscaleCompleto: string = "";

  persone: Persona[] = [];
  searched: boolean = false;

  constructor(private impiantoService: ImpiantoService,
    private location: Location,
    private router: Router,
    private sharedService: SharedService,
    private accreditamentoService: AccreditamentoService) { }

  ngOnInit(): void {
    this.impiantoService.init(this.apiUrl);
    this.accreditamentoService.init(this.apiUrl);
    this.prepareView();
  }

  prepareView() {
    this.colBreakpoint1 = (window.innerWidth < 768) ? 12 : 6;
    this.colBreakpoint3 = (window.innerWidth < 768) ? 0 : 3;
    this.rowSpan = (window.innerWidth < 768) ? 3 : 2;
    this.inner_card_width = (window.innerWidth < 768) ? 100 : 30;
    window.scrollTo(0, 0);
  }

  @HostListener('window:resize', ['$event'])
  onResize(event?) {
    this.prepareView();
  }


  cerca() {
    let utenteLoggato = this.sharedService.getUtenteLoggato();
    if (!utenteLoggato.ruoloLoggato?.ruolo) {
      this.onMessage.emit({ titolo: "Attenzione", descrizione: "Selezionare un ruolo per effettuare la ricerca per codice fiscale", type: 1 });
      return;
    }
    this.persone = [];
    this.impiantoService.cercaResponsabileProprietario(0, this.codiceFiscaleCompleto).subscribe((elem: Persona[]) => {
      this.persone = elem;
      this.searched = true;
    }, error => {
      this.searched = true;
    });
  }


  setDelega(persona: Persona) {
    let utenteLoggato: UtenteLoggato = this.sharedService.getUtenteLoggato();
    this.accreditamentoService.setDelega(utenteLoggato.pfLoggato.codiceFiscalePF, this.impresa.id_persona_giuridica, persona.idPersona).subscribe(() => {
      this.onMessage.emit({ titolo: "Delega aggiunta", descrizione: "Delega aggiunta con successo", type: 4 });
      // this.router.navigate(['/accreditamento/gestione-dati']);
      // this.location.back();
    }, error => {
      this.onMessage.emit({ titolo: "Delega già presente", descrizione: "La persona indicata risulta già delegata", type: 1 });
      // this.location.back();
      // this.router.navigate(['/accreditamento/gestione-dati']);
    });
  }

  onUppercaseModel(event: Event): void {
    const input = event.target as HTMLInputElement;
    const upper = input.value.toUpperCase();
    this.codiceFiscaleCompleto = upper;
  }

}
