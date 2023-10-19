package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Primary Key del DTO SigitTStoricoVarStatoPgDto.
 * E' utilizzato per tutte le operazioni di lettura dati per chiave primaria. 
 * @generated
 */
public class SigitTStoricoVarStatoPgPk implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna DT_EVENTO
	 * @generated
	 */
	protected java.sql.Timestamp dtEvento;

	/**
	 * Imposta il valore della proprieta' dtEvento associata alla
	 * colonna DT_EVENTO.
	 * @generated
	 */
	public void setDtEvento(java.sql.Timestamp val) {

		if (val != null) {
			dtEvento = new java.sql.Timestamp(val.getTime());
		} else {
			dtEvento = null;
		}

	}

	/**
	 * Legge il valore della proprieta' dtEvento associata alla
	 * @generated
	 */
	public java.sql.Timestamp getDtEvento() {

		if (dtEvento != null) {
			return new java.sql.Timestamp(dtEvento.getTime());
		} else {
			return null;
		}

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
	 * Costruttore di una chiave primaria vuota
	 * @generated 
	 */
	public SigitTStoricoVarStatoPgPk() {
		//empty constructor
	}

	/**
	 * Costruttore di una chiave primaria a partire dai valori delle varie colonne
	 * @generated
	 */
	public SigitTStoricoVarStatoPgPk(

			final java.sql.Timestamp dtEvento, final java.math.BigDecimal idPersonaGiuridica

	) {

		this.setDtEvento(dtEvento);

		this.setIdPersonaGiuridica(idPersonaGiuridica);

	}

	/**
	 * Method 'equals'. 
	 * Due istanze di SigitTStoricoVarStatoPgPk sono equals se i valori di tutti i campi coincidono.
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

		if (!(_other instanceof SigitTStoricoVarStatoPgPk)) {
			return false;
		}

		final SigitTStoricoVarStatoPgPk _cast = (SigitTStoricoVarStatoPgPk) _other;

		if (dtEvento == null ? _cast.getDtEvento() != null : !dtEvento.equals(_cast.getDtEvento())) {
			return false;
		}

		if (idPersonaGiuridica == null
				? _cast.getIdPersonaGiuridica() != null
				: !idPersonaGiuridica.equals(_cast.getIdPersonaGiuridica())) {
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

		if (dtEvento != null) {
			_hashCode = 29 * _hashCode + dtEvento.hashCode();
		}

		if (idPersonaGiuridica != null) {
			_hashCode = 29 * _hashCode + idPersonaGiuridica.hashCode();
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

		ret.append("it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTStoricoVarStatoPgPk: ");
		ret.append("dtEvento=" + dtEvento);

		ret.append("it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTStoricoVarStatoPgPk: ");
		ret.append("idPersonaGiuridica=" + idPersonaGiuridica);

		return ret.toString();
	}
}
