/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
package it.csi.sigit.sigitbatchn.batch;

/**
 * Enumeratore dei batch
 * 
 * @author 71845 - Marco Giacometto
 */
public enum BatchEnum {
	
	/**
	 * Batch per l'importazione massiva degli allegati
	 */
	IMPORTMASSIVOALLEGATI("Import massivo allegati", "importMassivoAllegati"),
	
	/**
	 * Batch per l'importazione massiva dei distributori
	 */
	IMPORTMASSIVODISTRIBUTORI("Import massivo distributori", "importMassivoDistributori"),
	
	/**
	 * Batch per l'importazioni dei manutentori da Infocamere
	 */
	INFOCAMERE("Infocamere", "infocamere"),
	/**
	 * Batch per l'importazione massiva degli impianti
	 */
	IMPORTMASSIVOIMPIANTI("Import massivo impianti e allegati", "importMassivoImpianti"),
	/**
	 * Batch per il consolidamento dei rapporti di controllo
	 */
	CONSOLIDAMENTORAPPORTI("Consolidamento rapporti di controllo", "consolidamentoRapporti"),
	/**
	 * Batch per l'invio di sveglie per utenti attivi, utenti disattivi e responsabili di impianti
	 */
	TIMERSERVICEMEMO("Timer service memo", "timerServiceMemo");

	/**
	 * Nome del batch
	 */
	private String name = null;
	/**
	 * Prefisso utilizzato nei nomi degli oggetti (es. per l'application
	 * context, il nome del bean, ecc.)
	 */
	private String prefix = null;

	/**
	 * Inizializza un'istanza dell'enumeratore
	 * 
	 * @param name Nome del batch
	 */
	BatchEnum(String name, String prefix) {
		this.name = name;
		this.prefix = prefix;
	}

	/**
	 * Restituisce il nome del batch
	 * 
	 * @return Nome del batch
	 */
	public String getName() {
		return name;
	}

	/**
	 * Restituisce il prefisso utilizzato nei nomi degli oggetti
	 * 
	 * @return Prefisso utilizzato nei nomi degli oggetti
	 */
	public String getPrefix() {
		return prefix;
	}
}
