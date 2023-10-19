
package it.csi.sigit.sigitwebn.dto;

import java.util.*;

/**
 * Contiene i risultati dell'esecuzione di un metodo di business
 * @generated
 */
public class ExecResults {

	/**
	 * il codice di outcome
	 * @generated
	 */
	private String resultCode;

	/**
	 * l'elenco degli errori associati ai field della schermata eventualmente inseriti 
	 * da business logic
	 * @generated
	 */
	private Map<String, String> fldErrors = new HashMap<String, String>();

	/**
	 * l'elenco degli errori globali eventualmente inseriti da business logic
	 * @generated
	 */
	private Collection<String> globalErrors = new ArrayList<String>();

	/**
	 * l'elenco dei messaggi globali eventualmente inseriti da business logic
	 * @generated
	 */
	private Collection<String> globalMessages = new ArrayList<String>();
	private Object model;

	/**
	 * imposta il model del content panel
	 * @param  model 
	 * @generated
	 */
	public void setModel(Object model) {
		this.model = model;
	}

	/**
	 * restutuisce il model del content panel
	 * @generated
	 */
	public Object getModel() {
		return this.model;
	}

	/**
	 * imposta il codice di outcome
	 * @generated
	 */
	public void setResultCode(String code) {
		this.resultCode = code;
	}

	/** 
	 * restutuisce il codice di outcome
	 * @generated
	 */
	public String getResultCode() {
		return this.resultCode;
	}

	/**
	 * restituisce l'elenco degli errori associati al campo eventualmente inseriti nella
	 * business logic
	 * @generated
	 */
	public Map<String, String> getFldErrors() {
		return fldErrors;
	}

	public void setFldErrors(Map<String, String> fldErrors) {
		this.fldErrors = fldErrors;
	}

	/**
	 * restituisce l'elenco degli errori globali eventualmente inseriti nella
	 * business logic
	 * @generated
	 */
	public Collection<String> getGlobalErrors() {
		return globalErrors;
	}

	public void setGlobalErrors(Collection<String> globalErrors) {
		this.globalErrors = globalErrors;
	}

	/**
	 * restituisce l'elenco dei messaggi globali eventualmente inseriti nella
	 * business logic
	 * @generated
	 */
	public Collection<String> getGlobalMessages() {
		return globalMessages;
	}

	public void setGlobalMessages(Collection<String> globalMessages) {
		this.globalMessages = globalMessages;
	}
}
