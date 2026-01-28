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
 * Interfaccia pubblica del DAO sigitTCompAg.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface SigitTCompAgDao {

	/**
	 * Metodo di inserimento del DAO sigitTCompAg. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitTCompAgPk
	 * @generated
	 */

	public SigitTCompAgPk insert(SigitTCompAgDto dto)

	;

	/** 
	 * Updates a single row in the SIGIT_T_COMP_AG table.
	 * @generated
	 */
	public void update(SigitTCompAgDto dto) throws SigitTCompAgDaoException;

	/** 
	 * Deletes a single row in the SIGIT_T_COMP_AG table.
	 * @generated
	 */

	public void delete(SigitTCompAgPk pk) throws SigitTCompAgDaoException;

	/** 
	 * Custom deleter in the SIGIT_T_COMP_AG table.
	 * @generated
	 */
	public void customDeleterByCodImpianto(java.lang.Integer filter) throws SigitTCompAgDaoException;

	/** 
	 * Custom deleter in the SIGIT_T_COMP_AG table.
	 * @generated
	 */
	public void customDeleterByFilter(it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.CompFilter filter)
			throws SigitTCompAgDaoException;

	/** 
	 * Returns all rows from the SIGIT_T_COMP_AG table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public SigitTCompAgDto findByPrimaryKey(SigitTCompAgPk pk) throws SigitTCompAgDaoException;

}
