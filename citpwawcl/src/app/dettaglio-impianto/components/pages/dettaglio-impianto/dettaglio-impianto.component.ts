import { Location } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatDialog } from '@angular/material/dialog';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { debounceTime, distinctUntilChanged, filter, map } from 'rxjs/operators';
import { DeleteDialogComponent } from 'src/app/common/components/delete-dialog/delete-dialog.component';
import { CodiceDescrizione } from 'src/app/models/codice-descrizione';
import { DatiImpianto } from 'src/app/models/dati-impianto';
import { Esito } from 'src/app/models/esito';
import { LoccsiFeature } from 'src/app/models/loccsi-feature';
import { Persona } from 'src/app/models/persona';
import { UtenteLoggato } from 'src/app/models/utente-loggato';
import { AuthenticationService } from 'src/app/services/authentication.service';
import { BackService } from 'src/app/services/back.service';
import { ComponenteService } from 'src/app/services/componente.service';
import { ImpiantoService } from 'src/app/services/impianto.service';
import { LibrettoService } from 'src/app/services/libretto.service';
import { LocalStorageServiceService } from 'src/app/services/local-storage-service.service';
import { MessageService } from 'src/app/services/message.service';
import { ResultService } from 'src/app/services/result.service';
import { TitleService } from 'src/app/services/title.service';
import { ICONSURL, ID_PROPRIETARIO_PROPRIETARIO, ID_PROPRIETARIO_PROPRIETARIO_IMPRESA, RUOLI } from 'src/app/utils/constants';
import { validateIndirizzo, validateNumbers, validatePDR, validatePOD } from 'src/app/validators/custom.validator';
import { AggiungiComponenteDialogComponent } from '../../aggiungi-componente-dialog/aggiungi-componente-dialog.component';
import { NuovoResponsabileProprietarioComponent } from '../../nuovo-responsabile-proprietario/nuovo-responsabile-proprietario.component';
import { ComuneEsteso } from 'src/app/models/comune-esteso.model';
import { SvistaService } from 'src/app/services/svista.service';

@Component({
  selector: 'app-dettaglio-impianto',
  templateUrl: './dettaglio-impianto.component.html',
  styleUrls: ['./dettaglio-impianto.component.scss']
})
export class DettaglioImpiantoComponent implements OnInit {

  stati: CodiceDescrizione[];
  impiantoForm: FormGroup;
  propForm: FormGroup;
  respForm: FormGroup;
  utente: UtenteLoggato;
  pdf: string = ICONSURL + "pdf.svg";
  success = false;
  codiceImpianto = "";
  mod: any;
  impreseMap: Map<string, any[]> = new Map();

  loccsiClickedImpianto = false;
  currentAddressImpianto: LoccsiFeature;
  filteredOptionsImpianto: Observable<LoccsiFeature[]>;
  indirizziImpianto: LoccsiFeature[] = [];
  isImpiantoDisabled;
  loccsiClickedImpiantoComune = false;
  currentAddressImpiantoComune: LoccsiFeature;
  comuniImpianto: LoccsiFeature[] = [];

  currentAddressImpiantoComuniEsteso: ComuneEsteso;
  filteredOptionsImpiantoComuni: Observable<ComuneEsteso[]>;
  comuniEstesoImpianto: ComuneEsteso[] = [];

  loccsiClickedProp = false;
  currentAddressProp: LoccsiFeature;
  filteredOptionsProp: Observable<LoccsiFeature[]>;
  indirizziProp: LoccsiFeature[] = [];
  isPropDisabled: boolean;
  loccsiClickedPropComuni = false;
  currentAddressPropComuni: LoccsiFeature;
  comuniProp: LoccsiFeature[] = [];

  currentAddressPropComuniEsteso: ComuneEsteso;
  filteredOptionsPropComuni: Observable<ComuneEsteso[]>;
  comuniEstesoProp: ComuneEsteso[] = [];

  loccsiClickedResp = false;
  currentAddressResp: LoccsiFeature;
  filteredOptionsResp: Observable<LoccsiFeature[]>;
  indirizziResp: LoccsiFeature[] = [];
  isRespDisabled: boolean;
  loccsiClickedRespComuni = false;
  currentAddressRespComuni: LoccsiFeature;
  comuniResp: LoccsiFeature[] = [];

  currentAddressRespComuniEsteso: ComuneEsteso;
  filteredOptionsRespComuni: Observable<ComuneEsteso[]>;
  comuniEstesoResp: ComuneEsteso[] = [];


  hasLoadedComponents = false;
  emptyComponents: boolean;
  titoli: CodiceDescrizione[] = [];

  constructor(public dialog: MatDialog, private readonly router: Router,
    private location: Location,
    private readonly impiantoService: ImpiantoService, private fb: FormBuilder,
    private readonly svistaService: SvistaService,
    private readonly authService: AuthenticationService, private route: ActivatedRoute,
    private readonly librettoService: LibrettoService, private readonly resultService: ResultService,
    private readonly backService: BackService,
    private readonly messageService: MessageService,
    private readonly titleService: TitleService,
    private readonly localStorageService: LocalStorageServiceService,
    private readonly componenteService: ComponenteService) {
    this.utente = authService.getCurrentUserFromSession();
    this.stati = [];
    this.impiantoForm = this.fb.group({
      codiceImpianto: ["", validateNumbers()],
      statoImpianto: [""],
      dataAss: ["", Validators.required],
      dataVar: [, Validators.required],
      motivazione: ["", Validators.required],
      tipo: ["", Validators.required],
      locTecnico: [false],
      contabilizzazione: [false],
      indirizzoLoccsi: ["", [Validators.required, validateIndirizzo()]],
      civicoLoccsi: ["", Validators.required],
      stradario: [false],
      indirizzo: [""],
      civico: [""],
      comune: [""],
      provincia: [""],
      pod: ["", validatePOD()],
      pdr: ["", validatePDR()],
      noPdr: [false],
      propCheck: [false]
    });

    this.propForm = this.fb.group({
      denominazione: [""],
      resEstera: [""],
      capEstero: [""],
      indirizzoEstero: [""],
      cittaEstero: [""],
      statoEstero: [""],
      indirizzoLoccsi: ["", [Validators.required, validateIndirizzo()]],
      civicoLoccsi: ["", Validators.required],
      stradario: [""],
      indirizzo: [""],
      civico: [""],
      comune: [""],
      provincia: [""],
      dataInizio: [""],
      email: [""]
    });

    this.respForm = this.fb.group({
      denominazione: [""],
      resEstera: [""],
      capEstero: [""],
      indirizzoEstero: [""],
      cittaEstero: [""],
      statoEstero: [""],
      indirizzoLoccsi: ["", [Validators.required, validateIndirizzo()]],
      civicoLoccsi: ["", Validators.required],
      stradario: [""],
      indirizzo: [""],
      civico: [""],
      comune: [""],
      provincia: [""],
      dataInizio: [""],
      titolo: [""],
      email: [""]
    });

    this.codiceImpianto = this.route.snapshot.paramMap.get('id_impianto');
  }

  ngOnInit(): void {
    this.titleService.setTitle("Dettaglio impianti termici");
    this.backService.setBackTitle("Torna alla ricerca");
    this.backService.setRoute("impianto/ricerca-impianti");
    this.impiantoForm.markAllAsTouched();
    this.respForm.markAllAsTouched();
    this.propForm.markAllAsTouched();
    this.impiantoService.getStatoImpianto().subscribe((elem: CodiceDescrizione[]) => {
      this.stati = elem;
    });

    this.impiantoForm.disable();
    this.propForm.disable();
    this.respForm.disable();

    this.isImpiantoDisabled = true;
    this.isRespDisabled = true;
    this.isPropDisabled = true;
    this.success = !!this.route.snapshot.paramMap.get('success');
    if (this.success) 
    {
      this.messageService.setTitolo("Successo");
      if (!!this.route.snapshot.paramMap.get('message')) 
      {
        this.messageService.setDescrizione(this.route.snapshot.paramMap.get('message'));
      } 
      else 
      {
        this.messageService.setDescrizione("Inserimento impianto avvenuto con successo");
      }
      this.messageService.showMessaggioM();
    }


    this.impiantoForm.controls['indirizzoLoccsi'].valueChanges
      .pipe(debounceTime(500), distinctUntilChanged(), filter(data => data.length >= 3)).subscribe(elem => {
        if (typeof elem === "string") {
          this.loccsiClickedImpianto = false;
          this.currentAddressImpianto = undefined;
          const elem2 = elem;
          this.impiantoForm.controls['civicoLoccsi'].enable();
          this.filteredOptionsImpianto = this.impiantoService.getIndirizzoStradario(elem2)
            .pipe(
              map(name => name ? name : this.indirizziImpianto.slice()));
        }
      });

    this.impiantoForm.controls['comune'].valueChanges
      .pipe(debounceTime(500), distinctUntilChanged(), filter(data => data.length >= 2)).subscribe(elem => {
        if (typeof elem === "string") {
          this.loccsiClickedImpiantoComune = false;
          this.currentAddressImpiantoComune = undefined;
          const elem2 = elem;
          this.impiantoForm.controls['civicoLoccsi'].enable();
          this.filteredOptionsImpiantoComuni = this.svistaService.loadDataFromLocalStorage(elem2)
          .pipe(
           map(name => name ? name : this.comuniEstesoImpianto.slice()));
         } 
      });

    this.propForm.controls['indirizzoLoccsi'].valueChanges
      .pipe(debounceTime(500), distinctUntilChanged(), filter(data => data.length >= 3)).subscribe(elem => {
        if (typeof elem === "string") {
          this.loccsiClickedProp = false;
          this.currentAddressProp = undefined;
          const elem2 = elem;
          this.propForm.controls['civicoLoccsi'].enable();
          this.filteredOptionsProp = this.impiantoService.getIndirizzoStradario(elem2)
            .pipe(
              map(name => name ? name : this.indirizziProp.slice()));
        }
      });

    this.propForm.controls['comune'].valueChanges
      .pipe(debounceTime(500), distinctUntilChanged(), filter(data => data.length >= 2)).subscribe(elem => {
        if (typeof elem === "string") {
          this.loccsiClickedPropComuni = false;
          this.currentAddressPropComuni = undefined;
          const elem2 = elem;
          this.propForm.controls['civicoLoccsi'].enable();
          this.filteredOptionsPropComuni = this.svistaService.loadDataFromLocalStorage(elem2)
          .pipe(
           map(name => name ? name : this.comuniEstesoProp.slice()));
         } 
      });

    this.respForm.controls['indirizzoLoccsi'].valueChanges
      .pipe(debounceTime(500), distinctUntilChanged(), filter(data => data.length >= 3)).subscribe(elem => {
        if (typeof elem === "string") {
          this.loccsiClickedResp = false;
          this.currentAddressResp = undefined;
          const elem2 = elem;
          this.respForm.controls['civicoLoccsi'].enable();
          this.filteredOptionsResp = this.impiantoService.getIndirizzoStradario(elem2)
            .pipe(
              map(name => name ? name : this.indirizziResp.slice()));
        }
      });

    this.respForm.controls['comune'].valueChanges
      .pipe(
        debounceTime(500),
        distinctUntilChanged(),
        filter(data => data.length >= 2)).subscribe(
          elem => {
            if (typeof elem === "string") {
              this.loccsiClickedRespComuni = false;
              this.currentAddressRespComuni = undefined;
              const elem2 = elem;
              this.respForm.controls['civicoLoccsi'].enable();
             this.filteredOptionsRespComuni = this.svistaService.loadDataFromLocalStorage(elem2)
             .pipe(
              map(name => name ? name : this.comuniEstesoResp.slice()));
            } 
          });
    this.svistaService.saveComuniEstesiToLocalStorage();
    this.getDettaglioImpianto();
  }

