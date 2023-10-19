/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
package it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter;

import java.util.Date;

public class RicercaAvanzataImpiantoFilter extends ImpiantoFilter {
	
	private boolean ricercaAllegati;
	private boolean ricercaTerzoResp;
	private boolean ricercaComponenti;
	private boolean ricercaImpresa;
	
	private java.lang.String tipoRicerca = null;

	/**
	 * imposta il valore del campo [tipoRicerca]
	 * @param val
	 * @generated
	 */

	public void setTipoRicerca(java.lang.String val) {
		tipoRicerca = val;
	}

	/**
	 * legge il valore del campo [tipoRicerca]
	 * @generated
	 */
	public java.lang.String getTipoRicerca() {
		return tipoRicerca;
	}

	/// Field [tipoComponente]
	private java.lang.String tipoComponente = null;

	/**
	 * imposta il valore del campo [tipoComponente]
	 * @param val
	 * @generated
	 */

	public void setTipoComponente(java.lang.String val) {
		tipoComponente = val;
	}

	/**
	 * legge il valore del campo [tipoComponente]
	 * @generated
	 */
	public java.lang.String getTipoComponente() {
		return tipoComponente;
	}

	/// Field [flgDismesse]
	private java.lang.Boolean flgDismesse;

	/**
	 * imposta il valore del campo [flgDismesse]
	 * @param val
	 * @generated
	 */

	public void setFlgDismesse(java.lang.Boolean val) {
		flgDismesse = val;
	}

	/**
	 * legge il valore del campo [flgDismesse]
	 * @generated
	 */
	public java.lang.Boolean getFlgDismesse() {
		return flgDismesse;
	}

	/// Field [marca]
	private java.lang.String marca = null;

	/**
	 * imposta il valore del campo [marca]
	 * @param val
	 * @generated
	 */

	public void setMarca(java.lang.String val) {
		marca = val;
	}

	/**
	 * legge il valore del campo [marca]
	 * @generated
	 */
	public java.lang.String getMarca() {
		return marca;
	}

	/// Field [combustibile]
	private java.lang.String combustibile = null;

	private java.lang.Integer rendimentoPercDa = null;
	private java.lang.Integer rendimentoPercA = null;

	/**
	 * imposta il valore del campo [combustibile]
	 * @param val
	 * @generated
	 */

	public void setCombustibile(java.lang.String val) {
		combustibile = val;
	}

	/**
	 * legge il valore del campo [combustibile]
	 * @generated
	 */
	public java.lang.String getCombustibile() {
		return combustibile;
	}

	public void setRendimentoPercDa(java.lang.Integer val) {
		rendimentoPercDa = val;
	}

	public java.lang.Integer getRendimentoPercDa() {
		return rendimentoPercDa;
	}

	public void setRendimentoPercA(java.lang.Integer val) {
		rendimentoPercA = val;
	}

	public java.lang.Integer getRendimentoPercA() {
		return rendimentoPercA;
	}
	
	/// Field [potenzaTermicaDa]
	private java.lang.Integer potenzaTermicaDa = null;
	private java.lang.Integer potenzaTermicaA = null;


	private Date dataInstallazioneDa = null;
	private Date dataInstallazioneA = null;
	private Date dataControlloDa = null;
	private Date dataControlloA = null;

	/// Field [tipoRapporto]
	private java.lang.String tipoRapporto = null;

	/**
	 * imposta il valore del campo [tipoRapporto]
	 * @param val
	 * @generated
	 */

	public void setTipoRapporto(java.lang.String val) {
		tipoRapporto = val;
	}

	/**
	 * legge il valore del campo [tipoRapporto]
	 * @generated
	 */
	public java.lang.String getTipoRapporto() {
		return tipoRapporto;
	}

	private Date interventoManutentivoDa = null;
	private Date interventoManutentivoA = null;
	private Integer numGiorniInviatoDopoDataControllo;
	
	private java.lang.String siglaBollino = null;
	
	public Integer getNumGiorniInviatoDopoDataControllo() {
		return numGiorniInviatoDopoDataControllo;
	}

	public void setNumGiorniInviatoDopoDataControllo(Integer numGiorniInviatoDopoDataControllo) {
		this.numGiorniInviatoDopoDataControllo = numGiorniInviatoDopoDataControllo;
	}
	
	/// Field [siglaBollino]
	
	/**
	 * imposta il valore del campo [siglaBollino]
	 * @param val
	 * @generated
	 */

