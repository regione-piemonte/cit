/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
package it.csi.sigit.sigitbatchn.batch;

/**
 * Interfaccia di un generico batch
 * 
 * @author 71845 - Marco Giacometto
 */
public interface Batch {
	/**
	 * Esegue il batch
	 * 
	 * @throws BatchException Errore durante l'esecuzione del batch
	 */
	public void execute() throws BatchException;
}
