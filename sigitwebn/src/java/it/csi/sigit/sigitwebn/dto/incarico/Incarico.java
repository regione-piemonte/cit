package it.csi.sigit.sigitwebn.dto.incarico;

public class Incarico implements java.io.Serializable {

	/// Field [impId]
	private java.lang.Integer impId = null;

	/**
	 * imposta il valore del campo [impId]
	 * @param val
	 * @generated
	 */

	public void setImpId(java.lang.Integer val) {
		impId = val;
	}

	/**
	 * legge il valore del campo [impId]
	 * @generated
	 */
	public java.lang.Integer getImpId() {
		return impId;
	}

	/// Field [impCf]
	private java.lang.String impCf = null;

	/**
	 * imposta il valore del campo [impCf]
	 * @param val
	 * @generated
	 */

	public void setImpCf(java.lang.String val) {
		impCf = val;
	}

	/**
	 * legge il valore del campo [impCf]
	 * @generated
	 */
	public java.lang.String getImpCf() {
		return impCf;
	}

	/// Field [impIdSiglaRea]
	private java.lang.String impIdSiglaRea = null;

	/**
	 * imposta il valore del campo [impIdSiglaRea]
	 * @param val
	 * @generated
	 */

	public void setImpIdSiglaRea(java.lang.String val) {
		impIdSiglaRea = val;
	}

	/**
	 * legge il valore del campo [impIdSiglaRea]
	 * @generated
	 */
	public java.lang.String getImpIdSiglaRea() {
		return impIdSiglaRea;
	}

	/// Field [impNumeroRea]
	private it.csi.sigit.sigitwebn.dto.common.UDTPositiveInteger impNumeroRea = null;

	/**
	 * imposta il valore del campo [impNumeroRea]
	 * @param val
	 * @generated
	 */

	public void setImpNumeroRea(it.csi.sigit.sigitwebn.dto.common.UDTPositiveInteger val) {
		impNumeroRea = val;
	}

	/**
	 * legge il valore del campo [impNumeroRea]
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.dto.common.UDTPositiveInteger getImpNumeroRea() {
		return impNumeroRea;
	}

	/// Field [impImpresa]
	private java.lang.String impImpresa = null;

	/**
	 * imposta il valore del campo [impImpresa]
	 * @param val
	 * @generated
	 */

	public void setImpImpresa(java.lang.String val) {
		impImpresa = val;
	}

	/**
	 * legge il valore del campo [impImpresa]
	 * @generated
	 */
	public java.lang.String getImpImpresa() {
		return impImpresa;
	}

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per la clusterizzazione della sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	/**
	 * Costruttore vuoto del DTO.
	 * @generated
	 */
	public Incarico() {
		super();

	}

	/**
	 * @generated
	 */
	public String toString() {
		/*PROTECTED REGION ID(R-944815610) ENABLED START*/
		/// inserire qui la logica desiderata per la rappresenatazione a stringa
		return super.toString();
		/*PROTECTED REGION END*/
	}
}
