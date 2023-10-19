package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Data transfer object relativo al DAO SigitTIspezione2018Dao.
 * @generated
 */
public class SigitTIspezione2018Dto extends SigitTIspezione2018Pk {

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
	 * store della proprieta' associata alla colonna FK_VERIFICA
	 * @generated
	 */
	protected Integer fkVerifica;

	/**
	 * Imposta il valore della proprieta' fkVerifica associata alla
	 * colonna FK_VERIFICA.
	 * @generated
	 */
	public void setFkVerifica(Integer val) {

		fkVerifica = val;

	}

	/**
	 * Legge il valore della proprieta' fkVerifica associata alla
	 * @generated
	 */
	public Integer getFkVerifica() {

		return fkVerifica;

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
	 * store della proprieta' associata alla colonna CODICE_IMPIANTO
	 * @generated
	 */
	protected java.math.BigDecimal codiceImpianto;

	/**
	 * Imposta il valore della proprieta' codiceImpianto associata alla
	 * colonna CODICE_IMPIANTO.
	 * @generated
	 */
	public void setCodiceImpianto(java.math.BigDecimal val) {

		codiceImpianto = val;

	}

	/**
	 * Legge il valore della proprieta' codiceImpianto associata alla
	 * @generated
	 */
	public java.math.BigDecimal getCodiceImpianto() {

		return codiceImpianto;

	}

	/**
	 * store della proprieta' associata alla colonna CF_ISPETTORE_SECONDARIO
	 * @generated
	 */
	protected String cfIspettoreSecondario;

	/**
	 * Imposta il valore della proprieta' cfIspettoreSecondario associata alla
	 * colonna CF_ISPETTORE_SECONDARIO.
	 * @generated
	 */
	public void setCfIspettoreSecondario(String val) {

		cfIspettoreSecondario = val;

	}

	/**
	 * Legge il valore della proprieta' cfIspettoreSecondario associata alla
	 * @generated
	 */
	public String getCfIspettoreSecondario() {

		return cfIspettoreSecondario;

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
	 * store della proprieta' associata alla colonna DT_SVEGLIA
	 * @generated
	 */
	protected java.sql.Timestamp dtSveglia;

	/**
	 * Imposta il valore della proprieta' dtSveglia associata alla
	 * colonna DT_SVEGLIA.
	 * @generated
	 */
	public void setDtSveglia(java.sql.Timestamp val) {

		if (val != null) {
			dtSveglia = new java.sql.Timestamp(val.getTime());
		} else {
			dtSveglia = null;
		}

	}

	/**
	 * Legge il valore della proprieta' dtSveglia associata alla
	 * @generated
	 */
	public java.sql.Timestamp getDtSveglia() {

		if (dtSveglia != null) {
			return new java.sql.Timestamp(dtSveglia.getTime());
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
	 * store della proprieta' associata alla colonna ISTAT_PROV_COMPETENZA
	 * @generated
	 */
	protected String istatProvCompetenza;

	/**
	 * Imposta il valore della proprieta' istatProvCompetenza associata alla
	 * colonna ISTAT_PROV_COMPETENZA.
	 * @generated
	 */
	public void setIstatProvCompetenza(String val) {

		istatProvCompetenza = val;

	}

	/**
	 * Legge il valore della proprieta' istatProvCompetenza associata alla
	 * @generated
	 */
	public String getIstatProvCompetenza() {

		return istatProvCompetenza;

	}

	/**
	 * store della proprieta' associata alla colonna FLG_ACC_SOSTITUTIVO
	 * @generated
	 */
	protected java.math.BigDecimal flgAccSostitutivo;

	/**
	 * Imposta il valore della proprieta' flgAccSostitutivo associata alla
	 * colonna FLG_ACC_SOSTITUTIVO.
	 * @generated
	 */
	public void setFlgAccSostitutivo(java.math.BigDecimal val) {

		flgAccSostitutivo = val;

	}

	/**
	 * Legge il valore della proprieta' flgAccSostitutivo associata alla
	 * @generated
	 */
	public java.math.BigDecimal getFlgAccSostitutivo() {

		return flgAccSostitutivo;

	}

	/**
	 * store della proprieta' associata alla colonna DT_CREAZIONE
	 * @generated
	 */
	protected java.sql.Timestamp dtCreazione;

	/**
	 * Imposta il valore della proprieta' dtCreazione associata alla
	 * colonna DT_CREAZIONE.
	 * @generated
	 */
	public void setDtCreazione(java.sql.Timestamp val) {

		if (val != null) {
			dtCreazione = new java.sql.Timestamp(val.getTime());
		} else {
			dtCreazione = null;
		}

	}

	/**
	 * Legge il valore della proprieta' dtCreazione associata alla
	 * @generated
	 */
	public java.sql.Timestamp getDtCreazione() {

		if (dtCreazione != null) {
			return new java.sql.Timestamp(dtCreazione.getTime());
		} else {
			return null;
		}

	}

	/**
	 * store della proprieta' associata alla colonna DT_CONCLUSIONE
	 * @generated
	 */
	protected java.sql.Timestamp dtConclusione;

	/**
	 * Imposta il valore della proprieta' dtConclusione associata alla
	 * colonna DT_CONCLUSIONE.
	 * @generated
	 */
	public void setDtConclusione(java.sql.Timestamp val) {

		if (val != null) {
			dtConclusione = new java.sql.Timestamp(val.getTime());
		} else {
			dtConclusione = null;
		}

	}

	/**
	 * Legge il valore della proprieta' dtConclusione associata alla
	 * @generated
	 */
	public java.sql.Timestamp getDtConclusione() {

		if (dtConclusione != null) {
			return new java.sql.Timestamp(dtConclusione.getTime());
		} else {
			return null;
		}

	}

	/**
	 * store della proprieta' associata alla colonna FLG_ISP_PAGAMENTO
	 * @generated
	 */
	protected java.math.BigDecimal flgIspPagamento;

	/**
	 * Imposta il valore della proprieta' flgIspPagamento associata alla
	 * colonna FLG_ISP_PAGAMENTO.
	 * @generated
	 */
	public void setFlgIspPagamento(java.math.BigDecimal val) {

		flgIspPagamento = val;

	}

	/**
	 * Legge il valore della proprieta' flgIspPagamento associata alla
	 * @generated
	 */
	public java.math.BigDecimal getFlgIspPagamento() {

		return flgIspPagamento;

	}

	/**
	 * store della proprieta' associata alla colonna ISTAT_COMUNE_COMPETENZA
	 * @generated
	 */
	protected String istatComuneCompetenza;

	/**
	 * Imposta il valore della proprieta' istatComuneCompetenza associata alla
	 * colonna ISTAT_COMUNE_COMPETENZA.
	 * @generated
	 */
	public void setIstatComuneCompetenza(String val) {

		istatComuneCompetenza = val;

	}

	/**
	 * Legge il valore della proprieta' istatComuneCompetenza associata alla
	 * @generated
	 */
	public String getIstatComuneCompetenza() {

		return istatComuneCompetenza;

	}

	/**
	 * Crea una istanza di SigitTIspezione2018Pk a partire dal valore dei campi chiave del DTO
	 * 
	 * @return SigitTIspezione2018Pk
	 * @generated
	 */
	public SigitTIspezione2018Pk createPk() {
		return new SigitTIspezione2018Pk(idIspezione2018);
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
