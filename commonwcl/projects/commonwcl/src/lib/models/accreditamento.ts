import { DatiDelega } from "./dati-delega";
import { DatiImpresa } from "./dati-impresa";
import { DatiIncarico } from "./dati-incarico";
import { Persona } from "./persona";

export interface Accreditamento {
    persona: Persona;
    datiImpresaList: DatiImpresa[];
    datiDelegaList: DatiDelega[];
    datiIncaricoList: DatiIncarico[];
}
