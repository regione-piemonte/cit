/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
package it.csi.sigit.sigitwebn.dto.codici_impianto;

public class RicercaCodImpianto implements java.io.Serializable {

	/// Field [codiceImpianto]
	private java.lang.String codiceImpianto = null;

	/**
	 * imposta il valore del campo [codiceImpianto]
	 * @param val
	 * @generated
	 */

	public void setCodiceImpianto(java.lang.String val) {
		codiceImpianto = val;
	}

	/**
	 * legge il valore del campo [codiceImpianto]
	 * @generated
	 */
	public java.lang.String getCodiceImpianto() {
		return codiceImpianto;
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
	private java.lang.String numeroRea = null;

	/**
	 * imposta il valore del campo [numeroRea]
	 * @param val
	 * @generated
	 */

	public void setNumeroRea(java.lang.String val) {
		numeroRea = val;
	}

	/**
	 * legge il valore del campo [numeroRea]
	 * @generated
	 */
	public java.lang.String getNumeroRea() {
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

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per la clusterizzazione della sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	/**
	 * Costruttore vuoto del DTO.
	 * @generated
	 */
	public RicercaCodImpianto() {
		super();

	}

	/**
	 * @generated
	 */
	public String toString() {
		/*PROTECTED REGION ID(R2096365905) ENABLED START*/
		/// inserire qui la logica desiderata per la rappresenatazione a stringa
		return super.toString();
		/*PROTECTED REGION END*/
	}
}
