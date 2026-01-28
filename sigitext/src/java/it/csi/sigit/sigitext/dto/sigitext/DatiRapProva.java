package it.csi.sigit.sigitext.dto.sigitext;

import java.io.Serializable;
import java.math.BigDecimal;

public class DatiRapProva implements Serializable{
	
    /**
	 * 
	 */
	private static final long serialVersionUID = -4347375212240198892L;
	private BigDecimal idAllegato;
    private String desStatoRapp; 
    private String desTipoDocumento;
    private Long dataControllo;    
    private String elencoApparecchiature;
    private BigDecimal fkStatoRapp;
    private BigDecimal codiceImpianto;
    private BigDecimal fkTipoDocumento;
    private String fOraArrivo;
    private String elencoCombustibili;
    private BigDecimal fkIspezIspet;
    private BigDecimal idIspezione2018;
    
	public BigDecimal getFkTipoDocumento() {
		return fkTipoDocumento;
	}
	public void setFkTipoDocumento(BigDecimal fkTipoDocumento) {
		this.fkTipoDocumento = fkTipoDocumento;
	}
	public BigDecimal getIdAllegato() {
		return idAllegato;
	}
	public void setIdAllegato(BigDecimal idAllegato) {
		this.idAllegato = idAllegato;
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
	public String getElencoApparecchiature() {
		return elencoApparecchiature;
	}
	public void setElencoApparecchiature(String elencoApparecchiature) {
		this.elencoApparecchiature = elencoApparecchiature;
	}
	public BigDecimal getFkStatoRapp() {
		return fkStatoRapp;
	}
	public void setFkStatoRapp(BigDecimal fkStatoRapp) {
		this.fkStatoRapp = fkStatoRapp;
	}
	public BigDecimal getCodiceImpianto() {
		return codiceImpianto;
	}
	public void setCodiceImpianto(BigDecimal codiceImpianto) {
		this.codiceImpianto = codiceImpianto;
	}
	public String getfOraArrivo() {
		return fOraArrivo;
	}
	public void setfOraArrivo(String fOraArrivo) {
		this.fOraArrivo = fOraArrivo;
	}
	public String getElencoCombustibili() {
		return elencoCombustibili;
	}
	public void setElencoCombustibili(String elencoCombustibili) {
		this.elencoCombustibili = elencoCombustibili;
	}
	public BigDecimal getFkIspezIspet() {
		return fkIspezIspet;
	}
	public void setFkIspezIspet(BigDecimal fkIspezIspet) {
		this.fkIspezIspet = fkIspezIspet;
	}
	public BigDecimal getIdIspezione2018() {
		return idIspezione2018;
	}
	public void setIdIspezione2018(BigDecimal idIspezione2018) {
		this.idIspezione2018 = idIspezione2018;
	}
    
    

}
