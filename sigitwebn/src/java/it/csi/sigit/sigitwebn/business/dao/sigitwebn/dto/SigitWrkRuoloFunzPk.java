package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Primary Key del DTO SigitWrkRuoloFunzDto.
 * E' utilizzato per tutte le operazioni di lettura dati per chiave primaria. 
 * @generated
 */
public class SigitWrkRuoloFunzPk implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna RUOLO
	 * @generated
	 */
	protected String ruolo;

	/**
	 * Imposta il valore della proprieta' ruolo associata alla
	 * colonna RUOLO.
	 * @generated
	 */
	public void setRuolo(String val) {

		ruolo = val;

	}

	/**
	 * Legge il valore della proprieta' ruolo associata alla
	 * @generated
	 */
	public String getRuolo() {

		return ruolo;

	}

	/**
	 * Costruttore di una chiave primaria vuota
	 * @generated 
	 */
	public SigitWrkRuoloFunzPk() {
		//empty constructor
	}

	/**
	 * Costruttore di una chiave primaria a partire dai valori delle varie colonne
	 * @generated
	 */
	public SigitWrkRuoloFunzPk(

			final String ruolo

	) {

		this.setRuolo(ruolo);

	}

	/**
	 * Method 'equals'. 
	 * Due istanze di SigitWrkRuoloFunzPk sono equals se i valori di tutti i campi coincidono.
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

		if (!(_other instanceof SigitWrkRuoloFunzPk)) {
			return false;
		}

		final SigitWrkRuoloFunzPk _cast = (SigitWrkRuoloFunzPk) _other;

		if (ruolo == null ? _cast.getRuolo() != null : !ruolo.equals(_cast.getRuolo())) {
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

		if (ruolo != null) {
			_hashCode = 29 * _hashCode + ruolo.hashCode();
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

		ret.append("it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitWrkRuoloFunzPk: ");
		ret.append("ruolo=" + ruolo);

		return ret.toString();
	}
}
