/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
package it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter;

import it.csi.sigit.sigitwebn.dto.sanzioni.DatiInserimentoSanzione;

public class RicercaPersonaGiuridicaFisicaFilter  implements java.io.Serializable {

	private String codiceFiscale;
	private String nome;
	private String cognomeDenominazione;
	
	
	public String getCodiceFiscale() {
		return codiceFiscale;
	}
	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognomeDenominazione() {
		return cognomeDenominazione;
	}
	public void setCognomeDenominazione(String cognomeDenominazione) {
		this.cognomeDenominazione = cognomeDenominazione;
	}
	
	
	public static RicercaPersonaGiuridicaFisicaFilter costruisciDaFormSanzione(DatiInserimentoSanzione sanzione) {
		RicercaPersonaGiuridicaFisicaFilter input = new RicercaPersonaGiuridicaFisicaFilter();
		input.setCodiceFiscale(sanzione.getCodiceFiscale());
		input.setCognomeDenominazione(sanzione.getDenominazione());
		input.setNome(sanzione.getNome());
		
		return input;
	}
	
	
	
}
