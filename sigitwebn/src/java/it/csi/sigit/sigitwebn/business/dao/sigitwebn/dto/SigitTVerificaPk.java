package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Primary Key del DTO SigitTVerificaDto.
 * E' utilizzato per tutte le operazioni di lettura dati per chiave primaria. 
 * @generated
 */
public class SigitTVerificaPk implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna ID_VERIFICA
	 * @generated
	 */
	protected Integer idVerifica;

	/**
	 * Imposta il valore della proprieta' idVerifica associata alla
	 * colonna ID_VERIFICA.
	 * @generated
	 */
	public void setIdVerifica(Integer val) {

		idVerifica = val;

	}

	/**
	 * Legge il valore della proprieta' idVerifica associata alla
	 * @generated
	 */
	public Integer getIdVerifica() {

		return idVerifica;

	}

	/**
	 * Costruttore di una chiave primaria vuota
	 * @generated 
	 */
	public SigitTVerificaPk() {
		//empty constructor
	}

	/**
	 * Costruttore di una chiave primaria a partire dai valori delle varie colonne
	 * @generated
	 */
	public SigitTVerificaPk(

			final Integer idVerifica

	) {

		this.setIdVerifica(idVerifica);

	}

	/**
	 * Method 'equals'. 
	 * Due istanze di SigitTVerificaPk sono equals se i valori di tutti i campi coincidono.
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

		if (!(_other instanceof SigitTVerificaPk)) {
			return false;
		}

		final SigitTVerificaPk _cast = (SigitTVerificaPk) _other;

		if (idVerifica == null ? _cast.getIdVerifica() != null : !idVerifica.equals(_cast.getIdVerifica())) {
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

		if (idVerifica != null) {
			_hashCode = 29 * _hashCode + idVerifica.hashCode();
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

		ret.append("it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTVerificaPk: ");
		ret.append("idVerifica=" + idVerifica);

		return ret.toString();
	}
}
