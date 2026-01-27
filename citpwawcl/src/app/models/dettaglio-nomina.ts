import { DatiAffidamento } from "./dati-affidamento";
import { Autodichiarazione } from "./dati-autodichiarazione";
import { DatiContratto } from "./dati-contratto";
import { DatiImpianto } from "./dati-impianto";
import { DatiImpresa } from "./dati-impresa";
import { Persona } from "./persona";

export class DettaglioNomina {
    datiImpresa: Array<DatiImpresa>;
    datiContratto: Array<DatiContratto>;
    datiImpianto: Array<DatiImpianto>;
    persona: Array<Persona>;
    datiAffidamento: Array<DatiAffidamento>;
    autodichiarazione: Array<Autodichiarazione>;
}
