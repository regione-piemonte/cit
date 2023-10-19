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

public class DatoControlloTipo1BModel extends DatoControlloModel {
	private MODModel xmlControllo;

	private List<DatiGTModel> datiCompModelList;

	public DatoControlloTipo1BModel() {
	}

	public DatoControlloTipo1BModel(MODModel xmlControllo, List<DatiGTModel> datiCompModelList) {
		this.xmlControllo = xmlControllo;
		this.datiCompModelList = datiCompModelList;
	}

	public MODModel getXmlControllo() {
		return xmlControllo;
	}

	public void setXmlControllo(MODModel xmlControllo) {
		this.xmlControllo = xmlControllo;
	}

	public List<DatiGTModel> getDatiCompModelList() {
		return datiCompModelList;
	}

	public void setDatiCompModelList(List<DatiGTModel> datiCompModelList) {
		this.datiCompModelList = datiCompModelList;
	}

	public void addDatiGTModelList(List<DatiGTModel> datiGTModel) {
		if (this.datiCompModelList == null)
			datiCompModelList = new ArrayList<>();
		this.datiCompModelList.addAll(datiGTModel);
	}

	@Override
	public String toString() {
		return "DatoControlloTipo1BModel{" + "xmlControllo=" + xmlControllo + ", datiGTModelList=" + datiCompModelList + "} " + super.toString();
	}
}
