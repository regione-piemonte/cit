export class LoccsiFeature {
    type: string;
    geometry: {
        type: string,
        coordinates: number[]
    };
    properties: {
        codiceIstat: string,
        localita: string,
        cap: string,
        comune: string,
        loccsiLabel: string,
        civicoNum: string,
        pv: string,
        nomeVia: string,
        civicoSub: string,
        preposizione: string,
        tipoVia: string
        descProvincia: string,
        siglaProvincia: string,
        circoscrizione: string
    };
    id: string;
}