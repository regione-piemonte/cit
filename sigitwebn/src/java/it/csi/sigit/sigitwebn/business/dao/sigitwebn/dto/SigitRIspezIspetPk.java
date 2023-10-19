package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Primary Key del DTO SigitRIspezIspetDto.
 * E' utilizzato per tutte le operazioni di lettura dati per chiave primaria. 
 * @generated
 */
public class SigitRIspezIspetPk implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna ID_ISPEZ_ISPET
	 * @generated
	 */
	protected java.math.BigDecimal idIspezIspet;

	/**
	 * Imposta il valore della proprieta' idIspezIspet associata alla
	 * colonna ID_ISPEZ_ISPET.
	 * @generated
	 */
	public void setIdIspezIspet(java.math.BigDecimal val) {

		idIspezIspet = val;

	}

	/**
	 * Legge il valore della proprieta' idIspezIspet associata alla
	 * @generated
	 */
	public java.math.BigDecimal getIdIspezIspet() {

		return idIspezIspet;

	}

	/**
	 * Costruttore di una chiave primaria vuota
	 * @generated 
	 */
	public SigitRIspezIspetPk() {
		//empty constructor
	}

	/**
	 * Costruttore di una chiave primaria a partire dai valori delle varie colonne
	 * @generated
	 */
	public SigitRIspezIspetPk(

			final java.math.BigDecimal idIspezIspet

	) {

		this.setIdIspezIspet(idIspezIspet);

	}

	/**
	 * Method 'equals'. 
	 * Due istanze di SigitRIspezIspetPk sono equals se i valori di tutti i campi coincidono.
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

		if (!(_other instanceof SigitRIspezIspetPk)) {
			return false;
		}

		final SigitRIspezIspetPk _cast = (SigitRIspezIspetPk) _other;

		if (idIspezIspet == null ? _cast.getIdIspezIspet() != null : !idIspezIspet.equals(_cast.getIdIspezIspet())) {
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

		if (idIspezIspet != null) {
			_hashCode = 29 * _hashCode + idIspezIspet.hashCode();
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

		ret.append("it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitRIspezIspetPk: ");
		ret.append("idIspezIspet=" + idIspezIspet);

		return ret.toString();
	}
}
