----------------------------------------------------------------------------------------
-- 03/05/2021  Lorita
-- Modifica tabella SIGIT_T_IMPIANTO aggiunta colonne per latitudine e longitudine
--  come da mail di Mariuccia del 30/4/2021 11:39
----------------------------------------------------------------------------------------
alter table SIGIT_T_IMPIANTO add column coord_x_long_dd float;

alter table SIGIT_T_IMPIANTO add column coord_y_lat_dd  float;

----------------------------------------------------------------------------------------
-- 18/05/2021  Lorita
-- Modifica viste *vista_ricerca_impianti aggiunte colonne per richiesta nuova query DW
--  come da mail di Katia del 23/4/2021 10:40
-- 03/06/2021  Lorita
-- Aggiunta sigit_t_impianto.flg_no_opendata
--  come da mail di Mariuccia del 28/5/2021 15:04
-- 11/06/2021  Lorita
-- Aggiunta provincia per responsabile pf, responsabile pg e 3^ responsabile
--  come da mail di Viviane/assistenza.energia del 11/6/2021 10:55
----------------------------------------------------------------------------------------
CREATE OR REPLACE VIEW sigit_new.vista_ricerca_impianti
as SELECT DISTINCT sigit_t_impianto.codice_impianto,
    sigit_t_impianto.istat_comune,
    sigit_t_impianto.denominazione_comune,
    sigit_t_impianto.sigla_provincia,
    sigit_t_impianto.denominazione_provincia,
    sigit_t_impianto.fk_stato,
    sigit_t_impianto.l1_3_pot_h2o_kw,
    sigit_t_impianto.l1_3_pot_clima_inv_kw,
    sigit_t_impianto.l1_3_pot_clima_est_kw,
    sigit_t_unita_immobiliare.flg_nopdr,
    COALESCE(sigit_t_unita_immobiliare.indirizzo_sitad, sigit_t_unita_immobiliare.indirizzo_non_trovato) AS indirizzo_unita_immob,
    sigit_t_unita_immobiliare.civico,
    sigit_t_unita_immobiliare.sezione,
    sigit_t_unita_immobiliare.foglio,
    sigit_t_unita_immobiliare.particella,
    sigit_t_unita_immobiliare.subalterno,
    sigit_t_unita_immobiliare.pod_elettrico,
    sigit_t_unita_immobiliare.pdr_gas,
    q_pf_ruolo.id_pf_responsabile,
    q_pg_ruolo.id_pg_responsabile,
    q_contratto.id_pg_3r,
    COALESCE(q_pf_ruolo.denominazione_resp, q_pg_ruolo.denominazione_resp::text, q_pf_ruolo.denominazione_resp) AS denominazione_responsabile,
    q_contratto.denominazione_3_responsabile,
    q_contratto.sigla_rea_3r,
    q_contratto.numero_rea_3r,
    q_contratto.codice_fiscale_3r,
    COALESCE(q_pf_ruolo.codice_fisc, q_pg_ruolo.codice_fisc, q_pf_ruolo.codice_fisc) AS codice_fiscale,
    COALESCE(q_pf_ruolo.data_fine_pfpg, q_pg_ruolo.data_fine_pfpg, q_pf_ruolo.data_fine_pfpg) AS data_fine_pfpg,
    COALESCE(q_pf_ruolo.ruolo_resp, q_pg_ruolo.ruolo_resp, q_pf_ruolo.ruolo_resp) AS ruolo_responsabile,
    COALESCE(q_pf_ruolo.ruolo_funz1, q_pg_ruolo.ruolo_funz1, q_pf_ruolo.ruolo_funz1) AS ruolo_funz,
    COALESCE(q_pf_ruolo.des_ruolo1, q_pg_ruolo.des_ruolo1, q_pf_ruolo.des_ruolo1) AS des_ruolo,
    sigit_t_impianto.flg_tipo_impianto,
    sigit_t_impianto.flg_apparecc_ui_ext,
    sigit_t_impianto.flg_contabilizzazione,
    sigit_d_stato_imp.des_stato,
    sigit_t_unita_immobiliare.fk_l2,
    sigit_t_impianto.flg_visu_proprietario,
    sigit_t_unita_immobiliare.l1_2_fk_categoria,
    q_pf_ruolo.INDIRIZZO_RESPONSABILE_PF,
    q_pf_ruolo.civico CIVICO_PF,
    q_pf_ruolo.cap CAP_PF,
    q_pf_ruolo.comune COMUNE_PF,
    q_pg_ruolo.INDIRIZZO_RESPONSABILE_PG,
    q_pg_ruolo.civico CIVICO_PG,
    q_pg_ruolo.cap CAP_PG,
    q_pg_ruolo.comune COMUNE_PG,
    q_contratto.INDIRIZZO_RESPONSABILE_3R,
    q_contratto.civico CIVICO_3R,
    q_contratto.cap CAP_3R,
    q_contratto.comune COMUNE_3R,
	sigit_t_impianto.flg_no_opendata,
    q_pf_ruolo.provincia PROVINCIA_PF,
    q_pg_ruolo.provincia PROVINCIA_PG,
    q_contratto.provincia PROVINCIA_3R
   FROM sigit_t_impianto
     JOIN sigit_d_stato_imp ON sigit_t_impianto.fk_stato = sigit_d_stato_imp.id_stato
     JOIN sigit_t_unita_immobiliare ON sigit_t_impianto.codice_impianto = sigit_t_unita_immobiliare.codice_impianto
     LEFT JOIN ( 
     SELECT sigit_r_imp_ruolo_pfpg_1.id_imp_ruolo_pfpg,
            sigit_r_imp_ruolo_pfpg_1.codice_impianto,
            sigit_r_imp_ruolo_pfpg_1.data_fine AS data_fine_pfpg,
            sigit_t_persona_fisica.id_persona_fisica AS id_pf_responsabile,
            sigit_t_persona_fisica.codice_fiscale AS codice_fisc,
            (COALESCE(sigit_t_persona_fisica.cognome, ' '::character varying)::text || ' '::text) || COALESCE(sigit_t_persona_fisica.nome, ' '::character varying)::text AS denominazione_resp,
            sigit_r_imp_ruolo_pfpg_1.fk_ruolo AS ruolo_resp,
            sigit_d_ruolo.ruolo_funz AS ruolo_funz1,
            sigit_d_ruolo.des_ruolo AS des_ruolo1,
            now() AS data_validita,
            sigit_r_imp_ruolo_pfpg_1.data_inizio,
            sigit_r_imp_ruolo_pfpg_1.data_fine,
            (coalesce(sigit_t_persona_fisica.INDIRIZZO_SITAD, ''::character varying)::text || ' '::text)|| coalesce(sigit_t_persona_fisica.INDIRIZZO_NON_TROVATO, ''::character varying)::text as INDIRIZZO_RESPONSABILE_PF,
    		sigit_t_persona_fisica.civico,
    		sigit_t_persona_fisica.cap,
    		sigit_t_persona_fisica.comune,
    		sigit_t_persona_fisica.provincia
           FROM sigit_d_ruolo
             JOIN (sigit_r_imp_ruolo_pfpg sigit_r_imp_ruolo_pfpg_1
             JOIN sigit_t_persona_fisica ON sigit_r_imp_ruolo_pfpg_1.fk_persona_fisica = sigit_t_persona_fisica.id_persona_fisica) ON sigit_d_ruolo.id_ruolo = sigit_r_imp_ruolo_pfpg_1.fk_ruolo
          WHERE (sigit_r_imp_ruolo_pfpg_1.fk_ruolo = ANY (ARRAY[4::numeric, 5::numeric, 10::numeric, 11::numeric, 12::numeric, 13::numeric])) AND sigit_r_imp_ruolo_pfpg_1.data_inizio <= now() AND now() <= COALESCE(sigit_r_imp_ruolo_pfpg_1.data_fine::timestamp with time zone, now(), sigit_r_imp_ruolo_pfpg_1.data_fine::timestamp with time zone)) q_pf_ruolo ON sigit_t_impianto.codice_impianto = q_pf_ruolo.codice_impianto
     LEFT JOIN ( SELECT sigit_r_imp_ruolo_pfpg.id_imp_ruolo_pfpg,
            sigit_r_imp_ruolo_pfpg.codice_impianto,
            sigit_r_imp_ruolo_pfpg.data_fine AS data_fine_pfpg,
            sigit_t_persona_giuridica.id_persona_giuridica AS id_pg_responsabile,
            sigit_t_persona_giuridica.codice_fiscale AS codice_fisc,
            sigit_t_persona_giuridica.denominazione AS denominazione_resp,
            sigit_r_imp_ruolo_pfpg.fk_ruolo AS ruolo_resp,
            sigit_d_ruolo.ruolo_funz AS ruolo_funz1,
            sigit_d_ruolo.des_ruolo AS des_ruolo1,
            now() AS data_validita,
            sigit_r_imp_ruolo_pfpg.data_inizio,
            sigit_r_imp_ruolo_pfpg.data_fine,
            (coalesce(sigit_t_persona_giuridica.INDIRIZZO_SITAD, ''::character varying)::text || ' '::text)|| coalesce(sigit_t_persona_giuridica.INDIRIZZO_NON_TROVATO, ''::character varying)::text as INDIRIZZO_RESPONSABILE_PG,
    		sigit_t_persona_giuridica.civico,
    		sigit_t_persona_giuridica.cap,
    		sigit_t_persona_giuridica.comune,
    		sigit_t_persona_giuridica.provincia
           FROM sigit_d_ruolo
             JOIN sigit_r_imp_ruolo_pfpg ON sigit_d_ruolo.id_ruolo = sigit_r_imp_ruolo_pfpg.fk_ruolo
             JOIN sigit_t_persona_giuridica ON sigit_r_imp_ruolo_pfpg.fk_persona_giuridica = sigit_t_persona_giuridica.id_persona_giuridica
          WHERE (sigit_r_imp_ruolo_pfpg.fk_ruolo = ANY (ARRAY[4::numeric, 5::numeric, 10::numeric, 11::numeric, 12::numeric, 13::numeric])) AND sigit_r_imp_ruolo_pfpg.data_inizio <= now() AND now() <= COALESCE(sigit_r_imp_ruolo_pfpg.data_fine::timestamp with time zone, now(), sigit_r_imp_ruolo_pfpg.data_fine::timestamp with time zone)) q_pg_ruolo ON sigit_t_impianto.codice_impianto = q_pg_ruolo.codice_impianto
     LEFT JOIN ( SELECT sigit_t_contratto_2019.id_contratto,
            sigit_t_contratto_2019.codice_impianto,
            sigit_t_contratto_2019.data_cessazione,
            sigit_t_contratto_2019.flg_tacito_rinnovo,
            sigit_t_contratto_2019.data_inizio,
            sigit_t_persona_giuridica_1.id_persona_giuridica AS id_pg_3r,
            sigit_t_persona_giuridica_1.denominazione AS denominazione_3_responsabile,
            sigit_t_persona_giuridica_1.sigla_rea AS sigla_rea_3r,
            sigit_t_persona_giuridica_1.numero_rea AS numero_rea_3r,
            sigit_t_persona_giuridica_1.codice_fiscale AS codice_fiscale_3r,
            (coalesce(sigit_t_persona_giuridica_1.INDIRIZZO_SITAD, ''::character varying)::text || ' '::text)|| coalesce(sigit_t_persona_giuridica_1.INDIRIZZO_NON_TROVATO, ''::character varying)::text as INDIRIZZO_RESPONSABILE_3R,
    		sigit_t_persona_giuridica_1.civico,
    		sigit_t_persona_giuridica_1.cap,
    		sigit_t_persona_giuridica_1.comune,
    		sigit_t_persona_giuridica_1.provincia
           FROM sigit_t_contratto_2019
             JOIN sigit_t_persona_giuridica sigit_t_persona_giuridica_1 ON sigit_t_contratto_2019.fk_pg_3_resp = sigit_t_persona_giuridica_1.id_persona_giuridica
          WHERE sigit_t_contratto_2019.data_cessazione IS NULL AND (sigit_t_contratto_2019.flg_tacito_rinnovo = 1::numeric OR sigit_t_contratto_2019.flg_tacito_rinnovo = 0::numeric AND sigit_t_contratto_2019.data_fine >= now()::date)) q_contratto ON sigit_t_impianto.codice_impianto = q_contratto.codice_impianto
  WHERE sigit_t_unita_immobiliare.flg_principale = 1::numeric;
  
 -- Permissions

