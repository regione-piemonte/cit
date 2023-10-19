/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Data transfer object relativo al DAO SigitVTotImpiantoDao.
 * @generated
 */
public class SigitExtImpiantoDto implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna CODICE_IMPIANTO
	 * @generated
	 */
	private java.math.BigDecimal _codiceImpianto;

	/**
	 * Imposta il valore della proprieta' codiceImpianto associata alla
	 * colonna CODICE_IMPIANTO.
	 * @generated
	 */
	public void setCodiceImpianto(java.math.BigDecimal val) {
		_codiceImpianto = val;
	}

	/**
	 * Legge il valore della proprieta' codiceImpianto associata alla
	 * @generated
	 */
	public java.math.BigDecimal getCodiceImpianto() {
		return _codiceImpianto;
	}

	/**
	 * store della proprieta' associata alla colonna SIGLA_PROVINCIA
	 * @generated
	 */
	private String _siglaProvincia;

	/**
	 * Imposta il valore della proprieta' siglaProvincia associata alla
	 * colonna SIGLA_PROVINCIA.
	 * @generated
	 */
	public void setSiglaProvincia(String val) {
		_siglaProvincia = val;
	}

	/**
	 * Legge il valore della proprieta' siglaProvincia associata alla
	 * @generated
	 */
	public String getSiglaProvincia() {
		return _siglaProvincia;
	}

	/**
	 * store della proprieta' associata alla colonna ISTAT_COMUNE
	 * @generated
	 */
	private String _istatComune;

	/**
	 * Imposta il valore della proprieta' istatComune associata alla
	 * colonna ISTAT_COMUNE.
	 * @generated
	 */
	public void setIstatComune(String val) {
		_istatComune = val;
	}

	/**
	 * Legge il valore della proprieta' istatComune associata alla
	 * @generated
	 */
	public String getIstatComune() {
		return _istatComune;
	}

	/**
	 * store della proprieta' associata alla colonna DENOMINAZIONE_PROVINCIA
	 * @generated
	 */
	private String _denominazioneProvincia;

	/**
	 * Imposta il valore della proprieta' denominazioneProvincia associata alla
	 * colonna DENOMINAZIONE_PROVINCIA.
	 * @generated
	 */
	public void setDenominazioneProvincia(String val) {
		_denominazioneProvincia = val;
	}

	/**
	 * Legge il valore della proprieta' denominazioneProvincia associata alla
	 * @generated
	 */
	public String getDenominazioneProvincia() {
		return _denominazioneProvincia;
	}

	/**
	 * store della proprieta' associata alla colonna DENOMINAZIONE_COMUNE
	 * @generated
	 */
	private String _denominazioneComune;

	/**
	 * Imposta il valore della proprieta' denominazioneComune associata alla
	 * colonna DENOMINAZIONE_COMUNE.
	 * @generated
	 */
	public void setDenominazioneComune(String val) {
		_denominazioneComune = val;
	}

	/**
	 * Legge il valore della proprieta' denominazioneComune associata alla
	 * @generated
	 */
	public String getDenominazioneComune() {
		return _denominazioneComune;
	}

	/**
	 * store della proprieta' associata alla colonna INDIRIZZO
	 * @generated
	 */
	private String _indirizzo;

	/**
	 * Imposta il valore della proprieta' indirizzo associata alla
	 * colonna INDIRIZZO_UNITA_IMMOB.
	 * @generated
	 */
	public void setIndirizzo(String val) {
		_indirizzo = val;
	}

	/**
	 * Legge il valore della proprieta' indirizzo associata alla
	 * @generated
	 */
	public String getIndirizzo() {
		return _indirizzo;
	}
	

	/**
	 * store della proprieta' associata alla colonna CIVICO
	 * @generated
	 */
	private String _civico;

	/**
	 * Imposta il valore della proprieta' civico associata alla
	 * colonna CIVICO.
	 * @generated
	 */
	public void setCivico(String val) {
		_civico = val;
	}

	/**
	 * Legge il valore della proprieta' civico associata alla
	 * @generated
	 */
	public String getCivico() {
		return _civico;
	}

	private String denominazioneResponsabile;
	
	public String getDenominazioneResponsabile() {
		return denominazioneResponsabile;
	}
	
	public void setDenominazioneResponsabile(String denominazioneResponsabile) {
		this.denominazioneResponsabile = denominazioneResponsabile;
	}

	private String denominazione3Responsabile;

	public String getDenominazione3Responsabile() {
		return denominazione3Responsabile;
	}

	public void setDenominazione3Responsabile(String denominazione3Responsabile) {
		this.denominazione3Responsabile = denominazione3Responsabile;
	}
}
