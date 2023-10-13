---------- RICORDARSI GRANT UTENTE RO -----------------
----------------------------------------------------------------------------------------
-- 03/01/2022  Lorita
-- Aggiunta campi
-- SIGIT_T_ACCERTAMENTO.istat_comune_competenza --> nullable
-- SIGIT_T_ISPEZIONE_2018.istat_comune_competenza --> nullable
--  come da mail di Mariuccia del 13/12/2021 9:48
-- DEV e TEST
----------------------------------------------------------------------------------------
ALTER TABLE SIGIT_T_ACCERTAMENTO ADD COLUMN istat_comune_competenza CHARACTER VARYING(6);
ALTER TABLE SIGIT_T_ISPEZIONE_2018 ADD COLUMN istat_comune_competenza CHARACTER VARYING(6);

----------------------------------------------------------------------------------------
-- 01/02/2022  Lorita
-- Aggiunta campi su viste *_dw_sk4_gt
--  sigit_t_rapp_tipo1.id_stelle  +  decodifica
--  sigit_t_rapp_tipo1.id_tipo_1b + decodifica
--  sigit_t_rapp_tipo1.id_aria_comburente + decodifica
--  sigit_t_rapp_tipo1.id_controllo_aria + decodifica
--  sigit_t_rapp_tipo1.id_tipo_caric_combu + decodifica
-- vista vista_tot_impianto aggiunta 
--  sigit_t_impianto.flg_tipo_impianto
-- vista *od_vista_dettaglio_impianti
--  sigit_t_impianto.flg_tipo_impianto
--  come da mail di Mariuccia del 28/01/2022 15:23
-- DEV e TEST
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
    sigit_d_stelle.id_stelle, sigit_d_stelle.desc_stelle,
    sigit_d_tipo_1b.id_tipo_1b, sigit_d_tipo_1b.desc_tipo_1b,
	sigit_d_aria_comburente.id_aria_comburente, sigit_d_aria_comburente.desc_aria_comburente,
	sigit_d_controllo_aria.id_controllo_aria, sigit_d_controllo_aria.desc_controllo_aria,
	sigit_d_tipo_caric_combu.id_tipo_caric_combu, sigit_d_tipo_caric_combu.desc_tipo_caric_combu
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
     LEFT JOIN sigit_t_rapp_tipo1 on sigit_t_allegato.id_allegato = sigit_t_rapp_tipo1.id_allegato
	 LEFT JOIN sigit_d_stelle on sigit_d_stelle.id_stelle = sigit_t_rapp_tipo1.id_stelle
	 LEFT JOIN sigit_d_tipo_1b on sigit_d_tipo_1b.id_tipo_1b = sigit_t_rapp_tipo1.id_tipo_1b
	 LEFT JOIN sigit_d_aria_comburente on sigit_d_aria_comburente.id_aria_comburente = sigit_t_rapp_tipo1.id_aria_comburente
	 LEFT JOIN sigit_d_controllo_aria on sigit_d_controllo_aria.id_controllo_aria = sigit_t_rapp_tipo1.id_controllo_aria
	 LEFT JOIN sigit_d_tipo_caric_combu on sigit_d_tipo_caric_combu.id_tipo_caric_combu = sigit_t_rapp_tipo1.id_tipo_caric_combu
;

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
    sigit_d_stelle.id_stelle, sigit_d_stelle.desc_stelle,
    sigit_d_tipo_1b.id_tipo_1b, sigit_d_tipo_1b.desc_tipo_1b,
	sigit_d_aria_comburente.id_aria_comburente, sigit_d_aria_comburente.desc_aria_comburente,
	sigit_d_controllo_aria.id_controllo_aria, sigit_d_controllo_aria.desc_controllo_aria,
	sigit_d_tipo_caric_combu.id_tipo_caric_combu, sigit_d_tipo_caric_combu.desc_tipo_caric_combu
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
     LEFT JOIN sigit_t_rapp_tipo1 on sigit_t_allegato.id_allegato = sigit_t_rapp_tipo1.id_allegato
	 LEFT JOIN sigit_d_stelle on sigit_d_stelle.id_stelle = sigit_t_rapp_tipo1.id_stelle
	 LEFT JOIN sigit_d_tipo_1b on sigit_d_tipo_1b.id_tipo_1b = sigit_t_rapp_tipo1.id_tipo_1b
	 LEFT JOIN sigit_d_aria_comburente on sigit_d_aria_comburente.id_aria_comburente = sigit_t_rapp_tipo1.id_aria_comburente
	 LEFT JOIN sigit_d_controllo_aria on sigit_d_controllo_aria.id_controllo_aria = sigit_t_rapp_tipo1.id_controllo_aria
	 LEFT JOIN sigit_d_tipo_caric_combu on sigit_d_tipo_caric_combu.id_tipo_caric_combu = sigit_t_rapp_tipo1.id_tipo_caric_combu
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
    mv_vista_dw_sk4_gt.id_stelle, mv_vista_dw_sk4_gt.desc_stelle,
    mv_vista_dw_sk4_gt.id_tipo_1b, mv_vista_dw_sk4_gt.desc_tipo_1b,
	mv_vista_dw_sk4_gt.id_aria_comburente, mv_vista_dw_sk4_gt.desc_aria_comburente,
	mv_vista_dw_sk4_gt.id_controllo_aria, mv_vista_dw_sk4_gt.desc_controllo_aria,
	mv_vista_dw_sk4_gt.id_tipo_caric_combu, mv_vista_dw_sk4_gt.desc_tipo_caric_combu
   FROM mv_vista_dw_sk4_gt;

