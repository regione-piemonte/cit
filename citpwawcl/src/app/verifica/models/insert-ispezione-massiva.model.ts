export interface InsertIspezioneMassiva {
  cfUtenteCaricamento: string;
  dtCaricamento: number;
  fkTipoVerifica: number;
  codiceImpianto?: number[];
  fkDatoDistrib?: number[];
  flgIspPagamento: number;
}
