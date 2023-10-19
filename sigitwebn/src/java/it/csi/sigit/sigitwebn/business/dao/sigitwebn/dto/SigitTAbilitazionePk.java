package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Primary Key del DTO SigitTAbilitazioneDto.
 * E' utilizzato per tutte le operazioni di lettura dati per chiave primaria. 
 * @generated
 */
public class SigitTAbilitazionePk implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna ID_RUOLO_PA
	 * @generated
	 */
	protected Integer idRuoloPa;

	/**
	 * Imposta il valore della proprieta' idRuoloPa associata alla
	 * colonna ID_RUOLO_PA.
	 * @generated
	 */
	public void setIdRuoloPa(Integer val) {

		idRuoloPa = val;

	}

	/**
	 * Legge il valore della proprieta' idRuoloPa associata alla
	 * @generated
	 */
	public Integer getIdRuoloPa() {

		return idRuoloPa;

	}

	/**
	 * store della proprieta' associata alla colonna ISTAT_ABILITAZIONE
	 * @generated
	 */
	protected String istatAbilitazione;

	/**
	 * Imposta il valore della proprieta' istatAbilitazione associata alla
	 * colonna ISTAT_ABILITAZIONE.
	 * @generated
	 */
	public void setIstatAbilitazione(String val) {

		istatAbilitazione = val;

	}

	/**
	 * Legge il valore della proprieta' istatAbilitazione associata alla
	 * @generated
	 */
	public String getIstatAbilitazione() {

		return istatAbilitazione;

	}

	/**
	 * Costruttore di una chiave primaria vuota
	 * @generated 
	 */
	public SigitTAbilitazionePk() {
		//empty constructor
	}

	/**
	 * Costruttore di una chiave primaria a partire dai valori delle varie colonne
	 * @generated
	 */
	public SigitTAbilitazionePk(

			final Integer idRuoloPa, final String istatAbilitazione

	) {

		this.setIdRuoloPa(idRuoloPa);

		this.setIstatAbilitazione(istatAbilitazione);

	}

	/**
	 * Method 'equals'. 
	 * Due istanze di SigitTAbilitazionePk sono equals se i valori di tutti i campi coincidono.
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

		if (!(_other instanceof SigitTAbilitazionePk)) {
			return false;
		}

		final SigitTAbilitazionePk _cast = (SigitTAbilitazionePk) _other;

		if (idRuoloPa == null ? _cast.getIdRuoloPa() != null : !idRuoloPa.equals(_cast.getIdRuoloPa())) {
			return false;
		}

		if (istatAbilitazione == null
				? _cast.getIstatAbilitazione() != null
				: !istatAbilitazione.equals(_cast.getIstatAbilitazione())) {
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

		if (idRuoloPa != null) {
			_hashCode = 29 * _hashCode + idRuoloPa.hashCode();
		}

		if (istatAbilitazione != null) {
			_hashCode = 29 * _hashCode + istatAbilitazione.hashCode();
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

		ret.append("it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTAbilitazionePk: ");
		ret.append("idRuoloPa=" + idRuoloPa);

		ret.append("it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTAbilitazionePk: ");
		ret.append("istatAbilitazione=" + istatAbilitazione);

		return ret.toString();
	}
}
