---------- RICORDARSI GRANT UTENTE RO -----------------
----------------------------------------------------------------------------------------
-- 01/06/2022  Lorita
-- Aumento dimensione campi civico
--  come da mail di Mariuccia del 1/06/2022 
-- DEV
-- TEST 14/9/2022
----------------------------------------------------------------------------------------
-- necessario cancellare e ricreare le viste che usano questi campi
drop VIEW sigit_new.vista_pf_pg;
drop VIEW sigit_new.v_srv_ricerca_nox_to;
drop VIEW sigit_new.v_srv_ricerca_nox_al;
drop VIEW sigit_new.od_vista_aggregata_stato_impianto;
drop VIEW sigit_new.od_vista_aggregata_impianto_potenza;
DROP VIEW sigit_new.vista_ricerca_impianti;
DROP VIEW sigit_new.vmv_vista_ricerca_impianti;
DROP MATERIALIZED VIEW sigit_new.mv_vista_ricerca_impianti;
drop VIEW sigit_new.vmv_vista_elenco_distributori;
drop MATERIALIZED VIEW sigit_new.mv_vista_elenco_distributori;
drop VIEW sigit_new.vista_dati_import_distributori;
drop VIEW sigit_new.vmv_vista_dati_import_distributori;
drop MATERIALIZED VIEW sigit_new.mv_vista_dati_import_distributori;
drop VIEW sigit_new.vista_elenco_distributori;
drop VIEW sigit_new.vista_ricerca_allegati_storico;
drop VIEW sigit_new.vista_ricerca_allegati;
drop VIEW sigit_new.od_vista_dettaglio_impianti;
drop VIEW sigit_new.vmv_od_vista_dettaglio_impianti;
drop MATERIALIZED VIEW sigit_new.mv_od_vista_dettaglio_impianti;
drop VIEW sigit_new.vista_tot_impianto;

ALTER TABLE sigit_new.sigit_t_persona_fisica ALTER COLUMN civico TYPE CHARACTER VARYING(50);
ALTER TABLE sigit_new.sigit_t_persona_giuridica ALTER COLUMN civico TYPE CHARACTER VARYING(50);
ALTER TABLE sigit_new.sigit_t_unita_immobiliare ALTER COLUMN civico TYPE CHARACTER VARYING(50);

CREATE OR REPLACE VIEW sigit_new.vista_ricerca_impianti
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
    q_pf_ruolo.indirizzo_responsabile_pf,
    q_pf_ruolo.civico AS civico_pf,
    q_pf_ruolo.cap AS cap_pf,
    q_pf_ruolo.comune AS comune_pf,
    q_pg_ruolo.indirizzo_responsabile_pg,
    q_pg_ruolo.civico AS civico_pg,
    q_pg_ruolo.cap AS cap_pg,
    q_pg_ruolo.comune AS comune_pg,
    q_contratto.indirizzo_responsabile_3r,
    q_contratto.civico AS civico_3r,
    q_contratto.cap AS cap_3r,
    q_contratto.comune AS comune_3r,
    sigit_t_impianto.flg_no_opendata,
    q_pf_ruolo.provincia AS provincia_pf,
    q_pg_ruolo.provincia AS provincia_pg,
    q_contratto.provincia AS provincia_3r,
    COALESCE(q_pf_ruolo.email, q_pg_ruolo.email, q_pf_ruolo.email) AS email,
    q_contratto.email AS email_3r
   FROM sigit_t_impianto
     JOIN sigit_d_stato_imp ON sigit_t_impianto.fk_stato = sigit_d_stato_imp.id_stato
     JOIN sigit_t_unita_immobiliare ON sigit_t_impianto.codice_impianto = sigit_t_unita_immobiliare.codice_impianto
     LEFT JOIN ( SELECT sigit_r_imp_ruolo_pfpg_1.id_imp_ruolo_pfpg,
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
            (COALESCE(sigit_t_persona_fisica.indirizzo_sitad, ''::character varying)::text || ' '::text) || COALESCE(sigit_t_persona_fisica.indirizzo_non_trovato, ''::character varying)::text AS indirizzo_responsabile_pf,
            sigit_t_persona_fisica.civico,
            sigit_t_persona_fisica.cap,
            sigit_t_persona_fisica.comune,
            sigit_t_persona_fisica.provincia,
            sigit_t_persona_fisica.email
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
            (COALESCE(sigit_t_persona_giuridica.indirizzo_sitad, ''::character varying)::text || ' '::text) || COALESCE(sigit_t_persona_giuridica.indirizzo_non_trovato, ''::character varying)::text AS indirizzo_responsabile_pg,
            sigit_t_persona_giuridica.civico,
            sigit_t_persona_giuridica.cap,
            sigit_t_persona_giuridica.comune,
            sigit_t_persona_giuridica.provincia,
            sigit_t_persona_giuridica.email
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
            (COALESCE(sigit_t_persona_giuridica_1.indirizzo_sitad, ''::character varying)::text || ' '::text) || COALESCE(sigit_t_persona_giuridica_1.indirizzo_non_trovato, ''::character varying)::text AS indirizzo_responsabile_3r,
            sigit_t_persona_giuridica_1.civico,
            sigit_t_persona_giuridica_1.cap,
            sigit_t_persona_giuridica_1.comune,
            sigit_t_persona_giuridica_1.provincia,
            sigit_t_persona_giuridica_1.email
           FROM sigit_t_contratto_2019
             JOIN sigit_t_persona_giuridica sigit_t_persona_giuridica_1 ON sigit_t_contratto_2019.fk_pg_3_resp = sigit_t_persona_giuridica_1.id_persona_giuridica
          WHERE sigit_t_contratto_2019.data_cessazione IS NULL AND (sigit_t_contratto_2019.flg_tacito_rinnovo = 1::numeric OR sigit_t_contratto_2019.flg_tacito_rinnovo = 0::numeric AND sigit_t_contratto_2019.data_fine >= now()::date)) q_contratto ON sigit_t_impianto.codice_impianto = q_contratto.codice_impianto
  WHERE sigit_t_unita_immobiliare.flg_principale = 1::numeric;

