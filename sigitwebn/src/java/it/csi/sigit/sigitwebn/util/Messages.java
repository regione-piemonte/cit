/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
/*
 * 
 */
package it.csi.sigit.sigitwebn.util;


/**
 * The Class Messages.
 */
public class Messages {

	// Classe che contieni le costanti MESSAGGI
	public final static String WARN_APPLICATIVO_IN_MANUTENZIONE = "Il servizio a causa di una manutenzione non e' al momento disponibile";

	public final static String ERROR_FIELD_FORMAL_ERROR = "campo non corretto";
	public final static String ERROR_GENERICO = "Si e' verificato un problema non previsto. Contattare l'amministratore di sistema";
	public final static String ERROR_ACCESSO = "Si e' verificato un problema nell'accesso. Contattare l'amministratore di sistema";
	public final static String ERROR_RECUPERO_SERVIZIO = "Errore durante il recupero dei dati dal servizio. Contattare l'amministratore di sistema";
	public final static String ERROR_SERVIZIO_NON_RAGGIUNGIBILE = "Un servizio non e' raggiungibile - Riprovare piu' tardi o contattare l'amministratore di sistema";
	public final static String ERROR_CAMPO_ABBIGATORIO_FIELD = "campo ##value## obbligatorio";
	public final static String ERROR_NESSUN_DATO_INDICATO = "Non e' stato indicato nessun dato";
	public final static String ERROR_CAMPO_ABBIGATORIO = "il campo e' obbligatorio";
	public final static String ERROR_SOLO_NUMERICI = "il campo deve essere numerico";
	public final static String ERROR_RECUPERO_DB = "Errore durante il recupero dei dati. Contattare l'amministratore di sistema";
	public final static String ERROR_INSERT_DB = "Errore durante l'inserimento dei dati. Contattare l'amministratore di sistema";
	public final static String ERROR_UPDATE_DB = "Errore durante l'aggiornamento dei dati. Contattare l'amministratore di sistema";
	public final static String ERROR_FORMALE_CODICE_FISCALE = "codice fiscale formalmente errato";
	public final static String ERROR_FORMALE_DATA = "data formalmente errata";
	public final static String ERROR_DATA_FUTURA = "non e' possibile inserire una data futura";
	public final static String ERROR_DATA_PASSATA = "non e' possibile inserire una data passata";
	public final static String ERROR_DATA_1900 = "non e' possibile inserire una data antecedente il 01/01/1900";
	public final static String ERROR_COMPONENTI_NON_ATTIVI_IN_DATA = "Errore: non esistono componenti ##value1## attivi in data ##value2##";
	public final static String ERROR_UPDATE_PROV_COM = "Errore durante l'aggiornamento dei dati. Verificare la denominazione della provincia/comune";

	public final static String ERROR_VALORE_FORMALE = "campo formalmente errato";
	public final static String ERROR_PARTITA_IVA = "partita iva formalmente errata";
	public final static String ERROR_INSTALLATORE_NON_TROVATO = "installatore non presente nell'albo";
	public final static String ERROR_IMPRESA_NON_TROVATA = "impresa non trovata";
	public final static String ERROR_INSTALLATORE_OBBLIGATORIO = "per proseguire bisogna prima ricercare l'installatore";
	public final static String ERROR_EMAIL_FORMAT= "indirizzo e-mail formalmente non corretto";
	public final static String ERROR_INVIO_MAIL = "Errore durante l'invio della mail";

	public final static String ERROR_FORMALE_CAP = "CAP formalmente errato";
	public final static String ERROR_FORMALE_RECUPERO_CODICE_IMPIANTO = "Errore durante il recupero del codice impianto";
	public final static String ERROR_RECUPERO_PERSONA_GIURIDICA = "Non trovata alcuna persona giuridica";
	//public final static String ERROR_ALTRI_CONTRATTI = "esistono gia' altri contratti nel periodo indicato";
	public final static String ERROR_FORMALE_POD = "POD formalmente errato";
	public final static String ERROR_FORMALE_PDR = "PDR formalmente errato";

	public final static String ERROR_INSTALLATORE_CESSATO = "l'installatore ha cessato l'attivita' in data ##value##, non e' possibile assegnare un codice in una data successiva";
	public final static String ERROR_DATA_RESPONSABILE = "la data di fine responsabilita' deve essere uguale o successiva alla data di inizio responsabilita'";
	public final static String ERROR_RESPONSABILE_ATTIVO = "Esiste gia' un responsabile attivo";
	public final static String ERROR_RESPONSABILE_ASSENTE = "Non esistono responsabili attivi";
	public final static String ERROR_IMPOSSIBILE_CONSOLIDARE = "Impossibile consolidare";
	public final static String ERROR_RESPONSABILE_DATA_RAPP_ASSENTE = "non esistono responsabili attivi alla data controllo";
	//public final static String ERROR_RESPONSABILE_DATA_RAPP_ASSENTE_1 = "Errore: ##valueNomeFile## non esistono responsabili attivi alla data controllo";

	public final static String ERROR_CONTRATTO_NO_COMPETENZA = "Si sta cercando di operare su un contratto non di propria competenza";
	public final static String ERROR_IMPIANTO_NO_COMPETENZA = "Si sta cercando di operare su un impianto non di propria competenza";

	
	public final static String ERROR_SELEZIONARE_COMUNE = "selezionare un comune";
	public final static String ERROR_SELEZIONARE_PROVINCIA = "selezionare una provincia";
	
