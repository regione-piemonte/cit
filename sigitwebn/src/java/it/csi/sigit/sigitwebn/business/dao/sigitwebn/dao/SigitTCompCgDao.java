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
 * Interfaccia pubblica del DAO sigitTCompCg.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface SigitTCompCgDao {

	/**
	 * Metodo di inserimento del DAO sigitTCompCg. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitTCompCgPk
	 * @generated
	 */

	public SigitTCompCgPk insert(SigitTCompCgDto dto)

	;

	/** 
	 * Updates a single row in the SIGIT_T_COMP_CG table.
	 * @generated
	 */
	public void update(SigitTCompCgDto dto) throws SigitTCompCgDaoException;

	/** 
	 * Deletes a single row in the SIGIT_T_COMP_CG table.
	 * @generated
	 */

	public void delete(SigitTCompCgPk pk) throws SigitTCompCgDaoException;

	/** 
	 * Custom deleter in the SIGIT_T_COMP_CG table.
	 * @generated
	 */
	public void customDeleterByCodImpianto(java.lang.Integer filter) throws SigitTCompCgDaoException;

	/** 
	 * Custom deleter in the SIGIT_T_COMP_CG table.
	 * @generated
	 */
	public void customDeleterByFilter(it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.CompFilter filter)
			throws SigitTCompCgDaoException;

	/** 
	 * Returns all rows from the SIGIT_T_COMP_CG table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public SigitTCompCgDto findByPrimaryKey(SigitTCompCgPk pk) throws SigitTCompCgDaoException;

	/** 
	 * Implementazione del finder componentiCancellate
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTCompCgDto> findComponentiCancellate(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.CompFilter input) throws SigitTCompCgDaoException;

	/** 
	 * Implementazione del finder byExample
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTCompCgDto> findByExample(it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.CompFilter input)
			throws SigitTCompCgDaoException;

}
