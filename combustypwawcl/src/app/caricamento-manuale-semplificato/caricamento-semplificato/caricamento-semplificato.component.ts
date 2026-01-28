import { Component, OnInit } from '@angular/core';
import { AbstractControl, FormBuilder, FormGroup, ValidationErrors, Validators } from '@angular/forms';
import { MatCheckboxChange } from '@angular/material/checkbox';
import { Router } from '@angular/router';
import { NgxPermissionsService } from 'ngx-permissions';
import { Observable, of } from 'rxjs';
import { debounceTime, distinctUntilChanged, filter, map, switchMap } from 'rxjs/operators';
import { WARNING_TYPE } from 'src/app/common/components/message-box/message-box.component';
import { CodiceDescrizione } from 'src/app/models/codice-descrizione';
import { ComuneEsteso } from 'src/app/models/comune-esteso.model';
import { DatiFornitura } from 'src/app/models/dati-fornitura';
import { Errore } from 'src/app/models/errore';
import { Esito } from 'src/app/models/esito';
import { ImportDatiDistributore } from 'src/app/models/importazione-dati-distributore';
import { LoccsiFeature } from 'src/app/models/loccsi-feature';
import { LogDatiFornitura } from 'src/app/models/log-dati-fornitura';
import { PERMS } from 'src/app/perms';
import { AuthenticationService } from 'src/app/services/authentication.service';
import { BackService } from 'src/app/services/back.service';
import { DatiDistributoreService } from 'src/app/services/dati-distributore.service';
import { ImpiantoService } from 'src/app/services/impianto.service';
import { MessageService } from 'src/app/services/message.service';
import { ResultService } from 'src/app/services/result.service';
import { SpinnerService } from 'src/app/services/spinner.service';
import { SvistaService } from 'src/app/services/svista.service';
import { TitleService } from 'src/app/services/title.service';
import { RUOLI } from 'src/app/utils/constants';

@Component({
  selector: 'app-caricamento-semplificato',
  templateUrl: './caricamento-semplificato.component.html',
  styleUrls: ['./caricamento-semplificato.component.scss']
})
export class CaricamentoSemplificatoComponent implements OnInit {

  errorType: number = WARNING_TYPE;
  titoloErrore = "";
  descrizioneErrore = "";
  backTitile: string = "";
  route: string = "";
  ruolo: any;

  dettaglioForm: FormGroup;
  combustibileForm: FormGroup;
  unitaDiMisuraForm: FormGroup;
  consumoForm: FormGroup;
  datiFornitura: any | null;

  combustibiliList: CodiceDescrizione[];
  unitaDiMisuraList: CodiceDescrizione[];
  filteredOptionsProp: Observable<LoccsiFeature[]>;
  filteredOptionsComuni: Observable<LoccsiFeature[]>;
  loccsiClickedProp = false;
  indirizziProp: LoccsiFeature[] = [];
  comuni: LoccsiFeature[] = [];
  currentAddressProp: LoccsiFeature;
  currentAddressComuni: LoccsiFeature;
  loccsiClickedComuni: boolean = false;

  isStradarioChecked: boolean;
  importDatiFornitura: ImportDatiDistributore;
  flg_pf_pg: number;
  df: any;
  utente: any;
  
  isVisualizzazioneDettaglio: boolean = false;
  isImpianto: boolean = false;
  isPersona: boolean = false;
  isCheckStradarioHide: boolean = false;

  dugSelezionato: string = "";
  indirizzoSelezionato: string = "";
  civicoSelezionato: string = "";
  descComuneSelezionato: string = "";
  istatSelezionato: string = "";
  capSelezionato: string = "";
  currentYear = new Date().getFullYear();

  constructor(readonly spinnerService: SpinnerService, 
    private router: Router,
    readonly titoloService: TitleService,
    readonly backService: BackService,
    readonly authService: AuthenticationService,
    readonly impiantoService: ImpiantoService,
    readonly datiDistributoreService: DatiDistributoreService,
    readonly messageService: MessageService,
    private readonly result: ResultService,
    private fb: FormBuilder,
    readonly svistaService: SvistaService,
    private permissions: NgxPermissionsService ) {
     }

