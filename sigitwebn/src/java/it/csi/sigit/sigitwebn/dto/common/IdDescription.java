package it.csi.sigit.sigitwebn.dto.common;

public class IdDescription implements java.io.Serializable {

	/// Field [id]
	private int id = 0;

	/**
	 * imposta il valore del campo [id]
	 * @param val
	 * @generated
	 */

	public void setId(int val) {
		id = val;
	}

	/**
	 * legge il valore del campo [id]
	 * @generated
	 */
	public int getId() {
		return id;
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
	public IdDescription() {
		super();

	}

	/**
	 * @generated
	 */
	public String toString() {
		/*PROTECTED REGION ID(R1263909684) ENABLED START*/
		/// inserire qui la logica desiderata per la rappresenatazione a stringa
		return super.toString();
		/*PROTECTED REGION END*/
	}
}
