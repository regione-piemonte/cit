package it.csi.citpwa.model;

import java.io.Serializable;
import java.util.Date;

public class DatiVerificaModel implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private int idVerifica;
    private int fkTipoVerifica;
    private String desTipoVerifica;
    private int fkAllegato;
    private int fkDatoDistrib;
    private String codiceImpianto;
    private String cfUtenteCaricamento;
    private String denomUtenteCaricamento;
    private Long dtCaricamento;
    private String siglaBollino;
    private String numeroBollino;
    private Long dtSveglia;
    private String noteSveglia;
    private String note;

    public int getIdVerifica() {
        return idVerifica;
    }
    public void setIdVerifica(int idVerifica) {
        this.idVerifica = idVerifica;
    }
    public int getFkTipoVerifica() {
        return fkTipoVerifica;
    }
    public void setFkTipoVerifica(int fkTipoVerifica) {
        this.fkTipoVerifica = fkTipoVerifica;
    }
    public String getDesTipoVerifica() {
        return desTipoVerifica;
    }
    public void setDesTipoVerifica(String desTipoVerifica) {
        this.desTipoVerifica = desTipoVerifica;
    }
    public int getFkAllegato() {
        return fkAllegato;
    }
    public void setFkAllegato(int fkAllegato) {
        this.fkAllegato = fkAllegato;
    }
    public int getFkDatoDistrib() {
        return fkDatoDistrib;
    }
    public void setFkDatoDistrib(int fkDatoDistrib) {
        this.fkDatoDistrib = fkDatoDistrib;
    }
    public String getCodiceImpianto() {
        return codiceImpianto;
    }
    public void setCodiceImpianto(String codiceImpianto) {
        this.codiceImpianto = codiceImpianto;
    }
    public String getCfUtenteCaricamento() {
        return cfUtenteCaricamento;
    }
    public void setCfUtenteCaricamento(String cfUtenteCaricamento) {
        this.cfUtenteCaricamento = cfUtenteCaricamento;
    }
    public String getDenomUtenteCaricamento() {
        return denomUtenteCaricamento;
    }
    public void setDenomUtenteCaricamento(String denomUtenteCaricamento) {
        this.denomUtenteCaricamento = denomUtenteCaricamento;
    }
    public Long getDtCaricamento() {
        return dtCaricamento;
    }
    public void setDtCaricamento(Long dtCaricamento) {
        this.dtCaricamento = dtCaricamento;
    }
    public String getSiglaBollino() {
        return siglaBollino;
    }
    public void setSiglaBollino(String siglaRee) {
        this.siglaBollino = siglaRee;
    }
    public String getNumeroBollino() {
        return numeroBollino;
    }
    public void setNumeroBollino(String numeroRee) {
        this.numeroBollino = numeroRee;
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
    @Override
    public String toString() {
        return "DatiVerifica [idVerifica=" + idVerifica + ", fkTipoVerifica=" + fkTipoVerifica + ", desTipoVerifica="
                + desTipoVerifica + ", fkAllegato=" + fkAllegato + ", fkDatoDistrib=" + fkDatoDistrib
                + ", codiceImpianto=" + codiceImpianto + ", cfUtenteCaricamento=" + cfUtenteCaricamento
                + ", denomUtenteCaricamento=" + denomUtenteCaricamento + ", dtCaricamento=" + dtCaricamento
                + ", siglaRee=" + siglaBollino + ", numeroRee=" + numeroBollino + ", dtSveglia=" + dtSveglia + ", noteSveglia="
                + noteSveglia + ", note=" + note + "]";
    }
}
