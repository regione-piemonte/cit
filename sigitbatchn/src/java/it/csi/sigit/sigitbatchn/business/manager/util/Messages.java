/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
/*
 * 
 */
package it.csi.sigit.sigitbatchn.business.manager.util;



/**
 * The Class Messages.
 */
public class Messages {

	// Classe che contieni le costanti MESSAGGI
	
	
	
	
	
	
	
	
	
	
	// OLD
	public final static String ERROR_FIELD_FORMAL_ERROR = "campo non corretto";
	public final static String ERROR_ACCESSO = "Si e' verificato un problema nell'accesso. Contattare l'amministratore di sistema";
	public final static String ERROR_RECUPERO_SERVIZIO = "Errore durante il recupero dei dati dal servizio. Contattare l'amministratore di sistema";
	public final static String ERROR_MAPPATURA_XML = "Errore durante la mappatura del tracciato xml. Verificare con il tracciato xsd";
	public final static String ERROR_VALIDAZIONE_XML = "Errore nella struttura del tracciato xml. Struttura file non conforme all'XSD concordato";

	public final static String ERROR_SERVIZIO_NON_RAGGIUNGIBILE = "Un servizio non e' raggiungibile - Riprovare piu' tardi o contattare l'amministratore di sistema";
	public final static String ERROR_CAMPO_ABBIGATORIO_FIELD = "campo ##value## obbligatorio";
	public final static String ERROR_NESSUN_DATO_INDICATO = "Non e' stato indicato nessun dato";
	public final static String ERROR_CAMPO_ABBIGATORIO = "il campo e' obbligatorio";
	public final static String ERROR_SOLO_NUMERICI = "il campo deve essere numerico";
	public final static String ERROR_RECUPERO_DB = "Errore durante il recupero dei dati. Contattare l'amministratore di sistema";
	
	public final static String ERROR_INSERT_DB = "Errore durante l'inserimento dei dati. Contattare l'amministratore di sistema";
	public final static String ERROR_UPDATE_DB = "Errore durante l'aggiornamento dei dati. Contattare l'amministratore di sistema";
	public final static String ERROR_FORMALE_CODICE_FISCALE = "codice fiscale (##value##) formalmente errato";
	public final static String ERROR_FORMALE_DATA = "data formalmente errata";

	public final static String ERROR_PARTITA_IVA = "partita iva (##value##) formalmente errata";
	public final static String ERROR_INSTALLATORE_NON_TROVATO = "installatore non presente nell'albo";
	public final static String ERROR_IMPRESA_NON_TROVATA = "impresa non trovata";
	public final static String ERROR_INSTALLATORE_OBBLIGATORIO = "per proseguire bisogna prima ricercare l'installatore";
	public final static String ERROR_INVIO_MAIL = "Errore durante l'invio della mail";
	public final static String ERROR_FORMALE_CAP = "CAP formalmente errato";
	public final static String ERROR_FORMALE_RECUPERO_CODICE_IMPIANTO = "Errore durante il recupero del codice impianto";
	public final static String ERROR_RECUPERO_PERSONA_GIURIDICA = "Non trovata alcuna persona giuridica";
	public final static String ERROR_RECUPERO_DATI = "Trovati Troppi record";

	public final static String ERROR_INSTALLATORE_CESSATO = "l'installatore ha cessato l'attività in data ##value##, non e' possibile assegnare un codice in una data successiva";
	public final static String ERROR_DATA_RESPONSABILE = "la data di fine responsabilita' deve essere uguale o successiva alla data di inizio responsabilita'";
	public final static String ERROR_RESPONSABILE_ATTIVO = "Esiste gia' un responsabile attivo";
	public final static String ERROR_RESPONSABILE_ASSENTE = "Non esistono responsabili attivi";
	public final static String ERROR_RESPONSABILE_DATA_RAPP_ASSENTE = "Non esistono responsabili attivi alla data controllo";

	
	public final static String ERROR_SELEZIONARE_COMUNE = "selezionare un comune";
	public final static String ERROR_SELEZIONARE_PROVINCIA = "selezionare una provincia";
	
	public final static String ERROR_LUNGHEZZA = "il campo deve essere di ##value## caratteri";
	public final static String ERROR_LUNGHEZZA_MINIMA = "il campo accetta minimo ##value## caratteri alfanumerici";
	public final static String ERROR_LUNGHEZZA_MASSIMA = "il campo accetta massimo ##value## caratteri alfanumerici";
	
