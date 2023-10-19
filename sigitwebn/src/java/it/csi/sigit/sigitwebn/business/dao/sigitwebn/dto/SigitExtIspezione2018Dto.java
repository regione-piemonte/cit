/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;

public class SigitExtIspezione2018Dto implements Serializable{
	
//	isp.ID_ISPEZIONE_2018, 
//	pers.NOME, pers.COGNOME, pers.CODICE_FISCALE, 
//	isp.CF_ISPETTORE_SECONDARIO, isp.DT_CREAZIONE, 
//	isp.FK_STATO_ISPEZIONE, isp.CODICE_IMPIANTO, isp.FLG_ESITO
	
	private BigDecimal idIspezione2018;
	private String cfIspettoreSecondario;
	private Date dataCreazione;
	private BigDecimal statoIspezione;
	private BigDecimal codiceImpianto;
	private BigDecimal flgEsito;
	private String enteCompetente;
	private String note;

	private String nomeIspettore;
	private String cognomeIspettore;
	private String cfIspettore;
	
	
	public BigDecimal getIdIspezione2018() {
		return idIspezione2018;
	}
	public void setIdIspezione2018(BigDecimal idIspezione2018) {
		this.idIspezione2018 = idIspezione2018;
	}
	public String getCfIspettoreSecondario() {
		return cfIspettoreSecondario;
	}
	public void setCfIspettoreSecondario(String cfIspettoreSecondario) {
		this.cfIspettoreSecondario = cfIspettoreSecondario;
	}
	public Date getDataCreazione() {
		return dataCreazione;
	}
	public void setDataCreazione(Date dataCreazione) {
		this.dataCreazione = dataCreazione;
	}
	public BigDecimal getStatoIspezione() {
		return statoIspezione;
	}
	public void setStatoIspezione(BigDecimal statoIspezione) {
		this.statoIspezione = statoIspezione;
	}
	public BigDecimal getCodiceImpianto() {
		return codiceImpianto;
	}
	public void setCodiceImpianto(BigDecimal codiceImpianto) {
		this.codiceImpianto = codiceImpianto;
	}
	public BigDecimal getFlgEsito() {
		return flgEsito;
	}
	public void setFlgEsito(BigDecimal flgEsito) {
		this.flgEsito = flgEsito;
	}
	public String getNomeIspettore() {
		return nomeIspettore;
	}
	public void setNomeIspettore(String nomeIspettore) {
		this.nomeIspettore = nomeIspettore;
	}
	public String getCognomeIspettore() {
		return cognomeIspettore;
	}
	public void setCognomeIspettore(String cognomeIspettore) {
		this.cognomeIspettore = cognomeIspettore;
	}
	public String getCfIspettore() {
		return cfIspettore;
	}
	public void setCfIspettore(String cfIspettore) {
		this.cfIspettore = cfIspettore;
	}
	public String getEnteCompetente() {
		return enteCompetente;
	}
	public void setEnteCompetente(String enteCompetente) {
		this.enteCompetente = enteCompetente;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	
	
	
	
	

	
}
