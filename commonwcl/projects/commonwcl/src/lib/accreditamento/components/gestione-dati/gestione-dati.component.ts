import { NumberInput } from '@angular/cdk/coercion';
import { Component, EventEmitter, HostListener, Input, OnInit, Output } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatDialog } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { debounceTime, distinctUntilChanged, filter, map } from 'rxjs/operators';
import { ConfirmDialog } from '../../../common/components/confirm-dialog/confirm-dialog.component';
import { Accreditamento } from '../../../models/accreditamento';
import { ComuneEsteso } from '../../../models/common/comune-esteso.model';
import { LoccsiFeature } from '../../../models/common/loccsi-feature';
import { DatiDelega } from '../../../models/dati-delega';
import { DatiImpresa } from '../../../models/dati-impresa';
import { DatiIncarico } from '../../../models/dati-incarico';
import { Persona } from '../../../models/persona';
import { AccreditamentoService } from '../../../services/accreditamento.service';
import { ImpiantoService } from '../../../services/impianto.service';
import { SharedService } from '../../../services/shared.service';
import { SvistaService } from '../../../services/svista.service';
import { RUOLI } from '../../../utils/constants';

@Component({
  selector: 'commonwcl-gestione-dati-accreditamento',
  templateUrl: './gestione-dati.component.html',
  styleUrls: ['./gestione-dati.component.scss']
})
export class GestioneDatiComponent implements OnInit {

  //@Input("apiUrl") apiUrl: string = '';
  @Input() apiUrl: string;
  @Input("codiceFiscalePF") codiceFiscalePF: string;
  @Output() onMessage = new EventEmitter<any>();

  currentAddressProp: LoccsiFeature;
  filteredOptionsProp: Observable<LoccsiFeature[]>;
  indirizziProp: LoccsiFeature[] = [];
  tempAddressProp: LoccsiFeature[] = [];
  loccsiClickedProp = false;

  accreditamento: Accreditamento;
  loccsiClickedPropComuni = false;
  currentAddressPropComuni: LoccsiFeature;
  //filteredOptionsPropComuni: Observable<LoccsiFeature[]>;
  comuniProp: LoccsiFeature[] = [];

  currentAddressPropComuniEsteso: ComuneEsteso;
  filteredOptionsPropComuni: Observable<ComuneEsteso[]>;
  comuniEstesoProp: ComuneEsteso[] = [];


  personalDataForm: FormGroup;
  colBreakpoint1: NumberInput;
  colBreakpoint2: NumberInput;
  colBreakpoint3: NumberInput;
  colBreakpoint4: NumberInput;
  colBreakpoint5: NumberInput;
  isModifyEnabled: boolean = false;

  imprese: any[] = [{
    title: "Impresa 1",
    showAddButton: true,
    showDeleteButton: true,
    showModifyButton: true,
    uidIndex: 1,
    denominazione: "impresa 1",
    codiceREA: "123456",
    codiceFiscale: "1234567890123456",
  }];

  constructor(
    private router: Router,
    private accreditamentoService: AccreditamentoService,
    private impiantoService: ImpiantoService,
    private svistaService: SvistaService,
    private sharedService: SharedService,
    private dialog: MatDialog,
    private fb: FormBuilder
  ) {
    this.createFormGroup();
  }

  createFormGroup() {
    this.personalDataForm = this.fb.group({
      // denominazione: ["", [Validators.required]],
      codiceFiscale: ["", [Validators.required, Validators.minLength(16), Validators.maxLength(16)]],
      residenzaEstera: [0],
      indirizzoSitad: [""],
      indirizzoNonTrovato: [""],
      civico: [""],
      stradario: [0],
      comune: [""],
      provincia: [""],
      capEstero: [""],
      indirizzoEstero: [""],
      cittaEstero: [""],
      statoEstero: [""],
      email: ["", [Validators.required, Validators.email]],
    });

  }

  ngOnInit(): void {
    this.prepareView();
    this.personalDataForm.disable();
    this.isModifyEnabled = false;
    this.impiantoService.init(this.apiUrl);
    this.svistaService.init(this.apiUrl);
    this.accreditamentoService.init(this.apiUrl);

    let utenteLoggato = this.sharedService.getUtenteLoggato();
    this.accreditamentoService.getDatiAccreditamento(utenteLoggato.pfLoggato.codiceFiscalePF).subscribe((data) => {
      this.personalDataForm.reset();
      this.accreditamento = data;
      this.personalDataForm.patchValue(data.persona);
      // this.personalDataForm.controls['denominazione'].setValue(this.accreditamento.persona.cognomeDenominazione + " " + this.accreditamento.persona.nome);
      this.init();
    }, (error) => {
      this.init();
    });
    window.scrollTo(0, 0);
  }

