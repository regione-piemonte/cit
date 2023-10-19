/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
package it.csi.sigit.sigitwebn.util.enumutil;

public enum TrattamentiAcquaFiltrazioneEnum {
	
	SICUREZZA("filtrazione di sicurezza"), MASSE("filtrazione a masse"), NO_TRATTAMENTO(
			"nessun trattamento"), ALTRO("altro");

	private String descrizione;

	private TrattamentiAcquaFiltrazioneEnum(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getDescrizione() {
		return descrizione;
	}

}
