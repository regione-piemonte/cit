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
 * Interfaccia pubblica del DAO sigitTIspezione2018.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface SigitTIspezione2018Dao {

	/**
	 * Metodo di inserimento del DAO sigitTIspezione2018. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return SigitTIspezione2018Pk
	 * @generated
	 */

	public SigitTIspezione2018Pk insert(SigitTIspezione2018Dto dto)

	;

	/** 
	 * Updates a single row in the SIGIT_T_ISPEZIONE_2018 table.
	 * @generated
	 */
	public void update(SigitTIspezione2018Dto dto) throws SigitTIspezione2018DaoException;

	/** 
	 * Updates selected columns in the SIGIT_T_ISPEZIONE_2018 table.
	 * @generated
	 */
	public void updateColumnsModificaIspezioneDaDettaglio(SigitTIspezione2018Dto dto)
			throws SigitTIspezione2018DaoException;

	/** 
	 * Updates selected columns in the SIGIT_T_ISPEZIONE_2018 table.
	 * @generated
	 */
	public void updateColumnsImpostaSveglia(SigitTIspezione2018Dto dto) throws SigitTIspezione2018DaoException;

	/** 
	 * Deletes a single row in the SIGIT_T_ISPEZIONE_2018 table.
	 * @generated
	 */

	public void delete(SigitTIspezione2018Pk pk) throws SigitTIspezione2018DaoException;

	/** 
	 * Returns all rows from the SIGIT_T_ISPEZIONE_2018 table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public SigitTIspezione2018Dto findByPrimaryKey(SigitTIspezione2018Pk pk) throws SigitTIspezione2018DaoException;

	/** 
	 * Restituisce tutte le righe della tabella SIGIT_T_ISPEZIONE_2018.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTIspezione2018Dto> findAll() throws SigitTIspezione2018DaoException;

	/** 
	 * Implementazione del finder byExample
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTIspezione2018Dto> findByExample(
			it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTIspezione2018Dto input)
			throws SigitTIspezione2018DaoException;

	/** 
	 * Implementazione del finder validaByIdAccertamento
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTIspezione2018Dto> findValidaByIdAccertamento(java.lang.Integer input)
			throws SigitTIspezione2018DaoException;

	/** 
	 * Implementazione del finder sveglieAttiveByCF
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTIspezione2018Dto> findSveglieAttiveByCF(java.lang.String input)
			throws SigitTIspezione2018DaoException;

	/** 
	 * Implementazione del finder bozzaByIdAccertamento
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitTIspezione2018Dto> findBozzaByIdAccertamento(java.lang.Integer input)
			throws SigitTIspezione2018DaoException;

}
