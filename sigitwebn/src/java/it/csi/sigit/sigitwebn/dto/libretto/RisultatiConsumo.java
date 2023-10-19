/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
package it.csi.sigit.sigitwebn.dto.libretto;

public class RisultatiConsumo implements java.io.Serializable {

	/// Field [idConsumo]
	private java.lang.Integer idConsumo = null;

	/**
	 * imposta il valore del campo [idConsumo]
	 * @param val
	 * @generated
	 */

	public void setIdConsumo(java.lang.Integer val) {
		idConsumo = val;
	}

	/**
	 * legge il valore del campo [idConsumo]
	 * @generated
	 */
	public java.lang.Integer getIdConsumo() {
		return idConsumo;
	}

	/// Field [codiceImpianto]
	private java.lang.Integer codiceImpianto = null;

	/**
	 * imposta il valore del campo [codiceImpianto]
	 * @param val
	 * @generated
	 */

	public void setCodiceImpianto(java.lang.Integer val) {
		codiceImpianto = val;
	}

	/**
	 * legge il valore del campo [codiceImpianto]
	 * @generated
	 */
	public java.lang.Integer getCodiceImpianto() {
		return codiceImpianto;
	}

	/// Field [tipoConsumo]
	private java.lang.String tipoConsumo = null;

	/**
	 * imposta il valore del campo [tipoConsumo]
	 * @param val
	 * @generated
	 */

	public void setTipoConsumo(java.lang.String val) {
		tipoConsumo = val;
	}

	/**
	 * legge il valore del campo [tipoConsumo]
	 * @generated
	 */
	public java.lang.String getTipoConsumo() {
		return tipoConsumo;
	}

	/// Field [combustibile]
	private java.lang.Integer combustibile = null;

	/**
	 * imposta il valore del campo [combustibile]
	 * @param val
	 * @generated
	 */

	public void setCombustibile(java.lang.Integer val) {
		combustibile = val;
	}

	/**
	 * legge il valore del campo [combustibile]
	 * @generated
	 */
	public java.lang.Integer getCombustibile() {
		return combustibile;
	}

	/// Field [unitaMisura]
	private java.lang.String unitaMisura = null;

	/**
	 * imposta il valore del campo [unitaMisura]
	 * @param val
	 * @generated
	 */

	public void setUnitaMisura(java.lang.String val) {
		unitaMisura = val;
	}

	/**
	 * legge il valore del campo [unitaMisura]
	 * @generated
	 */
	public java.lang.String getUnitaMisura() {
		return unitaMisura;
	}

	/// Field [acquisti]
	private java.lang.String acquisti = null;

	/**
	 * imposta il valore del campo [acquisti]
	 * @param val
	 * @generated
	 */

	public void setAcquisti(java.lang.String val) {
		acquisti = val;
	}

	/**
	 * legge il valore del campo [acquisti]
	 * @generated
	 */
	public java.lang.String getAcquisti() {
		return acquisti;
	}

	/// Field [letturaIniziale]
	private java.lang.Integer letturaIniziale = null;

	/**
	 * imposta il valore del campo [letturaIniziale]
	 * @param val
	 * @generated
	 */

	public void setLetturaIniziale(java.lang.Integer val) {
		letturaIniziale = val;
	}

	/**
	 * legge il valore del campo [letturaIniziale]
	 * @generated
	 */
	public java.lang.Integer getLetturaIniziale() {
		return letturaIniziale;
	}

	/// Field [letturaFinale]
	private java.lang.Integer letturaFinale = null;

	/**
	 * imposta il valore del campo [letturaFinale]
	 * @param val
	 * @generated
	 */

	public void setLetturaFinale(java.lang.Integer val) {
		letturaFinale = val;
	}

	/**
	 * legge il valore del campo [letturaFinale]
	 * @generated
	 */
	public java.lang.Integer getLetturaFinale() {
		return letturaFinale;
	}

	/// Field [consumo]
	private java.lang.Integer consumo = null;

	/**
	 * imposta il valore del campo [consumo]
	 * @param val
	 * @generated
	 */

	public void setConsumo(java.lang.Integer val) {
		consumo = val;
	}

	/**
	 * legge il valore del campo [consumo]
	 * @generated
	 */
	public java.lang.Integer getConsumo() {
		return consumo;
	}

	/// Field [esercizioDa]
	private java.lang.Integer esercizioDa = null;

	/**
	 * imposta il valore del campo [esercizioDa]
	 * @param val
	 * @generated
	 */

	public void setEsercizioDa(java.lang.Integer val) {
		esercizioDa = val;
	}

	/**
	 * legge il valore del campo [esercizioDa]
	 * @generated
	 */
	public java.lang.Integer getEsercizioDa() {
		return esercizioDa;
	}

	/// Field [esercizioA]
	private java.lang.Integer esercizioA = null;

	/**
	 * imposta il valore del campo [esercizioA]
	 * @param val
	 * @generated
	 */

	public void setEsercizioA(java.lang.Integer val) {
		esercizioA = val;
	}

	/**
	 * legge il valore del campo [esercizioA]
	 * @generated
	 */
	public java.lang.Integer getEsercizioA() {
		return esercizioA;
	}

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per la clusterizzazione della sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	/**
	 * Costruttore vuoto del DTO.
	 * @generated
	 */
	public RisultatiConsumo() {
		super();

	}

	/**
	 * @generated
	 */
	public String toString() {
		/*PROTECTED REGION ID(R-1870386782) ENABLED START*/
		/// inserire qui la logica desiderata per la rappresenatazione a stringa
		return super.toString();
		/*PROTECTED REGION END*/
	}
}
