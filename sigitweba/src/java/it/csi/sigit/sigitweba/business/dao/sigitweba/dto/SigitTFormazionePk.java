package it.csi.sigit.sigitweba.business.dao.sigitweba.dto;

import it.csi.sigit.sigitweba.business.dao.sigitweba.dao.*;
import it.csi.sigit.sigitweba.business.dao.sigitweba.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Primary Key del DTO SigitTFormazioneDto.
 * E' utilizzato per tutte le operazioni di lettura dati per chiave primaria. 
 * @generated
 */
public class SigitTFormazionePk implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna DATA_CORSO
	 * @generated
	 */
	protected java.sql.Date dataCorso;

	/**
	 * Imposta il valore della proprieta' dataCorso associata alla
	 * colonna DATA_CORSO.
	 * @generated
	 */
	public void setDataCorso(java.sql.Date val) {

		if (val != null) {
			dataCorso = new java.sql.Date(val.getTime());
		} else {
			dataCorso = null;
		}

	}

	/**
	 * Legge il valore della proprieta' dataCorso associata alla
	 * @generated
	 */
	public java.sql.Date getDataCorso() {

		if (dataCorso != null) {
			return new java.sql.Date(dataCorso.getTime());
		} else {
			return null;
		}

	}

	/**
	 * store della proprieta' associata alla colonna ID_PERSONA_FISICA
	 * @generated
	 */
	protected java.math.BigDecimal idPersonaFisica;

	/**
	 * Imposta il valore della proprieta' idPersonaFisica associata alla
	 * colonna ID_PERSONA_FISICA.
	 * @generated
	 */
	public void setIdPersonaFisica(java.math.BigDecimal val) {

		idPersonaFisica = val;

	}

	/**
	 * Legge il valore della proprieta' idPersonaFisica associata alla
	 * @generated
	 */
	public java.math.BigDecimal getIdPersonaFisica() {

		return idPersonaFisica;

	}

	/**
	 * Costruttore di una chiave primaria vuota
	 * @generated 
	 */
	public SigitTFormazionePk() {
		//empty constructor
	}

	/**
	 * Costruttore di una chiave primaria a partire dai valori delle varie colonne
	 * @generated
	 */
	public SigitTFormazionePk(

			final java.sql.Date dataCorso, final java.math.BigDecimal idPersonaFisica

	) {

		this.setDataCorso(dataCorso);

		this.setIdPersonaFisica(idPersonaFisica);

	}

	/**
	 * Method 'equals'. 
	 * Due istanze di SigitTFormazionePk sono equals se i valori di tutti i campi coincidono.
	 * 
	 * @param _other
	 * @return boolean se i due oggetti sono uguali
	 */
	public boolean equals(Object _other) {
		if (_other == null) {
			return false;
		}

		if (_other == this) {
			return true;
		}

		if (!(_other instanceof SigitTFormazionePk)) {
			return false;
		}

		final SigitTFormazionePk _cast = (SigitTFormazionePk) _other;

		if (dataCorso == null ? _cast.getDataCorso() != null : !dataCorso.equals(_cast.getDataCorso())) {
			return false;
		}

		if (idPersonaFisica == null
				? _cast.getIdPersonaFisica() != null
				: !idPersonaFisica.equals(_cast.getIdPersonaFisica())) {
			return false;
		}

		return true;
	}

	/**
	 * Method 'hashCode'
	 * 
	 * @return int
	 */
	public int hashCode() {
		int _hashCode = 0;

		if (dataCorso != null) {
			_hashCode = 29 * _hashCode + dataCorso.hashCode();
		}

		if (idPersonaFisica != null) {
			_hashCode = 29 * _hashCode + idPersonaFisica.hashCode();
		}

		return _hashCode;
	}

	/**
	 * Method 'toString'
	 * 
	 * @return String
	 */
	public String toString() {
		StringBuilder ret = new StringBuilder();

		ret.append("it.csi.sigit.sigitweba.business.dao.sigitweba.dto.SigitTFormazionePk: ");
		ret.append("dataCorso=" + dataCorso);

		ret.append("it.csi.sigit.sigitweba.business.dao.sigitweba.dto.SigitTFormazionePk: ");
		ret.append("idPersonaFisica=" + idPersonaFisica);

		return ret.toString();
	}
}
