package it.csi.sigit.sigitweba.dto.accreditamento_tns;

public class Formazione implements java.io.Serializable {

	/// Field [dataCorso]
	private java.lang.String dataCorso = null;

	/**
	 * imposta il valore del campo [dataCorso]
	 * @param val
	 * @generated
	 */

	public void setDataCorso(java.lang.String val) {
		dataCorso = val;
	}

	/**
	 * legge il valore del campo [dataCorso]
	 * @generated
	 */
	public java.lang.String getDataCorso() {
		return dataCorso;
	}

	/// Field [descCorso]
	private java.lang.String descCorso = null;

	/**
	 * imposta il valore del campo [descCorso]
	 * @param val
	 * @generated
	 */

	public void setDescCorso(java.lang.String val) {
		descCorso = val;
	}

	/**
	 * legge il valore del campo [descCorso]
	 * @generated
	 */
	public java.lang.String getDescCorso() {
		return descCorso;
	}

	/// Field [idPersonaFisica]
	private java.lang.String idPersonaFisica = null;

	/**
	 * imposta il valore del campo [idPersonaFisica]
	 * @param val
	 * @generated
	 */

	public void setIdPersonaFisica(java.lang.String val) {
		idPersonaFisica = val;
	}

	/**
	 * legge il valore del campo [idPersonaFisica]
	 * @generated
	 */
	public java.lang.String getIdPersonaFisica() {
		return idPersonaFisica;
	}

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per la clusterizzazione della sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	/**
	 * Costruttore vuoto del DTO.
	 * @generated
	 */
	public Formazione() {
		super();

	}

	/**
	 * @generated
	 */
	public String toString() {
		/*PROTECTED REGION ID(R1959306425) ENABLED START*/
		/// inserire qui la logica desiderata per la rappresenatazione a stringa
		return super.toString();
		/*PROTECTED REGION END*/
	}
}
