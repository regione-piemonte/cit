package it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dto;

import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dao.*;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Data transfer object relativo al DAO SigitTImportDistribDao.
 * @generated
 */
public class SigitTImportDistribDto extends SigitTImportDistribPk {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna FK_PERSONA_GIURIDICA
	 * @generated
	 */
	protected java.math.BigDecimal fkPersonaGiuridica;

	/**
	 * Imposta il valore della proprieta' fkPersonaGiuridica associata alla
	 * colonna FK_PERSONA_GIURIDICA.
	 * @generated
	 */
	public void setFkPersonaGiuridica(java.math.BigDecimal val) {

		fkPersonaGiuridica = val;

	}

	/**
	 * Legge il valore della proprieta' fkPersonaGiuridica associata alla
	 * @generated
	 */
	public java.math.BigDecimal getFkPersonaGiuridica() {

		return fkPersonaGiuridica;

	}

	/**
	 * store della proprieta' associata alla colonna FK_STATO_DISTRIB
	 * @generated
	 */
	protected Integer fkStatoDistrib;

	/**
	 * Imposta il valore della proprieta' fkStatoDistrib associata alla
	 * colonna FK_STATO_DISTRIB.
	 * @generated
	 */
	public void setFkStatoDistrib(Integer val) {

		fkStatoDistrib = val;

	}

	/**
	 * Legge il valore della proprieta' fkStatoDistrib associata alla
	 * @generated
	 */
	public Integer getFkStatoDistrib() {

		return fkStatoDistrib;

	}

	/**
	 * store della proprieta' associata alla colonna DATA_INIZIO_ELAB
	 * @generated
	 */
	protected java.sql.Timestamp dataInizioElab;

	/**
	 * Imposta il valore della proprieta' dataInizioElab associata alla
	 * colonna DATA_INIZIO_ELAB.
	 * @generated
	 */
	public void setDataInizioElab(java.sql.Timestamp val) {

		if (val != null) {
			dataInizioElab = new java.sql.Timestamp(val.getTime());
		} else {
			dataInizioElab = null;
		}

	}

	/**
	 * Legge il valore della proprieta' dataInizioElab associata alla
	 * @generated
	 */
	public java.sql.Timestamp getDataInizioElab() {

		if (dataInizioElab != null) {
			return new java.sql.Timestamp(dataInizioElab.getTime());
		} else {
			return null;
		}

	}

	/**
	 * store della proprieta' associata alla colonna DATA_FINE_ELAB
	 * @generated
	 */
	protected java.sql.Timestamp dataFineElab;

	/**
	 * Imposta il valore della proprieta' dataFineElab associata alla
	 * colonna DATA_FINE_ELAB.
	 * @generated
	 */
	public void setDataFineElab(java.sql.Timestamp val) {

		if (val != null) {
			dataFineElab = new java.sql.Timestamp(val.getTime());
		} else {
			dataFineElab = null;
		}

	}

	/**
	 * Legge il valore della proprieta' dataFineElab associata alla
	 * @generated
	 */
	public java.sql.Timestamp getDataFineElab() {

		if (dataFineElab != null) {
			return new java.sql.Timestamp(dataFineElab.getTime());
		} else {
			return null;
		}

	}

	/**
	 * store della proprieta' associata alla colonna DATA_ANNULLAMENTO
	 * @generated
	 */
	protected java.sql.Timestamp dataAnnullamento;

	/**
	 * Imposta il valore della proprieta' dataAnnullamento associata alla
	 * colonna DATA_ANNULLAMENTO.
	 * @generated
	 */
	public void setDataAnnullamento(java.sql.Timestamp val) {

		if (val != null) {
			dataAnnullamento = new java.sql.Timestamp(val.getTime());
		} else {
			dataAnnullamento = null;
		}

	}

	/**
	 * Legge il valore della proprieta' dataAnnullamento associata alla
	 * @generated
	 */
	public java.sql.Timestamp getDataAnnullamento() {

		if (dataAnnullamento != null) {
			return new java.sql.Timestamp(dataAnnullamento.getTime());
		} else {
			return null;
		}

	}

	/**
	 * store della proprieta' associata alla colonna NOME_FILE_IMPORT
	 * @generated
	 */
	protected String nomeFileImport;

	/**
	 * Imposta il valore della proprieta' nomeFileImport associata alla
	 * colonna NOME_FILE_IMPORT.
	 * @generated
	 */
	public void setNomeFileImport(String val) {

		nomeFileImport = val;

	}

