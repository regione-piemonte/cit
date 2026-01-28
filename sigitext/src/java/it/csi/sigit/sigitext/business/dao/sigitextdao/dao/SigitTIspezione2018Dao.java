package it.csi.sigit.sigitext.business.dao.sigitextdao.dao;

import java.util.List;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTIspezione2018Dto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTIspezione2018Pk;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.DaoException;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitTIspezione2018DaoException;
import it.csi.sigit.sigitext.dto.sigitext.DatiIspezione;

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
	public List<SigitTIspezione2018Dto> findByExample(SigitTIspezione2018Dto input)
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

	public List<SigitTIspezione2018Dto> getElencoIspezioni(
			DatiIspezione input)
			throws DaoException;
}
