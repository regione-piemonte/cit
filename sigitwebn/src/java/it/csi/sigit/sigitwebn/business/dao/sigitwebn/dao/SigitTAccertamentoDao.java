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
 * Interfaccia pubblica del DAO sigitTAccertamento.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface SigitTAccertamentoDao {

	/**
	 * Metodo di inserimento del DAO sigitTAccertamento. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitTAccertamentoPk
	 * @generated
	 */

	public SigitTAccertamentoPk insert(SigitTAccertamentoDto dto)

	;

	/** 
	 * Updates a single row in the SIGIT_T_ACCERTAMENTO table.
	 * @generated
	 */
	public void update(SigitTAccertamentoDto dto) throws SigitTAccertamentoDaoException;

	/** 
	 * Updates selected columns in the SIGIT_T_ACCERTAMENTO table.
	 * @generated
	 */
	public void updateColumnsSveglia(SigitTAccertamentoDto dto) throws SigitTAccertamentoDaoException;

	/** 
	 * Updates selected columns in the SIGIT_T_ACCERTAMENTO table.
	 * @generated
	 */
	public void updateColumnsModifica(SigitTAccertamentoDto dto) throws SigitTAccertamentoDaoException;

	/** 
	 * Updates selected columns in the SIGIT_T_ACCERTAMENTO table.
	 * @generated
	 */
	public void updateColumnsConcludi(SigitTAccertamentoDto dto) throws SigitTAccertamentoDaoException;

	/** 
	 * Deletes a single row in the SIGIT_T_ACCERTAMENTO table.
	 * @generated
	 */

	public void delete(SigitTAccertamentoPk pk) throws SigitTAccertamentoDaoException;

	/** 
	 * Custom deleter in the SIGIT_T_ACCERTAMENTO table.
	 * @generated
	 */
	public void customDeleterByCodImpianto(java.lang.Integer filter) throws SigitTAccertamentoDaoException;

	/** 
	 * Returns all rows from the SIGIT_T_ACCERTAMENTO table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public SigitTAccertamentoDto findByPrimaryKey(SigitTAccertamentoPk pk) throws SigitTAccertamentoDaoException;

	/** 
	 * Implementazione del finder byExample
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTAccertamentoDto> findByExample(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTAccertamentoDto input)
			throws SigitTAccertamentoDaoException;

	/** 
	 * Implementazione del finder byFilter
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTAccertamentoDto> findByFilter(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.RicercaAccertamentoFilter input)
			throws SigitTAccertamentoDaoException;

	/** 
	 * Implementazione del finder sveglieAttiveByCF
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTAccertamentoDto> findSveglieAttiveByCF(java.lang.String input)
			throws SigitTAccertamentoDaoException;

}
