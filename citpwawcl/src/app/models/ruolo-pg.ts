export class RuoloPG {


  piva: string
  siglaREA: string
  numeroREA: string
  denominazione: string
  dataCessazione: Date
  ruoloPG: string
  idStato: number
  descStato: string
  idPersonaGiuridica: number


  constructor(
    piva: string,
    siglaREA: string,
    numeroREA: string,
    denominazione: string,
    dataCessazione: Date,
    ruoloPG: string,
    idStato: number,
    descStato: string,
    idPersonaGiuridica: number
  ) {
    this.piva = piva
    this.siglaREA = siglaREA
    this.numeroREA = numeroREA
    this.denominazione = denominazione
    this.dataCessazione = dataCessazione
    this.ruoloPG = ruoloPG
    this.idStato = idStato
    this.descStato = descStato
    this.idPersonaGiuridica = idPersonaGiuridica
  }

}