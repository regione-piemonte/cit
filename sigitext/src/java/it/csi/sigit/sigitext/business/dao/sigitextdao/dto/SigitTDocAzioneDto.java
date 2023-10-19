package it.csi.sigit.sigitext.business.dao.sigitextdao.dto;

/**
 * Data transfer object relativo al DAO SigitTDocAzioneDao.
 * @generated
 */
public class SigitTDocAzioneDto extends SigitTDocAzionePk {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna FK_AZIONE
	 * @generated
	 */
	protected Integer fkAzione;

	/**
	 * Imposta il valore della proprieta' fkAzione associata alla
	 * colonna FK_AZIONE.
	 * @generated
	 */
	public void setFkAzione(Integer val) {

		fkAzione = val;

	}

	/**
	 * Legge il valore della proprieta' fkAzione associata alla
	 * @generated
	 */
	public Integer getFkAzione() {

		return fkAzione;

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
	 * Crea una istanza di SigitTDocAzionePk a partire dal valore dei campi chiave del DTO
	 * 
	 * @return SigitTDocAzionePk
	 * @generated
	 */
	public SigitTDocAzionePk createPk() {
		return new SigitTDocAzionePk(idDocAzione);
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
