package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Data transfer object relativo al DAO SigitDStatoDistribDao.
 * @generated
 */
public class SigitDStatoDistribDto extends SigitDStatoDistribPk {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna DES_STATO_DISTRIB
	 * @generated
	 */
	protected String desStatoDistrib;

	/**
	 * Imposta il valore della proprieta' desStatoDistrib associata alla
	 * colonna DES_STATO_DISTRIB.
	 * @generated
	 */
	public void setDesStatoDistrib(String val) {

		desStatoDistrib = val;

	}

	/**
	 * Legge il valore della proprieta' desStatoDistrib associata alla
	 * @generated
	 */
	public String getDesStatoDistrib() {

		return desStatoDistrib;

	}

	/**
	 * Crea una istanza di SigitDStatoDistribPk a partire dal valore dei campi chiave del DTO
	 * 
	 * @return SigitDStatoDistribPk
	 * @generated
	 */
	public SigitDStatoDistribPk createPk() {
		return new SigitDStatoDistribPk(idStatoDistrib);
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
