package it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dto;

import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dao.*;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Primary Key del DTO SigitTRifCatastDto.
 * E' utilizzato per tutte le operazioni di lettura dati per chiave primaria. 
 * @generated
 */
public class SigitTRifCatastPk implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna ID_RIF_CATAST
	 * @generated
	 */
	protected Integer idRifCatast;

	/**
	 * Imposta il valore della proprieta' idRifCatast associata alla
	 * colonna ID_RIF_CATAST.
	 * @generated
	 */
	public void setIdRifCatast(Integer val) {

		idRifCatast = val;

	}

	/**
	 * Legge il valore della proprieta' idRifCatast associata alla
	 * @generated
	 */
	public Integer getIdRifCatast() {

		return idRifCatast;

	}

	/**
	 * Costruttore di una chiave primaria vuota
	 * @generated 
	 */
	public SigitTRifCatastPk() {
		//empty constructor
	}

	/**
	 * Costruttore di una chiave primaria a partire dai valori delle varie colonne
	 * @generated
	 */
	public SigitTRifCatastPk(

			final Integer idRifCatast

	) {

		this.setIdRifCatast(idRifCatast);

	}

	/**
	 * Method 'equals'. 
	 * Due istanze di SigitTRifCatastPk sono equals se i valori di tutti i campi coincidono.
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

		if (!(_other instanceof SigitTRifCatastPk)) {
			return false;
		}

		final SigitTRifCatastPk _cast = (SigitTRifCatastPk) _other;

		if (idRifCatast == null ? _cast.getIdRifCatast() != null : !idRifCatast.equals(_cast.getIdRifCatast())) {
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

		if (idRifCatast != null) {
			_hashCode = 29 * _hashCode + idRifCatast.hashCode();
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

		ret.append("it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dto.SigitTRifCatastPk: ");
		ret.append("idRifCatast=" + idRifCatast);

		return ret.toString();
	}
}
