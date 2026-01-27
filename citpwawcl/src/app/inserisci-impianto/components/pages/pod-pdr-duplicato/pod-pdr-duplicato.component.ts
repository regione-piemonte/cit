import { Component, HostListener, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { DatiImpianto } from 'src/app/models/dati-impianto';
import { Esito } from 'src/app/models/esito';
import { LocalStorageServiceService } from 'src/app/services/local-storage-service.service';
import { ImpiantoService } from 'src/app/services/impianto.service';
import { MessageService } from 'src/app/services/message.service';
import { ReadFileService } from 'src/app/services/read-file.service';
import { FormBuilder, FormGroup } from '@angular/forms';
import { AuthenticationService } from 'src/app/services/authentication.service';
import { ResultService } from 'src/app/services/result.service';
import { BackService } from 'src/app/services/back.service';
import { TitleService } from 'src/app/services/title.service';
import { UtenteLoggato } from 'src/app/models/utente-loggato';
import { Impianto } from 'src/app/models/impianto';
import { NumberInput } from '@angular/cdk/coercion';
import { ICONSURL, RUOLI } from 'src/app/utils/constants';
import { DatiImpresa } from '@sigit/common-lib';

@Component({
  selector: 'app-pod-pdr-duplicato',
  templateUrl: './pod-pdr-duplicato.component.html',
  styleUrls: ['./pod-pdr-duplicato.component.scss']
})
export class PodPdrDuplicatoComponent implements OnInit {

  impianto: DatiImpianto;
  responsabilita: number | undefined;
  pod: string;
  pdr?: string;

  titoloMessaggio: string = "";
  descrzioneMessaggio: string = "";
  tipomessaggio: number = 0;
  showMessaggio: boolean = false;
  maxResults!: number;
  isRicercaCompletaChecked: boolean = false;
  utente: UtenteLoggato | null;
  filterForm: FormGroup;
  impiantiRisultato: Impianto[] = [];
  btnBreakpoint: NumberInput;
  gridHeightBreakpoint: NumberInput;
  datiImpresa: DatiImpresa;
  subentro: string = ICONSURL + "subentro.svg";

  constructor(private messageService: MessageService, 
              private readFileService: ReadFileService, 
              private fb: FormBuilder, 
              private route: ActivatedRoute,
              private router: Router, 
              private readonly authService: AuthenticationService, 
              private readonly result: ResultService, 
              private readonly backService: BackService, 
              private readonly titleService: TitleService, 
              private readonly impiantoService: ImpiantoService,
              private localStorageService: LocalStorageServiceService) 
    {
    this.utente = authService.getCurrentUserFromSession();
    this.filterForm = this.fb.group({
      filtro: ["", [
      ]]
    });
  }

  ngOnInit(): void {
    window.scrollTo(0, 0); 

    this.route.queryParams.subscribe(params => {
      this.pod = params['pod'];
      this.pdr = params['pdr'];
    });

    const dati = this.localStorageService.getDatiImpiantoDuplicato();
    console.log("[DEBUG] getDatiImpiantoDuplicato() ritorna:", dati);

    if (dati) {
      this.impianto = dati.impianto;
      this.responsabilita = dati.responsabilita;
    } else {
      this.router.navigate(['/impianto/nuovo-impianto']);
    }
    
    this.impiantoService.getGeoJsonImpiantoMaxResults()
      .subscribe(value => {
        this.maxResults = value;
        console.log("Valore ricevuto:", this.maxResults);
    });

    this.isRicercaCompletaChecked = true;
    this.backService.setBackTitle("Torna indietro");
    this.backService.setRoute("impianto/nuovo-impianto");
    this.titleService.setTitle("Risultato impianti termici");

    this.ricercaPerPodEPdr();

    this.filterForm.controls["filtro"].setValue("1");
    this.sortImpianti("1");
    this.btnBreakpoint = (window.innerWidth < 768) ? 14 : 12;
    this.gridHeightBreakpoint = (window.innerWidth < 768) ? "3em" : "2em";
  }

  confermaInserimento(): void {
    if (!this.impianto) return;

    this.impiantoService.setImpianto(this.impianto, this.responsabilita).subscribe(
      (esito: Esito) => {
        this.messageService.setTitolo("Impianto inserito correttamente");
        this.messageService.showMessaggioM();
        this.messageService.setType(4);
        this.router.navigate(['/impianto/dettaglio-impianto/' + esito.codiceImpianto, { success: true }]);
      },
      error => {
        const esito: Esito = error.error;
        this.messageService.setTitolo("Errore inserimento impianto");
        this.messageService.setDescrizione(esito.descrizioneEsito);
        this.messageService.showMessaggioM();
        this.messageService.setType(2);
      }
    );
  }

  annulla(): void {
    this.router.navigate(['/impianto/nuovo-impianto']);
  }

  ricercaPerPodEPdr(): void {
    let podResults: Impianto[] = [];
    let pdrResults: Impianto[] = [];

    this.impiantoService.getGeoJsonByFilterPodPdrDuplicati(
      true, undefined, "1", undefined, undefined, undefined,
      this.pod, undefined, undefined, undefined, undefined, undefined, undefined, undefined
    ).subscribe({
      next: geoJsonPod => {
        podResults = this.impiantoService.parseGeoJsonToImpianto(geoJsonPod);
        procediConPdr();
      },
      error: err => {
        console.warn("[WARN] POD non trovato, procedo con PDR", err);
        podResults = [];
        procediConPdr();
      }
    });

    const procediConPdr = () => {
      if (this.pdr) {
        this.impiantoService.getGeoJsonByFilterPodPdrDuplicati(
          true, undefined, "1", undefined, undefined, undefined,
          undefined, this.pdr, undefined, undefined, undefined, undefined, undefined, undefined
        ).subscribe({
          next: geoJsonPdr => {
            pdrResults = this.impiantoService.parseGeoJsonToImpianto(geoJsonPdr);
          },
          error: err => {
            this.messageService.setTitolo("Errore ricerca PDR");
            this.messageService.setDescrizione(err.error?.title || "Errore sconosciuto");
            this.messageService.showMessaggioM();
            this.messageService.setType(2);
          },
          complete: () => {
            this.unisciRisultati(podResults, pdrResults);
          }
        });
      } else {
        this.unisciRisultati(podResults, []);
      }
    };
  }


  unisciRisultati(podResults: Impianto[], pdrResults: Impianto[]): void {
    const map = new Map<number, Impianto>();

    podResults.forEach(i => map.set(i.codiceImpianto, i));
    pdrResults.forEach(i => map.set(i.codiceImpianto, i));

    this.impiantiRisultato = Array.from(map.values());

    console.log("[DEBUG] Risultati POD:", podResults);
    console.log("[DEBUG] Risultati PDR:", pdrResults);
    console.log("[DEBUG] Risultato unificato impiantiRisultato:", this.impiantiRisultato); 

  }

  sortImpianti(type: string) {
    if (this.impiantiRisultato) {
      if (type == "1")
        this.impiantiRisultato.sort((a, b) => (a.codiceImpianto < b.codiceImpianto ? -1 : 1));
      if (type == "2")
        this.impiantiRisultato.sort((a, b) => (a.descComune < b.descComune ? -1 : 1));
      if (type == "3")
        this.impiantiRisultato.sort((a, b) => (a.indirizzo < b.indirizzo ? -1 : 1));
      if (type == "4")
        this.impiantiRisultato.sort((a, b) => (a.denomResponsabile < b.denomResponsabile ? -1 : 1));
      if (type == "5")
        this.impiantiRisultato.sort((a, b) => (a.stato < b.stato ? -1 : 1));
    }
  }

  @HostListener('window:resize', ['$event'])
  onResize(event?) {
    this.btnBreakpoint = (event.target.innerWidth < 768) ? 14 : 12;
    this.gridHeightBreakpoint = (window.innerWidth < 768) ? "3em" : "2em";
  }

  getProvinciaBySiglaProvincia(siglaProvincia: string) {
    let provArr;
    let provincia;
    if (localStorage.ComuniEstesi) provArr = JSON.parse(localStorage.ComuniEstesi);
    if (provArr) provincia = provArr.find(elem => elem.siglaProvincia === siglaProvincia);
    return provincia ? provincia.provincia : "";
  }

  verificaImpiantoSubentroFromImpianto(impianto: Impianto) {
    console.log("[verificaImpiantoSubentroFromImpianto] Inizio verifica per impianto:", impianto);

    this.impiantoService.getDettaglioImpianto(impianto.codiceImpianto.toString())
        .subscribe((res) => {
            console.log("[verificaImpiantoSubentroFromImpianto] Response API:", res);

            const apiData = res?.Richiesta?.datiPrecompilati;
            if (!apiData) {
                console.error("[verificaImpiantoSubentroFromImpianto] Dati impianto non disponibili");
                this.messageService.setTitolo("Errore");
                this.messageService.setDescrizione("Dati impianto non disponibili");
                this.messageService.setType(2);
                this.messageService.showMessaggioM();
                return;
            }

            const datiImpianto: DatiImpianto = {
                codiceImpianto: apiData.codice_impianto,
                indirizzoSitad: apiData.L1_2indirizzo,
                civico: apiData.L1_2civico,
                comune: apiData.L1_2comune,
                siglaProv: apiData.L1_2prov,
                provincia: apiData.L1_6provincia,
                stradario: apiData.fuoriStradario === 1,
                indirizzoNonTrovato: apiData.L1_2indirizzo
            };

            console.log("[verificaImpiantoSubentroFromImpianto] Dati costruiti per verifica:", datiImpianto);

            this.verificaImpiantoSubentro(datiImpianto);
        }, (err) => {
            console.error("[verificaImpiantoSubentroFromImpianto] Errore nel recupero impianto", err);
            this.messageService.setTitolo("Errore");
            this.messageService.setDescrizione("Impossibile recuperare i dati dell'impianto");
            this.messageService.setType(2);
            this.messageService.showMessaggioM();
        });
  }

  verificaImpiantoSubentro(datiImpianto: DatiImpianto) {
      console.log("[verificaImpiantoSubentro] Inizio verifica con dati:", datiImpianto);

      const checkContrattoInEssere = [RUOLI.RUOLO_SUPER, RUOLI.RUOLO_VALIDATORE, RUOLI.RUOLO_IMPRESA, RUOLI.RUOLO_RESPONSABILE, RUOLI.RUOLO_RESPONSABILE_IMPRESA]
          .includes(this.utente.ruoloLoggato.ruolo);

      this.datiImpresa = this.datiImpresa || {};
      this.datiImpresa.id_persona_giuridica = this.utente.ruoloLoggato?.idPersonaGiuridica;

      console.log("[verificaImpiantoSubentro] checkContrattoInEssere:", checkContrattoInEssere);
      console.log("[verificaImpiantoSubentro] datiImpresa:", this.datiImpresa);

      const datiPerBackend = {
          ...datiImpianto,
          stradario: datiImpianto.stradario ? 1 : 0
      };

      console.log("[verificaImpiantoSubentro] Dati inviati al backend:", datiPerBackend);

      this.impiantoService.verifyIndirizzoImpianto(datiPerBackend, checkContrattoInEssere)
          .subscribe(() => {
              console.log("[verificaImpiantoSubentro] Verifica indirizzo ok, navigazione in base al ruolo");

              switch (this.utente.ruoloLoggato.ruolo) {
                  case RUOLI.RUOLO_SUPER:
                  case RUOLI.RUOLO_VALIDATORE:
                  case RUOLI.RUOLO_IMPRESA:
                      console.log("[verificaImpiantoSubentro] Navigazione: /nomina/seleziona-subentro");
                      this.router.navigate(["/nomina/seleziona-subentro"], {
                          queryParams: {
                              codiceImpianto: datiImpianto.codiceImpianto,
                              id_persona_giuridica: this.datiImpresa.id_persona_giuridica
                          },
                          state: { impresa: this.datiImpresa }
                      });
                      break;
                  case RUOLI.RUOLO_RESPONSABILE:
                  case RUOLI.RUOLO_RESPONSABILE_IMPRESA:
                      console.log("[verificaImpiantoSubentro] Navigazione: /nomina/effettua-subentro");
                      this.router.navigate(["/nomina/effettua-subentro"], {
                          queryParams: {
                              codiceImpianto: datiImpianto.codiceImpianto,
                              id_persona_giuridica: this.datiImpresa.id_persona_giuridica
                          },
                          state: { impresa: this.datiImpresa }
                      });
                      break;
                  default:
                      console.log("[verificaImpiantoSubentro] Navigazione: /nomina/effettua-subentro");
                      this.router.navigate(["/nomina/effettua-subentro"], {
                          queryParams: {
                              codiceImpianto: datiImpianto.codiceImpianto,
                              id_persona_giuridica: this.datiImpresa.id_persona_giuridica
                          },
                          state: { impresa: this.datiImpresa }
                      });
                      break;
              }
          }, (err) => {
              console.error("[verificaImpiantoSubentro] Errore verifyIndirizzoImpianto", err);

              if (err?.error && err.error.descrizioneEsito) {
                  if (err.error.descrizioneEsito === "NOIMPIANTO") {
                      this.noImpiantoAction();
                  } else if (err.error.descrizioneEsito === "S070") {
                      this.messageService.setTitolo("Errore");
                      this.messageService.setDescrizione("Il codice impianto non risulta presente all'indirizzo indicato");
                      this.messageService.setType(2);
                      this.messageService.showMessaggioM();
                  } else {
                      this.messageService.setTitolo("Errore");
                      this.messageService.setDescrizione(err.error.descrizioneEsito);
                      this.messageService.setType(2);
                      this.messageService.showMessaggioM();
                  }
              }
          });
  }

  noImpiantoAction() {
      console.log("[noImpiantoAction] Impianto non presente a sistema, ruolo:", this.utente.ruoloLoggato.ruolo);

      switch (this.utente.ruoloLoggato.ruolo) {
          case RUOLI.RUOLO_SUPER:
          case RUOLI.RUOLO_VALIDATORE:
          case RUOLI.RUOLO_IMPRESA:
              this.router.navigate(["/nomina/effettua-subentro"], {
                  queryParams: { noImpianto: true }
              });
              break;
          default:
              this.messageService.setTitolo("Errore");
              this.messageService.setDescrizione("Il codice impianto non risulta presente nel sistema");
              this.messageService.setType(2);
              this.messageService.showMessaggioM();
              break;
      }
  }
}
