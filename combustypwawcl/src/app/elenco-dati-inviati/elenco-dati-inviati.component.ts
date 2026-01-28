import { Component, HostListener, OnInit } from '@angular/core';
import { SpinnerService } from '../services/spinner.service';
import { Router } from '@angular/router';
import { TitleService } from '../services/title.service';
import { BackService } from '../services/back.service';
import { AuthenticationService } from '../services/authentication.service';
import { FormBuilder, FormGroup } from '@angular/forms';
import { ImportDatiDistributore } from '../models/importazione-dati-distributore'
import { ICONSURL } from '../utils/constants';
import { MatDialog, MatDialogModule } from '@angular/material/dialog';
import { DettaglioAcquisizioneXmlComponent } from '../dettaglio-acquisizione-xml/dettaglio-acquisizione-xml.component';
import { AnnullaAcquisizioneComponent } from '../annulla-acquisizione/annulla-acquisizione.component';
import { DatiDistributoreService } from '../services/dati-distributore.service';
import { ResultService } from '../services/result.service';
import { CONFIRM_TYPE, ERROR_TYPE, WARNING_TYPE } from '../common/components/message-box/message-box.component';
import { ImpiantoService } from '../services/impianto.service';

@Component({
  selector: 'app-elenco-dati-inviati',
  templateUrl: './elenco-dati-inviati.component.html',
  styleUrls: ['./elenco-dati-inviati.component.scss']
})

export class ElencoDatiInviatiComponent implements OnInit {

  errorType: number = WARNING_TYPE;
  titoloErrore = "";
  descrizioneErrore = "";
  backTitle: string = "";
  route: string = "ruoli";
  ruolo: any;
  utente: any;

  eyeIcon: string = ICONSURL + "eye.png";
  deleteIcon: string = ICONSURL + "delete.svg";

  filterListIcon: string = ICONSURL + "filter-list.svg"
  filterListWhiteIcon: string = ICONSURL + "filter-list-white.svg"

  isMobile: boolean;
  isFiltraImpiantiPanelOpen: boolean;

  risultati: number = 0;
  filterForm: FormGroup;
  elencoImportDatiDistributore: ImportDatiDistributore[];
  elencoImportDatiDistributoreFiltrati = [];
  anniDisponibili: string[] = [];
  mesiDisponibili: { nome: string, valore: string }[] = [];

  loading: boolean = false;
  maxRisultatiEstratti: number;

  constructor(
      readonly spinnerService: SpinnerService, 
      private router: Router,
      readonly titoloService: TitleService,
      readonly backService: BackService,
      readonly authService: AuthenticationService,
      private fb: FormBuilder,
      private dialog: MatDialog,
      private readonly result: ResultService,
      private datiDistributoreService: DatiDistributoreService,
      private impiantoService: ImpiantoService
      ) { }

  ngOnInit(): void {
    this.isMobile = (window.innerWidth < 768) ? true : false;
    this.utente = this.authService.getCurrentUserFromSession();
    this.ruolo = this.authService.getCurrentUserFromSession().ruoloLoggato;
    this.titoloService.setTitle("Elenco Dati Inviati");
    this.route = "/";
    this.backTitle = "Torna indietro"
    this.backService.setBackTitle(this.backTitle);
    this.backService.setRoute("/");

    this.result.setIsPersona(null);
    this.result.setIsImpianto(null);
    this.result.setIsVisualizzazioneDettaglio(null);

    this.estraiAnniUnici();
    this.estraiMesiUnici();

    this.filterForm = this.fb.group({
      anno: [''],
      mese: [''],
      instInterna: [''],
      instStato: [''],
      ordinamento: ['recenti'] // valore di default
    });

    const filtriSalvati = this.datiDistributoreService.getFiltri();
    if (filtriSalvati) {
      this.filterForm.patchValue(filtriSalvati);
    }

    this.filterForm.get('ordinamento')?.valueChanges.subscribe((value: string) => {
      this.onOrdinaChange(value);
    });

    this.filterForm.get('anno')?.valueChanges.subscribe(value => {
      console.log('Valore cambiato per anno:', value);
    });

    this.filterForm.get('mese')?.valueChanges.subscribe(value => {
      console.log('Valore cambiato per mese:', value);
    });

    this.filterForm.get('instInterna')?.valueChanges.subscribe(value => {
      console.log('Valore cambiato per instInterna:', value);
    });

    this.filterForm.get('instStato')?.valueChanges.subscribe(value => {
      console.log('Valore cambiato per instStato:', value);
    });

    console.log("this.ruolo :" + this.ruolo);    
    console.log("this.idPersonaGiuridica :" + this.authService.getCurrentUserFromSession()?.ruoloLoggato?.idPersonaGiuridica);

      this.impiantoService.getGeoJsonImpiantoMaxResults().subscribe({
      next: (max) => {
        this.maxRisultatiEstratti = max;
        console.log('Limite massimo risultati:', max);

        this.ricaricaDati();
      },
      error: (err) => {
        console.error('Errore nel recupero di max risultati impianto:', err);
        this.maxRisultatiEstratti = 0;

        this.ricaricaDati();
      }
    });
  }

