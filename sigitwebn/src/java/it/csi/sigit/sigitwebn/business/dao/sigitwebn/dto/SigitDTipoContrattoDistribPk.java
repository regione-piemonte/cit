package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Primary Key del DTO SigitDTipoContrattoDistribDto.
 * E' utilizzato per tutte le operazioni di lettura dati per chiave primaria. 
 * @generated
 */
public class SigitDTipoContrattoDistribPk implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna ID_TIPO_CONTRATTO_DISTRIB
	 * @generated
	 */
	protected Integer idTipoContrattoDistrib;

	/**
	 * Imposta il valore della proprieta' idTipoContrattoDistrib associata alla
	 * colonna ID_TIPO_CONTRATTO_DISTRIB.
	 * @generated
	 */
	public void setIdTipoContrattoDistrib(Integer val) {

		idTipoContrattoDistrib = val;

	}

	/**
	 * Legge il valore della proprieta' idTipoContrattoDistrib associata alla
	 * @generated
	 */
	public Integer getIdTipoContrattoDistrib() {

		return idTipoContrattoDistrib;

	}

	/**
	 * Costruttore di una chiave primaria vuota
	 * @generated 
	 */
	public SigitDTipoContrattoDistribPk() {
		//empty constructor
	}

	/**
	 * Costruttore di una chiave primaria a partire dai valori delle varie colonne
	 * @generated
	 */
	public SigitDTipoContrattoDistribPk(

			final Integer idTipoContrattoDistrib

	) {

		this.setIdTipoContrattoDistrib(idTipoContrattoDistrib);

	}

	/**
	 * Method 'equals'. 
	 * Due istanze di SigitDTipoContrattoDistribPk sono equals se i valori di tutti i campi coincidono.
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

		if (!(_other instanceof SigitDTipoContrattoDistribPk)) {
			return false;
		}

		final SigitDTipoContrattoDistribPk _cast = (SigitDTipoContrattoDistribPk) _other;

		if (idTipoContrattoDistrib == null
				? _cast.getIdTipoContrattoDistrib() != null
				: !idTipoContrattoDistrib.equals(_cast.getIdTipoContrattoDistrib())) {
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

		if (idTipoContrattoDistrib != null) {
			_hashCode = 29 * _hashCode + idTipoContrattoDistrib.hashCode();
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

		ret.append("it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitDTipoContrattoDistribPk: ");
		ret.append("idTipoContrattoDistrib=" + idTipoContrattoDistrib);

		return ret.toString();
	}
}
