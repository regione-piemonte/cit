package it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dto;

import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dao.*;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Primary Key del DTO SigitTIspezione2018Dto.
 * E' utilizzato per tutte le operazioni di lettura dati per chiave primaria. 
 * @generated
 */
public class SigitTIspezione2018Pk implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna ID_ISPEZIONE_2018
	 * @generated
	 */
	protected Integer idIspezione2018;

	/**
	 * Imposta il valore della proprieta' idIspezione2018 associata alla
	 * colonna ID_ISPEZIONE_2018.
	 * @generated
	 */
	public void setIdIspezione2018(Integer val) {

		idIspezione2018 = val;

	}

	/**
	 * Legge il valore della proprieta' idIspezione2018 associata alla
	 * @generated
	 */
	public Integer getIdIspezione2018() {

		return idIspezione2018;

	}

	/**
	 * Costruttore di una chiave primaria vuota
	 * @generated 
	 */
	public SigitTIspezione2018Pk() {
		//empty constructor
	}

	/**
	 * Costruttore di una chiave primaria a partire dai valori delle varie colonne
	 * @generated
	 */
	public SigitTIspezione2018Pk(

			final Integer idIspezione2018

	) {

		this.setIdIspezione2018(idIspezione2018);

	}

	/**
	 * Method 'equals'. 
	 * Due istanze di SigitTIspezione2018Pk sono equals se i valori di tutti i campi coincidono.
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

		if (!(_other instanceof SigitTIspezione2018Pk)) {
			return false;
		}

		final SigitTIspezione2018Pk _cast = (SigitTIspezione2018Pk) _other;

		if (idIspezione2018 == null
				? _cast.getIdIspezione2018() != null
				: !idIspezione2018.equals(_cast.getIdIspezione2018())) {
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

		if (idIspezione2018 != null) {
			_hashCode = 29 * _hashCode + idIspezione2018.hashCode();
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

		ret.append("it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dto.SigitTIspezione2018Pk: ");
		ret.append("idIspezione2018=" + idIspezione2018);

		return ret.toString();
	}
}
