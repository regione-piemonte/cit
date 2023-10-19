package it.csi.sigit.elencom.dto.ricercamanutentoretns;

import com.opensymphony.xwork2.validator.annotations.*;

/**
 * DTO relativo al ComplexType manutentore.
 * @generated 
 */
@Validation
public class Manutentore implements java.io.Serializable {

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

	/// Field [indirizzo]
	private java.lang.String indirizzo = null;

	/**
	 * imposta il valore del campo [indirizzo]
	 * @param val
	 * @generated
	 */

	public void setIndirizzo(java.lang.String val) {
		indirizzo = val;
	}

	/**
	 * legge il valore del campo [indirizzo]
	 * @generated
	 */
	public java.lang.String getIndirizzo() {
		return indirizzo;
	}

	/// Field [comune]
	private java.lang.String comune = null;

	/**
	 * imposta il valore del campo [comune]
	 * @param val
	 * @generated
	 */

	public void setComune(java.lang.String val) {
		comune = val;
	}

	/**
	 * legge il valore del campo [comune]
	 * @generated
	 */
	public java.lang.String getComune() {
		return comune;
	}

	/// Field [provincia]
	private java.lang.String provincia = null;

	/**
	 * imposta il valore del campo [provincia]
	 * @param val
	 * @generated
	 */

	public void setProvincia(java.lang.String val) {
		provincia = val;
	}

	/**
	 * legge il valore del campo [provincia]
	 * @generated
	 */
	public java.lang.String getProvincia() {
		return provincia;
	}

	/// Field [civico]
	private java.lang.String civico = null;

	/**
	 * imposta il valore del campo [civico]
	 * @param val
	 * @generated
	 */

	public void setCivico(java.lang.String val) {
		civico = val;
	}

	/**
	 * legge il valore del campo [civico]
	 * @generated
	 */
	public java.lang.String getCivico() {
		return civico;
	}

	/// Field [idManutentore]
	private java.lang.String idManutentore = null;

	/**
	 * imposta il valore del campo [idManutentore]
	 * @param val
	 * @generated
	 */

	public void setIdManutentore(java.lang.String val) {
		idManutentore = val;
	}

	/**
	 * legge il valore del campo [idManutentore]
	 * @generated
	 */
	public java.lang.String getIdManutentore() {
		return idManutentore;
	}

	/// Field [flgManutentore]
	private java.lang.String flgManutentore = null;

	/**
	 * imposta il valore del campo [flgManutentore]
	 * @param val
	 * @generated
	 */

	public void setFlgManutentore(java.lang.String val) {
		flgManutentore = val;
	}

	/**
	 * legge il valore del campo [flgManutentore]
	 * @generated
	 */
	public java.lang.String getFlgManutentore() {
		return flgManutentore;
	}

	/// Field [flgTerzoResponsabile]
	private java.lang.String flgTerzoResponsabile = null;

	/**
	 * imposta il valore del campo [flgTerzoResponsabile]
	 * @param val
	 * @generated
	 */

	public void setFlgTerzoResponsabile(java.lang.String val) {
		flgTerzoResponsabile = val;
	}

	/**
	 * legge il valore del campo [flgTerzoResponsabile]
	 * @generated
	 */
	public java.lang.String getFlgTerzoResponsabile() {
		return flgTerzoResponsabile;
	}

	/// Field [flgInstallatore]
	private java.lang.String flgInstallatore = null;

	/**
	 * imposta il valore del campo [flgInstallatore]
	 * @param val
	 * @generated
	 */

	public void setFlgInstallatore(java.lang.String val) {
		flgInstallatore = val;
	}

	/**
	 * legge il valore del campo [flgInstallatore]
	 * @generated
	 */
	public java.lang.String getFlgInstallatore() {
		return flgInstallatore;
	}

	/// Field [ubicazione]
	private java.lang.String ubicazione = null;

	/**
	 * imposta il valore del campo [ubicazione]
	 * @param val
	 * @generated
	 */

	public void setUbicazione(java.lang.String val) {
		ubicazione = val;
	}

	/**
	 * legge il valore del campo [ubicazione]
	 * @generated
	 */
	public java.lang.String getUbicazione() {
		return ubicazione;
	}

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per la clusterizzazione della sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	/**
	 * Costruttore vuoto del DTO.
	 * @generated
	 */
	public Manutentore() {
		super();

	}

	/**
	 * @generated
	 */
	public String toString() {
		/*PROTECTED REGION ID(R-2028183958) ENABLED START*/
		/// inserire qui la logica desiderata per la rappresenatazione a stringa
		return super.toString();
		/*PROTECTED REGION END*/
	}
}