ALTER TABLE sigit_new.vmv_vista_dw_sk4_gt OWNER TO sigit_new;
GRANT ALL ON TABLE sigit_new.vmv_vista_dw_sk4_gt TO sigit_new;
GRANT INSERT, SELECT, UPDATE, DELETE ON TABLE sigit_new.vmv_vista_dw_sk4_gt TO sigit_new_rw;
GRANT SELECT ON TABLE sigit_new.vmv_vista_dw_sk4_gt TO sigit_new_ro;

CREATE OR REPLACE VIEW sigit_new.vista_tot_impianto
AS SELECT sigit_t_impianto.codice_impianto,
    sigit_t_impianto.denominazione_provincia,
    sigit_t_impianto.sigla_provincia,
    sigit_t_impianto.istat_comune,
    sigit_t_impianto.denominazione_comune,
    COALESCE(sigit_t_unita_immobiliare.indirizzo_sitad, sigit_t_unita_immobiliare.indirizzo_non_trovato) AS indirizzo_sitad,
    sigit_t_unita_immobiliare.civico,
    sigit_t_unita_immobiliare.flg_principale,
    'PF'::character varying(2) AS pf_pg,
    sigit_t_persona_fisica.id_persona_fisica,
    sigit_t_persona_fisica.nome,
    sigit_t_persona_fisica.cognome AS denominazione,
    sigit_d_ruolo.id_ruolo,
    sigit_d_ruolo.des_ruolo,
    sigit_d_ruolo.ruolo_funz,
    sigit_t_persona_fisica.codice_fiscale,
    NULL::character varying(2) AS sigla_rea,
    NULL::numeric(11,0) AS numero_rea,
    sigit_r_imp_ruolo_pfpg.id_imp_ruolo_pfpg,
    sigit_r_imp_ruolo_pfpg.data_inizio AS data_inizio_pfpg,
    sigit_r_imp_ruolo_pfpg.data_fine AS data_fine_pfpg,
    sigit_t_impianto.flg_visu_proprietario,
    sigit_t_impianto.flg_tipo_impianto
   FROM sigit_d_ruolo
     JOIN (sigit_t_persona_fisica
     JOIN (sigit_t_impianto
     JOIN sigit_t_unita_immobiliare ON sigit_t_impianto.codice_impianto = sigit_t_unita_immobiliare.codice_impianto
     JOIN sigit_r_imp_ruolo_pfpg ON sigit_t_impianto.codice_impianto = sigit_r_imp_ruolo_pfpg.codice_impianto) ON sigit_t_persona_fisica.id_persona_fisica = sigit_r_imp_ruolo_pfpg.fk_persona_fisica) ON sigit_d_ruolo.id_ruolo = sigit_r_imp_ruolo_pfpg.fk_ruolo
  WHERE sigit_t_unita_immobiliare.flg_principale = 1::numeric
UNION
 SELECT sigit_t_impianto.codice_impianto,
    sigit_t_impianto.denominazione_provincia,
    sigit_t_impianto.sigla_provincia,
    sigit_t_impianto.istat_comune,
    sigit_t_impianto.denominazione_comune,
    COALESCE(sigit_t_unita_immobiliare.indirizzo_sitad, sigit_t_unita_immobiliare.indirizzo_non_trovato) AS indirizzo_sitad,
    sigit_t_unita_immobiliare.civico,
    sigit_t_unita_immobiliare.flg_principale,
    'PG'::character varying(2) AS pf_pg,
    sigit_t_persona_giuridica.id_persona_giuridica AS id_persona_fisica,
    NULL::character varying(100) AS nome,
    sigit_t_persona_giuridica.denominazione,
    sigit_d_ruolo.id_ruolo,
    sigit_d_ruolo.des_ruolo,
    sigit_d_ruolo.ruolo_funz,
    sigit_t_persona_giuridica.codice_fiscale,
    sigit_t_persona_giuridica.sigla_rea,
    sigit_t_persona_giuridica.numero_rea,
    sigit_r_imp_ruolo_pfpg.id_imp_ruolo_pfpg,
    sigit_r_imp_ruolo_pfpg.data_inizio AS data_inizio_pfpg,
    sigit_r_imp_ruolo_pfpg.data_fine AS data_fine_pfpg,
    sigit_t_impianto.flg_visu_proprietario,
    sigit_t_impianto.flg_tipo_impianto
   FROM sigit_d_ruolo
     JOIN (sigit_t_persona_giuridica
     JOIN (sigit_t_impianto
     JOIN sigit_t_unita_immobiliare ON sigit_t_impianto.codice_impianto = sigit_t_unita_immobiliare.codice_impianto
     JOIN sigit_r_imp_ruolo_pfpg ON sigit_t_impianto.codice_impianto = sigit_r_imp_ruolo_pfpg.codice_impianto) ON sigit_t_persona_giuridica.id_persona_giuridica = sigit_r_imp_ruolo_pfpg.fk_persona_giuridica) ON sigit_d_ruolo.id_ruolo = sigit_r_imp_ruolo_pfpg.fk_ruolo
  WHERE sigit_t_unita_immobiliare.flg_principale = 1::numeric;

