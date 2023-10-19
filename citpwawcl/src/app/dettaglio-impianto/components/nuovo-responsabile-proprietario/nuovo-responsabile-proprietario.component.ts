import { Component, Inject, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatCheckboxChange } from '@angular/material/checkbox';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import { Observable } from 'rxjs';
import { debounceTime, distinctUntilChanged, filter, map } from 'rxjs/operators';
import { Esito } from 'src/app/models/esito';
import { LoccsiFeature } from 'src/app/models/loccsi-feature';
import { Persona } from 'src/app/models/persona';
import { ImpiantoService } from 'src/app/services/impianto.service';
import { SpinnerService } from 'src/app/services/spinner.service';
import { ACCREDITATO, ICONSURL } from 'src/app/utils/constants';
import { validateAlphanumeric, validateCFPIVA, validateDateBefore, validateIndirizzo } from 'src/app/validators/custom.validator';

@Component({
  selector: 'app-nuovo-responsabile-proprietario',
  templateUrl: './nuovo-responsabile-proprietario.component.html',
  styleUrls: ['./nuovo-responsabile-proprietario.component.scss']
})
export class NuovoResponsabileProprietarioComponent implements OnInit {

  closeGrigio: string = ICONSURL + "close-grigio.png";
  insertForm: FormGroup;
  searchForm: FormGroup;
  isValueSet: boolean = false;
  x: number = 0;
  y: number = 0;
  distanza = 0;
  value = 0;
  result = false;
  search = false;
  persone: Persona[] = [];
  personaSelezionata: Persona;
  isEnte: boolean = false;

  loccsiClickedProp = false;
  currentAddressProp: LoccsiFeature;
  filteredOptionsProp: Observable<LoccsiFeature[]>;
  indirizziProp: LoccsiFeature[] = [];
  tempAddressProp: LoccsiFeature[] = [];

  loccsiClickedPropComuni = false;
  currentAddressPropComuni: LoccsiFeature;
  filteredOptionsPropComuni: Observable<LoccsiFeature[]>;
  comuniProp: LoccsiFeature[] = [];

  titoloErrore = "";
  descrizioneErrore = "";


  constructor(public dialogRef: MatDialogRef<NuovoResponsabileProprietarioComponent>,
    @Inject(MAT_DIALOG_DATA) public data,
    private fb: FormBuilder, private readonly impiantoService: ImpiantoService, readonly spinnerService: SpinnerService) {

    this.insertForm = this.fb.group({
      titolo: [""],
      tipo: [""],
      cf: ["", [Validators.required,
      validateCFPIVA()]
      ],
      indirizzo: [""],
      indirizzoLoccsi: ["", [Validators.required, validateIndirizzo()]],
      dataInizio: ["",
        [Validators.required,
        validateDateBefore()]],
      email: [""],
      cognome: ["", Validators.required],
      nome: ["", Validators.required],
      resEstera: [false],
      capEstero: [""],
      indirizzoEstero: [""],
      cittaEstero: [""],
      statoEstero: [""],
      civicoLoccsi: ["", Validators.required],
      stradario: [""],
      civico: [""],
      comune: [""],
      provincia: ["", validateAlphanumeric()],
    });

    this.searchForm = this.fb.group({
      tipo: [""],
      cf: [""]
    });
  }

  ngOnInit(): void {
    this.personaSelezionata = undefined;
    this.insertForm.reset();
    this.insertForm.markAllAsTouched();

    if (this.data.isResp) {
      this.insertForm.controls["titolo"].setValidators(Validators.required);
    }

    this.insertForm.controls['indirizzoLoccsi'].valueChanges
      .pipe(debounceTime(500), distinctUntilChanged(), filter(data => data ? data.length >= 3 : false)).subscribe(elem => {
        if (typeof elem === "string") {
          this.loccsiClickedProp = false;
          this.currentAddressProp = undefined;
          const elem2 = elem;
          this.insertForm.controls['civicoLoccsi'].enable();
          this.filteredOptionsProp = this.impiantoService.getIndirizzoStradario(elem2)
            .pipe(
              map(name => name ? name : this.indirizziProp.slice()));
        }
      });

    this.insertForm.controls['comune'].valueChanges
      .pipe(debounceTime(500), distinctUntilChanged(), filter(data => data ? data.length >= 3 : false)).subscribe(elem => {
        if (typeof elem === "string") {
          this.loccsiClickedPropComuni = false;
          this.currentAddressPropComuni = undefined;
          const elem2 = elem;
          this.insertForm.controls['civicoLoccsi'].enable();
          this.filteredOptionsPropComuni = this.impiantoService.getProvinciaByComune(elem2)
            .pipe(
              map(name => name ? name : this.comuniProp.slice()));
        }
      });
  }

