package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Primary Key del DTO SigitDTipoComponenteDto.
 * E' utilizzato per tutte le operazioni di lettura dati per chiave primaria. 
 * @generated
 */
public class SigitDTipoComponentePk implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna ID_TIPO_COMPONENTE
	 * @generated
	 */
	protected String idTipoComponente;

	/**
	 * Imposta il valore della proprieta' idTipoComponente associata alla
	 * colonna ID_TIPO_COMPONENTE.
	 * @generated
	 */
	public void setIdTipoComponente(String val) {

		idTipoComponente = val;

	}

	/**
	 * Legge il valore della proprieta' idTipoComponente associata alla
	 * @generated
	 */
	public String getIdTipoComponente() {

		return idTipoComponente;

	}

	/**
	 * Costruttore di una chiave primaria vuota
	 * @generated 
	 */
	public SigitDTipoComponentePk() {
		//empty constructor
	}

	/**
	 * Costruttore di una chiave primaria a partire dai valori delle varie colonne
	 * @generated
	 */
	public SigitDTipoComponentePk(

			final String idTipoComponente

	) {

		this.setIdTipoComponente(idTipoComponente);

	}

	/**
	 * Method 'equals'. 
	 * Due istanze di SigitDTipoComponentePk sono equals se i valori di tutti i campi coincidono.
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

		if (!(_other instanceof SigitDTipoComponentePk)) {
			return false;
		}

		final SigitDTipoComponentePk _cast = (SigitDTipoComponentePk) _other;

		if (idTipoComponente == null
				? _cast.getIdTipoComponente() != null
				: !idTipoComponente.equals(_cast.getIdTipoComponente())) {
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

		if (idTipoComponente != null) {
			_hashCode = 29 * _hashCode + idTipoComponente.hashCode();
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

		ret.append("it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitDTipoComponentePk: ");
		ret.append("idTipoComponente=" + idTipoComponente);

		return ret.toString();
	}
}
