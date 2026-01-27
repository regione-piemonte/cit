import { NumberInput } from '@angular/cdk/coercion';
import { Component, HostListener, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { Extent } from 'ol/interaction';
import { Subscription } from 'rxjs';
import { Dataset } from 'src/app/models/dataset.model';
import { DatiImpianto } from 'src/app/models/dati-impianto';
import { GeolocationConf } from 'src/app/models/geolocation-config.model';
import { Impianto } from 'src/app/models/impianto';
import { Layers } from 'src/app/models/layer.model';
import { MapConfig } from 'src/app/models/map-config.model';
import { PointStyle } from 'src/app/models/point-style.model';
import { UtenteLoggato } from 'src/app/models/utente-loggato';
import { WMSLayer } from 'src/app/models/wms-layer.model';
import { AuthenticationService } from 'src/app/services/authentication.service';
import { BackService } from 'src/app/services/back.service';
import { ImpiantoService } from 'src/app/services/impianto.service';
import { ReadFileService } from 'src/app/services/read-file.service';
import { ResultService } from 'src/app/services/result.service';
import { TitleService } from 'src/app/services/title.service';
import { ICONSURL, MAT_GRID_STYLE, RUOLI } from 'src/app/utils/constants';
import { DatiImpresa } from '@sigit/common-lib';
import { MessageService } from 'src/app/services/message.service';
import { LocalStorageServiceService } from 'src/app/services/local-storage-service.service';


@Component({
  selector: 'app-risultato-ricerca-impianti',
  templateUrl: './risultato-ricerca-impianti.component.html',
  styleUrls: ['./risultato-ricerca-impianti.component.scss'],
  styles: [ MAT_GRID_STYLE ]

})
export class RisultatoRicercaImpiantiComponent implements OnInit {
  mappaIcon: string = ICONSURL + "mappa.svg";
  subentro: string = ICONSURL + "subentro.svg";
  impianti: Impianto[];
  utente: UtenteLoggato | null;
  filterForm: FormGroup;
  subscription: Subscription;
  btnBreakpoint: NumberInput;
  gridHeightBreakpoint: NumberInput;
  isMapShowed: Boolean;
  isRicercaCompletaChecked: boolean = false;
  
  datiImpresa: DatiImpresa;
  titoloMessaggio: string = "";
  descrzioneMessaggio: string = "";
  tipomessaggio: number = 0;
  showMessaggio: boolean = false;
  maxResults!: number;

  public datasets: Dataset[] = [];

  public baseLayer!: Layers;

  public showMap = false;

  public options: MapConfig = {
    fullScreen: false,
    switchBaseLayer: false,
    geolocationConfig: new GeolocationConf({
      visible: true,
      iconGeoEnaled: 'assets/target_full.svg',
      iconGeoDisabled: 'assets/target_empty.svg',
      enableZoomTo: true,
      pointStyle: new PointStyle({
        featureBorderColor: 'yellow',
        fillColor: 'rgba(255,255,0,0.5)',
        icon: 'assets/target_full.svg',
        heightIcon: 15
      })
    })
  }

  public zoomTo: Extent | [number,number] | {} = {};

  public wmsList: WMSLayer[] = [];

  GeoTest: any = null;

  constructor(private localStorageService: LocalStorageServiceService, private messageService: MessageService, private readFileService: ReadFileService, private fb: FormBuilder, private router: Router, private readonly authService: AuthenticationService, private readonly result: ResultService, private readonly backService: BackService, private readonly titleService: TitleService, private readonly impiantoService: ImpiantoService) {
    this.utente = authService.getCurrentUserFromSession();
    this.filterForm = this.fb.group({
      filtro: ["", [
      ]]
    });
  }

  ngOnInit(): void {
    window.scrollTo(0, 0); 
    
    this.impiantoService.getGeoJsonImpiantoMaxResults()
      .subscribe(value => {
        this.maxResults = value;
        console.log("Valore ricevuto:", this.maxResults);
    });

    this.result.isRicercaCompletaChecked$.subscribe(value => {
      this.isRicercaCompletaChecked = value;
    });

    this.backService.setBackTitle("Torna alla ricerca");
    this.backService.setRoute("impianto/ricerca-impianti");
    this.titleService.setTitle("Risultato impianti termici");
    this.impianti = this.impiantoService.parseGeoJsonToImpianto(this.result.getResult());
    this.filterForm.controls["filtro"].setValue("1");
    this.sortImpianti("1");
    this.btnBreakpoint = (window.innerWidth < 768) ? 15 : 5;
    this.gridHeightBreakpoint = (window.innerWidth < 768) ? "3em" : "2em";

    this.GeoTest = this.result.getResult();
    this.instantiateDataSet();
    if(!Array.isArray(this.impianti) || this.impianti.length != 0) {
    this.zoomTo = this.createBoundingBoxGeoJson(this.GeoTest);
    }
    this.isMapShowed = false;
  }

  instantiateDataSet(){
    this.datasets = [
      new Dataset({
          layerName: 'Impianti termici',
          style: new PointStyle({textColor: 'white', fillColor: 'blue', selectFillColor: 'yellow', clusterPointRadius: 10, featurePointRadius: 10}),
          clusterMinDistance:300000,
          geojson: this.GeoTest
        })]
  }

  @HostListener('window:resize', ['$event'])
  onResize(event?) {
    this.btnBreakpoint = (event.target.innerWidth < 768) ? 15 : 5;
    this.gridHeightBreakpoint = (window.innerWidth < 768) ? "3em" : "2em";
  }

  showMapAndPoints(){
    this.isMapShowed = !this.isMapShowed;
  }

  sortImpianti(type: string) {
    if (this.impianti) {
      if (type == "1")
        this.impianti.sort((a, b) => (a.codiceImpianto < b.codiceImpianto ? -1 : 1));
      if (type == "2")
        this.impianti.sort((a, b) => (a.descComune < b.descComune ? -1 : 1));
      if (type == "3")
        this.impianti.sort((a, b) => (a.indirizzo < b.indirizzo ? -1 : 1));
      if (type == "4")
        this.impianti.sort((a, b) => (a.denomResponsabile < b.denomResponsabile ? -1 : 1));
      if (type == "5")
        this.impianti.sort((a, b) => (a.stato < b.stato ? -1 : 1));
    }
  }

  dettaglioImpianto(elem: Impianto) {
    this.router.navigate(["/impianto/dettaglio-impianto/" + elem.codiceImpianto]);
  }

  isAbilitatoInserisciImpianto() {
    return this.utente?.ruoloLoggato.ruolo != RUOLI.RUOLO_CONSULTATORE &&
      this.utente?.ruoloLoggato.ruolo != RUOLI.RUOLO_3RESPONSABILE &&
      this.utente?.ruoloLoggato.ruolo != RUOLI.RUOLO_PROPRIETARIO &&
      this.utente?.ruoloLoggato.ruolo != RUOLI.RUOLO_PROPRIETARIO_IMPRESA;
  }

  apriInserisciimpianto() {
    this.localStorageService.clearDatiImpiantoDuplicato();
    this.router.navigate(["/impianto/nuovo-impianto"]);
  }

  getProvinciaBySiglaProvincia(siglaProvincia: string) {
    let provArr;
    let provincia;
    if (localStorage.ComuniEstesi) provArr = JSON.parse(localStorage.ComuniEstesi);
    if (provArr) provincia = provArr.find(elem => elem.siglaProvincia === siglaProvincia);
    return provincia ? provincia.provincia : "";
  }

      /**
   * Read identified list of geojson point and wms
   * @param list of geojson
   */
      public readIdentifiedList(list: any[]) {
        console.log('[List of GeoJson from identify either GeoJson passed from Datasets and WMS ]', list);
      }

      /**
       * Retrieve selected point when click on 'Vai al punto' button on identify
       * @param geojson
       */
      public selectedGeoJsonOnIdentify(geojson: any) {
        console.log('[Geojson of the selected point]', geojson);
      }

      createBoundingBoxGeoJson(inputGeoJson: any): any {
        const coordinates: number[][] = [];

        inputGeoJson.features.forEach((feature: any) => {
          if (feature.geometry.type === 'Point') {
            coordinates.push(feature.geometry.coordinates);
          }
        });

        const minLng = Math.min(...coordinates.map(coord => coord[0]));
        const minLat = Math.min(...coordinates.map(coord => coord[1]));
        const maxLng = Math.max(...coordinates.map(coord => coord[0]));
        const maxLat = Math.max(...coordinates.map(coord => coord[1]));

        return {
          type: 'Feature',
          geometry: {
            type: 'Polygon',
            coordinates: [[
              [minLng, minLat],
              [minLng, maxLat],
              [maxLng, maxLat],
              [maxLng, minLat],
              [minLng, minLat]
            ]]
          },
          properties: {}
        };
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

          const checkContrattoInEssere = [RUOLI.RUOLO_SUPER, RUOLI.RUOLO_VALIDATORE, RUOLI.RUOLO_IMPRESA]
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