    @HostListener('window:resize', ['$event'])
    onResize(event?) {
      this.isMobile = (event.target.innerWidth < 768) ? true : false;
   }
  

  updateImpiantiCount() {
    this.risultati = this.elencoImportDatiDistributoreFiltrati.length;
  }

  estraiMesiUnici() {
    const nomiMesi = [
      'Gennaio', 'Febbraio', 'Marzo', 'Aprile', 'Maggio', 'Giugno',
      'Luglio', 'Agosto', 'Settembre', 'Ottobre', 'Novembre', 'Dicembre'
    ];

    this.mesiDisponibili = nomiMesi.map((nome, index) => ({
      nome,
      valore: (index + 1).toString() 
    }));
  }

  estraiAnniUnici() {
      const annoInizio = 2014;
      const annoCorrente = new Date().getFullYear();

      this.anniDisponibili = Array.from(
        { length: annoCorrente - annoInizio + 1 },
        (_, i) => (annoInizio + i).toString()
      ).reverse();
  }

  filtraImpianti() {
    this.loading = true;
    const { anno, mese, instInterna, instStato, ordinamento } = this.filterForm.value;
    this.datiDistributoreService.salvaFiltri(this.filterForm.value);
    if (this.isMobile) this.isFiltraImpiantiPanelOpen = false;

    this.datiDistributoreService.getDettaglioDatiDistributoreJson(
          this.authService.getCurrentUserFromSession()?.ruoloLoggato?.idPersonaGiuridica, anno, mese, instInterna, instStato
        ).subscribe({
          next: (response) => {
            this.elencoImportDatiDistributore = response;
            console.log("getDettaglioDatiDistributoreJson: ");
            console.log(this.elencoImportDatiDistributore);
            //this.elencoImportDatiDistributoreFiltrati = response; 
            this.elencoImportDatiDistributoreFiltrati = response.filter(item => this.isValidImport(item));

            this.onOrdinaChange(this.filterForm.get('ordinamento')?.value || 'recenti');
            this.updateImpiantiCount();

            if (response.length >= this.maxRisultatiEstratti) {  
              this.titoloErrore = "Attenzione!";
              this.descrizioneErrore = "Sono stati estratti solo alcuni risultati. Si raccomanda di affinare la ricerca tramite l'utilizzo dei filtri.";
              this.errorType = WARNING_TYPE;
            }

            this.loading = false;
          },
          error: (err) => {
            console.error('Errore nel recupero dei dati del distributore:', err);
            this.elencoImportDatiDistributore = [];
            this.elencoImportDatiDistributoreFiltrati = [];

            this.loading = false;
          }
        });


    this.onOrdinaChange(ordinamento); 

    this.updateImpiantiCount();
  }

  onOrdinaChange(value: string) {
    switch (value) {
      case 'recenti':
        this.elencoImportDatiDistributoreFiltrati.sort((a, b) => 
          (this.parseDateIT(b.data_inizio_elab)?.getTime() || 0) - (this.parseDateIT(a.data_inizio_elab)?.getTime() || 0)
        );
        break;
      case 'vecchi':
        this.elencoImportDatiDistributoreFiltrati.sort((a, b) => 
          (this.parseDateIT(a.data_inizio_elab)?.getTime() || 0) - (this.parseDateIT(b.data_inizio_elab)?.getTime() || 0)
        );
        break;
      case 'stato':
        this.elencoImportDatiDistributoreFiltrati.sort((a, b) =>
          (a.des_stato_distrib || '').localeCompare(b.des_stato_distrib || '')
        );
        break;
      case 'tipologia':
        this.elencoImportDatiDistributoreFiltrati.sort((a, b) =>
          (a.tipo_caricamento || '').localeCompare(b.tipo_caricamento || '')
        );
        break;
    }
  }

  getStatoClass(stato: string): string {
  switch (stato?.toLowerCase()) {
    case 'inviato':
      return 'verde-scuro';
    case 'sostituito':
      return 'verde-chiaro';
    case 'da elaborare':
      return 'celeste';
    case 'rifiutato/scartato':
      return 'senape';
    case 'eliminato':
      return 'rosso';
    default:
      return '';
  }
}

  openFiltraImpiantiPanel() {
    this.isFiltraImpiantiPanelOpen = true;
  }

  closeFiltraImpiantiPanel(){
    this.isFiltraImpiantiPanelOpen = false;
  }

  navigateToImportazioneXml() {
    this.router.navigate(["/importazione-xml"]);
  }
  
  navigateToCaricamentoManuale() {
    this.router.navigate(["/caricamento-semplificato"]);
  }

  navigateToCercaDatiFornitura() {
    this.router.navigate(["/cerca-dati-fornitura"]);
  }

