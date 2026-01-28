/*
 *
 *  * ******************************************************************************
 *  *  SPDX-License-Identifier: EUPL-1.2
 *  *  Copyright Regione Piemonte - 2021
 *  * *****************************************************************************
 *
 */

package it.csi.sigit.sigitext.dto;

public class ComuneEstesoModel {

	private Long id;
	private String cap;
	private String codiceIstat;
	private String comune;
	
	private Long idProvincia;
	private String siglaProvincia;
	private String provincia;
	
	public ComuneEstesoModel() {
	}

	public ComuneEstesoModel(Long id, String cap, String codiceIstat, String comune, Long idProvincia, String siglaProvincia, String provincia) {
		super();
		this.id = id;
		this.cap = cap;
		this.codiceIstat = codiceIstat;
		
		this.idProvincia = idProvincia;
		this.comune = comune;
		this.siglaProvincia = siglaProvincia;
		this.provincia = provincia;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCap() {
		return cap;
	}

	public void setCap(String cap) {
		this.cap = cap;
	}

	public String getCodiceIstat() {
		return codiceIstat;
	}

	public void setCodiceIstat(String codiceIstat) {
		this.codiceIstat = codiceIstat;
	}

	public String getComune() {
		return comune;
	}

	public void setComune(String comune) {
		this.comune = comune;
	}

	public Long getIdProvincia() {
		return idProvincia;
	}

	public void setIdProvincia(Long idProvincia) {
		this.idProvincia = idProvincia;
	}

	public String getSiglaProvincia() {
		return siglaProvincia;
	}

	public void setSiglaProvincia(String siglaProvincia) {
		this.siglaProvincia = siglaProvincia;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	@Override
	public String toString() {
		return "ComuneEstesoModel [id=" + id + ", cap=" + cap + ", codiceIstat=" + codiceIstat + ", comune=" + comune
				+ ", idProvincia=" + idProvincia + ", siglaProvincia=" + siglaProvincia + ", provincia=" + provincia
				+ "]";
	}

}
