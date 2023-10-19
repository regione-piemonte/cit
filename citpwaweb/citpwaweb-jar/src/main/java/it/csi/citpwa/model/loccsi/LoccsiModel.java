/*
 *
 *  * ******************************************************************************
 *  *  SPDX-License-Identifier: EUPL-1.2
 *  *  Copyright Regione Piemonte - 2021
 *  * *****************************************************************************
 *
 */

package it.csi.citpwa.model.loccsi;

import java.util.List;

public class LoccsiModel {
	private Long id;
	private String name;
	private String description;
	private List<String> catalogs;
	private LoccsiFeatureCollectionModel featureCollection;

	public LoccsiModel() {
	}

	public LoccsiModel(Long id, String name, String description, List<String> catalogs, LoccsiFeatureCollectionModel featureCollection) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.catalogs = catalogs;
		this.featureCollection = featureCollection;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<String> getCatalogs() {
		return catalogs;
	}

	public void setCatalogs(List<String> catalogs) {
		this.catalogs = catalogs;
	}

	public LoccsiFeatureCollectionModel getFeatureCollection() {
		return featureCollection;
	}

	public void setFeatureCollection(LoccsiFeatureCollectionModel featureCollection) {
		this.featureCollection = featureCollection;
	}

	@Override
	public String toString() {
		return "LoccsiModel{" + "id=" + id + ", name='" + name + '\'' + ", description='" + description + '\'' + ", catalogs=" + catalogs + ", featureCollection=" + featureCollection + '}';
	}
}


