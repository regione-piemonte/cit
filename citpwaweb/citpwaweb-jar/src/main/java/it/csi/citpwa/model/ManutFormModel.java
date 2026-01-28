/*
 *
 *  * ******************************************************************************
 *  *  SPDX-License-Identifier: EUPL-1.2
 *  *  Copyright Regione Piemonte - 2021
 *  * *****************************************************************************
 *
 */

package it.csi.citpwa.model;

public class ManutFormModel {
	private String dataControllo;
	private String tipoControllo;
	private String tipoComponente;
	private String tipoIntervento;
	private String osservazioni;
	private String raccomandazioni;
	private String prescrizioni;
	private String prossimoInterventoEntro;
	private String nomeCognomeTecnico;
	private String oraArrivo;
	private String oraPartenza;

	private Integer progressivo;

	private String codiceFiscale;
	private String numeroRea;
	private String siglaRea;

	public ManutFormModel() {
		//Not implemented
	}

	public String getDataControllo() {
		return dataControllo;
	}

	public void setDataControllo(String dataControllo) {
		this.dataControllo = dataControllo;
	}

	public String getTipoControllo() {
		return tipoControllo;
	}

	public void setTipoControllo(String tipoControllo) {
		this.tipoControllo = tipoControllo;
	}

	public String getTipoComponente() {
		return tipoComponente;
	}

	public void setTipoComponente(String tipoComponente) {
		this.tipoComponente = tipoComponente;
	}

	public String getTipoIntervento() {
		return tipoIntervento;
	}

	public void setTipoIntervento(String tipoIntervento) {
		this.tipoIntervento = tipoIntervento;
	}

	public String getOsservazioni() {
		return osservazioni;
	}

	public void setOsservazioni(String osservazioni) {
		this.osservazioni = osservazioni;
	}

	public String getRaccomandazioni() {
		return raccomandazioni;
	}

	public void setRaccomandazioni(String raccomandazioni) {
		this.raccomandazioni = raccomandazioni;
	}

	public String getPrescrizioni() {
		return prescrizioni;
	}

	public void setPrescrizioni(String prescrizioni) {
		this.prescrizioni = prescrizioni;
	}

	public String getProssimoInterventoEntro() {
		return prossimoInterventoEntro;
	}

	public void setProssimoInterventoEntro(String prossimoInterventoEntro) {
		this.prossimoInterventoEntro = prossimoInterventoEntro;
	}

	public String getNomeCognomeTecnico() {
		return nomeCognomeTecnico;
	}

	public void setNomeCognomeTecnico(String nomeCognomeTecnico) {
		this.nomeCognomeTecnico = nomeCognomeTecnico;
	}

	public String getOraArrivo() {
		return oraArrivo;
	}

	public void setOraArrivo(String oraArrivo) {
		this.oraArrivo = oraArrivo;
	}

	public String getOraPartenza() {
		return oraPartenza;
	}

	public void setOraPartenza(String oraPartenza) {
		this.oraPartenza = oraPartenza;
	}

	public Integer getProgressivo() {
		return progressivo;
	}

	public void setProgressivo(Integer progressivo) {
		this.progressivo = progressivo;
	}

	public String getCodiceFiscale() {
		return codiceFiscale;
	}

	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}

	public String getNumeroRea() {
		return numeroRea;
	}

	public void setNumeroRea(String numeroRea) {
		this.numeroRea = numeroRea;
	}

	public String getSiglaRea() {
		return siglaRea;
	}

	public void setSiglaRea(String siglaRea) {
		this.siglaRea = siglaRea;
	}
}
