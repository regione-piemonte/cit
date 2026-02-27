export class DatiToken {

  idPersonaGiuridica: string;
  denominazione: string;
  codiceFiscale: string;
  siglaRea: string;
  numeroRea: number;
  token: string;
  dtCreazioneToken: string;
  dtScadenzaToken: string;

  constructor(idPersonaGiuridica: string, 
              denominazione: string,
              codiceFiscale: string,
              siglaRea: string,
              numeroRea: number,
              token: string,
              dtCreazioneToken: string,
              dtScadenzaToken: string) 
  {
    this.idPersonaGiuridica = idPersonaGiuridica;
    this.denominazione = denominazione;
    this.codiceFiscale = codiceFiscale;
    this.siglaRea = siglaRea;
    this.numeroRea = numeroRea;
    this.token = token;
    this.dtCreazioneToken = dtCreazioneToken;
    this.dtScadenzaToken = dtScadenzaToken;
  }

}
