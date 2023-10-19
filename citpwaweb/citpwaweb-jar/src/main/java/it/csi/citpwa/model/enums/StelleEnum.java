package it.csi.citpwa.model.enums;

public enum StelleEnum {
	STELLE3("1","3"),

	STELLE4("2","4"),

	STELLE5("3","5"),

	NON_APPLICABILE("4","0");

	public final String idXsd;
	public final String idPwa;

	private StelleEnum(String idXsd, String idPwa) {
		this.idPwa = idPwa;
		this.idXsd = idXsd;
	}

	public static StelleEnum valueOfIdPwa(String idPwa) {
		for (StelleEnum stella : values()) {
			if (stella.idPwa.equals(idPwa)) {
				return stella;
			}
		}
		return null;
	}

	public static StelleEnum valueOfIdXsd(String idXsd) {
		for (StelleEnum stella : values()) {
			if (stella.idXsd.equals(idXsd)) {
				return stella;
			}
		}
		return null;
	}
}
