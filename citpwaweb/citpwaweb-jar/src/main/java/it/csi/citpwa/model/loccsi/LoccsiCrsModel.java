/*
 *
 *  * ******************************************************************************
 *  *  SPDX-License-Identifier: EUPL-1.2
 *  *  Copyright Regione Piemonte - 2021
 *  * *****************************************************************************
 *
 */

package it.csi.citpwa.model.loccsi;

public class LoccsiCrsModel {

	private String type;
	private LoccsiCrsPropertiesModel properties;

	public LoccsiCrsModel(String type, LoccsiCrsPropertiesModel properties) {
		this.type = type;
		this.properties = properties;
	}

	public LoccsiCrsModel() {
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public LoccsiCrsPropertiesModel getProperties() {
		return properties;
	}

	public void setProperties(LoccsiCrsPropertiesModel properties) {
		this.properties = properties;
	}

	@Override
	public String toString() {
		return "LoccsiCrsModel{" + "type='" + type + '\'' + ", properties=" + properties + '}';
	}
}
