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
 * Interfaccia pubblica del DAO sigitTConsumo14_4.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface SigitTConsumo14_4Dao {

	/**
	 * Metodo di inserimento del DAO sigitTConsumo14_4. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitTConsumo14_4Pk
	 * @generated
	 */

	public SigitTConsumo14_4Pk insert(SigitTConsumo14_4Dto dto)

	;

	/** 
	 * Updates a single row in the SIGIT_T_CONSUMO_14_4 table.
	 * @generated
	 */
	public void update(SigitTConsumo14_4Dto dto) throws SigitTConsumo14_4DaoException;

	/** 
	 * Custom deleter in the SIGIT_T_CONSUMO_14_4 table.
	 * @generated
	 */
	public void customDeleterByCodImpianto(Integer filter) throws SigitTConsumo14_4DaoException;

	/** 
	 * Deletes a single row in the SIGIT_T_CONSUMO_14_4 table.
	 * @generated
	 */

	public void delete(SigitTConsumo14_4Pk pk) throws SigitTConsumo14_4DaoException;

	/** 
	 * Implementazione del finder byCodImpianto
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTConsumo14_4Dto> findByCodImpianto(Integer input) throws SigitTConsumo14_4DaoException;

}
