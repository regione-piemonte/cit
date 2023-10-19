package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Data transfer object relativo al DAO SigitDRuoloPaDao.
 * @generated
 */
public class SigitDRuoloPaDto extends SigitDRuoloPaPk {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna DES_RUOLO_PA
	 * @generated
	 */
	protected String desRuoloPa;

	/**
	 * Imposta il valore della proprieta' desRuoloPa associata alla
	 * colonna DES_RUOLO_PA.
	 * @generated
	 */
	public void setDesRuoloPa(String val) {

		desRuoloPa = val;

	}

	/**
	 * Legge il valore della proprieta' desRuoloPa associata alla
	 * @generated
	 */
	public String getDesRuoloPa() {

		return desRuoloPa;

	}

	/**
	 * Crea una istanza di SigitDRuoloPaPk a partire dal valore dei campi chiave del DTO
	 * 
	 * @return SigitDRuoloPaPk
	 * @generated
	 */
	public SigitDRuoloPaPk createPk() {
		return new SigitDRuoloPaPk(idRuoloPa);
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