  ngOnInit(): void {
    this.utente = this.authService.getCurrentUserFromSession();
    this.ruolo = this.authService.getCurrentUserFromSession().ruoloLoggato;
    this.titoloService.setTitle("Caricamento manuale semplificato");
    this.route = "";
    this.backTitile = "Torna indietro"
    this.backService.setBackTitle(this.backTitile);
    this.backService.setRoute("");
    this.setupForms();

     this.datiDistributoreService.getTipoCombustibile().subscribe(combustibili => {
        this.combustibiliList = combustibili;

        this.datiDistributoreService.getUnitaDiMisura().subscribe(unita => {
        this.unitaDiMisuraList = unita;
      
        this.datiFornitura = this.result.getResult();
        this.df = this.datiFornitura;
        console.log("this.datiFornitura :");
        console.log(this.datiFornitura);

        this.postInizializzazione();
      });
    });

      this.dettaglioForm.get('instInterna')?.valueChanges.subscribe((valore: number) => {
      const nome = this.dettaglioForm.get('nome');
      if (!nome) return;

      if (valore === 1) {
        nome.setValidators([Validators.required]);
      } else {
        nome.clearValidators();
      }
      nome.updateValueAndValidity();
    });
  }

  private postInizializzazione(): void {
    this.ricercaIndirizzo();
    
    this.dettaglioForm.get('stradario')?.valueChanges.subscribe(val => {
      if (!val) {
        this.ricercaIndirizzo(); // abilita la ricerca solo se NON è selezionato
      } else {
        this.filteredOptionsProp = of([]); // svuota i risultati se selezionato
      }
    });

    this.dettaglioForm.controls['comune'].valueChanges
      .pipe(debounceTime(500), distinctUntilChanged(), filter(data => data.length >= 3)).subscribe(elem => {
      if (typeof elem === "string") {
        this.loccsiClickedComuni = false;
        this.currentAddressComuni = undefined;
        const elem2 = elem;
        this.dettaglioForm.controls['comune'].enable();
        this.filteredOptionsComuni = this.impiantoService.getProvinciaByComune(elem2)
          .pipe(
            map(name => name ? name : this.comuni.slice()));
      }
    });
    
    this.isVisualizzazioneDettaglio = this.result.getResultIsVisualizzazioneDettaglio();
    this.isImpianto = this.result.getResultIsImpianto();
    this.isPersona = this.result.getResultIsPersona();

    if(this.isVisualizzazioneDettaglio){
      this.route = "elenco-dati-inviati"
      this.backService.setRoute("elenco-dati-inviati");
    } else{
      this.route = "cerca-dati-fornitura";
      this.backService.setRoute("cerca-dati-fornitura");
    }

    console.log("isVisualizzazioneDettaglio: " + this.isVisualizzazioneDettaglio);
    console.log("isImpianto: " + this.isImpianto);
    console.log("isPersona: " + this.isPersona);  
    
    // CASO 1: datiFornitura vuoto, nuovo inserimento
    if (!this.df) 
    {
        this.dettaglioForm.get('annoRiferimento')?.setValue(new Date().getFullYear()); 
        this.dettaglioForm.get('codImpianto')?.disable();
        return;
    }

    // CASO 2: datiFornitura ha tipo datiFornitura
    if (!this.isImpianto && !this.isPersona) {
      console.log("Caso 2");
      this.populateFormFromDatiFornitura(this.df);
    }

    // CASO 3: datiFornitura esiste con codiceImpianto (datiFornitura ha tipo Impianto)
    if (this.isImpianto && !this.isPersona) {
      console.log("Caso 3");
      this.populateFormFromImpianto(this.df);
      const nome = this.dettaglioForm.get('nome');
      const cognome = this.dettaglioForm.get('cognome');
      nome!.clearValidators();
      nome!.updateValueAndValidity();
    }

    // CASO 4: datiFornitura esiste ma senza codiceImpianto (DatiFornitura ha tipo persona)
    if (this.isPersona && !this.isImpianto) {
      console.log("Caso 4");
      this.populateFormFromPersona(this.df);
      const nome = this.dettaglioForm.get('nome');
      const cognome = this.dettaglioForm.get('cognome');
      nome!.setValidators([Validators.required]);
      nome!.updateValueAndValidity();
    }
      
    this.isStradarioChecked = this.dettaglioForm.get("stradario")?.value;

    if(this.isVisualizzazioneDettaglio) {
      this.disableAllControls();
    }
  }

