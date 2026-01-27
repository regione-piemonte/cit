import { PointStyle } from "./point-style.model";

export interface GeolocationConfI {
    /**
     * Show or hide geolocation button
     */
    visible?: boolean;
    /**
     * Icon to show on button of geolocation when it is enable
     */
    iconGeoEnaled?: string;
    /**
     * Icon to show on button of geolocation when it is disabled
     */
    iconGeoDisabled?: string;
    /**
     * Style of geolocation point on map
     */
    pointStyle?: PointStyle;
    /**
     * Enable zoom to geolocation when active it
     */
    enableZoomTo?: boolean;
}

export class GeolocationConf {
    /**
     * Show or hide geolocation button
     * @default true
     */
    visible: boolean;
    /**
     * Icon to show on button of geolocation when it is enable
     * @default 'assets/target_full.svg'
     */
    iconGeoEnaled: string;
    /**
     * Icon to show on button of geolocation when it is disabled
     * @default 'assets/target_empty.svg'
     */
    iconGeoDisabled: string;
    /**
     * Style of geolocation point on map
     * @default yellow with fill color yellow opacity 50%
     */
    pointStyle: PointStyle;

    /**
     * Enable zoom to geolocation when active it
     * @default false
     */
    enableZoomTo: boolean;

    constructor(geolocationConf?: GeolocationConfI) {
        this.visible = geolocationConf?.visible !== undefined ? geolocationConf.visible : true;
        this.iconGeoEnaled = geolocationConf?.iconGeoEnaled ? geolocationConf.iconGeoEnaled : 'assets/target_full.svg';
        this.iconGeoDisabled = geolocationConf?.iconGeoDisabled ? geolocationConf.iconGeoDisabled : 'assets/target_empty.svg';
        this.pointStyle = geolocationConf?.pointStyle ? geolocationConf.pointStyle : new PointStyle({featureBorderColor: 'yellow', fillColor: 'rgba(255,255,0,0.5)'});
        this.enableZoomTo = geolocationConf?.enableZoomTo ? geolocationConf.enableZoomTo : false;
    }
}
