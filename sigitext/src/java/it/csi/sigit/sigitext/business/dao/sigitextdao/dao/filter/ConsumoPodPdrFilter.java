/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
package it.csi.sigit.sigitext.business.dao.sigitextdao.dao.filter;

import java.math.BigDecimal;

/**
 * Filtro per cercare per codice REA
 * 
 */
public class ConsumoPodPdrFilter {
	
	
	private String podPdr;

	public ConsumoPodPdrFilter() {
		super();
	}

	public String getPodPdr() {
		return podPdr;
	}

	public void setPodPdr(String podPdr) {
		this.podPdr = podPdr;
	}
	
	
	
}
