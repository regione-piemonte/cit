import { Component, Inject, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Persona } from 'src/app/models/persona';
import { validateAlphanumeric, validateCFPIVA } from '../validators/custom.validator';
import { SpinnerService } from '../services/spinner.service';
import { TitleService } from '../services/title.service';
import { BackService } from '../services/back.service';
import { AuthenticationService } from '../services/authentication.service';
import { AccreditamentoService } from '@sigit/common-lib';
import { DatiImpresa } from '@sigit/common-lib/lib/models/dati-impresa';
import { environment } from 'src/environments/environment';
import { ResultService } from '../services/result.service';
import { SvistaService } from '../services/svista.service';
import { Provincia } from '../models/provincia.model';
import { WARNING_TYPE } from '../common/components/message-box/message-box.component';
import { MessageService } from '../services/message.service';

@Component({
  selector: 'app-ricerca-impresa',
  templateUrl: './ricerca-impresa.component.html',
  styleUrls: ['./ricerca-impresa.component.scss']
})
export class RicercaImpresaComponent implements OnInit {

  searchForm: FormGroup;
  titoloErrore = "";
  descrizioneErrore = "";
  errorType: number = WARNING_TYPE;
  persone: Persona[] = undefined;

  backTitle: string = "";
  route: string = "ruoli";
  ruolo: any;
  codiceFiscalePF;
  imprese: DatiImpresa[] = [];
  searched: boolean;
  sigleReaList: string[] = [];

  constructor(
    private fb: FormBuilder, 
    readonly spinnerService: SpinnerService, 
    private router: Router,
    readonly titoloService: TitleService,
    readonly backService: BackService,
    readonly authService: AuthenticationService,
    private readonly result: ResultService,
    readonly svistaService: SvistaService,
    readonly messageService: MessageService,
    @Inject(AccreditamentoService) private accreditamentoService: AccreditamentoService) 
    {
      this.accreditamentoService.init(environment.apiUrl);
      this.searchForm = fb.group({
        cf: ["", [Validators.required,validateCFPIVA]],
        siglaRea: ["", [Validators.required,validateAlphanumeric]],
        numeroRea: ["", [Validators.required, Validators.pattern("[0-9]+")]]
      });
   }

  ngOnInit(): void {
    this.ruolo = this.authService.getCurrentUserFromSession().ruoloLoggato;
    this.titoloService.setTitle("Ricerca Impresa");
    this.route = "/";
    this.backTitle = "Torna indietro"
    this.backService.setBackTitle(this.backTitle);
    this.backService.setRoute("/");
    this.initProvincie();
  }

  initProvincie() {
    let province: Provincia[] = this.svistaService.loadProvinceFromLocalStorage();
    this.sigleReaList = province.map((provincia) => provincia.siglaProvincia);
  }

  private checkImpresaFilter(i: DatiImpresa): boolean {
    return i.flg_distributore === 1;
  }

  cercaPerCF() {
    this.imprese = [];
    const cf = this.searchForm.get('cf')?.value;

    this.accreditamentoService.getDatiImpresa(cf, null, null).subscribe(
      elem => this.gestisciRisultato(elem),
      error => this.handleError(error)
    );
  }

  cercaPerREA() {
    this.imprese = [];
    const siglaRea = this.searchForm.get('siglaRea')?.value;
    const numeroRea = this.searchForm.get('numeroRea')?.value;

    this.accreditamentoService.getDatiImpresa(undefined, siglaRea, numeroRea).subscribe(
      elem => this.gestisciRisultato(elem),
      error => this.handleError(error)
    );
  }

  private handleError(error: any) {
    this.titoloErrore = "Nessun risultato trovato";
    this.descrizioneErrore = "Nessuna persona giuridica trovata con i parametri indicati.";
    this.errorType = 1;
    this.messageService.showMessaggioM();
    this.setErrorStatus(error);
  }

  private gestisciRisultato(elem: DatiImpresa[]) {
    this.searched = true;

    if (elem.length === 0) {
      this.titoloErrore = "Nessun elemento trovato";
      this.descrizioneErrore = "Nessuna persona giuridica trovata con i parametri indicati.";
      this.errorType = 1;
      this.messageService.showMessaggioM();
      return;
    }

    const hasDistributore = elem.some(i => i.flg_distributore == 1);
    this.imprese = elem.filter(i => this.checkImpresaFilter(i));
    this.result.setResultBool(hasDistributore);

    if (this.imprese.length === 0) {
      this.titoloErrore =  hasDistributore 
        ? "Nessun elemento trovato" 
        : "Attenzione"
      this.descrizioneErrore = hasDistributore 
        ? "Nessuna persona giuridica trovata con i parametri indicati." 
        : "L'impresa e' presente a sistema, ma non e' dichiarata con ruolo distributore.";
      this.errorType = 1;
      this.messageService.showMessaggioM();
      return;
    }

    this.result.setResult(this.imprese);
    console.log(this.imprese);
    this.router.navigate(["/risultato-ricerca-impresa"]);
  }

  setErrorStatus(error: any){
    if (error.status === 404) {
      this.persone = [];
    }
  }

  onUppercase(controlName: string, event: Event): void {
    const input = event.target as HTMLInputElement;
    const upper = input.value.toUpperCase();
    this.searchForm.get(controlName)?.setValue(upper, { emitEvent: false });
  }

  clearErrore() {
    this.titoloErrore = '';
    this.descrizioneErrore = '';
  }

  get cf() { return this.searchForm.get('cf'); }
  get siglaRea() { return this.searchForm.get('siglaRea'); }
  get numeroRea() { return this.searchForm.get('numeroRea'); }
}
