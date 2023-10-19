package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Primary Key del DTO SigitDRuoloAccredDto.
 * E' utilizzato per tutte le operazioni di lettura dati per chiave primaria. 
 * @generated
 */
public class SigitDRuoloAccredPk implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna ID_RUOLO_ACCRED
	 * @generated
	 */
	protected java.math.BigDecimal idRuoloAccred;

	/**
	 * Imposta il valore della proprieta' idRuoloAccred associata alla
	 * colonna ID_RUOLO_ACCRED.
	 * @generated
	 */
	public void setIdRuoloAccred(java.math.BigDecimal val) {

		idRuoloAccred = val;

	}

	/**
	 * Legge il valore della proprieta' idRuoloAccred associata alla
	 * @generated
	 */
	public java.math.BigDecimal getIdRuoloAccred() {

		return idRuoloAccred;

	}

	/**
	 * Costruttore di una chiave primaria vuota
	 * @generated 
	 */
	public SigitDRuoloAccredPk() {
		//empty constructor
	}

	/**
	 * Costruttore di una chiave primaria a partire dai valori delle varie colonne
	 * @generated
	 */
	public SigitDRuoloAccredPk(

			final java.math.BigDecimal idRuoloAccred

	) {

		this.setIdRuoloAccred(idRuoloAccred);

	}

	/**
	 * Method 'equals'. 
	 * Due istanze di SigitDRuoloAccredPk sono equals se i valori di tutti i campi coincidono.
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

		if (!(_other instanceof SigitDRuoloAccredPk)) {
			return false;
		}

		final SigitDRuoloAccredPk _cast = (SigitDRuoloAccredPk) _other;

		if (idRuoloAccred == null
				? _cast.getIdRuoloAccred() != null
				: !idRuoloAccred.equals(_cast.getIdRuoloAccred())) {
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

		if (idRuoloAccred != null) {
			_hashCode = 29 * _hashCode + idRuoloAccred.hashCode();
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

		ret.append("it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitDRuoloAccredPk: ");
		ret.append("idRuoloAccred=" + idRuoloAccred);

		return ret.toString();
	}
}
