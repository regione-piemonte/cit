/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
package it.csi.sigit.sigitbatchn.batch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

//import it.csi.sigit.common.manager.messaggi.MsgMgr;
import it.csi.sigit.sigitbatchn.business.util.LoggerHelper;

/**
 * Generico importatore di dati
 * 
 * @author 71845 - Marco Giacometto
 */
public abstract class AbstractDataImport implements DataImport {
	/**
	 * Logger da utilizzare
	 */
	protected LoggerHelper loggerHelper = null;
	/**
	 * Gestore dei messaggi
	 */
	//protected MsgMgr msgMgr = null;

	/**
	 * Legge un file
	 * 
	 * @param fileReader Lettore del file
	 * @return Contenuto del file
	 * @throws IOException Errore durante la lettura del file
	 */
	protected String readFile(Reader fileReader) throws IOException {
		StringBuilder fileContent = null;
		BufferedReader reader = null;
		String line = null;

		reader = new BufferedReader(fileReader);
		fileContent = new StringBuilder();
		while((line = reader.readLine()) != null) {
			fileContent.append(line).append("\n");
		}
		return fileContent.toString();
	}
	
	/**
	 * Restituisce il progresso dell'elaborazione
	 * 
	 * @param current Attività corrente
	 * @param total Totale attività
	 * @return Progressivo dell'elaborazione
	 */
	protected String getProgress(int current, int total) {
		return "(" + current + " di " + total + ")";
	}

	/**
	 * Imposta il logger da utilizzare
	 * 
	 * @param loggerHelper Logger da utilizzare
	 */
	public void setLoggerHelper(LoggerHelper loggerHelper) {
		this.loggerHelper = loggerHelper;
	}

	/**
	 * Restituisce il logger da utilizzare
	 * 
	 * @return Logger da utilizzare
	 */
	public LoggerHelper getLoggerHelper() {
		return loggerHelper;
	}

	
}
