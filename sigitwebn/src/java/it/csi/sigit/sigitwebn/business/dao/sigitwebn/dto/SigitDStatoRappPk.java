package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Primary Key del DTO SigitDStatoRappDto.
 * E' utilizzato per tutte le operazioni di lettura dati per chiave primaria. 
 * @generated
 */
public class SigitDStatoRappPk implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna ID_STATO_RAPP
	 * @generated
	 */
	protected java.math.BigDecimal idStatoRapp;

	/**
	 * Imposta il valore della proprieta' idStatoRapp associata alla
	 * colonna ID_STATO_RAPP.
	 * @generated
	 */
	public void setIdStatoRapp(java.math.BigDecimal val) {

		idStatoRapp = val;

	}

	/**
	 * Legge il valore della proprieta' idStatoRapp associata alla
	 * @generated
	 */
	public java.math.BigDecimal getIdStatoRapp() {

		return idStatoRapp;

	}

	/**
	 * Costruttore di una chiave primaria vuota
	 * @generated 
	 */
	public SigitDStatoRappPk() {
		//empty constructor
	}

	/**
	 * Costruttore di una chiave primaria a partire dai valori delle varie colonne
	 * @generated
	 */
	public SigitDStatoRappPk(

			final java.math.BigDecimal idStatoRapp

	) {

		this.setIdStatoRapp(idStatoRapp);

	}

	/**
	 * Method 'equals'. 
	 * Due istanze di SigitDStatoRappPk sono equals se i valori di tutti i campi coincidono.
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

		if (!(_other instanceof SigitDStatoRappPk)) {
			return false;
		}

		final SigitDStatoRappPk _cast = (SigitDStatoRappPk) _other;

		if (idStatoRapp == null ? _cast.getIdStatoRapp() != null : !idStatoRapp.equals(_cast.getIdStatoRapp())) {
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

		if (idStatoRapp != null) {
			_hashCode = 29 * _hashCode + idStatoRapp.hashCode();
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

		ret.append("it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitDStatoRappPk: ");
		ret.append("idStatoRapp=" + idStatoRapp);

		return ret.toString();
	}
}
