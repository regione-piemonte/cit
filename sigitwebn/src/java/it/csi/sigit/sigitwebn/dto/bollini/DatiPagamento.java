package it.csi.sigit.sigitwebn.dto.bollini;

public class DatiPagamento implements java.io.Serializable {

	/// Field [idGestorePagamento]
	private java.lang.String idGestorePagamento = null;

	/**
	 * imposta il valore del campo [idGestorePagamento]
	 * @param val
	 * @generated
	 */

	public void setIdGestorePagamento(java.lang.String val) {
		idGestorePagamento = val;
	}

	/**
	 * legge il valore del campo [idGestorePagamento]
	 * @generated
	 */
	public java.lang.String getIdGestorePagamento() {
		return idGestorePagamento;
	}

	/// Field [importo]
	private java.lang.String importo = null;

	/**
	 * imposta il valore del campo [importo]
	 * @param val
	 * @generated
	 */

	public void setImporto(java.lang.String val) {
		importo = val;
	}

	/**
	 * legge il valore del campo [importo]
	 * @generated
	 */
	public java.lang.String getImporto() {
		return importo;
	}

	/// Field [dataValuta]
	private java.lang.String dataValuta = null;

	/**
	 * imposta il valore del campo [dataValuta]
	 * @param val
	 * @generated
	 */

	public void setDataValuta(java.lang.String val) {
		dataValuta = val;
	}

	/**
	 * legge il valore del campo [dataValuta]
	 * @generated
	 */
	public java.lang.String getDataValuta() {
		return dataValuta;
	}

	/// Field [causale]
	private java.lang.String causale = null;

	/**
	 * imposta il valore del campo [causale]
	 * @param val
	 * @generated
	 */

	public void setCausale(java.lang.String val) {
		causale = val;
	}

	/**
	 * legge il valore del campo [causale]
	 * @generated
	 */
	public java.lang.String getCausale() {
		return causale;
	}

	/// Field [idMetodoPagamento]
	private java.lang.Integer idMetodoPagamento = null;

	/**
	 * imposta il valore del campo [idMetodoPagamento]
	 * @param val
	 * @generated
	 */

	public void setIdMetodoPagamento(java.lang.Integer val) {
		idMetodoPagamento = val;
	}

	/**
	 * legge il valore del campo [idMetodoPagamento]
	 * @generated
	 */
	public java.lang.Integer getIdMetodoPagamento() {
		return idMetodoPagamento;
	}

	/// Field [descMetodoPagamento]
	private java.lang.String descMetodoPagamento = null;

	/**
	 * imposta il valore del campo [descMetodoPagamento]
	 * @param val
	 * @generated
	 */

	public void setDescMetodoPagamento(java.lang.String val) {
		descMetodoPagamento = val;
	}

	/**
	 * legge il valore del campo [descMetodoPagamento]
	 * @generated
	 */
	public java.lang.String getDescMetodoPagamento() {
		return descMetodoPagamento;
	}

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per la clusterizzazione della sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	/**
	 * Costruttore vuoto del DTO.
	 * @generated
	 */
	public DatiPagamento() {
		super();

	}

	/**
	 * @generated
	 */
	public String toString() {
		/*PROTECTED REGION ID(R-415610057) ENABLED START*/
		/// inserire qui la logica desiderata per la rappresenatazione a stringa
		return super.toString();
		/*PROTECTED REGION END*/
	}
}
