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
 * Interfaccia pubblica del DAO sigitWrkLogPrec.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface SigitWrkLogPrecDao {

	/**
	 * Metodo di inserimento del DAO sigitWrkLogPrec. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitWrkLogPrecPk
	 * @generated
	 */

	public SigitWrkLogPrecPk insert(SigitWrkLogPrecDto dto)

	;

	/** 
	 * Custom deleter in the SIGIT_WRK_LOG_PREC table.
	 * @generated
	 */
	public void customDeleterOld(java.lang.Integer filter) throws SigitWrkLogPrecDaoException;

	/** 
	 * Restituisce tutte le righe della tabella SIGIT_WRK_LOG_PREC.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitWrkLogPrecDto> findAll() throws SigitWrkLogPrecDaoException;

}
