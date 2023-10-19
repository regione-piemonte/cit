package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Data transfer object relativo al DAO SigitDTipoComponenteDao.
 * @generated
 */
public class SigitDTipoComponenteDto extends SigitDTipoComponentePk {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna DES_TIPO_COMPONENTE
	 * @generated
	 */
	protected String desTipoComponente;

	/**
	 * Imposta il valore della proprieta' desTipoComponente associata alla
	 * colonna DES_TIPO_COMPONENTE.
	 * @generated
	 */
	public void setDesTipoComponente(String val) {

		desTipoComponente = val;

	}

	/**
	 * Legge il valore della proprieta' desTipoComponente associata alla
	 * @generated
	 */
	public String getDesTipoComponente() {

		return desTipoComponente;

	}

	/**
	 * store della proprieta' associata alla colonna FLG_VISUALIZZA
	 * @generated
	 */
	protected java.math.BigDecimal flgVisualizza;

	/**
	 * Imposta il valore della proprieta' flgVisualizza associata alla
	 * colonna FLG_VISUALIZZA.
	 * @generated
	 */
	public void setFlgVisualizza(java.math.BigDecimal val) {

		flgVisualizza = val;

	}

	/**
	 * Legge il valore della proprieta' flgVisualizza associata alla
	 * @generated
	 */
	public java.math.BigDecimal getFlgVisualizza() {

		return flgVisualizza;

	}

	/**
	 * Crea una istanza di SigitDTipoComponentePk a partire dal valore dei campi chiave del DTO
	 * 
	 * @return SigitDTipoComponentePk
	 * @generated
	 */
	public SigitDTipoComponentePk createPk() {
		return new SigitDTipoComponentePk(idTipoComponente);
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
