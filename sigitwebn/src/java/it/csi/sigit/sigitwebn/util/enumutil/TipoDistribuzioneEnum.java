/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
package it.csi.sigit.sigitwebn.util.enumutil;

public enum TipoDistribuzioneEnum {
	
	VERTICALE("verticale a colonne montanti"),
	ORIZZONTALE ("orizzontale a zone"),
	CANALI ("canali d'aria"),
	ALTRO ("altro");

	private String descrizione;

	private TipoDistribuzioneEnum(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getDescrizione() {
		return descrizione;
	}

}
