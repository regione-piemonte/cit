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
 * Interfaccia pubblica del DAO sigitTComp4.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface SigitTComp4Dao {

	/**
	 * Metodo di inserimento del DAO sigitTComp4. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitTComp4Pk
	 * @generated
	 */

	public SigitTComp4Pk insert(SigitTComp4Dto dto)

	;

	/** 
	 * Updates a single row in the SIGIT_T_COMP4 table.
	 * @generated
	 */
	public void update(SigitTComp4Dto dto) throws SigitTComp4DaoException;

	/** 
	 * Deletes a single row in the SIGIT_T_COMP4 table.
	 * @generated
	 */

	public void delete(SigitTComp4Pk pk) throws SigitTComp4DaoException;

	/** 
	 * Custom deleter in the SIGIT_T_COMP4 table.
	 * @generated
	 */
	public void customDeleterByCodImpianto(java.lang.Integer filter) throws SigitTComp4DaoException;

	/** 
	 * Returns all rows from the SIGIT_T_COMP4 table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public SigitTComp4Dto findByPrimaryKey(SigitTComp4Pk pk) throws SigitTComp4DaoException;

	/** 
	 * Implementazione del finder componentiCancellate
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTComp4Dto> findComponentiCancellate(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.CompFilter input) throws SigitTComp4DaoException;

	/** 
	 * Implementazione del finder byFilter
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTComp4Dto> findByFilter(it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.CompFilter input)
			throws SigitTComp4DaoException;

	/** 
	 * Implementazione del finder nonControllateByCodImp
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTComp4Dto> findNonControllateByCodImp(java.lang.Integer input) throws SigitTComp4DaoException;

	/** 
	 * Implementazione del finder nonControllateByFilter
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTComp4Dto> findNonControllateByFilter(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.CompFilter input) throws SigitTComp4DaoException;

}
