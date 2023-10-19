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

public class DatoControlloTipo4Model extends DatoControlloModel {
	private MODModel xmlControllo;

	private List<DatiCGModel> datiCompModelList;

	public DatoControlloTipo4Model() {
	}

	public DatoControlloTipo4Model(MODModel xmlControllo, List<DatiCGModel> datiCompModelList) {
		this.xmlControllo = xmlControllo;
		this.datiCompModelList = datiCompModelList;
	}

	public MODModel getXmlControllo() {
		return xmlControllo;
	}

	public void setXmlControllo(MODModel xmlControllo) {
		this.xmlControllo = xmlControllo;
	}

	public List<DatiCGModel> getDatiCompModelList() {
		return datiCompModelList;
	}

	public void setDatiCompModelList(List<DatiCGModel> datiCompModelList) {
		this.datiCompModelList = datiCompModelList;
	}

	public void addDatiCGmodelList(List<DatiCGModel> datiCGModel) {
		if (this.datiCompModelList == null)
			datiCompModelList = new ArrayList<>();
		this.datiCompModelList.addAll(datiCGModel);
	}

	@Override
	public String toString() {
		return "DatoControlloTipo1BModel{" + "xmlControllo=" + xmlControllo + ", datiCGModelList=" + datiCompModelList + "} " + super.toString();
	}
}
