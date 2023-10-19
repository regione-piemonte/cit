/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
package it.csi.sigit.sigitwebn.dto.index;

public class DettaglioDocumento {
	
	private static final long serialVersionUID = -6978966528394781758L;
	
	private String nomeDocumento = null;
	private byte[] file = null;
	private boolean isPdfStatic = false;
	
	
	public byte[] getFile() {
		return file;
	}

	public void setFile(byte[] file) {
		this.file = file;
	}

	public String getNomeDocumento() {
		return nomeDocumento;
	}

	public void setNomeDocumento(String nomeDocumento) {
		this.nomeDocumento = nomeDocumento;
	}

	public boolean isPdfStatic() {
		return isPdfStatic;
	}

	public void setPdfStatic(boolean isPdfStatic) {
		this.isPdfStatic = isPdfStatic;
	}
	
	
}
