interface DatiRapProva {
  idAllegato: number;
  codiceImpianto: number;
}

export interface UploadRapprovaFirmato {
  datiRapProva: DatiRapProva;
  docBase64: string;
  docName: string;
}
