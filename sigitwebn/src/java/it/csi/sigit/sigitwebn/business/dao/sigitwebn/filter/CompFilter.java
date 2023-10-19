/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
package it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter;

import java.util.List;
import java.sql.Date;

public class CompFilter {

	private Integer idPG;
	private Integer idAllegato;
	private Date dataControllo;
	private String codImpianto;
	private String tipoComponente;
	private Date dataInstallazione;
	private List<String> listDateInstallazione;
	private String dateDismissione;
	private String progressivo;
	private Integer idRuolo;

	private List<String> listProgressivi;
	private List<String> listCombustibile;
	private List<String> listNotCombustibile;
	private List<String> listTipiComponente;
	
	public List<String> getListTipiComponente() {
		return listTipiComponente;
	}

	public void setListTipiComponente(List<String> listTipiComponente) {
		this.listTipiComponente = listTipiComponente;
	}
	private Boolean checkControllate;
	
	public Boolean getCheckControllate() {
		return checkControllate;
	}

	public void setCheckControllate(Boolean checkControllate) {
		this.checkControllate = checkControllate;
	}

	public CompFilter()
	{
		
	}
	
	public CompFilter(String codImpianto)
	{
		this.codImpianto = codImpianto;
	}
	
	public CompFilter(String codImpianto, String tipoComponente, List<String> listCombustibile, Date dataInstallazione)
	{
		this.codImpianto = codImpianto;
		this.tipoComponente = tipoComponente;
		this.listCombustibile = listCombustibile;
		this.dataInstallazione = dataInstallazione;
	}
	
	public CompFilter(String codImpianto, List<String> listProgressivi, Date dataInstallazione)
	{
		this.codImpianto = codImpianto;
		this.listProgressivi = listProgressivi;
		this.dataInstallazione = dataInstallazione;
	}

	public CompFilter(String codImpianto, String progressivo, Date dataInstallazione)
	{
		this.codImpianto = codImpianto;
		this.progressivo = progressivo;
		this.dataInstallazione = dataInstallazione;
	}

	public CompFilter(String codImpianto, String progressivo)
	{
		this.codImpianto = codImpianto;
		this.progressivo = progressivo;
	}
	
	public CompFilter(String codImpianto, String progressivo, String tipoComponente)
	{
		this.codImpianto = codImpianto;
		this.progressivo = progressivo;
		this.tipoComponente = tipoComponente;
	}
	
	public CompFilter(String codImpianto, String progressivo, Integer idAllegato)
	{
		this.codImpianto = codImpianto;
		this.progressivo = progressivo;
		this.idAllegato = idAllegato;
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
	public List<String> getListDateInstallazione() {
		return listDateInstallazione;
	}
	public void setListDateInstallazione(List<String> dateInstallazione) {
		this.listDateInstallazione = dateInstallazione;
	}
	public List<String> getListProgressivi() {
		return listProgressivi;
	}
	public void setListProgressivi(List<String> listProgressivi) {
		this.listProgressivi = listProgressivi;
	}
	public Date getDataInstallazione() {
		return dataInstallazione;
	}
	public void setDataInstallazione(Date dataInstallazione) {
		this.dataInstallazione = dataInstallazione;
	}
	public String getDateDismissione() {
		return dateDismissione;
	}
	public void setDateDismissione(String dateDismissione) {
		this.dateDismissione = dateDismissione;
	}
	public List<String> getListCombustibile() {
		return listCombustibile;
	}
	public void setListCombustibile(List<String> listCombustibile) {
		this.listCombustibile = listCombustibile;
	}
	public Integer getIdPG() {
		return idPG;
	}
	public void setIdPG(Integer idPG) {
		this.idPG = idPG;
	}
	
	public Integer getIdAllegato() {
		return idAllegato;
	}
	public void setIdAllegato(Integer idAllegato) {
		this.idAllegato = idAllegato;
	}
	public Integer getIdRuolo() {
		return idRuolo;
	}
	public void setIdRuolo(Integer idRuolo) {
		this.idRuolo = idRuolo;
	}

	public Date getDataControllo() {
		return dataControllo;
	}

	public void setDataControllo(Date dataControllo) {
		this.dataControllo = dataControllo;
	}

	public List<String> getListNotCombustibile() {
		return listNotCombustibile;
	}

	public void setListNotCombustibile(List<String> listNotCombustibile) {
		this.listNotCombustibile = listNotCombustibile;
	}
	
}
