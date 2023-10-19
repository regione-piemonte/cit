package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Data transfer object relativo al DAO SigitDDettaglioVmDao.
 * @generated
 */
public class SigitDDettaglioVmDto extends SigitDDettaglioVmPk {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna DES_DETTAGLIO_VM
	 * @generated
	 */
	protected String desDettaglioVm;

	/**
	 * Imposta il valore della proprieta' desDettaglioVm associata alla
	 * colonna DES_DETTAGLIO_VM.
	 * @generated
	 */
	public void setDesDettaglioVm(String val) {

		desDettaglioVm = val;

	}

	/**
	 * Legge il valore della proprieta' desDettaglioVm associata alla
	 * @generated
	 */
	public String getDesDettaglioVm() {

		return desDettaglioVm;

	}

	/**
	 * Crea una istanza di SigitDDettaglioVmPk a partire dal valore dei campi chiave del DTO
	 * 
	 * @return SigitDDettaglioVmPk
	 * @generated
	 */
	public SigitDDettaglioVmPk createPk() {
		return new SigitDDettaglioVmPk(idDettaglioVm);
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
