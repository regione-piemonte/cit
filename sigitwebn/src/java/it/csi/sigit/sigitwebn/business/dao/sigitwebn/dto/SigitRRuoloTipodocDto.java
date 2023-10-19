package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Data transfer object relativo al DAO SigitRRuoloTipodocDao.
 * @generated
 */
public class SigitRRuoloTipodocDto extends SigitRRuoloTipodocPk {

	private static final long serialVersionUID = 1L;

	/**
	 * Crea una istanza di SigitRRuoloTipodocPk a partire dal valore dei campi chiave del DTO
	 * 
	 * @return SigitRRuoloTipodocPk
	 * @generated
	 */
	public SigitRRuoloTipodocPk createPk() {
		return new SigitRRuoloTipodocPk(idRuolo, idTipoDocumento);
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
