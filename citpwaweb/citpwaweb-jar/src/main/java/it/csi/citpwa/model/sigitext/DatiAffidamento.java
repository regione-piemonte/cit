package it.csi.citpwa.model.sigitext;

import java.io.Serializable;

public class DatiAffidamento implements Serializable {
	
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	
	private String idTipoComponente;
	private Integer progressivo;
	private String denominazione;
	private String codiceFiscale;
	private String siglaRea;
	private Integer numeroRea;
	
	
	public String getIdTipoComponente() {
		return idTipoComponente;
	}
	public void setIdTipoComponente(String idTipoComponente) {
		this.idTipoComponente = idTipoComponente;
	}
	public Integer getProgressivo() {
		return progressivo;
	}
	public void setProgressivo(Integer progressivo) {
		this.progressivo = progressivo;
	}
	public String getDenominazione() {
		return denominazione;
	}
	public void setDenominazione(String denominazione) {
		this.denominazione = denominazione;
	}
	public String getCodiceFiscale() {
		return codiceFiscale;
	}
	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}
	public String getSiglaRea() {
		return siglaRea;
	}
	public void setSiglaRea(String siglaRea) {
		this.siglaRea = siglaRea;
	}
	public Integer getNumeroRea() {
		return numeroRea;
	}
	public void setNumeroRea(Integer numeroRea) {
		this.numeroRea = numeroRea;
	}
	
	
	
}
