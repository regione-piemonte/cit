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
 * Interfaccia pubblica del DAO sigitDCombustibile.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface SigitDCombustibileDao {

	/** 
	 * Restituisce tutte le righe della tabella SIGIT_D_COMBUSTIBILE.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitDCombustibileDto> findAll() throws SigitDCombustibileDaoException;

	/** 
	 * Implementazione del finder byElencoId
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitDCombustibileDto> findByElencoId(java.util.ArrayList<java.lang.Integer> input)
			throws SigitDCombustibileDaoException;

	/** 
	 * Implementazione del finder byNotInElencoId
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitDCombustibileDto> findByNotInElencoId(java.util.ArrayList<java.lang.Integer> input)
			throws SigitDCombustibileDaoException;

	/** 
	 * Returns all rows from the SIGIT_D_COMBUSTIBILE table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public SigitDCombustibileDto findByPrimaryKey(SigitDCombustibilePk pk) throws SigitDCombustibileDaoException;

}
