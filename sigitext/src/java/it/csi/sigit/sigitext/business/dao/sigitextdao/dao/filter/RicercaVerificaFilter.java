/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
package it.csi.sigit.sigitext.business.dao.sigitextdao.dao.filter;

import it.csi.sigit.sigitext.business.util.ConvertUtil;
import it.csi.sigit.sigitext.dto.sigitext.RicercaVerifica;

import java.math.BigDecimal;

public class RicercaVerificaFilter implements java.io.Serializable {

	private BigDecimal idVerifica;
	private BigDecimal idValidatoreCaricamento;
	private java.sql.Date dataCreazioneDA;
	private java.sql.Date dataCreazioneA;
	private BigDecimal idTipoVerifica;
	private BigDecimal codiceImpianto;
	private String siglaBollino;
	private BigDecimal numeroBollino;
	private BigDecimal idDatoDistributore;
	private boolean ricercaAutomatiche;
	private String denomUtenteCaricamento;	
	private BigDecimal fkAllegato;
	
	

	public BigDecimal getFkAllegato() {
		return fkAllegato;
	}



	public void setFkAllegato(BigDecimal fkAllegato) {
		this.fkAllegato = fkAllegato;
	}



	public String getDenomUtenteCaricamento() {
		return denomUtenteCaricamento;
	}



	public void setDenomUtenteCaricamento(String denomUtenteCaricamento) {
		this.denomUtenteCaricamento = denomUtenteCaricamento;
	}



	public boolean isRicercaAutomatiche() {
		return ricercaAutomatiche;
	}



	public void setRicercaAutomatiche(boolean ricercaAutomatiche) {
		this.ricercaAutomatiche = ricercaAutomatiche;
	}



	public BigDecimal getIdValidatoreCaricamento() {
		return idValidatoreCaricamento;
	}



	public void setIdValidatoreCaricamento(BigDecimal idValidatoreCaricamento) {
		this.idValidatoreCaricamento = idValidatoreCaricamento;
	}



	public java.sql.Date getDataCreazioneDA() {
		return dataCreazioneDA;
	}



	public void setDataCreazioneDA(java.sql.Date dataCreazioneDA) {
		this.dataCreazioneDA = dataCreazioneDA;
	}



	public java.sql.Date getDataCreazioneA() {
		return dataCreazioneA;
	}



	public void setDataCreazioneA(java.sql.Date dataCreazioneA) {
		this.dataCreazioneA = dataCreazioneA;
	}



	public BigDecimal getIdTipoVerifica() {
		return idTipoVerifica;
	}



	public void setIdTipoVerifica(BigDecimal idTipoVerifica) {
		this.idTipoVerifica = idTipoVerifica;
	}




	public String getSiglaBollino() {
		return siglaBollino;
	}



	public void setSiglaBollino(String siglaBollino) {
		this.siglaBollino = siglaBollino;
	}



	public BigDecimal getIdDatoDistributore() {
		return idDatoDistributore;
	}



	public void setIdDatoDistributore(BigDecimal idDatoDistributore) {
		this.idDatoDistributore = idDatoDistributore;
	}
	

	public BigDecimal getIdVerifica() {
		return idVerifica;
	}



	public void setIdVerifica(BigDecimal idVerifica) {
		this.idVerifica = idVerifica;
	}



	public BigDecimal getCodiceImpianto() {
		return codiceImpianto;
	}



	public void setCodiceImpianto(BigDecimal codiceImpianto) {
		this.codiceImpianto = codiceImpianto;
	}



	public BigDecimal getNumeroBollino() {
		return numeroBollino;
	}



	public void setNumeroBollino(BigDecimal numeroBollino) {
		this.numeroBollino = numeroBollino;
	}



	public static RicercaVerificaFilter getByRicercaVerifica(RicercaVerifica resource) {
		if (resource == null) {
			return null;
		}
		
		RicercaVerificaFilter filter = new RicercaVerificaFilter();
		filter.setIdValidatoreCaricamento(ConvertUtil.convertToBigDecimal(resource.getIdValidatore()));
		filter.setCodiceImpianto(ConvertUtil.convertToBigDecimal(resource.getCodiceImpianto()));
		filter.setDataCreazioneA(ConvertUtil.convertToSqlDate(resource.getDataCreazioneA()));
		filter.setDataCreazioneDA(ConvertUtil.convertToSqlDate(resource.getDataCreazioneDA()));
		filter.setIdDatoDistributore(ConvertUtil.convertToBigDecimal(resource.getIdDatoDistributore()));
		filter.setIdVerifica(ConvertUtil.convertToBigDecimal(resource.getIdentificativo()));
		filter.setIdTipoVerifica(ConvertUtil.convertToBigDecimal(resource.getTipoVerifica()));
		filter.setNumeroBollino(ConvertUtil.convertToBigDecimal(resource.getNumeroBollino()));
		filter.setSiglaBollino(resource.getSiglaBollino());
		filter.setRicercaAutomatiche(resource.getCheckRicercaAutomatiche());
		
		return filter;
	}

}
