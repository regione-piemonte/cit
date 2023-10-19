package it.csi.sigit.sigitwebn.dto.terzoresponsabile;

public class DocContratto implements java.io.Serializable {

	/// Field [idDocContratto]
	private java.lang.Integer idDocContratto = null;

	/**
	 * imposta il valore del campo [idDocContratto]
	 * @param val
	 * @generated
	 */

	public void setIdDocContratto(java.lang.Integer val) {
		idDocContratto = val;
	}

	/**
	 * legge il valore del campo [idDocContratto]
	 * @generated
	 */
	public java.lang.Integer getIdDocContratto() {
		return idDocContratto;
	}

	/// Field [nomeDocumento]
	private java.lang.String nomeDocumento = null;

	/**
	 * imposta il valore del campo [nomeDocumento]
	 * @param val
	 * @generated
	 */

	public void setNomeDocumento(java.lang.String val) {
		nomeDocumento = val;
	}

	/**
	 * legge il valore del campo [nomeDocumento]
	 * @generated
	 */
	public java.lang.String getNomeDocumento() {
		return nomeDocumento;
	}

	/// Field [descrizione]
	private java.lang.String descrizione = null;

	/**
	 * imposta il valore del campo [descrizione]
	 * @param val
	 * @generated
	 */

	public void setDescrizione(java.lang.String val) {
		descrizione = val;
	}

	/**
	 * legge il valore del campo [descrizione]
	 * @generated
	 */
	public java.lang.String getDescrizione() {
		return descrizione;
	}

	/// Field [dataUpload]
	private java.lang.String dataUpload = null;

	/**
	 * imposta il valore del campo [dataUpload]
	 * @param val
	 * @generated
	 */

	public void setDataUpload(java.lang.String val) {
		dataUpload = val;
	}

	/**
	 * legge il valore del campo [dataUpload]
	 * @generated
	 */
	public java.lang.String getDataUpload() {
		return dataUpload;
	}

	/// Field [statoDocumento]
	private java.lang.String statoDocumento = null;

	/**
	 * imposta il valore del campo [statoDocumento]
	 * @param val
	 * @generated
	 */

	public void setStatoDocumento(java.lang.String val) {
		statoDocumento = val;
	}

	/**
	 * legge il valore del campo [statoDocumento]
	 * @generated
	 */
	public java.lang.String getStatoDocumento() {
		return statoDocumento;
	}

	/// Field [uidIndex]
	private java.lang.String uidIndex = null;

	/**
	 * imposta il valore del campo [uidIndex]
	 * @param val
	 * @generated
	 */

	public void setUidIndex(java.lang.String val) {
		uidIndex = val;
	}

	/**
	 * legge il valore del campo [uidIndex]
	 * @generated
	 */
	public java.lang.String getUidIndex() {
		return uidIndex;
	}

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per la clusterizzazione della sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	/**
	 * Costruttore vuoto del DTO.
	 * @generated
	 */
	public DocContratto() {
		super();

	}

	/**
	 * @generated
	 */
	public String toString() {
		/*PROTECTED REGION ID(R1363890279) ENABLED START*/
		/// inserire qui la logica desiderata per la rappresenatazione a stringa
		return super.toString();
		/*PROTECTED REGION END*/
	}
}
