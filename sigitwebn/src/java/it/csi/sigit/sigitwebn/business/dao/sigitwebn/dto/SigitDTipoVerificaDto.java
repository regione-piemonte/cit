package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Data transfer object relativo al DAO SigitDTipoVerificaDao.
 * @generated
 */
public class SigitDTipoVerificaDto extends SigitDTipoVerificaPk {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna DES_TIPO_VERIFICA
	 * @generated
	 */
	protected String desTipoVerifica;

	/**
	 * Imposta il valore della proprieta' desTipoVerifica associata alla
	 * colonna DES_TIPO_VERIFICA.
	 * @generated
	 */
	public void setDesTipoVerifica(String val) {

		desTipoVerifica = val;

	}

	/**
	 * Legge il valore della proprieta' desTipoVerifica associata alla
	 * @generated
	 */
	public String getDesTipoVerifica() {

		return desTipoVerifica;

	}

	/**
	 * Crea una istanza di SigitDTipoVerificaPk a partire dal valore dei campi chiave del DTO
	 * 
	 * @return SigitDTipoVerificaPk
	 * @generated
	 */
	public SigitDTipoVerificaPk createPk() {
		return new SigitDTipoVerificaPk(idTipoVerifica);
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
