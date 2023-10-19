package it.csi.sigit.sigitext.dto.sigitext;

import it.csi.iride2.iridefed.entity.Ruolo;

public class UtenteLoggatoModel implements java.io.Serializable {

	/// Field [denominazione]
	private String denominazione = null;

	/**
	 * imposta il valore del campo [denominazione]
	 * @param val
	 * @generated
	 */

	public void setDenominazione(String val) {
		denominazione = val;
	}

	/**
	 * legge il valore del campo [denominazione]
	 * @generated
	 */
	public String getDenominazione() {
		return denominazione;
	}

	/// Field [codiceFiscale]
	private String codiceFiscale = null;

	/**
	 * imposta il valore del campo [codiceFiscale]
	 * @param val
	 * @generated
	 */

	public void setCodiceFiscale(String val) {
		codiceFiscale = val;
	}

	/**
	 * legge il valore del campo [codiceFiscale]
	 * @generated
	 */
	public String getCodiceFiscale() {
		return codiceFiscale;
	}

	/// Field [ruolo]
	private Ruolo ruolo = null;

	/**
	 * imposta il valore del campo [ruolo]
	 * @param val
	 * @generated
	 */

	public void setRuolo(Ruolo val) {
		ruolo = val;
	}

	/**
	 * legge il valore del campo [ruolo]
	 * @generated
	 */
	public Ruolo getRuolo() {
		return ruolo;
	}

	/// Field [abilitazioniRuoloFunz]
	private AbilitazioniRuoloFunz abilitazioniRuoloFunz = null;

	/**
	 * imposta il valore del campo [abilitazioniRuoloFunz]
	 * @param val
	 * @generated
	 */

	public void setAbilitazioniRuoloFunz(AbilitazioniRuoloFunz val) {
		abilitazioniRuoloFunz = val;
	}

	/**
	 * legge il valore del campo [abilitazioniRuoloFunz]
	 * @generated
	 */
	public AbilitazioniRuoloFunz getAbilitazioniRuoloFunz() {
		return abilitazioniRuoloFunz;
	}

	/// Field [idPersonaFisica]
	private String idPersonaFisica = null;

	/**
	 * imposta il valore del campo [idPersonaFisica]
	 * @param val
	 * @generated
	 */

	public void setIdPersonaFisica(String val) {
		idPersonaFisica = val;
	}

	/**
	 * legge il valore del campo [idPersonaFisica]
	 * @generated
	 */
	public String getIdPersonaFisica() {
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
	public UtenteLoggatoModel() {
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
