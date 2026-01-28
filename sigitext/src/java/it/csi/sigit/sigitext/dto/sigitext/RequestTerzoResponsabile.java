package it.csi.sigit.sigitext.dto.sigitext;

import java.io.Serializable;
import java.util.List;

public class RequestTerzoResponsabile implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private DatiImpianto datiImpianto;
	private UtenteLoggato utenteLoggato;
	private DatiContratto datiContratto;
	private List<Autodichiarazione> autodichiarazioni;
	private DatiImpresa datiImpresa;
	
	
	public DatiImpianto getDatiImpianto() {
		return datiImpianto;
	}
	public void setDatiImpianto(DatiImpianto datiImpianto) {
		this.datiImpianto = datiImpianto;
	}
	public UtenteLoggato getUtenteLoggato() {
		return utenteLoggato;
	}
	public void setUtenteLoggato(UtenteLoggato utenteLoggato) {
		this.utenteLoggato = utenteLoggato;
	}
	public DatiContratto getDatiContratto() {
		return datiContratto;
	}
	public void setDatiContratto(DatiContratto datiContratto) {
		this.datiContratto = datiContratto;
	}
	public List<Autodichiarazione> getAutodichiarazioni() {
		return autodichiarazioni;
	}
	public void setAutodichiarazioni(List<Autodichiarazione> autodichiarazioni) {
		this.autodichiarazioni = autodichiarazioni;
	}
	public DatiImpresa getDatiImpresa() {
		return datiImpresa;
	}
	public void setDatiImpresa(DatiImpresa datiImpresa) {
		this.datiImpresa = datiImpresa;
	}
	
	
}
