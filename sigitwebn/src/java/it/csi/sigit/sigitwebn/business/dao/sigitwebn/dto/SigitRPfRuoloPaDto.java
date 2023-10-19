package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Data transfer object relativo al DAO SigitRPfRuoloPaDao.
 * @generated
 */
public class SigitRPfRuoloPaDto extends SigitRPfRuoloPaPk {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna DATA_FINE
	 * @generated
	 */
	protected java.sql.Date dataFine;

	/**
	 * Imposta il valore della proprieta' dataFine associata alla
	 * colonna DATA_FINE.
	 * @generated
	 */
	public void setDataFine(java.sql.Date val) {

		if (val != null) {
			dataFine = new java.sql.Date(val.getTime());
		} else {
			dataFine = null;
		}

	}

	/**
	 * Legge il valore della proprieta' dataFine associata alla
	 * @generated
	 */
	public java.sql.Date getDataFine() {

		if (dataFine != null) {
			return new java.sql.Date(dataFine.getTime());
		} else {
			return null;
		}

	}

	/**
	 * store della proprieta' associata alla colonna NOTE
	 * @generated
	 */
	protected String note;

	/**
	 * Imposta il valore della proprieta' note associata alla
	 * colonna NOTE.
	 * @generated
	 */
	public void setNote(String val) {

		note = val;

	}

	/**
	 * Legge il valore della proprieta' note associata alla
	 * @generated
	 */
	public String getNote() {

		return note;

	}

	/**
	 * store della proprieta' associata alla colonna DESC_ABILITAZIONE
	 * @generated
	 */
	protected String descAbilitazione;

	/**
	 * Imposta il valore della proprieta' descAbilitazione associata alla
	 * colonna DESC_ABILITAZIONE.
	 * @generated
	 */
	public void setDescAbilitazione(String val) {

		descAbilitazione = val;

	}

	/**
	 * Legge il valore della proprieta' descAbilitazione associata alla
	 * @generated
	 */
	public String getDescAbilitazione() {

		return descAbilitazione;

	}

	/**
	 * Crea una istanza di SigitRPfRuoloPaPk a partire dal valore dei campi chiave del DTO
	 * 
	 * @return SigitRPfRuoloPaPk
	 * @generated
	 */
	public SigitRPfRuoloPaPk createPk() {
		return new SigitRPfRuoloPaPk(idPersonaFisica, idRuoloPa, istatAbilitazione, dataInizio);
	}

	/**
	 * la semantica dell'equals del DTO e' la stessa della PK
	 * (ovvero della superclasse).
	 * @param other l'oggetto con cui effettuare il confronto
	 * @return true se i due oggetti sono semanticamente da considerarsi uguali
	 */
	public boolean equals(Object other) {
		return super.equals(other);
	}

	/**
	 * la semantica dell'hashCode del DTO e' la stessa della PK
	 * (ovvero della superclasse).
	 * 
	 * @return int
	 */
	public int hashCode() {
		return super.hashCode();
	}

}
