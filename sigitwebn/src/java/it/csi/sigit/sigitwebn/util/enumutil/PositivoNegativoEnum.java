/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
package it.csi.sigit.sigitwebn.util.enumutil;

public enum PositivoNegativoEnum {

	POSITIVO ("Positivo", 1),
	NEGATIVO ("Negativo", 0);
	
	private String descrizione;
	
	private int id;
	
	private PositivoNegativoEnum(String descrizione, int id) {
		this.descrizione = descrizione;
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public String getDescrizione() {
		return descrizione;
	}
}
