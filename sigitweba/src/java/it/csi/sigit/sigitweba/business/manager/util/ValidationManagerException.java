/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
package it.csi.sigit.sigitweba.business.manager.util;

import it.csi.sigit.sigitweba.business.manager.ValidationMgr;


/**
 * Eccezione sollevata dal {@link ValidationMgr}
 * 
 * @author 71845 - Marco Giacometto
 */
public class ValidationManagerException extends ManagerException {
	/**
	 * Id univoco della classe
	 */
	private static final long serialVersionUID = 786129391319167656L;

	/**
	 * Inizializza un'istanza della classe
	 */
	public ValidationManagerException() {
		super(null, null, null);
	}

	/**
	 * Inizializza un'istanza della classe
	 * 
	 * @param msg Messaggio associato all'eccezione
	 */
	public ValidationManagerException(Message msg) {
		super(msg);
	}

	/**
	 * Inizializza un'istanza della classe
	 * 
	 * @param message Messaggio d'errore
	 * @param msg Messaggio associato all'eccezione
	 */
	public ValidationManagerException(String message, Message msg) {
		super(message, msg);
	}

	/**
	 * Inizializza un'istanza della classe
	 * 
	 * @param cause Causa dell'eccezione
	 * @param msg Messaggio associato all'eccezione
	 */
	public ValidationManagerException(Throwable cause, Message msg) {
		super(cause, msg);
	}

	/**
	 * Inizializza un'istanza della classe
	 * 
	 * @param message Messaggio d'errore
	 * @param cause Causa dell'eccezione
	 * @param msg Messaggio associato all'eccezione
	 */
	public ValidationManagerException(String message, Throwable cause, Message msg) {
		super(message, cause, msg);
	}
}