ALTER TABLE sigit_new.vista_ricerca_impianti OWNER TO sigit_new;
GRANT ALL ON TABLE sigit_new.vista_ricerca_impianti TO sigit_new;
GRANT INSERT, SELECT, UPDATE, DELETE ON TABLE sigit_new.vista_ricerca_impianti TO sigit_new_rw;

drop VIEW sigit_new.vmv_vista_ricerca_impianti;

drop MATERIALIZED VIEW sigit_new.mv_vista_ricerca_impianti;

CREATE MATERIALIZED VIEW sigit_new.mv_vista_ricerca_impianti
TABLESPACE pg_default
AS SELECT DISTINCT sigit_t_impianto.codice_impianto,
    sigit_t_impianto.istat_comune,
    sigit_t_impianto.denominazione_comune,
    sigit_t_impianto.sigla_provincia,
    sigit_t_impianto.denominazione_provincia,
    sigit_t_impianto.fk_stato,
    sigit_t_impianto.l1_3_pot_h2o_kw,
    sigit_t_impianto.l1_3_pot_clima_inv_kw,
    sigit_t_impianto.l1_3_pot_clima_est_kw,
    sigit_t_unita_immobiliare.flg_nopdr,
    COALESCE(sigit_t_unita_immobiliare.indirizzo_sitad, sigit_t_unita_immobiliare.indirizzo_non_trovato) AS indirizzo_unita_immob,
    sigit_t_unita_immobiliare.civico,
    sigit_t_unita_immobiliare.sezione,
    sigit_t_unita_immobiliare.foglio,
    sigit_t_unita_immobiliare.particella,
    sigit_t_unita_immobiliare.subalterno,
    sigit_t_unita_immobiliare.pod_elettrico,
    sigit_t_unita_immobiliare.pdr_gas,
    q_pf_ruolo.id_pf_responsabile,
    q_pg_ruolo.id_pg_responsabile,
    q_contratto.id_pg_3r,
    COALESCE(q_pf_ruolo.denominazione_resp, q_pg_ruolo.denominazione_resp::text, q_pf_ruolo.denominazione_resp) AS denominazione_responsabile,
    q_contratto.denominazione_3_responsabile,
    q_contratto.sigla_rea_3r,
    q_contratto.numero_rea_3r,
    q_contratto.codice_fiscale_3r,
    COALESCE(q_pf_ruolo.codice_fisc, q_pg_ruolo.codice_fisc, q_pf_ruolo.codice_fisc) AS codice_fiscale,
    COALESCE(q_pf_ruolo.data_fine_pfpg, q_pg_ruolo.data_fine_pfpg, q_pf_ruolo.data_fine_pfpg) AS data_fine_pfpg,
    COALESCE(q_pf_ruolo.ruolo_resp, q_pg_ruolo.ruolo_resp, q_pf_ruolo.ruolo_resp) AS ruolo_responsabile,
    COALESCE(q_pf_ruolo.ruolo_funz1, q_pg_ruolo.ruolo_funz1, q_pf_ruolo.ruolo_funz1) AS ruolo_funz,
    COALESCE(q_pf_ruolo.des_ruolo1, q_pg_ruolo.des_ruolo1, q_pf_ruolo.des_ruolo1) AS des_ruolo,
    sigit_t_impianto.flg_tipo_impianto,
    sigit_t_impianto.flg_apparecc_ui_ext,
    sigit_t_impianto.flg_contabilizzazione,
    sigit_d_stato_imp.des_stato,
    sigit_t_unita_immobiliare.fk_l2,
    sigit_t_impianto.flg_visu_proprietario,
    sigit_t_unita_immobiliare.l1_2_fk_categoria,
    q_pf_ruolo.INDIRIZZO_RESPONSABILE_PF,
    q_pf_ruolo.civico CIVICO_PF,
    q_pf_ruolo.cap CAP_PF,
    q_pf_ruolo.comune COMUNE_PF,
    q_pg_ruolo.INDIRIZZO_RESPONSABILE_PG,
    q_pg_ruolo.civico CIVICO_PG,
    q_pg_ruolo.cap CAP_PG,
    q_pg_ruolo.comune COMUNE_PG,
    q_contratto.INDIRIZZO_RESPONSABILE_3R,
    q_contratto.civico CIVICO_3R,
    q_contratto.cap CAP_3R,
    q_contratto.comune COMUNE_3R,
	sigit_t_impianto.flg_no_opendata,
    q_pf_ruolo.provincia PROVINCIA_PF,
    q_pg_ruolo.provincia PROVINCIA_PG,
    q_contratto.provincia PROVINCIA_3R
   FROM sigit_t_impianto
     JOIN sigit_d_stato_imp ON sigit_t_impianto.fk_stato = sigit_d_stato_imp.id_stato
     JOIN sigit_t_unita_immobiliare ON sigit_t_impianto.codice_impianto = sigit_t_unita_immobiliare.codice_impianto
     LEFT JOIN ( 
     SELECT sigit_r_imp_ruolo_pfpg_1.id_imp_ruolo_pfpg,
            sigit_r_imp_ruolo_pfpg_1.codice_impianto,
            sigit_r_imp_ruolo_pfpg_1.data_fine AS data_fine_pfpg,
            sigit_t_persona_fisica.id_persona_fisica AS id_pf_responsabile,
            sigit_t_persona_fisica.codice_fiscale AS codice_fisc,
            (COALESCE(sigit_t_persona_fisica.cognome, ' '::character varying)::text || ' '::text) || COALESCE(sigit_t_persona_fisica.nome, ' '::character varying)::text AS denominazione_resp,
            sigit_r_imp_ruolo_pfpg_1.fk_ruolo AS ruolo_resp,
            sigit_d_ruolo.ruolo_funz AS ruolo_funz1,
            sigit_d_ruolo.des_ruolo AS des_ruolo1,
            now() AS data_validita,
            sigit_r_imp_ruolo_pfpg_1.data_inizio,
            sigit_r_imp_ruolo_pfpg_1.data_fine,
            (coalesce(sigit_t_persona_fisica.INDIRIZZO_SITAD, ''::character varying)::text || ' '::text)|| coalesce(sigit_t_persona_fisica.INDIRIZZO_NON_TROVATO, ''::character varying)::text as INDIRIZZO_RESPONSABILE_PF,
    		sigit_t_persona_fisica.civico,
    		sigit_t_persona_fisica.cap,
    		sigit_t_persona_fisica.comune,
    		sigit_t_persona_fisica.provincia
           FROM sigit_d_ruolo
             JOIN (sigit_r_imp_ruolo_pfpg sigit_r_imp_ruolo_pfpg_1
             JOIN sigit_t_persona_fisica ON sigit_r_imp_ruolo_pfpg_1.fk_persona_fisica = sigit_t_persona_fisica.id_persona_fisica) ON sigit_d_ruolo.id_ruolo = sigit_r_imp_ruolo_pfpg_1.fk_ruolo
          WHERE (sigit_r_imp_ruolo_pfpg_1.fk_ruolo = ANY (ARRAY[4::numeric, 5::numeric, 10::numeric, 11::numeric, 12::numeric, 13::numeric])) AND sigit_r_imp_ruolo_pfpg_1.data_inizio <= now() AND now() <= COALESCE(sigit_r_imp_ruolo_pfpg_1.data_fine::timestamp with time zone, now(), sigit_r_imp_ruolo_pfpg_1.data_fine::timestamp with time zone)) q_pf_ruolo ON sigit_t_impianto.codice_impianto = q_pf_ruolo.codice_impianto
     LEFT JOIN ( SELECT sigit_r_imp_ruolo_pfpg.id_imp_ruolo_pfpg,
            sigit_r_imp_ruolo_pfpg.codice_impianto,
            sigit_r_imp_ruolo_pfpg.data_fine AS data_fine_pfpg,
            sigit_t_persona_giuridica.id_persona_giuridica AS id_pg_responsabile,
            sigit_t_persona_giuridica.codice_fiscale AS codice_fisc,
            sigit_t_persona_giuridica.denominazione AS denominazione_resp,
            sigit_r_imp_ruolo_pfpg.fk_ruolo AS ruolo_resp,
            sigit_d_ruolo.ruolo_funz AS ruolo_funz1,
            sigit_d_ruolo.des_ruolo AS des_ruolo1,
            now() AS data_validita,
            sigit_r_imp_ruolo_pfpg.data_inizio,
            sigit_r_imp_ruolo_pfpg.data_fine,
            (coalesce(sigit_t_persona_giuridica.INDIRIZZO_SITAD, ''::character varying)::text || ' '::text)|| coalesce(sigit_t_persona_giuridica.INDIRIZZO_NON_TROVATO, ''::character varying)::text as INDIRIZZO_RESPONSABILE_PG,
    		sigit_t_persona_giuridica.civico,
    		sigit_t_persona_giuridica.cap,
    		sigit_t_persona_giuridica.comune,
    		sigit_t_persona_giuridica.provincia
           FROM sigit_d_ruolo
             JOIN sigit_r_imp_ruolo_pfpg ON sigit_d_ruolo.id_ruolo = sigit_r_imp_ruolo_pfpg.fk_ruolo
             JOIN sigit_t_persona_giuridica ON sigit_r_imp_ruolo_pfpg.fk_persona_giuridica = sigit_t_persona_giuridica.id_persona_giuridica
          WHERE (sigit_r_imp_ruolo_pfpg.fk_ruolo = ANY (ARRAY[4::numeric, 5::numeric, 10::numeric, 11::numeric, 12::numeric, 13::numeric])) AND sigit_r_imp_ruolo_pfpg.data_inizio <= now() AND now() <= COALESCE(sigit_r_imp_ruolo_pfpg.data_fine::timestamp with time zone, now(), sigit_r_imp_ruolo_pfpg.data_fine::timestamp with time zone)) q_pg_ruolo ON sigit_t_impianto.codice_impianto = q_pg_ruolo.codice_impianto
     LEFT JOIN ( SELECT sigit_t_contratto_2019.id_contratto,
            sigit_t_contratto_2019.codice_impianto,
            sigit_t_contratto_2019.data_cessazione,
            sigit_t_contratto_2019.flg_tacito_rinnovo,
            sigit_t_contratto_2019.data_inizio,
            sigit_t_persona_giuridica_1.id_persona_giuridica AS id_pg_3r,
            sigit_t_persona_giuridica_1.denominazione AS denominazione_3_responsabile,
            sigit_t_persona_giuridica_1.sigla_rea AS sigla_rea_3r,
            sigit_t_persona_giuridica_1.numero_rea AS numero_rea_3r,
            sigit_t_persona_giuridica_1.codice_fiscale AS codice_fiscale_3r,
            (coalesce(sigit_t_persona_giuridica_1.INDIRIZZO_SITAD, ''::character varying)::text || ' '::text)|| coalesce(sigit_t_persona_giuridica_1.INDIRIZZO_NON_TROVATO, ''::character varying)::text as INDIRIZZO_RESPONSABILE_3R,
    		sigit_t_persona_giuridica_1.civico,
    		sigit_t_persona_giuridica_1.cap,
    		sigit_t_persona_giuridica_1.comune,
    		sigit_t_persona_giuridica_1.provincia
           FROM sigit_t_contratto_2019
             JOIN sigit_t_persona_giuridica sigit_t_persona_giuridica_1 ON sigit_t_contratto_2019.fk_pg_3_resp = sigit_t_persona_giuridica_1.id_persona_giuridica
          WHERE sigit_t_contratto_2019.data_cessazione IS NULL AND (sigit_t_contratto_2019.flg_tacito_rinnovo = 1::numeric OR sigit_t_contratto_2019.flg_tacito_rinnovo = 0::numeric AND sigit_t_contratto_2019.data_fine >= now()::date)) q_contratto ON sigit_t_impianto.codice_impianto = q_contratto.codice_impianto
  WHERE sigit_t_unita_immobiliare.flg_principale = 1::numeric
  WITH DATA;

 -- Permissions

