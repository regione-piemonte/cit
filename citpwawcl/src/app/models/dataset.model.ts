import { PointStyle } from "./point-style.model";

interface DatasetI {
    /**
     * Style of the point on map
     */
    style: PointStyle;

    /**
     * @required
     * Geojson of the point
     */
    geojson: {};

    /**
     * Name of layer used in identify when click on a point
     */
    layerName?: string;

    /**
     * The distance within which features will be clustered together
     */
    clusterDistance?: number;

    /**
     * The minimum distance between clusters. Can't be larger than the configured distance.
     */
    clusterMinDistance?: number;
}

export class Dataset {
    /**
     * Style of the point on map
     */
    style: PointStyle;

    /**
     * @required
     * Geojson of the point
     */
    geojson: {};

    /**
     * Name of layer used in identify when click on a point
     */
    layerName?: string;

    /**
     * The distance within which features will be clustered together
     * @default 10
     */
    clusterDistance?: number;

    /**
     * The minimum distance between clusters. Can't be larger than the configured distance.
     * @default 0
     */
    clusterMinDistance?: number;

    constructor(datasetConf: DatasetI) {
        this.style = new PointStyle(datasetConf.style);
        this.geojson = datasetConf.geojson;
        this.layerName = datasetConf.layerName;
        this.clusterDistance = datasetConf.clusterDistance ? datasetConf.clusterDistance : 10;
        this.clusterMinDistance = datasetConf.clusterMinDistance? datasetConf.clusterMinDistance : 0;
    }

}
