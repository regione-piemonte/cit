package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Primary Key del DTO SigitDControlloAriaDto.
 * E' utilizzato per tutte le operazioni di lettura dati per chiave primaria. 
 * @generated
 */
public class SigitDControlloAriaPk implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna ID_CONTROLLO_ARIA
	 * @generated
	 */
	protected java.math.BigDecimal idControlloAria;

	/**
	 * Imposta il valore della proprieta' idControlloAria associata alla
	 * colonna ID_CONTROLLO_ARIA.
	 * @generated
	 */
	public void setIdControlloAria(java.math.BigDecimal val) {

		idControlloAria = val;

	}

	/**
	 * Legge il valore della proprieta' idControlloAria associata alla
	 * @generated
	 */
	public java.math.BigDecimal getIdControlloAria() {

		return idControlloAria;

	}

	/**
	 * Costruttore di una chiave primaria vuota
	 * @generated 
	 */
	public SigitDControlloAriaPk() {
		//empty constructor
	}

	/**
	 * Costruttore di una chiave primaria a partire dai valori delle varie colonne
	 * @generated
	 */
	public SigitDControlloAriaPk(

			final java.math.BigDecimal idControlloAria

	) {

		this.setIdControlloAria(idControlloAria);

	}

	/**
	 * Method 'equals'. 
	 * Due istanze di SigitDControlloAriaPk sono equals se i valori di tutti i campi coincidono.
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

		if (!(_other instanceof SigitDControlloAriaPk)) {
			return false;
		}

		final SigitDControlloAriaPk _cast = (SigitDControlloAriaPk) _other;

		if (idControlloAria == null
				? _cast.getIdControlloAria() != null
				: !idControlloAria.equals(_cast.getIdControlloAria())) {
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

		if (idControlloAria != null) {
			_hashCode = 29 * _hashCode + idControlloAria.hashCode();
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

		ret.append("it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitDControlloAriaPk: ");
		ret.append("idControlloAria=" + idControlloAria);

		return ret.toString();
	}
}
