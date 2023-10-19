package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Data transfer object relativo al DAO SigitDCategoriaUtilDao.
 * @generated
 */
public class SigitDCategoriaUtilDto extends SigitDCategoriaUtilPk {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna DES_CATEGORIA_UTIL
	 * @generated
	 */
	protected String desCategoriaUtil;

	/**
	 * Imposta il valore della proprieta' desCategoriaUtil associata alla
	 * colonna DES_CATEGORIA_UTIL.
	 * @generated
	 */
	public void setDesCategoriaUtil(String val) {

		desCategoriaUtil = val;

	}

	/**
	 * Legge il valore della proprieta' desCategoriaUtil associata alla
	 * @generated
	 */
	public String getDesCategoriaUtil() {

		return desCategoriaUtil;

	}

	/**
	 * Crea una istanza di SigitDCategoriaUtilPk a partire dal valore dei campi chiave del DTO
	 * 
	 * @return SigitDCategoriaUtilPk
	 * @generated
	 */
	public SigitDCategoriaUtilPk createPk() {
		return new SigitDCategoriaUtilPk(idCategoriaUtil);
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
