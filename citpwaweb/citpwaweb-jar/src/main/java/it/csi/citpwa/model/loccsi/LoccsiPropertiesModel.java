/*
 *
 *  * ******************************************************************************
 *  *  SPDX-License-Identifier: EUPL-1.2
 *  *  Copyright Regione Piemonte - 2021
 *  * *****************************************************************************
 *
 */

package it.csi.citpwa.model.loccsi;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class LoccsiPropertiesModel {
	private String codiceIstat;
	private String localita;
	private String cap;
	private String comune;
	private String loccsiLabel;
	private String civicoNum;
	private String nomeVia;
	private String civicoSub;
	private String tipoVia;
	private String pv;
	private String toponimo;
	private String preposizione;
	private String descProvincia;

	private String siglaProvincia;

	private String circoscrizione;

	@JsonCreator
	public LoccsiPropertiesModel(@JsonProperty("codice_istat") String codiceIstat, @JsonProperty("localita") String localita, @JsonProperty("cap") String cap, @JsonProperty("comune") String comune, @JsonProperty("loccsi_label") String loccsiLabel, @JsonProperty("civico_num") String civicoNum, @JsonProperty("nome_via") String nomeVia, @JsonProperty("civico_sub") String civicoSub, @JsonProperty("tipo_via") String tipoVia, @JsonProperty("pv") String pv, @JsonProperty("toponimo") String toponimo, @JsonProperty("preposizione") String preposizione, @JsonProperty("descrizione_provincia") String descProvincia, @JsonProperty("sigla_provincia") String siglaProvincia, @JsonProperty("circoscrizione") String circoscrizione) {
		this.codiceIstat = codiceIstat;
		this.localita = localita;
		this.cap = cap;
		this.comune = comune;
		this.loccsiLabel = loccsiLabel;
		this.civicoNum = civicoNum;
		this.nomeVia = nomeVia;
		this.civicoSub = civicoSub;
		this.tipoVia = tipoVia;
		this.pv = pv;
		this.toponimo = toponimo;
		this.preposizione = preposizione;
		this.descProvincia = descProvincia;
		this.siglaProvincia = siglaProvincia;
		this.circoscrizione = circoscrizione;
	}

	public LoccsiPropertiesModel() {
	}

	public String getPreposizione() {
		return preposizione;
	}

	public void setPreposizione(String preposizione) {
		this.preposizione = preposizione;
	}

	public String getPv() {
		return pv;
	}

	public void setPv(String pv) {
		this.pv = pv;
	}

	public String getToponimo() {
		return toponimo;
	}

	public void setToponimo(String toponimo) {
		this.toponimo = toponimo;
	}

	public String getCodiceIstat() {
		return codiceIstat;
	}

	public void setCodiceIstat(String codiceIstat) {
		this.codiceIstat = codiceIstat;
	}

	public String getLocalita() {
		return localita;
	}

	public void setLocalita(String localita) {
		this.localita = localita;
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

	public String getLoccsiLabel() {
		return loccsiLabel;
	}

	public void setLoccsiLabel(String loccsiLabel) {
		this.loccsiLabel = loccsiLabel;
	}

	public String getCivicoNum() {
		return civicoNum;
	}

	public void setCivicoNum(String civicoNum) {
		this.civicoNum = civicoNum;
	}

	public String getNomeVia() {
		return nomeVia;
	}

	public void setNomeVia(String nomeVia) {
		this.nomeVia = nomeVia;
	}

	public String getCivicoSub() {
		return civicoSub;
	}

	public void setCivicoSub(String civicoSub) {
		this.civicoSub = civicoSub;
	}

	public String getTipoVia() {
		return tipoVia;
	}

	public void setTipoVia(String tipoVia) {
		this.tipoVia = tipoVia;
	}

	public String getDescProvincia() {
		return descProvincia;
	}

	public void setDescProvincia(String descProvincia) {
		this.descProvincia = descProvincia;
	}

	public String getSiglaProvincia() {
		return siglaProvincia;
	}

	public void setSiglaProvincia(String siglaProvincia) {
		this.siglaProvincia = siglaProvincia;
	}

	public String getCircoscrizione() {
		return circoscrizione;
	}

	public void setCircoscrizione(String circoscrizione) {
		this.circoscrizione = circoscrizione;
	}

	@Override
	public String toString() {
		return "LoccsiPropertiesModel{" + "codiceIstat='" + codiceIstat + '\'' + ", localita='" + localita + '\'' + ", cap='" + cap + '\'' + ", comune='" + comune + '\'' + ", loccsiLabel='"
				+ loccsiLabel + '\'' + ", civicoNum='" + civicoNum + '\'' + ", nomeVia='" + nomeVia + '\'' + ", civicoSub='" + civicoSub + '\'' + ", tipoVia='" + tipoVia + '\'' + ", pv='" + pv + '\''
				+ ", toponimo='" + toponimo + '\'' + ", preposizione='" + preposizione + '\'' + ", descProvincia='" + descProvincia + '\'' + ", siglaProvincia='" + siglaProvincia + '\''
				+ ", circoscrizione='" + circoscrizione + '\'' + '}';
	}
}
