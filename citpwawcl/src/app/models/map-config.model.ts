import { GeolocationConf, GeolocationConfI } from "./geolocation-config.model";

export interface MapConfigI {
    /**
     * Show or hide full screen button on map
     */
    fullScreen?: boolean;

    /**
     * Style of geolocation point
     */
    geolocationConfig?: GeolocationConfI;

    /**
     * Show or hide switch layer on map
     */
    switchBaseLayer?: boolean;
}

export class MapConfig {

    /**
     * Show or hide full screen button on map
     * @default false
     */
    fullScreen: boolean;

    /**
     * Style of geolocation point
     */
    geolocationConfig: GeolocationConf;

    /**
     * Show or hide switch layer on map
     * @default false
     */
    switchBaseLayer?: boolean;

    constructor(conf?: MapConfigI) {
        this.fullScreen = conf?.fullScreen ? conf.fullScreen : false;
        this.geolocationConfig = new GeolocationConf(conf?.geolocationConfig);
        this.switchBaseLayer = conf?.switchBaseLayer ? conf.switchBaseLayer : false;
    }

}
