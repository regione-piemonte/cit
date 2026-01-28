package it.csi.citpwa.model.sigitext.geojson;

import java.io.Serializable;
import java.util.Arrays;

public class Geometry implements Serializable {

	private String type = "Point";
	
	private Float[] coordinates;

	public Geometry() {
		super();
	}

	public Geometry(Float[] coordinates) {
		super();
		this.coordinates = coordinates;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Float[] getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(Float[] coordinates) {
		this.coordinates = coordinates;
	}

	@Override
	public String toString() {
		return "Geometry [type=" + type + ", coordinates=" + Arrays.toString(coordinates) + "]";
	}

}
