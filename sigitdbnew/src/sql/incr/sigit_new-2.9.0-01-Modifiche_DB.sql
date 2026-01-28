----------------------------------------------------------------------------------------
-- 23/7/2023  Lorita
-- Modifiche SIGIT_T_DOC_AZIONE allungamento campi nome documento da richiesta skype di Mariuccia
-- DEV 23/7/2023
----------------------------------------------------------------------------------------
ALTER TABLE sigit_new.sigit_t_doc_azione ALTER COLUMN nome_doc_originale TYPE varchar(200) USING nome_doc_originale::varchar;

ALTER TABLE sigit_new.sigit_t_doc_azione ALTER COLUMN nome_doc TYPE varchar(200) USING nome_doc::varchar;

----------------------------------------------------------------------------------------
-- 10/2023  Lorita
-- Modifiche per upgrade di versione Postgres da 9.6 a 15.8
----------------------------------------------------------------------------------------
CREATE OR REPLACE FUNCTION sigit_new.trunc(myTimestamp timestamp)
 RETURNS timestamp
 LANGUAGE plpgsql
AS $function$
 DECLARE
    a timestamp;
BEGIN 
      a:=DATE_TRUNC('day',myTimestamp);
      RETURN a ;
      EXCEPTION WHEN others THEN 
     	RETURN cast(NULL as TIMESTAMP) ;
END; 
$function$
;

CREATE OR REPLACE FUNCTION sigit_new.to_number(myNumber text)
 RETURNS numeric
 LANGUAGE plpgsql
AS $function$
 DECLARE
    a numeric;
BEGIN 
	if COALESCE(myNumber,null,'') = ''
	then RETURN 0;
    end if;
      a:=COALESCE(myNumber, 'NOS-Numbers');
      RETURN a ;
      EXCEPTION WHEN others THEN RETURN '' ;
END; 
$function$
;

ALTER TABLE sigit_l_accesso DROP CONSTRAINT  pk_sigit_l_accesso ;  

ALTER TABLE sigit_l_accesso ADD CONSTRAINT pk_sigit_l_accesso PRIMARY KEY (dt_accesso, codice_fiscale, ruolo);