  getDettaglioImpianto() {
    this.impiantoService.getDettaglioImpianto(this.codiceImpianto).subscribe(elem => {
      this.mod = elem;
      this.localStorageService.setXmlImpianto(this.mod);
      this.compilaSezioneImpianto();
      this.compilaSezioneProprietario();
      this.compilaSezioneResponsabile();
      this.compilaSezComponenti();
      this.updateValidityAll();
    }, error => {
      this.messageService.setTitolo("Errore recupero dettaglio");
      let esito = error.error as Esito;
      this.messageService.setDescrizione(esito.descrizioneEsito);
      this.messageService.showMessaggioM();
      this.messageService.setType(2);
    });
  }

  checkMessageDescription(descrizione : String) : String {
    this.messageService.showMessaggioM();
    if(descrizione == "Codice POD o PDR inserito gia' presente sul sistema") {
      this.messageService.setType(1);
      return descrizione;
    }
    else{
      this.messageService.setType(4);
      return descrizione ??= "";
    }
  }

  inserisciImpianto() {
        
    this.disableLoocsiValidators();
    if (this.impiantoFormValid()) 
    {
      let impianto = this.creaNuovoImpianto();
      this.impiantoService.updateImpianto(impianto, this.codiceImpianto).subscribe((elem) => 
      {
        this.router.navigateByUrl('/', { skipLocationChange: true }).then(() =>
        this.router.navigate(["/impianto/dettaglio-impianto/" + this.codiceImpianto, 
        { success: true, message: this.checkMessageDescription(elem.descrizioneEsito)}]));
      }, error => 
      {
        this.messageService.setTitolo("Errore aggiornamento impianto");
        let esito = error.error as Esito;
        this.messageService.setDescrizione(esito.descrizioneEsito);
        this.messageService.showMessaggioM();
        this.messageService.setType(2);
      });
    } 
    else 
    {
      this.impiantoForm.markAllAsTouched();
      this.messageService.setType(2);
      this.messageService.setTitolo("Dati impianto non validi");
      this.messageService.setDescrizione("Compilare tutti i campi e riprovare");
      this.messageService.showMessaggioM();
    }
  }

  inserisciResponsabile() {

    let persona = this.creaNuovoResponsabile();
    this.impiantoService.updateResponsabileProprietario(this.codiceImpianto, persona).subscribe((elem) => {
      this.router.navigateByUrl('/', { skipLocationChange: true }).then(() =>
        this.router.navigate(["/impianto/dettaglio-impianto/" + this.codiceImpianto, 
        { success: true, message: this.checkMessageDescription("Responsabile inserito con successo") }]));
    }, error => {
      this.messageService.setTitolo("Errore aggiornamento responsabile");
      let esito = error.error as Esito;
      this.messageService.setDescrizione(esito.descrizioneEsito);
      this.messageService.showMessaggioM();
      this.messageService.setType(2);
    });
  }

  inserisciProprietario() {
    
    let persona = this.creaNuovoProprietario();
    this.impiantoService.updateResponsabileProprietario(this.codiceImpianto, persona).subscribe((elem) => {
      this.router.navigateByUrl('/', { skipLocationChange: true }).then(() =>
        this.router.navigate(["/impianto/dettaglio-impianto/" + this.codiceImpianto, 
        { success: true, message: this.checkMessageDescription("Proprietario inserito con successo") }]));
    }, error => {
      this.messageService.setTitolo("Errore aggiornamento proprietario");
      let esito = error.error as Esito;
      this.messageService.setDescrizione(esito.descrizioneEsito);
      this.messageService.showMessaggioM();
      this.messageService.setType(2);
    });
  }

  creaNuovoResponsabile() {
    let persona: Persona = new Persona();
    let datiPrecompilati = this.mod.Richiesta.datiPrecompilati;
    let estero = this.respForm.controls["resEstera"].value;
    let stradario = this.respForm.controls["stradario"].value;
    persona.email = this.respForm.controls["email"].value ? this.respForm.controls["email"].value.toUpperCase() : undefined;
    persona.flgResp = true;
    if (estero) {
      persona.stradario = 0;
      persona.residenzaEstera = 1;
      persona.indirizzoEstero = this.respForm.controls["indirizzoEstero"].value ? this.respForm.controls["indirizzoEstero"].value.toUpperCase() : undefined;
      persona.capEstero = this.respForm.controls["capEstero"].value ? this.respForm.controls["capEstero"].value.toUpperCase() : undefined;
      persona.cittaEstero = this.respForm.controls["cittaEstero"].value ? this.respForm.controls["cittaEstero"].value.toUpperCase() : undefined;
      persona.statoEstero = this.respForm.controls["statoEstero"].value ? this.respForm.controls["statoEstero"].value.toUpperCase() : undefined;
    } else if (stradario) {
      persona.stradario = 1;
      persona.residenzaEstera = 0;
      persona.comune = this.currentAddressRespComuniEsteso.comune;
      persona.siglaProv = this.currentAddressRespComuniEsteso.siglaProvincia;
      persona.istatComune = this.currentAddressRespComuniEsteso.codiceIstat;
      persona.provincia = this.respForm.controls["provincia"].value;
      persona.indirizzoNonTrovato = this.respForm.controls["indirizzo"].value;
      persona.civico = this.respForm.controls["civico"].value;
    } else {
      persona.stradario = 0;
      persona.residenzaEstera = 0;
      if (this.loccsiClickedResp) {
        persona.comune = this.currentAddressResp.properties.comune;
        persona.provincia = this.currentAddressResp.properties.descProvincia;
        persona.siglaProv = this.currentAddressResp.properties.siglaProvincia ? this.currentAddressResp.properties.siglaProvincia : this.currentAddressResp.properties.pv;
        persona.istatComune = this.currentAddressResp.properties.codiceIstat ? this.currentAddressResp.properties.codiceIstat : undefined;
        let respStr = this.currentAddressResp.properties.tipoVia;
        respStr += this.currentAddressResp.properties.preposizione
          && this.currentAddressResp.properties.preposizione != "" ? " " + this.currentAddressResp.properties.preposizione : "";
        respStr += " " + this.currentAddressResp.properties.nomeVia;
        persona.indirizzoSitad = respStr;
        if (this.currentAddressResp.properties.civicoNum) {
          persona.civico = this.currentAddressResp.properties.civicoNum;
          persona.civico += this.currentAddressResp.properties.civicoSub ? " " + this.currentAddressResp.properties.civicoSub : "";
        } else {
          persona.civico = this.respForm.controls["civicoLoccsi"].value;
        }
      }
    }

    if (datiPrecompilati.L1_6cf) {
      persona.nome = datiPrecompilati.L1_6nome;
      persona.cognomeDenominazione = datiPrecompilati.L1_6cognome;
    } else {
      persona.cognomeDenominazione = datiPrecompilati.L1_6ragSociale;
    }
    persona.dataInizioResp = new Date(datiPrecompilati.L1_6dataInizioIncarico);
    persona.titolo = this.respForm.controls["titolo"].value;
    persona.codiceFiscale = datiPrecompilati.L1_6cf && datiPrecompilati.L1_6cf != "" ? datiPrecompilati.L1_6cf : datiPrecompilati.L1_6piva;
    if (datiPrecompilati.L1_6cf && (datiPrecompilati.L1_6nome || datiPrecompilati.L1_6cognome)) {
      persona.tipo = 0;
    } else if (datiPrecompilati.L1_6piva && datiPrecompilati.L1_6ragSociale) {
      persona.tipo = 1;
    }
    return persona;
  }

