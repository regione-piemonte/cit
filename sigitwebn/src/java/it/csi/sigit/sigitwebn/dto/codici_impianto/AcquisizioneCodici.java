package it.csi.sigit.sigitwebn.dto.codici_impianto;

public class AcquisizioneCodici implements java.io.Serializable {

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

	/// Field [impresa]
	private java.lang.String impresa = null;

	/**
	 * imposta il valore del campo [impresa]
	 * @param val
	 * @generated
	 */

	public void setImpresa(java.lang.String val) {
		impresa = val;
	}

	/**
	 * legge il valore del campo [impresa]
	 * @generated
	 */
	public java.lang.String getImpresa() {
		return impresa;
	}

	/// Field [dataConsegna]
	private java.lang.String dataConsegna = null;

	/**
	 * imposta il valore del campo [dataConsegna]
	 * @param val
	 * @generated
	 */

	public void setDataConsegna(java.lang.String val) {
		dataConsegna = val;
	}

	/**
	 * legge il valore del campo [dataConsegna]
	 * @generated
	 */
	public java.lang.String getDataConsegna() {
		return dataConsegna;
	}

	/// Field [acquisitiDa]
	private java.lang.String acquisitiDa = null;

	/**
	 * imposta il valore del campo [acquisitiDa]
	 * @param val
	 * @generated
	 */

	public void setAcquisitiDa(java.lang.String val) {
		acquisitiDa = val;
	}

	/**
	 * legge il valore del campo [acquisitiDa]
	 * @generated
	 */
	public java.lang.String getAcquisitiDa() {
		return acquisitiDa;
	}

	/// Field [quantita]
	private java.lang.Integer quantita = null;

	/**
	 * imposta il valore del campo [quantita]
	 * @param val
	 * @generated
	 */

	public void setQuantita(java.lang.Integer val) {
		quantita = val;
	}

	/**
	 * legge il valore del campo [quantita]
	 * @generated
	 */
	public java.lang.Integer getQuantita() {
		return quantita;
	}

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per la clusterizzazione della sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	/**
	 * Costruttore vuoto del DTO.
	 * @generated
	 */
	public AcquisizioneCodici() {
		super();

	}

	/**
	 * @generated
	 */
	public String toString() {
		/*PROTECTED REGION ID(R829134400) ENABLED START*/
		/// inserire qui la logica desiderata per la rappresenatazione a stringa
		return super.toString();
		/*PROTECTED REGION END*/
	}
}