ALTER TABLE sigit_new.vista_ricerca_impianti OWNER TO sigit_new;
GRANT ALL ON TABLE sigit_new.vista_ricerca_impianti TO sigit_new;
GRANT INSERT, SELECT, UPDATE, DELETE ON TABLE sigit_new.vista_ricerca_impianti TO sigit_new_rw;

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
    q_pf_ruolo.indirizzo_responsabile_pf,
    q_pf_ruolo.civico AS civico_pf,
    q_pf_ruolo.cap AS cap_pf,
    q_pf_ruolo.comune AS comune_pf,
    q_pg_ruolo.indirizzo_responsabile_pg,
    q_pg_ruolo.civico AS civico_pg,
    q_pg_ruolo.cap AS cap_pg,
    q_pg_ruolo.comune AS comune_pg,
    q_contratto.indirizzo_responsabile_3r,
    q_contratto.civico AS civico_3r,
    q_contratto.cap AS cap_3r,
    q_contratto.comune AS comune_3r,
    sigit_t_impianto.flg_no_opendata,
    q_pf_ruolo.provincia AS provincia_pf,
    q_pg_ruolo.provincia AS provincia_pg,
    q_contratto.provincia AS provincia_3r,
    COALESCE(q_pf_ruolo.email, q_pg_ruolo.email, q_pf_ruolo.email) AS email,
    q_contratto.email AS email_3r
   FROM sigit_t_impianto
     JOIN sigit_d_stato_imp ON sigit_t_impianto.fk_stato = sigit_d_stato_imp.id_stato
     JOIN sigit_t_unita_immobiliare ON sigit_t_impianto.codice_impianto = sigit_t_unita_immobiliare.codice_impianto
     LEFT JOIN ( SELECT sigit_r_imp_ruolo_pfpg_1.id_imp_ruolo_pfpg,
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
            (COALESCE(sigit_t_persona_fisica.indirizzo_sitad, ''::character varying)::text || ' '::text) || COALESCE(sigit_t_persona_fisica.indirizzo_non_trovato, ''::character varying)::text AS indirizzo_responsabile_pf,
            sigit_t_persona_fisica.civico,
            sigit_t_persona_fisica.cap,
            sigit_t_persona_fisica.comune,
            sigit_t_persona_fisica.provincia,
            sigit_t_persona_fisica.email
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
            (COALESCE(sigit_t_persona_giuridica.indirizzo_sitad, ''::character varying)::text || ' '::text) || COALESCE(sigit_t_persona_giuridica.indirizzo_non_trovato, ''::character varying)::text AS indirizzo_responsabile_pg,
            sigit_t_persona_giuridica.civico,
            sigit_t_persona_giuridica.cap,
            sigit_t_persona_giuridica.comune,
            sigit_t_persona_giuridica.provincia,
            sigit_t_persona_giuridica.email
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
            (COALESCE(sigit_t_persona_giuridica_1.indirizzo_sitad, ''::character varying)::text || ' '::text) || COALESCE(sigit_t_persona_giuridica_1.indirizzo_non_trovato, ''::character varying)::text AS indirizzo_responsabile_3r,
            sigit_t_persona_giuridica_1.civico,
            sigit_t_persona_giuridica_1.cap,
            sigit_t_persona_giuridica_1.comune,
            sigit_t_persona_giuridica_1.provincia,
            sigit_t_persona_giuridica_1.email
           FROM sigit_t_contratto_2019
             JOIN sigit_t_persona_giuridica sigit_t_persona_giuridica_1 ON sigit_t_contratto_2019.fk_pg_3_resp = sigit_t_persona_giuridica_1.id_persona_giuridica
          WHERE sigit_t_contratto_2019.data_cessazione IS NULL AND (sigit_t_contratto_2019.flg_tacito_rinnovo = 1::numeric OR sigit_t_contratto_2019.flg_tacito_rinnovo = 0::numeric AND sigit_t_contratto_2019.data_fine >= now()::date)) q_contratto ON sigit_t_impianto.codice_impianto = q_contratto.codice_impianto
  WHERE sigit_t_unita_immobiliare.flg_principale = 1::numeric
WITH DATA;

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
    mv_vista_ricerca_impianti.indirizzo_responsabile_pf,
    mv_vista_ricerca_impianti.civico_pf,
    mv_vista_ricerca_impianti.cap_pf,
    mv_vista_ricerca_impianti.comune_pf,
    mv_vista_ricerca_impianti.indirizzo_responsabile_pg,
    mv_vista_ricerca_impianti.civico_pg,
    mv_vista_ricerca_impianti.cap_pg,
    mv_vista_ricerca_impianti.comune_pg,
    mv_vista_ricerca_impianti.indirizzo_responsabile_3r,
    mv_vista_ricerca_impianti.civico_3r,
    mv_vista_ricerca_impianti.cap_3r,
    mv_vista_ricerca_impianti.comune_3r,
    mv_vista_ricerca_impianti.flg_no_opendata,
    mv_vista_ricerca_impianti.provincia_pf,
    mv_vista_ricerca_impianti.provincia_pg,
    mv_vista_ricerca_impianti.provincia_3r,
    mv_vista_ricerca_impianti.email,
    mv_vista_ricerca_impianti.email_3r
   FROM mv_vista_ricerca_impianti;

ALTER TABLE sigit_new.vmv_vista_ricerca_impianti OWNER TO sigit_new;
GRANT ALL ON TABLE sigit_new.vmv_vista_ricerca_impianti TO sigit_new;
GRANT INSERT, SELECT, UPDATE, DELETE ON TABLE sigit_new.vmv_vista_ricerca_impianti TO sigit_new_rw;