CREATE OR REPLACE VIEW sigit_new.od_vista_dettaglio_impianti AS 
SELECT i.codice_impianto,
    i.denominazione_comune,
    i.denominazione_provincia,
    ui.l1_2_fk_categoria,
    ui.l1_2_vol_risc_m3,
    ui.l1_2_vol_raff_m3,
    i.l1_3_pot_h2o_kw,
    i.l1_3_pot_clima_inv_kw,
    i.l1_3_pot_clima_est_kw,
    gt.id_tipo_componente AS tipo_componente,
    gt.progressivo,
    gt.data_install,
    gt.des_marca,
    gt.des_combustibile,
    gt.des_dettaglio_gt AS des_dettaglio,
    gt.potenza_termica_kw AS potenza,
    gt.rendimento_perc,
    gt.data_controllo,
    gt.e_nox_ppm,
    gt.e_nox_mg_kwh,
    gt.e_n_modulo_termico,
    i.flg_no_opendata,
    COALESCE(ui.indirizzo_sitad, ui.indirizzo_non_trovato) AS indirizzo_unita_immob,
    ui.civico,
    ui.sezione,
    ui.foglio,
    ui.particella,
    ui.subalterno,
    ui.pod_elettrico,
    ui.pdr_gas,
    gt.e_nox_mg_nm3,
    i.coord_x_long_dd,
    i.coord_y_lat_dd,
    i.flg_tipo_impianto
   FROM sigit_t_impianto i
     JOIN sigit_t_unita_immobiliare ui ON i.codice_impianto = ui.codice_impianto
     JOIN vista_dw_sk4_gt gt ON i.codice_impianto = gt.codice_impianto
  WHERE gt.data_dismiss IS NULL AND ui.flg_principale = 1::numeric AND i.fk_stato = 1::numeric AND ((i.codice_impianto, gt.id_tipo_componente::text, gt.progressivo, gt.data_controllo) IN ( SELECT i_1.codice_impianto,
            gt_1.id_tipo_componente AS tipo_componente,
            gt_1.progressivo,
            max(gt_1.data_controllo) AS data_controllo
           FROM sigit_t_impianto i_1
             JOIN sigit_t_unita_immobiliare ui_1 ON i_1.codice_impianto = ui_1.codice_impianto
             JOIN vista_dw_sk4_gt gt_1 ON i_1.codice_impianto = gt_1.codice_impianto
          WHERE gt_1.data_dismiss IS NULL AND ui_1.flg_principale = 1::numeric AND i_1.fk_stato = 1::numeric
          GROUP BY i_1.codice_impianto, gt_1.id_tipo_componente, gt_1.progressivo))
  GROUP BY i.codice_impianto, i.denominazione_comune, i.denominazione_provincia, ui.l1_2_fk_categoria, ui.l1_2_vol_risc_m3, ui.l1_2_vol_raff_m3, i.l1_3_pot_h2o_kw, i.l1_3_pot_clima_inv_kw, i.l1_3_pot_clima_est_kw, gt.id_tipo_componente, gt.progressivo, gt.data_install, gt.des_marca, gt.des_combustibile, gt.des_dettaglio_gt, gt.potenza_termica_kw, gt.rendimento_perc, gt.data_controllo, gt.e_nox_ppm, gt.e_nox_mg_kwh, gt.e_n_modulo_termico, i.flg_no_opendata, (COALESCE(ui.indirizzo_sitad, ui.indirizzo_non_trovato)), ui.civico, ui.sezione, ui.foglio, ui.particella, ui.subalterno, ui.pod_elettrico, ui.pdr_gas, gt.e_nox_mg_nm3
UNION
 SELECT i.codice_impianto,
    i.denominazione_comune,
    i.denominazione_provincia,
    ui.l1_2_fk_categoria,
    ui.l1_2_vol_risc_m3,
    ui.l1_2_vol_raff_m3,
    i.l1_3_pot_h2o_kw,
    i.l1_3_pot_clima_inv_kw,
    i.l1_3_pot_clima_est_kw,
    gf.id_tipo_componente AS tipo_componente,
    gf.progressivo,
    gf.data_install,
    gf.des_marca,
    gf.des_combustibile,
    NULL::text AS des_dettaglio,
    gf.potenza_termica_kw AS potenza,
    NULL::numeric AS rendimento_perc,
    max(gf.data_controllo) AS data_controllo,
    NULL::numeric AS e_nox_ppm,
    NULL::numeric AS e_nox_mg_kwh,
    NULL::numeric AS e_n_modulo_termico,
    i.flg_no_opendata,
    COALESCE(ui.indirizzo_sitad, ui.indirizzo_non_trovato) AS indirizzo_unita_immob,
    ui.civico,
    ui.sezione,
    ui.foglio,
    ui.particella,
    ui.subalterno,
    ui.pod_elettrico,
    ui.pdr_gas,
    NULL::numeric AS e_nox_mg_nm3,
    i.coord_x_long_dd,
    i.coord_y_lat_dd,
    i.flg_tipo_impianto
   FROM sigit_t_impianto i
     JOIN sigit_t_unita_immobiliare ui ON i.codice_impianto = ui.codice_impianto
     JOIN vista_dw_sk4_gf gf ON i.codice_impianto = gf.codice_impianto
  WHERE gf.data_dismiss IS NULL AND ui.flg_principale = 1::numeric AND i.fk_stato = 1::numeric
  GROUP BY i.codice_impianto, i.denominazione_comune, i.denominazione_provincia, ui.l1_2_fk_categoria, ui.l1_2_vol_risc_m3, ui.l1_2_vol_raff_m3, i.l1_3_pot_h2o_kw, i.l1_3_pot_clima_inv_kw, i.l1_3_pot_clima_est_kw, gf.id_tipo_componente, gf.progressivo, gf.data_install, gf.des_marca, gf.des_combustibile, NULL::text, gf.potenza_termica_kw, i.flg_no_opendata, (COALESCE(ui.indirizzo_sitad, ui.indirizzo_non_trovato)), ui.civico, ui.sezione, ui.foglio, ui.particella, ui.subalterno, ui.pod_elettrico, ui.pdr_gas
