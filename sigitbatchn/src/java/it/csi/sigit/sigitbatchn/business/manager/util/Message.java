/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
package it.csi.sigit.sigitbatchn.business.manager.util;


import it.csi.sigit.sigitbatchn.business.util.ConvertUtil;

import java.util.Date;


/**
 * Bean contenente le informazioni su un messaggio
 * 
 */
public class Message implements java.io.Serializable {
	/**
	 * Segnaposto delle parti variabili dei messaggi
	 */
	private final static String VALUE_PLACEHOLDER = "##value##";
	private final static String VALUE_PLACEHOLDER1 = "##value1##";
	private final static String VALUE_PLACEHOLDER2 = "##value2##";
	private final static String VALUE_PLACEHOLDER3 = "##value3##";


	/**
	 * Messaggio d'errore fatale
	 */
	public final static int FATAL = 5;
	/**
	 * Messaggio d'errore
	 */
	public final static int ERROR = 4;
	/**
	 * Messaggio d'allerta
	 */
	public final static int WARNING = 3;
	/**
	 * Messaggio di informazione
	 */
	public final static int INFO = 2;
	/**
	 * Messaggio di debug
	 */
	public final static int DEBUG = 1;
	/**
	 * Messaggio di conferma
	 */
	public final static int CONFIRM = 0;
	
	/**
	 * Testo del messaggio
	 */
	private String text = null;
	
	/**
	 * Tipo di messaggio
	 */
	private int type = -1;
	
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
	 * Inizializza un'istanza della classe con un parametro di sostituzione
	 * 
	 * @param text Testo del messaggio
	 * @param value Valore da sostituire
	 */
	public Message(String text, String value) {
		this.text = text;
		replacePlaceholder(value);
		
	}
	
	/**
	 * Inizializza un'istanza della classe con due parametri di sostituzione
	 * 
	 * @param text Testo del messaggio
	 * @param value1 Valore da sostituire
	 * @param value2 Valore da sostituire
	 */
	public Message(String text, String value1, String value2) {
		this.text = text;
		replacePlaceholder(value1,value2);
		
	}

	/**
	 * Inizializza un'istanza della classe con due parametri di sostituzione
	 * 
	 * @param text Testo del messaggio
	 * @param value1 Valore da sostituire
	 * @param value2 Valore da sostituire
	 * @param value3 Valore da sostituire
	 */
	public Message(String text, String value1, String value2, String value3) {
		this.text = text;
		replacePlaceholder(value1,value2,value3);
		
	}
	
	/**
	 * Inizializza un'istanza della classe
	 * 
	 * @param text Testo del messaggio
	 */
	public Message(String text, int type) {
		this.text = text;
		this.type = type;
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
	 * Sostituisce due valori ai segnaposto del messaggio
	 * 
	 * @param value Valore da sostituire
	 * @return Messaggio
	 */
	public Message replacePlaceholder(String value1,String value2) {
		text = text.replaceFirst(VALUE_PLACEHOLDER1, value1);
		text = text.replaceFirst(VALUE_PLACEHOLDER2, value2);
		return this;
	}

	/**
	 * Sostituisce due valori ai segnaposto del messaggio
	 * 
	 * @param value Valore da sostituire
	 * @return Messaggio
	 */
	public Message replacePlaceholder(String value1,String value2,String value3) {
		text = text.replaceFirst(VALUE_PLACEHOLDER1, value1);
		text = text.replaceFirst(VALUE_PLACEHOLDER2, value2);
		text = text.replaceFirst(VALUE_PLACEHOLDER3, value3);

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
	 * Verifica se il messaggio e' un messaggio d'errore fatale
	 * 
	 * @return True se e' un messaggio d'errore fatale, false altrimenti
	 */
	public boolean isFatalMessage() {
		return type == FATAL;
	}

	/**
	 * Verifica se il messaggio e' un messaggio d'errore
	 * 
	 * @return True se e' un messaggio d'errore, false altrimenti
	 */
	public boolean isErrorMessage() {
		return type == ERROR;
	}

	/**
	 * Verifica se il messaggio e' un messaggio d'allerta
	 * 
	 * @return True se e' un messaggio d'allerta, false altrimenti
	 */
	public boolean isWarningMessage() {
		return type == WARNING;
	}

	/**
	 * Verifica se il messaggio e' un messaggio d'informazione
	 * 
	 * @return True se e' un messaggio d'informazione, false altrimenti
	 */
	public boolean isInfoMessage() {
		return type == INFO;
	}

	/**
	 * Verifica se il messaggio e' un messaggio di debug
	 * 
	 * @return True se e' un messaggio di debug, false altrimenti
	 */
	public boolean isDebugMessage() {
		return type == DEBUG;
	}

	/**
	 * Verifica se il messaggio e' un messaggio di conferma
	 * 
	 * @return True se e' un messaggio di conferma, false altrimenti
	 */
	public boolean isConfirmMessage() {
		return type == CONFIRM;
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
	
	/**
	 * Restituisce il tipo del messaggio
	 * 
	 * @return Tipo del messaggio
	 */
	public int getType() {
		return type;
	}

	/**
	 * Imposta il tipo del messaggio
	 * 
	 * @param type Tipo del messaggio
	 */
	public void setType(int type) {
		this.type = type;
	}

}
