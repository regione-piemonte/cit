package it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dto;

import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dao.*;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Primary Key del DTO SigitTDatoDistribDto.
 * E' utilizzato per tutte le operazioni di lettura dati per chiave primaria. 
 * @generated
 */
public class SigitTDatoDistribPk implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna ID_DATO_DISTRIB
	 * @generated
	 */
	protected Integer idDatoDistrib;

	/**
	 * Imposta il valore della proprieta' idDatoDistrib associata alla
	 * colonna ID_DATO_DISTRIB.
	 * @generated
	 */
	public void setIdDatoDistrib(Integer val) {

		idDatoDistrib = val;

	}

	/**
	 * Legge il valore della proprieta' idDatoDistrib associata alla
	 * @generated
	 */
	public Integer getIdDatoDistrib() {

		return idDatoDistrib;

	}

	/**
	 * Costruttore di una chiave primaria vuota
	 * @generated 
	 */
	public SigitTDatoDistribPk() {
		//empty constructor
	}

	/**
	 * Costruttore di una chiave primaria a partire dai valori delle varie colonne
	 * @generated
	 */
	public SigitTDatoDistribPk(

			final Integer idDatoDistrib

	) {

		this.setIdDatoDistrib(idDatoDistrib);

	}

	/**
	 * Method 'equals'. 
	 * Due istanze di SigitTDatoDistribPk sono equals se i valori di tutti i campi coincidono.
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

		if (!(_other instanceof SigitTDatoDistribPk)) {
			return false;
		}

		final SigitTDatoDistribPk _cast = (SigitTDatoDistribPk) _other;

		if (idDatoDistrib == null
				? _cast.getIdDatoDistrib() != null
				: !idDatoDistrib.equals(_cast.getIdDatoDistrib())) {
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

		if (idDatoDistrib != null) {
			_hashCode = 29 * _hashCode + idDatoDistrib.hashCode();
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

		ret.append("it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dto.SigitTDatoDistribPk: ");
		ret.append("idDatoDistrib=" + idDatoDistrib);

		return ret.toString();
	}
}
