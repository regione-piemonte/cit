package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Primary Key del DTO SigitDStatoDistribDto.
 * E' utilizzato per tutte le operazioni di lettura dati per chiave primaria. 
 * @generated
 */
public class SigitDStatoDistribPk implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna ID_STATO_DISTRIB
	 * @generated
	 */
	protected Integer idStatoDistrib;

	/**
	 * Imposta il valore della proprieta' idStatoDistrib associata alla
	 * colonna ID_STATO_DISTRIB.
	 * @generated
	 */
	public void setIdStatoDistrib(Integer val) {

		idStatoDistrib = val;

	}

	/**
	 * Legge il valore della proprieta' idStatoDistrib associata alla
	 * @generated
	 */
	public Integer getIdStatoDistrib() {

		return idStatoDistrib;

	}

	/**
	 * Costruttore di una chiave primaria vuota
	 * @generated 
	 */
	public SigitDStatoDistribPk() {
		//empty constructor
	}

	/**
	 * Costruttore di una chiave primaria a partire dai valori delle varie colonne
	 * @generated
	 */
	public SigitDStatoDistribPk(

			final Integer idStatoDistrib

	) {

		this.setIdStatoDistrib(idStatoDistrib);

	}

	/**
	 * Method 'equals'. 
	 * Due istanze di SigitDStatoDistribPk sono equals se i valori di tutti i campi coincidono.
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

		if (!(_other instanceof SigitDStatoDistribPk)) {
			return false;
		}

		final SigitDStatoDistribPk _cast = (SigitDStatoDistribPk) _other;

		if (idStatoDistrib == null
				? _cast.getIdStatoDistrib() != null
				: !idStatoDistrib.equals(_cast.getIdStatoDistrib())) {
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

		if (idStatoDistrib != null) {
			_hashCode = 29 * _hashCode + idStatoDistrib.hashCode();
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

		ret.append("it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitDStatoDistribPk: ");
		ret.append("idStatoDistrib=" + idStatoDistrib);

		return ret.toString();
	}
}