  creaNuovoProprietario() {
    let persona: Persona = new Persona();
    let estero = this.propForm.controls["resEstera"].value;
    let stradario = this.propForm.controls["stradario"].value;
    persona.email = this.propForm.controls["email"].value ? this.propForm.controls["email"].value.toUpperCase() : undefined;
    persona.flgResp = false;
    if (estero) {
      persona.residenzaEstera = 1;
      persona.stradario = 0;
      persona.indirizzoEstero = this.propForm.controls["indirizzoEstero"].value ? this.propForm.controls["indirizzoEstero"].value.toUpperCase() : undefined;
      persona.capEstero = this.propForm.controls["capEstero"].value ? this.propForm.controls["capEstero"].value.toUpperCase() : undefined;
      persona.cittaEstero = this.propForm.controls["cittaEstero"].value ? this.propForm.controls["cittaEstero"].value.toUpperCase() : undefined;
      persona.statoEstero = this.propForm.controls["statoEstero"].value ? this.propForm.controls["statoEstero"].value.toUpperCase() : undefined;
    } else if (stradario) {
      persona.residenzaEstera = 0;
      persona.stradario = 1;
      persona.comune = this.currentAddressPropComuniEsteso.comune;
      persona.siglaProv = this.currentAddressPropComuniEsteso.siglaProvincia;
      persona.istatComune = this.currentAddressPropComuniEsteso.codiceIstat;
      persona.provincia = this.propForm.controls["provincia"].value;
      persona.indirizzoNonTrovato = this.propForm.controls["indirizzo"].value;
      persona.civico = this.propForm.controls["civico"].value;
    } else {
      persona.residenzaEstera = 0;
      persona.stradario = 0;
      if (this.loccsiClickedProp) {
        persona.comune = this.currentAddressProp.properties.comune;
        persona.provincia = this.currentAddressProp.properties.descProvincia;
        persona.siglaProv = this.currentAddressProp.properties.siglaProvincia ? this.currentAddressProp.properties.siglaProvincia : this.currentAddressProp.properties.pv;
        persona.istatComune = this.currentAddressProp.properties.codiceIstat ? this.currentAddressProp.properties.codiceIstat : undefined;
        let propStr = this.currentAddressProp.properties.tipoVia;
        propStr += this.currentAddressProp.properties.preposizione
          && this.currentAddressProp.properties.preposizione != "" ? " " + this.currentAddressProp.properties.preposizione : "";
        propStr += " " + this.currentAddressProp.properties.nomeVia;
        persona.indirizzoSitad = propStr;
        if (this.currentAddressProp.properties.civicoNum) {
          persona.civico = this.currentAddressProp.properties.civicoNum;
          persona.civico += this.currentAddressProp.properties.civicoSub ? " " + this.currentAddressProp.properties.civicoSub : "";
        } else {
          persona.civico = this.propForm.controls["civicoLoccsi"].value;
        }
      }
    }

    let datiPrecompilati = this.mod.Richiesta.datiPrecompilati;
    if (datiPrecompilati.L1P_6cf) {
      persona.nome = datiPrecompilati.L1P_6nome;
      persona.cognomeDenominazione = datiPrecompilati.L1P_6cognome;
    } else {
      persona.cognomeDenominazione = datiPrecompilati.L1P_6ragSociale;
    }
    persona.dataInizioResp = new Date(this.propForm.controls["dataInizio"].value);

    persona.codiceFiscale = datiPrecompilati.L1P_6cf && datiPrecompilati.L1P_6cf != "" ? datiPrecompilati.L1P_6cf : datiPrecompilati.L1P_6piva;
    if (datiPrecompilati.L1P_6cf && (datiPrecompilati.L1P_6nome || datiPrecompilati.L1P_6cognome)) {
      persona.tipo = 0;
      persona.titolo = ID_PROPRIETARIO_PROPRIETARIO;
    } else if (datiPrecompilati.L1P_6piva && datiPrecompilati.L1P_6ragSociale) {
      persona.tipo = 1;
      persona.titolo = ID_PROPRIETARIO_PROPRIETARIO_IMPRESA;
    }
    return persona;
  }

  creaNuovoImpianto() {
    let impianto: DatiImpianto = new DatiImpianto();
    let codiceImpianto = this.impiantoForm.controls["codiceImpianto"].value;
    let statoImpianto = this.impiantoForm.controls["statoImpianto"].value;
    let dataAss = this.impiantoForm.controls["dataAss"].value;
    let dataVar = this.impiantoForm.controls["dataVar"].value;
    let motivazione = this.impiantoForm.controls["motivazione"].value;
    let tipo = this.impiantoForm.controls["tipo"].value;
    let locTecnico = this.impiantoForm.controls["locTecnico"].value;
    let contabilizzazione = this.impiantoForm.controls["contabilizzazione"].value;
    let civicoLoccsi = this.impiantoForm.controls["civicoLoccsi"].value;
    let stradario = this.impiantoForm.controls["stradario"].value;
    let indirizzo = this.impiantoForm.controls["indirizzo"].value;
    let civico = this.impiantoForm.controls["civico"].value;
    let comune = this.impiantoForm.controls["comune"].value;
    let provincia = this.impiantoForm.controls["provincia"].value;
    let pod = this.impiantoForm.controls["pod"].value;
    let pdr = this.impiantoForm.controls["pdr"].value;
    let noPdr = this.impiantoForm.controls["noPdr"].value;
    let propCheck = this.impiantoForm.controls["propCheck"].value;

    if (codiceImpianto)
      impianto.codiceImpianto = codiceImpianto;
    impianto.dataAssCi = dataAss;
    impianto.dataVar = dataVar;
    impianto.motivazione = motivazione;
    impianto.tipoImpianto = tipo;
    impianto.flgContabilizzazione = contabilizzazione;
    if (stradario) {
      impianto.civico = civico;
      impianto.indirizzoNonTrovato = indirizzo;
      impianto.comune = this.currentAddressImpiantoComuniEsteso.comune;
      impianto.siglaProv = this.currentAddressImpiantoComuniEsteso.siglaProvincia;
      impianto.istatComune = this.currentAddressImpiantoComuniEsteso.codiceIstat;
      impianto.provincia = provincia;
      } else if (this.loccsiClickedImpianto) {
      let impiantoStr = this.currentAddressImpianto.properties.tipoVia;
      impiantoStr += this.currentAddressImpianto.properties.preposizione
        && this.currentAddressImpianto.properties.preposizione != "" ? " " + this.currentAddressImpianto.properties.preposizione : "";
      impiantoStr += " " + this.currentAddressImpianto.properties.nomeVia;
      impianto.indirizzoSitad = impiantoStr;
      impianto.comune = this.currentAddressImpianto.properties.comune;
      if (this.currentAddressImpianto.properties.civicoNum) {
        impianto.civico = this.currentAddressImpianto.properties.civicoNum;
        impianto.civico += this.currentAddressImpianto.properties.civicoSub ? " " + this.currentAddressImpianto.properties.civicoSub : "";
      } else {
        impianto.civico = civicoLoccsi;
      }

      impianto.provincia = this.currentAddressImpianto.properties.descProvincia;
      impianto.siglaProv = this.currentAddressImpianto.properties.siglaProvincia;
      impianto.coordX = this.currentAddressImpianto.geometry.coordinates[0],
        impianto.coordY = this.currentAddressImpianto.geometry.coordinates[1]
      impianto.istatComune = this.currentAddressImpianto.properties.codiceIstat ? this.currentAddressImpianto.properties.codiceIstat : undefined;

    }

    impianto.stato = statoImpianto;
    impianto.pod = pod;
    if (!noPdr) {
      impianto.pdr = pdr;
    }

    impianto.flgNoPdr = noPdr;
    impianto.stradario = stradario;
    impianto.flgVisuProprietario = propCheck;
    impianto.flgApparevvUiExt = locTecnico;
    return impianto;
  }




  impiantoFormValid() {
    return this.impiantoForm.controls["stradario"].value ? this.impiantoForm.valid && this.loccsiClickedImpiantoComune : this.impiantoForm.valid && this.loccsiClickedImpianto;
  }

  propFormValid() {
    if (this.propForm.controls["stradario"].value) {
      return this.propForm.valid && this.loccsiClickedPropComuni;
    } else if (!this.propForm.controls["resEstera"].value) {
      return this.propForm.valid && this.loccsiClickedProp;
    } else
      return this.propForm.valid;
  }

  respFormValid() {
    if (this.respForm.controls["stradario"].value) {
      return this.respForm.valid && this.loccsiClickedRespComuni;
    } else if (!this.respForm.controls["resEstera"].value) {
      return this.respForm.valid && this.loccsiClickedResp;
    } else
      return this.respForm.valid;
  }

