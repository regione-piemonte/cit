/*******************************************************************************
* SPDX-License-Identifier: EUPL-1.2
* Copyright Regione Piemonte - 2021
*******************************************************************************/
package it.csi.sigit.sigitwebn.util.enumutil;

public enum CondottoEvacuazioneFumiTipo1BEnum {
	CAMINETTO_APERTO ("Caminetto aperto (UNI EN 13229)", 1),
	CAMINETTO_CHIUSO ("Caminetto chiuso (UNI EN 13229)", 2),
	INSERTO_CAMINETTO ("Inserto caminetto (UNI EN 13229)", 3);
	
	private CondottoEvacuazioneFumiTipo1BEnum(String descrizione, Integer id) {
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
	
	public static CondottoEvacuazioneFumiTipo1BEnum getById(Integer id) throws Exception {
		for (CondottoEvacuazioneFumiTipo1BEnum condotto : values()) {
			if (condotto.getId().equals(id)) {
				return condotto;
			}
		}
		
		throw new Exception ("Nessun condotto di evacuazione fumi tipo 1B trovato per l'id " + id);
	}
}
