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
 * Interfaccia pubblica del DAO sigitTRappTipo4.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface SigitTRappTipo4Dao {

	/**
	 * Metodo di inserimento del DAO sigitTRappTipo4. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitTRappTipo4Pk
	 * @generated
	 */

	public SigitTRappTipo4Pk insert(SigitTRappTipo4Dto dto)

	;

	/** 
	 * Updates a single row in the SIGIT_T_RAPP_TIPO4 table.
	 * @generated
	 */
	public void update(SigitTRappTipo4Dto dto) throws SigitTRappTipo4DaoException;

	/** 
	 * Deletes a single row in the SIGIT_T_RAPP_TIPO4 table.
	 * @generated
	 */

	public void delete(SigitTRappTipo4Pk pk) throws SigitTRappTipo4DaoException;

	/** 
	 * Restituisce tutte le righe della tabella SIGIT_T_RAPP_TIPO4.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTRappTipo4Dto> findAll() throws SigitTRappTipo4DaoException;

	/** 
	 * Returns all rows from the SIGIT_T_RAPP_TIPO4 table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public SigitTRappTipo4Dto findByPrimaryKey(SigitTRappTipo4Pk pk) throws SigitTRappTipo4DaoException;

}
