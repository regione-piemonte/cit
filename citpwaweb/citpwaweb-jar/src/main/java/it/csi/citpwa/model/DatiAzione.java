package it.csi.citpwa.model;

import java.math.BigDecimal;
import java.util.Date;

public class DatiAzione {

    private BigDecimal idAzione;
    private Long dtAzione;
    private BigDecimal fkTipoAzione;
    private BigDecimal idVerifica;
    private BigDecimal idAccertamento;
    private BigDecimal idIspezione2018;
    private BigDecimal idSanzione;
    private String  descrizioneAzione;
    private String cfUtenteAzione;
    private String denomUtenteAzione;
    private String nomeDocOriginale;
    private String nomeDoc;
    private String uidIndex;
    private String mimeTypeDoc;

    private String docBase64;
    private String docContentType;

    public String getMimeTypeDoc() {
        return mimeTypeDoc;
    }

    public void setMimeTypeDoc(String mimeTypeDoc) {
        this.mimeTypeDoc = mimeTypeDoc;
    }

    public BigDecimal getIdAzione() {
        return idAzione;
    }

    public void setIdAzione(BigDecimal idAzione) {
        this.idAzione = idAzione;
    }

    public Long getDtAzione() {
        return dtAzione;
    }

    public void setDtAzione(Long dtAzione) {
        this.dtAzione = dtAzione;
    }

    public BigDecimal getFkTipoAzione() {
        return fkTipoAzione;
    }

    public void setFkTipoAzione(BigDecimal fkTipoAzione) {
        this.fkTipoAzione = fkTipoAzione;
    }

    public BigDecimal getIdVerifica() {
        return idVerifica;
    }

    public void setIdVerifica(BigDecimal idVerifica) {
        this.idVerifica = idVerifica;
    }

    public BigDecimal getIdAccertamento() {
        return idAccertamento;
    }

    public void setIdAccertamento(BigDecimal idAccertamento) {
        this.idAccertamento = idAccertamento;
    }

    public BigDecimal getIdIspezione2018() {
        return idIspezione2018;
    }

    public void setIdIspezione2018(BigDecimal idIspezione2018) {
        this.idIspezione2018 = idIspezione2018;
    }

    public BigDecimal getIdSanzione() {
        return idSanzione;
    }

    public void setIdSanzione(BigDecimal idSanzione) {
        this.idSanzione = idSanzione;
    }

    public String getDescrizioneAzione() {
        return descrizioneAzione;
    }

    public void setDescrizioneAzione(String descrizioneAzione) {
        this.descrizioneAzione = descrizioneAzione;
    }

    public String getCfUtenteAzione() {
        return cfUtenteAzione;
    }

    public void setCfUtenteAzione(String cfUtenteAzione) {
        this.cfUtenteAzione = cfUtenteAzione;
    }

    public String getDenomUtenteAzione() {
        return denomUtenteAzione;
    }

    public void setDenomUtenteAzione(String denomUtenteAzione) {
        this.denomUtenteAzione = denomUtenteAzione;
    }

    public String getNomeDocOriginale() {
        return nomeDocOriginale;
    }

    public void setNomeDocOriginale(String nomeDocOriginale) {
        this.nomeDocOriginale = nomeDocOriginale;
    }

    public String getNomeDoc() {
        return nomeDoc;
    }

    public void setNomeDoc(String nomeDoc) {
        this.nomeDoc = nomeDoc;
    }

    public String getUidIndex() {
        return uidIndex;
    }

    public void setUidIndex(String uidIndex) {
        this.uidIndex = uidIndex;
    }

    public String getDocBase64() {
        return docBase64;
    }

    public void setDocBase64(String docBase64) {
        this.docBase64 = docBase64;
    }

    public String getDocContentType() {
        return docContentType;
    }

    public void setDocContentType(String docContentType) {
        this.docContentType = docContentType;
    }
}
