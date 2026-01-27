import { Projection } from '../../models/projection.model';

export class Constants {
    /**
     * Empirically choosen for the base layer and wms visibility
     */
    static zoomLevel = 17;

    /**
     * Definition of geoJson projection
     */
    static geoJsonProjection = 'EPSG:4326';

    /**
     * Definition of map projection
     */
    static mapProjection: Projection = {
        code: "EPSG:32632",
        def: "+proj=utm +zone=32 +datum=WGS84 +units=m +no_defs +type=crs",
        // trovato sull'altro branch
        extent: [
            -10198294.6545,
            -5596920.6825,
            11389716.6914,
            15991090.6634
        ]
    };

    /**
     * Piemonte region extent.
     * Expanded extent for allowing centering on 1080p 16:9 wide screen monitor
     */
    static extentRegion: number[] = [-238573, 4673179, 1103677, 5379829];
}