  toggleStradarioImpianto(event: MatCheckboxChange): void {
    const checked = event.checked;
    this.dettaglioForm.get('stradario')?.setValue(checked);
    this.isStradarioChecked = checked;

    if(!this.isVisualizzazioneDettaglio){
      this.dugSelezionato = "";
      this.indirizzoSelezionato = "";
      this.civicoSelezionato = "";
      this.descComuneSelezionato = "";
      this.istatSelezionato = "";
      this.capSelezionato = "";

      this.dettaglioForm.get('indirizzo')?.setValue("");
      this.dettaglioForm.get('indirizzoStradario')?.setValue("");
      this.dettaglioForm.get('comune')?.setValue("");
      this.dettaglioForm.get('civico')?.setValue("");
      this.dettaglioForm.get('cap')?.setValue("");
    }

  }

  updateIndirizzoValidators() {
    const applyValidators = (stradarioValue: boolean) => {
      const indirizzo = this.dettaglioForm.get('indirizzo');
      const indirizzoStradario = this.dettaglioForm.get('indirizzoStradario');
      const comune = this.dettaglioForm.get('comune');
      const civico = this.dettaglioForm.get('civico');

      if (stradarioValue) {
        indirizzo!.clearValidators();
        indirizzoStradario!.setValidators([Validators.required]);
        comune!.setValidators([Validators.required]);
        civico!.setValidators([Validators.required]);
      } else {
        indirizzo!.setValidators([Validators.required]);
        indirizzoStradario!.clearValidators();
        comune!.clearValidators();
        civico!.clearValidators();
      }

      indirizzo!.updateValueAndValidity();
      indirizzoStradario!.updateValueAndValidity();
      comune!.updateValueAndValidity();
      civico!.updateValueAndValidity();
    };

    // Applica subito in base al valore iniziale
    applyValidators(this.dettaglioForm.get('stradario')?.value);

    // Riassegna validator al cambio di valore
    this.dettaglioForm.get('stradario')!.valueChanges.subscribe(applyValidators);
  }

  setupForms(): void {
    this.dettaglioForm = this.fb.group({
      instInterna: [null, Validators.required],
      nome:       ['', Validators.required],
      cognome:    ['', Validators.required],
      cf:         ['', [Validators.required, Validators.minLength(1), Validators.maxLength(16)]],
      codImpianto: [''],
      indirizzo:   [''],
      stradario:   [false],
      indirizzoStradario: [''],
      comune: [''],
      civico: [''],
      cap: [''],
      annoRiferimento: ['',
        [
          Validators.required,
          Validators.pattern(/^\d{4}$/),
          this.annoRangeValidator(2020, this.currentYear)
        ]]
    });

    this.combustibileForm = this.fb.group({
      combustibile: [null, Validators.required]
    });

    this.consumoForm = this.fb.group({
      consumo: ['', Validators.required]
    });

    this.unitaDiMisuraForm = this.fb.group({
      unitaDiMisura: [null, Validators.required]
    });

    this.updateIndirizzoValidators();
  }

  getComuneByCodiceIstat(codiceIstat) {
    const comuniEstesi = JSON.parse(localStorage.getItem('ComuniEstesi'));

    if (!comuniEstesi || !Array.isArray(comuniEstesi)) {
      console.warn("ComuniEstesi non trovato o in formato non valido");
      return null;
    }

    const comune = comuniEstesi.find(c => c.codiceIstat === codiceIstat);

    return comune ? comune.comune : null;
  }

  getCodiceIstatByComune(nomeComune) {
  const comuniEstesi = JSON.parse(localStorage.getItem('ComuniEstesi'));

  if (!comuniEstesi || !Array.isArray(comuniEstesi)) {
    console.warn("ComuniEstesi non trovato o in formato non valido");
    return null;
  }

  // Trova il comune ignorando eventuali differenze di maiuscole/minuscole
  const comune = comuniEstesi.find(c => c.comune.toLowerCase() === nomeComune.toLowerCase());

  return comune ? comune.codiceIstat : null;
  }

