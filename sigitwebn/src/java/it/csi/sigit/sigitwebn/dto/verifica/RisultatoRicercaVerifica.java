/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
package it.csi.sigit.sigitwebn.dto.verifica;

public class RisultatoRicercaVerifica implements java.io.Serializable {

	/// Field [identificativo]
	private java.lang.String identificativo = null;

	/**
	 * imposta il valore del campo [identificativo]
	 * @param val
	 * @generated
	 */

	public void setIdentificativo(java.lang.String val) {
		identificativo = val;
	}

	/**
	 * legge il valore del campo [identificativo]
	 * @generated
	 */
	public java.lang.String getIdentificativo() {
		return identificativo;
	}

	/// Field [cfUtente]
	private java.lang.String cfUtente = null;

	/**
	 * imposta il valore del campo [cfUtente]
	 * @param val
	 * @generated
	 */

	public void setCfUtente(java.lang.String val) {
		cfUtente = val;
	}

	/**
	 * legge il valore del campo [cfUtente]
	 * @generated
	 */
	public java.lang.String getCfUtente() {
		return cfUtente;
	}

	/// Field [dataCreazione]
	private java.lang.String dataCreazione = null;

	/**
	 * imposta il valore del campo [dataCreazione]
	 * @param val
	 * @generated
	 */

	public void setDataCreazione(java.lang.String val) {
		dataCreazione = val;
	}

	/**
	 * legge il valore del campo [dataCreazione]
	 * @generated
	 */
	public java.lang.String getDataCreazione() {
		return dataCreazione;
	}

	/// Field [tipoVerifica]
	private java.lang.String tipoVerifica = null;

	/**
	 * imposta il valore del campo [tipoVerifica]
	 * @param val
	 * @generated
	 */

	public void setTipoVerifica(java.lang.String val) {
		tipoVerifica = val;
	}

	/**
	 * legge il valore del campo [tipoVerifica]
	 * @generated
	 */
	public java.lang.String getTipoVerifica() {
		return tipoVerifica;
	}

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

	/// Field [bollino]
	private java.lang.String bollino = null;

	/**
	 * imposta il valore del campo [bollino]
	 * @param val
	 * @generated
	 */

	public void setBollino(java.lang.String val) {
		bollino = val;
	}

	/**
	 * legge il valore del campo [bollino]
	 * @generated
	 */
	public java.lang.String getBollino() {
		return bollino;
	}

	/// Field [idDatoDistributore]
	private java.lang.String idDatoDistributore = null;

	/**
	 * imposta il valore del campo [idDatoDistributore]
	 * @param val
	 * @generated
	 */

	public void setIdDatoDistributore(java.lang.String val) {
		idDatoDistributore = val;
	}

	/**
	 * legge il valore del campo [idDatoDistributore]
	 * @generated
	 */
	public java.lang.String getIdDatoDistributore() {
		return idDatoDistributore;
	}

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per la clusterizzazione della sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	/**
	 * Costruttore vuoto del DTO.
	 * @generated
	 */
	public RisultatoRicercaVerifica() {
		super();

	}

	/**
	 * @generated
	 */
	public String toString() {
		/*PROTECTED REGION ID(R688496196) ENABLED START*/
		/// inserire qui la logica desiderata per la rappresenatazione a stringa
		return super.toString();
		/*PROTECTED REGION END*/
	}
}
