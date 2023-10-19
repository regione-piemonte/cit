package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Primary Key del DTO SigitDStatoSanzioneDto.
 * E' utilizzato per tutte le operazioni di lettura dati per chiave primaria. 
 * @generated
 */
public class SigitDStatoSanzionePk implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna ID_STATO_SANZIONE
	 * @generated
	 */
	protected Integer idStatoSanzione;

	/**
	 * Imposta il valore della proprieta' idStatoSanzione associata alla
	 * colonna ID_STATO_SANZIONE.
	 * @generated
	 */
	public void setIdStatoSanzione(Integer val) {

		idStatoSanzione = val;

	}

	/**
	 * Legge il valore della proprieta' idStatoSanzione associata alla
	 * @generated
	 */
	public Integer getIdStatoSanzione() {

		return idStatoSanzione;

	}

	/**
	 * Costruttore di una chiave primaria vuota
	 * @generated 
	 */
	public SigitDStatoSanzionePk() {
		//empty constructor
	}

	/**
	 * Costruttore di una chiave primaria a partire dai valori delle varie colonne
	 * @generated
	 */
	public SigitDStatoSanzionePk(

			final Integer idStatoSanzione

	) {

		this.setIdStatoSanzione(idStatoSanzione);

	}

	/**
	 * Method 'equals'. 
	 * Due istanze di SigitDStatoSanzionePk sono equals se i valori di tutti i campi coincidono.
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

		if (!(_other instanceof SigitDStatoSanzionePk)) {
			return false;
		}

		final SigitDStatoSanzionePk _cast = (SigitDStatoSanzionePk) _other;

		if (idStatoSanzione == null
				? _cast.getIdStatoSanzione() != null
				: !idStatoSanzione.equals(_cast.getIdStatoSanzione())) {
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

		if (idStatoSanzione != null) {
			_hashCode = 29 * _hashCode + idStatoSanzione.hashCode();
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

		ret.append("it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitDStatoSanzionePk: ");
		ret.append("idStatoSanzione=" + idStatoSanzione);

		return ret.toString();
	}
}
