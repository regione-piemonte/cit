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
 * Interfaccia pubblica del DAO sigitWrkRuoloFunz.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface SigitWrkRuoloFunzDao {

	/** 
	 * Restituisce tutte le righe della tabella SIGIT_WRK_RUOLO_FUNZ.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitWrkRuoloFunzDto> findAll() throws SigitWrkRuoloFunzDaoException;

	/** 
	 * Returns all rows from the SIGIT_WRK_RUOLO_FUNZ table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public SigitWrkRuoloFunzDto findByPrimaryKey(SigitWrkRuoloFunzPk pk) throws SigitWrkRuoloFunzDaoException;

}
