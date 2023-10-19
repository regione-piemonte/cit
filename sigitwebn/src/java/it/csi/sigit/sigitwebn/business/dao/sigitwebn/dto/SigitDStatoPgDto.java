package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Data transfer object relativo al DAO SigitDStatoPgDao.
 * @generated
 */
public class SigitDStatoPgDto extends SigitDStatoPgPk {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna DES_STATO_PG
	 * @generated
	 */
	protected String desStatoPg;

	/**
	 * Imposta il valore della proprieta' desStatoPg associata alla
	 * colonna DES_STATO_PG.
	 * @generated
	 */
	public void setDesStatoPg(String val) {

		desStatoPg = val;

	}

	/**
	 * Legge il valore della proprieta' desStatoPg associata alla
	 * @generated
	 */
	public String getDesStatoPg() {

		return desStatoPg;

	}

	/**
	 * Crea una istanza di SigitDStatoPgPk a partire dal valore dei campi chiave del DTO
	 * 
	 * @return SigitDStatoPgPk
	 * @generated
	 */
	public SigitDStatoPgPk createPk() {
		return new SigitDStatoPgPk(idStatoPg);
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
