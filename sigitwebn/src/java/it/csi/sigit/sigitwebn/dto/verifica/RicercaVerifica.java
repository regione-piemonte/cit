package it.csi.sigit.sigitwebn.dto.verifica;

import com.opensymphony.xwork2.validator.annotations.*;

/**
 * DTO relativo al ComplexType ricercaVerifica.
 * @generated 
 */
@Validation
public class RicercaVerifica implements java.io.Serializable {

	/// Field [identificativo]
	private java.lang.String identificativo = null;

	/**
	 * imposta il valore del campo [identificativo]
	 * @param val
	 * @generated
	 */

	public void setIdentificativo(java.lang.String val) {
		identificativo = val;
	}

	/**
	 * legge il valore del campo [identificativo]
	 * @generated
	 */
	public java.lang.String getIdentificativo() {
		return identificativo;
	}

	/// Field [idValidatore]
	private java.lang.String idValidatore = null;

	/**
	 * imposta il valore del campo [idValidatore]
	 * @param val
	 * @generated
	 */

	public void setIdValidatore(java.lang.String val) {
		idValidatore = val;
	}

	/**
	 * legge il valore del campo [idValidatore]
	 * @generated
	 */
	public java.lang.String getIdValidatore() {
		return idValidatore;
	}

	/// Field [dataCreazioneDA]
	private java.lang.String dataCreazioneDA = null;

	/**
	 * imposta il valore del campo [dataCreazioneDA]
	 * @param val
	 * @generated
	 */

	public void setDataCreazioneDA(java.lang.String val) {
		dataCreazioneDA = val;
	}

	/**
	 * legge il valore del campo [dataCreazioneDA]
	 * @generated
	 */
	public java.lang.String getDataCreazioneDA() {
		return dataCreazioneDA;
	}

	/// Field [dataCreazioneA]
	private java.lang.String dataCreazioneA = null;

	/**
	 * imposta il valore del campo [dataCreazioneA]
	 * @param val
	 * @generated
	 */

	public void setDataCreazioneA(java.lang.String val) {
		dataCreazioneA = val;
	}

	/**
	 * legge il valore del campo [dataCreazioneA]
	 * @generated
	 */
	public java.lang.String getDataCreazioneA() {
		return dataCreazioneA;
	}

	/// Field [tipoVerifica]
	private java.lang.Integer tipoVerifica = null;

	/**
	 * imposta il valore del campo [tipoVerifica]
	 * @param val
	 * @generated
	 */

	public void setTipoVerifica(java.lang.Integer val) {
		tipoVerifica = val;
	}

	/**
	 * legge il valore del campo [tipoVerifica]
	 * @generated
	 */
	public java.lang.Integer getTipoVerifica() {
		return tipoVerifica;
	}

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

	/// Field [siglaBollino]
	private java.lang.String siglaBollino = null;

	/**
	 * imposta il valore del campo [siglaBollino]
	 * @param val
	 * @generated
	 */

	public void setSiglaBollino(java.lang.String val) {
		siglaBollino = val;
	}

	/**
	 * legge il valore del campo [siglaBollino]
	 * @generated
	 */
	public java.lang.String getSiglaBollino() {
		return siglaBollino;
	}

	/// Field [numeroBollino]
	private java.lang.String numeroBollino = null;

	/**
	 * imposta il valore del campo [numeroBollino]
	 * @param val
	 * @generated
	 */

	public void setNumeroBollino(java.lang.String val) {
		numeroBollino = val;
	}

	/**
	 * legge il valore del campo [numeroBollino]
	 * @generated
	 */
	public java.lang.String getNumeroBollino() {
		return numeroBollino;
	}

	/// Field [idDatoDistributore]
	private java.lang.String idDatoDistributore = null;

	/**
	 * imposta il valore del campo [idDatoDistributore]
	 * @param val
	 * @generated
	 */

	public void setIdDatoDistributore(java.lang.String val) {
		idDatoDistributore = val;
	}

	/**
	 * legge il valore del campo [idDatoDistributore]
	 * @generated
	 */
	public java.lang.String getIdDatoDistributore() {
		return idDatoDistributore;
	}

	/// Field [checkRicercaAutomatiche]
	private boolean checkRicercaAutomatiche = false;

	/**
	 * imposta il valore del campo [checkRicercaAutomatiche]
	 * @param val
	 * @generated
	 */

	public void setCheckRicercaAutomatiche(boolean val) {
		checkRicercaAutomatiche = val;
	}

	/**
	 * legge il valore del campo [checkRicercaAutomatiche]
	 * @generated
	 */
	public boolean getCheckRicercaAutomatiche() {
		return checkRicercaAutomatiche;
	}

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per la clusterizzazione della sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	/**
	 * Costruttore vuoto del DTO.
	 * @generated
	 */
	public RicercaVerifica() {
		super();

	}

	/**
	 * @generated
	 */
	public String toString() {
		/*PROTECTED REGION ID(R1690736789) ENABLED START*/
		/// inserire qui la logica desiderata per la rappresenatazione a stringa
		return super.toString();
		/*PROTECTED REGION END*/
	}
}
