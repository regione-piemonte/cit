/*
 *
 *  * ******************************************************************************
 *  *  SPDX-License-Identifier: EUPL-1.2
 *  *  Copyright Regione Piemonte - 2021
 *  * *****************************************************************************
 *
 */

package it.csi.citpwa.model.xml.ree;

public class MODModel {
	private RichiestaModel richiesta;

	public MODModel() {
	}

	public MODModel(RichiestaModel richiesta) {
		this.richiesta = richiesta;
	}

	public RichiestaModel getRichiesta() {
		return richiesta;
	}

	public void setRichiesta(RichiestaModel richiesta) {
		this.richiesta = richiesta;
	}

	@Override
	public String toString() {
		return "MODIIModel{" + "richiesta=" + richiesta + '}';
	}
}
