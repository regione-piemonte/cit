/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Primary Key del DTO SigitTAllRespTxtDto.
 * E' utilizzato per tutte le operazioni di lettura dati per chiave primaria. 
 * @generated
 */
public class SigitTAllRespTxtPk implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna DATA_CONTROLLO
	 * @generated
	 */
	private java.sql.Date _dataControllo;

	/**
	 * Imposta il valore della proprieta' dataControllo associata alla
	 * colonna DATA_CONTROLLO.
	 * @generated
	 */
	public void setDataControllo(java.sql.Date val) {
		_dataControllo = val;
	}

	/**
	 * Legge il valore della proprieta' dataControllo associata alla
	 * @generated
	 */
	public java.sql.Date getDataControllo() {
		return _dataControllo;
	}

	/**
	 * store della proprieta' associata alla colonna ID_IMP_RUOLO_PFPG
	 * @generated
	 */
	private java.math.BigDecimal _idImpRuoloPfpg;

	/**
	 * Imposta il valore della proprieta' idImpRuoloPfpg associata alla
	 * colonna ID_IMP_RUOLO_PFPG.
	 * @generated
	 */
	public void setIdImpRuoloPfpg(java.math.BigDecimal val) {
		_idImpRuoloPfpg = val;
	}

	/**
	 * Legge il valore della proprieta' idImpRuoloPfpg associata alla
	 * @generated
	 */
	public java.math.BigDecimal getIdImpRuoloPfpg() {
		return _idImpRuoloPfpg;
	}

	/**
	 * store della proprieta' associata alla colonna ID_ALLEGATO
	 * @generated
	 */
	private java.math.BigDecimal _idAllegato;

	/**
	 * Imposta il valore della proprieta' idAllegato associata alla
	 * colonna ID_ALLEGATO.
	 * @generated
	 */
	public void setIdAllegato(java.math.BigDecimal val) {
		_idAllegato = val;
	}

	/**
	 * Legge il valore della proprieta' idAllegato associata alla
	 * @generated
	 */
	public java.math.BigDecimal getIdAllegato() {
		return _idAllegato;
	}

	/**
	 * Costruttore di una chiave primaria vuota
	 * @generated 
	 */
	public SigitTAllRespTxtPk() {
		//empty constructor
	}

	/**
	 * Costruttore di una chiave primaria a partire dai valori delle varie colonne
	 * @generated
	 */
	public SigitTAllRespTxtPk(

	final java.sql.Date dataControllo,
			final java.math.BigDecimal idImpRuoloPfpg,
			final java.math.BigDecimal idAllegato

	) {

		this._dataControllo = dataControllo;

		this._idImpRuoloPfpg = idImpRuoloPfpg;

		this._idAllegato = idAllegato;

	}

	/**
	 * Method 'equals'. 
	 * Due istanze di SigitTAllRespTxtPk sono equals se i valori di tutti i campi coincidono.
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

		if (!(_other instanceof SigitTAllRespTxtPk)) {
			return false;
		}

		final SigitTAllRespTxtPk _cast = (SigitTAllRespTxtPk) _other;

		if (_dataControllo == null
				? _cast.getDataControllo() != null
				: !_dataControllo.equals(_cast.getDataControllo())) {
			return false;
		}

		if (_idImpRuoloPfpg == null
				? _cast.getIdImpRuoloPfpg() != null
				: !_idImpRuoloPfpg.equals(_cast.getIdImpRuoloPfpg())) {
			return false;
		}

		if (_idAllegato == null ? _cast.getIdAllegato() != null : !_idAllegato
				.equals(_cast.getIdAllegato())) {
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

		if (_dataControllo != null) {
			_hashCode = 29 * _hashCode + _dataControllo.hashCode();
		}

		if (_idImpRuoloPfpg != null) {
			_hashCode = 29 * _hashCode + _idImpRuoloPfpg.hashCode();
		}

		if (_idAllegato != null) {
			_hashCode = 29 * _hashCode + _idAllegato.hashCode();
		}

		return _hashCode;
	}

	/**
	 * Method 'toString'
	 * 
	 * @return String
	 */
	public String toString() {
		StringBuffer ret = new StringBuffer();

		ret.append("it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTAllRespTxtPk: ");
		ret.append("_dataControllo=" + _dataControllo);

		ret.append("it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTAllRespTxtPk: ");
		ret.append("_idImpRuoloPfpg=" + _idImpRuoloPfpg);

		ret.append("it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTAllRespTxtPk: ");
		ret.append("_idAllegato=" + _idAllegato);

		return ret.toString();
	}
}
