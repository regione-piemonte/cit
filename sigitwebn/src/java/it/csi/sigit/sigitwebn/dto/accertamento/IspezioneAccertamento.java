package it.csi.sigit.sigitwebn.dto.accertamento;

public class IspezioneAccertamento implements java.io.Serializable {

	/// Field [idIspezione]
	private java.lang.Integer idIspezione = null;

	/**
	 * imposta il valore del campo [idIspezione]
	 * @param val
	 * @generated
	 */

	public void setIdIspezione(java.lang.Integer val) {
		idIspezione = val;
	}

	/**
	 * legge il valore del campo [idIspezione]
	 * @generated
	 */
	public java.lang.Integer getIdIspezione() {
		return idIspezione;
	}

	/// Field [idStatoIspezione]
	private java.lang.Integer idStatoIspezione = null;

	/**
	 * imposta il valore del campo [idStatoIspezione]
	 * @param val
	 * @generated
	 */

	public void setIdStatoIspezione(java.lang.Integer val) {
		idStatoIspezione = val;
	}

	/**
	 * legge il valore del campo [idStatoIspezione]
	 * @generated
	 */
	public java.lang.Integer getIdStatoIspezione() {
		return idStatoIspezione;
	}

	/// Field [descStatoIspezione]
	private java.lang.String descStatoIspezione = null;

	/**
	 * imposta il valore del campo [descStatoIspezione]
	 * @param val
	 * @generated
	 */

	public void setDescStatoIspezione(java.lang.String val) {
		descStatoIspezione = val;
	}

	/**
	 * legge il valore del campo [descStatoIspezione]
	 * @generated
	 */
	public java.lang.String getDescStatoIspezione() {
		return descStatoIspezione;
	}

	/// Field [descIspPagamento]
	private java.lang.String descIspPagamento = null;

	/**
	 * imposta il valore del campo [descIspPagamento]
	 * @param val
	 * @generated
	 */

	public void setDescIspPagamento(java.lang.String val) {
		descIspPagamento = val;
	}

	/**
	 * legge il valore del campo [descIspPagamento]
	 * @generated
	 */
	public java.lang.String getDescIspPagamento() {
		return descIspPagamento;
	}

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per la clusterizzazione della sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	/**
	 * Costruttore vuoto del DTO.
	 * @generated
	 */
	public IspezioneAccertamento() {
		super();

	}

	/**
	 * @generated
	 */
	public String toString() {
		/*PROTECTED REGION ID(R377628534) ENABLED START*/
		/// inserire qui la logica desiderata per la rappresenatazione a stringa
		return super.toString();
		/*PROTECTED REGION END*/
	}
}
