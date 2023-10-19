package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Data transfer object relativo al DAO SigitDAutodichiarazioneDao.
 * @generated
 */
public class SigitDAutodichiarazioneDto extends SigitDAutodichiarazionePk {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna DES_AUTODICHIARAZIONE
	 * @generated
	 */
	protected String desAutodichiarazione;

	/**
	 * Imposta il valore della proprieta' desAutodichiarazione associata alla
	 * colonna DES_AUTODICHIARAZIONE.
	 * @generated
	 */
	public void setDesAutodichiarazione(String val) {

		desAutodichiarazione = val;

	}

	/**
	 * Legge il valore della proprieta' desAutodichiarazione associata alla
	 * @generated
	 */
	public String getDesAutodichiarazione() {

		return desAutodichiarazione;

	}

	/**
	 * Crea una istanza di SigitDAutodichiarazionePk a partire dal valore dei campi chiave del DTO
	 * 
	 * @return SigitDAutodichiarazionePk
	 * @generated
	 */
	public SigitDAutodichiarazionePk createPk() {
		return new SigitDAutodichiarazionePk(idAutodichiarazione);
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
