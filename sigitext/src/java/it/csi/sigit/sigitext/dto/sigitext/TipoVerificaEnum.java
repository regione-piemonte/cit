package it.csi.sigit.sigitext.dto.sigitext;

public enum TipoVerificaEnum {

	IMPIANTO(1, "Impianto"), REE(2, "Rapporto Efficienza Energetica (REE)"), RELAZIONE(3, "Relazione Esimente"), DATO_DISTRIBUTORE(4, "Dato distributore"), SEGNALAZIONE(5, "Segnalazione"), DECADENZA3R(6, "Decadenza 3 Responsabile"), ALTRO(7, "Altro");

	private Integer idDb;

	private String descrizioneDb;

	public Integer getIdDb() {
		return idDb;
	}

	public void setIdDb(Integer idDb) {
		this.idDb = idDb;
	}

	public String getDescrizioneDb() {
		return descrizioneDb;
	}

	public void setDescrizioneDb(String descrizioneDb) {
		this.descrizioneDb = descrizioneDb;
	}

	private TipoVerificaEnum(Integer idDb, String descrizioneDb) {
		this.idDb = idDb;
		this.descrizioneDb = descrizioneDb;
	}

	public static TipoVerificaEnum getFromDbValue(Integer dbValue) {
		for (TipoVerificaEnum tipoEnum : TipoVerificaEnum.values()) {
			if (tipoEnum.getIdDb().equals(dbValue)) {
				return tipoEnum;
			}
		}
		return null;
	}
}