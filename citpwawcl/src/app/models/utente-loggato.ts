import { PFLoggato } from "./pf-loggato";
import { RuoloLoggato } from "./ruolo-loggato";

export class UtenteLoggato{
    pfLoggato:PFLoggato;
    ruoloLoggato:RuoloLoggato;


  constructor(pfLoggato: PFLoggato, ruoloLoggato: RuoloLoggato) {
    this.pfLoggato = pfLoggato
    this.ruoloLoggato = ruoloLoggato
  }

}