ALTER TABLE sigit_new.mv_vista_ricerca_impianti OWNER TO sigit_new;
GRANT ALL ON TABLE sigit_new.mv_vista_ricerca_impianti TO sigit_new;
GRANT INSERT, SELECT, UPDATE, DELETE ON TABLE sigit_new.mv_vista_ricerca_impianti TO sigit_new_rw;

CREATE OR REPLACE VIEW sigit_new.vmv_vista_ricerca_impianti
AS SELECT mv_vista_ricerca_impianti.codice_impianto,
    mv_vista_ricerca_impianti.istat_comune,
    mv_vista_ricerca_impianti.denominazione_comune,
    mv_vista_ricerca_impianti.sigla_provincia,
    mv_vista_ricerca_impianti.denominazione_provincia,
    mv_vista_ricerca_impianti.fk_stato,
    mv_vista_ricerca_impianti.l1_3_pot_h2o_kw,
    mv_vista_ricerca_impianti.l1_3_pot_clima_inv_kw,
    mv_vista_ricerca_impianti.l1_3_pot_clima_est_kw,
    mv_vista_ricerca_impianti.flg_nopdr,
    mv_vista_ricerca_impianti.indirizzo_unita_immob,
    mv_vista_ricerca_impianti.civico,
    mv_vista_ricerca_impianti.sezione,
    mv_vista_ricerca_impianti.foglio,
    mv_vista_ricerca_impianti.particella,
    mv_vista_ricerca_impianti.subalterno,
    mv_vista_ricerca_impianti.pod_elettrico,
    mv_vista_ricerca_impianti.pdr_gas,
    mv_vista_ricerca_impianti.id_pf_responsabile,
    mv_vista_ricerca_impianti.id_pg_responsabile,
    mv_vista_ricerca_impianti.id_pg_3r,
    mv_vista_ricerca_impianti.denominazione_responsabile,
    mv_vista_ricerca_impianti.denominazione_3_responsabile,
    mv_vista_ricerca_impianti.sigla_rea_3r,
    mv_vista_ricerca_impianti.numero_rea_3r,
    mv_vista_ricerca_impianti.codice_fiscale_3r,
    mv_vista_ricerca_impianti.codice_fiscale,
    mv_vista_ricerca_impianti.data_fine_pfpg,
    mv_vista_ricerca_impianti.ruolo_responsabile,
    mv_vista_ricerca_impianti.ruolo_funz,
    mv_vista_ricerca_impianti.des_ruolo,
    mv_vista_ricerca_impianti.flg_tipo_impianto,
    mv_vista_ricerca_impianti.flg_apparecc_ui_ext,
    mv_vista_ricerca_impianti.flg_contabilizzazione,
    mv_vista_ricerca_impianti.des_stato,
    mv_vista_ricerca_impianti.fk_l2,
    mv_vista_ricerca_impianti.flg_visu_proprietario,
    mv_vista_ricerca_impianti.l1_2_fk_categoria,
    mv_vista_ricerca_impianti.INDIRIZZO_RESPONSABILE_PF,
    mv_vista_ricerca_impianti.CIVICO_PF,
    mv_vista_ricerca_impianti.CAP_PF,
    mv_vista_ricerca_impianti.COMUNE_PF,
    mv_vista_ricerca_impianti.INDIRIZZO_RESPONSABILE_PG,
    mv_vista_ricerca_impianti.CIVICO_PG,
    mv_vista_ricerca_impianti.CAP_PG,
    mv_vista_ricerca_impianti.COMUNE_PG,
    mv_vista_ricerca_impianti.INDIRIZZO_RESPONSABILE_3R,
    mv_vista_ricerca_impianti.CIVICO_3R,
    mv_vista_ricerca_impianti.CAP_3R,
    mv_vista_ricerca_impianti.COMUNE_3R,
	mv_vista_ricerca_impianti.flg_no_opendata,
    mv_vista_ricerca_impianti.PROVINCIA_PF,
    mv_vista_ricerca_impianti.PROVINCIA_PG,
    mv_vista_ricerca_impianti.PROVINCIA_3R
   FROM mv_vista_ricerca_impianti;

-- Permissions

ALTER TABLE sigit_new.vmv_vista_ricerca_impianti OWNER TO sigit_new;
GRANT ALL ON TABLE sigit_new.vmv_vista_ricerca_impianti TO sigit_new;
GRANT INSERT, SELECT, UPDATE, DELETE ON TABLE sigit_new.vmv_vista_ricerca_impianti TO sigit_new_rw;

