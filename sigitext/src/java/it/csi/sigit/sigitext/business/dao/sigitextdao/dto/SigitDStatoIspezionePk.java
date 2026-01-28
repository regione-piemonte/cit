package it.csi.sigit.sigitext.business.dao.sigitextdao.dto;

import java.io.Serializable;

/**
 * Primary Key del DTO SigitDStatoIspezioneDto.
 * E' utilizzato per tutte le operazioni di lettura dati per chiave primaria. 
 * @generated
 */
public class SigitDStatoIspezionePk implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna ID_STATO_ISPEZIONE
	 * @generated
	 */
	protected java.math.BigDecimal idStatoIspezione;

	/**
	 * Imposta il valore della proprieta' idStatoIspezione associata alla
	 * colonna ID_STATO_ISPEZIONE.
	 * @generated
	 */
	public void setIdStatoIspezione(java.math.BigDecimal idStatoIspezione) {

		this.idStatoIspezione = idStatoIspezione;

	}

	/**
	 * Legge il valore della proprieta' idStatoIspezione associata alla
	 * @generated
	 */
	public java.math.BigDecimal getIdStatoIspezione() {

		return idStatoIspezione;

	}

	/**
	 * Costruttore di una chiave primaria vuota
	 * @generated 
	 */
	public SigitDStatoIspezionePk() {
		//empty constructor
	}

	/**
	 * Costruttore di una chiave primaria a partire dai valori delle varie colonne
	 * @generated
	 */
	public SigitDStatoIspezionePk(

			final java.math.BigDecimal idStatoIspezione

	) {

		this.setIdStatoIspezione(idStatoIspezione);

	}

	/**
	 * Method 'equals'. 
	 * Due istanze di SigitDStatoIspezionePk sono equals se i valori di tutti i campi coincidono.
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

		if (!(_other instanceof SigitDStatoIspezionePk)) {
			return false;
		}

		final SigitDStatoIspezionePk _cast = (SigitDStatoIspezionePk) _other;

		if (idStatoIspezione == null ? _cast.getIdStatoIspezione() != null : !idStatoIspezione.equals(_cast.getIdStatoIspezione())) {
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

		if (idStatoIspezione != null) {
			_hashCode = 29 * _hashCode + idStatoIspezione.hashCode();
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

		ret.append("it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitDStatoIspezionePk: ");
		ret.append("idStato=" + idStatoIspezione);

		return ret.toString();
	}
}