  init() {

    this.personalDataForm.get('residenzaEstera').valueChanges.subscribe((value) => {
      if (value !== null && (value === 1 || value === true)) {
        // this.personalDataForm.controls['indirizzoSitad'].setValue('');
        // this.personalDataForm.controls['indirizzoNonTrovato'].setValue('');
        // this.personalDataForm.controls['civico'].setValue('');
        // this.personalDataForm.controls['comune'].setValue('');
        // this.personalDataForm.controls['provincia'].setValue('');
        this.clearValidators(this.personalDataForm.controls['indirizzoSitad']);
        this.clearValidators(this.personalDataForm.controls['civico']);
        this.clearValidators(this.personalDataForm.controls['comune']);
        this.clearValidators(this.personalDataForm.controls['provincia']);
        this.personalDataForm.controls['indirizzoEstero'].setValidators([Validators.required]);
        this.personalDataForm.controls['cittaEstero'].setValidators([Validators.required]);
        this.personalDataForm.controls['statoEstero'].setValidators([Validators.required]);
        this.personalDataForm.controls['capEstero'].setValidators([Validators.required]);
        this.personalDataForm.controls['indirizzoSitad'].updateValueAndValidity();
      } else if (value !== null && (value === 0 || value === false)) {
        this.clearValidators(this.personalDataForm.controls['indirizzoEstero']);
        this.clearValidators(this.personalDataForm.controls['cittaEstero']);
        this.clearValidators(this.personalDataForm.controls['statoEstero']);
        this.clearValidators(this.personalDataForm.controls['capEstero']);
        this.personalDataForm.controls['indirizzoSitad'].setValidators([Validators.required]);
        this.personalDataForm.controls['civico'].setValidators([Validators.required]);
      }
      this.personalDataForm.updateValueAndValidity();
      // this.updateFormValidity(this.personalDataForm);
    });
    this.personalDataForm.get('stradario').valueChanges.subscribe((value) => {
      if (value !== null && (value === 1 || value === true)) {
        this.personalDataForm.controls['civico'].setValidators([Validators.required]);
        this.personalDataForm.controls['comune'].setValidators([Validators.required]);
        this.personalDataForm.controls['provincia'].setValidators([Validators.required]);
        this.personalDataForm.controls['indirizzoNonTrovato'].setValidators([Validators.required]);
        this.clearValidators(this.personalDataForm.controls['indirizzoEstero']);
        this.clearValidators(this.personalDataForm.controls['cittaEstero']);
        this.clearValidators(this.personalDataForm.controls['statoEstero']);
        this.clearValidators(this.personalDataForm.controls['capEstero']);
        this.clearValidators(this.personalDataForm.controls['indirizzoSitad']);
      } else if (value !== null && (value === 0 || value === false) && !this.personalDataForm.get('residenzaEstera').value) {
        this.clearValidators(this.personalDataForm.controls['indirizzoNonTrovato'])
        this.personalDataForm.controls['indirizzoSitad'].setValidators([Validators.required]);
        this.personalDataForm.controls['civico'].setValidators([Validators.required]);
        this.personalDataForm.controls['comune'].setValidators([Validators.required]);
        this.personalDataForm.controls['provincia'].setValidators([Validators.required]);
        this.personalDataForm.controls['indirizzoNonTrovato'].setValue('');
      }
      this.personalDataForm.updateValueAndValidity();
    });


    this.personalDataForm.controls['indirizzoSitad'].valueChanges
      .pipe(debounceTime(500), distinctUntilChanged(), filter(data => data ? data.length >= 3 : false)).subscribe(elem => {
        if (typeof elem === "string" && elem !== this.accreditamento.persona.indirizzoSitad) {
          this.loccsiClickedProp = false;
          // this.currentAddressProp = undefined;
          const elem2 = elem;
          this.personalDataForm.controls['civico'].enable();
          this.filteredOptionsProp = this.impiantoService.getIndirizzoStradario(elem2)
            .pipe(
              map(name => name ? name : this.indirizziProp.slice()));
        }
      });

    this.personalDataForm.controls['comune'].valueChanges
      .pipe(debounceTime(500), distinctUntilChanged(), filter(data => data ? data.length >= 2 : false)).subscribe(elem => {
        if (typeof elem === "string") {
          this.loccsiClickedPropComuni = false;
          this.currentAddressPropComuni = undefined;
          const elem2 = elem;
          this.filteredOptionsPropComuni = this.svistaService.loadDataFromLocalStorage(elem2)
            .pipe(
              map(name => name ? name : this.comuniEstesoProp.slice()));
        }
      });
  }

