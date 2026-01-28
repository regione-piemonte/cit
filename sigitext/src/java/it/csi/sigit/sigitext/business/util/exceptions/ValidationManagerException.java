/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
package it.csi.sigit.sigitext.business.util.exceptions;

import it.csi.sigit.sigitext.business.util.FieldError;
import it.csi.sigit.sigitext.business.util.Message;
import it.csi.sigit.sigitext.business.util.Messages;

import java.util.ArrayList;
import java.util.List;

public class ValidationManagerException extends Exception{

	private static final long serialVersionUID = 786129391319167656L;
	private Message msg;
	private String message;
	private Throwable cause;
	private List<FieldError> fieldList = null;

	public ValidationManagerException() {
		this.fieldList = new ArrayList<FieldError>();
	}

	/**
	 * Inizializza un'istanza della classe
	 * 
	 * @param msg Messaggio associato all'eccezione
	 */
	public ValidationManagerException(Message msg) {
		this.msg = msg;
		this.fieldList = new ArrayList<FieldError>();
	}


	public ValidationManagerException(String message, Message msg) {
		super(message);
		this.msg = msg;
		this.fieldList = new ArrayList<FieldError>();
	}

	public ValidationManagerException(Throwable cause, Message msg) {
		super(cause);
		this.msg = msg;
		this.fieldList = new ArrayList<FieldError>();
	}


	public ValidationManagerException(String message, Throwable cause, Message msg) {
		super(message, cause);
		this.msg = msg;
		this.fieldList = new ArrayList<FieldError>();
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public Message getMsg() {
		return msg;
	}

	public void setMsg(Message msg) {
		this.msg = msg;
	}

	@Override
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public synchronized Throwable getCause() {
		return cause;
	}

	public void setCause(Throwable cause) {
		this.cause = cause;
	}

	public List<FieldError> getFieldList() {
		return fieldList;
	}

	public void setFieldList(List<FieldError> fieldList) {
		this.fieldList = fieldList;
	}

	public void addField(String field, String message) {
		FieldError filedError = new FieldError();
		filedError.setField(field);
		filedError.setMessageField(message);
		fieldList.add(filedError);
	}

	public void addFieldRequired(String field) {
		FieldError filedError = new FieldError();
		filedError.setField(field);
		filedError.setMessageField(Messages.ERROR_CAMPO_ABBIGATORIO);
		fieldList.add(filedError);
	}

	public void addField(String field) {
		FieldError filedError = new FieldError();
		filedError.setField(field);
		fieldList.add(filedError);
	}

	public void addField(FieldError field) {
		fieldList.add(field);
	}
}
