import { NumberInput } from '@angular/cdk/coercion';
import { Location } from '@angular/common';
import { Component, HostListener, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatDialog } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { debounceTime, distinctUntilChanged, filter, map } from 'rxjs/operators';
import { DeleteDialogComponent } from 'src/app/common/components/delete-dialog/delete-dialog.component';
import { CodiceDescrizione } from 'src/app/models/codice-descrizione';
import { DatiImpianto } from 'src/app/models/dati-impianto';
import { Esito } from 'src/app/models/esito';
import { LoccsiFeature } from 'src/app/models/loccsi-feature';
import { UtenteLoggato } from 'src/app/models/utente-loggato';
import { AuthenticationService } from 'src/app/services/authentication.service';
import { BackService } from 'src/app/services/back.service';
import { ImpiantoService } from 'src/app/services/impianto.service';
import { LocalStorageServiceService } from 'src/app/services/local-storage-service.service';
import { MessageService } from 'src/app/services/message.service';
import { TitleService } from 'src/app/services/title.service';
import { RUOLI, STATO_IMPIANTO } from 'src/app/utils/constants';
import { validateIndirizzo, validateNumbers, validatePDR, validatePOD } from 'src/app/validators/custom.validator';

@Component({
  selector: 'app-nuovo-impianto',
  templateUrl: './nuovo-impianto.component.html',
  styleUrls: ['./nuovo-impianto.component.scss']
})
export class NuovoImpiantoComponent implements OnInit {
  stati: CodiceDescrizione[];
  insertForm: FormGroup;
  utente: UtenteLoggato;
  filteredOptions: Observable<LoccsiFeature[]>;
  indirizzi: LoccsiFeature[] = [];
  loccsiClicked: boolean = false;
  currentAddress: LoccsiFeature;

  filteredOptionsComuni: Observable<LoccsiFeature[]>;
  comuni: LoccsiFeature[] = [];
  loccsiClickedComuni: boolean = false;
  currentAddressComuni: LoccsiFeature;
  isResp = false;
  isPg = false;

  colBreakpoint1: NumberInput;
  colBreakpoint2: NumberInput;
  colBreakpoint3: NumberInput;

  constructor(private readonly router: Router,
    private location: Location,
    private readonly impiantoService: ImpiantoService, private fb: FormBuilder,
    private readonly authService: AuthenticationService,
    private localStorageService: LocalStorageServiceService,
    private readonly titleService: TitleService,
    private readonly backService: BackService,
    private readonly messageService: MessageService,
    private dialog: MatDialog) {
    this.utente = authService.getCurrentUserFromSession();
    this.stati = [];
    this.insertForm = this.fb.group({
      codiceImpianto: ["", validateNumbers()],
      statoImpianto: [""],
      responsabilita: [""],
      dataVar: ["", Validators.required],
      motivazione: ["Primo caricamento impianto", Validators.required],
      tipo: ["", Validators.required],
      locTecnico: [""],
      contabilizzazione: [""],
      flgMedioImpiantoCivile: [""],
      indirizzoLoccsi: ["", [
        Validators.required, validateIndirizzo()
      ]],
      civicoLoccsi: ["", Validators.required],
      stradario: [""],
      indirizzo: [""],
      civico: [""],
      comune: [""],
      provincia: [""],
      pod: ["", validatePOD()],
      pdr: ["", validatePDR()],
      noPdr: [""],
      propCheck: [""]
    });

    //this.insertForm.controls['tipo'].setValue("C");
    this.insertForm.controls['propCheck'].setValue(true);
  }

