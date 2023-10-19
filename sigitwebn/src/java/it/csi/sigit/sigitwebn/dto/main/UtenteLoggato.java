package it.csi.sigit.sigitwebn.dto.main;

public class UtenteLoggato implements java.io.Serializable {

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

	/// Field [ruolo]
	private it.csi.sigit.sigitwebn.dto.accesso.Ruolo ruolo = null;

	/**
	 * imposta il valore del campo [ruolo]
	 * @param val
	 * @generated
	 */

	public void setRuolo(it.csi.sigit.sigitwebn.dto.accesso.Ruolo val) {
		ruolo = val;
	}

	/**
	 * legge il valore del campo [ruolo]
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.dto.accesso.Ruolo getRuolo() {
		return ruolo;
	}

	/// Field [abilitazioniRuoloFunz]
	private it.csi.sigit.sigitwebn.dto.accesso.AbilitazioniRuoloFunz abilitazioniRuoloFunz = null;

	/**
	 * imposta il valore del campo [abilitazioniRuoloFunz]
	 * @param val
	 * @generated
	 */

	public void setAbilitazioniRuoloFunz(it.csi.sigit.sigitwebn.dto.accesso.AbilitazioniRuoloFunz val) {
		abilitazioniRuoloFunz = val;
	}

	/**
	 * legge il valore del campo [abilitazioniRuoloFunz]
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.dto.accesso.AbilitazioniRuoloFunz getAbilitazioniRuoloFunz() {
		return abilitazioniRuoloFunz;
	}

	/// Field [idPersonaFisica]
	private java.lang.String idPersonaFisica = null;

	/**
	 * imposta il valore del campo [idPersonaFisica]
	 * @param val
	 * @generated
	 */

	public void setIdPersonaFisica(java.lang.String val) {
		idPersonaFisica = val;
	}

	/**
	 * legge il valore del campo [idPersonaFisica]
	 * @generated
	 */
	public java.lang.String getIdPersonaFisica() {
		return idPersonaFisica;
	}

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per la clusterizzazione della sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	/**
	 * Costruttore vuoto del DTO.
	 * @generated
	 */
	public UtenteLoggato() {
		super();

	}

	/**
	 * @generated
	 */
	public String toString() {
		/*PROTECTED REGION ID(R1203698085) ENABLED START*/
		/// inserire qui la logica desiderata per la rappresenatazione a stringa
		return super.toString();
		/*PROTECTED REGION END*/
	}
}
