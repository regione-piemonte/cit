package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Primary Key del DTO SigitDStatoAccertamentoDto.
 * E' utilizzato per tutte le operazioni di lettura dati per chiave primaria. 
 * @generated
 */
public class SigitDStatoAccertamentoPk implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna ID_STATO_ACCERTAMENTO
	 * @generated
	 */
	protected Integer idStatoAccertamento;

	/**
	 * Imposta il valore della proprieta' idStatoAccertamento associata alla
	 * colonna ID_STATO_ACCERTAMENTO.
	 * @generated
	 */
	public void setIdStatoAccertamento(Integer val) {

		idStatoAccertamento = val;

	}

	/**
	 * Legge il valore della proprieta' idStatoAccertamento associata alla
	 * @generated
	 */
	public Integer getIdStatoAccertamento() {

		return idStatoAccertamento;

	}

	/**
	 * Costruttore di una chiave primaria vuota
	 * @generated 
	 */
	public SigitDStatoAccertamentoPk() {
		//empty constructor
	}

	/**
	 * Costruttore di una chiave primaria a partire dai valori delle varie colonne
	 * @generated
	 */
	public SigitDStatoAccertamentoPk(

			final Integer idStatoAccertamento

	) {

		this.setIdStatoAccertamento(idStatoAccertamento);

	}

	/**
	 * Method 'equals'. 
	 * Due istanze di SigitDStatoAccertamentoPk sono equals se i valori di tutti i campi coincidono.
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

		if (!(_other instanceof SigitDStatoAccertamentoPk)) {
			return false;
		}

		final SigitDStatoAccertamentoPk _cast = (SigitDStatoAccertamentoPk) _other;

		if (idStatoAccertamento == null
				? _cast.getIdStatoAccertamento() != null
				: !idStatoAccertamento.equals(_cast.getIdStatoAccertamento())) {
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

		if (idStatoAccertamento != null) {
			_hashCode = 29 * _hashCode + idStatoAccertamento.hashCode();
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

		ret.append("it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitDStatoAccertamentoPk: ");
		ret.append("idStatoAccertamento=" + idStatoAccertamento);

		return ret.toString();
	}
}
