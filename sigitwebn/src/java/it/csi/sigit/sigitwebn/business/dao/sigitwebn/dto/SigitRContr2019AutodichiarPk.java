package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Primary Key del DTO SigitRContr2019AutodichiarDto.
 * E' utilizzato per tutte le operazioni di lettura dati per chiave primaria. 
 * @generated
 */
public class SigitRContr2019AutodichiarPk implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna ID_CONTRATTO
	 * @generated
	 */
	protected Integer idContratto;

	/**
	 * Imposta il valore della proprieta' idContratto associata alla
	 * colonna ID_CONTRATTO.
	 * @generated
	 */
	public void setIdContratto(Integer val) {

		idContratto = val;

	}

	/**
	 * Legge il valore della proprieta' idContratto associata alla
	 * @generated
	 */
	public Integer getIdContratto() {

		return idContratto;

	}

	/**
	 * store della proprieta' associata alla colonna ID_AUTODICHIARAZIONE
	 * @generated
	 */
	protected Integer idAutodichiarazione;

	/**
	 * Imposta il valore della proprieta' idAutodichiarazione associata alla
	 * colonna ID_AUTODICHIARAZIONE.
	 * @generated
	 */
	public void setIdAutodichiarazione(Integer val) {

		idAutodichiarazione = val;

	}

	/**
	 * Legge il valore della proprieta' idAutodichiarazione associata alla
	 * @generated
	 */
	public Integer getIdAutodichiarazione() {

		return idAutodichiarazione;

	}

	/**
	 * store della proprieta' associata alla colonna FLG_NOMINA_CESSA
	 * @generated
	 */
	protected String flgNominaCessa;

	/**
	 * Imposta il valore della proprieta' flgNominaCessa associata alla
	 * colonna FLG_NOMINA_CESSA.
	 * @generated
	 */
	public void setFlgNominaCessa(String val) {

		flgNominaCessa = val;

	}

	/**
	 * Legge il valore della proprieta' flgNominaCessa associata alla
	 * @generated
	 */
	public String getFlgNominaCessa() {

		return flgNominaCessa;

	}

	/**
	 * Costruttore di una chiave primaria vuota
	 * @generated 
	 */
	public SigitRContr2019AutodichiarPk() {
		//empty constructor
	}

	/**
	 * Costruttore di una chiave primaria a partire dai valori delle varie colonne
	 * @generated
	 */
	public SigitRContr2019AutodichiarPk(

			final Integer idContratto, final Integer idAutodichiarazione, final String flgNominaCessa

	) {

		this.setIdContratto(idContratto);

		this.setIdAutodichiarazione(idAutodichiarazione);

		this.setFlgNominaCessa(flgNominaCessa);

	}

	/**
	 * Method 'equals'. 
	 * Due istanze di SigitRContr2019AutodichiarPk sono equals se i valori di tutti i campi coincidono.
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

		if (!(_other instanceof SigitRContr2019AutodichiarPk)) {
			return false;
		}

		final SigitRContr2019AutodichiarPk _cast = (SigitRContr2019AutodichiarPk) _other;

		if (idContratto == null ? _cast.getIdContratto() != null : !idContratto.equals(_cast.getIdContratto())) {
			return false;
		}

		if (idAutodichiarazione == null
				? _cast.getIdAutodichiarazione() != null
				: !idAutodichiarazione.equals(_cast.getIdAutodichiarazione())) {
			return false;
		}

		if (flgNominaCessa == null
				? _cast.getFlgNominaCessa() != null
				: !flgNominaCessa.equals(_cast.getFlgNominaCessa())) {
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

		if (idContratto != null) {
			_hashCode = 29 * _hashCode + idContratto.hashCode();
		}

		if (idAutodichiarazione != null) {
			_hashCode = 29 * _hashCode + idAutodichiarazione.hashCode();
		}

		if (flgNominaCessa != null) {
			_hashCode = 29 * _hashCode + flgNominaCessa.hashCode();
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

		ret.append("it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitRContr2019AutodichiarPk: ");
		ret.append("idContratto=" + idContratto);

		ret.append("it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitRContr2019AutodichiarPk: ");
		ret.append("idAutodichiarazione=" + idAutodichiarazione);

		ret.append("it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitRContr2019AutodichiarPk: ");
		ret.append("flgNominaCessa=" + flgNominaCessa);

		return ret.toString();
	}
}
