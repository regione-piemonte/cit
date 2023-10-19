package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Data transfer object relativo al DAO SigitDCategoriaDao.
 * @generated
 */
public class SigitDCategoriaDto extends SigitDCategoriaPk {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna DES_CATEGORIA
	 * @generated
	 */
	protected String desCategoria;

	/**
	 * Imposta il valore della proprieta' desCategoria associata alla
	 * colonna DES_CATEGORIA.
	 * @generated
	 */
	public void setDesCategoria(String val) {

		desCategoria = val;

	}

	/**
	 * Legge il valore della proprieta' desCategoria associata alla
	 * @generated
	 */
	public String getDesCategoria() {

		return desCategoria;

	}

	/**
	 * Crea una istanza di SigitDCategoriaPk a partire dal valore dei campi chiave del DTO
	 * 
	 * @return SigitDCategoriaPk
	 * @generated
	 */
	public SigitDCategoriaPk createPk() {
		return new SigitDCategoriaPk(idCategoria);
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
