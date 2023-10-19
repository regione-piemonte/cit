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
 * Interfaccia pubblica del DAO sigitTConsumoTipo1B.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface SigitTConsumoTipo1BDao {

	/**
	 * Metodo di inserimento del DAO sigitTConsumoTipo1B. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitTConsumoTipo1BPk
	 * @generated
	 */

	public SigitTConsumoTipo1BPk insert(SigitTConsumoTipo1BDto dto)

	;

	/** 
	 * Updates a single row in the SIGIT_T_CONSUMO_TIPO1B table.
	 * @generated
	 */
	public void update(SigitTConsumoTipo1BDto dto) throws SigitTConsumoTipo1BDaoException;

	/** 
	 * Deletes a single row in the SIGIT_T_CONSUMO_TIPO1B table.
	 * @generated
	 */

	public void delete(SigitTConsumoTipo1BPk pk) throws SigitTConsumoTipo1BDaoException;

	/** 
	 * Custom deleter in the SIGIT_T_CONSUMO_TIPO1B table.
	 * @generated
	 */
	public void customDeleterDeleteByIdAllegato(java.math.BigDecimal filter) throws SigitTConsumoTipo1BDaoException;

	/** 
	 * Returns all rows from the SIGIT_T_CONSUMO_TIPO1B table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public SigitTConsumoTipo1BDto findByPrimaryKey(SigitTConsumoTipo1BPk pk) throws SigitTConsumoTipo1BDaoException;

	/** 
	 * Implementazione del finder byFilter
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTConsumoTipo1BDto> findByFilter(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTConsumoTipo1BDto input)
			throws SigitTConsumoTipo1BDaoException;

}
