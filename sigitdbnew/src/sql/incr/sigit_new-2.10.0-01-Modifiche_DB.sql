----------------------------------------------------------------------------------------
-- 08/05/2025  Lorita
-- Modifiche SIGIT_T_DATO_DISTRIB modifiche come da richieste di Marco Di Nunzio del 7/5/2025 h 9:51
-- DEV e TEST 08/05/2025
----------------------------------------------------------------------------------------
/* ---------------------------------------------------------------------- */
/* Script generated with: DeZign for Databases 12.2.0                     */
/* Target DBMS:           PostgreSQL 9                                    */
/* Project file:          SIGIT_V21.dez                                   */
/* Project name:                                                          */
/* Author:                                                                */
/* Script type:           Database creation script                        */
/* Created on:            2025-05-08 14:20                                */
/* ---------------------------------------------------------------------- */
ALTER TABLE sigit_new.sigit_t_dato_distrib ADD COLUMN codice_impianto NUMERIC  NOT NULL DEFAULT 0;

/* ---------------------------------------------------------------------- */
/* Add foreign key constraints                                            */
/* ---------------------------------------------------------------------- */
ALTER TABLE sigit_new.sigit_t_dato_distrib ADD CONSTRAINT sigit_t_impianto_sigit_t_dato_distrib 
    FOREIGN KEY (codice_impianto) REFERENCES sigit_new.sigit_t_impianto (codice_impianto);

/* ---------------------------------------------------------------------- */
/* Aggiunto valore per nuovi casi non gestiti                             */
/* ---------------------------------------------------------------------- */
insert into sigit_d_categoria_util (id_categoria_util, des_categoria_util)
values ('ND','Non definito');

/*
Richiesta Assistenza del 9/6/2025 con ricicli fino al 13/6/2025
*/
drop VIEW sigit_new.vmv_vista_dw_sk4_gt;
drop MATERIALIZED VIEW sigit_new.mv_vista_dw_sk4_gt;