  populateFormFromDatiFornitura(df: any): void {
    console.log("populateFormForConsultatore, this.dettaglioForm: " + this.dettaglioForm.value);
    if (!df || !df.datiFornitura || !Array.isArray(df.datiFornitura) || df.datiFornitura.length === 0) {
        this.titoloErrore = "Attenzione!";
        this.descrizioneErrore = "Dati fornitura non presenti.";
        this.errorType = WARNING_TYPE;
        console.warn("populateFormFromDatiFornitura: df o df.datiFornitura non valido", df);
        return;
      }

    const dati = df.datiFornitura[0];
    if (!dati) {
      this.titoloErrore = "Attenzione!";
      this.descrizioneErrore = "Dati fornitura non presenti.";
      this.errorType = WARNING_TYPE;
      console.warn("populateFormFromDatiFornitura: datiFornitura[0] nullo");
      return;
    }
 
    let nomeComune = "";
    if(dati.istat_comune != null && dati.istat_comune != ""){
      nomeComune = this.getComuneByCodiceIstat(dati.istat_comune);
    }
    
    const comuneCap = 
      (nomeComune && dati.cap) ? `${nomeComune} ${dati.cap}` :
      (nomeComune) ? nomeComune :
      (dati.cap) ? dati.cap :
      '';

    const indirizzoCompleto = [
      dati.dug,
      " ",
      dati.indirizzo,
      " ",
      dati.civico,
      comuneCap ? `, ${comuneCap}` : ''
    ].filter(val => val !== undefined && val !== null && val !== '').join('');

    let flgPfGgValue: number = dati.flg_pf_pg === "PF" ? 1 : 0;
    this.dettaglioForm.get('instInterna')?.setValue(flgPfGgValue);   
    this.isCheckStradarioHide = true; 

    this.dettaglioForm.patchValue({
      //instInterna: dati.flg_pf_pg === "PF" ? "1" : "0",
      nome: dati.nome,
      cognome: dati.cognome_denom,
      cf: dati.cf_piva,
      codImpianto: dati.codice_impianto == 0 ? "-" : dati.codice_impianto,
      indirizzo: indirizzoCompleto,
      stradario: dati.indirizzo === "" ? 1 : 0,
      annoRiferimento: dati.anno_rif
    });

    console.log('Form instInterna:', this.dettaglioForm.get('instInterna')?.value);

    const combustibileObj = this.combustibiliList.find(c => c.codice === dati.fk_combustibile?.toString());
    this.combustibileForm.patchValue({ combustibile: combustibileObj });

    const consumoStr = dati.consumo_anno?.toString();
    this.consumoForm.patchValue({ consumo: consumoStr });
    console.log('FormControl consumo:', this.consumoForm.get('consumo')?.value);
    console.log('Tipo:', typeof this.consumoForm.get('consumo')?.value);

    const unitaMisuraObj = this.unitaDiMisuraList.find(c => c.codice === dati.fk_unita_misura?.toString());
    this.unitaDiMisuraForm.patchValue({ unitaDiMisura: unitaMisuraObj });
  }

  populateFormFromImpianto(df: any): void {  
    if (this.df.idPfResponsabile != "" && this.df.idPgResponsabile == "") {
      this.flg_pf_pg = 1;
    } else if (this.df.idPgResponsabile != "" && this.df.idPfResponsabile == "") {
      this.flg_pf_pg = 0;
    }
    
    this.isCheckStradarioHide = true; 
    this.dettaglioForm.get('instInterna')?.setValue(this.flg_pf_pg);   
    this.isStradarioChecked = !!this.df.indirizzoNonTrovato;

    this.dettaglioForm.patchValue({
      //instInterna: this.flg_pf_pg,
      nome: "", // non esiste
      cognome: this.df.denomResponsabile,
      cf: this.df.cfResponsabile,
      codImpianto: this.df.codiceImpianto,
      indirizzo: this.df.indirizzo + " " + this.df.civico + ", " + this.df.descComune,
      stradario: this.isStradarioChecked,
      indirizzoStradario: this.df.indirizzoNonTrovato,
      comune: this.df.descComune,
      //civico: this.df.civico,
      //cap: this.df.cap,
      annoRiferimento: new Date().getFullYear().toString()
    });

    this.combustibileForm.patchValue({ combustibile: ""});
    this.consumoForm.patchValue({ consumo: ""});
    this.unitaDiMisuraForm.patchValue({ unitaDiMisura: "" });

    this.dugSelezionato = "";
    this.indirizzoSelezionato = this.df.indirizzo;
    this.civicoSelezionato = this.df.civico;
    this.descComuneSelezionato = this.df.descComune;
    this.istatSelezionato = this.getCodiceIstatByComune(this.df.descComune);;
    this.capSelezionato =  "";
    
    ['instInterna', 'nome', 'cognome', 'cf', 'codImpianto', 'indirizzo']
    .forEach(field => this.dettaglioForm.get(field)?.disable());
  }
  
