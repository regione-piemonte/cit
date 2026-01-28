package it.csi.sigit.sigitext.dto.sigitext;

import java.io.Serializable;
import java.util.Date;

public class DatiDelega implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer id_persona_fisica;
	private Integer id_persona_giuridic;
	private String cognome;
	private String nome;
	private String codice_fiscale;
	private Date data_inizio_legame;
	private String tipo_legame;
	
	
	public Integer getId_persona_fisica() {
		return id_persona_fisica;
	}
	public void setId_persona_fisica(Integer id_persona_fisica) {
		this.id_persona_fisica = id_persona_fisica;
	}
	public Integer getId_persona_giuridic() {
		return id_persona_giuridic;
	}
	public void setId_persona_giuridic(Integer id_persona_giuridic) {
		this.id_persona_giuridic = id_persona_giuridic;
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
	public Date getData_inizio_legame() {
		return data_inizio_legame;
	}
	public void setData_inizio_legame(Date data_inizio_legame) {
		this.data_inizio_legame = data_inizio_legame;
	}
	public String getTipo_legame() {
		return tipo_legame;
	}
	public void setTipo_legame(String tipo_legame) {
		this.tipo_legame = tipo_legame;
	}
	
	

}
