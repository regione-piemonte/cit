import { AfterViewInit, Component, EventEmitter, Input, OnChanges, Output, SimpleChanges, ViewEncapsulation } from '@angular/core';
import { Feature, Map, Overlay } from 'ol';
import GeoJSON from 'ol/format/GeoJSON';
import TileLayer from 'ol/layer/Tile';
import { TileWMS } from 'ol/source';
import { forkJoin } from 'rxjs';
import { identifyService } from 'src/app/map/identify/identify.service';
import { Constants } from '../utils/constants';

@Component({
  selector: 'app-identify',
  templateUrl: './identify.component.html',
  styleUrls: ['./identify.component.scss'],
  encapsulation: ViewEncapsulation.None,
})
export class IdentifyComponent implements AfterViewInit, OnChanges{

  /**
   * Map Object
   */
  @Input()
  public map: Map = new Map({});

  /**
   * Wms layer list to use easily in identify
   */
  @Input()
  public olWmsList: TileLayer<TileWMS>[] = [];

  /**
   * list of feature to show in tooltip
   */
  @Input()
  public selectedFeatureList: Feature[] = [];

  /**
   * Event to tell parent to clear selected feature
   */
  @Output()
  clearSelectedFeatureEmit: EventEmitter<any> = new EventEmitter();

  /**
   * Event to pass identify list to parent
   */
  @Output()
  identifiedListEmit: EventEmitter<Feature[]> = new EventEmitter();

  /**
   * Event to pass feature when click on 'Vai al punto'
   */
  @Output()
  selectedIdentifyPointEmit:EventEmitter<Feature> = new EventEmitter();

  /**
   * Overlay where place popup
   */
  private popupOverlay = new Overlay({
    element: undefined,
    autoPan: {
      animation: {
        duration: 250,
      },
    },
    insertFirst: false,
  });

  /**
   * Id of the selected feature of the list
   */
  public selectedFeatureId = 0;

  /**
   * Combined list of feature selected with interaction and wms feature info
   */
  public featureList: Feature[] = [];

  /**
   * Level of zoom when select "Vai al punto" button.
   * Empirically choosen for the base layer and wms visibility
   */
  private featureZoomLevel: number = Constants.zoomLevel;

  /**
   * Regular expression to check url into feature attribute
   */
  private urlRegExp = new RegExp(/(https?:\/\/(?:www\.|(?!www))[a-zA-Z0-9][a-zA-Z0-9-]+[a-zA-Z0-9]\.[^\s]{2,}|www\.[a-zA-Z0-9][a-zA-Z0-9-]+[a-zA-Z0-9]\.[^\s]{2,}|https?:\/\/(?:www\.|(?!www))[a-zA-Z0-9]+\.[^\s]{2,}|www\.[a-zA-Z0-9]+\.[^\s]{2,})/);

  constructor(
    private identifyService: identifyService,
  ) {
  }


  ngAfterViewInit(): void {
    this.createOverlay();

  }

  ngOnChanges(changes: SimpleChanges): void {
    if(!changes) return;

    if(!changes['selectedFeatureList'].currentValue) return;

    if(changes['selectedFeatureList'].currentValue.length  === 0) {
      this.popupOverlay.setPosition(undefined);
      return
    }

    this.featureList = this.featureList.concat(this.selectedFeatureList);

    if(this.featureList.length === 0) return;

    const firstFeature = this.featureList[0] as Feature<any>;

    const coord = firstFeature.getGeometry()?.coordinate ?? firstFeature.getGeometry()?.flatCoordinates;

    if(!coord) return;

    this.setOverlayPosition(coord)
  }

  /**
   * Retrieve wms feature, only for wms querable, at determinated coordinate of cursor click
   * @param coordinate
   */
  private getWmsFeatureInfo(coordinate: number[]) {
    const listOfUrl: any = {};
    this.olWmsList.forEach(wms => {
      const layersName = wms.getSource()?.getParams()['LAYERS'];
      const mapResolution = this.map.getView().getResolution();

      if(!wms.getProperties()['querable']) return;

      const url = wms.getSource()?.getFeatureInfoUrl(coordinate, mapResolution ? mapResolution : 10, this.map.getView().getProjection(), {INFO_FORMAT: 'application/geojson'});
      if(url) {
        listOfUrl[layersName]= this.identifyService.getFeatureInfo(url);
      }

    });

    forkJoin(listOfUrl).subscribe({
      next: (responseList: any) => {
        Object.keys(responseList).forEach((layerName: string) => {
          if(!responseList[layerName]) return;

          const features = new GeoJSON().readFeatures(responseList[layerName]);
          features.forEach((f, i) => {
            // check if there is layerName for that feature and add it to feature
            if(responseList[layerName].features[i].layerName) {
              f.set('layerName', responseList[layerName].features[i].layerName)
            } else {
              // if not exist add layer name from dataset
              f.set('layerName', layerName);
            }
          })
          this.featureList = this.featureList.concat(features);
        })
      },
      // enter in complete also if forkJoin has empty list of url
      complete: () => {
        // Return to parent selected feature list
        this.setOverlayPosition(coordinate);

        this.identifiedListEmit.emit(this.featureList);
      }
    })

  }

  /**
   * Create popup overlay, set the right element and add it to map
   */
  private createOverlay() {
    this.popupOverlay = new Overlay({
      element: document.getElementById('popup') ?? undefined,
      autoPan: {
        animation: {
          duration: 250,
        },
      },
      insertFirst: false,
    });
    this.map.addOverlay(this.popupOverlay);
    this.listenOnMapClick();
  }

  /**
   * List event 'singleclick' of the map
   */
  private listenOnMapClick() {
    this.map.on('singleclick', (event) => {
      this.featureList = [];
      this.clearSelectedFeatureEmit.emit();
      this.getWmsFeatureInfo(event.coordinate);
    });
  }

  /**
   * Change position of popup
   * @param coordinate
   */
  private setOverlayPosition(coordinate: number[]) {
    if(this.featureList.length ===  0) return;

    this.popupOverlay.setPosition(coordinate);
  }

  /**
   * Close popup to set position to undefined
   */
  public closePopup() {
    this.selectedFeatureId = 0;
    this.popupOverlay.setPosition(undefined);
    this.clearSelectedFeatureEmit.emit();
  }

  /**
   * Zoom to the selected feature and move popup on the feature
   * @param feature
   */
  public goToFeature(feature: Feature<any>) {
    const coord = feature.getGeometry().coordinate ?? feature.getGeometry().flatCoordinates;
    this.setOverlayPosition(coord);
    const zoom = this.map.getView().getZoom();

    if(!zoom) return;

    // fixed for the base layer and wms visibility when developing the component
    this.map.getView().fit(feature.getGeometry(), {maxZoom: zoom < this.featureZoomLevel ? this.featureZoomLevel: zoom});

    this.selectedIdentifyPointEmit.emit(feature);
  }

  /**
   * Check if string is a url and return boolen
   * @param url
   * @returns
   */
  public checkIfIsUrl(url: string): boolean {
    return this.urlRegExp.test(url);
  }

  getProvinciaBySiglaProvincia(siglaProvincia: string) {
    let provArr;
    let provincia;
    if (localStorage.ComuniEstesi) provArr = JSON.parse(localStorage.ComuniEstesi);
    if (provArr) provincia = provArr.find(elem => elem.siglaProvincia === siglaProvincia);
    return provincia ? provincia.provincia : "";
  }
}

