package it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dto;

import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dao.*;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Data transfer object relativo al DAO SigitDCombustibileDao.
 * @generated
 */
public class SigitDCombustibileDto extends SigitDCombustibilePk {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna DES_COMBUSTIBILE
	 * @generated
	 */
	protected String desCombustibile;

	/**
	 * Imposta il valore della proprieta' desCombustibile associata alla
	 * colonna DES_COMBUSTIBILE.
	 * @generated
	 */
	public void setDesCombustibile(String val) {

		desCombustibile = val;

	}

	/**
	 * Legge il valore della proprieta' desCombustibile associata alla
	 * @generated
	 */
	public String getDesCombustibile() {

		return desCombustibile;

	}

	/**
	 * Crea una istanza di SigitDCombustibilePk a partire dal valore dei campi chiave del DTO
	 * 
	 * @return SigitDCombustibilePk
	 * @generated
	 */
	public SigitDCombustibilePk createPk() {
		return new SigitDCombustibilePk(idCombustibile);
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
