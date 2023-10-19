package it.csi.sigit.sigitext.business.dao.sigitextdao.dto;

import java.io.Serializable;

/**
 * Primary Key del DTO SigitDTipo1BDto.
 * E' utilizzato per tutte le operazioni di lettura dati per chiave primaria. 
 * @generated
 */
public class SigitDTipo1BPk implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna ID_TIPO_1B
	 * @generated
	 */
	protected java.math.BigDecimal idTipo1b;

	/**
	 * Imposta il valore della proprieta' idTipo1b associata alla
	 * colonna ID_TIPO_1B.
	 * @generated
	 */
	public void setIdTipo1b(java.math.BigDecimal val) {

		idTipo1b = val;

	}

	/**
	 * Legge il valore della proprieta' idTipo1b associata alla
	 * @generated
	 */
	public java.math.BigDecimal getIdTipo1b() {

		return idTipo1b;

	}

	/**
	 * Costruttore di una chiave primaria vuota
	 * @generated 
	 */
	public SigitDTipo1BPk() {
		//empty constructor
	}

	/**
	 * Costruttore di una chiave primaria a partire dai valori delle varie colonne
	 * @generated
	 */
	public SigitDTipo1BPk(

			final java.math.BigDecimal idTipo1b

	) {

		this.setIdTipo1b(idTipo1b);

	}

	/**
	 * Method 'equals'. 
	 * Due istanze di SigitDTipo1BPk sono equals se i valori di tutti i campi coincidono.
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

		if (!(_other instanceof SigitDTipo1BPk)) {
			return false;
		}

		final SigitDTipo1BPk _cast = (SigitDTipo1BPk) _other;

		if (idTipo1b == null ? _cast.getIdTipo1b() != null : !idTipo1b.equals(_cast.getIdTipo1b())) {
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

		if (idTipo1b != null) {
			_hashCode = 29 * _hashCode + idTipo1b.hashCode();
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

		ret.append("it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitDTipo1BPk: ");
		ret.append("idTipo1b=" + idTipo1b);

		return ret.toString();
	}
}
