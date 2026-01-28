package it.csi.citpwa.model.sigitext.geojson;

import java.io.Serializable;
import java.util.Arrays;

public class FeatureCollection implements Serializable {

	private String type = "FeatureCollection";
	
	private Feature[] features;
	
	private Crs crs;
	
	private Float[] bbox;

	public FeatureCollection() {
		super();
	}

	public FeatureCollection(Feature[] features, Crs crs, Float[] bbox) {
		super();
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

	public Feature[] getFeatures() {
		return features;
	}

	public void setFeatures(Feature[] features) {
		this.features = features;
	}

	public Crs getCrs() {
		return crs;
	}

	public void setCrs(Crs crs) {
		this.crs = crs;
	}

	public Float[] getBbox() {
		return bbox;
	}

	public void setBbox(Float[] bbox) {
		this.bbox = bbox;
	}

	@Override
	public String toString() {
		return "FeatureCollection [type=" + type + ", features=" + Arrays.toString(features) + ", crs=" + crs
				+ ", bbox=" + Arrays.toString(bbox) + "]";
	}
	
}
