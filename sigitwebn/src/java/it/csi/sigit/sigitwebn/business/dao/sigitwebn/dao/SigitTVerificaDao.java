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
 * Interfaccia pubblica del DAO sigitTVerifica.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface SigitTVerificaDao {

	/**
	 * Metodo di inserimento del DAO sigitTVerifica. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitTVerificaPk
	 * @generated
	 */

	public SigitTVerificaPk insert(SigitTVerificaDto dto)

	;

	/** 
	 * Updates a single row in the SIGIT_T_VERIFICA table.
	 * @generated
	 */
	public void update(SigitTVerificaDto dto) throws SigitTVerificaDaoException;

	/** 
	 * Updates selected columns in the SIGIT_T_VERIFICA table.
	 * @generated
	 */
	public void updateColumnsSveglia(SigitTVerificaDto dto) throws SigitTVerificaDaoException;

	/** 
	 * Deletes a single row in the SIGIT_T_VERIFICA table.
	 * @generated
	 */

	public void delete(SigitTVerificaPk pk) throws SigitTVerificaDaoException;

	/** 
	 * Custom deleter in the SIGIT_T_VERIFICA table.
	 * @generated
	 */
	public void customDeleterByCodImpianto(java.lang.Integer filter) throws SigitTVerificaDaoException;

	/** 
	 * Returns all rows from the SIGIT_T_VERIFICA table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public SigitTVerificaDto findByPrimaryKey(SigitTVerificaPk pk) throws SigitTVerificaDaoException;

	/** 
	 * Implementazione del finder byExample
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTVerificaDto> findByExample(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.RicercaVerificaFilter input)
			throws SigitTVerificaDaoException;

	/** 
	 * Restituisce tutte le righe della tabella SIGIT_T_VERIFICA.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTVerificaDto> findAll() throws SigitTVerificaDaoException;

	/** 
	 * Implementazione del finder sveglieAttiveByCF
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTVerificaDto> findSveglieAttiveByCF(java.lang.String input) throws SigitTVerificaDaoException;

}
