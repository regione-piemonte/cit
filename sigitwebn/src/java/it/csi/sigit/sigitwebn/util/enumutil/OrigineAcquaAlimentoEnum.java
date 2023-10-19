/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
package it.csi.sigit.sigitwebn.util.enumutil;

public enum OrigineAcquaAlimentoEnum {
	
	ACQUEDOTTO("acquedotto"), POZZO("pozzo"), ACQUA_SUPERFICIALE("acqua superficiale");

	private String descrizione;

	private OrigineAcquaAlimentoEnum(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getDescrizione() {
		return descrizione;
	}

}
