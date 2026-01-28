package it.csi.citpwa.model;

import it.csi.citpwa.model.sigitext.UtenteLoggato;

import java.io.Serializable;

public class VerificaInsModel implements Serializable {

    private static final long serialVersionUID = 1L;

    VerificaModel verifica;
    UtenteLoggatoModel utenteLoggatoModel;

    public VerificaModel getVerifica() {
        return verifica;
    }

    public void setVerifica(VerificaModel verifica) {
        this.verifica = verifica;
    }

    public UtenteLoggatoModel getUtenteLoggatoModel() {
        return utenteLoggatoModel;
    }

    public void setUtenteLoggatoModel(UtenteLoggatoModel utenteLoggatoModel) {
        this.utenteLoggatoModel = utenteLoggatoModel;
    }

    @Override
    public String toString() {
        return "VerificaIns{" +
                "verifica=" + verifica +
                ", utenteLoggato=" + utenteLoggatoModel +
                '}';
    }
}
