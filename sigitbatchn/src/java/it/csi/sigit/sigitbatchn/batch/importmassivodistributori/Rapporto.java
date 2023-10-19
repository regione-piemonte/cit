/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
package it.csi.sigit.sigitbatchn.batch.importmassivodistributori;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Rapporto {
	
	private Integer idRapportoControllo = null;
	
	private Date dataRapportoControllo = null;

	public Integer getIdRapportoControllo() {
		return idRapportoControllo;
	}

	public void setIdRapportoControllo(Integer idRapportoControllo) {
		this.idRapportoControllo = idRapportoControllo;
	}

	public Date getDataRapportoControllo() {
		return dataRapportoControllo;
	}

	public void setDataRapportoControllo(Date dataRapportoControllo) {
		this.dataRapportoControllo = dataRapportoControllo;
	}
	
	
}
