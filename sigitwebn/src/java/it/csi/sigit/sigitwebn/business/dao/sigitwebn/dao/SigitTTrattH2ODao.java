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
 * Interfaccia pubblica del DAO sigitTTrattH2O.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface SigitTTrattH2ODao {

	/**
	 * Metodo di inserimento del DAO sigitTTrattH2O. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitTTrattH2OPk
	 * @generated
	 */

	public SigitTTrattH2OPk insert(SigitTTrattH2ODto dto)

	;

	/** 
	 * Updates a single row in the SIGIT_T_TRATT_H2O table.
	 * @generated
	 */
	public void update(SigitTTrattH2ODto dto) throws SigitTTrattH2ODaoException;

	/** 
	 * Custom deleter in the SIGIT_T_TRATT_H2O table.
	 * @generated
	 */
	public void customDeleterByCodImpianto(java.lang.Integer filter) throws SigitTTrattH2ODaoException;

	/** 
	 * Returns all rows from the SIGIT_T_TRATT_H2O table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public SigitTTrattH2ODto findByPrimaryKey(SigitTTrattH2OPk pk) throws SigitTTrattH2ODaoException;

}
