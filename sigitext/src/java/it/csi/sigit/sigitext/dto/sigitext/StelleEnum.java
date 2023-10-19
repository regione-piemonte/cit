package it.csi.sigit.sigitext.dto.sigitext;

public enum StelleEnum {
	STELLE3(1,3),

	STELLE4(2,4),

	STELLE5(3,5),

	NON_APPLICABILE(4,0);

	public final Integer idXsd;
	public final Integer idCit;

	private StelleEnum(Integer idXsd, Integer idCit) {
		this.idCit = idCit;
		this.idXsd = idXsd;
	}

	public static StelleEnum valueOfIdCit(Integer idCit) {
		for (StelleEnum stella : values()) {
			if (stella.idCit.equals(idCit)) {
				return stella;
			}
		}
		return null;
	}

	public static StelleEnum valueOfIdXsd(Integer idXsd) {
		for (StelleEnum stella : values()) {
			if (stella.idXsd.equals(idXsd)) {
				return stella;
			}
		}
		return null;
	}
}
