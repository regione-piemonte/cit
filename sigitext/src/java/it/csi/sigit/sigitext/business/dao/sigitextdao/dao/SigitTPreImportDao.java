package it.csi.sigit.sigitext.business.dao.sigitextdao.dao;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTPreImportDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTPreImportPk;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitTPreImportDaoException;

/**
 * Interfaccia pubblica del DAO sigitTPreImport.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface SigitTPreImportDao {

	/**
	 * Metodo di inserimento del DAO sigitTPreImport. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitTPreImportPk
	 * @generated
	 */

	public SigitTPreImportPk insert(SigitTPreImportDto dto)

	;

	/** 
	 * Updates a single row in the SIGIT_T_PRE_IMPORT table.
	 * @generated
	 */
	public void update(SigitTPreImportDto dto) throws SigitTPreImportDaoException;

}
