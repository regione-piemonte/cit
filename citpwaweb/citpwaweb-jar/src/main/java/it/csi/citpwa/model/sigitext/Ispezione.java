package it.csi.citpwa.model.sigitext;

import java.io.Serializable;

public class Ispezione  implements Serializable {

    private static final long serialVersionUID = 6928169192056024049L;

    private DatiIspezione datiIspezione;
    private UtenteLoggato utenteLoggato;
    private Persona persona;

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public DatiIspezione getDatiIspezione() {
        return datiIspezione;
    }
    public void setDatiIspezione(DatiIspezione datiIspezione) {
        this.datiIspezione = datiIspezione;
    }
    public UtenteLoggato getUtenteLoggato() {
        return utenteLoggato;
    }
    public void setUtenteLoggato(UtenteLoggato utenteLoggato) {
        this.utenteLoggato = utenteLoggato;
    }
    @Override
    public String toString() {
        return "ConcludiIspezione [datiIspezione=" + datiIspezione + ", utenteLoggato=" + utenteLoggato + "]";
    }
}
