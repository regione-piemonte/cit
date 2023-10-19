package it.csi.sigit.elencom.dto.ricercamanutentoretns;

public class Corso implements java.io.Serializable {

	/// Field [descrizione]
	private java.lang.String descrizione = null;

	/**
	 * imposta il valore del campo [descrizione]
	 * @param val
	 * @generated
	 */

	public void setDescrizione(java.lang.String val) {
		descrizione = val;
	}

	/**
	 * legge il valore del campo [descrizione]
	 * @generated
	 */
	public java.lang.String getDescrizione() {
		return descrizione;
	}

	/// Field [dataCorso]
	private java.lang.String dataCorso = null;

	/**
	 * imposta il valore del campo [dataCorso]
	 * @param val
	 * @generated
	 */

	public void setDataCorso(java.lang.String val) {
		dataCorso = val;
	}

	/**
	 * legge il valore del campo [dataCorso]
	 * @generated
	 */
	public java.lang.String getDataCorso() {
		return dataCorso;
	}

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per la clusterizzazione della sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	/**
	 * Costruttore vuoto del DTO.
	 * @generated
	 */
	public Corso() {
		super();

	}

	/**
	 * @generated
	 */
	public String toString() {
		/*PROTECTED REGION ID(R1685494876) ENABLED START*/
		/// inserire qui la logica desiderata per la rappresenatazione a stringa
		return super.toString();
		/*PROTECTED REGION END*/
	}
}
