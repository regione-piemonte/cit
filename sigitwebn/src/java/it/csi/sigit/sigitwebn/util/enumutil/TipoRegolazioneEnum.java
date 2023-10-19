/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
package it.csi.sigit.sigitwebn.util.enumutil;

public enum TipoRegolazioneEnum {
	
	TERMOSTATO_ON_OFF ("Termostato di zona o ambiente con controllo ON-OFF"),
	TERMOSTATO_PROPORZIONALE ("Termostato di zona o ambiente con controllo proporzionale"),
	CONTROLLO_ARIA_ESTERNA ("Controllo entalpico su serranda aria esterna"),
	CONTROLLO_ARIA_CANALIZZATA ("Controllo portata aria variabile per aria canalizzata");
	
	private TipoRegolazioneEnum(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getDescrizione() {
		return descrizione;
	}

	private String descrizione;

}
