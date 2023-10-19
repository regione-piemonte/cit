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
 * Interfaccia pubblica del DAO sigitWrkLog.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface SigitWrkLogDao {

	/**
	 * Metodo di inserimento del DAO sigitWrkLog. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitWrkLogPk
	 * @generated
	 */

	public SigitWrkLogPk insert(SigitWrkLogDto dto)

	;

	/** 
	 * Deletes a single row in the SIGIT_WRK_LOG table.
	 * @generated
	 */

	public void delete(SigitWrkLogPk pk) throws SigitWrkLogDaoException;

	/** 
	 * Implementazione del finder daArchiviare
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitWrkLogDto> findDaArchiviare(java.lang.Integer input) throws SigitWrkLogDaoException;

}
