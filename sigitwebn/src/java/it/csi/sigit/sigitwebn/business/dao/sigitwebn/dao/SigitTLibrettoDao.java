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
 * Interfaccia pubblica del DAO sigitTLibretto.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface SigitTLibrettoDao {

	/**
	 * Metodo di inserimento del DAO sigitTLibretto. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitTLibrettoPk
	 * @generated
	 */

	public SigitTLibrettoPk insert(SigitTLibrettoDto dto)

	;

	/** 
	 * Updates a single row in the SIGIT_T_LIBRETTO table.
	 * @generated
	 */
	public void update(SigitTLibrettoDto dto) throws SigitTLibrettoDaoException;

	/** 
	 * Custom updater in the SIGIT_T_LIBRETTO table.
	 * @generated
	 */
	public void customUpdaterStoricizzaByCodImpianto(SigitTLibrettoDto filter, java.lang.Object value)
			throws SigitTLibrettoDaoException;

	/** 
	 * Deletes a single row in the SIGIT_T_LIBRETTO table.
	 * @generated
	 */

	public void delete(SigitTLibrettoPk pk) throws SigitTLibrettoDaoException;

	/** 
	 * Custom deleter in the SIGIT_T_LIBRETTO table.
	 * @generated
	 */
	public void customDeleterBozzaByCodiceImpianto(java.lang.Integer filter) throws SigitTLibrettoDaoException;

	/** 
	 * Custom deleter in the SIGIT_T_LIBRETTO table.
	 * @generated
	 */
	public void customDeleterByCodImpianto(java.lang.Integer filter) throws SigitTLibrettoDaoException;

	/** 
	 * Returns all rows from the SIGIT_T_LIBRETTO table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public SigitTLibrettoDto findByPrimaryKey(SigitTLibrettoPk pk) throws SigitTLibrettoDaoException;

	/** 
	 * Implementazione del finder byCodiceImpianto
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTLibrettoDto> findByCodiceImpianto(java.lang.Integer input) throws SigitTLibrettoDaoException;

	/** 
	 * Implementazione del finder byLibrettoFilter
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTLibrettoDto> findByLibrettoFilter(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.LibrettoFilter input)
			throws SigitTLibrettoDaoException;

	/** 
	 * Implementazione del finder byCodiceImpOrderById
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTLibrettoDto> findByCodiceImpOrderById(java.lang.Integer input) throws SigitTLibrettoDaoException;

	/** 
		 * Implementazione del finder byCodiceImpNonBozza con Qdef
		 * @generated
		 */

	public List<SigitTLibrettoByCodiceImpNonBozzaDto> findByCodiceImpNonBozza(java.lang.Integer input)
			throws SigitTLibrettoDaoException;

	/** 
	 * Implementazione del finder daArchiviare
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTLibrettoDto> findDaArchiviare(java.lang.Integer input) throws SigitTLibrettoDaoException;

}
