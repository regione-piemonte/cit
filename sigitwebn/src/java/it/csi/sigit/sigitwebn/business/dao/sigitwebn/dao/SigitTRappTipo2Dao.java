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
 * Interfaccia pubblica del DAO sigitTRappTipo2.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface SigitTRappTipo2Dao {

	/**
	 * Metodo di inserimento del DAO sigitTRappTipo2. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitTRappTipo2Pk
	 * @generated
	 */

	public SigitTRappTipo2Pk insert(SigitTRappTipo2Dto dto)

	;

	/** 
	 * Updates a single row in the SIGIT_T_RAPP_TIPO2 table.
	 * @generated
	 */
	public void update(SigitTRappTipo2Dto dto) throws SigitTRappTipo2DaoException;

	/** 
	 * Deletes a single row in the SIGIT_T_RAPP_TIPO2 table.
	 * @generated
	 */

	public void delete(SigitTRappTipo2Pk pk) throws SigitTRappTipo2DaoException;

	/** 
	 * Restituisce tutte le righe della tabella SIGIT_T_RAPP_TIPO2.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTRappTipo2Dto> findAll() throws SigitTRappTipo2DaoException;

	/** 
	 * Returns all rows from the SIGIT_T_RAPP_TIPO2 table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public SigitTRappTipo2Dto findByPrimaryKey(SigitTRappTipo2Pk pk) throws SigitTRappTipo2DaoException;

}
