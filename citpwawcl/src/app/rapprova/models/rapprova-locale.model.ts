import { SaveRapprovaWeb } from "./save-rapprova-web.model";

export interface RapprovaLocale extends SaveRapprovaWeb {
  localId?: string;
  idIspezione2018: number;
}
