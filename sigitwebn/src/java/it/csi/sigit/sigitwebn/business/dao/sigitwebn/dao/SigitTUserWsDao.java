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
 * Interfaccia pubblica del DAO sigitTUserWs.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface SigitTUserWsDao {

	/** 
	 * Updates a single row in the SIGIT_T_USER_WS table.
	 * @generated
	 */
	public void update(SigitTUserWsDto dto) throws SigitTUserWsDaoException;

	/** 
	 * Restituisce tutte le righe della tabella SIGIT_T_USER_WS.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTUserWsDto> findAll() throws SigitTUserWsDaoException;

	/** 
	 * Implementazione del finder userWsCustom
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTUserWsDto> findUserWsCustom(java.lang.Integer input) throws SigitTUserWsDaoException;

	/** 
	 * Returns all rows from the SIGIT_T_USER_WS table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public SigitTUserWsDto findByPrimaryKey(SigitTUserWsPk pk) throws SigitTUserWsDaoException;

}
