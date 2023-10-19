/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
package it.csi.sigit.sigitbatchn.batch;

import it.csi.sigit.sigitbatchn.batch.reader.DataReader;

import java.util.List;

/**
 * Interfaccia generica di un importatore di dati
 * 
 * @author 71845 - Marco Giacometto
 */
public interface DataImport {
	/**
	 * Importa dei dati
	 * 
	 * @param conf Configurazione da utilizzare
	 * @param dataReaderList Lista dei reader da cui recuperare i dati da
	 *            importare
	 * @throws BatchException Errore durante l'importazione dei dati
	 */
	public void importData(BatchConf conf, List<DataReader> dataReaderList) throws BatchException;
}
