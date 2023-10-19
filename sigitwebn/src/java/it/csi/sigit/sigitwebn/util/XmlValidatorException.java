/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
package it.csi.sigit.sigitwebn.util;

import java.util.Collection;

import org.apache.xmlbeans.XmlError;

/**
 * Eccezione sollevata dalla classe {@link XmlValidator}
 * 
 * @author 71845 - Marco Giacometto
 */
public class XmlValidatorException extends Exception {
	/**
	 * Id univoco della classe
	 */
	private static final long serialVersionUID = 8903271242660055218L;
	/**
	 * Lista degli errori riscontrati nella validazione
	 */
	private Collection<XmlError> errors = null;

	/**
	 * Inizializza un'istanza della classe
	 */
	public XmlValidatorException() {
	}

	/**
	 * Inizializza un'istanza della classe
	 * 
	 * @param message Messaggio d'errore
	 */
	public XmlValidatorException(String message) {
		super(message);
	}

	/**
	 * Inizializza un'istanza della classe
	 * 
	 * @param cause Causa dell'eccezione
	 */
	public XmlValidatorException(Throwable cause) {
		super(cause);
	}

	/**
	 * Inizializza un'istanza della classe
	 * 
	 * @param message Messaggio d'errore
	 * @param cause Causa dell'eccezione
	 */
	public XmlValidatorException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Imposta la lista degli errori riscontrati nella validazione
	 * 
	 * @param errors Lista degli errori riscontrati nella validazione
	 */
	public void setErrors(Collection<XmlError> errors) {
		this.errors = errors;
	}

	/**
	 * Restituisce la lista degli errori riscontrati nella validazione
	 * 
	 * @return Lista degli errori riscontrati nella validazione
	 */
	public Collection<XmlError> getErrors() {
		return errors;
	}
}
