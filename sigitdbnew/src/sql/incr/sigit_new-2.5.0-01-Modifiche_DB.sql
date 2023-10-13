---------- RICORDARSI GRANT UTENTE RO -----------------
----------------------------------------------------------------------------------------
-- 10/01/2022  Lorita
-- Aggiunta campi su sigit_t_persona_giuridica
-- Aggiunta tabella sigit_t_graffatura
--  come da mail di Mariuccia del 4/01/2022 12:02
-- DEV e TEST
----------------------------------------------------------------------------------------
/* ---------------------------------------------------------------------- */
/* Script generated with: DeZign for Databases 12.2.0                     */
/* Target DBMS:           PostgreSQL 9                                    */
/* Project file:          SIGIT_V20.dez                                   */
/* Project name:                                                          */
/* Author:                                                                */
/* Script type:           Database creation script                        */
/* Created on:            2022-01-10 18:21                                */
/* ---------------------------------------------------------------------- */
ALTER TABLE sigit_new.sigit_t_persona_giuridica ADD COLUMN pec CHARACTER VARYING(100);
ALTER TABLE sigit_new.sigit_t_persona_giuridica ADD COLUMN telefono CHARACTER VARYING(50);

/* ---------------------------------------------------------------------- */
/* Add table "sigit_t_graffatura"                                         */
/* ---------------------------------------------------------------------- */

CREATE TABLE sigit_t_graffatura (
    id_graffatura NUMERIC(10)  NOT NULL,
    codice_impianto NUMERIC  NOT NULL,
    dt_inserimento TIMESTAMP  NOT NULL,
    dt_cancellazione TIMESTAMP,
    utente_ult_mod CHARACTER VARYING(16),
    CONSTRAINT PK_sigit_t_graffatura PRIMARY KEY (id_graffatura, codice_impianto, dt_inserimento)
);

/* ---------------------------------------------------------------------- */
/* Add foreign key constraints                                            */
/* ---------------------------------------------------------------------- */

ALTER TABLE sigit_t_graffatura ADD CONSTRAINT sigit_t_impianto_sigit_t_graffatura 
    FOREIGN KEY (codice_impianto) REFERENCES sigit_new.sigit_t_impianto (codice_impianto);

CREATE SEQUENCE sigit_new.seq_t_graffatura
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1;

----------------------------------------------------------------------------------------
-- 21/02/2022  Lorita
-- Aggiunta campi uid_index_firmato e nome_allegato_firmato
-- su viste vista_ricerca_allegati e vista_ricerca_allegati_storico
--  come da messaggio Skype di Mariuccia del 21/02/2022 12:02
-- DEV e TEST
----------------------------------------------------------------------------------------
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
    a.uid_index_firmato, a.nome_allegato_firmato
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
    a.uid_index_firmato, a.nome_allegato_firmato
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
    a.uid_index_firmato, a.nome_allegato_firmato
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

----------------------------------------------------------------------------------------
-- 25/03/2022  Lorita
-- Aggiunta campi
--indirizzo mail del responsabile persona fisica o giuridica
--indirizzo mail del terzo responsabile
--  su mv_vista_ricerca_impianti, vmv_vista_ricerca_impianti
--  come da mail di Katia del 04/13/2022 12:02
-- DEV e TEST
----------------------------------------------------------------------------------------
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

-- Permissions

ALTER TABLE sigit_new.mv_vista_ricerca_impianti OWNER TO sigit_new;
GRANT ALL ON TABLE sigit_new.mv_vista_ricerca_impianti TO sigit_new;
GRANT INSERT, SELECT, UPDATE, DELETE ON TABLE sigit_new.mv_vista_ricerca_impianti TO sigit_new_rw;
GRANT SELECT ON TABLE sigit_new.mv_vista_ricerca_impianti TO sigit_new_ro;

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

-- Permissions

ALTER TABLE sigit_new.vmv_vista_ricerca_impianti OWNER TO sigit_new;
GRANT ALL ON TABLE sigit_new.vmv_vista_ricerca_impianti TO sigit_new;
GRANT INSERT, SELECT, UPDATE, DELETE ON TABLE sigit_new.vmv_vista_ricerca_impianti TO sigit_new_rw;
GRANT SELECT ON TABLE sigit_new.vmv_vista_ricerca_impianti TO sigit_new_ro;

----------------------------------------------------------------------------------------
-- 29/03/2022  Lorita
-- Aggiunta campi
--indirizzo mail del responsabile persona fisica o giuridica
--indirizzo mail del terzo responsabile
--  su vista_ricerca_impianti
--  come da mail di Mariuccia del 25/3/2022 20:16
-- DEV e TEST
----------------------------------------------------------------------------------------
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
