import { ControlloModel } from "./controllo-model";
import { ManutFormModel } from "./manut-form-model";

export class DatoControlloModel {
    controlloModel: ControlloModel;
    xmlControllo: any;
    datiCompModelList: any;
    tempIdControllo: string;
    fkStatoPrec: number;
    manut:ManutFormModel;
}
