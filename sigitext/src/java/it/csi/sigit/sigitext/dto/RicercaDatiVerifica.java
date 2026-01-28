package it.csi.sigit.sigitext.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class RicercaDatiVerifica implements Serializable{
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BigDecimal idVerifica;
    private BigDecimal fkTipoVerifica;
    private BigDecimal fkAllegato;
    private BigDecimal fkDatoDistrib;
    private String codiceImpianto;
    private String cfUtenteCaricamento;
    private String denomUtenteCaricamento;
    private Date dtCaricamentoDa;
    private Date dtCaricamentoA;
    private String siglaRee;
    private String numeroRee;
    private Date dtVeglia;
    private String noteSveglia;
    private String note;
    
    private BigDecimal idValidatoreCaricamento;
    private boolean ricercaAutomatiche;
    
    
	public BigDecimal getIdVerifica() {
		return idVerifica;
	}
	public void setIdVerifica(BigDecimal idVerifica) {
		this.idVerifica = idVerifica;
	}
	
	public BigDecimal getFkTipoVerifica() {
		return fkTipoVerifica;
	}
	public void setFkTipoVerifica(BigDecimal fkTipoVerifica) {
		this.fkTipoVerifica = fkTipoVerifica;
	}
	public BigDecimal getFkAllegato() {
		return fkAllegato;
	}
	public void setFkAllegato(BigDecimal fkAllegato) {
		this.fkAllegato = fkAllegato;
	}
	public BigDecimal getFkDatoDistrib() {
		return fkDatoDistrib;
	}
	public void setFkDatoDistrib(BigDecimal fkDatoDistrib) {
		this.fkDatoDistrib = fkDatoDistrib;
	}
	public String getCodiceImpianto() {
		return codiceImpianto;
	}
	public void setCodiceImpianto(String codiceImpianto) {
		this.codiceImpianto = codiceImpianto;
	}
	public String getCfUtenteCaricamento() {
		return cfUtenteCaricamento;
	}
	public void setCfUtenteCaricamento(String cfUtenteCaricamento) {
		this.cfUtenteCaricamento = cfUtenteCaricamento;
	}
	public String getDenomUtenteCaricamento() {
		return denomUtenteCaricamento;
	}
	public void setDenomUtenteCaricamento(String denomUtenteCaricamento) {
		this.denomUtenteCaricamento = denomUtenteCaricamento;
	}
	public Date getDtCaricamentoDa() {
		return dtCaricamentoDa;
	}
	public void setDtCaricamentoDa(Date dtCaricamentoDa) {
		this.dtCaricamentoDa = dtCaricamentoDa;
	}
	public Date getDtCaricamentoA() {
		return dtCaricamentoA;
	}
	public void setDtCaricamentoA(Date dtCaricamentoA) {
		this.dtCaricamentoA = dtCaricamentoA;
	}	
	public String getSiglaRee() {
		return siglaRee;
	}
	public void setSiglaRee(String siglaRee) {
		this.siglaRee = siglaRee;
	}
	public String getNumeroRee() {
		return numeroRee;
	}
	public void setNumeroRee(String numeroRee) {
		this.numeroRee = numeroRee;
	}
	public Date getDtVeglia() {
		return dtVeglia;
	}
	public void setDtVeglia(Date dtVeglia) {
		this.dtVeglia = dtVeglia;
	}
	public String getNoteSveglia() {
		return noteSveglia;
	}
	public void setNoteSveglia(String noteSveglia) {
		this.noteSveglia = noteSveglia;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public BigDecimal getIdValidatoreCaricamento() {
		return idValidatoreCaricamento;
	}
	public void setIdValidatoreCaricamento(BigDecimal idValidatoreCaricamento) {
		this.idValidatoreCaricamento = idValidatoreCaricamento;
	}
	public boolean isRicercaAutomatiche() {
		return ricercaAutomatiche;
	}
	public void setRicercaAutomatiche(boolean ricercaAutomatiche) {
		this.ricercaAutomatiche = ricercaAutomatiche;
	}

    
}
