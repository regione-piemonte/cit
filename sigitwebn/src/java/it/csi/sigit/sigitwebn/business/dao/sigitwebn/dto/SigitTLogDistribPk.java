package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Primary Key del DTO SigitTLogDistribDto.
 * E' utilizzato per tutte le operazioni di lettura dati per chiave primaria. 
 * @generated
 */
public class SigitTLogDistribPk implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna ID_LOG_DISTRIB
	 * @generated
	 */
	protected Integer idLogDistrib;

	/**
	 * Imposta il valore della proprieta' idLogDistrib associata alla
	 * colonna ID_LOG_DISTRIB.
	 * @generated
	 */
	public void setIdLogDistrib(Integer val) {

		idLogDistrib = val;

	}

	/**
	 * Legge il valore della proprieta' idLogDistrib associata alla
	 * @generated
	 */
	public Integer getIdLogDistrib() {

		return idLogDistrib;

	}

	/**
	 * Costruttore di una chiave primaria vuota
	 * @generated 
	 */
	public SigitTLogDistribPk() {
		//empty constructor
	}

	/**
	 * Costruttore di una chiave primaria a partire dai valori delle varie colonne
	 * @generated
	 */
	public SigitTLogDistribPk(

			final Integer idLogDistrib

	) {

		this.setIdLogDistrib(idLogDistrib);

	}

	/**
	 * Method 'equals'. 
	 * Due istanze di SigitTLogDistribPk sono equals se i valori di tutti i campi coincidono.
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

		if (!(_other instanceof SigitTLogDistribPk)) {
			return false;
		}

		final SigitTLogDistribPk _cast = (SigitTLogDistribPk) _other;

		if (idLogDistrib == null ? _cast.getIdLogDistrib() != null : !idLogDistrib.equals(_cast.getIdLogDistrib())) {
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

		if (idLogDistrib != null) {
			_hashCode = 29 * _hashCode + idLogDistrib.hashCode();
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

		ret.append("it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTLogDistribPk: ");
		ret.append("idLogDistrib=" + idLogDistrib);

		return ret.toString();
	}
}
