/*
 *
 *  * ******************************************************************************
 *  *  SPDX-License-Identifier: EUPL-1.2
 *  *  Copyright Regione Piemonte - 2021
 *  * *****************************************************************************
 *
 */

package it.csi.citpwa.model.loccsi;

public class LoccsiFeatureModel {
	private String type;
	private LoccsiGeometryModel geometry;
	private LoccsiPropertiesModel properties;
	private String id;

	public LoccsiFeatureModel() {
	}

	public LoccsiFeatureModel(String type, LoccsiGeometryModel geometry, LoccsiPropertiesModel properties, String id) {
		this.type = type;
		this.geometry = geometry;
		this.properties = properties;
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public LoccsiGeometryModel getGeometry() {
		return geometry;
	}

	public void setGeometry(LoccsiGeometryModel geometry) {
		this.geometry = geometry;
	}

	public LoccsiPropertiesModel getProperties() {
		return properties;
	}

	public void setProperties(LoccsiPropertiesModel properties) {
		this.properties = properties;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "LoccsiFeatureModel{" + "type='" + type + '\'' + ", geometry=" + geometry + ", properties=" + properties + ", id='" + id + '\'' + '}';
	}
}