	public final static String ERROR_LUNGHEZZA = "il campo deve essere di ##value## caratteri";
	public final static String ERROR_LUNGHEZZA_MINIMA = "il campo accetta minimo ##value## caratteri alfanumerici";
	public final static String ERROR_LUNGHEZZA_MASSIMA = "il campo accetta massimo ##value## caratteri alfanumerici";
	public final static String ERROR_CARATTERI_SPECIALI = "il campo non accetta caratteri speciali. Es. accapo, lettere accentate, etc.";
	
	public final static String ERROR_SIGLA_NUMERO_BOLLINO = "se si indica il numero REE e' obbligatorio indicare anche la sigla (e viceversa)";
	public final static String ERROR_CODICE_REA_CF_MANCANTE = "indicare il codice REA oppure il codice fiscale dell'impresa";
	public final static String ERROR_CODICE_REA_DENOMINAZIONE_CF_MANCANTE = "indicare il codice REA o il codice fiscale o il cognome/denominazione dell'impresa";
	public final static String ERROR_DENOMINAZIONE_CF_MANCANTE = "indicare il codice fiscale o il cognome/denominazione del manutentore";
	public final static String ERROR_IS_IMPRESA_MANCANTE = "indicare se si tratta di impresa";

	public final static String ERROR_CODICE_REA_NON_CERCATO = "il codice REA e codice fiscale inserito e' gia' presente nel sistema. Per associarlo all'impianto premere il tasto 'cerca'";
	public final static String ERROR_CF_NON_CERCATO = "il codice fiscale inserito e' gia' presente nel sistema. Per associarlo all'impianto premere il tasto 'cerca'";
	public final static String ERROR_METODO_PAGAMENTO_OBBLIGATORIO = "per proseguire bisogna prima indicare il gestore e modalita' del pagamento";
	public final static String ERROR_LIBRETTO_NON_CONTROLLATO = "occorre prima verificare il libretto";
	public final static String ERROR_LIBRETTO_COMP_NON_CONTROLLATE = "occorre prima verificare le seguenti componenti: ##value##";
	public final static String ERROR_PDR_OBBLIGATORIO = "bisogna indicare il pdr o dichiare che non e' presente";

	public final static String ERROR_DENOMINAZIONE_CF_MANCANTE_DELEGATO = "indicare il codice fiscale o il cognome del delegato";

	public final static String ERROR_ALLEGATO_IN_BOZZA = "Impossibile inserire il libretto, esiste un rapporto di controllo in stato bozza.";
	public final static String ERROR_DATA_PROROGA_CONTRATTO = "La data proroga deve essere successiva alla vecchia data fine contratto";
	public final static String ERROR_DATA_PROROGA_CONTRATTO_CESSATO = "Non e' possibile prorogare un contratto cessato esplicitamente dall'utente prima della naturale scadenza";
	public final static String ERROR_DATA_PROROGA_CONTRATTO_TACITO_RINNOVO = "Non e' necessario prorogare la terza responsabilita' in quanto gia' soggetta al tacito rinnovo";
	
	
	public final static String ERROR_CODICE_IMPIANTO_NON_ESISTE = "non esiste un impianto con il codice specificato";
	public final static String ERROR_BOLLINO_NON_ESISTE = "non esiste un bollino con il codice specificato";
	public final static String ERROR_DATO_DISTRIBUTORE_NON_ESISTE = "non esiste un dato distributore con il codice specificato";

	public final static String ERROR_CODICE_IMPIANTO_NON_CORRETTO = "il codice impianto specificato (##value##) e' formalmente errato";

	public final static String ERROR_FLAG_MAN_INS_AMM = "Almeno uno dei FLG installatore/manutentore/altra impresa/terzo responsabile/distributore/CAT deve essere selezionato";

	public final static String ERROR_SELEZIONARE_RIGA = "selezionare almeno una riga";

	public final static String ERROR_DEVE_ESSERE_ANNO = "deve essere un anno";
	public final static String ERROR_ANNO_FUTURO = "non puo' essere una data futura";
	public final static String ERROR_CAMPO_OBBLIGATORIO = "&egrave un campo obbligatorio";
	public final static String ERROR_DEVE_ESSERE_NUMERICO = "deve essere un campo numerico";
	public final static String ERROR_DEVE_ESSERE_NUMERICO_POSITIVO = "deve essere un campo numerico maggiore o uguale a 0";
	public final static String ERROR_CAMPO_NON_CORRETTO = "non ha un valore corretto";
	public final static String ERROR_DECIMALI_NON_CORRETTI = "ammette massimo 16 caratteri e di cui massimo 2 decimali";
	public final static String ERROR_NUMERO_NON_CORRETTO = "ammette massimo ##value1## interi e ##value2## decimali";

	public final static String ERROR_LIBRETTO_SCHEDA1_NON_SALVATA = "Attenzione: e' il tuo primo accesso al libretto WEB, per poter compilare le altre parti del libretto e' necessario eseguire un salvataggio della Scheda 1 Identificativa Impianto";
	public final static String ERROR_DATA_INSTALL_DISMISS = "la data di dismissione deve essere uguale o successiva alla data di istallazione";
	public final static String ERROR_DATA_INSTALL_DISMISS_DISM = "la data di installazione deve essere successiva rispetto all'ultimo dismesso";
	public final static String ERROR_COMPONENTE_NON_DISMESSA = "la componente non risulta dismessa correttamente";

	
	public final static String ERROR_VALORE_MASSIMO = "Il valore massimo e' ##value##";
	public final static String ERROR_VALORE_MINIMO = "Il valore deve essere maggiore di ##value##";
	public final static String ERROR_DEVE_ESSERE_NUMERICO_TOT_CARATTERI_DI_CUI_INTERI = "deve essere un campo numerico di ##value1## caratteri di cui massimo ##value2## interi";
	public final static String ERROR_DEVE_ESSERE_NUMERICO_TOT_CARATTERI_DI_CUI_DECIMALI = "deve essere un campo numerico di ##value1## caratteri di cui massimo ##value2## decimali";
	public final static String ERROR_DEVE_ESSERE_NUMERICO_TOT_CARATTERI = "deve essere un campo numerico di ##value## caratteri";
	
