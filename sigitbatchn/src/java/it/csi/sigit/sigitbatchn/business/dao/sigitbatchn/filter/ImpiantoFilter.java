/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
package it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.filter;

import java.math.BigDecimal;
import java.util.Date;


/**
 * Filtro per cercare gli impianti
 * 
 */
public class ImpiantoFilter {

	/**
	 * Codice impianto
	 */
	private Integer codiceImpianto = null;
	
	/**
	 * sigla provincia
	 */
	private String siglaProvincia = null;
	
	/**
	 * sigla comune
	 */
	private String siglaComune = null;
	
	/**
	 * indirizzo
	 */
	private String indirizzo = null;
	
	/**
	 * cf responsabile
	 */
	private String cfResponsabile = null;
	
	/**
	 * cf terzo responsabile
	 */
	private String cf3Responsabile = null;
	
	/**
	 * matricola
	 */
	private String matricola = null;
	
	/**
	 * Sigla REA
	 */
	private String siglaRea = null;
	/**
	 * Numero REA
	 */
	private Integer numeroRea = null;

	/**
	 * Codice fiscale
	 */
	private String cfDitta = null;
	
	/**
	 * Codice fiscale
	 */
	private String descRuoloFuonz = null;


	private BigDecimal idPersonaGiuridica;
	public BigDecimal getIdPersonaGiuridica() {
		return idPersonaGiuridica;
	}


	public void setIdPersonaGiuridica(BigDecimal idPersonaGiuridica) {
		this.idPersonaGiuridica = idPersonaGiuridica;
	}



	private Integer ruolo;
	
	public Integer getRuolo() {
		return ruolo;
	}


	public void setRuolo(Integer ruolo) {
		this.ruolo = ruolo;
	}



	private Date dataControllo;
	
	public Date getDataControllo() {
		return dataControllo;
	}


	public void setDataControllo(Date dataControllo) {
		this.dataControllo = dataControllo;
	}


	/**
	 * Inizializza un'istanza della classe
	 */
	public ImpiantoFilter() {
	}

	
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
	public Integer getNumeroRea() {
		return numeroRea;
	}

	/**
	 * Imposta il numero REA
	 * 
	 * @param numeroRea Numero REA
	 */
	public void setNumeroRea(Integer numeroRea) {
		this.numeroRea = numeroRea;
	}



	public String getSiglaProvincia() {
		return siglaProvincia;
	}



	public void setSiglaProvincia(String siglaProvincia) {
		this.siglaProvincia = siglaProvincia;
	}



	public String getSiglaComune() {
		return siglaComune;
	}



	public void setSiglaComune(String siglaComune) {
		this.siglaComune = siglaComune;
	}



	public String getIndirizzo() {
		return indirizzo;
	}



	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}



	public String getCfResponsabile() {
		return cfResponsabile;
	}



	public void setCfResponsabile(String cfResponsabile) {
		this.cfResponsabile = cfResponsabile;
	}



	public String getCf3Responsabile() {
		return cf3Responsabile;
	}



	public void setCf3Responsabile(String cf3Responsabile) {
		this.cf3Responsabile = cf3Responsabile;
	}



	public String getMatricola() {
		return matricola;
	}



	public void setMatricola(String matricola) {
		this.matricola = matricola;
	}



	public String getCfDitta() {
		return cfDitta;
	}



	public void setCfDitta(String cfDitta) {
		this.cfDitta = cfDitta;
	}



	public String getDescRuoloFuonz() {
		return descRuoloFuonz;
	}



	public void setDescRuoloFuonz(String descRuoloFuonz) {
		this.descRuoloFuonz = descRuoloFuonz;
	}
	
	
	
}
