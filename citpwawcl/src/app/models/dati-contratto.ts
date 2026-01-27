export interface DatiContratto {
    id_contratto?: number;
    fk_pg_3_resp?: number;
    fk_imp_ruolo_pfpg_resp?: number;
    codice_impianto?: number;
    data_inizio?: string;
    data_fine?: string;
    flg_tacito_rinnovo?: number;
    data_caricamento?: Date;
    data_ult_mod?: Date;
    utente_utl_mod?: string;
    data_cessazione?: string;
    data_inserimento_cessazione?: string;
    motivo_cessazione?: string;
    fk_tipo_cessazione?: string;
    note?: string;
}