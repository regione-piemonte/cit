/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
package it.csi.sigit.sigitwebn.dto.terzoresponsabile;

public class AutodichiarazioneContratto implements java.io.Serializable {

	/// Field [idAutodichiarazione]
	private int idAutodichiarazione = 0;

	/**
	 * imposta il valore del campo [idAutodichiarazione]
	 * @param val
	 * @generated
	 */

	public void setIdAutodichiarazione(int val) {
		idAutodichiarazione = val;
	}

	/**
	 * legge il valore del campo [idAutodichiarazione]
	 * @generated
	 */
	public int getIdAutodichiarazione() {
		return idAutodichiarazione;
	}

	/// Field [idContratto]
	private int idContratto = 0;

	/**
	 * imposta il valore del campo [idContratto]
	 * @param val
	 * @generated
	 */

	public void setIdContratto(int val) {
		idContratto = val;
	}

	/**
	 * legge il valore del campo [idContratto]
	 * @generated
	 */
	public int getIdContratto() {
		return idContratto;
	}

	/// Field [desAutodichiarazione]
	private java.lang.String desAutodichiarazione = null;

	/**
	 * imposta il valore del campo [desAutodichiarazione]
	 * @param val
	 * @generated
	 */

	public void setDesAutodichiarazione(java.lang.String val) {
		desAutodichiarazione = val;
	}

	/**
	 * legge il valore del campo [desAutodichiarazione]
	 * @generated
	 */
	public java.lang.String getDesAutodichiarazione() {
		return desAutodichiarazione;
	}

	/// Field [flgAutodichiarazione]
	private boolean flgAutodichiarazione = false;

	/**
	 * imposta il valore del campo [flgAutodichiarazione]
	 * @param val
	 * @generated
	 */

	public void setFlgAutodichiarazione(boolean val) {
		flgAutodichiarazione = val;
	}

	/**
	 * legge il valore del campo [flgAutodichiarazione]
	 * @generated
	 */
	public boolean getFlgAutodichiarazione() {
		return flgAutodichiarazione;
	}

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per la clusterizzazione della sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	/**
	 * Costruttore vuoto del DTO.
	 * @generated
	 */
	public AutodichiarazioneContratto() {
		super();

	}

	/**
	 * @generated
	 */
	public String toString() {
		/*PROTECTED REGION ID(R267351208) ENABLED START*/
		/// inserire qui la logica desiderata per la rappresenatazione a stringa
		return super.toString();
		/*PROTECTED REGION END*/
	}
}
