package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Data transfer object relativo al DAO SigitTDocAllegatoDao.
 * @generated
 */
public class SigitTDocAllegatoDto extends SigitTDocAllegatoPk {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna FK_ALLEGATO
	 * @generated
	 */
	protected java.math.BigDecimal fkAllegato;

	/**
	 * Imposta il valore della proprieta' fkAllegato associata alla
	 * colonna FK_ALLEGATO.
	 * @generated
	 */
	public void setFkAllegato(java.math.BigDecimal val) {

		fkAllegato = val;

	}

	/**
	 * Legge il valore della proprieta' fkAllegato associata alla
	 * @generated
	 */
	public java.math.BigDecimal getFkAllegato() {

		return fkAllegato;

	}

	/**
	 * store della proprieta' associata alla colonna NOME_DOC_ORIGINALE
	 * @generated
	 */
	protected String nomeDocOriginale;

	/**
	 * Imposta il valore della proprieta' nomeDocOriginale associata alla
	 * colonna NOME_DOC_ORIGINALE.
	 * @generated
	 */
	public void setNomeDocOriginale(String val) {

		nomeDocOriginale = val;

	}

	/**
	 * Legge il valore della proprieta' nomeDocOriginale associata alla
	 * @generated
	 */
	public String getNomeDocOriginale() {

		return nomeDocOriginale;

	}

	/**
	 * store della proprieta' associata alla colonna NOME_DOC
	 * @generated
	 */
	protected String nomeDoc;

	/**
	 * Imposta il valore della proprieta' nomeDoc associata alla
	 * colonna NOME_DOC.
	 * @generated
	 */
	public void setNomeDoc(String val) {

		nomeDoc = val;

	}

	/**
	 * Legge il valore della proprieta' nomeDoc associata alla
	 * @generated
	 */
	public String getNomeDoc() {

		return nomeDoc;

	}

	/**
	 * store della proprieta' associata alla colonna UID_INDEX
	 * @generated
	 */
	protected String uidIndex;

	/**
	 * Imposta il valore della proprieta' uidIndex associata alla
	 * colonna UID_INDEX.
	 * @generated
	 */
	public void setUidIndex(String val) {

		uidIndex = val;

	}

	/**
	 * Legge il valore della proprieta' uidIndex associata alla
	 * @generated
	 */
	public String getUidIndex() {

		return uidIndex;

	}

	/**
	 * store della proprieta' associata alla colonna DESCRIZIONE
	 * @generated
	 */
	protected String descrizione;

	/**
	 * Imposta il valore della proprieta' descrizione associata alla
	 * colonna DESCRIZIONE.
	 * @generated
	 */
	public void setDescrizione(String val) {

		descrizione = val;

	}

	/**
	 * Legge il valore della proprieta' descrizione associata alla
	 * @generated
	 */
	public String getDescrizione() {

		return descrizione;

	}

	/**
	 * store della proprieta' associata alla colonna DATA_ULT_MOD
	 * @generated
	 */
	protected java.sql.Date dataUltMod;

	/**
	 * Imposta il valore della proprieta' dataUltMod associata alla
	 * colonna DATA_ULT_MOD.
	 * @generated
	 */
	public void setDataUltMod(java.sql.Date val) {

		if (val != null) {
			dataUltMod = new java.sql.Date(val.getTime());
		} else {
			dataUltMod = null;
		}

	}

	/**
	 * Legge il valore della proprieta' dataUltMod associata alla
	 * @generated
	 */
	public java.sql.Date getDataUltMod() {

		if (dataUltMod != null) {
			return new java.sql.Date(dataUltMod.getTime());
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
	 * store della proprieta' associata alla colonna DATA_UPLOAD
	 * @generated
	 */
	protected java.sql.Timestamp dataUpload;

	/**
	 * Imposta il valore della proprieta' dataUpload associata alla
	 * colonna DATA_UPLOAD.
	 * @generated
	 */
	public void setDataUpload(java.sql.Timestamp val) {

		if (val != null) {
			dataUpload = new java.sql.Timestamp(val.getTime());
		} else {
			dataUpload = null;
		}

	}

	/**
	 * Legge il valore della proprieta' dataUpload associata alla
	 * @generated
	 */
	public java.sql.Timestamp getDataUpload() {

		if (dataUpload != null) {
			return new java.sql.Timestamp(dataUpload.getTime());
		} else {
			return null;
		}

	}

	/**
	 * store della proprieta' associata alla colonna DATA_DELETE
	 * @generated
	 */
	protected java.sql.Timestamp dataDelete;

	/**
	 * Imposta il valore della proprieta' dataDelete associata alla
	 * colonna DATA_DELETE.
	 * @generated
	 */
	public void setDataDelete(java.sql.Timestamp val) {

		if (val != null) {
			dataDelete = new java.sql.Timestamp(val.getTime());
		} else {
			dataDelete = null;
		}

	}

	/**
	 * Legge il valore della proprieta' dataDelete associata alla
	 * @generated
	 */
	public java.sql.Timestamp getDataDelete() {

		if (dataDelete != null) {
			return new java.sql.Timestamp(dataDelete.getTime());
		} else {
			return null;
		}

	}

	/**
	 * Crea una istanza di SigitTDocAllegatoPk a partire dal valore dei campi chiave del DTO
	 * 
	 * @return SigitTDocAllegatoPk
	 * @generated
	 */
	public SigitTDocAllegatoPk createPk() {
		return new SigitTDocAllegatoPk(idDocAllegato);
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
