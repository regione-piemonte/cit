package it.csi.sigit.sigitext.dto.sigitext;

import java.io.Serializable;
import java.util.List;

public class SubentroComponente implements Serializable{

	private UtenteLoggato utenteLoggato;
	private List<Componente> componenti;
	
	public UtenteLoggato getUtenteLoggato() {
		return utenteLoggato;
	}
	public void setUtenteLoggato(UtenteLoggato utenteLoggato) {
		this.utenteLoggato = utenteLoggato;
	}
	public List<Componente> getComponenti() {
		return componenti;
	}
	public void setComponenti(List<Componente> componenti) {
		this.componenti = componenti;
	}
	
	
}
