/*******************************************************************************
* SPDX-License-Identifier: EUPL-1.2
* Copyright Regione Piemonte - 2021
*******************************************************************************/
package it.csi.sigit.sigitwebn.util.enumutil;

public enum NaturaleForzataEnum {
	N ("Naturale"),
	F ("Forzata");
	
	private NaturaleForzataEnum(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getDescrizione() {
		return descrizione;
	}

	private String descrizione;
}
