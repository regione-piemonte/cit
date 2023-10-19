package it.csi.sigit.elencom.dto.ricercamanutentoretns;

public class CodiceDescrizione implements java.io.Serializable {

	/// Field [codice]
	private java.lang.String codice = null;

	/**
	 * imposta il valore del campo [codice]
	 * @param val
	 * @generated
	 */

	public void setCodice(java.lang.String val) {
		codice = val;
	}

	/**
	 * legge il valore del campo [codice]
	 * @generated
	 */
	public java.lang.String getCodice() {
		return codice;
	}

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

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per la clusterizzazione della sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	/**
	 * Costruttore vuoto del DTO.
	 * @generated
	 */
	public CodiceDescrizione() {
		super();

	}

	/**
	 * @generated
	 */
	public String toString() {
		/*PROTECTED REGION ID(R-198588330) ENABLED START*/
		/// inserire qui la logica desiderata per la rappresenatazione a stringa
		return super.toString();
		/*PROTECTED REGION END*/
	}
}
