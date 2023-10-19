/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
package it.csi.sigit.sigitbatchn.batch.importmassivodistributori;

import java.util.ArrayList;
import java.util.List;

/**
 * Gestisce gli errori riscontrati per un impianto
 * 
 * @author 71845 - Marco Giacometto
 */
public class Errors {
	/**
	 * Id del manutentore associato all'impianto
	 */
	private Integer idManutentore = null;
	/**
	 * Mail del manutentore associato all'impianto
	 */
	private String mailManutentore = null;
	/**
	 * Codice dell'impianto per cui si sono riscontrati errori
	 */
	private Integer codiceImpianto = null;
	/**
	 * Lista dei messaggi d'errore riscontrati
	 */
	private List<String> errorMessagesList = null;

	/**
	 * Restituisce l'Id del manutentore associato all'impianto
	 * 
	 * @return Id del manutentore associato all'impianto
	 */
	public Integer getIdManutentore() {
		return idManutentore;
	}

	/**
	 * Imposta l'Id del manutentore associato all'impianto
	 * 
	 * @param idManutentore Id del manutentore associato all'impianto
	 */
	public void setIdManutentore(Integer idManutentore) {
		this.idManutentore = idManutentore;
	}

	/**
	 * Restituisce la mail del manutentore associato all'impianto
	 * 
	 * @return Mail del manutentore associato all'impianto
	 */
	public String getMailManutentore() {
		return mailManutentore;
	}

	/**
	 * Imposta la mail del manutentore associato all'impianto
	 * 
	 * @param mailManutentore Mail del manutentore associato all'impianto
	 */
	public void setMailManutentore(String mailManutentore) {
		this.mailManutentore = mailManutentore;
	}

	/**
	 * Imposta il codice dell'impianto per cui si sono riscontrati errori
	 * 
	 * @param codiceImpianto Codice dell'impianto per cui si sono riscontrati
	 *            errori
	 */
	public void setCodiceImpianto(Integer codiceImpianto) {
		this.codiceImpianto = codiceImpianto;
	}

	/**
	 * Restituisce il codice dell'impianto per cui si sono riscontrati errori
	 * 
	 * @return Codice dell'impianto per cui si sono riscontrati errori
	 */
	public Integer getCodiceImpianto() {
		return codiceImpianto;
	}

	/**
	 * Imposta la lista dei messaggi d'errore riscontrati
	 * 
	 * @param errorMessagesList Lista dei messaggi d'errore riscontrati
	 */
	public void setErrorMessagesList(List<String> errorMessagesList) {
		this.errorMessagesList = errorMessagesList;
	}

	/**
	 * Restituisce la lista dei messaggi d'errore riscontrati
	 * 
	 * @return Lista dei messaggi d'errore riscontrati
	 */
	public List<String> getErrorMessagesList() {
		return errorMessagesList;
	}

	/**
	 * Aggiunge un errore alla lista dei messaggi d'errore
	 * 
	 * @param errorMessage Errore da aggiungere
	 */
	public void addErrorMessage(String errorMessage) {
		if(errorMessagesList == null) {
			errorMessagesList = new ArrayList<String>();
		}
		errorMessagesList.add(errorMessage);
	}

	/**
	 * Pulisce la lista dei messaggi d'errore
	 */
	public void cleanErrorMessagesList() {
		errorMessagesList = new ArrayList<String>();
	}
}
