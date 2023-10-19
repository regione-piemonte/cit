package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Primary Key del DTO SigitDRuoloDto.
 * E' utilizzato per tutte le operazioni di lettura dati per chiave primaria. 
 * @generated
 */
public class SigitDRuoloPk implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna ID_RUOLO
	 * @generated
	 */
	protected java.math.BigDecimal idRuolo;

	/**
	 * Imposta il valore della proprieta' idRuolo associata alla
	 * colonna ID_RUOLO.
	 * @generated
	 */
	public void setIdRuolo(java.math.BigDecimal val) {

		idRuolo = val;

	}

	/**
	 * Legge il valore della proprieta' idRuolo associata alla
	 * @generated
	 */
	public java.math.BigDecimal getIdRuolo() {

		return idRuolo;

	}

	/**
	 * Costruttore di una chiave primaria vuota
	 * @generated 
	 */
	public SigitDRuoloPk() {
		//empty constructor
	}

	/**
	 * Costruttore di una chiave primaria a partire dai valori delle varie colonne
	 * @generated
	 */
	public SigitDRuoloPk(

			final java.math.BigDecimal idRuolo

	) {

		this.setIdRuolo(idRuolo);

	}

	/**
	 * Method 'equals'. 
	 * Due istanze di SigitDRuoloPk sono equals se i valori di tutti i campi coincidono.
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

		if (!(_other instanceof SigitDRuoloPk)) {
			return false;
		}

		final SigitDRuoloPk _cast = (SigitDRuoloPk) _other;

		if (idRuolo == null ? _cast.getIdRuolo() != null : !idRuolo.equals(_cast.getIdRuolo())) {
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

		if (idRuolo != null) {
			_hashCode = 29 * _hashCode + idRuolo.hashCode();
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

		ret.append("it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitDRuoloPk: ");
		ret.append("idRuolo=" + idRuolo);

		return ret.toString();
	}
}
