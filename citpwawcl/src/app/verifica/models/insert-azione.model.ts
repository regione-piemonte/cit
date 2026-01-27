export interface InsertAzione {
  cfUtenteAzione: string;
  descrizioneAzione: string;
  dtAzione: number;
  idVerifica: number;
  nomeDocOriginale?: string;
  docBase64?: string;
  docContentType?: string;
}
