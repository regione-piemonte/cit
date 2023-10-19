package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Data transfer object relativo al DAO SigitDFrequenzaManutDao.
 * @generated
 */
public class SigitDFrequenzaManutDto extends SigitDFrequenzaManutPk {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna DES_FREQUENZA
	 * @generated
	 */
	protected String desFrequenza;

	/**
	 * Imposta il valore della proprieta' desFrequenza associata alla
	 * colonna DES_FREQUENZA.
	 * @generated
	 */
	public void setDesFrequenza(String val) {

		desFrequenza = val;

	}

	/**
	 * Legge il valore della proprieta' desFrequenza associata alla
	 * @generated
	 */
	public String getDesFrequenza() {

		return desFrequenza;

	}

	/**
	 * Crea una istanza di SigitDFrequenzaManutPk a partire dal valore dei campi chiave del DTO
	 * 
	 * @return SigitDFrequenzaManutPk
	 * @generated
	 */
	public SigitDFrequenzaManutPk createPk() {
		return new SigitDFrequenzaManutPk(idFrequenza);
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
