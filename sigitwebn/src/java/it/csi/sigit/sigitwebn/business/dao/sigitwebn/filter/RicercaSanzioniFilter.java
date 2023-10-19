/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
package it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter;

import java.math.BigDecimal;

import it.csi.sigit.sigitwebn.dto.accertamento.RicercaAccertamento;
import it.csi.sigit.sigitwebn.dto.sanzioni.RicercaSanzioni;
import it.csi.sigit.sigitwebn.util.ConvertUtil;
import it.csi.sigit.sigitwebn.util.enumutil.SiNoEnum;

public class RicercaSanzioniFilter  implements java.io.Serializable {

	
	private BigDecimal identificativo;
	private String cfResponsabile;
	private java.sql.Date dataCreazioneDa;
	private java.sql.Date dataCreazioneA;
	private java.sql.Date dataComunicazioneDa;
	private java.sql.Date dataComunicazioneA;
	private java.sql.Date dataPagamentoA;
	private java.sql.Date dataPagamentoDa;
	private java.sql.Date dataAnnullamentoDa;
	private java.sql.Date dataAnnullamentoA;
	private BigDecimal valoreSanzioneDa;
	private BigDecimal valoreSanzioneA;
	private Integer fkStatoSanzione;
	private boolean associataAdAccertamento;
	private boolean associataAdIspezione;
	private String cfPFSanzionata;
	private String cfPGSanzionata;
	private String motivo;
	
	
	public BigDecimal getIdentificativo() {
		return identificativo;
	}
	public void setIdentificativo(BigDecimal identificativo) {
		this.identificativo = identificativo;
	}
	public String getCfResponsabile() {
		return cfResponsabile;
	}
	public void setCfResponsabile(String cfResponsabile) {
		this.cfResponsabile = cfResponsabile;
	}
	public java.sql.Date getDataCreazioneDa() {
		return dataCreazioneDa;
	}
	public void setDataCreazioneDa(java.sql.Date dataCreazioneDa) {
		this.dataCreazioneDa = dataCreazioneDa;
	}
	public java.sql.Date getDataCreazioneA() {
		return dataCreazioneA;
	}
	public void setDataCreazioneA(java.sql.Date dataCreazioneA) {
		this.dataCreazioneA = dataCreazioneA;
	}
	public java.sql.Date getDataComunicazioneDa() {
		return dataComunicazioneDa;
	}
	public void setDataComunicazioneDa(java.sql.Date dataComunicazioneDa) {
		this.dataComunicazioneDa = dataComunicazioneDa;
	}
	public java.sql.Date getDataComunicazioneA() {
		return dataComunicazioneA;
	}
	public void setDataComunicazioneA(java.sql.Date dataComunicazioneA) {
		this.dataComunicazioneA = dataComunicazioneA;
	}
	public java.sql.Date getDataPagamentoA() {
		return dataPagamentoA;
	}
	public void setDataPagamentoA(java.sql.Date dataPagamentoA) {
		this.dataPagamentoA = dataPagamentoA;
	}
	public java.sql.Date getDataPagamentoDa() {
		return dataPagamentoDa;
	}
	public void setDataPagamentoDa(java.sql.Date dataPagamentoDa) {
		this.dataPagamentoDa = dataPagamentoDa;
	}
	public java.sql.Date getDataAnnullamentoDa() {
		return dataAnnullamentoDa;
	}
	public void setDataAnnullamentoDa(java.sql.Date dataAnnullamentoDa) {
		this.dataAnnullamentoDa = dataAnnullamentoDa;
	}
	public java.sql.Date getDataAnnullamentoA() {
		return dataAnnullamentoA;
	}
	public void setDataAnnullamentoA(java.sql.Date dataAnnullamentoA) {
		this.dataAnnullamentoA = dataAnnullamentoA;
	}
	public BigDecimal getValoreSanzioneDa() {
		return valoreSanzioneDa;
	}
	public void setValoreSanzioneDa(BigDecimal valoreSanzioneDa) {
		this.valoreSanzioneDa = valoreSanzioneDa;
	}
	public BigDecimal getValoreSanzioneA() {
		return valoreSanzioneA;
	}
	public void setValoreSanzioneA(BigDecimal valoreSanzioneA) {
		this.valoreSanzioneA = valoreSanzioneA;
	}
	public Integer getFkStatoSanzione() {
		return fkStatoSanzione;
	}
	public void setFkStatoSanzione(Integer fkStatoSanzione) {
		this.fkStatoSanzione = fkStatoSanzione;
	}
	public boolean isAssociataAdAccertamento() {
		return associataAdAccertamento;
	}
	public void setAssociataAdAccertamento(boolean associataAdAccertamento) {
		this.associataAdAccertamento = associataAdAccertamento;
	}
	public boolean isAssociataAdIspezione() {
		return associataAdIspezione;
	}
	public void setAssociataAdIspezione(boolean associataAdIspezione) {
		this.associataAdIspezione = associataAdIspezione;
	}
	public String getCfPFSanzionata() {
		return cfPFSanzionata;
	}
	public void setCfPFSanzionata(String cfPFSanzionata) {
		this.cfPFSanzionata = cfPFSanzionata;
	}
	public String getCfPGSanzionata() {
		return cfPGSanzionata;
	}
	public void setCfPGSanzionata(String cfPGSanzionata) {
		this.cfPGSanzionata = cfPGSanzionata;
	}
	public String getMotivo() {
		return motivo;
	}
	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
	
	
	public static RicercaSanzioniFilter getByRicercaSanzioni(RicercaSanzioni resource) {
		if (resource == null) {
			return null;
		}
		
		RicercaSanzioniFilter filter = new RicercaSanzioniFilter();
		
		filter.setAssociataAdAccertamento(SiNoEnum.SI_1.getCodice().equals(resource.getAssociataAccertamento()));
		filter.setAssociataAdIspezione(SiNoEnum.SI_1.getCodice().equals(resource.getAssociataIspezione()));
		filter.setCfPFSanzionata(resource.getCfFisicaSanzionato());
		filter.setCfPGSanzionata(resource.getCfGiuridicaSanzionato());
		filter.setCfResponsabile(resource.getCfUtenteResponsabile());
		filter.setDataAnnullamentoA(ConvertUtil.convertToSqlDate(resource.getDataAnnullamentoA()));
		filter.setDataAnnullamentoDa(ConvertUtil.convertToSqlDate(resource.getDataAnnullamentoDa()));
		filter.setDataComunicazioneA(ConvertUtil.convertToSqlDate(resource.getDataComunicazioneA()));
		filter.setDataComunicazioneDa(ConvertUtil.convertToSqlDate(resource.getDataComunicazioneDa()));
		filter.setDataCreazioneA(ConvertUtil.convertToSqlDate(resource.getDataCreazioneA()));
		filter.setDataCreazioneDa(ConvertUtil.convertToSqlDate(resource.getDataCreazioneDa()));
		filter.setDataPagamentoA(ConvertUtil.convertToSqlDate(resource.getDataPagamentoA()));
		filter.setDataPagamentoDa(ConvertUtil.convertToSqlDate(resource.getDataPagamentoDa()));
		filter.setFkStatoSanzione(resource.getStato());
		filter.setIdentificativo(ConvertUtil.convertToBigDecimal(resource.getIdentificativo()));
		filter.setMotivo(resource.getMotivo());
		filter.setValoreSanzioneA(ConvertUtil.convertToBigDecimal(resource.getValoreA()));
		filter.setValoreSanzioneDa(ConvertUtil.convertToBigDecimal(resource.getValoreDa()));
		
		return filter;
	}
	
	
}
