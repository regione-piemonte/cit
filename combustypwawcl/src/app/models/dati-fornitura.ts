import { LogDatiFornitura } from "./log-dati-fornitura";

export class DatiFornitura {
    id_dato_distrib: number;
    fk_tipo_contratto: number;
    fk_import_distrib: number;
    fk_categoria_util: string;
    fk_combustibile: number;
    des_combustibile: string;
    fk_unita_misura: number;
    des_unita_misura: string;
    flg_pf_pg: string;
    cognome_denom: string;
    nome: string;
    cf_piva: string;
    anno_rif: string;
    nr_mesi_fattur: number;
    dug: string;
    indirizzo: string;
    civico: string;
    cap: string;
    istat_comune: string;
    des_comune: string;
    consumo_anno: string;
  
    flg_pf_pg_fatt: string;
    cognome_denom_fatt: string;
    nome_fatt: string;
    cf_piva_fatt: string;
    dug_fatt: string;
    indirizzo_fatt: string;
    civico_fatt: string;
    cap_fatt: string;
    istat_comune_fatt: string;
  
    codice_impianto: number;
  
    logDatiFornitura: LogDatiFornitura[];
  }
  