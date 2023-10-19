/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
package it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter;

import java.util.ArrayList;
import java.util.List;

public class FiltroRicercaAllegati implements java.io.Serializable {

	/// Field [idStatoAllegato]
	private java.lang.Integer idStatoAllegato = null;
	
	/// Field [dataControlloDa]
	private java.lang.String dataControlloDa = null;
	
	/// Field [dataControlloA]
	private java.lang.String dataControlloA = null;
	
	/// Field [sicurezzaImpianti]
	private java.lang.Boolean sicurezzaImpianti = null;
	
	/// Field [conOsservazioni]
	private java.lang.Boolean conOsservazioni = null;

	/// Field [conRaccomandazioni]
	private java.lang.Boolean conRaccomandazioni = null;

	/// Field [conPrescrizioni]
	private java.lang.Boolean conPrescrizioni = null;

	
	/// Field [idBollinoSigla]
	private java.lang.String idBollinoSigla = null;
	
	/// Field [numeroBollino]
	private java.lang.Integer numeroBollino = null;
	
	/// Field [idTipoDocumento]
	private java.lang.Integer idTipoDocumento = null;
	private List<Integer> listaTipoDocumento = null;
	
	/// Field [idReaSigla]
	private java.lang.String idReaSigla = null;
	
	/// Field [numeroRea]
	private java.lang.Integer numeroRea = null;
	
	/// Field [codiceFiscale]
	private java.lang.String codiceFiscale = null;

	/// Field [interventoDa]
	private java.lang.String interventoDa = null;

	/// Field [interventoA]
	private java.lang.String interventoA = null;
	
	private Integer codiceImpianto;
	
	private String comuneImpianto = null;
	
	private String siglaProvImpianto = null;
	
	private String istatAbilitazione = null;

	/// Field [elencoCodiciImpianto]
	private java.util.ArrayList<java.lang.String> elencoCodiciImpianto = new java.util.ArrayList<java.lang.String>();

	
	/// Field [descrizioneRruoloFunzionale]
	private java.lang.String descrizioneRuoloFunzionale = null;



	public void setIdStatoAllegato(java.lang.Integer val) {
		idStatoAllegato = val;
	}

	
	public java.lang.Integer getIdStatoAllegato() {
		return idStatoAllegato;
	}

	
	public void setDataControlloDa(java.lang.String val) {
		dataControlloDa = val;
	}

	
	public java.lang.String getDataControlloDa() {
		return dataControlloDa;
	}


	public void setDataControlloA(java.lang.String val) {
		dataControlloA = val;
	}

	
	public java.lang.String getDataControlloA() {
		return dataControlloA;
	}

	public void setIdBollinoSigla(java.lang.String val) {
		idBollinoSigla = val;
	}

	
	public java.lang.String getIdBollinoSigla() {
		return idBollinoSigla;
	}


	public void setNumeroBollino(java.lang.Integer val) {
		numeroBollino = val;
	}

	
	public java.lang.Integer getNumeroBollino() {
		return numeroBollino;
	}

	public void setIdReaSigla(java.lang.String val) {
		idReaSigla = val;
	}

	
	public java.lang.String getIdReaSigla() {
		return idReaSigla;
	}


	public void setIdTipoDocumento(java.lang.Integer val) {
		idTipoDocumento = val;
	}

	
	public java.lang.Integer getIdTipoDocumento() {
		return idTipoDocumento;
	}

	public void setNumeroRea(
			java.lang.Integer val) {
		numeroRea = val;
	}

	
	public java.lang.Integer getNumeroRea() {
		return numeroRea;
	}

	
	

	public void setCodiceFiscale(java.lang.String val) {
		codiceFiscale = val;
	}

	
	public java.lang.String getCodiceFiscale() {
		return codiceFiscale;
	}

	
	

	public void setInterventoDa(java.lang.String val) {
		interventoDa = val;
	}

	
	public java.lang.String getInterventoDa() {
		return interventoDa;
	}

	

	public void setInterventoA(java.lang.String val) {
		interventoA = val;
	}

	
	public java.lang.String getInterventoA() {
		return interventoA;
	}

	

	public void setElencoCodiciImpianto(
			java.util.ArrayList<java.lang.String> val) {
		elencoCodiciImpianto = val;
	}

	
	public java.util.ArrayList<java.lang.String> getElencoCodiciImpianto() {
		return elencoCodiciImpianto;
	}


	public java.lang.String getDescrizioneRuoloFunzionale() {
		return descrizioneRuoloFunzionale;
	}


	public void setDescrizioneRuoloFunzionale(
			java.lang.String descrizioneRuoloFunzionale) {
		this.descrizioneRuoloFunzionale = descrizioneRuoloFunzionale;
	}


	public Integer getCodiceImpianto() {
		return codiceImpianto;
	}


	public void setCodiceImpianto(Integer codiceImpianto) {
		this.codiceImpianto = codiceImpianto;
	}


	public java.lang.Boolean getSicurezzaImpianti() {
		return sicurezzaImpianti;
	}


	public void setSicurezzaImpianti(java.lang.Boolean sicurezzaImpianti) {
		this.sicurezzaImpianti = sicurezzaImpianti;
	}


	public java.lang.Boolean getConOsservazioni() {
		return conOsservazioni;
	}


	public void setConOsservazioni(java.lang.Boolean conOsservazioni) {
		this.conOsservazioni = conOsservazioni;
	}


	public java.lang.Boolean getConRaccomandazioni() {
		return conRaccomandazioni;
	}


	public void setConRaccomandazioni(java.lang.Boolean conRaccomandazioni) {
		this.conRaccomandazioni = conRaccomandazioni;
	}


	public java.lang.Boolean getConPrescrizioni() {
		return conPrescrizioni;
	}


	public void setConPrescrizioni(java.lang.Boolean conPrescrizioni) {
		this.conPrescrizioni = conPrescrizioni;
	}


	public List<Integer> getListaTipoDocumento() {
		return listaTipoDocumento;
	}


	public void setListaTipoDocumento(List<Integer> listaTipoDocumento) {
		this.listaTipoDocumento = listaTipoDocumento;
	}


	public String getComuneImpianto() {
		return comuneImpianto;
	}


	public void setComuneImpianto(String comuneImpianto) {
		this.comuneImpianto = comuneImpianto;
	}


	public String getSiglaProvImpianto() {
		return siglaProvImpianto;
	}


	public void setSiglaProvImpianto(String siglaProvImpianto) {
		this.siglaProvImpianto = siglaProvImpianto;
	}


	public String getIstatAbilitazione() {
		return istatAbilitazione;
	}


	public void setIstatAbilitazione(String istatAbilitazione) {
		this.istatAbilitazione = istatAbilitazione;
	}
	
	

}