UNION
 SELECT i.codice_impianto,
    i.denominazione_comune,
    i.denominazione_provincia,
    ui.l1_2_fk_categoria,
    ui.l1_2_vol_risc_m3,
    ui.l1_2_vol_raff_m3,
    i.l1_3_pot_h2o_kw,
    i.l1_3_pot_clima_inv_kw,
    i.l1_3_pot_clima_est_kw,
    sc.id_tipo_componente AS tipo_componente,
    sc.progressivo,
    sc.data_install,
    sc.des_marca,
    NULL::character varying AS des_combustibile,
    NULL::text AS des_dettaglio,
    sc.potenza_termica_kw AS potenza,
    NULL::numeric AS rendimento_perc,
    max(sc.data_controllo) AS data_controllo,
    NULL::numeric AS e_nox_ppm,
    NULL::numeric AS e_nox_mg_kwh,
    NULL::numeric AS e_n_modulo_termico,
    i.flg_no_opendata,
    COALESCE(ui.indirizzo_sitad, ui.indirizzo_non_trovato) AS indirizzo_unita_immob,
    ui.civico,
    ui.sezione,
    ui.foglio,
    ui.particella,
    ui.subalterno,
    ui.pod_elettrico,
    ui.pdr_gas,
    NULL::numeric AS e_nox_mg_nm3,
    i.coord_x_long_dd,
    i.coord_y_lat_dd,
    i.flg_tipo_impianto
   FROM sigit_t_impianto i
     JOIN sigit_t_unita_immobiliare ui ON i.codice_impianto = ui.codice_impianto
     JOIN vista_dw_sk4_sc sc ON i.codice_impianto = sc.codice_impianto
  WHERE sc.data_dismiss IS NULL AND ui.flg_principale = 1::numeric AND i.fk_stato = 1::numeric
  GROUP BY i.codice_impianto, i.denominazione_comune, i.denominazione_provincia, ui.l1_2_fk_categoria, ui.l1_2_vol_risc_m3, ui.l1_2_vol_raff_m3, i.l1_3_pot_h2o_kw, i.l1_3_pot_clima_inv_kw, i.l1_3_pot_clima_est_kw, sc.id_tipo_componente, sc.progressivo, sc.data_install, sc.des_marca, NULL::text, sc.potenza_termica_kw, i.flg_no_opendata, (COALESCE(ui.indirizzo_sitad, ui.indirizzo_non_trovato)), ui.civico, ui.sezione, ui.foglio, ui.particella, ui.subalterno, ui.pod_elettrico, ui.pdr_gas
UNION
 SELECT i.codice_impianto,
    i.denominazione_comune,
    i.denominazione_provincia,
    ui.l1_2_fk_categoria,
    ui.l1_2_vol_risc_m3,
    ui.l1_2_vol_raff_m3,
    i.l1_3_pot_h2o_kw,
    i.l1_3_pot_clima_inv_kw,
    i.l1_3_pot_clima_est_kw,
    cg.id_tipo_componente AS tipo_componente,
    cg.progressivo,
    cg.data_install,
    cg.des_marca,
    cg.des_combustibile,
    NULL::character varying AS des_dettaglio,
    cg.potenza_termica_kw AS potenza,
    NULL::numeric AS rendimento_perc,
    max(cg.data_controllo) AS data_controllo,
    NULL::numeric AS e_nox_ppm,
    NULL::numeric AS e_nox_mg_kwh,
    NULL::numeric AS e_n_modulo_termico,
    i.flg_no_opendata,
    COALESCE(ui.indirizzo_sitad, ui.indirizzo_non_trovato) AS indirizzo_unita_immob,
    ui.civico,
    ui.sezione,
    ui.foglio,
    ui.particella,
    ui.subalterno,
    ui.pod_elettrico,
    ui.pdr_gas,
    NULL::numeric AS e_nox_mg_nm3,
    i.coord_x_long_dd,
    i.coord_y_lat_dd,
    i.flg_tipo_impianto
   FROM sigit_t_impianto i
     JOIN sigit_t_unita_immobiliare ui ON i.codice_impianto = ui.codice_impianto
     JOIN vista_dw_sk4_cg cg ON i.codice_impianto = cg.codice_impianto
  WHERE cg.data_dismiss IS NULL AND ui.flg_principale = 1::numeric AND i.fk_stato = 1::numeric
  GROUP BY i.codice_impianto, i.denominazione_comune, i.denominazione_provincia, ui.l1_2_fk_categoria, ui.l1_2_vol_risc_m3, ui.l1_2_vol_raff_m3, i.l1_3_pot_h2o_kw, i.l1_3_pot_clima_inv_kw, i.l1_3_pot_clima_est_kw, cg.id_tipo_componente, cg.progressivo, cg.data_install, cg.des_marca, cg.des_combustibile, cg.potenza_termica_kw, i.flg_no_opendata, (COALESCE(ui.indirizzo_sitad, ui.indirizzo_non_trovato)), ui.civico, ui.sezione, ui.foglio, ui.particella, ui.subalterno, ui.pod_elettrico, ui.pdr_gas;