	public final static String INFO_COD_IMPIANTO_VERIFICATO = "codice impianto verificato correttamente";
	public final static String INFO_COD_IMPIANTO_VERIFICATO_NO_DATA_ASS = "codice impianto verificato correttamente <BR> Attenzione e' stata impostata la data di assegnazione uguale alla data di acquisizione del codice impianto";
	public final static String INFO_COD_IMPIANTO_VERIFICATO_NON_USATO = "codice impianto non censito a sistema: e' comunque possibile procedere con il subentro previo il caricamento dei dati impianto";
	public final static String INFO_INSERIMENTO_CORRETTO = "l'inserimento e' avvenuto correttamente";
	public final static String INFO_MODIFICA_CORRETTA = "la modifica e' avvenuta correttamente";
	public final static String INFO_ALLEGATO_INVIATO_CORRETTAMENTE = "il REE e' stato inviato correttamente";
	public final static String INFO_ALLEGATO_INVIATO_IMP_NON_VALVOLE = "<BR><font color=\"red\">l'impianto centralizzato oggetto del presente rapporto di controllo, non e' conforme all'obbligo di installazione di un sistema di contabilizzazione / ripartizione ai sensi del dlgs 102/2014 e non risulta caricata nessuna relazione di deroga all'obbligo</font>";
	public final static String INFO_ALLEGATO_INVIATO_NON_SICURO = "<BR><font color=\"red\">In caso di carenze riscontrate in materia di sicurezza, tali da arrecare un immediato pericolo alle persone, agli animali domestici e ai beni, deve essere data comunicazione al Comune su cui insiste l'impianto</font>";
	public final static String INFO_ELIMINAZIONE_CORRETTA = "l'eliminazione e' avvenuta correttamente";
	public final static String INFO_ALLEGATO_RESPINTO_CORRETTAMENTE = "il REE e' stato respinto correttamente.";
	public final static String INFO_NESSUNA_MAIL_INVIATA = "Non e' stata inviata nessuna mail";
	public final static String INFO_SUBENTRO_CORRETTO = "il subentro e' avvenuto correttamente";
	public final static String INFO_ANNULLAMENTO_CORRETTO = "l'annullamento e' avvenuto correttamente";
	public final static String INFO_MANUTENZIONE_ANNULLATA_CORRETTAMENTE = "la manutenzione e' stata annullata correttamente.";
	public final static String INFO_ANNULLAMENTO_ACCERTAMENTO_CORRETTO = "accertamento annullato da ##value##";

	public final static String INFO_SALVATAGGIO_CORRETTO = "il salvataggio e' avvenuto correttamente";
	public final static String INFO_LIBRETTO_CONSOLIDATO_CORRETTAMENTE = "libretto consolidato correttamente";

	public final static String INFO_DOCUMENTO_IMPORTATO_CORRETTAMENTE = "documento importato correttamente";
	
	public final static String INFO_DELEGA_INSERITA_CORRETTAMENTE = "inserimento delegato avvenuto correttamente";
	public final static String INFO_INCARICO_INSERITO_CORRETTAMENTE = "inserimento incaricato avvenuto correttamente";

	public final static String INFO_VERIFICA_EMAIL_OK= "E' stata inviata una e-mail di verifica";
	public final static String INFO_VERIFICA_EMAIL_KO= "Problemi nell'invio della mail di verifica, verificare l'indirizzo mail (##value##)";

	public final static String INFO_INDIRIZZI_MAIL_OK= "E-mail inviate: ##value##";
	public final static String INFO_INDIRIZZI_MAIL_KO= "<font color=\"red\">E-mail non inviate (verificare l'indirizzo mail): ##value##</font>";
	public final static String INFO_AZIONE_CORRETTA = "l'azione e' stata caricata correttamente";

	public final static String S006	= "campo obbligatorio";
	public final static String S007	= "selezionare una voce dall'elenco";
	public final static String S009 = "accesso negato - Utente non autorizzato";
	public final static String S010 = "impostare almeno un criterio di ricerca";
	public final static String S011 = "indicare sia la sigla sia il codice REA";
	public final static String S011_bis = "indicare sia la sigla bollino sia il numero bollino";
	public final static String S012 = "indicare un valore numerico intero";
	public final static String S014 = "la ditta ha cessato l'attivita' in data ##value##, impossibile assegnare nuovi codici impianto";
	public final static String S015 = "la quantita' non puo' essere superiore a ##value##";
	public final static String S016 = "inserire un valore multiplo di ##value##";
	public final static String S018 = "la quantita' deve essere un valore numerico intero e maggiore di 0";
	public final static String S019 = "impossibile eliminare l'impianto perche' ci sono dei rapporti di controllo associati attivi o storicizzati. Se possibile eliminare gli allegati o modificare lo stato dell'impianto in 'Cancellato'";
	public final static String S020 = "impossibile eliminare l'impianto perche' esiste un libretto consolidato. E' possibile modificare  lo stato dell'impianto in 'Cancellato'";
	

