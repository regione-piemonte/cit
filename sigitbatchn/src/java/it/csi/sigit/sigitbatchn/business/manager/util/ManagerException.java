/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
package it.csi.sigit.sigitbatchn.business.manager.util;


import java.util.ArrayList;
import java.util.List;


/**
 * Eccezione sollevata dai manager
 * 
 */
public class ManagerException extends Exception { //implements ConstantsField {
	/**
	 * ID univoco della classe
	 */
	private static final long serialVersionUID = -2888738880900079487L;
	/**
	 * Messaggio d'errore di default
	 */
	private final static String DEFAULT_ERROR_MESSAGE = "Business error";
	/**
	 * Messaggio associato all'eccezione
	 */
	private Message msg = null;
	
	public ManagerException(Message msg) {
		super(DEFAULT_ERROR_MESSAGE);
		this.setMsg(msg);
	}

//	/**
//	 * Inizializza un'istanza della classe
//	 * 
//	 * @param msg Messaggio associato all'eccezione
//	 */
//	public ManagerException(Message msg) {
//		super(DEFAULT_ERROR_MESSAGE);
//		this.setMsg(msg);
//		fieldList = new ArrayList<FieldError>();
//	}

//	/**
//	 * Inizializza un'istanza della classe
//	 * 
//	 * @param message Messaggio d'errore
//	 * @param msg Messaggio associato all'eccezione
//	 */
//	public ManagerException(String message, Message msg) {
//		super(message);
//		this.setMsg(msg);
//		fieldList = new ArrayList<FieldError>();
//	}

//	/**
//	 * Inizializza un'istanza della classe
//	 * 
//	 * @param cause Causa dell'errore
//	 * @param msg Messaggio associato all'eccezione
//	 */
	public ManagerException(Throwable cause, Message msg) {
		
		
		super(DEFAULT_ERROR_MESSAGE, cause);
		
		this.setMsg(msg);
		//fieldList = new ArrayList<FieldError>();
	}

//	/**
//	 * Inizializza un'istanza della classe
//	 * 
//	 * @param message Messaggio d'errore
//	 * @param cause Causa dell'errore
//	 * @param msg Messaggio associato all'eccezione
//	 */
//	public ManagerException(String message, Throwable cause, Message msg) {
//		super(message, cause);
//		this.setMsg(msg);
//		fieldList = new ArrayList<FieldError>();
//	}

	/**
	 * Imposta il messaggio associato all'eccezione
	 * 
	 * @param msg Messaggio associato all'eccezione
	 */
	public void setMsg(Message msg) {
		this.msg = msg;
	}

	/**
	 * Restituisce il messaggio associato all'eccezione
	 * 
	 * @return Messaggio associato all'eccezione
	 */
	public Message getMsg() {
		return msg;
	}

	
	
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getMessage() {
		String m = null;
		
		if(msg != null) {
			m = msg.getText();
		}
		else {
			m = super.getMessage();
		}
		return m;
	}
}
