/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
/*
 * 
 */
package it.csi.sigit.sigitweba.util;


// TODO: Auto-generated Javadoc
/**
 * The Class Messages.
 */
public class Messages {

	// Classe che contieni le costanti MESSAGGI
	public final static String WARN_APPLICATIVO_IN_MANUTENZIONE = "Il servizio a causa di una manutenzione non e' al momento disponibile";
	public final static String ERROR_RECUPERO_SERVIZIO = "Errore durante il recupero dei dati dal servizio. Contattare l'amministratore di sistema";
	public final static String ERROR_SERVIZIO_NON_RAGGIUNGIBILE = "Un servizio non e' raggiungibile - Riprovare piu' tardi o contattare l'amministratore di sistema";
	public final static String ERROR_CAMPO_ABBIGATORIO_FIELD = "campo ##value## obbligatorio";
	public final static String ERROR_NESSUN_DATO_INDICATO = "Non e' stato indicato nessun dato";
	public final static String ERROR_CAMPO_ABBIGATORIO = "il campo e' obbligatorio";
	public final static String ERROR_SOLO_NUMERICI = "il campo deve essere numerico";
	public final static String ERROR_SELEZIONA_IMPRESA = "Errore: e' necessario indicare una impresa";
	public final static String ERROR_LEGAME_DELEGA = "Errore: l'utente \"Delegato\" non puo' modificare i dati dell'impresa";
	public final static String ERROR_LEGAME_CESSATO = "Errore: legame non attivo con l'impresa";
	public final static String ERROR_LEGAME_ATTIVO_DA_CESSARE = "Errore: non esiste alcun legame attivo da cessare";
	public final static String ERROR_CODICE_REA_PRESENTE = "Errore: Codice REA gia' presente a sistema";
	public final static String ERROR_CODICE_REA_PIVA_PRESENTE = "Errore: Codice REA o P. IVA di impresa con legame di accreditamento ancora valido";
	public final static String ERROR_CODICE_FISCALE_PRESENTE = "Errore: Codice fiscale gia' presente a sistema";
	public final static String ERROR_LUNGHEZZA_CODICE_FISCALE = "Il Codice fiscale deve avere una lunghezza di 11 o 16 caratteri";
	public final static String ERROR_UPDATE_PROV_COM = "Errore durante l'aggiornamento dei dati. Verificare la denominazione della provincia/comune";

	public final static String ERROR_RECUPERO_DB = "Errore durante il recupero dei dati. Contattare l'amministratore di sistema";
	public final static String ERROR_INSERT_DB = "Errore durante il salvataggio dei dati. Contattare l'amministratore di sistema";
	public final static String ERROR_UPDATE_DB = "Errore durante la modifica dei dati. Contattare l'amministratore di sistema";

	
	public final static String MSG_AGGIORNAMENTO_CORRETTO = "Aggiornamento avvenuto correttamente";
	public final static String MSG_VERIFICA_EMAIL_OK= "E' stata inviata una e-mail di verifica all'indirizzo: ";
	
	public final static String ERROR_EMAIL_FORMAT= "indirizzo e-mail formalmente non corretto";
	public final static String ERROR_CODICE_FISCALE_FORMAT= "codice fiscale formalmente errato";
	public final static String ERROR_PARTITA_IVA = "partita iva formalmente errata";

	public static final String ERROR_SELEZIONARE_PROVINCIA = "selezionare una provincia";
	
	public static final String ERROR_SELEZIONARE_COMUNE = "selezionare un comune";
	public static final String ERROR_INSERIRE_INDIRIZZO = "Scrivere un indirizzo";
	public static final String ERROR_INSERIRE_INDIRIZZO_LUNGO = " il campo indirizzo accetta minimo 3 caratteri";
	public static final String ERROR_INDIRIZZO_MULTIPLO = "Inserire solo una tra 'Indirizzo' e 'Indirizzo non trovato'";
	public static final String ERROR_FORMATO_DATA_ERRATO = " data formalmente non corretta";
	
	public final static String ERROR_INVIO_MAIL = "Errore durante l'invio della mail";

	public final static String ERROR_DATA_CESSAZIONE = "La data cessazione deve essere successiva o uguale alla data di inizio attivita'";
	public final static String ERROR_DATA_FUTURA = "Non e' possibile inserire date future.";
	public final static String ERROR_FLAG_MAN_INS_AMM = "Almeno uno dei FLG installatore/manutentore/altra impresa/terzo responsabile/distributore/CAT deve essere selezionato";

	public final static String ERROR_INSERIMENTO_DATA_FORMAZIONE = "Errore: Data corso gia' presente. Cambiare la data e riprovare";
	
	public final static String ERROR_CERCA_INDIRIZZO = " specificare il dato indirizzo attivando il tasto CERCA";
	public final static String ERROR_LEGAME_ESISTENTE = "Errore: legame gia' esistente";
	public final static String ERROR_INDIRIZZO_NON_VALIDO = "Indirizzo non valido";
	
	public final static String ERROR_FLG_AMM_SOGG_DEL = "Specificare se la presente dichiarazione e' resa in qualita' di Amministratore o Soggetto incaricato"; 
	public final static String ERROR_DELEGA_SOGG_DEL = "Inserire il soggetto incaricato"; 
	public final static String ERROR_LUNGHEZZA_DELEGA_SOGG_DEL = "Il campo soggetto incaricato accetta massimo 200 caratteri"; 
	
}
