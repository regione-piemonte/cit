package it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dto;

import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dao.*;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Primary Key del DTO SigitRRuoloTipodocDto.
 * E' utilizzato per tutte le operazioni di lettura dati per chiave primaria. 
 * @generated
 */
public class SigitRRuoloTipodocPk implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna ID_RUOLO
	 * @generated
	 */
	protected java.math.BigDecimal idRuolo;

	/**
	 * Imposta il valore della proprieta' idRuolo associata alla
	 * colonna ID_RUOLO.
	 * @generated
	 */
	public void setIdRuolo(java.math.BigDecimal val) {

		idRuolo = val;

	}

	/**
	 * Legge il valore della proprieta' idRuolo associata alla
	 * @generated
	 */
	public java.math.BigDecimal getIdRuolo() {

		return idRuolo;

	}

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
	public SigitRRuoloTipodocPk() {
		//empty constructor
	}

	/**
	 * Costruttore di una chiave primaria a partire dai valori delle varie colonne
	 * @generated
	 */
	public SigitRRuoloTipodocPk(

			final java.math.BigDecimal idRuolo, final java.math.BigDecimal idTipoDocumento

	) {

		this.setIdRuolo(idRuolo);

		this.setIdTipoDocumento(idTipoDocumento);

	}

	/**
	 * Method 'equals'. 
	 * Due istanze di SigitRRuoloTipodocPk sono equals se i valori di tutti i campi coincidono.
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

		if (!(_other instanceof SigitRRuoloTipodocPk)) {
			return false;
		}

		final SigitRRuoloTipodocPk _cast = (SigitRRuoloTipodocPk) _other;

		if (idRuolo == null ? _cast.getIdRuolo() != null : !idRuolo.equals(_cast.getIdRuolo())) {
			return false;
		}

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

		if (idRuolo != null) {
			_hashCode = 29 * _hashCode + idRuolo.hashCode();
		}

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

		ret.append("it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dto.SigitRRuoloTipodocPk: ");
		ret.append("idRuolo=" + idRuolo);

		ret.append("it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dto.SigitRRuoloTipodocPk: ");
		ret.append("idTipoDocumento=" + idTipoDocumento);

		return ret.toString();
	}
}