CREATE MATERIALIZED VIEW sigit_new.mv_vista_dw_sk4_gt
TABLESPACE pg_default
AS SELECT DISTINCT sigit_t_comp_gt.codice_impianto,
    sigit_t_comp_gt.id_tipo_componente,
    sigit_t_comp_gt.progressivo,
    sigit_t_comp_gt.data_install,
    sigit_t_comp_gt.data_dismiss,
    sigit_t_comp_gt.matricola,
    sigit_t_comp_gt.fk_marca,
    sigit_d_marca.des_marca,
    sigit_d_combustibile.id_combustibile,
    sigit_d_combustibile.des_combustibile,
    sigit_t_comp_gt.fk_fluido,
    sigit_d_fluido.des_fluido,
    sigit_t_comp_gt.fk_dettaglio_gt,
    sigit_d_dettaglio_gt.des_dettaglio_gt,
    sigit_t_comp_gt.modello,
    sigit_t_comp_gt.potenza_termica_kw,
    sigit_t_comp_gt.data_ult_mod,
    sigit_t_comp_gt.utente_ult_mod,
    sigit_t_comp_gt.rendimento_perc,
    sigit_t_comp_gt.n_moduli,
    sigit_t_comp_gt.flg_dismissione,
    sigit_t_allegato.data_controllo,
    sigit_t_impianto.istat_comune,
    sigit_t_impianto.denominazione_comune,
    sigit_t_impianto.denominazione_provincia,
    sigit_t_impianto.fk_stato AS stato_impianto,
    sigit_d_stato_imp.des_stato AS des_stato_impianto,
    sigit_t_libretto.data_consolidamento,
    sigit_t_dett_tipo1.e_nox_ppm,
    sigit_t_dett_tipo1.e_nox_mg_kwh,
    sigit_t_dett_tipo1.e_n_modulo_termico,
    sigit_t_allegato.fk_stato_rapp,
    sigit_d_stato_rapp.des_stato_rapp,
    sigit_t_allegato.f_osservazioni,
    sigit_t_allegato.f_raccomandazioni,
    sigit_t_allegato.f_prescrizioni,
    sigit_t_allegato.f_flg_puo_funzionare,
    sigit_t_allegato.f_intervento_entro,
    sigit_t_dett_tipo1.e_o2_perc,
    sigit_t_dett_tipo1.e_co2_perc,
    sigit_t_dett_tipo1.e_co_corretto_ppm,
    sigit_t_dett_tipo1.e_rend_comb_perc,
    sigit_t_dett_tipo1.e_rend_min_legge_perc,
    sigit_t_allegato.id_allegato,
    sigit_t_allegato.fk_tipo_documento,
    sigit_d_tipo_documento.des_tipo_documento,
    sigit_t_dett_tipo1.e_nox_mg_nm3,
    sigit_d_stelle.id_stelle,
    sigit_d_stelle.desc_stelle,
    sigit_d_tipo_1b.id_tipo_1b,
    sigit_d_tipo_1b.desc_tipo_1b,
    sigit_d_aria_comburente.id_aria_comburente,
    sigit_d_aria_comburente.desc_aria_comburente,
    sigit_d_controllo_aria.id_controllo_aria,
    sigit_d_controllo_aria.desc_controllo_aria,
    sigit_d_tipo_caric_combu.id_tipo_caric_combu,
    sigit_d_tipo_caric_combu.desc_tipo_caric_combu,
        CASE
            WHEN sigit_t_impianto.l1_3_pot_h2o_kw IS NOT NULL THEN 'SI'::text
            ELSE 'NO'::text
        END AS produzione_acqua_calda_sanitaria,
    sigit_t_impianto.flg_tipo_impianto
    , coalesce(sigit_t_unita_immobiliare.indirizzo_sitad,sigit_t_unita_immobiliare.indirizzo_non_trovato) indirizzo
    , sigit_t_persona_fisica.codice_fiscale codice_fiscale_resp_pf, sigit_t_persona_fisica.cognome cognome_resp_pf, sigit_t_persona_fisica.nome nome_resp_pf
	, sigit_t_persona_giuridica.codice_fiscale codice_fiscale_resp_pg, sigit_t_persona_giuridica.denominazione denominazione_resp_pg
    , sigit_t_persona_giuridica_1.codice_fiscale codice_fiscale_3resp, sigit_t_persona_giuridica_1.denominazione denominazione_3resp
   FROM sigit_t_comp_gt
     LEFT JOIN sigit_r_allegato_comp_gt USING (id_tipo_componente, progressivo, codice_impianto, data_install)
     LEFT JOIN sigit_t_allegato ON sigit_t_allegato.id_allegato = sigit_r_allegato_comp_gt.id_allegato AND sigit_t_allegato.fk_stato_rapp = 1::numeric
     LEFT JOIN sigit_t_dett_tipo1 ON sigit_t_dett_tipo1.fk_allegato = sigit_t_allegato.id_allegato AND sigit_t_dett_tipo1.fk_tipo_componente::text = sigit_r_allegato_comp_gt.id_tipo_componente::text AND sigit_t_dett_tipo1.progressivo = sigit_r_allegato_comp_gt.progressivo AND sigit_t_dett_tipo1.codice_impianto = sigit_r_allegato_comp_gt.codice_impianto AND sigit_t_dett_tipo1.data_install = sigit_r_allegato_comp_gt.data_install
     JOIN sigit_t_impianto ON sigit_t_impianto.codice_impianto = sigit_t_comp_gt.codice_impianto
     JOIN sigit_d_stato_imp ON sigit_t_impianto.fk_stato = sigit_d_stato_imp.id_stato
     LEFT JOIN sigit_t_libretto ON sigit_t_impianto.codice_impianto = sigit_t_libretto.codice_impianto AND sigit_t_libretto.fk_stato = 2::numeric
     LEFT JOIN sigit_d_marca ON sigit_t_comp_gt.fk_marca = sigit_d_marca.id_marca
     LEFT JOIN sigit_d_fluido ON sigit_t_comp_gt.fk_fluido = sigit_d_fluido.id_fluido
     LEFT JOIN sigit_d_dettaglio_gt ON sigit_t_comp_gt.fk_dettaglio_gt = sigit_d_dettaglio_gt.id_dettaglio_gt
     LEFT JOIN sigit_d_combustibile ON sigit_t_comp_gt.fk_combustibile = sigit_d_combustibile.id_combustibile
     LEFT JOIN sigit_d_stato_rapp ON sigit_d_stato_rapp.id_stato_rapp = sigit_t_allegato.fk_stato_rapp
     LEFT JOIN sigit_d_tipo_documento ON sigit_d_tipo_documento.id_tipo_documento = sigit_t_allegato.fk_tipo_documento
     LEFT JOIN sigit_t_rapp_tipo1 ON sigit_t_allegato.id_allegato = sigit_t_rapp_tipo1.id_allegato
     LEFT JOIN sigit_d_stelle ON sigit_d_stelle.id_stelle = sigit_t_rapp_tipo1.id_stelle
     LEFT JOIN sigit_d_tipo_1b ON sigit_d_tipo_1b.id_tipo_1b = sigit_t_rapp_tipo1.id_tipo_1b
     LEFT JOIN sigit_d_aria_comburente ON sigit_d_aria_comburente.id_aria_comburente = sigit_t_rapp_tipo1.id_aria_comburente
     LEFT JOIN sigit_d_controllo_aria ON sigit_d_controllo_aria.id_controllo_aria = sigit_t_rapp_tipo1.id_controllo_aria
     LEFT JOIN sigit_d_tipo_caric_combu ON sigit_d_tipo_caric_combu.id_tipo_caric_combu = sigit_t_rapp_tipo1.id_tipo_caric_combu
     LEFT join sigit_t_unita_immobiliare on  sigit_t_unita_immobiliare.codice_impianto = sigit_t_comp_gt.codice_impianto
     	and sigit_t_unita_immobiliare.flg_principale = 1::numeric
     left join sigit_r_imp_ruolo_pfpg sigit_r_imp_ruolo_pfpg_1 on sigit_r_imp_ruolo_pfpg_1.codice_impianto = sigit_t_comp_gt.codice_impianto
     	and (sigit_r_imp_ruolo_pfpg_1.fk_ruolo = ANY (ARRAY[4::numeric, 5::numeric, 10::numeric, 11::numeric, 12::numeric, 13::numeric])) 
     	AND sigit_r_imp_ruolo_pfpg_1.data_inizio <= now() 
     	AND now() <= COALESCE(sigit_r_imp_ruolo_pfpg_1.data_fine::timestamp with time zone, now(), sigit_r_imp_ruolo_pfpg_1.data_fine::timestamp with time zone)
     left JOIN sigit_t_persona_fisica ON sigit_r_imp_ruolo_pfpg_1.fk_persona_fisica = sigit_t_persona_fisica.id_persona_fisica 
     left join sigit_r_imp_ruolo_pfpg sigit_r_imp_ruolo_pfpg_2 on sigit_r_imp_ruolo_pfpg_2.codice_impianto = sigit_t_comp_gt.codice_impianto
     	and (sigit_r_imp_ruolo_pfpg_2.fk_ruolo = ANY (ARRAY[4::numeric, 5::numeric, 10::numeric, 11::numeric, 12::numeric, 13::numeric])) 
     	AND sigit_r_imp_ruolo_pfpg_2.data_inizio <= now() 
     	AND now() <= COALESCE(sigit_r_imp_ruolo_pfpg_2.data_fine::timestamp with time zone, now(), sigit_r_imp_ruolo_pfpg_2.data_fine::timestamp with time zone)
     left JOIN sigit_t_persona_giuridica ON sigit_r_imp_ruolo_pfpg_2.fk_persona_giuridica = sigit_t_persona_giuridica.id_persona_giuridica
	 left JOIN sigit_t_contratto_2019 on sigit_t_contratto_2019.codice_impianto = sigit_t_comp_gt.codice_impianto
          and ((sigit_t_contratto_2019.data_cessazione IS NULL AND sigit_t_contratto_2019.flg_tacito_rinnovo = 1::numeric) 
          OR (sigit_t_contratto_2019.data_cessazione IS NULL AND sigit_t_contratto_2019.flg_tacito_rinnovo = 0::numeric AND sigit_t_contratto_2019.data_fine >= now()::date))
     left JOIN sigit_t_persona_giuridica sigit_t_persona_giuridica_1 ON sigit_t_contratto_2019.fk_pg_3_resp = sigit_t_persona_giuridica_1.id_persona_giuridica
