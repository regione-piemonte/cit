package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Data transfer object relativo al DAO SigitTGraffaturaDao.
 * @generated
 */
public class SigitTGraffaturaDto extends SigitTGraffaturaPk {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna DT_CANCELLAZIONE
	 * @generated
	 */
	protected java.sql.Timestamp dtCancellazione;

	/**
	 * Imposta il valore della proprieta' dtCancellazione associata alla
	 * colonna DT_CANCELLAZIONE.
	 * @generated
	 */
	public void setDtCancellazione(java.sql.Timestamp val) {

		if (val != null) {
			dtCancellazione = new java.sql.Timestamp(val.getTime());
		} else {
			dtCancellazione = null;
		}

	}

	/**
	 * Legge il valore della proprieta' dtCancellazione associata alla
	 * @generated
	 */
	public java.sql.Timestamp getDtCancellazione() {

		if (dtCancellazione != null) {
			return new java.sql.Timestamp(dtCancellazione.getTime());
		} else {
			return null;
		}

	}

	/**
	 * store della proprieta' associata alla colonna UTENTE_ULT_MOD
	 * @generated
	 */
	protected String utenteUltMod;

	/**
	 * Imposta il valore della proprieta' utenteUltMod associata alla
	 * colonna UTENTE_ULT_MOD.
	 * @generated
	 */
	public void setUtenteUltMod(String val) {

		utenteUltMod = val;

	}

	/**
	 * Legge il valore della proprieta' utenteUltMod associata alla
	 * @generated
	 */
	public String getUtenteUltMod() {

		return utenteUltMod;

	}

	/**
	 * Crea una istanza di SigitTGraffaturaPk a partire dal valore dei campi chiave del DTO
	 * 
	 * @return SigitTGraffaturaPk
	 * @generated
	 */
	public SigitTGraffaturaPk createPk() {
		return new SigitTGraffaturaPk(idGraffatura, codiceImpianto, dtInserimento);
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
