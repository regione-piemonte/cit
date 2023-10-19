package it.csi.sigit.sigitext.business.dao.sigitextdao.dto;

public class SigitDFonteEnSfruttataDto extends SigitDFonteEnSfruttataPk {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna DESC_FONTE_EN_SFRUTTATA
	 *
	 * @generated
	 */
	protected String descFonteEnSfruttata;

	/**
	 * Imposta il valore della proprieta' descFonteEnSfruttata associata alla
	 * colonna DESC_FONTE_EN_SFRUTTATA.
	 *
	 * @generated
	 */
	public void setDescFonteEnSfruttata(String val) {

		descFonteEnSfruttata = val;

	}

	/**
	 * Legge il valore della proprieta' descFonteEnSfruttata associata alla
	 *
	 * @generated
	 */
	public String getDescFonteEnSfruttata() {

		return descFonteEnSfruttata;

	}

	/**
	 * Crea una istanza di SigitDFonteEnSfruttataPk a partire dal valore dei campi chiave del DTO
	 *
	 * @return SigitDFonteEnSfruttataPk
	 * @generated
	 */
	public SigitDFonteEnSfruttataPk createPk() {
		return new SigitDFonteEnSfruttataPk(idFonteEnSfruttata);
	}

	/**
	 * la semantica dell'equals del DTO e' la stessa della PK
	 * (ovvero della superclasse).
	 *
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
