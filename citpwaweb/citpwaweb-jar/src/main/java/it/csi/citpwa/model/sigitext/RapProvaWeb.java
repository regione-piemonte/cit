package it.csi.citpwa.model.sigitext;

import it.csi.citpwa.model.DatiRapProva;

import java.io.Serializable;
import java.util.List;

public class RapProvaWeb implements Serializable {

    private static final long serialVersionUID = -7012368246199783454L;

    private UtenteLoggato utenteLoggato;
    private DatiRapProva datiRapProva;
    private DatiRapProvaWebGt datiRapProvaWebGt;
    private DatiRapProvaWebGf datiRapProvaWebGf;
    private List<DatiGT> listDatiGt;
    private List<DatiGF> listDatiGf;
    private List<DatiBR> listDatiBR;
    private String docBase64;
    private String docName;

    public DatiRapProva getDatiRapProva() {
        return datiRapProva;
    }

    public void setDatiRapProva(DatiRapProva datiRapProva) {
        this.datiRapProva = datiRapProva;
    }

    public DatiRapProvaWebGt getDatiRapProvaWebGt() {
        return datiRapProvaWebGt;
    }

    public void setDatiRapProvaWebGt(DatiRapProvaWebGt datiRapProvaWebGt) {
        this.datiRapProvaWebGt = datiRapProvaWebGt;
    }

    public DatiRapProvaWebGf getDatiRapProvaWebGf() {
        return datiRapProvaWebGf;
    }

    public void setDatiRapProvaWebGf(DatiRapProvaWebGf datiRapProvaWebGf) {
        this.datiRapProvaWebGf = datiRapProvaWebGf;
    }

    public List<DatiGT> getListDatiGt() {
        return listDatiGt;
    }

    public void setListDatiGt(List<DatiGT> listDatiGt) {
        this.listDatiGt = listDatiGt;
    }

    public List<DatiGF> getListDatiGf() {
        return listDatiGf;
    }

    public void setListDatiGf(List<DatiGF> listDatiGf) {
        this.listDatiGf = listDatiGf;
    }

    public List<DatiBR> getListDatiBR() {
        return listDatiBR;
    }

    public void setListDatiBR(List<DatiBR> listDatiBR) {
        this.listDatiBR = listDatiBR;
    }

    public UtenteLoggato getUtenteLoggato() {
        return utenteLoggato;
    }

    public void setUtenteLoggato(UtenteLoggato utenteLoggato) {
        this.utenteLoggato = utenteLoggato;
    }

    public String getDocBase64() {
        return docBase64;
    }

    public void setDocBase64(String docBase64) {
        this.docBase64 = docBase64;
    }

    public String getDocName() {
        return docName;
    }

    public void setDocName(String docName) {
        this.docName = docName;
    }
}

