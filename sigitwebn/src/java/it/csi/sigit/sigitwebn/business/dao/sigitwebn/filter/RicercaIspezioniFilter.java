/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
package it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter;

import java.math.BigDecimal;
import java.util.Date;

import it.csi.sigit.sigitwebn.dto.ispezioni.RicercaIspezioni2018;
import it.csi.sigit.sigitwebn.dto.verifica.RicercaVerifica;
import it.csi.sigit.sigitwebn.util.ConvertUtil;
import it.csi.sigit.sigitwebn.util.GenericUtil;

public class RicercaIspezioniFilter implements java.io.Serializable {
	
	

	private BigDecimal identificativoIspezione;
	private Integer idIspettore;
	private java.sql.Date dataCreazioneDA;
	private java.sql.Date dataCreazioneA;
	private java.sql.Date dataConclusioneDA;
	private java.sql.Date dataConclusioneA;
	private Integer idStatoIspezione;
	private BigDecimal flagEsitoIspezione;
	private BigDecimal codiceImpianto;
	private boolean flagNonAssegnato;
	private String istatProvincia;
	private String istatComune;
	private boolean flagIspPagamento;
	
	


	public BigDecimal getIdentificativoIspezione() {
		return identificativoIspezione;
	}





	public void setIdentificativoIspezione(BigDecimal identificativoIspezione) {
		this.identificativoIspezione = identificativoIspezione;
	}





	public Integer getIdIspettore() {
		return idIspettore;
	}





	public void setIdIspettore(Integer idIspettore) {
		this.idIspettore = idIspettore;
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





	public java.sql.Date getDataConclusioneDA() {
		return dataConclusioneDA;
	}





	public void setDataConclusioneDA(java.sql.Date dataConclusioneDA) {
		this.dataConclusioneDA = dataConclusioneDA;
	}





	public java.sql.Date getDataConclusioneA() {
		return dataConclusioneA;
	}





	public void setDataConclusioneA(java.sql.Date dataConclusioneA) {
		this.dataConclusioneA = dataConclusioneA;
	}





	public Integer getIdStatoIspezione() {
		return idStatoIspezione;
	}





	public void setIdStatoIspezione(Integer idStatoIspezione) {
		this.idStatoIspezione = idStatoIspezione;
	}



	public BigDecimal getCodiceImpianto() {
		return codiceImpianto;
	}





	public void setCodiceImpianto(BigDecimal codiceImpianto) {
		this.codiceImpianto = codiceImpianto;
	}



	public BigDecimal getFlagEsitoIspezione() {
		return flagEsitoIspezione;
	}





	public void setFlagEsitoIspezione(BigDecimal flagEsitoIspezione) {
		this.flagEsitoIspezione = flagEsitoIspezione;
	}






	public boolean isFlagNonAssegnato() {
		return flagNonAssegnato;
	}





	public void setFlagNonAssegnato(boolean flagNonAssegnato) {
		this.flagNonAssegnato = flagNonAssegnato;
	}





	public String getIstatProvincia() {
		return istatProvincia;
	}





	public void setIstatProvincia(String istatProvincia) {
		this.istatProvincia = istatProvincia;
	}


	public String getIstatComune() {
		return istatComune;
	}


	public void setIstatComune(String istatComune) {
		this.istatComune = istatComune;
	}

	public boolean isFlagIspPagamento() {
		return flagIspPagamento;
	}





	public void setFlagIspPagamento(boolean flagIspPagamento) {
		this.flagIspPagamento = flagIspPagamento;
	}





	public static RicercaIspezioniFilter getByRicercaIspezione2018(RicercaIspezioni2018 resource) {
		if (resource == null) {
			return null;
		}
		
		RicercaIspezioniFilter filter = new RicercaIspezioniFilter();
		filter.setIdIspettore(resource.getIdIspettore());
		filter.setCodiceImpianto(ConvertUtil.convertToBigDecimal(resource.getCodiceImpianto()));
		filter.setDataConclusioneA(ConvertUtil.convertToSqlDate(resource.getDataConclusioneA()));
		filter.setDataConclusioneDA(ConvertUtil.convertToSqlDate(resource.getDataConclusioneDa()));
		filter.setDataCreazioneA(ConvertUtil.convertToSqlDate(resource.getDataCreazioneA()));
		filter.setDataCreazioneDA(ConvertUtil.convertToSqlDate(resource.getDataCreazioneDa()));
		filter.setFlagNonAssegnato(resource.getFlgNonAssegnato() != null && resource.getFlgNonAssegnato());
		filter.setFlagEsitoIspezione(ConvertUtil.convertToBigDecimal(resource.getFlgEsitoIspezione()));
		filter.setIdentificativoIspezione(ConvertUtil.convertToBigDecimal(resource.getIdentificativoIspezione()));
		filter.setIdStatoIspezione(resource.getIdStatoIspezione());
		filter.setIstatProvincia(resource.getIstatProvincia());
		filter.setIstatComune(resource.getIstatComune());
		filter.setFlagIspPagamento(resource.getFlgIspPagamento() != null && resource.getFlgIspPagamento());
		
		
		return filter;
	}

}
