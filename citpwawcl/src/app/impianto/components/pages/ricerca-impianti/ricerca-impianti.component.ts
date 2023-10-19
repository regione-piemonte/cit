import { Component, OnInit } from '@angular/core';
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
import { TitleService } from 'src/app/services/title.service';
import { ICONSURL, RUOLI, STATO_IMPIANTO } from 'src/app/utils/constants';
import { validateAlphanumeric, validateCFPIVA, validateNumbers } from 'src/app/validators/custom.validator';
import { RicercaIndirizzoDialogComponent } from '../../ricerca-indirizzo-dialog/ricerca-indirizzo-dialog.component';
import { SvistaService } from 'src/app/services/svista.service';

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
    this.svistaService.saveComuniEstesiToLocalStorage();
    this.titoloService.setTitle("Cerca impianto termico");
    this.backService.setRoute("");
    this.impiantoService.getStatoImpianto().subscribe((elem: CodiceDescrizione[]) => {
      this.stati = elem;
      this.searchForm.controls["statoImpianto"].setValue(STATO_IMPIANTO.ATTIVO);
    });
    this.addFilters();
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
  }

  apriIndirizzoDialog() {
    this.dialog.open(RicercaIndirizzoDialogComponent, {
      width: "90%",
      data: "",
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

    this.impiantoService.getImpiantoByFilter(codiceImpianto, stato, cfResponsabile, cfProprietario, cf3Resp, pod,
      pdr, undefined, undefined, undefined, undefined, undefined).subscribe((element: Impianto[]) => {
        this.impianti = element;
        this.result.setResult(this.impianti);
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

  apriInserisciimpianto() {
    this.router.navigate(["/impianto/nuovo-impianto"]);
  }
}
