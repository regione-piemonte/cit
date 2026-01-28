package it.csi.sigit.sigitext.business.dao.sigitextdao.dto;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;

public class SigitRIspezIspetDto extends SigitRIspezIspetPk{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7137315959853416833L;
	BigDecimal fkRuolo;
	Date dataInizio;
	Date dataFine;
	BigDecimal fkPersonaFisica;
	BigDecimal fkPersonaGiuridica;
	Timestamp dataUltMod;
	String utenteUltMod;
	BigDecimal flgPrimoCaricatore;
	BigDecimal idIspezione2018;
	public BigDecimal getFkRuolo() {
		return fkRuolo;
	}
	public void setFkRuolo(BigDecimal fkRuolo) {
		this.fkRuolo = fkRuolo;
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
	public BigDecimal getFkPersonaFisica() {
		return fkPersonaFisica;
	}
	public void setFkPersonaFisica(BigDecimal fkPersonaFisica) {
		this.fkPersonaFisica = fkPersonaFisica;
	}
	public BigDecimal getFkPersonaGiuridica() {
		return fkPersonaGiuridica;
	}
	public void setFkPersonaGiuridica(BigDecimal fkPersonaGiuridica) {
		this.fkPersonaGiuridica = fkPersonaGiuridica;
	}
	public Timestamp getDataUltMod() {
		return dataUltMod;
	}
	public void setDataUltMod(Timestamp dataUltMod) {
		this.dataUltMod = dataUltMod;
	}
	public String getUtenteUltMod() {
		return utenteUltMod;
	}
	public void setUtenteUltMod(String utenteUltMod) {
		this.utenteUltMod = utenteUltMod;
	}
	public BigDecimal getFlgPrimoCaricatore() {
		return flgPrimoCaricatore;
	}
	public void setFlgPrimoCaricatore(BigDecimal flgPrimoCaricatore) {
		this.flgPrimoCaricatore = flgPrimoCaricatore;
	}
	public BigDecimal getIdIspezione2018() {
		return idIspezione2018;
	}
	public void setIdIspezione2018(BigDecimal idIspezione2018) {
		this.idIspezione2018 = idIspezione2018;
	}
	@Override
	public String toString() {
		return "SigitRIspezIspetDto [fkRuolo=" + fkRuolo + ", dataInizio=" + dataInizio + ", dataFine=" + dataFine
				+ ", fkPersonaFisica=" + fkPersonaFisica + ", fkPersonaGiuridica=" + fkPersonaGiuridica
				+ ", dataUltMod=" + dataUltMod + ", utenteUltMod=" + utenteUltMod + ", flgPrimoCaricatore="
				+ flgPrimoCaricatore + ", idIspezione2018=" + idIspezione2018 + "]";
	}
	
	
	
}
	
	