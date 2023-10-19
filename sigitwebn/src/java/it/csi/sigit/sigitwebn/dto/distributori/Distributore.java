package it.csi.sigit.sigitwebn.dto.distributori;

public class Distributore implements java.io.Serializable {

	/// Field [distrId]
	private java.lang.Integer distrId = null;

	/**
	 * imposta il valore del campo [distrId]
	 * @param val
	 * @generated
	 */

	public void setDistrId(java.lang.Integer val) {
		distrId = val;
	}

	/**
	 * legge il valore del campo [distrId]
	 * @generated
	 */
	public java.lang.Integer getDistrId() {
		return distrId;
	}

	/// Field [distrCf]
	private java.lang.String distrCf = null;

	/**
	 * imposta il valore del campo [distrCf]
	 * @param val
	 * @generated
	 */

	public void setDistrCf(java.lang.String val) {
		distrCf = val;
	}

	/**
	 * legge il valore del campo [distrCf]
	 * @generated
	 */
	public java.lang.String getDistrCf() {
		return distrCf;
	}

	/// Field [distrIdSiglaRea]
	private java.lang.String distrIdSiglaRea = null;

	/**
	 * imposta il valore del campo [distrIdSiglaRea]
	 * @param val
	 * @generated
	 */

	public void setDistrIdSiglaRea(java.lang.String val) {
		distrIdSiglaRea = val;
	}

	/**
	 * legge il valore del campo [distrIdSiglaRea]
	 * @generated
	 */
	public java.lang.String getDistrIdSiglaRea() {
		return distrIdSiglaRea;
	}

	/// Field [distrNumeroRea]
	private it.csi.sigit.sigitwebn.dto.common.UDTPositiveInteger distrNumeroRea = null;

	/**
	 * imposta il valore del campo [distrNumeroRea]
	 * @param val
	 * @generated
	 */

	public void setDistrNumeroRea(it.csi.sigit.sigitwebn.dto.common.UDTPositiveInteger val) {
		distrNumeroRea = val;
	}

	/**
	 * legge il valore del campo [distrNumeroRea]
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.dto.common.UDTPositiveInteger getDistrNumeroRea() {
		return distrNumeroRea;
	}

	/// Field [distrImpresa]
	private java.lang.String distrImpresa = null;

	/**
	 * imposta il valore del campo [distrImpresa]
	 * @param val
	 * @generated
	 */

	public void setDistrImpresa(java.lang.String val) {
		distrImpresa = val;
	}

	/**
	 * legge il valore del campo [distrImpresa]
	 * @generated
	 */
	public java.lang.String getDistrImpresa() {
		return distrImpresa;
	}

	/// Field [distrEmail]
	private java.lang.String distrEmail = null;

	/**
	 * imposta il valore del campo [distrEmail]
	 * @param val
	 * @generated
	 */

	public void setDistrEmail(java.lang.String val) {
		distrEmail = val;
	}

	/**
	 * legge il valore del campo [distrEmail]
	 * @generated
	 */
	public java.lang.String getDistrEmail() {
		return distrEmail;
	}

	/// Field [idImportSostituzione]
	private java.lang.Integer idImportSostituzione = null;

	/**
	 * imposta il valore del campo [idImportSostituzione]
	 * @param val
	 * @generated
	 */

	public void setIdImportSostituzione(java.lang.Integer val) {
		idImportSostituzione = val;
	}

	/**
	 * legge il valore del campo [idImportSostituzione]
	 * @generated
	 */
	public java.lang.Integer getIdImportSostituzione() {
		return idImportSostituzione;
	}

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per la clusterizzazione della sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	/**
	 * Costruttore vuoto del DTO.
	 * @generated
	 */
	public Distributore() {
		super();

	}

	/**
	 * @generated
	 */
	public String toString() {
		/*PROTECTED REGION ID(R579163770) ENABLED START*/
		/// inserire qui la logica desiderata per la rappresenatazione a stringa
		return super.toString();
		/*PROTECTED REGION END*/
	}
}
