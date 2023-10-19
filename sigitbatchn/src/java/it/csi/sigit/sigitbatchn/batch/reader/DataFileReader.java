/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
package it.csi.sigit.sigitbatchn.batch.reader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;

/**
 * Lettore di file dati
 * 
 * @author 71845 - Marco Giacometto
 */
public class DataFileReader implements DataReader {
	/**
	 * File da leggere
	 */
	private File file = null;

	/**
	 * Inizializza un'istanza della classe
	 * 
	 * @param fileName Nome del file da leggere
	 * @throws FileNotFoundException Il file non è stato trovato
	 */
	public DataFileReader(String fileName) throws FileNotFoundException {
		this(new File(fileName));
	}

	/**
	 * Inizializza un'istanza della classe
	 * 
	 * @param file File da leggere
	 * @throws FileNotFoundException Il file non è stato trovato
	 */
	public DataFileReader(File file) throws FileNotFoundException {
		this.file = file;
		if(!file.exists()) {
			throw new FileNotFoundException("File " + file.getAbsolutePath() + " non trovato");
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public Reader getReader() {
		Reader reader = null;
		
		try {
			reader = new FileReader(file);
		}
		catch(FileNotFoundException e) {
		}
		return reader;
	}
}
