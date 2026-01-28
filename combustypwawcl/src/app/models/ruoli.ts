import { PFLoggato } from "./pf-loggato";
import { RuoloPA } from "./ruolo-pa";
import { RuoloPF } from "./ruolo-pf";
import { RuoloPG } from "./ruolo-pg";

export class Ruoli {

    pfLoggato: PFLoggato;

    ruoliPF: RuoloPF[];

    ruoliPG: RuoloPG[];

    ruoliPA: RuoloPA[];

    constructor(
        pfLoggato: PFLoggato,
        ruoliPF: RuoloPF[],
        ruoliPG: RuoloPG[],
        ruoliPA: RuoloPA[]
    ) {
        this.pfLoggato = pfLoggato
        this.ruoliPF = ruoliPF
        this.ruoliPG = ruoliPG
        this.ruoliPA = ruoliPA
    }

}
