/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
package it.csi.sigit.sigitweba.util;



import it.csi.sigit.sigitweba.dto.ExecResults;
import it.csi.sigit.sigitweba.business.manager.util.FieldError;
import it.csi.sigit.sigitweba.business.manager.util.ManagerException;
import it.csi.sigit.sigitweba.business.manager.util.Message;

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
	protected Logger log = Logger.getLogger(Constants.APPLICATION_CODE);

	/**
	 * Segnala i campi che risultano errati
	 * 
	 * @param result Result in cui segnalare i campi
	 * @param e Eccezione che contiene i campi errati
	 */
	static private void segnalaCampiErrati(ExecResults result, ManagerException e) {
		List<FieldError> fieldList = null;

		fieldList = e.getFieldList();
		for(FieldError field : fieldList) {
			result.getFldErrors().put(field.getField(),field.getMessageField());
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

		System.out.println("STAMPO IL MESSAGGIO: "+message);
		
		if(message != null) {
			System.out.println("STAMPO IL TESTO DEL MESSAGGIO: "+message.getText());
			result.getGlobalErrors().add(message.getText());
			
		}
		result.setResultCode(KO);

	}
}
