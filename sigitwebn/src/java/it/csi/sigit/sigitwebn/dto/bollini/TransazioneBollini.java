package it.csi.sigit.sigitwebn.dto.bollini;

public class TransazioneBollini implements java.io.Serializable {

	/// Field [idTransazione]
	private java.lang.Long idTransazione = null;

	/**
	 * imposta il valore del campo [idTransazione]
	 * @param val
	 * @generated
	 */

	public void setIdTransazione(java.lang.Long val) {
		idTransazione = val;
	}

	/**
	 * legge il valore del campo [idTransazione]
	 * @generated
	 */
	public java.lang.Long getIdTransazione() {
		return idTransazione;
	}

	/// Field [idStatoTransazione]
	private java.lang.Integer idStatoTransazione = null;

	/**
	 * imposta il valore del campo [idStatoTransazione]
	 * @param val
	 * @generated
	 */

	public void setIdStatoTransazione(java.lang.Integer val) {
		idStatoTransazione = val;
	}

	/**
	 * legge il valore del campo [idStatoTransazione]
	 * @generated
	 */
	public java.lang.Integer getIdStatoTransazione() {
		return idStatoTransazione;
	}

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per la clusterizzazione della sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	/**
	 * Costruttore vuoto del DTO.
	 * @generated
	 */
	public TransazioneBollini() {
		super();

	}

	/**
	 * @generated
	 */
	public String toString() {
		/*PROTECTED REGION ID(R1361004846) ENABLED START*/
		/// inserire qui la logica desiderata per la rappresenatazione a stringa
		return super.toString();
		/*PROTECTED REGION END*/
	}
}
