package it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dto;

import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dao.*;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Data transfer object relativo al DAO SigitWrkLogMemoTuDao.
 * @generated
 */
public class SigitWrkLogMemoTuDto extends SigitWrkLogMemoTuPk {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna DT_LOG_MEMO_PTU
	 * @generated
	 */
	protected java.sql.Timestamp dtLogMemoPtu;

	/**
	 * Imposta il valore della proprieta' dtLogMemoPtu associata alla
	 * colonna DT_LOG_MEMO_PTU.
	 * @generated
	 */
	public void setDtLogMemoPtu(java.sql.Timestamp val) {

		if (val != null) {
			dtLogMemoPtu = new java.sql.Timestamp(val.getTime());
		} else {
			dtLogMemoPtu = null;
		}

	}

	/**
	 * Legge il valore della proprieta' dtLogMemoPtu associata alla
	 * @generated
	 */
	public java.sql.Timestamp getDtLogMemoPtu() {

		if (dtLogMemoPtu != null) {
			return new java.sql.Timestamp(dtLogMemoPtu.getTime());
		} else {
			return null;
		}

	}

	/**
	 * store della proprieta' associata alla colonna NOTE_LOG_MEMO_PTU
	 * @generated
	 */
	protected String noteLogMemoPtu;

	/**
	 * Imposta il valore della proprieta' noteLogMemoPtu associata alla
	 * colonna NOTE_LOG_MEMO_PTU.
	 * @generated
	 */
	public void setNoteLogMemoPtu(String val) {

		noteLogMemoPtu = val;

	}

	/**
	 * Legge il valore della proprieta' noteLogMemoPtu associata alla
	 * @generated
	 */
	public String getNoteLogMemoPtu() {

		return noteLogMemoPtu;

	}

	/**
	 * store della proprieta' associata alla colonna MESSAGGIO_LOG_MEMO_PTU
	 * @generated
	 */
	protected String messaggioLogMemoPtu;

	/**
	 * Imposta il valore della proprieta' messaggioLogMemoPtu associata alla
	 * colonna MESSAGGIO_LOG_MEMO_PTU.
	 * @generated
	 */
	public void setMessaggioLogMemoPtu(String val) {

		messaggioLogMemoPtu = val;

	}

	/**
	 * Legge il valore della proprieta' messaggioLogMemoPtu associata alla
	 * @generated
	 */
	public String getMessaggioLogMemoPtu() {

		return messaggioLogMemoPtu;

	}

	/**
	 * store della proprieta' associata alla colonna ESITO_LOG_MEMO_PTU
	 * @generated
	 */
	protected String esitoLogMemoPtu;

	/**
	 * Imposta il valore della proprieta' esitoLogMemoPtu associata alla
	 * colonna ESITO_LOG_MEMO_PTU.
	 * @generated
	 */
	public void setEsitoLogMemoPtu(String val) {

		esitoLogMemoPtu = val;

	}

	/**
	 * Legge il valore della proprieta' esitoLogMemoPtu associata alla
	 * @generated
	 */
	public String getEsitoLogMemoPtu() {

		return esitoLogMemoPtu;

	}

	/**
	 * Crea una istanza di SigitWrkLogMemoTuPk a partire dal valore dei campi chiave del DTO
	 * 
	 * @return SigitWrkLogMemoTuPk
	 * @generated
	 */
	public SigitWrkLogMemoTuPk createPk() {
		return new SigitWrkLogMemoTuPk(idLogMemoPtu);
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
