/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
package it.csi.sigit.sigitwebn.util.enumutil;

public enum PresenteAssenteEnum {

	P ("Presente", 1),
	A ("Assente", 0);
	
	private PresenteAssenteEnum(String descrizione, Integer id) {
		this.descrizione = descrizione;
		this.id = id;
	}

	private String descrizione;
	private Integer id;

	public String getDescrizione() {
		return descrizione;
	}

	public Integer getId() {
		return id;
	}
	
	
}
