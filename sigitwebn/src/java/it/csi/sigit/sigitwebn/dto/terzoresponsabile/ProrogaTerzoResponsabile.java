package it.csi.sigit.sigitwebn.dto.terzoresponsabile;

public class ProrogaTerzoResponsabile implements java.io.Serializable {

	/// Field [dataFineContratto]
	private java.lang.String dataFineContratto = null;

	/**
	 * imposta il valore del campo [dataFineContratto]
	 * @param val
	 * @generated
	 */

	public void setDataFineContratto(java.lang.String val) {
		dataFineContratto = val;
	}

	/**
	 * legge il valore del campo [dataFineContratto]
	 * @generated
	 */
	public java.lang.String getDataFineContratto() {
		return dataFineContratto;
	}

	/// Field [idContratto]
	private java.lang.Integer idContratto = null;

	/**
	 * imposta il valore del campo [idContratto]
	 * @param val
	 * @generated
	 */

	public void setIdContratto(java.lang.Integer val) {
		idContratto = val;
	}

	/**
	 * legge il valore del campo [idContratto]
	 * @generated
	 */
	public java.lang.Integer getIdContratto() {
		return idContratto;
	}

	/// Field [flgTacitoRinnovo]
	private boolean flgTacitoRinnovo = false;

	/**
	 * imposta il valore del campo [flgTacitoRinnovo]
	 * @param val
	 * @generated
	 */

	public void setFlgTacitoRinnovo(boolean val) {
		flgTacitoRinnovo = val;
	}

	/**
	 * legge il valore del campo [flgTacitoRinnovo]
	 * @generated
	 */
	public boolean getFlgTacitoRinnovo() {
		return flgTacitoRinnovo;
	}

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per la clusterizzazione della sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	/**
	 * Costruttore vuoto del DTO.
	 * @generated
	 */
	public ProrogaTerzoResponsabile() {
		super();

	}

	/**
	 * @generated
	 */
	public String toString() {
		/*PROTECTED REGION ID(R-986954432) ENABLED START*/
		/// inserire qui la logica desiderata per la rappresenatazione a stringa
		return super.toString();
		/*PROTECTED REGION END*/
	}
}