	public void setSiglaBollino(java.lang.String val) {
		siglaBollino = val;
	}

	/**
	 * legge il valore del campo [siglaBollino]
	 * @generated
	 */
	public java.lang.String getSiglaBollino() {
		return siglaBollino;
	}

	/// Field [numeroBollino]
	private java.lang.Integer numeroBollino = null;

	/**
	 * imposta il valore del campo [numeroBollino]
	 * @param val
	 * @generated
	 */

	public void setNumeroBollino(java.lang.Integer val) {
		numeroBollino = val;
	}

	/**
	 * legge il valore del campo [numeroBollino]
	 * @generated
	 */
	public java.lang.Integer getNumeroBollino() {
		return numeroBollino;
	}


	/// Field [sicurezzaImpianti]
	private java.lang.Boolean sicurezzaImpianti = null;

	/**
	 * imposta il valore del campo [sicurezzaImpianti]
	 * @param val
	 * @generated
	 */

	public void setSicurezzaImpianti(java.lang.Boolean val) {
		sicurezzaImpianti = val;
	}

	/**
	 * legge il valore del campo [sicurezzaImpianti]
	 * @generated
	 */
	public java.lang.Boolean getSicurezzaImpianti() {
		return sicurezzaImpianti;
	}

	/// Field [conPrescrizioni]
	private java.lang.Boolean conPrescrizioni = null;

	/**
	 * imposta il valore del campo [conPrescrizioni]
	 * @param val
	 * @generated
	 */

	public void setConPrescrizioni(java.lang.Boolean val) {
		conPrescrizioni = val;
	}

	/**
	 * legge il valore del campo [conPrescrizioni]
	 * @generated
	 */
	public java.lang.Boolean getConPrescrizioni() {
		return conPrescrizioni;
	}

	/// Field [conRaccomandazioni]
	private java.lang.Boolean conRaccomandazioni = null;

	/**
	 * imposta il valore del campo [conRaccomandazioni]
	 * @param val
	 * @generated
	 */

	public void setConRaccomandazioni(java.lang.Boolean val) {
		conRaccomandazioni = val;
	}

	/**
	 * legge il valore del campo [conRaccomandazioni]
	 * @generated
	 */
	public java.lang.Boolean getConRaccomandazioni() {
		return conRaccomandazioni;
	}

	/// Field [conOsservazioni]
	private java.lang.Boolean conOsservazioni = null;

	/**
	 * imposta il valore del campo [conOsservazioni]
	 * @param val
	 * @generated
	 */

	public void setConOsservazioni(java.lang.Boolean val) {
		conOsservazioni = val;
	}

	/**
	 * legge il valore del campo [conOsservazioni]
	 * @generated
	 */
	public java.lang.Boolean getConOsservazioni() {
		return conOsservazioni;
	}

	/// Field [cfTerzoResponsabile]
	private java.lang.String cfTerzoResponsabile = null;

	/**
	 * imposta il valore del campo [cfTerzoResponsabile]
	 * @param val
	 * @generated
	 */

	public void setCfTerzoResponsabile(java.lang.String val) {
		cfTerzoResponsabile = val;
	}

	/**
	 * legge il valore del campo [cfTerzoResponsabile]
	 * @generated
	 */
	public java.lang.String getCfTerzoResponsabile() {
		return cfTerzoResponsabile;
	}

	private java.lang.Boolean flgVerificaAssociata;

	private String unitaMisEnox = null;
	private Integer eNoxDa = null;
	private Integer eNoxA = null;

	private Integer ggInserimentoContratto = null;
	private Integer ggRevoca = null;

	private Date dataInizioContrattoDa = null;
	private Date dataInizioContrattoA = null;
	private Date dataFineContrattoDa = null;
	private Date dataFineContrattoA = null;

	public String toString() {
		/// inserire qui la logica desiderata per la rappresenatazione a stringa
		return super.toString();
	}

	public Date getDataInstallazioneDa() {
		return dataInstallazioneDa;
	}

	public void setDataInstallazioneDa(Date dataInstallazioneDa) {
		this.dataInstallazioneDa = dataInstallazioneDa;
	}

	public Date getDataInstallazioneA() {
		return dataInstallazioneA;
	}

	public void setDataInstallazioneA(Date dataInstallazioneA) {
		this.dataInstallazioneA = dataInstallazioneA;
	}

	public Date getDataControlloDa() {
		return dataControlloDa;
	}

