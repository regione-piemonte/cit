package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Data transfer object relativo al DAO SigitTAccertamentoDao.
 * @generated
 */
public class SigitTAccertamentoDto extends SigitTAccertamentoPk {

	private static final long serialVersionUID = 1L;

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
	 * store della proprieta' associata alla colonna FK_STATO_ACCERTAMENTO
	 * @generated
	 */
	protected Integer fkStatoAccertamento;

	/**
	 * Imposta il valore della proprieta' fkStatoAccertamento associata alla
	 * colonna FK_STATO_ACCERTAMENTO.
	 * @generated
	 */
	public void setFkStatoAccertamento(Integer val) {

		fkStatoAccertamento = val;

	}

	/**
	 * Legge il valore della proprieta' fkStatoAccertamento associata alla
	 * @generated
	 */
	public Integer getFkStatoAccertamento() {

		return fkStatoAccertamento;

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
	 * store della proprieta' associata alla colonna CF_UTENTE_ASSEGN
	 * @generated
	 */
	protected String cfUtenteAssegn;

	/**
	 * Imposta il valore della proprieta' cfUtenteAssegn associata alla
	 * colonna CF_UTENTE_ASSEGN.
	 * @generated
	 */
	public void setCfUtenteAssegn(String val) {

		cfUtenteAssegn = val;

	}

	/**
	 * Legge il valore della proprieta' cfUtenteAssegn associata alla
	 * @generated
	 */
	public String getCfUtenteAssegn() {

		return cfUtenteAssegn;

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
	 * store della proprieta' associata alla colonna DT_CONCLUSIONE
	 * @generated
	 */
	protected java.sql.Date dtConclusione;

	/**
	 * Imposta il valore della proprieta' dtConclusione associata alla
	 * colonna DT_CONCLUSIONE.
	 * @generated
	 */
	public void setDtConclusione(java.sql.Date val) {

		if (val != null) {
			dtConclusione = new java.sql.Date(val.getTime());
		} else {
			dtConclusione = null;
		}

	}

	/**
	 * Legge il valore della proprieta' dtConclusione associata alla
	 * @generated
	 */
	public java.sql.Date getDtConclusione() {

		if (dtConclusione != null) {
			return new java.sql.Date(dtConclusione.getTime());
		} else {
			return null;
		}

	}

	/**
	 * store della proprieta' associata alla colonna FK_TIPO_CONCLUSIONE
	 * @generated
	 */
	protected Integer fkTipoConclusione;

	/**
	 * Imposta il valore della proprieta' fkTipoConclusione associata alla
	 * colonna FK_TIPO_CONCLUSIONE.
	 * @generated
	 */
	public void setFkTipoConclusione(Integer val) {

		fkTipoConclusione = val;

	}

	/**
	 * Legge il valore della proprieta' fkTipoConclusione associata alla
	 * @generated
	 */
	public Integer getFkTipoConclusione() {

		return fkTipoConclusione;

	}

	/**
	 * store della proprieta' associata alla colonna FK_TIPO_ANOMALIA
	 * @generated
	 */
	protected Integer fkTipoAnomalia;

	/**
	 * Imposta il valore della proprieta' fkTipoAnomalia associata alla
	 * colonna FK_TIPO_ANOMALIA.
	 * @generated
	 */
	public void setFkTipoAnomalia(Integer val) {

		fkTipoAnomalia = val;

	}

	/**
	 * Legge il valore della proprieta' fkTipoAnomalia associata alla
	 * @generated
	 */
	public Integer getFkTipoAnomalia() {

		return fkTipoAnomalia;

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
	 * store della proprieta' associata alla colonna SIGLA_PROV_COMPETENZA
	 * @generated
	 */
	protected String siglaProvCompetenza;

	/**
	 * Imposta il valore della proprieta' siglaProvCompetenza associata alla
	 * colonna SIGLA_PROV_COMPETENZA.
	 * @generated
	 */
	public void setSiglaProvCompetenza(String val) {

		siglaProvCompetenza = val;

	}

	/**
	 * Legge il valore della proprieta' siglaProvCompetenza associata alla
	 * @generated
	 */
	public String getSiglaProvCompetenza() {

		return siglaProvCompetenza;

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
	 * store della proprieta' associata alla colonna DENOM_UTENTE_ASSEGN
	 * @generated
	 */
	protected String denomUtenteAssegn;

	/**
	 * Imposta il valore della proprieta' denomUtenteAssegn associata alla
	 * colonna DENOM_UTENTE_ASSEGN.
	 * @generated
	 */
	public void setDenomUtenteAssegn(String val) {

		denomUtenteAssegn = val;

	}

	/**
	 * Legge il valore della proprieta' denomUtenteAssegn associata alla
	 * @generated
	 */
	public String getDenomUtenteAssegn() {

		return denomUtenteAssegn;

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
	 * Crea una istanza di SigitTAccertamentoPk a partire dal valore dei campi chiave del DTO
	 * 
	 * @return SigitTAccertamentoPk
	 * @generated
	 */
	public SigitTAccertamentoPk createPk() {
		return new SigitTAccertamentoPk(idAccertamento);
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