  ngOnInit(): void {
    this.colBreakpoint1 = (window.innerWidth < 768) ? 12 : 6;
    this.colBreakpoint2 = (window.innerWidth < 768) ? 0 : 6;
    this.colBreakpoint3 = (window.innerWidth < 768) ? 12 : 3;

    this.titleService.setTitle("Nuovo impianto termico");
    this.backService.setBackTitle("Torna alla ricerca");
    this.backService.setRoute("impianto/ricerca-impianti");
    this.insertForm.markAllAsTouched();
    this.impiantoService.getStatoImpianto().subscribe((elem: CodiceDescrizione[]) => {
      this.stati = elem;
      this.insertForm.controls["statoImpianto"].setValue(STATO_IMPIANTO.ATTIVO);
      this.insertForm.controls["dataVar"].setValue(new Date());
    });

    if (this.utente.ruoloLoggato.ruolo === RUOLI.RUOLO_RESPONSABILE) {
      this.insertForm.controls.responsabilita.setValidators(Validators.required);
      this.insertForm.controls.responsabilita.updateValueAndValidity();
      this.isResp = true;
      this.isPg = false;
    }

    if (this.utente.ruoloLoggato.ruolo === RUOLI.RUOLO_RESPONSABILE_IMPRESA) {
      this.insertForm.controls.responsabilita.setValidators(Validators.required);
      this.insertForm.controls.responsabilita.updateValueAndValidity();
      this.isResp = true;
      this.isPg = true;
    }

    this.insertForm.controls['indirizzoLoccsi'].valueChanges
      .pipe(debounceTime(500), distinctUntilChanged(), filter(data => data.length >= 3)).subscribe(elem => {
        if (typeof elem === "string") {
          this.loccsiClicked = false;
          this.currentAddress = undefined;
          const elem2 = elem;
          this.insertForm.controls['civicoLoccsi'].enable();
          this.filteredOptions = this.impiantoService.getIndirizzoStradario(elem2)
            .pipe(
              map(name => name ? name : this.indirizzi.slice()));
        }
      });

    this.insertForm.controls['comune'].valueChanges
      .pipe(debounceTime(500), distinctUntilChanged(), filter(data => data.length >= 3)).subscribe(elem => {
        if (typeof elem === "string") {
          this.loccsiClickedComuni = false;
          this.currentAddressComuni = undefined;
          const elem2 = elem;
          this.insertForm.controls['comune'].enable();
          this.filteredOptionsComuni = this.impiantoService.getProvinciaByComune(elem2)
            .pipe(
              map(name => name ? name : this.comuni.slice()));
        }
      });
      
     const duplicato = this.localStorageService.getDatiImpiantoDuplicato();

     if (duplicato) {
      this.insertForm.patchValue({
        codiceImpianto: duplicato.impianto.codiceImpianto || '', 
        statoImpianto: duplicato.impianto.stato || STATO_IMPIANTO.ATTIVO,
        dataVar: duplicato.impianto.dataVar ? new Date(duplicato.impianto.dataVar) : new Date(),
        motivazione: duplicato.impianto.motivazione || 'Primo caricamento impianto',
        tipo: duplicato.impianto.tipoImpianto === 'A' ? 'A' : 'C', 
        locTecnico: !!duplicato.impianto.flgApparevvUiExt,
        contabilizzazione: !!duplicato.impianto.flgContabilizzazione,
        flgMedioImpiantoCivile: !!duplicato.impianto.flgMedioImpiantoCivile,
        indirizzo: duplicato.impianto.indirizzoNonTrovato || duplicato.impianto.indirizzoSitad || '',
        civico: duplicato.impianto.civico || '',
        comune: duplicato.impianto.comune || '',
        provincia: duplicato.impianto.provincia || '',
        siglaProv: duplicato.impianto.siglaProv || '',
        pod: duplicato.impianto.pod || '',
        pdr: duplicato.impianto.pdr || '',
        noPdr: !!duplicato.impianto.flgNoPdr,
        propCheck: !!duplicato.impianto.flgVisuProprietario,
        coordX: duplicato.impianto.coordX || null,
        coordY: duplicato.impianto.coordY || null,
        istatComune: duplicato.impianto.istatComune || null
      });
    }
    else{
        this.insertForm.patchValue({
          tipo: null
       });
    }
    
      this.insertForm.controls['tipo'].markAsTouched();
      this.insertForm.controls['tipo'].updateValueAndValidity();
      this.toggleNoPdr(null);
    
  }

