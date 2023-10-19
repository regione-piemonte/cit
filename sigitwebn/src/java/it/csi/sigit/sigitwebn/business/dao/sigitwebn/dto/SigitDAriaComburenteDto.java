package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Data transfer object relativo al DAO SigitDAriaComburenteDao.
 * @generated
 */
public class SigitDAriaComburenteDto extends SigitDAriaComburentePk {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna DESC_ARIA_COMBURENTE
	 * @generated
	 */
	protected String descAriaComburente;

	/**
	 * Imposta il valore della proprieta' descAriaComburente associata alla
	 * colonna DESC_ARIA_COMBURENTE.
	 * @generated
	 */
	public void setDescAriaComburente(String val) {

		descAriaComburente = val;

	}

	/**
	 * Legge il valore della proprieta' descAriaComburente associata alla
	 * @generated
	 */
	public String getDescAriaComburente() {

		return descAriaComburente;

	}

	/**
	 * Crea una istanza di SigitDAriaComburentePk a partire dal valore dei campi chiave del DTO
	 * 
	 * @return SigitDAriaComburentePk
	 * @generated
	 */
	public SigitDAriaComburentePk createPk() {
		return new SigitDAriaComburentePk(idAriaComburente);
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
