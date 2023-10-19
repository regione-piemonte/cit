package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Primary Key del DTO SigitTStoricoVariazStatoDto.
 * E' utilizzato per tutte le operazioni di lettura dati per chiave primaria. 
 * @generated
 */
public class SigitTStoricoVariazStatoPk implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna CODICE_IMPIANTO
	 * @generated
	 */
	protected java.math.BigDecimal codiceImpianto;

	/**
	 * Imposta il valore della proprieta' codiceImpianto associata alla
	 * colonna CODICE_IMPIANTO.
	 * @generated
	 */
	public void setCodiceImpianto(java.math.BigDecimal val) {

		codiceImpianto = val;

	}

	/**
	 * Legge il valore della proprieta' codiceImpianto associata alla
	 * @generated
	 */
	public java.math.BigDecimal getCodiceImpianto() {

		return codiceImpianto;

	}

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
	 * Costruttore di una chiave primaria vuota
	 * @generated 
	 */
	public SigitTStoricoVariazStatoPk() {
		//empty constructor
	}

	/**
	 * Costruttore di una chiave primaria a partire dai valori delle varie colonne
	 * @generated
	 */
	public SigitTStoricoVariazStatoPk(

			final java.math.BigDecimal codiceImpianto, final java.sql.Timestamp dtEvento

	) {

		this.setCodiceImpianto(codiceImpianto);

		this.setDtEvento(dtEvento);

	}

	/**
	 * Method 'equals'. 
	 * Due istanze di SigitTStoricoVariazStatoPk sono equals se i valori di tutti i campi coincidono.
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

		if (!(_other instanceof SigitTStoricoVariazStatoPk)) {
			return false;
		}

		final SigitTStoricoVariazStatoPk _cast = (SigitTStoricoVariazStatoPk) _other;

		if (codiceImpianto == null
				? _cast.getCodiceImpianto() != null
				: !codiceImpianto.equals(_cast.getCodiceImpianto())) {
			return false;
		}

		if (dtEvento == null ? _cast.getDtEvento() != null : !dtEvento.equals(_cast.getDtEvento())) {
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

		if (codiceImpianto != null) {
			_hashCode = 29 * _hashCode + codiceImpianto.hashCode();
		}

		if (dtEvento != null) {
			_hashCode = 29 * _hashCode + dtEvento.hashCode();
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

		ret.append("it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTStoricoVariazStatoPk: ");
		ret.append("codiceImpianto=" + codiceImpianto);

		ret.append("it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTStoricoVariazStatoPk: ");
		ret.append("dtEvento=" + dtEvento);

		return ret.toString();
	}
}
