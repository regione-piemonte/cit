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
 * Interfaccia pubblica del DAO sigitTCompCs.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface SigitTCompCsDao {

	/**
	 * Metodo di inserimento del DAO sigitTCompCs. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitTCompCsPk
	 * @generated
	 */

	public SigitTCompCsPk insert(SigitTCompCsDto dto)

	;

	/** 
	 * Updates a single row in the SIGIT_T_COMP_CS table.
	 * @generated
	 */
	public void update(SigitTCompCsDto dto) throws SigitTCompCsDaoException;

	/** 
	 * Deletes a single row in the SIGIT_T_COMP_CS table.
	 * @generated
	 */

	public void delete(SigitTCompCsPk pk) throws SigitTCompCsDaoException;

	/** 
	 * Custom deleter in the SIGIT_T_COMP_CS table.
	 * @generated
	 */
	public void customDeleterByCodImpianto(java.lang.Integer filter) throws SigitTCompCsDaoException;

	/** 
	 * Custom deleter in the SIGIT_T_COMP_CS table.
	 * @generated
	 */
	public void customDeleterByFilter(it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.CompFilter filter)
			throws SigitTCompCsDaoException;

	/** 
	 * Returns all rows from the SIGIT_T_COMP_CS table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public SigitTCompCsDto findByPrimaryKey(SigitTCompCsPk pk) throws SigitTCompCsDaoException;

}