----------------------------------------------------------------------------------------
-- 03/06/2021  Lorita
-- Modifica viste od_vista_dettaglio_impianti aggiungendo vari campi
--  come da mail di Mariuccia del 28/5/2021 15:04
----------------------------------------------------------------------------------------
CREATE OR REPLACE VIEW sigit_new.od_vista_dettaglio_impianti
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
	ui.pdr_gas
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
  GROUP BY i.codice_impianto, i.denominazione_comune, i.denominazione_provincia, ui.l1_2_fk_categoria, ui.l1_2_vol_risc_m3, ui.l1_2_vol_raff_m3, i.l1_3_pot_h2o_kw, i.l1_3_pot_clima_inv_kw, i.l1_3_pot_clima_est_kw, gt.id_tipo_componente, gt.progressivo, gt.data_install, gt.des_marca, gt.des_combustibile, gt.des_dettaglio_gt, gt.potenza_termica_kw, gt.rendimento_perc, gt.data_controllo, gt.e_nox_ppm, gt.e_nox_mg_kwh, gt.e_n_modulo_termico,
  			i.flg_no_opendata,COALESCE(ui.indirizzo_sitad, ui.indirizzo_non_trovato),ui.civico,ui.sezione,ui.foglio,ui.particella,ui.subalterno,ui.pod_elettrico,ui.pdr_gas
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
	ui.pdr_gas
   FROM sigit_t_impianto i
     JOIN sigit_t_unita_immobiliare ui ON i.codice_impianto = ui.codice_impianto
     JOIN vista_dw_sk4_gf gf ON i.codice_impianto = gf.codice_impianto
  WHERE gf.data_dismiss IS NULL AND ui.flg_principale = 1::numeric AND i.fk_stato = 1::numeric
  GROUP BY i.codice_impianto, i.denominazione_comune, i.denominazione_provincia, ui.l1_2_fk_categoria, ui.l1_2_vol_risc_m3, ui.l1_2_vol_raff_m3, i.l1_3_pot_h2o_kw, i.l1_3_pot_clima_inv_kw, i.l1_3_pot_clima_est_kw, gf.id_tipo_componente, gf.progressivo, gf.data_install, gf.des_marca, gf.des_combustibile, NULL::text, gf.potenza_termica_kw,
  			i.flg_no_opendata,COALESCE(ui.indirizzo_sitad, ui.indirizzo_non_trovato),ui.civico,ui.sezione,ui.foglio,ui.particella,ui.subalterno,ui.pod_elettrico,ui.pdr_gas
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
	ui.pdr_gas
   FROM sigit_t_impianto i
     JOIN sigit_t_unita_immobiliare ui ON i.codice_impianto = ui.codice_impianto
     JOIN vista_dw_sk4_sc sc ON i.codice_impianto = sc.codice_impianto
  WHERE sc.data_dismiss IS NULL AND ui.flg_principale = 1::numeric AND i.fk_stato = 1::numeric
  GROUP BY i.codice_impianto, i.denominazione_comune, i.denominazione_provincia, ui.l1_2_fk_categoria, ui.l1_2_vol_risc_m3, ui.l1_2_vol_raff_m3, i.l1_3_pot_h2o_kw, i.l1_3_pot_clima_inv_kw, i.l1_3_pot_clima_est_kw, sc.id_tipo_componente, sc.progressivo, sc.data_install, sc.des_marca, NULL::text, sc.potenza_termica_kw,
  			i.flg_no_opendata,COALESCE(ui.indirizzo_sitad, ui.indirizzo_non_trovato),ui.civico,ui.sezione,ui.foglio,ui.particella,ui.subalterno,ui.pod_elettrico,ui.pdr_gas
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
	ui.pdr_gas
   FROM sigit_t_impianto i
     JOIN sigit_t_unita_immobiliare ui ON i.codice_impianto = ui.codice_impianto
     JOIN vista_dw_sk4_cg cg ON i.codice_impianto = cg.codice_impianto
  WHERE cg.data_dismiss IS NULL AND ui.flg_principale = 1::numeric AND i.fk_stato = 1::numeric
  GROUP BY i.codice_impianto, i.denominazione_comune, i.denominazione_provincia, ui.l1_2_fk_categoria, ui.l1_2_vol_risc_m3, ui.l1_2_vol_raff_m3, i.l1_3_pot_h2o_kw, i.l1_3_pot_clima_inv_kw, i.l1_3_pot_clima_est_kw, cg.id_tipo_componente, cg.progressivo, cg.data_install, cg.des_marca, cg.des_combustibile, cg.potenza_termica_kw,
  			i.flg_no_opendata,COALESCE(ui.indirizzo_sitad, ui.indirizzo_non_trovato),ui.civico,ui.sezione,ui.foglio,ui.particella,ui.subalterno,ui.pod_elettrico,ui.pdr_gas;

-- Permissions

ALTER TABLE sigit_new.od_vista_dettaglio_impianti OWNER TO sigit_new;
GRANT ALL ON TABLE sigit_new.od_vista_dettaglio_impianti TO sigit_new;
GRANT INSERT, SELECT, UPDATE, DELETE ON TABLE sigit_new.od_vista_dettaglio_impianti TO sigit_new_rw;

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
	ui.pdr_gas
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
  GROUP BY i.codice_impianto, i.denominazione_comune, i.denominazione_provincia, ui.l1_2_fk_categoria, ui.l1_2_vol_risc_m3, ui.l1_2_vol_raff_m3, i.l1_3_pot_h2o_kw, i.l1_3_pot_clima_inv_kw, i.l1_3_pot_clima_est_kw, gt.id_tipo_componente, gt.progressivo, gt.data_install, gt.des_marca, gt.des_combustibile, gt.des_dettaglio_gt, gt.potenza_termica_kw, gt.rendimento_perc, gt.data_controllo, gt.e_nox_ppm, gt.e_nox_mg_kwh, gt.e_n_modulo_termico,
  			i.flg_no_opendata,COALESCE(ui.indirizzo_sitad, ui.indirizzo_non_trovato),ui.civico,ui.sezione,ui.foglio,ui.particella,ui.subalterno,ui.pod_elettrico,ui.pdr_gas
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
	ui.pdr_gas
   FROM sigit_t_impianto i
     JOIN sigit_t_unita_immobiliare ui ON i.codice_impianto = ui.codice_impianto
     JOIN vista_dw_sk4_gf gf ON i.codice_impianto = gf.codice_impianto
  WHERE gf.data_dismiss IS NULL AND ui.flg_principale = 1::numeric AND i.fk_stato = 1::numeric
  GROUP BY i.codice_impianto, i.denominazione_comune, i.denominazione_provincia, ui.l1_2_fk_categoria, ui.l1_2_vol_risc_m3, ui.l1_2_vol_raff_m3, i.l1_3_pot_h2o_kw, i.l1_3_pot_clima_inv_kw, i.l1_3_pot_clima_est_kw, gf.id_tipo_componente, gf.progressivo, gf.data_install, gf.des_marca, gf.des_combustibile, NULL::text, gf.potenza_termica_kw,
  			i.flg_no_opendata,COALESCE(ui.indirizzo_sitad, ui.indirizzo_non_trovato),ui.civico,ui.sezione,ui.foglio,ui.particella,ui.subalterno,ui.pod_elettrico,ui.pdr_gas
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
	ui.pdr_gas
   FROM sigit_t_impianto i
     JOIN sigit_t_unita_immobiliare ui ON i.codice_impianto = ui.codice_impianto
     JOIN vista_dw_sk4_sc sc ON i.codice_impianto = sc.codice_impianto
  WHERE sc.data_dismiss IS NULL AND ui.flg_principale = 1::numeric AND i.fk_stato = 1::numeric
  GROUP BY i.codice_impianto, i.denominazione_comune, i.denominazione_provincia, ui.l1_2_fk_categoria, ui.l1_2_vol_risc_m3, ui.l1_2_vol_raff_m3, i.l1_3_pot_h2o_kw, i.l1_3_pot_clima_inv_kw, i.l1_3_pot_clima_est_kw, sc.id_tipo_componente, sc.progressivo, sc.data_install, sc.des_marca, NULL::text, sc.potenza_termica_kw,
  			i.flg_no_opendata,COALESCE(ui.indirizzo_sitad, ui.indirizzo_non_trovato),ui.civico,ui.sezione,ui.foglio,ui.particella,ui.subalterno,ui.pod_elettrico,ui.pdr_gas
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
	ui.pdr_gas
   FROM sigit_t_impianto i
     JOIN sigit_t_unita_immobiliare ui ON i.codice_impianto = ui.codice_impianto
     JOIN vista_dw_sk4_cg cg ON i.codice_impianto = cg.codice_impianto
  WHERE cg.data_dismiss IS NULL AND ui.flg_principale = 1::numeric AND i.fk_stato = 1::numeric
  GROUP BY i.codice_impianto, i.denominazione_comune, i.denominazione_provincia, ui.l1_2_fk_categoria, ui.l1_2_vol_risc_m3, ui.l1_2_vol_raff_m3, i.l1_3_pot_h2o_kw, i.l1_3_pot_clima_inv_kw, i.l1_3_pot_clima_est_kw, cg.id_tipo_componente, cg.progressivo, cg.data_install, cg.des_marca, cg.des_combustibile, cg.potenza_termica_kw,
  			i.flg_no_opendata,COALESCE(ui.indirizzo_sitad, ui.indirizzo_non_trovato),ui.civico,ui.sezione,ui.foglio,ui.particella,ui.subalterno,ui.pod_elettrico,ui.pdr_gas
WITH DATA;

-- Permissions

ALTER TABLE sigit_new.mv_od_vista_dettaglio_impianti OWNER TO sigit_new;
GRANT ALL ON TABLE sigit_new.mv_od_vista_dettaglio_impianti TO sigit_new;
GRANT ALL ON TABLE sigit_new.mv_od_vista_dettaglio_impianti TO sigit_new_rw;

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
	mv_od_vista_dettaglio_impianti.pdr_gas
   FROM mv_od_vista_dettaglio_impianti;

