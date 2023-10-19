package it.csi.sigit.sigitweba.business.dao.sigitweba.dto;

import it.csi.sigit.sigitweba.business.dao.sigitweba.dao.*;
import it.csi.sigit.sigitweba.business.dao.sigitweba.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Primary Key del DTO SigitRPfPgDelegaDto.
 * E' utilizzato per tutte le operazioni di lettura dati per chiave primaria. 
 * @generated
 */
public class SigitRPfPgDelegaPk implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna ID_PERSONA_FISICA
	 * @generated
	 */
	protected java.math.BigDecimal idPersonaFisica;

	/**
	 * Imposta il valore della proprieta' idPersonaFisica associata alla
	 * colonna ID_PERSONA_FISICA.
	 * @generated
	 */
	public void setIdPersonaFisica(java.math.BigDecimal val) {

		idPersonaFisica = val;

	}

	/**
	 * Legge il valore della proprieta' idPersonaFisica associata alla
	 * @generated
	 */
	public java.math.BigDecimal getIdPersonaFisica() {

		return idPersonaFisica;

	}

	/**
	 * store della proprieta' associata alla colonna ID_PERSONA_GIURIDICA
	 * @generated
	 */
	protected java.math.BigDecimal idPersonaGiuridica;

	/**
	 * Imposta il valore della proprieta' idPersonaGiuridica associata alla
	 * colonna ID_PERSONA_GIURIDICA.
	 * @generated
	 */
	public void setIdPersonaGiuridica(java.math.BigDecimal val) {

		idPersonaGiuridica = val;

	}

	/**
	 * Legge il valore della proprieta' idPersonaGiuridica associata alla
	 * @generated
	 */
	public java.math.BigDecimal getIdPersonaGiuridica() {

		return idPersonaGiuridica;

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
	public SigitRPfPgDelegaPk() {
		//empty constructor
	}

	/**
	 * Costruttore di una chiave primaria a partire dai valori delle varie colonne
	 * @generated
	 */
	public SigitRPfPgDelegaPk(

			final java.math.BigDecimal idPersonaFisica, final java.math.BigDecimal idPersonaGiuridica,
			final java.sql.Date dataInizio

	) {

		this.setIdPersonaFisica(idPersonaFisica);

		this.setIdPersonaGiuridica(idPersonaGiuridica);

		this.setDataInizio(dataInizio);

	}

	/**
	 * Method 'equals'. 
	 * Due istanze di SigitRPfPgDelegaPk sono equals se i valori di tutti i campi coincidono.
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

		if (!(_other instanceof SigitRPfPgDelegaPk)) {
			return false;
		}

		final SigitRPfPgDelegaPk _cast = (SigitRPfPgDelegaPk) _other;

		if (idPersonaFisica == null
				? _cast.getIdPersonaFisica() != null
				: !idPersonaFisica.equals(_cast.getIdPersonaFisica())) {
			return false;
		}

		if (idPersonaGiuridica == null
				? _cast.getIdPersonaGiuridica() != null
				: !idPersonaGiuridica.equals(_cast.getIdPersonaGiuridica())) {
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

		if (idPersonaFisica != null) {
			_hashCode = 29 * _hashCode + idPersonaFisica.hashCode();
		}

		if (idPersonaGiuridica != null) {
			_hashCode = 29 * _hashCode + idPersonaGiuridica.hashCode();
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

		ret.append("it.csi.sigit.sigitweba.business.dao.sigitweba.dto.SigitRPfPgDelegaPk: ");
		ret.append("idPersonaFisica=" + idPersonaFisica);

		ret.append("it.csi.sigit.sigitweba.business.dao.sigitweba.dto.SigitRPfPgDelegaPk: ");
		ret.append("idPersonaGiuridica=" + idPersonaGiuridica);

		ret.append("it.csi.sigit.sigitweba.business.dao.sigitweba.dto.SigitRPfPgDelegaPk: ");
		ret.append("dataInizio=" + dataInizio);

		return ret.toString();
	}
}
