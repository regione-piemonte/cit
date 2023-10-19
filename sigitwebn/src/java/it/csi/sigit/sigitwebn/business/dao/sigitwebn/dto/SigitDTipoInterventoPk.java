package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Primary Key del DTO SigitDTipoInterventoDto.
 * E' utilizzato per tutte le operazioni di lettura dati per chiave primaria. 
 * @generated
 */
public class SigitDTipoInterventoPk implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna ID_TIPO_INTERVENTO
	 * @generated
	 */
	protected java.math.BigDecimal idTipoIntervento;

	/**
	 * Imposta il valore della proprieta' idTipoIntervento associata alla
	 * colonna ID_TIPO_INTERVENTO.
	 * @generated
	 */
	public void setIdTipoIntervento(java.math.BigDecimal val) {

		idTipoIntervento = val;

	}

	/**
	 * Legge il valore della proprieta' idTipoIntervento associata alla
	 * @generated
	 */
	public java.math.BigDecimal getIdTipoIntervento() {

		return idTipoIntervento;

	}

	/**
	 * Costruttore di una chiave primaria vuota
	 * @generated 
	 */
	public SigitDTipoInterventoPk() {
		//empty constructor
	}

	/**
	 * Costruttore di una chiave primaria a partire dai valori delle varie colonne
	 * @generated
	 */
	public SigitDTipoInterventoPk(

			final java.math.BigDecimal idTipoIntervento

	) {

		this.setIdTipoIntervento(idTipoIntervento);

	}

	/**
	 * Method 'equals'. 
	 * Due istanze di SigitDTipoInterventoPk sono equals se i valori di tutti i campi coincidono.
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

		if (!(_other instanceof SigitDTipoInterventoPk)) {
			return false;
		}

		final SigitDTipoInterventoPk _cast = (SigitDTipoInterventoPk) _other;

		if (idTipoIntervento == null
				? _cast.getIdTipoIntervento() != null
				: !idTipoIntervento.equals(_cast.getIdTipoIntervento())) {
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

		if (idTipoIntervento != null) {
			_hashCode = 29 * _hashCode + idTipoIntervento.hashCode();
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

		ret.append("it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitDTipoInterventoPk: ");
		ret.append("idTipoIntervento=" + idTipoIntervento);

		return ret.toString();
	}
}