-- Permissions

ALTER TABLE sigit_new.vmv_od_vista_dettaglio_impianti OWNER TO sigit_new;
GRANT ALL ON TABLE sigit_new.vmv_od_vista_dettaglio_impianti TO sigit_new;
GRANT INSERT, SELECT, UPDATE, DELETE ON TABLE sigit_new.vmv_od_vista_dettaglio_impianti TO sigit_new_rw;


----------------------------------------------------------------------------------------
-- 15/06/2021  Lorita
-- Modifica aggiunga gestione tipo 1B
--  come da mail di Mariuccia del 10/6/2021 16:58 e 11/6/2021 11:23
----------------------------------------------------------------------------------------
/* ---------------------------------------------------------------------- */
/* Script generated with: DeZign for Databases 12.2.0                     */
/* Target DBMS:           PostgreSQL 9                                    */
/* Project file:          SIGIT_V19.dez                                   */
/* Project name:                                                          */
/* Author:                                                                */
/* Script type:           Database creation script                        */
/* Created on:            2021-06-11 18:53                                */
/* ---------------------------------------------------------------------- */


/* ---------------------------------------------------------------------- */
/* Add tables                                                             */
/* ---------------------------------------------------------------------- */

/* ---------------------------------------------------------------------- */
/* Add table "sigit_d_tipo_consumo_1B"                                    */
/* ---------------------------------------------------------------------- */

CREATE TABLE sigit_d_tipo_consumo_1B (
    id_tipo_consumo_1b NUMERIC  NOT NULL,
    desc_tipo_consumo_1b CHARACTER VARYING(100),
    CONSTRAINT PK_sigit_d_tipo_consumo_1B PRIMARY KEY (id_tipo_consumo_1b)
);

/* ---------------------------------------------------------------------- */
/* Add table "sigit_d_stelle"                                             */
/* ---------------------------------------------------------------------- */

CREATE TABLE sigit_d_stelle (
    id_stelle NUMERIC  NOT NULL,
    desc_stelle CHARACTER VARYING(100),
    CONSTRAINT PK_sigit_d_stelle PRIMARY KEY (id_stelle)
);

/* ---------------------------------------------------------------------- */
/* Add table "sigit_d_tipo_1B"                                            */
/* ---------------------------------------------------------------------- */

CREATE TABLE sigit_d_tipo_1B (
    id_tipo_1b NUMERIC  NOT NULL,
    desc_tipo_1b CHARACTER VARYING(100),
    CONSTRAINT PK_sigit_d_tipo_1B PRIMARY KEY (id_tipo_1b)
);

/* ---------------------------------------------------------------------- */
/* Add table "sigit_d_aria_comburente"                                    */
/* ---------------------------------------------------------------------- */

CREATE TABLE sigit_d_aria_comburente (
    id_aria_comburente NUMERIC  NOT NULL,
    desc_aria_comburente CHARACTER(100),
    CONSTRAINT PK_sigit_d_aria_comburente PRIMARY KEY (id_aria_comburente)
);

/* ---------------------------------------------------------------------- */
/* Add table "sigit_d_controllo_aria"                                     */
/* ---------------------------------------------------------------------- */

CREATE TABLE sigit_d_controllo_aria (
    id_controllo_aria NUMERIC  NOT NULL,
    desc_controllo_aria CHARACTER VARYING(100),
    CONSTRAINT PK_sigit_d_controllo_aria PRIMARY KEY (id_controllo_aria)
);

/* ---------------------------------------------------------------------- */
/* Add table "sigit_d_tipo_caric_combu"                                   */
/* ---------------------------------------------------------------------- */

CREATE TABLE sigit_d_tipo_caric_combu (
    id_tipo_caric_combu NUMERIC  NOT NULL,
    desc_tipo_caric_combu CHARACTER VARYING(100),
    CONSTRAINT PK_sigit_d_tipo_caric_combu PRIMARY KEY (id_tipo_caric_combu)
);

/* ---------------------------------------------------------------------- */
/* Add table "sigit_d_tipo_canna_fumaria"                                 */
/* ---------------------------------------------------------------------- */

CREATE TABLE sigit_d_tipo_canna_fumaria (
    id_tipo_canna_fumaria NUMERIC,
    desc_tipo_canna_fumaria CHARACTER VARYING(100),
    CONSTRAINT PK_sigit_d_tipo_canna_fumaria PRIMARY KEY (id_tipo_canna_fumaria)
);

/* ---------------------------------------------------------------------- */
/* Add table "sigit_d_fonte_en_sfruttata"                                 */
/* ---------------------------------------------------------------------- */

CREATE TABLE sigit_d_fonte_en_sfruttata (
    id_fonte_en_sfruttata NUMERIC  NOT NULL,
    desc_fonte_en_sfruttata CHARACTER VARYING(100),
    CONSTRAINT PK_sigit_d_fonte_en_sfruttata PRIMARY KEY (id_fonte_en_sfruttata)
);


/* ---------------------------------------------------------------------- */
/* Add table "sigit_t_consumo_tipo1B"                                     */
/* ---------------------------------------------------------------------- */

CREATE TABLE sigit_t_consumo_tipo1b (
    id_consumo_tipo1b NUMERIC  NOT NULL,
    esercizio NUMERIC,
    lettura_iniziale NUMERIC(10,2),
    lettura_finale NUMERIC(10,2),
    consumo NUMERIC(10,2),
    fk_allegato NUMERIC,
    id_tipo_consumo_1b NUMERIC,
    id_unita_misura CHARACTER VARYING(10),
    CONSTRAINT PK_sigit_t_consumo_tipo1B PRIMARY KEY (id_consumo_tipo1b)
);

/* sostituito da sequence creata dal fornitore
CREATE SEQUENCE sigit_t_consumo_tipo1b_id
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;
ALTER TABLE sigit_t_consumo_tipo1b_id OWNER TO sigit_new;
GRANT ALL ON SEQUENCE sigit_t_consumo_tipo1b_id TO sigit_new;
GRANT SELECT, UPDATE ON SEQUENCE sigit_t_consumo_tipo1b_id TO sigit_new_rw;

ALTER TABLE sigit_t_consumo_tipo1b 		ALTER COLUMN id_consumo_tipo1b 		SET DEFAULT NEXTVAL('sigit_t_consumo_tipo1b_id');
*/

/* ---------------------------------------------------------------------- */
/* Variazione tabelle esistenti                                           */
/* ---------------------------------------------------------------------- */
ALTER TABLE sigit_new.sigit_t_rapp_tipo1 ADD COLUMN id_stelle NUMERIC;
ALTER TABLE sigit_new.sigit_t_rapp_tipo1 ADD COLUMN id_tipo_1b NUMERIC;
ALTER TABLE sigit_new.sigit_t_rapp_tipo1 ADD COLUMN id_aria_comburente NUMERIC;
ALTER TABLE sigit_new.sigit_t_rapp_tipo1 ADD COLUMN id_controllo_aria NUMERIC;
ALTER TABLE sigit_new.sigit_t_rapp_tipo1 ADD COLUMN id_tipo_caric_combu NUMERIC;
ALTER TABLE sigit_new.sigit_t_rapp_tipo1 ADD COLUMN d_1b_flg_pulizia_camino NUMERIC(1);
ALTER TABLE sigit_new.sigit_t_rapp_tipo1 ADD COLUMN e_1b_flg_caldaia NUMERIC(1);
ALTER TABLE sigit_new.sigit_t_rapp_tipo1 ADD COLUMN e_1b_flg_stufa NUMERIC(1);
ALTER TABLE sigit_new.sigit_t_rapp_tipo1 ADD COLUMN e_1b_flg_stufa_accumulo NUMERIC(1);
ALTER TABLE sigit_new.sigit_t_rapp_tipo1 ADD COLUMN e_1b_flg_termocucina NUMERIC(1);
ALTER TABLE sigit_new.sigit_t_rapp_tipo1 ADD COLUMN e_1b_flg_caminetto_aperto NUMERIC(1);
ALTER TABLE sigit_new.sigit_t_rapp_tipo1 ADD COLUMN e_1b_flg_caminetto_chiuso NUMERIC(1);
ALTER TABLE sigit_new.sigit_t_rapp_tipo1 ADD COLUMN e_1b_flg_inserto_caminetto NUMERIC(1);
ALTER TABLE sigit_new.sigit_t_rapp_tipo1 ADD COLUMN e_1b_flg_stufa_assemblata NUMERIC(1);
ALTER TABLE sigit_new.sigit_t_rapp_tipo1 ADD COLUMN e_1b_flg_stufa_pellet NUMERIC(1);
ALTER TABLE sigit_new.sigit_t_rapp_tipo1 ADD COLUMN e_1b_flg_marcatura_ce NUMERIC(1);
ALTER TABLE sigit_new.sigit_t_rapp_tipo1 ADD COLUMN e_1b_flg_placca_camino NUMERIC(1);
ALTER TABLE sigit_new.sigit_t_rapp_tipo1 ADD     CONSTRAINT flg_1bPulCam_0_1_2 CHECK (d_1b_flg_pulizia_camino IN (0,1,2));
ALTER TABLE sigit_new.sigit_t_rapp_tipo1 ADD     CONSTRAINT flg_1bCald_0_1 CHECK (e_1b_flg_caldaia IN (0,1));
ALTER TABLE sigit_new.sigit_t_rapp_tipo1 ADD     CONSTRAINT flg_1bStuf_0_1 CHECK (e_1b_flg_stufa IN (0,1));
ALTER TABLE sigit_new.sigit_t_rapp_tipo1 ADD     CONSTRAINT flg_1bStufAcc_0_1 CHECK (e_1b_flg_stufa_accumulo IN (0,1));
ALTER TABLE sigit_new.sigit_t_rapp_tipo1 ADD     CONSTRAINT flg_1bTermocuc_0_1 CHECK (e_1b_flg_termocucina IN (0,1));
ALTER TABLE sigit_new.sigit_t_rapp_tipo1 ADD     CONSTRAINT flg_1bCaminAperto_0_1 CHECK (e_1b_flg_caminetto_aperto IN (0,1));
ALTER TABLE sigit_new.sigit_t_rapp_tipo1 ADD     CONSTRAINT flg_1bCaminChiuso_0_1 CHECK (e_1b_flg_caminetto_chiuso IN (0,1));
ALTER TABLE sigit_new.sigit_t_rapp_tipo1 ADD     CONSTRAINT flg_1bInsCamin_0_1 CHECK (e_1b_flg_inserto_caminetto IN (0,1));
ALTER TABLE sigit_new.sigit_t_rapp_tipo1 ADD     CONSTRAINT flg_1bStufAss_0_1 CHECK (e_1b_flg_stufa_assemblata IN (0,1));
ALTER TABLE sigit_new.sigit_t_rapp_tipo1 ADD     CONSTRAINT flg_1bStufPel_0_1 CHECK (e_1b_flg_stufa_pellet IN (0,1));
ALTER TABLE sigit_new.sigit_t_rapp_tipo1 ADD     CONSTRAINT flg_1bMarcaCE_0_1 CHECK (e_1b_flg_marcatura_ce IN (0,1));
ALTER TABLE sigit_new.sigit_t_rapp_tipo1 ADD     CONSTRAINT flg_1bPlaccaCam_0_1 CHECK (e_1b_flg_placca_camino IN (0,1));