WITH DATA;

-- Permissions

ALTER TABLE sigit_new.mv_vista_dw_sk4_gt OWNER TO sigit_new;
GRANT ALL ON TABLE sigit_new.mv_vista_dw_sk4_gt TO sigit_new;
GRANT INSERT, SELECT, UPDATE, DELETE ON TABLE sigit_new.mv_vista_dw_sk4_gt TO sigit_new_rw;
GRANT SELECT ON TABLE sigit_new.mv_vista_dw_sk4_gt TO sigit_new_ro;

CREATE OR REPLACE VIEW sigit_new.vmv_vista_dw_sk4_gt
AS SELECT mv_vista_dw_sk4_gt.codice_impianto,
    mv_vista_dw_sk4_gt.id_tipo_componente,
    mv_vista_dw_sk4_gt.progressivo,
    mv_vista_dw_sk4_gt.data_install,
    mv_vista_dw_sk4_gt.data_dismiss,
    mv_vista_dw_sk4_gt.matricola,
    mv_vista_dw_sk4_gt.fk_marca,
    mv_vista_dw_sk4_gt.des_marca,
    mv_vista_dw_sk4_gt.id_combustibile,
    mv_vista_dw_sk4_gt.des_combustibile,
    mv_vista_dw_sk4_gt.fk_fluido,
    mv_vista_dw_sk4_gt.des_fluido,
    mv_vista_dw_sk4_gt.fk_dettaglio_gt,
    mv_vista_dw_sk4_gt.des_dettaglio_gt,
    mv_vista_dw_sk4_gt.modello,
    mv_vista_dw_sk4_gt.potenza_termica_kw,
    mv_vista_dw_sk4_gt.data_ult_mod,
    mv_vista_dw_sk4_gt.utente_ult_mod,
    mv_vista_dw_sk4_gt.rendimento_perc,
    mv_vista_dw_sk4_gt.n_moduli,
    mv_vista_dw_sk4_gt.flg_dismissione,
    mv_vista_dw_sk4_gt.data_controllo,
    mv_vista_dw_sk4_gt.istat_comune,
    mv_vista_dw_sk4_gt.denominazione_comune,
    mv_vista_dw_sk4_gt.denominazione_provincia,
    mv_vista_dw_sk4_gt.stato_impianto,
    mv_vista_dw_sk4_gt.des_stato_impianto,
    mv_vista_dw_sk4_gt.data_consolidamento,
    mv_vista_dw_sk4_gt.e_nox_ppm,
    mv_vista_dw_sk4_gt.e_nox_mg_kwh,
    mv_vista_dw_sk4_gt.e_n_modulo_termico,
    mv_vista_dw_sk4_gt.fk_stato_rapp,
    mv_vista_dw_sk4_gt.des_stato_rapp,
    mv_vista_dw_sk4_gt.f_osservazioni,
    mv_vista_dw_sk4_gt.f_raccomandazioni,
    mv_vista_dw_sk4_gt.f_prescrizioni,
    mv_vista_dw_sk4_gt.f_flg_puo_funzionare,
    mv_vista_dw_sk4_gt.f_intervento_entro,
    mv_vista_dw_sk4_gt.e_o2_perc,
    mv_vista_dw_sk4_gt.e_co2_perc,
    mv_vista_dw_sk4_gt.e_co_corretto_ppm,
    mv_vista_dw_sk4_gt.e_rend_comb_perc,
    mv_vista_dw_sk4_gt.e_rend_min_legge_perc,
    mv_vista_dw_sk4_gt.id_allegato,
    mv_vista_dw_sk4_gt.fk_tipo_documento,
    mv_vista_dw_sk4_gt.des_tipo_documento,
    mv_vista_dw_sk4_gt.e_nox_mg_nm3,
    mv_vista_dw_sk4_gt.id_stelle,
    mv_vista_dw_sk4_gt.desc_stelle,
    mv_vista_dw_sk4_gt.id_tipo_1b,
    mv_vista_dw_sk4_gt.desc_tipo_1b,
    mv_vista_dw_sk4_gt.id_aria_comburente,
    mv_vista_dw_sk4_gt.desc_aria_comburente,
    mv_vista_dw_sk4_gt.id_controllo_aria,
    mv_vista_dw_sk4_gt.desc_controllo_aria,
    mv_vista_dw_sk4_gt.id_tipo_caric_combu,
    mv_vista_dw_sk4_gt.desc_tipo_caric_combu,
    mv_vista_dw_sk4_gt.produzione_acqua_calda_sanitaria,
    mv_vista_dw_sk4_gt.flg_tipo_impianto
    , mv_vista_dw_sk4_gt.indirizzo
    , mv_vista_dw_sk4_gt.codice_fiscale_resp_pf, mv_vista_dw_sk4_gt.cognome_resp_pf, mv_vista_dw_sk4_gt.nome_resp_pf
	, mv_vista_dw_sk4_gt.codice_fiscale_resp_pg, mv_vista_dw_sk4_gt.denominazione_resp_pg
    , mv_vista_dw_sk4_gt.codice_fiscale_3resp, mv_vista_dw_sk4_gt.denominazione_3resp
   FROM mv_vista_dw_sk4_gt;

