package it.csi.sigit.sigitext.business.dao.sigitextdao.dto;

/**
 * Data transfer object relativo al DAO SigitDStatoIspezioneDao.
 * @generated
 */
public class SigitDStatoIspezioneDto extends SigitDStatoIspezionePk {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna DES_STATO_ISPEZIONE
	 * @generated
	 */
	protected String desStatoIspezione;

	/**
	 * Imposta il valore della proprieta' desStato associata alla
	 * colonna DES_STATO_ISPEZIONE.
	 * @generated
	 */
	public void setDesStatoIspezione(String val) {

		desStatoIspezione = val;

	}

	/**
	 * Legge il valore della proprieta' desStatoIspezione associata alla
	 * @generated
	 */
	public String getDesStatoIspezione() {

		return desStatoIspezione;

	}

	/**
	 * Crea una istanza di SigitDStatoIspezionePk a partire dal valore dei campi chiave del DTO
	 * 
	 * @return SigitDStatoIspezionePk
	 * @generated
	 */
	public SigitDStatoIspezionePk createPk() {
		return new SigitDStatoIspezionePk(idStatoIspezione);
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
