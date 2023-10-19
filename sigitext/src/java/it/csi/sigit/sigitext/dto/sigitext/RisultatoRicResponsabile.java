package it.csi.sigit.sigitext.dto.sigitext;

public class RisultatoRicResponsabile implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private Integer idImpResp = null;
	private String denominazione = null;
	private String descTitolo = null;
	private String dataRespDal = null;
	private String dataRespAl = null;
	private String isImpresa = null;
	private Integer idTitolo = null;
	private Integer idPersona = null;

	public void setIdImpResp(Integer val) {
		idImpResp = val;
	}

	public Integer getIdImpResp() {
		return idImpResp;
	}

	public void setDenominazione(String val) {
		denominazione = val;
	}

	public String getDenominazione() {
		return denominazione;
	}

	public void setDescTitolo(String val) {
		descTitolo = val;
	}

	public String getDescTitolo() {
		return descTitolo;
	}

	public void setDataRespDal(String val) {
		dataRespDal = val;
	}

	public String getDataRespDal() {
		return dataRespDal;
	}

	public void setDataRespAl(String val) {
		dataRespAl = val;
	}

	public String getDataRespAl() {
		return dataRespAl;
	}

	public void setIsImpresa(String val) {
		isImpresa = val;
	}

	public String getIsImpresa() {
		return isImpresa;
	}

	public void setIdTitolo(Integer val) {
		idTitolo = val;
	}

	public Integer getIdTitolo() {
		return idTitolo;
	}

	public void setIdPersona(Integer val) {
		idPersona = val;
	}

	public Integer getIdPersona() {
		return idPersona;
	}

	public RisultatoRicResponsabile() {
		super();

	}

	@Override
	public String toString() {
		return "RisultatoRicResponsabile{" + "idImpResp=" + idImpResp + ", denominazione='" + denominazione + '\'' + ", descTitolo='" + descTitolo + '\'' + ", dataRespDal='" + dataRespDal + '\''
				+ ", dataRespAl='" + dataRespAl + '\'' + ", isImpresa='" + isImpresa + '\'' + ", idTitolo=" + idTitolo + ", idPersona=" + idPersona + '}';
	}
}