  displayFn(indirizzo: LoccsiFeature): string {
    return indirizzo && indirizzo.properties && indirizzo.properties.loccsiLabel ? indirizzo.properties.loccsiLabel : '';
  }

  cercaPerCF() {
    this.search = true;
    this.personaSelezionata = undefined;
    this.insertForm.reset();
  }

  setLoccsiElem(feature: LoccsiFeature) {
    this.currentAddressProp = feature;
    if (feature.properties.civicoNum) {
      this.insertForm.controls['civicoLoccsi'].setValue(feature.properties.civicoNum +
        feature.properties.civicoSub);
      this.insertForm.controls['civicoLoccsi'].disable();
    }
    this.impiantoService.getProvinciaByComune(this.currentAddressProp.properties.comune)
    this.loccsiClickedProp = true;
  }

  formValid() {
    Object.keys(this.insertForm.controls).forEach(key => {
      if (this.insertForm.controls[key].invalid)
        console.log(key);
    });
    if (this.insertForm.controls["stradario"].value) {
      return this.insertForm.valid && this.loccsiClickedPropComuni;
    } else if (!this.insertForm.controls["resEstera"].value) {
      return this.insertForm.valid && this.loccsiClickedProp;
    } else
      return this.insertForm.valid;
  }

  inserisciPropResp() {
    let persona: Persona = this.creaNuovoResponsabileProprietario();
    if (this.personaSelezionata)
      persona.idPersona = this.personaSelezionata.idPersona;
    this.impiantoService.setResponsabileProprietario(this.data.codiceImpianto, persona).subscribe((elem) => {
      this.dialogRef.close(elem);
    }, error => {
      this.titoloErrore = "Errore";
      let errore = error.error as Esito;
      this.descrizioneErrore = errore.descrizioneEsito;
      window.scroll({
        top: 0,
        left: 0,
        behavior: 'smooth'
      });
      setTimeout(() => {
        this.titoloErrore = "";
        this.descrizioneErrore = "";
      }, 10000);
    });
  }

