package it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dto;

import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dao.*;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Primary Key del DTO SigitWrkLogMemoDto.
 * E' utilizzato per tutte le operazioni di lettura dati per chiave primaria. 
 * @generated
 */
public class SigitWrkLogMemoPk implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna ID_LOG_MEMO
	 * @generated
	 */
	protected java.math.BigDecimal idLogMemo;

	/**
	 * Imposta il valore della proprieta' idLogMemo associata alla
	 * colonna ID_LOG_MEMO.
	 * @generated
	 */
	public void setIdLogMemo(java.math.BigDecimal val) {

		idLogMemo = val;

	}

	/**
	 * Legge il valore della proprieta' idLogMemo associata alla
	 * @generated
	 */
	public java.math.BigDecimal getIdLogMemo() {

		return idLogMemo;

	}

	/**
	 * Costruttore di una chiave primaria vuota
	 * @generated 
	 */
	public SigitWrkLogMemoPk() {
		//empty constructor
	}

	/**
	 * Costruttore di una chiave primaria a partire dai valori delle varie colonne
	 * @generated
	 */
	public SigitWrkLogMemoPk(

			final java.math.BigDecimal idLogMemo

	) {

		this.setIdLogMemo(idLogMemo);

	}

	/**
	 * Method 'equals'. 
	 * Due istanze di SigitWrkLogMemoPk sono equals se i valori di tutti i campi coincidono.
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

		if (!(_other instanceof SigitWrkLogMemoPk)) {
			return false;
		}

		final SigitWrkLogMemoPk _cast = (SigitWrkLogMemoPk) _other;

		if (idLogMemo == null ? _cast.getIdLogMemo() != null : !idLogMemo.equals(_cast.getIdLogMemo())) {
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

		if (idLogMemo != null) {
			_hashCode = 29 * _hashCode + idLogMemo.hashCode();
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

		ret.append("it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dto.SigitWrkLogMemoPk: ");
		ret.append("idLogMemo=" + idLogMemo);

		return ret.toString();
	}
}
