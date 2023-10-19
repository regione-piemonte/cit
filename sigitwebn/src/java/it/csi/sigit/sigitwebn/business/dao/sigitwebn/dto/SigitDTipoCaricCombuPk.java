package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Primary Key del DTO SigitDTipoCaricCombuDto.
 * E' utilizzato per tutte le operazioni di lettura dati per chiave primaria. 
 * @generated
 */
public class SigitDTipoCaricCombuPk implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna ID_TIPO_CARIC_COMBU
	 * @generated
	 */
	protected java.math.BigDecimal idTipoCaricCombu;

	/**
	 * Imposta il valore della proprieta' idTipoCaricCombu associata alla
	 * colonna ID_TIPO_CARIC_COMBU.
	 * @generated
	 */
	public void setIdTipoCaricCombu(java.math.BigDecimal val) {

		idTipoCaricCombu = val;

	}

	/**
	 * Legge il valore della proprieta' idTipoCaricCombu associata alla
	 * @generated
	 */
	public java.math.BigDecimal getIdTipoCaricCombu() {

		return idTipoCaricCombu;

	}

	/**
	 * Costruttore di una chiave primaria vuota
	 * @generated 
	 */
	public SigitDTipoCaricCombuPk() {
		//empty constructor
	}

	/**
	 * Costruttore di una chiave primaria a partire dai valori delle varie colonne
	 * @generated
	 */
	public SigitDTipoCaricCombuPk(

			final java.math.BigDecimal idTipoCaricCombu

	) {

		this.setIdTipoCaricCombu(idTipoCaricCombu);

	}

	/**
	 * Method 'equals'. 
	 * Due istanze di SigitDTipoCaricCombuPk sono equals se i valori di tutti i campi coincidono.
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

		if (!(_other instanceof SigitDTipoCaricCombuPk)) {
			return false;
		}

		final SigitDTipoCaricCombuPk _cast = (SigitDTipoCaricCombuPk) _other;

		if (idTipoCaricCombu == null
				? _cast.getIdTipoCaricCombu() != null
				: !idTipoCaricCombu.equals(_cast.getIdTipoCaricCombu())) {
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

		if (idTipoCaricCombu != null) {
			_hashCode = 29 * _hashCode + idTipoCaricCombu.hashCode();
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

		ret.append("it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitDTipoCaricCombuPk: ");
		ret.append("idTipoCaricCombu=" + idTipoCaricCombu);

		return ret.toString();
	}
}
