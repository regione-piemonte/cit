import { NumberInput } from '@angular/cdk/coercion';
import { Component, HostListener, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { MatDialog } from '@angular/material/dialog';
import { ActivatedRoute, Router } from '@angular/router';
import { CodiceDescrizione } from 'src/app/models/codice-descrizione';
import { Errore } from 'src/app/models/errore';
import { Impianto } from 'src/app/models/impianto';
import { UtenteLoggato } from 'src/app/models/utente-loggato';
import { AuthenticationService } from 'src/app/services/authentication.service';
import { BackService } from 'src/app/services/back.service';
import { ImpiantoService } from 'src/app/services/impianto.service';
import { MessageService } from 'src/app/services/message.service';
import { ResultService } from 'src/app/services/result.service';
import { SvistaService } from 'src/app/services/svista.service';
import { TitleService } from 'src/app/services/title.service';
import { ICONSURL, RUOLI, STATO_IMPIANTO } from 'src/app/utils/constants';
import { validateAlphanumeric, validateCFPIVA, validateNumbers } from 'src/app/validators/custom.validator';
import { RicercaIndirizzoDialogComponent } from '../../ricerca-indirizzo-dialog/ricerca-indirizzo-dialog.component';
import { log } from 'console';

@Component({
  selector: 'app-ricerca-impianti',
  templateUrl: './ricerca-impianti.component.html',
  styleUrls: ['./ricerca-impianti.component.scss']
})
export class RicercaImpiantiComponent implements OnInit {

  searchForm: FormGroup;
  stati: CodiceDescrizione[];
  search: string = ICONSURL + "search-bianco.png";
  home: string = ICONSURL + "home.svg";
  utente: UtenteLoggato | null;
  impianti: Impianto[];
  formColBreakpoint: NumberInput;
  heightBreakpoint: NumberInput;
  btnColBreakPoint: NumberInput;
  emptyColBreakPoint: NumberInput;
  isRicercaCompletaEnabled: boolean = false;
  isRicercaCompletaChecked: boolean = false;

  constructor(private fb: FormBuilder, private route: ActivatedRoute,
    public dialog: MatDialog, public router: Router,
    private readonly impiantoService: ImpiantoService,
    private readonly authService: AuthenticationService,
    private readonly result: ResultService,
    private readonly titoloService: TitleService,
    private readonly backService: BackService,
    private readonly messageService: MessageService,
    private readonly svistaService: SvistaService) {
    this.utente = authService.getCurrentUserFromSession();
    this.stati = [];
    this.searchForm = this.fb.group({
      codiceImpianto: ["", validateNumbers()],
      statoImpianto: [""],
      cfResp: ["", validateCFPIVA()],
      cfProp: ["", validateCFPIVA()],
      cf3Resp: ["", validateCFPIVA()],
      pod: ["", validateAlphanumeric()],
      pdr: ["", validateAlphanumeric()]
    });
  }

  ngOnInit(): void {
    this.formColBreakpoint = (window.innerWidth < 768) ? 1 : 2;
    this.btnColBreakPoint = (window.innerWidth < 768) ? 10 : 5;
    this.emptyColBreakPoint = (window.innerWidth < 768) ? 1 : 6;
    this.heightBreakpoint = (window.innerWidth < 768) ? 800 : 460;

    this.svistaService.saveComuniEstesiToLocalStorage();
    this.titoloService.setTitle("Cerca impianto termico");
    this.backService.setRoute("");
    this.impiantoService.getStatoImpianto().subscribe((elem: CodiceDescrizione[]) => {
      this.stati = elem;
      this.searchForm.controls["statoImpianto"].setValue(STATO_IMPIANTO.ATTIVO);
    });
    this.addFilters();

    this.isRicercaCompletaChecked = false;

    // Chiamata da commonwcl
    const navState = history.state as { impresa?: any };
    if (navState?.impresa) {
      const datiImpresa = navState.impresa;
      console.log(datiImpresa);
      console.log(datiImpresa.codice_fiscale);
      console.log(datiImpresa.numero_rea);
      console.log(datiImpresa.sigla_rea);
      this.ricercaImpiantoDaImpresa(datiImpresa.codice_fiscale, datiImpresa.numero_rea, datiImpresa.sigla_rea);
    }
  }

  @HostListener('window:resize', ['$event'])
  onResize(event?) {
    this.formColBreakpoint = (event.target.innerWidth < 768) ? 1 : 2;
    this.btnColBreakPoint = (event.target.innerWidth < 768) ? 10 : 5;
    this.emptyColBreakPoint = (event.target.innerWidth < 768) ? 1 : 6;
    this.heightBreakpoint = (event.target.innerWidth < 768) ? 800 : 460;
  }

  addFilters() {
    if (this.utente?.ruoloLoggato.ruolo == RUOLI.RUOLO_RESPONSABILE_IMPRESA) {
      this.searchForm.controls["cfResp"].setValue(this.utente?.ruoloLoggato.piva);
      this.searchForm.controls["cfResp"].disable();
    }
    if (this.utente?.ruoloLoggato.ruolo == RUOLI.RUOLO_RESPONSABILE) {
      this.searchForm.controls["cfResp"].setValue(this.utente?.pfLoggato.codiceFiscalePF);
      this.searchForm.controls["cfResp"].disable();
    }

    if (this.utente?.ruoloLoggato.ruolo == RUOLI.RUOLO_PROPRIETARIO_IMPRESA) {
      this.searchForm.controls["cfProp"].setValue(this.utente?.ruoloLoggato.piva);
      this.searchForm.controls["cfProp"].disable();
    }
    if (this.utente?.ruoloLoggato.ruolo == RUOLI.RUOLO_PROPRIETARIO) {
      this.searchForm.controls["cfProp"].setValue(this.utente?.pfLoggato.codiceFiscalePF);
      this.searchForm.controls["cfProp"].disable();
    }
    if (this.utente?.ruoloLoggato.ruolo == RUOLI.RUOLO_3RESPONSABILE) {
      this.searchForm.controls["cf3Resp"].setValue(this.utente?.ruoloLoggato.piva);
      this.searchForm.controls["cf3Resp"].disable();
    }

    if(this.utente?.ruoloLoggato.ruolo == RUOLI.RUOLO_IMPRESA){
      this.isRicercaCompletaEnabled = true;
    }
  }

  apriIndirizzoDialog() {
    this.dialog.open(RicercaIndirizzoDialogComponent, {
      width: "90%",
      data: {
        isRicercaCompletaChecked: this.isRicercaCompletaChecked,
      },
      maxWidth: "500px",
    }).afterClosed().subscribe(response => {
      if (response.data != undefined) {
        this.impianti = response.data;
        this.result.setResult(this.impianti);
        this.router.navigate(["/impianto/risultato-ricerca"]);
      } else if (response.error != undefined) {
        this.messageService.setTitolo("Errore recupero impianti");
        this.messageService.setDescrizione(response.error.title);
        this.messageService.showMessaggioM();
        this.messageService.setType(2);
      }
    });
  }

  ricercaImpianto() {
    this.result.setRicercaCompletaChecked(this.isRicercaCompletaChecked);

    let codiceImpianto = this.searchForm.controls['codiceImpianto'].value != "" ?
      this.searchForm.controls['codiceImpianto'].value : undefined;
    let stato = this.searchForm.controls['statoImpianto'].value;
    let cfProprietario = this.searchForm.controls['cfProp'].value != "" ?
      this.searchForm.controls['cfProp'].value : undefined;
    let cfResponsabile = this.searchForm.controls['cfResp'].value != "" ?
      this.searchForm.controls['cfResp'].value : undefined;
    let cf3Resp = this.searchForm.controls['cf3Resp'].value != "" ?
      this.searchForm.controls['cf3Resp'].value : undefined;
    let pod = this.searchForm.controls['pod'].value != "" ?
      this.searchForm.controls['pod'].value : undefined;
    let pdr = this.searchForm.controls['pdr'].value != "" ?
      this.searchForm.controls['pdr'].value : undefined;

    this.impiantoService.getGeoJsonByFilter(this.isRicercaCompletaChecked, codiceImpianto, stato, cfResponsabile, cfProprietario, cf3Resp, pod,
      pdr, undefined, undefined, undefined, undefined, undefined, undefined).subscribe((element: string) => {
        //Da GeoJson a Impianto
        this.impianti = this.impiantoService.parseGeoJsonToImpianto(element);
        this.result.setResult(element);
        this.router.navigate(["/impianto/risultato-ricerca"]);
      },
        error => {
          if (error.status == 404) {
            this.impianti = [];
            this.result.setResult(this.impianti);
            this.router.navigate(["/impianto/risultato-ricerca"]);
          } else {
            let errore = error.error as Errore;
            this.messageService.setTitolo("Errore recupero impianti");
            this.messageService.setDescrizione(errore.title);
            this.messageService.showMessaggioM();
            this.messageService.setType(2);
          }
        });
      }

  isAbilitatoInserisciImpianto() {
    return this.utente?.ruoloLoggato.ruolo != RUOLI.RUOLO_CONSULTATORE &&
      this.utente?.ruoloLoggato.ruolo != RUOLI.RUOLO_3RESPONSABILE &&
      this.utente?.ruoloLoggato.ruolo != RUOLI.RUOLO_PROPRIETARIO &&
      this.utente?.ruoloLoggato.ruolo != RUOLI.RUOLO_PROPRIETARIO_IMPRESA;
  }

  onRicercaCompletaChange(event: any) {
    this.isRicercaCompletaChecked = event.checked;
    console.log('Stato Ricerca Completa:', this.isRicercaCompletaChecked);
  }

  apriInserisciimpianto() {
    this.router.navigate(["/impianto/nuovo-impianto"]);
  }

  ricercaImpiantoDaImpresa(cfImpresa: string, numeroRea: string, siglaRea: string) {
  this.impiantoService.getGeoJsonImpianto(
    cfImpresa,  
    numeroRea,
    siglaRea,
    undefined,    
    undefined,               
    undefined,               
    undefined,               
    undefined,               
    undefined,               
    undefined,           
    undefined,                   
    undefined,               
    undefined,               
    undefined,               
    undefined                
  ).subscribe((element: string) => {
    this.impianti = this.impiantoService.parseGeoJsonToImpianto(element);
    this.result.setResult(element);
    this.router.navigate(["/impianto/risultato-ricerca"]);
  },
    error => {
      if (error.status == 404) {
        this.impianti = [];
        this.result.setResult(this.impianti);
        this.router.navigate(["/impianto/risultato-ricerca"]);
      } else {
        let errore = error.error as Errore;
        this.messageService.setTitolo("Errore recupero impianti");
        this.messageService.setDescrizione(errore.title);
        this.messageService.showMessaggioM();
        this.messageService.setType(2);
      }
    });
}
}
