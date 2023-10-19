package it.csi.sigit.sigitext.business.dao.sigitextdao.dto;

import java.io.Serializable;

/**
 * Primary Key del DTO SigitTContratto2019Dto.
 * E' utilizzato per tutte le operazioni di lettura dati per chiave primaria. 
 * @generated
 */
public class SigitTContratto2019Pk implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna ID_CONTRATTO
	 * @generated
	 */
	protected java.math.BigDecimal idContratto;

	/**
	 * Imposta il valore della proprieta' idContratto associata alla
	 * colonna ID_CONTRATTO.
	 * @generated
	 */
	public void setIdContratto(java.math.BigDecimal val) {

		idContratto = val;

	}

	/**
	 * Legge il valore della proprieta' idContratto associata alla
	 * @generated
	 */
	public java.math.BigDecimal getIdContratto() {

		return idContratto;

	}

	/**
	 * Costruttore di una chiave primaria vuota
	 * @generated 
	 */
	public SigitTContratto2019Pk() {
		//empty constructor
	}

	/**
	 * Costruttore di una chiave primaria a partire dai valori delle varie colonne
	 * @generated
	 */
	public SigitTContratto2019Pk(

			final java.math.BigDecimal idContratto

	) {

		this.setIdContratto(idContratto);

	}

	/**
	 * Method 'equals'. 
	 * Due istanze di SigitTContratto2019Pk sono equals se i valori di tutti i campi coincidono.
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

		if (!(_other instanceof SigitTContratto2019Pk)) {
			return false;
		}

		final SigitTContratto2019Pk _cast = (SigitTContratto2019Pk) _other;

		if (idContratto == null ? _cast.getIdContratto() != null : !idContratto.equals(_cast.getIdContratto())) {
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

		return _hashCode;
	}

	/**
	 * Method 'toString'
	 * 
	 * @return String
	 */
	public String toString() {
		StringBuilder ret = new StringBuilder();

		ret.append("it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTContratto2019Pk: ");
		ret.append("idContratto=" + idContratto);

		return ret.toString();
	}
}
