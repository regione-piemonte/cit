import { CodiceDescrizione } from "./codice-descrizione";
import { ControlloModel } from "./controllo-model";
import { DatiGTModel } from "./dati-gt-model";

export class RecuperoDatiModel {
    controllo: ControlloModel[];
    xml: any;
    datiGT: DatiGTModel[];
    datiGF: DatiGTModel[];
    datiSC: DatiGTModel[];
    datiCG: DatiGTModel[];
    stelle: CodiceDescrizione[];
    apparecchiature: CodiceDescrizione[];
    ariaCombustibile: CodiceDescrizione[];
    cotrolloAria: CodiceDescrizione[];
    unitaMisura: CodiceDescrizione[];
}
