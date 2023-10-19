package it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dto;

import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dao.*;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Primary Key del DTO SigitTImportDistribDto.
 * E' utilizzato per tutte le operazioni di lettura dati per chiave primaria. 
 * @generated
 */
public class SigitTImportDistribPk implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna ID_IMPORT_DISTRIB
	 * @generated
	 */
	protected Integer idImportDistrib;

	/**
	 * Imposta il valore della proprieta' idImportDistrib associata alla
	 * colonna ID_IMPORT_DISTRIB.
	 * @generated
	 */
	public void setIdImportDistrib(Integer val) {

		idImportDistrib = val;

	}

	/**
	 * Legge il valore della proprieta' idImportDistrib associata alla
	 * @generated
	 */
	public Integer getIdImportDistrib() {

		return idImportDistrib;

	}

	/**
	 * Costruttore di una chiave primaria vuota
	 * @generated 
	 */
	public SigitTImportDistribPk() {
		//empty constructor
	}

	/**
	 * Costruttore di una chiave primaria a partire dai valori delle varie colonne
	 * @generated
	 */
	public SigitTImportDistribPk(

			final Integer idImportDistrib

	) {

		this.setIdImportDistrib(idImportDistrib);

	}

	/**
	 * Method 'equals'. 
	 * Due istanze di SigitTImportDistribPk sono equals se i valori di tutti i campi coincidono.
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

		if (!(_other instanceof SigitTImportDistribPk)) {
			return false;
		}

		final SigitTImportDistribPk _cast = (SigitTImportDistribPk) _other;

		if (idImportDistrib == null
				? _cast.getIdImportDistrib() != null
				: !idImportDistrib.equals(_cast.getIdImportDistrib())) {
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

		if (idImportDistrib != null) {
			_hashCode = 29 * _hashCode + idImportDistrib.hashCode();
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

		ret.append("it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dto.SigitTImportDistribPk: ");
		ret.append("idImportDistrib=" + idImportDistrib);

		return ret.toString();
	}
}
