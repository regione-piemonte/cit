package it.csi.sigit.sigitwebn.dto.distributori;

public class DettaglioErrore implements java.io.Serializable {

	/// Field [idErrore]
	private java.lang.Integer idErrore = null;

	/**
	 * imposta il valore del campo [idErrore]
	 * @param val
	 * @generated
	 */

	public void setIdErrore(java.lang.Integer val) {
		idErrore = val;
	}

	/**
	 * legge il valore del campo [idErrore]
	 * @generated
	 */
	public java.lang.Integer getIdErrore() {
		return idErrore;
	}

	/// Field [descErrore]
	private java.lang.String descErrore = null;

	/**
	 * imposta il valore del campo [descErrore]
	 * @param val
	 * @generated
	 */

	public void setDescErrore(java.lang.String val) {
		descErrore = val;
	}

	/**
	 * legge il valore del campo [descErrore]
	 * @generated
	 */
	public java.lang.String getDescErrore() {
		return descErrore;
	}

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per la clusterizzazione della sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	/**
	 * Costruttore vuoto del DTO.
	 * @generated
	 */
	public DettaglioErrore() {
		super();

	}

	/**
	 * @generated
	 */
	public String toString() {
		/*PROTECTED REGION ID(R-1053809276) ENABLED START*/
		/// inserire qui la logica desiderata per la rappresenatazione a stringa
		return super.toString();
		/*PROTECTED REGION END*/
	}
}
