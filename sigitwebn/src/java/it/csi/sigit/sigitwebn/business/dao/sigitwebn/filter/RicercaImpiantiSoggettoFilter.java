/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
package it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;


public class RicercaImpiantiSoggettoFilter{

	private BigDecimal idImpRuoloPfpg;
	
	private List<String> listaRuoliInclusi;
	
	private BigDecimal codiceImpianto;
	
	private Date dataInizio;
	
	private Date dataFine;
	
	private BigDecimal idPersonaFisica;
	
	private BigDecimal idPersonaGiuridica;

	public List<String> getListaRuoliInclusi() {
		return listaRuoliInclusi;
	}

	public void setListaRuoliInclusi(List<String> listaRuoliInclusi) {
		this.listaRuoliInclusi = listaRuoliInclusi;
	}

	public BigDecimal getCodiceImpianto() {
		return codiceImpianto;
	}

	public void setCodiceImpianto(BigDecimal codiceImpianto) {
		this.codiceImpianto = codiceImpianto;
	}

	public Date getDataInizio() {
		return dataInizio;
	}

	public void setDataInizio(Date dataInizio) {
		this.dataInizio = dataInizio;
	}

	public Date getDataFine() {
		return dataFine;
	}

	public void setDataFine(Date dataFine) {
		this.dataFine = dataFine;
	}

	public BigDecimal getIdPersonaFisica() {
		return idPersonaFisica;
	}

	public void setIdPersonaFisica(BigDecimal idPersonaFisica) {
		this.idPersonaFisica = idPersonaFisica;
	}

	public BigDecimal getIdPersonaGiuridica() {
		return idPersonaGiuridica;
	}

	public void setIdPersonaGiuridica(BigDecimal idPersonaGiuridica) {
		this.idPersonaGiuridica = idPersonaGiuridica;
	}

	public BigDecimal getIdImpRuoloPfpg() {
		return idImpRuoloPfpg;
	}

	public void setIdImpRuoloPfpg(BigDecimal idImpRuoloPfpg) {
		this.idImpRuoloPfpg = idImpRuoloPfpg;
	}
	
	
	
	
	
	
	
	
	
	
}
