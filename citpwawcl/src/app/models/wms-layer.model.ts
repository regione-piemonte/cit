export class WMSLayer {
    /**
     * @required
     * url of wms service
     */
    url: string;
    /**
     * @required
     * list of name of the layer you want to see form the source url
     */
    layerName: string[];
    /**
     * if identify is enable for this layer
     * @default true
     */
    querable: boolean;
    /**
     * chenge opacity of the layer 
     * 0 = opacity
     * 1 = no opacity
     * @default 0.5
     */
    opacity: number;
    

    constructor(url: string, layerName: string[], querable?: boolean, opacity?: number) {
        this.url = url;
        this.layerName = layerName;
        this.querable = querable ?? true;
        this.opacity = opacity ?? 0.5
    }
}