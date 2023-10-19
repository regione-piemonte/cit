package it.csi.sigit.sigitwebn.dto.impianto;

public class Storico implements java.io.Serializable {

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

	/// Field [dataEvento]
	private java.lang.String dataEvento = null;

	/**
	 * imposta il valore del campo [dataEvento]
	 * @param val
	 * @generated
	 */

	public void setDataEvento(java.lang.String val) {
		dataEvento = val;
	}

	/**
	 * legge il valore del campo [dataEvento]
	 * @generated
	 */
	public java.lang.String getDataEvento() {
		return dataEvento;
	}

	/// Field [motivo]
	private java.lang.String motivo = null;

	/**
	 * imposta il valore del campo [motivo]
	 * @param val
	 * @generated
	 */

	public void setMotivo(java.lang.String val) {
		motivo = val;
	}

	/**
	 * legge il valore del campo [motivo]
	 * @generated
	 */
	public java.lang.String getMotivo() {
		return motivo;
	}

	/// Field [dataVariazione]
	private java.lang.String dataVariazione = null;

	/**
	 * imposta il valore del campo [dataVariazione]
	 * @param val
	 * @generated
	 */

	public void setDataVariazione(java.lang.String val) {
		dataVariazione = val;
	}

	/**
	 * legge il valore del campo [dataVariazione]
	 * @generated
	 */
	public java.lang.String getDataVariazione() {
		return dataVariazione;
	}

	/// Field [statoDa]
	private java.lang.String statoDa = null;

	/**
	 * imposta il valore del campo [statoDa]
	 * @param val
	 * @generated
	 */

	public void setStatoDa(java.lang.String val) {
		statoDa = val;
	}

	/**
	 * legge il valore del campo [statoDa]
	 * @generated
	 */
	public java.lang.String getStatoDa() {
		return statoDa;
	}

	/// Field [statoA]
	private java.lang.String statoA = null;

	/**
	 * imposta il valore del campo [statoA]
	 * @param val
	 * @generated
	 */

	public void setStatoA(java.lang.String val) {
		statoA = val;
	}

	/**
	 * legge il valore del campo [statoA]
	 * @generated
	 */
	public java.lang.String getStatoA() {
		return statoA;
	}

	/// Field [id]
	private int id = 0;

	/**
	 * imposta il valore del campo [id]
	 * @param val
	 * @generated
	 */

	public void setId(int val) {
		id = val;
	}

	/**
	 * legge il valore del campo [id]
	 * @generated
	 */
	public int getId() {
		return id;
	}

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per la clusterizzazione della sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	/**
	 * Costruttore vuoto del DTO.
	 * @generated
	 */
	public Storico() {
		super();

	}

	/**
	 * @generated
	 */
	public String toString() {
		/*PROTECTED REGION ID(R960783338) ENABLED START*/
		/// inserire qui la logica desiderata per la rappresenatazione a stringa
		return super.toString();
		/*PROTECTED REGION END*/
	}
}
