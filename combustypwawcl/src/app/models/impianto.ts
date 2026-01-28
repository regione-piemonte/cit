export class Impianto {
    cf3Responsabile:string;
    cfResponsabile:string;
    civico:string;
    codiceImpianto:number;
    denom3Responsabile:string;
    denomResponsabile:string;
    descComune:string;
    dtAssegnazione:string;
    dtDismissione:string;
    dtUltAggLibretto:string;
    indirizzo:string;
    motivoDisimissione:string;
    siglaProv:string;
    stato:string;
    uidIndexLibretto:string;
    idPfResponsabile: string;
    idPgResponsabile: string;


  constructor(
    cf3Responsabile: string, 
    cfResponsabile: string, 
    civico: string, 
    codiceImpianto: number, 
    denom3Responsabile: string, 
    denomResponsabile: string, 
    descComune: string, 
    dtAssegnazione: string, 
    dtDismissione: string, 
    dtUltAggLibretto: string, 
    indirizzo: string, 
    motivoDisimissione: string, 
    siglaProv: string, 
    stato: string, 
    uidIndexLibretto: string,
    idPfResponsabile: string,
    idPgResponsabile: string
) {
    this.cf3Responsabile = cf3Responsabile
    this.cfResponsabile = cfResponsabile
    this.civico = civico
    this.codiceImpianto = codiceImpianto
    this.denom3Responsabile = denom3Responsabile
    this.denomResponsabile = denomResponsabile
    this.descComune = descComune
    this.dtAssegnazione = dtAssegnazione
    this.dtDismissione = dtDismissione
    this.dtUltAggLibretto = dtUltAggLibretto
    this.indirizzo = indirizzo
    this.motivoDisimissione = motivoDisimissione
    this.siglaProv = siglaProv
    this.stato = stato
    this.uidIndexLibretto = uidIndexLibretto
    this.idPfResponsabile = idPfResponsabile
    this.idPgResponsabile = idPgResponsabile
  }

  }