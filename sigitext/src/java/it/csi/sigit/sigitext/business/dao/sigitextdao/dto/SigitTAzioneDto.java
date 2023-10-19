package it.csi.sigit.sigitext.business.dao.sigitextdao.dto;

/**
 * Data transfer object relativo al DAO SigitTAzioneDao.
 * @generated
 */
public class SigitTAzioneDto extends SigitTAzionePk {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna DT_AZIONE
	 * @generated
	 */
	protected java.sql.Date dtAzione;

	/**
	 * Imposta il valore della proprieta' dtAzione associata alla
	 * colonna DT_AZIONE.
	 * @generated
	 */
	public void setDtAzione(java.sql.Date val) {

		if (val != null) {
			dtAzione = new java.sql.Date(val.getTime());
		} else {
			dtAzione = null;
		}

	}

	/**
	 * Legge il valore della proprieta' dtAzione associata alla
	 * @generated
	 */
	public java.sql.Date getDtAzione() {

		if (dtAzione != null) {
			return new java.sql.Date(dtAzione.getTime());
		} else {
			return null;
		}

	}

	/**
	 * store della proprieta' associata alla colonna FK_TIPO_AZIONE
	 * @generated
	 */
	protected Integer fkTipoAzione;

	/**
	 * Imposta il valore della proprieta' fkTipoAzione associata alla
	 * colonna FK_TIPO_AZIONE.
	 * @generated
	 */
	public void setFkTipoAzione(Integer val) {

		fkTipoAzione = val;

	}

	/**
	 * Legge il valore della proprieta' fkTipoAzione associata alla
	 * @generated
	 */
	public Integer getFkTipoAzione() {

		return fkTipoAzione;

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
	 * store della proprieta' associata alla colonna FK_SANZIONE
	 * @generated
	 */
	protected Integer fkSanzione;

	/**
	 * Imposta il valore della proprieta' fkSanzione associata alla
	 * colonna FK_SANZIONE.
	 * @generated
	 */
	public void setFkSanzione(Integer val) {

		fkSanzione = val;

	}

	/**
	 * Legge il valore della proprieta' fkSanzione associata alla
	 * @generated
	 */
	public Integer getFkSanzione() {

		return fkSanzione;

	}

	/**
	 * store della proprieta' associata alla colonna DESCRIZIONE_AZIONE
	 * @generated
	 */
	protected String descrizioneAzione;

	/**
	 * Imposta il valore della proprieta' descrizioneAzione associata alla
	 * colonna DESCRIZIONE_AZIONE.
	 * @generated
	 */
	public void setDescrizioneAzione(String val) {

		descrizioneAzione = val;

	}

	/**
	 * Legge il valore della proprieta' descrizioneAzione associata alla
	 * @generated
	 */
	public String getDescrizioneAzione() {

		return descrizioneAzione;

	}

	/**
	 * store della proprieta' associata alla colonna CF_UTENTE_AZIONE
	 * @generated
	 */
	protected String cfUtenteAzione;

	/**
	 * Imposta il valore della proprieta' cfUtenteAzione associata alla
	 * colonna CF_UTENTE_AZIONE.
	 * @generated
	 */
	public void setCfUtenteAzione(String val) {

		cfUtenteAzione = val;

	}

	/**
	 * Legge il valore della proprieta' cfUtenteAzione associata alla
	 * @generated
	 */
	public String getCfUtenteAzione() {

		return cfUtenteAzione;

	}

	/**
	 * store della proprieta' associata alla colonna DENOM_UTENTE_AZIONE
	 * @generated
	 */
	protected String denomUtenteAzione;

	/**
	 * Imposta il valore della proprieta' denomUtenteAzione associata alla
	 * colonna DENOM_UTENTE_AZIONE.
	 * @generated
	 */
	public void setDenomUtenteAzione(String val) {

		denomUtenteAzione = val;

	}

	/**
	 * Legge il valore della proprieta' denomUtenteAzione associata alla
	 * @generated
	 */
	public String getDenomUtenteAzione() {

		return denomUtenteAzione;

	}

	/**
	 * Crea una istanza di SigitTAzionePk a partire dal valore dei campi chiave del DTO
	 * 
	 * @return SigitTAzionePk
	 * @generated
	 */
	public SigitTAzionePk createPk() {
		return new SigitTAzionePk(idAzione);
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
