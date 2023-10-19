package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Primary Key del DTO SigitTDocAllegatoDto.
 * E' utilizzato per tutte le operazioni di lettura dati per chiave primaria. 
 * @generated
 */
public class SigitTDocAllegatoPk implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna ID_DOC_ALLEGATO
	 * @generated
	 */
	protected Integer idDocAllegato;

	/**
	 * Imposta il valore della proprieta' idDocAllegato associata alla
	 * colonna ID_DOC_ALLEGATO.
	 * @generated
	 */
	public void setIdDocAllegato(Integer val) {

		idDocAllegato = val;

	}

	/**
	 * Legge il valore della proprieta' idDocAllegato associata alla
	 * @generated
	 */
	public Integer getIdDocAllegato() {

		return idDocAllegato;

	}

	/**
	 * Costruttore di una chiave primaria vuota
	 * @generated 
	 */
	public SigitTDocAllegatoPk() {
		//empty constructor
	}

	/**
	 * Costruttore di una chiave primaria a partire dai valori delle varie colonne
	 * @generated
	 */
	public SigitTDocAllegatoPk(

			final Integer idDocAllegato

	) {

		this.setIdDocAllegato(idDocAllegato);

	}

	/**
	 * Method 'equals'. 
	 * Due istanze di SigitTDocAllegatoPk sono equals se i valori di tutti i campi coincidono.
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

		if (!(_other instanceof SigitTDocAllegatoPk)) {
			return false;
		}

		final SigitTDocAllegatoPk _cast = (SigitTDocAllegatoPk) _other;

		if (idDocAllegato == null
				? _cast.getIdDocAllegato() != null
				: !idDocAllegato.equals(_cast.getIdDocAllegato())) {
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

		if (idDocAllegato != null) {
			_hashCode = 29 * _hashCode + idDocAllegato.hashCode();
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

		ret.append("it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTDocAllegatoPk: ");
		ret.append("idDocAllegato=" + idDocAllegato);

		return ret.toString();
	}
}
