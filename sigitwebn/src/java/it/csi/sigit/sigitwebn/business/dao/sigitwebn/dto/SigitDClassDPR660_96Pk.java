package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Primary Key del DTO SigitDClassDPR660_96Dto.
 * E' utilizzato per tutte le operazioni di lettura dati per chiave primaria. 
 * @generated
 */
public class SigitDClassDPR660_96Pk implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna ID_CLASS
	 * @generated
	 */
	protected String idClass;

	/**
	 * Imposta il valore della proprieta' idClass associata alla
	 * colonna ID_CLASS.
	 * @generated
	 */
	public void setIdClass(String val) {

		idClass = val;

	}

	/**
	 * Legge il valore della proprieta' idClass associata alla
	 * @generated
	 */
	public String getIdClass() {

		return idClass;

	}

	/**
	 * Costruttore di una chiave primaria vuota
	 * @generated 
	 */
	public SigitDClassDPR660_96Pk() {
		//empty constructor
	}

	/**
	 * Costruttore di una chiave primaria a partire dai valori delle varie colonne
	 * @generated
	 */
	public SigitDClassDPR660_96Pk(

			final String idClass

	) {

		this.setIdClass(idClass);

	}

	/**
	 * Method 'equals'. 
	 * Due istanze di SigitDClassDPR660_96Pk sono equals se i valori di tutti i campi coincidono.
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

		if (!(_other instanceof SigitDClassDPR660_96Pk)) {
			return false;
		}

		final SigitDClassDPR660_96Pk _cast = (SigitDClassDPR660_96Pk) _other;

		if (idClass == null ? _cast.getIdClass() != null : !idClass.equals(_cast.getIdClass())) {
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

		if (idClass != null) {
			_hashCode = 29 * _hashCode + idClass.hashCode();
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

		ret.append("it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitDClassDPR660_96Pk: ");
		ret.append("idClass=" + idClass);

		return ret.toString();
	}
}
