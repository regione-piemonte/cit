package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Data transfer object relativo al DAO SigitDTipoAnomaliaDao.
 * @generated
 */
public class SigitDTipoAnomaliaDto extends SigitDTipoAnomaliaPk {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna DES_TIPO_ANOMALIA
	 * @generated
	 */
	protected String desTipoAnomalia;

	/**
	 * Imposta il valore della proprieta' desTipoAnomalia associata alla
	 * colonna DES_TIPO_ANOMALIA.
	 * @generated
	 */
	public void setDesTipoAnomalia(String val) {

		desTipoAnomalia = val;

	}

	/**
	 * Legge il valore della proprieta' desTipoAnomalia associata alla
	 * @generated
	 */
	public String getDesTipoAnomalia() {

		return desTipoAnomalia;

	}

	/**
	 * Crea una istanza di SigitDTipoAnomaliaPk a partire dal valore dei campi chiave del DTO
	 * 
	 * @return SigitDTipoAnomaliaPk
	 * @generated
	 */
	public SigitDTipoAnomaliaPk createPk() {
		return new SigitDTipoAnomaliaPk(idTipoAnomalia);
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