CREATE OR REPLACE VIEW sigit_new.od_vista_aggregata_impianto_potenza
AS SELECT elenco.denominazione_comune AS key_classe,
    sum(elenco.tot_35) AS pot_clima_inv_fino_al_35,
    sum(elenco.tot_100) AS pot_clima_inv_dal_36_al_100,
    sum(elenco.tot_250) AS pot_clima_inv_dal_101_al_250,
    sum(elenco.tot_350) AS pot_clima_inv_dal_251_al_350,
    sum(elenco.tot_351) AS pot_clima_inv_oltre_350,
    sum(elenco.tot_e_35) AS pot_clima_est_fino_al_35,
    sum(elenco.tot_e_100) AS pot_clima_est_dal_36_al_100,
    sum(elenco.tot_e_250) AS pot_clima_est_dal_101_al_250,
    sum(elenco.tot_e_350) AS pot_clima_est_dal_251_al_350,
    sum(elenco.tot_e_351) AS pot_clima_iest_oltre_350
   FROM ( SELECT vista_ricerca_impianti.denominazione_comune,
            vista_ricerca_impianti.l1_3_pot_clima_inv_kw,
                CASE
                    WHEN vista_ricerca_impianti.l1_3_pot_clima_inv_kw <= 35::numeric THEN 1
                    ELSE 0
                END AS tot_35,
                CASE
                    WHEN vista_ricerca_impianti.l1_3_pot_clima_inv_kw >= 36::numeric AND vista_ricerca_impianti.l1_3_pot_clima_inv_kw <= 100::numeric THEN 1
                    ELSE 0
                END AS tot_100,
                CASE
                    WHEN vista_ricerca_impianti.l1_3_pot_clima_inv_kw >= 101::numeric AND vista_ricerca_impianti.l1_3_pot_clima_inv_kw <= 250::numeric THEN 1
                    ELSE 0
                END AS tot_250,
                CASE
                    WHEN vista_ricerca_impianti.l1_3_pot_clima_inv_kw >= 251::numeric AND vista_ricerca_impianti.l1_3_pot_clima_inv_kw <= 350::numeric THEN 1
                    ELSE 0
                END AS tot_350,
                CASE
                    WHEN vista_ricerca_impianti.l1_3_pot_clima_inv_kw > 350::numeric THEN 1
                    ELSE 0
                END AS tot_351,
            vista_ricerca_impianti.l1_3_pot_clima_est_kw,
                CASE
                    WHEN vista_ricerca_impianti.l1_3_pot_clima_est_kw <= 35::numeric THEN 1
                    ELSE 0
                END AS tot_e_35,
                CASE
                    WHEN vista_ricerca_impianti.l1_3_pot_clima_est_kw >= 36::numeric AND vista_ricerca_impianti.l1_3_pot_clima_est_kw <= 100::numeric THEN 1
                    ELSE 0
                END AS tot_e_100,
                CASE
                    WHEN vista_ricerca_impianti.l1_3_pot_clima_est_kw >= 101::numeric AND vista_ricerca_impianti.l1_3_pot_clima_est_kw <= 250::numeric THEN 1
                    ELSE 0
                END AS tot_e_250,
                CASE
                    WHEN vista_ricerca_impianti.l1_3_pot_clima_est_kw >= 251::numeric AND vista_ricerca_impianti.l1_3_pot_clima_est_kw <= 350::numeric THEN 1
                    ELSE 0
                END AS tot_e_350,
                CASE
                    WHEN vista_ricerca_impianti.l1_3_pot_clima_est_kw > 350::numeric THEN 1
                    ELSE 0
                END AS tot_e_351
           FROM vista_ricerca_impianti
          WHERE vista_ricerca_impianti.des_stato::text ~~ 'Attivo'::text) elenco
  GROUP BY elenco.denominazione_comune
  ORDER BY elenco.denominazione_comune;

ALTER TABLE sigit_new.od_vista_aggregata_impianto_potenza OWNER TO sigit_new;
GRANT ALL ON TABLE sigit_new.od_vista_aggregata_impianto_potenza TO sigit_new;
GRANT INSERT, SELECT, UPDATE, DELETE ON TABLE sigit_new.od_vista_aggregata_impianto_potenza TO sigit_new_rw;

CREATE OR REPLACE VIEW sigit_new.od_vista_aggregata_stato_impianto
AS SELECT elenco.denominazione_comune AS key_classe,
    elenco.sigla_provincia,
    sum(elenco.tot_attivo) AS attivo,
    sum(elenco.tot_cancellato) AS cancellato,
    sum(elenco.tot_dismesso) AS dismesso,
    sum(elenco.tot_sospeso) AS inattivabile_sospeso
   FROM ( SELECT vista_ricerca_impianti.sigla_provincia,
            vista_ricerca_impianti.denominazione_comune,
            vista_ricerca_impianti.des_stato,
                CASE
                    WHEN vista_ricerca_impianti.des_stato::text ~~ 'Attivo'::text THEN 1
                    ELSE 0
                END AS tot_attivo,
                CASE
                    WHEN vista_ricerca_impianti.des_stato::text ~~ 'Cancellato'::text THEN 1
                    ELSE 0
                END AS tot_cancellato,
                CASE
                    WHEN vista_ricerca_impianti.des_stato::text ~~ 'Dismesso'::text THEN 1
                    ELSE 0
                END AS tot_dismesso,
                CASE
                    WHEN vista_ricerca_impianti.des_stato::text ~~ 'Inattivabile/Sospeso'::text THEN 1
                    ELSE 0
                END AS tot_sospeso
           FROM vista_ricerca_impianti) elenco
  GROUP BY elenco.denominazione_comune, elenco.sigla_provincia
  ORDER BY elenco.denominazione_comune;

ALTER TABLE sigit_new.od_vista_aggregata_stato_impianto OWNER TO sigit_new;
GRANT ALL ON TABLE sigit_new.od_vista_aggregata_stato_impianto TO sigit_new;
GRANT INSERT, SELECT, UPDATE, DELETE ON TABLE sigit_new.od_vista_aggregata_stato_impianto TO sigit_new_rw;

