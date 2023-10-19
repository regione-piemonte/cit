package it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dto;

import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dao.*;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Data transfer object relativo al DAO SigitWrkLogMemoDao.
 * @generated
 */
public class SigitWrkLogMemoDto extends SigitWrkLogMemoPk {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna DT_LOG_MEMO
	 * @generated
	 */
	protected java.sql.Timestamp dtLogMemo;

	/**
	 * Imposta il valore della proprieta' dtLogMemo associata alla
	 * colonna DT_LOG_MEMO.
	 * @generated
	 */
	public void setDtLogMemo(java.sql.Timestamp val) {

		if (val != null) {
			dtLogMemo = new java.sql.Timestamp(val.getTime());
		} else {
			dtLogMemo = null;
		}

	}

	/**
	 * Legge il valore della proprieta' dtLogMemo associata alla
	 * @generated
	 */
	public java.sql.Timestamp getDtLogMemo() {

		if (dtLogMemo != null) {
			return new java.sql.Timestamp(dtLogMemo.getTime());
		} else {
			return null;
		}

	}

	/**
	 * store della proprieta' associata alla colonna DESC_LOG_MEMO
	 * @generated
	 */
	protected String descLogMemo;

	/**
	 * Imposta il valore della proprieta' descLogMemo associata alla
	 * colonna DESC_LOG_MEMO.
	 * @generated
	 */
	public void setDescLogMemo(String val) {

		descLogMemo = val;

	}

	/**
	 * Legge il valore della proprieta' descLogMemo associata alla
	 * @generated
	 */
	public String getDescLogMemo() {

		return descLogMemo;

	}

	/**
	 * Crea una istanza di SigitWrkLogMemoPk a partire dal valore dei campi chiave del DTO
	 * 
	 * @return SigitWrkLogMemoPk
	 * @generated
	 */
	public SigitWrkLogMemoPk createPk() {
		return new SigitWrkLogMemoPk(idLogMemo);
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