  enableModifica(elem: number) {
    switch (elem) {
      case 0:
        this.impiantoForm.enable();
        this.isImpiantoDisabled = false;
        this.impiantoForm.controls["codiceImpianto"].disable();
        this.impiantoForm.controls["dataAss"].disable();
        this.impiantoForm.controls["dataVar"].disable();
        this.impiantoForm.controls["motivazione"].disable();

        if (!(this.utente.ruoloLoggato.ruolo === RUOLI.RUOLO_SUPER
          || this.utente.ruoloLoggato.ruolo === RUOLI.RUOLO_RESPONSABILE
          || this.utente.ruoloLoggato.ruolo === RUOLI.RUOLO_RESPONSABILE_IMPRESA
          || this.utente.ruoloLoggato.ruolo === RUOLI.RUOLO_IMPRESA)) {
          this.impiantoForm.controls["pod"].disable();
          this.impiantoForm.controls["pdr"].disable();
        } else if (this.impiantoForm.controls["noPdr"].value) {
          this.impiantoForm.controls["pdr"].disable();
        }

        if (!this.isEditabile()) {
          this.impiantoForm.controls["indirizzoLoccsi"].disable();
          this.impiantoForm.controls["civicoLoccsi"].disable();
          this.impiantoForm.controls["indirizzo"].disable();
          this.impiantoForm.controls["civico"].disable();
          this.impiantoForm.controls["comune"].disable();
          this.impiantoForm.controls["provincia"].disable();
          this.impiantoForm.controls["stradario"].disable();
        }
        break;
      case 1:
        this.propForm.enable();
        this.isPropDisabled = false;
        this.propForm.controls['dataInizio'].disable();
        this.propForm.controls['denominazione'].disable();
        if (this.currentAddressProp && this.currentAddressProp.properties.civicoNum) {
          this.propForm.controls['civicoLoccsi'].disable();
        }
        break;
      case 2:
        this.respForm.enable();
        this.isRespDisabled = false;
        this.respForm.controls['dataInizio'].disable();
        this.respForm.controls['denominazione'].disable();
        if (this.currentAddressResp && this.currentAddressResp.properties.civicoNum) {
          this.respForm.controls['civicoLoccsi'].disable();
        }
        break;
    }
  }

  isEditabile() {
    let ruolo = this.utente.ruoloLoggato.ruolo;
    return (ruolo === RUOLI.RUOLO_SUPER
      || ruolo === RUOLI.RUOLO_VALIDATORE
      || ruolo === RUOLI.RUOLO_ISPETTORE);
  }

  disableModifica(elem: number) {

    switch (elem) {
      case 0:
        this.impiantoForm.disable();
        this.compilaSezioneImpianto();
        this.isImpiantoDisabled = true;
        break;
      case 1:
        this.isPropDisabled = true;
        this.compilaSezioneProprietario();
        this.propForm.disable();
        break;
      case 2:
        this.isRespDisabled = true;
        this.compilaSezioneResponsabile();
        this.respForm.disable();
        break;
    }
  }

  apriNuovoProprietario() {
    this.dialog.open(NuovoResponsabileProprietarioComponent, {
      width: "90%",
      height: '90%',
      maxWidth: "500px",
      data: { isResp: false, codiceImpianto: this.codiceImpianto }
    }).afterClosed().subscribe(response => {
      if (response) {
        this.mod = response;
        this.router.navigateByUrl('/', { skipLocationChange: true }).then(() =>
          this.router.navigate(["/impianto/dettaglio-impianto/" + this.codiceImpianto]));
      }
    });
  }

  apriNuovoResponsabile() {
    this.dialog.open(NuovoResponsabileProprietarioComponent, {
      width: "90%",
      height: '90%',
      maxWidth: "500px",
      data: { isResp: true, codiceImpianto: this.codiceImpianto }
    }).afterClosed().subscribe(response => {
      if (response) {
        this.mod = response;
        this.router.navigateByUrl('/', { skipLocationChange: true }).then(() =>
          this.router.navigate(["/impianto/dettaglio-impianto/" + this.codiceImpianto]));
      }
    });
  }

  apriAggiungiComponente() {
    this.resultService.setResult(this.mod.Richiesta.datiPrecompilati);
    this.dialog.open(AggiungiComponenteDialogComponent, {
      width: "90%",
      height: '90%',
      maxWidth: "500px",
      data: { codiceImpianto: this.codiceImpianto }
    }).afterClosed().subscribe(response => {
    });
  }

  compilaSezioneImpianto() {
    let datiPrecompilati = this.mod.Richiesta.datiPrecompilati;
    this.loccsiClickedImpianto = false;
    this.impiantoForm.controls['codiceImpianto'].setValue(datiPrecompilati.codice_impianto);
    this.impiantoForm.controls['statoImpianto'].setValue(datiPrecompilati.statoImpianto);
    let dataAss = new Date(datiPrecompilati.dataAssegnazioneCodiceImpianto);
    this.impiantoForm.controls['dataAss'].setValue(dataAss);
    if (datiPrecompilati.dataUltimaVariazioneImpianto) {
      let datavar = new Date(datiPrecompilati.dataUltimaVariazioneImpianto);
      this.impiantoForm.controls['dataVar'].setValue(datavar);
    }
    this.impiantoForm.controls['motivazione'].setValue(datiPrecompilati.motivazione);
    this.impiantoForm.controls['tipo'].setValue(datiPrecompilati.tipoImpianto);

    this.impiantoForm.controls['locTecnico'].setValue(datiPrecompilati.localeTecnicoDedicato ? !!parseInt(datiPrecompilati.localeTecnicoDedicato) : false);
    this.impiantoForm.controls['contabilizzazione'].setValue(datiPrecompilati.contabilizzazioneSingolaUtenza ? !!parseInt(datiPrecompilati.contabilizzazioneSingolaUtenza) : false);
    let fuoriStradario = !!parseInt(datiPrecompilati.fuoriStradario);
    let indirizzo = undefined;
    if (datiPrecompilati.L1_2indirizzo) {
      indirizzo = datiPrecompilati.L1_2indirizzo;
      indirizzo += datiPrecompilati.L1_2comune ? ", " + datiPrecompilati.L1_2comune : "";
    }
    if (fuoriStradario) {
      this.impiantoForm.controls['indirizzo'].setValue(datiPrecompilati.L1_2indirizzo);
      this.impiantoForm.controls['civico'].setValue(datiPrecompilati.L1_2civico);
      if (datiPrecompilati.L1_2comune) {
        this.svistaService.getComuneEsteso(datiPrecompilati.L1_2comune).subscribe((elem: ComuneEsteso[]) => {
          this.setProvinciaComuneEstesoImpianto(elem[0]);
          this.impiantoForm.controls['comune'].setValue(this.currentAddressImpiantoComuniEsteso);
        });
      }
      this.impiantoForm.controls['provincia'].setValue(datiPrecompilati.L1_2prov);
      this.impiantoForm.controls['stradario'].setValue(true);
      this.propForm.controls["indirizzoLoccsi"].clearValidators();
      this.propForm.controls["civicoLoccsi"].clearValidators();
      this.propForm.controls["indirizzoEstero"].clearValidators();
      this.propForm.controls["cittaEstero"].clearValidators();
      this.propForm.controls["capEstero"].clearValidators();
      this.propForm.controls["statoEstero"].clearValidators();
      this.propForm.controls["indirizzo"].setValidators([Validators.required]);
      this.propForm.controls["civico"].setValidators([Validators.required]);
      this.propForm.controls["comune"].setValidators([Validators.required, validateIndirizzo()]);
      this.propForm.controls["provincia"].setValidators([Validators.required]);
    } else {
      if (indirizzo) {
        this.impiantoService.getIndirizzoStradario(indirizzo).subscribe((elem: LoccsiFeature[]) => {
          this.setLoccsiElemSezImpianto(elem[0]);
          this.impiantoForm.controls['indirizzoLoccsi'].setValue(this.currentAddressImpianto);
        });
        this.propForm.controls["indirizzoLoccsi"].setValidators([Validators.required, validateIndirizzo()]);
        this.propForm.controls["civicoLoccsi"].setValidators([Validators.required]);
        this.propForm.controls["indirizzoEstero"].clearValidators();
        this.propForm.controls["cittaEstero"].clearValidators();
        this.propForm.controls["capEstero"].clearValidators();
        this.propForm.controls["statoEstero"].clearValidators();
        this.propForm.controls["indirizzo"].clearValidators();
        this.propForm.controls["civico"].clearValidators();
        this.propForm.controls["comune"].clearValidators();
        this.propForm.controls["provincia"].clearValidators();
      }
    }
    this.impiantoForm.controls['pod'].setValue(datiPrecompilati.sezCatasto.rowCatasto[0].L1_2pod);
    this.impiantoForm.controls['pdr'].setValue(datiPrecompilati.sezCatasto.rowCatasto[0].L1_2pdr);
    this.impiantoForm.controls['noPdr'].setValue(datiPrecompilati.allaccioReteGas);
    this.impiantoForm.controls['propCheck'].setValue(datiPrecompilati.consultazioneStatoProprietario ? !!parseInt(datiPrecompilati.consultazioneStatoProprietario) : false);
  }

