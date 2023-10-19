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
 * Interfaccia pubblica del DAO sigitTCompGt.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface SigitTCompGtDao {

	/**
	 * Metodo di inserimento del DAO sigitTCompGt. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitTCompGtPk
	 * @generated
	 */

	public SigitTCompGtPk insert(SigitTCompGtDto dto)

	;

	/** 
	 * Updates a single row in the SIGIT_T_COMP_GT table.
	 * @generated
	 */
	public void update(SigitTCompGtDto dto) throws SigitTCompGtDaoException;

	/** 
	 * Deletes a single row in the SIGIT_T_COMP_GT table.
	 * @generated
	 */

	public void delete(SigitTCompGtPk pk) throws SigitTCompGtDaoException;

	/** 
	 * Custom deleter in the SIGIT_T_COMP_GT table.
	 * @generated
	 */
	public void customDeleterByCodImpianto(java.lang.Integer filter) throws SigitTCompGtDaoException;

	/** 
	 * Custom deleter in the SIGIT_T_COMP_GT table.
	 * @generated
	 */
	public void customDeleterByFilter(it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.CompFilter filter)
			throws SigitTCompGtDaoException;

	/** 
	 * Returns all rows from the SIGIT_T_COMP_GT table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public SigitTCompGtDto findByPrimaryKey(SigitTCompGtPk pk) throws SigitTCompGtDaoException;

	/** 
	 * Implementazione del finder componentiCancellate
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTCompGtDto> findComponentiCancellate(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.CompFilter input) throws SigitTCompGtDaoException;

	/** 
	 * Implementazione del finder findByExample
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTCompGtDto> findFindByExample(SigitTCompGtPk input) throws SigitTCompGtDaoException;

	/** 
	 * Implementazione del finder byExample
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTCompGtDto> findByExample(it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.CompFilter input)
			throws SigitTCompGtDaoException;

}
