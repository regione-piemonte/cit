package it.csi.sigit.sigitwebn.dto.allegati;

public class FiltroRicercaCodiciImpianto implements java.io.Serializable {

	/// Field [codiceFiscaleUtenteLoggato]
	private java.lang.String codiceFiscaleUtenteLoggato = null;

	/**
	 * imposta il valore del campo [codiceFiscaleUtenteLoggato]
	 * @param val
	 * @generated
	 */

	public void setCodiceFiscaleUtenteLoggato(java.lang.String val) {
		codiceFiscaleUtenteLoggato = val;
	}

	/**
	 * legge il valore del campo [codiceFiscaleUtenteLoggato]
	 * @generated
	 */
	public java.lang.String getCodiceFiscaleUtenteLoggato() {
		return codiceFiscaleUtenteLoggato;
	}

	/// Field [codiceFiscalePersonaGiuridica]
	private java.lang.String codiceFiscalePersonaGiuridica = null;

	/**
	 * imposta il valore del campo [codiceFiscalePersonaGiuridica]
	 * @param val
	 * @generated
	 */

	public void setCodiceFiscalePersonaGiuridica(java.lang.String val) {
		codiceFiscalePersonaGiuridica = val;
	}

	/**
	 * legge il valore del campo [codiceFiscalePersonaGiuridica]
	 * @generated
	 */
	public java.lang.String getCodiceFiscalePersonaGiuridica() {
		return codiceFiscalePersonaGiuridica;
	}

	/// Field [descrizioneRuoloFunzionale]
	private java.lang.String descrizioneRuoloFunzionale = null;

	/**
	 * imposta il valore del campo [descrizioneRuoloFunzionale]
	 * @param val
	 * @generated
	 */

	public void setDescrizioneRuoloFunzionale(java.lang.String val) {
		descrizioneRuoloFunzionale = val;
	}

	/**
	 * legge il valore del campo [descrizioneRuoloFunzionale]
	 * @generated
	 */
	public java.lang.String getDescrizioneRuoloFunzionale() {
		return descrizioneRuoloFunzionale;
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

	/// Field [idPersonaGiuridica]
	private java.lang.String idPersonaGiuridica = null;

	/**
	 * imposta il valore del campo [idPersonaGiuridica]
	 * @param val
	 * @generated
	 */

	public void setIdPersonaGiuridica(java.lang.String val) {
		idPersonaGiuridica = val;
	}

	/**
	 * legge il valore del campo [idPersonaGiuridica]
	 * @generated
	 */
	public java.lang.String getIdPersonaGiuridica() {
		return idPersonaGiuridica;
	}

	/// Field [idRuolo]
	private java.util.ArrayList<java.lang.String> idRuolo = new java.util.ArrayList<java.lang.String>();

	/**
	 * imposta il valore del campo [idRuolo]
	 * @param val
	 * @generated
	 */

	public void setIdRuolo(java.util.ArrayList<java.lang.String> val) {
		idRuolo = val;
	}

	/**
	 * legge il valore del campo [idRuolo]
	 * @generated
	 */
	public java.util.ArrayList<java.lang.String> getIdRuolo() {
		return idRuolo;
	}

	/// Field [siglaRea]
	private java.lang.String siglaRea = null;

	/**
	 * imposta il valore del campo [siglaRea]
	 * @param val
	 * @generated
	 */

	public void setSiglaRea(java.lang.String val) {
		siglaRea = val;
	}

	/**
	 * legge il valore del campo [siglaRea]
	 * @generated
	 */
	public java.lang.String getSiglaRea() {
		return siglaRea;
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

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per la clusterizzazione della sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	/**
	 * Costruttore vuoto del DTO.
	 * @generated
	 */
	public FiltroRicercaCodiciImpianto() {
		super();

	}

	/**
	 * @generated
	 */
	public String toString() {
		/*PROTECTED REGION ID(R1140213398) ENABLED START*/
		/// inserire qui la logica desiderata per la rappresenatazione a stringa
		return super.toString();
		/*PROTECTED REGION END*/
	}
}
