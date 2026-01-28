package it.csi.citpwa.model.sigitext;

import it.csi.citpwa.model.DatiRapProva;
import it.csi.citpwa.model.sigitext.RapProva.DatiGF;
import it.csi.citpwa.model.sigitext.RapProva.DatiGT;

import java.io.Serializable;
import java.util.List;

public class RapportoDiProva
{

    private UtenteLoggato utenteLoggato;
    private DatiRapProva datiRapProva;
    private List<DatiGT> datiGt;
    private List<DatiGF> datiGf;
    private DocumentoPwa documentoPwa;

    public DocumentoPwa getDocumentoPwa() {
        return documentoPwa;
    }

    public void setDocumentoPwa(DocumentoPwa documentoPwa) {
        this.documentoPwa = documentoPwa;
    }

    public UtenteLoggato getUtenteLoggato() {
        return utenteLoggato;
    }

    public void setUtenteLoggato(UtenteLoggato utenteLoggato) {
        this.utenteLoggato = utenteLoggato;
    }

    public DatiRapProva getDatiRapProva() {
        return datiRapProva;
    }

    public void setDatiRapProva(DatiRapProva datiRapProva) {
        this.datiRapProva = datiRapProva;
    }

    public List<DatiGT> getDatiGt() {
        return datiGt;
    }

    public void setDatiGt(List<DatiGT> datiGt) {
        this.datiGt = datiGt;
    }

    public List<DatiGF> getDatiGf() {
        return datiGf;
    }

    public void setDatiGf(List<DatiGF> datiGf) {
        this.datiGf = datiGf;
    }
}
