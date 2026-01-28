package it.csi.citpwa.model.sigitext;

import java.io.Serializable;
import java.util.Date;

public class DatiToken implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	
	private Integer id_persona_giuridica;
	private String denominazione;
	private String codice_fiscale;
	private String sigla_rea;
	private Integer numero_rea;
	private String token;
	private Date dt_creazione_token;
	private Date dt_scadenza_token;
	
	public Integer getId_persona_giuridica() {
		return id_persona_giuridica;
	}
	
	public void setId_persona_giuridica(Integer id_persona_giuridica) {
		this.id_persona_giuridica = id_persona_giuridica;
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

	public String getSigla_rea() {
		return sigla_rea;
	}

	public void setSigla_rea(String sigla_rea) {
		this.sigla_rea = sigla_rea;
	}

	public Integer getNumero_rea() {
		return numero_rea;
	}

	public void setNumero_rea(Integer numero_rea) {
		this.numero_rea = numero_rea;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Date getDt_creazione_token() {
		return dt_creazione_token;
	}

	public void setDt_creazione_token(Date dt_creazione_token) {
		this.dt_creazione_token = dt_creazione_token;
	}

	public Date getDt_scadenza_token() {
		return dt_scadenza_token;
	}

	public void setDt_scadenza_token(Date dt_scadenza_token) {
		this.dt_scadenza_token = dt_scadenza_token;
	}
	
}
