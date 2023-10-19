/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
package it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter;


/**
 * Filtro per cercare gli impianti
 * 
 */
public class SubentroFilter {

	public SubentroFilter()
	{
		
	}
	
	public SubentroFilter(String descRuoloFunz, Integer codiceImpianto)
	{
		this.descRuoloFunz = descRuoloFunz;
		this.codiceImpianto = codiceImpianto;
	}
	
	/**
	 * Codice impianto
	 */
	private Integer codiceImpianto = null;
	
	/**
	 * descrizione ruolo funzionale
	 */
	private String descRuoloFunz = null;
	
	/**
	 * Imposta il codice impianto
	 * 
	 * @param codiceFiscale Codice impianto
	 */
	public void setCodiceImpianto(Integer codiceImpianto) {
		this.codiceImpianto = codiceImpianto;
	}

	/**
	 * Restituisce il codice impianto
	 * 
	 * @return Codice impianto
	 */
	public Integer getCodiceImpianto() {
		return codiceImpianto;
	}
	
	/**
	 * Restituisce la descrizione ruolo funzionale
	 * 
	 * @return Descrizione ruolo funzionale
	 */
	public String getDescRuoloFunz() {
		return descRuoloFunz;
	}

	/**
	 * Imposta la sescrizione ruolo funzionale
	 * 
	 * @param descRuoloFunz Descrizione ruolo funzionale
	 */
	public void setDescRuoloFunz(String descRuoloFunz) {
		this.descRuoloFunz = descRuoloFunz;
	}

}