  residenzaEsteraClick() {
    if (this.personalDataForm.controls['residenzaEstera'].value) {
      this.personalDataForm.controls['indirizzoSitad'].setValue('');
      this.personalDataForm.controls['indirizzoNonTrovato'].setValue('');
      this.personalDataForm.controls['civico'].setValue('');
      this.personalDataForm.controls['comune'].setValue('');
      this.personalDataForm.controls['provincia'].setValue('');
    } else {
      this.personalDataForm.controls['indirizzoEstero'].setValue('');
      this.personalDataForm.controls['cittaEstero'].setValue('');
      this.personalDataForm.controls['statoEstero'].setValue('');
      this.personalDataForm.controls['capEstero'].setValue('');
    }
  }

  stradarioClick() {
    if (this.personalDataForm.controls['stradario'].value) {
      this.personalDataForm.controls['indirizzoEstero'].setValue('');
      this.personalDataForm.controls['civico'].setValue('');
      this.personalDataForm.controls['cittaEstero'].setValue('');
      this.personalDataForm.controls['statoEstero'].setValue('');
      this.personalDataForm.controls['capEstero'].setValue('');
      this.personalDataForm.controls['indirizzoSitad'].setValue('');
    } else {
      this.personalDataForm.controls['indirizzoNonTrovato'].setValue('');
      this.personalDataForm.controls['civico'].setValue('');
      this.personalDataForm.controls['comune'].setValue('');
      this.personalDataForm.controls['provincia'].setValue('');
    }
  }

  prepareView() {
    this.colBreakpoint1 = (window.innerWidth < 768) ? 12 : 6;
    this.colBreakpoint2 = (window.innerWidth < 768) ? 12 : 3;
    this.colBreakpoint3 = (window.innerWidth < 768) ? 0 : 9;
    this.colBreakpoint4 = (window.innerWidth < 768) ? 0 : 6;
    this.colBreakpoint5 = (window.innerWidth < 768) ? 2 : 1;
  }


  @HostListener('window:resize', ['$event'])
  onResize(event?) {
    this.prepareView();
  }

  salvaDatiPersonali() {
    // this.personalDataForm.enable();
    console.log(this.personalDataForm.getRawValue());
    let persona: Persona = this.personalDataForm.getRawValue();
    persona.residenzaEstera = this.personalDataForm.controls['residenzaEstera'].value ? 1 : 0;
    persona.stradario = this.personalDataForm.controls['stradario'].value ? 1 : 0;
    //In caso non è residenza estera resetto tutti i campi legati ad essa
    if (!persona.residenzaEstera) {
      persona.indirizzoEstero = "";
      persona.cittaEstero = "";
      persona.capEstero = "";
      persona.statoEstero = "";
    } else {
      persona.indirizzoSitad = "";
      persona.civico = "";
      persona.comune = "";
      persona.provincia = "";
      persona.indirizzoNonTrovato = "";
    }
    if (!persona.stradario && !persona.residenzaEstera && this.currentAddressProp) {
      persona.indirizzoSitad = this.currentAddressProp.properties.tipoVia + " " + this.currentAddressProp.properties.nomeVia;
      persona.istatComune = this.currentAddressProp.properties.codiceIstat;
      persona.siglaProv = this.currentAddressProp.properties.siglaProvincia;
    } else if (this.currentAddressPropComuniEsteso) {
      persona.istatComune = this.currentAddressPropComuniEsteso.codiceIstat;
      persona.siglaProv = this.currentAddressPropComuniEsteso.siglaProvincia;
    }else{
      persona.istatComune = "";
      persona.siglaProv = "";
    }
    let obj = { ...this.accreditamento.persona, ...persona };
    this.accreditamentoService.setDatiPersonaliUtente(persona.codiceFiscale, obj).subscribe((data) => {
      this.onMessage.emit({
        titolo: "Dati salvati correttamente",
        descrizione: "Le modifiche apportate sono state salvate correttamente.", type: 4
      });
      this.ngOnInit();
    }, (error) => {
      console.log(error);
    });
  }

