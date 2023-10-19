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

public class DatoControlloTipo2Model extends DatoControlloModel {
	private MODModel xmlControllo;

	private List<DatiGFModel> datiCompModelList;

	public DatoControlloTipo2Model() {
	}

	public DatoControlloTipo2Model(MODModel xmlControllo, List<DatiGFModel> datiCompModelList) {
		this.xmlControllo = xmlControllo;
		this.datiCompModelList = datiCompModelList;
	}

	public MODModel getXmlControllo() {
		return xmlControllo;
	}

	public void setXmlControllo(MODModel xmlControllo) {
		this.xmlControllo = xmlControllo;
	}

	public List<DatiGFModel> getDatiCompModelList() {
		return datiCompModelList;
	}

	public void setDatiCompModelList(List<DatiGFModel> datiCompModelList) {
		this.datiCompModelList = datiCompModelList;
	}

	public void addDatiGFmodelList(List<DatiGFModel> datiGFModel) {
		if (this.datiCompModelList == null)
			datiCompModelList = new ArrayList<>();
		this.datiCompModelList.addAll(datiGFModel);
	}

	@Override
	public String toString() {
		return "DatoControlloTipo1BModel{" + "xmlControllo=" + xmlControllo + ", datiGFModelList=" + datiCompModelList + "} " + super.toString();
	}
}
