import { Injectable } from '@angular/core';
import { Feature, Geolocation, Map } from 'ol';
import { Control } from "ol/control";
import { Point } from 'ol/geom';
import VectorLayer from 'ol/layer/Vector';
import VectorSource from 'ol/source/Vector';
import { GeolocationConf } from 'src/app/models/geolocation-config.model';
import { Constants } from '../utils/constants';
import { FeatureStyle } from '../utils/feature-style';

/**
 * Added dinamically to map without html file
 */
@Injectable()
export class GeolocationComponent {

  /**
   * Geolocation variable
   */
  private geolocation: Geolocation;

  /**
   * Level of zoom when zoom on geolocation point.
   * Empirically choosen for base layer and wms visibility
   */
  private geolocationZoomLevel: number = Constants.zoomLevel;

  private geolocationFeature: Feature<any> = new Feature();

  constructor(
    private map: Map,
    private geolocOptions: GeolocationConf,
    private style: FeatureStyle,

  ) {
     // Create geolocation
     this.geolocation = new Geolocation({
      // enableHighAccuracy must be set to true to have the heading value.
      trackingOptions: {
        enableHighAccuracy: true,
      },
      // set same projection of map
      projection: this.map.getView().getProjection(),
      // enable tracking
      // tracking: true
    });
    this.createGeolocation();
  }

  /**
   * Create geolocation and layer where show the feature of location
   */
  private createGeolocation() {

    this.listeOnGeolocationEvents();

    // create Vector Layer and adding the feature
    const layerGeolocation = new VectorLayer({
      source: new VectorSource({features: [this.geolocationFeature]}),
      style: this.style.getFeatureStyle(this.geolocOptions.pointStyle),
      properties: {
        displayInLayerSwitcher: false,
      }
    });

    layerGeolocation.set('id', 'geolocation');

    this.map.addLayer(layerGeolocation);

    this.createGeolocationControl();

  }

  /**
   * Listen on geolocation events:
   * change:tracking => fired when enable or disable geolocation
   * change:position => fired when position of geolocation change
   * error => fired when an error occur to geolocation
   */
  private listeOnGeolocationEvents() {
    let goToLocation = this.geolocOptions.enableZoomTo;

    // set position of geolocation used when change tracking and position
    const setGeoPosition = () => {
      const coordinate = this.geolocation.getPosition();

      if(coordinate === undefined) return;

      this.geolocationFeature.setGeometry(new Point(coordinate));

      if(goToLocation === false || this.geolocOptions.enableZoomTo === false) return;

      this.zoomToGeometry(this.geolocationFeature.getGeometry());
      goToLocation = false;
    }

    this.geolocation.on('change:tracking', tracking => {
      goToLocation = tracking.oldValue === false;

      setGeoPosition();
    });

    this.geolocation.on('change:position', (geo) => {
      setGeoPosition();
    });

    // handle geolocation error and disable geolocation
    this.geolocation.on('error', (error) => {
      alert(error.message);
      this.disableGeolocation();
    });
  }

  /**
   * Create map control and add to map
   */
  private createGeolocationControl() {
    const button = document.createElement('button');
    // Set image into button
    button.innerHTML = `<img src="${this.geolocOptions.iconGeoDisabled}" alt="" style="width:1em; height: 1em"/>`;
    button.title = 'Abilita geolocalizzazione';
    button.id = 'geolocation';

    const element = document.createElement('div');
    element.className = 'ol-unselectable ol-control';
    element.style.marginLeft = '0.5em';
    // calc is = margin-top + button height * 2 + margin-bottom
    element.style.top = 'calc(0.5em + (24px * 2) + 0.5em)';
    element.id = 'geolocation-container';
    element.appendChild(button);

    button.addEventListener('click', this.changeGeolocation.bind(this), false);

    this.map.addControl(
      new Control({
        element: element,
        // target
      })
    );


  }

  /**
   *  When click on button of geolocation change button image and enable geolocation
   */
  private changeGeolocation() {
    if(!this.geolocation.getTracking()) this.geolocation.setTracking(true);
    const geolocationButton = document.getElementById('geolocation');
    const geolocationLayer = this.map.getAllLayers().find(l => l.get('id') == 'geolocation');
    if(geolocationButton) {
      this.setGeolocationButton(this.geolocation.getTracking());
      if(!!this.geolocation.getTracking()) {
        geolocationLayer?.setVisible(true);
      } else {
        geolocationLayer?.setVisible(false);
      }
    }
  }

  /**
   * Disable geolocation
   */
  private disableGeolocation() {
    this.geolocation.setTracking(false);
    this.setGeolocationButton(false);
  }

  /**
   * Set icon and tooltip label if tracking is enable or disable
   * @param locationEnabled
   */
  private setGeolocationButton(locationEnabled: boolean) {
    const geolocationButton = document.getElementById('geolocation');
    if(!!geolocationButton) {
      if(!!locationEnabled) {
        geolocationButton.innerHTML = `<img src="${this.geolocOptions.iconGeoEnaled}" alt="" style="width:1em; height: 1em"/>`;

        if(this.geolocOptions.enableZoomTo) {
          geolocationButton.title = 'Riposiziona mappa su geolocalizzazione';
          this.getGeolocPointAndZoomToIt();
        } else  {
          geolocationButton.title = 'Abilita geolocalizzazione';
        }

      } else {
        geolocationButton.innerHTML = `<img src="${this.geolocOptions.iconGeoDisabled}" alt="" style="width:1em; height: 1em"/>`;
        geolocationButton.title = 'Abilita geolocalizzazione';
      }
    }
  }

  /**
   * Retrieve geolocation point from geolocation layer and zoom to it
   * @returns
   */
  private getGeolocPointAndZoomToIt() {
    if(!this.geolocOptions.enableZoomTo) return;
    const geolocationLayer = this.map.getAllLayers().find(l => l.get('id') == 'geolocation') as VectorLayer<VectorSource<any>>;
    const feat = geolocationLayer?.getSource()?.getFeatures()[0];

    if (!feat || !feat.getGeometry()) return;

    this.zoomToGeometry(feat.getGeometry());
  }

  /**
   * Zoom map to geometry
   * @param geometry
   */
  private zoomToGeometry(geometry: any) {
    this.map.getView()?.fit(geometry, {maxZoom: this.geolocationZoomLevel});
  }

}
