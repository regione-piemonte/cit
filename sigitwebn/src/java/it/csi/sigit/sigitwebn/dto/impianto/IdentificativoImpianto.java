package it.csi.sigit.sigitwebn.dto.impianto;

public class IdentificativoImpianto implements java.io.Serializable {

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

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per la clusterizzazione della sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	/**
	 * Costruttore vuoto del DTO.
	 * @generated
	 */
	public IdentificativoImpianto() {
		super();

	}

	/**
	 * @generated
	 */
	public String toString() {
		/*PROTECTED REGION ID(R-1312049684) ENABLED START*/
		/// inserire qui la logica desiderata per la rappresenatazione a stringa
		return super.toString();
		/*PROTECTED REGION END*/
	}
}
