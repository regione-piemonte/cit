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
 * Interfaccia pubblica del DAO sigitTRappTipo3.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface SigitTRappTipo3Dao {

	/**
	 * Metodo di inserimento del DAO sigitTRappTipo3. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitTRappTipo3Pk
	 * @generated
	 */

	public SigitTRappTipo3Pk insert(SigitTRappTipo3Dto dto)

	;

	/** 
	 * Updates a single row in the SIGIT_T_RAPP_TIPO3 table.
	 * @generated
	 */
	public void update(SigitTRappTipo3Dto dto) throws SigitTRappTipo3DaoException;

	/** 
	 * Deletes a single row in the SIGIT_T_RAPP_TIPO3 table.
	 * @generated
	 */

	public void delete(SigitTRappTipo3Pk pk) throws SigitTRappTipo3DaoException;

	/** 
	 * Restituisce tutte le righe della tabella SIGIT_T_RAPP_TIPO3.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTRappTipo3Dto> findAll() throws SigitTRappTipo3DaoException;

	/** 
	 * Returns all rows from the SIGIT_T_RAPP_TIPO3 table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public SigitTRappTipo3Dto findByPrimaryKey(SigitTRappTipo3Pk pk) throws SigitTRappTipo3DaoException;

}
