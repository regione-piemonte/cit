/*
 *
 *  * ******************************************************************************
 *  *  SPDX-License-Identifier: EUPL-1.2
 *  *  Copyright Regione Piemonte - 2021
 *  * *****************************************************************************
 *
 */

package it.csi.sigit.sigitext.dto.sigitext;

import java.io.Serializable;
import java.util.Date;

public class DatiImpianto  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String codiceImpianto;
	private String stato;
	private Date dataVar;
	private String motivazione;
	private String tipoImpianto;
	private Integer flgApparevvUiExt;
	private Integer flgContabilizzazione;
	private Integer stradario;
	private String indirizzoSitad;
	private String indirizzoNonTrovato;
	private String comune;
	private String civico;
	private String provincia;
	private String pod;
	private String pdr;
	private Integer flgNoPdr;
	private Integer flgVisuProprietario;
	private Double coordX;
	private Double coordY;
	private String siglaProv;
	private String istatComune;
	private Integer flgMedioimpianto;

	public DatiImpianto() {
	}

	public DatiImpianto(String codiceImpianto, String stato, String motivazione, String tipoImpianto, Integer flgApparevvUiExt, Integer flgContabilizzazione, Integer stradario, String indirizzoSitad, String indirizzoNonTrovato, String comune, String civico, String provincia, String pod, String pdr, Integer flgNoPdr, Integer flgVisuProprietario, Double coordX, Double coordY, String siglaProv, String istatComune, Integer flgMedioimpianto) {
		this.codiceImpianto = codiceImpianto;
		this.stato = stato;
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
		this.setFlgMedioimpianto(flgMedioimpianto);
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

	public Integer getFlgApparevvUiExt() {
		return flgApparevvUiExt;
	}

	public void setFlgApparevvUiExt(Integer flgApparevvUiExt) {
		this.flgApparevvUiExt = flgApparevvUiExt;
	}

	public Integer getFlgContabilizzazione() {
		return flgContabilizzazione;
	}

	public void setFlgContabilizzazione(Integer flgContabilizzazione) {
		this.flgContabilizzazione = flgContabilizzazione;
	}

	public Integer getStradario() {
		return stradario;
	}

	public void setStradario(Integer stradario) {
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

	public Integer getFlgNoPdr() {
		return flgNoPdr;
	}

	public void setFlgNoPdr(Integer flgNoPdr) {
		this.flgNoPdr = flgNoPdr;
	}

	public Integer getFlgVisuProprietario() {
		return flgVisuProprietario;
	}

	public void setFlgVisuProprietario(Integer flgVisuProprietario) {
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

	public Integer getFlgMedioimpianto() {
		return flgMedioimpianto;
	}

	public void setFlgMedioimpianto(Integer flgMedioimpianto) {
		this.flgMedioimpianto = flgMedioimpianto;
	}

	public Date getDataVar() {
		return dataVar;
	}

	public void setDataVar(Date dataVar) {
		this.dataVar = dataVar;
	}

	@Override
	public String toString() {
		return "DatiImpianto{" + "codiceImpianto='" + codiceImpianto + '\'' + ", stato='" + stato + '\'' + ", dataVar=" + dataVar + ", motivazione='" + motivazione + '\''
				+ ", tipoImpianto='" + tipoImpianto + '\'' + ", flgApparevvUiExt=" + flgApparevvUiExt + ", flgContabilizzazione=" + flgContabilizzazione + ", stradario=" + stradario
				+ ", indirizzoSitad='" + indirizzoSitad + '\'' + ", indirizzoNonTrovato='" + indirizzoNonTrovato + '\'' + ", comune='" + comune + '\'' + ", civico='" + civico + '\'' + ", provincia='"
				+ provincia + '\'' + ", pod='" + pod + '\'' + ", pdr='" + pdr + '\'' + ", flgNoPdr=" + flgNoPdr + ", flgVisuProprietario=" + flgVisuProprietario + ", coordX=" + coordX + ", coordY="
				+ coordY + ", siglaProv='" + siglaProv + '\'' + ", istatComune='" + istatComune + '\'' + ", flgMedioimpianto=" + flgMedioimpianto + '}';
	}
}
