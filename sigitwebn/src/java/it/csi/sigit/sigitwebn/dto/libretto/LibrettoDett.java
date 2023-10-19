package it.csi.sigit.sigitwebn.dto.libretto;

public class LibrettoDett implements java.io.Serializable {

	/// Field [idLibretto]
	private int idLibretto = 0;

	/**
	 * imposta il valore del campo [idLibretto]
	 * @param val
	 * @generated
	 */

	public void setIdLibretto(int val) {
		idLibretto = val;
	}

	/**
	 * legge il valore del campo [idLibretto]
	 * @generated
	 */
	public int getIdLibretto() {
		return idLibretto;
	}

	/// Field [dataConsolidamento]
	private java.lang.String dataConsolidamento = null;

	/**
	 * imposta il valore del campo [dataConsolidamento]
	 * @param val
	 * @generated
	 */

	public void setDataConsolidamento(java.lang.String val) {
		dataConsolidamento = val;
	}

	/**
	 * legge il valore del campo [dataConsolidamento]
	 * @generated
	 */
	public java.lang.String getDataConsolidamento() {
		return dataConsolidamento;
	}

	/// Field [descTipoIntervento]
	private java.lang.String descTipoIntervento = null;

	/**
	 * imposta il valore del campo [descTipoIntervento]
	 * @param val
	 * @generated
	 */

	public void setDescTipoIntervento(java.lang.String val) {
		descTipoIntervento = val;
	}

	/**
	 * legge il valore del campo [descTipoIntervento]
	 * @generated
	 */
	public java.lang.String getDescTipoIntervento() {
		return descTipoIntervento;
	}

	/// Field [nomeDocumento]
	private java.lang.String nomeDocumento = null;

	/**
	 * imposta il valore del campo [nomeDocumento]
	 * @param val
	 * @generated
	 */

	public void setNomeDocumento(java.lang.String val) {
		nomeDocumento = val;
	}

	/**
	 * legge il valore del campo [nomeDocumento]
	 * @generated
	 */
	public java.lang.String getNomeDocumento() {
		return nomeDocumento;
	}

	/// Field [uid]
	private java.lang.String uid = null;

	/**
	 * imposta il valore del campo [uid]
	 * @param val
	 * @generated
	 */

	public void setUid(java.lang.String val) {
		uid = val;
	}

	/**
	 * legge il valore del campo [uid]
	 * @generated
	 */
	public java.lang.String getUid() {
		return uid;
	}

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per la clusterizzazione della sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	/**
	 * Costruttore vuoto del DTO.
	 * @generated
	 */
	public LibrettoDett() {
		super();

	}

	/**
	 * @generated
	 */
	public String toString() {
		/*PROTECTED REGION ID(R-1828892023) ENABLED START*/
		/// inserire qui la logica desiderata per la rappresenatazione a stringa
		return super.toString();
		/*PROTECTED REGION END*/
	}
}
