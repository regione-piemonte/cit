/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
package it.csi.sigit.sigitbatchn.batch.reader;

import java.io.Reader;
import java.io.StringReader;

/**
 * Lettore di stringhe
 * 
 * @author 71845 - Marco Giacometto
 */
public class DataStringReader implements DataReader {
	/**
	 * Dati da leggere
	 */
	private String data = null;

	/**
	 * Inizializza un'istanza della classe
	 * 
	 * @param data Dati da leggere
	 */
	public DataStringReader(String data) {
		this.data = data;
	}

	/**
	 * {@inheritDoc}
	 */
	public Reader getReader() {
		return new StringReader(data);
	}
}
