package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Primary Key del DTO SigitDTipoAnomaliaDto.
 * E' utilizzato per tutte le operazioni di lettura dati per chiave primaria. 
 * @generated
 */
public class SigitDTipoAnomaliaPk implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna ID_TIPO_ANOMALIA
	 * @generated
	 */
	protected Integer idTipoAnomalia;

	/**
	 * Imposta il valore della proprieta' idTipoAnomalia associata alla
	 * colonna ID_TIPO_ANOMALIA.
	 * @generated
	 */
	public void setIdTipoAnomalia(Integer val) {

		idTipoAnomalia = val;

	}

	/**
	 * Legge il valore della proprieta' idTipoAnomalia associata alla
	 * @generated
	 */
	public Integer getIdTipoAnomalia() {

		return idTipoAnomalia;

	}

	/**
	 * Costruttore di una chiave primaria vuota
	 * @generated 
	 */
	public SigitDTipoAnomaliaPk() {
		//empty constructor
	}

	/**
	 * Costruttore di una chiave primaria a partire dai valori delle varie colonne
	 * @generated
	 */
	public SigitDTipoAnomaliaPk(

			final Integer idTipoAnomalia

	) {

		this.setIdTipoAnomalia(idTipoAnomalia);

	}

	/**
	 * Method 'equals'. 
	 * Due istanze di SigitDTipoAnomaliaPk sono equals se i valori di tutti i campi coincidono.
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

		if (!(_other instanceof SigitDTipoAnomaliaPk)) {
			return false;
		}

		final SigitDTipoAnomaliaPk _cast = (SigitDTipoAnomaliaPk) _other;

		if (idTipoAnomalia == null
				? _cast.getIdTipoAnomalia() != null
				: !idTipoAnomalia.equals(_cast.getIdTipoAnomalia())) {
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

		if (idTipoAnomalia != null) {
			_hashCode = 29 * _hashCode + idTipoAnomalia.hashCode();
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

		ret.append("it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitDTipoAnomaliaPk: ");
		ret.append("idTipoAnomalia=" + idTipoAnomalia);

		return ret.toString();
	}
}
