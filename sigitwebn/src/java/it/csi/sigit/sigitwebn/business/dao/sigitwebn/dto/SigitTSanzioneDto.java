package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Data transfer object relativo al DAO SigitTSanzioneDao.
 * @generated
 */
public class SigitTSanzioneDto extends SigitTSanzionePk {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna FK_STATO_SANZIONE
	 * @generated
	 */
	protected Integer fkStatoSanzione;

	/**
	 * Imposta il valore della proprieta' fkStatoSanzione associata alla
	 * colonna FK_STATO_SANZIONE.
	 * @generated
	 */
	public void setFkStatoSanzione(Integer val) {

		fkStatoSanzione = val;

	}

	/**
	 * Legge il valore della proprieta' fkStatoSanzione associata alla
	 * @generated
	 */
	public Integer getFkStatoSanzione() {

		return fkStatoSanzione;

	}

	/**
	 * store della proprieta' associata alla colonna FK_ISPEZIONE_2018
	 * @generated
	 */
	protected Integer fkIspezione2018;

	/**
	 * Imposta il valore della proprieta' fkIspezione2018 associata alla
	 * colonna FK_ISPEZIONE_2018.
	 * @generated
	 */
	public void setFkIspezione2018(Integer val) {

		fkIspezione2018 = val;

	}

	/**
	 * Legge il valore della proprieta' fkIspezione2018 associata alla
	 * @generated
	 */
	public Integer getFkIspezione2018() {

		return fkIspezione2018;

	}

	/**
	 * store della proprieta' associata alla colonna FK_ACCERTAMENTO
	 * @generated
	 */
	protected Integer fkAccertamento;

	/**
	 * Imposta il valore della proprieta' fkAccertamento associata alla
	 * colonna FK_ACCERTAMENTO.
	 * @generated
	 */
	public void setFkAccertamento(Integer val) {

		fkAccertamento = val;

	}

	/**
	 * Legge il valore della proprieta' fkAccertamento associata alla
	 * @generated
	 */
	public Integer getFkAccertamento() {

		return fkAccertamento;

	}

	/**
	 * store della proprieta' associata alla colonna FK_PF_SANZIONATA
	 * @generated
	 */
	protected java.math.BigDecimal fkPfSanzionata;

	/**
	 * Imposta il valore della proprieta' fkPfSanzionata associata alla
	 * colonna FK_PF_SANZIONATA.
	 * @generated
	 */
	public void setFkPfSanzionata(java.math.BigDecimal val) {

		fkPfSanzionata = val;

	}

	/**
	 * Legge il valore della proprieta' fkPfSanzionata associata alla
	 * @generated
	 */
	public java.math.BigDecimal getFkPfSanzionata() {

		return fkPfSanzionata;

	}

	/**
	 * store della proprieta' associata alla colonna FK_PG_SANZIONATA
	 * @generated
	 */
	protected java.math.BigDecimal fkPgSanzionata;

	/**
	 * Imposta il valore della proprieta' fkPgSanzionata associata alla
	 * colonna FK_PG_SANZIONATA.
	 * @generated
	 */
	public void setFkPgSanzionata(java.math.BigDecimal val) {

		fkPgSanzionata = val;

	}

	/**
	 * Legge il valore della proprieta' fkPgSanzionata associata alla
	 * @generated
	 */
	public java.math.BigDecimal getFkPgSanzionata() {

		return fkPgSanzionata;

	}

	/**
	 * store della proprieta' associata alla colonna MOTIVAZIONE_SANZIONE
	 * @generated
	 */
	protected String motivazioneSanzione;

	/**
	 * Imposta il valore della proprieta' motivazioneSanzione associata alla
	 * colonna MOTIVAZIONE_SANZIONE.
	 * @generated
	 */
	public void setMotivazioneSanzione(String val) {

		motivazioneSanzione = val;

	}

	/**
	 * Legge il valore della proprieta' motivazioneSanzione associata alla
	 * @generated
	 */
	public String getMotivazioneSanzione() {

		return motivazioneSanzione;

	}

	/**
	 * store della proprieta' associata alla colonna VALORE_SANZIONE
	 * @generated
	 */
	protected java.math.BigDecimal valoreSanzione;

	/**
	 * Imposta il valore della proprieta' valoreSanzione associata alla
	 * colonna VALORE_SANZIONE.
	 * @generated
	 */
	public void setValoreSanzione(java.math.BigDecimal val) {

		valoreSanzione = val;

	}

	/**
	 * Legge il valore della proprieta' valoreSanzione associata alla
	 * @generated
	 */
	public java.math.BigDecimal getValoreSanzione() {

		return valoreSanzione;

	}

	/**
	 * store della proprieta' associata alla colonna DT_CREAZIONE
	 * @generated
	 */
	protected java.sql.Date dtCreazione;

	/**
	 * Imposta il valore della proprieta' dtCreazione associata alla
	 * colonna DT_CREAZIONE.
	 * @generated
	 */
	public void setDtCreazione(java.sql.Date val) {

		if (val != null) {
			dtCreazione = new java.sql.Date(val.getTime());
		} else {
			dtCreazione = null;
		}

	}

	/**
	 * Legge il valore della proprieta' dtCreazione associata alla
	 * @generated
	 */
	public java.sql.Date getDtCreazione() {

		if (dtCreazione != null) {
			return new java.sql.Date(dtCreazione.getTime());
		} else {
			return null;
		}

	}

	/**
	 * store della proprieta' associata alla colonna DT_COMUNICAZIONE
	 * @generated
	 */
	protected java.sql.Date dtComunicazione;