  creaNuovoResponsabileProprietario() {
    let persona: Persona = new Persona();
    let estero = this.insertForm.controls["resEstera"].value;
    let stradario = this.insertForm.controls["stradario"].value;
    persona.codiceFiscale = this.insertForm.controls["cf"].value ? this.insertForm.controls["cf"].value.toUpperCase() : undefined;
    if (estero) {
      persona.stradario = 0;
      persona.residenzaEstera = 1;
      persona.indirizzoEstero = this.insertForm.controls["indirizzoEstero"].value ? this.insertForm.controls["indirizzoEstero"].value.toUpperCase() : undefined;
      persona.capEstero = this.insertForm.controls["capEstero"].value ? this.insertForm.controls["capEstero"].value.toUpperCase() : undefined;
      persona.cittaEstero = this.insertForm.controls["cittaEstero"].value ? this.insertForm.controls["cittaEstero"].value.toUpperCase() : undefined;
      persona.statoEstero = this.insertForm.controls["statoEstero"].value ? this.insertForm.controls["statoEstero"].value.toUpperCase() : undefined;
    } else if (stradario) {
      persona.stradario = 1;
      persona.residenzaEstera = 0;
      persona.comune = this.currentAddressPropComuni.properties.loccsiLabel;
      persona.siglaProv = this.currentAddressPropComuni.properties.siglaProvincia ? this.currentAddressPropComuni.properties.siglaProvincia : this.currentAddressPropComuni.properties.pv;
      persona.istatComune = this.currentAddressPropComuni.properties.codiceIstat ? this.currentAddressPropComuni.properties.codiceIstat : undefined;
      persona.provincia = this.insertForm.controls["provincia"].value;
      persona.indirizzoNonTrovato = this.insertForm.controls["indirizzo"].value;
      persona.civico = this.insertForm.controls["civico"].value;
    } else {
      persona.stradario = 0;
      persona.residenzaEstera = 0;
      if (this.loccsiClickedProp) {
        persona.comune = this.currentAddressProp.properties.comune;
        persona.provincia = this.currentAddressProp.properties.descProvincia;
        let propStr = this.currentAddressProp.properties.tipoVia;
        propStr += this.currentAddressProp.properties.preposizione
          && this.currentAddressProp.properties.preposizione != "" ? " " + this.currentAddressProp.properties.preposizione : "";
        propStr += " " + this.currentAddressProp.properties.nomeVia;
        persona.indirizzoSitad = propStr;
        let civico = this.currentAddressProp.properties.civicoNum ? this.currentAddressProp.properties.civicoNum : "";
        civico += this.currentAddressProp.properties.civicoSub ? this.currentAddressProp.properties.civicoSub : "";
        persona.civico = civico ? civico : this.insertForm.controls["civicoLoccsi"].value;
        persona.siglaProv = this.currentAddressProp.properties.siglaProvincia ? this.currentAddressProp.properties.siglaProvincia : this.currentAddressProp.properties.pv;
        persona.istatComune = this.currentAddressProp.properties.codiceIstat ? this.currentAddressProp.properties.codiceIstat : undefined;
      }
    }

    persona.cognomeDenominazione = this.insertForm.controls["cognome"].value ? this.insertForm.controls["cognome"].value.toUpperCase() : undefined;
    persona.nome = this.insertForm.controls["nome"].value ? this.insertForm.controls["nome"].value.toUpperCase() : undefined;
    persona.dataInizioResp = this.insertForm.controls["dataInizio"].value;
    persona.titolo = this.insertForm.controls["titolo"].value;
    persona.email = this.insertForm.controls["email"].value ? this.insertForm.controls["email"].value.toUpperCase() : undefined;
    if (this.insertForm.controls["tipo"].value)
      persona.tipo = 1;
    else
      persona.tipo = 0;
    if (this.data.isResp) {
      persona.titolo = this.insertForm.controls["titolo"].value;
      persona.flgResp = true;
    } else {
      if (persona.tipo == 1) {
        persona.titolo = "16";
      } else {
        persona.titolo = "15";
      }
      persona.flgResp = false;
    }
    return persona;
  }

  closeDialog() {
    this.dialogRef.close();
  }

  backToInsert() {
    this.result = false;
    this.search = false;
  }

  backToSearch() {
    this.result = false;
    this.search = true;
  }

  searchCF() {
    this.persone = [];
    let cf = this.searchForm.controls["cf"].value ? this.searchForm.controls["cf"].value.toUpperCase() : this.searchForm.controls["cf"].value;
    this.impiantoService.cercaResponsabileProprietario(this.searchForm.controls["tipo"].value, cf).subscribe((elem: Persona[]) => {
      this.persone = elem;
      this.result = true;
    }, error => {
      if (error.status == 404) {
        this.result = true;
        let errore = error.error as Esito;
        this.titoloErrore = "Nessun Risultato";
        this.descrizioneErrore = errore.descrizioneEsito;
        setTimeout(() => {
          this.titoloErrore = "";
          this.descrizioneErrore = "";
        }, 10000);
      }
    });
  }