  @HostListener('window:resize', ['$event'])
  onResize(event?) {
    this.colBreakpoint1 = (event.target.innerWidth < 768) ? 12 : 6;
    this.colBreakpoint2 = (event.target.innerWidth < 768) ? 0 : 6;
    this.colBreakpoint3 = (event.target.innerWidth < 768) ? 12 : 3;
  }

  setLoccsiElem(feature: LoccsiFeature) {
    this.currentAddress = feature;
    if (feature.properties.civicoNum) {
      this.insertForm.controls['civicoLoccsi'].setValue(feature.properties.civicoNum +
        feature.properties.civicoSub);
      this.insertForm.controls['civicoLoccsi'].disable();
    }
    this.loccsiClicked = true;
  }

  setProvinciaComune(feature: LoccsiFeature) {
    this.currentAddressComuni = feature;
    this.insertForm.controls['provincia'].setValue(feature.properties.descProvincia ? feature.properties.descProvincia : feature.properties.pv);
    this.loccsiClickedComuni = true;
  }

  /* inserisciImpianto() {
    let impianto = this.creaNuovoImpianto();
    let responsabilita = undefined;
    if (this.isResp) {
      responsabilita = this.insertForm.controls.responsabilita.value;
    }
    this.impiantoService.setImpianto(impianto, responsabilita).subscribe((elem: Esito) => {
      this.router.navigate(["/impianto/dettaglio-impianto/" + elem.codiceImpianto, { success: true }]);
      this.messageService.setTitolo("Impianto inserito correttamente");
      this.messageService.showMessaggioM();
      this.messageService.setType(4);
    }, error => {
      this.messageService.setTitolo("Errore inserimento impianto");
      let esito = error.error as Esito;
      this.messageService.setDescrizione(esito.descrizioneEsito);
      this.messageService.showMessaggioM();
      this.messageService.setType(2);
    });
  } */

  /* checkPodPdrDuplicato() {
    let pod = this.insertForm.get("pod").value;
    let noPdr = this.insertForm.get("noPdr").value;
    if (!noPdr) {
      let pdr = this.insertForm.get("pdr").value;
      this.impiantoService.checkPodPdrDuplicato(pod, pdr).subscribe((elem: Esito) => {
        this.inserisciImpianto();
      }, error => {
        let esito = error.error as Esito;
        if (esito.esito === "OK") {
          this.dialog.open(DeleteDialogComponent, {
            data: { titolo: "Pod e/o Pdr duplicato", descrizione: "Attenzione! Sul Catasto Impianti Termici esistono altri impianti attivi con lo stesso POD e/o PDR. Vuoi continuare?" }
          }).afterClosed().subscribe(response => {
            if (response) {
              this.inserisciImpianto();
            }
          });
        } else {
          this.messageService.setTitolo("Errore inserimento impianto");
          this.messageService.setDescrizione(esito.descrizioneEsito);
          this.messageService.showMessaggioM();
          this.messageService.setType(2);
        }
      });

    } else {
      this.impiantoService.checkPodDuplicato(pod).subscribe((elem: Esito) => {
        this.inserisciImpianto();
      }, error => {
        let esito = error.error as Esito;
        if (esito.esito === "OK") {
          this.dialog.open(DeleteDialogComponent, {
            data: { titolo: "Pod duplicato", descrizione: "Attenzione! Sul Catasto Impianti Termici esistono altri impianti attivi con lo stesso POD. Vuoi continuare?" }
          }).afterClosed().subscribe(response => {
            if (response) {
              this.inserisciImpianto();
            }
          });
        } else {
          this.messageService.setTitolo("Errore inserimento impianto ");
          this.messageService.setDescrizione(esito.descrizioneEsito);
          this.messageService.showMessaggioM();
          this.messageService.setType(2);
        }
      });
    }
  } */ 


