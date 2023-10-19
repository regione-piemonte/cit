package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Primary Key del DTO SigitTRappControlloDto.
 * E' utilizzato per tutte le operazioni di lettura dati per chiave primaria. 
 * @generated
 */
public class SigitTRappControlloPk implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna ID_RAPPORTO_CONTROLLO
	 * @generated
	 */
	protected java.math.BigDecimal idRapportoControllo;

	/**
	 * Imposta il valore della proprieta' idRapportoControllo associata alla
	 * colonna ID_RAPPORTO_CONTROLLO.
	 * @generated
	 */
	public void setIdRapportoControllo(java.math.BigDecimal val) {

		idRapportoControllo = val;

	}

	/**
	 * Legge il valore della proprieta' idRapportoControllo associata alla
	 * @generated
	 */
	public java.math.BigDecimal getIdRapportoControllo() {

		return idRapportoControllo;

	}

	/**
	 * Costruttore di una chiave primaria vuota
	 * @generated 
	 */
	public SigitTRappControlloPk() {
		//empty constructor
	}

	/**
	 * Costruttore di una chiave primaria a partire dai valori delle varie colonne
	 * @generated
	 */
	public SigitTRappControlloPk(

			final java.math.BigDecimal idRapportoControllo

	) {

		this.setIdRapportoControllo(idRapportoControllo);

	}

	/**
	 * Method 'equals'. 
	 * Due istanze di SigitTRappControlloPk sono equals se i valori di tutti i campi coincidono.
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

		if (!(_other instanceof SigitTRappControlloPk)) {
			return false;
		}

		final SigitTRappControlloPk _cast = (SigitTRappControlloPk) _other;

		if (idRapportoControllo == null
				? _cast.getIdRapportoControllo() != null
				: !idRapportoControllo.equals(_cast.getIdRapportoControllo())) {
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

		if (idRapportoControllo != null) {
			_hashCode = 29 * _hashCode + idRapportoControllo.hashCode();
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

		ret.append("it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTRappControlloPk: ");
		ret.append("idRapportoControllo=" + idRapportoControllo);

		return ret.toString();
	}
}