ALTER TABLE sigit_new.sigit_t_dett_tipo1 ADD COLUMN e_1b_flg_cucina NUMERIC(1);
ALTER TABLE sigit_new.sigit_t_dett_tipo1 ADD COLUMN e_1b_flg_uni_10389_2 NUMERIC(1);
ALTER TABLE sigit_new.sigit_t_dett_tipo1 ADD COLUMN e_1b_particolato_mg_al_m3 NUMERIC;
ALTER TABLE sigit_new.sigit_t_dett_tipo1 ADD    CONSTRAINT flg_1bCucina_0_1 CHECK (e_1b_flg_cucina IN (0,1));
ALTER TABLE sigit_new.sigit_t_dett_tipo1 ADD    CONSTRAINT flg_1bUni10389_0_1_2 CHECK (e_1b_flg_uni_10389_2 IN (0,1,2));
--ALTER TABLE sigit_new.sigit_t_dett_tipo1 ADD    CONSTRAINT flg_1bEpartmgm3_0_1 CHECK (e_1b_particolato_mg_al_m3 IN (0,1));

ALTER TABLE sigit_new.sigit_t_comp_gf ADD COLUMN id_fonte_en_sfruttata NUMERIC;

ALTER TABLE sigit_new.sigit_t_comp_gt ADD COLUMN medi_imp_ore_operative NUMERIC(10,2);
ALTER TABLE sigit_new.sigit_t_comp_gt ADD COLUMN id_tipo_canna_fumaria NUMERIC;


/* ---------------------------------------------------------------------- */
/* Add foreign key constraints                                            */
/* ---------------------------------------------------------------------- */

ALTER TABLE sigit_new.sigit_t_rapp_tipo1 ADD CONSTRAINT sigit_d_stelle_sigit_t_rapp_tipo1 
    FOREIGN KEY (id_stelle) REFERENCES sigit_d_stelle (id_stelle);

ALTER TABLE sigit_new.sigit_t_rapp_tipo1 ADD CONSTRAINT sigit_d_tipo_1B_sigit_t_rapp_tipo1 
    FOREIGN KEY (id_tipo_1b) REFERENCES sigit_d_tipo_1B (id_tipo_1b);

ALTER TABLE sigit_new.sigit_t_rapp_tipo1 ADD CONSTRAINT sigit_d_aria_comburente_sigit_t_rapp_tipo1 
    FOREIGN KEY (id_aria_comburente) REFERENCES sigit_d_aria_comburente (id_aria_comburente);

ALTER TABLE sigit_new.sigit_t_rapp_tipo1 ADD CONSTRAINT sigit_d_controllo_aria_sigit_t_rapp_tipo1 
    FOREIGN KEY (id_controllo_aria) REFERENCES sigit_d_controllo_aria (id_controllo_aria);

ALTER TABLE sigit_new.sigit_t_rapp_tipo1 ADD CONSTRAINT sigit_d_tipo_caric_combu_sigit_t_rapp_tipo1 
    FOREIGN KEY (id_tipo_caric_combu) REFERENCES sigit_d_tipo_caric_combu (id_tipo_caric_combu);

ALTER TABLE sigit_t_consumo_tipo1b ADD CONSTRAINT sigit_t_rapp_tipo1_sigit_t_consumo_tipo1b 
    FOREIGN KEY (fk_allegato) REFERENCES sigit_new.sigit_t_rapp_tipo1 (id_allegato);

ALTER TABLE sigit_t_consumo_tipo1b ADD CONSTRAINT sigit_d_tipo_consumo_1b_sigit_t_consumo_tipo1b 
    FOREIGN KEY (id_tipo_consumo_1b) REFERENCES sigit_d_tipo_consumo_1b (id_tipo_consumo_1b);

ALTER TABLE sigit_t_consumo_tipo1b ADD CONSTRAINT sigit_d_unita_misura_sigit_t_consumo_tipo1b 
    FOREIGN KEY (id_unita_misura) REFERENCES sigit_new.sigit_d_unita_misura (id_unita_misura);

ALTER TABLE sigit_new.sigit_t_comp_gf ADD CONSTRAINT sigit_d_fonte_en_sfruttata_sigit_t_comp_gf 
    FOREIGN KEY (id_fonte_en_sfruttata) REFERENCES sigit_d_fonte_en_sfruttata (id_fonte_en_sfruttata);
	
ALTER TABLE sigit_new.sigit_t_comp_gt ADD CONSTRAINT sigit_d_tipo_canna_fumaria_sigit_t_comp_gt 
    FOREIGN KEY (id_tipo_canna_fumaria) REFERENCES sigit_d_tipo_canna_fumaria (id_tipo_canna_fumaria);

--------
INSERT INTO sigit_d_tipo_documento (id_tipo_documento,des_tipo_documento,flg_visu_elenco_all,flg_ricerca_all,flg_visu_elenco_rapprova,flg_visu_elenco_manut) VALUES 
(14,'Tipo 1 B',1,0,0,0);

INSERT INTO sigit_d_stelle (id_stelle,desc_stelle) VALUES 
(0,'Non applicabile'),
(3,'3 Stelle'),
(4,'4 Stelle'),
(5,'5 Stelle');

INSERT INTO sigit_d_tipo_1b (id_tipo_1b,desc_tipo_1b) VALUES 
(1,'tradizionale'),
(2,'a condensazione'),
(3,'altro');

INSERT INTO sigit_d_aria_comburente (id_aria_comburente,desc_aria_comburente) VALUES 
(1,'Da esterno'),
(2,'Dal locale installazione');

INSERT INTO sigit_d_controllo_aria (id_controllo_aria, desc_controllo_aria) VALUES
(1,'Automatico'),
(2,'Semiautomatico'),
(3,'Manuale');

INSERT INTO sigit_d_tipo_caric_combu (id_tipo_caric_combu, desc_tipo_caric_combu) VALUES
(1,'Automatico'),
(2,'Manuale'),
(3,'Automatico / Manuale');

INSERT INTO SIGIT_D_TIPO_CONSUMO_1B (id_tipo_consumo_1b, desc_tipo_consumo_1b) VALUES
(1,'Reintegro acqua'), 
(2,'Consumo biomassa');

INSERT INTO SIGIT_D_TIPO_CANNA_FUMARIA (id_tipo_canna_fumaria, desc_tipo_canna_fumaria) VALUES
(1,'Collettiva ramificata UNI 10640'),
(2,'Collettiva UNI 10641'),
(3,'Scarico a parete'),
(4,'Dedicata');

INSERT INTO SIGIT_D_FONTE_EN_SFRUTTATA (id_fonte_en_sfruttata, desc_fonte_en_sfruttata) VALUES
(1,'Aerotermica'),
(2,'Geotermica'),
(3,'Idrotermica');

----------------------------------------------------------------------------------------
-- 08/07/2021  Lorita
-- Modifiche varie fatte dal fornitore in mia assenza
--  come da mail di Beppe Todaro del 5/7/2021 10:42
----------------------------------------------------------------------------------------
/*Sequence Consumo Tipo1B*/
CREATE SEQUENCE sigit_new.seq_t_consumo_tipo1b
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1;