CREATE OR REPLACE VIEW sigit_new.v_srv_ricerca_nox_al
AS SELECT vista_ricerca_impianti.id_pf_responsabile,
    vista_ricerca_impianti.id_pg_responsabile,
    sigit_t_allegato.data_controllo,
    sigit_t_comp_gt.fk_combustibile,
    sigit_t_impianto.denominazione_comune AS comune_impianto,
    sigit_t_impianto.codice_impianto,
    sigit_t_comp_gt.id_tipo_componente,
    sigit_t_comp_gt.progressivo,
    sigit_t_unita_immobiliare.indirizzo_sitad AS indirizzo_sitad_impianto,
    sigit_t_unita_immobiliare.indirizzo_non_trovato AS indirizzo_nn_trovato_impianto,
    sigit_t_unita_immobiliare.civico AS civico_impianto,
    sigit_t_unita_immobiliare.cap AS cap_impianto,
    vista_ricerca_impianti.denominazione_responsabile,
    vista_ricerca_impianti.denominazione_3_responsabile,
    vista_ricerca_impianti.id_pg_3r,
    sigit_d_ruolo.des_ruolo,
    vista_ricerca_impianti.ruolo_funz,
    sigit_d_combustibile.des_combustibile,
    sigit_t_dett_tipo1.e_nox_ppm,
    sigit_t_comp_gt.rendimento_perc,
    sigit_t_comp_gt.potenza_termica_kw,
    sigit_t_allegato.f_osservazioni,
    sigit_t_allegato.f_raccomandazioni,
    sigit_t_allegato.f_prescrizioni,
    sigit_t_allegato.f_flg_puo_funzionare,
    sigit_t_dett_tipo1.e_nox_mg_kwh
   FROM sigit_r_comp4manut_all
     JOIN (sigit_r_comp4_manut
     JOIN (sigit_t_impianto
     JOIN sigit_t_comp_gt ON sigit_t_impianto.codice_impianto = sigit_t_comp_gt.codice_impianto) ON sigit_r_comp4_manut.progressivo = sigit_t_comp_gt.progressivo AND sigit_t_comp_gt.id_tipo_componente::text = sigit_r_comp4_manut.id_tipo_componente::text AND sigit_r_comp4_manut.codice_impianto = sigit_t_comp_gt.codice_impianto) ON sigit_r_comp4manut_all.id_r_comp4_manut = sigit_r_comp4_manut.id_r_comp4_manut
     JOIN sigit_t_allegato ON sigit_r_comp4manut_all.id_allegato = sigit_t_allegato.id_allegato
     JOIN sigit_t_unita_immobiliare ON sigit_t_impianto.codice_impianto = sigit_t_unita_immobiliare.codice_impianto AND sigit_t_unita_immobiliare.flg_principale = 1::numeric AND sigit_t_impianto.sigla_provincia::text = 'AL'::text
     JOIN sigit_t_dett_tipo1 ON sigit_t_allegato.id_allegato = sigit_t_dett_tipo1.fk_allegato
     JOIN sigit_d_combustibile ON sigit_t_comp_gt.fk_combustibile = sigit_d_combustibile.id_combustibile
     JOIN vista_ricerca_impianti ON sigit_t_impianto.codice_impianto = vista_ricerca_impianti.codice_impianto
     JOIN sigit_d_ruolo ON vista_ricerca_impianti.ruolo_responsabile = sigit_d_ruolo.id_ruolo
  ORDER BY sigit_t_impianto.denominazione_comune, sigit_t_impianto.codice_impianto;

ALTER TABLE sigit_new.v_srv_ricerca_nox_al OWNER TO sigit_new;
GRANT ALL ON TABLE sigit_new.v_srv_ricerca_nox_al TO sigit_new;
GRANT INSERT, SELECT, UPDATE, DELETE ON TABLE sigit_new.v_srv_ricerca_nox_al TO sigit_new_rw;

