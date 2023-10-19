package it.csi.sigit.sigitext.business.dao.sigitextdao.dao;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.filter.CodiceReaAndFiscaleAndDenomFilter;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitVPfPgDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitVPfPgDaoException;

import java.util.List;

/**
 * Interfaccia pubblica del DAO sigitVPfPg.
 * Espone le operazioni che possono essere eseguite per la gestione
 * della tabella [Table[TRANSIENT]]
 *
 * @generated
 */
public interface SigitVPfPgDao {

	/**
	 * Restituisce tutte le righe della tabella VISTA_PF_PG.
	 *
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitVPfPgDto> findAll() throws SigitVPfPgDaoException;

	/**
	 * Implementazione del finder byCodiceFiscale
	 *
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitVPfPgDto> findByCodiceFiscale(CodiceReaAndFiscaleAndDenomFilter input) throws SigitVPfPgDaoException;

	/**
	 * Implementazione del finder byDenominazione
	 *
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitVPfPgDto> findByDenominazione(CodiceReaAndFiscaleAndDenomFilter input) throws SigitVPfPgDaoException;

	/**
	 * Implementazione del finder byCodiceRea
	 *
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitVPfPgDto> findByCodiceRea(CodiceReaAndFiscaleAndDenomFilter input) throws SigitVPfPgDaoException;

	/**
	 * Implementazione del finder byCodiceReaAndFiscale
	 *
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitVPfPgDto> findByCodiceReaAndFiscale(CodiceReaAndFiscaleAndDenomFilter input) throws SigitVPfPgDaoException;

	/**
	 * Implementazione del finder byFilter
	 *
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<SigitVPfPgDto> findByFilter(CodiceReaAndFiscaleAndDenomFilter input) throws SigitVPfPgDaoException;

}
