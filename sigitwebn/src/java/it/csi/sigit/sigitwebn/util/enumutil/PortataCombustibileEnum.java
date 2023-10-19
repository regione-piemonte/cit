/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
package it.csi.sigit.sigitwebn.util.enumutil;

import it.csi.sigit.sigitwebn.util.Constants;

public enum PortataCombustibileEnum {
	M3 ("m3/h"),
	KG ("kg/h");
	
	private PortataCombustibileEnum(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getDescrizione() {
		return descrizione;
	}

	private String descrizione;

}