drop VIEW sigit_new.vmv_od_vista_dettaglio_impianti;
drop MATERIALIZED VIEW sigit_new.mv_od_vista_dettaglio_impianti;

CREATE MATERIALIZED VIEW sigit_new.mv_od_vista_dettaglio_impianti
TABLESPACE pg_default
AS SELECT i.codice_impianto,
    i.denominazione_comune,
    i.denominazione_provincia,
    ui.l1_2_fk_categoria,
    ui.l1_2_vol_risc_m3,
    ui.l1_2_vol_raff_m3,
    i.l1_3_pot_h2o_kw,
    i.l1_3_pot_clima_inv_kw,
    i.l1_3_pot_clima_est_kw,
    gt.id_tipo_componente AS tipo_componente,
    gt.progressivo,
    gt.data_install,
    gt.des_marca,
    gt.des_combustibile,
    gt.des_dettaglio_gt AS des_dettaglio,
    gt.potenza_termica_kw AS potenza,
    gt.rendimento_perc,
    gt.data_controllo,
    gt.e_nox_ppm,
    gt.e_nox_mg_kwh,
    gt.e_n_modulo_termico,
    i.flg_no_opendata,
    COALESCE(ui.indirizzo_sitad, ui.indirizzo_non_trovato) AS indirizzo_unita_immob,
    ui.civico,
    ui.sezione,
    ui.foglio,
    ui.particella,
    ui.subalterno,
    ui.pod_elettrico,
    ui.pdr_gas,
    gt.e_nox_mg_nm3,
    i.coord_x_long_dd,
    i.coord_y_lat_dd,
    i.flg_tipo_impianto
   FROM sigit_t_impianto i
     JOIN sigit_t_unita_immobiliare ui ON i.codice_impianto = ui.codice_impianto
     JOIN vista_dw_sk4_gt gt ON i.codice_impianto = gt.codice_impianto
  WHERE gt.data_dismiss IS NULL AND ui.flg_principale = 1::numeric AND i.fk_stato = 1::numeric AND ((i.codice_impianto, gt.id_tipo_componente::text, gt.progressivo, gt.data_controllo) IN ( SELECT i_1.codice_impianto,
            gt_1.id_tipo_componente AS tipo_componente,
            gt_1.progressivo,
            max(gt_1.data_controllo) AS data_controllo
           FROM sigit_t_impianto i_1
             JOIN sigit_t_unita_immobiliare ui_1 ON i_1.codice_impianto = ui_1.codice_impianto
             JOIN vista_dw_sk4_gt gt_1 ON i_1.codice_impianto = gt_1.codice_impianto
          WHERE gt_1.data_dismiss IS NULL AND ui_1.flg_principale = 1::numeric AND i_1.fk_stato = 1::numeric
          GROUP BY i_1.codice_impianto, gt_1.id_tipo_componente, gt_1.progressivo))
  GROUP BY i.codice_impianto, i.denominazione_comune, i.denominazione_provincia, ui.l1_2_fk_categoria, ui.l1_2_vol_risc_m3, ui.l1_2_vol_raff_m3, i.l1_3_pot_h2o_kw, i.l1_3_pot_clima_inv_kw, i.l1_3_pot_clima_est_kw, gt.id_tipo_componente, gt.progressivo, gt.data_install, gt.des_marca, gt.des_combustibile, gt.des_dettaglio_gt, gt.potenza_termica_kw, gt.rendimento_perc, gt.data_controllo, gt.e_nox_ppm, gt.e_nox_mg_kwh, gt.e_n_modulo_termico, i.flg_no_opendata, (COALESCE(ui.indirizzo_sitad, ui.indirizzo_non_trovato)), ui.civico, ui.sezione, ui.foglio, ui.particella, ui.subalterno, ui.pod_elettrico, ui.pdr_gas, gt.e_nox_mg_nm3
