package it.csi.sigit.elencom.business.dao.elencom.dto;

import it.csi.sigit.elencom.business.dao.elencom.dao.*;
import it.csi.sigit.elencom.business.dao.elencom.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Data transfer object relativo al DAO SigitTFormazioneDao.
 * @generated
 */
public class SigitTFormazioneDto extends SigitTFormazionePk {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna DES_CORSO
	 * @generated
	 */
	protected String desCorso;

	/**
	 * Imposta il valore della proprieta' desCorso associata alla
	 * colonna DES_CORSO.
	 * @generated
	 */
	public void setDesCorso(String val) {

		desCorso = val;

	}

	/**
	 * Legge il valore della proprieta' desCorso associata alla
	 * @generated
	 */
	public String getDesCorso() {

		return desCorso;

	}

	/**
	 * Crea una istanza di SigitTFormazionePk a partire dal valore dei campi chiave del DTO
	 * 
	 * @return SigitTFormazionePk
	 * @generated
	 */
	public SigitTFormazionePk createPk() {
		return new SigitTFormazionePk(dataCorso, idPersonaFisica);
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