	public final static String S021 = "per verificare il codice impianto bisogna prima cercare l'installatore";
	public final static String S022 = "il codice impianto non risulta associato all'installatore indicato";
	public final static String S023 = "il codice impianto indicato e' stato ritirato successivamente alla data di assegnazione indicata"; 
	public final static String S024 = "Impianto gia' caricato su sistema. Effettuare la ricerca per visualizzarne i dettagli";
	public final static String S024_1 = "Codice impianto non coerente con i dati del CIT. Verificare il codice indicato";

	public final static String S025 = "la data di dismissione deve essere uguale o successiva alla data di assegnazione";
	public final static String S026 = "il manutentore ha cessato l'attivita' in data ##value##, non e' possibile assegnare un codice o dismettere un impianto in una data successiva";
	public final static String S027 = "non e' possibile modificare la localizzazione dell'impianto";

	public final static String S030 = "e' necessario ricercare l'impresa";
	public final static String S031 = "la quantita' non puo' essere superiore a ##value##";
	public final static String S032 = "non e' possibile effettuare il pagamento per problemi tecnici, si prega di riprovare piu' tardi";
	public final static String S033 = "la quantita' deve essere un valore numerico intero maggiore di 0";
	
	public final static String S034 = "inserire una quantita'";
	public final static String S040 = "il REE puo' essere modificato o inviato solo da chi lo ha generato e se in stato BOZZA";
	public final static String S040_RAPP_PROVA = "il Rapporto di Prova puo' essere modificato o inviato solo se in stato BOZZA";
	public final static String S041 = "il REE puo' essere visualizzato solo se in stato INVIATO o RESPINTO";
	public final static String S041_RAPP_PROVA = "il Rapporto di Prova puo' essere visualizzato solo se in stato INVIATO o RESPINTO";

	public final static String S044 = "non si posseggono i privilegi per visionare e/o operare sul documento selezionato";
	public final static String S045 = "il REE puo' essere eliminato solo se in stato BOZZA";
	public final static String S045_RAPP_PROVA = "il Rapporto di Prova non puo' essere eliminato a partire da una ispezione in stato CONSOLIDATO";
	public final static String S045_RAPP_PROVA_2 = "il Rapporto di Prova non puo' essere eliminato se si trova in stato RESPINTO";

	
	
	public final static String S046 = "il REE puo' essere respinto solo se e' in stato INVIATO";
	public final static String S046_VER = "si puo' avviare una verifica solo per un REE in stato INVIATO";
	
	public final static String S047 = "per visualizzare la ricevuta il REE deve essere in stato INVIATO o RESPINTO";
	public final static String S048 = "il numero REE e' gia' stato utilizzato da un altro rapporto di controllo";
	public final static String S049 = "il numero REE non e' assegnato al manutentore indicato";
	//public final static String S049_1 = "Errore: ##valueNomeFile## il numero REE non e' assegnato al manutentore indicato";
	public final static String S050 = "la data di assegnazione del numero REE deve essere uguale o successiva alla data di ritiro del medesimo ##value##";
	public final static String S051 = "la data di controllo del REE deve essere uguale o successiva alla data di assegnazione del codice impianto ##value##";
	public final static String S052 = "il manutentore ha cessato l'attivita' in data ##value## non e' possibile inserire una data di controllo successiva";
	public final static String S053 = "non e' possibile operare sul tipo di documento selezionato. Eseguire prima il subentro";
	public final static String S054 = "non e' possibile operare sul tipo di documento ##value1## per il codice impianto ##value2##";
	public final static String S055 = "libretto in BOZZA. Non e' possibile creare un nuovo REE";
	public final static String S056 = "Impossibile procedere perch&#233; non esiste un libretto consolidato negli ultimi 5 anni";
	public final static String S056_BIS = "Impossibile procedere perch&#233; non esiste un libretto consolidato.<BR>Andare sul libretto web ed eseguire un consolidamento";

	public final static String S057 = "per lo stesso impianto non puo' esistere piu' di un responsabile attivo";
	public final static String S064 = "numero REE non piu' utilizzabile";
	public final static String S065 = "documento non controllato. Aprire il documento PDF ed eseguire la funzione di 'Salva e Controlla' ";
	public final static String S070 = "il codice impianto non risulta presente all'indirizzo indicato";
	public final static String S071 = "specificare con maggior precisione l'indirizzo";
	public final static String S073 = "non e' possibile effettuare il subentro";
	
	public final static String S074 = "non e' possibile effettuare il subentro del tipo selezionato";
	public final static String S075 = "non e' possibile subentrare a se stessi";
	public final static String S077 = "codice impianto mai acquisito";
	public final static String S078 = "effettuare prima la ricerca del delegato";
	public final static String S079 = "la persona indicata risulta gia' delegata";
	public final static String S080 = "legame gia' cessato";
	public final static String S081 = "non e' possibile rimuovere un legame di tipo Accreditato. Funzionalita' disponibile solo su Accreditamento/Registrazione";

