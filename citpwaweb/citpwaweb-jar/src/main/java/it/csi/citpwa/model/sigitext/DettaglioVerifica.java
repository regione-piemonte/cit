package it.csi.citpwa.model.sigitext;

import java.io.Serializable;

public class DettaglioVerifica implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private DatiVerifica datiVerifica;
    private DatiImpianto datiImpianto;

    public DatiVerifica getDatiVerifica() {
        return datiVerifica;
    }
    public void setDatiVerifica(DatiVerifica datiVerifica) {
        this.datiVerifica = datiVerifica;
    }
    public DatiImpianto getDatiImpianto() {
        return datiImpianto;
    }
    public void setDatiImpianto(DatiImpianto datiImpianto) {
        this.datiImpianto = datiImpianto;
    }
}
