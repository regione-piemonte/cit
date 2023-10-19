package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Primary Key del DTO SigitDFrequenzaManutDto.
 * E' utilizzato per tutte le operazioni di lettura dati per chiave primaria. 
 * @generated
 */
public class SigitDFrequenzaManutPk implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna ID_FREQUENZA
	 * @generated
	 */
	protected Integer idFrequenza;

	/**
	 * Imposta il valore della proprieta' idFrequenza associata alla
	 * colonna ID_FREQUENZA.
	 * @generated
	 */
	public void setIdFrequenza(Integer val) {

		idFrequenza = val;

	}

	/**
	 * Legge il valore della proprieta' idFrequenza associata alla
	 * @generated
	 */
	public Integer getIdFrequenza() {

		return idFrequenza;

	}

	/**
	 * Costruttore di una chiave primaria vuota
	 * @generated 
	 */
	public SigitDFrequenzaManutPk() {
		//empty constructor
	}

	/**
	 * Costruttore di una chiave primaria a partire dai valori delle varie colonne
	 * @generated
	 */
	public SigitDFrequenzaManutPk(

			final Integer idFrequenza

	) {

		this.setIdFrequenza(idFrequenza);

	}

	/**
	 * Method 'equals'. 
	 * Due istanze di SigitDFrequenzaManutPk sono equals se i valori di tutti i campi coincidono.
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

		if (!(_other instanceof SigitDFrequenzaManutPk)) {
			return false;
		}

		final SigitDFrequenzaManutPk _cast = (SigitDFrequenzaManutPk) _other;

		if (idFrequenza == null ? _cast.getIdFrequenza() != null : !idFrequenza.equals(_cast.getIdFrequenza())) {
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

		if (idFrequenza != null) {
			_hashCode = 29 * _hashCode + idFrequenza.hashCode();
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

		ret.append("it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitDFrequenzaManutPk: ");
		ret.append("idFrequenza=" + idFrequenza);

		return ret.toString();
	}
}
