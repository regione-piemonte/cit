/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
package it.csi.sigit.sigitwebn.util.enumutil;

import it.csi.sigit.sigitwebn.util.Constants;

public enum O2CO2Enum {
	O2 ("O2"),
	CO2 ("CO2");
	
	private O2CO2Enum(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getDescrizione() {
		return descrizione;
	}

	private String descrizione;

}
