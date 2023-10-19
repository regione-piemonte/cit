/*
 *
 *  * ******************************************************************************
 *  *  SPDX-License-Identifier: EUPL-1.2
 *  *  Copyright Regione Piemonte - 2021
 *  * *****************************************************************************
 *
 */

package it.csi.citpwa.model.sigitext;

public class RuoloPG {

	static final long serialVersionUID = 1;

	private String piva = null;

	private Integer idPersonaGiuridica = null;

	public Integer getIdPersonaGiuridica() {
		return idPersonaGiuridica;
	}

	public void setIdPersonaGiuridica(Integer idPersonaGiuridica) {
		this.idPersonaGiuridica = idPersonaGiuridica;
	}

	public void setPiva(String val) {
		piva = val;
	}

	public String getPiva() {
		return piva;
	}

	private String siglaREA = null;

	public void setSiglaREA(String val) {
		siglaREA = val;
	}

	public String getSiglaREA() {
		return siglaREA;
	}

	private String numeroREA = null;

	public void setNumeroREA(String val) {
		numeroREA = val;
	}

	public String getNumeroREA() {
		return numeroREA;
	}

	private String denominazione = null;

	public void setDenominazione(String val) {
		denominazione = val;
	}

	public String getDenominazione() {
		return denominazione;
	}

	private java.util.Date dataCessazione = null;

	public void setDataCessazione(java.util.Date val) {
		dataCessazione = (val == null ? null : new java.util.Date(val.getTime()));
	}

	public java.util.Date getDataCessazione() {
		return (dataCessazione == null ? null : new java.util.Date(dataCessazione.getTime()));
	}

	private String ruoloPG = null;

	public void setRuoloPG(String val) {
		ruoloPG = val;
	}

	public String getRuoloPG() {
		return ruoloPG;
	}

	private Integer idStato = null;

	public void setIdStato(Integer val) {
		idStato = val;
	}

	public Integer getIdStato() {
		return idStato;
	}

	private String descStato = null;

	public void setDescStato(String val) {
		descStato = val;
	}

	public String getDescStato() {
		return descStato;
	}
}
