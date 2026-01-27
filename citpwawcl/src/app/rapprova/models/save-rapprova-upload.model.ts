interface DatiRapProva {
  dataControllo: number;
  codiceImpianto: number;
  fkTipoDocumento: number;
  fOraArrivo: string;
  elencoApparecchiature: string;
  elencoCombustibili: string;
  fkIspezIspet: number;
}

interface DatiRapProvaWeb {
  progressivo: number;
  dataInstall: number;
}

export interface SaveRapprovaUpload {
  datiRapProva: DatiRapProva;
  datiRapProvaWebGt?: DatiRapProvaWeb;
  datiRapProvaWebGf?: DatiRapProvaWeb;
  docBase64: string;
  docName: string;
}
