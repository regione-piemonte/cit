package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Data transfer object relativo al DAO SigitDTipoCessazioneDao.
 * @generated
 */
public class SigitDTipoCessazioneDto extends SigitDTipoCessazionePk {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna DES_TIPO_CESSAZIONE
	 * @generated
	 */
	protected String desTipoCessazione;

	/**
	 * Imposta il valore della proprieta' desTipoCessazione associata alla
	 * colonna DES_TIPO_CESSAZIONE.
	 * @generated
	 */
	public void setDesTipoCessazione(String val) {

		desTipoCessazione = val;

	}

	/**
	 * Legge il valore della proprieta' desTipoCessazione associata alla
	 * @generated
	 */
	public String getDesTipoCessazione() {

		return desTipoCessazione;

	}

	/**
	 * Crea una istanza di SigitDTipoCessazionePk a partire dal valore dei campi chiave del DTO
	 * 
	 * @return SigitDTipoCessazionePk
	 * @generated
	 */
	public SigitDTipoCessazionePk createPk() {
		return new SigitDTipoCessazionePk(idTipoCessazione);
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
