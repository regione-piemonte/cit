/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
package it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter;

import java.io.File;
import java.sql.Timestamp;


public class ImportDistribFilter extends ImportFileSuper{
	
	private Integer annoRiferimento;
	private Integer idImport;
	private Timestamp dataInizio;
	private Integer idPersonaGiuridica;
	private Integer idImportSostituzione;
	


	public Integer getAnnoRiferimento() {
		return annoRiferimento;
	}
	public void setAnnoRiferimento(Integer annoRiferimento) {
		this.annoRiferimento = annoRiferimento;
	}
	public Integer getIdImport() {
		return idImport;
	}
	public void setIdImport(Integer idImport) {
		this.idImport = idImport;
	}
	public Timestamp getDataInizio() {
		return dataInizio;
	}
	public void setDataInizio(Timestamp dataInizio) {
		this.dataInizio = dataInizio;
	}
	public Integer getIdPersonaGiuridica() {
		return idPersonaGiuridica;
	}
	public void setIdPersonaGiuridica(Integer idPersonaGiuridica) {
		this.idPersonaGiuridica = idPersonaGiuridica;
	}
	public Integer getIdImportSostituzione() {
		return idImportSostituzione;
	}
	public void setIdImportSostituzione(Integer idImportSostituzione) {
		this.idImportSostituzione = idImportSostituzione;
	}
	
	
}
