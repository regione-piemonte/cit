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
 * Interfaccia pubblica del DAO sigitTRappTipo1.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface SigitTRappTipo1Dao {

	/**
	 * Metodo di inserimento del DAO sigitTRappTipo1. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitTRappTipo1Pk
	 * @generated
	 */

	public SigitTRappTipo1Pk insert(SigitTRappTipo1Dto dto)

	;

	/** 
	 * Updates a single row in the SIGIT_T_RAPP_TIPO1 table.
	 * @generated
	 */
	public void update(SigitTRappTipo1Dto dto) throws SigitTRappTipo1DaoException;

	/** 
	 * Deletes a single row in the SIGIT_T_RAPP_TIPO1 table.
	 * @generated
	 */

	public void delete(SigitTRappTipo1Pk pk) throws SigitTRappTipo1DaoException;

	/** 
	 * Restituisce tutte le righe della tabella SIGIT_T_RAPP_TIPO1.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTRappTipo1Dto> findAll() throws SigitTRappTipo1DaoException;

	/** 
	 * Returns all rows from the SIGIT_T_RAPP_TIPO1 table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public SigitTRappTipo1Dto findByPrimaryKey(SigitTRappTipo1Pk pk) throws SigitTRappTipo1DaoException;

}
