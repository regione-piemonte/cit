package it.csi.sigit.sigitext.business.dao.sigitextdao.dto;

/**
 * Data transfer object relativo al DAO SigitDTipo1BDao.
 * @generated
 */
public class SigitDTipo1BDto extends SigitDTipo1BPk {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna DESC_TIPO_1B
	 * @generated
	 */
	protected String descTipo1b;

	/**
	 * Imposta il valore della proprieta' descTipo1b associata alla
	 * colonna DESC_TIPO_1B.
	 * @generated
	 */
	public void setDescTipo1b(String val) {

		descTipo1b = val;

	}

	/**
	 * Legge il valore della proprieta' descTipo1b associata alla
	 * @generated
	 */
	public String getDescTipo1b() {

		return descTipo1b;

	}

	/**
	 * Crea una istanza di SigitDTipo1BPk a partire dal valore dei campi chiave del DTO
	 * 
	 * @return SigitDTipo1BPk
	 * @generated
	 */
	public SigitDTipo1BPk createPk() {
		return new SigitDTipo1BPk(idTipo1b);
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
