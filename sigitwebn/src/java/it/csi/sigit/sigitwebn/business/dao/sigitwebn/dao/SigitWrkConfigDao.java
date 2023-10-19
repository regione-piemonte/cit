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
 * Interfaccia pubblica del DAO sigitWrkConfig.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface SigitWrkConfigDao {

	/** 
	 * Restituisce tutte le righe della tabella SIGIT_WRK_CONFIG.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitWrkConfigDto> findAll() throws SigitWrkConfigDaoException;

	/** 
	 * Returns all rows from the SIGIT_WRK_CONFIG table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public SigitWrkConfigDto findByPrimaryKey(SigitWrkConfigPk pk) throws SigitWrkConfigDaoException;

	/** 
	 * Implementazione del finder byChiaveConfig
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitWrkConfigDto> findByChiaveConfig(java.lang.String input) throws SigitWrkConfigDaoException;

}