	/**
	 * Legge il valore della proprieta' nomeFileImport associata alla
	 * @generated
	 */
	public String getNomeFileImport() {

		return nomeFileImport;

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
	 * store della proprieta' associata alla colonna ANNO_RIFERIMENTO
	 * @generated
	 */
	protected java.math.BigDecimal annoRiferimento;

	/**
	 * Imposta il valore della proprieta' annoRiferimento associata alla
	 * colonna ANNO_RIFERIMENTO.
	 * @generated
	 */
	public void setAnnoRiferimento(java.math.BigDecimal val) {

		annoRiferimento = val;

	}

	/**
	 * Legge il valore della proprieta' annoRiferimento associata alla
	 * @generated
	 */
	public java.math.BigDecimal getAnnoRiferimento() {

		return annoRiferimento;

	}

	/**
	 * store della proprieta' associata alla colonna DATA_INVIO_MAIL_DISTRIB
	 * @generated
	 */
	protected java.sql.Timestamp dataInvioMailDistrib;

	/**
	 * Imposta il valore della proprieta' dataInvioMailDistrib associata alla
	 * colonna DATA_INVIO_MAIL_DISTRIB.
	 * @generated
	 */
	public void setDataInvioMailDistrib(java.sql.Timestamp val) {

		if (val != null) {
			dataInvioMailDistrib = new java.sql.Timestamp(val.getTime());
		} else {
			dataInvioMailDistrib = null;
		}

	}

	/**
	 * Legge il valore della proprieta' dataInvioMailDistrib associata alla
	 * @generated
	 */
	public java.sql.Timestamp getDataInvioMailDistrib() {

		if (dataInvioMailDistrib != null) {
			return new java.sql.Timestamp(dataInvioMailDistrib.getTime());
		} else {
			return null;
		}

	}

	/**
	 * store della proprieta' associata alla colonna DATA_INVIO_MAIL_ASSISTENZA
	 * @generated
	 */
	protected java.sql.Timestamp dataInvioMailAssistenza;

	/**
	 * Imposta il valore della proprieta' dataInvioMailAssistenza associata alla
	 * colonna DATA_INVIO_MAIL_ASSISTENZA.
	 * @generated
	 */
	public void setDataInvioMailAssistenza(java.sql.Timestamp val) {

		if (val != null) {
			dataInvioMailAssistenza = new java.sql.Timestamp(val.getTime());
		} else {
			dataInvioMailAssistenza = null;
		}

	}

	/**
	 * Legge il valore della proprieta' dataInvioMailAssistenza associata alla
	 * @generated
	 */
	public java.sql.Timestamp getDataInvioMailAssistenza() {

		if (dataInvioMailAssistenza != null) {
			return new java.sql.Timestamp(dataInvioMailAssistenza.getTime());
		} else {
			return null;
		}

	}

	/**
	 * store della proprieta' associata alla colonna TOT_RECORD_ELABORATI
	 * @generated
	 */
	protected java.math.BigDecimal totRecordElaborati;

	/**
	 * Imposta il valore della proprieta' totRecordElaborati associata alla
	 * colonna TOT_RECORD_ELABORATI.
	 * @generated
	 */
	public void setTotRecordElaborati(java.math.BigDecimal val) {

		totRecordElaborati = val;

	}

	/**
	 * Legge il valore della proprieta' totRecordElaborati associata alla
	 * @generated
	 */
	public java.math.BigDecimal getTotRecordElaborati() {

		return totRecordElaborati;

	}

	/**
	 * store della proprieta' associata alla colonna TOT_RECORD_SCARTATI
	 * @generated
	 */
	protected java.math.BigDecimal totRecordScartati;

	/**
	 * Imposta il valore della proprieta' totRecordScartati associata alla
	 * colonna TOT_RECORD_SCARTATI.
	 * @generated
	 */
	public void setTotRecordScartati(java.math.BigDecimal val) {

		totRecordScartati = val;

	}

	/**
	 * Legge il valore della proprieta' totRecordScartati associata alla
	 * @generated
	 */
	public java.math.BigDecimal getTotRecordScartati() {

		return totRecordScartati;

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
	 * store della proprieta' associata alla colonna UTENTE_CARICAMENTO
	 * @generated
	 */
	protected String utenteCaricamento;

	/**
	 * Imposta il valore della proprieta' utenteCaricamento associata alla
	 * colonna UTENTE_CARICAMENTO.
	 * @generated
	 */
	public void setUtenteCaricamento(String val) {

		utenteCaricamento = val;

	}

	/**
	 * Legge il valore della proprieta' utenteCaricamento associata alla
	 * @generated
	 */
	public String getUtenteCaricamento() {

		return utenteCaricamento;

	}

	/**
	 * Crea una istanza di SigitTImportDistribPk a partire dal valore dei campi chiave del DTO
	 * 
	 * @return SigitTImportDistribPk
	 * @generated
	 */
	public SigitTImportDistribPk createPk() {
		return new SigitTImportDistribPk(idImportDistrib);
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
