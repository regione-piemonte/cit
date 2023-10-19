import { LoccsiFeature } from "./loccsi-feature";

export class LoccsiModel{
    id: number;
    name: string;
    description: string;
    catalogs: string [];
    featureCollection: {
        type: string,
        features: LoccsiFeature[],
        crs: {
            type: string;
            properties: {
                name: string;
            }
        },
        bbox: number[]
    }
}