import { CodiceDescrizione } from "./codice-descrizione";
import { DatiCGModel } from "./dati-cg-model";
import { DatiGFModel } from "./dati-gf.-model";
import { DatiGTModel } from "./dati-gt-model";
import { DatiSCModel } from "./dati-sc-model";
import { DatoControlloModel } from "./dato-controllo-model";

export class DatiControlloModel {
    controlli: DatoControlloModel[];
    datiGT: DatiGTModel[];
    datiGF: DatiGFModel[];
    datiSC: DatiSCModel[];
    datiCG: DatiCGModel[];
    stelle: CodiceDescrizione[];
    apparecchiature: CodiceDescrizione[];
    ariaCombustibile: CodiceDescrizione[];
    controlloAria: CodiceDescrizione[];
    unitaMisura: CodiceDescrizione[];
    fluido: CodiceDescrizione[];
}