	public final static String ERROR_SIGLA_NUMERO_BOLLINO = "se si indica il numero bollino e' obbligatorio indicare anche la sigla (e viceversa)";
	public final static String ERROR_CODICE_REA_CF_MANCANTE = "indicare il codice REA oppure il codice fiscale dell'impresa";
	public final static String ERROR_CODICE_REA_DENOMINAZIONE_CF_MANCANTE = "indicare il codice REA o il codice fiscale o il cognome/denominazione del manutentore";
	public final static String ERROR_DENOMINAZIONE_CF_MANCANTE = "indicare il codice fiscale o il cognome/denominazione del manutentore";
	public final static String ERROR_IS_IMPRESA_MANCANTE = "indicare se si tratta di impresa";

	public final static String ERROR_CODICE_REA_NON_CERCATO = "il codice REA e codice fiscale inserito e' gia' presente nel sistema. Per associarlo all'impianto premere il tasto 'cerca'";
	public final static String ERROR_CF_NON_CERCATO = "il codice fiscale inserito e' gia' presente nel sistema. Per associarlo all'impianto premere il tasto 'cerca'";
	public final static String ERROR_METODO_PAGAMENTO_OBBLIGATORIO = "per proseguire bisogna prima indicare il gestore e modalita' del pagamento";
	//public final static String ERROR_LIBRETTO_NON_CONTROLLATO = "eseguirebisogna prima verificare il libretto";
	public final static String ERROR_PDR_OBBLIGATORIO = "bisogna indicare il pdr o dichiare che non e' presente";

	public final static String ERROR_DENOMINAZIONE_CF_MANCANTE_DELEGATO = "indicare il codice fiscale o il cognome del delegato";

	public final static String ERROR_ALLEGATO_IN_BOZZA = "Impossibile inserire il libretto, esiste un rapporto di controllo in stato bozza.";
	public final static String ERROR_DATA_FINE_AFTER_INIZIO = "data fine deve essere successiva alla data inizio";

	public final static String ERROR_CODICE_IMPIANTO_NON_ESISTE = "non esiste un impianto con il codice specificato";

	public final static String INFO_COD_IMPIANTO_VERIFICATO = "codice impianto verificato correttamente";
	public final static String INFO_COD_IMPIANTO_VERIFICATO_NO_DATA_ASS = "codice impianto verificato correttamente <BR> Attenzione e' stata impostata la data di assegnazione uguale alla data di acquisizione del codice impianto";
	public final static String INFO_COD_IMPIANTO_VERIFICATO_NON_USATO = "codice impianto non censito a sistema: e' comunque possibile procedere con il subentro previo il caricamento dei dati impianto";
	public final static String INFO_INSERIMENTO_CORRETTO = "l'inserimento e' avvenuto correttamente";
	public final static String INFO_MODIFICA_CORRETTA = "la modifica e' avvenuta correttamente";
	public final static String INFO_ALLEGATO_INVIATO_CORRETTAMENTE = "l'allegato e' stato inviato correttamente";
	public final static String INFO_ELIMINAZIONE_CORRETTA = "l'eliminazione e' avvenuta correttamente";
	public final static String INFO_ALLEGATO_RESPINTO_CORRETTAMENTE = "l'allegato e' stato respinto correttamente. E' stata una inviata una mail ai seguenti indirizzi: ##value##";
	public final static String INFO_ALLEGATO_RESPINTO_CORRETTAMENTE_NO_MAIL = "l'allegato e' stato respinto correttamente. Non e' stata inviata nessuna mail";
	public final static String INFO_SUBENTRO_CORRETTO = "il subentro e' avvenuto correttamente";

	public final static String INFO_SALVATAGGIO_CORRETTO = "il salvataggio e' avvenuto correttamente";

	
	public final static String INFO_DELEGA_INSERITA_CORRETTAMENTE = "inserimento delegato avvenuto correttamente";
	
	public final static String S006	= "campo obbligatorio";
	public final static String S007	= "selezionare una voce dall'elenco";
	public final static String S009 = "accesso negato - Utente non autorizzato";
	public final static String S010 = "impostare almeno un criterio di ricerca";
	public final static String S011 = "indicare sia la sigla sia il codice REA";
	public final static String S012 = "indicare un valore numerico intero";
	public final static String S014 = "la ditta ha cessato l'attivita' in data ##value##, impossibile assegnare nuovi codici impianto";
	public final static String S015 = "la quantita' non puo' essere superiore a ##value##";
	public final static String S016 = "inserire un valore multiplo di ##value##";
	public final static String S018 = "la quantita' deve essere un valore numerico intero e maggiore di 0";
	public final static String S019 = "impossibile eliminare l'impianto perche' ci sono dei rapporti di controllo associati. Se possibile eliminare gli allegati o modificare lo stato dell'impianto in 'Cancellato'";
	public final static String S020 = "impossibile eliminare l'impianto perche' esiste un libretto consolidato. E' possibile modificare  lo stato dell'impianto in 'Cancellato'";
	

