package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Data transfer object relativo al DAO SigitDTipoManutenzioneDao.
 * @generated
 */
public class SigitDTipoManutenzioneDto extends SigitDTipoManutenzionePk {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna DES_TIPO_MANUTENZIONE
	 * @generated
	 */
	protected String desTipoManutenzione;

	/**
	 * Imposta il valore della proprieta' desTipoManutenzione associata alla
	 * colonna DES_TIPO_MANUTENZIONE.
	 * @generated
	 */
	public void setDesTipoManutenzione(String val) {

		desTipoManutenzione = val;

	}

	/**
	 * Legge il valore della proprieta' desTipoManutenzione associata alla
	 * @generated
	 */
	public String getDesTipoManutenzione() {

		return desTipoManutenzione;

	}

	/**
	 * Crea una istanza di SigitDTipoManutenzionePk a partire dal valore dei campi chiave del DTO
	 * 
	 * @return SigitDTipoManutenzionePk
	 * @generated
	 */
	public SigitDTipoManutenzionePk createPk() {
		return new SigitDTipoManutenzionePk(idTipoManutenzione);
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