CREATE OR REPLACE VIEW sigit_new.v_srv_ricerca_nox_to
AS SELECT vista_ricerca_impianti.id_pf_responsabile,
    vista_ricerca_impianti.id_pg_responsabile,
    sigit_t_allegato.data_controllo,
    sigit_t_comp_gt.fk_combustibile,
    sigit_t_impianto.denominazione_comune AS comune_impianto,
    sigit_t_impianto.codice_impianto,
    sigit_t_comp_gt.id_tipo_componente,
    sigit_t_comp_gt.progressivo,
    sigit_t_unita_immobiliare.indirizzo_sitad AS indirizzo_sitad_impianto,
    sigit_t_unita_immobiliare.indirizzo_non_trovato AS indirizzo_nn_trovato_impianto,
    sigit_t_unita_immobiliare.civico AS civico_impianto,
    sigit_t_unita_immobiliare.cap AS cap_impianto,
    vista_ricerca_impianti.denominazione_responsabile,
    vista_ricerca_impianti.denominazione_3_responsabile,
    vista_ricerca_impianti.id_pg_3r,
    sigit_d_ruolo.des_ruolo,
    vista_ricerca_impianti.ruolo_funz,
    sigit_d_combustibile.des_combustibile,
    sigit_t_dett_tipo1.e_nox_ppm,
    sigit_t_comp_gt.rendimento_perc,
    sigit_t_comp_gt.potenza_termica_kw,
    sigit_t_allegato.f_osservazioni,
    sigit_t_allegato.f_raccomandazioni,
    sigit_t_allegato.f_prescrizioni,
    sigit_t_allegato.f_flg_puo_funzionare,
    sigit_t_dett_tipo1.e_nox_mg_kwh
   FROM sigit_r_comp4manut_all
     JOIN (sigit_r_comp4_manut
     JOIN (sigit_t_impianto
     JOIN sigit_t_comp_gt ON sigit_t_impianto.codice_impianto = sigit_t_comp_gt.codice_impianto) ON sigit_r_comp4_manut.progressivo = sigit_t_comp_gt.progressivo AND sigit_t_comp_gt.id_tipo_componente::text = sigit_r_comp4_manut.id_tipo_componente::text AND sigit_r_comp4_manut.codice_impianto = sigit_t_comp_gt.codice_impianto) ON sigit_r_comp4manut_all.id_r_comp4_manut = sigit_r_comp4_manut.id_r_comp4_manut
     JOIN sigit_t_allegato ON sigit_r_comp4manut_all.id_allegato = sigit_t_allegato.id_allegato
     JOIN sigit_t_unita_immobiliare ON sigit_t_impianto.codice_impianto = sigit_t_unita_immobiliare.codice_impianto AND sigit_t_unita_immobiliare.flg_principale = 1::numeric AND (sigit_t_impianto.istat_comune::text = ANY (ARRAY['001156'::character varying::text, '001090'::character varying::text, '001164'::character varying::text, '001272'::character varying::text, '001265'::character varying::text, '001120'::character varying::text, '001292'::character varying::text, '001171'::character varying::text, '001063'::character varying::text, '001024'::character varying::text, '001130'::character varying::text, '001314'::character varying::text, '001028'::character varying::text, '001316'::character varying::text, '001219'::character varying::text, '001078'::character varying::text, '001214'::character varying::text, '001249'::character varying::text, '001189'::character varying::text, '001008'::character varying::text, '001309'::character varying::text, '001280'::character varying::text, '001257'::character varying::text, '001058'::character varying::text, '001127'::character varying::text, '001099'::character varying::text, '001192'::character varying::text, '001048'::character varying::text, '001051'::character varying::text, '001183'::character varying::text, '001059'::character varying::text, '001082'::character varying::text, '001125'::character varying::text]))
     JOIN sigit_t_dett_tipo1 ON sigit_t_allegato.id_allegato = sigit_t_dett_tipo1.fk_allegato
     JOIN sigit_d_combustibile ON sigit_t_comp_gt.fk_combustibile = sigit_d_combustibile.id_combustibile
     JOIN vista_ricerca_impianti ON sigit_t_impianto.codice_impianto = vista_ricerca_impianti.codice_impianto
     JOIN sigit_d_ruolo ON vista_ricerca_impianti.ruolo_responsabile = sigit_d_ruolo.id_ruolo
  ORDER BY sigit_t_impianto.denominazione_comune, sigit_t_impianto.codice_impianto;

ALTER TABLE sigit_new.v_srv_ricerca_nox_to OWNER TO sigit_new;
GRANT ALL ON TABLE sigit_new.v_srv_ricerca_nox_to TO sigit_new;
GRANT INSERT, SELECT, UPDATE, DELETE ON TABLE sigit_new.v_srv_ricerca_nox_to TO sigit_new_rw;

CREATE OR REPLACE VIEW sigit_new.vista_pf_pg
AS SELECT sigit_t_persona_giuridica.id_persona_giuridica AS id_persona,
    'PG'::character varying(2) AS pf_pg,
    NULL::character varying(100) AS nome,
    sigit_t_persona_giuridica.sigla_rea,
    sigit_t_persona_giuridica.numero_rea,
    sigit_t_persona_giuridica.denominazione,
    sigit_t_persona_giuridica.codice_fiscale,
    sigit_t_persona_giuridica.fk_l2,
    sigit_t_persona_giuridica.indirizzo_sitad,
    sigit_t_persona_giuridica.indirizzo_non_trovato,
    sigit_t_persona_giuridica.sigla_prov,
    sigit_t_persona_giuridica.istat_comune,
    sigit_t_persona_giuridica.comune,
    sigit_t_persona_giuridica.provincia,
    sigit_t_persona_giuridica.civico,
    sigit_t_persona_giuridica.cap,
    sigit_t_persona_giuridica.email,
    sigit_t_persona_giuridica.data_inizio_attivita,
    sigit_t_persona_giuridica.data_cessazione,
    sigit_t_persona_giuridica.flg_indirizzo_estero,
    sigit_t_persona_giuridica.stato_estero,
    sigit_t_persona_giuridica.citta_estero,
    sigit_t_persona_giuridica.indirizzo_estero,
    sigit_t_persona_giuridica.cap_estero
   FROM sigit_t_persona_giuridica
UNION
 SELECT sigit_t_persona_fisica.id_persona_fisica AS id_persona,
    'PF'::character varying(2) AS pf_pg,
    sigit_t_persona_fisica.nome,
    NULL::character varying(2) AS sigla_rea,
    NULL::numeric(11,0) AS numero_rea,
    sigit_t_persona_fisica.cognome::character varying(500) AS denominazione,
    sigit_t_persona_fisica.codice_fiscale,
    sigit_t_persona_fisica.fk_l2,
    sigit_t_persona_fisica.indirizzo_sitad,
    sigit_t_persona_fisica.indirizzo_non_trovato,
    sigit_t_persona_fisica.sigla_prov,
    sigit_t_persona_fisica.istat_comune,
    sigit_t_persona_fisica.comune,
    sigit_t_persona_fisica.provincia,
    sigit_t_persona_fisica.civico,
    sigit_t_persona_fisica.cap,
    sigit_t_persona_fisica.email,
    NULL::date AS data_inizio_attivita,
    NULL::date AS data_cessazione,
    sigit_t_persona_fisica.flg_indirizzo_estero,
    sigit_t_persona_fisica.stato_estero,
    sigit_t_persona_fisica.citta_estero,
    sigit_t_persona_fisica.indirizzo_estero,
    sigit_t_persona_fisica.cap_estero
   FROM sigit_t_persona_fisica;

ALTER TABLE sigit_new.vista_pf_pg OWNER TO sigit_new;
GRANT ALL ON TABLE sigit_new.vista_pf_pg TO sigit_new;
GRANT INSERT, SELECT, UPDATE, DELETE ON TABLE sigit_new.vista_pf_pg TO sigit_new_rw;

