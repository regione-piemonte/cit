----------------------------------------------------------------------------------------
-- 10/12/2020  Lorita
-- Modifiche tabelle sigit_l_accesso e sigit_s_accesso
--  come da mail di Mariuccia del 1/12/2020 16:47
----------------------------------------------------------------------------------------
alter TABLE sigit_new.sigit_l_accesso 
	drop CONSTRAINT pk_sigit_l_accesso;
	
alter TABLE sigit_new.sigit_l_accesso 
	add CONSTRAINT pk_sigit_l_accesso PRIMARY KEY (dt_accesso, codice_fiscale);
	
CREATE TABLE sigit_new.sigit_s_accesso (
	dt_accesso timestamp NOT NULL,
	codice_fiscale varchar(16) NOT NULL,
	nome varchar(100) NULL,
	cognome varchar(100) NULL,
	ruolo varchar(50) NULL,
	CONSTRAINT pk_sigit_s_accesso PRIMARY KEY (dt_accesso, codice_fiscale)
);

ALTER TABLE sigit_new.sigit_s_accesso OWNER TO sigit_new;
GRANT ALL ON TABLE sigit_new.sigit_s_accesso TO sigit_new;
GRANT INSERT, SELECT, UPDATE, DELETE, TRUNCATE ON TABLE sigit_new.sigit_s_accesso TO sigit_new_rw;

----------------------------------------------------------------------------------------
-- 29/01/2021  Lorita
-- Modifica tabella SIGIT_T_IMPIANTO aggiunta flg_no_opendata
--  come da mail di Mariuccia del 29/01/2021 15:50
----------------------------------------------------------------------------------------
ALTER TABLE sigit_t_impianto ADD COLUMN 
	flg_no_opendata       NUMERIC(1)  DEFAULT  0 NOT NULL  CONSTRAINT  dom_0_1_open CHECK (flg_no_opendata IN (0,1));

----------------------------------------------------------------------------------------
-- 03/02/2021  Lorita
-- Modifica tabella SIGIT_T_ALLEGATO aggiunta uid_index_firmato, nome_allegato_firmato
--  come da mail di Mariuccia del 03/02/2021 10:53
-- aggiungere anche su SIGIT_S_ALLEGATO
----------------------------------------------------------------------------------------
ALTER TABLE sigit_t_allegato ADD COLUMN uid_index_firmato     	CHARACTER VARYING(50)  NULL;
ALTER TABLE sigit_t_allegato ADD COLUMN nome_allegato_firmato  	CHARACTER VARYING(50)  NULL;

ALTER TABLE sigit_s_allegato ADD COLUMN uid_index_firmato     	CHARACTER VARYING(50)  NULL;
ALTER TABLE sigit_s_allegato ADD COLUMN nome_allegato_firmato  	CHARACTER VARYING(50)  NULL;
