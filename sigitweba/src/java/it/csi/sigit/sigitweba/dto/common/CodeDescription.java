package it.csi.sigit.sigitweba.dto.common;

public class CodeDescription implements java.io.Serializable {

	/// Field [code]
	private java.lang.String code = null;

	/**
	 * imposta il valore del campo [code]
	 * @param val
	 * @generated
	 */

	public void setCode(java.lang.String val) {
		code = val;
	}

	/**
	 * legge il valore del campo [code]
	 * @generated
	 */
	public java.lang.String getCode() {
		return code;
	}

	/// Field [description]
	private java.lang.String description = null;

	/**
	 * imposta il valore del campo [description]
	 * @param val
	 * @generated
	 */

	public void setDescription(java.lang.String val) {
		description = val;
	}

	/**
	 * legge il valore del campo [description]
	 * @generated
	 */
	public java.lang.String getDescription() {
		return description;
	}

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per la clusterizzazione della sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	/**
	 * Costruttore vuoto del DTO.
	 * @generated
	 */
	public CodeDescription() {
		super();

	}

	/**
	 * @generated
	 */
	public String toString() {
		/*PROTECTED REGION ID(R-923658398) ENABLED START*/
		/// inserire qui la logica desiderata per la rappresenatazione a stringa
		return super.toString();
		/*PROTECTED REGION END*/
	}
}
