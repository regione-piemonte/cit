/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
package it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter;

import java.io.File;
import java.sql.Timestamp;


public class ImportFileSuper {
	
	private File  file;
	private String nomeFile;
	private String nomeFileMod;
	private String uidIndex;
	private String contentType;
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
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
	
	
	
	
	
}
