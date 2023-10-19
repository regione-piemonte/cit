package it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dto;

import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dao.*;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Primary Key del DTO SigitTAccertamentoDto.
 * E' utilizzato per tutte le operazioni di lettura dati per chiave primaria. 
 * @generated
 */
public class SigitTAccertamentoPk implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna ID_ACCERTAMENTO
	 * @generated
	 */
	protected Integer idAccertamento;

	/**
	 * Imposta il valore della proprieta' idAccertamento associata alla
	 * colonna ID_ACCERTAMENTO.
	 * @generated
	 */
	public void setIdAccertamento(Integer val) {

		idAccertamento = val;

	}

	/**
	 * Legge il valore della proprieta' idAccertamento associata alla
	 * @generated
	 */
	public Integer getIdAccertamento() {

		return idAccertamento;

	}

	/**
	 * Costruttore di una chiave primaria vuota
	 * @generated 
	 */
	public SigitTAccertamentoPk() {
		//empty constructor
	}

	/**
	 * Costruttore di una chiave primaria a partire dai valori delle varie colonne
	 * @generated
	 */
	public SigitTAccertamentoPk(

			final Integer idAccertamento

	) {

		this.setIdAccertamento(idAccertamento);

	}

	/**
	 * Method 'equals'. 
	 * Due istanze di SigitTAccertamentoPk sono equals se i valori di tutti i campi coincidono.
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

		if (!(_other instanceof SigitTAccertamentoPk)) {
			return false;
		}

		final SigitTAccertamentoPk _cast = (SigitTAccertamentoPk) _other;

		if (idAccertamento == null
				? _cast.getIdAccertamento() != null
				: !idAccertamento.equals(_cast.getIdAccertamento())) {
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

		if (idAccertamento != null) {
			_hashCode = 29 * _hashCode + idAccertamento.hashCode();
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

		ret.append("it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dto.SigitTAccertamentoPk: ");
		ret.append("idAccertamento=" + idAccertamento);

		return ret.toString();
	}
}
