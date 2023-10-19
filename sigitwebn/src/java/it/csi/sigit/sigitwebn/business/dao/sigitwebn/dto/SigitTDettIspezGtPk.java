package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Primary Key del DTO SigitTDettIspezGtDto.
 * E' utilizzato per tutte le operazioni di lettura dati per chiave primaria. 
 * @generated
 */
public class SigitTDettIspezGtPk implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna ID_DETT_ISPEZ_GT
	 * @generated
	 */
	protected java.math.BigDecimal idDettIspezGt;

	/**
	 * Imposta il valore della proprieta' idDettIspezGt associata alla
	 * colonna ID_DETT_ISPEZ_GT.
	 * @generated
	 */
	public void setIdDettIspezGt(java.math.BigDecimal val) {

		idDettIspezGt = val;

	}

	/**
	 * Legge il valore della proprieta' idDettIspezGt associata alla
	 * @generated
	 */
	public java.math.BigDecimal getIdDettIspezGt() {

		return idDettIspezGt;

	}

	/**
	 * Costruttore di una chiave primaria vuota
	 * @generated 
	 */
	public SigitTDettIspezGtPk() {
		//empty constructor
	}

	/**
	 * Costruttore di una chiave primaria a partire dai valori delle varie colonne
	 * @generated
	 */
	public SigitTDettIspezGtPk(

			final java.math.BigDecimal idDettIspezGt

	) {

		this.setIdDettIspezGt(idDettIspezGt);

	}

	/**
	 * Method 'equals'. 
	 * Due istanze di SigitTDettIspezGtPk sono equals se i valori di tutti i campi coincidono.
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

		if (!(_other instanceof SigitTDettIspezGtPk)) {
			return false;
		}

		final SigitTDettIspezGtPk _cast = (SigitTDettIspezGtPk) _other;

		if (idDettIspezGt == null
				? _cast.getIdDettIspezGt() != null
				: !idDettIspezGt.equals(_cast.getIdDettIspezGt())) {
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

		if (idDettIspezGt != null) {
			_hashCode = 29 * _hashCode + idDettIspezGt.hashCode();
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

		ret.append("it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTDettIspezGtPk: ");
		ret.append("idDettIspezGt=" + idDettIspezGt);

		return ret.toString();
	}
}
