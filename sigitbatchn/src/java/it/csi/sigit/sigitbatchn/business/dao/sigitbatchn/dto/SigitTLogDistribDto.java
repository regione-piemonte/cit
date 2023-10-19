package it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dto;

import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dao.*;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Data transfer object relativo al DAO SigitTLogDistribDao.
 * @generated
 */
public class SigitTLogDistribDto extends SigitTLogDistribPk {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna FK_IMPORT_DISTRIB
	 * @generated
	 */
	protected Integer fkImportDistrib;

	/**
	 * Imposta il valore della proprieta' fkImportDistrib associata alla
	 * colonna FK_IMPORT_DISTRIB.
	 * @generated
	 */
	public void setFkImportDistrib(Integer val) {

		fkImportDistrib = val;

	}

	/**
	 * Legge il valore della proprieta' fkImportDistrib associata alla
	 * @generated
	 */
	public Integer getFkImportDistrib() {

		return fkImportDistrib;

	}

	/**
	 * store della proprieta' associata alla colonna MSG_ERRORE
	 * @generated
	 */
	protected String msgErrore;

	/**
	 * Imposta il valore della proprieta' msgErrore associata alla
	 * colonna MSG_ERRORE.
	 * @generated
	 */
	public void setMsgErrore(String val) {

		msgErrore = val;

	}

	/**
	 * Legge il valore della proprieta' msgErrore associata alla
	 * @generated
	 */
	public String getMsgErrore() {

		return msgErrore;

	}

	/**
	 * Crea una istanza di SigitTLogDistribPk a partire dal valore dei campi chiave del DTO
	 * 
	 * @return SigitTLogDistribPk
	 * @generated
	 */
	public SigitTLogDistribPk createPk() {
		return new SigitTLogDistribPk(idLogDistrib);
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
