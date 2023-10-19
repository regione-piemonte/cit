package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Data transfer object relativo al DAO SigitDStatoSanzioneDao.
 * @generated
 */
public class SigitDStatoSanzioneDto extends SigitDStatoSanzionePk {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna DES_STATO_SANZIONE
	 * @generated
	 */
	protected String desStatoSanzione;

	/**
	 * Imposta il valore della proprieta' desStatoSanzione associata alla
	 * colonna DES_STATO_SANZIONE.
	 * @generated
	 */
	public void setDesStatoSanzione(String val) {

		desStatoSanzione = val;

	}

	/**
	 * Legge il valore della proprieta' desStatoSanzione associata alla
	 * @generated
	 */
	public String getDesStatoSanzione() {

		return desStatoSanzione;

	}

	/**
	 * Crea una istanza di SigitDStatoSanzionePk a partire dal valore dei campi chiave del DTO
	 * 
	 * @return SigitDStatoSanzionePk
	 * @generated
	 */
	public SigitDStatoSanzionePk createPk() {
		return new SigitDStatoSanzionePk(idStatoSanzione);
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
