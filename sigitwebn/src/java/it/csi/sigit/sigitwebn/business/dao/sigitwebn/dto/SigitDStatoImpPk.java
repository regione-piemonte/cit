package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Primary Key del DTO SigitDStatoImpDto.
 * E' utilizzato per tutte le operazioni di lettura dati per chiave primaria. 
 * @generated
 */
public class SigitDStatoImpPk implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna ID_STATO
	 * @generated
	 */
	protected java.math.BigDecimal idStato;

	/**
	 * Imposta il valore della proprieta' idStato associata alla
	 * colonna ID_STATO.
	 * @generated
	 */
	public void setIdStato(java.math.BigDecimal val) {

		idStato = val;

	}

	/**
	 * Legge il valore della proprieta' idStato associata alla
	 * @generated
	 */
	public java.math.BigDecimal getIdStato() {

		return idStato;

	}

	/**
	 * Costruttore di una chiave primaria vuota
	 * @generated 
	 */
	public SigitDStatoImpPk() {
		//empty constructor
	}

	/**
	 * Costruttore di una chiave primaria a partire dai valori delle varie colonne
	 * @generated
	 */
	public SigitDStatoImpPk(

			final java.math.BigDecimal idStato

	) {

		this.setIdStato(idStato);

	}

	/**
	 * Method 'equals'. 
	 * Due istanze di SigitDStatoImpPk sono equals se i valori di tutti i campi coincidono.
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

		if (!(_other instanceof SigitDStatoImpPk)) {
			return false;
		}

		final SigitDStatoImpPk _cast = (SigitDStatoImpPk) _other;

		if (idStato == null ? _cast.getIdStato() != null : !idStato.equals(_cast.getIdStato())) {
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

		if (idStato != null) {
			_hashCode = 29 * _hashCode + idStato.hashCode();
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

		ret.append("it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitDStatoImpPk: ");
		ret.append("idStato=" + idStato);

		return ret.toString();
	}
}
