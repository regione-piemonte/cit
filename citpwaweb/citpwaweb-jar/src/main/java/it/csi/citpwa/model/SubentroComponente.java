package it.csi.citpwa.model;


import it.csi.citpwa.model.sigitext.UtenteLoggato;

import java.util.List;

public class SubentroComponente {

    private UtenteLoggato utenteLoggato;
    private List<Componente> componenti;

    public UtenteLoggato getUtenteLoggato() {
        return utenteLoggato;
    }
    public void setUtenteLoggato(UtenteLoggato utenteLoggato) {
        this.utenteLoggato = utenteLoggato;
    }
    public List<Componente> getComponenti() {
        return componenti;
    }
    public void setComponenti(List<Componente> componenti) {
        this.componenti = componenti;
    }


}

