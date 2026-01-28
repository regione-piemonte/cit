/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
package it.csi.sigit.combustypwabff.model.sigitext;

import java.sql.Timestamp;


public class SigitextDataFile {
	
	private byte[] file;
	private String nomeFile;
	private String nomeFileMod;
	private String uidIndex;
	private String contentType;

	private Integer annoRiferimento;
	private Integer idImport;
	private Timestamp dataInizio;
	private Integer idPersonaGiuridica;
	private Integer idImportSostituzione;
	


	public byte[] getFile() {
		return file;
	}
	public void setFile(byte[] file) {
		this.file = file;
	}
	public String getNomeFile() {
		return nomeFile;
	}
	public void setNomeFile(String nomeFile) {
		this.nomeFile = nomeFile;
	}
	public String getNomeFileMod() {
		return nomeFileMod;
	}
	public void setNomeFileMod(String nomeFileMod) {
		this.nomeFileMod = nomeFileMod;
	}
	public String getUidIndex() {
		return uidIndex;
	}
	public void setUidIndex(String uidIndex) {
		this.uidIndex = uidIndex;
	}
	public String getContentType() {
		return contentType;
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
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
