package it.csi.sigit.sigitext.business.dao.sigitextdao.dto;

import java.io.Serializable;

/**
 * Primary Key del DTO SigitLAccessoDto.
 * E' utilizzato per tutte le operazioni di lettura dati per chiave primaria. 
 * @generated
 */
public class SigitLAccessoPk implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna DT_ACCESSO
	 * @generated
	 */
	protected java.sql.Timestamp dtAccesso;

	/**
	 * Imposta il valore della proprieta' dtAccesso associata alla
	 * colonna DT_ACCESSO.
	 * @generated
	 */
	public void setDtAccesso(java.sql.Timestamp val) {

		if (val != null) {
			dtAccesso = new java.sql.Timestamp(val.getTime());
		} else {
			dtAccesso = null;
		}

	}

	/**
	 * Legge il valore della proprieta' dtAccesso associata alla
	 * @generated
	 */
	public java.sql.Timestamp getDtAccesso() {

		if (dtAccesso != null) {
			return new java.sql.Timestamp(dtAccesso.getTime());
		} else {
			return null;
		}

	}

	/**
	 * store della proprieta' associata alla colonna CODICE_FISCALE
	 * @generated
	 */
	protected String codiceFiscale;

	/**
	 * Imposta il valore della proprieta' codiceFiscale associata alla
	 * colonna CODICE_FISCALE.
	 * @generated
	 */
	public void setCodiceFiscale(String val) {

		codiceFiscale = val;

	}

	/**
	 * Legge il valore della proprieta' codiceFiscale associata alla
	 * @generated
	 */
	public String getCodiceFiscale() {

		return codiceFiscale;

	}

	/**
	 * Costruttore di una chiave primaria vuota
	 * @generated 
	 */
	public SigitLAccessoPk() {
		//empty constructor
	}

	/**
	 * Costruttore di una chiave primaria a partire dai valori delle varie colonne
	 * @generated
	 */
	public SigitLAccessoPk(

			final java.sql.Timestamp dtAccesso, final String codiceFiscale

	) {

		this.setDtAccesso(dtAccesso);

		this.setCodiceFiscale(codiceFiscale);

	}

	/**
	 * Method 'equals'. 
	 * Due istanze di SigitLAccessoPk sono equals se i valori di tutti i campi coincidono.
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

		if (!(_other instanceof SigitLAccessoPk)) {
			return false;
		}

		final SigitLAccessoPk _cast = (SigitLAccessoPk) _other;

		if (dtAccesso == null ? _cast.getDtAccesso() != null : !dtAccesso.equals(_cast.getDtAccesso())) {
			return false;
		}

		if (codiceFiscale == null
				? _cast.getCodiceFiscale() != null
				: !codiceFiscale.equals(_cast.getCodiceFiscale())) {
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

		if (dtAccesso != null) {
			_hashCode = 29 * _hashCode + dtAccesso.hashCode();
		}

		if (codiceFiscale != null) {
			_hashCode = 29 * _hashCode + codiceFiscale.hashCode();
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

		ret.append("it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitLAccessoPk: ");
		ret.append("dtAccesso=" + dtAccesso);

		ret.append("it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitLAccessoPk: ");
		ret.append("codiceFiscale=" + codiceFiscale);

		return ret.toString();
	}
}
