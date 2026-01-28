package it.csi.sigit.sigitext.business.dao.sigitextdao.dto;

import java.io.Serializable;

/**
 * Primary Key del DTO CombustibileCITDto.
 * E' utilizzato per tutte le operazioni di lettura dati per chiave primaria. 
 * @generated
 */
public class FrequenzaManutCITPk implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna ID_COMBUSTIBILE
	 * @generated
	 */
	protected java.math.BigDecimal idFrequenza;

	/**
	 * Imposta il valore della proprieta' idCombustibile associata alla
	 * colonna ID_COMBUSTIBILE.
	 * @generated
	 */
	public void setIdFrequenza(java.math.BigDecimal val) {

		idFrequenza = val;

	}

	/**
	 * Legge il valore della proprieta' idCombustibile associata alla
	 * @generated
	 */
	public java.math.BigDecimal getIdFrequenza() {

		return idFrequenza;

	}

	/**
	 * Costruttore di una chiave primaria vuota
	 * @generated 
	 */
	public FrequenzaManutCITPk() {
		//empty constructor
	}

	/**
	 * Costruttore di una chiave primaria a partire dai valori delle varie colonne
	 * @generated
	 */
	public FrequenzaManutCITPk(

			final java.math.BigDecimal idFrequenza

	) {

		this.setIdFrequenza(idFrequenza);

	}

	/**
	 * Method 'equals'. 
	 * Due istanze di CombustibileCITPk sono equals se i valori di tutti i campi coincidono.
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

		if (!(_other instanceof FrequenzaManutCITPk)) {
			return false;
		}

		final FrequenzaManutCITPk _cast = (FrequenzaManutCITPk) _other;

		if (idFrequenza == null
				? _cast.getIdFrequenza() != null
				: !idFrequenza.equals(_cast.getIdFrequenza())) {
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

		if (idFrequenza != null) {
			_hashCode = 29 * _hashCode + idFrequenza.hashCode();
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

		ret.append("it.csi.sigit.sigitext.business.dao.sigitextdao.dto.FrequenzaManutCITPk: ");
		ret.append("idFrequenza=" + idFrequenza);

		return ret.toString();
	}
}
