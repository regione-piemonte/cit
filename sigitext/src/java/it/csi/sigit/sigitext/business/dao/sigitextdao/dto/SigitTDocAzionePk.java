package it.csi.sigit.sigitext.business.dao.sigitextdao.dto;

import java.io.Serializable;

/**
 * Primary Key del DTO SigitTDocAzioneDto.
 * E' utilizzato per tutte le operazioni di lettura dati per chiave primaria. 
 * @generated
 */
public class SigitTDocAzionePk implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna ID_DOC_AZIONE
	 * @generated
	 */
	protected Integer idDocAzione;

	/**
	 * Imposta il valore della proprieta' idDocAzione associata alla
	 * colonna ID_DOC_AZIONE.
	 * @generated
	 */
	public void setIdDocAzione(Integer val) {

		idDocAzione = val;

	}

	/**
	 * Legge il valore della proprieta' idDocAzione associata alla
	 * @generated
	 */
	public Integer getIdDocAzione() {

		return idDocAzione;

	}

	/**
	 * Costruttore di una chiave primaria vuota
	 * @generated 
	 */
	public SigitTDocAzionePk() {
		//empty constructor
	}

	/**
	 * Costruttore di una chiave primaria a partire dai valori delle varie colonne
	 * @generated
	 */
	public SigitTDocAzionePk(

			final Integer idDocAzione

	) {

		this.setIdDocAzione(idDocAzione);

	}

	/**
	 * Method 'equals'. 
	 * Due istanze di SigitTDocAzionePk sono equals se i valori di tutti i campi coincidono.
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

		if (!(_other instanceof SigitTDocAzionePk)) {
			return false;
		}

		final SigitTDocAzionePk _cast = (SigitTDocAzionePk) _other;

		if (idDocAzione == null ? _cast.getIdDocAzione() != null : !idDocAzione.equals(_cast.getIdDocAzione())) {
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

		if (idDocAzione != null) {
			_hashCode = 29 * _hashCode + idDocAzione.hashCode();
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

		ret.append("it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTDocAzionePk: ");
		ret.append("idDocAzione=" + idDocAzione);

		return ret.toString();
	}
}
