package it.csi.sigit.sigitwebn.dto.bollini;

public class AcquistoBollini implements java.io.Serializable {

	/// Field [idTransazione]
	private java.lang.Long idTransazione = null;

	/**
	 * imposta il valore del campo [idTransazione]
	 * @param val
	 * @generated
	 */

	public void setIdTransazione(java.lang.Long val) {
		idTransazione = val;
	}

	/**
	 * legge il valore del campo [idTransazione]
	 * @generated
	 */
	public java.lang.Long getIdTransazione() {
		return idTransazione;
	}

	/// Field [codiceFiscaleOp]
	private java.lang.String codiceFiscaleOp = null;

	/**
	 * imposta il valore del campo [codiceFiscaleOp]
	 * @param val
	 * @generated
	 */

	public void setCodiceFiscaleOp(java.lang.String val) {
		codiceFiscaleOp = val;
	}

	/**
	 * legge il valore del campo [codiceFiscaleOp]
	 * @generated
	 */
	public java.lang.String getCodiceFiscaleOp() {
		return codiceFiscaleOp;
	}

	/// Field [dataAcquisto]
	private java.lang.String dataAcquisto = null;

	/**
	 * imposta il valore del campo [dataAcquisto]
	 * @param val
	 * @generated
	 */

	public void setDataAcquisto(java.lang.String val) {
		dataAcquisto = val;
	}

	/**
	 * legge il valore del campo [dataAcquisto]
	 * @generated
	 */
	public java.lang.String getDataAcquisto() {
		return dataAcquisto;
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

	/// Field [codiceFiscaleImpresa]
	private java.lang.String codiceFiscaleImpresa = null;

	/**
	 * imposta il valore del campo [codiceFiscaleImpresa]
	 * @param val
	 * @generated
	 */

	public void setCodiceFiscaleImpresa(java.lang.String val) {
		codiceFiscaleImpresa = val;
	}

	/**
	 * legge il valore del campo [codiceFiscaleImpresa]
	 * @generated
	 */
	public java.lang.String getCodiceFiscaleImpresa() {
		return codiceFiscaleImpresa;
	}

	/// Field [denominazioneImpresa]
	private java.lang.String denominazioneImpresa = null;

	/**
	 * imposta il valore del campo [denominazioneImpresa]
	 * @param val
	 * @generated
	 */

	public void setDenominazioneImpresa(java.lang.String val) {
		denominazioneImpresa = val;
	}

	/**
	 * legge il valore del campo [denominazioneImpresa]
	 * @generated
	 */
	public java.lang.String getDenominazioneImpresa() {
		return denominazioneImpresa;
	}

	/// Field [idInstallatore]
	private java.lang.Integer idInstallatore = null;

	/**
	 * imposta il valore del campo [idInstallatore]
	 * @param val
	 * @generated
	 */

	public void setIdInstallatore(java.lang.Integer val) {
		idInstallatore = val;
	}

	/**
	 * legge il valore del campo [idInstallatore]
	 * @generated
	 */
	public java.lang.Integer getIdInstallatore() {
		return idInstallatore;
	}

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per la clusterizzazione della sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	/**
	 * Costruttore vuoto del DTO.
	 * @generated
	 */
	public AcquistoBollini() {
		super();

	}

	/**
	 * @generated
	 */
	public String toString() {
		/*PROTECTED REGION ID(R1398846895) ENABLED START*/
		/// inserire qui la logica desiderata per la rappresenatazione a stringa
		return super.toString();
		/*PROTECTED REGION END*/
	}
}
