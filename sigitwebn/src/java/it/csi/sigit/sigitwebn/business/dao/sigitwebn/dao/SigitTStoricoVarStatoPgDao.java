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
 * Interfaccia pubblica del DAO sigitTStoricoVarStatoPg.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface SigitTStoricoVarStatoPgDao {

	/**
	 * Metodo di inserimento del DAO sigitTStoricoVarStatoPg. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitTStoricoVarStatoPgPk
	 * @generated
	 */

	public SigitTStoricoVarStatoPgPk insert(SigitTStoricoVarStatoPgDto dto)

	;

	/** 
	 * Returns all rows from the SIGIT_T_STORICO_VAR_STATO_PG table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public SigitTStoricoVarStatoPgDto findByPrimaryKey(SigitTStoricoVarStatoPgPk pk)
			throws SigitTStoricoVarStatoPgDaoException;

	/** 
	 * Implementazione del finder piuRecenteByIdPg
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTStoricoVarStatoPgDto> findPiuRecenteByIdPg(java.lang.Integer input)
			throws SigitTStoricoVarStatoPgDaoException;

}
