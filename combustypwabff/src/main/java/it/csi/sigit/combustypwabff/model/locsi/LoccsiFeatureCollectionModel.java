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

public class LoccsiFeatureCollectionModel {
	private String type;
	private List<LoccsiFeatureModel> features;
	private LoccsiCrsModel crs;
	private List<BigDecimal> bbox;

	public LoccsiFeatureCollectionModel() {
	}

	public LoccsiFeatureCollectionModel(String type, List<LoccsiFeatureModel> features, LoccsiCrsModel crs, List<BigDecimal> bbox) {
		this.type = type;
		this.features = features;
		this.crs = crs;
		this.bbox = bbox;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<LoccsiFeatureModel> getFeatures() {
		return features;
	}

	public void setFeatures(List<LoccsiFeatureModel> features) {
		this.features = features;
	}

	public LoccsiCrsModel getCrs() {
		return crs;
	}

	public void setCrs(LoccsiCrsModel crs) {
		this.crs = crs;
	}

	public List<BigDecimal> getBbox() {
		return bbox;
	}

	public void setBbox(List<BigDecimal> bbox) {
		this.bbox = bbox;
	}

	@Override
	public String toString() {
		return "LoccsiFeatureCollectionModel{" + "type='" + type + '\'' + ", features=" + features + ", crs=" + crs + ", bbox=" + bbox + '}';
	}
}
