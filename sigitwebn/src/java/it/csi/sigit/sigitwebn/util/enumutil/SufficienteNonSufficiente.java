/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
package it.csi.sigit.sigitwebn.util.enumutil;

public enum SufficienteNonSufficiente {

	SUFFICIENTE ("Sufficiente", "1"),
	NON_SUFFICIENTE("Non Sufficiente", "0");
	
	private String descrizione;
	
	private String codice;
	
	private SufficienteNonSufficiente(String descrizione, String codice) {
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