  populateFormFromPersona(df: any): void {
    this.dettaglioForm.get('instInterna')?.setValue(this.df.tipo == 1 ? 0 : 1); 
    this.dettaglioForm.patchValue({
      //instInterna: this.df.tipo == 1 ? 0 : 1,
      nome: this.df.nome,
      cognome: this.df.cognomeDenominazione,
      cf: this.df.codiceFiscale,
      //stradario: this.df.stradario,
      //indirizzoStradario: this.df.indirizzoNonTrovato,
      //comune: this.df.comune,
      //civico: this.df.civico,
      annoRiferimento: new Date().getFullYear().toString()
    });

    this.dugSelezionato = "";
    this.indirizzoSelezionato = this.df.indirizzo;
    this.civicoSelezionato = this.df.civico;
    this.descComuneSelezionato = this.df.descComune;
    if(this.df.descComune != null && this.df.descComune != ""){
      this.istatSelezionato = this.getCodiceIstatByComune(this.df.descComune);
    }
    this.capSelezionato =  "";

    ['instInterna', 'nome', 'cognome', 'cf', 'codImpianto']
    .forEach(field => this.dettaglioForm.get(field)?.disable());
  }

  disableAllControls(): void {
    const disableFields = [
      'instInterna', 'nome', 'cognome', 'cf', 'codImpianto', 'indirizzo',
      'stradario', 'annoRiferimento'
    ];

    disableFields.forEach(field => this.dettaglioForm.get(field)?.disable());
    this.combustibileForm.get('combustibile')?.disable();
    this.consumoForm.get('consumo')?.disable();
    this.unitaDiMisuraForm.get('unitaDiMisura')?.disable();
  }

  getDataCorrenteFormattata(): string {
    const now = new Date();
    const pad = (n: number) => n.toString().padStart(2, '0');

    return `${now.getFullYear()}-${pad(now.getMonth() + 1)}-${pad(now.getDate())} ${pad(now.getHours())}:${pad(now.getMinutes())}:${pad(now.getSeconds())}`;
  }

  getCodiceDaDescrizione(lista: CodiceDescrizione[], descrizione: string): number | undefined {
    const trovato = lista.find(item => item.descrizione.toLowerCase() === descrizione.toLowerCase());
    return trovato ? Number(trovato.codice) : undefined;
  }

  onUppercase(controlName: string, event: Event): void {
    const input = event.target as HTMLInputElement;
    const upper = input.value.toUpperCase();
    this.dettaglioForm.get(controlName)?.setValue(upper, { emitEvent: false });
  }

  ricercaIndirizzo() {
      this.dettaglioForm.controls['indirizzo'].valueChanges
    .pipe(
      debounceTime(500),
      distinctUntilChanged(),
      filter(val => typeof val === 'string' && val.length >= 3)
    )
    .subscribe(val => {
      if (!this.dettaglioForm.get('stradario')?.value) {
        this.filteredOptionsProp = this.impiantoService.getIndirizzoStradario(val)
          .pipe(
            map(risultati => risultati ?? [])
          );
      } else {
        this.filteredOptionsProp = of([]);
      }
    });
  }

  displayFnComune(indirizzo: LoccsiFeature): string {
    return indirizzo && indirizzo.properties && indirizzo.properties.loccsiLabel ? indirizzo.properties.loccsiLabel : '';
  }

  displayFn(indirizzo: LoccsiFeature): string {
    if (typeof indirizzo === 'string') {
      if (indirizzo) {
        return indirizzo;
      } else {
        return "";
      }
    }
    return indirizzo && indirizzo.properties && indirizzo.properties.loccsiLabel ? (indirizzo.properties.loccsiLabel) : '';
  }

  setLoccsiElem(feature: LoccsiFeature) {
    this.currentAddressProp = feature;

    if (feature.properties.tipoVia) {
      const tipoVia = feature.properties.tipoVia ?? "";
      const nomeVia = feature.properties.nomeVia ?? "";
      const civicoNum = feature.properties.civicoNum ?? "";
      const civicoSub = feature.properties.civicoSub ?? "";
      const comune = feature.properties.comune ?? "";

      const indirizzo = `${tipoVia} ${nomeVia} ${civicoNum} ${civicoSub}, ${comune}`.trim();
      this.dettaglioForm.controls['indirizzo'].setValue(indirizzo);

      this.dugSelezionato = tipoVia;
      this.indirizzoSelezionato = nomeVia;
      this.civicoSelezionato = `${civicoNum} ${civicoSub}`.trim();
      this.descComuneSelezionato = comune;
      this.istatSelezionato = feature.properties.codiceIstat ?? "";
      this.capSelezionato = feature.properties.cap ?? "";
    }

    this.loccsiClickedProp = true;
  }

