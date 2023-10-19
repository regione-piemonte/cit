package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Primary Key del DTO SigitDTipoDocAggDto.
 * E' utilizzato per tutte le operazioni di lettura dati per chiave primaria. 
 * @generated
 */
public class SigitDTipoDocAggPk implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna ID_TIPO_DOC_AGG
	 * @generated
	 */
	protected java.math.BigDecimal idTipoDocAgg;

	/**
	 * Imposta il valore della proprieta' idTipoDocAgg associata alla
	 * colonna ID_TIPO_DOC_AGG.
	 * @generated
	 */
	public void setIdTipoDocAgg(java.math.BigDecimal val) {

		idTipoDocAgg = val;

	}

	/**
	 * Legge il valore della proprieta' idTipoDocAgg associata alla
	 * @generated
	 */
	public java.math.BigDecimal getIdTipoDocAgg() {

		return idTipoDocAgg;

	}

	/**
	 * Costruttore di una chiave primaria vuota
	 * @generated 
	 */
	public SigitDTipoDocAggPk() {
		//empty constructor
	}

	/**
	 * Costruttore di una chiave primaria a partire dai valori delle varie colonne
	 * @generated
	 */
	public SigitDTipoDocAggPk(

			final java.math.BigDecimal idTipoDocAgg

	) {

		this.setIdTipoDocAgg(idTipoDocAgg);

	}

	/**
	 * Method 'equals'. 
	 * Due istanze di SigitDTipoDocAggPk sono equals se i valori di tutti i campi coincidono.
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

		if (!(_other instanceof SigitDTipoDocAggPk)) {
			return false;
		}

		final SigitDTipoDocAggPk _cast = (SigitDTipoDocAggPk) _other;

		if (idTipoDocAgg == null ? _cast.getIdTipoDocAgg() != null : !idTipoDocAgg.equals(_cast.getIdTipoDocAgg())) {
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

		if (idTipoDocAgg != null) {
			_hashCode = 29 * _hashCode + idTipoDocAgg.hashCode();
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

		ret.append("it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitDTipoDocAggPk: ");
		ret.append("idTipoDocAgg=" + idTipoDocAgg);

		return ret.toString();
	}
}
