package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Data transfer object relativo al DAO SigitDFluidoDao.
 * @generated
 */
public class SigitDFluidoDto extends SigitDFluidoPk {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna DES_FLUIDO
	 * @generated
	 */
	protected String desFluido;

	/**
	 * Imposta il valore della proprieta' desFluido associata alla
	 * colonna DES_FLUIDO.
	 * @generated
	 */
	public void setDesFluido(String val) {

		desFluido = val;

	}

	/**
	 * Legge il valore della proprieta' desFluido associata alla
	 * @generated
	 */
	public String getDesFluido() {

		return desFluido;

	}

	/**
	 * Crea una istanza di SigitDFluidoPk a partire dal valore dei campi chiave del DTO
	 * 
	 * @return SigitDFluidoPk
	 * @generated
	 */
	public SigitDFluidoPk createPk() {
		return new SigitDFluidoPk(idFluido);
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
