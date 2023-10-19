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
 * Interfaccia pubblica del DAO sigitTCompSc.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface SigitTCompScDao {

	/**
	 * Metodo di inserimento del DAO sigitTCompSc. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitTCompScPk
	 * @generated
	 */

	public SigitTCompScPk insert(SigitTCompScDto dto)

	;

	/** 
	 * Updates a single row in the SIGIT_T_COMP_SC table.
	 * @generated
	 */
	public void update(SigitTCompScDto dto) throws SigitTCompScDaoException;

	/** 
	 * Deletes a single row in the SIGIT_T_COMP_SC table.
	 * @generated
	 */

	public void delete(SigitTCompScPk pk) throws SigitTCompScDaoException;

	/** 
	 * Custom deleter in the SIGIT_T_COMP_SC table.
	 * @generated
	 */
	public void customDeleterByCodImpianto(java.lang.Integer filter) throws SigitTCompScDaoException;

	/** 
	 * Custom deleter in the SIGIT_T_COMP_SC table.
	 * @generated
	 */
	public void customDeleterByFilter(it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.CompFilter filter)
			throws SigitTCompScDaoException;

	/** 
	 * Returns all rows from the SIGIT_T_COMP_SC table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public SigitTCompScDto findByPrimaryKey(SigitTCompScPk pk) throws SigitTCompScDaoException;

	/** 
	 * Implementazione del finder componentiCancellate
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTCompScDto> findComponentiCancellate(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.CompFilter input) throws SigitTCompScDaoException;

	/** 
	 * Implementazione del finder byExample
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTCompScDto> findByExample(it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.CompFilter input)
			throws SigitTCompScDaoException;

}
