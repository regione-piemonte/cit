package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Data transfer object relativo al DAO SigitDTipoInterventoDao.
 * @generated
 */
public class SigitDTipoInterventoDto extends SigitDTipoInterventoPk {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna DES_TIPO_INTERVENTO
	 * @generated
	 */
	protected String desTipoIntervento;

	/**
	 * Imposta il valore della proprieta' desTipoIntervento associata alla
	 * colonna DES_TIPO_INTERVENTO.
	 * @generated
	 */
	public void setDesTipoIntervento(String val) {

		desTipoIntervento = val;

	}

	/**
	 * Legge il valore della proprieta' desTipoIntervento associata alla
	 * @generated
	 */
	public String getDesTipoIntervento() {

		return desTipoIntervento;

	}

	/**
	 * Crea una istanza di SigitDTipoInterventoPk a partire dal valore dei campi chiave del DTO
	 * 
	 * @return SigitDTipoInterventoPk
	 * @generated
	 */
	public SigitDTipoInterventoPk createPk() {
		return new SigitDTipoInterventoPk(idTipoIntervento);
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
