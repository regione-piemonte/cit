package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Primary Key del DTO SigitDTipoAzioneDto.
 * E' utilizzato per tutte le operazioni di lettura dati per chiave primaria. 
 * @generated
 */
public class SigitDTipoAzionePk implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna ID_TIPO_AZIONE
	 * @generated
	 */
	protected Integer idTipoAzione;

	/**
	 * Imposta il valore della proprieta' idTipoAzione associata alla
	 * colonna ID_TIPO_AZIONE.
	 * @generated
	 */
	public void setIdTipoAzione(Integer val) {

		idTipoAzione = val;

	}

	/**
	 * Legge il valore della proprieta' idTipoAzione associata alla
	 * @generated
	 */
	public Integer getIdTipoAzione() {

		return idTipoAzione;

	}

	/**
	 * Costruttore di una chiave primaria vuota
	 * @generated 
	 */
	public SigitDTipoAzionePk() {
		//empty constructor
	}

	/**
	 * Costruttore di una chiave primaria a partire dai valori delle varie colonne
	 * @generated
	 */
	public SigitDTipoAzionePk(

			final Integer idTipoAzione

	) {

		this.setIdTipoAzione(idTipoAzione);

	}

	/**
	 * Method 'equals'. 
	 * Due istanze di SigitDTipoAzionePk sono equals se i valori di tutti i campi coincidono.
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

		if (!(_other instanceof SigitDTipoAzionePk)) {
			return false;
		}

		final SigitDTipoAzionePk _cast = (SigitDTipoAzionePk) _other;

		if (idTipoAzione == null ? _cast.getIdTipoAzione() != null : !idTipoAzione.equals(_cast.getIdTipoAzione())) {
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

		if (idTipoAzione != null) {
			_hashCode = 29 * _hashCode + idTipoAzione.hashCode();
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

		ret.append("it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitDTipoAzionePk: ");
		ret.append("idTipoAzione=" + idTipoAzione);

		return ret.toString();
	}
}
