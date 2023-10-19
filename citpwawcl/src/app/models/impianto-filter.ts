export class ImpiantoFilter {
    codiceImpianto: string;
    statoImpianto: string;
    cfResp: string;
    cfProp: string;
    cf3Resp: string
    pod: string;
    pdr: string;
    coordX: string;
    coordY: string;
    distanza: string;

    constructor(codiceImpianto: string, statoImpianto: string, cfResp: string, cfProp: string, cf3Resp: string,
        pod: string, pdr: string, coordX: string, coordY: string, distanza: string) {
        this.codiceImpianto = codiceImpianto;
        this.statoImpianto = statoImpianto;
        this.cf3Resp = cf3Resp;
        this.cfProp = cfProp;
        this.cfResp = cfResp;
        this.pod = pod;
        this.pdr = pdr;
        this.coordX = coordX;
        this.coordY = coordY;
        this.distanza = distanza;
    }
}