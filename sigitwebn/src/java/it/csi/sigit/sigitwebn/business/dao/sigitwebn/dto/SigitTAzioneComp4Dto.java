package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Data transfer object relativo al DAO SigitTAzioneComp4Dao.
 * @generated
 */
public class SigitTAzioneComp4Dto extends SigitTAzioneComp4Pk {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna DT_INSTALL
	 * @generated
	 */
	protected java.sql.Date dtInstall;

	/**
	 * Imposta il valore della proprieta' dtInstall associata alla
	 * colonna DT_INSTALL.
	 * @generated
	 */
	public void setDtInstall(java.sql.Date val) {

		if (val != null) {
			dtInstall = new java.sql.Date(val.getTime());
		} else {
			dtInstall = null;
		}

	}

	/**
	 * Legge il valore della proprieta' dtInstall associata alla
	 * @generated
	 */
	public java.sql.Date getDtInstall() {

		if (dtInstall != null) {
			return new java.sql.Date(dtInstall.getTime());
		} else {
			return null;
		}

	}

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
	 * Crea una istanza di SigitTAzioneComp4Pk a partire dal valore dei campi chiave del DTO
	 * 
	 * @return SigitTAzioneComp4Pk
	 * @generated
	 */
	public SigitTAzioneComp4Pk createPk() {
		return new SigitTAzioneComp4Pk(codiceImpianto, idTipoComponente, progressivo, dtAzione);
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