-- Permissions

ALTER TABLE sigit_new.vmv_vista_dw_sk4_gt OWNER TO sigit_new;
GRANT ALL ON TABLE sigit_new.vmv_vista_dw_sk4_gt TO sigit_new;
GRANT INSERT, SELECT, UPDATE, DELETE ON TABLE sigit_new.vmv_vista_dw_sk4_gt TO sigit_new_rw;
GRANT SELECT ON TABLE sigit_new.vmv_vista_dw_sk4_gt TO sigit_new_ro;

----------------------------------------------------------------------------------------
-- 22/07/2025  Lorita
-- Modifiche SIGIT_T_DATO_DISTRIB modifiche come da richieste di Corrado Giordano del 15/7/2025 h 9:53
-- bisognerebbe estendere i campi seguenti della sigit_t_dato_distrib come indicato:
-- indirizzo VARCHAR2(300) <= deve poter ospitare il piu' lungo degli indirizzi trovati (cioe' deve essere uniformato a indirizzo_non_trovato)
-- civico VARCHAR2(50)
-- indirizzo_fatt VARCHAR2(300)
-- civico_fatt VARCHAR2(50)
-- DEV 22/07/2025 circa 5 minuti
-- DEV 23/07/2025 circa 6 minuti
----------------------------------------------------------------------------------------
drop view sigit_new.vista_dettaglio_dati_distributori;
drop view sigit_new.vista_dati_import_distributori;
drop VIEW sigit_new.vmv_vista_dati_import_distributori;
drop MATERIALIZED VIEW sigit_new.mv_vista_dati_import_distributori;

