/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
package it.csi.sigit.sigitext.business.dao.sigitextdao.dao.filter;

import java.math.BigDecimal;
import java.util.Date;

public class ContrattoFilter {

	private BigDecimal codiceImpianto;
	private BigDecimal idPersonaGiuridica3Responsabile;
	private Date dataDal;
	private Date dataAl;
	private boolean conTacitoRinnovo;
	private String idTipoComponente;
	private java.util.ArrayList<String> elencoComponenti = new java.util.ArrayList<String>();
	private String componente;
	
	
	public BigDecimal getCodiceImpianto() {
		return codiceImpianto;
	}
	public void setCodiceImpianto(BigDecimal codiceImpianto) {
		this.codiceImpianto = codiceImpianto;
	}
	public BigDecimal getIdPersonaGiuridica3Responsabile() {
		return idPersonaGiuridica3Responsabile;
	}
	public void setIdPersonaGiuridica3Responsabile(BigDecimal idPersonaGiuridica3Responsabile) {
		this.idPersonaGiuridica3Responsabile = idPersonaGiuridica3Responsabile;
	}
	public Date getDataDal() {
		return dataDal;
	}
	public void setDataDal(Date dataDal) {
		this.dataDal = dataDal;
	}
	public Date getDataAl() {
		return dataAl;
	}
	public void setDataAl(Date dataAl) {
		this.dataAl = dataAl;
	}
	public boolean isConTacitoRinnovo() {
		return conTacitoRinnovo;
	}
	public void setConTacitoRinnovo(boolean conTacitoRinnovo) {
		this.conTacitoRinnovo = conTacitoRinnovo;
	}
	
	public String getIdTipoComponente() {
		return idTipoComponente;
	}
	public void setIdTipoComponente(String idTipoComponente) {
		this.idTipoComponente = idTipoComponente;
	}
	public java.util.ArrayList<String> getElencoComponenti() {
		return elencoComponenti;
	}
	public void setElencoComponenti(
			java.util.ArrayList<String> elencoComponenti) {
		this.elencoComponenti = elencoComponenti;
	}
	
	public void addElencoComponenti(
			String componente) {
		this.elencoComponenti.add(componente);
	}
	public String getComponente() {
		return componente;
	}
	public void setComponente(String componente) {
		this.componente = componente;
	}
	
}