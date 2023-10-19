package it.csi.sigit.sigitext.business.dao.sigitextdao.dto;

import java.io.Serializable;

/**
 * Primary Key del DTO SigitTConsumoTipo1BDto.
 * E' utilizzato per tutte le operazioni di lettura dati per chiave primaria. 
 * @generated
 */
public class SigitTConsumoTipo1BPk implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna ID_CONSUMO_TIPO1B
	 * @generated
	 */
	protected java.math.BigDecimal idConsumoTipo1b;

	/**
	 * Imposta il valore della proprieta' idConsumoTipo1b associata alla
	 * colonna ID_CONSUMO_TIPO1B.
	 * @generated
	 */
	public void setIdConsumoTipo1b(java.math.BigDecimal val) {

		idConsumoTipo1b = val;

	}

	/**
	 * Legge il valore della proprieta' idConsumoTipo1b associata alla
	 * @generated
	 */
	public java.math.BigDecimal getIdConsumoTipo1b() {

		return idConsumoTipo1b;

	}

	/**
	 * Costruttore di una chiave primaria vuota
	 * @generated 
	 */
	public SigitTConsumoTipo1BPk() {
		//empty constructor
	}

	/**
	 * Costruttore di una chiave primaria a partire dai valori delle varie colonne
	 * @generated
	 */
	public SigitTConsumoTipo1BPk(

			final java.math.BigDecimal idConsumoTipo1b

	) {

		this.setIdConsumoTipo1b(idConsumoTipo1b);

	}

	/**
	 * Method 'equals'. 
	 * Due istanze di SigitTConsumoTipo1BPk sono equals se i valori di tutti i campi coincidono.
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

		if (!(_other instanceof SigitTConsumoTipo1BPk)) {
			return false;
		}

		final SigitTConsumoTipo1BPk _cast = (SigitTConsumoTipo1BPk) _other;

		if (idConsumoTipo1b == null
				? _cast.getIdConsumoTipo1b() != null
				: !idConsumoTipo1b.equals(_cast.getIdConsumoTipo1b())) {
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

		if (idConsumoTipo1b != null) {
			_hashCode = 29 * _hashCode + idConsumoTipo1b.hashCode();
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

		ret.append("it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTConsumoTipo1BPk: ");
		ret.append("idConsumoTipo1b=" + idConsumoTipo1b);

		return ret.toString();
	}
}
