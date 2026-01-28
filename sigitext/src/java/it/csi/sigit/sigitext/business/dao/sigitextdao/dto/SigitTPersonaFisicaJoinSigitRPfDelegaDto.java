package it.csi.sigit.sigitext.business.dao.sigitextdao.dto;

import java.math.BigDecimal;
import java.util.Date;

public class SigitTPersonaFisicaJoinSigitRPfDelegaDto {
	
	private BigDecimal id_persona_fisica;
	private BigDecimal id_persona_giuridica;
	private String cognome;
	private String nome;
	private String codice_fiscale;
	private Date data_inizio;
	private String tipo_legame;
	
	
	public BigDecimal getId_persona_fisica() {
		return id_persona_fisica;
	}
	public void setId_persona_fisica(BigDecimal id_persona_fisica) {
		this.id_persona_fisica = id_persona_fisica;
	}
	public BigDecimal getId_persona_giuridica() {
		return id_persona_giuridica;
	}
	public void setId_persona_giuridica(BigDecimal id_persona_giuridica) {
		this.id_persona_giuridica = id_persona_giuridica;
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
	public String getTipo_legame() {
		return tipo_legame;
	}
	public void setTipo_legame(String tipo_legame) {
		this.tipo_legame = tipo_legame;
	}
	
	

}
