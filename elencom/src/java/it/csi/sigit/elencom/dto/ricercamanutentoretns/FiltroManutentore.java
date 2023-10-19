package it.csi.sigit.elencom.dto.ricercamanutentoretns;

import com.opensymphony.xwork2.validator.annotations.*;

/**
 * DTO relativo al ComplexType filtroManutentore.
 * @generated 
 */
@Validation
public class FiltroManutentore implements java.io.Serializable {

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

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per la clusterizzazione della sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	/**
	 * Costruttore vuoto del DTO.
	 * @generated
	 */
	public FiltroManutentore() {
		super();

	}

	/**
	 * @generated
	 */
	public String toString() {
		/*PROTECTED REGION ID(R282022338) ENABLED START*/
		/// inserire qui la logica desiderata per la rappresenatazione a stringa
		return super.toString();
		/*PROTECTED REGION END*/
	}
}
