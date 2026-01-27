export type SaveIspezione = InsertIspezione | UpdateIspezione;

export interface InsertIspezione {
  fkVerifica: number;
  dtCreazione: number;
  fkStatoIspezione: number;
  codiceImpianto: number;
  flgIspPagamento: number;
  note: string;
}

export interface UpdateIspezione {
  idIspezione2018: number;
  dtSveglia: number;
  noteSveglia: string;
  note: string;
}