	public final static String S082 = "non e' possibile effettuare il subentro: la ditta ha cessato l'attivita' in data ##value##, successiva al censimento dell'impianto";
	public final static String S082_1 = "non e' possibile effettuare il subentro: esistono dei REE con data controllo odierna";
	public final static String S082_2 = "non e' possibile effettuare il subentro: esistono dei contratti con data odierna";
	public final static String S083 = "duplicazione di delega/nomina per impresa persona, e data inizio";
	public final static String S084 = "Errore: Impresa e' presente a sistema ma non e' dichiarata con ruolo terzo responsabile";
	public final static String S085 = "Errore: effettuare prima la ricerca del terzo responsabile";
	public final static String S086 = "Errore: effettuare prima la ricerca dell'impianto";
	public final static String S087 = "Errore: il responsabile attivo dell'impianto deve avere titolo di Amministratore o di Proprietario";
	public final static String S088 = "Errore: non esiste alcun legame da revocare con l'impianto selezionato";
	public final static String S089 = "Errore: alla data di inizio del contratto non esiste un responsabile valido";
	public final static String S090 = "Errore: esiste gia' un terzo responsabile attivo per l'impianto indicato";
	public final static String S091 = "Errore: nel periodo contrattuale indicato alcune componenti selezionate (##value##) hanno gia' un precedente contratto di terza responsabilita'";
	public final static String S092 = "Errore: impossibile procedere con il salvataggio delle modifiche, verificare la data inizio e/o la data fine responsabilita' in modo che sia congruente con le nomine di terza responsabilita' caricate";
	public final static String S093 = "la data revoca indicata e' precedente alla data di inizio del contratto di terza responsabilita'";
	public final static String ERRORE_PRESENZA_REE_INVIATI = "Impossibile procedere poiche' esistono degli allegati inviati nelle date indicate";
	public final static String ERROR_DATA_FINE_AFTER_INIZIO = "data fine deve essere successiva alla data inizio";
	
	public final static String S094 = "Errore: la data revoca indicata e' precedente ad una data di controllo/manutenzione";

	public final static String S095 = "Errore: il file non ha il formato richiesto";
	public final static String S096 = "Errore: il file non e' presente oppure non ha il formato richiesto (##value##)";
	public final static String S097 = "nome file non coerente con le specifiche";
	public final static String S098 = "struttura file non conforme all'XSD concordato";
	public final static String S099 = "codice impianto ##value## sprovvisto di libretto consolidato";
	public final static String S100 = "il manutentore indicato ##value## non censito";
	public final static String S101 = "il manutentore indicato ##value## non risulta associato all'impianto ##valueCodImpianto## alla data attuale per la tipologia REE ##valueTipoAllegato##";
	
	public final static String S102 = "la data controllo non puo' essere futura (##value##)";
	public final static String S103 = "il bollino indicato ##value## non e' corretto";
	public final static String S105 = "il tag ##value## non e' coerente con il valore atteso";
	public final static String S106 = "La componente ##value1## non risulta associato al manutentore ##value2##";
	public final static String S107_GT = "composizione impianto ##value## discordante da quanto presente su CIT. Verificare le prove fumi dei componenti GT";
	public final static String S107_GF = "composizione impianto ##value## discordante da quanto presente su CIT. Verificare i circuiti dei componenti GF";

	
	public final static String S114 = "Errore: e' possibile modificare solo le ispezioni in stato BOZZA ";
	public final static String S115 = "Errore: e' possibile consolidare solo ispezioni in stato BOZZA";
	public final static String S116 = "Errore: e' possibile associare/inserire un rapporto di controllo solo se l'ispezione e' in stato BOZZA";
	public final static String S117 = "Errore: esiste gia' un rapporto di controllo associato all'ispezione";
	public final static String S118 = "Errore: non e' possibile consolidare l'ispezione perche' esiste un rapporto di controllo associato in stato BOZZA";
	public final static String S119 = "effettuare prima la ricerca dell'ispettore";
	public final static String S120 = "l'ispezione risulta gia' in stato ANNULLATO";
	public final static String S121 = "l'ispezione non ha nessun rapporto di controllo collegato";
	public final static String S122 = "il REE e' legato ad una ispezione, la gestione puo' avvenire nella funzione ispezioni";
	public final static String S123 = "impossibile eliminare l'impianto perche' esistono delle ispezioni. E' possibile modificare  lo stato dell'impianto in 'Cancellato'";

	public final static String S124 = "il numero REE selezionato non e' valido nella data controllo indicata";
	public final static String S125 = "Non e' stato trovato alcun ispettore";
	public final static String S126 = "le apparecchiature selezionate appartengono a manutentori diversi";
	public final static String S127 = "l'impresa e' presente a sistema ma non e' dichiarata con ruolo distributore";
	public final static String S128 = "esiste gia' un incarico attivo tra CAT selezionato e Impresa";
	public final static String S129 = "il REE risulta gia' caricato a sistema";
	public final static String S0100 = "la ditta ha cessato l'attivita' in data ##value##, impossibile assegnare nuovi numeri REE";
	public final static String S130 = "incongruenza sulle date per il componente ##value1##-##value2## installato il ##value3##: la data di installazione deve essere successiva o uguale alla data di dismissione del medesimo";
	public final static String S131 = "incongruenza sulle date per il componente ##value1##-##value2##: la data di installazione [##value3##] deve essere successiva alla data di dismissione [##value4##]";
	public final static String S132 = "incongruenza sul GT collegato per la componente ##value1##-##value2##, il GT-##value3## non e' presente";
	public final static String S133 = "il dato ##value1## ##value2## non e' presente nel sistema";
	public final static String S134 = "incongruenza sulla data per il componente ##value1##-##value2##: la data ##value3## non puo' essere futura";
	public final static String S135 = "se si seleziona 'altro' (##value##) bisogna obbligatoriamente indicare la descrizione";
	public final static String S136 = "se si seleziona il tag ##value## bisogna obbligatoriamente indicare il valore";
	public final static String S137 = "selezionare almeno un elemento della sezione ##value##";
	public final static String S138 = "la data di variazione deve essere uguale o successiva alla data di inizio attivita'";
	public final static String S139 = "la data di inizio attivita' deve essere precedente o uguale alla data della prima variazione";
	public final static String S140 = "la data di variazione deve essere uguale o successiva alla data dell'ultima variazione";
	public final static String S141 = "la ditta selezionata non puo' operare sul CIT in quanto in stato RADIATO o SOSPESO";
	public final static String S142 = "incongruenza sulle date per il componente ##value1##-##value2##: la data di installazione [##value3##] deve essere successiva alla data di installazione [##value4##]";
	public final static String S143 = "incongruenza sulle date per il componente ##value1##-##value2##: la data di dismissione [##value3##] deve essere successiva alla data di dismissione [##value4##]";
	public final static String S144 = "Impresa non trovata sul servizio di Anagrafe delle Attivita' Produttive (AAEP)";
	public final static String S145 = "nessuna apparecchiatura attiva alla data inizio contratto";
	
