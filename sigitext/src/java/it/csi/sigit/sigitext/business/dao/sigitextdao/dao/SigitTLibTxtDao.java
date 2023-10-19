package it.csi.sigit.sigitext.business.dao.sigitextdao.dao;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTLibTxtDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTLibTxtPk;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitTLibTxtDaoException;

/**
 * Interfaccia pubblica del DAO sigitTLibTxt.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface SigitTLibTxtDao {

	/**
	 * Metodo di inserimento del DAO sigitTLibTxt. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitTLibTxtPk
	 * @generated
	 */

	public SigitTLibTxtPk insert(SigitTLibTxtDto dto)

	;

	/** 
	 * Updates a single row in the SIGIT_T_LIB_TXT table.
	 * @generated
	 */
	public void update(SigitTLibTxtDto dto) throws SigitTLibTxtDaoException;

	/** 
	 * Returns all rows from the SIGIT_T_LIB_TXT table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public SigitTLibTxtDto findByPrimaryKey(SigitTLibTxtPk pk) throws SigitTLibTxtDaoException;

}
