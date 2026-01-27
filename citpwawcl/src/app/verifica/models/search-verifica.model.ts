export interface SearchVerifica {
  idVerifica?: number;
  fkTipoVerifica?: number;
  fkAllegato?: number;
  fkDatoDistrib?: number;
  codiceImpianto?: number;
  cfUtenteCaricamento?: string;
  denomUtenteCaricamento?: string;
  dtCaricamentoDa?: number;
  dtCaricamentoA?: number;
  siglaRee?: string;
  numeroRee?: number;
  dtSveglia?: number;
  noteSveglia?: string;
  note?: string;
}