	public final static String S146 = "la ditta indicata (##value1##-##value2##) non e' abilitata ad operare in qualita' di terzo responsabile";
	public final static String S147 = "non e' possibile procedere in quanto la ditta indicata (##value1## CF/PIVA ##value2##) e' in stato RADIATO o SOSPESO";
	//public final static String S147_1 = "Errore: ##value1## non e' possibile procedere in quanto la ditta indicata (##value2## CF/PIVA ##value3##) e' in stato RADIATO o SOSPESO";
	
	public final static String S148 = "la voce selezionata e' gia' stata revocata";

	public final static String S149 = "ci sono delle componenti con una data rapporto di controllo/manutenzione successiva alla data revoca";
	public final static String S150 = "impossibile eliminare l'impianto perche' esistono dei contratti di terza responsabilita'. E' possibile modificare  lo stato dell'impianto in 'Cancellato'";

	public final static String S151 = "impossibile eseguire la revoca sull'impianto se non esiste nessun terzo responsabile";
	public final static String S152 = "Impossibile modificare l'impianto se non esiste un responsabile attivo";
	public final static String S153 = "non e' stato flaggato il tacito rinnovo e la data revoca indicata e' successiva alla data di fine del contratto di terza responsabilita'";
	public final static String S154 = "solo il terzo responsabile puo' inserire la revoca";
	public final static String S155 = "documento eliminabile solo da un'ispettore";
	public final static String S156 = "Il file e' troppo grande. Il sistema accetta file di dimensione massima ##value##MB";
	public final static String S157 = "codice impianto ##value## prima di procedere e' necessario eseguire un aggiornamento dei dati di ubicazione dell'impianto";
	public final static String S158 = "prima di procedere e' necessario eseguire un aggiornamento dei dati di ubicazione dell'impianto";
	public final static String S159 = "l'impresa selezionata non e' un CAT";
	public final static String S160 = "il file ha un nome che supera il massimo consentito (##value##)";

	public final static String S161 = "non e' possibile procedere in quanto la ditta indicata (##value1## CF/PIVA ##value2##) e' CESSATA in data ##value3##";
	public final static String S162 = "impossibile procedere con il salvataggio delle modifiche, verificare la data inizio e/o la data fine responsabilita' in modo che sia congruente con le date dei rapporti di controllo e delle manutenzioni su cui il responsabile e' tracciato";
	
	public final static String S163 = "Impossibile procedere perch&#233; non esiste un libretto consolidato";
	
	public final static String S163_1 = "Non e' possibile procedere con la nomina della terza responsabilita' in quanto c'e' un accertamento in corso sull'impianto stesso";
	
	public final static String S164 = "alcune componenti non possono essere eliminate/dismesse in quanto esistono dei rapporti di controllo (si veda per esempio ##value1##-##value2##)";
	public final static String S164_1 = "alcune componenti non possono essere eliminate in quanto esistono dei rapporti di controllo";
	public final static String S164_2 = "la componente non puo' essere eliminata in quanto esistono dei rapporti di controllo associati";
	public final static String S164_3 = "non e' possibile dismettere o eliminare il componente in quanto e' presente un REE o manutenzione o rapporto di prova con data controllo ##value##";
	
	public final static String S165 = "alcune componenti non possono essere eliminate/dismesse in quanto esistono dei contratti di terza responsabilita' (si veda per esempio ##value1##-##value2##)";
	public final static String S165_1 = "Alcune componenti non possono essere eliminate in quanto esistono dei contratti di terza responsabilita'";
	public final static String S165_2 = "La componente non puo' essere eliminata in quanto esistono dei contratti di terza responsabilita' associati";
	public final static String S166 = "Errore nel caricamento del libretto - scheda 1";
	public final static String S167 = "Attenzione: almeno una delle voci 1.3 deve essere indicata";
	public final static String S168 = "E&#39;necessario indicare la potenza utile";
	public final static String S168_VOLUME_RISCALDATO = "E&#39;necessario indicare il Volume lordo riscaldato a seguito della selezione della checkox Climatizzazione Invernale";
	public final static String S168_VOLUME_RAFFRESCATO = "E&#39;necessario indicare il Volume lordo raffrescato a seguito della selezione della checkox Climatizzazione Estiva";
	public final static String S169 = "Campo obbligatorio";
	public final static String S170 = "Attenzione: almeno una delle voci 1.4 deve essere indicata";
	public final static String S171 = "Attenzione: almeno una delle voci 1.5 deve essere indicata";
	
	public final static String S172 = "Attenzione: non e' possibile salvare la scheda senza alcun consumo";
	public final static String S173 = "Attenzione: alcuni campi sono obbligatori";
	
