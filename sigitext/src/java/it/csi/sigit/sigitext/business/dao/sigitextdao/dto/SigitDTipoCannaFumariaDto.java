package it.csi.sigit.sigitext.business.dao.sigitextdao.dto;

/**
 * Data transfer object relativo al DAO SigitDTipoCannaFumariaDao.
 * @generated
 */
public class SigitDTipoCannaFumariaDto extends SigitDTipoCannaFumariaPk {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna DESC_TIPO_CANNA_FUMARIA
	 * @generated
	 */
	protected String descTipoCannaFumaria;

	/**
	 * Imposta il valore della proprieta' descTipoCannaFumaria associata alla
	 * colonna DESC_TIPO_CANNA_FUMARIA.
	 * @generated
	 */
	public void setDescTipoCannaFumaria(String val) {

		descTipoCannaFumaria = val;

	}

	/**
	 * Legge il valore della proprieta' descTipoCannaFumaria associata alla
	 * @generated
	 */
	public String getDescTipoCannaFumaria() {

		return descTipoCannaFumaria;

	}

	/**
	 * Crea una istanza di SigitDTipoCannaFumariaPk a partire dal valore dei campi chiave del DTO
	 * 
	 * @return SigitDTipoCannaFumariaPk
	 * @generated
	 */
	public SigitDTipoCannaFumariaPk createPk() {
		return new SigitDTipoCannaFumariaPk(idTipoCannaFumaria);
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
