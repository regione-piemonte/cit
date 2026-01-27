export interface LayerI {
    /**
     * Visibility of layer
     */
    visible: boolean,
    /**
     * Layer is baselayer
     */
    baseLayer: boolean,
    /**
     * configuration to create layer
     */
    sourceOptions: {
        /**
         * maximum zoom for layer visibility beyond which the layer is no longer visible
         */
        maxZoom: number,
        /**
         * response format to render the layer (e.g. "image/png")
         */
        format: string,
        /**
         * leave "anonymous" at the moment
         */
        crossOrigin: string,
        /**
         * name of the layer style which can be found in the GetCapabilities of the service (e.g. "default")
         */
        style: string,
        /**
         * reference system (e.g. 'EPSG:32632')
         */
        projection: string,
        /**
         * url of the service where the layer is located
         */
        url: string,
        /**
         * name of the layer to use to retrieve the layer
         */
        layer: string,
        /**
         * matrix set of the layer specified by the `layer` parameter, found in the GetCapabilities of the service
         */
        matrixSet: string,
    }

    /**
     * Title of layer. Showed in switch layer
     */
    title: string;
}

export class Layers {
    layers: LayerI[] = [];
}