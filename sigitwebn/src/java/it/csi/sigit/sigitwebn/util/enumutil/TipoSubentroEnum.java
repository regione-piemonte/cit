/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
package it.csi.sigit.sigitwebn.util.enumutil;

public enum TipoSubentroEnum {

	IMPRESA ("IMPRESA", 2),
	RESPONSABILE_IMPRESA ("RESPONSABILE IMPRESA", 3);
	
	private String descrizione;
	
	private int id;
	
	private TipoSubentroEnum(String descrizione, int id) {
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
