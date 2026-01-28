package it.csi.sigit.sigitext.business.dao.sigitextdao.dto;

import java.io.Serializable;

/**
 * Primary Key del DTO CombustibileCITDto.
 * E' utilizzato per tutte le operazioni di lettura dati per chiave primaria. 
 * @generated
 */
public class ClassDpr66096CITPk implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna ID_COMBUSTIBILE
	 * @generated
	 */
	protected java.math.BigDecimal idClass;

	/**
	 * Imposta il valore della proprieta' idCombustibile associata alla
	 * colonna ID_COMBUSTIBILE.
	 * @generated
	 */
	public void setIdClass(java.math.BigDecimal val) {

		idClass = val;

	}

	/**
	 * Legge il valore della proprieta' idCombustibile associata alla
	 * @generated
	 */
	public java.math.BigDecimal getIdClass() {

		return idClass;

	}

	/**
	 * Costruttore di una chiave primaria vuota
	 * @generated 
	 */
	public ClassDpr66096CITPk() {
		//empty constructor
	}

	/**
	 * Costruttore di una chiave primaria a partire dai valori delle varie colonne
	 * @generated
	 */
	public ClassDpr66096CITPk(

			final java.math.BigDecimal idClass

	) {

		this.setIdClass(idClass);

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

		if (!(_other instanceof ClassDpr66096CITPk)) {
			return false;
		}

		final ClassDpr66096CITPk _cast = (ClassDpr66096CITPk) _other;

		if (idClass == null
				? _cast.getIdClass() != null
				: !idClass.equals(_cast.getIdClass())) {
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

		if (idClass != null) {
			_hashCode = 29 * _hashCode + idClass.hashCode();
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

		ret.append("it.csi.sigit.sigitext.business.dao.sigitextdao.dto.ClassDpr66096CITPk: ");
		ret.append("idClass=" + idClass);

		return ret.toString();
	}
}