CREATE OR REPLACE VIEW sigit_new.vista_elenco_distributori
AS SELECT sigit_t_persona_giuridica.id_persona_giuridica,
    sigit_t_persona_giuridica.denominazione,
    sigit_t_persona_giuridica.codice_fiscale,
    sigit_t_persona_giuridica.fk_l2,
    sigit_t_persona_giuridica.indirizzo_sitad,
    sigit_t_persona_giuridica.indirizzo_non_trovato,
    sigit_t_persona_giuridica.sigla_prov,
    sigit_t_persona_giuridica.istat_comune,
    sigit_t_persona_giuridica.comune,
    sigit_t_persona_giuridica.provincia,
    sigit_t_persona_giuridica.civico,
    sigit_t_persona_giuridica.cap,
    sigit_t_persona_giuridica.email,
    sigit_t_persona_giuridica.data_inizio_attivita,
    sigit_t_persona_giuridica.data_cessazione,
    sigit_t_persona_giuridica.sigla_rea,
    sigit_t_persona_giuridica.numero_rea,
    sigit_t_persona_giuridica.flg_amministratore,
    sigit_t_persona_giuridica.data_ult_mod,
    sigit_t_persona_giuridica.utente_ult_mod,
    sigit_t_persona_giuridica.flg_terzo_responsabile,
    sigit_t_persona_giuridica.flg_distributore
   FROM sigit_t_persona_giuridica
  WHERE sigit_t_persona_giuridica.flg_distributore = 1::numeric;

ALTER TABLE sigit_new.vista_elenco_distributori OWNER TO sigit_new;
GRANT ALL ON TABLE sigit_new.vista_elenco_distributori TO sigit_new;
GRANT INSERT, SELECT, UPDATE, DELETE ON TABLE sigit_new.vista_elenco_distributori TO sigit_new_rw;

CREATE MATERIALIZED VIEW sigit_new.mv_vista_elenco_distributori
TABLESPACE pg_default
AS SELECT sigit_t_persona_giuridica.id_persona_giuridica,
    sigit_t_persona_giuridica.denominazione,
    sigit_t_persona_giuridica.codice_fiscale,
    sigit_t_persona_giuridica.fk_l2,
    sigit_t_persona_giuridica.indirizzo_sitad,
    sigit_t_persona_giuridica.indirizzo_non_trovato,
    sigit_t_persona_giuridica.sigla_prov,
    sigit_t_persona_giuridica.istat_comune,
    sigit_t_persona_giuridica.comune,
    sigit_t_persona_giuridica.provincia,
    sigit_t_persona_giuridica.civico,
    sigit_t_persona_giuridica.cap,
    sigit_t_persona_giuridica.email,
    sigit_t_persona_giuridica.data_inizio_attivita,
    sigit_t_persona_giuridica.data_cessazione,
    sigit_t_persona_giuridica.sigla_rea,
    sigit_t_persona_giuridica.numero_rea,
    sigit_t_persona_giuridica.flg_amministratore,
    sigit_t_persona_giuridica.data_ult_mod,
    sigit_t_persona_giuridica.utente_ult_mod,
    sigit_t_persona_giuridica.flg_terzo_responsabile,
    sigit_t_persona_giuridica.flg_distributore
   FROM sigit_t_persona_giuridica
  WHERE sigit_t_persona_giuridica.flg_distributore = 1::numeric
WITH DATA;

ALTER TABLE sigit_new.mv_vista_elenco_distributori OWNER TO sigit_new;
GRANT ALL ON TABLE sigit_new.mv_vista_elenco_distributori TO sigit_new;
GRANT INSERT, SELECT, UPDATE, DELETE ON TABLE sigit_new.mv_vista_elenco_distributori TO sigit_new_rw;

CREATE OR REPLACE VIEW sigit_new.vmv_vista_elenco_distributori
AS SELECT mv_vista_elenco_distributori.id_persona_giuridica,
    mv_vista_elenco_distributori.denominazione,
    mv_vista_elenco_distributori.codice_fiscale,
    mv_vista_elenco_distributori.fk_l2,
    mv_vista_elenco_distributori.indirizzo_sitad,
    mv_vista_elenco_distributori.indirizzo_non_trovato,
    mv_vista_elenco_distributori.sigla_prov,
    mv_vista_elenco_distributori.istat_comune,
    mv_vista_elenco_distributori.comune,
    mv_vista_elenco_distributori.provincia,
    mv_vista_elenco_distributori.civico,
    mv_vista_elenco_distributori.cap,
    mv_vista_elenco_distributori.email,
    mv_vista_elenco_distributori.data_inizio_attivita,
    mv_vista_elenco_distributori.data_cessazione,
    mv_vista_elenco_distributori.sigla_rea,
    mv_vista_elenco_distributori.numero_rea,
    mv_vista_elenco_distributori.flg_amministratore,
    mv_vista_elenco_distributori.data_ult_mod,
    mv_vista_elenco_distributori.utente_ult_mod,
    mv_vista_elenco_distributori.flg_terzo_responsabile,
    mv_vista_elenco_distributori.flg_distributore
   FROM mv_vista_elenco_distributori;

ALTER TABLE sigit_new.vmv_vista_elenco_distributori OWNER TO sigit_new;
GRANT ALL ON TABLE sigit_new.vmv_vista_elenco_distributori TO sigit_new;
GRANT INSERT, SELECT, UPDATE, DELETE ON TABLE sigit_new.vmv_vista_elenco_distributori TO sigit_new_rw;

CREATE OR REPLACE VIEW sigit_new.vista_dati_import_distributori
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
     LEFT JOIN sigit_t_rif_catast ON sigit_t_dato_distrib.id_dato_distrib = sigit_t_rif_catast.fk_dato_distrib;

ALTER TABLE sigit_new.vista_dati_import_distributori OWNER TO sigit_new;
GRANT ALL ON TABLE sigit_new.vista_dati_import_distributori TO sigit_new;
GRANT INSERT, SELECT, UPDATE, DELETE ON TABLE sigit_new.vista_dati_import_distributori TO sigit_new_rw;

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