ALTER TABLE sigit_new.sigit_t_dato_distrib ALTER COLUMN     indirizzo 		TYPE CHARACTER VARYING(300)	USING indirizzo::varchar;
ALTER TABLE sigit_new.sigit_t_dato_distrib ALTER COLUMN     civico 			TYPE CHARACTER VARYING(50)  USING civico::varchar;
ALTER TABLE sigit_new.sigit_t_dato_distrib alter COLUMN     indirizzo_fatt  type CHARACTER VARYING(300)	USING indirizzo_fatt::varchar;
ALTER TABLE sigit_new.sigit_t_dato_distrib alter COLUMN     civico_fatt 	type CHARACTER VARYING(50)	USING civico_fatt::varchar;

CREATE OR REPLACE VIEW sigit_new.vista_dettaglio_dati_distributori
AS SELECT DISTINCT sigit_d_combustibile.id_combustibile,
    sigit_t_dato_distrib.id_dato_distrib,
    sigit_t_dato_distrib.fk_tipo_contratto,
    sigit_d_tipo_contratto_distrib.des_tipo_contratto_distrib,
    sigit_t_dato_distrib.fk_import_distrib,
    sigit_t_persona_giuridica.denominazione,
    sigit_t_persona_giuridica.codice_fiscale,
    sigit_d_stato_distrib.des_stato_distrib,
    sigit_t_import_distrib.data_inizio_elab,
    sigit_t_import_distrib.data_fine_elab,
    sigit_t_import_distrib.data_annullamento,
    sigit_t_import_distrib.anno_riferimento,
    sigit_t_import_distrib.tot_record_elaborati,
    sigit_t_import_distrib.tot_record_scartati,
    sigit_t_dato_distrib.fk_categoria_util,
    sigit_d_categoria_util.des_categoria_util,
    sigit_t_dato_distrib.fk_combustibile,
    sigit_d_combustibile.des_combustibile,
    sigit_t_dato_distrib.codice_assenza_catast,
    sigit_t_dato_distrib.fk_unita_misura,
    sigit_d_unita_misura.des_unita_misura,
    sigit_t_dato_distrib.flg_pf_pg,
    sigit_t_dato_distrib.cognome_denom,
    sigit_t_dato_distrib.nome,
    sigit_t_dato_distrib.cf_piva,
    sigit_t_dato_distrib.anno_rif,
    sigit_t_dato_distrib.nr_mesi_fattur,
    sigit_t_dato_distrib.dug,
    sigit_t_dato_distrib.indirizzo,
    sigit_t_dato_distrib.civico,
    sigit_t_dato_distrib.cap,
    sigit_t_dato_distrib.istat_comune,
    sigit_t_dato_distrib.pod_pdr,
    sigit_t_dato_distrib.consumo_anno,
    sigit_t_dato_distrib.consumo_mensile,
    sigit_t_dato_distrib.mese_riferimento,
    sigit_t_dato_distrib.consumo_giornaliero,
    sigit_t_dato_distrib.giorno_riferimento,
    sigit_t_dato_distrib.volumetria
   FROM sigit_t_import_distrib,
    sigit_t_persona_giuridica,
    sigit_t_dato_distrib,
    sigit_d_tipo_contratto_distrib,
    sigit_d_categoria_util,
    sigit_d_combustibile,
    sigit_d_unita_misura,
    sigit_d_stato_distrib
  WHERE sigit_t_import_distrib.id_import_distrib = sigit_t_dato_distrib.fk_import_distrib AND sigit_t_persona_giuridica.id_persona_giuridica = sigit_t_import_distrib.fk_persona_giuridica AND sigit_d_tipo_contratto_distrib.id_tipo_contratto_distrib = sigit_t_dato_distrib.fk_tipo_contratto AND sigit_d_categoria_util.id_categoria_util::text = sigit_t_dato_distrib.fk_categoria_util::text AND sigit_d_combustibile.id_combustibile = sigit_t_dato_distrib.fk_combustibile AND sigit_d_unita_misura.id_unita_misura::text = sigit_t_dato_distrib.fk_unita_misura::text AND sigit_d_stato_distrib.id_stato_distrib = sigit_t_import_distrib.fk_stato_distrib;

