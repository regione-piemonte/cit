package it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dto;

import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dao.*;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Primary Key del DTO SigitDCombustibileDto.
 * E' utilizzato per tutte le operazioni di lettura dati per chiave primaria. 
 * @generated
 */
public class SigitDCombustibilePk implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna ID_COMBUSTIBILE
	 * @generated
	 */
	protected java.math.BigDecimal idCombustibile;

	/**
	 * Imposta il valore della proprieta' idCombustibile associata alla
	 * colonna ID_COMBUSTIBILE.
	 * @generated
	 */
	public void setIdCombustibile(java.math.BigDecimal val) {

		idCombustibile = val;

	}

	/**
	 * Legge il valore della proprieta' idCombustibile associata alla
	 * @generated
	 */
	public java.math.BigDecimal getIdCombustibile() {

		return idCombustibile;

	}

	/**
	 * Costruttore di una chiave primaria vuota
	 * @generated 
	 */
	public SigitDCombustibilePk() {
		//empty constructor
	}

	/**
	 * Costruttore di una chiave primaria a partire dai valori delle varie colonne
	 * @generated
	 */
	public SigitDCombustibilePk(

			final java.math.BigDecimal idCombustibile

	) {

		this.setIdCombustibile(idCombustibile);

	}

	/**
	 * Method 'equals'. 
	 * Due istanze di SigitDCombustibilePk sono equals se i valori di tutti i campi coincidono.
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

		if (!(_other instanceof SigitDCombustibilePk)) {
			return false;
		}

		final SigitDCombustibilePk _cast = (SigitDCombustibilePk) _other;

		if (idCombustibile == null
				? _cast.getIdCombustibile() != null
				: !idCombustibile.equals(_cast.getIdCombustibile())) {
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

		if (idCombustibile != null) {
			_hashCode = 29 * _hashCode + idCombustibile.hashCode();
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

		ret.append("it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dto.SigitDCombustibilePk: ");
		ret.append("idCombustibile=" + idCombustibile);

		return ret.toString();
	}
}
