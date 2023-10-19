/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
package it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter;


/**
 * Filtro per cercare per codice REA
 * 
 */
public class DelegaFilter {

	
	/**
	 * Id persona giuridica
	 */
	private Integer idPersonaGiuridica = null;
	
	/**
	 * CF persona fisica
	 */
	private String cfPersonaFisica = null;

	public DelegaFilter(Integer idPersonaGiuridica, String cfPersonaFisica) {
		this.idPersonaGiuridica = idPersonaGiuridica;
		this.cfPersonaFisica = cfPersonaFisica;
	}
	

	public Integer getIdPersonaGiuridica() {
		return idPersonaGiuridica;
	}

	public void setIdPersonaGiuridica(Integer idPersonaGiuridica) {
		this.idPersonaGiuridica = idPersonaGiuridica;
	}

	public String getCfPersonaFisica() {
		return cfPersonaFisica;
	}

	public void setCfPersonaFisica(String cfPersonaFisica) {
		this.cfPersonaFisica = cfPersonaFisica;
	}

	
}
