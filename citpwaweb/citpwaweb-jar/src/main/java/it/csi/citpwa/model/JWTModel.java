/*
 *
 *  * ******************************************************************************
 *  *  SPDX-License-Identifier: EUPL-1.2
 *  *  Copyright Regione Piemonte - 2021
 *  * *****************************************************************************
 *
 */

package it.csi.citpwa.model;

import it.csi.citpwa.model.enums.JWTUserEnum;

import java.util.Date;

public class JWTModel {
	private String issuer = "CSI Piemonte";
	// codice rea della PG loggata oppure stringa 'INTERNO' (default)
	private String subject = "INTERNO";
	private String idPg;
	private String codApplFruitore ;
	private String codFiscalePf ;
	private JWTUserEnum userType;
	private String token;
	private Date dtCreazioneToken;
	private Date dtScadenzaToken;

	public JWTModel(JWTUserEnum userType) {
		this.userType = userType;
	}

	public String getIssuer() {
		return issuer;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getIdPg() {
		return idPg;
	}

	public void setIdPg(String idPg) {
		this.idPg = idPg;
	}

	public String getCodApplFruitore() {
		return codApplFruitore;
	}

	public void setCodApplFruitore(String codApplFruitore) {
		this.codApplFruitore = codApplFruitore;
	}

	public String getCodFiscalePf() {
		return codFiscalePf;
	}

	public void setCodFiscalePf(String codFiscalePf) {
		this.codFiscalePf = codFiscalePf;
	}

	public JWTUserEnum getUserType() {
		return userType;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Date getDtCreazioneToken() {
		return dtCreazioneToken;
	}

	public void setDtCreazioneToken(Date dtCreazioneToken) {
		this.dtCreazioneToken = dtCreazioneToken;
	}

	public Date getDtScadenzaToken() {
		return dtScadenzaToken;
	}

	public void setDtScadenzaToken(Date dtScadenzaToken) {
		this.dtScadenzaToken = dtScadenzaToken;
	}

	@Override
	public String toString() {
		return "JWTDto [issuer=" + issuer + ", subject=" + subject + ", idPg=" + idPg + ", codApplFruitore="
				+ codApplFruitore + ", codFiscalePf=" + codFiscalePf + ", userType=" + userType + "]";
	}
}