ALTER TABLE sigit_new.mv_vista_dati_import_distributori OWNER TO sigit_new;
GRANT ALL ON TABLE sigit_new.mv_vista_dati_import_distributori TO sigit_new;
GRANT INSERT, SELECT, UPDATE, DELETE ON TABLE sigit_new.mv_vista_dati_import_distributori TO sigit_new_rw;

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

ALTER TABLE sigit_new.vmv_vista_dati_import_distributori OWNER TO sigit_new;
GRANT ALL ON TABLE sigit_new.vmv_vista_dati_import_distributori TO sigit_new;
GRANT INSERT, SELECT, UPDATE, DELETE ON TABLE sigit_new.vmv_vista_dati_import_distributori TO sigit_new_rw;

CREATE OR REPLACE VIEW sigit_new.vista_ricerca_allegati_storico
AS SELECT DISTINCT a.id_allegato,
    a.fk_stato_rapp,
    srapp.des_stato_rapp,
    a.fk_imp_ruolo_pfpg,
    a.fk_tipo_documento,
    doc.des_tipo_documento,
    a.fk_sigla_bollino,
    a.fk_numero_bollino,
    a.data_controllo,
    a.b_flg_libretto_uso,
    a.b_flg_dichiar_conform,
    a.b_flg_lib_imp,
    a.b_flg_lib_compl,
    a.f_osservazioni,
    a.f_raccomandazioni,
    a.f_prescrizioni,
    a.f_flg_puo_funzionare,
    a.f_intervento_entro,
    a.f_ora_arrivo,
    a.f_ora_partenza,
    a.f_denominaz_tecnico,
    a.f_flg_firma_tecnico,
    a.f_flg_firma_responsabile,
    a.data_invio,
    a.data_respinta,
    a.nome_allegato,
    a.a_potenza_termica_nominale_max,
    a.data_ult_mod,
    a.utente_ult_mod,
    a.elenco_combustibili,
    a.elenco_apparecchiature,
    a.fk_pg_cat,
    a.altro_descr,
    ru.des_ruolo,
    ru.ruolo_funz,
    pg.id_persona_giuridica,
    pg.denominazione AS pg_denominazione,
    pg.codice_fiscale AS pg_codice_fiscale,
    pg.fk_stato_pg AS pg_fk_stato_pg,
    pg.sigla_rea AS pg_sigla_rea,
    pg.numero_rea AS pg_numero_rea,
    r1.codice_impianto,
    i.denominazione_comune AS comune_impianto,
    i.sigla_provincia AS sigla_prov_impianto,
    COALESCE(u.indirizzo_sitad, u.indirizzo_non_trovato) AS indirizzo_unita_immob,
    u.civico AS civico_unita_immob,
    a.flg_controllo_bozza,
    a.uid_index,
    tm.id_tipo_manutenzione,
    tm.des_tipo_manutenzione,
    a.uid_index_firmato,
    a.nome_allegato_firmato
   FROM sigit_s_allegato a
     JOIN sigit_r_imp_ruolo_pfpg r1 ON a.fk_imp_ruolo_pfpg = r1.id_imp_ruolo_pfpg
     JOIN sigit_d_ruolo ru ON r1.fk_ruolo = ru.id_ruolo
     JOIN sigit_d_tipo_documento doc ON a.fk_tipo_documento = doc.id_tipo_documento
     JOIN sigit_d_tipo_manutenzione tm ON a.fk_tipo_manutenzione = tm.id_tipo_manutenzione
     JOIN sigit_d_stato_rapp srapp ON a.fk_stato_rapp = srapp.id_stato_rapp
     LEFT JOIN sigit_t_persona_giuridica pg ON r1.fk_persona_giuridica = pg.id_persona_giuridica
     LEFT JOIN sigit_t_impianto i ON r1.codice_impianto = i.codice_impianto
     LEFT JOIN sigit_t_unita_immobiliare u ON r1.codice_impianto = u.codice_impianto
  WHERE u.flg_principale = 1::numeric;

ALTER TABLE sigit_new.vista_ricerca_allegati_storico OWNER TO sigit_new;
GRANT ALL ON TABLE sigit_new.vista_ricerca_allegati_storico TO sigit_new;
GRANT INSERT, SELECT, UPDATE, DELETE ON TABLE sigit_new.vista_ricerca_allegati_storico TO sigit_new_rw;

CREATE OR REPLACE VIEW sigit_new.vista_ricerca_allegati
AS SELECT DISTINCT a.id_allegato,
    a.fk_stato_rapp,
    srapp.des_stato_rapp,
    a.fk_ispez_ispet,
    a.fk_tipo_documento,
    doc.des_tipo_documento,
    a.fk_sigla_bollino,
    a.fk_numero_bollino,
    a.data_controllo,
    a.b_flg_libretto_uso,
    a.b_flg_dichiar_conform,
    a.b_flg_lib_imp,
    a.b_flg_lib_compl,
    a.f_osservazioni,
    a.f_raccomandazioni,
    a.f_prescrizioni,
    a.f_flg_puo_funzionare,
    a.f_intervento_entro,
    a.f_ora_arrivo,
    a.f_ora_partenza,
    a.f_denominaz_tecnico,
    a.f_flg_firma_tecnico,
    a.f_flg_firma_responsabile,
    a.data_invio,
    a.data_respinta,
    a.nome_allegato,
    a.a_potenza_termica_nominale_max,
    a.data_ult_mod,
    a.utente_ult_mod,
    a.elenco_combustibili,
    a.elenco_apparecchiature,
    a.fk_pg_cat,
    a.altro_descr,
    ru.des_ruolo,
    ru.ruolo_funz,
    pg.id_persona_giuridica,
    pg.denominazione AS pg_denominazione,
    pg.codice_fiscale AS pg_codice_fiscale,
    pg.fk_stato_pg AS pg_fk_stato_pg,
    pg.sigla_rea AS pg_sigla_rea,
    pg.numero_rea AS pg_numero_rea,
    r1.codice_impianto,
    i.denominazione_comune AS comune_impianto,
    i.sigla_provincia AS sigla_prov_impianto,
    COALESCE(u.indirizzo_sitad, u.indirizzo_non_trovato) AS indirizzo_unita_immob,
    u.civico AS civico_unita_immob,
    a.flg_controllo_bozza,
    a.uid_index,
    tm.id_tipo_manutenzione,
    tm.des_tipo_manutenzione,
    a.dt_invio_memo,
    a.mail_invio_memo,
    a.uid_index_firmato,
    a.nome_allegato_firmato
   FROM sigit_t_allegato a
     JOIN sigit_r_comp4manut_all ON a.id_allegato = sigit_r_comp4manut_all.id_allegato
     JOIN sigit_r_comp4_manut r1 ON sigit_r_comp4manut_all.id_r_comp4_manut = r1.id_r_comp4_manut
     JOIN sigit_d_ruolo ru ON r1.fk_ruolo = ru.id_ruolo
     JOIN sigit_d_tipo_documento doc ON a.fk_tipo_documento = doc.id_tipo_documento
     JOIN sigit_d_tipo_manutenzione tm ON a.fk_tipo_manutenzione = tm.id_tipo_manutenzione
     JOIN sigit_d_stato_rapp srapp ON a.fk_stato_rapp = srapp.id_stato_rapp
     LEFT JOIN sigit_t_persona_giuridica pg ON r1.fk_persona_giuridica = pg.id_persona_giuridica
     LEFT JOIN sigit_t_impianto i ON r1.codice_impianto = i.codice_impianto
     LEFT JOIN sigit_t_unita_immobiliare u ON r1.codice_impianto = u.codice_impianto
  WHERE u.flg_principale = 1::numeric
