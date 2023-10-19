/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
package it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.filter;

import java.math.BigDecimal;


/**
 * Filtro per cercare gli allegati
 * 
 */
public class BollinoFilter {

	/**
	 * Sigla bollino
	 */
	private String siglaBollino = null;
	
	/**
	 * Numero bollino
	 */
	private Integer numeroBollino = null;
	
	/**
	 * Id persona giuridica
	 */
	private BigDecimal idPersonaGiuridica = null;
	
	/**
	 * Inizializza un'istanza della classe
	 */
	public BollinoFilter() {
	}

	/**
	 * Inizializza un'istanza della classe
	 */
	public BollinoFilter(String siglaBollino, Integer numeroBollino) {
		setSiglaBollino(siglaBollino);
		setNumeroBollino(numeroBollino);
	}

	/**
	 * Inizializza un'istanza della classe
	 */
	public BollinoFilter(String siglaBollino, Integer numeroBollino, BigDecimal idPersonaGiuridica) {
		setSiglaBollino(siglaBollino);
		setNumeroBollino(numeroBollino);
		setIdPersonaGiuridica(idPersonaGiuridica);

	}
	
	
	public String getSiglaBollino() {
		return siglaBollino;
	}

	public void setSiglaBollino(String siglaBollino) {
		this.siglaBollino = siglaBollino;
	}

	public Integer getNumeroBollino() {
		return numeroBollino;
	}

	public void setNumeroBollino(Integer numeroBollino) {
		this.numeroBollino = numeroBollino;
	}

	public BigDecimal getIdPersonaGiuridica() {
		return idPersonaGiuridica;
	}

	public void setIdPersonaGiuridica(BigDecimal idPersonaGiuridica) {
		this.idPersonaGiuridica = idPersonaGiuridica;
	}
	
	
}
