package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Data transfer object relativo al DAO SigitTAzioneContrattoDao.
 * @generated
 */
public class SigitTAzioneContrattoDto extends SigitTAzioneContrattoPk {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna CF_UTENTE_AZIONE
	 * @generated
	 */
	protected String cfUtenteAzione;

	/**
	 * Imposta il valore della proprieta' cfUtenteAzione associata alla
	 * colonna CF_UTENTE_AZIONE.
	 * @generated
	 */
	public void setCfUtenteAzione(String val) {

		cfUtenteAzione = val;

	}

	/**
	 * Legge il valore della proprieta' cfUtenteAzione associata alla
	 * @generated
	 */
	public String getCfUtenteAzione() {

		return cfUtenteAzione;

	}

	/**
	 * store della proprieta' associata alla colonna DESCRIZIONE_AZIONE
	 * @generated
	 */
	protected String descrizioneAzione;

	/**
	 * Imposta il valore della proprieta' descrizioneAzione associata alla
	 * colonna DESCRIZIONE_AZIONE.
	 * @generated
	 */
	public void setDescrizioneAzione(String val) {

		descrizioneAzione = val;

	}

	/**
	 * Legge il valore della proprieta' descrizioneAzione associata alla
	 * @generated
	 */
	public String getDescrizioneAzione() {

		return descrizioneAzione;

	}

	/**
	 * store della proprieta' associata alla colonna OLD_DATA_FINE
	 * @generated
	 */
	protected java.sql.Date oldDataFine;

	/**
	 * Imposta il valore della proprieta' oldDataFine associata alla
	 * colonna OLD_DATA_FINE.
	 * @generated
	 */
	public void setOldDataFine(java.sql.Date val) {

		if (val != null) {
			oldDataFine = new java.sql.Date(val.getTime());
		} else {
			oldDataFine = null;
		}

	}

	/**
	 * Legge il valore della proprieta' oldDataFine associata alla
	 * @generated
	 */
	public java.sql.Date getOldDataFine() {

		if (oldDataFine != null) {
			return new java.sql.Date(oldDataFine.getTime());
		} else {
			return null;
		}

	}

	/**
	 * Crea una istanza di SigitTAzioneContrattoPk a partire dal valore dei campi chiave del DTO
	 * 
	 * @return SigitTAzioneContrattoPk
	 * @generated
	 */
	public SigitTAzioneContrattoPk createPk() {
		return new SigitTAzioneContrattoPk(idContratto, dtAzione);
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
