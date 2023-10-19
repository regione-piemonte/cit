package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Data transfer object relativo al DAO SigitRContr2019AutodichiarDao.
 * @generated
 */
public class SigitRContr2019AutodichiarDto extends SigitRContr2019AutodichiarPk {

	private static final long serialVersionUID = 1L;

	/**
	 * Crea una istanza di SigitRContr2019AutodichiarPk a partire dal valore dei campi chiave del DTO
	 * 
	 * @return SigitRContr2019AutodichiarPk
	 * @generated
	 */
	public SigitRContr2019AutodichiarPk createPk() {
		return new SigitRContr2019AutodichiarPk(idContratto, idAutodichiarazione, flgNominaCessa);
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
