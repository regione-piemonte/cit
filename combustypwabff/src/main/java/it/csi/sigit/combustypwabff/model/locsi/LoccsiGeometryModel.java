/*
 *
 *  * ******************************************************************************
 *  *  SPDX-License-Identifier: EUPL-1.2
 *  *  Copyright Regione Piemonte - 2021
 *  * *****************************************************************************
 *
 */

package it.csi.sigit.combustypwabff.model.locsi;

import java.math.BigDecimal;
import java.util.List;

public class LoccsiGeometryModel {
	private String type;
	private List<BigDecimal> coordinates;

	public LoccsiGeometryModel(String type, List<BigDecimal> coordinates) {
		this.type = type;
		this.coordinates = coordinates;
	}

	public LoccsiGeometryModel() {
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<BigDecimal> getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(List<BigDecimal> coordinates) {
		this.coordinates = coordinates;
	}

	@Override
	public String toString() {
		return "Geometry{" + "type='" + type + '\'' + ", coordinates=" + coordinates + '}';
	}
}
