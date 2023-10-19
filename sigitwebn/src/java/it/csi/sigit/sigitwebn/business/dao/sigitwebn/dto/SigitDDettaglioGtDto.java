package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Data transfer object relativo al DAO SigitDDettaglioGtDao.
 * @generated
 */
public class SigitDDettaglioGtDto extends SigitDDettaglioGtPk {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna DES_DETTAGLIO_GT
	 * @generated
	 */
	protected String desDettaglioGt;

	/**
	 * Imposta il valore della proprieta' desDettaglioGt associata alla
	 * colonna DES_DETTAGLIO_GT.
	 * @generated
	 */
	public void setDesDettaglioGt(String val) {

		desDettaglioGt = val;

	}

	/**
	 * Legge il valore della proprieta' desDettaglioGt associata alla
	 * @generated
	 */
	public String getDesDettaglioGt() {

		return desDettaglioGt;

	}

	/**
	 * Crea una istanza di SigitDDettaglioGtPk a partire dal valore dei campi chiave del DTO
	 * 
	 * @return SigitDDettaglioGtPk
	 * @generated
	 */
	public SigitDDettaglioGtPk createPk() {
		return new SigitDDettaglioGtPk(idDettaglioGt);
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
