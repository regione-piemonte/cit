/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
package it.csi.sigit.sigitwebn.util.enumutil;

public enum EditabilitaComp4Enum {

	COMP_REE_NON_MODIFICABILE ("La componente ha un ree associato e non e' modificabile"),
	COMP_REE_MODIFICABILE ("La componente ha un ree associato restando comunque modificabile"),
	COMP_NON_MODIFICABILE ("La componente non e' modificabile "),
	COMP_MODIFICABILE ("La componente non ha ree associati ed e' modificabile");
	
	
	public String getDescrizione() {
		return descrizione;
	}

	private EditabilitaComp4Enum(String descrizione) {
		this.descrizione = descrizione;
	}

	private String descrizione;
	
}
