import { Component, EventEmitter, Input, OnChanges, OnInit, Output, SimpleChanges } from '@angular/core';
import { Feature, Map, View } from 'ol';
import SelectCluster from 'ol-ext/interaction/SelectCluster';
import AnimatedCluster from 'ol-ext/layer/AnimatedCluster';
import { defaults as defaultControls } from "ol/control";
import { extend, Extent, getCenter, getTopLeft, getWidth } from 'ol/extent';
import GeoJSON from 'ol/format/GeoJSON';
import { Point, SimpleGeometry } from 'ol/geom';
import TileLayer from "ol/layer/Tile";
import { get as getProjection, Projection as olProjection } from "ol/proj";
import { register } from 'ol/proj/proj4.js';
import { Cluster, OSM, TileWMS, WMTS } from "ol/source";
import VectorSource from 'ol/source/Vector';
import WMTSTileGrid from 'ol/tilegrid/WMTS';
import proj4 from 'proj4';
import { Dataset } from '../models/dataset.model';
import { LayerI, Layers } from '../models/layer.model';
import { MapConfig } from '../models/map-config.model';
import { WMSLayer } from '../models/wms-layer.model';
import { Constants } from './utils/constants';
import { FeatureStyle } from './utils/feature-style';


@Component({
  selector: 'app-map',
  templateUrl: './map.component.html',
  styleUrls: ['./map.component.scss']
})
export class MapComponent implements OnInit, OnChanges {
  /**
   * Configuration of map, if empty use default values set to MapConfig model
   */
   @Input()
   public options: MapConfig = new MapConfig();

   /**
    * Datasets of point to show in map
    */
   @Input()
   public datasets: Dataset[] = [];

   /**
    * Configured base layer to show in map and in switch layer, if enabled
    */
   @Input()
   public baseLayer!: Layers;

   /**
    * Configured WMS layer to show in map
    */
   @Input()
   public wmsList: WMSLayer[] = [];

   /**
    * Go to a specific point, section or geoJson in map
    * Available input is extent, coordinate or GeoJson
    * Extent | [number,number] = Extent (called also Bbox) and coordinate must have epsg same as map
    * {} = GeoJson must have EPSG:4326
    */
   @Input()
   public zoomTo: Extent | [number,number] | {} = [];

  /**
   * Event to pass identify list to parent
   */
   @Output()
   identifiedListEmit: EventEmitter<any[]> = new EventEmitter();

  /**
   * Event to pass feature when click on 'Vai al punto' on identify
   */
   @Output()
   selectedIdentifyPointEmit: EventEmitter<any> = new EventEmitter();

  /**
   * Define EPSG:32632
   */
  private projection = Constants.mapProjection;

  /**
   * Piemonte region extent.
   * Expanded extent for allowing centering on 1080p 16:9 wide screen monitor
   */
  private extentRegion: number[] = Constants.extentRegion;

  /**
   * Map variable
   */
  public map: Map = new Map({});

  /**
   * View of the map default settings
   */
  private view: View;

  /**
   * Wms layer list to use easily in identify
   */
  public olWmsList: TileLayer<TileWMS>[] = [];

  /**
   * list of feature to show in tooltip
   */
  public selectedFeatureList: Feature[] = [];

  /**
   * List of select cluster interaction
   */
  private selectClusterInteractionList: SelectCluster[] = [];

  /**
   * Projection of GeoJson used to convert correctly for map projection
   */
  private geoJsonProjection = Constants.geoJsonProjection;

  /**
   * Level of zoom used when zoom to a point, extent (bbox) or geojson
   * Empirically choosen for base layer and wms visibility
   */
  private zoomLevel = Constants.zoomLevel;

  constructor(
    private style: FeatureStyle,
  ) {
    // register EPSG:32632
    proj4.defs(this.projection.code, this.projection.def);
    register(proj4);
    // Set extent of the projection
    if(this.projection.extent) {
      getProjection(this.projection.code)?.setExtent(this.projection.extent)
    }

    // Create view with EPSG:32632
    this.view = new View({
      projection: new olProjection(this.projection),
      center: getCenter(this.extentRegion),
      // if extent is set user can't go out of this extent
      extent: this.extentRegion,
      rotation: 0,
      zoom: 8,
      // Padding from extent to map limit to show all feature correctly
      padding: [20,20,20,20]
    })
  }

  ngOnInit(): void {
    this.initMap();
  }

  ngOnChanges(changes: SimpleChanges): void {
    if(!changes) return;

    if(!changes['zoomTo'].currentValue) return;

    this.centerOn(changes['zoomTo'].currentValue);
  }

