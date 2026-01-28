----------------------------------------------------------------------------------------
-- 18/3/2025  Lorita
-- ISSUE 172263
--vista_dw_sk4_gt
--vmv_vista_dw_sk4_gt
--mv_vista_dw_sk4_gt

--con l'aggiunta dei seguenti campi 
--sigit_t_impianto.l1_3_pot_h2o_kw (il campo se valorizzato con un valore numerico, indica che è presente un servizio di Produzione acqua calda sanitaria (ACS) , 
--quindi sarebbe da valorizzare con SI , se nullo andrebbe valorizzato a NO)
--sigit_t_impianto.flg_tipo_impianto (A= autonomo , C = centralizzato)

--Le modifiche sono funzionali alla pubblicazione di questi altri campi su un Report del DWCIT.
-- DEV e TEST 19/3/2025
----------------------------------------------------------------------------------------

CREATE OR REPLACE VIEW sigit_new.vista_dw_sk4_gt AS 
SELECT DISTINCT sigit_t_comp_gt.codice_impianto,
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
    case when sigit_t_impianto.l1_3_pot_h2o_kw is not null then 'SI' else 'NO' end "produzione_acqua_calda_sanitaria",
    sigit_t_impianto.flg_tipo_impianto
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
     LEFT JOIN sigit_d_tipo_caric_combu ON sigit_d_tipo_caric_combu.id_tipo_caric_combu = sigit_t_rapp_tipo1.id_tipo_caric_combu;

ALTER TABLE sigit_new.vista_dw_sk4_gt OWNER TO sigit_new;
GRANT ALL ON TABLE sigit_new.vista_dw_sk4_gt TO sigit_new;
GRANT INSERT, SELECT, UPDATE, DELETE, TRUNCATE ON TABLE sigit_new.vista_dw_sk4_gt TO sigit_new_rw;
GRANT SELECT ON TABLE sigit_new.vista_dw_sk4_gt TO sigit_new_ro;

drop VIEW sigit_new.vmv_vista_dw_sk4_gt;
drop MATERIALIZED VIEW sigit_new.mv_vista_dw_sk4_gt;

CREATE MATERIALIZED VIEW sigit_new.mv_vista_dw_sk4_gt
TABLESPACE pg_default AS 
SELECT DISTINCT sigit_t_comp_gt.codice_impianto,
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
    case when sigit_t_impianto.l1_3_pot_h2o_kw is not null then 'SI' else 'NO' end produzione_acqua_calda_sanitaria,
    sigit_t_impianto.flg_tipo_impianto
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
WITH DATA;

ALTER TABLE sigit_new.mv_vista_dw_sk4_gt OWNER TO sigit_new;
GRANT ALL ON TABLE sigit_new.mv_vista_dw_sk4_gt TO sigit_new;
GRANT INSERT, SELECT, UPDATE, DELETE ON TABLE sigit_new.mv_vista_dw_sk4_gt TO sigit_new_rw;
GRANT SELECT ON TABLE sigit_new.mv_vista_dw_sk4_gt TO sigit_new_ro;

CREATE OR REPLACE VIEW sigit_new.vmv_vista_dw_sk4_gt AS 
SELECT mv_vista_dw_sk4_gt.codice_impianto,
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
   FROM mv_vista_dw_sk4_gt;

ALTER TABLE sigit_new.vmv_vista_dw_sk4_gt OWNER TO sigit_new;
GRANT ALL ON TABLE sigit_new.vmv_vista_dw_sk4_gt TO sigit_new;
GRANT INSERT, SELECT, UPDATE, DELETE ON TABLE sigit_new.vmv_vista_dw_sk4_gt TO sigit_new_rw;
GRANT SELECT ON TABLE sigit_new.vmv_vista_dw_sk4_gt TO sigit_new_ro;