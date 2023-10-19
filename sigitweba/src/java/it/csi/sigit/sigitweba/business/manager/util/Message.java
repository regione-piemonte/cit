/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
package it.csi.sigit.sigitweba.business.manager.util;

import it.csi.sigit.sigitweba.util.ConvertUtil;

import java.util.Date;


/**
 * Bean contenente le informazioni su un messaggio
 * 
 */
public class Message implements Cloneable {
	/**
	 * Segnaposto delle parti variabili dei messaggi
	 */
	private final static String VALUE_PLACEHOLDER = "##value##";
	/**
	 * Testo del messaggio
	 */
	private String text = null;

	/**
	 * Inizializza un'istanza della classe
	 */
	public Message() {
	}

	/**
	 * Inizializza un'istanza della classe
	 * 
	 * @param text Testo del messaggio
	 */
	public Message(String text) {
		this.text = text;
	}

	/**
	 * Sostituisce un valore al primo segnaposto del messaggio
	 * 
	 * @param value Valore da sostituire
	 * @return Messaggio
	 */
	public Message replacePlaceholder(String value) {
		text = text.replaceFirst(VALUE_PLACEHOLDER, value);
		return this;
	}

	/**
	 * Sostituisce un valore al primo segnaposto del messaggio
	 * 
	 * @param value Valore da sostituire
	 * @return Messaggio
	 */
	public Message replacePlaceholder(long value) {
		text = text.replaceFirst(VALUE_PLACEHOLDER, Long.toString(value));
		return this;
	}

	/**
	 * Sostituisce un valore al primo segnaposto del messaggio
	 * 
	 * @param value Valore da sostituire
	 * @return Messaggio
	 */
	public Message replacePlaceholder(Date value) {
		text = text.replaceFirst(VALUE_PLACEHOLDER, ConvertUtil.convertToString(value));
		return this;
	}

	/**
	 * Sostituisce un valore al primo segnaposto del messaggio
	 * 
	 * @param value Valore da sostituire
	 * @return Messaggio
	 */
	public Message replacePlaceholder(int value) {
		text = text.replaceFirst(VALUE_PLACEHOLDER, Integer.toString(value));
		return this;
	}

	/**
	 * Restituisce il testo del messaggio
	 * 
	 * @return Testo del messaggio
	 */
	public String getText() {
		return text;
	}

	/**
	 * Imposta il testo del messaggio
	 * 
	 * @param text Testo del messaggio
	 */
	public void setText(String text) {
		this.text = text;
	}

}
