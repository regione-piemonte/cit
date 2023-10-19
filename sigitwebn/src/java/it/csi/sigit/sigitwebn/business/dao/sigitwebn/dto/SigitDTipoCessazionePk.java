package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Primary Key del DTO SigitDTipoCessazioneDto.
 * E' utilizzato per tutte le operazioni di lettura dati per chiave primaria. 
 * @generated
 */
public class SigitDTipoCessazionePk implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna ID_TIPO_CESSAZIONE
	 * @generated
	 */
	protected Integer idTipoCessazione;

	/**
	 * Imposta il valore della proprieta' idTipoCessazione associata alla
	 * colonna ID_TIPO_CESSAZIONE.
	 * @generated
	 */
	public void setIdTipoCessazione(Integer val) {

		idTipoCessazione = val;

	}

	/**
	 * Legge il valore della proprieta' idTipoCessazione associata alla
	 * @generated
	 */
	public Integer getIdTipoCessazione() {

		return idTipoCessazione;

	}

	/**
	 * Costruttore di una chiave primaria vuota
	 * @generated 
	 */
	public SigitDTipoCessazionePk() {
		//empty constructor
	}

	/**
	 * Costruttore di una chiave primaria a partire dai valori delle varie colonne
	 * @generated
	 */
	public SigitDTipoCessazionePk(

			final Integer idTipoCessazione

	) {

		this.setIdTipoCessazione(idTipoCessazione);

	}

	/**
	 * Method 'equals'. 
	 * Due istanze di SigitDTipoCessazionePk sono equals se i valori di tutti i campi coincidono.
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

		if (!(_other instanceof SigitDTipoCessazionePk)) {
			return false;
		}

		final SigitDTipoCessazionePk _cast = (SigitDTipoCessazionePk) _other;

		if (idTipoCessazione == null
				? _cast.getIdTipoCessazione() != null
				: !idTipoCessazione.equals(_cast.getIdTipoCessazione())) {
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

		if (idTipoCessazione != null) {
			_hashCode = 29 * _hashCode + idTipoCessazione.hashCode();
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

		ret.append("it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitDTipoCessazionePk: ");
		ret.append("idTipoCessazione=" + idTipoCessazione);

		return ret.toString();
	}
}
