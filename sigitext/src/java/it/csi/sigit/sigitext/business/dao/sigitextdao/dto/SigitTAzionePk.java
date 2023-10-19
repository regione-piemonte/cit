package it.csi.sigit.sigitext.business.dao.sigitextdao.dto;

import java.io.Serializable;

/**
 * Primary Key del DTO SigitTAzioneDto.
 * E' utilizzato per tutte le operazioni di lettura dati per chiave primaria. 
 * @generated
 */
public class SigitTAzionePk implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna ID_AZIONE
	 * @generated
	 */
	protected Integer idAzione;

	/**
	 * Imposta il valore della proprieta' idAzione associata alla
	 * colonna ID_AZIONE.
	 * @generated
	 */
	public void setIdAzione(Integer val) {

		idAzione = val;

	}

	/**
	 * Legge il valore della proprieta' idAzione associata alla
	 * @generated
	 */
	public Integer getIdAzione() {

		return idAzione;

	}

	/**
	 * Costruttore di una chiave primaria vuota
	 * @generated 
	 */
	public SigitTAzionePk() {
		//empty constructor
	}

	/**
	 * Costruttore di una chiave primaria a partire dai valori delle varie colonne
	 * @generated
	 */
	public SigitTAzionePk(

			final Integer idAzione

	) {

		this.setIdAzione(idAzione);

	}

	/**
	 * Method 'equals'. 
	 * Due istanze di SigitTAzionePk sono equals se i valori di tutti i campi coincidono.
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

		if (!(_other instanceof SigitTAzionePk)) {
			return false;
		}

		final SigitTAzionePk _cast = (SigitTAzionePk) _other;

		if (idAzione == null ? _cast.getIdAzione() != null : !idAzione.equals(_cast.getIdAzione())) {
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

		if (idAzione != null) {
			_hashCode = 29 * _hashCode + idAzione.hashCode();
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

		ret.append("it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTAzionePk: ");
		ret.append("idAzione=" + idAzione);

		return ret.toString();
	}
}
