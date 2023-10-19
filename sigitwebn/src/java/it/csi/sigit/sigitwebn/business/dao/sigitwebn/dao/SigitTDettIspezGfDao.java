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
 * Interfaccia pubblica del DAO sigitTDettIspezGf.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface SigitTDettIspezGfDao {

	/**
	 * Metodo di inserimento del DAO sigitTDettIspezGf. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitTDettIspezGfPk
	 * @generated
	 */

	public SigitTDettIspezGfPk insert(SigitTDettIspezGfDto dto)

	;

	/** 
	 * Updates a single row in the SIGIT_T_DETT_ISPEZ_GF table.
	 * @generated
	 */
	public void update(SigitTDettIspezGfDto dto) throws SigitTDettIspezGfDaoException;

	/** 
	 * Custom updater in the SIGIT_T_DETT_ISPEZ_GF table.
	 * @generated
	 */
	public void customUpdaterDettDettIspezGfComune(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTDettIspezGfDto filter,
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTDettIspezGfDto value)
			throws SigitTDettIspezGfDaoException;

	/** 
	 * Custom deleter in the SIGIT_T_DETT_ISPEZ_GF table.
	 * @generated
	 */
	public void customDeleterDeleteByIdAllegato(java.lang.Integer filter) throws SigitTDettIspezGfDaoException;

	/** 
	 * Implementazione del finder ByExample
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTDettIspezGfDto> findByExample(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTDettIspezGfDto input)
			throws SigitTDettIspezGfDaoException;

	/** 
	 * Implementazione del finder byIdAllegato
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTDettIspezGfDto> findByIdAllegato(java.math.BigDecimal input) throws SigitTDettIspezGfDaoException;

}
