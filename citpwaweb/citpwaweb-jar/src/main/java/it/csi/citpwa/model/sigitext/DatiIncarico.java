package it.csi.citpwa.model.sigitext;

import java.io.Serializable;
import java.util.Date;

public class DatiIncarico implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer id_persona_giuridica_cat;
	private Integer id_persona_giuridica_impresa;
	private String denominazione;
	private String codice_fiscale;
	private Date data_inizio_legame;
	private Date data_fine_legame;
	public Integer getId_persona_giuridica_cat() {
		return id_persona_giuridica_cat;
	}
	public void setId_persona_giuridica_cat(Integer id_persona_giuridica_cat) {
		this.id_persona_giuridica_cat = id_persona_giuridica_cat;
	}
	public Integer getId_persona_giuridica_impresa() {
		return id_persona_giuridica_impresa;
	}
	public void setId_persona_giuridica_impresa(Integer id_persona_giuridica_impresa) {
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
	public Date getData_inizio_legame() {
		return data_inizio_legame;
	}
	public void setData_inizio_legame(Date data_inizio_legame) {
		this.data_inizio_legame = data_inizio_legame;
	}
	public Date getData_fine_legame() {
		return data_fine_legame;
	}
	public void setData_fine_legame(Date data_fine_legame) {
		this.data_fine_legame = data_fine_legame;
	}
}
