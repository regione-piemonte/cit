package it.csi.citpwa.model.sigitext;

import it.csi.citpwa.model.UtenteLoggatoModel;
import org.springframework.web.bind.annotation.RequestBody;

public class VerificaIns {

    Verifica verifica;
    UtenteLoggatoModel utenteLoggatoModel;

    public Verifica getVerifica() {
        return verifica;
    }

    public void setVerifica(Verifica verifica) {
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
                ", utenteLoggatoModel=" + utenteLoggatoModel +
                '}';
    }
}
