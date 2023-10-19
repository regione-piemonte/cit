package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Data transfer object relativo al DAO SigitTStoricoVarStatoPgDao.
 * @generated
 */
public class SigitTStoricoVarStatoPgDto extends SigitTStoricoVarStatoPgPk {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna DT_INIZIO_VARIAZIONE
	 * @generated
	 */
	protected java.sql.Date dtInizioVariazione;

	/**
	 * Imposta il valore della proprieta' dtInizioVariazione associata alla
	 * colonna DT_INIZIO_VARIAZIONE.
	 * @generated
	 */
	public void setDtInizioVariazione(java.sql.Date val) {

		if (val != null) {
			dtInizioVariazione = new java.sql.Date(val.getTime());
		} else {
			dtInizioVariazione = null;
		}

	}

	/**
	 * Legge il valore della proprieta' dtInizioVariazione associata alla
	 * @generated
	 */
	public java.sql.Date getDtInizioVariazione() {

		if (dtInizioVariazione != null) {
			return new java.sql.Date(dtInizioVariazione.getTime());
		} else {
			return null;
		}

	}

	/**
	 * store della proprieta' associata alla colonna MOTIVO
	 * @generated
	 */
	protected String motivo;

	/**
	 * Imposta il valore della proprieta' motivo associata alla
	 * colonna MOTIVO.
	 * @generated
	 */
	public void setMotivo(String val) {

		motivo = val;

	}

	/**
	 * Legge il valore della proprieta' motivo associata alla
	 * @generated
	 */
	public String getMotivo() {

		return motivo;

	}

	/**
	 * store della proprieta' associata alla colonna STATO_PG_DA
	 * @generated
	 */
	protected Integer statoPgDa;

	/**
	 * Imposta il valore della proprieta' statoPgDa associata alla
	 * colonna STATO_PG_DA.
	 * @generated
	 */
	public void setStatoPgDa(Integer val) {

		statoPgDa = val;

	}

	/**
	 * Legge il valore della proprieta' statoPgDa associata alla
	 * @generated
	 */
	public Integer getStatoPgDa() {

		return statoPgDa;

	}

	/**
	 * store della proprieta' associata alla colonna STATO_PG_A
	 * @generated
	 */
	protected Integer statoPgA;

	/**
	 * Imposta il valore della proprieta' statoPgA associata alla
	 * colonna STATO_PG_A.
	 * @generated
	 */
	public void setStatoPgA(Integer val) {

		statoPgA = val;

	}

	/**
	 * Legge il valore della proprieta' statoPgA associata alla
	 * @generated
	 */
	public Integer getStatoPgA() {

		return statoPgA;

	}

	/**
	 * store della proprieta' associata alla colonna DATA_ULT_MOD
	 * @generated
	 */
	protected java.sql.Timestamp dataUltMod;

	/**
	 * Imposta il valore della proprieta' dataUltMod associata alla
	 * colonna DATA_ULT_MOD.
	 * @generated
	 */
	public void setDataUltMod(java.sql.Timestamp val) {

		if (val != null) {
			dataUltMod = new java.sql.Timestamp(val.getTime());
		} else {
			dataUltMod = null;
		}

	}

	/**
	 * Legge il valore della proprieta' dataUltMod associata alla
	 * @generated
	 */
	public java.sql.Timestamp getDataUltMod() {

		if (dataUltMod != null) {
			return new java.sql.Timestamp(dataUltMod.getTime());
		} else {
			return null;
		}

	}

	/**
	 * store della proprieta' associata alla colonna UTENTE_ULT_MOD
	 * @generated
	 */
	protected String utenteUltMod;

	/**
	 * Imposta il valore della proprieta' utenteUltMod associata alla
	 * colonna UTENTE_ULT_MOD.
	 * @generated
	 */
	public void setUtenteUltMod(String val) {

		utenteUltMod = val;

	}

	/**
	 * Legge il valore della proprieta' utenteUltMod associata alla
	 * @generated
	 */
	public String getUtenteUltMod() {

		return utenteUltMod;

	}

	/**
	 * Crea una istanza di SigitTStoricoVarStatoPgPk a partire dal valore dei campi chiave del DTO
	 * 
	 * @return SigitTStoricoVarStatoPgPk
	 * @generated
	 */
	public SigitTStoricoVarStatoPgPk createPk() {
		return new SigitTStoricoVarStatoPgPk(dtEvento, idPersonaGiuridica);
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
