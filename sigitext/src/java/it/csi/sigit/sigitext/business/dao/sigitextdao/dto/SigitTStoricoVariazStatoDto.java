package it.csi.sigit.sigitext.business.dao.sigitextdao.dto;

/**
 * Data transfer object relativo al DAO SigitTStoricoVariazStatoDao.
 * @generated
 */
public class SigitTStoricoVariazStatoDto extends SigitTStoricoVariazStatoPk {

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
	 * store della proprieta' associata alla colonna STATO_DA
	 * @generated
	 */
	protected java.math.BigDecimal statoDa;

	/**
	 * Imposta il valore della proprieta' statoDa associata alla
	 * colonna STATO_DA.
	 * @generated
	 */
	public void setStatoDa(java.math.BigDecimal val) {

		statoDa = val;

	}

	/**
	 * Legge il valore della proprieta' statoDa associata alla
	 * @generated
	 */
	public java.math.BigDecimal getStatoDa() {

		return statoDa;

	}

	/**
	 * store della proprieta' associata alla colonna STATO_A
	 * @generated
	 */
	protected java.math.BigDecimal statoA;

	/**
	 * Imposta il valore della proprieta' statoA associata alla
	 * colonna STATO_A.
	 * @generated
	 */
	public void setStatoA(java.math.BigDecimal val) {

		statoA = val;

	}

	/**
	 * Legge il valore della proprieta' statoA associata alla
	 * @generated
	 */
	public java.math.BigDecimal getStatoA() {

		return statoA;

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
	 * Crea una istanza di SigitTStoricoVariazStatoPk a partire dal valore dei campi chiave del DTO
	 * 
	 * @return SigitTStoricoVariazStatoPk
	 * @generated
	 */
	public SigitTStoricoVariazStatoPk createPk() {
		return new SigitTStoricoVariazStatoPk(codiceImpianto, dtEvento);
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
