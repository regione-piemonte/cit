package it.csi.citpwa.model.sigitext;

public class RespPropModel {
	private Persona persona;
	private String codiceImpianto;
	private UtenteLoggato utenteLoggato;

	public RespPropModel(Persona persona, String codiceImpianto, UtenteLoggato utenteLoggato) {
		this.persona = persona;
		this.codiceImpianto = codiceImpianto;
		this.utenteLoggato = utenteLoggato;
	}

	public RespPropModel() {
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public String getCodiceImpianto() {
		return codiceImpianto;
	}

	public void setCodiceImpianto(String codiceImpianto) {
		this.codiceImpianto = codiceImpianto;
	}

	public UtenteLoggato getUtenteLoggato() {
		return utenteLoggato;
	}

	public void setUtenteLoggato(UtenteLoggato utenteLoggato) {
		this.utenteLoggato = utenteLoggato;
	}

	@Override
	public String toString() {
		return "RespPropModel{" + "persona=" + persona + ", codiceImpianto='" + codiceImpianto + '\'' + ", utenteLoggato=" + utenteLoggato + '}';
	}
}
