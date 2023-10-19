package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Primary Key del DTO SigitDFonteEnSfruttataDto.
 * E' utilizzato per tutte le operazioni di lettura dati per chiave primaria. 
 * @generated
 */
public class SigitDFonteEnSfruttataPk implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna ID_FONTE_EN_SFRUTTATA
	 * @generated
	 */
	protected java.math.BigDecimal idFonteEnSfruttata;

	/**
	 * Imposta il valore della proprieta' idFonteEnSfruttata associata alla
	 * colonna ID_FONTE_EN_SFRUTTATA.
	 * @generated
	 */
	public void setIdFonteEnSfruttata(java.math.BigDecimal val) {

		idFonteEnSfruttata = val;

	}

	/**
	 * Legge il valore della proprieta' idFonteEnSfruttata associata alla
	 * @generated
	 */
	public java.math.BigDecimal getIdFonteEnSfruttata() {

		return idFonteEnSfruttata;

	}

	/**
	 * Costruttore di una chiave primaria vuota
	 * @generated 
	 */
	public SigitDFonteEnSfruttataPk() {
		//empty constructor
	}

	/**
	 * Costruttore di una chiave primaria a partire dai valori delle varie colonne
	 * @generated
	 */
	public SigitDFonteEnSfruttataPk(

			final java.math.BigDecimal idFonteEnSfruttata

	) {

		this.setIdFonteEnSfruttata(idFonteEnSfruttata);

	}

	/**
	 * Method 'equals'. 
	 * Due istanze di SigitDFonteEnSfruttataPk sono equals se i valori di tutti i campi coincidono.
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

		if (!(_other instanceof SigitDFonteEnSfruttataPk)) {
			return false;
		}

		final SigitDFonteEnSfruttataPk _cast = (SigitDFonteEnSfruttataPk) _other;

		if (idFonteEnSfruttata == null
				? _cast.getIdFonteEnSfruttata() != null
				: !idFonteEnSfruttata.equals(_cast.getIdFonteEnSfruttata())) {
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

		if (idFonteEnSfruttata != null) {
			_hashCode = 29 * _hashCode + idFonteEnSfruttata.hashCode();
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

		ret.append("it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitDFonteEnSfruttataPk: ");
		ret.append("idFonteEnSfruttata=" + idFonteEnSfruttata);

		return ret.toString();
	}
}
