package it.csi.sigit.sigitext.business.dao.sigitextdao.dto;

/**
 * Data transfer object relativo al DAO SigitTContratto2019Dao.
 * @generated
 */
public class SigitTContratto2019Dto extends SigitTContratto2019Pk {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna FK_PG_3_RESP
	 * @generated
	 */
	protected java.math.BigDecimal fkPg3Resp;

	/**
	 * Imposta il valore della proprieta' fkPg3Resp associata alla
	 * colonna FK_PG_3_RESP.
	 * @generated
	 */
	public void setFkPg3Resp(java.math.BigDecimal val) {

		fkPg3Resp = val;

	}

	/**
	 * Legge il valore della proprieta' fkPg3Resp associata alla
	 * @generated
	 */
	public java.math.BigDecimal getFkPg3Resp() {

		return fkPg3Resp;

	}

	/**
	 * store della proprieta' associata alla colonna FK_IMP_RUOLO_PFPG_RESP
	 * @generated
	 */
	protected java.math.BigDecimal fkImpRuoloPfpgResp;

	/**
	 * Imposta il valore della proprieta' fkImpRuoloPfpgResp associata alla
	 * colonna FK_IMP_RUOLO_PFPG_RESP.
	 * @generated
	 */
	public void setFkImpRuoloPfpgResp(java.math.BigDecimal val) {

		fkImpRuoloPfpgResp = val;

	}

