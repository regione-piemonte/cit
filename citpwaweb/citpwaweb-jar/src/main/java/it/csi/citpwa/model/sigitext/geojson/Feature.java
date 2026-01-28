package it.csi.citpwa.model.sigitext.geojson;

import java.io.Serializable;
import java.util.HashMap;

public class Feature implements Serializable {

	private String type = "Feature";
	
	private Geometry geometry;
	
	private HashMap<String, String> properties;
	
	public Feature() {
		super();
	}

	public Feature(Geometry geometry, HashMap<String, String> properties) {
		super();
		this.geometry = geometry;
		this.properties = properties;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Geometry getGeometry() {
		return geometry;
	}

	public void setGeometry(Geometry geometry) {
		this.geometry = geometry;
	}

	public HashMap<String, String> getProperties() {
		return properties;
	}

	public void setProperties(HashMap<String, String> properties) {
		this.properties = properties;
	}

	@Override
	public String toString() {
		return "Feature [type=" + type + ", geometry=" + geometry + ", properties=" + properties + "]";
	}
	
}
