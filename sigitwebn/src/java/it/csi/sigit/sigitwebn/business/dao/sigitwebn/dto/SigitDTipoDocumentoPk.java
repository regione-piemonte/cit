package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Primary Key del DTO SigitDTipoDocumentoDto.
 * E' utilizzato per tutte le operazioni di lettura dati per chiave primaria. 
 * @generated
 */
public class SigitDTipoDocumentoPk implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna ID_TIPO_DOCUMENTO
	 * @generated
	 */
	protected java.math.BigDecimal idTipoDocumento;

	/**
	 * Imposta il valore della proprieta' idTipoDocumento associata alla
	 * colonna ID_TIPO_DOCUMENTO.
	 * @generated
	 */
	public void setIdTipoDocumento(java.math.BigDecimal val) {

		idTipoDocumento = val;

	}

	/**
	 * Legge il valore della proprieta' idTipoDocumento associata alla
	 * @generated
	 */
	public java.math.BigDecimal getIdTipoDocumento() {

		return idTipoDocumento;

	}

	/**
	 * Costruttore di una chiave primaria vuota
	 * @generated 
	 */
	public SigitDTipoDocumentoPk() {
		//empty constructor
	}

	/**
	 * Costruttore di una chiave primaria a partire dai valori delle varie colonne
	 * @generated
	 */
	public SigitDTipoDocumentoPk(

			final java.math.BigDecimal idTipoDocumento

	) {

		this.setIdTipoDocumento(idTipoDocumento);

	}

	/**
	 * Method 'equals'. 
	 * Due istanze di SigitDTipoDocumentoPk sono equals se i valori di tutti i campi coincidono.
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

		if (!(_other instanceof SigitDTipoDocumentoPk)) {
			return false;
		}

		final SigitDTipoDocumentoPk _cast = (SigitDTipoDocumentoPk) _other;

		if (idTipoDocumento == null
				? _cast.getIdTipoDocumento() != null
				: !idTipoDocumento.equals(_cast.getIdTipoDocumento())) {
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

		if (idTipoDocumento != null) {
			_hashCode = 29 * _hashCode + idTipoDocumento.hashCode();
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

		ret.append("it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitDTipoDocumentoPk: ");
		ret.append("idTipoDocumento=" + idTipoDocumento);

		return ret.toString();
	}
}
