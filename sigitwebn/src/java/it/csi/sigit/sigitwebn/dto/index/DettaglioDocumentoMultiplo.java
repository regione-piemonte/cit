/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
package it.csi.sigit.sigitwebn.dto.index;

public class DettaglioDocumentoMultiplo {
	
	private static final long serialVersionUID = -6978966528394781758L;
	
	private DettaglioDocumento documentoPdf = null;

	private DettaglioDocumento documentoXml = null;

	public DettaglioDocumento getDocumentoPdf() {
		return documentoPdf;
	}

	public void setDocumentoPdf(DettaglioDocumento documentoPdf) {
		this.documentoPdf = documentoPdf;
	}

	public DettaglioDocumento getDocumentoXml() {
		return documentoXml;
	}

	public void setDocumentoXml(DettaglioDocumento documentoXml) {
		this.documentoXml = documentoXml;
	}

	
}
