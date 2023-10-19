package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Data transfer object relativo al DAO SigitDTipoCaricCombuDao.
 * @generated
 */
public class SigitDTipoCaricCombuDto extends SigitDTipoCaricCombuPk {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna DESC_TIPO_CARIC_COMBU
	 * @generated
	 */
	protected String descTipoCaricCombu;

	/**
	 * Imposta il valore della proprieta' descTipoCaricCombu associata alla
	 * colonna DESC_TIPO_CARIC_COMBU.
	 * @generated
	 */
	public void setDescTipoCaricCombu(String val) {

		descTipoCaricCombu = val;

	}

	/**
	 * Legge il valore della proprieta' descTipoCaricCombu associata alla
	 * @generated
	 */
	public String getDescTipoCaricCombu() {

		return descTipoCaricCombu;

	}

	/**
	 * Crea una istanza di SigitDTipoCaricCombuPk a partire dal valore dei campi chiave del DTO
	 * 
	 * @return SigitDTipoCaricCombuPk
	 * @generated
	 */
	public SigitDTipoCaricCombuPk createPk() {
		return new SigitDTipoCaricCombuPk(idTipoCaricCombu);
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
