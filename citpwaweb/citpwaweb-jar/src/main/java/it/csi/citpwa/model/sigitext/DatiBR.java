package it.csi.citpwa.model.sigitext;

import java.io.Serializable;

public class DatiBR implements Serializable {

    private static final long serialVersionUID = 4822242742767870670L;

    private String desMarca;
    private String matricola;
    private String modello;

    public String getDesMarca() {
        return desMarca;
    }

    public void setDesMarca(String desMarca) {
        this.desMarca = desMarca;
    }

    public String getMatricola() {
        return matricola;
    }

    public void setMatricola(String matricola) {
        this.matricola = matricola;
    }

    public String getModello() {
        return modello;
    }

    public void setModello(String modello) {
        this.modello = modello;
    }
}
