package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Primary Key del DTO SigitTSanzioneDto.
 * E' utilizzato per tutte le operazioni di lettura dati per chiave primaria. 
 * @generated
 */
public class SigitTSanzionePk implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna ID_SANZIONE
	 * @generated
	 */
	protected Integer idSanzione;

	/**
	 * Imposta il valore della proprieta' idSanzione associata alla
	 * colonna ID_SANZIONE.
	 * @generated
	 */
	public void setIdSanzione(Integer val) {

		idSanzione = val;

	}

	/**
	 * Legge il valore della proprieta' idSanzione associata alla
	 * @generated
	 */
	public Integer getIdSanzione() {

		return idSanzione;

	}

	/**
	 * Costruttore di una chiave primaria vuota
	 * @generated 
	 */
	public SigitTSanzionePk() {
		//empty constructor
	}

	/**
	 * Costruttore di una chiave primaria a partire dai valori delle varie colonne
	 * @generated
	 */
	public SigitTSanzionePk(

			final Integer idSanzione

	) {

		this.setIdSanzione(idSanzione);

	}

	/**
	 * Method 'equals'. 
	 * Due istanze di SigitTSanzionePk sono equals se i valori di tutti i campi coincidono.
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

		if (!(_other instanceof SigitTSanzionePk)) {
			return false;
		}

		final SigitTSanzionePk _cast = (SigitTSanzionePk) _other;

		if (idSanzione == null ? _cast.getIdSanzione() != null : !idSanzione.equals(_cast.getIdSanzione())) {
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

		if (idSanzione != null) {
			_hashCode = 29 * _hashCode + idSanzione.hashCode();
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

		ret.append("it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTSanzionePk: ");
		ret.append("idSanzione=" + idSanzione);

		return ret.toString();
	}
}
