export class Esito {
  esito: string;
  descrizioneEsito: string;
  codiceImpianto: string;
  idAllegatoNew: number;


  constructor(esito: string, descrizioneEsito: string, codiceImpianto: string) {
    this.esito = esito
    this.descrizioneEsito = descrizioneEsito
    this.codiceImpianto = codiceImpianto
  }
}