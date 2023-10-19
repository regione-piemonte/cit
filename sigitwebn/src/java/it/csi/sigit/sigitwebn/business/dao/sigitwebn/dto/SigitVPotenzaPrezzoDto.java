package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Data transfer object relativo al DAO SigitVPotenzaPrezzoDao.
 * @generated
 */
public class SigitVPotenzaPrezzoDto implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna ID_POTENZA
	 * @generated
	 */
	protected java.math.BigDecimal idPotenza;

	/**
	 * Imposta il valore della proprieta' idPotenza associata alla
	 * colonna ID_POTENZA.
	 * @generated
	 */
	public void setIdPotenza(java.math.BigDecimal val) {

		idPotenza = val;

	}

	/**
	 * Legge il valore della proprieta' idPotenza associata alla
	 * @generated
	 */
	public java.math.BigDecimal getIdPotenza() {

		return idPotenza;

	}

	/**
	 * store della proprieta' associata alla colonna DES_POTENZA
	 * @generated
	 */
	protected String desPotenza;

	/**
	 * Imposta il valore della proprieta' desPotenza associata alla
	 * colonna DES_POTENZA.
	 * @generated
	 */
	public void setDesPotenza(String val) {

		desPotenza = val;

	}

	/**
	 * Legge il valore della proprieta' desPotenza associata alla
	 * @generated
	 */
	public String getDesPotenza() {

		return desPotenza;

	}

	/**
	 * store della proprieta' associata alla colonna LIMITE_INFERIORE
	 * @generated
	 */
	protected java.math.BigDecimal limiteInferiore;

	/**
	 * Imposta il valore della proprieta' limiteInferiore associata alla
	 * colonna LIMITE_INFERIORE.
	 * @generated
	 */
	public void setLimiteInferiore(java.math.BigDecimal val) {

		limiteInferiore = val;

	}

	/**
	 * Legge il valore della proprieta' limiteInferiore associata alla
	 * @generated
	 */
	public java.math.BigDecimal getLimiteInferiore() {

		return limiteInferiore;

	}

	/**
	 * store della proprieta' associata alla colonna LIMITE_SUPERIORE
	 * @generated
	 */
	protected java.math.BigDecimal limiteSuperiore;

	/**
	 * Imposta il valore della proprieta' limiteSuperiore associata alla
	 * colonna LIMITE_SUPERIORE.
	 * @generated
	 */
	public void setLimiteSuperiore(java.math.BigDecimal val) {

		limiteSuperiore = val;

	}

	/**
	 * Legge il valore della proprieta' limiteSuperiore associata alla
	 * @generated
	 */
	public java.math.BigDecimal getLimiteSuperiore() {

		return limiteSuperiore;

	}

	/**
	 * store della proprieta' associata alla colonna ID_PREZZO
	 * @generated
	 */
	protected java.math.BigDecimal idPrezzo;

	/**
	 * Imposta il valore della proprieta' idPrezzo associata alla
	 * colonna ID_PREZZO.
	 * @generated
	 */
	public void setIdPrezzo(java.math.BigDecimal val) {

		idPrezzo = val;

	}

	/**
	 * Legge il valore della proprieta' idPrezzo associata alla
	 * @generated
	 */
	public java.math.BigDecimal getIdPrezzo() {

		return idPrezzo;

	}

	/**
	 * store della proprieta' associata alla colonna PREZZO
	 * @generated
	 */
	protected java.math.BigDecimal prezzo;

	/**
	 * Imposta il valore della proprieta' prezzo associata alla
	 * colonna PREZZO.
	 * @generated
	 */
	public void setPrezzo(java.math.BigDecimal val) {

		prezzo = val;

	}

	/**
	 * Legge il valore della proprieta' prezzo associata alla
	 * @generated
	 */
	public java.math.BigDecimal getPrezzo() {

		return prezzo;

	}

	/**
	 * store della proprieta' associata alla colonna DT_INIZIO
	 * @generated
	 */
	protected java.sql.Date dtInizio;

	/**
	 * Imposta il valore della proprieta' dtInizio associata alla
	 * colonna DT_INIZIO.
	 * @generated
	 */
	public void setDtInizio(java.sql.Date val) {

		if (val != null) {
			dtInizio = new java.sql.Date(val.getTime());
		} else {
			dtInizio = null;
		}

	}

	/**
	 * Legge il valore della proprieta' dtInizio associata alla
	 * @generated
	 */
	public java.sql.Date getDtInizio() {

		if (dtInizio != null) {
			return new java.sql.Date(dtInizio.getTime());
		} else {
			return null;
		}

	}

	/**
	 * store della proprieta' associata alla colonna DT_FINE
	 * @generated
	 */
	protected java.sql.Date dtFine;

	/**
	 * Imposta il valore della proprieta' dtFine associata alla
	 * colonna DT_FINE.
	 * @generated
	 */
	public void setDtFine(java.sql.Date val) {

		if (val != null) {
			dtFine = new java.sql.Date(val.getTime());
		} else {
			dtFine = null;
		}

	}

	/**
	 * Legge il valore della proprieta' dtFine associata alla
	 * @generated
	 */
	public java.sql.Date getDtFine() {

		if (dtFine != null) {
			return new java.sql.Date(dtFine.getTime());
		} else {
			return null;
		}

	}

}
