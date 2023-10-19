package it.csi.sigit.sigitwebn.dto.verifica;

public class InserimentoIspezioniMassive implements java.io.Serializable {

	/// Field [idTipoVerifica]
	private java.lang.Integer idTipoVerifica = null;

	/**
	 * imposta il valore del campo [idTipoVerifica]
	 * @param val
	 * @generated
	 */

	public void setIdTipoVerifica(java.lang.Integer val) {
		idTipoVerifica = val;
	}

	/**
	 * legge il valore del campo [idTipoVerifica]
	 * @generated
	 */
	public java.lang.Integer getIdTipoVerifica() {
		return idTipoVerifica;
	}

	/// Field [elencoValori]
	private java.lang.String elencoValori = null;

	/**
	 * imposta il valore del campo [elencoValori]
	 * @param val
	 * @generated
	 */

	public void setElencoValori(java.lang.String val) {
		elencoValori = val;
	}

	/**
	 * legge il valore del campo [elencoValori]
	 * @generated
	 */
	public java.lang.String getElencoValori() {
		return elencoValori;
	}

	/// Field [isIspezionePagamento]
	private boolean isIspezionePagamento = false;

	/**
	 * imposta il valore del campo [isIspezionePagamento]
	 * @param val
	 * @generated
	 */

	public void setIsIspezionePagamento(boolean val) {
		isIspezionePagamento = val;
	}

	/**
	 * legge il valore del campo [isIspezionePagamento]
	 * @generated
	 */
	public boolean getIsIspezionePagamento() {
		return isIspezionePagamento;
	}

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per la clusterizzazione della sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	/**
	 * Costruttore vuoto del DTO.
	 * @generated
	 */
	public InserimentoIspezioniMassive() {
		super();

	}

	/**
	 * @generated
	 */
	public String toString() {
		/*PROTECTED REGION ID(R1847349186) ENABLED START*/
		/// inserire qui la logica desiderata per la rappresenatazione a stringa
		return super.toString();
		/*PROTECTED REGION END*/
	}
}
