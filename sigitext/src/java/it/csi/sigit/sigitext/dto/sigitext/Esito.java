package it.csi.sigit.sigitext.dto.sigitext;

public class Esito {
	private String esito;
	private String descrizioneEsito;
	private String codiceImpianto;
	private Integer idAllegatoNew;
	private byte[] xmlLibretto;

	public Esito() {
	}

	public Esito(String esito, String descrizioneEsito) {
		this.esito = esito;
		this.descrizioneEsito = descrizioneEsito;
	}

	public String getEsito() {
		return esito;
	}

	public void setEsito(String esito) {
		this.esito = esito;
	}

	public String getDescrizioneEsito() {
		return descrizioneEsito;
	}

	public void setDescrizioneEsito(String descrizioneEsito) {
		this.descrizioneEsito = descrizioneEsito;
	}

	public String getCodiceImpianto() {
		return codiceImpianto;
	}

	public void setCodiceImpianto(String codiceImpianto) {
		this.codiceImpianto = codiceImpianto;
	}

	public byte[] getXmlLibretto() {
		return xmlLibretto;
	}

	public void setXmlLibretto(byte[] xmlLibretto) {
		this.xmlLibretto = xmlLibretto;
	}

	public Integer getIdAllegatoNew() {
		return idAllegatoNew;
	}

	public void setIdAllegatoNew(Integer idAllegatoNew) {
		this.idAllegatoNew = idAllegatoNew;
	}
}