UNION
 SELECT i.codice_impianto,
    i.denominazione_comune,
    i.denominazione_provincia,
    ui.l1_2_fk_categoria,
    ui.l1_2_vol_risc_m3,
    ui.l1_2_vol_raff_m3,
    i.l1_3_pot_h2o_kw,
    i.l1_3_pot_clima_inv_kw,
    i.l1_3_pot_clima_est_kw,
    gf.id_tipo_componente AS tipo_componente,
    gf.progressivo,
    gf.data_install,
    gf.des_marca,
    gf.des_combustibile,
    NULL::text AS des_dettaglio,
    gf.potenza_termica_kw AS potenza,
    NULL::numeric AS rendimento_perc,
    max(gf.data_controllo) AS data_controllo,
    NULL::numeric AS e_nox_ppm,
    NULL::numeric AS e_nox_mg_kwh,
    NULL::numeric AS e_n_modulo_termico,
    i.flg_no_opendata,
    COALESCE(ui.indirizzo_sitad, ui.indirizzo_non_trovato) AS indirizzo_unita_immob,
    ui.civico,
    ui.sezione,
    ui.foglio,
    ui.particella,
    ui.subalterno,
    ui.pod_elettrico,
    ui.pdr_gas,
    NULL::numeric AS e_nox_mg_nm3,
    i.coord_x_long_dd,
    i.coord_y_lat_dd,
    i.flg_tipo_impianto
   FROM sigit_t_impianto i
     JOIN sigit_t_unita_immobiliare ui ON i.codice_impianto = ui.codice_impianto
     JOIN vista_dw_sk4_gf gf ON i.codice_impianto = gf.codice_impianto
  WHERE gf.data_dismiss IS NULL AND ui.flg_principale = 1::numeric AND i.fk_stato = 1::numeric
  GROUP BY i.codice_impianto, i.denominazione_comune, i.denominazione_provincia, ui.l1_2_fk_categoria, ui.l1_2_vol_risc_m3, ui.l1_2_vol_raff_m3, i.l1_3_pot_h2o_kw, i.l1_3_pot_clima_inv_kw, i.l1_3_pot_clima_est_kw, gf.id_tipo_componente, gf.progressivo, gf.data_install, gf.des_marca, gf.des_combustibile, NULL::text, gf.potenza_termica_kw, i.flg_no_opendata, (COALESCE(ui.indirizzo_sitad, ui.indirizzo_non_trovato)), ui.civico, ui.sezione, ui.foglio, ui.particella, ui.subalterno, ui.pod_elettrico, ui.pdr_gas
UNION
 SELECT i.codice_impianto,
    i.denominazione_comune,
    i.denominazione_provincia,
    ui.l1_2_fk_categoria,
    ui.l1_2_vol_risc_m3,
    ui.l1_2_vol_raff_m3,
    i.l1_3_pot_h2o_kw,
    i.l1_3_pot_clima_inv_kw,
    i.l1_3_pot_clima_est_kw,
    sc.id_tipo_componente AS tipo_componente,
    sc.progressivo,
    sc.data_install,
    sc.des_marca,
    NULL::character varying AS des_combustibile,
    NULL::text AS des_dettaglio,
    sc.potenza_termica_kw AS potenza,
    NULL::numeric AS rendimento_perc,
    max(sc.data_controllo) AS data_controllo,
    NULL::numeric AS e_nox_ppm,
    NULL::numeric AS e_nox_mg_kwh,
    NULL::numeric AS e_n_modulo_termico,
    i.flg_no_opendata,
    COALESCE(ui.indirizzo_sitad, ui.indirizzo_non_trovato) AS indirizzo_unita_immob,
    ui.civico,
    ui.sezione,
    ui.foglio,
    ui.particella,
    ui.subalterno,
    ui.pod_elettrico,
    ui.pdr_gas,
    NULL::numeric AS e_nox_mg_nm3,
    i.coord_x_long_dd,
    i.coord_y_lat_dd,
    i.flg_tipo_impianto
   FROM sigit_t_impianto i
     JOIN sigit_t_unita_immobiliare ui ON i.codice_impianto = ui.codice_impianto
     JOIN vista_dw_sk4_sc sc ON i.codice_impianto = sc.codice_impianto
  WHERE sc.data_dismiss IS NULL AND ui.flg_principale = 1::numeric AND i.fk_stato = 1::numeric
  GROUP BY i.codice_impianto, i.denominazione_comune, i.denominazione_provincia, ui.l1_2_fk_categoria, ui.l1_2_vol_risc_m3, ui.l1_2_vol_raff_m3, i.l1_3_pot_h2o_kw, i.l1_3_pot_clima_inv_kw, i.l1_3_pot_clima_est_kw, sc.id_tipo_componente, sc.progressivo, sc.data_install, sc.des_marca, NULL::text, sc.potenza_termica_kw, i.flg_no_opendata, (COALESCE(ui.indirizzo_sitad, ui.indirizzo_non_trovato)), ui.civico, ui.sezione, ui.foglio, ui.particella, ui.subalterno, ui.pod_elettrico, ui.pdr_gas
