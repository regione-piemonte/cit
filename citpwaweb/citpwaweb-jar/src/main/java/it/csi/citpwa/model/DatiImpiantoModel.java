/*
 *
 *  * ******************************************************************************
 *  *  SPDX-License-Identifier: EUPL-1.2
 *  *  Copyright Regione Piemonte - 2021
 *  * *****************************************************************************
 *
 */

package it.csi.citpwa.model;

import java.util.Date;

public class DatiImpiantoModel {
	private String codiceImpianto;
	private String stato;
	private Date dataAssCi;
	private Date dataVar;
	private String motivazione;
	private String tipoImpianto;
	private Boolean flgApparevvUiExt;
	private Boolean flgContabilizzazione;
	private Boolean stradario;
	private String indirizzoSitad;
	private String indirizzoNonTrovato;
	private String comune;
	private String civico;
	private String provincia;
	private String pod;
	private String pdr;
	private Boolean flgNoPdr;
	private Boolean flgVisuProprietario;
	private Double coordX;
	private Double coordY;
	private String siglaProv;
	private String istatComune;

	public DatiImpiantoModel() {
	}

	public DatiImpiantoModel(String codiceImpianto, String stato, Date dataAssCi, String motivazione, String tipoImpianto, Boolean flgApparevvUiExt, Boolean flgContabilizzazione, Boolean stradario, String indirizzoSitad, String indirizzoNonTrovato, String comune, String civico, String provincia, String pod, String pdr, Boolean flgNoPdr, Boolean flgVisuProprietario, Double coordX, Double coordY, String siglaProv, String istatComune) {
		this.codiceImpianto = codiceImpianto;
		this.stato = stato;
		this.dataAssCi = dataAssCi;
		this.motivazione = motivazione;
		this.tipoImpianto = tipoImpianto;
		this.flgApparevvUiExt = flgApparevvUiExt;
		this.flgContabilizzazione = flgContabilizzazione;
		this.stradario = stradario;
		this.indirizzoSitad = indirizzoSitad;
		this.indirizzoNonTrovato = indirizzoNonTrovato;
		this.comune = comune;
		this.civico = civico;
		this.provincia = provincia;
		this.pod = pod;
		this.pdr = pdr;
		this.flgNoPdr = flgNoPdr;
		this.flgVisuProprietario = flgVisuProprietario;
		this.coordX = coordX;
		this.coordY = coordY;
		this.siglaProv = siglaProv;
		this.istatComune = istatComune;
	}

	public String getCodiceImpianto() {
		return codiceImpianto;
	}

	public void setCodiceImpianto(String codiceImpianto) {
		this.codiceImpianto = codiceImpianto;
	}

	public String getStato() {
		return stato;
	}

	public void setStato(String stato) {
		this.stato = stato;
	}

	public Date getDataAssCi() {
		return dataAssCi;
	}

	public void setDataAssCi(Date dataAssCi) {
		this.dataAssCi = dataAssCi;
	}

	public String getMotivazione() {
		return motivazione;
	}

	public void setMotivazione(String motivazione) {
		this.motivazione = motivazione;
	}

	public String getTipoImpianto() {
		return tipoImpianto;
	}

	public void setTipoImpianto(String tipoImpianto) {
		this.tipoImpianto = tipoImpianto;
	}

	public Boolean getFlgApparevvUiExt() {
		return flgApparevvUiExt;
	}

	public void setFlgApparevvUiExt(Boolean flgApparevvUiExt) {
		this.flgApparevvUiExt = flgApparevvUiExt;
	}

	public Boolean getFlgContabilizzazione() {
		return flgContabilizzazione;
	}

	public void setFlgContabilizzazione(Boolean flgContabilizzazione) {
		this.flgContabilizzazione = flgContabilizzazione;
	}

	public Boolean getStradario() {
		return stradario;
	}

	public void setStradario(Boolean stradario) {
		this.stradario = stradario;
	}

	public String getIndirizzoSitad() {
		return indirizzoSitad;
	}

	public void setIndirizzoSitad(String indirizzoSitad) {
		this.indirizzoSitad = indirizzoSitad;
	}

	public String getIndirizzoNonTrovato() {
		return indirizzoNonTrovato;
	}

	public void setIndirizzoNonTrovato(String indirizzoNonTrovato) {
		this.indirizzoNonTrovato = indirizzoNonTrovato;
	}

	public String getComune() {
		return comune;
	}

	public void setComune(String comune) {
		this.comune = comune;
	}

	public String getCivico() {
		return civico;
	}

	public void setCivico(String civico) {
		this.civico = civico;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getPod() {
		return pod;
	}

	public void setPod(String pod) {
		this.pod = pod;
	}

	public String getPdr() {
		return pdr;
	}

	public void setPdr(String pdr) {
		this.pdr = pdr;
	}

	public Boolean getFlgNoPdr() {
		return flgNoPdr;
	}

	public void setFlgNoPdr(Boolean flgNoPdr) {
		this.flgNoPdr = flgNoPdr;
	}

	public Boolean getFlgVisuProprietario() {
		return flgVisuProprietario;
	}

	public void setFlgVisuProprietario(Boolean flgVisuProprietario) {
		this.flgVisuProprietario = flgVisuProprietario;
	}

	public Double getCoordX() {
		return coordX;
	}

	public void setCoordX(Double coordX) {
		this.coordX = coordX;
	}

	public Double getCoordY() {
		return coordY;
	}

	public void setCoordY(Double coordY) {
		this.coordY = coordY;
	}

	public String getSiglaProv() {
		return siglaProv;
	}

	public void setSiglaProv(String siglaProv) {
		this.siglaProv = siglaProv;
	}

	public String getIstatComune() {
		return istatComune;
	}

	public void setIstatComune(String istatComune) {
		this.istatComune = istatComune;
	}

	public Date getDataVar() {
		return dataVar;
	}

	public void setDataVar(Date dataVar) {
		this.dataVar = dataVar;
	}

	@Override
	public String toString() {
		return "DatiImpiantoModel{" + "codiceImpianto='" + codiceImpianto + '\'' + ", stato='" + stato + '\'' + ", dataAssCi=" + dataAssCi + ", dataVar=" + dataVar + ", motivazione='" + motivazione
				+ '\'' + ", tipoImpianto='" + tipoImpianto + '\'' + ", flgApparevvUiExt=" + flgApparevvUiExt + ", flgContabilizzazione=" + flgContabilizzazione + ", stradario=" + stradario
				+ ", indirizzoSitad='" + indirizzoSitad + '\'' + ", indirizzoNonTrovato='" + indirizzoNonTrovato + '\'' + ", comune='" + comune + '\'' + ", civico='" + civico + '\'' + ", provincia='"
				+ provincia + '\'' + ", pod='" + pod + '\'' + ", pdr='" + pdr + '\'' + ", flgNoPdr=" + flgNoPdr + ", flgVisuProprietario=" + flgVisuProprietario + ", coordX=" + coordX + ", coordY="
				+ coordY + ", siglaProv='" + siglaProv + '\'' + ", istatComune='" + istatComune + '\'' + '}';
	}
}
