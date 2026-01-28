/*
 *
 *  * ******************************************************************************
 *  *  SPDX-License-Identifier: EUPL-1.2
 *  *  Copyright Regione Piemonte - 2021
 *  * *****************************************************************************
 *
 */

package it.csi.sigit.combustypwabff.model.locsi;

public class LoccsiCrsPropertiesModel {
	private String name;

	public LoccsiCrsPropertiesModel(String name) {
		this.name = name;
	}

	public LoccsiCrsPropertiesModel() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "LoccsiCrsPropertiesModel{" + "name='" + name + '\'' + '}';
	}
}
