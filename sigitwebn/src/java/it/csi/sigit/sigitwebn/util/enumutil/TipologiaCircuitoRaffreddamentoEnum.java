/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
package it.csi.sigit.sigitwebn.util.enumutil;

public enum TipologiaCircuitoRaffreddamentoEnum {
	
	NO_REC_TERMICO("senza recupero termico"), REC_TERMICO_PARZIALE(
			"a recupero termico parziale"), REC_TERMICO_TOTALE("a recupero termico totale");

	private String descrizione;

	private TipologiaCircuitoRaffreddamentoEnum(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getDescrizione() {
		return descrizione;
	}

}
