package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Primary Key del DTO SigitDTipoCannaFumariaDto.
 * E' utilizzato per tutte le operazioni di lettura dati per chiave primaria. 
 * @generated
 */
public class SigitDTipoCannaFumariaPk implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna ID_TIPO_CANNA_FUMARIA
	 * @generated
	 */
	protected java.math.BigDecimal idTipoCannaFumaria;

	/**
	 * Imposta il valore della proprieta' idTipoCannaFumaria associata alla
	 * colonna ID_TIPO_CANNA_FUMARIA.
	 * @generated
	 */
	public void setIdTipoCannaFumaria(java.math.BigDecimal val) {

		idTipoCannaFumaria = val;

	}

	/**
	 * Legge il valore della proprieta' idTipoCannaFumaria associata alla
	 * @generated
	 */
	public java.math.BigDecimal getIdTipoCannaFumaria() {

		return idTipoCannaFumaria;

	}

	/**
	 * Costruttore di una chiave primaria vuota
	 * @generated 
	 */
	public SigitDTipoCannaFumariaPk() {
		//empty constructor
	}

	/**
	 * Costruttore di una chiave primaria a partire dai valori delle varie colonne
	 * @generated
	 */
	public SigitDTipoCannaFumariaPk(

			final java.math.BigDecimal idTipoCannaFumaria

	) {

		this.setIdTipoCannaFumaria(idTipoCannaFumaria);

	}

	/**
	 * Method 'equals'. 
	 * Due istanze di SigitDTipoCannaFumariaPk sono equals se i valori di tutti i campi coincidono.
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

		if (!(_other instanceof SigitDTipoCannaFumariaPk)) {
			return false;
		}

		final SigitDTipoCannaFumariaPk _cast = (SigitDTipoCannaFumariaPk) _other;

		if (idTipoCannaFumaria == null
				? _cast.getIdTipoCannaFumaria() != null
				: !idTipoCannaFumaria.equals(_cast.getIdTipoCannaFumaria())) {
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

		if (idTipoCannaFumaria != null) {
			_hashCode = 29 * _hashCode + idTipoCannaFumaria.hashCode();
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

		ret.append("it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitDTipoCannaFumariaPk: ");
		ret.append("idTipoCannaFumaria=" + idTipoCannaFumaria);

		return ret.toString();
	}
}
