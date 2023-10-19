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
public class PersonaRuoloFilter {
	
	
	private BigDecimal idImpRuoloPfpg = null;

	/**
	 * Codice impianto
	 */
	private BigDecimal codiceImpianto = null;

	/**
	 * Id persona giuridica
	 */
	private Integer idResponsabile = null;

	/**
	 * Id persona giuridica
	 */
	private Integer idPersonaGiuridica = null;
	
	/**
	 * Id persona fisica
	 */
	private Integer idPersonaFisica = null;
	
	/**
	 * CF persona fisica
	 */
	private String cfPersonaFisica = null;

	/**
	 * id ruolo 
	 */
	private Integer idRuolo;
	
	/**
	 * descrizione ruolo funzionale
	 */
	private String ruoloFunz;

	/**
	 * solo attivi
	 */
	private boolean isSoloAttivi;

	/**
	 * Inizializza un'istanza della classe
	 */
	public PersonaRuoloFilter() {
	}

	public BigDecimal getCodiceImpianto() {
		return codiceImpianto;
	}

	public void setCodiceImpianto(BigDecimal codiceImpianto) {
		this.codiceImpianto = codiceImpianto;
	}

	
	
	public Integer getIdResponsabile() {
		return idResponsabile;
	}

	public void setIdResponsabile(Integer idResponsabile) {
		this.idResponsabile = idResponsabile;
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

	
	public Integer getIdRuolo() {
		return idRuolo;
	}

	public void setIdRuolo(Integer idRuolo) {
		this.idRuolo = idRuolo;
	}

	public String getRuoloFunz() {
		return ruoloFunz;
	}

	public void setRuoloFunz(String ruoloFunz) {
		this.ruoloFunz = ruoloFunz;
	}

	public Integer getIdPersonaFisica() {
		return idPersonaFisica;
	}

	public void setIdPersonaFisica(Integer idPersonaFisica) {
		this.idPersonaFisica = idPersonaFisica;
	}

	public BigDecimal getIdImpRuoloPfpg() {
		return idImpRuoloPfpg;
	}

	public void setIdImpRuoloPfpg(BigDecimal idImpRuoloPfpg) {
		this.idImpRuoloPfpg = idImpRuoloPfpg;
	}

	public boolean isSoloAttivi() {
		return isSoloAttivi;
	}

	public void setSoloAttivi(boolean isSoloAttivi) {
		this.isSoloAttivi = isSoloAttivi;
	}

	
	
}
