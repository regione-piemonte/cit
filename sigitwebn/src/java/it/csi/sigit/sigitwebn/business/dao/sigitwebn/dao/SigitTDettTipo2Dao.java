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
 * Interfaccia pubblica del DAO sigitTDettTipo2.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface SigitTDettTipo2Dao {

	/**
	 * Metodo di inserimento del DAO sigitTDettTipo2. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitTDettTipo2Pk
	 * @generated
	 */

	public SigitTDettTipo2Pk insert(SigitTDettTipo2Dto dto)

	;

	/** 
	 * Updates a single row in the SIGIT_T_DETT_TIPO2 table.
	 * @generated
	 */
	public void update(SigitTDettTipo2Dto dto) throws SigitTDettTipo2DaoException;

	/** 
	 * Custom updater in the SIGIT_T_DETT_TIPO2 table.
	 * @generated
	 */
	public void customUpdaterAggiornaDatiComuni(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTDettTipo2Dto filter, java.lang.Object value)
			throws SigitTDettTipo2DaoException;

	/** 
	 * Custom deleter in the SIGIT_T_DETT_TIPO2 table.
	 * @generated
	 */
	public void customDeleterByIdAllegato(java.math.BigDecimal filter) throws SigitTDettTipo2DaoException;

	/** 
	 * Restituisce tutte le righe della tabella SIGIT_T_DETT_TIPO2.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTDettTipo2Dto> findAll() throws SigitTDettTipo2DaoException;

	/** 
	 * Returns all rows from the SIGIT_T_DETT_TIPO2 table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public SigitTDettTipo2Dto findByPrimaryKey(SigitTDettTipo2Pk pk) throws SigitTDettTipo2DaoException;

	/** 
	 * Implementazione del finder byAllegatoCodImpianto
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTDettTipo2Dto> findByAllegatoCodImpianto(SigitTDettTipo2Dto input)
			throws SigitTDettTipo2DaoException;

}
