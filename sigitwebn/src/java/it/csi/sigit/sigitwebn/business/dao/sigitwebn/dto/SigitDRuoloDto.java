package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Data transfer object relativo al DAO SigitDRuoloDao.
 * @generated
 */
public class SigitDRuoloDto extends SigitDRuoloPk {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna DES_RUOLO
	 * @generated
	 */
	protected String desRuolo;

	/**
	 * Imposta il valore della proprieta' desRuolo associata alla
	 * colonna DES_RUOLO.
	 * @generated
	 */
	public void setDesRuolo(String val) {

		desRuolo = val;

	}

	/**
	 * Legge il valore della proprieta' desRuolo associata alla
	 * @generated
	 */
	public String getDesRuolo() {

		return desRuolo;

	}

	/**
	 * store della proprieta' associata alla colonna RUOLO_FUNZ
	 * @generated
	 */
	protected String ruoloFunz;

	/**
	 * Imposta il valore della proprieta' ruoloFunz associata alla
	 * colonna RUOLO_FUNZ.
	 * @generated
	 */
	public void setRuoloFunz(String val) {

		ruoloFunz = val;

	}

	/**
	 * Legge il valore della proprieta' ruoloFunz associata alla
	 * @generated
	 */
	public String getRuoloFunz() {

		return ruoloFunz;

	}

	/**
	 * Crea una istanza di SigitDRuoloPk a partire dal valore dei campi chiave del DTO
	 * 
	 * @return SigitDRuoloPk
	 * @generated
	 */
	public SigitDRuoloPk createPk() {
		return new SigitDRuoloPk(idRuolo);
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
