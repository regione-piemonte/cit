package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Primary Key del DTO SigitDCategoriaDto.
 * E' utilizzato per tutte le operazioni di lettura dati per chiave primaria. 
 * @generated
 */
public class SigitDCategoriaPk implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna ID_CATEGORIA
	 * @generated
	 */
	protected String idCategoria;

	/**
	 * Imposta il valore della proprieta' idCategoria associata alla
	 * colonna ID_CATEGORIA.
	 * @generated
	 */
	public void setIdCategoria(String val) {

		idCategoria = val;

	}

	/**
	 * Legge il valore della proprieta' idCategoria associata alla
	 * @generated
	 */
	public String getIdCategoria() {

		return idCategoria;

	}

	/**
	 * Costruttore di una chiave primaria vuota
	 * @generated 
	 */
	public SigitDCategoriaPk() {
		//empty constructor
	}

	/**
	 * Costruttore di una chiave primaria a partire dai valori delle varie colonne
	 * @generated
	 */
	public SigitDCategoriaPk(

			final String idCategoria

	) {

		this.setIdCategoria(idCategoria);

	}

	/**
	 * Method 'equals'. 
	 * Due istanze di SigitDCategoriaPk sono equals se i valori di tutti i campi coincidono.
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

		if (!(_other instanceof SigitDCategoriaPk)) {
			return false;
		}

		final SigitDCategoriaPk _cast = (SigitDCategoriaPk) _other;

		if (idCategoria == null ? _cast.getIdCategoria() != null : !idCategoria.equals(_cast.getIdCategoria())) {
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

		if (idCategoria != null) {
			_hashCode = 29 * _hashCode + idCategoria.hashCode();
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

		ret.append("it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitDCategoriaPk: ");
		ret.append("idCategoria=" + idCategoria);

		return ret.toString();
	}
}
