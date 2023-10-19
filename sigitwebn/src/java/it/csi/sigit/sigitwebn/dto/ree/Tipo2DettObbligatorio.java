/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
package it.csi.sigit.sigitwebn.dto.ree;

public class Tipo2DettObbligatorio implements java.io.Serializable {

	/// Field [nCircuito]
	private java.lang.String nCircuito = null;

	/**
	 * imposta il valore del campo [nCircuito]
	 * @param val
	 * @generated
	 */

	public void setNCircuito(java.lang.String val) {
		nCircuito = val;
	}

	/**
	 * legge il valore del campo [nCircuito]
	 * @generated
	 */
	public java.lang.String getNCircuito() {
		return nCircuito;
	}

	/// Field [surrisc]
	private java.lang.String surrisc = null;

	/**
	 * imposta il valore del campo [surrisc]
	 * @param val
	 * @generated
	 */

	public void setSurrisc(java.lang.String val) {
		surrisc = val;
	}

	/**
	 * legge il valore del campo [surrisc]
	 * @generated
	 */
	public java.lang.String getSurrisc() {
		return surrisc;
	}

	/// Field [sottoraffredd]
	private java.lang.String sottoraffredd = null;

	/**
	 * imposta il valore del campo [sottoraffredd]
	 * @param val
	 * @generated
	 */

	public void setSottoraffredd(java.lang.String val) {
		sottoraffredd = val;
	}

	/**
	 * legge il valore del campo [sottoraffredd]
	 * @generated
	 */
	public java.lang.String getSottoraffredd() {
		return sottoraffredd;
	}

	/// Field [condensazione]
	private java.lang.String condensazione = null;

	/**
	 * imposta il valore del campo [condensazione]
	 * @param val
	 * @generated
	 */

	public void setCondensazione(java.lang.String val) {
		condensazione = val;
	}

	/**
	 * legge il valore del campo [condensazione]
	 * @generated
	 */
	public java.lang.String getCondensazione() {
		return condensazione;
	}

	/// Field [evaporazione]
	private java.lang.String evaporazione = null;

	/**
	 * imposta il valore del campo [evaporazione]
	 * @param val
	 * @generated
	 */

	public void setEvaporazione(java.lang.String val) {
		evaporazione = val;
	}

	/**
	 * legge il valore del campo [evaporazione]
	 * @generated
	 */
	public java.lang.String getEvaporazione() {
		return evaporazione;
	}

	/// Field [inLatoEst]
	private java.lang.String inLatoEst = null;

	/**
	 * imposta il valore del campo [inLatoEst]
	 * @param val
	 * @generated
	 */

	public void setInLatoEst(java.lang.String val) {
		inLatoEst = val;
	}

	/**
	 * legge il valore del campo [inLatoEst]
	 * @generated
	 */
	public java.lang.String getInLatoEst() {
		return inLatoEst;
	}

	/// Field [outLatoEst]
	private java.lang.String outLatoEst = null;

	/**
	 * imposta il valore del campo [outLatoEst]
	 * @param val
	 * @generated
	 */

	public void setOutLatoEst(java.lang.String val) {
		outLatoEst = val;
	}

	/**
	 * legge il valore del campo [outLatoEst]
	 * @generated
	 */
	public java.lang.String getOutLatoEst() {
		return outLatoEst;
	}

	/// Field [inLatoUtenze]
	private java.lang.String inLatoUtenze = null;

	/**
	 * imposta il valore del campo [inLatoUtenze]
	 * @param val
	 * @generated
	 */

	public void setInLatoUtenze(java.lang.String val) {
		inLatoUtenze = val;
	}

	/**
	 * legge il valore del campo [inLatoUtenze]
	 * @generated
	 */
	public java.lang.String getInLatoUtenze() {
		return inLatoUtenze;
	}

	/// Field [outLatoUtenze]
	private java.lang.String outLatoUtenze = null;

	/**
	 * imposta il valore del campo [outLatoUtenze]
	 * @param val
	 * @generated
	 */

	public void setOutLatoUtenze(java.lang.String val) {
		outLatoUtenze = val;
	}

	/**
	 * legge il valore del campo [outLatoUtenze]
	 * @generated
	 */
	public java.lang.String getOutLatoUtenze() {
		return outLatoUtenze;
	}

	/// Field [idDettTipo2]
	private java.lang.Integer idDettTipo2 = null;

	/**
	 * imposta il valore del campo [idDettTipo2]
	 * @param val
	 * @generated
	 */

	public void setIdDettTipo2(java.lang.Integer val) {
		idDettTipo2 = val;
	}

	/**
	 * legge il valore del campo [idDettTipo2]
	 * @generated
	 */
	public java.lang.Integer getIdDettTipo2() {
		return idDettTipo2;
	}

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per la clusterizzazione della sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	/**
	 * Costruttore vuoto del DTO.
	 * @generated
	 */
	public Tipo2DettObbligatorio() {
		super();

	}

	/**
	 * @generated
	 */
	public String toString() {
		/*PROTECTED REGION ID(R874487326) ENABLED START*/
		/// inserire qui la logica desiderata per la rappresenatazione a stringa
		return super.toString();
		/*PROTECTED REGION END*/
	}
}
