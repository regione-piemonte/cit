package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Primary Key del DTO SigitDTipoManutenzioneDto.
 * E' utilizzato per tutte le operazioni di lettura dati per chiave primaria. 
 * @generated
 */
public class SigitDTipoManutenzionePk implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna ID_TIPO_MANUTENZIONE
	 * @generated
	 */
	protected Integer idTipoManutenzione;

	/**
	 * Imposta il valore della proprieta' idTipoManutenzione associata alla
	 * colonna ID_TIPO_MANUTENZIONE.
	 * @generated
	 */
	public void setIdTipoManutenzione(Integer val) {

		idTipoManutenzione = val;

	}

	/**
	 * Legge il valore della proprieta' idTipoManutenzione associata alla
	 * @generated
	 */
	public Integer getIdTipoManutenzione() {

		return idTipoManutenzione;

	}

	/**
	 * Costruttore di una chiave primaria vuota
	 * @generated 
	 */
	public SigitDTipoManutenzionePk() {
		//empty constructor
	}

	/**
	 * Costruttore di una chiave primaria a partire dai valori delle varie colonne
	 * @generated
	 */
	public SigitDTipoManutenzionePk(

			final Integer idTipoManutenzione

	) {

		this.setIdTipoManutenzione(idTipoManutenzione);

	}

	/**
	 * Method 'equals'. 
	 * Due istanze di SigitDTipoManutenzionePk sono equals se i valori di tutti i campi coincidono.
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

		if (!(_other instanceof SigitDTipoManutenzionePk)) {
			return false;
		}

		final SigitDTipoManutenzionePk _cast = (SigitDTipoManutenzionePk) _other;

		if (idTipoManutenzione == null
				? _cast.getIdTipoManutenzione() != null
				: !idTipoManutenzione.equals(_cast.getIdTipoManutenzione())) {
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

		if (idTipoManutenzione != null) {
			_hashCode = 29 * _hashCode + idTipoManutenzione.hashCode();
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

		ret.append("it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitDTipoManutenzionePk: ");
		ret.append("idTipoManutenzione=" + idTipoManutenzione);

		return ret.toString();
	}
}
