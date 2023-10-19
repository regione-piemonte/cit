package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Primary Key del DTO SigitDCategoriaUtilDto.
 * E' utilizzato per tutte le operazioni di lettura dati per chiave primaria. 
 * @generated
 */
public class SigitDCategoriaUtilPk implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna ID_CATEGORIA_UTIL
	 * @generated
	 */
	protected String idCategoriaUtil;

	/**
	 * Imposta il valore della proprieta' idCategoriaUtil associata alla
	 * colonna ID_CATEGORIA_UTIL.
	 * @generated
	 */
	public void setIdCategoriaUtil(String val) {

		idCategoriaUtil = val;

	}

	/**
	 * Legge il valore della proprieta' idCategoriaUtil associata alla
	 * @generated
	 */
	public String getIdCategoriaUtil() {

		return idCategoriaUtil;

	}

	/**
	 * Costruttore di una chiave primaria vuota
	 * @generated 
	 */
	public SigitDCategoriaUtilPk() {
		//empty constructor
	}

	/**
	 * Costruttore di una chiave primaria a partire dai valori delle varie colonne
	 * @generated
	 */
	public SigitDCategoriaUtilPk(

			final String idCategoriaUtil

	) {

		this.setIdCategoriaUtil(idCategoriaUtil);

	}

	/**
	 * Method 'equals'. 
	 * Due istanze di SigitDCategoriaUtilPk sono equals se i valori di tutti i campi coincidono.
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

		if (!(_other instanceof SigitDCategoriaUtilPk)) {
			return false;
		}

		final SigitDCategoriaUtilPk _cast = (SigitDCategoriaUtilPk) _other;

		if (idCategoriaUtil == null
				? _cast.getIdCategoriaUtil() != null
				: !idCategoriaUtil.equals(_cast.getIdCategoriaUtil())) {
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

		if (idCategoriaUtil != null) {
			_hashCode = 29 * _hashCode + idCategoriaUtil.hashCode();
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

		ret.append("it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitDCategoriaUtilPk: ");
		ret.append("idCategoriaUtil=" + idCategoriaUtil);

		return ret.toString();
	}
}
