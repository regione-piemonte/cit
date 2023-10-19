package it.csi.sigit.sigitwebn.dto.ispezioni;

public class FiltroRicercaNumeriBollino implements java.io.Serializable {

	/// Field [siglaBollino]
	private java.lang.String siglaBollino = null;

	/**
	 * imposta il valore del campo [siglaBollino]
	 * @param val
	 * @generated
	 */

	public void setSiglaBollino(java.lang.String val) {
		siglaBollino = val;
	}

	/**
	 * legge il valore del campo [siglaBollino]
	 * @generated
	 */
	public java.lang.String getSiglaBollino() {
		return siglaBollino;
	}

	/// Field [idPersonaGiuridica]
	private java.lang.Integer idPersonaGiuridica = null;

	/**
	 * imposta il valore del campo [idPersonaGiuridica]
	 * @param val
	 * @generated
	 */

	public void setIdPersonaGiuridica(java.lang.Integer val) {
		idPersonaGiuridica = val;
	}

	/**
	 * legge il valore del campo [idPersonaGiuridica]
	 * @generated
	 */
	public java.lang.Integer getIdPersonaGiuridica() {
		return idPersonaGiuridica;
	}

	/// Field [numeroBollino]
	private java.lang.Integer numeroBollino = null;

	/**
	 * imposta il valore del campo [numeroBollino]
	 * @param val
	 * @generated
	 */

	public void setNumeroBollino(java.lang.Integer val) {
		numeroBollino = val;
	}

	/**
	 * legge il valore del campo [numeroBollino]
	 * @generated
	 */
	public java.lang.Integer getNumeroBollino() {
		return numeroBollino;
	}

	/// Field [idAllegato]
	private java.lang.Integer idAllegato = null;

	/**
	 * imposta il valore del campo [idAllegato]
	 * @param val
	 * @generated
	 */

	public void setIdAllegato(java.lang.Integer val) {
		idAllegato = val;
	}

	/**
	 * legge il valore del campo [idAllegato]
	 * @generated
	 */
	public java.lang.Integer getIdAllegato() {
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
	public FiltroRicercaNumeriBollino() {
		super();

	}

	/**
	 * @generated
	 */
	public String toString() {
		/*PROTECTED REGION ID(R-1519178478) ENABLED START*/
		/// inserire qui la logica desiderata per la rappresenatazione a stringa
		return super.toString();
		/*PROTECTED REGION END*/
	}
}