  usaDati(persona: Persona) {
    this.backToInsert();
    this.mapToPersonaSelezionata(persona);
    this.insertForm.controls["tipo"].setValue(persona.tipo);
    this.insertForm.controls["tipo"].disable();
    this.insertForm.controls["cf"].setValue(persona.codiceFiscale);
    this.insertForm.controls["cf"].disable();
    this.insertForm.controls["stradario"].setValue(persona.stradario);
    this.insertForm.controls["resEstera"].setValue(persona.residenzaEstera);
    if (persona.residenzaEstera) {
      this.insertForm.controls["capEstero"].setValue(persona.capEstero);
      this.insertForm.controls["indirizzoEstero"].setValue(persona.indirizzoEstero);
      this.insertForm.controls["cittaEstero"].setValue(persona.cittaEstero);
      this.insertForm.controls["statoEstero"].setValue(persona.statoEstero);
      this.insertForm.controls["indirizzoLoccsi"].clearValidators();
      this.insertForm.controls["civicoLoccsi"].clearValidators();
      this.insertForm.controls["indirizzoEstero"].setValidators([Validators.required]);
      this.insertForm.controls["cittaEstero"].setValidators([Validators.required]);
      this.insertForm.controls["capEstero"].setValidators([Validators.required]);
      this.insertForm.controls["statoEstero"].setValidators([Validators.required]);
      this.insertForm.controls["indirizzo"].clearValidators();
      this.insertForm.controls["civico"].clearValidators();
      this.insertForm.controls["comune"].clearValidators();
      this.insertForm.controls["provincia"].clearValidators();
    } 
    else 
    {
      if (persona.stradario) {
        this.insertForm.controls["indirizzo"].setValue(persona.indirizzoNonTrovato);
        this.insertForm.controls["civico"].setValue(persona.civico);
        this.impiantoService.getProvinciaByComune(persona.comune).subscribe((elem: LoccsiFeature[]) => {   
          this.setProvinciaComuneProp(elem[0]); 
          this.insertForm.controls['comune'].setValue(this.currentAddressPropComuni);
        });
        this.insertForm.controls["provincia"].setValue(persona.provincia);
        this.insertForm.controls["indirizzoLoccsi"].clearValidators();
        this.insertForm.controls["civicoLoccsi"].clearValidators();
        this.insertForm.controls["indirizzoEstero"].clearValidators();
        this.insertForm.controls["cittaEstero"].clearValidators();
        this.insertForm.controls["capEstero"].clearValidators();
        this.insertForm.controls["statoEstero"].clearValidators();
        this.insertForm.controls["indirizzo"].setValidators([Validators.required]);
        this.insertForm.controls["civico"].setValidators([Validators.required]);
        this.insertForm.controls["comune"].setValidators([Validators.required, validateIndirizzo()]);
        this.insertForm.controls["provincia"].setValidators([Validators.required]);
      } 
      else 
      {
          this.impiantoService.getIndirizzoStradario(persona.indirizzoSitad + "," + persona.comune).subscribe((elem: LoccsiFeature[]) => {  
          elem.forEach(element => {
            if(element.properties.comune === persona.comune) 
            {  
              this.tempAddressProp.push(element); 
            } 
          });
          this.setLoccsiElem(this.tempAddressProp[0]);
          this.insertForm.controls['indirizzoLoccsi'].setValue(this.currentAddressProp);
          if (!this.currentAddressProp.properties.civicoNum) {
            this.insertForm.controls["civicoLoccsi"].setValue(persona.civico);
          }
        });
        this.insertForm.controls["indirizzoLoccsi"].setValue(persona.indirizzoSitad);
        this.insertForm.controls["civicoLoccsi"].setValue(persona.civico);
        this.insertForm.controls["indirizzoLoccsi"].setValidators([Validators.required, validateIndirizzo()]);
        this.insertForm.controls["civicoLoccsi"].setValidators([Validators.required]);
        this.insertForm.controls["indirizzoEstero"].clearValidators();
        this.insertForm.controls["cittaEstero"].clearValidators();
        this.insertForm.controls["capEstero"].clearValidators();
        this.insertForm.controls["statoEstero"].clearValidators();
        this.insertForm.controls["indirizzo"].clearValidators();
        this.insertForm.controls["civico"].clearValidators();
        this.insertForm.controls["comune"].clearValidators();
        this.insertForm.controls["provincia"].clearValidators();
      }
    }
    this.insertForm.controls["dataInizio"].setValue(persona.dataInizioResp);
    this.insertForm.controls["email"].setValue(persona.email);
    this.insertForm.controls["cognome"].setValue(persona.cognomeDenominazione);
    this.insertForm.controls["nome"].setValue(persona.nome);
    if (persona.accreditato === ACCREDITATO) {
      this.insertForm.controls["cognome"].disable();
      this.insertForm.controls["nome"].disable();
    } else {
      this.insertForm.controls["cognome"].enable();
      this.insertForm.controls["nome"].enable();
    }

    this.insertForm.updateValueAndValidity();
  }

