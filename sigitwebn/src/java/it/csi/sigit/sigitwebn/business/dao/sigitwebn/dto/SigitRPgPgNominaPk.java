package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Primary Key del DTO SigitRPgPgNominaDto.
 * E' utilizzato per tutte le operazioni di lettura dati per chiave primaria. 
 * @generated
 */
public class SigitRPgPgNominaPk implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna ID_PERSONA_GIURIDICA_CAT
	 * @generated
	 */
	protected java.math.BigDecimal idPersonaGiuridicaCat;

	/**
	 * Imposta il valore della proprieta' idPersonaGiuridicaCat associata alla
	 * colonna ID_PERSONA_GIURIDICA_CAT.
	 * @generated
	 */
	public void setIdPersonaGiuridicaCat(java.math.BigDecimal val) {

		idPersonaGiuridicaCat = val;

	}

	/**
	 * Legge il valore della proprieta' idPersonaGiuridicaCat associata alla
	 * @generated
	 */
	public java.math.BigDecimal getIdPersonaGiuridicaCat() {

		return idPersonaGiuridicaCat;

	}

	/**
	 * store della proprieta' associata alla colonna ID_PERSONA_GIURIDICA_IMPRESA
	 * @generated
	 */
	protected java.math.BigDecimal idPersonaGiuridicaImpresa;

	/**
	 * Imposta il valore della proprieta' idPersonaGiuridicaImpresa associata alla
	 * colonna ID_PERSONA_GIURIDICA_IMPRESA.
	 * @generated
	 */
	public void setIdPersonaGiuridicaImpresa(java.math.BigDecimal val) {

		idPersonaGiuridicaImpresa = val;

	}

	/**
	 * Legge il valore della proprieta' idPersonaGiuridicaImpresa associata alla
	 * @generated
	 */
	public java.math.BigDecimal getIdPersonaGiuridicaImpresa() {

		return idPersonaGiuridicaImpresa;

	}

	/**
	 * store della proprieta' associata alla colonna DATA_INIZIO
	 * @generated
	 */
	protected java.sql.Date dataInizio;

	/**
	 * Imposta il valore della proprieta' dataInizio associata alla
	 * colonna DATA_INIZIO.
	 * @generated
	 */
	public void setDataInizio(java.sql.Date val) {

		if (val != null) {
			dataInizio = new java.sql.Date(val.getTime());
		} else {
			dataInizio = null;
		}

	}

	/**
	 * Legge il valore della proprieta' dataInizio associata alla
	 * @generated
	 */
	public java.sql.Date getDataInizio() {

		if (dataInizio != null) {
			return new java.sql.Date(dataInizio.getTime());
		} else {
			return null;
		}

	}

	/**
	 * Costruttore di una chiave primaria vuota
	 * @generated 
	 */
	public SigitRPgPgNominaPk() {
		//empty constructor
	}

	/**
	 * Costruttore di una chiave primaria a partire dai valori delle varie colonne
	 * @generated
	 */
	public SigitRPgPgNominaPk(

			final java.math.BigDecimal idPersonaGiuridicaCat, final java.math.BigDecimal idPersonaGiuridicaImpresa,
			final java.sql.Date dataInizio

	) {

		this.setIdPersonaGiuridicaCat(idPersonaGiuridicaCat);

		this.setIdPersonaGiuridicaImpresa(idPersonaGiuridicaImpresa);

		this.setDataInizio(dataInizio);

	}

	/**
	 * Method 'equals'. 
	 * Due istanze di SigitRPgPgNominaPk sono equals se i valori di tutti i campi coincidono.
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

		if (!(_other instanceof SigitRPgPgNominaPk)) {
			return false;
		}

		final SigitRPgPgNominaPk _cast = (SigitRPgPgNominaPk) _other;

		if (idPersonaGiuridicaCat == null
				? _cast.getIdPersonaGiuridicaCat() != null
				: !idPersonaGiuridicaCat.equals(_cast.getIdPersonaGiuridicaCat())) {
			return false;
		}

		if (idPersonaGiuridicaImpresa == null
				? _cast.getIdPersonaGiuridicaImpresa() != null
				: !idPersonaGiuridicaImpresa.equals(_cast.getIdPersonaGiuridicaImpresa())) {
			return false;
		}

		if (dataInizio == null ? _cast.getDataInizio() != null : !dataInizio.equals(_cast.getDataInizio())) {
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

		if (idPersonaGiuridicaCat != null) {
			_hashCode = 29 * _hashCode + idPersonaGiuridicaCat.hashCode();
		}

		if (idPersonaGiuridicaImpresa != null) {
			_hashCode = 29 * _hashCode + idPersonaGiuridicaImpresa.hashCode();
		}

		if (dataInizio != null) {
			_hashCode = 29 * _hashCode + dataInizio.hashCode();
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

		ret.append("it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitRPgPgNominaPk: ");
		ret.append("idPersonaGiuridicaCat=" + idPersonaGiuridicaCat);

		ret.append("it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitRPgPgNominaPk: ");
		ret.append("idPersonaGiuridicaImpresa=" + idPersonaGiuridicaImpresa);

		ret.append("it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitRPgPgNominaPk: ");
		ret.append("dataInizio=" + dataInizio);

		return ret.toString();
	}
}
