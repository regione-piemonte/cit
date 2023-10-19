/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
package it.csi.sigit.sigitwebn.business.manager.util;

import it.csi.sigit.sigitwebn.util.ConstantsField;
import it.csi.sigit.sigitwebn.util.Messages;

import java.util.ArrayList;
import java.util.List;


/**
 * Eccezione sollevata dai manager
 * 
 */
public class ManagerException extends Exception implements ConstantsField {
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
	/**
	 * Lista dei campi che hanno sollevato l'eccezione
	 */
	private List<FieldError> fieldList = null;

	/**
	 * Inizializza un'istanza della classe
	 * 
	 * @param msg Messaggio associato all'eccezione
	 */
	public ManagerException(Message msg) {
		super(DEFAULT_ERROR_MESSAGE);
		this.setMsg(msg);
		fieldList = new ArrayList<FieldError>();
	}

	/**
	 * Inizializza un'istanza della classe
	 * 
	 * @param message Messaggio d'errore
	 * @param msg Messaggio associato all'eccezione
	 */
	public ManagerException(String message, Message msg) {
		super(message);
		this.setMsg(msg);
		fieldList = new ArrayList<FieldError>();
	}

	/**
	 * Inizializza un'istanza della classe
	 * 
	 * @param cause Causa dell'errore
	 * @param msg Messaggio associato all'eccezione
	 */
	public ManagerException(Throwable cause, Message msg) {
		super(DEFAULT_ERROR_MESSAGE, cause);
		this.setMsg(msg);
		fieldList = new ArrayList<FieldError>();
	}

	/**
	 * Inizializza un'istanza della classe
	 * 
	 * @param message Messaggio d'errore
	 * @param cause Causa dell'errore
	 * @param msg Messaggio associato all'eccezione
	 */
	public ManagerException(String message, Throwable cause, Message msg) {
		super(message, cause);
		this.setMsg(msg);
		fieldList = new ArrayList<FieldError>();
	}

	/**
	 * Imposta il messaggio associato all'eccezione
	 * 
	 * @param msg Messaggio associato all'eccezione
	 */
	public void setMsg(Message msg) {
		
		// Se non e' stato impostato il tipo di messaggio
		// visto che mi trovo su ManagerException 
		// lo setto a ERROR
		if (msg != null && msg.getType() == Message.DEFAULT)
		{
			// Setto ERROR come default per l'eccezione
			msg.setType(Message.ERROR);
		}
		
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
	 * Imposta la lista dei campi che hanno sollevato l'eccezione
	 * 
	 * @param fieldList Lista dei campi che hanno sollevato l'eccezione
	 */
	public void setFieldList(List<FieldError> fieldList) {
		this.fieldList = fieldList;
	}

	/**
	 * Restituisce la lista dei campi che hanno sollevato l'eccezione
	 * 
	 * @return Lista dei campi che hanno sollevato l'eccezione
	 */
	public List<FieldError> getFieldList() {
		return fieldList;
	}

	/**
	 * Aggiunge un campo alla lista dei campi che hanno sollevato l'eccezione
	 * 
	 * @param field Campo da aggiungere
	 */
	public void addField(FieldError field) {
		fieldList.add(field);
	}

	/**
	 * Aggiunge un campo alla lista dei campi che hanno sollevato l'eccezione
	 * 
	 * @param field Campo da aggiungere
	 */
	public void addField(String field) {
		FieldError filedError = new FieldError();
		filedError.setField(field);
		fieldList.add(filedError);
	}
	
	/**
	 * Aggiunge un campo alla lista dei campi che hanno sollevato l'eccezione
	 * 
	 * @param field Campo da aggiungere
	 */
	public void addFieldRequired(String field) {
		FieldError filedError = new FieldError();
		filedError.setField(field);
		filedError.setMessageField(Messages.ERROR_CAMPO_ABBIGATORIO);
		fieldList.add(filedError);
	}
	
	/**
	 * Aggiunge un campo alla lista dei campi che hanno sollevato l'eccezione
	 * 
	 * @param field Campo da aggiungere
	 */
	public void addField(String field, String message) {
		FieldError filedError = new FieldError();
		filedError.setField(field);
		filedError.setMessageField(message);
		fieldList.add(filedError);
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
	
	public String getMessageCompleto() {
		StringBuffer m = new StringBuffer();
		
		if(msg != null) {
			m.append(" Message: "+msg.getText());
			m.append(" Type: "+msg.getType());
		}
		else {
			m.append(" Message: "+super.getMessage());
		}
		
		if (fieldList != null && fieldList.size() > 0 )
		{
			for (FieldError fieldError : fieldList) {
				m.append(" #fieldError: "+fieldError.getField() + "("+fieldError.getMessageField()+")");
				
			}
		}
		
		return m.toString();
	}
	
}
