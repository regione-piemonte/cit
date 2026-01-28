package it.csi.sigit.sigitext.business.dao.sigitextdao.dto;

import java.math.BigDecimal;
import java.util.Date;

public class SigitTPersonaGiuridicaJoinSigitRPgPgNominaDto {
	
	private BigDecimal id_persona_giuridica_cat;
	private BigDecimal id_persona_giuridica_impresa;
	private String denominazione;
	private String codice_fiscale;
	private Date data_inizio;
	private Date data_fine;
	public BigDecimal getId_persona_giuridica_cat() {
		return id_persona_giuridica_cat;
	}
	public void setId_persona_giuridica_cat(BigDecimal id_persona_giuridica_cat) {
		this.id_persona_giuridica_cat = id_persona_giuridica_cat;
	}
	public BigDecimal getId_persona_giuridica_impresa() {
		return id_persona_giuridica_impresa;
	}
	public void setId_persona_giuridica_impresa(BigDecimal id_persona_giuridica_impresa) {
		this.id_persona_giuridica_impresa = id_persona_giuridica_impresa;
	}
	public String getDenominazione() {
		return denominazione;
	}
	public void setDenominazione(String denominazione) {
		this.denominazione = denominazione;
	}
	public String getCodice_fiscale() {
		return codice_fiscale;
	}
	public void setCodice_fiscale(String codice_fiscale) {
		this.codice_fiscale = codice_fiscale;
	}
	public Date getData_inizio() {
		return data_inizio;
	}
	public void setData_inizio(Date data_inizio) {
		this.data_inizio = data_inizio;
	}
	public Date getData_fine() {
		return data_fine;
	}
	public void setData_fine(Date data_fine) {
		this.data_fine = data_fine;
	}
	
	

}
