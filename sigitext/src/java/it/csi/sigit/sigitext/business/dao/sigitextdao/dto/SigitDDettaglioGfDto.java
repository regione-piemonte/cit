package it.csi.sigit.sigitext.business.dao.sigitextdao.dto;

/**
 * Data transfer object relativo al DAO SigitDDettaglioGfDao.
 * @generated
 */
public class SigitDDettaglioGfDto extends SigitDDettaglioGfPk {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna DES_DETTAGLIO_GF
	 * @generated
	 */
	protected String desDettaglioGf;

	/**
	 * Imposta il valore della proprieta' desDettaglioGf associata alla
	 * colonna DES_DETTAGLIO_GF.
	 * @generated
	 */
	public void setDesDettaglioGf(String val) {

		desDettaglioGf = val;

	}

	/**
	 * Legge il valore della proprieta' desDettaglioGf associata alla
	 * @generated
	 */
	public String getDesDettaglioGf() {

		return desDettaglioGf;

	}

	/**
	 * Crea una istanza di SigitDDettaglioGfPk a partire dal valore dei campi chiave del DTO
	 * 
	 * @return SigitDDettaglioGfPk
	 * @generated
	 */
	public SigitDDettaglioGfPk createPk() {
		return new SigitDDettaglioGfPk(idDettaglioGf);
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
