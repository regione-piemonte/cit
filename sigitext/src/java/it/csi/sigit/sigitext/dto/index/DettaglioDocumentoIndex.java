/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
package it.csi.sigit.sigitext.dto.index;

import java.io.InputStream;

public class DettaglioDocumentoIndex {
	
	private static final long serialVersionUID = -6978966528394781758L;
	
	private String nomeAllegato = null;
	private InputStream file = null;

	public InputStream getFile() {
		return file;
	}

	public void setFile(InputStream file) {
		this.file = file;
	}

	public String getNomeAllegato() {
		return nomeAllegato;
	}

	public void setNomeAllegato(String nomeAllegato) {
		this.nomeAllegato = nomeAllegato;
	}
	
	
}
