package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Primary Key del DTO SigitDTipoConclusioneDto.
 * E' utilizzato per tutte le operazioni di lettura dati per chiave primaria. 
 * @generated
 */
public class SigitDTipoConclusionePk implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna ID_TIPO_CONCLUSIONE
	 * @generated
	 */
	protected Integer idTipoConclusione;

	/**
	 * Imposta il valore della proprieta' idTipoConclusione associata alla
	 * colonna ID_TIPO_CONCLUSIONE.
	 * @generated
	 */
	public void setIdTipoConclusione(Integer val) {

		idTipoConclusione = val;

	}

	/**
	 * Legge il valore della proprieta' idTipoConclusione associata alla
	 * @generated
	 */
	public Integer getIdTipoConclusione() {

		return idTipoConclusione;

	}

	/**
	 * Costruttore di una chiave primaria vuota
	 * @generated 
	 */
	public SigitDTipoConclusionePk() {
		//empty constructor
	}

	/**
	 * Costruttore di una chiave primaria a partire dai valori delle varie colonne
	 * @generated
	 */
	public SigitDTipoConclusionePk(

			final Integer idTipoConclusione

	) {

		this.setIdTipoConclusione(idTipoConclusione);

	}

	/**
	 * Method 'equals'. 
	 * Due istanze di SigitDTipoConclusionePk sono equals se i valori di tutti i campi coincidono.
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

		if (!(_other instanceof SigitDTipoConclusionePk)) {
			return false;
		}

		final SigitDTipoConclusionePk _cast = (SigitDTipoConclusionePk) _other;

		if (idTipoConclusione == null
				? _cast.getIdTipoConclusione() != null
				: !idTipoConclusione.equals(_cast.getIdTipoConclusione())) {
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

		if (idTipoConclusione != null) {
			_hashCode = 29 * _hashCode + idTipoConclusione.hashCode();
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

		ret.append("it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitDTipoConclusionePk: ");
		ret.append("idTipoConclusione=" + idTipoConclusione);

		return ret.toString();
	}
}
