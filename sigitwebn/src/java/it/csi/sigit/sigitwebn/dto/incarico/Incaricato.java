package it.csi.sigit.sigitwebn.dto.incarico;

public class Incaricato implements java.io.Serializable {

	/// Field [idIncaricato]
	private java.lang.String idIncaricato = null;

	/**
	 * imposta il valore del campo [idIncaricato]
	 * @param val
	 * @generated
	 */

	public void setIdIncaricato(java.lang.String val) {
		idIncaricato = val;
	}

	/**
	 * legge il valore del campo [idIncaricato]
	 * @generated
	 */
	public java.lang.String getIdIncaricato() {
		return idIncaricato;
	}

	/// Field [codiceFiscale]
	private java.lang.String codiceFiscale = null;

	/**
	 * imposta il valore del campo [codiceFiscale]
	 * @param val
	 * @generated
	 */

	public void setCodiceFiscale(java.lang.String val) {
		codiceFiscale = val;
	}

	/**
	 * legge il valore del campo [codiceFiscale]
	 * @generated
	 */
	public java.lang.String getCodiceFiscale() {
		return codiceFiscale;
	}

	/// Field [denominazione]
	private java.lang.String denominazione = null;

	/**
	 * imposta il valore del campo [denominazione]
	 * @param val
	 * @generated
	 */

	public void setDenominazione(java.lang.String val) {
		denominazione = val;
	}

	/**
	 * legge il valore del campo [denominazione]
	 * @generated
	 */
	public java.lang.String getDenominazione() {
		return denominazione;
	}

	/// Field [dataIncaricoDal]
	private java.lang.String dataIncaricoDal = null;

	/**
	 * imposta il valore del campo [dataIncaricoDal]
	 * @param val
	 * @generated
	 */

	public void setDataIncaricoDal(java.lang.String val) {
		dataIncaricoDal = val;
	}

	/**
	 * legge il valore del campo [dataIncaricoDal]
	 * @generated
	 */
	public java.lang.String getDataIncaricoDal() {
		return dataIncaricoDal;
	}

	/// Field [dataIncaricoAl]
	private java.lang.String dataIncaricoAl = null;

	/**
	 * imposta il valore del campo [dataIncaricoAl]
	 * @param val
	 * @generated
	 */

	public void setDataIncaricoAl(java.lang.String val) {
		dataIncaricoAl = val;
	}

	/**
	 * legge il valore del campo [dataIncaricoAl]
	 * @generated
	 */
	public java.lang.String getDataIncaricoAl() {
		return dataIncaricoAl;
	}

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per la clusterizzazione della sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	/**
	 * Costruttore vuoto del DTO.
	 * @generated
	 */
	public Incaricato() {
		super();

	}

	/**
	 * @generated
	 */
	public String toString() {
		/*PROTECTED REGION ID(R-1683791757) ENABLED START*/
		/// inserire qui la logica desiderata per la rappresenatazione a stringa
		return super.toString();
		/*PROTECTED REGION END*/
	}
}
