export class RuoloPA{
    ruoloPA: string;
    idRuoloPA:number;
    istatAbilitazione:string;
    descrAbilitazione:string;


  constructor(
    ruoloPA: string, 
    idRuoloPA: number, 
    istatAbilitazione: string, 
    descrAbilitazione: string
) {
    this.ruoloPA = ruoloPA
    this.idRuoloPA = idRuoloPA
    this.istatAbilitazione = istatAbilitazione
    this.descrAbilitazione = descrAbilitazione
  }
}