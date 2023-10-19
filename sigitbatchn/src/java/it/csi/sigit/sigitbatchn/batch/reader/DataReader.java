/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
package it.csi.sigit.sigitbatchn.batch.reader;

import java.io.Reader;

/**
 * Interfaccia di un generico lettore di dati
 * 
 * @author 71845 - Marco Giacometto
 */
public interface DataReader {
	/**
	 * Restituisce il lettore dei dati
	 * 
	 * @return Lettore dei dati
	 */
	public Reader getReader();
}