	public final static String S021 = "per verificare il codice impianto bisogna prima cercare l'installatore";
	public final static String S022 = "il codice impianto non risulta associato all'installatore indicato";
	public final static String S023 = "il codice impianto indicato e' stato ritirato successivamente alla data di assegnazione indicata"; 
	public final static String S024 = "Impianto gia' caricato su sistema. Effettuare la ricerca per visualizzarne i dettagli";
	public final static String S025 = "la data di dismissione deve essere uguale o successiva alla data di assegnazione";
	public final static String S026 = "il manutentore ha cessato l'attività in data ##value##, non e' possibile assegnare un codice o dismettere un impianto in una data successiva";
	public final static String S027 = "non e' possibile modificare la localizzazione dell'impianto";

	public final static String S030 = "e' necessario ricercare l'impresa";
	public final static String S031 = "la quantita' non puo' essere superiore a ##value##";
	public final static String S032 = "non e' possibile effettuare il pagamento per problemi tecnici, si prega di riprovare piu' tardi";
	public final static String S033 = "la quantita' deve essere un valore numerico intero maggiore di 0";
	
	public final static String S034 = "inserire una quantita'";
	public final static String S040 = "l'allegato puo' essere modificato o inviato solo da chi lo ha generato e se in stato BOZZA";
	public final static String S041 = "l'allegato puo' essere visualizzato solo se in stato INVIATO o RESPINTO";

	public final static String S044 = "non si posseggono i privilegi per visionare e/o operare sul documento selezionato";
	public final static String S045 = "l'allegato puo' essere eliminato solo se in stato BOZZA";

	public final static String S046 = "l'allegato puo' essere respinto solo se e' in stato INVIATO";
	
	public final static String S047 = "per visualizzare la ricevuta l'allegato deve essere in stato INVIATO o RESPINTO";
	public final static String S048 = "il bollino e' gia' stato utilizzato da un altro rapporto di controllo";
	public final static String S049 = "il bollino non e' assegnato al manutentore indicato";
	public final static String S050 = "la data di assegnazione del bollino deve essere uguale o successiva alla data di ritiro del bollino ##value##";
	public final static String S051 = "la data di assegnazione del bollino deve essere uguale o successiva alla data di assegnazione del codice impianto ##value##";
	public final static String S052 = "il manutentore ha cessato l'attività in data ##value## non e' possibile inserire una data di controllo successiva";
	public final static String S053 = "non e' possibile operare sul tipo di documento selezionato. Eseguire prima il subentro";
	public final static String S054 = "non e' possibile operare sul tipo di documento ##value1## per il codice impianto ##value2##";
	public final static String S055 = "libretto in BOZZA. Non e' possibile creare un nuovo allegato";
	public final static String S057 = "per lo stesso impianto non puo' esistere piu' di un responsabile attivo";
	public final static String S064 = "bollino non piu' utilizzabile";
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
	public final static String S083 = "duplicazione di delega per impresa persona, e data inizio";
	public final static String S084 = "Errore: Impresa è presente a sistema ma non è dichiarata con ruolo terzo responsabile";
	public final static String S085 = "Errore: effettuare prima la ricerca del terzo responsabile";
	public final static String S086 = "Errore: effettuare prima la ricerca dell'impianto";
	public final static String S087 = "Errore: il responsabile attivo dell'impianto deve avere titolo di Amministratore o  di Proprietario";
	public final static String S088 = "Errore: non esiste alcun legame da revocare con l'impianto selezionato";
	public final static String S089 = "Errore: alla data di inizio del contratto non esiste un responsabile valido";
	public final static String S090 = "Errore: esiste già un terzo responsabile attivo per l'impianto indicato";
	public final static String S091 = "Errore: nel periodo contrattuale indicato esiste già un precedente contratto di terza responsabilità";
	public final static String S093 = "Errore: la data revoca indicata è precedente alla data di inizio del contratto di terza responsabilità";
	public final static String S094 = "Errore: la data revoca indicata è precedente alla data di controllo di un rapporto di controllo  inviato ";

