package it.csi.sigit.sigitext.business.dao.sigitextdao.dto;

/**
 * Data transfer object relativo al DAO UserElencoWsDao.
 * @generated
 */
public class UserElencoWsDto extends UserElencoWsPk {

	private static final long serialVersionUID = 1L;

	/**
	 * Crea una istanza di UserElencoWsPk a partire dal valore dei campi chiave del DTO
	 * 
	 * @return UserElencoWsPk
	 * @generated
	 */
	public UserElencoWsPk createPk() {
		return new UserElencoWsPk(idUserWs, idElencoWs);
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
