package it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dao;

import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dao.*;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.dto.*;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.qbe.*;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.metadata.*;
import it.csi.sigit.sigitbatchn.business.dao.sigitbatchn.exceptions.*;
import it.csi.sigit.sigitbatchn.business.dao.util.*;
import it.csi.sigit.sigitbatchn.business.dao.qbe.*;
import java.util.*;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Interfaccia pubblica del DAO sigitWrkLogMemoTu.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface SigitWrkLogMemoTuDao {

	/**
	 * Metodo di inserimento del DAO sigitWrkLogMemoTu. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitWrkLogMemoTuPk
	 * @generated
	 */

	public SigitWrkLogMemoTuPk insert(SigitWrkLogMemoTuDto dto)

	;

	/** 
	 * Updates a single row in the SIGIT_WRK_LOG_MEMO_PTU table.
	 * @generated
	 */
	public void update(SigitWrkLogMemoTuDto dto) throws SigitWrkLogMemoTuDaoException;

	/** 
	 * Returns all rows from the SIGIT_WRK_LOG_MEMO_PTU table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public SigitWrkLogMemoTuDto findByPrimaryKey(SigitWrkLogMemoTuPk pk) throws SigitWrkLogMemoTuDaoException;

}
