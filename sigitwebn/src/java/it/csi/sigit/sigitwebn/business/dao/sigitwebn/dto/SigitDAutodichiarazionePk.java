package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Primary Key del DTO SigitDAutodichiarazioneDto.
 * E' utilizzato per tutte le operazioni di lettura dati per chiave primaria. 
 * @generated
 */
public class SigitDAutodichiarazionePk implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna ID_AUTODICHIARAZIONE
	 * @generated
	 */
	protected Integer idAutodichiarazione;

	/**
	 * Imposta il valore della proprieta' idAutodichiarazione associata alla
	 * colonna ID_AUTODICHIARAZIONE.
	 * @generated
	 */
	public void setIdAutodichiarazione(Integer val) {

		idAutodichiarazione = val;

	}

	/**
	 * Legge il valore della proprieta' idAutodichiarazione associata alla
	 * @generated
	 */
	public Integer getIdAutodichiarazione() {

		return idAutodichiarazione;

	}

	/**
	 * Costruttore di una chiave primaria vuota
	 * @generated 
	 */
	public SigitDAutodichiarazionePk() {
		//empty constructor
	}

	/**
	 * Costruttore di una chiave primaria a partire dai valori delle varie colonne
	 * @generated
	 */
	public SigitDAutodichiarazionePk(

			final Integer idAutodichiarazione

	) {

		this.setIdAutodichiarazione(idAutodichiarazione);

	}

	/**
	 * Method 'equals'. 
	 * Due istanze di SigitDAutodichiarazionePk sono equals se i valori di tutti i campi coincidono.
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

		if (!(_other instanceof SigitDAutodichiarazionePk)) {
			return false;
		}

		final SigitDAutodichiarazionePk _cast = (SigitDAutodichiarazionePk) _other;

		if (idAutodichiarazione == null
				? _cast.getIdAutodichiarazione() != null
				: !idAutodichiarazione.equals(_cast.getIdAutodichiarazione())) {
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

		if (idAutodichiarazione != null) {
			_hashCode = 29 * _hashCode + idAutodichiarazione.hashCode();
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

		ret.append("it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitDAutodichiarazionePk: ");
		ret.append("idAutodichiarazione=" + idAutodichiarazione);

		return ret.toString();
	}
}
