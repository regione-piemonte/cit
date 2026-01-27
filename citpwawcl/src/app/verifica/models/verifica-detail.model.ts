import { Verifica } from "./verifica.model";

export interface VerificaDetail extends Verifica {
  indirizzoNonTrovato?: string;
  indirizzoSitad: string;
  civico: string;
  comune: string;
  istatComune: string;
  dtSveglia: number;
  noteSveglia: string;
  note: string;
}
