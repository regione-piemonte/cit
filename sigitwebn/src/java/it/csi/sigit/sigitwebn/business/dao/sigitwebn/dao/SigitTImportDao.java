package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.qbe.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.metadata.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.*;
import it.csi.sigit.sigitwebn.business.dao.util.*;
import it.csi.sigit.sigitwebn.business.dao.qbe.*;
import java.util.*;
import java.sql.ResultSet;
import java.sql.SQLException;

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
	 * Deletes a single row in the SIGIT_T_IMPORT table.
	 * @generated
	 */

	public void delete(SigitTImportPk pk) throws SigitTImportDaoException;

	/** 
	 * Returns all rows from the SIGIT_T_IMPORT table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public SigitTImportDto findByPrimaryKey(SigitTImportPk pk) throws SigitTImportDaoException;

	/** 
	 * Implementazione del finder byIdAllegato
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTImportDto> findByIdAllegato(java.math.BigDecimal input) throws SigitTImportDaoException;

}
