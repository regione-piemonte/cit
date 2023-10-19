/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
package it.csi.sigit.sigitwebn.dto.codici_impianto;

public class RisultatoRicCodImpianto implements java.io.Serializable {

	/// Field [idTransazione]
	private java.lang.Integer idTransazione = null;

	/**
	 * imposta il valore del campo [idTransazione]
	 * @param val
	 * @generated
	 */

	public void setIdTransazione(java.lang.Integer val) {
		idTransazione = val;
	}

	/**
	 * legge il valore del campo [idTransazione]
	 * @generated
	 */
	public java.lang.Integer getIdTransazione() {
		return idTransazione;
	}

	/// Field [codiceRea]
	private java.lang.String codiceRea = null;

	/**
	 * imposta il valore del campo [codiceRea]
	 * @param val
	 * @generated
	 */

	public void setCodiceRea(java.lang.String val) {
		codiceRea = val;
	}

	/**
	 * legge il valore del campo [codiceRea]
	 * @generated
	 */
	public java.lang.String getCodiceRea() {
		return codiceRea;
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

	/// Field [dataTransazione]
	private java.lang.String dataTransazione = null;

	/**
	 * imposta il valore del campo [dataTransazione]
	 * @param val
	 * @generated
	 */

	public void setDataTransazione(java.lang.String val) {
		dataTransazione = val;
	}

	/**
	 * legge il valore del campo [dataTransazione]
	 * @generated
	 */
	public java.lang.String getDataTransazione() {
		return dataTransazione;
	}

	/// Field [totCodici]
	private java.lang.String totCodici = null;

	/**
	 * imposta il valore del campo [totCodici]
	 * @param val
	 * @generated
	 */

	public void setTotCodici(java.lang.String val) {
		totCodici = val;
	}

	/**
	 * legge il valore del campo [totCodici]
	 * @generated
	 */
	public java.lang.String getTotCodici() {
		return totCodici;
	}

	/// Field [totCodiciLiberi]
	private java.lang.String totCodiciLiberi = null;

	/**
	 * imposta il valore del campo [totCodiciLiberi]
	 * @param val
	 * @generated
	 */

	public void setTotCodiciLiberi(java.lang.String val) {
		totCodiciLiberi = val;
	}

	/**
	 * legge il valore del campo [totCodiciLiberi]
	 * @generated
	 */
	public java.lang.String getTotCodiciLiberi() {
		return totCodiciLiberi;
	}

	/// Field [intervalloCodici]
	private java.lang.String intervalloCodici = null;

	/**
	 * imposta il valore del campo [intervalloCodici]
	 * @param val
	 * @generated
	 */

	public void setIntervalloCodici(java.lang.String val) {
		intervalloCodici = val;
	}

	/**
	 * legge il valore del campo [intervalloCodici]
	 * @generated
	 */
	public java.lang.String getIntervalloCodici() {
		return intervalloCodici;
	}

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per la clusterizzazione della sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	/**
	 * Costruttore vuoto del DTO.
	 * @generated
	 */
	public RisultatoRicCodImpianto() {
		super();

	}

	/**
	 * @generated
	 */
	public String toString() {
		/*PROTECTED REGION ID(R-2027445799) ENABLED START*/
		/// inserire qui la logica desiderata per la rappresenatazione a stringa
		return super.toString();
		/*PROTECTED REGION END*/
	}
}
