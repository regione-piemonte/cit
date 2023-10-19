package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Primary Key del DTO SigitRPfRuoloPaDto.
 * E' utilizzato per tutte le operazioni di lettura dati per chiave primaria. 
 * @generated
 */
public class SigitRPfRuoloPaPk implements Serializable {

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
	 * store della proprieta' associata alla colonna ID_RUOLO_PA
	 * @generated
	 */
	protected Integer idRuoloPa;

	/**
	 * Imposta il valore della proprieta' idRuoloPa associata alla
	 * colonna ID_RUOLO_PA.
	 * @generated
	 */
	public void setIdRuoloPa(Integer val) {

		idRuoloPa = val;

	}

	/**
	 * Legge il valore della proprieta' idRuoloPa associata alla
	 * @generated
	 */
	public Integer getIdRuoloPa() {

		return idRuoloPa;

	}

	/**
	 * store della proprieta' associata alla colonna ISTAT_ABILITAZIONE
	 * @generated
	 */
	protected String istatAbilitazione;

	/**
	 * Imposta il valore della proprieta' istatAbilitazione associata alla
	 * colonna ISTAT_ABILITAZIONE.
	 * @generated
	 */
	public void setIstatAbilitazione(String val) {

		istatAbilitazione = val;

	}

	/**
	 * Legge il valore della proprieta' istatAbilitazione associata alla
	 * @generated
	 */
	public String getIstatAbilitazione() {

		return istatAbilitazione;

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
	public SigitRPfRuoloPaPk() {
		//empty constructor
	}

	/**
	 * Costruttore di una chiave primaria a partire dai valori delle varie colonne
	 * @generated
	 */
	public SigitRPfRuoloPaPk(

			final java.math.BigDecimal idPersonaFisica, final Integer idRuoloPa, final String istatAbilitazione,
			final java.sql.Date dataInizio

	) {

		this.setIdPersonaFisica(idPersonaFisica);

		this.setIdRuoloPa(idRuoloPa);

		this.setIstatAbilitazione(istatAbilitazione);

		this.setDataInizio(dataInizio);

	}

	/**
	 * Method 'equals'. 
	 * Due istanze di SigitRPfRuoloPaPk sono equals se i valori di tutti i campi coincidono.
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

		if (!(_other instanceof SigitRPfRuoloPaPk)) {
			return false;
		}

		final SigitRPfRuoloPaPk _cast = (SigitRPfRuoloPaPk) _other;

		if (idPersonaFisica == null
				? _cast.getIdPersonaFisica() != null
				: !idPersonaFisica.equals(_cast.getIdPersonaFisica())) {
			return false;
		}

		if (idRuoloPa == null ? _cast.getIdRuoloPa() != null : !idRuoloPa.equals(_cast.getIdRuoloPa())) {
			return false;
		}

		if (istatAbilitazione == null
				? _cast.getIstatAbilitazione() != null
				: !istatAbilitazione.equals(_cast.getIstatAbilitazione())) {
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

		if (idRuoloPa != null) {
			_hashCode = 29 * _hashCode + idRuoloPa.hashCode();
		}

		if (istatAbilitazione != null) {
			_hashCode = 29 * _hashCode + istatAbilitazione.hashCode();
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

		ret.append("it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitRPfRuoloPaPk: ");
		ret.append("idPersonaFisica=" + idPersonaFisica);

		ret.append("it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitRPfRuoloPaPk: ");
		ret.append("idRuoloPa=" + idRuoloPa);

		ret.append("it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitRPfRuoloPaPk: ");
		ret.append("istatAbilitazione=" + istatAbilitazione);

		ret.append("it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitRPfRuoloPaPk: ");
		ret.append("dataInizio=" + dataInizio);

		return ret.toString();
	}
}
