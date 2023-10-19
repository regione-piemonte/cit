package it.csi.sigit.sigitext.business.dao.sigitextdao.dto;

/**
 * Data transfer object relativo al DAO SigitRPgPgNominaDao.
 * @generated
 */
public class SigitRPgPgNominaDto extends SigitRPgPgNominaPk {

	private static final long serialVersionUID = 1L;

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
	 * store della proprieta' associata alla colonna DATA_ULTIMA_MODIFICA
	 * @generated
	 */
	protected java.sql.Date dataUltimaModifica;

	/**
	 * Imposta il valore della proprieta' dataUltimaModifica associata alla
	 * colonna DATA_ULTIMA_MODIFICA.
	 * @generated
	 */
	public void setDataUltimaModifica(java.sql.Date val) {

		if (val != null) {
			dataUltimaModifica = new java.sql.Date(val.getTime());
		} else {
			dataUltimaModifica = null;
		}

	}

	/**
	 * Legge il valore della proprieta' dataUltimaModifica associata alla
	 * @generated
	 */
	public java.sql.Date getDataUltimaModifica() {

		if (dataUltimaModifica != null) {
			return new java.sql.Date(dataUltimaModifica.getTime());
		} else {
			return null;
		}

	}

	/**
	 * store della proprieta' associata alla colonna UTENTE_ULTIMA_MODIFICA
	 * @generated
	 */
	protected String utenteUltimaModifica;

	/**
	 * Imposta il valore della proprieta' utenteUltimaModifica associata alla
	 * colonna UTENTE_ULTIMA_MODIFICA.
	 * @generated
	 */
	public void setUtenteUltimaModifica(String val) {

		utenteUltimaModifica = val;

	}

	/**
	 * Legge il valore della proprieta' utenteUltimaModifica associata alla
	 * @generated
	 */
	public String getUtenteUltimaModifica() {

		return utenteUltimaModifica;

	}

	/**
	 * Crea una istanza di SigitRPgPgNominaPk a partire dal valore dei campi chiave del DTO
	 * 
	 * @return SigitRPgPgNominaPk
	 * @generated
	 */
	public SigitRPgPgNominaPk createPk() {
		return new SigitRPgPgNominaPk(idPersonaGiuridicaCat, idPersonaGiuridicaImpresa, dataInizio);
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
