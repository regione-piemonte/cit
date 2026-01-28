package it.csi.sigit.sigitext.dto.sigitext;

import java.io.Serializable;

public class UtenteLoggato implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PFLoggato pfLoggato;
	private RuoloLoggato ruoloLoggato;

	public UtenteLoggato(PFLoggato pfLoggato, RuoloLoggato ruoloLoggato) {
		this.pfLoggato = pfLoggato;
		this.ruoloLoggato = ruoloLoggato;
	}

	public UtenteLoggato() {
	}

	public PFLoggato getPfLoggato() {
		return pfLoggato;
	}

	public void setPfLoggato(PFLoggato pfLoggato) {
		this.pfLoggato = pfLoggato;
	}

	public RuoloLoggato getRuoloLoggato() {
		return ruoloLoggato;
	}

	public void setRuoloLoggato(RuoloLoggato ruoloLoggato) {
		this.ruoloLoggato = ruoloLoggato;
	}
}
