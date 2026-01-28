package it.csi.citpwa.model;

public class UtenteLoggatoModel {

    /// Field [denominazione]
    private String denominazione = null;

    /**
     * imposta il valore del campo [denominazione]
     * @param val
     * @generated
     */

    public void setDenominazione(String val) {
        denominazione = val;
    }

    /**
     * legge il valore del campo [denominazione]
     * @generated
     */
    public String getDenominazione() {
        return denominazione;
    }

    /// Field [codiceFiscale]
    private String codiceFiscale = null;

    /**
     * imposta il valore del campo [codiceFiscale]
     * @param val
     * @generated
     */

    public void setCodiceFiscale(String val) {
        codiceFiscale = val;
    }

    /**
     * legge il valore del campo [codiceFiscale]
     * @generated
     */
    public String getCodiceFiscale() {
        return codiceFiscale;
    }


    // il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
    // solo per la clusterizzazione della sessione web e non viene scambiata con altre
    // componenti.
    private static final long serialVersionUID = 1L;



}