  compilaSezioneProprietario() {
    let datiPrecompilati = this.mod.Richiesta.datiPrecompilati;
    this.loccsiClickedProp = false;
    this.loccsiClickedPropComuni = false;
    if (datiPrecompilati.L1P_6cf || datiPrecompilati.L1P_6piva) {
      let denom = "";
      if (datiPrecompilati.L1P_6cf) {
        denom = datiPrecompilati.L1P_6nome ? datiPrecompilati.L1P_6nome : "";
        denom += datiPrecompilati.L1P_6cognome ? " " + datiPrecompilati.L1P_6cognome : "";
      } else {
        denom = datiPrecompilati.L1P_6ragSociale ? datiPrecompilati.L1P_6ragSociale : "";
      }
      this.propForm.controls['denominazione'].setValue(denom);
      let resEstera = datiPrecompilati.L1P_6residenzaEstera;
      this.propForm.controls['resEstera'].setValue(datiPrecompilati.L1P_6residenzaEstera);
      if (resEstera) {
        this.propForm.controls['capEstero'].setValue(datiPrecompilati.L1P_6capEstero);
        this.propForm.controls['cittaEstero'].setValue(datiPrecompilati.L1P_6cittaEstero);
        this.propForm.controls['indirizzoEstero'].setValue(datiPrecompilati.L1P_6indirizzoEstero);
        this.propForm.controls['statoEstero'].setValue(datiPrecompilati.L1P_6statoEstero);
        this.propForm.controls["indirizzoLoccsi"].clearValidators();
        this.propForm.controls["civicoLoccsi"].clearValidators();
        this.propForm.controls["indirizzoEstero"].setValidators([Validators.required]);
        this.propForm.controls["cittaEstero"].setValidators([Validators.required]);
        this.propForm.controls["capEstero"].setValidators([Validators.required]);
        this.propForm.controls["statoEstero"].setValidators([Validators.required]);
        this.propForm.controls["indirizzo"].clearValidators();
        this.propForm.controls["civico"].clearValidators();
        this.propForm.controls["comune"].clearValidators();
        this.propForm.controls["provincia"].clearValidators();
      } else {
        let indirizzo = undefined;
        if (datiPrecompilati.L1P_6indirizzo) {
          indirizzo = datiPrecompilati.L1P_6indirizzo;
          indirizzo += datiPrecompilati.L1P_6comune ? ", " + datiPrecompilati.L1P_6comune : "";
        }
        let fuoriStradario = datiPrecompilati.L1P_6fuoriStradario;
        if (fuoriStradario) {
          this.propForm.controls['indirizzo'].setValue(datiPrecompilati.L1P_6indirizzo);
          this.propForm.controls['civico'].setValue(datiPrecompilati.L1P_6civico);
          if (datiPrecompilati.L1P_6comune) {
            this.svistaService.getComuneEsteso(datiPrecompilati.L1P_6comune).subscribe((elem: ComuneEsteso[]) => {
              this.setProvinciaComuneEstesoProp(elem[0]);
              this.propForm.controls['comune'].setValue(this.currentAddressPropComuniEsteso);
            }); 
          }
          this.propForm.controls['provincia'].setValue(datiPrecompilati.L1P_6provincia);
          this.propForm.controls['stradario'].setValue(true);
          this.propForm.controls["indirizzoLoccsi"].clearValidators();
          this.propForm.controls["civicoLoccsi"].clearValidators();
          this.propForm.controls["indirizzoEstero"].clearValidators();
          this.propForm.controls["cittaEstero"].clearValidators();
          this.propForm.controls["capEstero"].clearValidators();
          this.propForm.controls["statoEstero"].clearValidators();
          this.propForm.controls["indirizzo"].setValidators([Validators.required]);
          this.propForm.controls["civico"].setValidators([Validators.required]);
          this.propForm.controls["comune"].setValidators([Validators.required, validateIndirizzo()]);
          this.propForm.controls["provincia"].setValidators([Validators.required]);
        } else {
          if (indirizzo) {
            this.impiantoService.getIndirizzoStradario(indirizzo).subscribe((elem: LoccsiFeature[]) => {
              this.setLoccsiElemSezProp(elem[0]);
              this.propForm.controls['indirizzoLoccsi'].setValue(this.currentAddressProp);
            });
            this.propForm.controls["indirizzoLoccsi"].setValidators([Validators.required, validateIndirizzo()]);
            this.propForm.controls["civicoLoccsi"].setValidators([Validators.required]);
            this.propForm.controls["indirizzoEstero"].clearValidators();
            this.propForm.controls["cittaEstero"].clearValidators();
            this.propForm.controls["capEstero"].clearValidators();
            this.propForm.controls["statoEstero"].clearValidators();
            this.propForm.controls["indirizzo"].clearValidators();
            this.propForm.controls["civico"].clearValidators();
            this.propForm.controls["comune"].clearValidators();
            this.propForm.controls["provincia"].clearValidators();
          }
        }
      }
      let dataInizio = new Date(datiPrecompilati.L1P_6dataInizioIncarico);
      this.propForm.controls['dataInizio'].setValue(dataInizio);
      this.propForm.controls['email'].setValue(datiPrecompilati.L1P_6email);
    }
  }

  compilaSezioneResponsabile() {
    let datiPrecompilati = this.mod.Richiesta.datiPrecompilati;
    this.loccsiClickedResp = false;
    this.loccsiClickedRespComuni = false;
    if (datiPrecompilati.L1_6cf || datiPrecompilati.L1_6piva) {
      let denom = "";
      if (datiPrecompilati.L1_6cf) {
        denom = datiPrecompilati.L1_6nome ? datiPrecompilati.L1_6nome : "";
        denom += datiPrecompilati.L1_6cognome ? " " + datiPrecompilati.L1_6cognome : "";
      } else {
        denom = datiPrecompilati.L1_6ragSociale ? datiPrecompilati.L1_6ragSociale : "";
      }
      this.respForm.controls['denominazione'].setValue(denom);
      let resEstera = datiPrecompilati.L1_6residenzaEstera;
      this.respForm.controls['resEstera'].setValue(datiPrecompilati.L1_6residenzaEstera);
      if (resEstera) {
        this.respForm.controls['capEstero'].setValue(datiPrecompilati.L1_6capEstero);
        this.respForm.controls['cittaEstero'].setValue(datiPrecompilati.L1_6cittaEstero);
        this.respForm.controls['indirizzoEstero'].setValue(datiPrecompilati.L1_6indirizzoEstero);
        this.respForm.controls['statoEstero'].setValue(datiPrecompilati.L1_6statoEstero);
        this.propForm.controls["indirizzoLoccsi"].clearValidators();
        this.propForm.controls["civicoLoccsi"].clearValidators();
        this.propForm.controls["indirizzoEstero"].setValidators([Validators.required]);
        this.propForm.controls["cittaEstero"].setValidators([Validators.required]);
        this.propForm.controls["capEstero"].setValidators([Validators.required]);
        this.propForm.controls["statoEstero"].setValidators([Validators.required]);
        this.propForm.controls["indirizzo"].clearValidators();
        this.propForm.controls["civico"].clearValidators();
        this.propForm.controls["comune"].clearValidators();
        this.propForm.controls["provincia"].clearValidators();
      } else {
        let indirizzo = undefined;
        if (datiPrecompilati.L1_6indirizzo) {
          indirizzo = datiPrecompilati.L1_6indirizzo;
          indirizzo += datiPrecompilati.L1_6comune ? ", " + datiPrecompilati.L1_6comune : "";
        }
        let fuoriStradario = datiPrecompilati.L1_6fuoriStradario;
        if (fuoriStradario) {
          this.respForm.controls['indirizzo'].setValue(datiPrecompilati.L1_6indirizzo);
          this.respForm.controls['civico'].setValue(datiPrecompilati.L1_6civico);
          if (datiPrecompilati.L1_6comune) {
              this.svistaService.getComuneEsteso(datiPrecompilati.L1_6comune).subscribe((elem: ComuneEsteso[]) => {
              this.setProvinciaComuneEstesoResp(elem[0]);
              this.respForm.controls['comune'].setValue(this.currentAddressRespComuniEsteso);
            });
          }
          this.respForm.controls['provincia'].setValue(datiPrecompilati.L1_6provincia);
          this.respForm.controls['stradario'].setValue(true);
          this.respForm.controls["indirizzoLoccsi"].clearValidators();
          this.respForm.controls["civicoLoccsi"].clearValidators();
          this.respForm.controls["indirizzoEstero"].clearValidators();
          this.respForm.controls["cittaEstero"].clearValidators();
          this.respForm.controls["capEstero"].clearValidators();
          this.respForm.controls["statoEstero"].clearValidators();
          this.respForm.controls["indirizzo"].setValidators([Validators.required]);
          this.respForm.controls["civico"].setValidators([Validators.required]);
          this.respForm.controls["comune"].setValidators([Validators.required, validateIndirizzo()]);
          this.respForm.controls["provincia"].setValidators([Validators.required]);
        } else {
          if (indirizzo) {
            this.impiantoService.getIndirizzoStradario(indirizzo).subscribe((elem: LoccsiFeature[]) => {
              this.setLoccsiElemSezResp(elem[0]);
              this.respForm.controls['indirizzoLoccsi'].setValue(this.currentAddressResp);
            });
            this.respForm.controls["indirizzoLoccsi"].setValidators([Validators.required, validateIndirizzo()]);
            this.respForm.controls["civicoLoccsi"].setValidators([Validators.required]);
            this.respForm.controls["indirizzoEstero"].clearValidators();
            this.respForm.controls["cittaEstero"].clearValidators();
            this.respForm.controls["capEstero"].clearValidators();
            this.respForm.controls["statoEstero"].clearValidators();
            this.respForm.controls["indirizzo"].clearValidators();
            this.respForm.controls["civico"].clearValidators();
            this.respForm.controls["comune"].clearValidators();
            this.respForm.controls["provincia"].clearValidators();
          }
        }
      }
      if (datiPrecompilati.L1_6ragSociale && datiPrecompilati.L1_6piva) {
        this.titoli = [new CodiceDescrizione("10", "Proprietario"), new CodiceDescrizione("11", "Occupante"), new CodiceDescrizione("12", "Amministratore di condominio")];
      } else if (datiPrecompilati.L1_6cf && (datiPrecompilati.L1_6nome || datiPrecompilati.L1_6cognome)) {
        this.titoli = [new CodiceDescrizione("4", "Proprietario"), new CodiceDescrizione("5", "Occupante"), new CodiceDescrizione("13", "Amministratore di condominio")];
      }
      this.respForm.controls['titolo'].setValue(datiPrecompilati.L1_6titolo);
      let dataInizio = new Date(datiPrecompilati.L1_6dataInizioIncarico);
      this.respForm.controls['dataInizio'].setValue(dataInizio);
      this.respForm.controls['email'].setValue(datiPrecompilati.L1_6email);
    }
  }

