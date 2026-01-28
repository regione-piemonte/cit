package it.csi.sigit.sigitext.dto.sigitext;

import java.io.Serializable;

public class AssegnaIspezione implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -639529891222413417L;
	private UtenteLoggato utenteLoggato;
	private Persona persona;
	
	public UtenteLoggato getUtenteLoggato() {
		return utenteLoggato;
	}
	public void setUtenteLoggato(UtenteLoggato utenteLoggato) {
		this.utenteLoggato = utenteLoggato;
	}
	public Persona getPersona() {
		return persona;
	}
	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	@Override
	public String toString() {
		return "AssegnaIspezione [utenteLoggato=" + utenteLoggato + ", persona=" + persona + "]";
	}
	
	

}