UNION
 SELECT i.codice_impianto,
    i.denominazione_comune,
    i.denominazione_provincia,
    ui.l1_2_fk_categoria,
    ui.l1_2_vol_risc_m3,
    ui.l1_2_vol_raff_m3,
    i.l1_3_pot_h2o_kw,
    i.l1_3_pot_clima_inv_kw,
    i.l1_3_pot_clima_est_kw,
    cg.id_tipo_componente AS tipo_componente,
    cg.progressivo,
    cg.data_install,
    cg.des_marca,
    cg.des_combustibile,
    NULL::character varying AS des_dettaglio,
    cg.potenza_termica_kw AS potenza,
    NULL::numeric AS rendimento_perc,
    max(cg.data_controllo) AS data_controllo,
    NULL::numeric AS e_nox_ppm,
    NULL::numeric AS e_nox_mg_kwh,
    NULL::numeric AS e_n_modulo_termico,
    i.flg_no_opendata,
    COALESCE(ui.indirizzo_sitad, ui.indirizzo_non_trovato) AS indirizzo_unita_immob,
    ui.civico,
    ui.sezione,
    ui.foglio,
    ui.particella,
    ui.subalterno,
    ui.pod_elettrico,
    ui.pdr_gas,
    NULL::numeric AS e_nox_mg_nm3,
    i.coord_x_long_dd,
    i.coord_y_lat_dd,
    i.flg_tipo_impianto
   FROM sigit_t_impianto i
     JOIN sigit_t_unita_immobiliare ui ON i.codice_impianto = ui.codice_impianto
     JOIN vista_dw_sk4_cg cg ON i.codice_impianto = cg.codice_impianto
  WHERE cg.data_dismiss IS NULL AND ui.flg_principale = 1::numeric AND i.fk_stato = 1::numeric
  GROUP BY i.codice_impianto, i.denominazione_comune, i.denominazione_provincia, ui.l1_2_fk_categoria, ui.l1_2_vol_risc_m3, ui.l1_2_vol_raff_m3, i.l1_3_pot_h2o_kw, i.l1_3_pot_clima_inv_kw, i.l1_3_pot_clima_est_kw, cg.id_tipo_componente, cg.progressivo, cg.data_install, cg.des_marca, cg.des_combustibile, cg.potenza_termica_kw, i.flg_no_opendata, (COALESCE(ui.indirizzo_sitad, ui.indirizzo_non_trovato)), ui.civico, ui.sezione, ui.foglio, ui.particella, ui.subalterno, ui.pod_elettrico, ui.pdr_gas
WITH DATA;

ALTER TABLE sigit_new.mv_od_vista_dettaglio_impianti OWNER TO sigit_new;
GRANT ALL ON TABLE sigit_new.mv_od_vista_dettaglio_impianti TO sigit_new;
GRANT INSERT, SELECT, UPDATE, DELETE ON TABLE sigit_new.mv_od_vista_dettaglio_impianti TO sigit_new_rw;
GRANT SELECT ON TABLE sigit_new.mv_od_vista_dettaglio_impianti TO sigit_new_ro;

CREATE OR REPLACE VIEW sigit_new.vmv_od_vista_dettaglio_impianti
AS SELECT mv_od_vista_dettaglio_impianti.codice_impianto,
    mv_od_vista_dettaglio_impianti.denominazione_comune,
    mv_od_vista_dettaglio_impianti.denominazione_provincia,
    mv_od_vista_dettaglio_impianti.l1_2_fk_categoria,
    mv_od_vista_dettaglio_impianti.l1_2_vol_risc_m3,
    mv_od_vista_dettaglio_impianti.l1_2_vol_raff_m3,
    mv_od_vista_dettaglio_impianti.l1_3_pot_h2o_kw,
    mv_od_vista_dettaglio_impianti.l1_3_pot_clima_inv_kw,
    mv_od_vista_dettaglio_impianti.l1_3_pot_clima_est_kw,
    mv_od_vista_dettaglio_impianti.tipo_componente,
    mv_od_vista_dettaglio_impianti.progressivo,
    mv_od_vista_dettaglio_impianti.data_install,
    mv_od_vista_dettaglio_impianti.des_marca,
    mv_od_vista_dettaglio_impianti.des_combustibile,
    mv_od_vista_dettaglio_impianti.des_dettaglio,
    mv_od_vista_dettaglio_impianti.potenza,
    mv_od_vista_dettaglio_impianti.rendimento_perc,
    mv_od_vista_dettaglio_impianti.data_controllo,
    mv_od_vista_dettaglio_impianti.e_nox_ppm,
    mv_od_vista_dettaglio_impianti.e_nox_mg_kwh,
    mv_od_vista_dettaglio_impianti.e_n_modulo_termico,
    mv_od_vista_dettaglio_impianti.flg_no_opendata,
    mv_od_vista_dettaglio_impianti.indirizzo_unita_immob,
    mv_od_vista_dettaglio_impianti.civico,
    mv_od_vista_dettaglio_impianti.sezione,
    mv_od_vista_dettaglio_impianti.foglio,
    mv_od_vista_dettaglio_impianti.particella,
    mv_od_vista_dettaglio_impianti.subalterno,
    mv_od_vista_dettaglio_impianti.pod_elettrico,
    mv_od_vista_dettaglio_impianti.pdr_gas,
    mv_od_vista_dettaglio_impianti.e_nox_mg_nm3,
    mv_od_vista_dettaglio_impianti.coord_x_long_dd,
    mv_od_vista_dettaglio_impianti.coord_y_lat_dd,
    mv_od_vista_dettaglio_impianti.flg_tipo_impianto
   FROM mv_od_vista_dettaglio_impianti;

