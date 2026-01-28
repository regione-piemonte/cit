/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
package it.csi.sigit.sigitext.business.dao.sigitextdao.dto;

import java.io.Serializable;
import java.util.*;

/**
 * Data transfer object relativo al DAO SigitVRicercaImpiantiDao.
 * @generated
 */
public class SigitExtIspezioniDto implements Serializable {

	private static final long serialVersionUID = 1L;

	protected Integer idIspezione2018;

	protected java.math.BigDecimal codiceImpianto;

	protected String desStatoIspezione;

	protected java.sql.Timestamp dtCreazione;

	protected java.math.BigDecimal flgEsito;

	protected String cognome;

	protected String nome;
	
	protected String codiceFiscale;
	
	protected String istatProvCompetenza;

	protected String cfIspettoreSecondario;

	protected java.math.BigDecimal flgIspPagamento;

	protected String indirizzoUnitaImmob;
	
	protected String civico;
	
	protected String denominazioneComune;
	
	protected String siglaProvincia;

	protected java.math.BigDecimal l13PotH2oKw;

	protected java.math.BigDecimal l13PotClimaInvKw;

	protected java.math.BigDecimal l13PotClimaEstKw;

	public Integer getIdIspezione2018() {
		return idIspezione2018;
	}

	public void setIdIspezione2018(Integer idIspezione2018) {
		this.idIspezione2018 = idIspezione2018;
	}

	public java.math.BigDecimal getCodiceImpianto() {
		return codiceImpianto;
	}

	public void setCodiceImpianto(java.math.BigDecimal codiceImpianto) {
		this.codiceImpianto = codiceImpianto;
	}

	public String getDesStatoIspezione() {
		return desStatoIspezione;
	}

	public void setDesStatoIspezione(String desStatoIspezione) {
		this.desStatoIspezione = desStatoIspezione;
	}

	public java.sql.Timestamp getDtCreazione() {
		return dtCreazione;
	}

	public void setDtCreazione(java.sql.Timestamp dtCreazione) {
		this.dtCreazione = dtCreazione;
	}

	public java.math.BigDecimal getFlgEsito() {
		return flgEsito;
	}

	public void setFlgEsito(java.math.BigDecimal flgEsito) {
		this.flgEsito = flgEsito;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCodiceFiscale() {
		return codiceFiscale;
	}

	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}

	public String getIstatProvCompetenza() {
		return istatProvCompetenza;
	}

	public void setIstatProvCompetenza(String istatProvCompetenza) {
		this.istatProvCompetenza = istatProvCompetenza;
	}

	public String getCfIspettoreSecondario() {
		return cfIspettoreSecondario;
	}

	public void setCfIspettoreSecondario(String cfIspettoreSecondario) {
		this.cfIspettoreSecondario = cfIspettoreSecondario;
	}

	public java.math.BigDecimal getFlgIspPagamento() {
		return flgIspPagamento;
	}

	public void setFlgIspPagamento(java.math.BigDecimal flgIspPagamento) {
		this.flgIspPagamento = flgIspPagamento;
	}

	public String getIndirizzoUnitaImmob() {
		return indirizzoUnitaImmob;
	}

	public void setIndirizzoUnitaImmob(String indirizzoUnitaImmob) {
		this.indirizzoUnitaImmob = indirizzoUnitaImmob;
	}

	public String getCivico() {
		return civico;
	}

	public void setCivico(String civico) {
		this.civico = civico;
	}

	public String getDenominazioneComune() {
		return denominazioneComune;
	}

	public void setDenominazioneComune(String denominazioneComune) {
		this.denominazioneComune = denominazioneComune;
	}

	public String getSiglaProvincia() {
		return siglaProvincia;
	}

	public void setSiglaProvincia(String siglaProvincia) {
		this.siglaProvincia = siglaProvincia;
	}

	public java.math.BigDecimal getL13PotH2oKw() {
		return l13PotH2oKw;
	}

	public void setL13PotH2oKw(java.math.BigDecimal l13PotH2oKw) {
		this.l13PotH2oKw = l13PotH2oKw;
	}

	public java.math.BigDecimal getL13PotClimaInvKw() {
		return l13PotClimaInvKw;
	}

	public void setL13PotClimaInvKw(java.math.BigDecimal l13PotClimaInvKw) {
		this.l13PotClimaInvKw = l13PotClimaInvKw;
	}

	public java.math.BigDecimal getL13PotClimaEstKw() {
		return l13PotClimaEstKw;
	}

	public void setL13PotClimaEstKw(java.math.BigDecimal l13PotClimaEstKw) {
		this.l13PotClimaEstKw = l13PotClimaEstKw;
	}


	
}
