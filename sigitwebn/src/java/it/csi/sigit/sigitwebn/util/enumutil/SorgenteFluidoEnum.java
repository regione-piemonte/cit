/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
package it.csi.sigit.sigitwebn.util.enumutil;

public enum SorgenteFluidoEnum {

	ACQUA ("Acqua"),
	ARIA ("Aria");
	
	private SorgenteFluidoEnum(String descrizione) {
		this.descrizione = descrizione;
	}

	private String descrizione;

	public String getDescrizione() {
		return descrizione;
	}
	
}
