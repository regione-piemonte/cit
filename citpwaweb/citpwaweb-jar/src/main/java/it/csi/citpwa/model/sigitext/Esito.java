package it.csi.citpwa.model.sigitext;

import it.csi.sigit.sigitext.ws.service.client.Impianto;

public class Esito {
	private String esito;
	private String descrizioneEsito;
	private String codiceImpianto;
	private Integer idAllegatoNew;
	private byte[] xmlLibretto;
	private Boolean impiantoNonConformeDlgs1022014;

	private Long idVerifica;
	private Long idAzione;
	private Long idIspezione2018;

	private Impianto[] impiantoArray;

	public Esito() {
	}

	public Esito(String esito, String descrizioneEsito) {
		this.esito = esito;
		this.descrizioneEsito = descrizioneEsito;
	}

	public Esito(String esito, String descrizioneEsito, Integer idAllegatoNew) {
		this.esito = esito;
		this.descrizioneEsito = descrizioneEsito;
		this.idAllegatoNew = idAllegatoNew;
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

	public Long getIdVerifica() {
		return idVerifica;
	}

	public void setIdVerifica(Long idVerifica) {
		this.idVerifica = idVerifica;
	}

	public Long getIdAzione() {
		return idAzione;
	}

	public void setIdAzione(Long idAzione) {
		this.idAzione = idAzione;
	}

	public Long getIdIspezione2018() {
		return idIspezione2018;
	}

	public void setIdIspezione2018(Long idIspezione2018) {
		this.idIspezione2018 = idIspezione2018;
	}

	public Impianto[] getImpiantoArray() {
		return impiantoArray;
	}

	public void setImpiantoArray(Impianto[] impiantoArray) {
		this.impiantoArray = impiantoArray;
	}

	public Boolean getImpiantoNonConformeDlgs1022014() {
		return impiantoNonConformeDlgs1022014;
	}

	public void setImpiantoNonConformeDlgs1022014(Boolean impiantoNonConformeDlgs1022014) {
		this.impiantoNonConformeDlgs1022014 = impiantoNonConformeDlgs1022014;
	}
}
