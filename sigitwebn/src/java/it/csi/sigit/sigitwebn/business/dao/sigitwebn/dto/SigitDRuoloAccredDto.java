package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Data transfer object relativo al DAO SigitDRuoloAccredDao.
 * @generated
 */
public class SigitDRuoloAccredDto extends SigitDRuoloAccredPk {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna DES_RUOLO_ACCRED
	 * @generated
	 */
	protected String desRuoloAccred;

	/**
	 * Imposta il valore della proprieta' desRuoloAccred associata alla
	 * colonna DES_RUOLO_ACCRED.
	 * @generated
	 */
	public void setDesRuoloAccred(String val) {

		desRuoloAccred = val;

	}

	/**
	 * Legge il valore della proprieta' desRuoloAccred associata alla
	 * @generated
	 */
	public String getDesRuoloAccred() {

		return desRuoloAccred;

	}

	/**
	 * Crea una istanza di SigitDRuoloAccredPk a partire dal valore dei campi chiave del DTO
	 * 
	 * @return SigitDRuoloAccredPk
	 * @generated
	 */
	public SigitDRuoloAccredPk createPk() {
		return new SigitDRuoloAccredPk(idRuoloAccred);
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
