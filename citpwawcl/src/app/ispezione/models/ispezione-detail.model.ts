import { Ispezione } from "./ispezione.model";

export interface IspezioneDetail extends Ispezione {
  indirizzoNonTrovato?: string;
  indirizzoSitad: string;
  civico: string;
  denominazioneComune: string;
  idIspezIspet: number;
}