  compilaSezComponenti() {
    this.hasLoadedComponents = false;
    this.emptyComponents = true;

    let rowGt = this.mod
      && this.mod.Richiesta
      && this.mod.Richiesta.datiSchedaGT
      && this.mod.Richiesta.datiSchedaGT.sezGruppiTermici
      && this.mod.Richiesta.datiSchedaGT.sezGruppiTermici.rowGT ? this.mod.Richiesta.datiSchedaGT.sezGruppiTermici.rowGT : [];

    let rowGf = this.mod
      && this.mod.Richiesta
      && this.mod.Richiesta.datiSchedaGF
      && this.mod.Richiesta.datiSchedaGF.sezGF
      && this.mod.Richiesta.datiSchedaGF.sezGF.rowGF ? this.mod.Richiesta.datiSchedaGF.sezGF.rowGF : [];

    let rowSc = this.mod
      && this.mod.Richiesta
      && this.mod.Richiesta.datiSchedaSC
      && this.mod.Richiesta.datiSchedaSC.sezSC
      && this.mod.Richiesta.datiSchedaSC.sezSC.rowSC ? this.mod.Richiesta.datiSchedaSC.sezSC.rowSC : [];

    let rowCg = this.mod
      && this.mod.Richiesta
      && this.mod.Richiesta.datiSchedaCG
      && this.mod.Richiesta.datiSchedaCG.sezCG
      && this.mod.Richiesta.datiSchedaCG.sezCG.rowCG ? this.mod.Richiesta.datiSchedaCG.sezCG.rowCG : [];

    rowGt.forEach(element => {
      this.emptyComponents = false;
      let key = element.sezGTimpresa.impresaGT.L4_1rea;
      if (!this.impreseMap.has(key)) {
        this.impreseMap.set(key, []);
      }
      this.impreseMap.get(key).push(element);
    });

    rowSc.forEach(element => {
      this.emptyComponents = false;
      let key = element.sezSCimpresa.impresaSC.L4_5rea;
      if (!this.impreseMap.has(key)) {
        this.impreseMap.set(key, []);
      }
      this.impreseMap.get(key).push(element);
    });

    rowGf.forEach(element => {
      this.emptyComponents = false;
      let key = element.sezGFimpresa.impresaGF.L4_4rea;
      if (!this.impreseMap.has(key)) {
        this.impreseMap.set(key, []);
      }
      this.impreseMap.get(key).push(element);
    });

    rowCg.forEach(element => {
      this.emptyComponents = false;
      let key = element.sezCGimpresa.impresaCG.L4_6rea;
      if (!this.impreseMap.has(key)) {
        this.impreseMap.set(key, []);
      }
      this.impreseMap.get(key).push(element);
    });

    this.hasLoadedComponents = true;
  }

  displayFn(indirizzo: LoccsiFeature): string {
    let respStr = indirizzo.properties ? indirizzo.properties.tipoVia : "";
    respStr += indirizzo.properties && indirizzo.properties.preposizione
      && indirizzo.properties.preposizione != "" ? " " + indirizzo.properties.preposizione : "";
    respStr += indirizzo.properties ? " " + indirizzo.properties.nomeVia : "";
    respStr += indirizzo.properties ? ", " + indirizzo.properties.comune : "";
    return respStr;
  }

  /*displayFnComune(indirizzo: LoccsiFeature): string {
    return indirizzo && indirizzo.properties && indirizzo.properties.loccsiLabel ? indirizzo.properties.loccsiLabel : '';
  }*/

  displayFnComune(indirizzo: ComuneEsteso): string {
    return indirizzo && indirizzo.comune ? indirizzo.comune : '';
  }

  setLoccsiElemSezImpianto(feature: LoccsiFeature) {
    this.currentAddressImpianto = feature;
    if (feature.properties.civicoNum) {
      this.impiantoForm.controls['civicoLoccsi'].setValue(feature.properties.civicoNum + " " +
        feature.properties.civicoSub);
    } else if (this.mod.Richiesta.datiPrecompilati.L1_2civico) {
      this.impiantoForm.controls['civicoLoccsi'].setValue(this.mod.Richiesta.datiPrecompilati.L1_2civico);
    } else {
      this.impiantoForm.controls['civicoLoccsi'].setValue("");
    }
    this.loccsiClickedImpianto = true;
  }

  setProvinciaComuneEstesoImpianto(feature: ComuneEsteso) {
    this.currentAddressImpiantoComuniEsteso = feature;
    this.impiantoForm.controls['provincia'].setValue(feature.siglaProvincia ? feature.siglaProvincia : "");
    this.loccsiClickedImpiantoComune = true;
  }

  setLoccsiElemSezProp(feature: LoccsiFeature) {
    this.currentAddressProp = feature;
    if (feature.properties.civicoNum) {
      this.propForm.controls['civicoLoccsi'].setValue(feature.properties.civicoNum + " " +
        feature.properties.civicoSub);
    } else if (this.mod.Richiesta.datiPrecompilati.L1P_6civico) {
      this.propForm.controls['civicoLoccsi'].setValue(this.mod.Richiesta.datiPrecompilati.L1P_6civico);
    } else {
      this.propForm.controls['civicoLoccsi'].setValue("");
    }
    this.loccsiClickedProp = true;
  }

  setProvinciaComuneEstesoProp(feature: ComuneEsteso) {
    this.currentAddressPropComuniEsteso = feature;
    this.propForm.controls['provincia'].setValue(feature.siglaProvincia ? feature.siglaProvincia : "");
    this.loccsiClickedPropComuni = true;
  }

  setLoccsiElemSezResp(feature: LoccsiFeature) {
    this.currentAddressResp = feature;
    if (feature.properties.civicoNum) {
      this.respForm.controls['civicoLoccsi'].setValue(feature.properties.civicoNum + " " +
        feature.properties.civicoSub);
    } else if (this.mod.Richiesta.datiPrecompilati.L1_6civico) {
      this.respForm.controls['civicoLoccsi'].setValue(this.mod.Richiesta.datiPrecompilati.L1_6civico);
    } else {
      this.respForm.controls['civicoLoccsi'].setValue("");
    }
    this.loccsiClickedResp = true;

  }

  setProvinciaComuneEstesoResp(feature: ComuneEsteso) {
    this.currentAddressRespComuniEsteso = feature;
    this.respForm.controls['provincia'].setValue(feature.siglaProvincia ? feature.siglaProvincia : "");
    this.loccsiClickedRespComuni = true;
  }

  variazioneStato(event) {
    let datiPrecompilati = this.mod.Richiesta.datiPrecompilati;
    if (event.value === datiPrecompilati.statoImpianto) {
      this.impiantoForm.controls["motivazione"].setValue(datiPrecompilati.motivazione);
      this.impiantoForm.controls["motivazione"].disable();
      this.impiantoForm.controls["dataVar"].setValue(datiPrecompilati.dataUltimaVariazioneImpianto
        ? new Date(datiPrecompilati.dataUltimaVariazioneImpianto) : "");
      this.impiantoForm.controls["dataVar"].disable();
    } else {
      this.impiantoForm.controls["motivazione"].setValue("");
      this.impiantoForm.controls["motivazione"].enable();
      this.impiantoForm.controls["dataVar"].enable();
      this.impiantoForm.controls["dataVar"].setValue(new Date());
    }
  }

  scaricaLibretto() {
    this.librettoService.getLibrettoByCodice(this.codiceImpianto).subscribe(elem => {
      var blob = new Blob([elem], { type: 'application/pdf' });
      let url = window.URL.createObjectURL(blob);
      let a = document.createElement('a');
      a.href = url;
      a.download = "libretto.pdf";
      a.click();
    }, error => {
      if (error.status === 404) {
        this.messageService.setTitolo("Errore recupero libretto");
        this.messageService.setDescrizione("Nessun libretto trovato sul sistema");
        this.messageService.showMessaggioM();
        this.messageService.setType(2);
      } else {
        let errore = error.error as Esito;
        this.messageService.setTitolo("Errore recupero libretto");
        this.messageService.setDescrizione(errore.descrizioneEsito);
        this.messageService.showMessaggioM();
        this.messageService.setType(2);
      }
    })
  }

  isEnabledModifica() {
    let ruolo = this.utente.ruoloLoggato.ruolo;
    return !((ruolo === RUOLI.RUOLO_CONSULTATORE
      //|| ruolo === RUOLI.RUOLO_RESPONSABILE
      //|| ruolo === RUOLI.RUOLO_RESPONSABILE_IMPRESA
      || ruolo === RUOLI.RUOLO_3RESPONSABILE
      || ruolo === RUOLI.RUOLO_PROPRIETARIO
      || ruolo === RUOLI.RUOLO_PROPRIETARIO_IMPRESA));
  }