/* Modifica a vista sk4 GT*/
CREATE OR REPLACE VIEW sigit_new.vista_sk4_gt
AS SELECT DISTINCT sigit_t_comp_gt.codice_impianto,
    sigit_t_comp_gt.id_tipo_componente,
    sigit_t_comp_gt.progressivo,
    sigit_t_comp_gt.data_install,
    sigit_t_comp_gt.data_dismiss,
    sigit_t_comp_gt.tempo_manut_anni,
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
    sigit_t_allegato.id_allegato,
    sigit_t_allegato.fk_tipo_documento,
    sigit_d_tipo_documento.des_tipo_documento,
    sigit_t_comp_gt.id_tipo_canna_fumaria,
    sigit_t_comp_gt.medi_imp_ore_operative,
    sigit_d_tipo_canna_fumaria.desc_tipo_canna_fumaria
   FROM sigit_t_comp_gt
     LEFT JOIN sigit_d_marca ON sigit_t_comp_gt.fk_marca = sigit_d_marca.id_marca
     LEFT JOIN sigit_d_fluido ON sigit_t_comp_gt.fk_fluido = sigit_d_fluido.id_fluido
     LEFT JOIN sigit_d_dettaglio_gt ON sigit_t_comp_gt.fk_dettaglio_gt = sigit_d_dettaglio_gt.id_dettaglio_gt
     LEFT JOIN sigit_d_combustibile ON sigit_t_comp_gt.fk_combustibile = sigit_d_combustibile.id_combustibile
     LEFT JOIN sigit_t_dett_tipo1 ON sigit_t_dett_tipo1.codice_impianto = sigit_t_comp_gt.codice_impianto AND sigit_t_dett_tipo1.fk_tipo_componente::text = sigit_t_comp_gt.id_tipo_componente::text AND sigit_t_dett_tipo1.progressivo = sigit_t_comp_gt.progressivo AND sigit_t_dett_tipo1.data_install = sigit_t_comp_gt.data_install
     LEFT JOIN sigit_t_allegato ON sigit_t_dett_tipo1.fk_allegato = sigit_t_allegato.id_allegato
     LEFT JOIN sigit_d_tipo_documento ON sigit_t_allegato.fk_tipo_documento = sigit_d_tipo_documento.id_tipo_documento
     LEFT JOIN sigit_d_tipo_canna_fumaria ON sigit_t_comp_gt.id_tipo_canna_fumaria = sigit_d_tipo_canna_fumaria.id_tipo_canna_fumaria
UNION
 SELECT DISTINCT sigit_t_comp_gt.codice_impianto,
    sigit_t_comp_gt.id_tipo_componente,
    sigit_t_comp_gt.progressivo,
    sigit_t_comp_gt.data_install,
    sigit_t_comp_gt.data_dismiss,
    sigit_t_comp_gt.tempo_manut_anni,
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
    sigit_t_allegato.id_allegato,
    sigit_t_allegato.fk_tipo_documento,
    sigit_d_tipo_documento.des_tipo_documento,
    sigit_t_comp_gt.id_tipo_canna_fumaria,
    sigit_t_comp_gt.medi_imp_ore_operative,
    sigit_d_tipo_canna_fumaria.desc_tipo_canna_fumaria
   FROM sigit_t_dett_ispez_gt
     LEFT JOIN sigit_t_comp_gt ON sigit_t_dett_ispez_gt.codice_impianto = sigit_t_comp_gt.codice_impianto AND sigit_t_dett_ispez_gt.fk_tipo_componente::text = sigit_t_comp_gt.id_tipo_componente::text AND sigit_t_dett_ispez_gt.progressivo = sigit_t_comp_gt.progressivo AND sigit_t_dett_ispez_gt.data_install = sigit_t_comp_gt.data_install
     LEFT JOIN sigit_d_marca ON sigit_t_comp_gt.fk_marca = sigit_d_marca.id_marca
     LEFT JOIN sigit_d_fluido ON sigit_t_comp_gt.fk_fluido = sigit_d_fluido.id_fluido
     LEFT JOIN sigit_d_dettaglio_gt ON sigit_t_comp_gt.fk_dettaglio_gt = sigit_d_dettaglio_gt.id_dettaglio_gt
     LEFT JOIN sigit_d_combustibile ON sigit_t_comp_gt.fk_combustibile = sigit_d_combustibile.id_combustibile
     LEFT JOIN sigit_t_allegato ON sigit_t_dett_ispez_gt.fk_allegato = sigit_t_allegato.id_allegato
     LEFT JOIN sigit_d_tipo_documento ON sigit_t_allegato.fk_tipo_documento = sigit_d_tipo_documento.id_tipo_documento
     LEFT JOIN sigit_d_tipo_canna_fumaria ON sigit_t_comp_gt.id_tipo_canna_fumaria = sigit_d_tipo_canna_fumaria.id_tipo_canna_fumaria;
 
/* Modifica a vista sk4 GF*/
CREATE OR REPLACE VIEW sigit_new.vista_sk4_gf
AS SELECT sigit_t_comp_gf.codice_impianto,
    sigit_t_comp_gf.id_tipo_componente,
    sigit_t_comp_gf.progressivo,
    sigit_t_comp_gf.data_install,
    sigit_t_comp_gf.tempo_manut_anni,
    sigit_t_comp_gf.matricola,
    sigit_t_comp_gf.fk_marca,
    sigit_d_marca.des_marca,
    sigit_d_combustibile.id_combustibile,
    sigit_d_combustibile.des_combustibile,
    sigit_t_comp_gf.fk_dettaglio_gf,
    sigit_d_dettaglio_gf.des_dettaglio_gf,
    sigit_t_comp_gf.modello,
    sigit_t_comp_gf.flg_sorgente_ext,
    sigit_t_comp_gf.flg_fluido_utenze,
    sigit_t_comp_gf.fluido_frigorigeno,
    sigit_t_comp_gf.n_circuiti,
    sigit_t_comp_gf.raffrescamento_eer,
    sigit_t_comp_gf.raff_potenza_kw,
    sigit_t_comp_gf.raff_potenza_ass,
    sigit_t_comp_gf.riscaldamento_cop,
    sigit_t_comp_gf.risc_potenza_kw,
    sigit_t_comp_gf.risc_potenza_ass_kw,
    sigit_t_comp_gf.flg_dismissione,
    sigit_t_comp_gf.data_dismiss,
    sigit_t_comp_gf.data_ult_mod,
    sigit_t_comp_gf.utente_ult_mod,
    sigit_t_comp_gf.potenza_termica_kw,
    sigit_t_allegato.data_controllo,
    sigit_t_allegato.id_allegato,
    sigit_t_allegato.fk_tipo_documento,
    sigit_d_tipo_documento.des_tipo_documento,
    sigit_t_comp_gf.id_fonte_en_sfruttata,
    sigit_d_fonte_en_sfruttata.desc_fonte_en_sfruttata
   FROM sigit_t_comp_gf
     LEFT JOIN sigit_d_marca ON sigit_t_comp_gf.fk_marca = sigit_d_marca.id_marca
     LEFT JOIN sigit_d_dettaglio_gf ON sigit_t_comp_gf.fk_dettaglio_gf = sigit_d_dettaglio_gf.id_dettaglio_gf
     LEFT JOIN sigit_d_combustibile ON sigit_t_comp_gf.fk_combustibile = sigit_d_combustibile.id_combustibile
     LEFT JOIN sigit_t_dett_tipo2 ON sigit_t_dett_tipo2.codice_impianto = sigit_t_comp_gf.codice_impianto AND sigit_t_dett_tipo2.fk_tipo_componente::text = sigit_t_comp_gf.id_tipo_componente::text AND sigit_t_dett_tipo2.progressivo = sigit_t_comp_gf.progressivo AND sigit_t_dett_tipo2.data_install = sigit_t_comp_gf.data_install
     LEFT JOIN sigit_t_allegato ON sigit_t_dett_tipo2.fk_allegato = sigit_t_allegato.id_allegato
     LEFT JOIN sigit_d_tipo_documento ON sigit_t_allegato.fk_tipo_documento = sigit_d_tipo_documento.id_tipo_documento
     LEFT JOIN sigit_d_fonte_en_sfruttata ON sigit_t_comp_gf.id_fonte_en_sfruttata = sigit_d_fonte_en_sfruttata.id_fonte_en_sfruttata
UNION
 SELECT sigit_t_comp_gf.codice_impianto,
    sigit_t_comp_gf.id_tipo_componente,
    sigit_t_comp_gf.progressivo,
    sigit_t_comp_gf.data_install,
    sigit_t_comp_gf.tempo_manut_anni,
    sigit_t_comp_gf.matricola,
    sigit_t_comp_gf.fk_marca,
    sigit_d_marca.des_marca,
    sigit_d_combustibile.id_combustibile,
    sigit_d_combustibile.des_combustibile,
    sigit_t_comp_gf.fk_dettaglio_gf,
    sigit_d_dettaglio_gf.des_dettaglio_gf,
    sigit_t_comp_gf.modello,
    sigit_t_comp_gf.flg_sorgente_ext,
    sigit_t_comp_gf.flg_fluido_utenze,
    sigit_t_comp_gf.fluido_frigorigeno,
    sigit_t_comp_gf.n_circuiti,
    sigit_t_comp_gf.raffrescamento_eer,
    sigit_t_comp_gf.raff_potenza_kw,
    sigit_t_comp_gf.raff_potenza_ass,
    sigit_t_comp_gf.riscaldamento_cop,
    sigit_t_comp_gf.risc_potenza_kw,
    sigit_t_comp_gf.risc_potenza_ass_kw,
    sigit_t_comp_gf.flg_dismissione,
    sigit_t_comp_gf.data_dismiss,
    sigit_t_comp_gf.data_ult_mod,
    sigit_t_comp_gf.utente_ult_mod,
    sigit_t_comp_gf.potenza_termica_kw,
    sigit_t_allegato.data_controllo,
    sigit_t_allegato.id_allegato,
    sigit_t_allegato.fk_tipo_documento,
    sigit_d_tipo_documento.des_tipo_documento,
    sigit_t_comp_gf.id_fonte_en_sfruttata,
    sigit_d_fonte_en_sfruttata.desc_fonte_en_sfruttata
   FROM sigit_t_dett_ispez_gf
     LEFT JOIN sigit_t_comp_gf ON sigit_t_dett_ispez_gf.codice_impianto = sigit_t_comp_gf.codice_impianto AND sigit_t_dett_ispez_gf.fk_tipo_componente::text = sigit_t_comp_gf.id_tipo_componente::text AND sigit_t_dett_ispez_gf.progressivo = sigit_t_comp_gf.progressivo AND sigit_t_dett_ispez_gf.data_install = sigit_t_comp_gf.data_install
     LEFT JOIN sigit_d_marca ON sigit_t_comp_gf.fk_marca = sigit_d_marca.id_marca
     LEFT JOIN sigit_d_dettaglio_gf ON sigit_t_comp_gf.fk_dettaglio_gf = sigit_d_dettaglio_gf.id_dettaglio_gf
     LEFT JOIN sigit_d_combustibile ON sigit_t_comp_gf.fk_combustibile = sigit_d_combustibile.id_combustibile
     LEFT JOIN sigit_t_allegato ON sigit_t_dett_ispez_gf.fk_allegato = sigit_t_allegato.id_allegato
     LEFT JOIN sigit_d_tipo_documento ON sigit_t_allegato.fk_tipo_documento = sigit_d_tipo_documento.id_tipo_documento
     LEFT JOIN sigit_d_fonte_en_sfruttata ON sigit_t_comp_gf.id_fonte_en_sfruttata = sigit_d_fonte_en_sfruttata.id_fonte_en_sfruttata;