  aggiungiImpresa() {

  }

  deleteImpresa(a, i) {

  }

  /**
   *
   * @param impresa
   * @returns
   */
  isModificaImpresaVisible(impresa: DatiImpresa) {
    let cfPersona = this.accreditamento.persona.codiceFiscale;
    let idImpresaGiuridica = impresa.id_persona_giuridica;
    for (let delega of this.accreditamento.datiDelegaList) {
      if (delega.id_persona_giuridic == idImpresaGiuridica && delega.codice_fiscale == cfPersona) {
        if (delega.tipo_legame == "Accreditato") {
          return false;
        }
      }
    }
    return true;
  }

  deleteIncarico(incarico: DatiIncarico) {
    this.dialog.open(ConfirmDialog, {
      data: {
        titolo: 'Conferma eliminazione',
        premessa: "Attenzione: ",
        descrizione: 'Sei sicuro di voler eliminare questo incarico?'
      }
    }).afterClosed().subscribe((confirm) => {
      this.accreditamentoService.deleteIncaricoSoggettoDelegato(this.codiceFiscalePF, incarico.id_persona_giuridica_impresa, incarico.id_persona_giuridica_cat).pipe().subscribe((data) => {
        this.onMessage.emit({
          titolo: "Incarico eliminato correttamente",
          descrizione: "L'incarico è stato eliminato correttamente.", type: 4
        });
        this.ngOnInit();
      }, (error) => {
        this.onMessage.emit({
          titolo: "Impossibile eliminare l'incarico",
          descrizione: "Impossibile eliminare l'incarico, contattare il supporto per maggiori dettagli.", type: 4
        });
      });
    });
  }

  dettaglioImpresa(index: any, onlyView: boolean = true) {
    let impresa: DatiImpresa = null;
    if (index === null) {
      impresa = { denominazione: "Prova", numero_rea: 3434, codice_fiscale: "PPASLJDKFJLKSJDF" };
    } else {
      impresa = this.accreditamento.datiImpresaList[index];
      this.accreditamentoService.getDatiImpresa(impresa.codice_fiscale, impresa.sigla_rea, impresa.numero_rea).subscribe((data) => {
        this.router.navigate(['accreditamento/dettaglio-impresa'], { state: { impresa: data[0], onlyView: onlyView, codiceFiscalePF: this.codiceFiscalePF } });
      });
    }
  }

  nuovaImpresa() {
    this.router.navigate(['accreditamento/nuova-impresa'], { state: { codiceFiscalePF: this.codiceFiscalePF } });
  }

  nuovoIncarico(index: number) {
    let impresa = this.accreditamento.datiImpresaList[index];
    this.router.navigate(['accreditamento/nuovo-incarico'], { state: { impresa: impresa, codiceFiscalePF: this.codiceFiscalePF } });
  }

  nuovoDelegato(index: number) {
    let impresa = this.accreditamento.datiImpresaList[index];
    this.router.navigate(['accreditamento/nuova-delega'], { state: { impresa: impresa, codiceFiscalePF: this.codiceFiscalePF } });
  }


  deleteDelega(impresa: DatiImpresa, delega: DatiDelega) {
    let idPersona = null;
    if (delega.id_persona_fisica) {
      idPersona = delega.id_persona_fisica;
    } else {
      idPersona = delega.id_persona_giuridic;
    }
    let utenteLoggato = this.sharedService.getUtenteLoggato();
    this.accreditamentoService.deleteDelega(idPersona, utenteLoggato).subscribe((data) => {
      this.dialog.open(ConfirmDialog, {
        data: {
          titolo: 'Conferma eliminazione',
          premessa: "Attenzione: ",
          descrizione: 'Sei sicuro di voler eliminare questa delega?'
        }
      }).afterClosed().subscribe((confirm) => {
        if (confirm) {
          this.accreditamentoService.deleteDelegaConfirm(this.codiceFiscalePF, impresa.id_persona_giuridica, delega.id_persona_fisica)
            .subscribe((deleteData) => {
              this.onMessage.emit({
                titolo: "Delega eliminata correttamente",
                descrizione: "La delega è stata eliminata correttamente.", type: 4
              });
              this.ngOnInit();
            });
        }
      });
    });
  }


