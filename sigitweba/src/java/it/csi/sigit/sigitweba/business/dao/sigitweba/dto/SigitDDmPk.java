package it.csi.sigit.sigitweba.business.dao.sigitweba.dto;

import it.csi.sigit.sigitweba.business.dao.sigitweba.dao.*;
import it.csi.sigit.sigitweba.business.dao.sigitweba.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Primary Key del DTO SigitDDmDto.
 * E' utilizzato per tutte le operazioni di lettura dati per chiave primaria. 
 * @generated
 */
public class SigitDDmPk implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna TIPO_DM37_2008
	 * @generated
	 */
	protected String tipoDm372008;

	/**
	 * Imposta il valore della proprieta' tipoDm372008 associata alla
	 * colonna TIPO_DM37_2008.
	 * @generated
	 */
	public void setTipoDm372008(String val) {

		tipoDm372008 = val;

	}

	/**
	 * Legge il valore della proprieta' tipoDm372008 associata alla
	 * @generated
	 */
	public String getTipoDm372008() {

		return tipoDm372008;

	}

	/**
	 * Costruttore di una chiave primaria vuota
	 * @generated 
	 */
	public SigitDDmPk() {
		//empty constructor
	}

	/**
	 * Costruttore di una chiave primaria a partire dai valori delle varie colonne
	 * @generated
	 */
	public SigitDDmPk(

			final String tipoDm372008

	) {

		this.setTipoDm372008(tipoDm372008);

	}

	/**
	 * Method 'equals'. 
	 * Due istanze di SigitDDmPk sono equals se i valori di tutti i campi coincidono.
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

		if (!(_other instanceof SigitDDmPk)) {
			return false;
		}

		final SigitDDmPk _cast = (SigitDDmPk) _other;

		if (tipoDm372008 == null ? _cast.getTipoDm372008() != null : !tipoDm372008.equals(_cast.getTipoDm372008())) {
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

		if (tipoDm372008 != null) {
			_hashCode = 29 * _hashCode + tipoDm372008.hashCode();
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

		ret.append("it.csi.sigit.sigitweba.business.dao.sigitweba.dto.SigitDDmPk: ");
		ret.append("tipoDm372008=" + tipoDm372008);

		return ret.toString();
	}
}
