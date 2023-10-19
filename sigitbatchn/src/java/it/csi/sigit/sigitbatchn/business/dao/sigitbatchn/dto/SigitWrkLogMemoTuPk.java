package it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dto;

import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dao.*;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Primary Key del DTO SigitWrkLogMemoTuDto.
 * E' utilizzato per tutte le operazioni di lettura dati per chiave primaria. 
 * @generated
 */
public class SigitWrkLogMemoTuPk implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna ID_LOG_MEMO_PTU
	 * @generated
	 */
	protected java.math.BigDecimal idLogMemoPtu;

	/**
	 * Imposta il valore della proprieta' idLogMemoPtu associata alla
	 * colonna ID_LOG_MEMO_PTU.
	 * @generated
	 */
	public void setIdLogMemoPtu(java.math.BigDecimal val) {

		idLogMemoPtu = val;

	}

	/**
	 * Legge il valore della proprieta' idLogMemoPtu associata alla
	 * @generated
	 */
	public java.math.BigDecimal getIdLogMemoPtu() {

		return idLogMemoPtu;

	}

	/**
	 * Costruttore di una chiave primaria vuota
	 * @generated 
	 */
	public SigitWrkLogMemoTuPk() {
		//empty constructor
	}

	/**
	 * Costruttore di una chiave primaria a partire dai valori delle varie colonne
	 * @generated
	 */
	public SigitWrkLogMemoTuPk(

			final java.math.BigDecimal idLogMemoPtu

	) {

		this.setIdLogMemoPtu(idLogMemoPtu);

	}

	/**
	 * Method 'equals'. 
	 * Due istanze di SigitWrkLogMemoTuPk sono equals se i valori di tutti i campi coincidono.
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

		if (!(_other instanceof SigitWrkLogMemoTuPk)) {
			return false;
		}

		final SigitWrkLogMemoTuPk _cast = (SigitWrkLogMemoTuPk) _other;

		if (idLogMemoPtu == null ? _cast.getIdLogMemoPtu() != null : !idLogMemoPtu.equals(_cast.getIdLogMemoPtu())) {
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

		if (idLogMemoPtu != null) {
			_hashCode = 29 * _hashCode + idLogMemoPtu.hashCode();
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

		ret.append("it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dto.SigitWrkLogMemoTuPk: ");
		ret.append("idLogMemoPtu=" + idLogMemoPtu);

		return ret.toString();
	}
}
