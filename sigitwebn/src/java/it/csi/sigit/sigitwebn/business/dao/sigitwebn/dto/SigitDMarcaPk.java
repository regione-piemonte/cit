package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Primary Key del DTO SigitDMarcaDto.
 * E' utilizzato per tutte le operazioni di lettura dati per chiave primaria. 
 * @generated
 */
public class SigitDMarcaPk implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna ID_MARCA
	 * @generated
	 */
	protected java.math.BigDecimal idMarca;

	/**
	 * Imposta il valore della proprieta' idMarca associata alla
	 * colonna ID_MARCA.
	 * @generated
	 */
	public void setIdMarca(java.math.BigDecimal val) {

		idMarca = val;

	}

	/**
	 * Legge il valore della proprieta' idMarca associata alla
	 * @generated
	 */
	public java.math.BigDecimal getIdMarca() {

		return idMarca;

	}

	/**
	 * Costruttore di una chiave primaria vuota
	 * @generated 
	 */
	public SigitDMarcaPk() {
		//empty constructor
	}

	/**
	 * Costruttore di una chiave primaria a partire dai valori delle varie colonne
	 * @generated
	 */
	public SigitDMarcaPk(

			final java.math.BigDecimal idMarca

	) {

		this.setIdMarca(idMarca);

	}

	/**
	 * Method 'equals'. 
	 * Due istanze di SigitDMarcaPk sono equals se i valori di tutti i campi coincidono.
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

		if (!(_other instanceof SigitDMarcaPk)) {
			return false;
		}

		final SigitDMarcaPk _cast = (SigitDMarcaPk) _other;

		if (idMarca == null ? _cast.getIdMarca() != null : !idMarca.equals(_cast.getIdMarca())) {
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

		if (idMarca != null) {
			_hashCode = 29 * _hashCode + idMarca.hashCode();
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

		ret.append("it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitDMarcaPk: ");
		ret.append("idMarca=" + idMarca);

		return ret.toString();
	}
}
