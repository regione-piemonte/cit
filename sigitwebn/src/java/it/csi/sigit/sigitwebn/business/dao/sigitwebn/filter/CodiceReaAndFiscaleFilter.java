/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
package it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter;

import java.math.BigDecimal;

/**
 * Filtro per cercare per codice REA
 * 
 */
public class CodiceReaAndFiscaleFilter {
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
	 * Flg solo attivi
	 */
	private boolean flgSoloAttivi = false;
	
	/**
	 * Flg dm37LetteraC
	 */
	private boolean flgDm37LetteraC = false;

	/**
	 * Inizializza un'istanza della classe
	 */
	public CodiceReaAndFiscaleFilter() {
	}

	/**
	 * Inizializza un'istanza della classe
	 * 
	 * @param siglaRea Sigla REA
	 * @param numeroRea Numero REA
	 * @param codiceFiscale  Codice fiscale
	 */
	public CodiceReaAndFiscaleFilter(String siglaRea, BigDecimal numeroRea, String codiceFiscale) {
		this.siglaRea = siglaRea;
		this.numeroRea = numeroRea;
		this.codiceFiscale = codiceFiscale;
	}
	
	/**
	 * Inizializza un'istanza della classe
	 * 
	 * @param siglaRea Sigla REA
	 * @param numeroRea Numero REA
	 * @param codiceFiscale  Codice fiscale
	 */
	public CodiceReaAndFiscaleFilter(String siglaRea, BigDecimal numeroRea, String codiceFiscale, boolean flgDm37LetteraC) {
		this.siglaRea = siglaRea;
		this.numeroRea = numeroRea;
		this.codiceFiscale = codiceFiscale;
		this.flgDm37LetteraC = flgDm37LetteraC;
	}

	/**
	 * Inizializza un'istanza della classe
	 * 
	 * @param siglaRea Sigla REA
	 * @param numeroRea Numero REA
	 */
	public CodiceReaAndFiscaleFilter(String siglaRea, BigDecimal numeroRea) {
		this.siglaRea = siglaRea;
		this.numeroRea = numeroRea;
	}
	
	/**
	 * Inizializza un'istanza della classe
	 * 
	 * @param siglaRea Sigla REA
	 * @param numeroRea Numero REA
	 */
	public CodiceReaAndFiscaleFilter(String siglaRea, BigDecimal numeroRea, boolean flgDm37LetteraC) {
		this.siglaRea = siglaRea;
		this.numeroRea = numeroRea;
		this.flgDm37LetteraC = flgDm37LetteraC;
	}
	
	/**
	 * Inizializza un'istanza della classe
	 * 
	 * @param codiceFiscale  Codice fiscale
	 */
	public CodiceReaAndFiscaleFilter(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}
	
	/**
	 * Inizializza un'istanza della classe
	 * 
	 * @param codiceFiscale  Codice fiscale
	 */
	public CodiceReaAndFiscaleFilter(String codiceFiscale, boolean flgDm37LetteraC) {
		this.codiceFiscale = codiceFiscale;
		this.flgDm37LetteraC = flgDm37LetteraC;
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
	
	/**
	 * Imposta il codice fiscale
	 * 
	 * @param codiceFiscale Codice fiscale
	 */
	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}

	/**
	 * Restituisce il codice fiscale
	 * 
	 * @return Codice fiscale
	 */
	public String getCodiceFiscale() {
		return codiceFiscale;
	}

	public boolean isFlgSoloAttivi() {
		return flgSoloAttivi;
	}

	public void setFlgSoloAttivi(boolean flgSoloAttivi) {
		this.flgSoloAttivi = flgSoloAttivi;
	}

	public boolean isFlgDm37LetteraC() {
		return flgDm37LetteraC;
	}

	public void setFlgDm37LetteraC(boolean flgDm37LetteraC) {
		this.flgDm37LetteraC = flgDm37LetteraC;
	}
	
	
}
