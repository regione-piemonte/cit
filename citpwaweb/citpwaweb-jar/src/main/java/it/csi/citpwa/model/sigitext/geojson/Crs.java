package it.csi.citpwa.model.sigitext.geojson;

import java.io.Serializable;
import java.util.HashMap;

public class Crs implements Serializable {

	private String type = "name";
	
	private HashMap<String, String> properties;

	public Crs() {
		super();
	}

	public Crs(HashMap<String, String> properties) {
		super();
		this.properties = properties;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public HashMap<String, String> getProperties() {
		return properties;
	}

	public void setProperties(HashMap<String, String> properties) {
		this.properties = properties;
	}

	@Override
	public String toString() {
		return "Crs [type=" + type + ", properties=" + properties + "]";
	}

}
