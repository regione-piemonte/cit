package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Data transfer object relativo al DAO SigitDTipoDocAggDao.
 * @generated
 */
public class SigitDTipoDocAggDto extends SigitDTipoDocAggPk {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna FK_RAGG_DOC_AGG
	 * @generated
	 */
	protected java.math.BigDecimal fkRaggDocAgg;

	/**
	 * Imposta il valore della proprieta' fkRaggDocAgg associata alla
	 * colonna FK_RAGG_DOC_AGG.
	 * @generated
	 */
	public void setFkRaggDocAgg(java.math.BigDecimal val) {

		fkRaggDocAgg = val;

	}

	/**
	 * Legge il valore della proprieta' fkRaggDocAgg associata alla
	 * @generated
	 */
	public java.math.BigDecimal getFkRaggDocAgg() {

		return fkRaggDocAgg;

	}

	/**
	 * store della proprieta' associata alla colonna DES_TIPO_DOC_AGG
	 * @generated
	 */
	protected String desTipoDocAgg;

	/**
	 * Imposta il valore della proprieta' desTipoDocAgg associata alla
	 * colonna DES_TIPO_DOC_AGG.
	 * @generated
	 */
	public void setDesTipoDocAgg(String val) {

		desTipoDocAgg = val;

	}

	/**
	 * Legge il valore della proprieta' desTipoDocAgg associata alla
	 * @generated
	 */
	public String getDesTipoDocAgg() {

		return desTipoDocAgg;

	}

	/**
	 * Crea una istanza di SigitDTipoDocAggPk a partire dal valore dei campi chiave del DTO
	 * 
	 * @return SigitDTipoDocAggPk
	 * @generated
	 */
	public SigitDTipoDocAggPk createPk() {
		return new SigitDTipoDocAggPk(idTipoDocAgg);
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
