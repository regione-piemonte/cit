package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Data transfer object relativo al DAO SigitDStatoImpDao.
 * @generated
 */
public class SigitDStatoImpDto extends SigitDStatoImpPk {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna DES_STATO
	 * @generated
	 */
	protected String desStato;

	/**
	 * Imposta il valore della proprieta' desStato associata alla
	 * colonna DES_STATO.
	 * @generated
	 */
	public void setDesStato(String val) {

		desStato = val;

	}

	/**
	 * Legge il valore della proprieta' desStato associata alla
	 * @generated
	 */
	public String getDesStato() {

		return desStato;

	}

	/**
	 * Crea una istanza di SigitDStatoImpPk a partire dal valore dei campi chiave del DTO
	 * 
	 * @return SigitDStatoImpPk
	 * @generated
	 */
	public SigitDStatoImpPk createPk() {
		return new SigitDStatoImpPk(idStato);
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
