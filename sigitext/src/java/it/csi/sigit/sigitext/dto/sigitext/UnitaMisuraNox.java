package it.csi.sigit.sigitext.dto.sigitext;

public enum UnitaMisuraNox {

	MG_KWH_1 ("mg/kWh", "0"),
	PPM_0 ("ppm", "1");
	
	private String descrizione;
	
	private String codice;
	
	private UnitaMisuraNox(String descrizione, String codice) {
		this.descrizione = descrizione;
		this.codice = codice;
	}

	public String getCodice() {
		return codice;
	}

	public String getDescrizione() {
		return descrizione;
	}
}