----------------------------------------------------------------------------------------
-- 14/07/2021  Lorita
-- Modifica vista vista_comp_gt_dett
--  come da mail di Mariuccia del 14/7/2021 9:22
----------------------------------------------------------------------------------------
CREATE OR REPLACE VIEW sigit_new.vista_comp_gt_dett
AS SELECT sigit_t_dett_tipo1.codice_impianto,
    sigit_t_dett_tipo1.fk_tipo_componente,
    sigit_t_dett_tipo1.progressivo,
    sigit_t_dett_tipo1.data_install,
    sigit_t_dett_tipo1.id_dett_tipo1,
    sigit_t_dett_tipo1.fk_allegato,
    sigit_t_dett_tipo1.e_n_modulo_termico,
    sigit_t_dett_tipo1.e_pot_term_focol_kw,
    sigit_t_dett_tipo1.e_flg_clima_inverno,
    sigit_t_dett_tipo1.e_flg_produz_acs,
    sigit_t_dett_tipo1.e_flg_dispos_comando,
    sigit_t_dett_tipo1.e_flg_dispos_sicurezza,
    sigit_t_dett_tipo1.e_flg_valvola_sicurezza,
    sigit_t_dett_tipo1.e_flg_scambiatore_fumi,
    sigit_t_dett_tipo1.e_flg_riflusso,
    sigit_t_dett_tipo1.e_flg_uni_10389_1,
    sigit_t_dett_tipo1.e_flg_evacu_fumi,
    sigit_t_dett_tipo1.e_depr_canale_fumo_pa,
    sigit_t_dett_tipo1.e_temp_fumi_c,
    sigit_t_dett_tipo1.e_temp_aria_c,
    sigit_t_dett_tipo1.e_o2_perc,
    sigit_t_dett_tipo1.e_co2_perc,
    sigit_t_dett_tipo1.e_bacharach_min,
    sigit_t_dett_tipo1.e_bacharach_med,
    sigit_t_dett_tipo1.e_bacharach_max,
    sigit_t_dett_tipo1.e_co_corretto_ppm,
    sigit_t_dett_tipo1.e_rend_comb_perc,
    sigit_t_dett_tipo1.e_rend_min_legge_perc,
    sigit_t_dett_tipo1.e_nox_ppm,
    sigit_t_dett_tipo1.e_nox_mg_kwh,
    sigit_t_dett_tipo1.data_ult_mod AS data_ult_mod_dett,
    sigit_t_dett_tipo1.utente_ult_mod AS utente_ult_mod_dett,
    sigit_t_allegato.data_controllo,
    sigit_t_allegato.fk_stato_rapp,
    sigit_t_dett_tipo1.l11_1_portata_combustibile,
    sigit_t_dett_tipo1.l11_1_portata_combustibile_um,
    sigit_t_dett_tipo1.l11_1_altro_riferimento,
    sigit_t_dett_tipo1.l11_1_co_no_aria_ppm,
    sigit_t_dett_tipo1.l11_1_flg_rispetta_bacharach,
    sigit_t_dett_tipo1.l11_1_flg_co_min_1000,
    sigit_t_dett_tipo1.l11_1_flg_rend_mag_rend_min,
    sigit_t_persona_giuridica.sigla_rea,
    sigit_t_persona_giuridica.numero_rea,
    sigit_t_persona_giuridica.id_persona_giuridica,
    sigit_r_comp4_manut.fk_ruolo
   FROM sigit_t_dett_tipo1
     JOIN sigit_t_allegato ON sigit_t_dett_tipo1.fk_allegato = sigit_t_allegato.id_allegato AND sigit_t_allegato.fk_stato_rapp <> 2::numeric
     JOIN sigit_r_comp4manut_all ON sigit_r_comp4manut_all.id_allegato = sigit_t_allegato.id_allegato
     JOIN sigit_r_comp4_manut ON sigit_r_comp4_manut.id_r_comp4_manut = sigit_r_comp4manut_all.id_r_comp4_manut
     JOIN sigit_t_persona_giuridica ON sigit_r_comp4_manut.fk_persona_giuridica = sigit_t_persona_giuridica.id_persona_giuridica
  WHERE sigit_t_allegato.fk_tipo_documento IN (3::numeric, 14::numeric)
UNION
 SELECT sigit_t_dett_tipo1.codice_impianto,
    sigit_t_dett_tipo1.fk_tipo_componente,
    sigit_t_dett_tipo1.progressivo,
    sigit_t_dett_tipo1.data_install,
    sigit_t_dett_tipo1.id_dett_tipo1,
    sigit_t_dett_tipo1.fk_allegato,
    sigit_t_dett_tipo1.e_n_modulo_termico,
    sigit_t_dett_tipo1.e_pot_term_focol_kw,
    sigit_t_dett_tipo1.e_flg_clima_inverno,
    sigit_t_dett_tipo1.e_flg_produz_acs,
    sigit_t_dett_tipo1.e_flg_dispos_comando,
    sigit_t_dett_tipo1.e_flg_dispos_sicurezza,
    sigit_t_dett_tipo1.e_flg_valvola_sicurezza,
    sigit_t_dett_tipo1.e_flg_scambiatore_fumi,
    sigit_t_dett_tipo1.e_flg_riflusso,
    sigit_t_dett_tipo1.e_flg_uni_10389_1,
    sigit_t_dett_tipo1.e_flg_evacu_fumi,
    sigit_t_dett_tipo1.e_depr_canale_fumo_pa,
    sigit_t_dett_tipo1.e_temp_fumi_c,
    sigit_t_dett_tipo1.e_temp_aria_c,
    sigit_t_dett_tipo1.e_o2_perc,
    sigit_t_dett_tipo1.e_co2_perc,
    sigit_t_dett_tipo1.e_bacharach_min,
    sigit_t_dett_tipo1.e_bacharach_med,
    sigit_t_dett_tipo1.e_bacharach_max,
    sigit_t_dett_tipo1.e_co_corretto_ppm,
    sigit_t_dett_tipo1.e_rend_comb_perc,
    sigit_t_dett_tipo1.e_rend_min_legge_perc,
    sigit_t_dett_tipo1.e_nox_ppm,
    sigit_t_dett_tipo1.e_nox_mg_kwh,
    sigit_t_dett_tipo1.data_ult_mod AS data_ult_mod_dett,
    sigit_t_dett_tipo1.utente_ult_mod AS utente_ult_mod_dett,
    sigit_t_allegato.data_controllo,
    sigit_t_allegato.fk_stato_rapp,
    sigit_t_dett_tipo1.l11_1_portata_combustibile,
    sigit_t_dett_tipo1.l11_1_portata_combustibile_um,
    sigit_t_dett_tipo1.l11_1_altro_riferimento,
    sigit_t_dett_tipo1.l11_1_co_no_aria_ppm,
    sigit_t_dett_tipo1.l11_1_flg_rispetta_bacharach,
    sigit_t_dett_tipo1.l11_1_flg_co_min_1000,
    sigit_t_dett_tipo1.l11_1_flg_rend_mag_rend_min,
    sigit_t_persona_giuridica.sigla_rea,
    sigit_t_persona_giuridica.numero_rea,
    COALESCE(sigit_t_persona_giuridica.id_persona_giuridica, sigit_t_persona_fisica.id_persona_fisica, sigit_t_persona_giuridica.id_persona_giuridica) AS id_persona_giuridica,
    sigit_r_ispez_ispet.fk_ruolo
   FROM sigit_t_dett_tipo1
     JOIN sigit_t_allegato ON sigit_t_dett_tipo1.fk_allegato = sigit_t_allegato.id_allegato AND sigit_t_allegato.fk_stato_rapp <> 2::numeric
     JOIN sigit_r_ispez_ispet ON sigit_r_ispez_ispet.id_ispez_ispet = sigit_t_allegato.fk_ispez_ispet
     LEFT JOIN sigit_t_persona_giuridica ON sigit_r_ispez_ispet.fk_persona_giuridica = sigit_t_persona_giuridica.id_persona_giuridica
     LEFT JOIN sigit_t_persona_fisica ON sigit_r_ispez_ispet.fk_persona_fisica = sigit_t_persona_fisica.id_persona_fisica
  WHERE sigit_t_allegato.fk_tipo_documento IN (3::numeric, 14::numeric);

-- Permissions
ALTER TABLE sigit_new.vista_comp_gt_dett OWNER TO sigit_new;

