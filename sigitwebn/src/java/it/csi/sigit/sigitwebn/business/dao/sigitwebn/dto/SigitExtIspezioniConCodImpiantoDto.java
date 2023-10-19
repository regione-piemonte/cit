/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Data transfer object relativo al DAO SigitVRicercaImpiantiDao.
 * @generated
 */
public class SigitExtIspezioniConCodImpiantoDto implements Serializable {

	private static final long serialVersionUID = 1L;

	protected java.math.BigDecimal codiceImpianto;

	protected String ruolo;

	protected java.math.BigDecimal idResponsabile;

	protected String cognomeDenominazione;

	protected String nome;

	protected String codiceFiscale;

	protected String indirizzo;

	protected String civico;

	protected String cap;

	protected String comune;

	protected String provincia;

	protected String email;

	protected String siglaRea;

	protected java.math.BigDecimal numeroRea;

	public java.math.BigDecimal getCodiceImpianto() {
		return codiceImpianto;
	}

	public void setCodiceImpianto(java.math.BigDecimal codiceImpianto) {
		this.codiceImpianto = codiceImpianto;
	}

	public String getRuolo() {
		return ruolo;
	}

	public void setRuolo(String ruolo) {
		this.ruolo = ruolo;
	}

	public java.math.BigDecimal getIdResponsabile() {
		return idResponsabile;
	}

	public void setIdResponsabile(java.math.BigDecimal idResponsabile) {
		this.idResponsabile = idResponsabile;
	}

	public String getCognomeDenominazione() {
		return cognomeDenominazione;
	}

	public void setCognomeDenominazione(String cognomeDenominazione) {
		this.cognomeDenominazione = cognomeDenominazione;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCodiceFiscale() {
		return codiceFiscale;
	}

	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public String getCivico() {
		return civico;
	}

	public void setCivico(String civico) {
		this.civico = civico;
	}

	public String getCap() {
		return cap;
	}

	public void setCap(String cap) {
		this.cap = cap;
	}

	public String getComune() {
		return comune;
	}

	public void setComune(String comune) {
		this.comune = comune;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSiglaRea() {
		return siglaRea;
	}

	public void setSiglaRea(String siglaRea) {
		this.siglaRea = siglaRea;
	}

	public java.math.BigDecimal getNumeroRea() {
		return numeroRea;
	}

	public void setNumeroRea(java.math.BigDecimal numeroRea) {
		this.numeroRea = numeroRea;
	}

	
}