-- Permissions

ALTER TABLE sigit_new.vista_dettaglio_dati_distributori OWNER TO sigit_new;
GRANT ALL ON TABLE sigit_new.vista_dettaglio_dati_distributori TO sigit_new;
GRANT INSERT, SELECT, UPDATE, DELETE ON TABLE sigit_new.vista_dettaglio_dati_distributori TO sigit_new_rw;
GRANT SELECT ON TABLE sigit_new.vista_dettaglio_dati_distributori TO sigit_new_ro;

CREATE MATERIALIZED VIEW sigit_new.mv_vista_dati_import_distributori
TABLESPACE pg_default
AS SELECT vista_elenco_distributori.codice_fiscale AS cf_distributore,
    vista_elenco_distributori.denominazione AS denominazione_distributore,
    vista_elenco_distributori.sigla_rea AS sigla_rea_distributore,
    vista_elenco_distributori.numero_rea AS numero_rea_distributore,
    sigit_t_import_distrib.fk_persona_giuridica,
    sigit_d_stato_distrib.des_stato_distrib,
    sigit_t_dato_distrib.fk_import_distrib,
    sigit_t_import_distrib.id_import_distrib,
    sigit_t_import_distrib.data_inizio_elab,
    sigit_t_import_distrib.data_fine_elab,
    sigit_t_import_distrib.nome_file_import,
    sigit_t_import_distrib.data_annullamento,
    sigit_t_import_distrib.anno_riferimento,
    sigit_t_import_distrib.tot_record_elaborati,
    sigit_t_import_distrib.tot_record_scartati,
    sigit_t_import_distrib.data_ult_mod,
    sigit_t_dato_distrib.fk_tipo_contratto,
    sigit_d_tipo_contratto_distrib.des_tipo_contratto_distrib,
    sigit_t_dato_distrib.fk_combustibile,
    sigit_d_combustibile.des_combustibile,
    sigit_t_dato_distrib.fk_unita_misura,
    sigit_d_unita_misura.des_unita_misura,
    sigit_t_dato_distrib.id_dato_distrib,
    sigit_t_dato_distrib.fk_categoria_util,
    sigit_d_categoria_util.des_categoria_util,
    sigit_t_dato_distrib.flg_pf_pg,
    sigit_t_dato_distrib.cognome_denom AS cognome_denom_cliente,
    sigit_t_dato_distrib.nome AS nome_cliente,
    sigit_t_dato_distrib.cf_piva AS cf_cliente,
    sigit_t_dato_distrib.anno_rif,
    sigit_t_dato_distrib.nr_mesi_fattur,
    sigit_t_dato_distrib.dug AS dug_cliente,
    sigit_t_dato_distrib.indirizzo AS indirizzo_cliente,
    sigit_t_dato_distrib.civico AS civico_cliente,
    sigit_t_dato_distrib.cap AS cap_cliente,
    sigit_t_dato_distrib.istat_comune AS istat_comune_cliente,
    sigit_t_dato_distrib.codice_assenza_catast,
    sigit_t_rif_catast.sezione,
    sigit_t_rif_catast.foglio,
    sigit_t_rif_catast.particella,
    sigit_t_rif_catast.subalterno,
    sigit_t_dato_distrib.pod_pdr,
    sigit_t_dato_distrib.consumo_anno,
    sigit_t_dato_distrib.consumo_mensile,
    sigit_t_dato_distrib.mese_riferimento,
    sigit_t_dato_distrib.consumo_giornaliero,
    sigit_t_dato_distrib.giorno_riferimento,
    sigit_t_dato_distrib.volumetria,
    sigit_t_dato_distrib.flg_pf_pg_fatt,
    sigit_t_dato_distrib.cognome_denom_fatt,
    sigit_t_dato_distrib.nome_fatt,
    sigit_t_dato_distrib.cf_piva_fatt,
    sigit_t_dato_distrib.dug_fatt,
    sigit_t_dato_distrib.indirizzo_fatt,
    sigit_t_dato_distrib.civico_fatt,
    sigit_t_dato_distrib.cap_fatt,
    sigit_t_dato_distrib.istat_comune_fatt
   FROM sigit_t_dato_distrib
     JOIN sigit_d_tipo_contratto_distrib ON sigit_t_dato_distrib.fk_tipo_contratto = sigit_d_tipo_contratto_distrib.id_tipo_contratto_distrib
     JOIN sigit_d_combustibile ON sigit_t_dato_distrib.fk_combustibile = sigit_d_combustibile.id_combustibile
     JOIN sigit_d_unita_misura ON sigit_t_dato_distrib.fk_unita_misura::text = sigit_d_unita_misura.id_unita_misura::text
     JOIN sigit_d_categoria_util ON sigit_d_categoria_util.id_categoria_util::text = sigit_t_dato_distrib.fk_categoria_util::text
     JOIN sigit_t_import_distrib ON sigit_t_dato_distrib.fk_import_distrib = sigit_t_import_distrib.id_import_distrib
     JOIN vista_elenco_distributori ON sigit_t_import_distrib.fk_persona_giuridica = vista_elenco_distributori.id_persona_giuridica
     JOIN sigit_d_stato_distrib ON sigit_t_import_distrib.fk_stato_distrib = sigit_d_stato_distrib.id_stato_distrib
     LEFT JOIN sigit_t_rif_catast ON sigit_t_dato_distrib.id_dato_distrib = sigit_t_rif_catast.fk_dato_distrib
