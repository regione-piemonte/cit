/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
package it.csi.sigit.sigitext.business.dao.sigitextdao.dao.filter;

import java.math.BigDecimal;

/**
 * Filtro per cercare per codice REA
 * 
 */
public class CodiceReaAndFiscaleAndDenomFilter {
	/**
	 * Sigla REA
	 */
	private String siglaRea = null;
	/**
	 * Numero REA
	 */
	private BigDecimal numeroRea = null;

	/**
	 * Codice fiscale
	 */
	private String codiceFiscale = null;
	
	/**
	 * Denominazione
	 */
	private String denominazione = null;
	
	/**
	 * isImpresa
	 */
	private Boolean isImpresa = null;
	
	/**
	 * Inizializza un'istanza della classe
	 */
	public CodiceReaAndFiscaleAndDenomFilter() {
	}

	
	/**
	 * Restituisce la sigla REA
	 * 
	 * @return Sigla REA
	 */
	public String getSiglaRea() {
		return siglaRea;
	}

	/**
	 * Imposta la sigla REA
	 * 
	 * @param siglaRea Sigla REA
	 */
	public void setSiglaRea(String siglaRea) {
		this.siglaRea = siglaRea;
	}

	/**
	 * Restituisce il numero REA
	 * 
	 * @return Numero REA
	 */
	public BigDecimal getNumeroRea() {
		return numeroRea;
	}

	/**
	 * Imposta il numero REA
	 * 
	 * @param numeroRea Numero REA
	 */
	public void setNumeroRea(BigDecimal numeroRea) {
		this.numeroRea = numeroRea;
	}


	public String getCodiceFiscale() {
		return codiceFiscale;
	}


	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}


	public String getDenominazione() {
		return denominazione;
	}


	public void setDenominazione(String denominazione) {
		this.denominazione = denominazione;
	}


	public Boolean getIsImpresa() {
		return isImpresa;
	}


	public void setIsImpresa(Boolean isImpresa) {
		this.isImpresa = isImpresa;
	}
	
	
	
}
