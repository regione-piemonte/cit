----------------------------------------------------------------------------------------
-- 18/4/2023  Lorita
-- Modifica SIGIT_T_IMPIANTO aggiunta flg_medioImpianto da richiesta skype di Mariuccia
-- DEV 18/4/2023
----------------------------------------------------------------------------------------
ALTER TABLE sigit_new.sigit_t_impianto ADD column 
	flg_medioImpianto NUMERIC(1)  NULL  CONSTRAINT  dom_0_1_medioImp CHECK (flg_medioImpianto IN (null,0,1));

----------------------------------------------------------------------------------------
-- 8/9/2023  Lorita
-- Eliminati campi butta da richiesta skype di Beppe del 4/9/2023 h 15:26
-- DEV 8/9/2023
----------------------------------------------------------------------------------------
alter table sigit_r_allegato_comp_cg drop column butta_fk_r_pg;
alter table sigit_r_allegato_comp_cg drop column butta_fk_3r_pg;
alter table sigit_r_allegato_comp_cg drop column butta_fk_r_pf;
alter table sigit_r_allegato_comp_cg drop column butta_fk_3resp;
alter table sigit_r_allegato_comp_cg drop column butta_fk_resp;

alter table sigit_r_allegato_comp_sc drop column butta_fk_r_pg;
alter table sigit_r_allegato_comp_sc drop column butta_fk_3r_pg;
alter table sigit_r_allegato_comp_sc drop column butta_fk_r_pf;
alter table sigit_r_allegato_comp_sc drop column butta_fk_3resp;
alter table sigit_r_allegato_comp_sc drop column butta_fk_resp;

----------------------------------------------------------------------------------------
-- 11/9/2023  Lorita
-- Cancellazione vincolo NOT NULL su sigit_t_impianto.data_assegnazione 
-- da richiesta skype di Beppe del 11/9/2023 h 15:09
-- DEV 11/9/2023
----------------------------------------------------------------------------------------
alter table sigit_t_impianto alter column data_assegnazione drop not null;

----------------------------------------------------------------------------------------
-- TEST 17/10/2023 tutti gli script fino qui
----------------------------------------------------------------------------------------
