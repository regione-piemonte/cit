package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Primary Key del DTO SigitDStatoPgDto.
 * E' utilizzato per tutte le operazioni di lettura dati per chiave primaria. 
 * @generated
 */
public class SigitDStatoPgPk implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna ID_STATO_PG
	 * @generated
	 */
	protected Integer idStatoPg;

	/**
	 * Imposta il valore della proprieta' idStatoPg associata alla
	 * colonna ID_STATO_PG.
	 * @generated
	 */
	public void setIdStatoPg(Integer val) {

		idStatoPg = val;

	}

	/**
	 * Legge il valore della proprieta' idStatoPg associata alla
	 * @generated
	 */
	public Integer getIdStatoPg() {

		return idStatoPg;

	}

	/**
	 * Costruttore di una chiave primaria vuota
	 * @generated 
	 */
	public SigitDStatoPgPk() {
		//empty constructor
	}

	/**
	 * Costruttore di una chiave primaria a partire dai valori delle varie colonne
	 * @generated
	 */
	public SigitDStatoPgPk(

			final Integer idStatoPg

	) {

		this.setIdStatoPg(idStatoPg);

	}

	/**
	 * Method 'equals'. 
	 * Due istanze di SigitDStatoPgPk sono equals se i valori di tutti i campi coincidono.
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

		if (!(_other instanceof SigitDStatoPgPk)) {
			return false;
		}

		final SigitDStatoPgPk _cast = (SigitDStatoPgPk) _other;

		if (idStatoPg == null ? _cast.getIdStatoPg() != null : !idStatoPg.equals(_cast.getIdStatoPg())) {
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

		if (idStatoPg != null) {
			_hashCode = 29 * _hashCode + idStatoPg.hashCode();
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

		ret.append("it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitDStatoPgPk: ");
		ret.append("idStatoPg=" + idStatoPg);

		return ret.toString();
	}
}
