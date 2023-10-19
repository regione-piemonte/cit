package it.csi.sigit.sigitwebn.dto.main;

public class RicercaTransazione implements java.io.Serializable {

	/// Field [codiceImpianto]
	private it.csi.sigit.sigitwebn.dto.common.UDTPositiveInteger codiceImpianto = null;

	/**
	 * imposta il valore del campo [codiceImpianto]
	 * @param val
	 * @generated
	 */

	public void setCodiceImpianto(it.csi.sigit.sigitwebn.dto.common.UDTPositiveInteger val) {
		codiceImpianto = val;
	}

	/**
	 * legge il valore del campo [codiceImpianto]
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.dto.common.UDTPositiveInteger getCodiceImpianto() {
		return codiceImpianto;
	}

	/// Field [siglaBollino]
	private java.lang.String siglaBollino = null;

	/**
	 * imposta il valore del campo [siglaBollino]
	 * @param val
	 * @generated
	 */

	public void setSiglaBollino(java.lang.String val) {
		siglaBollino = val;
	}

	/**
	 * legge il valore del campo [siglaBollino]
	 * @generated
	 */
	public java.lang.String getSiglaBollino() {
		return siglaBollino;
	}

	/// Field [numeroBollino]
	private it.csi.sigit.sigitwebn.dto.common.UDTPositiveInteger numeroBollino = null;

	/**
	 * imposta il valore del campo [numeroBollino]
	 * @param val
	 * @generated
	 */

	public void setNumeroBollino(it.csi.sigit.sigitwebn.dto.common.UDTPositiveInteger val) {
		numeroBollino = val;
	}

	/**
	 * legge il valore del campo [numeroBollino]
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.dto.common.UDTPositiveInteger getNumeroBollino() {
		return numeroBollino;
	}

	/// Field [idSiglaRea]
	private java.lang.String idSiglaRea = null;

	/**
	 * imposta il valore del campo [idSiglaRea]
	 * @param val
	 * @generated
	 */

	public void setIdSiglaRea(java.lang.String val) {
		idSiglaRea = val;
	}

	/**
	 * legge il valore del campo [idSiglaRea]
	 * @generated
	 */
	public java.lang.String getIdSiglaRea() {
		return idSiglaRea;
	}

	/// Field [numeroRea]
	private it.csi.sigit.sigitwebn.dto.common.UDTPositiveInteger numeroRea = null;

	/**
	 * imposta il valore del campo [numeroRea]
	 * @param val
	 * @generated
	 */

	public void setNumeroRea(it.csi.sigit.sigitwebn.dto.common.UDTPositiveInteger val) {
		numeroRea = val;
	}

	/**
	 * legge il valore del campo [numeroRea]
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.dto.common.UDTPositiveInteger getNumeroRea() {
		return numeroRea;
	}

	/// Field [codiceFiscale]
	private java.lang.String codiceFiscale = null;

	/**
	 * imposta il valore del campo [codiceFiscale]
	 * @param val
	 * @generated
	 */

	public void setCodiceFiscale(java.lang.String val) {
		codiceFiscale = val;
	}

	/**
	 * legge il valore del campo [codiceFiscale]
	 * @generated
	 */
	public java.lang.String getCodiceFiscale() {
		return codiceFiscale;
	}

	/// Field [dataAcquisizioneDa]
	private java.lang.String dataAcquisizioneDa = null;

	/**
	 * imposta il valore del campo [dataAcquisizioneDa]
	 * @param val
	 * @generated
	 */

	public void setDataAcquisizioneDa(java.lang.String val) {
		dataAcquisizioneDa = val;
	}

	/**
	 * legge il valore del campo [dataAcquisizioneDa]
	 * @generated
	 */
	public java.lang.String getDataAcquisizioneDa() {
		return dataAcquisizioneDa;
	}

	/// Field [dataAcquisizioneA]
	private java.lang.String dataAcquisizioneA = null;

	/**
	 * imposta il valore del campo [dataAcquisizioneA]
	 * @param val
	 * @generated
	 */

	public void setDataAcquisizioneA(java.lang.String val) {
		dataAcquisizioneA = val;
	}

	/**
	 * legge il valore del campo [dataAcquisizioneA]
	 * @generated
	 */
	public java.lang.String getDataAcquisizioneA() {
		return dataAcquisizioneA;
	}

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per la clusterizzazione della sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	/**
	 * Costruttore vuoto del DTO.
	 * @generated
	 */
	public RicercaTransazione() {
		super();

	}

	/**
	 * @generated
	 */
	public String toString() {
		/*PROTECTED REGION ID(R275615770) ENABLED START*/
		/// inserire qui la logica desiderata per la rappresenatazione a stringa
		return super.toString();
		/*PROTECTED REGION END*/
	}
}