  mapToPersonaSelezionata(persona: Persona) {
    this.personaSelezionata = new Persona();
    this.personaSelezionata.capEstero = persona.capEstero;
    this.personaSelezionata.cittaEstero = persona.cittaEstero;
    this.personaSelezionata.civico = persona.civico;
    this.personaSelezionata.codiceFiscale = persona.codiceFiscale;
    this.personaSelezionata.cognomeDenominazione = persona.cognomeDenominazione;
    this.personaSelezionata.comune = persona.comune;
    this.personaSelezionata.dataInizioResp = persona.dataInizioResp;
    this.personaSelezionata.email = persona.email;
    this.personaSelezionata.idPersona = persona.idPersona;
    this.personaSelezionata.indirizzoEstero = persona.indirizzoEstero;
    this.personaSelezionata.indirizzoNonTrovato = persona.indirizzoNonTrovato;
    this.personaSelezionata.indirizzoSitad = persona.indirizzoSitad;
    this.personaSelezionata.nome = persona.nome;
    this.personaSelezionata.provincia = persona.provincia;
    this.personaSelezionata.residenzaEstera = persona.residenzaEstera;
    this.personaSelezionata.statoEstero = persona.statoEstero;
    this.personaSelezionata.stradario = persona.stradario;
    this.personaSelezionata.tipo = persona.tipo;
    this.personaSelezionata.titolo = persona.titolo;
    this.personaSelezionata.istatComune = persona.istatComune;
    this.personaSelezionata.siglaProv = persona.siglaProv;
    this.personaSelezionata.accreditato = persona.accreditato;
  }


  setProvinciaComuneProp(feature: LoccsiFeature) {
    this.currentAddressPropComuni = feature;
    this.insertForm.controls['provincia'].setValue(feature.properties.descProvincia ? feature.properties.descProvincia : feature.properties.pv);
    this.loccsiClickedPropComuni = true;
  }

  toggleResEsteraProp($event) {
    console.log(this.insertForm.controls["resEstera"].value);
    if (this.insertForm.controls["resEstera"].value) {
      this.insertForm.controls["indirizzoLoccsi"].clearValidators();
      this.insertForm.controls["indirizzoLoccsi"].updateValueAndValidity();
      this.insertForm.controls["civicoLoccsi"].clearValidators();
      this.insertForm.controls["civicoLoccsi"].updateValueAndValidity();

      this.insertForm.controls["indirizzoEstero"].setValidators([Validators.required]);
      this.insertForm.controls["cittaEstero"].setValidators([Validators.required]);
      this.insertForm.controls["capEstero"].setValidators([Validators.required]);
      this.insertForm.controls["statoEstero"].setValidators([Validators.required]);
      this.insertForm.controls["indirizzoEstero"].updateValueAndValidity();
      this.insertForm.controls["cittaEstero"].updateValueAndValidity();
      this.insertForm.controls["capEstero"].updateValueAndValidity();
      this.insertForm.controls["statoEstero"].updateValueAndValidity();

      this.insertForm.controls["indirizzo"].clearValidators();
      this.insertForm.controls["civico"].clearValidators();
      this.insertForm.controls["indirizzo"].updateValueAndValidity();
      this.insertForm.controls["civico"].updateValueAndValidity();
      this.insertForm.controls["comune"].clearValidators();
      this.insertForm.controls["comune"].updateValueAndValidity();
      this.insertForm.controls["provincia"].clearValidators();
      this.insertForm.controls["provincia"].updateValueAndValidity();

    } else {
      this.insertForm.controls["indirizzoEstero"].clearValidators();
      this.insertForm.controls["cittaEstero"].clearValidators();
      this.insertForm.controls["capEstero"].clearValidators();
      this.insertForm.controls["statoEstero"].clearValidators();
      this.insertForm.controls["indirizzoEstero"].updateValueAndValidity();
      this.insertForm.controls["cittaEstero"].updateValueAndValidity();
      this.insertForm.controls["capEstero"].updateValueAndValidity();
      this.insertForm.controls["statoEstero"].updateValueAndValidity();

      if (!this.insertForm.controls["stradario"].value) {
        this.insertForm.controls["indirizzoLoccsi"].setValidators([Validators.required, validateIndirizzo()]);
        this.insertForm.controls["indirizzoLoccsi"].updateValueAndValidity();
        this.insertForm.controls["civicoLoccsi"].setValidators([Validators.required]);
        this.insertForm.controls["civicoLoccsi"].updateValueAndValidity();
      }
    }
  }

