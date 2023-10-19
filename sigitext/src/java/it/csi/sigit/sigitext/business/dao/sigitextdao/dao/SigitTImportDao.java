package it.csi.sigit.sigitext.business.dao.sigitextdao.dao;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTImportDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTImportPk;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitTImportDaoException;

import java.math.BigDecimal;
import java.util.List;

/**
 * Interfaccia pubblica del DAO sigitTImport.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface SigitTImportDao {

	/**
	 * Metodo di inserimento del DAO sigitTImport. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitTImportPk
	 * @generated
	 */

	public SigitTImportPk insert(SigitTImportDto dto)

	;

	/** 
	 * Updates a single row in the SIGIT_T_IMPORT table.
	 * @generated
	 */
	public void update(SigitTImportDto dto) throws SigitTImportDaoException;

	/** 
	 * Returns all rows from the SIGIT_T_IMPORT table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public SigitTImportDto findByPrimaryKey(SigitTImportPk pk) throws SigitTImportDaoException;

	List<SigitTImportDto> findByIdAllegato(BigDecimal idAllegato) throws SigitTImportDaoException;

	void delete(SigitTImportPk sigitTImportPk) throws SigitTImportDaoException;
}
