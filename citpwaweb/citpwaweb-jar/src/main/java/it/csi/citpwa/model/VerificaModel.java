package it.csi.citpwa.model;

import it.csi.citpwa.model.sigitext.ElencoAzioniSvolte;

import java.io.Serializable;

public class VerificaModel implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer tipoVerifica;
    private String descrizioneTipoVerifica;
    private String idAllegato;
    private String idDatoDistributore;
    private String codiceImpianto;
    private String cfUtenteCaricamento;
    private String denomUtenteCaricamento;
    private Long dataCaricamento;
    private String siglaBollino;
    private Integer numeroBollino;
    private String dataSveglia = null;
    private String dataSvegliaDes = null;
    private String noteSveglia = null;
    private String descrizioneSveglia = null;
    private String note = null;



    public Integer getTipoVerifica() {
        return tipoVerifica;
    }

    public void setTipoVerifica(Integer tipoVerifica) {
        this.tipoVerifica = tipoVerifica;
    }

    public String getDescrizioneTipoVerifica() {
        return descrizioneTipoVerifica;
    }

    public void setDescrizioneTipoVerifica(String descrizioneTipoVerifica) {
        this.descrizioneTipoVerifica = descrizioneTipoVerifica;
    }

    public String getIdAllegato() {
        return idAllegato;
    }

    public void setIdAllegato(String idAllegato) {
        this.idAllegato = idAllegato;
    }

    public String getIdDatoDistributore() {
        return idDatoDistributore;
    }

    public void setIdDatoDistributore(String idDatoDistributore) {
        this.idDatoDistributore = idDatoDistributore;
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

    public Long getDataCaricamento() {
        return dataCaricamento;
    }

    public void setDataCaricamento(Long dataCaricamento) {
        this.dataCaricamento = dataCaricamento;
    }

    public String getSiglaBollino() {
        return siglaBollino;
    }

    public void setSiglaBollino(String siglaBollino) {
        this.siglaBollino = siglaBollino;
    }

    public Integer getNumeroBollino() {
        return numeroBollino;
    }

    public void setNumeroBollino(Integer numeroBollino) {
        this.numeroBollino = numeroBollino;
    }

    public String getDataSveglia() {
        return dataSveglia;
    }

    public void setDataSveglia(String dataSveglia) {
        this.dataSveglia = dataSveglia;
    }

    public String getDataSvegliaDes() {
        return dataSvegliaDes;
    }

    public void setDataSvegliaDes(String dataSvegliaDes) {
        this.dataSvegliaDes = dataSvegliaDes;
    }

    public String getNoteSveglia() {
        return noteSveglia;
    }

    public void setNoteSveglia(String noteSveglia) {
        this.noteSveglia = noteSveglia;
    }

    public String getDescrizioneSveglia() {
        return descrizioneSveglia;
    }

    public void setDescrizioneSveglia(String descrizioneSveglia) {
        this.descrizioneSveglia = descrizioneSveglia;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "VerificaModel{" +
                "tipoVerifica=" + tipoVerifica +
                ", descrizioneTipoVerifica='" + descrizioneTipoVerifica + '\'' +
                ", idAllegato='" + idAllegato + '\'' +
                ", idDatoDistributore='" + idDatoDistributore + '\'' +
                ", codiceImpianto='" + codiceImpianto + '\'' +
                ", cfUtenteCaricamento='" + cfUtenteCaricamento + '\'' +
                ", denomUtenteCaricamento='" + denomUtenteCaricamento + '\'' +
                ", dataCaricamento=" + dataCaricamento +
                ", siglaBollino='" + siglaBollino + '\'' +
                ", numeroBollino='" + numeroBollino + '\'' +
                ", dataSveglia='" + dataSveglia + '\'' +
                ", dataSvegliaDes='" + dataSvegliaDes + '\'' +
                ", noteSveglia='" + noteSveglia + '\'' +
                ", descrizioneSveglia='" + descrizioneSveglia + '\'' +
                ", note='" + note + '\'' +
                '}';
    }
}
