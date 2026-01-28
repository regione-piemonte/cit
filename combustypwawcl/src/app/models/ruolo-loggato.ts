export class RuoloLoggato {
  ruolo: string | null;
  piva: string | null;
  siglaRea: string | null;
  numeroRea: string | null;
  denominazione: string | null;
  dataCessazione: Date | null;
  idStato: number | null;
  descStato: string | null;
  istatAbilitazione: string | null;
  descrAbilitazione: string | null;
  idPersonaGiuridica: number | null;
  isCat: boolean | null;



  constructor(
    ruolo: string | null,
    piva: string | null,
    siglaRea: string | null,
    numeroRea: string | null,
    denominazione: string | null,
    dataCessazione: Date | null,
    idStato: number | null,
    descStato: string | null,
    istatAbilitazione: string | null,
    descrAbilitazione: string | null,
    idPersonaGiuridica: number | null
  ) {
    this.ruolo = ruolo
    this.piva = piva
    this.siglaRea = siglaRea
    this.numeroRea = numeroRea
    this.denominazione = denominazione
    this.dataCessazione = dataCessazione
    this.idStato = idStato
    this.descStato = descStato
    this.istatAbilitazione = istatAbilitazione
    this.descrAbilitazione = descrAbilitazione
    this.idPersonaGiuridica = idPersonaGiuridica
  }

}