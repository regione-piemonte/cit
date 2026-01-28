package it.csi.citpwa.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class IspezioneMassiva implements Serializable {

    private static final long serialVersionID = 1L;

    private String cfUtenteCaricamento;
    private BigDecimal dtCaricamento;
    private BigDecimal fkTipoVerifica;
    private BigDecimal[] codiceImpianto;
    private BigDecimal[] fkDatoDistrib;
    private BigDecimal flgIspPagamento;

    public String getCfUtenteCaricamento() {
        return cfUtenteCaricamento;
    }

    public void setCfUtenteCaricamento(String cfUtenteCaricamento) {
        this.cfUtenteCaricamento = cfUtenteCaricamento;
    }

    public BigDecimal getDtCaricamento() {
        return dtCaricamento;
    }

    public void setDtCaricamento(BigDecimal dtCaricamento) {
        this.dtCaricamento = dtCaricamento;
    }

    public BigDecimal getFkTipoVerifica() {
        return fkTipoVerifica;
    }

    public void setFkTipoVerifica(BigDecimal fkTipoVerifica) {
        this.fkTipoVerifica = fkTipoVerifica;
    }

    public BigDecimal[] getCodiceImpianto() {
        return codiceImpianto;
    }

    public void setCodiceImpianto(BigDecimal[] codiceImpianto) {
        this.codiceImpianto = codiceImpianto;
    }

    public BigDecimal[] getFkDatoDistrib() {
        return fkDatoDistrib;
    }

    public void setFkDatoDistrib(BigDecimal[] fkDatoDistrib) {
        this.fkDatoDistrib = fkDatoDistrib;
    }

    public BigDecimal getFlgIspPagamento() {
        return flgIspPagamento;
    }

    public void setFlgIspPagamento(BigDecimal flgIspPagamento) {
        this.flgIspPagamento = flgIspPagamento;
    }
}