	public void setDataControlloDa(Date dataControlloDa) {
		this.dataControlloDa = dataControlloDa;
	}

	public Date getDataControlloA() {
		return dataControlloA;
	}

	public void setDataControlloA(Date dataControlloA) {
		this.dataControlloA = dataControlloA;
	}

	public Date getInterventoManutentivoDa() {
		return interventoManutentivoDa;
	}

	public void setInterventoManutentivoDa(Date interventoManutentivoDa) {
		this.interventoManutentivoDa = interventoManutentivoDa;
	}

	public Date getInterventoManutentivoA() {
		return interventoManutentivoA;
	}

	public void setInterventoManutentivoA(Date interventoManutentivoA) {
		this.interventoManutentivoA = interventoManutentivoA;
	}
	
	public java.lang.Boolean getFlgVerificaAssociata() {
		return flgVerificaAssociata;
	}

	public void setFlgVerificaAssociata(java.lang.Boolean flgVerificaAssociata) {
		this.flgVerificaAssociata = flgVerificaAssociata;
	}

	public String getUnitaMisEnox() {
		return unitaMisEnox;
	}

	public void setUnitaMisEnox(String unitaMisEnox) {
		this.unitaMisEnox = unitaMisEnox;
	}

	
	public Integer geteNoxDa() {
		return eNoxDa;
	}

	public void seteNoxDa(Integer eNoxDa) {
		this.eNoxDa = eNoxDa;
	}

	public Integer geteNoxA() {
		return eNoxA;
	}

	public void seteNoxA(Integer eNoxA) {
		this.eNoxA = eNoxA;
	}

	public Integer getGgInserimentoContratto() {
		return ggInserimentoContratto;
	}

	public void setGgInserimentoContratto(Integer ggInserimentoContratto) {
		this.ggInserimentoContratto = ggInserimentoContratto;
	}

	public Integer getGgRevoca() {
		return ggRevoca;
	}

	public void setGgRevoca(Integer ggRevoca) {
		this.ggRevoca = ggRevoca;
	}

	public Date getDataInizioContrattoDa() {
		return dataInizioContrattoDa;
	}

	public void setDataInizioContrattoDa(Date dataInizioContrattoDa) {
		this.dataInizioContrattoDa = dataInizioContrattoDa;
	}

	public Date getDataInizioContrattoA() {
		return dataInizioContrattoA;
	}

	public void setDataInizioContrattoA(Date dataInizioContrattoA) {
		this.dataInizioContrattoA = dataInizioContrattoA;
	}

	public Date getDataFineContrattoDa() {
		return dataFineContrattoDa;
	}

	public void setDataFineContrattoDa(Date dataFineContrattoDa) {
		this.dataFineContrattoDa = dataFineContrattoDa;
	}

	public Date getDataFineContrattoA() {
		return dataFineContrattoA;
	}

	public void setDataFineContrattoA(Date dataFineContrattoA) {
		this.dataFineContrattoA = dataFineContrattoA;
	}

	public boolean isRicercaAllegati() {
		return ricercaAllegati;
	}

	public void setRicercaAllegati(boolean ricercaAllegati) {
		this.ricercaAllegati = ricercaAllegati;
	}

	public boolean isRicercaTerzoResp() {
		return ricercaTerzoResp;
	}

	public void setRicercaTerzoResp(boolean ricercaTerzoResp) {
		this.ricercaTerzoResp = ricercaTerzoResp;
	}

	public boolean isRicercaComponenti() {
		return ricercaComponenti;
	}

	public void setRicercaComponenti(boolean ricercaComponenti) {
		this.ricercaComponenti = ricercaComponenti;
	}

	public boolean isRicercaImpresa() {
		return ricercaImpresa;
	}

	public void setRicercaImpresa(boolean ricercaImpresa) {
		this.ricercaImpresa = ricercaImpresa;
	}

	public java.lang.Integer getPotenzaTermicaDa() {
		return potenzaTermicaDa;
	}

	public void setPotenzaTermicaDa(java.lang.Integer potenzaTermicaDa) {
		this.potenzaTermicaDa = potenzaTermicaDa;
	}

	public java.lang.Integer getPotenzaTermicaA() {
		return potenzaTermicaA;
	}

	public void setPotenzaTermicaA(java.lang.Integer potenzaTermicaA) {
		this.potenzaTermicaA = potenzaTermicaA;
	}
	
	private String sezione;
	private String particella;
	private String foglio;
	private String subalterno;