  onComuneSelected(selezionato: any): void {
    const comuneLabel = selezionato.properties?.loccsiLabel || '';
    this.dettaglioForm.get('comune')?.setValue(comuneLabel);
  }
  
  clearErrore() {
    this.titoloErrore = '';
    this.descrizioneErrore = '';
  }

  salvaCaricamentoSemplificato() {

    const indirizzoVal = this.dettaglioForm.get('indirizzo')?.value || '';
    const indirizzoFinale = indirizzoVal.trim() === '' ? this.dettaglioForm.get('indirizzoStradario')?.value : indirizzoVal;
    const codImpiantoVal = this.dettaglioForm.get('codImpianto')?.value;


    this.importDatiFornitura = {
      id_import_distrib: null,
      fk_persona_giuridica: this.utente.ruoloLoggato.idPersonaGiuridica,
      fk_stato_distrib: 2,
      des_stato_distrib: "",
      data_inizio_elab: this.getDataCorrenteFormattata(),
      data_fine_elab: this.getDataCorrenteFormattata(),
      data_annullamento: null,
      nome_file_import: "caricamento manuale fornitura " + this.dettaglioForm.get('cf')?.value, 
      uid_index: null,
      anno_riferimento: new Date().getFullYear().toString(),
      data_invio_mail_distrib: null,
      data_invio_mail_assistenza: this.getDataCorrenteFormattata(),
      tot_record_elaborati: 1,
      tot_record_scartati: 0,
      data_ult_mod: this.getDataCorrenteFormattata(),
      utente_ult_mod: this.utente.pfLoggato.codiceFiscalePF,
      utente_caricamento: this.utente.pfLoggato.codiceFiscalePF,
      
      datiFornitura: [],

      //dtAssegnazione: "", 
      //tipo_caricamento: null, 
      //stato_file: null 
  };

  const datiFornituraVuoto: DatiFornitura = {
      id_dato_distrib: 0,
      fk_tipo_contratto: 4,
      fk_import_distrib: 0,
      fk_categoria_util: "ND",
      fk_combustibile: this.getCodiceDaDescrizione(this.combustibiliList, this.combustibileForm.get('combustibile')?.value?.descrizione ),
      des_combustibile: this.combustibileForm.get('combustibile')?.value?.descrizione,
      fk_unita_misura: this.getCodiceDaDescrizione(this.unitaDiMisuraList, this.unitaDiMisuraForm.get('unitaDiMisura')?.value?.descrizione ),
      des_unita_misura: this.unitaDiMisuraForm.get('unitaDiMisura')?.value?.descrizione,
      flg_pf_pg: this.dettaglioForm.get('instInterna')?.value == 1 ? "PF" : "PG",
      cognome_denom: this.dettaglioForm.get('cognome')?.value,
      nome: this.dettaglioForm.get('nome')?.value,
      cf_piva: this.dettaglioForm.get('cf')?.value,
      anno_rif: this.dettaglioForm.get('annoRiferimento')?.value 
          ? this.dettaglioForm.get('annoRiferimento')?.value 
          : "",
      nr_mesi_fattur: 0,
      dug: this.dugSelezionato,
      indirizzo: this.dettaglioForm.get('stradario')?.value ? this.dettaglioForm.get('indirizzoStradario')?.value : this.indirizzoSelezionato,
      civico: this.dettaglioForm.get('stradario')?.value ? this.dettaglioForm.get('civico')?.value : this.civicoSelezionato,
      cap: this.dettaglioForm.get('stradario')?.value ? this.dettaglioForm.get('cap')?.value : this.capSelezionato,
      istat_comune: this.dettaglioForm.get('stradario')?.value ? this.getCodiceIstatByComune(this.dettaglioForm.get('comune')?.value) : this.istatSelezionato,
      des_comune:  this.dettaglioForm.get('stradario')?.value ? this.dettaglioForm.get('comune')?.value : this.descComuneSelezionato,
      consumo_anno: this.consumoForm.get('consumo')?.value,

      flg_pf_pg_fatt: this.dettaglioForm.get('instInterna')?.value == 1 ? "PF" : "PG",
      cognome_denom_fatt: this.dettaglioForm.get('cognome')?.value,
      nome_fatt: this.dettaglioForm.get('nome')?.value,
      cf_piva_fatt: this.dettaglioForm.get('cf')?.value,
      dug_fatt: this.dugSelezionato,
      indirizzo_fatt: this.dettaglioForm.get('stradario')?.value ? this.dettaglioForm.get('indirizzoStradario')?.value : this.indirizzoSelezionato,
      civico_fatt: this.dettaglioForm.get('stradario')?.value ? this.dettaglioForm.get('civico')?.value : this.civicoSelezionato,
      cap_fatt: this.dettaglioForm.get('stradario')?.value ? this.dettaglioForm.get('cap')?.value : this.capSelezionato,
      istat_comune_fatt: this.dettaglioForm.get('stradario')?.value ? this.getCodiceIstatByComune(this.dettaglioForm.get('comune')?.value) : this.istatSelezionato,
      codice_impianto: !codImpiantoVal ? "0" : codImpiantoVal,
      logDatiFornitura: []
  };

  const logDatiFornituraVuoto: LogDatiFornitura = {
    id_log_distrib: null,
    fk_import_distrib: null,
    msg_errore: null
  };

  this.importDatiFornitura.datiFornitura[0] = datiFornituraVuoto;
  this.importDatiFornitura.datiFornitura[0].logDatiFornitura[0] = logDatiFornituraVuoto;
  console.log("Dati inviati:", this.importDatiFornitura);

    this.datiDistributoreService.setDatiDistributoreSemplificatoJson(
      this.authService.getCurrentUserFromSession().ruoloLoggato.idPersonaGiuridica,
      this.authService.getCurrentUserFromSession().ruoloLoggato.piva,
      this.authService.getCurrentUserFromSession().pfLoggato.codiceFiscalePF,
      this.importDatiFornitura
    ).subscribe((element: Esito) => {
            if(element.descrizioneEsito == "" || element.descrizioneEsito == null){
              this.titoloErrore = "Successo";
              this.descrizioneErrore = "Salvataggio dei dati avvenuto con successo.";
              this.errorType = 4;
              this.messageService.showMessaggioM();
              setTimeout(() => {
                    this.result.setResult(null);
                    this.result.setIsPersona(null);
                    this.result.setIsImpianto(null);
                    this.result.setIsVisualizzazioneDettaglio(null);
                    this.router.navigate(["elenco-dati-inviati"]);
                  }, 2000);
            }
    },
        error => {
            let errore = error.error as Errore;
            this.titoloErrore = "Errore nel salvataggio dei dati";
            this.descrizioneErrore = errore.title;
            this.errorType = 2;
            this.messageService.showMessaggioM();
          }
      );
  }

