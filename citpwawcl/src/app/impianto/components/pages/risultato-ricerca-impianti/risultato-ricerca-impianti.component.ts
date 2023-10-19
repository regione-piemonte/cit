import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { Subscription } from 'rxjs';
import { Impianto } from 'src/app/models/impianto';
import { UtenteLoggato } from 'src/app/models/utente-loggato';
import { AuthenticationService } from 'src/app/services/authentication.service';
import { BackService } from 'src/app/services/back.service';
import { ResultService } from 'src/app/services/result.service';
import { TitleService } from 'src/app/services/title.service';
import { ICONSURL, RUOLI } from 'src/app/utils/constants';

@Component({
  selector: 'app-risultato-ricerca-impianti',
  templateUrl: './risultato-ricerca-impianti.component.html',
  styleUrls: ['./risultato-ricerca-impianti.component.scss']
})
export class RisultatoRicercaImpiantiComponent implements OnInit {


  mappaIcon: string = ICONSURL + "mappa.svg";

  impianti: Impianto[];

  utente: UtenteLoggato | null;

  filterForm: FormGroup;
  subscription: Subscription;

  constructor(private fb: FormBuilder, private router: Router, private readonly authService: AuthenticationService, private readonly result: ResultService, private readonly backService: BackService, private readonly titleService: TitleService) {
    this.utente = authService.getCurrentUserFromSession();
    this.filterForm = this.fb.group({
      filtro: ["", [
      ]]
    });
  }

  ngOnInit(): void {
    this.backService.setBackTitle("Torna alla ricerca");
    this.backService.setRoute("impianto/ricerca-impianti");
    this.titleService.setTitle("Risultato impianti termici");
    this.impianti = this.result.getResult();
    this.filterForm.controls["filtro"].setValue("1");
    this.sortImpianti("1");
  }

  sortImpianti(type: string) {
    if (this.impianti) {
      if (type == "1")
        this.impianti.sort((a, b) => (a.codiceImpianto < b.codiceImpianto ? -1 : 1));
      if (type == "2")
        this.impianti.sort((a, b) => (a.descComune < b.descComune ? -1 : 1));
      if (type == "3")
        this.impianti.sort((a, b) => (a.indirizzo < b.indirizzo ? -1 : 1));
      if (type == "4")
        this.impianti.sort((a, b) => (a.denomResponsabile < b.denomResponsabile ? -1 : 1));
      if (type == "5")
        this.impianti.sort((a, b) => (a.stato < b.stato ? -1 : 1));
    }
  }

  dettaglioImpianto(elem: Impianto) {
    this.router.navigate(["/impianto/dettaglio-impianto/" + elem.codiceImpianto]);
  }

  isAbilitatoInserisciImpianto() {
    return this.utente?.ruoloLoggato.ruolo != RUOLI.RUOLO_CONSULTATORE &&
      this.utente?.ruoloLoggato.ruolo != RUOLI.RUOLO_3RESPONSABILE &&
      this.utente?.ruoloLoggato.ruolo != RUOLI.RUOLO_PROPRIETARIO &&
      this.utente?.ruoloLoggato.ruolo != RUOLI.RUOLO_PROPRIETARIO_IMPRESA;
  }

  apriInserisciimpianto() {
    this.router.navigate(["/impianto/nuovo-impianto"]);
  }

  getProvinciaBySiglaProvincia(siglaProvincia: string) {
    let provArr;
    let provincia;
    if (localStorage.ComuniEstesi) provArr = JSON.parse(localStorage.ComuniEstesi);
    if (provArr) provincia = provArr.find(elem => elem.siglaProvincia === siglaProvincia);
    return provincia ? provincia.provincia : "";
  }
}