	public String getSezione() {
		return sezione;
	}

	public void setSezione(String sezione) {
		this.sezione = sezione;
	}

	public String getParticella() {
		return particella;
	}

	public void setParticella(String particella) {
		this.particella = particella;
	}

	public String getFoglio() {
		return foglio;
	}

	public void setFoglio(String foglio) {
		this.foglio = foglio;
	}

	public String getSubalterno() {
		return subalterno;
	}

	public void setSubalterno(String subalterno) {
		this.subalterno = subalterno;
	}

	private java.lang.Boolean senzaPdr;
	private java.lang.String statoImpianto;
	private java.lang.Integer potenzaAcsDa;
	private java.lang.Integer potenzaAcsA;
	private java.lang.Integer potenzaClimaEstDa;
	private java.lang.Integer potenzaClimaEstA;
	private java.lang.Integer potenzaClimaInvDa;
	private java.lang.Integer potenzaClimaInvA;

	public java.lang.Boolean getSenzaPdr() {
		return senzaPdr;
	}

	public void setSenzaPdr(java.lang.Boolean senzaPdr) {
		this.senzaPdr = senzaPdr;
	}

	public java.lang.String getStatoImpianto() {
		return statoImpianto;
	}

	public void setStatoImpianto(java.lang.String statoImpianto) {
		this.statoImpianto = statoImpianto;
	}

	public java.lang.Integer getPotenzaAcsDa() {
		return potenzaAcsDa;
	}

	public void setPotenzaAcsDa(java.lang.Integer potenzaAcsDa) {
		this.potenzaAcsDa = potenzaAcsDa;
	}

	public java.lang.Integer getPotenzaAcsA() {
		return potenzaAcsA;
	}

	public void setPotenzaAcsA(java.lang.Integer potenzaAcsA) {
		this.potenzaAcsA = potenzaAcsA;
	}

	public java.lang.Integer getPotenzaClimaEstDa() {
		return potenzaClimaEstDa;
	}

	public void setPotenzaClimaEstDa(java.lang.Integer potenzaClimaEstDa) {
		this.potenzaClimaEstDa = potenzaClimaEstDa;
	}

	public java.lang.Integer getPotenzaClimaEstA() {
		return potenzaClimaEstA;
	}

	public void setPotenzaClimaEstA(java.lang.Integer potenzaClimaEstA) {
		this.potenzaClimaEstA = potenzaClimaEstA;
	}

	public java.lang.Integer getPotenzaClimaInvDa() {
		return potenzaClimaInvDa;
	}

	public void setPotenzaClimaInvDa(java.lang.Integer potenzaClimaInvDa) {
		this.potenzaClimaInvDa = potenzaClimaInvDa;
	}

	public java.lang.Integer getPotenzaClimaInvA() {
		return potenzaClimaInvA;
	}

	public void setPotenzaClimaInvA(java.lang.Integer potenzaClimaInvA) {
		this.potenzaClimaInvA = potenzaClimaInvA;
	}
	
	private java.lang.String tipoImpianto;
	private java.lang.Boolean flgAppareccUiExt;
	private java.lang.Boolean flgContabilizzatore;

	
	private java.lang.Integer idTipoDocumento;
	private java.lang.Integer idIncaricato;

	public java.lang.String getTipoImpianto() {
		return tipoImpianto;
	}

	public void setTipoImpianto(java.lang.String tipoImpianto) {
		this.tipoImpianto = tipoImpianto;
	}

	public java.lang.Boolean getFlgAppareccUiExt() {
		return flgAppareccUiExt;
	}

	public void setFlgAppareccUiExt(java.lang.Boolean flgAppareccUiExt) {
		this.flgAppareccUiExt = flgAppareccUiExt;
	}

	public java.lang.Boolean getFlgContabilizzatore() {
		return flgContabilizzatore;
	}

	public void setFlgContabilizzatore(java.lang.Boolean flgContabilizzatore) {
		this.flgContabilizzatore = flgContabilizzatore;
	}

	public java.lang.Integer getIdTipoDocumento() {
		return idTipoDocumento;
	}

	public void setIdTipoDocumento(java.lang.Integer idTipoDocumento) {
		this.idTipoDocumento = idTipoDocumento;
	}

	public java.lang.Integer getIdIncaricato() {
		return idIncaricato;
	}

	public void setIdIncaricato(java.lang.Integer idIncaricato) {
		this.idIncaricato = idIncaricato;
	}
}