UNION
 SELECT DISTINCT a.id_allegato,
    a.fk_stato_rapp,
    srapp.des_stato_rapp,
    a.fk_ispez_ispet,
    a.fk_tipo_documento,
    doc.des_tipo_documento,
    a.fk_sigla_bollino,
    a.fk_numero_bollino,
    a.data_controllo,
    a.b_flg_libretto_uso,
    a.b_flg_dichiar_conform,
    a.b_flg_lib_imp,
    a.b_flg_lib_compl,
    a.f_osservazioni,
    a.f_raccomandazioni,
    a.f_prescrizioni,
    a.f_flg_puo_funzionare,
    a.f_intervento_entro,
    a.f_ora_arrivo,
    a.f_ora_partenza,
    a.f_denominaz_tecnico,
    a.f_flg_firma_tecnico,
    a.f_flg_firma_responsabile,
    a.data_invio,
    a.data_respinta,
    a.nome_allegato,
    a.a_potenza_termica_nominale_max,
    a.data_ult_mod,
    a.utente_ult_mod,
    a.elenco_combustibili,
    a.elenco_apparecchiature,
    a.fk_pg_cat,
    a.altro_descr,
    ru.des_ruolo,
    ru.ruolo_funz,
    pg.id_persona_giuridica,
    pg.denominazione AS pg_denominazione,
    pg.codice_fiscale AS pg_codice_fiscale,
    pg.fk_stato_pg AS pg_fk_stato_pg,
    pg.sigla_rea AS pg_sigla_rea,
    pg.numero_rea AS pg_numero_rea,
    i.codice_impianto,
    i.denominazione_comune AS comune_impianto,
    i.sigla_provincia AS sigla_prov_impianto,
    COALESCE(u.indirizzo_sitad, u.indirizzo_non_trovato) AS indirizzo_unita_immob,
    u.civico AS civico_unita_immob,
    a.flg_controllo_bozza,
    a.uid_index,
    tm.id_tipo_manutenzione,
    tm.des_tipo_manutenzione,
    a.dt_invio_memo,
    a.mail_invio_memo,
    a.uid_index_firmato,
    a.nome_allegato_firmato
   FROM sigit_t_allegato a
     JOIN sigit_r_ispez_ispet r1 ON a.fk_ispez_ispet = r1.id_ispez_ispet
     JOIN sigit_d_ruolo ru ON r1.fk_ruolo = ru.id_ruolo
     JOIN sigit_d_tipo_documento doc ON a.fk_tipo_documento = doc.id_tipo_documento
     JOIN sigit_d_tipo_manutenzione tm ON a.fk_tipo_manutenzione = tm.id_tipo_manutenzione
     JOIN sigit_d_stato_rapp srapp ON a.fk_stato_rapp = srapp.id_stato_rapp
     JOIN sigit_t_ispezione_2018 isp ON r1.id_ispezione_2018 = isp.id_ispezione_2018
     LEFT JOIN sigit_t_persona_giuridica pg ON r1.fk_persona_giuridica = pg.id_persona_giuridica
     LEFT JOIN sigit_t_impianto i ON isp.codice_impianto = i.codice_impianto
     LEFT JOIN sigit_t_unita_immobiliare u ON i.codice_impianto = u.codice_impianto
  WHERE u.flg_principale = 1::numeric;

ALTER TABLE sigit_new.vista_ricerca_allegati OWNER TO sigit_new;
GRANT ALL ON TABLE sigit_new.vista_ricerca_allegati TO sigit_new;
GRANT INSERT, SELECT, UPDATE, DELETE ON TABLE sigit_new.vista_ricerca_allegati TO sigit_new_rw;

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

ALTER TABLE sigit_new.od_vista_dettaglio_impianti OWNER TO sigit_new;
GRANT ALL ON TABLE sigit_new.od_vista_dettaglio_impianti TO sigit_new;
GRANT INSERT, SELECT, UPDATE, DELETE ON TABLE sigit_new.od_vista_dettaglio_impianti TO sigit_new_rw;

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

ALTER TABLE sigit_new.vista_tot_impianto OWNER TO sigit_new;
GRANT ALL ON TABLE sigit_new.vista_tot_impianto TO sigit_new;
GRANT INSERT, SELECT, UPDATE, DELETE ON TABLE sigit_new.vista_tot_impianto TO sigit_new_rw;

