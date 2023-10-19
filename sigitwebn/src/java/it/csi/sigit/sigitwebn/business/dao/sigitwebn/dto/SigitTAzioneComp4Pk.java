package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Primary Key del DTO SigitTAzioneComp4Dto.
 * E' utilizzato per tutte le operazioni di lettura dati per chiave primaria. 
 * @generated
 */
public class SigitTAzioneComp4Pk implements Serializable {

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
	 * store della proprieta' associata alla colonna ID_TIPO_COMPONENTE
	 * @generated
	 */
	protected String idTipoComponente;

	/**
	 * Imposta il valore della proprieta' idTipoComponente associata alla
	 * colonna ID_TIPO_COMPONENTE.
	 * @generated
	 */
	public void setIdTipoComponente(String val) {

		idTipoComponente = val;

	}

	/**
	 * Legge il valore della proprieta' idTipoComponente associata alla
	 * @generated
	 */
	public String getIdTipoComponente() {

		return idTipoComponente;

	}

	/**
	 * store della proprieta' associata alla colonna PROGRESSIVO
	 * @generated
	 */
	protected java.math.BigDecimal progressivo;

	/**
	 * Imposta il valore della proprieta' progressivo associata alla
	 * colonna PROGRESSIVO.
	 * @generated
	 */
	public void setProgressivo(java.math.BigDecimal val) {

		progressivo = val;

	}

	/**
	 * Legge il valore della proprieta' progressivo associata alla
	 * @generated
	 */
	public java.math.BigDecimal getProgressivo() {

		return progressivo;

	}

	/**
	 * store della proprieta' associata alla colonna DT_AZIONE
	 * @generated
	 */
	protected java.sql.Timestamp dtAzione;

	/**
	 * Imposta il valore della proprieta' dtAzione associata alla
	 * colonna DT_AZIONE.
	 * @generated
	 */
	public void setDtAzione(java.sql.Timestamp val) {

		if (val != null) {
			dtAzione = new java.sql.Timestamp(val.getTime());
		} else {
			dtAzione = null;
		}

	}

	/**
	 * Legge il valore della proprieta' dtAzione associata alla
	 * @generated
	 */
	public java.sql.Timestamp getDtAzione() {

		if (dtAzione != null) {
			return new java.sql.Timestamp(dtAzione.getTime());
		} else {
			return null;
		}

	}

	/**
	 * Costruttore di una chiave primaria vuota
	 * @generated 
	 */
	public SigitTAzioneComp4Pk() {
		//empty constructor
	}

	/**
	 * Costruttore di una chiave primaria a partire dai valori delle varie colonne
	 * @generated
	 */
	public SigitTAzioneComp4Pk(

			final java.math.BigDecimal codiceImpianto, final String idTipoComponente,
			final java.math.BigDecimal progressivo, final java.sql.Timestamp dtAzione

	) {

		this.setCodiceImpianto(codiceImpianto);

		this.setIdTipoComponente(idTipoComponente);

		this.setProgressivo(progressivo);

		this.setDtAzione(dtAzione);

	}

	/**
	 * Method 'equals'. 
	 * Due istanze di SigitTAzioneComp4Pk sono equals se i valori di tutti i campi coincidono.
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

		if (!(_other instanceof SigitTAzioneComp4Pk)) {
			return false;
		}

		final SigitTAzioneComp4Pk _cast = (SigitTAzioneComp4Pk) _other;

		if (codiceImpianto == null
				? _cast.getCodiceImpianto() != null
				: !codiceImpianto.equals(_cast.getCodiceImpianto())) {
			return false;
		}

		if (idTipoComponente == null
				? _cast.getIdTipoComponente() != null
				: !idTipoComponente.equals(_cast.getIdTipoComponente())) {
			return false;
		}

		if (progressivo == null ? _cast.getProgressivo() != null : !progressivo.equals(_cast.getProgressivo())) {
			return false;
		}

		if (dtAzione == null ? _cast.getDtAzione() != null : !dtAzione.equals(_cast.getDtAzione())) {
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

		if (idTipoComponente != null) {
			_hashCode = 29 * _hashCode + idTipoComponente.hashCode();
		}

		if (progressivo != null) {
			_hashCode = 29 * _hashCode + progressivo.hashCode();
		}

		if (dtAzione != null) {
			_hashCode = 29 * _hashCode + dtAzione.hashCode();
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

		ret.append("it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTAzioneComp4Pk: ");
		ret.append("codiceImpianto=" + codiceImpianto);

		ret.append("it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTAzioneComp4Pk: ");
		ret.append("idTipoComponente=" + idTipoComponente);

		ret.append("it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTAzioneComp4Pk: ");
		ret.append("progressivo=" + progressivo);

		ret.append("it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTAzioneComp4Pk: ");
		ret.append("dtAzione=" + dtAzione);

		return ret.toString();
	}
}
