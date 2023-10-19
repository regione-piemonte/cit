package it.csi.citpwa.model.sigitext;

public class UtenteLoggato {
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
