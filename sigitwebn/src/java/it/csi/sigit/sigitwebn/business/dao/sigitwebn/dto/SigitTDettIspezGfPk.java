package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Primary Key del DTO SigitTDettIspezGfDto.
 * E' utilizzato per tutte le operazioni di lettura dati per chiave primaria. 
 * @generated
 */
public class SigitTDettIspezGfPk implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna ID_DETT_ISPEZ_GF
	 * @generated
	 */
	protected java.math.BigDecimal idDettIspezGf;

	/**
	 * Imposta il valore della proprieta' idDettIspezGf associata alla
	 * colonna ID_DETT_ISPEZ_GF.
	 * @generated
	 */
	public void setIdDettIspezGf(java.math.BigDecimal val) {

		idDettIspezGf = val;

	}

	/**
	 * Legge il valore della proprieta' idDettIspezGf associata alla
	 * @generated
	 */
	public java.math.BigDecimal getIdDettIspezGf() {

		return idDettIspezGf;

	}

	/**
	 * Costruttore di una chiave primaria vuota
	 * @generated 
	 */
	public SigitTDettIspezGfPk() {
		//empty constructor
	}

	/**
	 * Costruttore di una chiave primaria a partire dai valori delle varie colonne
	 * @generated
	 */
	public SigitTDettIspezGfPk(

			final java.math.BigDecimal idDettIspezGf

	) {

		this.setIdDettIspezGf(idDettIspezGf);

	}

	/**
	 * Method 'equals'. 
	 * Due istanze di SigitTDettIspezGfPk sono equals se i valori di tutti i campi coincidono.
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

		if (!(_other instanceof SigitTDettIspezGfPk)) {
			return false;
		}

		final SigitTDettIspezGfPk _cast = (SigitTDettIspezGfPk) _other;

		if (idDettIspezGf == null
				? _cast.getIdDettIspezGf() != null
				: !idDettIspezGf.equals(_cast.getIdDettIspezGf())) {
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

		if (idDettIspezGf != null) {
			_hashCode = 29 * _hashCode + idDettIspezGf.hashCode();
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

		ret.append("it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTDettIspezGfPk: ");
		ret.append("idDettIspezGf=" + idDettIspezGf);

		return ret.toString();
	}
}
