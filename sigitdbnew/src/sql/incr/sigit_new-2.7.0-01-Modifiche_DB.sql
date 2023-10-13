----------------------------------------------------------------------------------------
-- 3/1/2023  Lorita
-- Creazione nuova tabella sigit_wrk_log_memo_ptu come da accordi nella call del 15/12/2022
-- DEV 3/1/2023
----------------------------------------------------------------------------------------

/* ---------------------------------------------------------------------- */
/* Script generated with: DeZign for Databases 12.2.0                     */
/* Target DBMS:           PostgreSQL 9                                    */
/* Project file:          SIGIT_V21.dez                                   */
/* Project name:                                                          */
/* Author:                                                                */
/* Script type:           Database creation script                        */
/* Created on:            2022-12-16 14:56                                */
/* ---------------------------------------------------------------------- */


/* ---------------------------------------------------------------------- */
/* Add tables                                                             */
/* ---------------------------------------------------------------------- */

/* ---------------------------------------------------------------------- */
/* Add table "sigit_new.sigit_wrk_log_memo_ptu"                           */
/* ---------------------------------------------------------------------- */

CREATE TABLE sigit_new.sigit_wrk_log_memo_ptu (
    id_log_memo_ptu NUMERIC  NOT NULL,
    dt_log_memo_ptu TIMESTAMP,
    note_log_memo_ptu CHARACTER VARYING(1000),
    messaggio_log_memo_ptu TEXT,
    esito_log_memo_ptu CHARACTER VARYING(250),
    CONSTRAINT pk_sigit_wrk_log_memo_ptu PRIMARY KEY (id_log_memo_ptu)
);

COMMENT ON COLUMN sigit_new.sigit_wrk_log_memo_ptu.dt_log_memo_ptu IS 'Contiene data avvio e poi data esito';

COMMENT ON COLUMN sigit_new.sigit_wrk_log_memo_ptu.note_log_memo_ptu IS 'Contiene eventuali messaggi utili emersi durante l''elaborazione';

COMMENT ON COLUMN sigit_new.sigit_wrk_log_memo_ptu.messaggio_log_memo_ptu IS 'Contiene il json inviato al servizio PTTU';

GRANT SELECT ON TABLE sigit_new.sigit_wrk_log_memo_ptu TO sigit_new_ro;


ALTER TABLE sigit_new.sigit_s_allegato ADD column id_log_memo_ptu NUMERIC;

ALTER TABLE sigit_new.sigit_t_allegato ADD column id_log_memo_ptu NUMERIC;

ALTER TABLE sigit_s_allegato ADD CONSTRAINT sigit_wrk_log_memo_ptu_sigit_s_allegato 
    FOREIGN KEY (id_log_memo_ptu) REFERENCES sigit_wrk_log_memo_ptu (id_log_memo_ptu);

ALTER TABLE sigit_t_allegato ADD CONSTRAINT sigit_wrk_log_memo_ptu_sigit_t_allegato 
    FOREIGN KEY (id_log_memo_ptu) REFERENCES sigit_wrk_log_memo_ptu (id_log_memo_ptu);

CREATE SEQUENCE sigit_new.sigit_wrk_log_memo_ptu_id
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1;

ALTER SEQUENCE sigit_new.sigit_wrk_log_memo_ptu_id OWNER TO sigit_new;

----------------------------------------------------------------------------------------
-- 15/03/2023  Beppe
-- Modifica la tabella sigit_l_accesso ampliato campo ruolo (da 50 a 100)
-- DEV 15/03/2023
----------------------------------------------------------------------------------------

ALTER TABLE sigit_l_accesso ALTER COLUMN ruolo TYPE character varying(100);

----------------------------------------------------------------------------------------
-- 31/1/2023  Lorita
-- Modifica viste vista_ricerca_allegati e vista_ricerca_allegati_storico come da richiesta in chat
-- DEV 31/1/2023
----------------------------------------------------------------------------------------
CREATE OR REPLACE VIEW sigit_new.vista_ricerca_allegati
as SELECT DISTINCT a.id_allegato,
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
    a.nome_allegato_firmato,
    id_log_memo_ptu
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
    a.nome_allegato_firmato,
    id_log_memo_ptu
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

-- Permissions

ALTER TABLE sigit_new.vista_ricerca_allegati OWNER TO sigit_new;
GRANT ALL ON TABLE sigit_new.vista_ricerca_allegati TO sigit_new;
GRANT INSERT, SELECT, UPDATE, DELETE ON TABLE sigit_new.vista_ricerca_allegati TO sigit_new_rw;
GRANT SELECT ON TABLE sigit_new.vista_ricerca_allegati TO sigit_new_ro;

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
    a.nome_allegato_firmato,
    id_log_memo_ptu
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

-- Permissions

ALTER TABLE sigit_new.vista_ricerca_allegati_storico OWNER TO sigit_new;
GRANT ALL ON TABLE sigit_new.vista_ricerca_allegati_storico TO sigit_new;
GRANT INSERT, SELECT, UPDATE, DELETE ON TABLE sigit_new.vista_ricerca_allegati_storico TO sigit_new_rw;
GRANT SELECT ON TABLE sigit_new.vista_ricerca_allegati_storico TO sigit_new_ro;
