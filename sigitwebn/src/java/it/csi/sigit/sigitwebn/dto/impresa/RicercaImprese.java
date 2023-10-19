package it.csi.sigit.sigitwebn.dto.impresa;

public class RicercaImprese implements java.io.Serializable {

	/// Field [denominazione]
	private java.lang.String denominazione = null;

	/**
	 * imposta il valore del campo [denominazione]
	 * @param val
	 * @generated
	 */

	public void setDenominazione(java.lang.String val) {
		denominazione = val;
	}

	/**
	 * legge il valore del campo [denominazione]
	 * @generated
	 */
	public java.lang.String getDenominazione() {
		return denominazione;
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

	/// Field [descRuolo]
	private java.lang.String descRuolo = null;

	/**
	 * imposta il valore del campo [descRuolo]
	 * @param val
	 * @generated
	 */

	public void setDescRuolo(java.lang.String val) {
		descRuolo = val;
	}

	/**
	 * legge il valore del campo [descRuolo]
	 * @generated
	 */
	public java.lang.String getDescRuolo() {
		return descRuolo;
	}

	/// Field [idStatoPg]
	private java.lang.Integer idStatoPg = null;

	/**
	 * imposta il valore del campo [idStatoPg]
	 * @param val
	 * @generated
	 */

	public void setIdStatoPg(java.lang.Integer val) {
		idStatoPg = val;
	}

	/**
	 * legge il valore del campo [idStatoPg]
	 * @generated
	 */
	public java.lang.Integer getIdStatoPg() {
		return idStatoPg;
	}

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per la clusterizzazione della sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	/**
	 * Costruttore vuoto del DTO.
	 * @generated
	 */
	public RicercaImprese() {
		super();

	}

	/**
	 * @generated
	 */
	public String toString() {
		/*PROTECTED REGION ID(R391685509) ENABLED START*/
		/// inserire qui la logica desiderata per la rappresenatazione a stringa
		return super.toString();
		/*PROTECTED REGION END*/
	}
}
