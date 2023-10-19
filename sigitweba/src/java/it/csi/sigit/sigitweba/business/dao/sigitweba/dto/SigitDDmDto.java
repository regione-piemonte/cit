package it.csi.sigit.sigitweba.business.dao.sigitweba.dto;

import it.csi.sigit.sigitweba.business.dao.sigitweba.dao.*;
import it.csi.sigit.sigitweba.business.dao.sigitweba.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Data transfer object relativo al DAO SigitDDmDao.
 * @generated
 */
public class SigitDDmDto extends SigitDDmPk {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna DES_TIPO_DM37_2008
	 * @generated
	 */
	protected String desTipoDm372008;

	/**
	 * Imposta il valore della proprieta' desTipoDm372008 associata alla
	 * colonna DES_TIPO_DM37_2008.
	 * @generated
	 */
	public void setDesTipoDm372008(String val) {

		desTipoDm372008 = val;

	}

	/**
	 * Legge il valore della proprieta' desTipoDm372008 associata alla
	 * @generated
	 */
	public String getDesTipoDm372008() {

		return desTipoDm372008;

	}

	/**
	 * Crea una istanza di SigitDDmPk a partire dal valore dei campi chiave del DTO
	 * 
	 * @return SigitDDmPk
	 * @generated
	 */
	public SigitDDmPk createPk() {
		return new SigitDDmPk(tipoDm372008);
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
