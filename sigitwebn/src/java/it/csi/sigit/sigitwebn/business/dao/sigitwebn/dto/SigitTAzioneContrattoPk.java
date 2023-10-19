package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Primary Key del DTO SigitTAzioneContrattoDto.
 * E' utilizzato per tutte le operazioni di lettura dati per chiave primaria. 
 * @generated
 */
public class SigitTAzioneContrattoPk implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna ID_CONTRATTO
	 * @generated
	 */
	protected Integer idContratto;

	/**
	 * Imposta il valore della proprieta' idContratto associata alla
	 * colonna ID_CONTRATTO.
	 * @generated
	 */
	public void setIdContratto(Integer val) {

		idContratto = val;

	}

	/**
	 * Legge il valore della proprieta' idContratto associata alla
	 * @generated
	 */
	public Integer getIdContratto() {

		return idContratto;

	}

	/**
	 * store della proprieta' associata alla colonna DT_AZIONE
	 * @generated
	 */
	protected java.sql.Timestamp dtAzione;

	/**
	 * Imposta il valore della proprieta' dtAzione associata alla
	 * colonna DT_AZIONE.
	 * @generated
	 */
	public void setDtAzione(java.sql.Timestamp val) {

		if (val != null) {
			dtAzione = new java.sql.Timestamp(val.getTime());
		} else {
			dtAzione = null;
		}

	}

	/**
	 * Legge il valore della proprieta' dtAzione associata alla
	 * @generated
	 */
	public java.sql.Timestamp getDtAzione() {

		if (dtAzione != null) {
			return new java.sql.Timestamp(dtAzione.getTime());
		} else {
			return null;
		}

	}

	/**
	 * Costruttore di una chiave primaria vuota
	 * @generated 
	 */
	public SigitTAzioneContrattoPk() {
		//empty constructor
	}

	/**
	 * Costruttore di una chiave primaria a partire dai valori delle varie colonne
	 * @generated
	 */
	public SigitTAzioneContrattoPk(

			final Integer idContratto, final java.sql.Timestamp dtAzione

	) {

		this.setIdContratto(idContratto);

		this.setDtAzione(dtAzione);

	}

	/**
	 * Method 'equals'. 
	 * Due istanze di SigitTAzioneContrattoPk sono equals se i valori di tutti i campi coincidono.
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

		if (!(_other instanceof SigitTAzioneContrattoPk)) {
			return false;
		}

		final SigitTAzioneContrattoPk _cast = (SigitTAzioneContrattoPk) _other;

		if (idContratto == null ? _cast.getIdContratto() != null : !idContratto.equals(_cast.getIdContratto())) {
			return false;
		}

		if (dtAzione == null ? _cast.getDtAzione() != null : !dtAzione.equals(_cast.getDtAzione())) {
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

		if (idContratto != null) {
			_hashCode = 29 * _hashCode + idContratto.hashCode();
		}

		if (dtAzione != null) {
			_hashCode = 29 * _hashCode + dtAzione.hashCode();
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

		ret.append("it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTAzioneContrattoPk: ");
		ret.append("idContratto=" + idContratto);

		ret.append("it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTAzioneContrattoPk: ");
		ret.append("dtAzione=" + dtAzione);

		return ret.toString();
	}
}
