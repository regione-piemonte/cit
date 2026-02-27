export interface Persona {
    idPersona: number;
    titolo: string;
    tipo: number;
    codiceFiscale: string;
    cognomeDenominazione: string;
    nome: string;
    residenzaEstera: number;
    stradario: number;
    indirizzoSitad: string;
    indirizzoNonTrovato: string;
    istatComune: string;
    comune: string;
    provincia: string;
    siglaProv: string;
    civico: string;
    cap: string;
    statoEstero: string;
    cittaEstero: string;
    indirizzoEstero: string;
    capEstero: string;
    dataInizioResp: Date;
    email: string;
    accreditato: string;
    newsletter: number;
    gdpr: number;
}