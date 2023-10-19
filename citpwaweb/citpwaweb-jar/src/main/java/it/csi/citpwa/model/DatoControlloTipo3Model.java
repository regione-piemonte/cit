/*
 *
 *  * ******************************************************************************
 *  *  SPDX-License-Identifier: EUPL-1.2
 *  *  Copyright Regione Piemonte - 2021
 *  * *****************************************************************************
 *
 */

package it.csi.citpwa.model;

import it.csi.citpwa.model.xml.ree.MODModel;

import java.util.ArrayList;
import java.util.List;

public class DatoControlloTipo3Model extends DatoControlloModel {
	private MODModel xmlControllo;

	private List<DatiSCModel> datiCompModelList;

	public DatoControlloTipo3Model() {
	}

	public DatoControlloTipo3Model(MODModel xmlControllo, List<DatiSCModel> datiCompModelList) {
		this.xmlControllo = xmlControllo;
		this.datiCompModelList = datiCompModelList;
	}

	public MODModel getXmlControllo() {
		return xmlControllo;
	}

	public void setXmlControllo(MODModel xmlControllo) {
		this.xmlControllo = xmlControllo;
	}

	public List<DatiSCModel> getDatiCompModelList() {
		return datiCompModelList;
	}

	public void setDatiCompModelList(List<DatiSCModel> datiCompModelList) {
		this.datiCompModelList = datiCompModelList;
	}

	public void addDatiGFmodelList(List<DatiSCModel> datiSCModel) {
		if (this.datiCompModelList == null)
			datiCompModelList = new ArrayList<>();
		this.datiCompModelList.addAll(datiSCModel);
	}

	@Override
	public String toString() {
		return "DatoControlloTipo1BModel{" + "xmlControllo=" + xmlControllo + ", datiSCModelList=" + datiCompModelList + "} " + super.toString();
	}
}
