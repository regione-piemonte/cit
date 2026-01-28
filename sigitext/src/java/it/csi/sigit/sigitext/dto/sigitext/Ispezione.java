package it.csi.sigit.sigitext.dto.sigitext;

import java.io.Serializable;

public class Ispezione implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6928169192056024049L;
	
	private DatiIspezione datiIspezione;
	private UtenteLoggato utenteLoggato;
	public DatiIspezione getDatiIspezione() {
		return datiIspezione;
	}
	public void setDatiIspezione(DatiIspezione datiIspezione) {
		this.datiIspezione = datiIspezione;
	}
	public UtenteLoggato getUtenteLoggato() {
		return utenteLoggato;
	}
	public void setUtenteLoggato(UtenteLoggato utenteLoggato) {
		this.utenteLoggato = utenteLoggato;
	}
	@Override
	public String toString() {
		return "ConcludiIspezione [datiIspezione=" + datiIspezione + ", utenteLoggato=" + utenteLoggato + "]";
	}
	
	

}
