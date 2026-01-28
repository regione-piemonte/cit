package it.csi.citpwa.model.sigitext;

import java.io.Serializable;

public class IncarichiSoggettiDelegatiResponse implements Serializable {
	
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer idPersonaGiuridica;
	private String denominazione;
	
	public Integer getIdPersonaGiuridica() {
		return idPersonaGiuridica;
	}
	public void setIdPersonaGiuridica(Integer idPersonaGiuridica) {
		this.idPersonaGiuridica = idPersonaGiuridica;
	}
	public String getDenominazione() {
		return denominazione;
	}
	public void setDenominazione(String denominazione) {
		this.denominazione = denominazione;
	}
}