  openDettaglioCaricamentoManualeSemplificato(importDatiDistributore: ImportDatiDistributore) {
  console.log("Import selezionato (manuale):", importDatiDistributore);

  const idImport = importDatiDistributore.id_import_distrib;

  this.datiDistributoreService.getDettaglioDatiImportJson(idImport).subscribe({
      next: (datiFornitura) => {
        const importCompleto = {
          ...importDatiDistributore,
          datiFornitura: [datiFornitura]
        };

        this.result.setResult(importCompleto);
        this.result.setIsVisualizzazioneDettaglio(true);
        this.navigateToCaricamentoManuale();
      },
      error: (err) => {
        console.error('Errore nel caricamento del dettaglio manuale:', err);
      }
    });
  }

  openDettaglioAcquisizioneXML(importDatiDistributore: ImportDatiDistributore) {
    console.log("Import selezionato (XML):", importDatiDistributore);

    const idImport = importDatiDistributore.id_import_distrib;

    this.datiDistributoreService.getDettaglioDatiImportJson(idImport).subscribe({
        next: (datiFornitura) => {
          const importCompleto = {
            ...importDatiDistributore,
            datiFornitura: [datiFornitura]
          };

          this.dialog.open(DettaglioAcquisizioneXmlComponent, {
            width: '80%',
            data: importCompleto
          });
        },
        error: (err) => {
          console.error('Errore nel caricamento del dettaglio XML:', err);
        }
      });
  }

  openAnnullaAcquisizione(importDatiDistributore: ImportDatiDistributore) {
    console.log("this.utente.pfLoggato.codiceFiscalePF: " + this.utente.pfLoggato.codiceFiscalePF)
    
    const dialogRef = this.dialog.open(AnnullaAcquisizioneComponent, {
      width: '60%',
      disableClose: true, 
      data: { 
        importDatiDistributore,
        codiceFiscalePF: this.utente.pfLoggato.codiceFiscalePF,
        errorType: this.errorType,
        titoloErrore: this.titoloErrore,
        descrizioneErrore: this.descrizioneErrore
       } 
    });

     dialogRef.afterClosed().subscribe(result => {
      console.log('Risultato ricevuto dal dialog:', result); 

    if (result?.titoloErrore && result?.descrizioneErrore && result?.errorType != null) {
      this.titoloErrore = result.titoloErrore;
      this.descrizioneErrore = result.descrizioneErrore;
      this.errorType = result.errorType;

      if (result.errorType === CONFIRM_TYPE) {
        setTimeout(() => {
          this.ricaricaDati();
        }, 100);
      }
    }
  });
}

  ricaricaDati() {
    const filtri = this.datiDistributoreService.getFiltri() || this.filterForm.value;
    const { anno, mese, instInterna, instStato } = filtri;

    this.datiDistributoreService.getDettaglioDatiDistributoreJson(
      this.authService.getCurrentUserFromSession()?.ruoloLoggato?.idPersonaGiuridica, anno, mese, instInterna, instStato
    ).subscribe({
      next: (response) => {
        this.elencoImportDatiDistributore = response;
        console.log("getDettaglioDatiDistributoreJson: ");
        console.log(this.elencoImportDatiDistributore);
        //this.elencoImportDatiDistributoreFiltrati = response; 
        this.elencoImportDatiDistributoreFiltrati = response.filter(item => this.isValidImport(item));
        this.onOrdinaChange(this.filterForm.get('ordinamento')?.value || 'recenti');
        this.updateImpiantiCount();

        if (response.length >= this.maxRisultatiEstratti) {  
          this.titoloErrore = "Attenzione!";
          this.descrizioneErrore = "Sono stati estratti solo alcuni risultati. Si raccomanda di affinare la ricerca tramite l'utilizzo dei filtri.";
          this.errorType = WARNING_TYPE;
        }
      },
      error: (err) => {
        console.error('Errore nel recupero dei dati del distributore:', err);
        this.elencoImportDatiDistributore = [];
        this.elencoImportDatiDistributoreFiltrati = [];
      }
    });
  }

  azzeraFiltri() {
    this.filterForm.reset({
      anno: '',
      mese: '',
      instInterna: '',
      instStato: '',
      ordinamento: 'recenti'
    });

    this.datiDistributoreService.clearFiltri();
    this.elencoImportDatiDistributoreFiltrati = this.elencoImportDatiDistributore.filter(item => this.isValidImport(item));
    this.onOrdinaChange('recenti');
    this.updateImpiantiCount();
  }

  parseDateIT(dateStr: string): Date | null {
    if (!dateStr) return null;
    const parts = dateStr.split('-'); // [dd, MM, yyyy]
    if (parts.length !== 3) return null;
    const day = Number(parts[0]);
    const month = Number(parts[1]) - 1; 
    const year = Number(parts[2]);
    return new Date(year, month, day);
  }

    clearErrore() {
    this.titoloErrore = '';
    this.descrizioneErrore = '';
  }

  isValidImport(item: ImportDatiDistributore): boolean {
    const isImportXml = item.uid_index && !item.nome_file_import.includes('caricamento manuale');
    const isManuale = !item.uid_index && item.nome_file_import.includes('caricamento manuale');
    return isImportXml || isManuale; // scarta quelli che sarebbero "N/D"
  }
}