  annulla() {
    this.result.setResult(null);
    this.router.navigate(["elenco-dati-inviati"]); 
  }

  allowOnlyDecimal(event: KeyboardEvent): void {
    const allowedKeys = ['Backspace', 'Tab', 'ArrowLeft', 'ArrowRight', 'Delete'];
    const inputChar = event.key;

    if (allowedKeys.includes(inputChar)) return;

    const isNumber = /^[0-9]$/.test(inputChar);
    const isDot = inputChar === '.';
    const currentValue = (event.target as HTMLInputElement).value;
    const alreadyHasDot = currentValue.includes('.');

    if (!isNumber && !(isDot && !alreadyHasDot)) {
      event.preventDefault();
    }
  }

  allowOnlyNumbers(event: KeyboardEvent): void {
    const allowedKeys = ['Backspace', 'Tab', 'ArrowLeft', 'ArrowRight', 'Delete'];
    const inputChar = event.key;

    if (allowedKeys.includes(inputChar)) return;

    const isNumber = /^[0-9]$/.test(inputChar);

    if (!isNumber) {
      event.preventDefault();
    }
  }

  annoRangeValidator(min: number, max: number) {
    return (control: AbstractControl): ValidationErrors | null => {
      const value = parseInt(control.value, 10);
      if (isNaN(value)) return null;
      if (value < min || value > max) {
        return { annoOutOfRange: true };
      }
      return null;
    };
  }

  isFormInvalid(): boolean {
  return this.dettaglioForm.invalid 
      || this.combustibileForm.invalid 
      || this.consumoForm.invalid 
      || this.unitaDiMisuraForm.invalid;
  }
}
