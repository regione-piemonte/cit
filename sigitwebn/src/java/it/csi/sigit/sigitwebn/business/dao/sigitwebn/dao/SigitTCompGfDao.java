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
 * Interfaccia pubblica del DAO sigitTCompGf.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface SigitTCompGfDao {

	/**
	 * Metodo di inserimento del DAO sigitTCompGf. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitTCompGfPk
	 * @generated
	 */

	public SigitTCompGfPk insert(SigitTCompGfDto dto)

	;

	/** 
	 * Updates a single row in the SIGIT_T_COMP_GF table.
	 * @generated
	 */
	public void update(SigitTCompGfDto dto) throws SigitTCompGfDaoException;

	/** 
	 * Deletes a single row in the SIGIT_T_COMP_GF table.
	 * @generated
	 */

	public void delete(SigitTCompGfPk pk) throws SigitTCompGfDaoException;

	/** 
	 * Custom deleter in the SIGIT_T_COMP_GF table.
	 * @generated
	 */
	public void customDeleterByCodImpianto(java.lang.Integer filter) throws SigitTCompGfDaoException;

	/** 
	 * Custom deleter in the SIGIT_T_COMP_GF table.
	 * @generated
	 */
	public void customDeleterByFilter(it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.CompFilter filter)
			throws SigitTCompGfDaoException;

	/** 
	 * Returns all rows from the SIGIT_T_COMP_GF table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public SigitTCompGfDto findByPrimaryKey(SigitTCompGfPk pk) throws SigitTCompGfDaoException;

	/** 
	 * Implementazione del finder componentiCancellate
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTCompGfDto> findComponentiCancellate(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.CompFilter input) throws SigitTCompGfDaoException;

	/** 
	 * Implementazione del finder byExample
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTCompGfDto> findByExample(it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.CompFilter input)
			throws SigitTCompGfDaoException;

}