  checkPodPdrDuplicato() {
    let pod = this.insertForm.get("pod").value;
    let noPdr = this.insertForm.get("noPdr").value;

    if (!noPdr) {
      let pdr = this.insertForm.get("pdr").value;
      this.impiantoService.checkPodPdrDuplicato(pod, pdr).subscribe(
        () => {
          this.inserisciImpianto();
        },
        error => {
          let esito = error.error as Esito;
          if (esito.esito === "OK") {
            // duplicato pod o pdr
            let impianto: DatiImpianto = this.creaNuovoImpianto();
            let responsabilita = this.isResp ? this.insertForm.controls.responsabilita.value : undefined;
            this.localStorageService.setDatiImpiantoDuplicato(impianto, responsabilita);
            this.router.navigate(['/impianto/pod-pdr-duplicato'], { queryParams: { pod, pdr } });     
          } else {
            this.messageService.setTitolo("Errore inserimento impianto");
            this.messageService.setDescrizione(esito.descrizioneEsito);
            this.messageService.showMessaggioM();
            this.messageService.setType(2);
          }
        }
      );

    } else {
      this.impiantoService.checkPodDuplicato(pod).subscribe(
        () => {
          this.inserisciImpianto();
        },
        error => {
          let esito = error.error as Esito;
          if (esito.esito === "OK") {
            let impianto: DatiImpianto = this.creaNuovoImpianto();
            let responsabilita = this.isResp ? this.insertForm.controls.responsabilita.value : undefined;
            this.localStorageService.setDatiImpiantoDuplicato(impianto, responsabilita);
            this.router.navigate(['/impianto/pod-pdr-duplicato'], { queryParams: { pod } });
          } else {
            this.messageService.setTitolo("Errore inserimento impianto ");
            this.messageService.setDescrizione(esito.descrizioneEsito);
            this.messageService.showMessaggioM();
            this.messageService.setType(2);
          }
        }
      );
    }
  }

  inserisciImpianto() {
    let impianto: DatiImpianto = this.creaNuovoImpianto();
    let responsabilita = undefined;
    if (this.isResp) {
      responsabilita = this.insertForm.controls.responsabilita.value;
    }
    this.impiantoService.setImpianto(impianto, responsabilita).subscribe(
      (elem: Esito) => {
        this.router.navigate(["/impianto/dettaglio-impianto/" + elem.codiceImpianto, { success: true }]);
        this.messageService.setTitolo("Impianto inserito correttamente");
        this.messageService.showMessaggioM();
        this.messageService.setType(4);
      },
      error => {
        this.messageService.setTitolo("Errore inserimento impianto");
        let esito = error.error as Esito;
        this.messageService.setDescrizione(esito.descrizioneEsito);
        this.messageService.showMessaggioM();
        this.messageService.setType(2);
      }
    );
  }

