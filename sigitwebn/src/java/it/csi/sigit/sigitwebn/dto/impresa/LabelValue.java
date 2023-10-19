package it.csi.sigit.sigitwebn.dto.impresa;

public class LabelValue implements java.io.Serializable {

	/// Field [label]
	private java.lang.String label = null;

	/**
	 * imposta il valore del campo [label]
	 * @param val
	 * @generated
	 */

	public void setLabel(java.lang.String val) {
		label = val;
	}

	/**
	 * legge il valore del campo [label]
	 * @generated
	 */
	public java.lang.String getLabel() {
		return label;
	}

	/// Field [value]
	private java.lang.String value = null;

	/**
	 * imposta il valore del campo [value]
	 * @param val
	 * @generated
	 */

	public void setValue(java.lang.String val) {
		value = val;
	}

	/**
	 * legge il valore del campo [value]
	 * @generated
	 */
	public java.lang.String getValue() {
		return value;
	}

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per la clusterizzazione della sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	/**
	 * Costruttore vuoto del DTO.
	 * @generated
	 */
	public LabelValue() {
		super();

	}

	/**
	 * @generated
	 */
	public String toString() {
		/*PROTECTED REGION ID(R-1031999416) ENABLED START*/
		/// inserire qui la logica desiderata per la rappresenatazione a stringa
		return super.toString();
		/*PROTECTED REGION END*/
	}
}