  toggleStradarioProp($event) {
    if (this.insertForm.controls["stradario"].value) {
      this.insertForm.controls["indirizzoLoccsi"].clearValidators();
      this.insertForm.controls["indirizzoLoccsi"].updateValueAndValidity();
      this.insertForm.controls["civicoLoccsi"].clearValidators();
      this.insertForm.controls["civicoLoccsi"].updateValueAndValidity();

      this.insertForm.controls["indirizzoEstero"].clearValidators();
      this.insertForm.controls["cittaEstero"].clearValidators();
      this.insertForm.controls["capEstero"].clearValidators();
      this.insertForm.controls["statoEstero"].clearValidators();
      this.insertForm.controls["indirizzoEstero"].updateValueAndValidity();
      this.insertForm.controls["cittaEstero"].updateValueAndValidity();
      this.insertForm.controls["capEstero"].updateValueAndValidity();
      this.insertForm.controls["statoEstero"].updateValueAndValidity();

      this.insertForm.controls["indirizzo"].setValidators([Validators.required]);
      this.insertForm.controls["civico"].setValidators([Validators.required]);
      this.insertForm.controls["indirizzo"].updateValueAndValidity();
      this.insertForm.controls["civico"].updateValueAndValidity();
      this.insertForm.controls["comune"].setValidators([Validators.required, validateIndirizzo()]);
      this.insertForm.controls["comune"].updateValueAndValidity();
      this.insertForm.controls["provincia"].setValidators([Validators.required]);
      this.insertForm.controls["provincia"].updateValueAndValidity();
    } else {

      this.insertForm.controls["indirizzo"].clearValidators();
      this.insertForm.controls["civico"].clearValidators();
      this.insertForm.controls["indirizzo"].updateValueAndValidity();
      this.insertForm.controls["civico"].updateValueAndValidity();
      this.insertForm.controls["comune"].clearValidators();
      this.insertForm.controls["comune"].updateValueAndValidity();
      this.insertForm.controls["provincia"].clearValidators();
      this.insertForm.controls["provincia"].updateValueAndValidity();

      if (!this.insertForm.controls["resEstera"].value) {
        this.insertForm.controls["indirizzoLoccsi"].setValidators([Validators.required, validateIndirizzo()]);
        this.insertForm.controls["indirizzoLoccsi"].updateValueAndValidity();
        this.insertForm.controls["civicoLoccsi"].setValidators([Validators.required]);
        this.insertForm.controls["civicoLoccsi"].updateValueAndValidity();
      }

    }
  }

  checkEnteImpresa(event: MatCheckboxChange) {
    if (event.checked) {
      this.isEnte = true;
      this.insertForm.controls["nome"].clearValidators();
    } else {
      this.isEnte = false;
      this.insertForm.controls["nome"].setValidators([Validators.required]);
    }
    this.insertForm.controls["nome"].updateValueAndValidity();
  }
}

