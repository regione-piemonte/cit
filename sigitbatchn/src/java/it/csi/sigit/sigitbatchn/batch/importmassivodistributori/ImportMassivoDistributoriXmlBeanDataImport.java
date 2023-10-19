/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
package it.csi.sigit.sigitbatchn.batch.importmassivodistributori;

import it.csi.sigit.sigitbatchn.batch.AbstractDataImport;
import it.csi.sigit.sigitbatchn.batch.BatchConf;
import it.csi.sigit.sigitbatchn.batch.BatchException;
import it.csi.sigit.sigitbatchn.batch.reader.DataReader;
import it.csi.sigit.sigitbatchn.business.manager.business.ImportMassivoDistributoriBusinessMgr;
import it.csi.sigit.sigitbatchn.business.manager.util.ManagerException;


import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.xmlbeans.XmlException;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

/**
 * Import dati per import massivo distributorieffettuato tramite XmlBean
 * 
 */
public class ImportMassivoDistributoriXmlBeanDataImport extends AbstractDataImport {
	/**
	 * Nome della classe
	 */
	private final static String CLASS_NAME = ImportMassivoDistributoriXmlBeanDataImport.class.getSimpleName();
	/**
	 * Percorso dello schema di ImportMassivoImpianti
	 */
	private final static String IMPORT_MASSIVO_IMPIANTI_SCHEMA_PATH = "META-INF/importImpianti.xsd";
	/**
	 * Fallimento
	 */
	private final static String FAILURE = "0";
	/**
	 * Successo
	 */
	private final static String SUCCESS = "1";
	/**
	 * Manager business
	 */
	private ImportMassivoDistributoriBusinessMgr businessMgr = null;
	/**
	 * Lista degli errori riscontrati
	 */
	private List<Errors> errorsList = null;
	/**
	 * Lista degi rapporto controllo importati
	 */
	private List<Importati> importatiList = null;
	/**
	 * Lista degi rapporto controllo inviati
	 */
	private List<Importati> inviatiList = null;
	
	/**
	 * Mappatore di classi
	 */
	private Mapper mapper = null;
	/**
	 * Errori riscontrati durante l'import
	 */
	private Errors errors = null;
	/**
	 * Rapporto controllo importati (senza invio)
	 */
	private Importati importati = null;

	/**
	 * Rapporto controllo inviati
	 */
	private Importati inviati = null;

	
	/**
	 * {@inheritDoc}
	 */
	public void importData(BatchConf conf, List<DataReader> dataReaderList) throws BatchException {
		
	}
	
	/**
	 * Restituisce il messaggio associato ad una generica eccezione
	 * 
	 * @param e Eccezione per cui restituire il messaggio
	 * @return Messaggio associato all'eccezione
	 */
	private String getGenericExceptionMessage(Exception e) {
		// return(e == null ? null : e.getClass().getSimpleName() + ": " + e.getMessage());
		return(e == null ? null : e.getMessage());
	}

	/**
	 * Aggiunge un messaggio d'errore alla lista dei messaggi d'errore di un
	 * impianto
	 * 
	 * @param codiceImpianto Codice impianto a cui è associato il messaggio
	 *            d'errore
	 * @param exception Eccezione sollevata
	 * @return Lista aggiornata dei messaggi d'errore associati all'impianto
	 */
	private void addErrorMessage(Integer codiceImpianto, ManagerException exception) {
		if(errors == null) {
			errors = new Errors();
			errors.setCodiceImpianto(codiceImpianto);
		}
		//errors.addErrorMessage(retrieveErrorMessage(exception));
	}

	/**
	 * Aggiunge un messaggio d'errore alla lista dei messaggi d'errore di un
	 * impianto
	 * 
	 * @param codiceImpianto Codice impianto a cui è associato il messaggio
	 *            d'errore
	 * @param exception Eccezione sollevata
	 * @return Lista aggiornata dei messaggi d'errore associati all'impianto
	 */
	private void addErrorMessage(Integer codiceImpianto, Exception exception) {
		if(errors == null) {
			errors = new Errors();
			errors.setCodiceImpianto(codiceImpianto);
		}
		errors.addErrorMessage(getGenericExceptionMessage(exception));
	}

	/**
	 * Aggiunge un importato correttamente alla lista degli importati correttamente
	 * 
	 * @param idRapportoControllo
	 * @return Lista aggiornata degli importati correttamente
	 */
	private void addRapportoControlloImportati(Rapporto rapportoControllo) {
		if(importati == null) {
			importati = new Importati();
			
		}
		importati.addRapportoControllo(rapportoControllo);
	}
	
	/**
	 * Aggiunge un importato correttamente alla lista degli importati correttamente
	 * 
	 * @param idRapportoControllo
	 * @return Lista aggiornata degli importati correttamente
	 */
	private void addRapportoControlloInviati(Rapporto rapportoControllo) {
		if(inviati == null) {
			inviati = new Importati();
			
		}
		inviati.addRapportoControllo(rapportoControllo);
	}
	

	/**
	 * Restituisce il manager business
	 * 
	 * @return Manager business
	 */
	public ImportMassivoDistributoriBusinessMgr getBusinessMgr() {
		return businessMgr;
	}

	/**
	 * Imposta il manager business
	 * 
	 * @param businessMgr Manager business
	 */
	public void setBusinessMgr(ImportMassivoDistributoriBusinessMgr businessMgr) {
		this.businessMgr = businessMgr;
	}

	/**
	 * Imposta la lista degli errori riscontrati
	 * 
	 * @param errorsList Lista degli errori riscontrati
	 */
	public void setErrorsList(List<Errors> errorsList) {
		this.errorsList = errorsList;
	}

	/**
	 * Restituisce la lista degli errori riscontrati
	 * 
	 * @return Lista degli errori riscontrati
	 */
	public List<Errors> getErrorsList() {
		return errorsList;
	}

	
	/**
	 * Imposta la lista dei rapporti importati correttamente
	 * 
	 * @param idRapportoControlloList Lista dei rapporti importati correttamente
	 */
	public void setImportatiList(List<Importati> importatiList) {
		this.importatiList = importatiList;
	}

	/**
	 * Restituisce la lista dei rapporti importati correttamente
	 * 
	 * @return Lista dei rapporti importati correttamente
	 */
	public List<Importati> getImportatiList() {
		return importatiList;
	}

	/**
	 * Imposta la lista dei rapporti inviati correttamente
	 * 
	 * @param idRapportoControlloList Lista dei rapporti inviati correttamente
	 */
	public void setInviatiList(List<Importati> inviatiList) {
		this.inviatiList = inviatiList;
	}

	/**
	 * Restituisce la lista dei rapporti inviati correttamente
	 * 
	 * @return Lista dei rapporti inviati correttamente
	 */
	public List<Importati> getInviatiList() {
		return inviatiList;
	}

	
	/**
	 * Restituisce il mappatore di classi
	 * 
	 * @return Mappatore di classi
	 */
	public Mapper getMapper() {
		return mapper;
	}

	/**
	 * Imposta il mappatore di classi
	 * 
	 * @param mapper Mappatore di classi
	 */
	public void setMapper(Mapper mapper) {
		this.mapper = mapper;
	}

	
}
