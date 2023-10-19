package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Primary Key del DTO SigitTGraffaturaDto.
 * E' utilizzato per tutte le operazioni di lettura dati per chiave primaria. 
 * @generated
 */
public class SigitTGraffaturaPk implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna ID_GRAFFATURA
	 * @generated
	 */
	protected java.math.BigDecimal idGraffatura;

	/**
	 * Imposta il valore della proprieta' idGraffatura associata alla
	 * colonna ID_GRAFFATURA.
	 * @generated
	 */
	public void setIdGraffatura(java.math.BigDecimal val) {

		idGraffatura = val;

	}

	/**
	 * Legge il valore della proprieta' idGraffatura associata alla
	 * @generated
	 */
	public java.math.BigDecimal getIdGraffatura() {

		return idGraffatura;

	}

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
	 * store della proprieta' associata alla colonna DT_INSERIMENTO
	 * @generated
	 */
	protected java.sql.Timestamp dtInserimento;

	/**
	 * Imposta il valore della proprieta' dtInserimento associata alla
	 * colonna DT_INSERIMENTO.
	 * @generated
	 */
	public void setDtInserimento(java.sql.Timestamp val) {

		if (val != null) {
			dtInserimento = new java.sql.Timestamp(val.getTime());
		} else {
			dtInserimento = null;
		}

	}

	/**
	 * Legge il valore della proprieta' dtInserimento associata alla
	 * @generated
	 */
	public java.sql.Timestamp getDtInserimento() {

		if (dtInserimento != null) {
			return new java.sql.Timestamp(dtInserimento.getTime());
		} else {
			return null;
		}

	}

	/**
	 * Costruttore di una chiave primaria vuota
	 * @generated 
	 */
	public SigitTGraffaturaPk() {
		//empty constructor
	}

	/**
	 * Costruttore di una chiave primaria a partire dai valori delle varie colonne
	 * @generated
	 */
	public SigitTGraffaturaPk(

			final java.math.BigDecimal idGraffatura, final java.math.BigDecimal codiceImpianto,
			final java.sql.Timestamp dtInserimento

	) {

		this.setIdGraffatura(idGraffatura);

		this.setCodiceImpianto(codiceImpianto);

		this.setDtInserimento(dtInserimento);

	}

	/**
	 * Method 'equals'. 
	 * Due istanze di SigitTGraffaturaPk sono equals se i valori di tutti i campi coincidono.
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

		if (!(_other instanceof SigitTGraffaturaPk)) {
			return false;
		}

		final SigitTGraffaturaPk _cast = (SigitTGraffaturaPk) _other;

		if (idGraffatura == null ? _cast.getIdGraffatura() != null : !idGraffatura.equals(_cast.getIdGraffatura())) {
			return false;
		}

		if (codiceImpianto == null
				? _cast.getCodiceImpianto() != null
				: !codiceImpianto.equals(_cast.getCodiceImpianto())) {
			return false;
		}

		if (dtInserimento == null
				? _cast.getDtInserimento() != null
				: !dtInserimento.equals(_cast.getDtInserimento())) {
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

		if (idGraffatura != null) {
			_hashCode = 29 * _hashCode + idGraffatura.hashCode();
		}

		if (codiceImpianto != null) {
			_hashCode = 29 * _hashCode + codiceImpianto.hashCode();
		}

		if (dtInserimento != null) {
			_hashCode = 29 * _hashCode + dtInserimento.hashCode();
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

		ret.append("it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTGraffaturaPk: ");
		ret.append("idGraffatura=" + idGraffatura);

		ret.append("it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTGraffaturaPk: ");
		ret.append("codiceImpianto=" + codiceImpianto);

		ret.append("it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTGraffaturaPk: ");
		ret.append("dtInserimento=" + dtInserimento);

		return ret.toString();
	}
}