ALTER TABLE sigit_new.vmv_od_vista_dettaglio_impianti OWNER TO sigit_new;
GRANT ALL ON TABLE sigit_new.vmv_od_vista_dettaglio_impianti TO sigit_new;
GRANT INSERT, SELECT, UPDATE, DELETE ON TABLE sigit_new.vmv_od_vista_dettaglio_impianti TO sigit_new_rw;
GRANT SELECT ON TABLE sigit_new.vmv_od_vista_dettaglio_impianti TO sigit_new_ro;

----------------------------------------------------------------------------------------
-- 03/02/2022  Lorita
-- Aggiunta campo istat_comune_competenza nella vista vista_ricerca_ispezioni
--  come da messaggio skype di Mariuccia del 3/02/2021 11:45
-- DEV e TEST
-- 07/02/2022  Lorita
-- Tolto filtro su istat_comune_competenza nella vista vista_ricerca_ispezioni
--  come da messaggio skype di Mariuccia del 7/02/2021 10:55
----------------------------------------------------------------------------------------
CREATE OR REPLACE VIEW sigit_new.vista_ricerca_ispezioni AS 
SELECT sigit_t_ispezione_2018.id_ispezione_2018,
    sigit_t_ispezione_2018.codice_impianto,
    sigit_r_ispez_ispet.id_ispez_ispet,
    sigit_t_ispezione_2018.fk_stato_ispezione,
    sigit_d_stato_ispezione.des_stato_ispezione,
    sigit_t_ispezione_2018.ente_competente,
    sigit_t_ispezione_2018.dt_creazione,
    sigit_t_ispezione_2018.dt_conclusione,
    sigit_t_ispezione_2018.flg_esito,
    sigit_t_ispezione_2018.note,
    sigit_t_allegato.id_allegato,
    sigit_t_allegato.fk_stato_rapp,
    sigit_d_stato_rapp.des_stato_rapp,
    sigit_t_allegato.fk_tipo_documento,
    sigit_d_tipo_documento.des_tipo_documento,
    sigit_t_allegato.fk_sigla_bollino,
    sigit_t_allegato.fk_numero_bollino,
    sigit_t_allegato.data_controllo,
    sigit_t_allegato.b_flg_libretto_uso,
    sigit_t_allegato.b_flg_dichiar_conform,
    sigit_t_allegato.b_flg_lib_imp,
    sigit_t_allegato.b_flg_lib_compl,
    sigit_t_allegato.f_osservazioni,
    sigit_t_allegato.f_raccomandazioni,
    sigit_t_allegato.f_prescrizioni,
    sigit_t_allegato.f_flg_puo_funzionare,
    sigit_t_allegato.f_intervento_entro,
    sigit_t_allegato.f_ora_arrivo,
    sigit_t_allegato.f_ora_partenza,
    sigit_t_allegato.f_denominaz_tecnico,
    sigit_t_allegato.f_flg_firma_tecnico,
    sigit_t_allegato.f_flg_firma_responsabile,
    sigit_t_allegato.data_invio,
    sigit_t_allegato.nome_allegato,
    sigit_t_allegato.data_ult_mod AS data_ult_mod_allegato,
    sigit_t_allegato.utente_ult_mod AS utente_ult_mod_allegato,
    sigit_t_allegato.cf_redattore,
    sigit_t_allegato.uid_index,
    sigit_t_allegato.f_firma_tecnico,
    sigit_t_allegato.f_firma_responsabile,
    sigit_t_allegato.flg_controllo_bozza,
    sigit_t_allegato.a_potenza_termica_nominale_max,
    sigit_t_allegato.elenco_combustibili,
    sigit_t_allegato.elenco_apparecchiature,
    sigit_t_persona_fisica.id_persona_fisica,
    sigit_t_persona_fisica.nome,
    sigit_t_persona_fisica.cognome,
    sigit_t_persona_fisica.codice_fiscale,
    sigit_t_ispezione_2018.istat_prov_competenza,
    sigit_t_ispezione_2018.flg_acc_sostitutivo,
    sigit_t_ispezione_2018.cf_ispettore_secondario,
    sigit_t_ispezione_2018.flg_isp_pagamento,
    sigit_t_ispezione_2018.istat_comune_competenza
   FROM sigit_t_ispezione_2018
     LEFT JOIN sigit_r_ispez_ispet ON sigit_t_ispezione_2018.id_ispezione_2018 = sigit_r_ispez_ispet.id_ispezione_2018
     LEFT JOIN sigit_t_persona_fisica ON sigit_r_ispez_ispet.fk_persona_fisica = sigit_t_persona_fisica.id_persona_fisica
     LEFT JOIN sigit_t_allegato ON sigit_r_ispez_ispet.id_ispez_ispet = sigit_t_allegato.fk_ispez_ispet
     LEFT JOIN sigit_d_tipo_documento ON sigit_t_allegato.fk_tipo_documento = sigit_d_tipo_documento.id_tipo_documento
     LEFT JOIN sigit_d_stato_rapp ON sigit_t_allegato.fk_stato_rapp = sigit_d_stato_rapp.id_stato_rapp
     JOIN sigit_d_stato_ispezione ON sigit_t_ispezione_2018.fk_stato_ispezione = sigit_d_stato_ispezione.id_stato_ispezione
  WHERE sigit_t_ispezione_2018.id_ispezione_2018 <> 0
-- and istat_comune_competenza is not null
 ;
