package it.csi.sigit.sigitext.dto.sigitext;

import java.io.Serializable;
import java.math.BigDecimal;


public class Controlli implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    private int idAllegato;
    private BigDecimal codiceImpianto;
    private String desStatoRapp;
    private String desTipoDocumento;
    private Long dataControllo;
    private Long fInterventoEntro;
    private String elencoApparecchiature;
    //xml
	public int getIdAllegato() {
		return idAllegato;
	}
	public void setIdAllegato(int idAllegato) {
		this.idAllegato = idAllegato;
	}
	public BigDecimal getCodiceImpianto() {
		return codiceImpianto;
	}
	public void setCodiceImpianto(BigDecimal codiceImpianto) {
		this.codiceImpianto = codiceImpianto;
	}
	public String getDesStatoRapp() {
		return desStatoRapp;
	}
	public void setDesStatoRapp(String desStatoRapp) {
		this.desStatoRapp = desStatoRapp;
	}
	public String getDesTipoDocumento() {
		return desTipoDocumento;
	}
	public void setDesTipoDocumento(String desTipoDocumento) {
		this.desTipoDocumento = desTipoDocumento;
	}
	public Long getDataControllo() {
		return dataControllo;
	}
	public void setDataControllo(Long dataControllo) {
		this.dataControllo = dataControllo;
	}
	public Long getfInterventoEntro() {
		return fInterventoEntro;
	}
	public void setfInterventoEntro(Long fInterventoEntro) {
		this.fInterventoEntro = fInterventoEntro;
	}
	public String getElencoApparecchiature() {
		return elencoApparecchiature;
	}
	public void setElencoApparecchiature(String elencoApparecchiature) {
		this.elencoApparecchiature = elencoApparecchiature;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Controlli [idAllegato=" + idAllegato + ", codiceImpianto=" + codiceImpianto + ", desStatoRapp="
				+ desStatoRapp + ", desTipoDocumento=" + desTipoDocumento + ", dataControllo=" + dataControllo
				+ ", fInterventoEntro=" + fInterventoEntro + ", elencoApparecchiature=" + elencoApparecchiature + "]";
	}
    
    

}
