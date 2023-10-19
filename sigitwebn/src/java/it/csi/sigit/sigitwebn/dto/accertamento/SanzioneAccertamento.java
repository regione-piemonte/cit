package it.csi.sigit.sigitwebn.dto.accertamento;

public class SanzioneAccertamento implements java.io.Serializable {

	/// Field [idSanzione]
	private java.lang.Integer idSanzione = null;

	/**
	 * imposta il valore del campo [idSanzione]
	 * @param val
	 * @generated
	 */

	public void setIdSanzione(java.lang.Integer val) {
		idSanzione = val;
	}

	/**
	 * legge il valore del campo [idSanzione]
	 * @generated
	 */
	public java.lang.Integer getIdSanzione() {
		return idSanzione;
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

	/// Field [descMotivoSanzione]
	private java.lang.String descMotivoSanzione = null;

	/**
	 * imposta il valore del campo [descMotivoSanzione]
	 * @param val
	 * @generated
	 */

	public void setDescMotivoSanzione(java.lang.String val) {
		descMotivoSanzione = val;
	}

	/**
	 * legge il valore del campo [descMotivoSanzione]
	 * @generated
	 */
	public java.lang.String getDescMotivoSanzione() {
		return descMotivoSanzione;
	}

	/// Field [descStatoSanzione]
	private java.lang.String descStatoSanzione = null;

	/**
	 * imposta il valore del campo [descStatoSanzione]
	 * @param val
	 * @generated
	 */

	public void setDescStatoSanzione(java.lang.String val) {
		descStatoSanzione = val;
	}

	/**
	 * legge il valore del campo [descStatoSanzione]
	 * @generated
	 */
	public java.lang.String getDescStatoSanzione() {
		return descStatoSanzione;
	}

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per la clusterizzazione della sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	/**
	 * Costruttore vuoto del DTO.
	 * @generated
	 */
	public SanzioneAccertamento() {
		super();

	}

	/**
	 * @generated
	 */
	public String toString() {
		/*PROTECTED REGION ID(R-2116591395) ENABLED START*/
		/// inserire qui la logica desiderata per la rappresenatazione a stringa
		return super.toString();
		/*PROTECTED REGION END*/
	}
}
