/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
package it.csi.sigit.sigitbatchn.batch;

/**
 * Eccezione sollevata da un batch
 * 
 * @author 71845 - Marco Giacometto
 */
public class BatchException extends Exception {
	/**
	 * Id univoco della classe
	 */
	private static final long serialVersionUID = -4174861422716667544L;

	/**
	 * Inizializza un'istanza della classe
	 */
	public BatchException() {
		super();
	}

	/**
	 * Inizializza un'istanza della classe
	 * 
	 * @param message Messaggio d'errore
	 * @param throwable Causa dell'eccezione
	 */
	public BatchException(String message, Throwable throwable) {
		super(message, throwable);
	}

	/**
	 * Inizializza un'istanza della classe
	 * 
	 * @param message Messaggio d'errore
	 */
	public BatchException(String message) {
		super(message);
	}

	/**
	 * Inizializza un'istanza della classe
	 * 
	 * @param throwable Causa dell'eccezione
	 */
	public BatchException(Throwable throwable) {
		super(throwable);
	}
}