	/**
	 * Imposta il valore della proprieta' dtComunicazione associata alla
	 * colonna DT_COMUNICAZIONE.
	 * @generated
	 */
	public void setDtComunicazione(java.sql.Date val) {

		if (val != null) {
			dtComunicazione = new java.sql.Date(val.getTime());
		} else {
			dtComunicazione = null;
		}

	}

	/**
	 * Legge il valore della proprieta' dtComunicazione associata alla
	 * @generated
	 */
	public java.sql.Date getDtComunicazione() {

		if (dtComunicazione != null) {
			return new java.sql.Date(dtComunicazione.getTime());
		} else {
			return null;
		}

	}

	/**
	 * store della proprieta' associata alla colonna DT_PAGAMENTO
	 * @generated
	 */
	protected java.sql.Date dtPagamento;

	/**
	 * Imposta il valore della proprieta' dtPagamento associata alla
	 * colonna DT_PAGAMENTO.
	 * @generated
	 */
	public void setDtPagamento(java.sql.Date val) {

		if (val != null) {
			dtPagamento = new java.sql.Date(val.getTime());
		} else {
			dtPagamento = null;
		}

	}

	/**
	 * Legge il valore della proprieta' dtPagamento associata alla
	 * @generated
	 */
	public java.sql.Date getDtPagamento() {

		if (dtPagamento != null) {
			return new java.sql.Date(dtPagamento.getTime());
		} else {
			return null;
		}

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
	 * store della proprieta' associata alla colonna MOTIVO_ANNULLAMENTO
	 * @generated
	 */
	protected String motivoAnnullamento;

	/**
	 * Imposta il valore della proprieta' motivoAnnullamento associata alla
	 * colonna MOTIVO_ANNULLAMENTO.
	 * @generated
	 */
	public void setMotivoAnnullamento(String val) {

		motivoAnnullamento = val;

	}

	/**
	 * Legge il valore della proprieta' motivoAnnullamento associata alla
	 * @generated
	 */
	public String getMotivoAnnullamento() {

		return motivoAnnullamento;

	}

	/**
	 * store della proprieta' associata alla colonna DT_ANNULLAMENTO
	 * @generated
	 */
	protected java.sql.Date dtAnnullamento;

	/**
	 * Imposta il valore della proprieta' dtAnnullamento associata alla
	 * colonna DT_ANNULLAMENTO.
	 * @generated
	 */
	public void setDtAnnullamento(java.sql.Date val) {

		if (val != null) {
			dtAnnullamento = new java.sql.Date(val.getTime());
		} else {
			dtAnnullamento = null;
		}

	}

	/**
	 * Legge il valore della proprieta' dtAnnullamento associata alla
	 * @generated
	 */
	public java.sql.Date getDtAnnullamento() {

		if (dtAnnullamento != null) {
			return new java.sql.Date(dtAnnullamento.getTime());
		} else {
			return null;
		}

	}

	/**
	 * store della proprieta' associata alla colonna CF_RESPONSABILE
	 * @generated
	 */
	protected String cfResponsabile;

	/**
	 * Imposta il valore della proprieta' cfResponsabile associata alla
	 * colonna CF_RESPONSABILE.
	 * @generated
	 */
	public void setCfResponsabile(String val) {

		cfResponsabile = val;

	}

	/**
	 * Legge il valore della proprieta' cfResponsabile associata alla
	 * @generated
	 */
	public String getCfResponsabile() {

		return cfResponsabile;

	}

	/**
	 * store della proprieta' associata alla colonna DENOM_UT_RESPONSABILE
	 * @generated
	 */
	protected String denomUtResponsabile;

	/**
	 * Imposta il valore della proprieta' denomUtResponsabile associata alla
	 * colonna DENOM_UT_RESPONSABILE.
	 * @generated
	 */
	public void setDenomUtResponsabile(String val) {

		denomUtResponsabile = val;

	}

	/**
	 * Legge il valore della proprieta' denomUtResponsabile associata alla
	 * @generated
	 */
	public String getDenomUtResponsabile() {

		return denomUtResponsabile;

	}

	/**
	 * store della proprieta' associata alla colonna DT_SVEGLIA
	 * @generated
	 */
	protected java.sql.Date dtSveglia;

	/**
	 * Imposta il valore della proprieta' dtSveglia associata alla
	 * colonna DT_SVEGLIA.
	 * @generated
	 */
	public void setDtSveglia(java.sql.Date val) {

		if (val != null) {
			dtSveglia = new java.sql.Date(val.getTime());
		} else {
			dtSveglia = null;
		}

	}

	/**
	 * Legge il valore della proprieta' dtSveglia associata alla
	 * @generated
	 */
	public java.sql.Date getDtSveglia() {

		if (dtSveglia != null) {
			return new java.sql.Date(dtSveglia.getTime());
		} else {
			return null;
		}

	}

	/**
	 * store della proprieta' associata alla colonna NOTE_SVEGLIA
	 * @generated
	 */
	protected String noteSveglia;

	/**
	 * Imposta il valore della proprieta' noteSveglia associata alla
	 * colonna NOTE_SVEGLIA.
	 * @generated
	 */
	public void setNoteSveglia(String val) {

		noteSveglia = val;

	}

	/**
	 * Legge il valore della proprieta' noteSveglia associata alla
	 * @generated
	 */
	public String getNoteSveglia() {

		return noteSveglia;

	}

	/**
	 * Crea una istanza di SigitTSanzionePk a partire dal valore dei campi chiave del DTO
	 * 
	 * @return SigitTSanzionePk
	 * @generated
	 */
	public SigitTSanzionePk createPk() {
		return new SigitTSanzionePk(idSanzione);
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