  /**
   * initialize map and the default buttons on map
   */
  private initMap() {

    // set control map
    const mapControl: any[] = [
      //new ScaleLine(),
    ];
    // Show full screen button only if specified
    /*if(!!this.options.fullScreen) {
      mapControl.push(new FullScreen());
    }

    if(!!this.options.switchBaseLayer) {
      mapControl.push(new LayerSwitcherImage())
    }*/

    this.map = new Map({
      // id of the html div that will contain canva map
      target: 'map',
      // layers: this.getBaseLayersList(),
      layers: [
        new TileLayer(
          {source: new OSM}
        )
      ],
      view: this.view,
      // added defaults map control
      controls: defaultControls().extend(mapControl),
      // overlays: [this.popupOverlay]
    });
    // @ts-ignore
    // if(this.options.geolocationConfig.visible) new GeolocationComponent(this.map, this.options.geolocationConfig, this.style);
    this.createWMSLayer();
    this.createClusterLayers();
  }

  /**
   * Create base layer and return list of Tile layers
   * @returns
   */
  private getBaseLayersList(): TileLayer<WMTS>[] {
    const olLayers: any[] = [];

    this.baseLayer.layers.forEach(l => {
        if(!l.baseLayer) return;

        const baseLayer = new TileLayer({
          source: new WMTS({
            url: l.sourceOptions.url,
            matrixSet: l.sourceOptions.matrixSet,
            layer: l.sourceOptions.layer,
            style: l.sourceOptions.style,
            tileGrid: this.getWMTSTileGrid(l),
            format: l.sourceOptions.format,
            crossOrigin: l.sourceOptions.crossOrigin,
            transition: 0,
          }),
          visible: l.visible,
          maxZoom: l.sourceOptions.maxZoom,
          // Set to 0 to be always the bottom layer
          zIndex: 0,
          properties: {
            displayInLayerSwitcher: true,
            baseLayer: l.baseLayer,
            title: l.title,
            preview: `${l.sourceOptions.url}?layer=${l.sourceOptions.layer}&style=default&tilematrixset=${l.sourceOptions.matrixSet}&Service=WMTS&Request=GetTile&Version=1.0.0&Format=image/png&TileMatrix=06&TileCol=31&TileRow=32`,
          },
        });
      olLayers.push(baseLayer);
    });
    return olLayers;
  }

  /**
   * Create WMTS Tile Grid
   * @param layer
   * @returns
   */
  private getWMTSTileGrid(layer: LayerI) {
    const projection = getProjection(layer.sourceOptions.projection);
    let projectionExtent!: Extent;

    if(!!projection) projectionExtent = projection.getExtent();

    let size = 0;

    if(!!projectionExtent) size = getWidth(projectionExtent) / 256;

    const resolutions = new Array(19);
    const matrixIds = new Array(19);
    for (let z = 0; z < 19; ++z) {
      resolutions[z] = size / Math.pow(2, z);
      matrixIds[z] = z.toString().replace(/^(\d)$/, "0$1");
    }
    return new WMTSTileGrid({
      origin: getTopLeft(projectionExtent),
      resolutions: resolutions,
      matrixIds: matrixIds,
    });
  }

  /**
   * Create wms layer
   */
  private createWMSLayer() {
    this.wmsList.forEach(l => {
      const source = new TileWMS({
        url: l.url,
        params: {TILED: true, LAYERS: l.layerName}
      });
      const layer = new TileLayer({
        source: source,
        visible: true,
        zIndex: 1,
        properties: {
          querable: l.querable,
          displayInLayerSwitcher: false,
        },
        opacity: l.opacity,
      });
      this.olWmsList.push(layer);
      this.map.addLayer(layer);
    });


  }

  /**
   * Create feature, create layer and set extent on showed feature
   *
   */
  private createClusterLayers() {
    let calcExtent: any = [];
    this.datasets.forEach((dataset, id) => {
      const geoJsonFeature = this.readFeatures(dataset.geojson);
      geoJsonFeature.forEach(g => {
        g.set('layerName', dataset.layerName);
        g.set('zoomTo', true);
      });

      // create vector source and add feature
      const vectorSource = new VectorSource({
        features: geoJsonFeature
      });

      // create cluster and set configuration
      const clusterSource = new Cluster({
        distance: dataset.clusterDistance,
        minDistance: dataset.clusterMinDistance,
        source: vectorSource,
      });

      const styleCache: any = {};

      // create Vector Layer and add the feature
      const layer = new AnimatedCluster({
        animationDuration: 700,
        source: clusterSource,
        zIndex: 2,
        style: (cluster) => {
          const size = cluster.get('features').length;
          let style = styleCache[size];
          if (!style) {
            // size > 1 = cluster
            if(size > 1 ) {
              // if there is multiple point means that is cluster, so retrieve cluster style
              style = this.style.getClusterStyle(dataset.style, size.toString(), size)
            } else {
              // if size is only one, is a feature so retrieve feature style
              style = this.style.getFeatureStyle(dataset.style);
            }
            styleCache[size] = style;
          }
          return style;
        },
        properties: {
          id: id,
          displayInLayerSwitcher: false,
        }
      });

      // If is the first element set the extent to the variable
      if(id === 0) {
        calcExtent = vectorSource.getExtent();
      } else {
        // Extend the extent with new layer extent
        calcExtent = extend(calcExtent, vectorSource.getExtent());
      }

      // add layer to map
      this.map.addLayer(layer);

      this.createSelectCluster(layer, dataset, id);
    });

    // Fit map view with the calculated extent
    if(!this.zoomTo) this.map.getView().fit(calcExtent)
    else this.centerOn(this.zoomTo);
  }