WITH DATA;

-- Permissions

ALTER TABLE sigit_new.mv_vista_dati_import_distributori OWNER TO sigit_new;
GRANT ALL ON TABLE sigit_new.mv_vista_dati_import_distributori TO sigit_new;
GRANT INSERT, SELECT, UPDATE, DELETE ON TABLE sigit_new.mv_vista_dati_import_distributori TO sigit_new_rw;
GRANT SELECT ON TABLE sigit_new.mv_vista_dati_import_distributori TO sigit_new_ro;

CREATE OR REPLACE VIEW sigit_new.vmv_vista_dati_import_distributori
AS SELECT mv_vista_dati_import_distributori.cf_distributore,
    mv_vista_dati_import_distributori.denominazione_distributore,
    mv_vista_dati_import_distributori.sigla_rea_distributore,
    mv_vista_dati_import_distributori.numero_rea_distributore,
    mv_vista_dati_import_distributori.fk_persona_giuridica,
    mv_vista_dati_import_distributori.des_stato_distrib,
    mv_vista_dati_import_distributori.fk_import_distrib,
    mv_vista_dati_import_distributori.id_import_distrib,
    mv_vista_dati_import_distributori.data_inizio_elab,
    mv_vista_dati_import_distributori.data_fine_elab,
    mv_vista_dati_import_distributori.nome_file_import,
    mv_vista_dati_import_distributori.data_annullamento,
    mv_vista_dati_import_distributori.anno_riferimento,
    mv_vista_dati_import_distributori.tot_record_elaborati,
    mv_vista_dati_import_distributori.tot_record_scartati,
    mv_vista_dati_import_distributori.data_ult_mod,
    mv_vista_dati_import_distributori.fk_tipo_contratto,
    mv_vista_dati_import_distributori.des_tipo_contratto_distrib,
    mv_vista_dati_import_distributori.fk_combustibile,
    mv_vista_dati_import_distributori.des_combustibile,
    mv_vista_dati_import_distributori.fk_unita_misura,
    mv_vista_dati_import_distributori.des_unita_misura,
    mv_vista_dati_import_distributori.id_dato_distrib,
    mv_vista_dati_import_distributori.fk_categoria_util,
    mv_vista_dati_import_distributori.des_categoria_util,
    mv_vista_dati_import_distributori.flg_pf_pg,
    mv_vista_dati_import_distributori.cognome_denom_cliente,
    mv_vista_dati_import_distributori.nome_cliente,
    mv_vista_dati_import_distributori.cf_cliente,
    mv_vista_dati_import_distributori.anno_rif,
    mv_vista_dati_import_distributori.nr_mesi_fattur,
    mv_vista_dati_import_distributori.dug_cliente,
    mv_vista_dati_import_distributori.indirizzo_cliente,
    mv_vista_dati_import_distributori.civico_cliente,
    mv_vista_dati_import_distributori.cap_cliente,
    mv_vista_dati_import_distributori.istat_comune_cliente,
    mv_vista_dati_import_distributori.codice_assenza_catast,
    mv_vista_dati_import_distributori.sezione,
    mv_vista_dati_import_distributori.foglio,
    mv_vista_dati_import_distributori.particella,
    mv_vista_dati_import_distributori.subalterno,
    mv_vista_dati_import_distributori.pod_pdr,
    mv_vista_dati_import_distributori.consumo_anno,
    mv_vista_dati_import_distributori.consumo_mensile,
    mv_vista_dati_import_distributori.mese_riferimento,
    mv_vista_dati_import_distributori.consumo_giornaliero,
    mv_vista_dati_import_distributori.giorno_riferimento,
    mv_vista_dati_import_distributori.volumetria,
    mv_vista_dati_import_distributori.flg_pf_pg_fatt,
    mv_vista_dati_import_distributori.cognome_denom_fatt,
    mv_vista_dati_import_distributori.nome_fatt,
    mv_vista_dati_import_distributori.cf_piva_fatt,
    mv_vista_dati_import_distributori.dug_fatt,
    mv_vista_dati_import_distributori.indirizzo_fatt,
    mv_vista_dati_import_distributori.civico_fatt,
    mv_vista_dati_import_distributori.cap_fatt,
    mv_vista_dati_import_distributori.istat_comune_fatt
   FROM mv_vista_dati_import_distributori;

-- Permissions

ALTER TABLE sigit_new.vmv_vista_dati_import_distributori OWNER TO sigit_new;
GRANT ALL ON TABLE sigit_new.vmv_vista_dati_import_distributori TO sigit_new;
GRANT INSERT, SELECT, UPDATE, DELETE ON TABLE sigit_new.vmv_vista_dati_import_distributori TO sigit_new_rw;
GRANT SELECT ON TABLE sigit_new.vmv_vista_dati_import_distributori TO sigit_new_ro;

