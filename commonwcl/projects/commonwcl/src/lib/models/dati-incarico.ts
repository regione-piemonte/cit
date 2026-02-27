export interface DatiIncarico {
    id_persona_giuridica_cat: number;
    id_persona_giuridica_impresa: number;
    denominazione: string;
    codice_fiscale: string;
    data_inizio_legame: string;
    data_fine_legame: Date;
  }