  resetIndirizzo() {
    this.personalDataForm.controls['indirizzo'].setValue('');
    this.personalDataForm.controls['civico'].setValue('');
    this.personalDataForm.controls['comune'].setValue('');
    this.personalDataForm.controls['provincia'].setValue('');
  }


  changeEditMode() {
    this.isModifyEnabled = !this.isModifyEnabled;
    if (this.isModifyEnabled) {
      this.personalDataForm.enable();
      this.personalDataForm.controls['codiceFiscale'].disable();
      // this.personalDataForm.controls['cognomeDenominazione'].disable();
      this.personalDataForm.controls['provincia'].disable();
    } else {
      this.personalDataForm.disable();
    }
  }

  annulla() {
    this.isModifyEnabled = !this.isModifyEnabled;
    this.personalDataForm.disable();
    this.createFormGroup();
    this.ngOnInit();
  }

  setLoccsiElem(feature: LoccsiFeature) {
    this.currentAddressProp = feature;
    if (feature.properties.civicoNum) {
      this.personalDataForm.controls['civico'].setValue(feature.properties.civicoNum +
        feature.properties.civicoSub);
      this.personalDataForm.controls['civico'].disable();
    }
    if (feature.properties.tipoVia) {
      let indirizzo = feature.properties.tipoVia + " " + feature.properties.nomeVia;
      this.personalDataForm.controls['indirizzoSitad'].setValue(indirizzo);
    }
    this.personalDataForm.controls['comune'].setValue(feature.properties.comune);
    this.personalDataForm.controls['provincia'].setValue(feature.properties.descProvincia);
    this.personalDataForm.controls['istat_comune'].setValue(feature.properties.codiceIstat);
    this.personalDataForm.controls['sigla_prov'].setValue(feature.properties.siglaProvincia);
    this.loccsiClickedProp = true;

  }

  setProvinciaComuneEstesoProp(feature: ComuneEsteso) {
    this.currentAddressPropComuniEsteso = feature;
    this.personalDataForm.controls['comune'].setValue(feature.comune ? feature.comune : "");
    this.personalDataForm.controls['provincia'].setValue(feature.provincia ? feature.provincia : "");
    this.loccsiClickedPropComuni = true;
  }

  displayFn(indirizzo: LoccsiFeature): string {
    if (typeof indirizzo === 'string') {
      if (indirizzo) {
        return indirizzo + ", " + this.personalDataForm.controls['comune'].value;
      } else {
        return "";
      }
    }
    return indirizzo && indirizzo.properties && indirizzo.properties.loccsiLabel ? (indirizzo.properties.loccsiLabel) : '';
  }

  displayFnComune(indirizzo: ComuneEsteso | string): string {
    if (typeof indirizzo === 'string') {
      return indirizzo;
    }
    return indirizzo && indirizzo.comune ? indirizzo.comune : '';
  }


  sendTestMail() {
    let email_address = this.personalDataForm.controls['email'].value;
    this.accreditamentoService.sendTestMail(email_address).subscribe((data) => {
      this.onMessage.emit({
        titolo: "Email inviata correttamente",
        descrizione: "L'email è stata inviata correttamente.",
        type: 4,
        reload: false
      });
    });
  }


  filterDelega(val: number) {
    if (this.accreditamento?.datiDelegaList) {
      return this.accreditamento?.datiDelegaList?.filter((item) => item.id_persona_giuridic === val);
    }
    return [];
  }

  filterIncarico(val: number) {
    if (this.accreditamento?.datiIncaricoList) {
      return this.accreditamento?.datiIncaricoList?.filter((item) => item.id_persona_giuridica_impresa === val);
    }
    return [];
  }


  clearValidators(control) {
    control.setValue('');
    control.clearValidators();
    control.updateValueAndValidity();
  }

  updateFormValidity(form: FormGroup) {
    Object.keys(form.controls).forEach(key => {
      form.get(key).updateValueAndValidity();
    });

  }


  visible(key: string) {
    return (this.personalDataForm.controls[key].value == true || this.personalDataForm.controls[key].value == 1);
  }

  isConsultatoreValidatore() {
    let utenteLoggato = this.sharedService.getUtenteLoggato();
    if (utenteLoggato.ruoloLoggato.ruolo == RUOLI.RUOLO_CONSULTATORE || utenteLoggato.ruoloLoggato.ruolo == RUOLI.RUOLO_VALIDATORE) {
      return true;
    }
    return false;
  }
}
