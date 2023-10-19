package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Data transfer object relativo al DAO SigitDClassDPR660_96Dao.
 * @generated
 */
public class SigitDClassDPR660_96Dto extends SigitDClassDPR660_96Pk {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna DES_CLASS
	 * @generated
	 */
	protected String desClass;

	/**
	 * Imposta il valore della proprieta' desClass associata alla
	 * colonna DES_CLASS.
	 * @generated
	 */
	public void setDesClass(String val) {

		desClass = val;

	}

	/**
	 * Legge il valore della proprieta' desClass associata alla
	 * @generated
	 */
	public String getDesClass() {

		return desClass;

	}

	/**
	 * Crea una istanza di SigitDClassDPR660_96Pk a partire dal valore dei campi chiave del DTO
	 * 
	 * @return SigitDClassDPR660_96Pk
	 * @generated
	 */
	public SigitDClassDPR660_96Pk createPk() {
		return new SigitDClassDPR660_96Pk(idClass);
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
