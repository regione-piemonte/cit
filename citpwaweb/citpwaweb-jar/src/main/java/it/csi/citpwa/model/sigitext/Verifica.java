package it.csi.citpwa.model.sigitext;

import java.io.Serializable;

public class Verifica implements Serializable {

    private static final long serialVersionUID = 1L;

    private String identificativo;
    private Integer tipoVerifica;
    private String descrizioneTipoVerifica;
    private String idAllegato;
    private String idDatoDistributore;
    private String codiceImpianto;
    private String cfUtenteCaricamento;
    private String denomUtenteCaricamento;
    private String dataCaricamento;
    private String siglaBollino;
    private String numeroBollino;
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

    public String getDataCaricamento() {
        return dataCaricamento;
    }

    public void setDataCaricamento(String dataCaricamento) {
        this.dataCaricamento = dataCaricamento;
    }

    public String getSiglaBollino() {
        return siglaBollino;
    }

    public void setSiglaBollino(String siglaBollino) {
        this.siglaBollino = siglaBollino;
    }

    public String getNumeroBollino() {
        return numeroBollino;
    }

    public void setNumeroBollino(String numeroBollino) {
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

    public String getIdentificativo() {
        return identificativo;
    }

    public void setIdentificativo(String identificativo) {
        this.identificativo = identificativo;
    }

    @Override
    public String toString() {
        return "Verifica{" +
                "tipoVerifica=" + tipoVerifica +
                ", descrizioneTipoVerifica='" + descrizioneTipoVerifica + '\'' +
                ", idAllegato='" + idAllegato + '\'' +
                ", idDatoDistributore='" + idDatoDistributore + '\'' +
                ", codiceImpianto='" + codiceImpianto + '\'' +
                ", cfUtenteCaricamento='" + cfUtenteCaricamento + '\'' +
                ", denomUtenteCaricamento='" + denomUtenteCaricamento + '\'' +
                ", dataCaricamento='" + dataCaricamento + '\'' +
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
