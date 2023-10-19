package it.csi.sigit.sigitext.business.dao.sigitextdao.dao;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTAllTxtDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTAllTxtPk;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitTAllTxtDaoException;

/**
 * Interfaccia pubblica del DAO sigitTAllTxt.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface SigitTAllTxtDao {

	/**
	 * Metodo di inserimento del DAO sigitTAllTxt. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitTAllTxtPk
	 * @generated
	 */

	public SigitTAllTxtPk insert(SigitTAllTxtDto dto)

	;

	/** 
	 * Updates a single row in the SIGIT_T_ALL_TXT table.
	 * @generated
	 */
	public void update(SigitTAllTxtDto dto) throws SigitTAllTxtDaoException;

	/** 
	 * Deletes a single row in the SIGIT_T_ALL_TXT table.
	 * @generated
	 */

	public void delete(SigitTAllTxtPk pk) throws SigitTAllTxtDaoException;

	/** 
	 * Returns all rows from the SIGIT_T_ALL_TXT table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public SigitTAllTxtDto findByPrimaryKey(SigitTAllTxtPk pk) throws SigitTAllTxtDaoException;

}
