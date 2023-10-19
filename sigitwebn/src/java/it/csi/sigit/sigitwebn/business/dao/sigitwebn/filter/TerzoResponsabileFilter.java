/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
package it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter;

import java.math.BigDecimal;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitVRicerca3ResponsabileDto;

public class TerzoResponsabileFilter extends SigitVRicerca3ResponsabileDto{

	//dcosta: mev reingegnerizzazione viste. sulla vista di ricerca terzo responsabile non ci sono più le chiavi esterne dirette a 
	//pg e pf quindi vengono aggiunti in questa classe
	
	private BigDecimal fkPgResponsabile;
	
	private BigDecimal fkPfResponsabile;

	public BigDecimal getFkPgResponsabile() {
		return fkPgResponsabile;
	}

	public void setFkPgResponsabile(BigDecimal fkPgResponsabile) {
		this.fkPgResponsabile = fkPgResponsabile;
	}

	public BigDecimal getFkPfResponsabile() {
		return fkPfResponsabile;
	}

	public void setFkPfResponsabile(BigDecimal fkPfResponsabile) {
		this.fkPfResponsabile = fkPfResponsabile;
	}
	
	
	
}
