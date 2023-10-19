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
 * Interfaccia pubblica del DAO sigitTCompBrRc.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface SigitTCompBrRcDao {

	/**
	 * Metodo di inserimento del DAO sigitTCompBrRc. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitTCompBrRcPk
	 * @generated
	 */

	public SigitTCompBrRcPk insert(SigitTCompBrRcDto dto)

	;

	/** 
	 * Updates a single row in the SIGIT_T_COMP_BR_RC table.
	 * @generated
	 */
	public void update(SigitTCompBrRcDto dto) throws SigitTCompBrRcDaoException;

	/** 
	 * Deletes a single row in the SIGIT_T_COMP_BR_RC table.
	 * @generated
	 */

	public void delete(SigitTCompBrRcPk pk) throws SigitTCompBrRcDaoException;

	/** 
	 * Custom deleter in the SIGIT_T_COMP_BR_RC table.
	 * @generated
	 */
	public void customDeleterByCodImpianto(Integer filter) throws SigitTCompBrRcDaoException;

	/** 
	 * Custom deleter in the SIGIT_T_COMP_BR_RC table.
	 * @generated
	 */
	public void customDeleterByFilterComp(it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.CompFilter filter)
			throws SigitTCompBrRcDaoException;

	/** 
	 * Returns all rows from the SIGIT_T_COMP_BR_RC table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public SigitTCompBrRcDto findByPrimaryKey(SigitTCompBrRcPk pk) throws SigitTCompBrRcDaoException;

	/** 
	 * Implementazione del finder byFilter
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTCompBrRcDto> findByFilter(SigitTCompBrRcDto input) throws SigitTCompBrRcDaoException;

	/** 
	 * Implementazione del finder componentiCancellate
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTCompBrRcDto> findComponentiCancellate(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.CompFilter input) throws SigitTCompBrRcDaoException;

	/** 
	 * Implementazione del finder BrRcLegateAGt
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTCompBrRcDto> findBrRcLegateAGt(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.CompFilter input) throws SigitTCompBrRcDaoException;

	/** 
	 * Implementazione del finder byTipoAndCodImpiantoOrdered
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTCompBrRcDto> findByTipoAndCodImpiantoOrdered(SigitTCompBrRcDto input)
			throws SigitTCompBrRcDaoException;

	/** 
	 * Restituisce tutte le righe della tabella SIGIT_T_COMP_BR_RC.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTCompBrRcDto> findAll() throws SigitTCompBrRcDaoException;

	/** 
		 * Implementazione del finder BrRcLegateAGtComplex con Qdef
		 * @generated
		 */

	public List<SigitTCompBrRcBrRcLegateAGtComplexDto> findBrRcLegateAGtComplex(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.CompFilter input) throws SigitTCompBrRcDaoException;

}