	public final static String S711 = "Attenzione: almeno una delle voci ##value## deve essere indicata";
	public final static String S174 = "Attenzione: la data di intervento manutentivo deve essere successiva alla data controllo";
	public final static String S174_1 = "Attenzione: la data del prossimo intervento manutentivo deve essere successiva alla data manutenzione";
	public final static String S175 = "Attenzione: se si indica la portata combustibile UM e' obbligatorio indicare anche la portata combustibile (e viceversa)";
	public final static String S176 = "Attenzione: indicare almeno uno tra climatizzazione invernale e produzione acs";
	public final static String S177 = "Attenzione: la data di ripristino deve essere successiva alla data controllo";
	
	public final static String S178 = "la manutenzione puo' essere annullata solo se e' in stato INVIATO";
	public final static String S179 = "si possono annulare solo le manutenzioni";
	public final static String S180 = "documento gia' eliminato";
	public final static String S181 = "Errore: la data di inizio contratto indicata e' precedente ad una data di controllo/manutenzione";

	
	public final static String I001 = "la ricerca ha prodotto piu' di un risultato. Inserire criteri di ricerca piu' restrittivi e riprovare";
	public final static String I002 = "la ricerca ha prodotto troppi risultati. Inserire criteri di ricerca piu' restrittivi e riprovare";
	public final static String I003 = "non ci sono elementi da visualizzare";
	public final static String I011 = "Il legame e' stato rimosso correttamente";
	public final static String I012 = "##value## il rapporto di controllo verra' elaborato nella notte";
	
	public final static String C001 = "si conferma la cessazione del legame con la ditta selezionata?";
	public final static String C002 = "si conferma l'eliminazione dell'impianto ##value##? ";
	public final static String C003 = "dopo l'invio non sara' piu' possibile apportare modifiche al ##value## selezionato. Continuare?";
	public final static String C004 = "si conferma l'eliminazione del documento?";

	public final static String C005 = "Si conferma l'annullamento dell'ispezione ##value##?\nEventuali Rapporti Di Prova in stato BOZZA verranno eliminati\nEventuali Rapporti Di Prova in stato INVIATO verranno respinti";
	public final static String C006 = "si conferma il consolidamento?";
	public final static String C007 = "si conferma la cancellazione dell'ispezione selezionata?";
	public final static String C007_1 = "Attenzione: sono presenti dei documenti associati all'ispezione che verranno cancellati";

	public final static String C008 = "si conferma la cancellazione della componente ##value##?";
	public final static String C008_1 = "Attenzione: sono presenti degli elementi sostituiti. Prima di procedere con la cancellazione e' necessario eliminare tutta la storia della componente!";
	public final static String C008_2 = "si conferma l'annullamento dell'accertamento ##value##?";

	
	public final static String A001 = "Il range indicato non e' in sequenza";
	
	public final static String MSG_AGGIORNAMENTO_CORRETTO = "Aggiornamento avvenuto correttamente";

	public final static String MSG_RISULTATI_RICERCA = "Attenzione: Sono stati visualizzati solo i primi ##value## record che rispondono ai criteri impostati. Si raccomanda di affinare la ricerca.";
	
	public final static String S223 = "Si ricordano i seguenti valori massimi attesi: 100 per % e 14 per ph";
	
	public final static String S224 = "Non esistono Gruppi Termici a cui collegare il ##value##";
	public final static String S224_2 = "La componente non puo' essere eliminata poiche' esistono Bruciatori/Recuperatori ad essa associati";
	
	public final static String ERROR_ALLEGATO_REE_VALORE_FLG_SI = "in assenza di trattamento impostare a SI";
	
	public final static String ERRORE_DEL_VERIFICA_ACCERTAMENTO = "Attenzione: impossibile eliminare la verifica in presenza di accertamenti";
	public final static String ERRORE_DEL_VERIFICA_ISPEZIONE = "Attenzione: impossibile eliminare la verifica in presenza di ispezioni";
	public final static String ERRORE_DEL_VERIFICA_AZIONE = "Attenzione: impossibile eliminare la verifica in presenza di azioni";
	public final static String ERRORE_DEL_VERIFICA_SVEGLIA = "Attenzione: impossibile eliminare la verifica in presenza di sveglie";
	public final static String ERRORE_AVVIO_ISPEZIONE_DA_VERIFICA = "Attenzione: impossibile avviare una ispezione su una verifica priva di codice impianto associato";

	public final static String ERRORE_DEL_ACCERTAMENTO_ISPEZIONE = "Attenzione: impossibile completare l'operazione in presenza di ispezioni attive";
	public final static String ERRORE_DEL_ACCERTAMENTO_SANZIONE = "Attenzione: impossibile annullare l'accertamento in presenza di sanzioni attive";
	public final static String ERRORE_DEL_ACCERTAMENTO_SVEGLIA = "Attenzione: impossibile annullare l'accertamento in presenza di sveglie";

	public final static String ERRORE_DEL_ACCERTAMENTO_NO_IMPIANTO = "Attenzione: l'accertamento non e' collegato ad un codice impianto";
	public final static String ERRORE_DEL_ACCERTAMENTO_3R_NO_BLOCCATO = "Attenzione: la nomina del terzo responsabile non e' bloccata";

	public final static String ERRORE_DEL_ACCERTAMENTO_GIA_CHIUSO = "Attenzione: l'accertamento e' gia' concluso/annullato";
	
	public final static String ERROR_INDIRIZZO_INCOMPLETO = "l'indirizzo non e' completo, manca il toponimo o l'indirizzo";

	public final static String ERRORE_ACCERTAMENTO_SENZA_ASSEGNATARIO = "Attenzione: e' impossibile porocedere senza un assegnatario";

	public final static String ERRORE_ACCERTAMENTO_SENZA_ANOMALIA = "Attenzione: e' necessario salvare il tipo anomalia per procedere";

