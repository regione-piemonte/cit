package it.csi.sigit.sigitext.dto.sigitext;

import java.io.Serializable;

import it.csi.sigit.sigitext.dto.sigitext.geojson.FeatureCollection;

public class ListaImpiantiGeo implements Serializable {

	private Impianto[] impianti;
	
	private FeatureCollection featureCollection;

	public ListaImpiantiGeo() {
		super();
	}

	public ListaImpiantiGeo(Impianto[] impianti, FeatureCollection featureCollection) {
		super();
		this.impianti = impianti;
		this.featureCollection = featureCollection;
	}

	public Impianto[] getImpianti() {
		return impianti;
	}

	public void setImpianti(Impianto[] impianti) {
		this.impianti = impianti;
	}

	public FeatureCollection getFeatureCollection() {
		return featureCollection;
	}

	public void setFeatureCollection(FeatureCollection featureCollection) {
		this.featureCollection = featureCollection;
	}

	@Override
	public String toString() {
		return "ListaImpiantiGeo [impianti=" + impianti + ", featureCollection=" + featureCollection + "]";
	}
}
