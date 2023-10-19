package it.csi.sigit.sigitext.business.dao.sigitextdao.dao.filter;

import it.csi.sigit.sigitext.business.util.ConvertUtil;
import it.csi.sigit.sigitext.dto.RicercaAccertamento;

import java.math.BigDecimal;

public class RicercaAccertamentoFilter implements java.io.Serializable {

	private BigDecimal idAccertamento;
	private BigDecimal idValidatoreCaricamento;
	private java.sql.Date dataCreazioneDA;
	private java.sql.Date dataCreazioneA;
	private java.sql.Date dataConclusioneDA;
	private java.sql.Date dataConclusioneA;
	private BigDecimal codiceImpianto;
	private BigDecimal idStatoAccertamento;
	private BigDecimal idTipoAnomalia;
	private BigDecimal idTipoConclusione;
	private Boolean flgNonAssegnato;
	private String istatProvincia;
	private BigDecimal idVerifica;
	private  String istatComune;

	public BigDecimal getIdAccertamento() {
		return idAccertamento;
	}
	public void setIdAccertamento(BigDecimal idAccertamento) {
		this.idAccertamento = idAccertamento;
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
	public BigDecimal getCodiceImpianto() {
		return codiceImpianto;
	}
	public void setCodiceImpianto(BigDecimal codiceImpianto) {
		this.codiceImpianto = codiceImpianto;
	}
	public BigDecimal getIdStatoAccertamento() {
		return idStatoAccertamento;
	}
	public void setIdStatoAccertamento(BigDecimal idStatoAccertamento) {
		this.idStatoAccertamento = idStatoAccertamento;
	}
	public BigDecimal getIdTipoAnomalia() {
		return idTipoAnomalia;
	}
	public void setIdTipoAnomalia(BigDecimal idTipoAnomalia) {
		this.idTipoAnomalia = idTipoAnomalia;
	}
	public BigDecimal getIdTipoConclusione() {
		return idTipoConclusione;
	}
	public void setIdTipoConclusione(BigDecimal idTipoConclusione) {
		this.idTipoConclusione = idTipoConclusione;
	}
	public Boolean isFlgNonAssegnato() {
		return flgNonAssegnato;
	}
	public void setFlgNonAssegnato(Boolean flgNonAssegnato) {
		this.flgNonAssegnato = flgNonAssegnato;
	}
	public String getIstatProvincia() {
		return istatProvincia;
	}
	public void setIstatProvincia(String istatProvincia) {
		this.istatProvincia = istatProvincia;
	}
	public Boolean getFlgNonAssegnato() {return flgNonAssegnato; }
	public String getIstatComune() { return istatComune; }
	public void setIstatComune(String istatComune) { this.istatComune = istatComune; }
	public BigDecimal getIdVerifica() {
		return idVerifica;
	}
	public void setIdVerifica(BigDecimal idVerifica) {
		this.idVerifica = idVerifica;
	}
	public static RicercaAccertamentoFilter getByRicercaAccertamento(RicercaAccertamento resource) {
		if (resource == null) {
			return null;
		}
		
		RicercaAccertamentoFilter filter = new RicercaAccertamentoFilter();
		filter.setIdAccertamento(ConvertUtil.convertToBigDecimal(resource.getIdentificativo()));
		filter.setIdValidatoreCaricamento(ConvertUtil.convertToBigDecimal(resource.getIdValidatore()));
		filter.setDataCreazioneA(ConvertUtil.convertToSqlDate(resource.getDataCreazioneA()));
		filter.setDataCreazioneDA(ConvertUtil.convertToSqlDate(resource.getDataCreazioneDA()));
		filter.setDataConclusioneA(ConvertUtil.convertToSqlDate(resource.getDataConclusioneA()));
		filter.setDataConclusioneDA(ConvertUtil.convertToSqlDate(resource.getDataConclusioneDA()));
		filter.setCodiceImpianto(ConvertUtil.convertToBigDecimal(resource.getCodiceImpianto()));
		filter.setIdStatoAccertamento(ConvertUtil.convertToBigDecimal(resource.getIdStatoAccertamento()));
		filter.setIdTipoAnomalia(ConvertUtil.convertToBigDecimal(resource.getIdTipoAnomalia()));
		filter.setIdTipoConclusione(ConvertUtil.convertToBigDecimal(resource.getIdTipoConclusione()));
		filter.setFlgNonAssegnato(resource.getFlgNonAssegnato());
		filter.setIstatProvincia(resource.getIstatProvincia());
		filter.setIstatComune(resource.getIstatComune());
		
		return filter;
	}
}
