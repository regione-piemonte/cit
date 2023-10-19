package it.csi.sigit.sigitext.business.dao.sigitextdao.dto;

import java.io.Serializable;

/**
 * Primary Key del DTO SigitTRappDettaglioDto.
 * E' utilizzato per tutte le operazioni di lettura dati per chiave primaria. 
 * @generated
 */
public class SigitTRappDettaglioPk implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna ID_RAPPORTO_DETTAGLIO
	 * @generated
	 */
	protected java.math.BigDecimal idRapportoDettaglio;

	/**
	 * Imposta il valore della proprieta' idRapportoDettaglio associata alla
	 * colonna ID_RAPPORTO_DETTAGLIO.
	 * @generated
	 */
	public void setIdRapportoDettaglio(java.math.BigDecimal val) {

		idRapportoDettaglio = val;

	}

	/**
	 * Legge il valore della proprieta' idRapportoDettaglio associata alla
	 * @generated
	 */
	public java.math.BigDecimal getIdRapportoDettaglio() {

		return idRapportoDettaglio;

	}

	/**
	 * Costruttore di una chiave primaria vuota
	 * @generated 
	 */
	public SigitTRappDettaglioPk() {
		//empty constructor
	}

	/**
	 * Costruttore di una chiave primaria a partire dai valori delle varie colonne
	 * @generated
	 */
	public SigitTRappDettaglioPk(

			final java.math.BigDecimal idRapportoDettaglio

	) {

		this.setIdRapportoDettaglio(idRapportoDettaglio);

	}

	/**
	 * Method 'equals'. 
	 * Due istanze di SigitTRappDettaglioPk sono equals se i valori di tutti i campi coincidono.
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

		if (!(_other instanceof SigitTRappDettaglioPk)) {
			return false;
		}

		final SigitTRappDettaglioPk _cast = (SigitTRappDettaglioPk) _other;

		if (idRapportoDettaglio == null
				? _cast.getIdRapportoDettaglio() != null
				: !idRapportoDettaglio.equals(_cast.getIdRapportoDettaglio())) {
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

		if (idRapportoDettaglio != null) {
			_hashCode = 29 * _hashCode + idRapportoDettaglio.hashCode();
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

		ret.append("it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTRappDettaglioPk: ");
		ret.append("idRapportoDettaglio=" + idRapportoDettaglio);

		return ret.toString();
	}
}
