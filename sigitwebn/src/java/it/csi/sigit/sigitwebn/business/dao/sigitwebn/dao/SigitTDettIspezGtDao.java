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
 * Interfaccia pubblica del DAO sigitTDettIspezGt.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface SigitTDettIspezGtDao {

	/**
	 * Metodo di inserimento del DAO sigitTDettIspezGt. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitTDettIspezGtPk
	 * @generated
	 */

	public SigitTDettIspezGtPk insert(SigitTDettIspezGtDto dto)

	;

	/** 
	 * Updates a single row in the SIGIT_T_DETT_ISPEZ_GT table.
	 * @generated
	 */
	public void update(SigitTDettIspezGtDto dto) throws SigitTDettIspezGtDaoException;

	/** 
	 * Custom updater in the SIGIT_T_DETT_ISPEZ_GT table.
	 * @generated
	 */
	public void customUpdaterDettDettIspezGtComune(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTDettIspezGtDto filter,
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTDettIspezGtDto value)
			throws SigitTDettIspezGtDaoException;

	/** 
	 * Custom deleter in the SIGIT_T_DETT_ISPEZ_GT table.
	 * @generated
	 */
	public void customDeleterDeleteByIdAllegato(java.lang.Integer filter) throws SigitTDettIspezGtDaoException;

	/** 
	 * Implementazione del finder byIdAllegato
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTDettIspezGtDto> findByIdAllegato(java.math.BigDecimal input) throws SigitTDettIspezGtDaoException;

	/** 
	 * Implementazione del finder byExample
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTDettIspezGtDto> findByExample(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTDettIspezGtDto input)
			throws SigitTDettIspezGtDaoException;

}
