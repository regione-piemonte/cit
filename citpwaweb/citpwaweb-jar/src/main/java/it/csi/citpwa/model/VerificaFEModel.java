package it.csi.citpwa.model;

import java.io.Serializable;

public class VerificaFEModel implements Serializable {

    private static final long serialVersionUID = 1L;

    Long idVerifica;
    String cfUtenteCaricamento;
    Long dtCaricamento;
    Integer fkTipoVerifica;
    Long codiceImpianto;
    String indirizzoSitad;
    String civico;
    Long numeroBollino;
    String siglaBollino;
    String fkDatoDistrib;
    Long dtSveglia;
    String noteSveglia;
    String note;



    public Long getIdVerifica() {
        return idVerifica;
    }

    public void setIdVerifica(Long idVerifica) {
        this.idVerifica = idVerifica;
    }

    public String getCfUtenteCaricamento() {
        return cfUtenteCaricamento;
    }

    public void setCfUtenteCaricamento(String cfUtenteCaricamento) {
        this.cfUtenteCaricamento = cfUtenteCaricamento;
    }

    public Long getDtCaricamento() {
        return dtCaricamento;
    }

    public void setDtCaricamento(Long dtCaricamento) {
        this.dtCaricamento = dtCaricamento;
    }

    public Integer getFkTipoVerifica() {
        return fkTipoVerifica;
    }

    public void setFkTipoVerifica(Integer fkTipoVerifica) {
        this.fkTipoVerifica = fkTipoVerifica;
    }

    public Long getCodiceImpianto() {
        return codiceImpianto;
    }

    public void setCodiceImpianto(Long codiceImpianto) {
        this.codiceImpianto = codiceImpianto;
    }

    public String getIndirizzoSitad() {
        return indirizzoSitad;
    }

    public void setIndirizzoSitad(String indirizzoSitad) {
        this.indirizzoSitad = indirizzoSitad;
    }

    public String getCivico() {
        return civico;
    }

    public void setCivico(String civico) {
        this.civico = civico;
    }

    public Long getNumeroBollino() {
        return numeroBollino;
    }

    public void setNumeroBollino(Long numeroBollino) {
        this.numeroBollino = numeroBollino;
    }

    public String getFkDatoDistrib() {
        return fkDatoDistrib;
    }

    public void setFkDatoDistrib(String fkDatoDistrib) {
        this.fkDatoDistrib = fkDatoDistrib;
    }

    public Long getDtSveglia() {
        return dtSveglia;
    }

    public void setDtSveglia(Long dtSveglia) {
        this.dtSveglia = dtSveglia;
    }

    public String getNoteSveglia() {
        return noteSveglia;
    }

    public void setNoteSveglia(String noteSveglia) {
        this.noteSveglia = noteSveglia;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getSiglaBollino() {
        return siglaBollino;
    }

    public void setSiglaBollino(String siglaBollino) {
        this.siglaBollino = siglaBollino;
    }
}
