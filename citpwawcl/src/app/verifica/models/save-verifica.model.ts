export type SaveVerifica = InsertVerifica | UpdateVerifica;

export interface InsertVerifica {
  cfUtenteCaricamento: string;
  dtCaricamento: number;
  fkTipoVerifica: number;
  codiceImpianto?: number;
  indirizzoSitad: string;
  civico: string;
  siglaBollino?: string;
  numeroBollino?: number;
  fkDatoDistrib?: number;
  dtSveglia: number;
  noteSveglia: string;
  note: string;
}

export interface UpdateVerifica {
  idVerifica: number;
  dtSveglia: number;
  noteSveglia: string;
  note: string;
}