  isResponsabile(){
    let ruolo = this.utente.ruoloLoggato.ruolo;
    return (ruolo === RUOLI.RUOLO_RESPONSABILE || ruolo === RUOLI.RUOLO_RESPONSABILE_IMPRESA)
  }

  isEnabledModificaImp() {
    let ruolo = this.utente.ruoloLoggato.ruolo;
    let datiPrecompilati = this.mod && this.mod.Richiesta && this.mod.Richiesta.datiPrecompilati ?
      this.mod.Richiesta.datiPrecompilati : undefined;
    if (!((ruolo === RUOLI.RUOLO_CONSULTATORE
      || ruolo === RUOLI.RUOLO_3RESPONSABILE
      || ruolo === RUOLI.RUOLO_PROPRIETARIO
      || ruolo === RUOLI.RUOLO_PROPRIETARIO_IMPRESA))) {
      if (ruolo === RUOLI.RUOLO_RESPONSABILE_IMPRESA || ruolo === RUOLI.RUOLO_RESPONSABILE) {
        return datiPrecompilati && (datiPrecompilati.L1_6cf === this.utente.pfLoggato.codiceFiscalePF
          || datiPrecompilati.L1_6piva === this.utente.ruoloLoggato.piva);
      } else {
        return true;
      }
    } else
      return false;
  }
  
  disableLoocsiValidators(){
    if (this.impiantoForm.controls["stradario"].value) {
      this.impiantoForm.controls["indirizzoLoccsi"].clearValidators();
      this.impiantoForm.controls["indirizzoLoccsi"].updateValueAndValidity();
      this.impiantoForm.controls["civicoLoccsi"].clearValidators();
      this.impiantoForm.controls["civicoLoccsi"].updateValueAndValidity();

      this.impiantoForm.controls["indirizzo"].setValidators([Validators.required]);
      this.impiantoForm.controls["civico"].setValidators([Validators.required]);
      this.impiantoForm.controls["indirizzo"].updateValueAndValidity();
      this.impiantoForm.controls["civico"].updateValueAndValidity();
      this.impiantoForm.controls["comune"].setValidators([Validators.required, validateIndirizzo()]);
      this.impiantoForm.controls["comune"].updateValueAndValidity();
      this.impiantoForm.controls["provincia"].setValidators([Validators.required]);
      this.impiantoForm.controls["provincia"].updateValueAndValidity();
    }
  }
  
  enableLoocsiValidators(){
    if (!this.impiantoForm.controls["stradario"].value) {
      this.impiantoForm.controls["indirizzo"].clearValidators();
      this.impiantoForm.controls["civico"].clearValidators();
      this.impiantoForm.controls["indirizzo"].updateValueAndValidity();
      this.impiantoForm.controls["civico"].updateValueAndValidity();
      this.impiantoForm.controls["comune"].clearValidators();
      this.impiantoForm.controls["comune"].updateValueAndValidity();
      this.impiantoForm.controls["provincia"].clearValidators();
      this.impiantoForm.controls["provincia"].updateValueAndValidity();

      this.impiantoForm.controls["indirizzoLoccsi"].setValidators([Validators.required, validateIndirizzo()]);
      this.impiantoForm.controls["indirizzoLoccsi"].updateValueAndValidity();
      this.impiantoForm.controls["civicoLoccsi"].setValidators([Validators.required]);
      this.impiantoForm.controls["civicoLoccsi"].updateValueAndValidity();
    }
      
  }
  
  toggleStradarioImpianto($event) {
    if (this.impiantoForm.controls["stradario"].value) this.disableLoocsiValidators();
    else this.enableLoocsiValidators();  
    this.svistaService.saveComuniEstesiToLocalStorage();
  }

  toggleStradarioProp($event) {
    if (this.propForm.controls["stradario"].value) {
      this.propForm.controls["indirizzoLoccsi"].clearValidators();
      this.propForm.controls["indirizzoLoccsi"].updateValueAndValidity();
      this.propForm.controls["civicoLoccsi"].clearValidators();
      this.propForm.controls["civicoLoccsi"].updateValueAndValidity();
      this.propForm.controls["indirizzoEstero"].clearValidators();
      this.propForm.controls["cittaEstero"].clearValidators();
      this.propForm.controls["capEstero"].clearValidators();
      this.propForm.controls["statoEstero"].clearValidators();
      this.propForm.controls["indirizzoEstero"].updateValueAndValidity();
      this.propForm.controls["cittaEstero"].updateValueAndValidity();
      this.propForm.controls["capEstero"].updateValueAndValidity();
      this.propForm.controls["statoEstero"].updateValueAndValidity();
      this.propForm.controls["indirizzo"].setValidators([Validators.required]);
      this.propForm.controls["civico"].setValidators([Validators.required]);
      this.propForm.controls["indirizzo"].updateValueAndValidity();
      this.propForm.controls["civico"].updateValueAndValidity();
      this.propForm.controls["comune"].setValidators([Validators.required, validateIndirizzo()]);
      this.propForm.controls["comune"].updateValueAndValidity();
      this.propForm.controls["provincia"].setValidators([Validators.required]);
      this.propForm.controls["provincia"].updateValueAndValidity();
    } else {
      this.propForm.controls["indirizzo"].clearValidators();
      this.propForm.controls["civico"].clearValidators();
      this.propForm.controls["indirizzo"].updateValueAndValidity();
      this.propForm.controls["civico"].updateValueAndValidity();
      this.propForm.controls["comune"].clearValidators();
      this.propForm.controls["comune"].updateValueAndValidity();
      this.propForm.controls["provincia"].clearValidators();
      this.propForm.controls["provincia"].updateValueAndValidity();

      if (!this.propForm.controls["resEstera"].value) {
        this.propForm.controls["indirizzoLoccsi"].setValidators([Validators.required, validateIndirizzo()]);
        this.propForm.controls["indirizzoLoccsi"].updateValueAndValidity();
        this.propForm.controls["civicoLoccsi"].setValidators([Validators.required]);
        this.propForm.controls["civicoLoccsi"].updateValueAndValidity();
      }

    }

    this.svistaService.saveComuniEstesiToLocalStorage();
  }

  toggleStradarioResp($event) {
    if (this.respForm.controls["stradario"].value) {
      this.respForm.controls["indirizzoLoccsi"].clearValidators();
      this.respForm.controls["indirizzoLoccsi"].updateValueAndValidity();
      this.respForm.controls["civicoLoccsi"].clearValidators();
      this.respForm.controls["civicoLoccsi"].updateValueAndValidity();

      this.respForm.controls["indirizzoEstero"].clearValidators();
      this.respForm.controls["cittaEstero"].clearValidators();
      this.respForm.controls["capEstero"].clearValidators();
      this.respForm.controls["statoEstero"].clearValidators();
      this.respForm.controls["indirizzoEstero"].updateValueAndValidity();
      this.respForm.controls["cittaEstero"].updateValueAndValidity();
      this.respForm.controls["capEstero"].updateValueAndValidity();
      this.respForm.controls["statoEstero"].updateValueAndValidity();

      this.respForm.controls["indirizzo"].setValidators([Validators.required]);
      this.respForm.controls["civico"].setValidators([Validators.required]);
      this.respForm.controls["indirizzo"].updateValueAndValidity();
      this.respForm.controls["civico"].updateValueAndValidity();

      this.respForm.controls["comune"].setValidators([Validators.required, validateIndirizzo()]);
      this.respForm.controls["comune"].updateValueAndValidity();

      this.respForm.controls["provincia"].setValidators([Validators.required]);
      this.respForm.controls["provincia"].updateValueAndValidity();
    } else {

      this.respForm.controls["indirizzo"].clearValidators();
      this.respForm.controls["civico"].clearValidators();
      this.respForm.controls["indirizzo"].updateValueAndValidity();
      this.respForm.controls["civico"].updateValueAndValidity();
      this.respForm.controls["comune"].clearValidators();
      this.respForm.controls["comune"].updateValueAndValidity();
      this.respForm.controls["provincia"].clearValidators();
      this.respForm.controls["provincia"].updateValueAndValidity();

      if (!this.respForm.controls["resEstera"].value) {
        this.respForm.controls["indirizzoLoccsi"].setValidators([Validators.required, validateIndirizzo()]);
        this.respForm.controls["indirizzoLoccsi"].updateValueAndValidity();
        this.respForm.controls["civicoLoccsi"].setValidators([Validators.required]);
        this.respForm.controls["civicoLoccsi"].updateValueAndValidity();
      }
    }

    this.svistaService.saveComuniEstesiToLocalStorage();
  }

  toggleNoPdr($event) {
    if (this.impiantoForm.controls["noPdr"].value) {
      this.impiantoForm.controls["pdr"].setValue("");
      this.impiantoForm.controls["pdr"].disable();
      this.impiantoForm.controls["pdr"].clearValidators();
      this.impiantoForm.controls["pdr"].updateValueAndValidity();
    } else {
      this.impiantoForm.controls["pdr"].enable();
      this.impiantoForm.controls["pdr"].setValidators([Validators.required, validatePDR()]);
      this.impiantoForm.controls["pdr"].updateValueAndValidity();
    }
  }