  creaNuovoImpianto() {
    let impianto: DatiImpianto = new DatiImpianto();
    let codiceImpianto = this.insertForm.controls["codiceImpianto"].value;
    let statoImpianto = this.insertForm.controls["statoImpianto"].value;
    let dataVar = this.insertForm.controls["dataVar"].value;
    let motivazione = this.insertForm.controls["motivazione"].value;
    let tipo = this.insertForm.controls["tipo"].value;
    let locTecnico = this.insertForm.controls["locTecnico"].value;
    let contabilizzazione = this.insertForm.controls["contabilizzazione"].value;
    let flgMedioImpiantoCivile = this.insertForm.controls["flgMedioImpiantoCivile"].value;
    let civicoLoccsi = this.insertForm.controls["civicoLoccsi"].value;
    let stradario = this.insertForm.controls["stradario"].value;
    let indirizzo = this.insertForm.controls["indirizzo"].value;
    let civico = this.insertForm.controls["civico"].value;
    let provincia = this.insertForm.controls["provincia"].value;
    let pod = this.insertForm.controls["pod"].value;
    let pdr = this.insertForm.controls["pdr"].value;
    let noPdr = this.insertForm.controls["noPdr"].value;
    let propCheck = this.insertForm.controls["propCheck"].value;

    if (codiceImpianto)
      impianto.codiceImpianto = codiceImpianto;
    impianto.dataVar = dataVar;
    impianto.motivazione = motivazione;
    impianto.tipoImpianto = tipo;
    impianto.flgContabilizzazione = contabilizzazione;
    impianto.flgMedioImpiantoCivile = flgMedioImpiantoCivile;
    if (stradario) {
      impianto.civico = civico;
      impianto.indirizzoNonTrovato = indirizzo;
      impianto.comune = this.currentAddressComuni.properties.loccsiLabel;
      impianto.provincia = this.currentAddressComuni.properties.descProvincia ? this.currentAddressComuni.properties.descProvincia : this.currentAddressComuni?.properties.pv;
      impianto.siglaProv = this.currentAddressComuni.properties.siglaProvincia ? this.currentAddressComuni.properties.siglaProvincia : this.currentAddressComuni.properties.pv;
      impianto.istatComune = this.currentAddressComuni.properties.codiceIstat ? this.currentAddressComuni.properties.codiceIstat : undefined;
    } else if (this.loccsiClicked) {
      let impiantoStr = this.currentAddress.properties.tipoVia;
      impiantoStr += this.currentAddress.properties.preposizione
        && this.currentAddress.properties.preposizione != "" ? " " + this.currentAddress.properties.preposizione : "";
      impiantoStr += " " + this.currentAddress.properties.nomeVia;
      impianto.indirizzoSitad = impiantoStr;
      impianto.comune = this.currentAddress.properties.comune;
      if (this.currentAddress.properties.civicoNum) {
        impianto.civico = this.currentAddress.properties.civicoNum;
        impianto.civico += this.currentAddress.properties.civicoSub ? this.currentAddress.properties.civicoSub : "";
      } else {
        impianto.civico = civicoLoccsi;
      }

      impianto.provincia = this.currentAddress.properties.descProvincia;
      impianto.siglaProv = this.currentAddress.properties.siglaProvincia;
      impianto.coordX = this.currentAddress.geometry.coordinates[0];
      impianto.coordY = this.currentAddress.geometry.coordinates[1];
      impianto.istatComune = this.currentAddress.properties.codiceIstat ? this.currentAddress.properties.codiceIstat : undefined;
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

  goBack() {
    //this.location.back();
    this.localStorageService.clearDatiImpiantoDuplicato();
    this.router.navigate(['/impianto/ricerca-impianti']);
  }

  formValid() {
    return this.insertForm.controls["stradario"].value ? this.insertForm.valid && this.loccsiClickedComuni : this.insertForm.valid && this.loccsiClicked;
  }


  displayFn(indirizzo: LoccsiFeature): string {
    return indirizzo && indirizzo.properties && indirizzo.properties.loccsiLabel ? indirizzo.properties.loccsiLabel : '';
  }

  toggleStradarioImpianto($event) {
    if (this.insertForm.controls["stradario"].value) {
      this.insertForm.controls["indirizzoLoccsi"].clearValidators();
      this.insertForm.controls["indirizzoLoccsi"].updateValueAndValidity();
      this.insertForm.controls["civicoLoccsi"].clearValidators();
      this.insertForm.controls["civicoLoccsi"].updateValueAndValidity();

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

      this.insertForm.controls["indirizzoLoccsi"].setValidators([Validators.required, validateIndirizzo()]);
      this.insertForm.controls["indirizzoLoccsi"].updateValueAndValidity();
      this.insertForm.controls["civicoLoccsi"].setValidators([Validators.required]);
      this.insertForm.controls["civicoLoccsi"].updateValueAndValidity();
    }
  }

  myFilter = (d: Date | null): boolean => {
    return d < new Date();
  };

  toggleNoPdr($event) {
    if (this.insertForm.controls["noPdr"].value) {
      this.insertForm.controls["pdr"].setValue("");
      this.insertForm.controls["pdr"].disable();
      this.insertForm.controls["pdr"].clearValidators();
      this.insertForm.controls["pdr"].updateValueAndValidity();
    } else {
      this.insertForm.controls["pdr"].enable();
      this.insertForm.controls["pdr"].setValidators([Validators.required, validatePDR()]);
      this.insertForm.controls["pdr"].updateValueAndValidity();
    }
  }
}
