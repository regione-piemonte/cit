package it.csi.sigit.sigitext.business.dao.sigitextdao.dto;

import java.io.Serializable;

/**
 * Primary Key del DTO SigitDAriaComburenteDto.
 * E' utilizzato per tutte le operazioni di lettura dati per chiave primaria. 
 * @generated
 */
public class SigitDAriaComburentePk implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna ID_ARIA_COMBURENTE
	 * @generated
	 */
	protected java.math.BigDecimal idAriaComburente;

	/**
	 * Imposta il valore della proprieta' idAriaComburente associata alla
	 * colonna ID_ARIA_COMBURENTE.
	 * @generated
	 */
	public void setIdAriaComburente(java.math.BigDecimal val) {

		idAriaComburente = val;

	}

	/**
	 * Legge il valore della proprieta' idAriaComburente associata alla
	 * @generated
	 */
	public java.math.BigDecimal getIdAriaComburente() {

		return idAriaComburente;

	}

	/**
	 * Costruttore di una chiave primaria vuota
	 * @generated 
	 */
	public SigitDAriaComburentePk() {
		//empty constructor
	}

	/**
	 * Costruttore di una chiave primaria a partire dai valori delle varie colonne
	 * @generated
	 */
	public SigitDAriaComburentePk(

			final java.math.BigDecimal idAriaComburente

	) {

		this.setIdAriaComburente(idAriaComburente);

	}

	/**
	 * Method 'equals'. 
	 * Due istanze di SigitDAriaComburentePk sono equals se i valori di tutti i campi coincidono.
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

		if (!(_other instanceof SigitDAriaComburentePk)) {
			return false;
		}

		final SigitDAriaComburentePk _cast = (SigitDAriaComburentePk) _other;

		if (idAriaComburente == null
				? _cast.getIdAriaComburente() != null
				: !idAriaComburente.equals(_cast.getIdAriaComburente())) {
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

		if (idAriaComburente != null) {
			_hashCode = 29 * _hashCode + idAriaComburente.hashCode();
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

		ret.append("it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitDAriaComburentePk: ");
		ret.append("idAriaComburente=" + idAriaComburente);

		return ret.toString();
	}
}