  /**
   * For each cluster layer we need the select interaction
   * @param layer cluster layer which interaction will work
   * @param dataset of the geojson data to use style
   * @param id to set a preper radius to show feature when select cluster
   */
  private createSelectCluster(layer: AnimatedCluster, dataset: Dataset, id: number) {
    const selectClusterInteraction = new SelectCluster({
      layers: [layer],
      multi: true,
      pointRadius: ((id + 1) * 8),
      animate: true,
      selectCluster: false,
      // Style of the expended feature when select cluster
      featureStyle: this.style.getExpandedFeatureStyle(dataset.style),
      // Style of the feature when a single feature is select
      style: this.style.getSelectedFeatureStyle(dataset.style),
      autoClose: false,

    });

    selectClusterInteraction.on('select', (event) => {
      // if select one cluster with one feature show tooltip
      if(event.selected.length === 0) return;

      if(event.selected[0].get('features').length === 0 || event.selected[0].get('features').length > 1) return;

      const feature = event.selected[0].get('features')[0];
      // this assegnation will fire ngOnChanges on identify component
      this.selectedFeatureList = [...this.selectedFeatureList, feature];
    })

    this.selectClusterInteractionList.push(selectClusterInteraction)
    this.map.addInteraction(selectClusterInteraction);
  }

  /**
   * read features and convert projection from EPSG:4326, feature projection, to EPSG:3857, map projection
   * @param feature geoJson object
   * @returns list of Feature
   */
  private readFeatures(feature: {}) {
      return new GeoJSON({dataProjection: this.geoJsonProjection, featureProjection: this.projection.code}).readFeatures(feature);
  }

  /**
   * Clear selected feature list
   */
  public onClearSelectedFeature() {
    this.selectedFeatureList = [];
    this.selectClusterInteractionList.forEach(interaction => {
      interaction.clear();
    })
  }

  /**
   * Convert selected feature from identify to GeoJson and send list to parent
   * @param feature
   */
  public convertSelectedFeatureToGeoJson(feature: Feature[]) {
    const geojsonList: any[]= [];
    feature.forEach(f => {
      geojsonList.push(JSON.parse(new GeoJSON({dataProjection: this.geoJsonProjection, featureProjection: this.projection.code}).writeFeature(f)));
    });
    this.identifiedListEmit.emit(geojsonList);
  }

  /**
   * Emit to father the geoJson value of passed feature from identify
   * @param feature
   */
  public selectedIdentifyPoint(feature: Feature) {
    this.selectedIdentifyPointEmit.emit(JSON.parse(new GeoJSON({dataProjection: this.geoJsonProjection, featureProjection: this.projection.code}).writeFeature(feature)));
  }

  /**
   * Zoom somewhere on map using geometry o extent
   */
  private zoomToGeometryOrExtent(geometryOrExtent: Extent | SimpleGeometry) {
    this.map.getView().fit(geometryOrExtent, {maxZoom: this.zoomLevel});
  }

  /**
   * Check wich type of value want to zoom to and zoom to it
   * @param value
   */
  private centerOn(value: Extent | [number,number] | {}) {
    // Available are coordinare, geoJson or extent
    if(value instanceof Array && value.length === 2) {

      const geom = new Point(value);
      this.zoomToGeometryOrExtent(geom)

    } else if(value instanceof Array && value.length === 4) {

      this.zoomToGeometryOrExtent(value);

    } else if(value instanceof Object) {

      try {
        const features: Feature<any>[] = this.readFeatures(value);
        let ext = features[0].getGeometry().getExtent();
        features.forEach(f => {
          ext = extend(ext, f.getGeometry().getExtent());
        })
        this.zoomToGeometryOrExtent(ext);
      } catch(e) {
        console.error('[ERROR] Error to convert object to geojson');
      }
    } else {
      console.error('[ERROR] Object passed is not correct');
    }
  }

}
