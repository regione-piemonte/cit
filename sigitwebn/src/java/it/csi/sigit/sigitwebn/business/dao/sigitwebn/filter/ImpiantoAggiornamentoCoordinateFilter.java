/*******************************************************************************
* SPDX-License-Identifier: EUPL-1.2
* Copyright Regione Piemonte - 2021
*******************************************************************************/
package it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter;

public class ImpiantoAggiornamentoCoordinateFilter {

	private Boolean senzaCoordinateFlag = null;
	
	private String aggiornatiAData = null;

	public Boolean getSenzaCoordinateFlag() {
		return senzaCoordinateFlag;
	}

	public void setSenzaCoordinateFlag(Boolean senzaCoordinateFlag) {
		this.senzaCoordinateFlag = senzaCoordinateFlag;
	}

	public String getAggiornatiAData() {
		return aggiornatiAData;
	}

	public void setAggiornatiAData(String aggiornatiAData) {
		this.aggiornatiAData = aggiornatiAData;
	}
}