	public final static String ERRORE_NON_PREVISTO_BATCH = "Errore: ##valueNomeFile## si e' verificato un errore non previsto. Contattare l'assistenza";

	public final static String S096 = "Errore: il file non è presente oppure non ha il formato richiesto (XML)";
	public final static String S097 = "Errore: ##valueNomeFile## nome file non coerente con le specifiche";
	//public final static String S097 = "Errore: ##value##  nome file non coerente con le specifiche";
	public final static String S098 = "Errore: ##valueNomeFile## struttura file non conforme all'XSD concordato";
	public final static String S099 = "Errore: ##valueNomeFile## codice impianto ##value## sprovvisto di libretto consolidato";
	public final static String S100 = "Errore: ##valueNomeFile## il manutentore indicato ##value## non censito";
	public final static String S101 = "Errore: ##valueNomeFile## il manutentore indicato ##value## non risulta associato all'impianto ##valueCodImpianto## alla data attuale per la tipologia allegato ##valueTipoAllegato##";

	public final static String S102 = "Errore: ##valueNomeFile## il bollino indicato ##value## non e' corretto";
	public final static String S103 = "Errore: ##valueNomeFile## il bollino indicato ##value1## non e' associato al manutentore riportato nell'xml ##value2##";
	public final static String S104 = "Errore: ##valueNomeFile## il bollino indicato ##value## e' gia' stato utilizzato";

	public final static String S105 = "Errore: ##valueNomeFile## il tag ##value## non e' coerente con il valore atteso";
	public final static String S106 = "Errore: ##valueNomeFile## composizione impianto ##value## discordante da quanto presente su CIT. Verificare le componenti";
	public final static String S107 = "Errore: ##valueNomeFile## composizione impianto ##value## discordante da quanto presente su CIT. Verificare le prove fumi dei componenti GT";
	public final static String S108 = "Errore: ##valueNomeFile## unita' di misura della portata combustibile non coerente con il valore atteso";
	public final static String S109 = "Errore: ##valueNomeFile## portata combustibile senza alcuna unita' di misura";
	public final static String S110 = "Errore: ##valueNomeFile## il bollino indicato ##value## non e' valido nella data controllo indicata";
	public final static String S111 = "Errore: ##valueNomeFile## non e' possibile procedere in quanto la ditta indicata (##value1## CF/PIVA ##value2##) e' in stato RADIATO o SOSPESO";

	public final static String S0100 = "la ditta ha cessato l'attivita' in data ##value##, impossibile assegnare nuovi bollini";
	public final static String S112 = "Errore: ##valueNomeFile## non esistono responsabili attivi alla data controllo ##value##";
	public final static String S113 = "Errore: ##valueNomeFile## rapporto di controllo con data controllo futura (##value##)";

	public final static String S114 = "Errore: ##valueNomeFile## non e' possibile indicare una data intervento raccomandato (##value1##) precedente alla data del rapporto di controllo (##value2##)";
	
	public final static String S115 = "deve essere un anno";
	public final static String S115_bis = "anno ##value## superiore alla data corrente";
	
	public final static String S116 = "deve essere una data";
	public final static String S116_bis = "giorno di riferimento ##value## superiore alla data corrente";
	
	
	public final static String I001 = "la ricerca ha prodotto piu' di un risultato. Inserire criteri di ricerca piu' restrittivi e riprovare";
	public final static String I002 = "la ricerca ha prodotto troppi risultati. Inserire criteri di ricerca piu' restrittivi e riprovare";
	public final static String I003 = "non ci sono elementi da visualizzare";
	public final static String I011 = "Il legame e' stato rimosso correttamente";
	public final static String I012 = "##value## il rapporto di controllo verrà elaborato nella notte";
	
	public final static String C001 = "si conferma la cessazione del legame con la ditta selezionata?";
	public final static String C002 = "si conferma l'eliminazione dell'impianto ##value##? ";
	public final static String C003 = "dopo l'invio non sara' piu' possibile apportare modifiche all'allegato selezionato. Continuare?";
	public final static String C004 = "si conferma l'eliminazione del documento?";

	public final static String A001 = "Il range indicato non e' in sequenza";
	public final static String A002 = "ATTENZIONE: l'impianto centralizzato oggetto del presente rapporto di controllo, non e' conforme all'obbligo di installazione di un sistema di contabilizzazione / ripartizione ai sensi del dlgs 102/2014 e non risulta caricata nessuna relazione di deroga all'obbligo";
	
	public final static String MSG_AGGIORNAMENTO_CORRETTO = "Aggiornamento avvenuto correttamente";
	
}
