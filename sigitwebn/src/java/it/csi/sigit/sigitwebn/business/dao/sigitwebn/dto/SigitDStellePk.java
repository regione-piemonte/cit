package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Primary Key del DTO SigitDStelleDto.
 * E' utilizzato per tutte le operazioni di lettura dati per chiave primaria. 
 * @generated
 */
public class SigitDStellePk implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna ID_STELLE
	 * @generated
	 */
	protected java.math.BigDecimal idStelle;

	/**
	 * Imposta il valore della proprieta' idStelle associata alla
	 * colonna ID_STELLE.
	 * @generated
	 */
	public void setIdStelle(java.math.BigDecimal val) {

		idStelle = val;

	}

	/**
	 * Legge il valore della proprieta' idStelle associata alla
	 * @generated
	 */
	public java.math.BigDecimal getIdStelle() {

		return idStelle;

	}

	/**
	 * Costruttore di una chiave primaria vuota
	 * @generated 
	 */
	public SigitDStellePk() {
		//empty constructor
	}

	/**
	 * Costruttore di una chiave primaria a partire dai valori delle varie colonne
	 * @generated
	 */
	public SigitDStellePk(

			final java.math.BigDecimal idStelle

	) {

		this.setIdStelle(idStelle);

	}

	/**
	 * Method 'equals'. 
	 * Due istanze di SigitDStellePk sono equals se i valori di tutti i campi coincidono.
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

		if (!(_other instanceof SigitDStellePk)) {
			return false;
		}

		final SigitDStellePk _cast = (SigitDStellePk) _other;

		if (idStelle == null ? _cast.getIdStelle() != null : !idStelle.equals(_cast.getIdStelle())) {
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

		if (idStelle != null) {
			_hashCode = 29 * _hashCode + idStelle.hashCode();
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

		ret.append("it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitDStellePk: ");
		ret.append("idStelle=" + idStelle);

		return ret.toString();
	}
}
