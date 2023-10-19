/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
package it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.filter;

import java.sql.Date;
import java.util.List;

public class CompFilter {

	private String codImpianto;
	private String tipoComponente;
	private Date dataInstallazione;
	private String progressivo;
	private List<String> listProgressivi;
	private Integer idRuolo;
	private Integer idPersonaGiuridica;
	
	public CompFilter()
	{
		
	}
	
	public CompFilter(String codImpianto, List<String> listProgressivi, Date dataInstallazione)
	{
		this.codImpianto = codImpianto;
		this.listProgressivi = listProgressivi;
		this.dataInstallazione = dataInstallazione;
	}
	
	public CompFilter(String codImpianto, Date dataInstallazione, Integer idPersonaGiuridica)
	{
		this.codImpianto = codImpianto;
		this.dataInstallazione = dataInstallazione;
		this.idPersonaGiuridica = idPersonaGiuridica;
	}
	
	public String getTipoComponente() {
		return tipoComponente;
	}
	public void setTipoComponente(String tipoComponente) {
		this.tipoComponente = tipoComponente;
	}
	public String getProgressivo() {
		return progressivo;
	}
	public void setProgressivo(String progressivo) {
		this.progressivo = progressivo;
	}
	public String getCodImpianto() {
		return codImpianto;
	}
	public void setCodImpianto(String codImpianto) {
		this.codImpianto = codImpianto;
	}
	public Date getDataInstallazione() {
		return dataInstallazione;
	}
	public void setDataInstallazione(Date dataInstallazione) {
		this.dataInstallazione = dataInstallazione;
	}
	public List<String> getListProgressivi() {
		return listProgressivi;
	}
	public void setListProgressivi(List<String> listProgressivi) {
		this.listProgressivi = listProgressivi;
	}
	public Integer getIdRuolo() {
		return idRuolo;
	}
	public void setIdRuolo(Integer idRuolo) {
		this.idRuolo = idRuolo;
	}
	public Integer getIdPersonaGiuridica() {
		return idPersonaGiuridica;
	}
	public void setIdPersonaGiuridica(Integer idPersonaGiuridica) {
		this.idPersonaGiuridica = idPersonaGiuridica;
	}
	
}
