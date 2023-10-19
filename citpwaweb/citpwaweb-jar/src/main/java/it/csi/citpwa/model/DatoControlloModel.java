/*
 *
 *  * ******************************************************************************
 *  *  SPDX-License-Identifier: EUPL-1.2
 *  *  Copyright Regione Piemonte - 2021
 *  * *****************************************************************************
 *
 */

package it.csi.citpwa.model;

public class DatoControlloModel {
	private ControlloModel controlloModel;

	public ControlloModel getControlloModel() {
		return controlloModel;
	}

	public void setControlloModel(ControlloModel controlloModel) {
		this.controlloModel = controlloModel;
	}

	@Override
	public String toString() {
		return "DatoControlloModel{" + "controlloModel=" + controlloModel + '}';
	}
}
