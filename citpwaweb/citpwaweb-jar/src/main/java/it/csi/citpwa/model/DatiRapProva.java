package it.csi.citpwa.model;

import java.math.BigDecimal;
import java.util.Date;

public class DatiRapProva {

    private BigDecimal idAllegato;
    private String desStatoRapp;
    private String desTipoDocumento;
    private Long dataControllo;
    private String elencoApparecchiature;

    private BigDecimal codiceImpianto;
    private BigDecimal idIspezione2018;
    private Long dtControllo;
    private String[] componenti;
    private BigDecimal fkStatoRapProva;
    private BigDecimal fkStatoRapp;


    private BigDecimal fkTipoDocumento;
    private String fOraArrivo;
    private String elencoCombustibili;
    private BigDecimal fkIspezIspet;

    public BigDecimal getFkTipoDocumento() {
        return fkTipoDocumento;
    }

    public void setFkTipoDocumento(BigDecimal fkTipoDocumento) {
        this.fkTipoDocumento = fkTipoDocumento;
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

    public BigDecimal getCodiceImpianto() {
        return codiceImpianto;
    }

    public void setCodiceImpianto(BigDecimal codiceImpianto) {
        this.codiceImpianto = codiceImpianto;
    }

    public BigDecimal getIdIspezione2018() {
        return idIspezione2018;
    }

    public void setIdIspezione2018(BigDecimal idIspezione2018) {
        this.idIspezione2018 = idIspezione2018;
    }

    public Long getDtControllo() {
        return dtControllo;
    }

    public void setDtControllo(Long dtControllo) {
        this.dtControllo = dtControllo;
    }

    public String[] getComponenti() {
        return componenti;
    }

    public void setComponenti(String[] componenti) {
        this.componenti = componenti;
    }

    public BigDecimal getFkStatoRapProva() {
        return fkStatoRapProva;
    }

    public void setFkStatoRapProva(BigDecimal fkStatoRapProva) {
        this.fkStatoRapProva = fkStatoRapProva;
    }

    public BigDecimal getFkStatoRapp() {
        return fkStatoRapp;
    }

    public void setFkStatoRapp(BigDecimal fkStatoRapp) {
        this.fkStatoRapp = fkStatoRapp;
    }
}
