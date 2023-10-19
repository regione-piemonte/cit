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
 * Interfaccia pubblica del DAO sigitTDettTipo1.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface SigitTDettTipo1Dao {

	/**
	 * Metodo di inserimento del DAO sigitTDettTipo1. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitTDettTipo1Pk
	 * @generated
	 */

	public SigitTDettTipo1Pk insert(SigitTDettTipo1Dto dto)

	;

	/** 
	 * Updates a single row in the SIGIT_T_DETT_TIPO1 table.
	 * @generated
	 */
	public void update(SigitTDettTipo1Dto dto) throws SigitTDettTipo1DaoException;

	/** 
	 * Custom updater in the SIGIT_T_DETT_TIPO1 table.
	 * @generated
	 */
	public void customUpdaterAggiornaDatiComuni(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTDettTipo1Dto filter, java.lang.Object value)
			throws SigitTDettTipo1DaoException;

	/** 
	 * Custom deleter in the SIGIT_T_DETT_TIPO1 table.
	 * @generated
	 */
	public void customDeleterByIdAllegato(java.math.BigDecimal filter) throws SigitTDettTipo1DaoException;

	/** 
	 * Restituisce tutte le righe della tabella SIGIT_T_DETT_TIPO1.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTDettTipo1Dto> findAll() throws SigitTDettTipo1DaoException;

	/** 
	 * Returns all rows from the SIGIT_T_DETT_TIPO1 table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public SigitTDettTipo1Dto findByPrimaryKey(SigitTDettTipo1Pk pk) throws SigitTDettTipo1DaoException;

	/** 
	 * Implementazione del finder byAllegatoCodImpianto
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTDettTipo1Dto> findByAllegatoCodImpianto(SigitTDettTipo1Dto input)
			throws SigitTDettTipo1DaoException;

}
