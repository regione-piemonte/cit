package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Primary Key del DTO SigitDRuoloPaDto.
 * E' utilizzato per tutte le operazioni di lettura dati per chiave primaria. 
 * @generated
 */
public class SigitDRuoloPaPk implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna ID_RUOLO_PA
	 * @generated
	 */
	protected Integer idRuoloPa;

	/**
	 * Imposta il valore della proprieta' idRuoloPa associata alla
	 * colonna ID_RUOLO_PA.
	 * @generated
	 */
	public void setIdRuoloPa(Integer val) {

		idRuoloPa = val;

	}

	/**
	 * Legge il valore della proprieta' idRuoloPa associata alla
	 * @generated
	 */
	public Integer getIdRuoloPa() {

		return idRuoloPa;

	}

	/**
	 * Costruttore di una chiave primaria vuota
	 * @generated 
	 */
	public SigitDRuoloPaPk() {
		//empty constructor
	}

	/**
	 * Costruttore di una chiave primaria a partire dai valori delle varie colonne
	 * @generated
	 */
	public SigitDRuoloPaPk(

			final Integer idRuoloPa

	) {

		this.setIdRuoloPa(idRuoloPa);

	}

	/**
	 * Method 'equals'. 
	 * Due istanze di SigitDRuoloPaPk sono equals se i valori di tutti i campi coincidono.
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

		if (!(_other instanceof SigitDRuoloPaPk)) {
			return false;
		}

		final SigitDRuoloPaPk _cast = (SigitDRuoloPaPk) _other;

		if (idRuoloPa == null ? _cast.getIdRuoloPa() != null : !idRuoloPa.equals(_cast.getIdRuoloPa())) {
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

		if (idRuoloPa != null) {
			_hashCode = 29 * _hashCode + idRuoloPa.hashCode();
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

		ret.append("it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitDRuoloPaPk: ");
		ret.append("idRuoloPa=" + idRuoloPa);

		return ret.toString();
	}
}
