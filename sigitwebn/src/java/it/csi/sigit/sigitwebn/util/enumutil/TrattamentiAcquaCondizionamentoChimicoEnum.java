/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
package it.csi.sigit.sigitwebn.util.enumutil;

public enum TrattamentiAcquaCondizionamentoChimicoEnum {

	ANTINCROSTANTE("a prevalente azione antincrostante"), ANTICORROSIVA(
			"a prevalente azione anticorrosiva"), ANTINCROSTANTE_ANTICORROSIVA(
					"azione antincrostante e anticorrosiva"), BIOCIDA(
							"biocida"), NESSUNO("nessun trattamento"), ALTRO("altro");

	private String descrizione;

	private TrattamentiAcquaCondizionamentoChimicoEnum(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getDescrizione() {
		return descrizione;
	}
	
}
