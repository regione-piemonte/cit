package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Primary Key del DTO SigitDDettaglioVmDto.
 * E' utilizzato per tutte le operazioni di lettura dati per chiave primaria. 
 * @generated
 */
public class SigitDDettaglioVmPk implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna ID_DETTAGLIO_VM
	 * @generated
	 */
	protected java.math.BigDecimal idDettaglioVm;

	/**
	 * Imposta il valore della proprieta' idDettaglioVm associata alla
	 * colonna ID_DETTAGLIO_VM.
	 * @generated
	 */
	public void setIdDettaglioVm(java.math.BigDecimal val) {

		idDettaglioVm = val;

	}

	/**
	 * Legge il valore della proprieta' idDettaglioVm associata alla
	 * @generated
	 */
	public java.math.BigDecimal getIdDettaglioVm() {

		return idDettaglioVm;

	}

	/**
	 * Costruttore di una chiave primaria vuota
	 * @generated 
	 */
	public SigitDDettaglioVmPk() {
		//empty constructor
	}

	/**
	 * Costruttore di una chiave primaria a partire dai valori delle varie colonne
	 * @generated
	 */
	public SigitDDettaglioVmPk(

			final java.math.BigDecimal idDettaglioVm

	) {

		this.setIdDettaglioVm(idDettaglioVm);

	}

	/**
	 * Method 'equals'. 
	 * Due istanze di SigitDDettaglioVmPk sono equals se i valori di tutti i campi coincidono.
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

		if (!(_other instanceof SigitDDettaglioVmPk)) {
			return false;
		}

		final SigitDDettaglioVmPk _cast = (SigitDDettaglioVmPk) _other;

		if (idDettaglioVm == null
				? _cast.getIdDettaglioVm() != null
				: !idDettaglioVm.equals(_cast.getIdDettaglioVm())) {
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

		if (idDettaglioVm != null) {
			_hashCode = 29 * _hashCode + idDettaglioVm.hashCode();
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

		ret.append("it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitDDettaglioVmPk: ");
		ret.append("idDettaglioVm=" + idDettaglioVm);

		return ret.toString();
	}
}
