package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Data transfer object relativo al DAO SigitTmpLibrettoDao.
 * @generated
 */
public class SigitTmpLibrettoDto extends SigitTmpLibrettoPk {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna FLG_ELABORATO
	 * @generated
	 */
	protected java.math.BigDecimal flgElaborato;

	/**
	 * Imposta il valore della proprieta' flgElaborato associata alla
	 * colonna FLG_ELABORATO.
	 * @generated
	 */
	public void setFlgElaborato(java.math.BigDecimal val) {

		flgElaborato = val;

	}

	/**
	 * Legge il valore della proprieta' flgElaborato associata alla
	 * @generated
	 */
	public java.math.BigDecimal getFlgElaborato() {

		return flgElaborato;

	}

	/**
	 * store della proprieta' associata alla colonna FLG_ESITO_ELAB
	 * @generated
	 */
	protected java.math.BigDecimal flgEsitoElab;

	/**
	 * Imposta il valore della proprieta' flgEsitoElab associata alla
	 * colonna FLG_ESITO_ELAB.
	 * @generated
	 */
	public void setFlgEsitoElab(java.math.BigDecimal val) {

		flgEsitoElab = val;

	}

	/**
	 * Legge il valore della proprieta' flgEsitoElab associata alla
	 * @generated
	 */
	public java.math.BigDecimal getFlgEsitoElab() {

		return flgEsitoElab;

	}

	/**
	 * store della proprieta' associata alla colonna DATA_ELAB
	 * @generated
	 */
	protected java.sql.Timestamp dataElab;

	/**
	 * Imposta il valore della proprieta' dataElab associata alla
	 * colonna DATA_ELAB.
	 * @generated
	 */
	public void setDataElab(java.sql.Timestamp val) {

		if (val != null) {
			dataElab = new java.sql.Timestamp(val.getTime());
		} else {
			dataElab = null;
		}

	}

	/**
	 * Legge il valore della proprieta' dataElab associata alla
	 * @generated
	 */
	public java.sql.Timestamp getDataElab() {

		if (dataElab != null) {
			return new java.sql.Timestamp(dataElab.getTime());
		} else {
			return null;
		}

	}

	/**
	 * Crea una istanza di SigitTmpLibrettoPk a partire dal valore dei campi chiave del DTO
	 * 
	 * @return SigitTmpLibrettoPk
	 * @generated
	 */
	public SigitTmpLibrettoPk createPk() {
		return new SigitTmpLibrettoPk(idLibretto);
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
