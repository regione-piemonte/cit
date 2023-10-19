package it.csi.sigit.sigitext.business.dao.sigitextdao.dto;

public class SigitTDocAggiuntivaDto extends SigitTDocAggiuntivaPk {

	private static final long serialVersionUID = 1L;

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
	 * store della proprieta' associata alla colonna FK_TIPO_DOCAGG
	 * @generated
	 */
	protected java.math.BigDecimal fkTipoDocagg;

	/**
	 * Imposta il valore della proprieta' fkTipoDocagg associata alla
	 * colonna FK_TIPO_DOCAGG.
	 * @generated
	 */
	public void setFkTipoDocagg(java.math.BigDecimal val) {

		fkTipoDocagg = val;

	}

	/**
	 * Legge il valore della proprieta' fkTipoDocagg associata alla
	 * @generated
	 */
	public java.math.BigDecimal getFkTipoDocagg() {

		return fkTipoDocagg;

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
	 * store della proprieta' associata alla colonna DES_ALTRO_TIPODOC
	 * @generated
	 */
	protected String desAltroTipodoc;

	/**
	 * Imposta il valore della proprieta' desAltroTipodoc associata alla
	 * colonna DES_ALTRO_TIPODOC.
	 * @generated
	 */
	public void setDesAltroTipodoc(String val) {

		desAltroTipodoc = val;

	}

	/**
	 * Legge il valore della proprieta' desAltroTipodoc associata alla
	 * @generated
	 */
	public String getDesAltroTipodoc() {

		return desAltroTipodoc;

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
	 * Crea una istanza di SigitTDocAggiuntivaPk a partire dal valore dei campi chiave del DTO
	 * 
	 * @return SigitTDocAggiuntivaPk
	 * @generated
	 */
	public SigitTDocAggiuntivaPk createPk() {
		return new SigitTDocAggiuntivaPk(idDocAggiuntiva);
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
