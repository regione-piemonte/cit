package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Primary Key del DTO SigitTDocAggiuntivaDto.
 * E' utilizzato per tutte le operazioni di lettura dati per chiave primaria. 
 * @generated
 */
public class SigitTDocAggiuntivaPk implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna ID_DOC_AGGIUNTIVA
	 * @generated
	 */
	protected Integer idDocAggiuntiva;

	/**
	 * Imposta il valore della proprieta' idDocAggiuntiva associata alla
	 * colonna ID_DOC_AGGIUNTIVA.
	 * @generated
	 */
	public void setIdDocAggiuntiva(Integer val) {

		idDocAggiuntiva = val;

	}

	/**
	 * Legge il valore della proprieta' idDocAggiuntiva associata alla
	 * @generated
	 */
	public Integer getIdDocAggiuntiva() {

		return idDocAggiuntiva;

	}

	/**
	 * Costruttore di una chiave primaria vuota
	 * @generated 
	 */
	public SigitTDocAggiuntivaPk() {
		//empty constructor
	}

	/**
	 * Costruttore di una chiave primaria a partire dai valori delle varie colonne
	 * @generated
	 */
	public SigitTDocAggiuntivaPk(

			final Integer idDocAggiuntiva

	) {

		this.setIdDocAggiuntiva(idDocAggiuntiva);

	}

	/**
	 * Method 'equals'. 
	 * Due istanze di SigitTDocAggiuntivaPk sono equals se i valori di tutti i campi coincidono.
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

		if (!(_other instanceof SigitTDocAggiuntivaPk)) {
			return false;
		}

		final SigitTDocAggiuntivaPk _cast = (SigitTDocAggiuntivaPk) _other;

		if (idDocAggiuntiva == null
				? _cast.getIdDocAggiuntiva() != null
				: !idDocAggiuntiva.equals(_cast.getIdDocAggiuntiva())) {
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

		if (idDocAggiuntiva != null) {
			_hashCode = 29 * _hashCode + idDocAggiuntiva.hashCode();
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

		ret.append("it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTDocAggiuntivaPk: ");
		ret.append("idDocAggiuntiva=" + idDocAggiuntiva);

		return ret.toString();
	}
}
