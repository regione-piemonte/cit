package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Data transfer object relativo al DAO SigitDStelleDao.
 * @generated
 */
public class SigitDStelleDto extends SigitDStellePk {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna DESC_STELLE
	 * @generated
	 */
	protected String descStelle;

	/**
	 * Imposta il valore della proprieta' descStelle associata alla
	 * colonna DESC_STELLE.
	 * @generated
	 */
	public void setDescStelle(String val) {

		descStelle = val;

	}

	/**
	 * Legge il valore della proprieta' descStelle associata alla
	 * @generated
	 */
	public String getDescStelle() {

		return descStelle;

	}

	/**
	 * Crea una istanza di SigitDStellePk a partire dal valore dei campi chiave del DTO
	 * 
	 * @return SigitDStellePk
	 * @generated
	 */
	public SigitDStellePk createPk() {
		return new SigitDStellePk(idStelle);
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