	/**
	 * Legge il valore della proprieta' fkImpRuoloPfpgResp associata alla
	 * @generated
	 */
	public java.math.BigDecimal getFkImpRuoloPfpgResp() {

		return fkImpRuoloPfpgResp;

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
	 * store della proprieta' associata alla colonna DATA_INIZIO
	 * @generated
	 */
	protected java.sql.Date dataInizio;

	/**
	 * Imposta il valore della proprieta' dataInizio associata alla
	 * colonna DATA_INIZIO.
	 * @generated
	 */
	public void setDataInizio(java.sql.Date val) {

		if (val != null) {
			dataInizio = new java.sql.Date(val.getTime());
		} else {
			dataInizio = null;
		}

	}

	/**
	 * Legge il valore della proprieta' dataInizio associata alla
	 * @generated
	 */
	public java.sql.Date getDataInizio() {

		if (dataInizio != null) {
			return new java.sql.Date(dataInizio.getTime());
		} else {
			return null;
		}

	}

	/**
	 * store della proprieta' associata alla colonna DATA_FINE
	 * @generated
	 */
	protected java.sql.Date dataFine;

	/**
	 * Imposta il valore della proprieta' dataFine associata alla
	 * colonna DATA_FINE.
	 * @generated
	 */
	public void setDataFine(java.sql.Date val) {

		if (val != null) {
			dataFine = new java.sql.Date(val.getTime());
		} else {
			dataFine = null;
		}

	}

	/**
	 * Legge il valore della proprieta' dataFine associata alla
	 * @generated
	 */
	public java.sql.Date getDataFine() {

		if (dataFine != null) {
			return new java.sql.Date(dataFine.getTime());
		} else {
			return null;
		}

	}

	/**
	 * store della proprieta' associata alla colonna FLG_TACITO_RINNOVO
	 * @generated
	 */
	protected java.math.BigDecimal flgTacitoRinnovo;

	/**
	 * Imposta il valore della proprieta' flgTacitoRinnovo associata alla
	 * colonna FLG_TACITO_RINNOVO.
	 * @generated
	 */
	public void setFlgTacitoRinnovo(java.math.BigDecimal val) {

		flgTacitoRinnovo = val;

	}

	/**
	 * Legge il valore della proprieta' flgTacitoRinnovo associata alla
	 * @generated
	 */
	public java.math.BigDecimal getFlgTacitoRinnovo() {

		return flgTacitoRinnovo;

	}

	/**
	 * store della proprieta' associata alla colonna DATA_CARICAMENTO
	 * @generated
	 */
	protected java.sql.Timestamp dataCaricamento;

	/**
	 * Imposta il valore della proprieta' dataCaricamento associata alla
	 * colonna DATA_CARICAMENTO.
	 * @generated
	 */
	public void setDataCaricamento(java.sql.Timestamp val) {

		if (val != null) {
			dataCaricamento = new java.sql.Timestamp(val.getTime());
		} else {
			dataCaricamento = null;
		}

	}

	/**
	 * Legge il valore della proprieta' dataCaricamento associata alla
	 * @generated
	 */
	public java.sql.Timestamp getDataCaricamento() {

		if (dataCaricamento != null) {
			return new java.sql.Timestamp(dataCaricamento.getTime());
		} else {
			return null;
		}

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
	 * store della proprieta' associata alla colonna DATA_CESSAZIONE
	 * @generated
	 */
	protected java.sql.Date dataCessazione;

	/**
	 * Imposta il valore della proprieta' dataCessazione associata alla
	 * colonna DATA_CESSAZIONE.
	 * @generated
	 */
	public void setDataCessazione(java.sql.Date val) {

		if (val != null) {
			dataCessazione = new java.sql.Date(val.getTime());
		} else {
			dataCessazione = null;
		}

	}

	/**
	 * Legge il valore della proprieta' dataCessazione associata alla
	 * @generated
	 */
	public java.sql.Date getDataCessazione() {

		if (dataCessazione != null) {
			return new java.sql.Date(dataCessazione.getTime());
		} else {
			return null;
		}

	}

	/**
	 * store della proprieta' associata alla colonna DATA_INSERIMENTO_CESSAZIONE
	 * @generated
	 */
	protected java.sql.Timestamp dataInserimentoCessazione;

	/**
	 * Imposta il valore della proprieta' dataInserimentoCessazione associata alla
	 * colonna DATA_INSERIMENTO_CESSAZIONE.
	 * @generated
	 */
	public void setDataInserimentoCessazione(java.sql.Timestamp val) {

		if (val != null) {
			dataInserimentoCessazione = new java.sql.Timestamp(val.getTime());
		} else {
			dataInserimentoCessazione = null;
		}

	}

	/**
	 * Legge il valore della proprieta' dataInserimentoCessazione associata alla
	 * @generated
	 */
	public java.sql.Timestamp getDataInserimentoCessazione() {

		if (dataInserimentoCessazione != null) {
			return new java.sql.Timestamp(dataInserimentoCessazione.getTime());
		} else {
			return null;
		}

	}

	/**
	 * store della proprieta' associata alla colonna MOTIVO_CESSAZIONE
	 * @generated
	 */
	protected String motivoCessazione;

	/**
	 * Imposta il valore della proprieta' motivoCessazione associata alla
	 * colonna MOTIVO_CESSAZIONE.
	 * @generated
	 */
	public void setMotivoCessazione(String val) {

		motivoCessazione = val;

	}

	/**
	 * Legge il valore della proprieta' motivoCessazione associata alla
	 * @generated
	 */
	public String getMotivoCessazione() {

		return motivoCessazione;

	}

	/**
	 * store della proprieta' associata alla colonna FK_TIPO_CESSAZIONE
	 * @generated
	 */
	protected Integer fkTipoCessazione;

	/**
	 * Imposta il valore della proprieta' fkTipoCessazione associata alla
	 * colonna FK_TIPO_CESSAZIONE.
	 * @generated
	 */
	public void setFkTipoCessazione(Integer val) {

		fkTipoCessazione = val;

	}

	/**
	 * Legge il valore della proprieta' fkTipoCessazione associata alla
	 * @generated
	 */
	public Integer getFkTipoCessazione() {

		return fkTipoCessazione;

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
	 * Crea una istanza di SigitTContratto2019Pk a partire dal valore dei campi chiave del DTO
	 * 
	 * @return SigitTContratto2019Pk
	 * @generated
	 */
	public SigitTContratto2019Pk createPk() {
		return new SigitTContratto2019Pk(idContratto);
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
