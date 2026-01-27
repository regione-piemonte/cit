export interface SearchIspezione {
  idIspezione2018?: number;
  fkStatoIspezione?: number;
  desStatoIspezione?: string;
  fkAccertamento?: number;
  fkVerifica?: number;
  codiceImpianto?: number;
  cfUtenteAssegn?: string;
  denomUtenteAssegn?: string;
  cfIspettoreSecondario?: string;
  enteCompetente?: string;
  flgEsito?: number;
  dtSveglia?: number;
  noteSveglia?: string;
  note?: string;
  istatProvCompetenza?: string;
  flgAccSostitutivo?: number;
  dtCreazioneDa?: number;
  dtCreazioneA?: number;
  dtConclusioneDa?: number;
  dtConclusioneA?: number;
  flgIspPagamento?: number;
  istatComuneCompetenza?: string;
  empty?: boolean;
}
