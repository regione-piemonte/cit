/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
package it.csi.sigit.sigitwebn.dto.allegati;

public class ElencoAllegatiPerImpianto implements java.io.Serializable {

	/// Field [dataControllo]
	private java.lang.String dataControllo = null;

	/**
	 * imposta il valore del campo [dataControllo]
	 * @param val
	 * @generated
	 */

	public void setDataControllo(java.lang.String val) {
		dataControllo = val;
	}

	/**
	 * legge il valore del campo [dataControllo]
	 * @generated
	 */
	public java.lang.String getDataControllo() {
		return dataControllo;
	}

	/// Field [tipoAllegato]
	private java.lang.String tipoAllegato = null;

	/**
	 * imposta il valore del campo [tipoAllegato]
	 * @param val
	 * @generated
	 */

	public void setTipoAllegato(java.lang.String val) {
		tipoAllegato = val;
	}

	/**
	 * legge il valore del campo [tipoAllegato]
	 * @generated
	 */
	public java.lang.String getTipoAllegato() {
		return tipoAllegato;
	}

	/// Field [statoAllegato]
	private java.lang.String statoAllegato = null;

	/**
	 * imposta il valore del campo [statoAllegato]
	 * @param val
	 * @generated
	 */

	public void setStatoAllegato(java.lang.String val) {
		statoAllegato = val;
	}

	/**
	 * legge il valore del campo [statoAllegato]
	 * @generated
	 */
	public java.lang.String getStatoAllegato() {
		return statoAllegato;
	}

	/// Field [osservazioni]
	private java.lang.String osservazioni = null;

	/**
	 * imposta il valore del campo [osservazioni]
	 * @param val
	 * @generated
	 */

	public void setOsservazioni(java.lang.String val) {
		osservazioni = val;
	}

	/**
	 * legge il valore del campo [osservazioni]
	 * @generated
	 */
	public java.lang.String getOsservazioni() {
		return osservazioni;
	}

	/// Field [raccomandazioni]
	private java.lang.String raccomandazioni = null;

	/**
	 * imposta il valore del campo [raccomandazioni]
	 * @param val
	 * @generated
	 */

	public void setRaccomandazioni(java.lang.String val) {
		raccomandazioni = val;
	}

	/**
	 * legge il valore del campo [raccomandazioni]
	 * @generated
	 */
	public java.lang.String getRaccomandazioni() {
		return raccomandazioni;
	}

	/// Field [prescrizioni]
	private java.lang.String prescrizioni = null;

	/**
	 * imposta il valore del campo [prescrizioni]
	 * @param val
	 * @generated
	 */

	public void setPrescrizioni(java.lang.String val) {
		prescrizioni = val;
	}

	/**
	 * legge il valore del campo [prescrizioni]
	 * @generated
	 */
	public java.lang.String getPrescrizioni() {
		return prescrizioni;
	}

	/// Field [interventoRaccomandato]
	private java.lang.String interventoRaccomandato = null;

	/**
	 * imposta il valore del campo [interventoRaccomandato]
	 * @param val
	 * @generated
	 */

	public void setInterventoRaccomandato(java.lang.String val) {
		interventoRaccomandato = val;
	}

	/**
	 * legge il valore del campo [interventoRaccomandato]
	 * @generated
	 */
	public java.lang.String getInterventoRaccomandato() {
		return interventoRaccomandato;
	}

	/// Field [idAllegato]
	private java.lang.String idAllegato = null;

	/**
	 * imposta il valore del campo [idAllegato]
	 * @param val
	 * @generated
	 */

	public void setIdAllegato(java.lang.String val) {
		idAllegato = val;
	}

	/**
	 * legge il valore del campo [idAllegato]
	 * @generated
	 */
	public java.lang.String getIdAllegato() {
		return idAllegato;
	}

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per la clusterizzazione della sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	/**
	 * Costruttore vuoto del DTO.
	 * @generated
	 */
	public ElencoAllegatiPerImpianto() {
		super();

	}

	/**
	 * @generated
	 */
	public String toString() {
		/*PROTECTED REGION ID(R-71815810) ENABLED START*/
		/// inserire qui la logica desiderata per la rappresenatazione a stringa
		return super.toString();
		/*PROTECTED REGION END*/
	}
}
