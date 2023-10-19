/*******************************************************************************
* SPDX-License-Identifier: EUPL-1.2
* Copyright Regione Piemonte - 2021
*******************************************************************************/
package it.csi.sigit.sigitwebn.util.enumutil;

public enum TipologiaTipo1BEnum {
	CALDAIA ("Caldaia (UNI EN 303-5)", 1),
	STUFA ("Stufa (UNI EN 13240)", 2),
	STUFA_ACCUMULO ("Stufa ad accumulo (UNI EN 15250)", 3),
	TERMOCUCINA ("Termocucina (UNI EN 12815)", 4),
	STUFA_ASSEMBLATA ("Stufa assemblata in opera (UNI EN 15544)", 5),
	STUFA_PELLET ("Stufa a pellet (UNI EN 14785)", 6);
	
	private TipologiaTipo1BEnum(String descrizione, Integer id) {
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
	
	public static TipologiaTipo1BEnum getById(Integer id) throws Exception {
		for (TipologiaTipo1BEnum tipologia : values()) {
			if (tipologia.getId().equals(id)) {
				return tipologia;
			}
		}
		
		throw new Exception ("Nessuna tipologia tipo 1B trovata per l'id " + id);
	}
}
