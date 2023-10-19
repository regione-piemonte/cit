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
 * Interfaccia pubblica del DAO sigitTConsumo.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface SigitTConsumoDao {

	/**
	 * Metodo di inserimento del DAO sigitTConsumo. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitTConsumoPk
	 * @generated
	 */

	public SigitTConsumoPk insert(SigitTConsumoDto dto)

	;

	/** 
	 * Updates a single row in the SIGIT_T_CONSUMO table.
	 * @generated
	 */
	public void update(SigitTConsumoDto dto) throws SigitTConsumoDaoException;

	/** 
	 * Custom deleter in the SIGIT_T_CONSUMO table.
	 * @generated
	 */
	public void customDeleterCombuByCodImpianto(Integer filter) throws SigitTConsumoDaoException;

	/** 
	 * Custom deleter in the SIGIT_T_CONSUMO table.
	 * @generated
	 */
	public void customDeleterEnergiaByCodImpianto(Integer filter) throws SigitTConsumoDaoException;

	/** 
	 * Custom deleter in the SIGIT_T_CONSUMO table.
	 * @generated
	 */
	public void customDeleterAcquaByCodImpianto(Integer filter) throws SigitTConsumoDaoException;

	/** 
	 * Custom deleter in the SIGIT_T_CONSUMO table.
	 * @generated
	 */
	public void customDeleterByCodImpianto(Integer filter) throws SigitTConsumoDaoException;

	/** 
	 * Deletes a single row in the SIGIT_T_CONSUMO table.
	 * @generated
	 */

	public void delete(SigitTConsumoPk pk) throws SigitTConsumoDaoException;

	/** 
	 * Implementazione del finder byCodImpianto
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTConsumoDto> findByCodImpianto(Integer input) throws SigitTConsumoDaoException;

	/** 
	 * Implementazione del finder ByCodImpiantoAndTipo
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTConsumoDto> findByCodImpiantoAndTipo(SigitTConsumoDto input) throws SigitTConsumoDaoException;

}