  toggleResEsteraProp($event) {
    if (this.propForm.controls["resEstera"].value) {
      this.propForm.controls["indirizzoLoccsi"].clearValidators();
      this.propForm.controls["indirizzoLoccsi"].updateValueAndValidity();
      this.propForm.controls["civicoLoccsi"].clearValidators();
      this.propForm.controls["civicoLoccsi"].updateValueAndValidity();

      this.propForm.controls["indirizzoEstero"].setValidators([Validators.required]);
      this.propForm.controls["cittaEstero"].setValidators([Validators.required]);
      this.propForm.controls["capEstero"].setValidators([Validators.required]);
      this.propForm.controls["statoEstero"].setValidators([Validators.required]);
      this.propForm.controls["indirizzoEstero"].updateValueAndValidity();
      this.propForm.controls["cittaEstero"].updateValueAndValidity();
      this.propForm.controls["capEstero"].updateValueAndValidity();
      this.propForm.controls["statoEstero"].updateValueAndValidity();

      this.propForm.controls["indirizzo"].clearValidators();
      this.propForm.controls["civico"].clearValidators();
      this.propForm.controls["indirizzo"].updateValueAndValidity();
      this.propForm.controls["civico"].updateValueAndValidity();
      this.propForm.controls["comune"].clearValidators();
      this.propForm.controls["comune"].updateValueAndValidity();
      this.propForm.controls["provincia"].clearValidators();
      this.propForm.controls["provincia"].updateValueAndValidity();

    } else {
      this.propForm.controls["indirizzoEstero"].clearValidators();
      this.propForm.controls["cittaEstero"].clearValidators();
      this.propForm.controls["capEstero"].clearValidators();
      this.propForm.controls["statoEstero"].clearValidators();
      this.propForm.controls["indirizzoEstero"].updateValueAndValidity();
      this.propForm.controls["cittaEstero"].updateValueAndValidity();
      this.propForm.controls["capEstero"].updateValueAndValidity();
      this.propForm.controls["statoEstero"].updateValueAndValidity();

      if (!this.propForm.controls["stradario"].value) {
        this.propForm.controls["indirizzoLoccsi"].setValidators([Validators.required, validateIndirizzo()]);
        this.propForm.controls["indirizzoLoccsi"].updateValueAndValidity();
        this.propForm.controls["civicoLoccsi"].setValidators([Validators.required]);
        this.propForm.controls["civicoLoccsi"].updateValueAndValidity();
      }
    }
  }

  toggleResEsteraResp($event) {
    if (this.respForm.controls["resEstera"].value) {
      this.respForm.controls["indirizzoLoccsi"].clearValidators();
      this.respForm.controls["indirizzoLoccsi"].updateValueAndValidity();
      this.respForm.controls["civicoLoccsi"].clearValidators();
      this.respForm.controls["civicoLoccsi"].updateValueAndValidity();

      this.respForm.controls["indirizzoEstero"].setValidators([Validators.required]);
      this.respForm.controls["cittaEstero"].setValidators([Validators.required]);
      this.respForm.controls["capEstero"].setValidators([Validators.required]);
      this.respForm.controls["statoEstero"].setValidators([Validators.required]);
      this.respForm.controls["indirizzoEstero"].updateValueAndValidity();
      this.respForm.controls["cittaEstero"].updateValueAndValidity();
      this.respForm.controls["capEstero"].updateValueAndValidity();
      this.respForm.controls["statoEstero"].updateValueAndValidity();

      this.respForm.controls["indirizzo"].clearValidators();
      this.respForm.controls["civico"].clearValidators();
      this.respForm.controls["indirizzo"].updateValueAndValidity();
      this.respForm.controls["civico"].updateValueAndValidity();
      this.respForm.controls["comune"].clearValidators();
      this.respForm.controls["comune"].updateValueAndValidity();
      this.respForm.controls["provincia"].clearValidators();
      this.respForm.controls["provincia"].updateValueAndValidity();

    } else {

      this.respForm.controls["indirizzoEstero"].clearValidators();
      this.respForm.controls["cittaEstero"].clearValidators();
      this.respForm.controls["capEstero"].clearValidators();
      this.respForm.controls["statoEstero"].clearValidators();
      this.respForm.controls["indirizzoEstero"].updateValueAndValidity();
      this.respForm.controls["cittaEstero"].updateValueAndValidity();
      this.respForm.controls["capEstero"].updateValueAndValidity();
      this.respForm.controls["statoEstero"].updateValueAndValidity();

      if (!this.respForm.controls["stradario"].value) {
        this.respForm.controls["indirizzoLoccsi"].setValidators([Validators.required, validateIndirizzo()]);
        this.respForm.controls["indirizzoLoccsi"].updateValueAndValidity();
        this.respForm.controls["civicoLoccsi"].setValidators([Validators.required]);
        this.respForm.controls["civicoLoccsi"].updateValueAndValidity();
      }
    }
  }

  isPropPresent() {
    return this.mod && this.mod.Richiesta && this.mod.Richiesta.datiPrecompilati && (this.mod.Richiesta.datiPrecompilati.L1P_6cf || this.mod.Richiesta.datiPrecompilati.L1P_6piva);
  }

  isRespPresent() {
    return this.mod && this.mod.Richiesta && this.mod.Richiesta.datiPrecompilati && (this.mod.Richiesta.datiPrecompilati.L1_6cf || this.mod.Richiesta.datiPrecompilati.L1_6piva);
  }

  dettaglioGt(numGt) {
    if (this.isEnabledModifica()) {
      this.resultService.setResult(this.mod.Richiesta.datiPrecompilati);
      this.router.navigate(["impianto/dettaglio/" + this.codiceImpianto + "/dettaglio-gt/" + numGt]);
    }
  }


  dettaglioGf(numGf) {
    if (this.isEnabledModifica()) {
      this.resultService.setResult(this.mod.Richiesta.datiPrecompilati);
      this.router.navigate(["impianto/dettaglio/" + this.codiceImpianto + "/dettaglio-gf/" + numGf]);
    }
  }

  dettaglioSc(numSc) {
    if (this.isEnabledModifica()) {
      this.resultService.setResult(this.mod.Richiesta.datiPrecompilati);
      this.router.navigate(["impianto/dettaglio/" + this.codiceImpianto + "/dettaglio-sc/" + numSc]);
    }
  }

  dettaglioCg(numCg) {
    if (this.isEnabledModifica()) {
      this.resultService.setResult(this.mod.Richiesta.datiPrecompilati);
      this.router.navigate(["impianto/dettaglio/" + this.codiceImpianto + "/dettaglio-cg/" + numCg]);
    }
  }

  apriElencoControlli() {
    this.resultService.setResult(this.mod.Richiesta.datiPrecompilati);
    this.router.navigate(["impianto/dettaglio/" + this.codiceImpianto + "/elenco-controlli"]);
  }

  step = 0;
  setStep(index: number) {
    this.step = index;
  }

  deleteComponente(elem) {
    let progr = 0;
    let type = "";
    if (elem.sezGTimpresa) {
      progr = elem.L4_1numGT;
      type = "GT";
    } else if (elem.sezGFimpresa) {
      progr = elem.L4_4numGF;
      type = "GF";
    } else if (elem.sezSCimpresa) {
      progr = elem.L4_5numSC;
      type = "SC";
    } else if (elem.sezCGimpresa) {
      progr = elem.L4_6numCG;
      type = "CG";
    }

    this.dialog.open(DeleteDialogComponent, {
      data: { titolo: "Eliminare il componente?", descrizione: "Confermi di voler eliminare il componente " + type + "-" + progr + "?" }
    }).afterClosed().subscribe(response => {
      if (response) {
        this.componenteService.delComponente(this.codiceImpianto, type, progr).subscribe(res => {
          this.impreseMap.clear();
          this.mod = undefined;
          this.hasLoadedComponents = false;
          this.messageService.setTitolo("Successo");
          this.messageService.setDescrizione("Componente eliminato con successo");
          this.messageService.showMessaggioM();
          this.messageService.setType(4);
          this.getDettaglioImpianto();
        }, error => {
          this.messageService.setTitolo("Errore eliminazione componente");
          let esito = error.error as Esito;
          this.messageService.setDescrizione(esito.descrizioneEsito);
          this.messageService.showMessaggioM();
          this.messageService.setType(2);
        });
      }
    });
  }

  consolidaLibretto() {
    if (this.isRespPresent()) {
      this.librettoService.consolidaLibretto(this.codiceImpianto).subscribe(res => {
        this.messageService.setTitolo("Successo");
        this.messageService.setDescrizione("Impianto consolidato con successo");
        this.messageService.showMessaggioM();
        this.messageService.setType(4);
      }, error => {
        this.messageService.setTitolo("Errore Consolidamento libretto");
        let esito = error.error as Esito;
        this.messageService.setDescrizione(esito.descrizioneEsito);
        this.messageService.showMessaggioM();
        this.messageService.setType(2);
      });
    } else {
      this.messageService.setTitolo("Errore Consolidamento libretto");
      this.messageService.setDescrizione("Impossibile consolidare un libretto senza un responsabile associato all'impianto");
      this.messageService.showMessaggioM();
      this.messageService.setType(2);
    }
  }

  updateValidityAll() {
    Object.keys(this.impiantoForm.controls).forEach(key => {
      this.impiantoForm.controls[key].updateValueAndValidity();
    });
    Object.keys(this.respForm.controls).forEach(key => {
      this.respForm.controls[key].updateValueAndValidity();
    });
    Object.keys(this.propForm.controls).forEach(key => {
      this.propForm.controls[key].updateValueAndValidity();
    });
  }
}



