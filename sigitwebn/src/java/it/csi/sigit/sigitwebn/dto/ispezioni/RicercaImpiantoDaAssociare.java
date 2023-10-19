package it.csi.sigit.sigitwebn.dto.ispezioni;

public class RicercaImpiantoDaAssociare implements java.io.Serializable {

	/// Field [codiceImpianto]
	private java.lang.String codiceImpianto = null;

	/**
	 * imposta il valore del campo [codiceImpianto]
	 * @param val
	 * @generated
	 */

	public void setCodiceImpianto(java.lang.String val) {
		codiceImpianto = val;
	}

	/**
	 * legge il valore del campo [codiceImpianto]
	 * @generated
	 */
	public java.lang.String getCodiceImpianto() {
		return codiceImpianto;
	}

	/// Field [codIstatProv]
	private java.lang.String codIstatProv = null;

	/**
	 * imposta il valore del campo [codIstatProv]
	 * @param val
	 * @generated
	 */

	public void setCodIstatProv(java.lang.String val) {
		codIstatProv = val;
	}

	/**
	 * legge il valore del campo [codIstatProv]
	 * @generated
	 */
	public java.lang.String getCodIstatProv() {
		return codIstatProv;
	}

	/// Field [ubicazione]
	private java.lang.String ubicazione = null;

	/**
	 * imposta il valore del campo [ubicazione]
	 * @param val
	 * @generated
	 */

	public void setUbicazione(java.lang.String val) {
		ubicazione = val;
	}

	/**
	 * legge il valore del campo [ubicazione]
	 * @generated
	 */
	public java.lang.String getUbicazione() {
		return ubicazione;
	}

	/// Field [responsabile]
	private java.lang.String responsabile = null;

	/**
	 * imposta il valore del campo [responsabile]
	 * @param val
	 * @generated
	 */

	public void setResponsabile(java.lang.String val) {
		responsabile = val;
	}

	/**
	 * legge il valore del campo [responsabile]
	 * @generated
	 */
	public java.lang.String getResponsabile() {
		return responsabile;
	}

	/// Field [ricercaEseguita]
	private boolean ricercaEseguita = false;

	/**
	 * imposta il valore del campo [ricercaEseguita]
	 * @param val
	 * @generated
	 */

	public void setRicercaEseguita(boolean val) {
		ricercaEseguita = val;
	}

	/**
	 * legge il valore del campo [ricercaEseguita]
	 * @generated
	 */
	public boolean getRicercaEseguita() {
		return ricercaEseguita;
	}

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per la clusterizzazione della sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	/**
	 * Costruttore vuoto del DTO.
	 * @generated
	 */
	public RicercaImpiantoDaAssociare() {
		super();

	}

	/**
	 * @generated
	 */
	public String toString() {
		/*PROTECTED REGION ID(R-1928511615) ENABLED START*/
		/// inserire qui la logica desiderata per la rappresenatazione a stringa
		return super.toString();
		/*PROTECTED REGION END*/
	}
}
