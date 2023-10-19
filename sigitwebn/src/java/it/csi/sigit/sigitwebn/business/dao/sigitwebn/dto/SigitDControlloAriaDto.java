package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Data transfer object relativo al DAO SigitDControlloAriaDao.
 * @generated
 */
public class SigitDControlloAriaDto extends SigitDControlloAriaPk {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna DESC_CONTROLLO_ARIA
	 * @generated
	 */
	protected String descControlloAria;

	/**
	 * Imposta il valore della proprieta' descControlloAria associata alla
	 * colonna DESC_CONTROLLO_ARIA.
	 * @generated
	 */
	public void setDescControlloAria(String val) {

		descControlloAria = val;

	}

	/**
	 * Legge il valore della proprieta' descControlloAria associata alla
	 * @generated
	 */
	public String getDescControlloAria() {

		return descControlloAria;

	}

	/**
	 * Crea una istanza di SigitDControlloAriaPk a partire dal valore dei campi chiave del DTO
	 * 
	 * @return SigitDControlloAriaPk
	 * @generated
	 */
	public SigitDControlloAriaPk createPk() {
		return new SigitDControlloAriaPk(idControlloAria);
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
