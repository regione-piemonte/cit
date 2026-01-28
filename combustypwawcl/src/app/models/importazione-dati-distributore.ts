import { DatiFornitura } from "./dati-fornitura";

export class ImportDatiDistributore {
  id_import_distrib: number;
  fk_persona_giuridica: number;
  fk_stato_distrib: number;
  des_stato_distrib: string;
  data_inizio_elab: string; 
  data_fine_elab: string;
  data_annullamento: string | null;
  nome_file_import: string;
  uid_index: string | null;
  anno_riferimento: string;
  data_invio_mail_distrib: string | null;
  data_invio_mail_assistenza: string | null;
  tot_record_elaborati: number;
  tot_record_scartati: number;
  data_ult_mod: string;
  utente_ult_mod: string;
  utente_caricamento: string;
  
  datiFornitura: DatiFornitura[];
  //dtAssegnazione: string | number | Date;
  //tipo_caricamento: any;
  //stato_file: any;
}