package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Data transfer object relativo al DAO SigitDTipoConclusioneDao.
 * @generated
 */
public class SigitDTipoConclusioneDto extends SigitDTipoConclusionePk {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna DES_TIPO_CONCLUSIONE
	 * @generated
	 */
	protected String desTipoConclusione;

	/**
	 * Imposta il valore della proprieta' desTipoConclusione associata alla
	 * colonna DES_TIPO_CONCLUSIONE.
	 * @generated
	 */
	public void setDesTipoConclusione(String val) {

		desTipoConclusione = val;

	}

	/**
	 * Legge il valore della proprieta' desTipoConclusione associata alla
	 * @generated
	 */
	public String getDesTipoConclusione() {

		return desTipoConclusione;

	}

	/**
	 * Crea una istanza di SigitDTipoConclusionePk a partire dal valore dei campi chiave del DTO
	 * 
	 * @return SigitDTipoConclusionePk
	 * @generated
	 */
	public SigitDTipoConclusionePk createPk() {
		return new SigitDTipoConclusionePk(idTipoConclusione);
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
