/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
package it.csi.sigit.sigitwebn.util;



import it.csi.sigit.sigitwebn.dto.ExecResults;
import it.csi.sigit.sigitwebn.business.manager.util.FieldError;
import it.csi.sigit.sigitwebn.business.manager.util.ManagerException;
import it.csi.sigit.sigitwebn.business.manager.util.Message;
import it.csi.sigit.sigitwebn.business.manager.util.ValidationManagerException;

import java.util.List;

import org.apache.log4j.Logger;

/**
 * Classe astratta per la validazione automatica delle schermate, contiene i
 * metodi generici di validazione
 * 
 * @author 70140
 */
public abstract class Validator {
	/**
	 * Risultato della valutazione con successo
	 */
	static public final String OK = "OK";
	/**
	 * Risultato della valutazione con errore
	 */
	static public final String KO = "KO";
	/**
	 * Logger da utilizzare
	 */
	protected static Logger log = Logger.getLogger(Constants.APPLICATION_CODE);

	/**
	 * Segnala i campi che risultano errati
	 * 
	 * @param result Result in cui segnalare i campi
	 * @param e Eccezione che contiene i campi errati
	 */
	static private void segnalaCampiErrati(ExecResults result, ManagerException e) {
		List<FieldError> fieldList = null;

		fieldList = e.getFieldList();
		String messagesField = null;
		for(FieldError field : fieldList) {
			messagesField =  GenericUtil.isNotNullOrEmpty(field.getMessageField())?field.getMessageField():Messages.ERROR_FIELD_FORMAL_ERROR;
			result.getFldErrors().put(field.getField(),messagesField);
		}
	}

	/**
	 * Gestisce l'eccezione impostando opportunamente l'oggetto result
	 * 
	 * @param result Result da impostare
	 * @param e Eccezione sollevata
	 */
	public static void gestisciEccezione(ExecResults result, ManagerException e) {
		Message message = null;

		segnalaCampiErrati(result, e);
		message = e.getMsg();

		log.debug("STAMPO IL MESSAGGIO: "+message);
		
		if (e instanceof ValidationManagerException)
		{
			log.debug("Stampo l'eccezione (validation)",e);
		}
		else
		{
			log.error("Stampo l'eccezione (diversa da validation)",e);
		}
		
		
		if(message != null) {
			log.debug("STAMPO IL TESTO DEL MESSAGGIO: "+message.getText());
			//log.error(message, e);
			
			result.getGlobalErrors().add(message.getText());
			
		}
		result.setResultCode(KO);

	}
	
	/**
	 * Gestisce l'eccezione impostando opportunamente l'oggetto result
	 * 
	 * @param result Result da impostare
	 * @param e Eccezione sollevata
	 */
	public static void gestisciEccezioneTabellaEditabile(ExecResults result, ManagerException e) {
		Message message = null;

	//	segnalaCampiErrati(result, e);
		message = e.getMsg();

		log.debug("STAMPO IL MESSAGGIO: "+message);
		
		if (e instanceof ValidationManagerException)
		{
			log.debug("Stampo l'eccezione (validation)",e);
		}
		else
		{
			log.error("Stampo l'eccezione (diversa da validation)",e);
		}
		
		
		if(message != null) {
			log.debug("STAMPO IL TESTO DEL MESSAGGIO: "+message.getText());
			//log.error(message, e);
			
			result.getGlobalErrors().add(message.getText());
			
		}
		result.setResultCode(KO);

	}
	
	
	
	
	
	
	
}
