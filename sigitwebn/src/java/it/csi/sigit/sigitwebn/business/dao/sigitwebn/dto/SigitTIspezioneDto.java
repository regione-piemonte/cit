/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Data transfer object relativo al DAO SigitTIspezioneDao.
 * @generated
 */
public class SigitTIspezioneDto extends SigitTIspezionePk {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna FK_STATO_ISPEZIONE
	 * @generated
	 */
	protected java.math.BigDecimal fkStatoIspezione;

	/**
	 * Imposta il valore della proprieta' fkStatoIspezione associata alla
	 * colonna FK_STATO_ISPEZIONE.
	 * @generated
	 */
	public void setFkStatoIspezione(java.math.BigDecimal val) {

		fkStatoIspezione = val;

	}

	/**
	 * Legge il valore della proprieta' fkStatoIspezione associata alla
	 * @generated
	 */
	public java.math.BigDecimal getFkStatoIspezione() {

		return fkStatoIspezione;

	}

	/**
	 * store della proprieta' associata alla colonna ENTE_COMPETENTE
	 * @generated
	 */
	protected String enteCompetente;

	/**
	 * Imposta il valore della proprieta' enteCompetente associata alla
	 * colonna ENTE_COMPETENTE.
	 * @generated
	 */
	public void setEnteCompetente(String val) {

		enteCompetente = val;

	}

	/**
	 * Legge il valore della proprieta' enteCompetente associata alla
	 * @generated
	 */
	public String getEnteCompetente() {

		return enteCompetente;

	}

	/**
	 * store della proprieta' associata alla colonna DATA_ISPEZIONE
	 * @generated
	 */
	protected java.sql.Timestamp dataIspezione;

	/**
	 * Imposta il valore della proprieta' dataIspezione associata alla
	 * colonna DATA_ISPEZIONE.
	 * @generated
	 */
	public void setDataIspezione(java.sql.Timestamp val) {

		if (val != null) {
			dataIspezione = new java.sql.Timestamp(val.getTime());
		} else {
			dataIspezione = null;
		}

	}

	/**
	 * Legge il valore della proprieta' dataIspezione associata alla
	 * @generated
	 */
	public java.sql.Timestamp getDataIspezione() {

		if (dataIspezione != null) {
			return new java.sql.Timestamp(dataIspezione.getTime());
		} else {
			return null;
		}

	}

	/**
	 * store della proprieta' associata alla colonna FLG_ESITO
	 * @generated
	 */
	protected java.math.BigDecimal flgEsito;

	/**
	 * Imposta il valore della proprieta' flgEsito associata alla
	 * colonna FLG_ESITO.
	 * @generated
	 */
	public void setFlgEsito(java.math.BigDecimal val) {

		flgEsito = val;

	}

	/**
	 * Legge il valore della proprieta' flgEsito associata alla
	 * @generated
	 */
	public java.math.BigDecimal getFlgEsito() {

		return flgEsito;

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
	 * store della proprieta' associata alla colonna NOTE
	 * @generated
	 */
	protected String note;

	/**
	 * Imposta il valore della proprieta' note associata alla
	 * colonna NOTE.
	 * @generated
	 */
	public void setNote(String val) {

		note = val;

	}

	/**
	 * Legge il valore della proprieta' note associata alla
	 * @generated
	 */
	public String getNote() {

		return note;

	}

	/**
	 * Crea una istanza di SigitTIspezionePk a partire dal valore dei campi chiave del DTO
	 * 
	 * @return SigitTIspezionePk
	 * @generated
	 */
	public SigitTIspezionePk createPk() {
		return new SigitTIspezionePk(idImpRuoloPfpg);
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
