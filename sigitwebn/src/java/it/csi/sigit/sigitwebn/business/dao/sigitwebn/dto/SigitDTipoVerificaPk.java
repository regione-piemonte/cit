package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Primary Key del DTO SigitDTipoVerificaDto.
 * E' utilizzato per tutte le operazioni di lettura dati per chiave primaria. 
 * @generated
 */
public class SigitDTipoVerificaPk implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna ID_TIPO_VERIFICA
	 * @generated
	 */
	protected Integer idTipoVerifica;

	/**
	 * Imposta il valore della proprieta' idTipoVerifica associata alla
	 * colonna ID_TIPO_VERIFICA.
	 * @generated
	 */
	public void setIdTipoVerifica(Integer val) {

		idTipoVerifica = val;

	}

	/**
	 * Legge il valore della proprieta' idTipoVerifica associata alla
	 * @generated
	 */
	public Integer getIdTipoVerifica() {

		return idTipoVerifica;

	}

	/**
	 * Costruttore di una chiave primaria vuota
	 * @generated 
	 */
	public SigitDTipoVerificaPk() {
		//empty constructor
	}

	/**
	 * Costruttore di una chiave primaria a partire dai valori delle varie colonne
	 * @generated
	 */
	public SigitDTipoVerificaPk(

			final Integer idTipoVerifica

	) {

		this.setIdTipoVerifica(idTipoVerifica);

	}

	/**
	 * Method 'equals'. 
	 * Due istanze di SigitDTipoVerificaPk sono equals se i valori di tutti i campi coincidono.
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

		if (!(_other instanceof SigitDTipoVerificaPk)) {
			return false;
		}

		final SigitDTipoVerificaPk _cast = (SigitDTipoVerificaPk) _other;

		if (idTipoVerifica == null
				? _cast.getIdTipoVerifica() != null
				: !idTipoVerifica.equals(_cast.getIdTipoVerifica())) {
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

		if (idTipoVerifica != null) {
			_hashCode = 29 * _hashCode + idTipoVerifica.hashCode();
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

		ret.append("it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitDTipoVerificaPk: ");
		ret.append("idTipoVerifica=" + idTipoVerifica);

		return ret.toString();
	}
}
