package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Data transfer object relativo al DAO SigitDStatoRappDao.
 * @generated
 */
public class SigitDStatoRappDto extends SigitDStatoRappPk {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna DES_STATO_RAPP
	 * @generated
	 */
	protected String desStatoRapp;

	/**
	 * Imposta il valore della proprieta' desStatoRapp associata alla
	 * colonna DES_STATO_RAPP.
	 * @generated
	 */
	public void setDesStatoRapp(String val) {

		desStatoRapp = val;

	}

	/**
	 * Legge il valore della proprieta' desStatoRapp associata alla
	 * @generated
	 */
	public String getDesStatoRapp() {

		return desStatoRapp;

	}

	/**
	 * Crea una istanza di SigitDStatoRappPk a partire dal valore dei campi chiave del DTO
	 * 
	 * @return SigitDStatoRappPk
	 * @generated
	 */
	public SigitDStatoRappPk createPk() {
		return new SigitDStatoRappPk(idStatoRapp);
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
