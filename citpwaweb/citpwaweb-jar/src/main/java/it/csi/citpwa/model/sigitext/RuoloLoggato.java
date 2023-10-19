/*
 *
 *  * ******************************************************************************
 *  *  SPDX-License-Identifier: EUPL-1.2
 *  *  Copyright Regione Piemonte - 2021
 *  * *****************************************************************************
 *
 */

package it.csi.citpwa.model.sigitext;

import java.util.Date;

public class RuoloLoggato {
	private String ruolo;
	private String piva;
	private String siglaRea;
	private String numeroRea;
	private String denominazione;
	private Date dataCessazione;
	private Integer idStato;
	private String descStato;
	private String istatAbilitazione;
	private String descrAbilitazione;

	private Integer idPersonaGiuridica;
	private Boolean isCat;

	public RuoloLoggato(String ruolo, String piva, String siglaRea, String numeroRea, String denominazione, Date dataCessazione, Integer idStato, String descStato, String istatAbilitazione, String descrAbilitazione,Integer idPersonaGiuridica) {
		this.ruolo = ruolo;
		this.piva = piva;
		this.siglaRea = siglaRea;
		this.numeroRea = numeroRea;
		this.denominazione = denominazione;
		this.dataCessazione = dataCessazione;
		this.idStato = idStato;
		this.descStato = descStato;
		this.istatAbilitazione = istatAbilitazione;
		this.descrAbilitazione = descrAbilitazione;
		this.idPersonaGiuridica = idPersonaGiuridica;
	}

	public RuoloLoggato() {
	}

	public String getRuolo() {
		return ruolo;
	}

	public void setRuolo(String ruolo) {
		this.ruolo = ruolo;
	}

	public String getPiva() {
		return piva;
	}

	public void setPiva(String piva) {
		this.piva = piva;
	}

	public String getSiglaRea() {
		return siglaRea;
	}

	public void setSiglaRea(String siglaRea) {
		this.siglaRea = siglaRea;
	}

	public String getNumeroRea() {
		return numeroRea;
	}

	public void setNumeroRea(String numeroRea) {
		this.numeroRea = numeroRea;
	}

	public String getDenominazione() {
		return denominazione;
	}

	public void setDenominazione(String denominazione) {
		this.denominazione = denominazione;
	}

	public Date getDataCessazione() {
		return dataCessazione;
	}

	public void setDataCessazione(Date dataCessazione) {
		this.dataCessazione = dataCessazione;
	}

	public Integer getIdStato() {
		return idStato;
	}

	public void setIdStato(Integer idStato) {
		this.idStato = idStato;
	}

	public String getDescStato() {
		return descStato;
	}

	public void setDescStato(String descStato) {
		this.descStato = descStato;
	}

	public String getIstatAbilitazione() {
		return istatAbilitazione;
	}

	public void setIstatAbilitazione(String istatAbilitazione) {
		this.istatAbilitazione = istatAbilitazione;
	}

	public String getDescrAbilitazione() {
		return descrAbilitazione;
	}

	public void setDescrAbilitazione(String descrAbilitazione) {
		this.descrAbilitazione = descrAbilitazione;
	}

	public Integer getIdPersonaGiuridica() {
		return idPersonaGiuridica;
	}

	public void setIdPersonaGiuridica(Integer idPersonaGiuridica) {
		this.idPersonaGiuridica = idPersonaGiuridica;
	}

	public Boolean getCat() {
		return isCat;
	}

	public void setCat(Boolean cat) {
		isCat = cat;
	}
}
