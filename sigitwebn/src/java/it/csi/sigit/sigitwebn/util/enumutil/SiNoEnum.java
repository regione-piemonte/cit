/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
package it.csi.sigit.sigitwebn.util.enumutil;

public enum SiNoEnum {

	SI_1 ("Si", "1"),
	NO_0 ("No", "0");
	
	private String descrizione;
	
	private String codice;
	
	private SiNoEnum(String descrizione, String codice) {
		this.descrizione = descrizione;
		this.codice = codice;
	}

	public String getCodice() {
		return codice;
	}

	public String getDescrizione() {
		return descrizione;
	}
}