	public final static String ERRORE_ALLEGATO_NON_REE = "Attenzione: operazione possibile solo per i documenti di tipo REE";

	public final static String ERRORE_RICERCA = "Attenzione: eseguire la ricerca sul campo";
	
	public final static String ERRORE_ISPEZIONE_ISPETTORE_UGUALE = "Attenzione: l'ispezione e' gia' assegnata all'ispettore selezionato";
	public final static String ERRORE_ISPEZIONE_NO_IMPIANTO = "Attenzione: l'ispezione non e' collegata ad un codice impianto";
	public final static String ERRORE_ISPEZIONE_GIA_CHIUSA = "Attenzione: l'ispezione e' gia' conclusa/annullata";
	public final static String ERRORE_ISPEZIONE_NO_ISPETTORE_AZIONE = "Attenzione: non e' possibile ##value## senza un ispettore primario associato";
	public final static String ERRORE_DEL_ISPEZIONE_SANZIONE = "Attenzione: impossibile annullare l'ispezione in presenza di sanzioni attive";
	public final static String ERRORE_DEL_ISPEZIONE_SVEGLIA = "Attenzione: impossibile annullare l'ispezione in presenza di sveglie";
	public final static String ERRORE_CONCLUDI_ISPEZIONE_RAPPORTI = "Attenzione: impossibile concludere l'ispezione in presenza di Rapporti Di Prova in stato BOZZA";

	public final static String ERROR_LIBRETTO_NON_CONTROLLATO_RAP_PROVA = "Per compilare Rapporto di Prova e' necessario eseguire un consolidamento del libretto";
	public final static String ERROR_NO_RESP_ATTIVO_RAP_PROVA = "Per compilare Rapporto di Prova e' necessario avere un responsabile attivo alla data odierna";
	
	public final static String INFO_ALLEGATO_RAPP_PROVA_INVIATO_CORRETTAMENTE = "il Rapporto di Prova e' stato inviato/consolidato correttamente";

	public final static String INFO_FILE_CARICATO_CORRETTAMENTE = "il file e' stato caricato correttamente";

	public final static String ERROR_ALMENO_UN_FLG = "Almeno uno dei FLG ##value## deve essere selezionato";
	
	public final static String ERROR_CONFRONTO_VALORI = "Il valore del campo ##value1## deve essere inferiore al valore del campo ##value2##";

	public final static String ERROR_ABILITAZIONE_GIA_CESSATA = "L'abilitazione seleziona risulta gia' cessata";
	
	public final static String ERROR_SELEZIONE_PROVINCIA_COMUNE_CESSATI = "Il Comune o la Provincia selezionata risulta cessata. Contattare l'assistenza.";
	
	public final static String ERROR_INSERISCI_ALLEGATO_IMPIANTO_STATO = "Non è possibile inserire un REE di un impianto in stato ";
	public final static String ERROR_NUOVO_MANUTENZIONE_IMPIANTO_STATO = "Non è possibile fare una manutenzione di un impianto in stato ";
	
	public final static String ERROR_SOSTITUZIONE_DATI_DISTRIBUTORE = "Non è possibile procedere con la sostituzione in quanto il caricamento del dato di partenza è avvenuto da più di un anno";
	public final static String ERROR_ANNULLAMENTO_DATI_DISTRIBUTORE = "Non è possibile procedere con l'annullamento in quanto il caricamento del dato di partenza è avvenuto da più di un anno";
	
	public final static String ERROR_SELEZIONE_ADMIN_SOGG_INCARICATO = "Specificare se la presente dichiarazione è resa in qualità di Amministratore o Soggetto incaricato";
	public final static String ERROR_SELEZIONE_SOGG_INCARICATO = "Inserire il soggetto incaricato";
	//public final static String MSG_CONFERMA_ANNULLA_ISPEZIONE = "Si conferma l'annullamento dell'ispezione ##value##?\nEventuali Rapporti Di Prova in stato BOZZA verranno eliminati\nEventuali Rapporti Di Prova in stato INVIATO verranno respinti";

	public static final String ABILITAZIONE_RUOLO_PA_NON_UNIVOCA = "Non è possibile eseguire il salvataggio: dato già presente";
	
	public static final String ERROR_NOME_FILE_IMPORT_XML_MASSIVO = "Il nome del file non rispetta le indicazioni es. manutGF_, AllegatoII_";
	
	public static final String ERROR_VALORI_INSERIMENTO_ISPEZIONI_MASSIVE = "Non è stato possibile inserire una ispezioni per i seguenti valori: ##value##";
	public static final String ERROR_TIPO_VERIFICA_NON_VALIDO_INSERIMENTO_ISPEZIONI_MASSIVE = "Il tipo di verifica selezionato non è valido per l'inserimento massivo di ispezioni";
	
	public static final String INFO_INSERIMENTO_ISPEZIONI_MASSIVE_AVVENUTO_CORRETTAMENTE = "L'inserimento delle ispezioni massive è avvenuto correttamente";
	
	public static final String ERROR_PIU_DATI_ASS_DETT_CARICA_MANUALE_DISTRIBUTORE = "Si sta cercando di visualizzare il dettaglio di una importazione con più dati associati";

	public static final String ERROR_STATO_IMPORT_DISTRIBUTORE = "L'import del distributore selezionato non è nello stato inviato";
	
	public static final String ERROR_STATO_RAPP_PROVA_UPLOAD_DOCUMENTO_FIRMATO = "Il documento firmato può essere caricato solo per i Rapporti di Prova in stato INVIATO";
	
	public static final String FILE_NON_SELEZIONATO = "Selezionare un file";
}
