/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
package it.csi.sigit.sigitwebn.util.enumutil;

public enum TrattamentiAcquaTrattamentoEnum {
	
	ADDOLCIMENTO("addolcimento"), OSMOSI("osmosi inversa"), DEMINERALIZZAZIONE("demineralizzazione"), NESSUNO(
			"nessun trattamento"), ALTRO("altro");

	private String descrizione;

	private TrattamentiAcquaTrattamentoEnum(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getDescrizione() {
		return descrizione;
	}

}
